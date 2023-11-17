package quanpnph29471.example.quanlykhohang;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "data";
    private static final int DB_VERSION = 1;

    public DbHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static final String TABLE_USER_CREATE ="CREATE TABLE IF NOT EXISTS " +
            "tbl_user (" +
            "    id       INTEGER   PRIMARY KEY AUTOINCREMENT," +
            "    username TEXT (50) NOT NULL" +
            "                       UNIQUE," +
            "    password TEXT (50) NOT NULL," +
            "    fullname TEXT (50) NOT NULL," +
            "    email    TEXT (50) NOT NULL" +
            ")";

    public static final String TABLE_PRODUCTTYPE_CREATE ="CREATE TABLE IF NOT EXISTS " +
            "tbl_category (" +
            "    id_category INTEGER PRIMARY KEY AUTOINCREMENT," +
            "    name       TEXT    NOT NULL" +
            ") ";

    public static final String TABLE_PRODUCT_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "tbl_product  (" +
            "    id_product     INTEGER PRIMARY KEY AUTOINCREMENT," +
            "    id_category INTEGER REFERENCES tbl_category (id_category) " +
            "                           NOT NULL," +
            "    name_product   TEXT    NOT NULL" +
            "                           UNIQUE," +
            "    price          INTEGER NOT NULL," +
            "    quantity       INTEGER NOT NULL," +
            "    describe       TEXT" +
            ")";

    public static final String TABLE_INVOICE_CREATE = "CREATE TABLE IF NOT EXISTS " +
            "tbl_invoice (" +
            "    id_invoice   INTEGER PRIMARY KEY AUTOINCREMENT," +
            "    id_user      INTEGER REFERENCES tbl_User (id) " +
            "                         NOT NULL," +
            "    invoice_type INTEGER NOT NULL," +
            "    date         TEXT    NOT NULL" +
            ")";

    public static final String TABLE_DETAIL_CREATE = "CREATE TABLE IF NOT EXISTS " +
            " tbl_detail (" +
            "    id_invoice INTEGER REFERENCES tbl_invoice (id_invoice) " +
            "                       NOT NULL," +
            "    id_product INTEGER REFERENCES tbl_product (id_product) " +
            "                       NOT NULL," +
            "    quantity   INTEGER NOT NULL," +
            "    price      INTEGER NOT NULL" +
            ")";


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_USER_CREATE);

        db.execSQL(TABLE_PRODUCT_CREATE);

        db.execSQL(TABLE_PRODUCTTYPE_CREATE);

        db.execSQL(TABLE_DETAIL_CREATE);

        db.execSQL(TABLE_INVOICE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1) {
            db.execSQL("DROP TABLE IF EXISTS tbl_User");
            db.execSQL("DROP TABLE IF EXISTS tbl_category");
            db.execSQL("DROP TABLE IF EXISTS tbl_product");
            db.execSQL("DROP TABLE IF EXISTS tbl_invoice");
            db.execSQL("DROP TABLE IF EXISTS tbl_detail");
            onCreate(db);
        }
    }
}
