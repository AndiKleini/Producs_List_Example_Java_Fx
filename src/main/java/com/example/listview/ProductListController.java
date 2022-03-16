package com.example.listview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductListController implements Initializable {

    private ProductListModel productsModel;

    @FXML
    private EnterProductController enterProductController;

    @FXML
    private ProductListingController productListingController;

    public ProductListController(ProductListModel productListModel) {
        this.productsModel = productListModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.enterProductController.addListener(
                p -> this.productsModel.addProduct(ProductModel.From(p)));
    }
}