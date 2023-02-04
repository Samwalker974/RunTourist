package com.example.runtourist.affichage;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.example.runtourist.R;

public class PremierPageAnime extends AppCompatActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pagedemarage);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(PremierPageAnime.this,MainAccueil.class));
                finish();
            }
        },3000);
    }

}
