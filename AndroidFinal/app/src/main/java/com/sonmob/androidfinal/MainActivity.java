package com.sonmob.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.sonmob.androidfinal.DBHelper.DBHelper;
import com.sonmob.androidfinal.model.Users;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    Button dangky;
    DBHelper dbHelper;

    ArrayList lstList;
    ArrayAdapter arrayAdapter;
    ArrayList<Users> users;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dangky = findViewById(R.id.btnDangky);

        lv = findViewById(R.id.lv_listUser);
        dbHelper = new DBHelper(MainActivity.this);
        lstList = new ArrayList<>();
        lstList = dbHelper.getAllItem();

        arrayAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, lstList);
        lv.setAdapter(arrayAdapter);

        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CreateAccActivity.class));
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        });

    }
}