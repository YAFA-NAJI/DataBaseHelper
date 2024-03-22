package com.example.databasehelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class DataBaseHelper extends android.database.sqlite.SQLiteOpenHelper{

    public DataBaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE CUSTOMER(ID LONG PRIMARY KEY,NAME TEXT, PHONE TEXT,GENDER TEXT)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void insertCustomer(Customer customer) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID", customer.getmCustomerId());
        contentValues.put("NAME", customer.getmName());
        contentValues.put("PHONE", customer.getmPhone());
        contentValues.put("GENDER", customer.getmGender());
        sqLiteDatabase.insert("CUSTOMER", null, contentValues);
    }
    public Cursor getCustomersWhoseNameStartsWithB() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM CUSTOMER" + " WHERE NAME" + " LIKE 'B%'", null);
    }

    public Cursor getAllCustomers() {
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        return sqLiteDatabase.rawQuery("SELECT * FROM CUSTOMER", null);
    }
}