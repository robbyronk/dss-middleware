
package com.stellent.dev.metadata;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocMetaDataResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocMetaDataResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="isAutoNumber" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="useAccounts" type="{http://www.w3.org/2001/XMLSchema}boolean" minOccurs="0"/>
 *         &lt;element name="DocTypes" type="{http://www.stellent.com/MetaData/}DocTypes" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SecurityGroups" type="{http://www.stellent.com/MetaData/}IdcOptionList" minOccurs="0"/>
 *         &lt;element name="Accounts" type="{http://www.stellent.com/MetaData/}IdcOptionList" minOccurs="0"/>
 *         &lt;element name="DocMetaFields" type="{http://www.stellent.com/MetaData/}DocMetaFields" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StatusInfo" type="{http://www.stellent.com/MetaData/}StatusInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocMetaDataResult", propOrder = {
    "isAutoNumber",
    "useAccounts",
    "docTypes",
    "securityGroups",
    "accounts",
    "docMetaFields",
    "statusInfo"
})
public class DocMetaDataResult {

    protected Boolean isAutoNumber;
    protected Boolean useAccounts;
    @XmlElement(name = "DocTypes")
    protected List<DocTypes> docTypes;
    @XmlElement(name = "SecurityGroups")
    protected IdcOptionList securityGroups;
    @XmlElement(name = "Accounts")
    protected IdcOptionList accounts;
    @XmlElement(name = "DocMetaFields")
    protected List<DocMetaFields> docMetaFields;
    @XmlElement(name = "StatusInfo")
    protected StatusInfo statusInfo;

    /**
     * Gets the value of the isAutoNumber property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isIsAutoNumber() {
        return isAutoNumber;
    }

    /**
     * Sets the value of the isAutoNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setIsAutoNumber(Boolean value) {
        this.isAutoNumber = value;
    }

    /**
     * Gets the value of the useAccounts property.
     * 
     * @return
     *     possible object is
     *     {@link Boolean }
     *     
     */
    public Boolean isUseAccounts() {
        return useAccounts;
    }

    /**
     * Sets the value of the useAccounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link Boolean }
     *     
     */
    public void setUseAccounts(Boolean value) {
        this.useAccounts = value;
    }

    /**
     * Gets the value of the docTypes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docTypes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocTypes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocTypes }
     * 
     * 
     */
    public List<DocTypes> getDocTypes() {
        if (docTypes == null) {
            docTypes = new ArrayList<DocTypes>();
        }
        return this.docTypes;
    }

    /**
     * Gets the value of the securityGroups property.
     * 
     * @return
     *     possible object is
     *     {@link IdcOptionList }
     *     
     */
    public IdcOptionList getSecurityGroups() {
        return securityGroups;
    }

    /**
     * Sets the value of the securityGroups property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdcOptionList }
     *     
     */
    public void setSecurityGroups(IdcOptionList value) {
        this.securityGroups = value;
    }

    /**
     * Gets the value of the accounts property.
     * 
     * @return
     *     possible object is
     *     {@link IdcOptionList }
     *     
     */
    public IdcOptionList getAccounts() {
        return accounts;
    }

    /**
     * Sets the value of the accounts property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdcOptionList }
     *     
     */
    public void setAccounts(IdcOptionList value) {
        this.accounts = value;
    }

    /**
     * Gets the value of the docMetaFields property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the docMetaFields property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDocMetaFields().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DocMetaFields }
     * 
     * 
     */
    public List<DocMetaFields> getDocMetaFields() {
        if (docMetaFields == null) {
            docMetaFields = new ArrayList<DocMetaFields>();
        }
        return this.docMetaFields;
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
