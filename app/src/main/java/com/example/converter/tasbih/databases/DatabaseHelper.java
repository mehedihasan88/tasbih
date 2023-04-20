package com.example.converter.tasbih.databases;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "tasbih.db";
    private static final int DATABASE_VERSION = 1;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " +
                DatabaseStructure.Verses.TABLE_NAME + " ( " +
                DatabaseStructure.Verses.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DatabaseStructure.Verses.COLUMN_START_TIME + " DATETIME NOT NULL, " +
                DatabaseStructure.Verses.COLUMN_END_TIME + " DATETIME, " +
                DatabaseStructure.Verses.COLUMN_TARGET + " INTEGER, " +
                DatabaseStructure.Verses.COLUMN_COUNT + " INTEGER );";
        db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // handle any updates to the database schema here
    }

    public long insert(Verse verse) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseStructure.Verses.COLUMN_START_TIME, verse.getStartTime());
        values.put(DatabaseStructure.Verses.COLUMN_END_TIME, verse.getEndTime());
        values.put(DatabaseStructure.Verses.COLUMN_TARGET, verse.getCount());
        values.put(DatabaseStructure.Verses.COLUMN_COUNT, verse.getTarget());
        long idForRowCreated = db.insert(DatabaseStructure.Verses.TABLE_NAME, null, values);
        db.close();
        return idForRowCreated;
    }

}

