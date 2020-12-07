package com.sonmob.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LessonOneActivity extends AppCompatActivity {
    private EditText User;
    private EditText Pass;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_one);

        User = (EditText) findViewById(R.id.User);
        Pass = (EditText) findViewById(R.id.Pass);
        Login = (Button) findViewById(R.id.Login);

    }

    public void onLogin(View view) {
        if (User.getText().toString().equals("admin") && Pass.getText().toString().equals("admin") ) {
            Toast.makeText(this, "Dang nhap thanh cong", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "Dang nhap that bai", Toast.LENGTH_LONG).show();
        }

    }
}