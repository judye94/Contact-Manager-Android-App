package com.example.judithehiguese.contactmanager;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by judithehiguese on 12/03/2017.
 */

//create class that will connect the database which extends from SQLite
public class DatabaseHelper extends SQLiteOpenHelper {

    //define database name and table name
    public static final String DATABASE_NAME = "contact.db";
    public static final String TABLE_NAME = "contact_table";
    public static final String C_1 = "ID";
    public static final String C_2 = "NAME";
    public static final String C_3 = "MOBILE";
    public static final String C_4 = "HOME";
    public static final String C_5 = "EMAIL";


    //database will be created when this constructor is called
    public DatabaseHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);
    }

    //creates table when this method is called
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " ( " + C_1 + " INTEGER PRIMARY KEY AUTOINCREMENT," + C_2 + " VARCHAR, " + C_3 + " VARCHAR, " + C_4 + " VARCHAR, " + C_5 + " VARCHAR);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_NAME);
        onCreate(db); //create table
    }

    //method to insert data
    public boolean insertData(String name, String mobile, String home, String email){
        SQLiteDatabase db = this.getWritableDatabase(); //create database and table for checking
        ContentValues contentValues = new ContentValues();
        contentValues.put(C_2, name);
        contentValues.put(C_3, mobile);
        contentValues.put(C_4, home);
        contentValues.put(C_5, email);
        long result = db.insert(TABLE_NAME, null, contentValues); //if data is not inserted it will return minus 1
        if(result == -1)
            return false;
        else
            return true;

    }

    public Cursor getAllData(){
        SQLiteDatabase db = this.getWritableDatabase(); //create database and table for checking
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }



}
