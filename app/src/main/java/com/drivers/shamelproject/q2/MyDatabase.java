package com.drivers.shamelproject.q2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

 import com.drivers.shamelproject.database.Student;

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

    //اضافة بالداتا بيز
    public boolean insert(Photos photos){
        SQLiteDatabase database = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("title",photos.getTitle());
        values.put("url",photos.getUrl());
        values.put("thumbnailUrl",photos.getThumbnailUrl());
        values.put("albumId",photos.getAlbumId());
        long result = database.insert(DB_NAME,null,values);
        return result != -1;
    }


    public ArrayList<Photos> getAllPhotos() {
        ArrayList<Photos> list = new ArrayList<>();
        SQLiteDatabase database = getReadableDatabase();
        Cursor cursor = database.rawQuery("SELECT * FROM " + MyDatabase.DB_NAME, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id"));
                @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex("title"));
                @SuppressLint("Range") String url = cursor.getString(cursor.getColumnIndex("url"));
                @SuppressLint("Range") String thumbnailUrl = cursor.getString(cursor.getColumnIndex("thumbnailUrl"));
                @SuppressLint("Range") String albumId = cursor.getString(cursor.getColumnIndex("albumId"));

                Photos photos = new Photos(albumId, title, url,thumbnailUrl);
                list.add(photos);

            } while (cursor.moveToNext());
            cursor.close();
        }

        return list;
    }




    public boolean deleteItem(Photos photos){
        SQLiteDatabase database = getWritableDatabase();
        //لو بدي احذف بناء على اي دي العنصر يعني ما احذف كل العناصر
        String arg [] = {String.valueOf(photos.getId())};
        int result = database.delete( MyDatabase.DB_NAME , "id=?" ,  arg);
        return result > 0;

    }

    //لارجاع عدد الصفوف في الجدول
    public long getStudentCount(){
        SQLiteDatabase database = getReadableDatabase();
        return DatabaseUtils.queryNumEntries(database,DB_NAME);

    }

}
