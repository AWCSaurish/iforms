//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.02.23 at 05:37:07 PM IST 
//


package ebig.oracle.cloud.integration.ReportService;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="updateXLIFFForReportInSessionReturn" type="{http://www.w3.org/2001/XMLSchema}boolean"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "updateXLIFFForReportInSessionReturn"
})
@XmlRootElement(name = "updateXLIFFForReportInSessionResponse")
public class UpdateXLIFFForReportInSessionResponse {

    protected boolean updateXLIFFForReportInSessionReturn;

    /**
     * Gets the value of the updateXLIFFForReportInSessionReturn property.
     * 
     */
    public boolean isUpdateXLIFFForReportInSessionReturn() {
        return updateXLIFFForReportInSessionReturn;
    }

    /**
     * Sets the value of the updateXLIFFForReportInSessionReturn property.
     * 
     */
    public void setUpdateXLIFFForReportInSessionReturn(boolean value) {
        this.updateXLIFFForReportInSessionReturn = value;
    }

}
