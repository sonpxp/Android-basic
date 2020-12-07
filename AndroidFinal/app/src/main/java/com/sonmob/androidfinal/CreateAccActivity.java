package com.sonmob.androidfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sonmob.androidfinal.DBHelper.DBHelper;
import com.sonmob.androidfinal.model.Users;

import java.util.ArrayList;
import java.util.List;

public class CreateAccActivity extends AppCompatActivity {

    private EditText edEmail;
    private EditText edPass;
    private EditText edPass2;
    private TextView loghere;
    private Button btnSigup;

    DBHelper dbHelper;
    ArrayList lstList;
    ArrayAdapter arrayAdapter;
    List<Users> users;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_acc);

        edEmail = (EditText) findViewById(R.id.ed_email);
        edPass = (EditText) findViewById(R.id.ed_pass);
        edPass2 = (EditText) findViewById(R.id.ed_pass2);
        btnSigup = (Button) findViewById(R.id.btnSigup);
        loghere = findViewById(R.id.loginhere);

        dbHelper = new DBHelper(CreateAccActivity.this);
        lstList = dbHelper.getAllItem();

        btnSigup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edEmail.getText().toString();
                String pass = edPass.getText().toString();
                //String pass2 = edPass2.getText().toString();
                Users users = new Users(email, pass);

                boolean kq = dbHelper.insertItem(users);
                if (kq){
                    Toast.makeText(CreateAccActivity.this, "Them User thanh cong", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(CreateAccActivity.this, "Them User that bai", Toast.LENGTH_SHORT).show();
                }
            }
        });

        loghere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CreateAccActivity.this, LoginActivity.class));
            }
        });

    }
}