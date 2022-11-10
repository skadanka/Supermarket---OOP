import java.util.Date;


public class Account {
   private static int numOfAccounts = 0; 

   private final String name;
   private String billing_address;
   private boolean is_closed;
   private Date open;
   private Date closed;
   private int balance;

    public Account() {
        this.name = String.valueOf(numOfAccounts++);
    }

    public Account(String billing_address, boolean is_closed, Date open, Date closed, int balance) {
        this.name = String.valueOf(numOfAccounts++);
        this.billing_address = billing_address;
        this.is_closed = is_closed;
        this.open = open;
        this.closed = closed;
        this.balance = balance;
    }

    public String getBilling_address() {
        return this.billing_address;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }

    public boolean isIs_closed() {
        return this.is_closed;
    }

    public boolean getIs_closed() {
        return this.is_closed;
    }

    public void setIs_closed(boolean is_closed) {
        this.is_closed = is_closed;
    }

    public Date getOpen() {
        return this.open;
    }

    public void setOpen(Date open) {
        this.open = open;
    }

    public Date getClosed() {
        return this.closed;
    }

    public void setClosed(Date closed) {
        this.closed = closed;
    }

    public int getBalance() {
        return this.balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public Account billing_address(String billing_address) {
        setBilling_address(billing_address);
        return this;
    }

    public Account is_closed(boolean is_closed) {
        setIs_closed(is_closed);
        return this;
    }

    public Account open(Date open) {
        setOpen(open);
        return this;
    }

    public Account closed(Date closed) {
        setClosed(closed);
        return this;
    }

    public Account balance(int balance) {
        setBalance(balance);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Account)) {
            return false;
        }
        Account account = (Account) o;
        return this.name == account.name;
    }


    @Override
    public String toString() {
        return "{" +
            " billing_address='" + getBilling_address() + "'" +
            ", is_closed='" + isIs_closed() + "'" +
            ", open='" + getOpen() + "'" +
            ", closed='" + getClosed() + "'" +
            ", balance='" + getBalance() + "'" +
            "}";
    }
}
