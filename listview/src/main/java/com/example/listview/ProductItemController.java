package com.example.listview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.util.converter.NumberStringConverter;

import java.util.function.Consumer;


public class ProductItemController  {

    private ProductModel product;

    private Consumer<ProductModel> onDeleteProductConsumer;

    @FXML
    public Label name;

    @FXML
    public Label price;

    @FXML
    private Node box = new HBox();

    public ProductItemController() { }

    public Node getProductItemBox() {
        return box;
    }

    public void setProduct(ProductModel product) {
        this.product = product;
        this.name.textProperty().bindBidirectional(this.product.nameProperty());
        this.price.textProperty().bindBidirectional(this.product.priceProperty(), new NumberStringConverter());
    }

    @FXML
    public void onPriceUp(ActionEvent actionEvent) {
        this.product.priceUp();
    }

    @FXML
    public void onPriceDown(ActionEvent actionEvent) {
        this.product.priceDown();
    }

    public void onDeleteProduct(ActionEvent actionEvent) {
        this.onDeleteProductConsumer.accept(this.product);
    }

    public void addListenerForDeleteProduct(Consumer<ProductModel> listener) {
        this.onDeleteProductConsumer = listener;
    }
}
