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
    //private HashSet<Supplier> suppliers;

    public MSystem() {

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
                throw new Exception("Costumer already exist.");
        } else
            throw new Exception("User already exist.");
    }

    /**
     * Remove user the system.
     *
     * @param login_id Username to remove.
     * @throws Exception if: 1. User doesnt exist. 2. User is currently login.
     */
    public void removeUser(String login_id) throws Exception {
        // Case1 - user doesnt exist.
        User user = User.getRegisteredUsers().get(login_id);
        if (user == null)
            throw new Exception("User doesnt exist.");

        // Case2 - user is logged in.
        if (currentLogged.getLogin_id() == login_id)
            throw new Exception("Logout first.");

        //User.getRegisteredUsers().remove(user.getLogin_id());
        user.removeUser();

    }

    /**
     * User login to system.
     *
     * @param login_id Username.
     * @param password User password.
     * @throws Exception if: 1. Username doesnt exist. 2. Another user logged to system. 3. Wrong password.
     */
    public void login(String login_id, String password) throws Exception {
        if (currentLogged == null)
            throw new Exception("Another user is logged in.");
        User user = User.getRegisteredUsers().get(login_id);
        if (user == null)
            throw new Exception("User doesnt exist.");
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
        User user = User.getRegisteredUsers().get(login_id);
        if (user != null) {
            if (user.getLogin_id().equals(currentLogged.getLogin_id())) {
                currentLogged = null;
                user.setState(UserState.Active);
            } else
                throw new Exception(login_id + "is not logged in");
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
            java.lang.System.out.println(user.getObjectID());
            // print user -> customer
            Customer customer = user.getCustomer();
            java.lang.System.out.println(customer.getObjectID());
            // print user -> customer -> account
            Account account = customer.getAccount();
            java.lang.System.out.println(account.getObjectID());
            // print user -> customer -> account -> shopping cart
            java.lang.System.out.println(account.getShoppingCart());
            // print all orders of this account.
            for (Order o :
                    account.getOrders()) {
                java.lang.System.out.println(o);
                // print all line items
                for (LineItem item :
                        o.getLineItems) {
                    java.lang.System.out.println(item);
                }
                // print all payment connected to users.
                for (Payment p :
                        account.getPayments()) {
                    java.lang.System.out.println(p.getObjectID());
                }
            }
            // print all suppliers.
            for (Supplier supplier :
                    this.suppliers) {
                java.lang.System.out.println(supplier);
                // for each supplier print its products.
                for (Product product : supplier.getProducts())
                    java.lang.System.out.println(product.getObjectID());
            }
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

        switch (objectClass) {
            case "AC":
                for (Account a :
                        Account.getRegisteredAccounts().values()) {
                    if (a.getObjectID().equals(objectID))
                        java.lang.System.out.println(a.toString());
                }
            case "CU":
                for (Customer c :
                        Customer.getRegisteredCostumers().values()) {
                    if (c.getObjectID().equals(objectID))
                        java.lang.System.out.println(c.toString());
                }
            case "LI":
                for (LineItem li :
                        LineItem.getRegisteredItems().values()) {
                    if (li.getObjectID().equals(objectID))
                        java.lang.System.out.println(li.toString());
                }

            case "OR":
                for (Order o :
                        Order.getAllOrders().values()) {
                    if (o.getObjectID().equals(objectID))
                        java.lang.System.out.println(o.toString());
                }

            case "PA":
                for (Payment p :
                        Payment.getAllPayment().values()) {
                    if (p.getObjectID().equals(objectID))
                        java.lang.System.out.println(p.toString());
                }

            case "PR":
                for (Product p :
                        Product.getAllProducts().values()) {
                    if (p.getObjectID().equals(objectID))
                        java.lang.System.out.println(p.toString());
                }

            case "SU":
                for (Supplier s :
                        Supplier.getRegisteredSuppliers().values()) {
                    if (s.getObjectID().equals(objectID))
                        java.lang.System.out.println(s.toString());
                }

            case "US":
                for (User u :
                        User.getRegisteredUsers().values()) {
                    if (u.getObjectID().equals(objectID))
                        java.lang.System.out.println(u.toString());
                }

            default:
                throw new Exception("ObjectID doesnt exist.");

        }


    }


    public void LinkProduct(String productName, int price, int quantity) {
        // Check if current logged user is Premium Account
        PremiumAccount pa = null;
        Account currAccount = currentLogged.getCustomer().getAccount();
        if (currAccount instanceof PremiumAccount) {
            pa = (PremiumAccount) currAccount;
            // Check if product exist in the database
            Product prod = Product.getAllProducts().get(productName);
            if (prod != null) {
                prod.setPrice(price);
                prod.setQuantity(quantity);
                pa.addProduct(prod);
            }
        }
    }


    public void AddProduct(String productName, String supplierName, String productId, String supplierId) {
        // we need to ask in the menu for those details.
        Supplier supp = Supplier.getRegisteredSuppliers().get(supplierName);
        if (supp == null)
            supp = new Supplier(supplierId, supplierName);
        Product prod = new Product(productId, productName, supp);
        supp.addProducts(prod);
    }

    public void DeleteProduct(String productName) {
        // check product exist in the System
        // Delete the product, and understand how to handle the links(lineItem, supplier) of product
        Product prod = Product.getAllProducts().get(productName);
        if (prod != null) {
            for (Supplier supp : Supplier.getRegisteredSuppliers().values()) {
                supp.deleteFromProducts(prod);
            }
            for (LineItem li : prod.getLineItems()) {
                li.getOrder().deleteFromItems(li);
                li.getShoppingCart().deleteFromItems(li);
            }
            Product.getAllProducts().get(productName);
        }
    }

    public String CreateNewOrder(String address){
        Account account = current_logged.getAccount();
        String out = account.addOrder(address);

        return "Order Created...\n Order Number: " + out;
    }

    public void AddProductToOrder(String order_id, String login_id, String product_name){
        // check if the login_id exist in the database? and use is prime
        // check order_id exist in the database
        // check product exist in the database?
        // Create new Line_item? and add a field to orders to contain all the lineitems?
        Account buyer = current_logged.getAccount();
        if (buyer.OrderExist(order_id))
            if (registred_user.containsKey(login_id)){
                Account seller = registred_user.get(login_id).getAccount();
                if(seller instanceof PremiumAccount){
                    PremiumAccount preAcc = (PremiumAccount) seller;
                    if(preAcc.ownProduct(product_name)){
                        ProductInfo productInfo = preAcc.getProduct(product_name);
                        int sellerQuantity = productInfo.getQuantity();
                        int price = productInfo.getPrice();
                        float discount = productInfo.getDiscount();
                        int minForDiscount = productInfo.getMinForDiscount();
                        Scanner sc = new Scanner(System.in);
                        System.out.println("%s can supply %d amount of %s at Price: %d...\n  You get %s% for buying %d",
                                login_id, sellerQuantity, product_name, discount*100, minForDiscount);
                        boolean flag = true;
                        do{
                            System.out.println("Insert Quantity");
                            int quantity  = sc.nextInt();
                            if(quantity > sellerQuantity)
                                System.out.print("Seller can supply only %d", sellerQuantity);
                            System.out.print("Want to change for available quantity? or Back to main menu (y\n)");
                            String ans = sc.nextLine();
                            if(ans.equals("y"))
                                flag = false;
                            else if(ans.equals("n"))
                                return;

                        }
                        while(flag);
                        buyer.AddProduct(order_id, null, sellerQuantity, price);
                    }
                    else{
                        System.out.println("User doesn't own any products");
                    }

                }
            }
            else{
                System.out.println("User not Found!");
            }
        else{
            System.out.println("Order not Found!");
        }

    }

    public void DisplayOrder(String login_id){
        // Get all Sorted Orders
        // Get the first Order where login_id == Order.User_id
        // ** Order_id, Create, Shipped, Address, OrderStatus, Price **
    }

}

