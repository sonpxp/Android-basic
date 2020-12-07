package com.sonmob.lab5;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class SQLiteHelper extends SQLiteOpenHelper {


    public static final String DBNAME = "QLBanHang";
    public static final int VERSION = 1;
    public static final String CREATE_TABLE_PRODUCT = "CREATE TABLE PRODUCT(" +
            " id text primary key, "+
            " name text, "+
            " price real, "+
            " image real "+
            ")";

    public static final String TABLE_NAME = "PRODUCT";
    public SQLiteHelper(@Nullable Context context) {
        super(context, DBNAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PRODUCT);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
    }
}
