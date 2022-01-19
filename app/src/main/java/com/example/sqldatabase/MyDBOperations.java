package com.example.sqldatabase;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class MyDBOperations {
    DBHelper dbHelper;

    public MyDBOperations(Context context) {
        dbHelper = new DBHelper(context);
    }

    public long insertData(String name, String pass) {
        SQLiteDatabase dbb = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.NAME, name);
        contentValues.put(DBHelper.MyPASSWORD, pass);
        long id = dbb.insert(DBHelper.TABLE_NAME, null, contentValues);
        return id;
    }
    @SuppressLint("Range")
    public String getData() {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] columns = {DBHelper.UID, DBHelper.NAME, DBHelper.MyPASSWORD};
        Cursor cursor = db.query(DBHelper.TABLE_NAME, columns, null, null, null, null, null);
        StringBuffer buffer = new StringBuffer();
        while (cursor.moveToNext()) {
                int cid = cursor.getInt(cursor.getColumnIndex(DBHelper.UID));
                String name = cursor.getString(cursor.getColumnIndex(DBHelper.NAME));
                String password = cursor.getString(cursor.getColumnIndex(DBHelper.MyPASSWORD));
                buffer.append(cid + "   " + name + "   " + password + " \n");
        }
        return buffer.toString();
    }

    public int delete(String uname) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String[] whereArgs = {uname};
        int count = db.delete(DBHelper.TABLE_NAME, DBHelper.NAME + " = ?", whereArgs);
        return count;
    }

    public int updateName(String oldName, String newName) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.NAME, newName);
        String[] whereArgs = {oldName};
        int count = db.update(DBHelper.TABLE_NAME, contentValues, DBHelper.NAME + " = ?", whereArgs);
        return count;
    }
}
