
package com.stellent.dev.search;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NavigationSearchResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NavigationSearchResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SearchResults" type="{http://www.stellent.com/Search/}SearchResults" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="SearchInfo" type="{http://www.stellent.com/Search/}SearchInfo" minOccurs="0"/>
 *         &lt;element name="NavigationPages" type="{http://www.stellent.com/Search/}NavigationPages" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StatusInfo" type="{http://www.stellent.com/Search/}StatusInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NavigationSearchResult", propOrder = {
    "searchResults",
    "searchInfo",
    "navigationPages",
    "statusInfo"
})
public class NavigationSearchResult {

    @XmlElement(name = "SearchResults")
    protected List<SearchResults> searchResults;
    @XmlElement(name = "SearchInfo")
    protected SearchInfo searchInfo;
    @XmlElement(name = "NavigationPages")
    protected List<NavigationPages> navigationPages;
    @XmlElement(name = "StatusInfo")
    protected StatusInfo statusInfo;

    /**
     * Gets the value of the searchResults property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the searchResults property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSearchResults().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SearchResults }
     * 
     * 
     */
    public List<SearchResults> getSearchResults() {
        if (searchResults == null) {
            searchResults = new ArrayList<SearchResults>();
        }
        return this.searchResults;
    }

    /**
     * Gets the value of the searchInfo property.
     * 
     * @return
     *     possible object is
     *     {@link SearchInfo }
     *     
     */
    public SearchInfo getSearchInfo() {
        return searchInfo;
    }

    /**
     * Sets the value of the searchInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchInfo }
     *     
     */
    public void setSearchInfo(SearchInfo value) {
        this.searchInfo = value;
    }

    /**
     * Gets the value of the navigationPages property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the navigationPages property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNavigationPages().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link NavigationPages }
     * 
     * 
     */
    public List<NavigationPages> getNavigationPages() {
        if (navigationPages == null) {
            navigationPages = new ArrayList<NavigationPages>();
        }
        return this.navigationPages;
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
