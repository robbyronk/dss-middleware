package org.cru.dss.middle.localcontent;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "CRU_WEB_IMAGE")
public class WebImage implements java.io.Serializable
{
	private static final long serialVersionUID = 1L;

	@Id @Column(name = "UCM_ID")
	String ucmId;
	
	@Column(name = "DESIGNATION")
	String designation;
	
	@Lob @Column(name = "IMAGE")
	byte[] image;

	public String getUcmId()
	{
		return ucmId;
	}

	public void setUcmId(String ucmId)
	{
		this.ucmId = ucmId;
	}

	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	public byte[] getImage()
	{
		return image;
	}

	public void setImage(byte[] image)
	{
		this.image = image;
	}
}
