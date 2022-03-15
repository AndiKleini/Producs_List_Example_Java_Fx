package com.example.listview;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

public class EnterProductController implements Initializable {
    private final EnterProductModel enterProductModel;
    public TextField newProductName;
    public TextField newProductPrice;
    private Consumer<EnterProductModel> newProductListener;

    public EnterProductController(EnterProductModel enterProductModel) {
        this.enterProductModel = enterProductModel;
    }

    public void addProduct(ActionEvent actionEvent) {
        this.newProductListener.accept(this.enterProductModel);
    }

    public void addListener(Consumer<EnterProductModel> listenToNewProduct) {
        this.newProductListener = listenToNewProduct;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.newProductName.textProperty().bindBidirectional(this.enterProductModel.nameProperty());
        this.newProductPrice.textProperty().bindBidirectional(this.enterProductModel.priceProperty(),  new NumberStringConverter());
    }
}
