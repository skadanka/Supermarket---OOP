package JUnit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class GeneralTest {

    MSystem system = new MSystem();

    public void init_system()
    {
        // dina1043
        Exception exception = null;
        try
        {
            system.addSupplier("1", "Osem");
            system.addSupplier("2", "Elite");


            system.addUser("shushi", "11111111", "333333333", "Beer Sheva", "0541122111", "shus@gmail.com", "BeerSheba",
                    true);
            system.addUser("dani", "11111111", "209888888", "Beer Sheva", "0541111111", "dani@gmail.com", "BeerSheba",
                    false);
            system.addUser("dina1043", "11111111", "209888888", "Beer Sheva", "0541111111", "dani@gmail.com", "BeerSheba",
                    false);

            system.addProductToSupplier("Bamba", "Osem");
            system.addProductToSupplier("Bisli", "Osem");
            system.addProductToSupplier("Aporpo", "Osem");

            system.login("dina1043", "11111111");
            system.createNewOrder("First Order --- ");
            system.logout("dina1043");
            system.login("dani", "11111111");
            system.createNewOrder("Rager 113 BeerSheva");
            system.createNewOrder("Rager 111 BeerSheva");


        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assertNull(exception, "Init should be succeed.");

    }

    // GENERAL TEST //
    @Test
    public void add_product_to_order()
    {

        // not allowed to add to this user
        // try to add to non exist order.
        // premium doesnt exist
        // premium dont sell product
        this.init_system();
        Exception exception = null;
        try {
            system.addProductToOrder("1", "shushi", "Choclate");
        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assert exception != null;
        assertEquals("Not allowed to add this order.", exception.getMessage(),
                "Check if users can add product to order not its.");


        exception = null;
        try {
            system.addProductToOrder("11", "shushi", "Choclate");
        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assert exception != null;
        assertEquals("Order number is not exist.", exception.getMessage(),
                "Check if users can add product to non exist orders.");


        exception = null;
        try {
            system.addProductToOrder("2", "shushi", "Choclate");
        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assert exception != null;
        assertEquals("Product is not exist.", exception.getMessage(),
                "Check if users can add product seller doesnt sell.");


        exception = null;
        try {
            system.addProductToOrder("2", "shushi", "Bamba");
        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assertNull(exception,
                "Check if prosuct has been added.");


        User userShushi = system.getAllUsers().get("shushi");
        assertEquals(9, userShushi.getCustomer().getAccount().getProducts().get("Bamba"), "Left 9 bamba");
        Assertions.assertEquals(5, userShushi.getCustomer().getAccount().getBalance());

    }

    @Test
    public void remove_products_orders()
    {
        // delte products from order and line items etc...

        // test on doesnt exist product -> productTest
        Exception exception = null;
        try
        {
            system.removeProduct("Bamba");
        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assertNull(exception, "product exist.");

        // check the deletion from order no. 2

        // check deletion from shushi premium account:
        User userShushi = system.getAllUsers().get("shushi");
        assertEquals(0, userShushi.getCustomer().getAccount().getProducts().size(), "No product to sell.");

        User userDani = system.getAllUsers().get("dani");

        // check deletion from order.
        Order order = userDani.getCustomer().getAccount().getOrders().get("2");
        assertEquals(0, order.getProsucts().size(), "No products in the order.");

        // check shopping cart of dani

        assertEquals(0, userDani.getCustomer().getAccount().getShoppingCart().getLineItems().size());




    }


}
