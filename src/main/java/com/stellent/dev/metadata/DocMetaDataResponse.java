
package com.stellent.dev.metadata;

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
 *         &lt;element name="DocMetaDataResult" type="{http://www.stellent.com/MetaData/}DocMetaDataResult" minOccurs="0"/>
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
    "docMetaDataResult"
})
@XmlRootElement(name = "DocMetaDataResponse")
public class DocMetaDataResponse {

    @XmlElement(name = "DocMetaDataResult")
    protected DocMetaDataResult docMetaDataResult;

    /**
     * Gets the value of the docMetaDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link DocMetaDataResult }
     *     
     */
    public DocMetaDataResult getDocMetaDataResult() {
        return docMetaDataResult;
    }

    /**
     * Sets the value of the docMetaDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocMetaDataResult }
     *     
     */
    public void setDocMetaDataResult(DocMetaDataResult value) {
        this.docMetaDataResult = value;
    }

}
