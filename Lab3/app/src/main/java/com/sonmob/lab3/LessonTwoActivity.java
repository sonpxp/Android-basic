package com.sonmob.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LessonTwoActivity extends AppCompatActivity {
    private EditText edSoA;
    private EditText edSoB;
    private EditText edSoC;
    private Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_two);

        edSoA = (EditText) findViewById(R.id.edSoA);
        edSoB = (EditText) findViewById(R.id.edSoB);
        edSoC = (EditText) findViewById(R.id.edSoC);
        Login = (Button) findViewById(R.id.Login);

    }

    public void onKetQua(View view) {
        Intent intent = new Intent(this, GiaiPhuongTrinhActivity.class);

        intent.putExtra("hsa",edSoA.getText().toString());
        intent.putExtra("hsb",edSoB.getText().toString());
        intent.putExtra("hsc",edSoC.getText().toString());
        startActivity(intent);
    }
}