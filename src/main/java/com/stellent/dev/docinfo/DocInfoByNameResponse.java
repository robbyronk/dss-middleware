
package com.stellent.dev.docinfo;

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
 *         &lt;element name="DocInfoByNameResult" type="{http://www.stellent.com/DocInfo/}DocInfoByNameResult" minOccurs="0"/>
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
    "docInfoByNameResult"
})
@XmlRootElement(name = "DocInfoByNameResponse")
public class DocInfoByNameResponse {

    @XmlElement(name = "DocInfoByNameResult")
    protected DocInfoByNameResult docInfoByNameResult;

    /**
     * Gets the value of the docInfoByNameResult property.
     * 
     * @return
     *     possible object is
     *     {@link DocInfoByNameResult }
     *     
     */
    public DocInfoByNameResult getDocInfoByNameResult() {
        return docInfoByNameResult;
    }

    /**
     * Sets the value of the docInfoByNameResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocInfoByNameResult }
     *     
     */
    public void setDocInfoByNameResult(DocInfoByNameResult value) {
        this.docInfoByNameResult = value;
    }

}
