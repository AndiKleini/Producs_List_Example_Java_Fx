package com.example.listview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductFormController implements Initializable {

    private ProductFormModel newProduct  = new ProductFormModel();

    @FXML
    public TextField newProductName = new TextField();

    @FXML
    public TextField newProductPrice = new TextField();productsModel

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.newProductName.textProperty().bindBidirectional(this.newProduct.nameProperty());
        this.newProductPrice.textProperty().bindBidirectional(this.newProduct.priceProperty(),  new NumberStringConverter());
    }

    public void addProduct(ActionEvent action) {
       this.newProduct.submit();
    }
}