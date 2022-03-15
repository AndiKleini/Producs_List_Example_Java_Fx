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
    public ListView<ProductModel> products = new ListView<>();

    public ProductListController(ProductListModel productListModel) {
        this.productsModel = productListModel;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.products.setItems(this.productsModel.getProducts());
        this.products.setCellFactory(productModelListView -> new ProductItemListCell(p -> this.deleteProduct(p)));
        this.enterProductController.addListener(p -> this.productsModel.addProduct(ProductModel.From(p)));
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
}