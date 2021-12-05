package mypackage;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class MedicineHandler extends DefaultHandler{
    private Set<Medicine> medicines;
    private Medicine current;
    private MedicineBuilder medicineBuilder;
    private MedicineXmlTag currentXmlTag;
    private EnumSet<MedicineXmlTag> withText;
    private static final String ELEMENT_MEDICINE = "Medicine";
    public MedicineHandler() {
        medicines = new HashSet<Medicine>();
        medicineBuilder = new MedicineBuilder();
        withText = EnumSet.range(MedicineXmlTag.ID, MedicineXmlTag.FREQUENCYOFADMISSION);
    }
    public Set<Medicine> getMedinides() {
        return medicines;
    }
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        if (ELEMENT_MEDICINE.equals(qName)) {
            current = new Medicine();
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
        current = medicineBuilder.buildBySAX(current, data, currentXmlTag);
        currentXmlTag = null;
    }
}
