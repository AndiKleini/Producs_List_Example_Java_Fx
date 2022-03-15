package com.example.listview;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProductListModel {

    private ProductFormModel productModel;

    public ProductListModel(ProductFormModel product) {
        this.productModel = product;
    }

    private ObservableList<ProductModel> products = FXCollections.observableArrayList();

    public ObservableList<ProductModel> getProducts() {
        return products;
    }

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
}
