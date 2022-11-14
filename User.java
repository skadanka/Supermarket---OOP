import java.util.HashMap;

/**
 * <p>Class User<p>
 *  This class responsible for managing all users in the system - creation, remove.
 */
public class User{

    private final String objectID;
    private final String login_id;
    private final String password;
    private UserState state;
    private ShoppingCart shoppingCart;
    private final Customer customer;
    private static HashMap<String, User> registeredUsers = new HashMap<>();
    private static int usersCounter = 0;


    /**
     * User Constructor - Initiate user, create all user connections: costumer, account.
     * @param login_id Username, should be unique.
     * @param password User passwords.
     * @param costumer Costumer link.
     */
    public User(String login_id, String password, String id, Customer costumer) {

        this.login_id = login_id;
        this.password = password;
        this.state = UserState.New;
        this.customer = costumer;
        this.objectID = "US" + String.valueOf(usersCounter++);
        registeredUsers.put(login_id, this);
        this.shoppingCart = this.customer.getAccount().getShoppingCart();

    }

    /**
     * @return Map of all registered users.
     */
    public static HashMap<String, User> getRegisteredUsers() {
        return registeredUsers;
    }

    public static void addUser(User user)
    {
        User.getRegisteredUsers().put(user.getLogin_id(),user);
    }

    /**
     * @return Username.
     */
    public String getLogin_id()
    {
        return this.login_id;
    }

    /**
     * Remove user from the system (and all its connections).
     */
    public void removeUser()
    {
        registeredUsers.remove(this.getLogin_id());
        customer.removeCustomer();
        this.shoppingCart = null;

    }

    /**
     * @return Users current password.
     */
    public String getPassword()
    {
        return password;
    }

    /**
     * @return Unique objectID.
     */
    public String getObjectID()
    {
        return "User "  + this.objectID;
    }

    /**
     * @return Customer related to user.
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @return Shopping cart related to User.
     */
    public ShoppingCart getShoppingCart()
    {
        return this.shoppingCart;
    }

    /**
     * Set user state.
     * @param state current state.
     */
    public void setState(UserState state)
    {
        this.state = state;
    }

    @Override
    public String toString()
    {

        return "User: " + this.getObjectID() +
                "\nLogin ID: " + this.login_id +
                "\nPassword: " + this.getPassword()+
                "\nState: " + this.state.toString() +
                "\nConnected Items: " +
                "\n" + this.getCustomer().getObjectID() +
                "\n"+ this.getShoppingCart().getObjectID();
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof User)) {
            return false;
        }
        User user = (User) o;
        return this.objectID.equals(user.objectID);
    }


    public UserState getState() {
        return this.getState();
    }

    public Account getAccount(){
        return this.customer.getAccount();
    }
}