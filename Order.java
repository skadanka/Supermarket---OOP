import java.util.Date;
import java.util.*;


public class Order {
    private static int numOfOrders = 0; // Incremental id for all orders created 
    private final String objectID;

    private Date ordered;
    private Date shipped;
    private String Address;
    private OrderStatus status;
    private float total;

    // Links
    private Map<String, LineItem> items;
    private Map<String, Payment> payments; 



    public Order(String Address) {
        this.objectID = 'O' + String.valueOf(numOfOrders++);
        this.ordered = new Date();
        this.shipped = null;
        this.Address = Address;
        this.status = OrderStatus.New;
        this.total = 0;
        this.items = new HashMap<>();
        this.payments = new HashMap<>();
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

    public Order ordered(Date ordered) {
        setOrdered(ordered);
        return this;
    }

    public Order shipped(Date shipped) {
        setShipped(shipped);
        return this;
    }

    public Order Address(String Address) {
        setAddress(Address);
        return this;
    }

    public Order status(OrderStatus status) {
        setStatus(status);
        return this;
    }

    public Order total(float total) {
        setTotal(total);
        return this;
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

}
