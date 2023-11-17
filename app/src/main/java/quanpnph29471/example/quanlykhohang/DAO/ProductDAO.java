package quanpnph29471.example.quanlykhohang.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import quanpnph29471.example.quanlykhohang.DbHelper;
import quanpnph29471.example.quanlykhohang.Model.Product;
import quanpnph29471.example.quanlykhohang.Model.Category;

public class ProductDAO {

    DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public ProductDAO(Context context){
        dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public ArrayList<Product> getAllData(){
        String sql = "SELECT * FROM tbl_product";
        return getData(sql);
    }

    @SuppressLint("Range")
    public ArrayList<Product> getData(String sql, String...SelectAvg) {
        ArrayList<Product> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tbl_product",SelectAvg);
        while (cursor.moveToNext()){
            Product obj = new Product();
            obj.setId_product(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id_product"))));
            obj.setId_category(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id_category"))));
            obj.setName_product(cursor.getString(cursor.getColumnIndex("name_product")));
            obj.setQuantity(cursor.getInt(cursor.getColumnIndex("quantity")));
            obj.setPrice(cursor.getInt(cursor.getColumnIndex("price")));
            obj.setDescribe(cursor.getString(cursor.getColumnIndex("describe")));
            list.add(obj);
        }
        return list;
    }

    public long insert(Product obj){
        ContentValues values = new ContentValues();
        values.put("id_category",obj.getId_category());
        values.put("name_product",obj.getName_product());
        values.put("quantity",obj.getQuantity());
        values.put("price",obj.getPrice());
        values.put("describe",obj.getDescribe());

        return sqLiteDatabase.insert("tbl_product", null, values);
    }

    public int update(Product obj){
        ContentValues values = new ContentValues();

        values.put("id_category",obj.getId_category());
        values.put("name_product",obj.getName_product());
        values.put("quantity",obj.getQuantity());
        values.put("price",obj.getPrice());
        values.put("describe",obj.getDescribe());
        return sqLiteDatabase.update("tbl_product", values,"id_product = ?", new String[]{String.valueOf(obj.getId_product())});
    }

    public int delete(int ID) {
        return sqLiteDatabase.delete("tbl_product", "id_product = ?", new String[]{String.valueOf(ID)});
    }

    public Product getById(int id) {
        Cursor cursor = sqLiteDatabase.query("tbl_product", null,"id_product = ?",
                new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToNext()){
            return new Product(
                    cursor.getInt(0),
                    cursor.getInt(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getInt(4),
                    cursor.getString(5))
                    ;
        }else {
            return null;
        }
    }
}
