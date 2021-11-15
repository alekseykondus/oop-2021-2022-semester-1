package mypackage;

import java.util.HashSet;
import java.util.Set;
public abstract class AbstractMedicinesBuilder {
    // protected - it is often accessed from a subclass
    protected Set<Medicine> medicines;
    public AbstractMedicinesBuilder() {
        medicines = new HashSet<Medicine>();
    }
    public AbstractMedicinesBuilder(Set<Medicine> medicines) {
        this.medicines = medicines;
    }
    public Set<Medicine> getMedicines() {
        return medicines;
    }
    public abstract void buildSetMedicines(String filename);
}
