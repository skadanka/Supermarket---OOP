import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class ProductTest {

    MSystem system = new MSystem();
    public void init()
    {
        system.addSupplier("1", "Osem");
        system.addSupplier("2", "Elite");
    }

    @Test
    public void add_product_to_supplier()
    {
        // Assumption - no 2 products with the same name.
        // supplier doesnt exist
        Exception exception = null;
        try
        {
            system.addProductToSupplier("Bamba", "O");
        }
        catch (Exception ex)
        {
            exception = ex;
        }

        assertEquals("Supplier doesnt exist.", exception.getMessage(), "Supplier o doesnt exist.");

        exception = null;
        try
        {
            system.addProductToSupplier("Bamba", "Osem");
            system.addProductToSupplier("Bisli", "Osem");
            system.addProductToSupplier("Aporpo", "Osem");

        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assertNull(exception, "Addition should be succeed.");
        Supplier s1 = system.getAllSuppliers().get("Osem");
        assertEquals(4, s1.getProducts().size(), "Supplier Osem has 4 products.");

    }

    public void remove_product_suppliers()
    {
        Exception exception = null;
        try
        {
            system.removeProduct("Doritos");
        }
        catch (Exception ex)
        {
            exception = ex;
        }

        assertEquals("Product doesnt exist.", exception.getMessage(), "Supplier o doesnt exist.");
        exception = null;
        try
        {
            system.removeProduct("Bamba");
            system.removeProduct("Bisli");

        }
        catch (Exception ex)
        {
            exception = ex;
        }
        Supplier s1 = system.getAllSuppliers().get("Osem");

        assertNull(exception, "Remove should be succeed.");
        assertEquals(1, s1.getProducts().size(), "Supplier Osem has 1 product.");

    }

    @Test
    public void add_product_premium()
    {
        Exception exception = null;
        try
        {
            system.addUser("shushi", "11111111", "333333333", "Beer Sheva", "0541122111", "shus@gmail.com", "BeerSheba",
                    true);
            system.addUser("dani", "11111111", "209888888", "Beer Sheva", "0541111111", "dani@gmail.com", "BeerSheba",
                    false);
            system.addUser("dina1043", "11111111", "209888888", "Beer Sheva", "0541111111", "dani@gmail.com", "BeerSheba",
                    false);

            system.addProductToSupplier("Bamba", "Osem");
            system.addProductToSupplier("Bisli", "Osem");

            system.login("dani", "11111111");

        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assertNull(exception, "Init should be succeed.");

        try
        {
            system.addProductPremium("Bamba", 40, 40);
        }
        catch (Exception ex)
        {
            exception = ex;
        }

        assertEquals("User loged in is not prmuim account.", exception.getMessage(),
                "Check addition to non-premium account.");

        exception = null;
        try
        {
            system.logout("dani");
            system.login("shushi", "11111111");

        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assertNull(exception, "Init should be succeed.");


        try
        {
            system.addProductPremium("Bambaaaaaa", 5, 10);
        }
        catch (Exception ex)
        {
            exception = ex;
        }

        assert exception != null;
        assertEquals("Product doesn't exist.", exception.getMessage(),
                "Check addition to non-exist product.");

        exception = null;
        try
        {
            system.addProductPremium("Bamba", 5, 10);
        }
        catch (Exception ex)
        {
            exception = ex;
        }

        assertNull(exception,
                "Addition complete.");

        User shushiUser = system.getAllUsers().get("shushi");

        // only to premium account
        assertEquals(1,shushiUser.getCustomer().getAccount().getProducts(), "Premium account connect to 1.");


    }

}
