import java.util.Date;
import java.util.*;


public class Account {
   private static int numOfAccounts = 0; 
   private final String objectID;
   private Order lastOrder = null;
   private final String id;
   private final String billing_address;
   private boolean is_closed;
   private final Date open;
   private Date closed;
   private int balance;
   private static HashMap<String, Account> registeredAccounts = new HashMap<>();

    // Links
   private HashMap<String, Order> orders;
   //private List<Order> orders;
   private ShoppingCart shoppingCart;
   private List<Payment> payments; // ** the orders are not related directly to the relevant payment **


    /**
     * Account constructor.
     * @param id Persons ID -> used for initiate costumer and account.
     * @param billingAddress Persons billing address -> used for initiate account.
     */
    public Account(String id, String billingAddress) {
        this.objectID = "AC" + String.valueOf(numOfAccounts++);
        this.billing_address = billingAddress;
        this.is_closed = false;
        this.open = new Date();
        this.closed = null;
        this.balance = 0;
        this.id = id;
        this.orders = new HashMap<>();
        this.payments = new ArrayList<>();
        this.shoppingCart = new ShoppingCart();
        this.shoppingCart.setAccount(this);
        registeredAccounts.put(id, this);

    }

    /**\
     * Order Exist.
     * @param OrderID get from user (unique for each order).
     * @return
     */
    public boolean OrderExist(String OrderID){
        return orders.containsKey(OrderID);
    }
    public void AddProduct(String orderID, Product product, int quantity, float price){
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
        Order order = new Order(address, this);
        String orderID = order.getID();
        orders.put(orderID, order);
        lastOrder = order;
        return orderID;
    }

    public Order getLastOrder() {
        return lastOrder;
    }

    /**
     * @return Person billing address.
     */
    public String getBilling_address() {
        return this.billing_address;
    }

    /**
     * @return Opening date of the account.
     */
    public Date getOpen() {
        return this.open;
    }

    /**
     * @return Closing date of the account.
     */
    public Date getClosed() {
        return this.closed;
    }

    /**
     * @param closed Set closing date.
     */
    public void setClosed(Date closed) {
        this.closed = closed;
    }

    /**
     * @return Get user balance.
     */
    public int getBalance() {
        return this.balance;
    }

    /**
     * @param balance Set user balance.
     */
    public void setBalance(int balance) {
        this.balance = balance;
    }

    /**
     * @return Shopping cart related to account.
     */
    public  ShoppingCart getShoppingCart() {return this.shoppingCart; }

    /**
     * @return All payments connected to account.
     */
    public List<Payment> getPayments() {return this.payments;}

    /**
     * @return All orders connected to account.
     */
    public Collection<Order> getOrders() {
        return this.orders.values();
    }
    /**
     * Remove account from all links.
     */
    public void removeAccount()
    {
        Date date = new Date();
        Account.registeredAccounts.remove(this.id);
        this.setClosed(date);
        this.is_closed = true;
        this.shoppingCart.removeShoppingCart();
        this.shoppingCart = null;

        this.payments = null;
        for (Order o: this.getOrders())
            o.removeOrder();
        this.orders = null;
    }

    /**
     * @return Class name + object Id.
     */
    public String getObjectID()
    {
        return this.objectID;
    }
    public String showObject()
    {
        return "Account: " + this.objectID;
    }

    /**
     * @return Map of all registered account.
     * Key = person ID.
     * Value = Person Account.
     */
    public static HashMap<String, Account> getRegisteredAccounts()
    {
        return registeredAccounts;
    }

    /**
     * @return Person unique ID.
     */
    public String getID()
    {
        return this.id;
    }

    /**
     * @return True if account closed.
     */
    public boolean getIsClosed()
    {
        return this.is_closed;
    }

    @Override
    public String toString() {
        String part1 = "Account: " + this.getObjectID() +
                "\nID: " + this.getID()+
                "\nBilling Address: " + this.getBilling_address()+
                "\nIs Closed: false" +
                "\nOpen: " + this.getOpen().toString() +
                "\nClosed: TBD" +
                "\nBalance: " + this.getBalance()+
                "\nConnected Items: " +
                "\n" + this.getShoppingCart().getObjectID();

        StringBuilder orders = new StringBuilder();
        for (Order o:
             this.getOrders()) {
            orders.append("\n").append(o.getObjectID());
        }
        StringBuilder payments = new StringBuilder();
        for (Payment p:
                this.getPayments()) {
            payments.append("\n").append(p.getObjectID());
        }

        return part1 + orders + payments;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Account)) {
            return false;
        }
        Account a = (Account) o;
        return this.objectID.equals(a.getObjectID());
    }

    public void addPayment(Payment p)
    {
        this.getPayments().add(p);
    }

}
