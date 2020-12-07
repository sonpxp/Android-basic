package com.sonmob.lab6.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.sonmob.lab6.database.SQLiteHelper;
import com.sonmob.lab6.model.Product;

public class ProductDAO {
    private SQLiteDatabase db;
    private SQLiteHelper dbHelper;
    private  Context context;

    public static final String SQL_TAO_BANG_PRODUCT = "CREATE TABLE product (" +
            "maSP text primary key, tenSP text, soLuongSP text)";
    public static final  String TABLE_NAME = "product";

    public ProductDAO(Context context) {
        this.context = context;
        dbHelper = new SQLiteHelper(context);
        db=dbHelper.getWritableDatabase();
    }

    //insert
    public int insertProduct(Product product){
        ContentValues values = new ContentValues();
        values.put("maSP", product.getMaSP());
        values.put("tenSP", product.getTenSP());
        values.put("soLuongSP", String.valueOf(product.getSoLuongSP()));
        if (db.insert(TABLE_NAME, null, values)<0){
            return  -1; // insert khong thanh cong
        }else {
            return  1; // insert thanh cong
        }
    }

    public int deleteProduct(String maSP){
        if (db.delete(TABLE_NAME,"maSP=?", new String[]{maSP})<0){
            return  -1;// xoa ko thanh cong
        }else {
            return  1;// xoa thanh cong
        }
    }
}
