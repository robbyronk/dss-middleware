
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
 *         &lt;element name="UserMetaDataResult" type="{http://www.stellent.com/MetaData/}UserMetaDataResult" minOccurs="0"/>
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
    "userMetaDataResult"
})
@XmlRootElement(name = "UserMetaDataResponse")
public class UserMetaDataResponse {

    @XmlElement(name = "UserMetaDataResult")
    protected UserMetaDataResult userMetaDataResult;

    /**
     * Gets the value of the userMetaDataResult property.
     * 
     * @return
     *     possible object is
     *     {@link UserMetaDataResult }
     *     
     */
    public UserMetaDataResult getUserMetaDataResult() {
        return userMetaDataResult;
    }

    /**
     * Sets the value of the userMetaDataResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link UserMetaDataResult }
     *     
     */
    public void setUserMetaDataResult(UserMetaDataResult value) {
        this.userMetaDataResult = value;
    }

}
