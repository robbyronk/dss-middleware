
package com.stellent.dev.getfile;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
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
 *         &lt;element name="dID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
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
    "did",
    "rendition",
    "extraProps"
})
@XmlRootElement(name = "GetFileByID")
public class GetFileByID {

    @XmlElement(name = "dID")
    protected Integer did;
    protected String rendition;
    protected IdcPropertyList extraProps;

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
