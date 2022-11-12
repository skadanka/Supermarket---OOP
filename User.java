
public class User{
    
    private final String login_id;
    private String password;
    private UserState state;
    
    private ShoppingCart shoppingCart;
    private Customer customer;

    public User(String login_id, String password, UserState state, ShoppingCart shoppingCart, Customer customer) {
        this.login_id = login_id;
        this.password = password;
        this.state = state;
        this.shoppingCart = shoppingCart;
        this.customer = customer;
    }
}