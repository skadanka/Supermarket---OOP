import java.util.Date;
import java.util.*;


public class ShoppingCart {
    private static int numOfShoppingCarts = 0;

    private final String object_id;
    private Date created;

    // Links
    // private User OwendByUser;
    private Map<String, LineItem> items;

    public ShoppingCart() {
        this.object_id = "SC" + String.valueOf(numOfShoppingCarts++);
        this.created = new Date();
        this.items = new HashMap<>();
    }

    public void addLineItem(LineItem lineItem){
        this.items.put(lineItem.getID() , lineItem);
    }

    public String getObjectID()
    {
        return "Shopping Cart: " + this.object_id;
    }

    public Set<LineItem> getItems() { return items; }

    public void deleteFromItems(LineItem li) {
        if (items.contains(li))
            items.remove(li);
    }
}