package com.sonmob.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

public class LessonThreeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_three);

        String myMap = "https://www.google.com/maps/place/Ph%E1%BB%91+%C4%91i+b%E1%BB%99+H%E1%BB%93+G%C6%B0%C6%A1m+-+H%E1%BB%93+Ho%C3%A0n+Ki%E1%BA%BFm+%7C+H%C3%A0+N%E1%BB%99i/@21.0254323,105.8510233,17z/data=!3m1!4b1!4m5!3m4!1s0x3135abc072eac06d:0xa71e3e2ad2e7d5!8m2!3d21.0254273!4d105.853212?hl=vi-VN";
        Intent map = new Intent(Intent.ACTION_VIEW,Uri.parse(myMap));
        startActivity(map);
    }
}