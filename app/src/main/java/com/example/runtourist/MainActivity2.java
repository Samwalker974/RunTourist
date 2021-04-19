package com.example.runtourist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;
//Cette activité est afficher quand l'utilisateur appuye sur Nord(Seulement pout le moment)
public class MainActivity2 extends AppCompatActivity {
    private ListView list;
    private MyCell[] mesCell;
    private int nbreCell;
    private AffMyCell affMyCell;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list=findViewById(R.id.listA);
        //Remplis la la liste de cellule
        remplisCell();
        //Appelle la classe pour afficher ma cellule et indique la liste de Cellule
        affMyCell=new AffMyCell(this,mesCell);
        //Envois ensuite tout dans la listView pour afficher
        list.setAdapter(affMyCell);
    }

    //Ici une fonction servant a remplir la cell pour exemples
    public void remplisCell(){
        mesCell= new MyCell[7];
        nbreCell=7;
        mesCell[0]=new MyCell("Lieux 1 ","Priorite : 0", Color.rgb(140,250,60));
        mesCell[1]=new MyCell("Lieux 2 ","Priorite : 1",Color.rgb(240,250,60));
        mesCell[2]=new MyCell("Lieux 3 ","Priorite : 2",Color.rgb(140,20,60));
        mesCell[3]=new MyCell("Lieux 4 ","Priorite : 3",Color.rgb(140,150,60));
        mesCell[4]=new MyCell("Lieux 5 ","Priorite : 4",Color.rgb(40,250,160));
        mesCell[5]=new MyCell("Lieux 6","Priorite : 5",Color.rgb(10,0,160));
        mesCell[6]=new MyCell("Lieux 7 ","Priorite : 6",Color.rgb(14,250,60));

    }
}