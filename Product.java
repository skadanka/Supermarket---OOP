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
   private Map<String, LineItem> lineItems;

    public Product(String id, String name, Supplier supplier, Account owendByAccount) {
            this.objectId = "PR"  + String.valueOf(numOfProducts++);
            this.id = id;
            this.name = name;
            this.supplier = supplier;
            this.owendByAccount = owendByAccount;
            this.lineItems = new HashMap<>();
            addToAllProducts(this);
        }


    public Product(String id, String name, Supplier supplier) {
            this.objectId = "PR"  + String.valueOf(numOfProducts++);
            this.id = id;
            this.name = name;
            this.supplier = supplier;
            this.lineItems = new HashMap<>();
            this.owendByAccount = null;
            addToAllProducts(this);
        }

    /**
     * @return Map of all the products.
     */
    public static Collection<Product> getAllProducts() {
        return allProducts.values();
    }

    /**
     * ITS COOl
     */
    public static void addToAllProducts(Product p) {
        allProducts.put(p.name ,p);
    }
       
    public static Product getProduct(String productName){
        return allProducts.get(productName);
    }


    public void deleteProduct(){
        for (LineItem li : this.getLineItems()) {
            li.getOrder().deleteFromItems(li);
            li.getShoppingCart().deleteFromItems(li);
        }
        allProducts.remove(this.name);
        this.supplier.deleteFromProducts(this.name);
        ((PremiumAccount)this.owendByAccount).deleteFromProducts(this.name);
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
    public Collection<LineItem> getLineItems() { return lineItems.values(); }

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
