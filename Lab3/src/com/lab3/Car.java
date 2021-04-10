package com.lab3;

public class Car {
    private final int id;
    private final String brand;
    private final String model;
    private final int yearOfCreator;
    private String color="#000000";
    private double price=0;
    private int registrationNumber=-1;

    Car(int id,String brand, String model,int yearOfCreator,String color, double price, int registrationNumber){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfCreator = yearOfCreator;
        setColor(color);
        setPrice(price);
        setRegistrationNumber(registrationNumber);
    }
    Car(int id,String brand, String model,int yearOfCreator){
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.yearOfCreator = yearOfCreator;
    }

    public int getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfCreator() {
        return yearOfCreator;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public int getRegistrationNumber() {
        return registrationNumber;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRegistrationNumber(int registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "" + id + "  " + brand + "  " + model + "  " + yearOfCreator + "  " + price;
    }
}
