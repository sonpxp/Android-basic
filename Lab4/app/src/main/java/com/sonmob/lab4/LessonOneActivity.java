package com.sonmob.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LessonOneActivity extends AppCompatActivity {
    private EditText edtSo1;
    private EditText edtSo2;
    private Button btnBSCNN;
    private Bundle bundle;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_one);

        edtSo1 = (EditText) findViewById(R.id.edtSo1);
        edtSo2 = (EditText) findViewById(R.id.edtSo2);
        btnBSCNN = (Button) findViewById(R.id.btnBSCNN);

        btnBSCNN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LessonOneActivity.this,NextLissionOneActivity.class);
                bundle = new Bundle();
                bundle.putInt("soA", Integer.parseInt(edtSo1.getText().toString()));
                bundle.putInt("soB", Integer.parseInt(edtSo2.getText().toString()));
                intent.putExtra("bun", bundle);
                startActivity(intent);
            }
        });
    }
}