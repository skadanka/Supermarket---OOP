import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        boolean done = false;
        boolean user_connected = false;

        MSystem mainsys = new MSystem();
        mainsys.addSupplier("Osem", "Osem");
        mainsys.addSupplier("EastWest", "EastWest");
        mainsys.addProduct("Bamba","Osem");
        mainsys.addProduct("Ramen","EastWest");
        mainsys.addUser("Dani","Dani123","111111111","Tel Aviv","054111111","Dani19@walla.com","Tel Aviv", false);
        mainsys.addUser("Dana","Dana123","222222222", "Jerusalem","0503456789", "Dana189A@gmail.com", "Kfar", true);
        PremiumAccount a = (PremiumAccount) User.getUser("Dana").getAccount();
        Product bamba = Product.getProduct("Bamba");
        a.addProduct(bamba,3,5);
        int choice;
        while(true) {
            System.out.println("Hello, what would u like to do? please enter the number");
            System.out.println("1. Add user");
            System.out.println("2. Remove user");
            System.out.println("3. Login user");
            System.out.println("4. Logout user");
            System.out.println("5. Create new order");
            System.out.println("6. Add product to order");
            System.out.println("7. Display order");
            System.out.println("8. Link product");
            System.out.println("9. Add product");
            System.out.println("10. Delete product");
            System.out.println("11. Show all objects");
            System.out.println("12. Show object ID");
            System.out.println("13. Exit");
            choice = input.nextInt();

            switch (choice) {
                //Scanner scanner = new Scanner(System.in);
                case 1:
                    Scanner scanner = new Scanner(System.in);

                    String login_id;
                    String password;
                    String id;
                    String address;
                    String phone;
                    String email;
                    String billingAddress;
                    boolean premium;
                    System.out.println("Please enter a Login id:");
                    login_id = scanner.nextLine();

                    System.out.println("Please enter a password:");
                    password = scanner.nextLine();

                    System.out.println("Premium account? yes/no:");
                    String ISpremium = scanner.nextLine();
                    if (ISpremium.equals("yes")){
                        premium = true;
                    }
                    else if (ISpremium.equals("no")){
                        premium = false;
                    }
                    else {
                        System.out.println("Not a valid input!");
                        System.out.println("U are not premium Account");
                        premium = false;
                    }
                    System.out.println("Please enter ID:");
                    id = scanner.nextLine();

                    System.out.println("Please enter Address:");
                    address = scanner.nextLine();

                    System.out.println("Please enter billingAddress:");
                    billingAddress = scanner.nextLine();

                    System.out.println("Please enter a phone:");
                    phone = scanner.nextLine();

                    System.out.println("Please enter an email:");
                    email = scanner.nextLine();

                    try{
                        mainsys.addUser(login_id,password,id,address,phone,email,billingAddress,premium);

                        System.out.println("You have successfully registered");
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                        System.out.println("Registration Failed! Please try again.");
                    }
                    break;
                case 2:
                    Scanner scanner2 = new Scanner(System.in);
                    System.out.println("Enter Login id");
                    String Login_id = scanner2.nextLine();
                    try {
                        mainsys.removeUser(Login_id);
                        System.out.println("User Removed successfully!");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("User Removed Failed! Please try again.");
                    }
                    break;
                case 3:
                    Scanner scanner3 = new Scanner(System.in);
                    System.out.println("Enter Login id");
                    String Login_id3 = scanner3.nextLine();
                    System.out.println("Enter password");
                    String password3 = scanner3.nextLine();
                    try {
//                        if(user_connected){
//                            System.out.println("Another user is logged in, please logout from the system");
//                        }
//                        else{
                            mainsys.login(Login_id3, password3);
                            user_connected = true;
                            System.out.println("You're successfully logged in!");
                        //}


                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                        System.out.println("Please try again.");
                    }
                    break;
                case 4:
                    Scanner scanner4 = new Scanner(System.in);
                    System.out.println("Enter Login id");
                    String Login_id4 = scanner4.nextLine();
                    try {
                        mainsys.logout(Login_id4);
                        user_connected = false;
                        System.out.println("You're successfully logged out!");
                    }
                    catch (Exception e){
                        System.out.println(e.getMessage());
                        System.out.println("You're still logged in! Please try again.");
                    }

                    break;

                case 5:

                    if (user_connected) {
                        try {
                            Scanner scanner6 = new Scanner(System.in);
                            System.out.println("Please enter Address: ");
                            String addressOrder = scanner6.nextLine();
                            String orderID = mainsys.CreateNewOrder(addressOrder);
                            System.out.println("Your OrderID - " + orderID);
                            Scanner scanner6b = new Scanner(System.in);
                            System.out.println("Please enter payer ID: ");
                            String payID = scanner6b.nextLine();
                            Scanner scanner7b = new Scanner(System.in);
                            System.out.println("Please enter details: ");
                            String payDetails = scanner6b.nextLine();
                            Scanner scanner6a = new Scanner(System.in);
                            do {
                                System.out.println("How would you like to pay? press:\n(1) Delayed Payment. \n(2) Immediate Payment. ");
                                String paymentType = scanner6a.nextLine();
                                try {
                                    mainsys.payment(paymentType, payID, payDetails, orderID);
                                    break;
                                } catch (Exception ex) {
                                    System.out.println(ex.getMessage());
                                }
                            }while (true);

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else
                        System.out.println("No one is connected...");

                    break;
                case 6:
                    if (user_connected != false) {
                        try {
                            Scanner scanner6 = new Scanner(System.in);
                            System.out.println("Please enter Order ID: ");
                            String order_id = scanner6.nextLine();

                            System.out.println("Please enter the User ID you want to Order from: ");
                            String order_from_id = scanner6.nextLine();

                            System.out.println("Please enter product name: ");
                            String product_name = scanner6.nextLine();
                            mainsys.AddProductToOrder(order_id, order_from_id, product_name);

                            System.out.println("The product successfully added to order");

                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else
                        System.out.println("No one is connected...");
                    break;

                case 7:
                    try {
                        mainsys.DisplayOrder();
                    }
                    catch (Exception ex)
                    {
                        System.out.println(ex.getMessage());
                    }
                    break;

                case 8:
                    if (user_connected) {
                        Scanner scanner8 = new Scanner(System.in);
                        System.out.println("Please enter Product Name: ");
                        String product_name = scanner8.nextLine();

                        System.out.println("Please enter Price: ");
                        float price = scanner8.nextFloat();

                        System.out.println("Please enter Quantity: ");
                        int quantity = scanner8.nextInt();

                        try {
                            mainsys.LinkProduct(product_name, price, quantity);
                            System.out.println("Product was successfully linked.");
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    else
                        System.out.println("Log in first.");
                    break;

                case 9:
                    Scanner scanner9 = new Scanner(System.in);
                    System.out.println("Dear supplier, please enter your Name:");
                    String supplierName = scanner9.nextLine();

                    System.out.println("Please enter your ID:");
                    String supplierId = scanner9.nextLine();

                    System.out.println("Please enter product's ID:");
                    String productId = scanner9.nextLine();

                    System.out.println("Please enter product's name:");
                    String productName = scanner9.nextLine();
                    try {
                        mainsys.addProduct(productName,supplierName);
                        System.out.println("Your product has successfully added!");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                        System.out.println("Product not added. Please try again.");
                    }
                    break;

                case 10:
                    Scanner scanner10 = new Scanner(System.in);
                    System.out.println("Please enter the product's name you want to delete: ");
                    String product_to_delete = scanner10.nextLine();
                    try {
                        mainsys.DeleteProduct(product_to_delete);
                        System.out.println("Product was successfully deleted.");
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 11:
                    System.out.println("Current all objects:");
                    mainsys.showAllObjects();
                    break;

                case 12:
                    System.out.println("Object ID:");
                    Scanner scanner12 = new Scanner(System.in);
                    String objectId;
                    objectId = scanner12.nextLine();
                    try {
                        mainsys.ShowObjectID(objectId);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 13:
                    done = true;
                    System.out.println("Goodbye!");
                    break;
                default :
                    System.out.println("This is not a valid Menu Option! Please Select Another");
                    break;
            }
        }
    }
}
