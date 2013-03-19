package org.cru.dss.middle.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.lang.StringEscapeUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.stellent.dev.getfile.GetFileByNameResult;

public class DssContentUtil
{
	
    public static final String COVER_PHOTO_RENDITION_NAME = "CruDss640x360";
    public static final String DETAIL_PHOTO_RENDITION_NAME = "CruDss288";

    
	public ContentPieces parseStellentFile(GetFileByNameResult file) throws SAXException, IOException, ParserConfigurationException
	{
		Document document = getXmlDocumentFromStellentDoc(file);
		
		NodeList nodes = document.getElementsByTagName("wcm:element");

		ContentPieces contentPieces = parseXmlDocument(nodes);		
		
		String cleansedhtml = parseAndReplaceEmbeddedImageTags(
									parseAndReplaceEmbeddedUrls(
											StringEscapeUtils.unescapeHtml(contentPieces.getPageContent())
									)
						  		);
		
		contentPieces.setPageContent(cleansedhtml);
		
		return contentPieces;
	}

	private Document getXmlDocumentFromStellentDoc(GetFileByNameResult file) throws ParserConfigurationException, SAXException, IOException
	{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		return dbf.newDocumentBuilder().parse(new ByteArrayInputStream(file.getDownloadFile().getFileContent()));
	}

	private ContentPieces parseXmlDocument(NodeList nodes)
	{
		ContentPieces contentPieces = new ContentPieces();
		
		/*initialize page content to prevent an NPE later */
		contentPieces.setPageContent("");
		
		for(int i = 0; i < nodes.getLength(); i++)
		{
			Node item = nodes.item(i);
			
			Node nameAttrib = item.getAttributes().getNamedItem("name");
			String nameAttr = null;
			if(nameAttrib !=null)
			{
				nameAttr = nameAttrib.getNodeValue();
			}
			
			NodeList subNodes = item.getChildNodes();
			for(int j = 0; j < subNodes.getLength(); j++)
			{
				Node childNode = subNodes.item(j);
				if("body".equals(nameAttr)) contentPieces.setPageContent(childNode.getNodeValue());
				else if("website".equals(nameAttr)) contentPieces.setExternalUrl(childNode.getNodeValue());
				else if("image".equals(nameAttr))
				{
					contentPieces.setPrimaryDetailImage(extractContentIdFromImageNode(childNode.getNodeValue()));
				}
				else if("wide_image".equals(nameAttr))
				{
					contentPieces.setCoverImage(extractContentIdFromImageNode(childNode.getNodeValue()));
				}
				else if("title".equals(nameAttr))
				{
					contentPieces.setWebTitle(childNode.getNodeValue());
				}
				else if("postscript".equals(nameAttr))
				{
					contentPieces.setPostscriptText(childNode.getNodeValue());
				}
				else if("signature".equals(nameAttr))
				{
					contentPieces.setSignatureImage(extractContentIdFromImageNode(childNode.getNodeValue()));
				}
			}
		}
		
		return contentPieces;
	}
	
	private String extractContentIdFromImageNode(String imageNode)
	{
		int start = imageNode.toUpperCase().indexOf("CMS");
		int end = 0;//imageNode.indexOf("'",start);
		
		//if there's no trailing 'tick', then try some common file type extensions
		if(end <= 0) end = imageNode.toUpperCase().indexOf(".JP",start);
		if(end <= 0) end = imageNode.toUpperCase().indexOf(".PNG",start);
		if(end <= 0) end = imageNode.toUpperCase().indexOf(".TIF",start);
		if(end <= 0) end = imageNode.toUpperCase().indexOf("'",start);
		
		if(start < 0 || end < 0) return "";
		
		return imageNode.substring(start,end);
	}

	private static String parseAndReplaceEmbeddedImageTags(String htmlBody)
	{
		while(htmlBody.contains("$wcmUrl('resource',"))
		{
			String contentId = htmlBody.substring(htmlBody.indexOf("'resource','",0) + 12,
												  htmlBody.indexOf("')--]")); 
			String[] parts = htmlBody.split("\\[!.*--\\]",2);
			
			
			htmlBody = parts[0] + "/give/ContentView/" + contentId + ".jpg" + parts[1];
		}
		
		return htmlBody;
	}
	
	private static String parseAndReplaceEmbeddedUrls(String htmlBody)
	{
		while(htmlBody.contains("href=\"/Give"))
		{
			String url = htmlBody.substring(htmlBody.indexOf("href=\"/Give",0) + 11,
												  htmlBody.indexOf("\"",htmlBody.indexOf("href=\"/Give",0) + 11)); 
			String[] parts = htmlBody.split("href=\"/Give/[0-9]{7}-[0-9]{4}\"",2);
			
			
			htmlBody = parts[0] + "href=\"/give/View" + url.replace("-", "_") + "\"" + parts[1];
		}
		
		return htmlBody;
	}
    
}
