package com.example.runtourist.baseDonne;

import android.content.Context;
import android.database.sqlite.*;

import androidx.annotation.Nullable;

public class AllMyCells extends SQLiteOpenHelper {
    /// variables qui seront utilisé et implementer dans la base de données pour l'instant il manque une instanciation
    // pour mettre une image dans une colonne
    public static final String DATABASE_NAME = "AllCells.db";
    public static final int DATABASE_VERSION = 1;
    public static final String TABLE_SERVERS = "table_servers";
    public static final String COL_ID = "ID";
    public static final String COL_NOMLIEU = "NOMLIEU";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_SERVERS + " ("
            + COL_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_NOMLIEU + "TEXT NOT NULL);" ;

    public AllMyCells(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //On crée la base de données
        db.execSQL(CREATE_BDD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int BDAVANT , int BDAPRES) {
        // si necessaire on supprime pour recreer
        db.execSQL("DROP TABLE " + TABLE_SERVERS + ";");
        onCreate(db);
    }
}
