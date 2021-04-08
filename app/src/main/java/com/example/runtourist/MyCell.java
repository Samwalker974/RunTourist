package com.example.runtourist;

//Ici ma classe MyCell contient les donnee suivante
//Nom du lieux ,Information a propos de ce lieux, Image associe a celui ci
public class MyCell {
    private String nomLieux;
    private String textInfo;
    private int imgC;

    public MyCell(String nomLieux, String textInfo, int imgC){
        setImgC(imgC);
        setNomLieux(nomLieux);
        setTextInfo(textInfo);
    }


    public String getNomLieux() {
        return nomLieux;
    }

    public void setNomLieux(String nomLieux) {
        this.nomLieux = nomLieux;
    }

    public String getTextInfo() {
        return textInfo;
    }

    public void setTextInfo(String textInfo) {
        this.textInfo = textInfo;
    }

    public int getImgC() {
        return imgC;
    }

    public void setImgC(int imgC) {
        this.imgC = imgC;
    }
}
