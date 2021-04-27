package com.example.runtourist;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.runtourist.base.MyData;

public class MainAccueil extends AppCompatActivity {
    Context context;
    Button lieuxVbt;
    Button lieuxFbt;
    MyData maBase;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        lieuxFbt =findViewById(R.id.lieuxFbt);
        lieuxVbt =findViewById(R.id.lieuxVbt);

        context=this;
        maBase = new MyData(context);

        MyCell[] cell ;
        cell = maBase.getData();

        maBase.close();


    }
    public void lieuxV(View v){
        Intent intent =new Intent(context,MainActivity.class);
        startActivity(intent);
    }
    public void lieuxF(View v){
        Intent intent =new Intent(context,MainActivity.class);
        startActivity(intent);
    }


    public void lieuxMenuV(View v){
        Intent intent =new Intent(context,MainActivity.class);
        startActivity(intent);
    }



}
