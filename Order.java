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

    
    public Order(String Address) {
        this.objectID = "OR" + String.valueOf(numOfOrders++);
        this.ordered = new Date();
        this.shipped = null;
        this.Address = Address;
        this.status = OrderStatus.New;
        this.total = 0;
        this.items = new HashMap<>();
        this.payments = new HashMap<>();
        addToAllOrders(this);
    }

    private void addToAllOrders(Order order){
        allOrders.put(order.getID(), order);
    }

    public static Collection<Order> getAllOrders(){
        return allOrders.values();
    }

    public String getID(){
        return this.objectID;
    }

    public void addLineItem(LineItem lineItem){
        this.items.put(lineItem.getID(), lineItem);
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
        return this.objectID == order.objectID;
    }


    @Override
    public String toString() {
        return "{" +
            " ordered='" + getOrdered() + "'" +
            ", shipped='" + getShipped() + "'" +
            ", Address='" + getAddress() + "'" +
            ", status='" + getStatus() + "'" +
            ", total='" + getTotal() + "'" +
            "}";
    }


    public Collection<LineItem> getLineItems() { 
        return items.values();
    }

    public void deleteFromItems(LineItem li) {
        items.remove(li);
    }

    public String getObjectID()
    {
        return "Order: " + this.objectID;
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
