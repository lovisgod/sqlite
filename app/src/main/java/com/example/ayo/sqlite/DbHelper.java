package com.example.ayo.sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

import static com.example.ayo.sqlite.DbHelper.WaitlistEntry.COL2;
import static com.example.ayo.sqlite.DbHelper.WaitlistEntry.DATABASE_NAME;
import static com.example.ayo.sqlite.DbHelper.WaitlistEntry.TABLE_NAME;

public class DbHelper extends SQLiteOpenHelper {

   // public static final String TABLE_NAME = "mylist.data";
    //public static final String COL1 = "ID";
    //public static final String COL2 = "itemm1";

    public static final class WaitlistEntry implements BaseColumns {
        public static final String DATABASE_NAME = "mylist.db";
        public static final String TABLE_NAME = "myList";
        public static final String COL1 = "ID";
        public static final String COL2 = "itemm1";
    }



    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String SQL_CREATE_WAITLIST_TABLE = "CREATE TABLE " + TABLE_NAME + " (" +
                WaitlistEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COL2 + " TEXT NOT NULL" + ") ";
        db.execSQL(SQL_CREATE_WAITLIST_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(String.format("DROP TABLE IF EXISTS%s", TABLE_NAME));
    }
    public boolean  addData(String item1){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL2,item1);

        long result = db.insert(TABLE_NAME,null,contentValues);
        if (result==-1){
            return false;
        }else {
            return true;
        }

    }

    public Cursor getListContents(){
        SQLiteDatabase db =this.getWritableDatabase();
        Cursor data = db.rawQuery("SELECT + FROM" + TABLE_NAME,null);
        return data;
    }
}
