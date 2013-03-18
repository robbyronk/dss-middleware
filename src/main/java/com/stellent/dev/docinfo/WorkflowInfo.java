
package com.stellent.dev.docinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for WorkflowInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="WorkflowInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dWfID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dDocName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dWfDocState" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dWfComputed" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dWfCurrentStepID" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="dWfDirectory" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dClbraName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dWfName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dWfDescription" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dCompletionDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dSecurityGroup" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dWfStatus" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dWfType" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dProjectID" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dIsCollaboration" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "WorkflowInfo", propOrder = {
    "dWfID",
    "dDocName",
    "dWfDocState",
    "dWfComputed",
    "dWfCurrentStepID",
    "dWfDirectory",
    "dClbraName",
    "dWfName",
    "dWfDescription",
    "dCompletionDate",
    "dSecurityGroup",
    "dWfStatus",
    "dWfType",
    "dProjectID",
    "dIsCollaboration"
})
public class WorkflowInfo {

    protected Integer dWfID;
    protected String dDocName;
    protected String dWfDocState;
    protected String dWfComputed;
    protected Integer dWfCurrentStepID;
    protected String dWfDirectory;
    protected String dClbraName;
    protected String dWfName;
    protected String dWfDescription;
    protected String dCompletionDate;
    protected String dSecurityGroup;
    protected String dWfStatus;
    protected String dWfType;
    protected String dProjectID;
    protected Boolean dIsCollaboration;

    /**
     * Gets the value of the dWfID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDWfID() {
        return dWfID;
    }

    /**
     * Sets the value of the dWfID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDWfID(Integer value) {
        this.dWfID = value;
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
     * Gets the value of the dWfDocState property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDWfDocState() {
        return dWfDocState;
    }

    /**
     * Sets the value of the dWfDocState property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDWfDocState(String value) {
        this.dWfDocState = value;
    }

    /**
     * Gets the value of the dWfComputed property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDWfComputed() {
        return dWfComputed;
    }

    /**
     * Sets the value of the dWfComputed property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDWfComputed(String value) {
        this.dWfComputed = value;
    }

    /**
     * Gets the value of the dWfCurrentStepID property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getDWfCurrentStepID() {
        return dWfCurrentStepID;
    }

    /**
     * Sets the value of the dWfCurrentStepID property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setDWfCurrentStepID(Integer value) {
        this.dWfCurrentStepID = value;
    }

    /**
     * Gets the value of the dWfDirectory property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDWfDirectory() {
        return dWfDirectory;
    }

    /**
     * Sets the value of the dWfDirectory property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDWfDirectory(String value) {
        this.dWfDirectory = value;
    }

    /**
     * Gets the value of the dClbraName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDClbraName() {
        return dClbraName;
    }

    /**
     * Sets the value of the dClbraName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDClbraName(String value) {
        this.dClbraName = value;
    }

    /**
     * Gets the value of the dWfName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDWfName() {
        return dWfName;
    }

    /**
     * Sets the value of the dWfName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDWfName(String value) {
        this.dWfName = value;
    }

    /**
     * Gets the value of the dWfDescription property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDWfDescription() {
        return dWfDescription;
    }

    /**
     * Sets the value of the dWfDescription property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDWfDescription(String value) {
        this.dWfDescription = value;
    }

    /**
     * Gets the value of the dCompletionDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDCompletionDate() {
        return dCompletionDate;
    }

    /**
     * Sets the value of the dCompletionDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDCompletionDate(String value) {
        this.dCompletionDate = value;
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
     * Gets the value of the dWfStatus property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDWfStatus() {
        return dWfStatus;
    }

    /**
     * Sets the value of the dWfStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDWfStatus(String value) {
        this.dWfStatus = value;
    }

    /**
     * Gets the value of the dWfType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDWfType() {
        return dWfType;
    }

    /**
     * Sets the value of the dWfType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDWfType(String value) {
        this.dWfType = value;
    }

    /**
     * Gets the value of the dProjectID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDProjectID() {
        return dProjectID;
    }

    /**
     * Sets the value of the dProjectID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDProjectID(String value) {
        this.dProjectID = value;
    }

    /**
     * Gets the value of the dIsCollaboration property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isDIsCollaboration() {
        return dIsCollaboration;
    }

    /**
     * Sets the value of the dIsCollaboration property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setDIsCollaboration(Boolean value) {
        this.dIsCollaboration = value;
    }

}
