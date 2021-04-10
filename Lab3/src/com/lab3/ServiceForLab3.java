package com.lab3;

public class ServiceForLab3 {
    Car[] cars;

    private static ServiceForLab3 instance;
    public static ServiceForLab3 getInstance(){
        if(instance==null) instance = new ServiceForLab3();
        return instance;
    }
    ServiceForLab3(){
        System.out.println("working");
        cars = init();


    }
    private Car[] init(){
        int size = 8;

        int [] ids = { 256987, 478569, 123654, 558965, 412036, 896789, 145899, 478544};
        String [] brands = {"BMV", "Toyota", "BMV", "Subaru", "Toyota", "BMV", "Subaru", "Subaru"};
        String [] models = {"v1","v2","v3","v1","v1","v3","v1","v2"};
        int [] yearOfCreated = {2001, 1985, 2012, 2011, 1999, 2001, 2005, 2021};
        double [] prices = {12, 14 , 18, 11, 15, 25, 9, 17};

        Car [] cars = new Car[size];
        for(int i=0;i<size;i++){
            cars[i] = new Car(ids[i],brands[i],models[i],yearOfCreated[i]);
            cars[i].setPrice(prices[i]);
        }
        return cars;
    }

    public void ex1(String brand){
        for(Car car : cars){
            if(brand.equals(car.getBrand())){
                System.out.println(car.toString());
            }
        }
    }
    public void ex2(String model, int olderThen){
        for(Car car : cars){
            if(model.equals(car.getModel()) &&
                    ((2021 - car.getYearOfCreator()) > olderThen)){
                System.out.println(car.toString());
            }
        }
    }
    public void ex3(int yearOfCreated, double price){
        for(Car car : cars){
            if(yearOfCreated == car.getYearOfCreator()
                && (car.getPrice() > price )){
                System.out.println(car.toString());
            }
        }
    }




}
