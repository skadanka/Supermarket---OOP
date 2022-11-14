package JUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    MSystem system = new MSystem();

    public void init_system() throws Exception {

        Exception exception = null;

        try {
            system.addUser("dani", "11111111", "209888888", "Beer Sheva", "0541111111", "dani@gmail.com", "BeerSheba",
                    false);
            system.addUser("shushi", "11111111", "333333333", "Beer Sheva", "0541122111", "shus@gmail.com", "BeerSheba",
                    true);
        }

        catch (Exception ex)
        {
            exception = ex;
        }

        assertNull(exception, "Creation should be succeed.");
    }

    @Test
    void create_new_order() throws Exception {


        Exception exception = null;
        try
        {
            init_system();
            system.login("dani", "11111111");
            // change function name...!
            system.createNewOrder("Rager 113 BeerSheva");
            system.createNewOrder("University BeerSheva");
        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assertNull(exception, "Order should be possible.");


        /*
            Check number of order. Should be unique.
         */
        User daniUser = system.getAllUsers().get("dani");
        Order order1 = daniUser.getCustomer().getAccount().getOrders().get(0);
        Order order2 = daniUser.getCustomer().getAccount().getOrders().get(1);
        Assertions.assertNotEquals(order1, order2, "Different order number.");

        /*
            Check the account ordered.
            (Each order connect to account)
         */

        assertEquals(daniUser.getCustomer().getAccount(), order1.getAccount());

        system.logout("dani");
        system.login("shushi", "11111111");

        system.createNewOrder("Shushi's House");
        User shushiUser = system.getAllUsers().get("shushi");
        Order order3 = shushiUser.getCustomer().getAccount().getOrders().get(0);


        assertNotEquals(order2.getAccount(), order3.getAccount(), "Test check" +
                        "orders kept on the right account.");
        Assertions.assertEquals(2, daniUser.getCustomer().getAccount().getOrders().size(), "Dani made 2 orders.");
        Assertions.assertEquals(1, shushiUser.getCustomer().getAccount().getOrders().size(), "Shushi made 1 order.");

        // check order status.
        Assertions.assertEquals("New", order3.getStatus().toString(), "order 3 is new order.");

        Exception ex = null;
        try
        {
            order3.setStatus(OrderStatus.Shipped);
        }
        catch (Exception exc)
        {
            ex = exc;
        }
        assertEquals("Order cannot be shipped.", ex.getMessage(), "Order is empty....");
        // ************************************************
        // ************************************************
        // discuss about order status...
        // ************************************************
        // ************************************************
    }



}
