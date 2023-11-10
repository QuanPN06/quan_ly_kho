package quanpnph29471.example.quanlykhohang.Model;

public class Invoice {
    private int id_invoice,id_user,invoice_type;
    private String date;

    public int getId_invoice() {
        return id_invoice;
    }

    public void setId_invoice(int id_invoice) {
        this.id_invoice = id_invoice;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public int getInvoice_type() {
        return invoice_type;
    }

    public void setInvoice_type(int invoice_type) {
        this.invoice_type = invoice_type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Invoice() {
    }

    public Invoice(int id_invoice, int id_user, int invoice_type, String date) {
        this.id_invoice = id_invoice;
        this.id_user = id_user;
        this.invoice_type = invoice_type;
        this.date = date;
    }
}
