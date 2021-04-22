package com.example.runtourist;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity{
    private ImageView imgN, imgE, imgO, imgS;
    private ImageView backN, backE, backO, backS;
    private TextView textN, textE, textO, textS;
    private Button button1;
    Context context;
    //lieuChoisi est une variable que selon ce que l'utlisateur appuye il aurra acces au lieu donnee
    private int lieuxChoisi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        
        // Constructeur qui recupere les id des imageView
        // Modification des noms plus simple et identifiable
        imgN = (ImageView) this.findViewById(R.id.imgN);
        imgE = (ImageView) this.findViewById(R.id.imgE);
        imgO = (ImageView) this.findViewById(R.id.imgO);
        imgS = (ImageView) this.findViewById(R.id.imgS);
        button1 = (Button) this.findViewById(R.id.button1);
        //Constructeur qui recupere les id des imageView mais ici leurs fond
        backN = (ImageView) this.findViewById(R.id.backnord);
        backE = (ImageView) this.findViewById(R.id.backest);
        backO = (ImageView) this.findViewById(R.id.backouest);
        backS = (ImageView) this.findViewById(R.id.backsud);
        //Constructeur qui recupere les id des textView
        textN = (TextView) this.findViewById(R.id.textN);
        textE = (TextView) this.findViewById(R.id.textE);
        textO = (TextView) this.findViewById(R.id.textO);
        textS = (TextView) this.findViewById(R.id.textS);
        //Met en invisible pour lorque l'utilisateur appuye sur Start demarre l'appli
        backN.setVisibility(View.INVISIBLE);
        backE.setVisibility(View.INVISIBLE);
        backO.setVisibility(View.INVISIBLE);
        backS.setVisibility(View.INVISIBLE);
        textN.setVisibility(View.INVISIBLE);
        textE.setVisibility(View.INVISIBLE);
        textO.setVisibility(View.INVISIBLE);
        textS.setVisibility(View.INVISIBLE);

        context=this;
        

    }
    // Fonction qui est appelle automatiquement lors de l'appuie du bouton start
    public void showImg(View view){
        imgN.setImageResource(R.drawable.nord);
        imgE.setImageResource(R.drawable.est);
        imgO.setImageResource(R.drawable.ouest);
        imgS.setImageResource(R.drawable.sud);
        button1.setVisibility(View.INVISIBLE);
        backN.setVisibility(View.VISIBLE);
        backE.setVisibility(View.VISIBLE);
        backO.setVisibility(View.VISIBLE);
        backS.setVisibility(View.VISIBLE);
        textN.setVisibility(View.VISIBLE);
        textE.setVisibility(View.VISIBLE);
        textO.setVisibility(View.VISIBLE);
        textS.setVisibility(View.VISIBLE);
    }
    //fonction activer lorsque l'utilisateur clique sur le nord
    public void pageNord(View view){
        Intent intent =new Intent(context,MainActivity2.class);
        //lieuxchoisi 1 etant le Nord
        lieuxChoisi = 1;
        //envoye de la valeur lieuxchoisi a l'autre Activite
        intent.putExtra("Lieux", lieuxChoisi);
        startActivity(intent);

    }
    //fonction activer lorsque l'utilisateur clique sur est
    public void pageEst(View view){
        Intent intent =new Intent(context,MainActivity2.class);
        lieuxChoisi = 2;
        intent.putExtra("Lieux", lieuxChoisi);
        startActivity(intent);
    }


}
