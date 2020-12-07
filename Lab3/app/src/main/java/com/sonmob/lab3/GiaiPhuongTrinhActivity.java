package com.sonmob.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class GiaiPhuongTrinhActivity extends AppCompatActivity {
    private TextView kqpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giai_phuong_trinh);

        kqpt = (TextView) findViewById(R.id.kqpt);
        //get data
        Intent intent = getIntent();
        int a = Integer.parseInt(intent.getExtras().getString("hsa"));
        int b = Integer.parseInt(intent.getExtras().getString("hsb"));
        int c = Integer.parseInt(intent.getExtras().getString("hsc"));

        double delta = b*b-4*a*c;
        if (delta < 0){
            kqpt.setText("phuong trinh vo nghiem");
        }else if(delta ==0) {
            kqpt.setText("phuong trinh co nghiem kep X= "+(-b)/(2*a));
        }else {
            double x1 = (-b+Math.sqrt(delta))/(2*a);
            double x2 = (-b-Math.sqrt(delta))/(2*a);
            kqpt.setText("Phuong trinh co 2 nhgiem: \nX1= "+x1+"; \nx2: "+x2);
        }
    }
}