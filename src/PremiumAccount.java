import java.util.*;


public class PremiumAccount extends Account{
    
    private Map<String, ProductInfo> products;

    public PremiumAccount(String id, String billing_address, Customer c) {
        super(id, billing_address, c);
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
        product.setOwner(this);
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

    /**
     * @return Class name + object Id.
     */
    public String getObjectID()
    {
        return super.getObjectID();
    }
    public String showObject()
    {
        return "Premium " + super.showObject();
    }
    @Override
    public String toString() {
        String part1 = "Premium Account: " + this.getObjectID() +
                "\nID: " + this.getID()+
                "\nBilling Address: " + this.getBilling_address()+
                "\nIs Closed: false" +
                "\nOpen: " + this.getOpen().toString()+
                "\nClosed: TBD" +
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
        StringBuilder prod1 = new StringBuilder();

        for (ProductInfo pr:
                this.products.values()) {
            prod1.append("\n" + pr.getProduct().getObjectID());
        }
        return part1 + orders + payments + prod1;
    }

}
