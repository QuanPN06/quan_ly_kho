package quanpnph29471.example.quanlykhohang.Model;

public class Detail {
    private int id_invoice,id_product,quantity,price;

    public int getId_invoice() {
        return id_invoice;
    }

    public void setId_invoice(int id_invoice) {
        this.id_invoice = id_invoice;
    }

    public int getId_product() {
        return id_product;
    }

    public void setId_product(int id_product) {
        this.id_product = id_product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Detail() {
    }

    public Detail(int id_invoice, int id_product, int quantity, int price) {
        this.id_invoice = id_invoice;
        this.id_product = id_product;
        this.quantity = quantity;
        this.price = price;
    }
}
