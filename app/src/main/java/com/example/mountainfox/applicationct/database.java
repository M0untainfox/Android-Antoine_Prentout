package com.example.mountainfox.applicationct;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class database extends SQLiteOpenHelper {

    private static final String baseName = "Base.voiture";
    private static final int VERSION = 1;

    public database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, baseName, factory, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
