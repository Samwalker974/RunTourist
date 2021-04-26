package com.example.runtourist.base;

import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import android.util.*;
public class BaseDonnee {

    private SQLdatabase bdd = null;
    private ServerSQLite serverSQLite = null;

    public BaseDonnee(Context context) {
        //creation d'une base et sa table
        serverSQLite = new ServerSQLite(context);
    }

}