import java.util.*;


public class Product {
   private static int numOfProducts = 0;
   private final String objectId;

   private String id;
   private String name;
   private int price;
   private int quantity;
    private static HashMap<String, Product> allProducts = new HashMap<>();

   // Links
   private Supplier supplier;
   private Account owendByAccount; 
   private Set<Product> lineItems;

    public Product(String id, String name, Supplier supplier, Account owendByAccount) {
            this.objectId = "PR"  + String.valueOf(numOfProducts++);
            this.id = id;
            this.name = name;
            this.supplier = supplier;
            this.owendByAccount = owendByAccount;
            this.lineItems = new HashSet<>();
            addToAllProducts(this,name);
        }


    public Product(String id, String name, Supplier supplier) {
            this.objectId = 'P'  + String.valueOf(numOfProducts++);
            this.id = id;
            this.name = name;
            this.supplier = supplier;
            this.lineItems = new HashSet<>();
            this.owendByAccount = null;
            addToAllProducts(this,name);
        }

    /**
     * @return Map of all the products.
     */
    public static HashMap<String, Product> getAllProducts() {
        return allProducts;
    }

    /**
     * ?????
     */
    public static void addToAllProducts(Product p, String name) {
        allProducts.put(name,p);
    }

    /**
     * @return id of the product.
     */
    public String getId() {
        return id;
    }

    /**
     * @return name of the product.
     */
    public String getName() { return name;}

    /**
     * @return object id of the product.
     */
    public String getObjectID() { return objectId; }

    /**
     * @return ???.
     */
    public Supplier getSupplier() { return supplier; }

    /**
     * @return ???.
     */
    public Set<Product> getLineItems() { return lineItems; }

    /**
     * @return ???.
     */
    public Account getOwendByAccount() { return owendByAccount; }

    public void setPrice(int price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
