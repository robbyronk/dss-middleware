
package com.stellent.dev.metadata;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocTypes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocTypes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dDocType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dGif" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocTypes", propOrder = {
    "dDocType",
    "dDescription",
    "dGif"
})
public class DocTypes {

    protected String dDocType;
    protected String dDescription;
    protected String dGif;

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
     * Gets the value of the dDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDDescription() {
        return dDescription;
    }

    /**
     * Sets the value of the dDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDDescription(String value) {
        this.dDescription = value;
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

}
