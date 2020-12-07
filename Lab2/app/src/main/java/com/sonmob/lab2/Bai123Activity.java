package com.sonmob.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Bai123Activity extends AppCompatActivity {
    EditText edtVar1, edtVar2;
    Button btnTong, btnTinhAll;
    TextView tvKq;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("test", "gọi hàm onCreate");

        edtVar1 = (EditText) findViewById(R.id.edtVar1);
        edtVar2 = (EditText) findViewById(R.id.edtVar2);
        btnTong = (Button) findViewById(R.id.btnTong);
        btnTinhAll = (Button) findViewById(R.id.btnTinh);
        tvKq = (TextView) findViewById(R.id.tvKq);


    }

    public void tinhTong(View view) {
        if (("".equals(edtVar1.getText().toString().trim()))){
            Toast.makeText(this, "Nhập vào ô 1 !", Toast.LENGTH_SHORT).show();
            return;
        } else if ("".equals(edtVar2.getText().toString().trim())){
            Toast.makeText(this, "Nhập vào ô 2 !", Toast.LENGTH_SHORT).show();
            return;
        }

        //
        float so1 = Float.parseFloat(edtVar1.getText().toString());
        float so2 = Float.parseFloat(edtVar2.getText().toString());


        //tinh tong
        float tong = so1 + so2;
        tvKq.setText(String.valueOf(tong));


    }

    public void btnTinhAll(View view) {
        intent = new Intent(Bai123Activity.this, Bai3Activity.class);
        //truyen du lieu
        String so1 = edtVar1.getText().toString();
        intent.putExtra("key_1", so1);
        //
        String so2 = edtVar2.getText().toString();
        intent.putExtra("key_2", so2);
        if (("".equals(edtVar1.getText().toString().trim()))){
            Toast.makeText(this, "Nhập vào ô 1 !", Toast.LENGTH_SHORT).show();
            return;
        } else if("".equals(edtVar2.getText().toString().trim())){
            Toast.makeText(this, "Nhập vào ô 2 !", Toast.LENGTH_SHORT).show();
            return;
        }

        //khoi chay
        startActivity(intent);
    }

    // Bai 1
    @Override
    protected void onStart() {
        super.onStart();
        Log.i("test", "gọi hàm onCreate");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i("test", "gọi hàm onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("test", "gọi hàm onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("test", "gọi hàm onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("test", "gọi hàm onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("test", "gọi hàm onPause");
    }

}