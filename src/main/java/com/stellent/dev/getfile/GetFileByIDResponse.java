
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
 *         &lt;element name="GetFileByIDResult" type="{http://www.stellent.com/GetFile/}GetFileByIDResult" minOccurs="0"/>
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
    "getFileByIDResult"
})
@XmlRootElement(name = "GetFileByIDResponse")
public class GetFileByIDResponse {

    @XmlElement(name = "GetFileByIDResult")
    protected GetFileByIDResult getFileByIDResult;

    /**
     * Gets the value of the getFileByIDResult property.
     * 
     * @return
     *     possible object is
     *     {@link GetFileByIDResult }
     *     
     */
    public GetFileByIDResult getGetFileByIDResult() {
        return getFileByIDResult;
    }

    /**
     * Sets the value of the getFileByIDResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetFileByIDResult }
     *     
     */
    public void setGetFileByIDResult(GetFileByIDResult value) {
        this.getFileByIDResult = value;
    }

}
