package com.lab6;

public class Solution implements  MedicinalProduct{
    private Substance activeSubstance;
    private double solutionPercent;
    private double weight;

    public Solution(Substance activeSubstance, double weight) {
        this.activeSubstance = activeSubstance;
        this.weight = weight;
        solutionPercent = calculateDosage();
    }

    @Override
    public void addActiveSubstance(Substance substance) {
        activeSubstance = substance;
    }

    @Override
    public double calculateDosage() {
        if(weight!=0) return (activeSubstance.getWeight()) / weight;
        else return -1;
    }

    @Override
    public void changeStatusSubstance(Substance substance, Status status) {
        substance.setStatus(status);
    }

    @Override
    public String getInfoActiveSubstance(int activeSubstanceNum) {
        return activeSubstance.toString() + ", percent is"+calculateDosage();
    }

    public Substance getActiveSubstance() {
        return activeSubstance.clone();
    }

    public double getSolutionPercent() {
        return solutionPercent;
    }

    public double getWeight() {
        return weight;
    }

    @Override
    public String toString(){
        return (activeSubstance.getName() + "  " + calculateDosage());
    }
}
