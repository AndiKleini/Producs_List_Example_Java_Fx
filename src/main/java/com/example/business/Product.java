package com.example.business;

public class Product {
    public Product(int price) {
        this.price = price;
    }

    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
