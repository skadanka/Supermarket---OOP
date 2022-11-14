import java.util.*;


public class Product {
   private static int numOfProducts = 0;
   private final String objectId;

   private String id;
   private String name;

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
        }

    public Product(String id, String name, Supplier supplier) {
            this.objectId = 'P'  + String.valueOf(numOfProducts++);
            this.id = id;
            this.name = name;
            this.supplier = supplier;
            this.lineItems = new HashSet<>();
            this.owendByAccount = null;
        }

    public String getName(){
        return this.name;
    }
}
