package com.drivers.shamelproject.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyDatabase extends SQLiteOpenHelper {

    public static final String DB_NAME = "test_db";
    public static final int DB_VERSION = 1 ;

    public MyDatabase(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE "+ DB_NAME+"(id INTEGER PRIMARY KEY AUTOINCREMENT , " + "name TEXT ,age TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE if exists DB_NAME");
        onCreate(db);
    }

    public boolean insert(Student student){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",student.getName());
        values.put("age",student.getAge());
        long result = database.insert(DB_NAME,null,values);
        return result != -1;
    }

    public ArrayList<Student> getAllStudents() {
        ArrayList<Student> list = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + MyDatabase.DB_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String age = cursor.getString(cursor.getColumnIndex("age"));

                Student student = new Student(id, name, age);
                list.add(student);

            } while (cursor.moveToNext());
            cursor.close();
        }

        return list;
    }

}
