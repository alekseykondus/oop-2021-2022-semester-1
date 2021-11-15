package mypackage;

public enum MedicineXmlTag {
    MEDICINES("Medicines"),
    ID("id"),
    NAME("Name"),
    MEDICINE("Medicine"),
    PHARM("Pharm"),
    GROUP("Group"),
    ANALOGS("Analogs"),
    VERSIONS("Versions"),

    CERTIFICATE("Certificate"),
    NUMBER("Number"),
    EXPIREDATE("ExpireDate"),
    REGISTERINGORGANIZATION("RegisteringOrganization"),

    PACKAGE("Package"),
    TYPEOFPACKAGING("TypeOfPackaging"),
    AMOUNTINPACKAGE("AmountInPackage"),
    PRICE("Price"),

    DOSAGE("Dosage"),
    DRUGDOSAGE("DrugDosage"),
    FREQUENCYOFADMISSION("FrequencyOfAdmission");

    private String value;
    MedicineXmlTag(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}
