package com.sonmob.lab6.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.sonmob.lab6.adapter.ProductDAO;

public class SQLiteHelper extends SQLiteOpenHelper {
    public static  final String DB_NAME="QLSP";
    public static  final int VERSION=1;

    public SQLiteHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
            db.execSQL(ProductDAO.SQL_TAO_BANG_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
            db.execSQL("DROP TABLE IF EXISTS "+ProductDAO.TABLE_NAME);
    }
}
