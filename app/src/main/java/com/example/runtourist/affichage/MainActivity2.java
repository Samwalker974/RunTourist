package com.example.runtourist.affichage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.runtourist.R;
import com.example.runtourist.baseDonne.MyData;
import com.example.runtourist.controller.AffMyCell;
import com.example.runtourist.controller.MyCell;


//Cette activité est afficher quand l'utilisateur appuye sur Nord(Seulement pout le moment)
public class MainActivity2 extends AppCompatActivity {
    //Les Elements présent dans le Xml(soit affichage)
    private ListView list;
    private ImageView imgBack;
    private Context context;
    private TextView texteH;
    //Creation des celules servant a l'affichage selon chaque Cardinalité
    private MyCell[] mesCell;
    private int nbreCell;
    private AffMyCell affMyCell;
    //
    private int lieux;
    private  Intent intent;
    //Ma base de donnee et de mes donne stocker dans un tableau
    private MyData maBase;
    private MyCell[] mesDonnes;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        //Affectation des id afficher sur l'ecran
        list=findViewById(R.id.listA);
        imgBack = findViewById(R.id.imgBack);
        texteH = findViewById(R.id.textH2);
        //Definition context et intent pour changer de vue ou autre
        context = this;
        intent = getIntent();
        //Appelle de ma base de donnee
        maBase = new MyData(context);
        //Lancement du choix de la vue
        choixDeMaVue();
        //Remplis la la liste de cellule
        //Appelle la classe pour afficher ma cellule et indique la liste de Cellule
        affMyCell=new AffMyCell(this,mesCell);
        //Envois ensuite tout dans la listView pour afficher
        list.setAdapter(affMyCell);
        //Ici on ecoute l'utilisateur appuyer longtemps su un lieux pour l'ajouter dans ses favoris
        list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                mesDonnes = maBase.getData();
                //test du doublon avant ajout
                if(mesDonnes.length!=0) {
                    if (pasDeDoublon(mesDonnes, mesCell[position])) {
                        //Ajout a ma base
                        maBase.addIN(mesCell[position].getIdLieux(), mesCell[position].getIdTextInfo(), mesCell[position].getIdImgC());
                        Toast.makeText(context, "Ajout de l'element comme préferer", Toast.LENGTH_SHORT).show();
                        //Mise a jour de mes données
                        mesDonnes = maBase.getData();

                    } else {
                        Toast.makeText(context, "Deja ajouter dans ma liste favorite", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    maBase.addIN(mesCell[position].getIdLieux(),mesCell[position].getIdTextInfo(),mesCell[position].getIdImgC());
                    Toast.makeText(context,"Ajout de l'element comme préferer",Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
    //Donnee de la page Est
     public void donneEst(){
         mesCell= new MyCell[4];
         nbreCell=5;
         mesCell[0]=new MyCell(R.string.bassin_la_paix,R.string.info_bassin_la_paix, R.drawable.bassinlapaix1);
         mesCell[1]=new MyCell(R.string.plaine_sable,R.string.info_plaine_sable,R.drawable.plainedessables1);
         mesCell[2]=new MyCell(R.string.voile_mariee ,R.string.info_c_voile_mariee,R.drawable.voiledelamariee1);
         mesCell[3]=new MyCell(R.string.notre_dame_des_laves,R.string.info_notre_dame_des_laves,R.drawable.notredamedeslaves1);
         mesCell[4]=new MyCell(R.string.piton_de_la_fournaise,R.string.info_piton_de_la_fournaise,R.drawable.pitondelafournaise1);
     }
     //Donnee de la page Nord
     public void donneNord(){
        mesCell= new MyCell[4];
        nbreCell=5;
        mesCell[0]=new MyCell(R.string.cascade_niagara,R.string.info_cascade_niagara, R.drawable.cascade_niagara1);
        mesCell[1]=new MyCell(R.string.jardin_etat,R.string.info_jardin_etat,R.drawable.jardin_de_letat1);
        mesCell[2]=new MyCell(R.string.roche_ecrite ,R.string.info_c_roche_ecrite,R.drawable.roche_ecrite1);
        mesCell[3]=new MyCell(R.string.parc_du_colorado,R.string.info_parc_du_colorado,R.drawable.parc_du_colorado1);
        mesCell[4]=new MyCell(R.string.vanilleraie,R.string.info_vanilleraie,R.drawable.vanilleraie1);
     }

    //Donnee de la page Ouest
    public void donneOuest(){
        mesCell= new MyCell[4];
        nbreCell=5;
        mesCell[0]=new MyCell(R.string.aquarium_de_la_reunion,R.string.info_aquarium_de_la_reunion, R.drawable.aquariumdelareunion1);
        mesCell[1]=new MyCell(R.string.bassin_cormoran,R.string.info_bassin_cormoran,R.drawable.bassincomoran1);
        mesCell[2]=new MyCell(R.string.cirque_de_mafate ,R.string.info_cirque_de_mafate,R.drawable.cirquedemafate1);
        mesCell[3]=new MyCell(R.string.kelonia,R.string.info_kelonia,R.drawable.kelonia1);
        mesCell[4]=new MyCell(R.string.maïdo,R.string.info_maïdo,R.drawable.maido1);
    }

    //Donnee de la page Ouest
    public void donneSud(){
        mesCell= new MyCell[4];
        nbreCell=5;
        mesCell[0]=new MyCell(R.string.cap_mechant,R.string.info_cap_mechant, R.drawable.capmechant1);
        mesCell[1]=new MyCell(R.string.cascade_langevin,R.string.info_cascade_langevin,R.drawable.cascadelangevin1);
        mesCell[2]=new MyCell(R.string.grand_anse ,R.string.info_grand_anse,R.drawable.grandanse1);
        mesCell[3]=new MyCell(R.string.piton_des_neiges,R.string.info_piton_des_neiges,R.drawable.pitondesneiges1);
        mesCell[4]=new MyCell(R.string.saga_du_rhum,R.string.info_saga_du_rhum,R.drawable.sagadurhum1);
    }


    //Choix de la vue selon ce que l'utlisateur a choisi
     public void choixDeMaVue(){
         lieux = intent.getIntExtra("Lieux",0);
         if(lieux == 1){
            donneNord();
            texteH.setText("Lieux : Nord");
         }
         if(lieux == 2){
             donneEst();
             texteH.setText("Lieux : Est");
         }
         if(lieux == 3){
             donneOuest();
             texteH.setText("Lieux : Ouest");
         }
         if(lieux == 4){
             donneSud();
             texteH.setText("Lieux : Sud");
         }

     }

    public void lieuxMenuH2(View v){
        Intent intent =new Intent(context, MainAccueil.class);
        startActivity(intent);
    }
    public void lieuxFavoris2(View v){
        Intent intent =new Intent(context,MainFavoris.class);
        startActivity(intent);
    }


   public boolean pasDeDoublon(MyCell[] listeMc,MyCell macell){
        boolean rep = true;
        //on recherche un doublon si on trouve la fontion renvois false
       Log.i("calen",listeMc.length+" ");
        for(int i = 0;i < listeMc.length;i++){
            Log.i("camar",i+" ");
            if(listeMc[i].getIdLieux() == macell.getIdLieux()){
                Log.i("camar",i+" ");
                rep = false;
            }
        }
        return rep;
    }




}