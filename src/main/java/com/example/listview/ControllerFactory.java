package com.example.listview;

public class ControllerFactory {
    private final ProductListModel productListModel;
    private final ProductModel productModel;
    private final EnterProductModel enterProductModel;

    public ControllerFactory() {
        this.productListModel = new ProductListModel();
        this.productModel = new ProductModel();
        this.enterProductModel = new EnterProductModel();
    }

    public Object create(Class controllerClass) throws Exception {
        if (controllerClass == EnterProductController.class) {
            return new EnterProductController(this.enterProductModel);
        } else if (controllerClass == ProductListController.class) {
            return new ProductListController(this.productListModel);
        } else {
            throw new Exception("Controller not supported " + controllerClass.getName());
        }
    }
}
