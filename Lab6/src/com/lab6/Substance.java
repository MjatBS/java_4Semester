package com.lab6;

public class Substance {
    private String name;
    private Status status;
    private double weight;
    Substance(String name){
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public double getWeight() {
        return weight;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return (name + ", status: "+status+", weight:"+weight);
    }

    @Override
    public Substance clone(){
        Substance sub = new Substance(name);
        sub.status = status;
        sub.weight = weight;
        return sub;
    }
}
