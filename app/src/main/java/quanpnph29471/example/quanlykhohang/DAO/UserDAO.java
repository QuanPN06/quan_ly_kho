package quanpnph29471.example.quanlykhohang.DAO;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import quanpnph29471.example.quanlykhohang.DbHelper;
import quanpnph29471.example.quanlykhohang.Model.User;

public class UserDAO {
    DbHelper dbHelper;
    private SQLiteDatabase sqLiteDatabase;

    public UserDAO(Context context){
        dbHelper = new DbHelper(context);
        sqLiteDatabase = dbHelper.getWritableDatabase();
    }

    public ArrayList<User> getAllData(){
        String sql = "SELECT * FROM tbl_user";
        return getData(sql);
    }

    @SuppressLint("Range")
    public ArrayList<User> getData(String sql, String...SelectAvg) {
        ArrayList<User> list = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM tbl_user",SelectAvg);
        while (cursor.moveToNext()){
            User obj = new User();
            obj.setId(Integer.parseInt(cursor.getString(cursor.getColumnIndex("id"))));
            obj.setUserName(cursor.getString(cursor.getColumnIndex("username")));
            obj.setFullname(cursor.getString(cursor.getColumnIndex("fullname")));
            obj.setPassword(cursor.getString(cursor.getColumnIndex("password")));
            obj.setEmail(cursor.getString(cursor.getColumnIndex("email")));
            list.add(obj);
        }
        return list;
    }

    public long insert(User obj){
        ContentValues values = new ContentValues();
        values.put("username", obj.getUserName());
        values.put("password", obj.getPassword());
        values.put("fullname", obj.getFullname());
        values.put("email", obj.getEmail());
        return sqLiteDatabase.insert("tbl_user", null, values);
    }

    public int update(User obj){
        ContentValues values = new ContentValues();

        values.put("username", obj.getUserName());
        values.put("password", obj.getPassword());
        values.put("fullname", obj.getFullname());
        values.put("email", obj.getEmail());
        return sqLiteDatabase.update("tbl_user", values,"id = ?", new String[]{String.valueOf(obj.getId())});
    }

    public int delete(int ID) {
        return sqLiteDatabase.delete("tbl_user", "id = ?", new String[]{String.valueOf(ID)});
    }

    public User getById(int id) {
        Cursor cursor = sqLiteDatabase.query("tbl_user", null,"id = ?",
                new String[]{String.valueOf(id)}, null, null, null);
        if (cursor.moveToNext()){
            return new User(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4));
        }else {
            return null;
        }
    }

}
