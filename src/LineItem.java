import java.util.*;

public class LineItem {
    private static int numOfLineItems = 0;
    private final String ObjectID;
    private static HashMap<String, LineItem> allLineItems = new HashMap<>();

    private int quantity;
    private float price;

    // Link Ideas
    private ShoppingCart shoppingCart;
    private Order order;
    private Product product;


    public LineItem(int quantity, float price, ShoppingCart shoppingCart, Order order, Product product) {
        this.ObjectID = "LI" + String.valueOf(numOfLineItems++);
        this.quantity = quantity;
        this.price = price;
        this.shoppingCart = shoppingCart;
        this.order = order;
        this.product = product;
        addToAllLineItems(this);
    }
    public String showObject()
    {
        return "Line Item: " + this.ObjectID;
    }

    private void addToAllLineItems(LineItem lineItem){
        allLineItems.put(lineItem.ObjectID, lineItem);
    }

    public static Collection<LineItem> getLineItems(){
        return allLineItems.values();
    } 

    public Order getOrder(){
        return order;
    }

    public ShoppingCart getShoppingCart(){
        return shoppingCart;
    }

    public String getID(){
        return this.ObjectID;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LineItem quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }


    // @Override
    // public boolean equals(Object o) {
    //     if (o == this)
    //         return true;
    //     if (!(o instanceof LineItem)) {
    //         return false;
        
    //     LineItem lineItem = (LineItem) o;
    //     return this.ObjectID == lineItem.ObjectID; 
    //     }
    // }

    public String toString() {
        return  "Line Item: " + this.getID() +
                "\nQuantity: " + this.quantity+
                "\nPrice: " + this.price+
                "\nConnected Objects: " +
                "\nShopping Cart: " + this.getShoppingCart().getObjectID() +
                "\nOrder: " + this.getOrder().getObjectID() +
                "\nProduct: " + this.getProduct().getObjectID();

    }


    public Product getProduct() {
        return this.product;
    }
}
