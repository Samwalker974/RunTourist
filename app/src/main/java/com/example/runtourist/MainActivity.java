package com.example.runtourist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends Activity {
    private ImageView imgN, imgE, imgO, imgS;
    private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
         // Constructeur qui recupere les id des imageView
        // Modification des noms plus simple et identifiable
        this.imgN = (ImageView) this.findViewById(R.id.imgN);
        this.imgE = (ImageView) this.findViewById(R.id.imgE);
        this.imgO = (ImageView) this.findViewById(R.id.imgO);
        this.imgS = (ImageView) this.findViewById(R.id.imgS);
        this.button1 = (Button) this.findViewById(R.id.button1);
        

    }
    // Fonction qui est appelle automatiquement lors de l'appuie du bouton start
    public void showImg(View view){
        imgN.setImageResource(R.drawable.nord);
        imgE.setImageResource(R.drawable.est);
        imgO.setImageResource(R.drawable.ouest);
        imgS.setImageResource(R.drawable.sud);
        button1.setVisibility(View.INVISIBLE);
    }


}
