package quanpnph29471.example.quanlykhohang.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import quanpnph29471.example.quanlykhohang.DbHelper;
import quanpnph29471.example.quanlykhohang.Model.Category;

public class CategoryDAO {
    DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public CategoryDAO(Context context){
        dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public ArrayList<Category> getAllData(){
        String sql = "SELECT * FROM tbl_category";
        return getData(sql);
    }

    @SuppressLint("Range")
    public ArrayList<Category> getData(String sql, String...SelectAvg) {
        ArrayList<Category> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tbl_category",SelectAvg);
        while (cursor.moveToNext()){
            Category obj = new Category();
            obj.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id_category"))));
            obj.setName(cursor.getString(cursor.getColumnIndex("name")));

            list.add(obj);
        }
        return list;
    }

    public long insert(Category obj){
        ContentValues values = new ContentValues();
        values.put("name", obj.getName());
        return sqLiteDatabase.insert("tbl_category", null, values);
    }

    public int update(Category obj){
        ContentValues values = new ContentValues();

        values.put("name", obj.getName());
        return sqLiteDatabase.update("tbl_category", values,"id_category = ?", new String[]{String.valueOf(obj.getId())});
    }

    public int delete(int ID) {
        return sqLiteDatabase.delete("tbl_category", "id_category = ?", new String[]{String.valueOf(ID)});
    }

    public Category getById(int id) {
        Cursor cursor = sqLiteDatabase.query("tbl_category", null,"id_category = ?",
                new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToNext()){
            return new Category(
                    cursor.getInt(0),
                    cursor.getString(1))
                    ;
        }else {
            return null;
        }
    }


}
