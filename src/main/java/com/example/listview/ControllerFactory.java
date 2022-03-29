package com.example.listview;

import com.example.business.CalculatePaymentFactory;
import com.example.business.ICalculatePayment;

public class ControllerFactory {
    private final ProductListModel productListModel;
    private final ProductModel productModel;
    private final EnterProductModel enterProductModel;

    public ControllerFactory() {
        ICalculatePayment payment = CalculatePaymentFactory.getPayment();
        this.productListModel = new ProductListModel(payment);
        this.productModel = new ProductModel();
        this.enterProductModel = new EnterProductModel();
    }

    public Object create(Class controllerClass) throws Exception {
        if (controllerClass == EnterProductController.class) {
            return new EnterProductController(this.enterProductModel);
        } else if (controllerClass == ProductListController.class) {
            return new ProductListController(this.productListModel);
        } else if (controllerClass == ProductListingController.class) {
            return new ProductListingController(this.productListModel);
        }else {
            throw new Exception("Controller not supported " + controllerClass.getName());
        }
    }
}
