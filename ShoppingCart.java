import java.util.Date;
import java.util.*;


public class ShoppingCart {
    private static int numOfShoppingCarts = 0;

    private final String object_id;
    private Date created;

    // Links
    // private User OwendByUser;
    private Set<LineItem> items;

    public ShoppingCart() {
        this.object_id = "SC" + String.valueOf(numOfShoppingCarts++);
        this.created = new Date();
        this.items = new HashSet<>();
    }
}