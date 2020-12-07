package com.sonmob.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onBai1(View view) {
        startActivity(new Intent(MainActivity.this, Bai1Activity.class));
    }

    public void onBai2(View view) {
        startActivity(new Intent(MainActivity.this, Bai2Activity.class));
    }

    public void onBai3(View view) {
        startActivity(new Intent(MainActivity.this, Bai3Activity.class));
    }
}