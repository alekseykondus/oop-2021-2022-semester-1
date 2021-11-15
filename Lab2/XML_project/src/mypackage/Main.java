package mypackage;

import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {

//        printXMLFile("resourses/medicines.xml");
        MedicinesDomBuilder domBuilder = new MedicinesDomBuilder();
        domBuilder.buildSetMedicines("resourses/medicines.xml");
        System.out.println(domBuilder.getMedicines());

        MedicinesSaxBuilder saxBuilder = new MedicinesSaxBuilder();
        saxBuilder.buildSetMedicines("resourses/medicines.xml");
        System.out.println(saxBuilder.getMedicines());

        MedicinesStaxBuilder staxBuilder = new MedicinesStaxBuilder();
        staxBuilder.buildSetMedicines("resourses/medicines.xml");
        System.out.println(staxBuilder.getMedicines());
    }

    public static void printXMLFile (String name) {
        try {
            // SAX parser creating & configuring
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(new ConsoleMedicineHandler());
            //reader.setErrorHandler(new StudentErrorHandler());
            reader.parse(name);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
