import java.util.Date;

public abstract class Payment {
   private static int numOfPayments = 0; 
   
   private final String id;

   private Date paid;
   private float total;
   private String Details;

    public Payment() {
        this.id = String.valueOf(numOfPayments++);
    }

    public Payment(String id, Date paid, float total, String Details) {
        this.id = String.valueOf(numOfPayments++);
        this.paid = paid;
        this.total = total;
        this.Details = Details;
    }

    public String getId() {
        return this.id;
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

    public Payment paid(Date paid) {
        setPaid(paid);
        return this;
    }

    public Payment total(float total) {
        setTotal(total);
        return this;
    }

    public Payment Details(String Details) {
        setDetails(Details);
        return this;
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

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", paid='" + getPaid() + "'" +
            ", total='" + getTotal() + "'" +
            ", Details='" + getDetails() + "'" +
            "}";
    }
}
