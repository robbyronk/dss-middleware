
package com.stellent.dev.getfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for FileInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FileInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dDocName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dDocTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dDocType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dDocAuthor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dSecurityGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dDocAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dRevClassID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dRevisionID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dRevLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dIsCheckedOut" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dCheckoutUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dCreateDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dInDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dOutDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dReleaseState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dFlag1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dWebExtension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dProcessingState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dMessage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dReleaseDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dRendition1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dRendition2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dIndexerState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dPublishType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dPublishState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dDocID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dIsPrimary" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dIsWebFormat" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dLocation" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dOriginalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dExtension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dFileSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="CustomDocMetaData" type="{http://www.stellent.com/GetFile/}IdcPropertyList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileInfo", propOrder = {
    "dDocName",
    "dDocTitle",
    "dDocType",
    "dDocAuthor",
    "dSecurityGroup",
    "dDocAccount",
    "did",
    "dRevClassID",
    "dRevisionID",
    "dRevLabel",
    "dIsCheckedOut",
    "dCheckoutUser",
    "dCreateDate",
    "dInDate",
    "dOutDate",
    "dStatus",
    "dReleaseState",
    "dFlag1",
    "dWebExtension",
    "dProcessingState",
    "dMessage",
    "dReleaseDate",
    "dRendition1",
    "dRendition2",
    "dIndexerState",
    "dPublishType",
    "dPublishState",
    "dDocID",
    "dIsPrimary",
    "dIsWebFormat",
    "dLocation",
    "dOriginalName",
    "dFormat",
    "dExtension",
    "dFileSize",
    "customDocMetaData"
})
public class FileInfo {

    protected String dDocName;
    protected String dDocTitle;
    protected String dDocType;
    protected String dDocAuthor;
    protected String dSecurityGroup;
    protected String dDocAccount;
    @XmlElement(name = "dID")
    protected Integer did;
    protected Integer dRevClassID;
    protected Integer dRevisionID;
    protected String dRevLabel;
    protected Boolean dIsCheckedOut;
    protected String dCheckoutUser;
    protected String dCreateDate;
    protected String dInDate;
    protected String dOutDate;
    protected String dStatus;
    protected String dReleaseState;
    protected String dFlag1;
    protected String dWebExtension;
    protected String dProcessingState;
    protected String dMessage;
    protected String dReleaseDate;
    protected String dRendition1;
    protected String dRendition2;
    protected String dIndexerState;
    protected String dPublishType;
    protected String dPublishState;
    protected Integer dDocID;
    protected Boolean dIsPrimary;
    protected Boolean dIsWebFormat;
    protected String dLocation;
    protected String dOriginalName;
    protected String dFormat;
    protected String dExtension;
    protected Integer dFileSize;
    @XmlElement(name = "CustomDocMetaData")
    protected IdcPropertyList customDocMetaData;

