package com.lab6;

public class Ointment extends Medicine{
    private double fatPercent;

    public Ointment(String title, Substance substance, int weight) {
        super(title, substance, weight);
    }
    public void setFatPercent(double fatPercent){
        this.fatPercent = fatPercent;
    }
    public double getFatPercent(){
        return fatPercent;
    }

}
