package com.sonmob.sqlitedemo;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.sonmob.sqlitedemo.database.DBHelper;
import com.sonmob.sqlitedemo.model.Student;

import java.util.ArrayList;

public class ListStudentActivity extends AppCompatActivity {
    ListView lv;
    DBHelper dbHelper;

    ArrayList lstList;
    ArrayAdapter arrayAdapter;
    ArrayList<Student> studentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_student);
        lv = findViewById(R.id.list_sv);

        dbHelper = new DBHelper(ListStudentActivity.this);
        lstList = new ArrayList<>();
        lstList = dbHelper.getAllItem();

        arrayAdapter = new ArrayAdapter<>(ListStudentActivity.this, android.R.layout.simple_list_item_1, lstList);
        lv.setAdapter(arrayAdapter);
//        lv.setOnClickListener(ListStudentActivity.this);


    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_sv, menu);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.it_edit:
            case R.id.it_xoa:
            default:
                return super.onContextItemSelected(item);
        }
    }
}