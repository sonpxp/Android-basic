package com.sonmob.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Bai3Activity extends AppCompatActivity {
    TextView tvKq3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        tvKq3 = findViewById(R.id.tvKq3);
        Intent intent = getIntent();
        int so1 = Integer.parseInt(intent.getExtras().getString("key_1"));
        int so2 = Integer.parseInt(intent.getExtras().getString("key_2"));
        int tong = so1+so2;
        int hieu = so1-so2;
        int tich = so1*so2;
        int thuong =so1/so2;

        String kq = "Tong: "+tong+"; \nHieu: "+hieu+"; \nThuong: "+thuong+" \nTich: "+tich;
        tvKq3.setText(String.valueOf(kq));
    }
}