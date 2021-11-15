package mypackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
public class MedicinesStaxBuilder {
    private Set<Medicine> medicines;
    private XMLInputFactory inputFactory;
    public MedicinesStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        medicines = new HashSet<Medicine>();
    }
    public Set<Medicine> getMedicines() {
        return medicines;
    }
    public void buildSetMedicines(String filename) {
        XMLStreamReader reader;
        String name;
        try(FileInputStream inputStream = new FileInputStream(new File(filename))) {
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    if (name.equals(MedicineXmlTag.MEDICINE.getValue())) {
                        Medicine medicine = buildMedicine(reader);
                        medicines.add(medicine);
                    }
                }
            }
        } catch (XMLStreamException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private Medicine buildMedicine(XMLStreamReader reader)
            throws XMLStreamException {
        Medicine medicine = new Medicine();
        medicine.setId(reader.getAttributeValue(null, MedicineXmlTag.ID.getValue()));
        // null check
        medicine.setName(reader.getAttributeValue(null,
                MedicineXmlTag.NAME.getValue()));
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            switch (type) {
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    MedicineXmlTag currentXmlTag = MedicineXmlTag.valueOf(name.toUpperCase());
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
                    break;
                case XMLStreamConstants.END_ELEMENT:
                    name = reader.getLocalName();
                    if (MedicineXmlTag.valueOf(name.toUpperCase()) == MedicineXmlTag.MEDICINE) {
                        return medicine;
                    }
            }
        }
        throw new XMLStreamException("Unknown element in tag <medicine>");
    }
    private Certificate getXMLCertificate(XMLStreamReader reader)
            throws XMLStreamException {

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

    private Package getXMLPackage(XMLStreamReader reader)
            throws XMLStreamException {

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