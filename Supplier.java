import java.util.*;


public class Supplier {
    private static int numOfSuppliers = 0;
    private final String object_id;    


    private String id;
    private String name;

    // Links
    private Set<Product> products;


    public Supplier(String id, String name) {
        this.object_id = "SU" + String.valueOf(numOfSuppliers++);
        this.id = id;
        this.name = name;
        this.products = new HashSet<>();
    }

}
