package PrintScreen;

import CartManagement.ShoppingCart;
import ProductType.CartProduct;
import java.util.Locale;
import java.text.NumberFormat;

//Handle the system flow of printing the result.
public class PrinterHandler {

    ShoppingCart cart;
    PriceCal cal;

    public PrinterHandler(ShoppingCart cart) {
        this.cart = cart;
        cal = new PriceCal();
    }

    public void printReceipt() {
        System.out.println("item\t\t\tprice\t\tqty\n");
        for (CartProduct item : cart.getItems()) {
            System.out.printf("%-23s$%7.2f\t\t%-10d%n", item.getName(), item.getPrice(), item.getQuantity());
        }
        
        NumberFormat currencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
        
        System.out.println("subtotal:\t\t\t\t" + currencyFormat.format(cal.calSubTotal(cart)));
        System.out.println("tax:\t\t\t\t\t" + currencyFormat.format(cal.calTaxTotal(cart)));
        
        System.out.println("total:\t\t\t\t\t" + currencyFormat.format(cal.calFinalTotal()));
    }
}
