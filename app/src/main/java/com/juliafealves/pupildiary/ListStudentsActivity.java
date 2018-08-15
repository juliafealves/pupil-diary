package com.juliafealves.pupildiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.juliafealves.pupildiary.dao.StudentDao;
import com.juliafealves.pupildiary.model.Student;

import java.util.List;

public class ListStudentsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);
        StudentDao dao = new StudentDao(this);
        List<Student> students = dao.findAll();

        ListView lvStudents = findViewById(R.id.listStudents_students);
        ArrayAdapter adapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, students);
        lvStudents.setAdapter(adapter);

        Button add = findViewById(R.id.listStudents_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openForm = new Intent(ListStudentsActivity.this, FormActivity.class);
                startActivity(openForm);
            }
        });
    }
}
