
package com.stellent.dev.search;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.1.6 in JDK 6
 * Generated source version: 2.1
 * 
 */
@WebService(name = "SearchSoap", targetNamespace = "http://www.stellent.com/Search/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SearchSoap {


    /**
     * 
     * @param extraProps
     * @param queryText
     * @return
     *     returns com.stellent.dev.search.QuickSearchResult
     */
    @WebMethod(operationName = "QuickSearch", action = "http://www.stellent.com/Search/")
    @WebResult(name = "QuickSearchResult", targetNamespace = "http://www.stellent.com/Search/")
    @RequestWrapper(localName = "QuickSearch", targetNamespace = "http://www.stellent.com/Search/", className = "com.stellent.dev.search.QuickSearch")
    @ResponseWrapper(localName = "QuickSearchResponse", targetNamespace = "http://www.stellent.com/Search/", className = "com.stellent.dev.search.QuickSearchResponse")
    public QuickSearchResult quickSearch(
        @WebParam(name = "queryText", targetNamespace = "http://www.stellent.com/Search/")
        String queryText,
        @WebParam(name = "extraProps", targetNamespace = "http://www.stellent.com/Search/")
        IdcPropertyList extraProps);

    /**
     * 
     * @param extraProps
     * @param sortField
     * @param resultCount
     * @param sortOrder
     * @param queryText
     * @return
     *     returns com.stellent.dev.search.AdvancedSearchResult
     */
    @WebMethod(operationName = "AdvancedSearch", action = "http://www.stellent.com/Search/")
    @WebResult(name = "AdvancedSearchResult", targetNamespace = "http://www.stellent.com/Search/")
    @RequestWrapper(localName = "AdvancedSearch", targetNamespace = "http://www.stellent.com/Search/", className = "com.stellent.dev.search.AdvancedSearch")
    @ResponseWrapper(localName = "AdvancedSearchResponse", targetNamespace = "http://www.stellent.com/Search/", className = "com.stellent.dev.search.AdvancedSearchResponse")
    public AdvancedSearchResult advancedSearch(
        @WebParam(name = "queryText", targetNamespace = "http://www.stellent.com/Search/")
        String queryText,
        @WebParam(name = "sortField", targetNamespace = "http://www.stellent.com/Search/")
        String sortField,
        @WebParam(name = "sortOrder", targetNamespace = "http://www.stellent.com/Search/")
        String sortOrder,
        @WebParam(name = "resultCount", targetNamespace = "http://www.stellent.com/Search/")
        Integer resultCount,
        @WebParam(name = "extraProps", targetNamespace = "http://www.stellent.com/Search/")
        IdcPropertyList extraProps);

    /**
     * 
     * @param endRow
     * @param extraProps
     * @param sortField
     * @param startRow
     * @param resultCount
     * @param sortOrder
     * @param pageNumber
     * @param queryText
     * @return
     *     returns com.stellent.dev.search.NavigationSearchResult
     */
    @WebMethod(operationName = "NavigationSearch", action = "http://www.stellent.com/Search/")
    @WebResult(name = "NavigationSearchResult", targetNamespace = "http://www.stellent.com/Search/")
    @RequestWrapper(localName = "NavigationSearch", targetNamespace = "http://www.stellent.com/Search/", className = "com.stellent.dev.search.NavigationSearch")
    @ResponseWrapper(localName = "NavigationSearchResponse", targetNamespace = "http://www.stellent.com/Search/", className = "com.stellent.dev.search.NavigationSearchResponse")
    public NavigationSearchResult navigationSearch(
        @WebParam(name = "queryText", targetNamespace = "http://www.stellent.com/Search/")
        String queryText,
        @WebParam(name = "sortField", targetNamespace = "http://www.stellent.com/Search/")
        String sortField,
        @WebParam(name = "sortOrder", targetNamespace = "http://www.stellent.com/Search/")
        String sortOrder,
        @WebParam(name = "resultCount", targetNamespace = "http://www.stellent.com/Search/")
        Integer resultCount,
        @WebParam(name = "pageNumber", targetNamespace = "http://www.stellent.com/Search/")
        Integer pageNumber,
        @WebParam(name = "startRow", targetNamespace = "http://www.stellent.com/Search/")
        Integer startRow,
        @WebParam(name = "endRow", targetNamespace = "http://www.stellent.com/Search/")
        Integer endRow,
        @WebParam(name = "extraProps", targetNamespace = "http://www.stellent.com/Search/")
        IdcPropertyList extraProps);

}
