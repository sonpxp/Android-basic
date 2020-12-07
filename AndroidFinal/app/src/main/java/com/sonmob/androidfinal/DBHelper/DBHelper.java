package com.sonmob.androidfinal.DBHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.sonmob.androidfinal.model.Users;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Users.db";
    private static final String TB_NAME = "User";
    private static final int VERSION = 1;


    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE User(email TEXT PRIMARY KEY, password TEXT)";
        db.execSQL(sql);

        sql = " INSERT INTO User VALUES ('LT1@gamil.com','ahihi')";
        db.execSQL(sql);
        sql = " INSERT INTO User VALUES ('LT2@gamil.com','ahihi2')";
        db.execSQL(sql);
        sql = " INSERT INTO User VALUES ('LT3@gamil.com','ahihi3')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TB_NAME);
    }

    public ArrayList getAllItem(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<Users> listUser  = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TB_NAME, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String email = cursor.getString(0);
            String password = cursor.getString(1);
            Users users = new Users(email, password);
            listUser.add(users);
            cursor.moveToNext();
        }
        return  listUser;
    }

    public boolean insertItem(Users users){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("email", users.getEmail());
        values.put("password", users.getPassword());
        long r = sqLiteDatabase.insert(TB_NAME, null, values);

        return  r > 0;
    }

//    public boolean updateItem(Users users){
//        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
//        ContentValues values = new ContentValues();
//        values.put("email", users.getEmail());
//        values.put("password", users.getPassword());
//        sqLiteDatabase.update(TB_NAME,values,"email = ?", new String[] { users.getEmail()});
//        return true;
//    }
//
//    public boolean deleteItem(String email){
//        SQLiteDatabase db = this.getWritableDatabase();
//        db.delete(TB_NAME,"email = ?", new String[] {email});
//        return true;
//    }
}
