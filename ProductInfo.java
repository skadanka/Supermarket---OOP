
public class ProductInfo{
    Product product;
    int price;
    int quantity;
    float discount;
    int minForDiscount;

    public ProductInfo(Product product, int price, int quantity, float discount, int minForDiscount){
        this.product = product;
        this.price = price;
        this.discount = discount;
        this.quantity = quantity;
        this.minForDiscount = minForDiscount;
    }

    public Product getProduct(){
        return this.product;
    }

    public int getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getDiscount() {
        return this.discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getMinForDiscount() {
        return this.minForDiscount;
    }

    public void setMinForDiscount(int minForDiscount) {
        this.minForDiscount = minForDiscount;
    }

}