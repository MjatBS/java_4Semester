package com.lab6;

import java.util.ArrayList;

public class Medicine implements  MedicinalProduct{
    private String title;
    private ArrayList<Substance> activeSubstances;
    private int weight;

    public Medicine(String title, Substance substance,  int weight){
        this.title = title;
        this.weight = weight;
        activeSubstances = new ArrayList();
        addActiveSubstance(substance);
    }

    @Override
    public void addActiveSubstance(Substance substance) {
        activeSubstances.add(substance);
    }
    public void deleteActiveSubstance(Substance substance){
        if(substance!=null)activeSubstances.remove(substance);
    }

    @Override
    public double calculateDosage() {
        if(activeSubstances.isEmpty() || weight==0) return -1;
        else return (activeSubstances.get(0).getWeight()) / weight;
    }

    @Override
    public void changeStatusSubstance(Substance substance, Status status) {
        substance.setStatus(status);
    }

    @Override
    public String getInfoActiveSubstance(int activeSubstanceNum) {
        if((activeSubstances.size() - 1) >= activeSubstanceNum) {
            return activeSubstances.get(activeSubstanceNum).toString();
        }else return "Substance not found";
    }

    public String getTitle() {
        return title;
    }

    public ArrayList<Substance> getActiveSubstances() {
        ArrayList<Substance> subs = new ArrayList<>();
        for(Substance sub: activeSubstances){
            subs.add(sub.clone());
        }
        return subs;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString(){
        return title;
    }
}
