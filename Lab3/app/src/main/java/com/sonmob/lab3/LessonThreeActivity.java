package com.sonmob.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class LessonThreeActivity extends AppCompatActivity {
    ListView listMon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson_three);

        listMon = (ListView) findViewById(R.id.listMon);
        ToDoList();
    }
    static final String[] sb = new String[]{
            "Android co ban",
            "Java2",
            "HTML5/CSS3",
            "Python"
    };

    public void ToDoList() {
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this
                ,android.R.layout.simple_list_item_1, sb);
        //setAdapter cho Listview
        listMon.setAdapter(adapter);
    }

}