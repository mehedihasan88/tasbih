package com.example.converter.tasbih.databases;

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tasbih.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "verses";
    private static final String KEY_ID = "id";
    private static final String KEY_START_TIME = "startTime";
    private static final String KEY_END_TIME = "endTime";
    private static final String KEY_TARGET = "target";
    private static final String KEY_COUNT = "count";
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_START_TIME +
                " DATETIME NOT NULL, " + KEY_END_TIME + "DATETIME, " + KEY_TARGET + " INTEGER, " + KEY_COUNT + " INTEGER);";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // handle any updates to the database schema here
    }

    public void insert(Verse verse) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_START_TIME, verse.getStartTime());
        values.put(KEY_END_TIME, verse.getEndTime());
        values.put(KEY_COUNT, verse.getCount());
        values.put(KEY_TARGET, verse.getTarget());
        db.insert(TABLE_NAME, null, values);
        System.out.println("values inserted");
        db.close();
    }

}

