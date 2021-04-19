package com.example.runtourist.base;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AllMyCells extends SQLiteOpenHelper {
    String TABLE_COMMENTS = "comments" ;
    String COLUMN_ID = "_id";
    String COLUMN_COMMENT ="comment";

    String DATABASE_CREATE = "create table "+ TABLE_COMMENTS + "(" + COLUMN_ID + " integer primary key autoincrement, "+ COLUMN_COMMENT + " text not null ; ";
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
