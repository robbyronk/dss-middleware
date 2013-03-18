
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
 *         &lt;element name="DocInfoByIDResult" type="{http://www.stellent.com/DocInfo/}DocInfoByIDResult" minOccurs="0"/>
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
    "docInfoByIDResult"
})
@XmlRootElement(name = "DocInfoByIDResponse")
public class DocInfoByIDResponse {

    @XmlElement(name = "DocInfoByIDResult")
    protected DocInfoByIDResult docInfoByIDResult;

    /**
     * Gets the value of the docInfoByIDResult property.
     * 
     * @return
     *     possible object is
     *     {@link DocInfoByIDResult }
     *     
     */
    public DocInfoByIDResult getDocInfoByIDResult() {
        return docInfoByIDResult;
    }

    /**
     * Sets the value of the docInfoByIDResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link DocInfoByIDResult }
     *     
     */
    public void setDocInfoByIDResult(DocInfoByIDResult value) {
        this.docInfoByIDResult = value;
    }

}
