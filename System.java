import java.util.Dictionary;
import java.util.HashSet;
import java.util.Scanner;
import java.util.*;

// User->customer->account->shoppingLIst, Orders ->lineItems->product->supplier
public class System {
    private User current_logged;
    // Key: String username, Value: User object, Support User.verfity(password);
    private HashMap<String, User> registred_user;

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
