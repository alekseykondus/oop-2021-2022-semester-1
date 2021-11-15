package mypackage;
import java.util.HashSet;
import java.util.Set;
/*
public class MedicineBuilderFactory {

    private enum TypeParser {
        SAX, STAX, DOM
    }
    private MedicineBuilderFactory() {
    }
    public static AbstractMedicinesBuilder createMedicineBuilder(String typeParser) {
        // insert parser name validation
        TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
        switch (type) {
            case DOM -> {
                return new MedicinesDomBuilder();
            }
            case STAX -> {
                return new MedicinesStaxBuilder();
            }
            case SAX -> {
                return new MedicinesSaxBuilder();
            }
            default -> throw new EnumConstantNotPresentException(
                    type.getDeclaringClass(), type.name());
        }
    }
}
public class MedicinesSaxBuilder extends AbstractMedicinesBuilder {
    private MedicineHandler handler;
    private XMLReader reader;

    public MedicinesSaxBuilder() { // more code
    }

    public MedicinesSaxBuilder(Set<Medicine> medicines) {
        super(medicines);
        // more code
    }

    @Override
    public void buildSetStudents(String fileName) {
        // more code
    }
    // private methods
}

public class StudentsDomBuilder extends AbstractStudentsBuilder {
    private DocumentBuilder docBuilder;
    public StudentsDomBuilder() {
        // more code
    }
    public StudentsDomBuilder(Set<Student> students) {
        super(students);
        // more code
    }
    @Override
    public void buildSetStudents(String fileName) {
        // more code
    }
    // private methods
}
public class StudentsStaxBuilder extends AbstractStudentsBuilder {
    private XMLInputFactory inputFactory;
    public StudentsStaxBuilder() {
        // more code
    }
    public StudentsStaxBuilder(Set<Student> students) {
        super(students);
        // more code
    }
    @Override
    public void buildSetStudents(String fileName) {
        // more code
    }
    // private methods
}
 */
