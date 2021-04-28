package com.example.runtourist.controller;

//Ici ma classe MyCell contient les donnee suivante
//Nom du lieux ,Information a propos de ce lieux, Image associe a celui ci
public class MyCell {
    private String nomLieux;
    private String textInfo;
    private int id;
    private int idLieux;
    private int idTextInfo;
    private int idImgC;


    public MyCell(int id,int idLieux, int idTextInfo, int idImgC){
        setIdImgC(idImgC);
        setIdLieux(idLieux);
        setIdTextInfo(idTextInfo);
        setId(id);
    }
    public MyCell(int idLieux, int idTextInfo, int idImgC){
        setIdImgC(idImgC);
        setIdLieux(idLieux);
        setIdTextInfo(idTextInfo);
    }


    public int getIdLieux() {
        return idLieux;
    }

    public void setIdLieux(int idLieux) {
        this.idLieux = idLieux;
    }

    public int getIdTextInfo() {
        return idTextInfo;
    }

    public int getIdImgC() {
        return idImgC;
    }

    public void setIdImgC(int idImgC) {
        this.idImgC = idImgC;
    }

    public void setIdTextInfo(int idTextInfo) {
        this.idTextInfo = idTextInfo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
