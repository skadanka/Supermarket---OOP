import java.util.Date;
import java.util.*;

public abstract class Payment {
   private static int numOfPayments = 0; 
   private final String objectID;
   private static HashMap <String, Payment> allPayments = new HashMap<>();


   private final String id;

   private Date paid;
   private float total;
   private String Details;
   private Order order;
   private Account account;

    // Links
    // Payment payment;
    // Account account;

    public Payment(String id, String Details, Order order, Account account) {
        this.objectID = "PA" + String.valueOf(numOfPayments);
        this.id = id;
        this.paid = new Date();
        this.total = 0;
        this.Details = Details;
        allPayments.put(objectID,this);
        this.order = order;
        this.account = account;
    }


    public static Collection<Payment> getAllPayments(){
        return allPayments.values();
    }

    public String getObjectID(){
        return objectID;
    }

    public String getId() {
        return "Payment: " + this.id;
    }

    public String showObject()
    {
        return "Payment: " + this.getObjectID();
    }

    public Date getPaid() {
        return this.paid;
    }

    public void setPaid(Date paid) {
        this.paid = paid;
    }

    public float getTotal() {
        return this.total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getDetails() {
        return this.Details;
    }

    public void setDetails(String Details) {
        this.Details = Details;
    }



    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Payment)) {
            return false;
        }
        Payment payment = (Payment) o;
        return this.id == payment.id;
    }

    public Account getAccount() {
        return account;
    }

    public Order getOrder() {
        return order;
    }
}
