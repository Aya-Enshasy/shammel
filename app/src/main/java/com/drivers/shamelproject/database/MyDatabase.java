package com.drivers.shamelproject.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
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
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String age = cursor.getString(cursor.getColumnIndex("age"));

                Student student = new Student(id, name, age);
                list.add(student);

            } while (cursor.moveToNext());
            cursor.close();
        }

        return list;
    }

    public boolean deleteAll(){
        SQLiteDatabase database = getWritableDatabase();
        //لو بدي احذف كل العناصر
        int result = database.delete( MyDatabase.DB_NAME , "1" ,  null);
        return result > 0;

    }

    public boolean deleteItem(Student student){
        SQLiteDatabase database = getWritableDatabase();
        //لو بدي احذف بناء على اي دي العنصر يعني ما احذف كل العناصر
        String arg [] = {String.valueOf(student.getId())};
        int result = database.delete( MyDatabase.DB_NAME , "id=?" ,  arg);
        return result > 0;

    }

    //لارجاع عدد الصفوف في الجدول
    public long getStudentCount(){
        SQLiteDatabase database = getReadableDatabase();
        return DatabaseUtils.queryNumEntries(database,DB_NAME);

    }

    // name search method
    public ArrayList<Student> getStudent(String nameSearch) {
        ArrayList<Student> posts = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();

        Cursor cursor = database.rawQuery("SELECT * FROM " + MyDatabase.DB_NAME + " WHERE " + "name" + " LIKE ?", new String[]{"%" + nameSearch + "%"
        });

        // to know if cursor contains data or not :
        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range")  int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String name = cursor.getString(cursor.getColumnIndex("name"));
                @SuppressLint("Range") String age = cursor.getString(cursor.getColumnIndex("age"));

                Student student = new Student(id, name, age);
                posts.add(student);
            }
            while (cursor.moveToNext());
            cursor.close();
        }

        return posts;
    }


    public boolean update(Student student){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name",student.getName());
        values.put("age",student.getAge());
        String arg [] = {String.valueOf(student.getId())};
        int result = database.update( MyDatabase.DB_NAME,values , "id=?" ,  arg);
        return result>0;
    }
    //اعمل انترفيس بالادابتر واجيب اي دي واحدث او احذف بناء عليه

}
