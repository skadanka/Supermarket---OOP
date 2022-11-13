import jdk.jshell.spi.ExecutionControl;
import org.junit.jupiter.api.Test;
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
        assertEquals(1, system.getAllSuppliers().size(), "1 supplier has been created.");

        try
        {
            system.addSupllier("1", "Elite");
        }
        catch (Exception ex)
        {
            exception = ex;
        }

        assertEquals("Supplier ID already exist.", ex1.getMessage(),  "Check uniqueness of id.");

        Supplier supplier1 = system.getAllSuppliers().get("1");
        assertEquals(0, supplier1.getProducts().size(), "Supplier has no products.");

    }

}