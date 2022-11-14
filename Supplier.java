import java.util.*;

import javax.xml.stream.events.StartElement;


public class Supplier {
    private static int numOfSuppliers = 0;
    private final String object_id;

    private static HashMap<String, Supplier> allSuppliers = new HashMap<>();
    private String id;
    private String name;

    // Links
    private Map<String, Product> products;

    public static Supplier getSupplier(String supplierName){
        return allSuppliers.get(supplierName);
    }

    public Supplier(String name) {
        this.object_id = "SU" + String.valueOf(numOfSuppliers++);
        this.name = name;
        this.products = new HashMap<>();
        addToAllSuppliers(this);
    }

    public String getObjectID(){
        return this.object_id;
    }
    
    /**
     * @return Map of all the suppliers.
     */
    public static Collection<Supplier> getRegisteredSuppliers() { 
        return allSuppliers.values(); 
    }

    /**
     * ?????
     */
    public static void addToAllSuppliers(Supplier supplier) {
        allSuppliers.put(supplier.name, supplier);
    }

    public Collection<Product> getProducts(){
        return this.products.values();
    }

    /**
     * ?????
     */
    public void addProducts(Product product) { 
        this.products.put(product.getName(), product); 
    }

    /**
     * ?????
     */
    public void deleteFromProducts(String productName) {
            this.products.remove(productName);
    }


}
