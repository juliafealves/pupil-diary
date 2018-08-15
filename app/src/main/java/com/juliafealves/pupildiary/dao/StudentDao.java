package com.juliafealves.pupildiary.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.juliafealves.pupildiary.model.Student;

public class StudentDao extends SQLiteOpenHelper {

    private static final String TABLE_NAME = "PupilDiary";

    public StudentDao(Context context) {
        super(context, StudentDao.TABLE_NAME, null, 1);
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
        String sql = "DROP TABLE IF EXISTS Alunos;";
        db.execSQL(sql);
        this.onCreate(db);
    }

    /**
     * Insert a student into table.
     * @param student
     */
    public void insert(Student student) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", student.getName());
        values.put("address", student.getAddress());
        values.put("phone", student.getPhone());
        values.put("website", student.getWebsite());
        values.put("rate", student.getRate());
        db.insert(StudentDao.TABLE_NAME, null, values);
    }
}
