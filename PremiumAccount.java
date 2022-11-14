import java.util.*;


public class PremiumAccount extends Account{
    
    private Set<Product> products;

    public PremiumAccount(String id, String billingAddress){
        super(id, billingAddress);
        this.products = new HashSet<>();
    }

    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public PremiumAccount products(Set<Product> products) {
        setProducts(products);
        return this;
    }

    public void addProduct(Product p){ this.products.add(p); }

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
