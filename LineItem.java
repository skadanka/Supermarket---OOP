public class LineItem {
    private static int numOfLineItems = 0;
    private final String ObjectID;


    private int quantity;
    private int price;

    // Link Ideas
    private ShoppingCart shoppingCart;
    private Order order;
    private Product product;


    public LineItem(int quantity, int price, ShoppingCart shoppingCart, Order order, Product product) {
        this.ObjectID = "LI" + String.valueOf(numOfLineItems++);
        this.quantity = quantity;
        this.price = price;
        this.shoppingCart = shoppingCart;
        this.order = order;
        this.product = product;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LineItem quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    public LineItem price(int price) {
        setPrice(price);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LineItem)) {
            return false;
        
        LineItem lineItem = (LineItem) o;
        return this.ObjectID == lineItem.ObjectID; 
        }
    }

    @Override
    public String toString() {
        return "{" +
            " quantity='" + getQuantity() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }
}
