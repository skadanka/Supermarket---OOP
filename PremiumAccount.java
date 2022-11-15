import java.util.*;


public class PremiumAccount extends Account{
    
    private Map<String, ProductInfo> products;

    public PremiumAccount(String billing_address, String id) {
        super(id, billing_address);
        this.products = new HashMap<>();
    }

//    public boolean addProduct(Product product, int price, float discount, int quantity, int minForDiscount){
//        if(price < 0)
//            return false;
//        if(discount > 1 && discount < 0)
//            return false;
//        if(quantity < 0)
//            return false;
//        if(minForDiscount < 0)
//            return false;
//
//        ProductInfo productInfo = new ProductInfo(product, price, quantity, discount, minForDiscount);
//        products.put(product.getName(), productInfo);
//        return true;
//    }



    public void addProduct(Product product, float price, int quantity){
        ProductInfo productInfo = new ProductInfo(product, price, quantity);
        products.put(product.getName(), productInfo);
    }

    public void deleteFromProducts(String productName){
        products.remove(productName);
    }

    public  boolean ownProduct(String productName){
        return  products.containsKey(productName);
    }

    public ProductInfo getProduct(String productName){
        return products.get(productName);
    }


    @Override
    public String toString() {
        String part1 = "Premium Account: " + this.getObjectID() +
                "\nID: " + this.getID()+
                "\nBilling Address: " + this.getBilling_address()+
                "\nIs Closed: " + this.getClosed()+
                "\nOpen: " + this.getOpen().toString()+
                "\nClosed: " + this.getClosed().toString()+
                "\nBalance: " + this.getBalance()+

                "\nConnected Items: " +
                "\n" + this.getShoppingCart().getObjectID();

        StringBuilder orders = new StringBuilder();
        for (Order o:
                this.getOrders()) {
            orders.append("\n" + o.getObjectID());
        }
        StringBuilder payments = new StringBuilder();
        for (Payment p:
                this.getPayments()) {
            payments.append("\n" + p.getObjectID());
        }

        return part1 + orders + payments;
    }

}
