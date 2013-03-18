
package com.stellent.dev.search;

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
 *         &lt;element name="NavigationSearchResult" type="{http://www.stellent.com/Search/}NavigationSearchResult" minOccurs="0"/>
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
    "navigationSearchResult"
})
@XmlRootElement(name = "NavigationSearchResponse")
public class NavigationSearchResponse {

    @XmlElement(name = "NavigationSearchResult")
    protected NavigationSearchResult navigationSearchResult;

    /**
     * Gets the value of the navigationSearchResult property.
     * 
     * @return
     *     possible object is
     *     {@link NavigationSearchResult }
     *     
     */
    public NavigationSearchResult getNavigationSearchResult() {
        return navigationSearchResult;
    }

    /**
     * Sets the value of the navigationSearchResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link NavigationSearchResult }
     *     
     */
    public void setNavigationSearchResult(NavigationSearchResult value) {
        this.navigationSearchResult = value;
    }

}
