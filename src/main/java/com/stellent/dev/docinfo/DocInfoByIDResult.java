
package com.stellent.dev.docinfo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DocInfoByIDResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DocInfoByIDResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ContentInfo" type="{http://www.stellent.com/DocInfo/}ContentInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="Revisions" type="{http://www.stellent.com/DocInfo/}Revisions" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="WorkflowInfo" type="{http://www.stellent.com/DocInfo/}WorkflowInfo" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="StatusInfo" type="{http://www.stellent.com/DocInfo/}StatusInfo" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DocInfoByIDResult", propOrder = {
    "contentInfo",
    "revisions",
    "workflowInfo",
    "statusInfo"
})
public class DocInfoByIDResult {

    @XmlElement(name = "ContentInfo")
    protected List<ContentInfo> contentInfo;
    @XmlElement(name = "Revisions")
    protected List<Revisions> revisions;
    @XmlElement(name = "WorkflowInfo")
    protected List<WorkflowInfo> workflowInfo;
    @XmlElement(name = "StatusInfo")
    protected StatusInfo statusInfo;

    /**
     * Gets the value of the contentInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentInfo }
     * 
     * 
     */
    public List<ContentInfo> getContentInfo() {
        if (contentInfo == null) {
            contentInfo = new ArrayList<ContentInfo>();
        }
        return this.contentInfo;
    }

    /**
     * Gets the value of the revisions property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the revisions property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRevisions().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Revisions }
     * 
     * 
     */
    public List<Revisions> getRevisions() {
        if (revisions == null) {
            revisions = new ArrayList<Revisions>();
        }
        return this.revisions;
    }

    /**
     * Gets the value of the workflowInfo property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the workflowInfo property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getWorkflowInfo().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link WorkflowInfo }
     * 
     * 
     */
    public List<WorkflowInfo> getWorkflowInfo() {
        if (workflowInfo == null) {
            workflowInfo = new ArrayList<WorkflowInfo>();
        }
        return this.workflowInfo;
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
