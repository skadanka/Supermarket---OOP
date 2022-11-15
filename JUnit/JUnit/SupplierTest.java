package JUnit;

import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
//import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.*;


public class SupplierTest {

    MSystem system = new MSystem();

    @Test
    void create_supplier()
    {
        Exception exception = null;
        try {
            system.addSupplier("1", "Osem");
        }
        catch (Exception ex)
        {
            exception = ex;
        }
        assertNull(exception, "Creation should be succeed.");
        Assertions.assertEquals(1, MSystem.getAllSuppliers().size(), "1 supplier has been created.");

        try
        {
            system.addSupplier("1", "Elite");
        }
        catch (Exception ex)
        {
            exception = ex;
        }

        assert exception != null;
        assertEquals("Supplier ID already exist.", exception.getMessage(),  "Check uniqueness of id.");

        Supplier supplier1 = MSystem.getAllSuppliers().get("1");
        Assertions.assertEquals(0, supplier1.getProducts().size(), "Supplier has no products.");

    }

}