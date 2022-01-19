package com.example.sqldatabase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DBHelper extends SQLiteOpenHelper {
    protected static final String DATABASE_NAME = "myDatabase";    // Database Name
    protected static final String TABLE_NAME = "myTable";   // Table Name
    protected static final int DATABASE_Version = 1;    // Database Version
    protected static final String UID = "_id";
    protected static final String NAME = "Name";
    protected static final String MyPASSWORD = "Password";
    protected static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME +
            " (" + UID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + NAME + " VARCHAR(255) ," + MyPASSWORD + " VARCHAR(225));";
    protected static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
    protected Context context;

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_Version);
        this.context = context;
    }

    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(CREATE_TABLE);
        } catch (Exception e) {
            Log.e("Exception", e.getMessage());
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        try {
            db.execSQL(DROP_TABLE);
            onCreate(db);
        } catch (Exception e) {
            Log.e("Exception", e.getMessage());
        }
    }
}
