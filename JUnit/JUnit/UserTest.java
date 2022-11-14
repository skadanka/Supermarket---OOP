package JUnit;

import jdk.jshell.spi.ExecutionControl;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class UserTest {

    MSystem system = new MSystem();



    @Test
    void create_user() throws Exception {

        Exception exception = null;
        try {
            system.addUser("Harry", "111111", "876767656", "Tel Aviv", "0546789987",
                    "kingHarry@gmail.com", "Beer Sheva", false);

            system.addUser("Marina", "111111", "200009987", "Tel Aviv", "0502223333",
                    "marinamarina@gmail.com", "Jerusalem", true);


        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assertNull(exception, "Addition is legit. Initiating the system.");

        system.addUser("dani", "111111", "111111111","BeerSheba","0523456789",
                "dani9@wala.com","BeerSheba",false);

        // status check
        User u1 = system.getAllUsers().get("dani");
        Assertions.assertEquals(UserState.New, u1.getState(), "New User.");

        /*
            Check if 2 users with the same username can exist.
        */
        exception = null;
        try
        {
            system.addUser("dani", "222222", "111111111","BeerSheba","0523456789",
                    "dani9@walla.com","BeerSheba",false);
        }
        catch (Exception ex1)
        {
            exception = ex1;
        }
        assert exception != null;
        assertEquals("User already exist.", exception.getMessage(),
                "Check creation of duplicate username.");


        /*
            Create different user for the same person.
         */
        exception = null;

        try
        {
            system.addUser("Moshe", "111111", "111111111","BeerSheba","0523456789",
                    "dani9@wala.com","BeerSheba",false);
        }
        catch (Exception ex1)
        {
            exception = ex1;
        }
        assert exception != null;

        assertEquals("Costumer already exist.", exception.getMessage(),
                "Check creation of another user to the same person has failed.");


        /*
            Create user as needed, check all connections:
            1. Creation of costumer.
            2. Creation of an account.
            3. Creation of shopping cart?
        */



        /*
            Check: Creation of costumer.
         */

        Customer c1 = u1.getCustomer();
        Assertions.assertNotNull(c1, "Check costumer created in the user.");
        Assertions.assertEquals("111111111", c1.getID(), "Check costumer ID.");
        Assertions.assertEquals("BeerSheba", c1.getAddress(), "Check costumer address.");
        Assertions.assertEquals("0523456789", c1.getPhone(), "Check costumer phone.");
        Assertions.assertEquals("dani9@walla.com", c1.getEmail(), "Check costumer Email.");

        Account a1 = c1.getAccount();
        Assertions.assertNotNull(a1, "Check account created in the costumer");
        Assertions.assertEquals("111111111", a1.getID(), "Check equality between costumer and account id.");
        ShoppingCart sc1 = a1.getShoppingCart();
        Date today = new Date();
        assertTrue(today.compareTo(sc1.getCreated()), "Check date creation of shopping cart. -> Created with account a1.");
        User daniUser = sc1.getUser();
        Assertions.assertEquals(u1, daniUser, "The same user (on memory).");
    }

    @Test
    void remove_user()
    {
        /*
            Try to remover user and check if its removed from the system.
        */
        Exception exception = null;
        try {
            system.removeUser("dani");

        } catch (Exception ex) {
            exception = ex;
        }

        assertNull(exception, "Remove should be succeed, dani is exist.");

        assertEquals(2, system.getAllUsers().size(), "Harry and Marina are exist.");

        assertNull(system.getAllUsers().get("dani"),"dani deleted from users.");

        try {
            system.addUser("dani", "111111", "111111111","BeerSheba","0523456789",
                    "dani9@wala.com","BeerSheba",false);

        } catch (Exception ex) {
            exception = ex;
        }
        assertNull(exception, "dani should be addedd again because its user has been deletes" +
                " (so its accpunt, customer, etc...");

        // what happened when user deleted?
        // changing status? delete entirely from the system?
        // ************************************************
        // ************************************************
        // ************* NOT IMPLEMENTED !!! ***************
        // test: check user deleted from all data structures.
        // test: compare count of all object exist right now.
        // ************************************************
        // ************************************************


        /*
            Try to remove user that not exist.
         */
        Exception ex2 = null;
        try
        {
            system.removeUser("lali");
        }
        catch (Exception exception1)
        {
            ex2 = exception1;
        }
        assert ex2 != null;
        assertEquals("User doesnt exist.", ex2.getMessage(), "Check if user doesnt " +
                "exist removed.");

        // remove while login.
    }

    @Test
    public void login_test()
    {
        Exception exception = null;
        try {
            system.login("Marina","211111");
        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assert exception != null;
        assertEquals(exception.getMessage(), "Wrong password.", "Login should failed. (password)");

        try {
            system.login("marina","111111");
        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assertEquals(exception.getMessage(), "User doesnt exist.", "Login should failed. (wrong username)");

        exception = null;

        try {
            system.login("Marina","111111");
        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assertNull(exception, "Login should be succeed.");

        try {
            system.login("Harry","111111");
        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assert exception != null;
        assertEquals(exception.getMessage(), "Another user is logged in.",
                "Login should failed. (only one can be logged in)");

    }

    public void remove_test_2()
    {
        // failed: cant remove user while its logged in.
        Exception ex2 = null;
        try
        {
            system.removeUser("Marina");
        }
        catch (Exception exception1)
        {
            ex2 = exception1;
        }
        assert ex2 != null;
        assertEquals("Logout first.", ex2.getMessage(), "Check if user logged-in " +
                "exist removed.");

    }

    public void logout_test()
    {
        Exception ex2 = null;
        try
        {
            system.removeUser("Harry");
        }
        catch (Exception exception1)
        {
            ex2 = exception1;
        }
        assert ex2 != null;
        assertEquals("Harry is not logged in", ex2.getMessage(), "Check if user can logged out if its not " +
                "logged in");

        ex2 = null;
        try
        {
            system.removeUser("laliiii");
        }
        catch (Exception exception1)
        {
            ex2 = exception1;
        }
        assert ex2 != null;
        assertEquals("User doesnt exist.", ex2.getMessage(), "Check if user can logged out if its not " +
                "exist.");

        ex2 = null;
        try
        {
            system.removeUser("Marina");
        }
        catch (Exception exception1)
        {
            ex2 = exception1;
        }
        assertNull(ex2, "Marina is logged in, so she can logged out.");

    }

    public void checkObject() throws Exception {
        String expected = """
                User: US1
                Login ID: Harry
                Password: 111111
                State: New
                Connected Items:\s
                CU1
                SC1""";

        Exception ex = null;
        try {

            PrintStream previousConsole = java.lang.System.out;
            ByteArrayOutputStream newConsole = new ByteArrayOutputStream();
            java.lang.System.setOut(new PrintStream(newConsole));

            system.ShowObjectID("US1");

            assertEquals(expected, newConsole.toString(), "Same String, no exception.");
        }
        catch (Exception exception)
        {
            ex = exception;
        }

        assertNull(ex, "No exception should be thrown...");

    }


}
