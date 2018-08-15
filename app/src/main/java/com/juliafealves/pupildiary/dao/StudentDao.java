package com.juliafealves.pupildiary.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.juliafealves.pupildiary.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDao extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "students";

    public StudentDao(Context context) {
        super(context, "PupilDairy", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE students (" +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT NOT NULL, " +
                "address TEXT, " +
                "phone TEXT, " +
                "website TEXT, " +
                "rate REAL);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
        db.execSQL(sql);
        this.onCreate(db);
    }

    /**
     * Insert a student into table.
     * @param student Object Student
     */
    public void insert(Student student) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", student.getName());
        values.put("address", student.getAddress());
        values.put("phone", student.getPhone());
        values.put("website", student.getWebsite());
        values.put("rate", student.getRate());
        db.insert(TABLE_NAME, null, values);
    }

    /**
     * Return all students save.
     * @return List
     */
    public List<Student> findAll() {
        String sql = "SELECT * FROM " + TABLE_NAME + ";";
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(sql, null);
        List<Student> students = new ArrayList<>();

        while (cursor.moveToNext()){
           Student student = new Student();
           student.setId(cursor.getLong(cursor.getColumnIndex("id")));
           student.setName(cursor.getString(cursor.getColumnIndex("name")));
           student.setAddress(cursor.getString(cursor.getColumnIndex("address")));
           student.setPhone(cursor.getString(cursor.getColumnIndex("phone")));
           student.setWebsite(cursor.getString(cursor.getColumnIndex("website")));
           student.setRate(cursor.getDouble(cursor.getColumnIndex("rate")));
           students.add(student);
        }

        cursor.close();

        return students;
    }
}
