package com.sonmob.lab7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Bai3Activity extends AppCompatActivity {

    EditText txt_ID = null;
    EditText txt_Pass = null;
    Button btn_Login = null;
    CheckBox chk = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai3);

        mapComp();
        restoringPreferences();
        btn_Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savingPreferences();
            }
        });
    }

    private void mapComp(){
        if(txt_ID == null)
            txt_ID = findViewById(R.id.txt_ID);
        if(txt_Pass==null)
            txt_Pass = findViewById(R.id.txt_Pass);
        if(btn_Login==null)
            btn_Login = findViewById(R.id.btn_Login);
        if(chk==null)
            chk = findViewById(R.id.chk_Save);
    }

    private void savingPreferences(){
        //Tạo đối tượng getSharedPreferences
        SharedPreferences sharedPreference = getSharedPreferences("khoa.txt", MODE_PRIVATE);
        //Tạo đối tượng Editor để lưu thay đổi
        SharedPreferences.Editor editor = sharedPreference.edit();
        String user = txt_ID.getText().toString();
        String password = txt_Pass.getText().toString();
        Intent intent = new Intent(Bai3Activity.this, WelcomeActivity.class);
        Bundle bundle = new Bundle();
        boolean chkSave = chk.isChecked();
        if(user.equals("")||password.equals("")){
            Toast.makeText(this, "Thiếu thông tin",Toast.LENGTH_LONG).show();
        }
        if (user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {

            if (!chkSave) {
                editor.clear();
                bundle.putString("username", user);
                intent.putExtra("info", bundle);
                editor.putString("username", user);
                editor.putString("password", password);
                editor.putBoolean("savestatus", chkSave);
                startActivity(intent);
            } else {
                bundle.putString("username", user);
                intent.putExtra("info", bundle);
                editor.putString("username", user);
                editor.putString("password", password);
                editor.putBoolean("savestatus", chkSave);
                startActivity(intent);
            }
            editor.commit();
        }
        else
            Toast.makeText(this, "Đăng nhập thất bại!",Toast.LENGTH_LONG).show();
    }
    private void restoringPreferences(){
        SharedPreferences pref = getSharedPreferences("khoa.txt",MODE_PRIVATE);
        boolean chkSave = pref.getBoolean("savestatus", false);
        if(chkSave){
            String user = pref.getString("username","");
            String password = pref.getString("password", "");
            txt_ID.setText(user);
            txt_Pass.setText(password);
        }
        chk.setChecked(chkSave);

    }
}