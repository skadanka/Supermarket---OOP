import java.util.*;

import javax.xml.stream.events.StartElement;


public class Supplier {
    private static int numOfSuppliers = 0;
    private final String object_id;

//    private static HashMap<String, Supplier> allSuppliers = new HashMap<>();
    private String id;
    private String name;

    // Links
    private Map<String, Product> products;

//    public static Supplier getSupplier(String supplierName){
//        return allSuppliers.get(supplierName);
//    }

    public Supplier(String id, String name) {
        this.object_id = "SU" + String.valueOf(numOfSuppliers++);
        this.id = id;
        this.name = name;
        this.products = new HashMap<>();
//        addToAllSuppliers(this);
    }
    public String showObject()
    {
        return "Supplier: " + this.getObjectID();
    }

    public String getObjectID(){
        return this.object_id;
    }
    
    /**
     * @return Map of all the suppliers.
     */
//    public static Collection<Supplier> getRegisteredSuppliers() {
//        return allSuppliers.values();
//    }

//    public static Supplier getSpecificSupp(String id) {
//        return allSuppliers.get(id);
//    }

    /**
     * ?????
     */
//    public static void addToAllSuppliers(Supplier supplier) {
//        allSuppliers.put(supplier.id, supplier);
//    }

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


    /**
     * ?????
     */


    @Override
    public String toString() {
        String part1 = "Supplier: " + this.getObjectID() +
                "\nID: " + this.id+
                "\nName: " + this.name;


        StringBuilder prod = new StringBuilder();

        if (this.getProducts().size() != 0)
        {
            prod.append("\nConnected Items: ");
            for (Product p:
                    this.getProducts()) {
                prod.append("\n").append(p.getObjectID());
            }

        }

        return part1 + prod.toString();
    }




}
