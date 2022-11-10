# Project1
![Class Diagram](https://user-images.githubusercontent.com/62882347/201133731-ee75ddcb-9efb-412d-8b68-bd1b6ff68439.jpg)


##### Eden 10/11/22
The Basic Structure of the project Done.
More Disscusion about the Classes relashionship and fields.


## System Startup

### Suppliers
- s1 = createSupplier(String id ="Osem", String name="Osem")
- s2 = createSupplier(String id ="EastWest", String name="EastWest")

### Product
- p1 = createProduct(String id ="Bamba", String name="Bamba") : Supplier_id="Osem"
- p2 = createProduct(String id="Ramen, String name="Ramen", ) : Supplier_id="EastWest"

### Account
- a1 = createAccount(String login_id="Dani", String password="Dani123") products: []
- a2 = createAccount(String login_id="Dana", String password="Dana123") : products : ["Bamba"]

