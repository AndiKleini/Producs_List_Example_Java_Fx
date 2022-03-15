package com.example.listview;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductModel {

    private Consumer<ProductModel> addProductHandler;
    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty price = new SimpleIntegerProperty();

    public static ProductModel From(ProductModel source) {
        var newInstance = new ProductModel();
        newInstance.name.set(source.name.getValue());
        newInstance.price.set(source.price.getValue());
        return newInstance;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public int getPrice() {
        return price.get();

    }

    public IntegerProperty priceProperty() {
        return price;
    }

    public void addListenerForAddProduct(Consumer<ProductModel> listener) {
        this.addProductHandler = listener;
    }

    public void setPrice(int price) {
        this.price.set(price);
    }

    public void priceUp() {
        this.price.setValue(this.price.getValue() + 1);
    }

    public void priceDown() {
        this.price.setValue(this.price.getValue() - 1);
    }

    public void submit() {
        this.addProductHandler.accept();
    }
}
