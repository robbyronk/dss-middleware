package org.cru.dss.middle.util;

public class ContentPieces
{

	String pageContent;
	String primaryDetailImage;
	String coverImage;
	String externalUrl;
	String webTitle;
	
	//for fund appeals
	String postscriptText;
	String signatureImage;
	
	public ContentPieces(String pageContent, String primaryDetailImage, String coverImage, String externalUrl)
	{
		this.pageContent = pageContent;
		this.primaryDetailImage = primaryDetailImage;
		this.coverImage = coverImage;
		this.externalUrl = externalUrl;
	}
	
	public ContentPieces()
	{
		// TODO Auto-generated constructor stub
	}

	public String getPageContent()
	{
		return pageContent;
	}
	public void setPageContent(String pageContent)
	{
		this.pageContent = pageContent;
	}
	public String getPrimaryDetailImage()
	{
		return primaryDetailImage;
	}
	public void setPrimaryDetailImage(String primaryDetailImage)
	{
		this.primaryDetailImage = primaryDetailImage;
	}
	public String getCoverImage()
	{
		return coverImage;
	}
	public void setCoverImage(String coverImage)
	{
		this.coverImage = coverImage;
	}
	public String getExternalUrl()
	{
		return externalUrl;
	}
	public void setExternalUrl(String externalUrl)
	{
		this.externalUrl = externalUrl;
	}

	public String getWebTitle()
	{
		return webTitle;
	}

	public void setWebTitle(String webTitle)
	{
		this.webTitle = webTitle;
	}

	public String getPostscriptText()
	{
		return postscriptText;
	}

	public void setPostscriptText(String postscriptText)
	{
		this.postscriptText = postscriptText;
	}

	public String getSignatureImage()
	{
		return signatureImage;
	}

	public void setSignatureImage(String signatureImage)
	{
		this.signatureImage = signatureImage;
	}
	
}
