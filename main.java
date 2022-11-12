
class Main{

    public static void main(String[] args){
        
    }

    public boolean AddUser(String Login_id){
        // Check if User already exist in the system
        // Prompt user to input password
        // Prompt user to Choose Premium user (y(es)?/n(o)?) (Ignore Case)
        // Decide what to return maybe User Status enum {SuccessToCreated, Exist, FailedToCreate}
        return false;
    }

    public boolean RemoveUser(String Login_id){
        // Check If user exist in the data base
        // Check if current logged user is the deleted user???
        // Remove From the Database
        // Return SuccessToRemove, FailedToRemove
        return false;
    }

    public boolean Login(String Login_id, String password){
        // Check if already anthor user is connected if true Prompt 'A User already logged to the system, Try again later!'
        // Check if login_id exist in the Users Database
        // Verify password
        // Update the Global system logged user
        // Prompt to user 'Welcome Login_id you are logged!'
        return false;
    }

    public boolean Logout(String login_id){
        // check if current user is logged
        // log out from system Prompt - 'Bye {login_id}, You are logged out'
        return false;
    }

    public String CreateNewOrder(String address, String login_id, String product_name){
        // Create Order
        //      if login_id in the data base and Product_Name exists
        //      else reject the order
        // Return The created order_id
        return "";
    }

    public void AddProductToOrder(String order_id, String login_id, String product_name){
    // check if the login_id exist in the database? and use is prime
    // check order_id exist in the database
    // check product exist in the database?
    // Create new Line_item? and add a field to orders to contain all the lineitems?
    }

    public void DisplayOrder(String login_id){
        // Get all Sorted Orders
        // Get the first Order where login_id == Order.User_id
        // ** Order_id, Create, Shipped, Address, OrderStatus, Price **
    }

    public void LinkProduct(String product_name, int price, int quantity){
        // Check if current logged user is Premium Account
        // Check if product exist in the database
        // Create new LineItem contain all the data about the product, price quantity
        // Link The LineItem to current User
    }

    public void AddProduct(String product_name, String supplier_name){
        // all users can add product with not link between them and the product
        // check if product already exist in the database?
        // check if supplier exist and link else create?
        // Create product and link to supplier
    }

    public void DeleteProduct(String product_name){
        // check product exist in the System
        // Delete the product, and understand how to handle the links(lineItem, supplier) of product
    }

    public void ShowAllObjects(){
        // Display all object with unique id of Objects
    }

    public void ShowObjectId(String id){
        // check object exist in the system
        // Understand how to display the object
    }

    
}