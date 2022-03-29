package com.example.listview;

import com.example.business.ICalculatePayment;
import com.example.business.Product;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.adapter.JavaBeanIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

public class ProductListModel {
    private ICalculatePayment payment;

    private ObservableList<ProductModel> products = FXCollections.observableArrayList();

    public ProductListModel(ICalculatePayment payment) {
        this.payment = payment;
    }

    public ObservableList<ProductModel> getProducts() {
        return products;
    }

    public IntegerProperty total = new SimpleIntegerProperty();

    public void addProduct(ProductModel product) {
        this.products.add(product);
    }

    public void removeProduct(ProductModel product) {
        this.products.remove(product);
    }

    public void removeAll() {
        this.products.clear();
    }

    public void allPriceUp() {
        this.products.stream().forEach(c -> c.priceUp());
    }

    public void allPriceDown() {
        this.products.stream().forEach(c -> c.priceDown());
    }

    public void sum() {
        List<Product> products = this.products.stream().map(p -> new Product(p.getPrice())).toList();
        int total = this.payment.sum(products).getSum();
        this.total.setValue(total);
    }
}
