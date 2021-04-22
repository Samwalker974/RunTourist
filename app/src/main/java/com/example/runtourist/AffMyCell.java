package com.example.runtourist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

//Affiche les cellules selon les donnée de MyCell
//Les donnee sont une image, un texte donnant le Nom du Lieux et un autre etant les information de ce lieux
public class AffMyCell extends ArrayAdapter<MyCell> {

    private final Context context;

    //Methode pour implementer la lecture de ma Liste de Celule
    public AffMyCell(@NonNull Context context, MyCell[] listeCell) {
        super(context,R.layout.cell_list, listeCell);
        this.context=context;

    }

    //Appleler automatiquement depuis Le MainActivity
    //ELle est utiliser comme une boucle de lecture et se termine quand elle a lu tout les donnée de ma liste de cellule
    public View getView(int position, View convertView, ViewGroup parent){
        View cellView=convertView;

        //Ici c'est lorque la liste est null on arrete la lecture
        if(cellView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            cellView = inflater.inflate(R.layout.cell_list,parent,false);
        }
        //Ici on lit ma liste de ma cellule
        //Pour chauqe cellule on defini son id
        ImageView image=cellView.findViewById(R.id.imgLieux);
        TextView textNom=cellView.findViewById(R.id.textNom);
        TextView textInfo=cellView.findViewById(R.id.textInfo);
        //On indique ainsi la cellule choisi
        MyCell s = getItem(position);
        //On implemente selon la position choissi on indique le nom ,l'information et l'image associé donner par une cellule de ma liste de cellule
        textNom.setText(s.getIdLieux());
        textInfo.setText(s.getIdTextInfo());
        image.setImageResource(s.getIdImgC());
        //On Retourne ma cellule lors de chaque repetition
        return cellView;
    }


}
