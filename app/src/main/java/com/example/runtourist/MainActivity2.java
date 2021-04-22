package com.example.runtourist;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.bumptech.glide.Glide;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

//Cette activité est afficher quand l'utilisateur appuye sur Nord(Seulement pout le moment)
public class MainActivity2 extends AppCompatActivity {
    private ListView list;
    private MyCell[] mesCell;
    private int nbreCell;
    private AffMyCell affMyCell;
    private FirebaseStorage storage;
    private StorageReference myStorageRef;
    private ImageView imgBack;

    private int lieux;
    private  Intent intent;

    private ImageView petite;
    StorageReference ref;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        list=findViewById(R.id.listA);
        storage = FirebaseStorage.getInstance();
        myStorageRef = FirebaseStorage.getInstance().getReference();
        imgBack = findViewById(R.id.imgBack);
        //downloadMyFiles();
        intent = getIntent();
        //Lancement du choix de la vue
        choixDeMaVue();
        //Remplis la la liste de cellule
        //Appelle la classe pour afficher ma cellule et indique la liste de Cellule
        affMyCell=new AffMyCell(this,mesCell);
        //Envois ensuite tout dans la listView pour afficher
        list.setAdapter(affMyCell);
    }
    //Utiliser pour Firebase mais ne marche pas
    public void downloadMyFiles(){
      ref = myStorageRef.child("/tree.jpg");

      ref.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
          @Override
          public void onSuccess(Uri uri) {
              Picasso.with(getApplicationContext()).load(ref.toString()).into(imgBack);
              Toast.makeText(getApplicationContext(),"Telechargement Reussi",Toast.LENGTH_LONG).show();
          }
      }).addOnFailureListener(new OnFailureListener() {
          @Override
          public void onFailure(@NonNull Exception e) {
              Toast.makeText(getApplicationContext(),"Telechargement Echouer "+ref.toString(),Toast.LENGTH_LONG).show();
          }
      });
    }
    //Donnee de la page Est
     public void donneEst(){
         mesCell= new MyCell[3];
         nbreCell=3;
         mesCell[0]=new MyCell(R.string.bassin_la_paix,R.string.info_bassin_la_paix, R.drawable.bassinlapaix1);
         mesCell[1]=new MyCell(R.string.plaine_sable,R.string.info_plaine_sable,R.drawable.plainedessables1);
         mesCell[2]=new MyCell(R.string.voile_mariee ,R.string.info_c_voile_mariee,R.drawable.voiledelamariee1);
     }
     //Donne de la page Nord
     public void donneNord(){
        mesCell= new MyCell[3];
        nbreCell=3;
        mesCell[0]=new MyCell(R.string.cascade_niagara,R.string.info_cascade_niagara, R.drawable.cascade_niagara1);
        mesCell[1]=new MyCell(R.string.jardin_etat,R.string.info_jardin_etat,R.drawable.jardin_de_letat1);
        mesCell[2]=new MyCell(R.string.roche_ecrite ,R.string.info_c_roche_ecrite,R.drawable.roche_ecrite1);

     }
    //Choix de la vue selon ce que l'utlisateur a choisi
     public void choixDeMaVue(){
         lieux = intent.getIntExtra("Lieux",0);
         if(lieux == 1){
            donneNord();

         }
         if(lieux == 2){
             donneEst();
         }

     }






}