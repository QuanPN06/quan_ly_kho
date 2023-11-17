package quanpnph29471.example.quanlykhohang.Model;

public class Product {
    private int id_product,id_category,price,quantity;
    private String name_product,describe;

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_category() {
        return id_category;
    }

    public void setId_category(int id_category) {
        this.id_category = id_category;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public Product(int id_product, int id_category, String name_product, int price, int quantity, String describe) {
        this.id_product = id_product;
        this.id_category = id_category;
        this.price = price;
        this.quantity = quantity;
        this.name_product = name_product;
        this.describe = describe;
    }

    public Product() {
    }
}
