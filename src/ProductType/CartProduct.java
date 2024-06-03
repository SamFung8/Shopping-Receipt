package ProductType;

//Object for save the shopping cart product
public class CartProduct extends Product {
    private int quantity;
    private double tax;

    public CartProduct(String name, double price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }

    @Override
    public int getQuantity() {
        return quantity;
    }

    @Override
    public double getTotalPrice() {
        return getPrice() * getQuantity();
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }
    
    public String getPriceStr(){
        return "$" + Double.toString(super.getPrice());
    }
}
