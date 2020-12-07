package com.example.slide72020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class Ex3Activity extends AppCompatActivity {

    EditText edtUser, edtPassword;
    CheckBox checkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex3);
        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        checkBox = findViewById(R.id.checkBox);
//        savingPreferences();
//        getDataPreferences();
    }

    private void getDataPreferences(){
        SharedPreferences pref = getSharedPreferences("user_file", MODE_PRIVATE);
        boolean check = pref.getBoolean("saveStatus", false);
        if (!check){
            String user = pref.getString("username", "");
            String password = pref.getString("password", "");
            edtUser.setText(user);
            edtPassword.setText(password);
        }
        checkBox.setChecked(check);
    }

    private void savingPreferences(){
        SharedPreferences sharedPreferences = getSharedPreferences("user_file", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String user = edtUser.getText().toString();
        String password = edtPassword.getText().toString();
        boolean check = checkBox.isChecked();

        if (!check){
            editor.clear();
        } else {
            editor.putString("username", user);
            editor.putString("password", password);
            editor.putBoolean("saveStatus", check);
        }
        editor.commit();
    }
    public void login(View view) {
        startActivity(new Intent(this, SuccessLoginActivity.class));
    }
}