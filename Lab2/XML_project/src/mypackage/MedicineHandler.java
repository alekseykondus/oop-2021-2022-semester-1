package mypackage;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class MedicineHandler extends DefaultHandler{
    private Set<Medicine> medicines;
    private Medicine current;
    private MedicineXmlTag currentXmlTag;
    private EnumSet<MedicineXmlTag> withText;
    private static final String ELEMENT_MEDICINE = "Medicine";
    public MedicineHandler() {
        medicines = new HashSet<Medicine>();
        withText = EnumSet.range(MedicineXmlTag.ID, MedicineXmlTag.FREQUENCYOFADMISSION);
    }
    public Set<Medicine> getMedinides() {
        return medicines;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_MEDICINE.equals(qName)) {
            current = new Medicine();
//            current.setId(attrs.getValue(0));
//            if (attrs.getLength() == 2) { // warning!!!!
//                current.setName(attrs.getValue(1));
//            }
        } else {
            MedicineXmlTag temp = MedicineXmlTag.valueOf(qName.toUpperCase());
            if (withText.contains(temp)) {
                currentXmlTag = temp;
            }
        }
    }
    public void endElement(String uri, String localName, String qName) {
        if (ELEMENT_MEDICINE.equals(qName)) {
            medicines.add(current);
        }
    }
    public void characters(char[] ch, int start, int length) {
        String data = new String(ch, start, length).trim();

        if (currentXmlTag!= null) {
            if (currentXmlTag.getValue() == "id")
                current.setId(data);
            else if (currentXmlTag.getValue() == "Name")
                current.setName(data);
            else if (currentXmlTag.getValue() == "Pharm")
                current.setPharm(data);
            else if (currentXmlTag.getValue() == "Group")
                current.setGroup(data);
            else if (currentXmlTag.getValue() == "Analogs")
                current.getAnalogs().add(data);
            else if (currentXmlTag.getValue() == "Versions")
                current.setVersions(data);
            else if (currentXmlTag.getValue() == "Certificate") {
                if (current.getCertificate() == null)
                    current.setCertificate(new Certificate());
            }
            else if (currentXmlTag.getValue() == "Number")
                current.getCertificate().setNumber(Integer.parseInt(data));
            else if (currentXmlTag.getValue() == "ExpireDate")
                current.getCertificate().setExpireDate(data);
            else if (currentXmlTag.getValue() == "RegisteringOrganization")
                current.getCertificate().setRegisteringOrganization(data);
            else if (currentXmlTag.getValue() == "Package") {
                if (current.getPackage() == null)
                    current.setPackage(new Package());
            }
            else if (currentXmlTag.getValue() == "TypeOfPackaging")
                current.getPackage().setTypeOfPackaging(data);
            else if (currentXmlTag.getValue() == "AmountInPackage")
                current.getPackage().setAmountInPackage(Integer.parseInt(data));
            else if (currentXmlTag.getValue() == "Price")
                current.getPackage().setPrice(Double.parseDouble(data));
            else if (currentXmlTag.getValue() == "Dosage") {
                if (current.getDosage() == null)
                    current.setDosage(new Dosage());
            }
            else if (currentXmlTag.getValue() == "DrugDosage")
                current.getDosage().setDrugDosage(data);
            else if (currentXmlTag.getValue() == "FrequencyOfAdmission")
                current.getDosage().setFrequencyOfAdmission(data);
            else {
                throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }
        currentXmlTag = null;
    }
}
