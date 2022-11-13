import java.util.Date;
import java.util.*;


public class Account {
   private static int numOfAccounts = 0; 
    private final String Object_id;

   private final String id;
   private String billing_address;
   private boolean is_closed;
   private Date open;
   private Date closed;
   private int balance;

   // Links
   private Map<String, Order> orders;
   private ShoppingCart shoppingCart;
   private Map<String, Payment> payments; // ** the orderes are not related directly to the relvant payment **


    public Account(String billing_address, boolean is_closed, Date closed, String id, int balance) {
        this.Object_id = 'A' + String.valueOf(numOfAccounts++);
        this.billing_address = billing_address;
        this.is_closed = false;
        this.open = new Date();
        this.closed = null;
        this.balance = balance;
        this.id = id;
        this.orders = new HashMap<>();
        this.payments = new HashMap<>();
        this.shoppingCart = new ShoppingCart();
    }

    public boolean OrderExist(String OrderID){
        return orders.containsKey(OrderID);
    }
    public void AddProduct(String orderID, Product product, int quantity, int price){
        if(orders.containsKey(orderID)){
            Order order = orders.get(orderID);
            if(order.getStatus() == OrderStatus.New || order.getStatus() == OrderStatus.Hold){
                LineItem lineItem = new LineItem(quantity, price , shoppingCart, order, product);
                shoppingCart.addLineItem(lineItem);
                order.addLineItem(lineItem);
                order.setStatus(OrderStatus.Hold);
            }
        }
    }



    public String addOrder(String address){
        Order order = new Order(address);
        String orderID = order.getID();
        orders.put(orderID, order);
        return orderID;
    }


    public String getBilling_address() {
        return this.billing_address;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    public boolean isIs_closed() {
        return this.is_closed;
    }

    public boolean getIs_closed() {
        return this.is_closed;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    public Date getOpen() {
        return this.open;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public Date getClosed() {
        return this.closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account billing_address(String billing_address) {
        setBilling_address(billing_address);
        return this;
    }

    public Account is_closed(boolean is_closed) {
        setIs_closed(is_closed);
        return this;
    }

    public Account open(Date open) {
        setOpen(open);
        return this;
    }

    public Account closed(Date closed) {
        setClosed(closed);
        return this;
    }

    public Account balance(int balance) {
        setBalance(balance);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return this.Object_id == account.Object_id;
    }


    @Override
    public String toString() {
        return "{" +
            " billing_address='" + getBilling_address() + "'" +
            ", is_closed='" + isIs_closed() + "'" +
            ", open='" + getOpen() + "'" +
            ", closed='" + getClosed() + "'" +
            ", balance='" + getBalance() + "'" +
            "}";
    }
}
