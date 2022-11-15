import java.util.Date;

public class ImmediatePayment extends Payment {
    private boolean phoneConfirmation;
    

    public ImmediatePayment(String id, String Details, Order order, Account account) {
        super(id, Details, order, account);
        this.phoneConfirmation = false;
    }

    public boolean isPhoneConfirmation() {
        return this.phoneConfirmation;
    }

    public boolean getPhoneConfirmation() {
        return this.phoneConfirmation;
    }

    public void setPhoneConfirmation(boolean phoneConfirmation) {
        this.phoneConfirmation = phoneConfirmation;
    }

    public ImmediatePayment phoneConfirmation(boolean phoneConfirmation) {
        setPhoneConfirmation(phoneConfirmation);
        return this;
    }
    public String showObject()
    {
        return "Immediate " + super.getObjectID();
    }


    public String toString() {
        return  "Immediate Payment: " + this.getObjectID() +
                "\nID: " + this.getId()+
                "\nPaid Date: " + this.getPaid().toString()+
                "\nTotal: " + this.getTotal() +
                "\nDetails: " + this.getDetails()+
                "\nPhone Confirmation: " + this.phoneConfirmation +
                "\nConnected Items: " +
                "\nAccount: " + this.getAccount().getID() +
                "\nOrder: " + this.getOrder().getObjectID();

    }
}