
package com.stellent.dev.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UserMetaFields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="UserMetaFields">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="umdName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="umdType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="umdCaption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="umdIsOptionList" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="umdOptionListType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="umdOptionListKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="umdIsAdminEdit" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="umdIsViewOnly" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="umdOverrideBitFlag" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="umdOptionListValues" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "UserMetaFields", propOrder = {
    "umdName",
    "umdType",
    "umdCaption",
    "umdIsOptionList",
    "umdOptionListType",
    "umdOptionListKey",
    "umdIsAdminEdit",
    "umdIsViewOnly",
    "umdOverrideBitFlag",
    "umdOptionListValues"
})
public class UserMetaFields {

    protected String umdName;
    protected String umdType;
    protected String umdCaption;
    protected Boolean umdIsOptionList;
    protected String umdOptionListType;
    protected String umdOptionListKey;
    protected Boolean umdIsAdminEdit;
    protected Boolean umdIsViewOnly;
    protected String umdOverrideBitFlag;
    protected String umdOptionListValues;

    /**
     * Gets the value of the umdName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUmdName() {
        return umdName;
    }

    /**
     * Sets the value of the umdName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUmdName(String value) {
        this.umdName = value;
    }

    /**
     * Gets the value of the umdType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUmdType() {
        return umdType;
    }

    /**
     * Sets the value of the umdType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUmdType(String value) {
        this.umdType = value;
    }

    /**
     * Gets the value of the umdCaption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUmdCaption() {
        return umdCaption;
    }

    /**
     * Sets the value of the umdCaption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUmdCaption(String value) {
        this.umdCaption = value;
    }

    /**
     * Gets the value of the umdIsOptionList property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUmdIsOptionList() {
        return umdIsOptionList;
    }

    /**
     * Sets the value of the umdIsOptionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUmdIsOptionList(Boolean value) {
        this.umdIsOptionList = value;
    }

    /**
     * Gets the value of the umdOptionListType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUmdOptionListType() {
        return umdOptionListType;
    }

    /**
     * Sets the value of the umdOptionListType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUmdOptionListType(String value) {
        this.umdOptionListType = value;
    }

    /**
     * Gets the value of the umdOptionListKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUmdOptionListKey() {
        return umdOptionListKey;
    }

    /**
     * Sets the value of the umdOptionListKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUmdOptionListKey(String value) {
        this.umdOptionListKey = value;
    }

    /**
     * Gets the value of the umdIsAdminEdit property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUmdIsAdminEdit() {
        return umdIsAdminEdit;
    }

    /**
     * Sets the value of the umdIsAdminEdit property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUmdIsAdminEdit(Boolean value) {
        this.umdIsAdminEdit = value;
    }

    /**
     * Gets the value of the umdIsViewOnly property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUmdIsViewOnly() {
        return umdIsViewOnly;
    }

    /**
     * Sets the value of the umdIsViewOnly property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUmdIsViewOnly(Boolean value) {
        this.umdIsViewOnly = value;
    }

    /**
     * Gets the value of the umdOverrideBitFlag property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUmdOverrideBitFlag() {
        return umdOverrideBitFlag;
    }

    /**
     * Sets the value of the umdOverrideBitFlag property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUmdOverrideBitFlag(String value) {
        this.umdOverrideBitFlag = value;
    }

    /**
     * Gets the value of the umdOptionListValues property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUmdOptionListValues() {
        return umdOptionListValues;
    }

    /**
     * Sets the value of the umdOptionListValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUmdOptionListValues(String value) {
        this.umdOptionListValues = value;
    }

}
