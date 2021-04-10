package com.lab6;

public interface MedicinalProduct {
    void addActiveSubstance(Substance substance);
    double calculateDosage();
    void changeStatusSubstance(Substance substance, Status status);
    String getInfoActiveSubstance(int activeSubstanceNum);
}
