package org.cru.dss.middle.webservices;

import java.io.StringWriter;
import java.io.UnsupportedEncodingException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.apache.log4j.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.cru.dss.middle.dao.StaffDesignationDao;
import org.cru.dss.middle.entity.DesignationEntity;
import org.cru.dss.middle.localcontent.ContentItem;
import org.cru.dss.middle.localcontent.LocalContentCacheService;
import org.cru.dss.middle.localcontent.WebImage;
import org.cru.dss.middle.util.ContentId;
import org.cru.dss.middle.util.ContentIdType;
import org.cru.dss.middle.util.ContentPieces;
import org.cru.dss.middle.util.DssContentUtil;
import org.cru.dss.middle.util.FullHtmlPageClient;

import com.stellent.dev.getfile.GetFileByNameResult;
import com.stellent.dev.getfile.GetFileSoap;
import com.stellent.dev.getfile.IdcFile;

@Path("/") @Stateless
public class GivingWebpageContentResources
{
	@Inject GetFileSoap getFileClient;
	@Inject FullHtmlPageClient pageClient;
	@Inject StaffDesignationDao designationDao;
	@Inject LocalContentCacheService localIndexBuilder;
	@Inject EntityManager em;

	Logger log = Logger.getLogger(GivingWebpageContentResources.class);

	@GET
	@Path("updateStaff")
	@Produces("text/plain")
	public String triggerUpdateStaffJob() throws Exception
	{
		log.info("Starting staff update job");

		for(DesignationEntity designation : designationDao.fetchAllActiveCruStaff())
		{
			GetFileByNameResult file = getFileClient.getFileByName(new ContentId(designation.getNumber(), ContentIdType.STAFF).toString(), "latest", null, null);
			if(file != null && file.getFileInfo().size() > 0)
			{
				saveAndIndexPageContent(designation, file);
				final ContentPieces parsedStellentFile = new DssContentUtil().parseStellentFile(file);
				log.info("Detail image: " + parsedStellentFile.getPrimaryDetailImage());
				saveAndIndexPrimaryAndCoverImages(parsedStellentFile);
			}
		}

		return "".toString();
	}

	private void saveAndIndexPageContent(DesignationEntity designation, GetFileByNameResult file) throws Exception
	{
		ContentPieces parsedContentFile = new DssContentUtil().parseStellentFile(file);
		try
		{
			em.persist(createContentItemToPersist(designation.getNumber(), parsedContentFile, file));
			em.flush();
		} 
		catch(Throwable t)
		{
			log.error("Error saving content for: " + designation.getNumber());
			t.printStackTrace();
			return;
		}

		//		try
		//		{
		//			localIndexBuilder.saveContentItemToCache(createContentItemToPersist(designation.getNumber(), parsedContentFile, file));
		//		} 
		//		catch (Exception e)
		//		{
		//			e.printStackTrace();
		//		}
		//		log.info("Saved and indexed content for: " + designation.getNumber());
	}

	private void saveAndIndexPrimaryAndCoverImages(ContentPieces parsedStellentFile)
	{
		if(parsedStellentFile.getPrimaryDetailImage() != null)
		{
			log.info("fetching detail image: " + parsedStellentFile.getPrimaryDetailImage().trim());
			GetFileByNameResult detailImageFile = getFileClient.getFileByName(parsedStellentFile.getPrimaryDetailImage().trim(), 
					"latest", 
					DssContentUtil.DETAIL_PHOTO_RENDITION_NAME, 
					null);

			if(detailImageFile == null || detailImageFile.getFileInfo().size() == 0)
			{
				log.info("fetching detail image: " + parsedStellentFile.getPrimaryDetailImage().trim());
				detailImageFile = getFileClient.getFileByName(parsedStellentFile.getPrimaryDetailImage().trim(), 
						"latest", 
						null, 
						null);
			}
			
			if(detailImageFile != null && detailImageFile.getFileInfo().size() > 0)
			{	
				WebImage detailImage = new WebImage();
				detailImage.setDesignation("");
				detailImage.setUcmId(parsedStellentFile.getPrimaryDetailImage());
				detailImage.setImage(detailImageFile.getDownloadFile().getFileContent());

				try
				{
					em.persist(detailImage);
					em.flush();
				}
				catch(Throwable t)
				{
					log.error("Error saving primary detail image for: " + parsedStellentFile.getPrimaryDetailImage());
					t.printStackTrace();
				}
			}
		}
		if(parsedStellentFile.getCoverImage() != null)
		{
			log.info("fetching cover image: " + parsedStellentFile.getCoverImage());
			GetFileByNameResult coverImageFile = getFileClient.getFileByName(parsedStellentFile.getCoverImage(), 
					"latest", 
					DssContentUtil.COVER_PHOTO_RENDITION_NAME, 
					null);

			if(coverImageFile != null && coverImageFile.getFileInfo().size() > 0)
			{
				WebImage coverImage = new WebImage();
				coverImage.setDesignation("");
				coverImage.setUcmId(parsedStellentFile.getCoverImage());
				coverImage.setImage(coverImageFile.getDownloadFile().getFileContent());

				try
				{
					em.persist(coverImage);
					em.flush();
				}
				catch(Throwable t)
				{
					log.error("Error saving cover image for: " + parsedStellentFile.getCoverImage());
					t.printStackTrace();
				}
			}
		}
	}

