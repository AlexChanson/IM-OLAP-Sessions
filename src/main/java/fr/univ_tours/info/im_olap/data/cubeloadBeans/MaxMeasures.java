
package fr.univ_tours.info.im_olap.data.cubeloadBeans;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
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
 *       &lt;attribute name="value" type="{http://www.w3.org/2001/XMLSchema}integer" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
@XmlRootElement(name = "MaxMeasures")
@Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-05-23T01:58:24+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
public class MaxMeasures {

    @XmlAttribute(name = "value")
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-05-23T01:58:24+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    protected BigInteger value;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-05-23T01:58:24+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public BigInteger getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    @Generated(value = "com.sun.tools.internal.xjc.Driver", date = "2019-05-23T01:58:24+02:00", comments = "JAXB RI v2.2.8-b130911.1802")
    public void setValue(BigInteger value) {
        this.value = value;
    }

}
