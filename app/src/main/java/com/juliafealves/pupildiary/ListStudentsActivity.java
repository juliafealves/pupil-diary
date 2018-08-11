package com.juliafealves.pupildiary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListStudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);

        String[] students = {"Julia", "Isabelle", "Ivana", "John"};
        ListView lvStudents = findViewById(R.id.lvStudents);
        ArrayAdapter adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, students);
        lvStudents.setAdapter(adapter);
    }
}
