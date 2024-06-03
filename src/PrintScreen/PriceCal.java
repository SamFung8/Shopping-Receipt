package PrintScreen;

import CartManagement.ShoppingCart;
import ProductType.CartProduct;

//A calculator for calculate the total price
public class PriceCal {

    double finalTotal = 0;

    public double calSubTotal(ShoppingCart cart) {
        double total = 0;
        for (CartProduct item : cart.getItems()) {
            total += item.getPrice() * item.getQuantity();
        }

        finalTotal += Math.ceil(total * 100.0) / 100.0;

        return Math.ceil(total * 100.0) / 100.0;
    }

    public double calTaxTotal(ShoppingCart cart) {
        double total = 0;
        for (CartProduct item : cart.getItems()) {
            total += item.getTax();
        }

        finalTotal += Math.ceil(total * 20.0) / 20.0;

        return Math.ceil(total * 20.0) / 20.0;
    }
    
    public double calFinalTotal(){
        return finalTotal;
    }
}
