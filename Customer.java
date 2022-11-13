import java.util.HashMap;

/**
 * <p>Class Customer<p>
 *  This class responsible for managing all costumers on system.
 */
public class Customer {
    private static int numOfCustomers = 0;
    private final String objectID;
    private final String id;
    private User user = null;
    private String address;
    private String phone;
    private String email;
    private Account account;
    private static HashMap<String, Customer> registeredCostumers = new HashMap<>();


    /**
     * Costummer constructor. Responsible to create an account.
     * @param id Persons ID -> used for initiate costumer and account.
     * @param address Person Address -> used for initiate costumer.
     * @param phone Persons phone number -> used for initiate costumer.
     * @param email Persons email -> used for initiate costumer.
     * @param billingAddress Persons billing address -> used for initiate account.
     * @param premium Is account is premium?
     */
    public Customer(String id, String address, String phone, String email, String billingAddress, boolean premium) {
        this.objectID = "CU" + String.valueOf(numOfCustomers++);
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.id = id;
        if (premium)
        {
            account = new PremiumAccount(id, billingAddress);
        }
        else
            account = new Account(id, billingAddress);
        registeredCostumers.put(id, this);
    }

    /**
     * @return Person ID.
     */
    public String getID()
    {
        return this.id;
    }

    /**
     * @return Person address.
     */
    public String getAddress() {
        return this.address;
    }

    /**
     * @return Person phone.
     */
    public String getPhone() {
        return this.phone;
    }

    /**
     * @return Person email.
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * @param id Person unique id.
     * @return True if id already exist on system.
     */
    public static boolean getIDList(String id)
    {
        return registeredCostumers.get(id) != null;
    }

    /**
     * Remove customer from system.
     */
    public void removeCustomer()
    {
        registeredCostumers.remove(this.id);
        this.user = null;
        account.removeAccount();
        this.account = null;
    }

    /**
     * @return String with class name and object ID.
     */
    public String getObjectID()
    {
        return "Customer " + this.objectID;
    }

    /**
     * @return Account related to customer.
     */
    public Account getAccount()
    {
        return this.account;
    }


    /**
     * @return Map of all registered customers.
     * Key = person unique ID.
     * Value = related customer.
     */
    public static HashMap<String, Customer> getRegisteredCostumers() {
        return registeredCostumers;
    }

    /**
     * @param user Set user related to customer.
     */
    public void setUser(User user)
    {
        this.user = user;
    }

    /**
     * @return User related to customer.
     */
    public User getUser()
    {
        return this.user;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return this.objectID.equals(customer.objectID);
    }


    @Override
    public String toString() {
        return "Customer: " + this.getObjectID() +
                "\nID: " + this.getID()+
                "\nAddress: " + this.getAddress()+
                "\nPhone: " + this.getPhone()+
                "\nEmail: " + this.getEmail()+
                "\nConnected Items: " +
                "\n" + this.getUser().getObjectID() +
                "\n" + this.getAccount().getObjectID();
    }
}