import java.util.Date;
import java.util.*;


public class Order {
    private static int numOfOrders = 0; // Incremental id for all orders created 
    private final String objectID;
    private static Map<String, Order> allOrders = new HashMap<>();

    private Date ordered;
    private Date shipped;
    private String Address;
    private OrderStatus status;
    private float total;

    // Links
    private Map<String, LineItem> items;
    private Map<String, Payment> payments;
    private final Account account;
    
    public Order(String Address, Account account) {
        this.objectID = "OR" + String.valueOf(numOfOrders++);
        this.ordered = new Date();
        this.shipped = null;
        this.Address = Address;
        this.status = OrderStatus.New;
        this.total = 0;
        this.items = new HashMap<>();
        this.payments = new HashMap<>();
        this.account = account;
        addToAllOrders(this);
    }

    private void addToAllOrders(Order order){
        allOrders.put(order.getID(), order);
    }


    public static Collection<Order> getAllOrders(){
        return allOrders.values();
    }

    public static Order getSpecificOrder(String orderID)
    {
        return allOrders.get(orderID);
    }

    public String getID(){
        return this.objectID;
    }

    public void addLineItem(LineItem lineItem){
        this.items.put(lineItem.getID(), lineItem);
    }

    public String showObject()
    {
        return "Order: " + this.getObjectID();
    }

    public void setPayments(Payment p)
    {
        this.payments.put(p.getObjectID(), p);
    }

    public Date getOrdered() {
        return this.ordered;
    }

    public void setOrdered(Date ordered) {
        this.ordered = ordered;
    }

    public Date getShipped() {
        return this.shipped;
    }

    public void setShipped(Date shipped) {
        this.shipped = shipped;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public OrderStatus getStatus() {
        return this.status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public float getTotal() {
        return this.total;
    }

    public void setTotal(float total) {
        this.total = total;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Order)) {
            return false;
        }
        Order order = (Order) o;
        return this.objectID.equals(order.objectID);
    }


    public String toString() {
        String part1 =  "Order: " + this.getObjectID() +
                "\nOderID: " + this.getObjectID()+
                "\nOrdered: " + this.ordered.toString()+
                "\nShipped: " + this.shipped.toString() +
                "\nShip TO: " + this.getAddress()+
                "\nStatus: " + this.getStatus().toString() +
                "\nTotal: " + this.total +
                "\nConnected Items: " +
                "\nAccount: " + this.account.getID();
        StringBuilder part2 = new StringBuilder();
        for (LineItem li:
                this.getLineItems()) {
            part2.append("\n").append(li.getID());
        }
        for (Payment pay:
                this.payments.values()) {
            part2.append("\n").append(pay.getObjectID());
        }

        return part1 + part2;
    }

    public String display()
    {
        return "Order: " + this.getObjectID() +
                "\nOrderID: " + this.getObjectID()+
                "\nOrdered: " + this.ordered.toString()+
                "\nShipped: " + String.format(this.shipped!=null? this.shipped.toString() : "---") +
                "\nShip TO: " + this.getAddress()+
                "\nStatus: " + this.getStatus().toString() +
                "\nTotal: " + this.total;
    }

    public Collection<LineItem> getLineItems() { 
        return items.values();
    }

    public void deleteFromItems(LineItem li) {
        items.remove(li);
    }

    public String getObjectID()
    {
        return this.objectID;
    }

    public void removeOrder() {
        allOrders.remove(this.objectID);
        Collection<LineItem> collection = LineItem.getLineItems();
        for (LineItem item: this.items.values()){
            collection.remove(item.getID());
        }
        this.items = null;
        Collection<Payment> collectionPayment = Payment.getAllPayments();
        for (Payment payment: this.payments.values()){
            collectionPayment.remove(payment.getObjectID());
        }
    }
}
