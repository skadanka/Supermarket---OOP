import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {

        Scanner input = new Scanner(System.in);
        boolean done = false;
        boolean user_connected = false;

        MSystem mainsys = new MSystem();

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
                        if(user_connected==true){
                            System.out.println("Another user is logged in, please logout from the system");
                        }
                        else{
                            mainsys.login(Login_id3, password3);
                            user_connected = true;
                            System.out.println("You're successfully logged in!");
                        }


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

//                case 5:
//                    Scanner scanner5 = new Scanner(System.in);
//
//                    break;
//                case 6:
//                    try {
//                        Scanner scanner6 = new Scanner(System.in);
//
//                    break;
//
//                case 7:
//                    mainsys.DisplayOrder();
//                    break;
//
//                case 8:
//                    Scanner scanner8 = new Scanner(System.in);
//
//                    break;
//
//                case 9:
//                    Scanner scanner9 = new Scanner(System.in);
//                    break;
//
//                case 10:
//                    Scanner scanner10 = new Scanner(System.in);
//
//                    break;

                case 11:
                    System.out.println("Current all objects:");
                    mainsys.showAllObjects();
                    break;

                case 12:
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
