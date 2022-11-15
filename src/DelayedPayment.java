import java.util.Date ;

public class DelayedPayment extends Payment {
    private Date paymentDate;


    public DelayedPayment(Date paymentDate, boolean phoneConfirmation, String id, Date paid, float total, String Details) {
        super(id, paid, total, Details);
        this.paymentDate = paymentDate;
    }

    public Date getPaymentDate() {
        return this.paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public DelayedPayment paymentDate(Date paymentDate) {
        setPaymentDate(paymentDate);
        return this;
    }


    @Override
    public String toString() {
        return "{" +
            " paymentDate='" + getPaymentDate() + "'" +
            "}";
    }
    
}
