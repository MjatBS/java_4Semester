package com.lab6;

public class Tablets extends Medicine{
    int quantity;
    public Tablets(String title, Substance substance, int weight) {
        super(title, substance, weight);
    }
    void setQuantity(int quantity){
        this.quantity = quantity;
    }
}
