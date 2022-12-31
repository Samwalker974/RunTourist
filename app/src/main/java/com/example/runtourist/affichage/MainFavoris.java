package com.example.runtourist.affichage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.runtourist.R;
import com.example.runtourist.baseDonne.MyData;
import com.example.runtourist.controller.AffMyCell;
import com.example.runtourist.controller.MyCell;

import org.w3c.dom.Text;

public class MainFavoris extends AppCompatActivity {
    private Context context;
    private MyCell[] mesCellFav;
    private MyData maBase;
    private ListView listF;
    private AffMyCell affMyCell;
    private TextView tf;
    private TextView btSuppAll;
    private TextView infoUtile;
    private Switch suppChoice;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoris);
        listF = findViewById(R.id.listFav);
        tf = findViewById(R.id.fav);
        btSuppAll = findViewById(R.id.suppAll);
        infoUtile = findViewById(R.id.infoUtil);
        suppChoice = findViewById(R.id.suppChoice);
        context = this;

        maBase = new MyData(context);
        mesCellFav = maBase.getData();


        if(mesCellFav.length != 0 ) {
            affMyCell = new AffMyCell(context, mesCellFav);
            listF.setAdapter(affMyCell);
            infoUtile.setVisibility(View.INVISIBLE);
        }else {
            infoUtile.setVisibility(View.VISIBLE);
        }
        listF.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(suppChoice.isChecked()){
                    maBase.deleteData(mesCellFav[position].getId());
                    maBase = new MyData(context);
                    mesCellFav = maBase.getData();
                    affMyCell = new AffMyCell(context, mesCellFav);
                    listF.setAdapter(affMyCell);
                    if(mesCellFav.length == 0){
                        infoUtile.setVisibility(View.VISIBLE);
                    }
                }
            }
        });



    }
    public void lieuxMenuV3(View view){
        Intent intent =new Intent(context,MainActivity.class);
        startActivity(intent);

    }
    public void lieuxHomeH3(View view){
        Intent intent =new Intent(context, MainAccueil.class);
        startActivity(intent);

    }
    public void clickSuppAll(View v){
        if(mesCellFav.length == 0){
            maBase.allDeleteData();
        }else {
            maBase.allDeleteData();
            Toast.makeText(context,"Base de donnee vider",Toast.LENGTH_SHORT).show();
            mesCellFav = maBase.getData();
            affMyCell=new AffMyCell(context,mesCellFav);
            listF.setAdapter(affMyCell);
            infoUtile.setVisibility(View.VISIBLE);

        }

    }
}
