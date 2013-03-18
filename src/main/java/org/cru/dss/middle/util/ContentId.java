package org.cru.dss.middle.util;

public class ContentId
{
	final String designationNumber;
	final ContentIdType contentType;
	
	
	public ContentId(String designationNumber, ContentIdType contentType)
	{
		this.designationNumber = designationNumber;
		this.contentType = contentType;
	}
	
	@Override
	public String toString()
	{
		return "DSS_" + contentType + "_" + designationNumber;
	}
}
