public class Customer {
   private static int numOfCustomers = 0;

    private final String name;

    private String Address;
    private String phone;
    private String email;



    public Customer() {
       this.name = String.valueOf(numOfCustomers++); 
    }

    public Customer(String Address, String phone, String email) {
        this.name = String.valueOf(numOfCustomers++); 
        this.Address = Address;
        this.phone = phone;
        this.email = email;
    }

    public String getAddress() {
        return this.Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Customer Address(String Address) {
        setAddress(Address);
        return this;
    }

    public Customer phone(String phone) {
        setPhone(phone);
        return this;
    }

    public Customer email(String email) {
        setEmail(email);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Customer)) {
            return false;
        }
        Customer customer = (Customer) o;
        return this.name == customer.name;
    }


    @Override
    public String toString() {
        return "{" +
            " Address='" + getAddress() + "'" +
            ", phone='" + getPhone() + "'" +
            ", email='" + getEmail() + "'" +
            "}";
    }
}