package com.example.runtourist;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainAccueil extends AppCompatActivity {
    Context context;
    Button lieuxVbt;
    Button lieuxFbt;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);
        lieuxFbt =findViewById(R.id.lieuxFbt);
        lieuxVbt =findViewById(R.id.lieuxVbt);


        context=this;

    }
    public void lieuxV(View v){
        Intent intent =new Intent(context,MainActivity.class);
        startActivity(intent);
    }
    public void lieuxF(View v){
        Intent intent =new Intent(context,MainActivity.class);
        startActivity(intent);
    }

}
