package com.example.runtourist.affichage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.runtourist.R;
import com.example.runtourist.baseDonne.MyData;
import com.example.runtourist.controller.MyCell;

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



    public void lieuxMenuV(View v){
        Intent intent =new Intent(context,MainActivity.class);
        startActivity(intent);
    }
    public void lieuxFavoris(View v){
        Intent intent =new Intent(context, MainFavoris.class);
        startActivity(intent);
    }




}
