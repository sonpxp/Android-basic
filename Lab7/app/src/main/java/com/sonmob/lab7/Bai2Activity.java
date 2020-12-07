package com.sonmob.lab7;

import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Bai2Activity extends AppCompatActivity {

    private EditText txt_Content = null;
    private Button btn_Save = null;
    private Button btn_Load = null;
    final String TAG = "check";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);

        mapComp();
        /*checkAndRequestPermissions();
        isExternalStorageReadable();*/
        btn_Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    saveData();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        });
        btn_Load.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    readData();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

        });

    }

    private void mapComp() {
        if (txt_Content == null)
            txt_Content = findViewById(R.id.txt_Content);
        if (btn_Save == null)
            btn_Save = findViewById(R.id.btn_Save);
        if (btn_Load == null)
            btn_Load = findViewById(R.id.btn_Load);
    }
    public void saveData() throws IOException {
        String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath()+"/khoa.txt";
        OutputStreamWriter writer = new OutputStreamWriter(new FileOutputStream(sdcard));
        writer.write(txt_Content.getText()+"");
        Toast.makeText(this,"Luu thanh cong!",Toast.LENGTH_LONG).show();
        writer.close();
    }

    public void readData() throws FileNotFoundException {
        String sdcard = Environment.getExternalStorageDirectory().getAbsolutePath()+"/khoa.txt";
        Scanner sc = new Scanner(new File(sdcard));
        String data="";
        while(sc.hasNext()){
            data+=sc.nextLine()+"\n";
        }
        Toast.makeText(this,"Doc thanh cong!",Toast.LENGTH_LONG).show();
        sc.close();
        txt_Content.setText(data+"");
    }
}