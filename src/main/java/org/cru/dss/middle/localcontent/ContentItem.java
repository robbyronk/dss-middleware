package org.cru.dss.middle.localcontent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "CRU_WEB_CONTENT_PAGE")
public class ContentItem implements java.io.Serializable
{

	private static final long serialVersionUID = 1L;

	@Id @Column(name = "UCM_ID")
	String ucmId;
	
	@Transient
	@Column(name = "CONTENT_TYPE")
	ContentItemType contentType;
	
	@Lob
	@Column(name = "CONTENT")
	byte[] contentBytes;
	
	@Column(name = "TITLE")
	String title;
	
	@Column(name = "FILENAME")
	String filename;
	
	@Column(name = "DESIGNATION")
	String designation;
	
	@Column(name = "EXTERNAL_WEB_URL")
	String externalWebUrl;
	
	@Column(name = "COVER_IMG_ID")
	String coverImageUcmId;
	
	@Column(name = "PRIMARY_IMG_ID")
	String primaryImageUcmId;
	
	@Transient
	@Column(name = "FILE_SIZE")
	String fileSize;
	
	public ContentItem()
	{
	}
	
	public ContentItem(String ucmId, ContentItemType contentType,
			byte[] contentBytes, String filename, String title, String designation,
			String fileSize)
	{
		this.ucmId = ucmId;
		this.contentType = contentType;
		this.contentBytes = contentBytes;
		this.filename = filename;
		this.title = title;
		this.designation = designation;
		this.fileSize = fileSize;
	}

	public String getUcmId()
	{
		return ucmId;
	}
	public void setUcmId(String ucmId)
	{
		this.ucmId = ucmId;
	}
	public ContentItemType getContentType()
	{
		return contentType;
	}
	public void setContentType(ContentItemType contentType)
	{
		this.contentType = contentType;
	}
	public byte[] getContentBytes()
	{
		return contentBytes;
	}
	public void setContentBytes(byte[] contentBytes)
	{
		this.contentBytes = contentBytes;
	}
	public String getFilename()
	{
		return filename;
	}
	public void setFilename(String filename)
	{
		this.filename = filename;
	}
	public String getDesignation()
	{
		return designation;
	}
	public void setDesignation(String designation)
	{
		this.designation = designation;
	}
	public String getFileSize()
	{
		return fileSize;
	}
	public void setFileSize(String fileSize)
	{
		this.fileSize = fileSize;
	}

	public String getTitle()
	{
		return title;
	}

	public void setTitle(String title)
	{
		this.title = title;
	}

	public String getExternalWebUrl()
	{
		return externalWebUrl;
	}

	public void setExternalWebUrl(String externalWebUrl)
	{
		this.externalWebUrl = externalWebUrl;
	}

	public String getCoverImageUcmId()
	{
		return coverImageUcmId;
	}

	public void setCoverImageUcmId(String coverImageUcmId)
	{
		this.coverImageUcmId = coverImageUcmId;
	}

	public String getPrimaryImageUcmId()
	{
		return primaryImageUcmId;
	}

	public void setPrimaryImageUcmId(String primaryImageUcmId)
	{
		this.primaryImageUcmId = primaryImageUcmId;
	}
}