    /**
     * Gets the value of the dDocName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDocName() {
        return dDocName;
    }

    /**
     * Sets the value of the dDocName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDocName(String value) {
        this.dDocName = value;
    }

    /**
     * Gets the value of the dDocTitle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDocTitle() {
        return dDocTitle;
    }

    /**
     * Sets the value of the dDocTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDocTitle(String value) {
        this.dDocTitle = value;
    }

    /**
     * Gets the value of the dDocType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDocType() {
        return dDocType;
    }

    /**
     * Sets the value of the dDocType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDocType(String value) {
        this.dDocType = value;
    }

    /**
     * Gets the value of the dDocAuthor property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDocAuthor() {
        return dDocAuthor;
    }

    /**
     * Sets the value of the dDocAuthor property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDocAuthor(String value) {
        this.dDocAuthor = value;
    }

    /**
     * Gets the value of the dSecurityGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDSecurityGroup() {
        return dSecurityGroup;
    }

    /**
     * Sets the value of the dSecurityGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDSecurityGroup(String value) {
        this.dSecurityGroup = value;
    }

    /**
     * Gets the value of the dDocAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDocAccount() {
        return dDocAccount;
    }

    /**
     * Sets the value of the dDocAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDocAccount(String value) {
        this.dDocAccount = value;
    }

    /**
     * Gets the value of the did property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDID() {
        return did;
    }

    /**
     * Sets the value of the did property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDID(Integer value) {
        this.did = value;
    }

    /**
     * Gets the value of the dRevClassID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDRevClassID() {
        return dRevClassID;
    }

    /**
     * Sets the value of the dRevClassID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDRevClassID(Integer value) {
        this.dRevClassID = value;
    }

    /**
     * Gets the value of the dRevisionID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDRevisionID() {
        return dRevisionID;
    }

    /**
     * Sets the value of the dRevisionID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDRevisionID(Integer value) {
        this.dRevisionID = value;
    }

    /**
     * Gets the value of the dRevLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDRevLabel() {
        return dRevLabel;
    }

    /**
     * Sets the value of the dRevLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDRevLabel(String value) {
        this.dRevLabel = value;
    }

    /**
     * Gets the value of the dIsCheckedOut property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDIsCheckedOut() {
        return dIsCheckedOut;
    }

    /**
     * Sets the value of the dIsCheckedOut property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDIsCheckedOut(Boolean value) {
        this.dIsCheckedOut = value;
    }

    /**
     * Gets the value of the dCheckoutUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDCheckoutUser() {
        return dCheckoutUser;
    }

    /**
     * Sets the value of the dCheckoutUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDCheckoutUser(String value) {
        this.dCheckoutUser = value;
    }

    /**
     * Gets the value of the dCreateDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDCreateDate() {
        return dCreateDate;
    }

    /**
     * Sets the value of the dCreateDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDCreateDate(String value) {
        this.dCreateDate = value;
    }

    /**
     * Gets the value of the dInDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDInDate() {
        return dInDate;
    }

    /**
     * Sets the value of the dInDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDInDate(String value) {
        this.dInDate = value;
    }

    /**
     * Gets the value of the dOutDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOutDate() {
        return dOutDate;
    }

    /**
     * Sets the value of the dOutDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOutDate(String value) {
        this.dOutDate = value;
    }

    /**
     * Gets the value of the dStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDStatus() {
        return dStatus;
    }

    /**
     * Sets the value of the dStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDStatus(String value) {
        this.dStatus = value;
    }

    /**
     * Gets the value of the dReleaseState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDReleaseState() {
        return dReleaseState;
    }

    /**
     * Sets the value of the dReleaseState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDReleaseState(String value) {
        this.dReleaseState = value;
    }

    /**
     * Gets the value of the dFlag1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDFlag1() {
        return dFlag1;
    }

    /**
     * Sets the value of the dFlag1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDFlag1(String value) {
        this.dFlag1 = value;
    }

    /**
     * Gets the value of the dWebExtension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDWebExtension() {
        return dWebExtension;
    }

    /**
     * Sets the value of the dWebExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDWebExtension(String value) {
        this.dWebExtension = value;
    }

    /**
     * Gets the value of the dProcessingState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDProcessingState() {
        return dProcessingState;
    }

    /**
     * Sets the value of the dProcessingState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDProcessingState(String value) {
        this.dProcessingState = value;
    }

    /**
     * Gets the value of the dMessage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDMessage() {
        return dMessage;
    }

    /**
     * Sets the value of the dMessage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDMessage(String value) {
        this.dMessage = value;
    }

    /**
     * Gets the value of the dReleaseDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDReleaseDate() {
        return dReleaseDate;
    }

    /**
     * Sets the value of the dReleaseDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDReleaseDate(String value) {
        this.dReleaseDate = value;
    }

    /**
     * Gets the value of the dRendition1 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDRendition1() {
        return dRendition1;
    }

    /**
     * Sets the value of the dRendition1 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDRendition1(String value) {
        this.dRendition1 = value;
    }

    /**
     * Gets the value of the dRendition2 property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDRendition2() {
        return dRendition2;
    }

    /**
     * Sets the value of the dRendition2 property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDRendition2(String value) {
        this.dRendition2 = value;
    }

    /**
     * Gets the value of the dIndexerState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDIndexerState() {
        return dIndexerState;
    }

    /**
     * Sets the value of the dIndexerState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDIndexerState(String value) {
        this.dIndexerState = value;
    }

    /**
     * Gets the value of the dPublishType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDPublishType() {
        return dPublishType;
    }

    /**
     * Sets the value of the dPublishType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDPublishType(String value) {
        this.dPublishType = value;
    }

    /**
     * Gets the value of the dPublishState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDPublishState() {
        return dPublishState;
    }

    /**
     * Sets the value of the dPublishState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDPublishState(String value) {
        this.dPublishState = value;
    }

    /**
     * Gets the value of the dDocID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDDocID() {
        return dDocID;
    }

    /**
     * Sets the value of the dDocID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDDocID(Integer value) {
        this.dDocID = value;
    }

    /**
     * Gets the value of the dIsPrimary property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDIsPrimary() {
        return dIsPrimary;
    }

    /**
     * Sets the value of the dIsPrimary property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDIsPrimary(Boolean value) {
        this.dIsPrimary = value;
    }

    /**
     * Gets the value of the dIsWebFormat property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDIsWebFormat() {
        return dIsWebFormat;
    }

    /**
     * Sets the value of the dIsWebFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDIsWebFormat(Boolean value) {
        this.dIsWebFormat = value;
    }

    /**
     * Gets the value of the dLocation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDLocation() {
        return dLocation;
    }

    /**
     * Sets the value of the dLocation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDLocation(String value) {
        this.dLocation = value;
    }

    /**
     * Gets the value of the dOriginalName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOriginalName() {
        return dOriginalName;
    }

    /**
     * Sets the value of the dOriginalName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOriginalName(String value) {
        this.dOriginalName = value;
    }

    /**
     * Gets the value of the dFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDFormat() {
        return dFormat;
    }

    /**
     * Sets the value of the dFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDFormat(String value) {
        this.dFormat = value;
    }

    /**
     * Gets the value of the dExtension property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDExtension() {
        return dExtension;
    }

    /**
     * Sets the value of the dExtension property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDExtension(String value) {
        this.dExtension = value;
    }

    /**
     * Gets the value of the dFileSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDFileSize() {
        return dFileSize;
    }

    /**
     * Sets the value of the dFileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDFileSize(Integer value) {
        this.dFileSize = value;
    }

    /**
     * Gets the value of the customDocMetaData property.
     * 
     * @return
     *     possible object is
     *     {@link IdcPropertyList }
     *     
     */
    public IdcPropertyList getCustomDocMetaData() {
        return customDocMetaData;
    }

    /**
     * Sets the value of the customDocMetaData property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdcPropertyList }
     *     
     */
    public void setCustomDocMetaData(IdcPropertyList value) {
        this.customDocMetaData = value;
    }

}
