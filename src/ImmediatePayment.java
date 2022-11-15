import java.util.Date;

public class ImmediatePayment extends Payment {
    private boolean phoneConfirmation;
    

    public ImmediatePayment(boolean phoneConfirmation, String id, Date paid, float total, String Details) {
        super(id, paid, total, Details);
        this.phoneConfirmation = phoneConfirmation;
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


    @Override
    public String toString() {
        return "{" +
            " phoneConfirmation='" + isPhoneConfirmation() + "'" +
            "}";
    }
}