package com.sonmob.lab7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bai1Activity extends AppCompatActivity {

    TextView txt_Show;
    public static final String file = "db101";
    public static final String content = "FPT Polytechnic";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);
        txt_Show = findViewById(R.id.txt_Show);
        try {
            FileOutputStream fos = openFileOutput(file,MODE_PRIVATE);
            fos.write(content.getBytes());
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str = "";

        try {
            FileInputStream fis = openFileInput(file);
            int c;

            while((c=fis.read())!=(-1)){
                str = str + ""+(char)c;
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        txt_Show.setText(str);

    }
}