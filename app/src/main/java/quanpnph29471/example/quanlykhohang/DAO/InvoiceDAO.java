package quanpnph29471.example.quanlykhohang.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import quanpnph29471.example.quanlykhohang.DbHelper;
import quanpnph29471.example.quanlykhohang.Model.Invoice;
import quanpnph29471.example.quanlykhohang.Model.Product;

public class InvoiceDAO {

    DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public InvoiceDAO(Context context){
        dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public ArrayList<Invoice> getAllData(){
        String sql = "SELECT * FROM tbl_invoice";
        return getData(sql);
    }

    @SuppressLint("Range")
    public ArrayList<Invoice> getData(String sql, String...SelectAvg) {
        ArrayList<Invoice> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tbl_invoice",SelectAvg);
        while (cursor.moveToNext()){
            Invoice obj = new Invoice();
            obj.setId_invoice(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id_product"))));
            obj.setId_user(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id_category"))));
            obj.setInvoice_type(cursor.getInt(cursor.getColumnIndex("name_product")));
            obj.setDate(cursor.getString(cursor.getColumnIndex("quantity")));

            list.add(obj);
        }
        return list;
    }

    public long insert(Invoice obj){
        ContentValues values = new ContentValues();

        values.put("id_user",obj.getId_user());
        values.put("invoice_type",obj.getInvoice_type());
        values.put("date",obj.getDate());

        return sqLiteDatabase.insert("tbl_invoice", null, values);
    }

    public int update(Invoice obj){
        ContentValues values = new ContentValues();

        values.put("id_user",obj.getId_user());
        values.put("invoice_type",obj.getInvoice_type());
        values.put("date",obj.getDate());
        return sqLiteDatabase.update("tbl_invoice", values,"id_invoice = ?", new String[]{String.valueOf(obj.getId_invoice())});
    }

    public int delete(int ID) {
        return sqLiteDatabase.delete("tbl_invoice", "id_invoice = ?", new String[]{String.valueOf(ID)});
    }

    public Invoice getById(int id) {
        Cursor cursor = sqLiteDatabase.query("tbl_invoice", null,"id_invoice = ?",
                new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToNext()){
            return new Invoice(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getInt(2),
                    cursor.getString(3));
        }else {
            return null;
        }
    }
}
