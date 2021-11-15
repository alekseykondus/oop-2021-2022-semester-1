
package mypackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for package complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="package">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="TypeOfPackaging">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Paper"/>
 *               &lt;enumeration value="Polyethylene"/>
 *               &lt;enumeration value="Glass"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="AmountInPackage" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="Price" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "package", namespace = "http://www.example.org/Medicine", propOrder = {
    "typeOfPackaging",
    "amountInPackage",
    "price"
})
public class Package {

    @XmlElement(name = "TypeOfPackaging", namespace = "http://www.example.org/Medicine", required = true)
    protected String typeOfPackaging;
    @XmlElement(name = "AmountInPackage", namespace = "http://www.example.org/Medicine")
    protected int amountInPackage;
    @XmlElement(name = "Price", namespace = "http://www.example.org/Medicine")
    protected double price;

    /**
     * Gets the value of the typeOfPackaging property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOfPackaging() {
        return typeOfPackaging;
    }

    /**
     * Sets the value of the typeOfPackaging property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOfPackaging(String value) {
        this.typeOfPackaging = value;
    }

    /**
     * Gets the value of the amountInPackage property.
     * 
     */
    public int getAmountInPackage() {
        return amountInPackage;
    }

    /**
     * Sets the value of the amountInPackage property.
     * 
     */
    public void setAmountInPackage(int value) {
        this.amountInPackage = value;
    }

    /**
     * Gets the value of the price property.
     * 
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     * 
     */
    public void setPrice(double value) {
        this.price = value;
    }

}
