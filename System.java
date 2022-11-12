import java.util.Dictionary;
import java.util.HashSet;

import java.util.*;

// User->customer->account->shoppingLIst, Orders ->lineItems->product->supplier
public class System {
    private User current_logged;
    // Key: String username, Value: User object, Support User.verfity(password);
    private HashMap<String, User> registred_user;

}
