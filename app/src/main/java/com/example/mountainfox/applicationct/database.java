package com.example.mountainfox.applicationct;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class database extends SQLiteOpenHelper {

    private static final String baseName = "Base.voiture";
    private static final int VERSION = 1;

    public static final String USER_KEY = "id";
    public static final String USER_LOGIN = "login";
    public static final String USER_PSWD = "password";
    public static final String USER_USERNAME = "username";
    public static final String USER_TABLE_NAME = "Users";

    public static final String USER_TABLE_CREATE =
            "CREATE TABLE " + USER_TABLE_NAME + " (" +
                    USER_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    USER_LOGIN + " TEXT, " +
                    USER_PSWD + " TEXT, " +
                    USER_USERNAME+ " TEXT); ";



    public database(Context context) {
        super(context, baseName, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(USER_TABLE_CREATE);

        ContentValues user = new ContentValues();

        user.put("login","admin");
        user.put("password","admin");
        user.put("username","mountainfox");

        db.insert("Users",null,user);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table Users");
        db.execSQL(USER_TABLE_CREATE);

    }

}