	private ContentItem createContentItemToPersist(String designation, ContentPieces parsedFile, GetFileByNameResult rawFile) throws UnsupportedEncodingException
	{
		ContentItem item = new ContentItem();
		item.setContentBytes(parsedFile.getPageContent().getBytes());
		item.setUcmId(new ContentId(designation, ContentIdType.STAFF).toString());
		item.setTitle(parsedFile.getWebTitle());
		item.setFilename(rawFile.getDownloadFile().getFileName());
		item.setDesignation(designation);
		item.setExternalWebUrl(parsedFile.getExternalUrl());
		item.setCoverImageUcmId(parsedFile.getCoverImage());
		item.setPrimaryImageUcmId(parsedFile.getPrimaryDetailImage());
		return item;
	}

	/**
	 * Get the page HTML that will be displayed on give.cru.org for any designation.  First it will try to fetch the page
	 * itself acting as the browsing making the request on give.cru.org (which is served by UCM).  If that fails for some
	 * reason, then it will fall back to retrieving the content from the back-up database (H2) perhaps 
	 * @param designation
	 * @return
	 * @throws Exception 
	 */
	@GET
	@Path("getHtml/{designation}")
	@Produces("text/html")
	public String getHtmlForDesignation(@PathParam("designation") String designation,
										@QueryParam("forceLocal") String forceLocal) throws Exception 
	{
		try
		{	
			if("y".equalsIgnoreCase(forceLocal)) throw new RuntimeException();
			return pageClient.fetchPage(designation);
		}
		catch(Exception e)
		{
			ContentItem content = em.find(ContentItem.class, "DSS_STAFF_" + designation);

			VelocityEngine ve = new VelocityEngine();
			ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
			ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
			ve.init();

			VelocityContext context = new VelocityContext();

			context.put("designation", 				designation);
			context.put("pageText", 				new String(content.getContentBytes(),"UTF-8"));
			context.put("designationName", 			content.getTitle());
			context.put("primaryImageFilename",		content.getPrimaryImageUcmId());
			context.put("externalWebUrl",			content.getExternalWebUrl());
			
			StringWriter sw = new StringWriter();
			ve.mergeTemplate("giveTemplate.vm", "UTF-8", context, sw);

			return sw.toString();
		}	
	}

	/**
	 * Get the image specified by imageName - a UCM content ID) first by using the Stellent/UCM web service
	 * If that fails, then  fall back to retrieving the content from the back-up database (H2) perhaps.
	 * @param imageName
	 * @return
	 */
	@GET
	@Path("getImage/{imageName}")
	@Produces("image/jpeg")
	public byte[] getImage(@PathParam("imageName") String imageName)
	{
		imageName = imageName.replaceAll("\\..*", "").toUpperCase();

		GetFileByNameResult fileByNameResult = getFileClient.getFileByName(imageName, "latest", null, null);

		IdcFile downloadFile = fileByNameResult.getDownloadFile();

		return downloadFile.getFileContent();
	}

}
