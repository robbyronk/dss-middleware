
package com.stellent.dev.getfile;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GetFileByIDResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GetFileByIDResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="FileInfo" type="{http://www.stellent.com/GetFile/}FileInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="downloadFile" type="{http://www.stellent.com/GetFile/}IdcFile" minOccurs="0"/>
 *         &lt;element name="StatusInfo" type="{http://www.stellent.com/GetFile/}StatusInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GetFileByIDResult", propOrder = {
    "fileInfo",
    "downloadFile",
    "statusInfo"
})
public class GetFileByIDResult {

    @XmlElement(name = "FileInfo")
    protected List<FileInfo> fileInfo;
    protected IdcFile downloadFile;
    @XmlElement(name = "StatusInfo")
    protected StatusInfo statusInfo;

    /**
     * Gets the value of the fileInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the fileInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getFileInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link FileInfo }
     * 
     * 
     */
    public List<FileInfo> getFileInfo() {
        if (fileInfo == null) {
            fileInfo = new ArrayList<FileInfo>();
        }
        return this.fileInfo;
    }

    /**
     * Gets the value of the downloadFile property.
     * 
     * @return
     *     possible object is
     *     {@link IdcFile }
     *     
     */
    public IdcFile getDownloadFile() {
        return downloadFile;
    }

    /**
     * Sets the value of the downloadFile property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdcFile }
     *     
     */
    public void setDownloadFile(IdcFile value) {
        this.downloadFile = value;
    }

    /**
     * Gets the value of the statusInfo property.
     * 
     * @return
     *     possible object is
     *     {@link StatusInfo }
     *     
     */
    public StatusInfo getStatusInfo() {
        return statusInfo;
    }

    /**
     * Sets the value of the statusInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link StatusInfo }
     *     
     */
    public void setStatusInfo(StatusInfo value) {
        this.statusInfo = value;
    }

}
