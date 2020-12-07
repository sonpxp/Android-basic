package com.sonmob.lab5;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.lv);
        List<Product> products = new ArrayList<Product>();
        products.add(new Product("01","van hoa", 123, Color.RED));
        products.add(new Product("02","van TY", 458, Color.YELLOW));
        products.add(new Product("03","van BUI", 821, Color.RED));
        products.add(new Product("04","van SAO", 764, Color.RED));
        products.add(new Product("05","van HUNG", 998, Color.RED));
        CustomAdapter adapter = new CustomAdapter(this, R.layout.item_listview, products );
        listView.setAdapter(adapter);
    }
}