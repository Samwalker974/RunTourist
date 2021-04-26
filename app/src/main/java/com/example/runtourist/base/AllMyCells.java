package com.example.runtourist.base;

import android.content.Context;
import android.database.sqlite.*;

import androidx.annotation.Nullable;

public class AllMyCells extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "AllCells.db";
    public static final int    DATABASE_VERSION = 1;
    public static final String TABLE_SERVEURS = "table_serveurs";
    public static final String COL_ID = "ID";
    public static final String COL_NOMLIEU = "NOMLIEU";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_SERVEURS + " ("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOMLIEU + " TEXT NOT NULL );";

    public AllMyCells(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        // on crée la table
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int BDavant, int BDapres)
    {
        // au choix : on supprime la table puis on la recrée
        db.execSQL("DROP TABLE " + TABLE_SERVEURS + ";");
        onCreate(db);
    }
}
