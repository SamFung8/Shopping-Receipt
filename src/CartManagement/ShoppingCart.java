package CartManagement;

import ProductType.CartProduct;
import java.util.*;

//Object for Shopping cart
public class ShoppingCart {
    private final String location;
    private final List<CartProduct> items;

    public ShoppingCart(String location) {
        this.location = location;
        this.items = new ArrayList<>();
    }

    public void addItem(CartProduct item) {
        items.add(item);
    }

    public String getLocation() {
        return location;
    }

    public List<CartProduct> getItems() {
        return items;
    }
}
