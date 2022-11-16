import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class MSystem {

/**
 * <p>Class System<p>
 * This class responsible is manging the system.
 * */

    private User currentLogged = null;
    // Key: String username, Value: User object, Support User.verity(password);
    private static HashMap<String, Supplier> allSuppliers = new HashMap<>();


    public static HashMap<String, Supplier> getAllSuppliers(){
        return allSuppliers;
    }
   /**
     * addUser - add new user to system.
     *
     * @param login_id       Username, should be unique.
     * @param password       User passwords.
     * @param id             Persons ID -> used for initiate costumer and account.
     * @param address        Person Address -> used for initiate costumer.
     * @param phone          Persons phone number -> used for initiate costumer.
     * @param email          Persons email -> used for initiate costumer.
     * @param billingAddress Persons billing address -> used for initiate account.
     * @param premium        Is account is premium?
     * @throws Exception Throw expection if creation failed: user name already taken\
     *                   costumer already has user on the system (according id).
     */

   public User getCurrentLogged()
   {
       return currentLogged;
   }
    public void addUser(String login_id, String password, String id,
                        String address, String phone, String email, String billingAddress, boolean premium) throws Exception {

        // Case1 - Username already taken.
        if (User.getRegisteredUsers().get(login_id) == null) {
            // Case2 - Check if costumer with id exist.

            if (!Customer.getIDList(id)) {
                Customer customer = new Customer(id, address, phone, email, billingAddress, premium);
                User user = new User(login_id, password, id, customer);
                customer.setUser(user);
            } else
                throw new Exception("Costumer ID already exist.");
        } else
            throw new Exception("User already exist.");
    }


    /**
     * Remove user the system.
     *
     * @param login_id Username to remove.
     * @throws Exception if: 1. User doesnt exist. 2. User is currently login.
     */
    public boolean removeUser(String login_id) throws Exception {
        // Case1 - user doesnt exist.
        boolean wasConnected = false;
        User user = User.getRegisteredUsers().get(login_id);
        if (user == null)
            throw new Exception("User doesnt exist.");

//        // Case2 - user is logged in.
//        if (currentLogged != null && currentLogged.getLogin_id().equals(login_id))
//            throw new Exception("Logout first.");
        if (currentLogged != null) {
            if (user.getLogin_id().equals(currentLogged.getLogin_id())) {
                currentLogged = null;
                wasConnected = true;
            }
        }
        //User.getRegisteredUsers().remove(user.getLogin_id());
        user.removeUser();
        return wasConnected;
    }

    /**
     * User login to system.
     *
     * @param login_id Username.
     * @param password User password.
     * @throws Exception if: 1. Username doesnt exist. 2. Another user logged to system. 3. Wrong password.
     */
    public void login(String login_id, String password) throws Exception {

        User user = User.getRegisteredUsers().get(login_id);
        if (user == null)
            throw new Exception("User doesnt exist.");
        else if (currentLogged != null) {
            if (currentLogged.getLogin_id().equals(login_id))
                throw new Exception("You already logged in!");
            else
                throw new Exception("Another user is logged in.");
        }
        else {
            if (password.equals(user.getPassword())) {
                currentLogged = user;
                user.setState(UserState.Online);
            } else
                throw new Exception("Wrong password.");
        }
    }

    /**
     * User logout from system
     *
     * @param login_id Username.
     * @throws Exception if 1. User wants to logout is not logged in. 2. Username doesnt exist.
     */
    public void logout(String login_id) throws Exception {
        if (currentLogged == null)
            throw new Exception("No user is logged in.");
        User user = User.getRegisteredUsers().get(login_id);
        if (user != null) {
            if (user.getLogin_id().equals(currentLogged.getLogin_id())) {
                user.setState(UserState.Active);
                currentLogged = null;
            } else
                throw new Exception(login_id + " is not logged in");
        } else
            throw new Exception("User doesnt exist.");

    }

    /**
     * Show all objects exist on system according their OBJECTID.
     */
    public void showAllObjects() {

        for (User user :
                User.getRegisteredUsers().values()) {
            // print user
            java.lang.System.out.println(user.showObject());
            // print user -> customer
            Customer customer = user.getCustomer();
            java.lang.System.out.println(customer.showObject());
            // print user -> customer -> account

            Account account = customer.getAccount();
            java.lang.System.out.println(account.showObject());
            // print user -> customer -> account -> shopping cart
            java.lang.System.out.println(account.getShoppingCart().showObject());
            // print all orders of this account.
            for (Order o :
                    account.getOrders()) {
                java.lang.System.out.println(o.showObject());
                // print all line items
                for (LineItem item :
                        o.getLineItems()) {
                    java.lang.System.out.println(item.showObject());
                }
                // print all payment connected to users.
                for (Payment p :
                        account.getPayments()) {
                    java.lang.System.out.println(p.showObject());
                }
            }
        }
        // print all suppliers.
        for (Supplier supplier :
                getAllSuppliers().values()) {
            java.lang.System.out.println(supplier.showObject());
            // for each supplier print its products.
            for (Product product : supplier.getProducts())
                java.lang.System.out.println(product.showObject());

        }
    }

    /**
     * Print all details about specific object according its ObjectID.
     *
     * @param objectID object unique ID.
     * @throws Exception if object id doesnt exist.
     */
    public void ShowObjectID(String objectID) throws Exception {
        String objectClass = objectID.substring(0, 2);
        boolean flag = false;
        switch (objectClass) {
            case "AC":
                for (Account a :
                        Account.getRegisteredAccounts().values()) {
                    if (a.getObjectID().equals(objectID)) {
                        java.lang.System.out.println(a.toString());
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    throw new Exception("ObjectID doesnt exist.");
                break;
                //throw new Exception("ObjectID doesnt exist.");

            case "CU":
                for (Customer c :
                        Customer.getRegisteredCostumers().values()) {
                    if (c.getObjectID().equals(objectID)){
                        java.lang.System.out.println(c.toString());
                    flag = true;
                    break;
                }
            }
            if (!flag)
                throw new Exception("ObjectID doesnt exist.");
            break;
            case "LI": 
                for (LineItem li :
                        LineItem.getLineItems()) {
                    if (li.getID().equals(objectID)){
                        java.lang.System.out.println(li.toString());
                    flag = true;
                    break;
                }
            }
            if (!flag)
                throw new Exception("ObjectID doesnt exist.");
            break;

            case "OR":
                for (Order o :
                        Order.getAllOrders()) {
                    if (o.getID().equals(objectID)){
                        java.lang.System.out.println(o.toString());
                    flag = true;
                    break;
                }
            }
            if (!flag)
                throw new Exception("ObjectID doesnt exist.");
            break;
            case "PA":
                for (Payment p :
                        Payment.getAllPayments()) {
                    if (p.getObjectID().equals(objectID)){
                        java.lang.System.out.println(p.toString());
                    flag = true;
                    break;
                }
            }
            if (!flag)
                throw new Exception("ObjectID doesnt exist.");
            break;
            case "PR":
                for (Product p :
                        Product.getAllProducts()) {
                    if (p.getObjectID().equals(objectID)){
                        java.lang.System.out.println(p.toString());
                    flag = true;
                    break;
                }
        }
        if (!flag)
            throw new Exception("ObjectID doesnt exist.");
        break;
            case "SC":
                for (ShoppingCart sc :
                        ShoppingCart.getAllShoppingCarts().values()) {
                    if (sc.getObjectID().equals(objectID)){
                        java.lang.System.out.println(sc.toString());
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    throw new Exception("ObjectID doesnt exist.");
            case "SU":
                for (Supplier s :
                        getAllSuppliers().values()) {
                    String id = s.getObjectID();
                    if (id.equals(objectID)){
                        System.out.println(s.toString());
                        flag = true;
                        break;
                }
        }
        if (!flag)
            throw new Exception("ObjectID doesnt exist.");
        break;

            case "US":
                for (User u :
                        User.getRegisteredUsers().values()) {
                    if (u.getObjectID().equals(objectID)){
                        java.lang.System.out.println(u.toString());
                    flag = true;
                    break;
                }
        }
        if (!flag)
            throw new Exception("ObjectID doesnt exist.");
        break;

            default:
                throw new Exception("ObjectID doesnt exist.");

        }


    }


    public void LinkProduct(String productName, float price, int quantity) throws Exception {
        if(price <= 0 )
            throw new Exception("Invalid price.");
        if(quantity <= 0 )
            throw new Exception("Invalid quantity.");
        // Check if current logged user is Premium Account
        Account currAccount = currentLogged.getCustomer().getAccount();
        if (currAccount instanceof PremiumAccount) {
            PremiumAccount pa = (PremiumAccount) currAccount;
            // Check if product exist in the database
            Product prod = Product.getProduct(productName);
            if (prod != null)
                pa.addProduct(prod,price,quantity);
            else
                throw new Exception("Product not exist.");
        }
        else
            throw new Exception("You are not premium account.");
    }


    public void addProduct(String productName, String supplierName) throws Exception {
        // we need to ask in the menu for those details.
        Supplier supplier = getAllSuppliers().get(supplierName);
        if (supplier == null)
            throw new Exception("Supplier not exist.");
        Product prod = new Product(productName, productName, supplier);
        supplier.addProducts(prod);
    }

    public void DeleteProduct(String productName) {
        Product p = Product.getProduct(productName);
        if (p != null)
            p.deleteProduct();
    }

    public String CreateNewOrder(String address){
        Account account = currentLogged.getAccount();
        String out = account.addOrder(address);
        return out;
    }

    public void payment(String type, String ID, String details, String orderID) throws Exception {
        // delayed payment
        Payment payment;
        Order order = Order.getSpecificOrder(orderID);
        if (type.equals("1"))
        {
             payment = new DelayedPayment(ID, details, order , currentLogged.getAccount());
        }
        else if (type.equals("2"))
        {
            payment = new ImmediatePayment(ID, details, order, currentLogged.getAccount());
        }
        else
            throw new Exception("Invalid action.");

        order.setPayments(payment);
        currentLogged.getAccount().addPayment(payment);

    }





    public void AddProductToOrder(String order_id, String login_id, String product_name) throws Exception {
        // check if the login_id exist in the database? and use is prime
        // check order_id exist in the database
        // check product exist in the database?
        // Create new Line_item? and add a field to orders to contain all the lineitems?
        int quantity;
        Account buyer = currentLogged.getAccount();
        if (!buyer.OrderExist(order_id))
            throw new Exception("Order not Found!");
        if (User.getUser(login_id) == null)
            throw new Exception("User not Found!");
        Account seller = User.getUser(login_id).getAccount();
        if(!(seller instanceof PremiumAccount))
            throw new Exception("User is not premium account.");
        PremiumAccount preAcc = (PremiumAccount) seller;
        if(!preAcc.ownProduct(product_name))
            throw new Exception("User doesn't own this product.");
        ProductInfo productInfo = preAcc.getProduct(product_name);
        int sellerQuantity = productInfo.getQuantity();
        float price = productInfo.getPrice();
        Scanner sc = new Scanner(System.in);
        System.out.format("%s can supply %d amount of %s at Price: %.2f...", login_id, sellerQuantity, product_name, price);
        boolean flag = true;
        do{
            System.out.println("Insert Quantity");
            quantity  = sc.nextInt();
            if(quantity > sellerQuantity) {
                System.out.format("Seller can supply only %d", sellerQuantity);
                System.out.print("Want to change for requested quantity? or Back to main menu (y\n)");
                String ans = sc.nextLine();
                if(ans.equals("y"))
                    flag = false;
                else if(ans.equals("n"))
                    return;
            }
            else
                flag = false;
        }
        while(flag);
        buyer.AddProduct(order_id, productInfo.getProduct(), quantity, price);



    }

    public void DisplayOrder() throws Exception {
        if (currentLogged == null)
            throw new Exception("No one is logged in.");
        if (currentLogged.getAccount().getLastOrder() == null)
            throw new Exception("You didnt made any orders...");
        else
            System.out.println(currentLogged.getAccount().getLastOrder().display());
    }

    public void addSupplier(String id,String name) throws Exception {

        Supplier supplier = allSuppliers.get(id);
        if(supplier != null)
            throw new Exception("Supplier already exist.");
        else {
            supplier = new Supplier(id,name);
            allSuppliers.put(id,supplier);
        }
    }

}


