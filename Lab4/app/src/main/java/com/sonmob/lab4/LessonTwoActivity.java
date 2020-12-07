package com.sonmob.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class LessonTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_two);

        Uri phoneCall = Uri.parse("tel:"  +"0334687436" );
        Intent caller = new Intent(Intent.ACTION_DIAL, phoneCall);
        startActivity(caller);
    }
}