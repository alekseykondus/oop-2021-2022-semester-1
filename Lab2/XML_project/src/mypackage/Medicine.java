
package mypackage;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * <p>Java class for Medicine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Medicine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}ID">
 *               &lt;pattern value="[0-9][0-9][0-9]"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Pharm" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="Group">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Antibiotics"/>
 *               &lt;enumeration value="Sedative"/>
 *               &lt;enumeration value="Vitamins"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Analogs" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="100"/>
 *         &lt;element name="Versions">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="Pills"/>
 *               &lt;enumeration value="Capsules"/>
 *               &lt;enumeration value="Powder"/>
 *               &lt;enumeration value="Drops"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Certificate" type="{http://www.example.org/Medicine}certificate"/>
 *         &lt;element name="Package" type="{http://www.example.org/Medicine}package"/>
 *         &lt;element name="Dosage" type="{http://www.example.org/Medicine}dosage"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Medicine", namespace = "http://www.example.org/Medicine", propOrder = {
    "id",
    "name",
    "pharm",
    "group",
    "analogs",
    "versions",
    "certificate",
    "_package",
    "dosage"
})
public class Medicine {

    @XmlElement(namespace = "http://www.example.org/Medicine", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    protected String id;
    @XmlElement(name = "Name", namespace = "http://www.example.org/Medicine", required = true)
    protected String name;
    @XmlElement(name = "Pharm", namespace = "http://www.example.org/Medicine", required = true)
    protected String pharm;
    @XmlElement(name = "Group", namespace = "http://www.example.org/Medicine", required = true)
    protected String group;
    @XmlElement(name = "Analogs", namespace = "http://www.example.org/Medicine", required = true)
    protected List<String> analogs;
    @XmlElement(name = "Versions", namespace = "http://www.example.org/Medicine", required = true)
    protected String versions;
    @XmlElement(name = "Certificate", namespace = "http://www.example.org/Medicine", required = true)
    protected Certificate certificate;
    @XmlElement(name = "Package", namespace = "http://www.example.org/Medicine", required = true)
    protected Package _package;
    @XmlElement(name = "Dosage", namespace = "http://www.example.org/Medicine", required = true)
    protected Dosage dosage;

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setId(String value) {
        this.id = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the pharm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPharm() {
        return pharm;
    }

    /**
     * Sets the value of the pharm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPharm(String value) {
        this.pharm = value;
    }

    /**
     * Gets the value of the group property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGroup() {
        return group;
    }

    /**
     * Sets the value of the group property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGroup(String value) {
        this.group = value;
    }

    /**
     * Gets the value of the analogs property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the analogs property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAnalogs().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getAnalogs() {
        if (analogs == null) {
            analogs = new ArrayList<String>();
        }
        return this.analogs;
    }

    /**
     * Gets the value of the versions property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersions() {
        return versions;
    }

    /**
     * Sets the value of the versions property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersions(String value) {
        this.versions = value;
    }

    /**
     * Gets the value of the certificate property.
     * 
     * @return
     *     possible object is
     *     {@link Certificate }
     *     
     */
    public Certificate getCertificate() {
        return certificate;
    }

    /**
     * Sets the value of the certificate property.
     * 
     * @param value
     *     allowed object is
     *     {@link Certificate }
     *     
     */
    public void setCertificate(Certificate value) {
        this.certificate = value;
    }

    /**
     * Gets the value of the package property.
     * 
     * @return
     *     possible object is
     *     {@link Package }
     *     
     */
    public Package getPackage() {
        return _package;
    }

    /**
     * Sets the value of the package property.
     * 
     * @param value
     *     allowed object is
     *     {@link Package }
     *     
     */
    public void setPackage(Package value) {
        this._package = value;
    }

    /**
     * Gets the value of the dosage property.
     * 
     * @return
     *     possible object is
     *     {@link Dosage }
     *     
     */
    public Dosage getDosage() {
        return dosage;
    }

    /**
     * Sets the value of the dosage property.
     * 
     * @param value
     *     allowed object is
     *     {@link Dosage }
     *     
     */
    public void setDosage(Dosage value) {
        this.dosage = value;
    }
    /**
     * Comparator class to compare Medicines
     *
     * @author  Oleksii Kondus
     */
    public static class IdComparator implements Comparator<Medicine> {
        /** compares Medicines by id
         *
         * @param medicine1 lhs Medicine
         * @param medicine1 rhs Medicine
         * @return int result of Medicines id comparison
         */
        @Override
        public int compare(Medicine medicine1, Medicine medicine2) {
            return medicine1.getId().compareTo(medicine2.getId());
        }
    }

}
