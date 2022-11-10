import java.util.*;


public class PremiumAccount extends Account{
    
    private List<Prodcut> products;

    public PremiumAccount() {
    }

    public PremiumAccount(List<Prodcut> products, String billing_address, boolean is_closed, Date open, Date closed, int balance) {
        super(billing_address, is_closed, open, closed, balance);
        this.products = products;
    }

    public List<Prodcut> getProducts() {
        return this.products;
    }

    public void setProducts(List<Prodcut> products) {
        this.products = products;
    }

    public PremiumAccount products(List<Prodcut> products) {
        setProducts(products);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
            " products='" + getProducts() + "'" +
            "}";
    }

}
