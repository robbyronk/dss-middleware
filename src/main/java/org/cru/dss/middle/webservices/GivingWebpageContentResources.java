package org.cru.dss.middle.webservices;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.log4j.Logger;
import org.apache.lucene.queryParser.ParseException;
import org.cru.dss.middle.localcontent.ContentItem;
import org.cru.dss.middle.localcontent.LocalContentCacheService;
import org.cru.dss.middle.util.ContentId;
import org.cru.dss.middle.util.ContentIdType;
import org.cru.dss.middle.util.FullHtmlPageClient;

import com.stellent.dev.getfile.GetFileByNameResult;
import com.stellent.dev.getfile.GetFileSoap;
import com.stellent.dev.getfile.IdcFile;

@Path("/")
public class GivingWebpageContentResources
{
	@Inject GetFileSoap getFileClient;
	@Inject FullHtmlPageClient pageClient;
	@Inject LocalContentCacheService localCacheService;
		
	Logger log = Logger.getLogger(GivingWebpageContentResources.class);
	
	@GET
	@Path("getXml/{designation}")
	@Produces("text/xml")
	public String getXmlForDesignation(@PathParam("designation") String designation) throws UnsupportedEncodingException
	{
		log.info("Fetching XML file for designation: " + designation);
		
		GetFileByNameResult file = getFileClient.getFileByName(new ContentId(designation, ContentIdType.STAFF).toString(), "latest", null, null);
		
		if(file.getFileInfo().size() > 0)
		{
			log.info("Found a file!");
			ContentItem item = new ContentItem();
			item.setContentBytes(file.getDownloadFile().getFileContent());
			item.setUcmId(new ContentId(designation, ContentIdType.STAFF).toString());
			
			log.info("File saved.");
			return new String(file.getDownloadFile().getFileContent(), "UTF-8");
		}
		
		return "".toString();
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
			return new String(localCacheService.retrieveContentItemFromCache(designation).getContentBytes(), "UTF-8");
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
//		pageClient = new FullHtmlPageClient();
//		localCacheService = new LocalContentCacheService("~/Scratch/middleware-content-cache/");
		new GivingWebpageContentResources().getHtmlForDesignation("0550510");
	}
}
