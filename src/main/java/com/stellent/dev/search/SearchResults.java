
package com.stellent.dev.search;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for SearchResults complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SearchResults">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dRevisionID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dDocName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dDocTitle" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dDocType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dDocAuthor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dSecurityGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dDocAccount" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dExtension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dWebExtension" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dRevLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dInDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dOutDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dOriginalName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="url" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="webCgiRoot" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dGif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="webFileSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vaultFileSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="alternateFileSize" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="alternateFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dPublishType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dRendition1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dRendition2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="CustomDocMetaData" type="{http://www.stellent.com/Search/}IdcPropertyList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SearchResults", propOrder = {
    "did",
    "dRevisionID",
    "dDocName",
    "dDocTitle",
    "dDocType",
    "dDocAuthor",
    "dSecurityGroup",
    "dDocAccount",
    "dExtension",
    "dWebExtension",
    "dRevLabel",
    "dInDate",
    "dOutDate",
    "dFormat",
    "dOriginalName",
    "url",
    "webCgiRoot",
    "dGif",
    "webFileSize",
    "vaultFileSize",
    "alternateFileSize",
    "alternateFormat",
    "dPublishType",
    "dRendition1",
    "dRendition2",
    "customDocMetaData"
})
public class SearchResults {

    @XmlElement(name = "dID")
    protected Integer did;
    protected Integer dRevisionID;
    protected String dDocName;
    protected String dDocTitle;
    protected String dDocType;
    protected String dDocAuthor;
    protected String dSecurityGroup;
    protected String dDocAccount;
    protected String dExtension;
    protected String dWebExtension;
    protected String dRevLabel;
    protected String dInDate;
    protected String dOutDate;
    protected String dFormat;
    protected String dOriginalName;
    protected String url;
    protected String webCgiRoot;
    protected String dGif;
    protected Integer webFileSize;
    protected Integer vaultFileSize;
    protected Integer alternateFileSize;
    protected String alternateFormat;
    protected String dPublishType;
    protected String dRendition1;
    protected String dRendition2;
    @XmlElement(name = "CustomDocMetaData")
    protected IdcPropertyList customDocMetaData;

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
     * Gets the value of the url property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the value of the url property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * Gets the value of the webCgiRoot property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWebCgiRoot() {
        return webCgiRoot;
    }

    /**
     * Sets the value of the webCgiRoot property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWebCgiRoot(String value) {
        this.webCgiRoot = value;
    }

    /**
     * Gets the value of the dGif property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDGif() {
        return dGif;
    }

    /**
     * Sets the value of the dGif property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDGif(String value) {
        this.dGif = value;
    }

    /**
     * Gets the value of the webFileSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getWebFileSize() {
        return webFileSize;
    }

    /**
     * Sets the value of the webFileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setWebFileSize(Integer value) {
        this.webFileSize = value;
    }

    /**
     * Gets the value of the vaultFileSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getVaultFileSize() {
        return vaultFileSize;
    }

    /**
     * Sets the value of the vaultFileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setVaultFileSize(Integer value) {
        this.vaultFileSize = value;
    }

    /**
     * Gets the value of the alternateFileSize property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getAlternateFileSize() {
        return alternateFileSize;
    }

    /**
     * Sets the value of the alternateFileSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setAlternateFileSize(Integer value) {
        this.alternateFileSize = value;
    }

    /**
     * Gets the value of the alternateFormat property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlternateFormat() {
        return alternateFormat;
    }

    /**
     * Sets the value of the alternateFormat property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlternateFormat(String value) {
        this.alternateFormat = value;
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
