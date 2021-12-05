package mypackage;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class MedicineBuilder {

    public Medicine buildBySAX(Medicine current, String data, MedicineXmlTag currentXmlTag) {
        if (currentXmlTag != null) {
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
            } else if (currentXmlTag.getValue() == "Number")
                current.getCertificate().setNumber(Integer.parseInt(data));
            else if (currentXmlTag.getValue() == "ExpireDate")
                current.getCertificate().setExpireDate(data);
            else if (currentXmlTag.getValue() == "RegisteringOrganization")
                current.getCertificate().setRegisteringOrganization(data);
            else if (currentXmlTag.getValue() == "Package") {
                if (current.getPackage() == null)
                    current.setPackage(new Package());
            } else if (currentXmlTag.getValue() == "TypeOfPackaging")
                current.getPackage().setTypeOfPackaging(data);
            else if (currentXmlTag.getValue() == "AmountInPackage")
                current.getPackage().setAmountInPackage(Integer.parseInt(data));
            else if (currentXmlTag.getValue() == "Price")
                current.getPackage().setPrice(Double.parseDouble(data));
            else if (currentXmlTag.getValue() == "Dosage") {
                if (current.getDosage() == null)
                    current.setDosage(new Dosage());
            } else if (currentXmlTag.getValue() == "DrugDosage")
                current.getDosage().setDrugDosage(data);
            else if (currentXmlTag.getValue() == "FrequencyOfAdmission")
                current.getDosage().setFrequencyOfAdmission(data);
            else {
                throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        }

        return current;
    }

    public Medicine buildByDOM(Element medicineElement) {
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

    public Medicine buildBySTAX(Medicine medicine, MedicineXmlTag currentXmlTag, XMLStreamReader reader) {
        try {
            if (currentXmlTag.getValue() == "id")
                medicine.setId(getXMLText(reader));
            else if (currentXmlTag.getValue() == "Name")
                medicine.setName(getXMLText(reader));
            else if (currentXmlTag.getValue() == "Pharm")
                medicine.setPharm(getXMLText(reader));
            else if (currentXmlTag.getValue() == "Group")
                medicine.setGroup(getXMLText(reader));
            else if (currentXmlTag.getValue() == "Analogs")
                medicine.getAnalogs().add(getXMLText(reader));
            else if (currentXmlTag.getValue() == "Versions")
                medicine.setVersions(getXMLText(reader));
            else if (currentXmlTag.getValue() == "Certificate")
                medicine.setCertificate(getXMLCertificate(reader));
            else if (currentXmlTag.getValue() == "Package")
                medicine.setPackage(getXMLPackage(reader));
            else if (currentXmlTag.getValue() == "Dosage")
                medicine.setDosage(getXMLDosage(reader));
            else {
                throw new EnumConstantNotPresentException(currentXmlTag.getDeclaringClass(), currentXmlTag.name());
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        return medicine;
    }
    private Certificate getXMLCertificate(XMLStreamReader reader) throws XMLStreamException {

        Certificate certificate = new Certificate();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    MedicineXmlTag currentXmlTag = MedicineXmlTag.valueOf(name.toUpperCase());
                    if (currentXmlTag.getValue() == "Number")
                        certificate.setNumber(Integer.parseInt(getXMLText(reader)));
                    else if (currentXmlTag.getValue() == "ExpireDate")
                        certificate.setExpireDate(getXMLText(reader));
                    else if (currentXmlTag.getValue() == "RegisteringOrganization")
                        certificate.setRegisteringOrganization(getXMLText(reader));
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.CERTIFICATE) {
                        return certificate;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <address>");
    }

    private Package getXMLPackage(XMLStreamReader reader) throws XMLStreamException {
        Package package_ = new Package();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    MedicineXmlTag currentXmlTag = MedicineXmlTag.valueOf(name.toUpperCase());
                    if (currentXmlTag.getValue() == "TypeOfPackaging")
                        package_.setTypeOfPackaging(getXMLText(reader));
                    else if (currentXmlTag.getValue() == "AmountInPackage")
                        package_.setAmountInPackage(Integer.parseInt(getXMLText(reader)));
                    else if (currentXmlTag.getValue() == "Price")
                        package_.setPrice(Double.parseDouble(getXMLText(reader)));
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.PACKAGE) {
                        return package_;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <address>");
    }

    private Dosage getXMLDosage(XMLStreamReader reader)
            throws XMLStreamException {

        Dosage dosage = new Dosage();
        int type;
        String name;

        while (reader.hasNext()) {
            type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    MedicineXmlTag currentXmlTag = MedicineXmlTag.valueOf(name.toUpperCase());
                    if (currentXmlTag.getValue() == "DrugDosage")
                        dosage.setDrugDosage(getXMLText(reader));
                    else if (currentXmlTag.getValue() == "FrequencyOfAdmission")
                        dosage.setFrequencyOfAdmission(getXMLText(reader));
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.DOSAGE) {
                        return dosage;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <address>");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
