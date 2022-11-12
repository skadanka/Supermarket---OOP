import java.util.*;


public class PremiumAccount extends Account{
    
    private Set<Product> products;

    public PremiumAccount(List<Product> products, String billing_address, boolean is_closed, Date open, Date closed, int balance) {
        super(billing_address, is_closed, closed, billing_address, balance);
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

    @Override
    public String toString() {
        return "{" +
            " products='" + getProducts() + "'" +
            "}";
    }

}
