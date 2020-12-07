package com.sonmob.lab8final;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai1Activity extends AppCompatActivity {

    private TextView tv1;
    private EditText edtLink;
    private WebView idWebview;
    private Button btnzo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai1);

        tv1 = (TextView) findViewById(R.id.tv1);
        edtLink = (EditText) findViewById(R.id.edtLink);
        idWebview = (WebView) findViewById(R.id.id_webview);
        btnzo = findViewById(R.id.btnTruycap);

        btnzo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String link = String.valueOf(edtLink.getText());
                idWebview.loadUrl(link);
                idWebview.setWebViewClient(new WebViewClient());
            }
        });
    }
}