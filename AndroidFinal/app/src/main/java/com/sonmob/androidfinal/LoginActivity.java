package com.sonmob.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.sonmob.androidfinal.DBHelper.DBHelper;
import com.sonmob.androidfinal.model.Users;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private EditText edEmail;
    private EditText edPass;
    private Button btnSigin;

    DBHelper dbHelper;
    ArrayList<Users> listTK = new ArrayList<>();
    ArrayAdapter arrayAdapter;
    List<Users> users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edEmail = (EditText) findViewById(R.id.ed_email);
        edPass = (EditText) findViewById(R.id.ed_pass);
        btnSigin = (Button) findViewById(R.id.btnSigin);

        btnSigin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // if ()
                boolean xetTk = false;
                dbHelper = new DBHelper(LoginActivity.this);
                String email = edEmail.getText().toString();
                String pass = edPass.getText().toString();
                listTK = dbHelper.getAllItem();
                for (int i = 0; i < listTK.size(); i++) {
                    Users tkx = listTK.get(i);
                    if (tkx.getEmail().matches(email) && tkx.getPassword().matches(pass)) {
                        xetTk = true;
                        break;
                    }
                }

                if (xetTk == true) {
                    Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                } else {
                    Toast.makeText(LoginActivity.this, "Tên tài khoản hoặc mật khẩu không chính xác!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}