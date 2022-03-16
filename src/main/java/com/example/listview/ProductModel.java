package com.example.listview;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProductModel {
    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty price = new SimpleIntegerProperty();

    public static ProductModel From(EnterProductModel source) {
        var newInstance = new ProductModel();
        newInstance.name.set(source.getName());
        newInstance.price.set(source.getPrice());
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

    public void setPrice(int price) {
        this.price.set(price);
    }

    public void priceUp() {
        this.price.setValue(this.price.getValue() + 1);
    }

    public void priceDown() {
        this.price.setValue(this.price.getValue() - 1);
    }
}
