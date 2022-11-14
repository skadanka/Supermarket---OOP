import java.util.*;


public class PremiumAccount extends Account{
    
    private Map<String, ProductInfo> products;
  
    public PremiumAccount(List<Product> products, String billing_address, boolean is_closed, Date open, Date closed, int balance) {
        super(billing_address, is_closed, closed, billing_address, balance);
        this.products = new HashMap<>();
    }
    
    public boolean addProduct(Product product, int price, float discount, int quantity, int minForDiscount){
        if(price < 0)
            return false;
        if(discount > 1 && discount < 0)
            return false;
        if(quantity < 0)
            return false;
        if(minForDiscount < 0)
            return false;
        
        ProductInfo productInfo = new ProductInfo(product, price, quantity, discount, minForDiscount);
        products.put(product.getName(), productInfo);
        return true;
    }

    public  boolean ownProduct(String productName){
        return  products.containsKey(productName);
    }   

    public ProductInfo getProduct(String productName){
        return products.get(productName);
    }

    @Override
    public String toString() {
        return "{" +
            " products='" + this.products + "'" +
            "}";
    }

}
