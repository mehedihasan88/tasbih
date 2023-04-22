package com.example.converter.tasbih.databases;

import android.provider.BaseColumns;

public class DatabaseStructure {
    private DatabaseStructure() {}

    //this inner class describes 'verses' table of the database
    public static class Verses implements BaseColumns {
        public static final String TABLE_NAME = "verses";
        public static final String COLUMN_ID = "id";
        public static final String COLUMN_START_TIME = "startTime";
        public static final String COLUMN_END_TIME = "endTime";
        public static final String COLUMN_TARGET = "target";
        public static final String COLUMN_COUNT = "count";
    }
}
