package com.example.runtourist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Button;
import android.view.View;

public class MainActivity extends Activity {
private ImageView imageView, imageView2, imageView3, imageView4;
private Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
         // Constructeur qui recupere les id des imageView
        this.imageView = (ImageView) this.findViewById(R.id.imageView);
        this.imageView2 = (ImageView) this.findViewById(R.id.imageView);
        this.imageView3 = (ImageView) this.findViewById(R.id.imageView3);
        this.imageView4 = (ImageView) this.findViewById(R.id.imageView4);
        this.button1 = (Button) this.findViewById(R.id.button1);
        
        this.button1.setOnClickListener(new Button.OnClickListener(){

            @Override
            // Fonction a l'appui du bouton Start qui affiche une image
            public void onClick(View v) {
                showImage1();
                //showImage2();

            }


        });
    }
    
    // Mise en place l'image dans l'image view
    private void showImage1() {
        this.imageView.setImageResource(R.drawable.nord);

       // this.imageView.setImageResource(R.drawable.ouest);
      //  this.imageView.setImageResource(R.drawable.est);
    }
    private void showImage2(){
        this.imageView.setImageResource(R.drawable.sud);

    }

}
