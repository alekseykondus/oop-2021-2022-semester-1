package mypackage;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MedicinesDomBuilder {

    private Set<Medicine> medicines;
    private DocumentBuilder docBuilder;
    public MedicinesDomBuilder() {
        medicines = new HashSet<Medicine>();
        // configuration
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace(); // log
        }
    }
    public Set<Medicine> getMedicines() {
        return medicines;
    }
    public void buildSetMedicines(String filename) {
        Document doc;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            // getting a list of <medicine> child elements
            NodeList medicinesList = root.getElementsByTagName("Medicine");
            for (int i = 0; i < medicinesList.getLength(); i++) {
                Element medicineElement = (Element) medicinesList.item(i);
                Medicine medicine = buildMedicine(medicineElement);
                medicines.add(medicine);
            }
        } catch (IOException | SAXException e) {
            e.printStackTrace(); // log
        }
    }
    private Medicine buildMedicine(Element medicineElement) {
        Medicine medicine = new Medicine();
        // add null check
        medicine.setId(getElementTextContent(medicineElement, "id"));
        medicine.setName(getElementTextContent(medicineElement, "Name"));
        medicine.setPharm(getElementTextContent(medicineElement, "Pharm"));
        medicine.setGroup(getElementTextContent(medicineElement, "Group"));

        NodeList analogsList = medicineElement.getElementsByTagName("Analogs");
        for (int i = 0; i < analogsList.getLength(); i++) {
            Element medicineElementList = (Element) analogsList.item(i);
            medicine.getAnalogs().add(medicineElementList.getTextContent());
        }
        medicine.setVersions(getElementTextContent(medicineElement, "Versions"));

        Certificate certificate = new Certificate();
        Integer number = Integer.parseInt(getElementTextContent(medicineElement, "Number"));
        certificate.setNumber(number);
        certificate.setExpireDate(getElementTextContent(medicineElement, "ExpireDate"));
        certificate.setRegisteringOrganization(getElementTextContent(medicineElement, "RegisteringOrganization"));
        medicine.setCertificate(certificate);

        Package package_ = new Package();
        package_.setTypeOfPackaging(getElementTextContent(medicineElement, "TypeOfPackaging"));
        Integer amountInPackage = Integer.parseInt(getElementTextContent(medicineElement, "AmountInPackage"));
        package_.setAmountInPackage(amountInPackage);
        Double price = Double.parseDouble(getElementTextContent(medicineElement, "Price"));
        package_.setPrice(price);
        medicine.setPackage(package_);

        Dosage dosage = new Dosage();
        dosage.setDrugDosage(getElementTextContent(medicineElement, "DrugDosage"));
        dosage.setFrequencyOfAdmission(getElementTextContent(medicineElement, "FrequencyOfAdmission"));
        medicine.setDosage(dosage);

        return medicine;
    }
    // get the text content of the tag
    private static String getElementTextContent(Element element, String elementName) {
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;
    }
}
