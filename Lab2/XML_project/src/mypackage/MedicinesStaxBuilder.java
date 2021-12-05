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
    private MedicineBuilder medicineBuilder;
    public MedicinesStaxBuilder() {
        inputFactory = XMLInputFactory.newInstance();
        medicines = new HashSet<Medicine>();
        medicineBuilder = new MedicineBuilder();
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
                    medicine = medicineBuilder.buildBySTAX(medicine, currentXmlTag, reader);
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
}