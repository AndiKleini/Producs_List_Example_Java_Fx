package com.example.listview;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.util.converter.NumberStringConverter;

import java.net.URL;
import java.util.ResourceBundle;

public class ProductListingController implements Initializable {
    private ProductListModel productsModel;

    @FXML
    public Label sum;

    @FXML
    public ListView<ProductModel> products = new ListView<>();

    public ProductListingController(ProductListModel productListModel) {
        this.productsModel = productListModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.products.setItems(this.productsModel.getProducts());
        this.products.setCellFactory(
                productModelListView -> new ProductItemListCell(p -> this.deleteProduct(p)));
        this.sum.textProperty().bindBidirectional(this.productsModel.total, new NumberStringConverter());
    }

    private void deleteProduct(ProductModel model) {
        this.productsModel.removeProduct(model);
    }

    public void clearProducts(ActionEvent actionEvent) {
        this.productsModel.removeAll();
    }

    public void allPricesUp(ActionEvent actionEvent) {
        this.productsModel.allPriceUp();
    }

    public void allPricesDown(ActionEvent actionEvent) {
        this.productsModel.allPriceDown();
    }

    public void sumProducts(ActionEvent actionEvent) { this.productsModel.sum(); }
}
