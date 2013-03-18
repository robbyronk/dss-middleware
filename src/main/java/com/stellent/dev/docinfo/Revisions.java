
package com.stellent.dev.docinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Revisions complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Revisions">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dFormat" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dInDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dOutDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dProcessingState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dRevLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dDocName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dRevisionID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Revisions", propOrder = {
    "dFormat",
    "dInDate",
    "dOutDate",
    "dStatus",
    "dProcessingState",
    "dRevLabel",
    "did",
    "dDocName",
    "dRevisionID"
})
public class Revisions {

    protected String dFormat;
    protected String dInDate;
    protected String dOutDate;
    protected String dStatus;
    protected String dProcessingState;
    protected String dRevLabel;
    @XmlElement(name = "dID")
    protected Integer did;
    protected String dDocName;
    protected Integer dRevisionID;

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

}
