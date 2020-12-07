package com.sonmob.studentmanager.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "QUANLYSINHVIENFPTDB.sqlite";
    public static final int VERSION = 1;

    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = " CREATE TABLE LOP(maLop TEXT PRIMARY KEY, tenLop TEXT)";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('LT1','Lap Trinh Android')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('LT2','Lap Trinh PHP')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('LT3','Lap Trinh C#')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('LT4','Lap Trinh Angualer')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('LT5','Lap Trinh Mob')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('LT6','Lap Trinh Python')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('LT7','Lap Trinh Vue JS')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('LT8','Lap Trinh JavaScrip')";
        db.execSQL(sql);
        sql = " INSERT INTO LOP VALUES ('LT9','Lap Trinh SQL Server')";
        db.execSQL(sql);

        sql = " CREATE TABLE SINHVIEN(maSv TEXT PRIMARY KEY, tenSV TEXT ," + " email TEXT , maLop TEXT REFERENCES LOP(maLop))";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('001','Quynh Hoa','tranthihoa@gmail.com','LT1')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('002','Truc Linh','tranthitruc@gmail.com','LT2')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('003','Quoc Nguyen','quocnguyen@gmail.com','LT3')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('004','Tue Linh','tuelinh@gmail.com','LT1')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('005','Van Nam','vannam@gmail.com','LT2')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('006','Nam Bui','nambui@gmail.com','LT3')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('007','Duy Thai','thaiduy@gmail.com','LT1')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('008','Linh Huong','thaihuong@gmail.com','LT2')";
        db.execSQL(sql);
        sql = " INSERT INTO SINHVIEN VALUES ('009','Tran Thanh','thanhlich@gmail.com','LT3')";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
    }
}
