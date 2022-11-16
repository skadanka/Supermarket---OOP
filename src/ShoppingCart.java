import java.util.Date;
import java.util.*;


public class ShoppingCart {
    private static int numOfShoppingCarts = 0;

    private final String object_id;
    private Date created;

    private Account account;
    private User user;
    // Links
    private Map<String, LineItem> items;
    private static HashMap<String, ShoppingCart> allShoppingCarts = new HashMap<>();

    public ShoppingCart() {
        this.object_id = "SC" + String.valueOf(numOfShoppingCarts++);
        this.created = new Date();
        this.items = new HashMap<>();
        allShoppingCarts.put(object_id,this);

    }



    public void setUser(User user)
    {
        this.user = user;
    }

    public void setAccount(Account account)
    {
        this.account = account;
    }

    public void addLineItem(LineItem lineItem){
        this.items.put(lineItem.getID() , lineItem);
    }

    public String showObject()
    {
        return "Shopping Cart: " + this.getObjectID();
    }

    public String getObjectID()
    {
        return   this.object_id;
    }

//    public Set<LineItem> getItems() { return items; }

    public void deleteFromItems(LineItem li) {
            items.remove(li);
    }

    public void removeShoppingCart() {
        allShoppingCarts.remove(this.object_id);
        for (LineItem item: this.items.values()){
            LineItem.getLineItems().remove(item);
        }
        this.items = null;
    }

    @Override
    public String toString() {
        String part1 = "Shopping Cart: " + this.getObjectID() +
                "\nCreated Date: " + this.created+
                "\nConnected Objects: " +
                "\nAccount: " + this.account.getObjectID()+
                "\nUser: " + this.user.getObjectID();

        StringBuilder part2 = new StringBuilder();
        for (LineItem item: this.items.values()
             ) {
            part2.append("\nLine Item: "+item.getID());
        }

        return part1 + part2.toString();
    }

    public static HashMap<String,ShoppingCart> getAllShoppingCarts()
    {
        return allShoppingCarts;
    }
}