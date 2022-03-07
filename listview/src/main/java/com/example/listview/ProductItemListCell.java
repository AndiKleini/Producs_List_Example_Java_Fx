package com.example.listview;

import javafx.fxml.FXMLLoader;
import javafx.util.Callback;
import java.io.IOException;
import java.util.function.Consumer;


public class ProductItemListCell extends javafx.scene.control.ListCell<ProductModel> {

    private Consumer<ProductModel> onDeleteProductCallBack;

    ProductItemListCell(Consumer<ProductModel> callback) {
        this.onDeleteProductCallBack = callback;
    }

    @Override
    public void updateItem(ProductModel product, boolean empty)
    {
        super.updateItem(product, empty);
        if (empty || product == null) {
            setText(null);
            setGraphic(null);
            return;
        }
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("productitem.fxml"));
        try
        {
            fxmlLoader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

        var controller = (ProductItemController)fxmlLoader.getController();
        controller.setProduct(product);
        controller.addListenerForDeleteProduct(this.onDeleteProductCallBack);
        setGraphic(controller.getProductItemBox());
    }
}
