
package com.stellent.dev.docinfo;

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
@WebService(name = "DocInfoSoap", targetNamespace = "http://www.stellent.com/DocInfo/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface DocInfoSoap {


    /**
     * 
     * @param dID
     * @param extraProps
     * @return
     *     returns com.stellent.dev.docinfo.DocInfoByIDResult
     */
    @WebMethod(operationName = "DocInfoByID", action = "http://www.stellent.com/DocInfo/")
    @WebResult(name = "DocInfoByIDResult", targetNamespace = "http://www.stellent.com/DocInfo/")
    @RequestWrapper(localName = "DocInfoByID", targetNamespace = "http://www.stellent.com/DocInfo/", className = "com.stellent.dev.docinfo.DocInfoByID")
    @ResponseWrapper(localName = "DocInfoByIDResponse", targetNamespace = "http://www.stellent.com/DocInfo/", className = "com.stellent.dev.docinfo.DocInfoByIDResponse")
    public DocInfoByIDResult docInfoByID(
        @WebParam(name = "dID", targetNamespace = "http://www.stellent.com/DocInfo/")
        Integer dID,
        @WebParam(name = "extraProps", targetNamespace = "http://www.stellent.com/DocInfo/")
        IdcPropertyList extraProps);

    /**
     * 
     * @param extraProps
     * @param dDocName
     * @return
     *     returns com.stellent.dev.docinfo.DocInfoByNameResult
     */
    @WebMethod(operationName = "DocInfoByName", action = "http://www.stellent.com/DocInfo/")
    @WebResult(name = "DocInfoByNameResult", targetNamespace = "http://www.stellent.com/DocInfo/")
    @RequestWrapper(localName = "DocInfoByName", targetNamespace = "http://www.stellent.com/DocInfo/", className = "com.stellent.dev.docinfo.DocInfoByName")
    @ResponseWrapper(localName = "DocInfoByNameResponse", targetNamespace = "http://www.stellent.com/DocInfo/", className = "com.stellent.dev.docinfo.DocInfoByNameResponse")
    public DocInfoByNameResult docInfoByName(
        @WebParam(name = "dDocName", targetNamespace = "http://www.stellent.com/DocInfo/")
        String dDocName,
        @WebParam(name = "extraProps", targetNamespace = "http://www.stellent.com/DocInfo/")
        IdcPropertyList extraProps);

}