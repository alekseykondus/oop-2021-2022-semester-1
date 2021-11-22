package tests;

import mypackage.Medicine;
import mypackage.MedicinesDomBuilder;
import mypackage.MedicinesSaxBuilder;
import mypackage.MedicinesStaxBuilder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


public class ParsersTests {
    private MedicinesDomBuilder domBuilder;
    private MedicinesSaxBuilder saxBuilder;
    private MedicinesStaxBuilder staxBuilder;

    @BeforeEach
    void setUp() {
        domBuilder = new MedicinesDomBuilder();
        saxBuilder = new MedicinesSaxBuilder();
        staxBuilder = new MedicinesStaxBuilder();
    }

    @Test
    void TestStaxBuilder() {
        try {
            staxBuilder.buildSetMedicines("resourses/medicines.xml");
            Set<Medicine> medicines = staxBuilder.getMedicines();
            Medicine medicine2 = staxBuilder.getMedicines().iterator().next();
            if (medicine2.getId() == "2") {
                assertEquals("2", medicine2.getId());
                assertEquals("Preparate_2", medicine2.getName());
                assertEquals("Pharm_1", medicine2.getPharm());
                assertEquals("Sedative", medicine2.getGroup());
                assertEquals("Analogs_2_1", medicine2.getAnalogs().get(0));
                assertEquals("Analogs_2_2", medicine2.getAnalogs().get(1));
                assertEquals(42524, medicine2.getCertificate().getNumber());
                assertEquals("12.11.23", medicine2.getCertificate().getExpireDate());
                assertEquals("RegisteringOrganization_2", medicine2.getCertificate().getRegisteringOrganization());
                assertEquals("Glass", medicine2.getPackage().getTypeOfPackaging());
                assertEquals(158, medicine2.getPackage().getAmountInPackage());
                assertEquals(12.25, medicine2.getPackage().getPrice());
                assertEquals("DrugDosage1", medicine2.getDosage().getDrugDosage());
                assertEquals("FrequencyOfAdmission1", medicine2.getDosage().getFrequencyOfAdmission());
            }
        } catch(Exception e) {
            fail();
        }
    }

    @Test
    void TestDomBuilder() {
        try {
            domBuilder.buildSetMedicines("resourses/medicines.xml");
            Set<Medicine> medicines = domBuilder.getMedicines();
            Medicine medicine2 = domBuilder.getMedicines().iterator().next();
            if (medicine2.getId() == "2") {
                assertEquals("2", medicine2.getId());
                assertEquals("Preparate_2", medicine2.getName());
                assertEquals("Pharm_1", medicine2.getPharm());
                assertEquals("Sedative", medicine2.getGroup());
                assertEquals("Analogs_2_1", medicine2.getAnalogs().get(0));
                assertEquals("Analogs_2_2", medicine2.getAnalogs().get(1));
                assertEquals(42524, medicine2.getCertificate().getNumber());
                assertEquals("12.11.23", medicine2.getCertificate().getExpireDate());
                assertEquals("RegisteringOrganization_2", medicine2.getCertificate().getRegisteringOrganization());
                assertEquals("Glass", medicine2.getPackage().getTypeOfPackaging());
                assertEquals(158, medicine2.getPackage().getAmountInPackage());
                assertEquals(12.25, medicine2.getPackage().getPrice());
                assertEquals("DrugDosage1", medicine2.getDosage().getDrugDosage());
                assertEquals("FrequencyOfAdmission1", medicine2.getDosage().getFrequencyOfAdmission());
            }
        } catch(Exception e) {
            fail();
        }
    }

    @Test
    void TestSaxBuilder() {
        try {
            saxBuilder.buildSetMedicines("resourses/medicines.xml");
            Set<Medicine> medicines = saxBuilder.getMedicines();
            Medicine medicine2 = saxBuilder.getMedicines().iterator().next();
            if (medicine2.getId() == "2") {
                assertEquals("2", medicine2.getId());
                assertEquals("Preparate_2", medicine2.getName());
                assertEquals("Pharm_1", medicine2.getPharm());
                assertEquals("Sedative", medicine2.getGroup());
                assertEquals("Analogs_2_1", medicine2.getAnalogs().get(0));
                assertEquals("Analogs_2_2", medicine2.getAnalogs().get(1));
                assertEquals(42524, medicine2.getCertificate().getNumber());
                assertEquals("12.11.23", medicine2.getCertificate().getExpireDate());
                assertEquals("RegisteringOrganization_2", medicine2.getCertificate().getRegisteringOrganization());
                assertEquals("Glass", medicine2.getPackage().getTypeOfPackaging());
                assertEquals(158, medicine2.getPackage().getAmountInPackage());
                assertEquals(12.25, medicine2.getPackage().getPrice());
                assertEquals("DrugDosage1", medicine2.getDosage().getDrugDosage());
                assertEquals("FrequencyOfAdmission1", medicine2.getDosage().getFrequencyOfAdmission());
            }
        } catch(Exception e) {
            fail();
        }
    }
}
