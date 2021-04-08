package com.example.runtourist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends Activity {
    private ImageView imgN, imgE, imgO, imgS;
    private Button button1;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
         // Constructeur qui recupere les id des imageView
        // Modification des noms plus simple et identifiable
        imgN = (ImageView) this.findViewById(R.id.imgN);
        imgE = (ImageView) this.findViewById(R.id.imgE);
        imgO = (ImageView) this.findViewById(R.id.imgO);
        imgS = (ImageView) this.findViewById(R.id.imgS);
        button1 = (Button) this.findViewById(R.id.button1);
        context=this;
        

    }
    // Fonction qui est appelle automatiquement lors de l'appuie du bouton start
    public void showImg(View view){
        imgN.setImageResource(R.drawable.nord);
        imgE.setImageResource(R.drawable.est);
        imgO.setImageResource(R.drawable.ouest);
        imgS.setImageResource(R.drawable.sud);
        button1.setVisibility(View.INVISIBLE);
    }
    //fonction activer lorsque l'utilisateur clique sur l'image nord
    public void pageNord(View view){
        Intent intent =new Intent(context,MainActivity2.class);
        startActivity(intent);

    }


}
