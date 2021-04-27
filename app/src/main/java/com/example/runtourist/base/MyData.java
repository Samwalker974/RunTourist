package com.example.runtourist.base;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.runtourist.MyCell;

public class MyData extends SQLiteOpenHelper {

    private static final String MY_TABLE ="My_table.db";



    public MyData(Context context) {
        super(context,MY_TABLE,null,1 );
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = " create table my_table (" + " id integer primary key autoincrement,"
                + " name integer not null, "
                + " info integer not null, "
                + " img integer not null "
                +")";
        db.execSQL(createTable);
        Log.i("ici","Creation de ma base de donnee");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table my_table");
        onCreate(db);
    }
    public void addIN(int name,int info ,int img){

        SQLiteDatabase db = this.getWritableDatabase();

        String strlSq = "insert into my_table (name, info,img) values ('"
                + name +"', '"+ info +"', "+ img +")";
        this.getWritableDatabase().execSQL(strlSq);
        Log.i("ici","Ajout dans ma base de donnee");



    }
    //Envoie d'un String
    public MyCell[] getData(){
        SQLiteDatabase db =this.getWritableDatabase();
        //Valeur a Retourner
        String donne =" ";
        //Ici on va se deplacer dans la base en selectionnat tout les colonne
        String query = " select * from my_table";
        // Cusor data pour parcourir la table
        Cursor data = this.getWritableDatabase().rawQuery(query,null);
        Log.i("ici","Ajout dans ma base de donnee");
        //Creation d'une celule
        MyCell[] cells = new MyCell[data.getCount()];
        Log.i("ici1","Ajout dans ma base de donnee"+data.getColumnCount());
        int i = 0;
        data.moveToFirst();

        //donne = data.getInt(0)+" "+data.getInt(1)+" "+data.getInt(2)+" "+data.getInt(3);

        int count = data.getCount();
        Log.i("ici",data.getCount()+"");

        while (i!=count){
            data.moveToPosition(i);
            //Log.i("ik1",donne);
            //Log.i("ik2",donne);
            Log.i("iko",data.getString(0));
            cells[i] = new MyCell(data.getInt(1),data.getInt(2),data.getInt(3));
            i++;

        }
        return cells;
    }
    //Supression d'une ligne dans la Base
    public void deleteData(int i){
        //Conversion de l'entier choisi en String
        String choix = String.valueOf(i);
        //Suppresion de la donne selon l'id
        this.getWritableDatabase().delete("my_table","id=?",new String[]{choix});
    }
    //Vider ma table
    public void allDeleteData(){
        SQLiteDatabase db=this.getWritableDatabase();
        db.execSQL("drop table my_table");
        onCreate(db);
    }

}
