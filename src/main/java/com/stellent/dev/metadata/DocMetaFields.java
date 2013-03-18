
package com.stellent.dev.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocMetaFields complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocMetaFields">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dIsRequired" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dIsEnabled" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dIsSearchable" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dCaption" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dIsOptionList" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="dOptionListKey" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dDefaultValue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dOrder" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dOptionListType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dOptionListValues" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocMetaFields", propOrder = {
    "dName",
    "dType",
    "dIsRequired",
    "dIsEnabled",
    "dIsSearchable",
    "dCaption",
    "dIsOptionList",
    "dOptionListKey",
    "dDefaultValue",
    "dOrder",
    "dOptionListType",
    "dOptionListValues"
})
public class DocMetaFields {

    protected String dName;
    protected String dType;
    protected Boolean dIsRequired;
    protected Boolean dIsEnabled;
    protected Boolean dIsSearchable;
    protected String dCaption;
    protected Boolean dIsOptionList;
    protected String dOptionListKey;
    protected String dDefaultValue;
    protected Integer dOrder;
    protected String dOptionListType;
    protected String dOptionListValues;

    /**
     * Gets the value of the dName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDName() {
        return dName;
    }

    /**
     * Sets the value of the dName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDName(String value) {
        this.dName = value;
    }

    /**
     * Gets the value of the dType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDType() {
        return dType;
    }

    /**
     * Sets the value of the dType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDType(String value) {
        this.dType = value;
    }

    /**
     * Gets the value of the dIsRequired property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDIsRequired() {
        return dIsRequired;
    }

    /**
     * Sets the value of the dIsRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDIsRequired(Boolean value) {
        this.dIsRequired = value;
    }

    /**
     * Gets the value of the dIsEnabled property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDIsEnabled() {
        return dIsEnabled;
    }

    /**
     * Sets the value of the dIsEnabled property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDIsEnabled(Boolean value) {
        this.dIsEnabled = value;
    }

    /**
     * Gets the value of the dIsSearchable property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDIsSearchable() {
        return dIsSearchable;
    }

    /**
     * Sets the value of the dIsSearchable property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDIsSearchable(Boolean value) {
        this.dIsSearchable = value;
    }

    /**
     * Gets the value of the dCaption property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDCaption() {
        return dCaption;
    }

    /**
     * Sets the value of the dCaption property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDCaption(String value) {
        this.dCaption = value;
    }

    /**
     * Gets the value of the dIsOptionList property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDIsOptionList() {
        return dIsOptionList;
    }

    /**
     * Sets the value of the dIsOptionList property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDIsOptionList(Boolean value) {
        this.dIsOptionList = value;
    }

    /**
     * Gets the value of the dOptionListKey property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOptionListKey() {
        return dOptionListKey;
    }

    /**
     * Sets the value of the dOptionListKey property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOptionListKey(String value) {
        this.dOptionListKey = value;
    }

    /**
     * Gets the value of the dDefaultValue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDefaultValue() {
        return dDefaultValue;
    }

    /**
     * Sets the value of the dDefaultValue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDefaultValue(String value) {
        this.dDefaultValue = value;
    }

    /**
     * Gets the value of the dOrder property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDOrder() {
        return dOrder;
    }

    /**
     * Sets the value of the dOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDOrder(Integer value) {
        this.dOrder = value;
    }

    /**
     * Gets the value of the dOptionListType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOptionListType() {
        return dOptionListType;
    }

    /**
     * Sets the value of the dOptionListType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOptionListType(String value) {
        this.dOptionListType = value;
    }

    /**
     * Gets the value of the dOptionListValues property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDOptionListValues() {
        return dOptionListValues;
    }

    /**
     * Sets the value of the dOptionListValues property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDOptionListValues(String value) {
        this.dOptionListValues = value;
    }

}
