package quanpnph29471.example.quanlykhohang.Model;

public class Product {
    private int id_product,id_productType,price,quantity;
    private String name_product,describe;

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getId_productType() {
        return id_productType;
    }

    public void setId_productType(int id_productType) {
        this.id_productType = id_productType;
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

    public Product() {
    }

    public Product(int id_product, int id_productType, int price, int quantity, String name_product, String describe) {
        this.id_product = id_product;
        this.id_productType = id_productType;
        this.price = price;
        this.quantity = quantity;
        this.name_product = name_product;
        this.describe = describe;
    }
}
