import java.util.*;


public class Supplier {
    private static int numOfSuppliers = 0;
    private final String object_id;

    private static HashMap<String, Supplier> allSuppliers = new HashMap<>();
    private String id;
    private String name;

    // Links
    private Set<Product> products;


    public Supplier(String id, String name) {
        this.object_id = "SU" + String.valueOf(numOfSuppliers++);
        this.id = id;
        this.name = name;
        this.products = new HashSet<>();
        addToAllSuppliers(this,name);
    }

    /**
     * @return Map of all the suppliers.
     */
    public static HashMap<String, Supplier> getRegisteredSuppliers() { return allSuppliers; }

    /**
     * ?????
     */
    public static void addToAllSuppliers(Supplier s, String name) {
        allSuppliers.put(name,s);
    }

    /**
     * ?????
     */
    public void addProducts(Product p) { this.products.add(p); }

    /**
     * ?????
     */
    public void deleteFromProducts(Product p) {
        if(products.contains(p))
            this.products.remove(p);
    }

}
