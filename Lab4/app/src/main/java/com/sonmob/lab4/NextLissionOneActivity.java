package com.sonmob.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class NextLissionOneActivity extends AppCompatActivity {
    private TextView kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_lission_one);

        kq = (TextView) findViewById(R.id.kq);

        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("bun");
        int a = bundle.getInt("soA");
        int b = bundle.getInt("soB");
        int bscnn = BSCNN(a, b);
        kq.setText(String.valueOf(bscnn));

    }
    // Để tìm BSCNN ta phải tim ÚCLN rồi lấy 2 số a,b/USCLN

    // trả về giá trị có tham số truyền vào , not Void
    public int USCLN(int a, int b) {
        if (b==0){
            return a;
        }else {
            return USCLN(b, a%b);
        }
    }
    // trả về giá trị có tham số truyền vào , not Void
    public int BSCNN(int a, int b) {
        return (a+b)/(USCLN(a,b));
    }

}