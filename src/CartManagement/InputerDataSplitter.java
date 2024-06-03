package CartManagement;

import ProductType.CartProduct;
import SetUp.InitializeHandler;

//Split the user input into an object
public class InputerDataSplitter {

    public TaxCal cal = new TaxCal();
    public InitializeHandler initController;


    public InputerDataSplitter(InitializeHandler initController) {
        this.initController = initController;
    }

    public ShoppingCart AddAllProducts(String userInput) {
        String[] parts = userInput.split(",");
        String location = parts[0].trim().split(":")[1].trim();

        ShoppingCart cart = new ShoppingCart(location);

        for (int i = 1; i < parts.length; i++) {
            String[] productInfo = parts[i].trim().split(" at ");
            int quantity = Integer.parseInt(productInfo[0].trim().split(" ")[0]);
            String productName = productInfo[0].trim().split(" ", 2)[1];
            double price = Double.parseDouble(productInfo[1].trim());

            CartProduct newProduct = new CartProduct(productName, price, quantity);
            newProduct.setTax(cal.calTaxRate(initController, newProduct, location));
            
            cart.addItem(newProduct);
        }
        
        return cart;
    }

}
