package com.juliafealves.pupildiary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.juliafealves.pupildiary.dao.StudentDao;
import com.juliafealves.pupildiary.model.Student;

import java.util.List;

public class ListStudentsActivity extends AppCompatActivity {

    private ListView lvStudents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_students);

        lvStudents = findViewById(R.id.listStudents_students);

        lvStudents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = (Student) parent.getItemAtPosition(position);
                Intent intent = new Intent(ListStudentsActivity.this, FormActivity.class);
                intent.putExtra("student", student);
                startActivity(intent);
            }
        });

        Button add = findViewById(R.id.listStudents_add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openForm = new Intent(ListStudentsActivity.this, FormActivity.class);
                startActivity(openForm);
            }
        });

        registerForContextMenu(lvStudents);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, final ContextMenu.ContextMenuInfo menuInfo) {
        menu.add("Remove").setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
                Student student = (Student) lvStudents.getItemAtPosition(info.position);

                StudentDao dao = new StudentDao(ListStudentsActivity.this);
                dao.remove(student);
                dao.close();

                createListStudents();

                return false;
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        this.createListStudents();
    }

    /**
     * Create the ListView of students, with query in database.
     */
    private void createListStudents() {
        StudentDao dao = new StudentDao(this);
        List<Student> students = dao.findAll();
        dao.close();

        ArrayAdapter<Student> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, students);
        lvStudents.setAdapter(adapter);
    }
}
