public class LineItem {
    private static int numOfLineItems = 0;

    private final String id;

    private int quantity;
    private int price;


    public LineItem() {
        this.id = String.valueOf(numOfLineItems++);
    }

    public LineItem(int quantity, int price) {
        this.id = String.valueOf(numOfLineItems++);
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LineItem quantity(int quantity) {
        setQuantity(quantity);
        return this;
    }

    public LineItem price(int price) {
        setPrice(price);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof LineItem)) {
            return false;
        }
        LineItem lineItem = (LineItem) o;
        return this.id == lineItem.id; 
    }

    // @Override
    // public int hashCode() {
    //     return Objects.hash(quantity, price);
    // }

    @Override
    public String toString() {
        return "{" +
            " quantity='" + getQuantity() + "'" +
            ", price='" + getPrice() + "'" +
            "}";
    }
}