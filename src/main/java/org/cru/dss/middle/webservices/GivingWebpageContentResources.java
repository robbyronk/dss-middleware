package org.cru.dss.middle.webservices;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.apache.lucene.queryParser.ParseException;
import org.cru.dss.middle.dao.StaffDesignationDao;
import org.cru.dss.middle.entity.DesignationEntity;
import org.cru.dss.middle.localcontent.ContentItem;
import org.cru.dss.middle.localcontent.LocalContentCacheService;
import org.cru.dss.middle.util.ContentId;
import org.cru.dss.middle.util.ContentIdType;
import org.cru.dss.middle.util.FullHtmlPageClient;
import org.quartz.SchedulerException;

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
	@Path("getXml/{designation}")
	@Produces("text/xml")
	public String getXmlForDesignation(@PathParam("designation") String designation) throws UnsupportedEncodingException
	{
		log.info("Fetching XML file for designation: " + designation);
				
		ContentItem content = em.find(ContentItem.class, "DSS_STAFF_" + designation);
		
		return new String(content.getContentBytes(),"UTF-8");
	}
	
	@GET
	@Path("updateStaff")
	@Produces("text/plain")
	public String triggerUpdateStaffJob() throws UnsupportedEncodingException, SchedulerException
	{
		log.info("Starting staff update job");

		for(DesignationEntity designation : designationDao.fetchAllActiveCruStaff())
		{
			GetFileByNameResult file = getFileClient.getFileByName(new ContentId(designation.getNumber(), ContentIdType.STAFF).toString(), "latest", null, null);
			if(file != null && file.getFileInfo().size() > 0)
			{
				try
				{
					em.persist(createContentItemToPersist(designation.getNumber(), file));
					em.flush();
				} 
				catch(Throwable t)
				{
					log.error("Error saving content for: " + designation.getNumber());
					t.printStackTrace();
					continue;
				}
				
				try
				{
					localIndexBuilder.saveContentItemToCache(createContentItemToPersist(designation.getNumber(), file));
				} 
				catch (Exception e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				log.info("Saved and indexed content for: " + designation.getNumber());
			}
		}

		return "".toString();
	}

	private ContentItem createContentItemToPersist(String designation,
			GetFileByNameResult file) throws UnsupportedEncodingException
	{
		ContentItem item = new ContentItem();
		item.setContentBytes(file.getDownloadFile().getFileContent());
		item.setUcmId(new ContentId(designation, ContentIdType.STAFF).toString());
		item.setTitle(null);
		item.setFilename(file.getDownloadFile().getFileName());
		item.setDesignation(designation);
		return item;
	}
	
	/**
	 * Get the page HTML that will be displayed on give.cru.org for any designation.  First it will try to fetch the page
	 * itself acting as the browsing making the request on give.cru.org (which is served by UCM).  If that fails for some
	 * reason, then it will fall back to retrieving the content from the back-up database (H2) perhaps 
	 * @param designation
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	@GET
	@Path("getHtml/{designation}")
	@Produces("text/html")
	public String getHtmlForDesignation(@PathParam("designation") String designation) throws IOException, ParseException 
	{
		try
		{
			return pageClient.fetchPage(designation);
		}
		catch(Exception e)
		{
			return "";
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
	
	public static void main(String[] args) throws IOException, ParseException
	{
		new GivingWebpageContentResources().getHtmlForDesignation("0550510");
	}
}
