package com.sonmob.sqlitedemo.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.sonmob.sqlitedemo.model.Student;

import java.util.ArrayList;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "QLSV.db";
    private static final String TB_NAME = "SMG";
    private static final int VERSION = 1;



    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE SMG(maSV TEXT PRIMARY KEY, nameSV TEXT, emailSV TEXT, phoneSV INTERGER)";
        db.execSQL(sql);
//        sql = " INSERT INTO LOP VALUES ('LT1','XUAN', 'UAN@GJJG.COM', 0123456)";
//        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TB_NAME);
    }


    public ArrayList getAllItem(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        ArrayList<Student> lstStudent  = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM " + TB_NAME, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            String masv = cursor.getString(0);
            String namesv = cursor.getString(1);
            String emailsv = cursor.getString(2);
            int phonesv = cursor.getInt(3);
            Student s = new Student(masv,namesv,emailsv,phonesv);
            lstStudent.add(s);
            cursor.moveToNext();
        }
        return  lstStudent;
    }

    public boolean insertItem(Student student){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("maSV", student.getMaSV());
        values.put("nameSV", student.getNameSV());
        values.put("emailSV", student.getEmailSV());
        values.put("phoneSV", student.getPhoneSV());
        long r = sqLiteDatabase.insert("SMG", null, values);

        return  r > 0;
    }

    public boolean updateItem(Student student){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("maSV", student.getMaSV());
        values.put("nameSV", student.getNameSV());
        values.put("emailSV", student.getEmailSV());
        values.put("phoneSV", student.getPhoneSV());
        sqLiteDatabase.update(TB_NAME,values,"maSV = ?", new String[] { student.getMaSV()});
        return true;
    }

    public boolean deleteItem(String maSV){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TB_NAME,"maSV = ?", new String[] { maSV});
        return true;
    }

}
