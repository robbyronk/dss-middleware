
package com.stellent.dev.getfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dDocName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="revisionSelectionMethod" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="rendition" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="extraProps" type="{http://www.stellent.com/GetFile/}IdcPropertyList" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "dDocName",
    "revisionSelectionMethod",
    "rendition",
    "extraProps"
})
@XmlRootElement(name = "GetFileByName")
public class GetFileByName {

    protected String dDocName;
    protected String revisionSelectionMethod;
    protected String rendition;
    protected IdcPropertyList extraProps;

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
     * Gets the value of the revisionSelectionMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRevisionSelectionMethod() {
        return revisionSelectionMethod;
    }

    /**
     * Sets the value of the revisionSelectionMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRevisionSelectionMethod(String value) {
        this.revisionSelectionMethod = value;
    }

    /**
     * Gets the value of the rendition property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRendition() {
        return rendition;
    }

    /**
     * Sets the value of the rendition property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRendition(String value) {
        this.rendition = value;
    }

    /**
     * Gets the value of the extraProps property.
     * 
     * @return
     *     possible object is
     *     {@link IdcPropertyList }
     *     
     */
    public IdcPropertyList getExtraProps() {
        return extraProps;
    }

    /**
     * Sets the value of the extraProps property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdcPropertyList }
     *     
     */
    public void setExtraProps(IdcPropertyList value) {
        this.extraProps = value;
    }

}
