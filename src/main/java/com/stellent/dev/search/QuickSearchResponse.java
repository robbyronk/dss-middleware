
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
 *         &lt;element name="QuickSearchResult" type="{http://www.stellent.com/Search/}QuickSearchResult" minOccurs="0"/>
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
    "quickSearchResult"
})
@XmlRootElement(name = "QuickSearchResponse")
public class QuickSearchResponse {

    @XmlElement(name = "QuickSearchResult")
    protected QuickSearchResult quickSearchResult;

    /**
     * Gets the value of the quickSearchResult property.
     * 
     * @return
     *     possible object is
     *     {@link QuickSearchResult }
     *     
     */
    public QuickSearchResult getQuickSearchResult() {
        return quickSearchResult;
    }

    /**
     * Sets the value of the quickSearchResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link QuickSearchResult }
     *     
     */
    public void setQuickSearchResult(QuickSearchResult value) {
        this.quickSearchResult = value;
    }

}
