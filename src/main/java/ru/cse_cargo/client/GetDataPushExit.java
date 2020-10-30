
package ru.cse_cargo.client;

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
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="InParametrs" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
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
    "inParametrs"
})
@XmlRootElement(name = "GetDataPushExit")
public class GetDataPushExit {

    @XmlElement(name = "InParametrs", required = true, nillable = true)
    protected String inParametrs;

    /**
     * Gets the value of the inParametrs property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInParametrs() {
        return inParametrs;
    }

    /**
     * Sets the value of the inParametrs property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInParametrs(String value) {
        this.inParametrs = value;
    }

}
