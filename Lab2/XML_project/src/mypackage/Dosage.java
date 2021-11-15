
package mypackage;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dosage complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dosage">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DrugDosage" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="FrequencyOfAdmission" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dosage", namespace = "http://www.example.org/Medicine", propOrder = {
    "drugDosage",
    "frequencyOfAdmission"
})
public class Dosage {

    @XmlElement(name = "DrugDosage", namespace = "http://www.example.org/Medicine", required = true)
    protected String drugDosage;
    @XmlElement(name = "FrequencyOfAdmission", namespace = "http://www.example.org/Medicine", required = true)
    protected String frequencyOfAdmission;

    /**
     * Gets the value of the drugDosage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrugDosage() {
        return drugDosage;
    }

    /**
     * Sets the value of the drugDosage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrugDosage(String value) {
        this.drugDosage = value;
    }

    /**
     * Gets the value of the frequencyOfAdmission property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFrequencyOfAdmission() {
        return frequencyOfAdmission;
    }

    /**
     * Sets the value of the frequencyOfAdmission property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFrequencyOfAdmission(String value) {
        this.frequencyOfAdmission = value;
    }

}
