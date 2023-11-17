package quanpnph29471.example.quanlykhohang.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import quanpnph29471.example.quanlykhohang.DbHelper;
import quanpnph29471.example.quanlykhohang.Model.Detail;

public class DetailDAO {
    DbHelper dbHelper;
    SQLiteDatabase db;

    public DetailDAO(Context ct){
        dbHelper = new DbHelper( ct ) ;
        db = dbHelper.getWritableDatabase();
    }

    public ArrayList<Detail> getList(){

        ArrayList<Detail> listObj = new ArrayList<>();

        Cursor c = db.rawQuery("SELECT * FROM tbl_detail ", null);
        if(c.getCount()>0){
            c.moveToFirst(); // đưa trỏ về đầu dòng
            do {
                Detail obj = new Detail();
                obj.setId_invoice(c.getInt(0));
                obj.setId_product(c.getInt(1));
                obj.setQuantity(c.getInt(2));
                obj.setPrice(c.getInt(3));

                // cho đối tượng vào danh sách
                listObj.add( obj );

            }while (c.moveToNext());
        }else{
            Log.d("zzzzzzzzzzzz", "getList: Không có dữ liệu");
        }
        return  listObj;
    }

    public long insert(Detail obj){
        ContentValues values = new ContentValues();
        values.put("id_invoice",obj.getId_invoice());
        values.put("id_product",obj.getId_product());
        values.put("quantity",obj.getQuantity());
        values.put("price",obj.getPrice());
        return db.insert("tbl_detail",null,values);
    }

}
