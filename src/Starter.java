
import CartManagement.ShoppingCartHandler;
import PrintScreen.PrinterHandler;
import SetUp.InitializeHandler;
import java.util.Scanner;

public class Starter {

    public static void main(String[] args) {

        //Load the json and set up tax rates and product categories data
        InitializeHandler initController = new InitializeHandler();
        initController.setUp();

        //Read user input
        Scanner myObj = new Scanner(System.in);
        System.out.println("Please input the Location and purchase item info.");
        System.out.println("Please use this input format:Location: CA, 1 book at 17.99, 1 potato chips at 3.99");
        String userInput = myObj.nextLine();

        //Based user input crate the shopping cart and put the items into cart
        ShoppingCartHandler shoppingCartController = new ShoppingCartHandler(initController);
        shoppingCartController.fillProductToCart(userInput);

        //Print out the result
        PrinterHandler printerController = new PrinterHandler(shoppingCartController.getCart());
        printerController.printReceipt();
    }
}
