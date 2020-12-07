package com.example.slide72020;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Ex2Activity extends AppCompatActivity {
    private EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex2);
        edtText = findViewById(R.id.editText);
    }

    public void saveToSD(View view) {
        String text = edtText.getText().toString().trim();
        if (text.isEmpty()) {
            Toast.makeText(this, "Can nhap thong tin", Toast.LENGTH_SHORT).show();
            return;
        }

        // xin quyen, hoi y kien nguoi dung xem co dong y cho ghi vao the nho ko ?
        if (ContextCompat.checkSelfPermission(Ex2Activity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted
            // viet cau lenh xin quyen or hoi y kien nguoi dung
            ActivityCompat.requestPermissions(Ex2Activity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 999);

        } else {
            try {

                String file = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test.txt";

                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
                outputStreamWriter.write(text);
                outputStreamWriter.close();
                Toast.makeText(this, "Da luu", Toast.LENGTH_SHORT).show();


            } catch (Exception e) {
                Log.e("ABC", e.getMessage());
            }
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 999) {
            if (ContextCompat.checkSelfPermission(Ex2Activity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                String text = edtText.getText().toString().trim();
                if (text.isEmpty()) {
                    Toast.makeText(this, "Can nhap thong tin", Toast.LENGTH_SHORT).show();
                    return;
                }
                try {

                    String file = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test.txt";

                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file));
                    outputStreamWriter.write(text);
                    outputStreamWriter.close();

                } catch (Exception e) {
                    Log.e("ABC", e.getMessage());
                }
            }else {
                Toast.makeText(this,"Ứng dụng cần được cấp quyền đọc ghi thì mới hoạt động được!!!",Toast.LENGTH_LONG).show();
            }
        }

    }

    public void loadFromSD(View view) {
        try {

            String file = Environment.getExternalStorageDirectory().getAbsolutePath() + "/test.txt";
            Scanner scanner = new Scanner(new File(file));
            String data = "";
            while (scanner.hasNext()) {
                data = data + scanner.nextLine();
            }
            scanner.close();
            Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

        } catch (Exception e) {

        }


    }
}