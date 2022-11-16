import java.util.Date ;

public class DelayedPayment extends Payment {
    private Date paymentDate;


    public DelayedPayment(String id, String Details, Order order, Account account) {
        super(id, Details, order, account);
        paymentDate = null;
    }

    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public DelayedPayment getPaymentDate(Date paymentDate) {
        setPaymentDate(paymentDate);
        return this;
    }

    public String showObject()
    {
        return "Delayed " + super.showObject();
    }

    public String toString() {
        String part1 = "Delayed Payment: " + this.getObjectID() +
                "\nID: " + this.getId()+
                "\nPaid Date: " + this.getPaid().toString()+
                "\nTotal: " + this.getTotal() +
                "\nDetails: " + this.getDetails() +
                "\nPayment Date: " + (this.getPaymentDate() != null ? this.getPaymentDate().toString() : "---") +
                "\nConnected Items: " +
                "\nAccount: " + this.getAccount().getID() +
                "\nOrder: " + this.getOrder().getObjectID();
        return  part1;



    }

    
}
