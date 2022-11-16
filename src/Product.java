import java.util.*;


public class Product {
   private static int numOfProducts = 0;
   private final String objectId;

   private String id;
   private String name;
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

    public void setOwner(PremiumAccount premiumAccount)
    {
        this.owendByAccount = premiumAccount;
    }

    public void deleteProduct(){
        for (LineItem li : this.getLineItems()) {
            li.getOrder().deleteFromItems(li);
            li.getShoppingCart().deleteFromItems(li);
        }
        allProducts.remove(this.name);
        this.supplier.deleteFromProducts(this.name);
        if (owendByAccount != null)
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


    public String showObject()
    {
        return "Product: " + this.getObjectID();
    }



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


    public String toString() {
        String part1 = "Product: " + this.getObjectID() +
                "\nID: " + this.id+
                "\nName: " + this.name+
                "\nConnected Objects: " +
                "\nSupplier: " + this.getObjectID();
        StringBuilder part2 = new StringBuilder();

        if (this.owendByAccount != null)
            part2.append("\nPremium Account: " + this.owendByAccount.getObjectID());
        if (this.getLineItems().size() != 0)
        {
            for (LineItem li:
                    this.getLineItems()) {
                part2.append("\n" + li.getID());
            }

        }

        return part1 + part2.toString();
    }
}
