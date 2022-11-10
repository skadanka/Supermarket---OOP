public class ImmediatePayment extends Payment {
    private boolean phoneConfirmation;
    

    public ImmediatePayment() {
    }

    public ImmediatePayment(boolean phoneConfirmation) {
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
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ImmediatePayment)) {
            return false;
        }
        ImmediatePayment immediatePayment = (ImmediatePayment) o;
        return phoneConfirmation == immediatePayment.phoneConfirmation;
    }

    @Override
    public String toString() {
        return "{" +
            " phoneConfirmation='" + isPhoneConfirmation() + "'" +
            "}";
    }
}