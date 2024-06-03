package CartManagement;

import SetUp.InitializeHandler;

//Handle the system flow of shopping cart
public class ShoppingCartHandler {
    private ShoppingCart cart;
    private InputerDataSplitter splitter;
    
    public ShoppingCartHandler(InitializeHandler initController) {
        splitter = new InputerDataSplitter(initController);
    }
    
    public void fillProductToCart(String input){
        cart = splitter.AddAllProducts(input);
    }

    public ShoppingCart getCart() {
        return cart;
    }
      
}
