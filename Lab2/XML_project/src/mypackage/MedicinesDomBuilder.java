package mypackage;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MedicinesDomBuilder {

    private Set<Medicine> medicines;
    private DocumentBuilder docBuilder;
    private MedicineBuilder medicineBuilder;
    public MedicinesDomBuilder() {
        medicines = new HashSet<Medicine>();
        medicineBuilder = new MedicineBuilder();
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
        return medicineBuilder.buildByDOM(medicineElement);
    }

}
