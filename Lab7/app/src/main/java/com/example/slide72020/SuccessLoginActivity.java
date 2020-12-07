package com.example.slide72020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class SuccessLoginActivity extends AppCompatActivity {

    TextView tvSuccessName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success_login);

        tvSuccessName = findViewById(R.id.tvNameSuccess);

        SharedPreferences pref = getSharedPreferences("user_file", MODE_PRIVATE);
        boolean check = pref.getBoolean("saveStatus", false);
//        if (!check){
            String user = pref.getString("username", "");
            String password = pref.getString("password", "");
            tvSuccessName.setText("Xin chao quan");
//            edtPassword.setText(password);
//        }
//        checkBox.setChecked(check);

    }



    public void exit(View view) {
    }
}