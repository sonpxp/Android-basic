package com.sonmob.studentmanager;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

public class FlashScreenActivity extends AppCompatActivity {
    private static int SPASH_TIME_OUT = 2500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //title bar option
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //tile bar hide
        getSupportActionBar().hide();

        setContentView(R.layout.activity_flash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                Intent intent = new Intent(FlashScreenActivity.this, MainActivity.class);
//                startActivity(intent);
                startActivity(new Intent(FlashScreenActivity.this, MainActivity.class));
                finish();
            }
        }, SPASH_TIME_OUT);
    }
}