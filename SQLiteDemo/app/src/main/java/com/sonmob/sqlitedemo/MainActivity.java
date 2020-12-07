package com.sonmob.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sonmob.sqlitedemo.database.DBHelper;
import com.sonmob.sqlitedemo.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edtMasv;
    private EditText edtNamesv;
    private EditText edtEmailsv;
    private EditText edtPhonesv;
    private Button btnThem;
    private Button btnSua;
    private Button btnXoa;
    private Button btnXem;

    DBHelper dbHelper;
    ArrayList lstList;
    ArrayAdapter arrayAdapter;
    List<Student> studentList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtMasv = (EditText) findViewById(R.id.edt_masv);
        edtNamesv = (EditText) findViewById(R.id.edt_namesv);
        edtEmailsv = (EditText) findViewById(R.id.edt_emailsv);
        edtPhonesv = (EditText) findViewById(R.id.edt_phonesv);
        btnThem = (Button) findViewById(R.id.btnThem);
        btnXem = (Button) findViewById(R.id.btnXem);
        btnSua = (Button) findViewById(R.id.btnSua);
        btnXoa = (Button) findViewById(R.id.btnXoa);

        dbHelper = new DBHelper(MainActivity.this);
        lstList = dbHelper.getAllItem();


        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = edtMasv.getText().toString();
                String ten = edtNamesv.getText().toString();
                String email = edtEmailsv.getText().toString();
                int sdt = Integer.parseInt(edtPhonesv.getText().toString());
                Student student = new Student(ma,ten,email,sdt);

                boolean kq = dbHelper.insertItem(student);
                if (kq){
                    Log.d("TAG", "onClick: xem log"+ student);
                    Toast.makeText(MainActivity.this, "them thanh cong", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "them that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ListStudentActivity.class));
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ma = edtMasv.getText().toString();
                String ten = edtNamesv.getText().toString();
                String email = edtEmailsv.getText().toString();
                int sdt = Integer.parseInt(edtPhonesv.getText().toString());
                Student student = new Student(ma,ten,email,sdt);

                boolean kq = dbHelper.updateItem(student);
                //boolean isUpdated = myDb.updateData(editId.getText().toString(),editName.getText().toString(),editSurName.getText().toString(),editMarks.getText().toString());
                if (kq)
                    Toast.makeText(MainActivity.this,"Data Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data not Updated", Toast.LENGTH_LONG).show();
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                boolean isDeleted = dbHelper.deleteItem(edtMasv.getText().toString());
                if (isDeleted)
                    Toast.makeText(MainActivity.this,"Data Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"Data not Deleted", Toast.LENGTH_LONG).show();
            }
        });

    }


}