package CartManagement;

import ProductType.CartProduct;
import SetUp.InitializeHandler;

//A calculator for calculate the tax
public class TaxCal {

    public double calTaxRate(InitializeHandler initController, CartProduct newProduct, String location) {
        if (!initController.getBuiltInData().getTaxExemptCategoriesByID(location).contains(initController.getBuiltInData().getProductListCategoriesByID(newProduct.getName()))) {
            return newProduct.getPrice() * initController.getBuiltInData().getTaxRatesByID(location) * newProduct.getQuantity();
        } else {
            return 0.0;
        }
    }
}
