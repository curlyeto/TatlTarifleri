package com.example.ertugrul.tatltarifleri.Model;

import java.io.Serializable;
public class Tatli implements Serializable {
    private int id;
    private String tatliresim;
    private String tatliadi;
    private String malzeme;
    private String yapilis;

    public Tatli() {
    }
    public Tatli(int id,String tatliresim, String tatliadi, String malzeme,String yapilis) {
        this.id=id;
        this.malzeme=malzeme;
        this.tatliresim = tatliresim;
        this.tatliadi = tatliadi;
        this.yapilis=yapilis;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTatliresim() {
        return tatliresim;
    }

    public void setTatliresim(String tatliresim) {
        this.tatliresim = tatliresim;
    }

    public String getTatliadi() {
        return tatliadi;
    }

    public void setTatliadi(String tatliadi) {
        this.tatliadi = tatliadi;
    }
    public String getYapilis() {
        return yapilis;
    }

    public void setYapilis(String yapilis) {
        this.yapilis = yapilis;
    }

    public String getMalzeme() {
        return malzeme;
    }

    public void setMalzeme(String malzeme) {
        this.malzeme = malzeme;
    }
}

/*
//firebase model
import java.io.Serializable;

public class Tatli implements Serializable {

    private String tatliresim;
    private String tatliadi;


    public Tatli() {
    }
    public Tatli(String tatliresim, String tatliadi) {
        this.tatliresim = tatliresim;
        this.tatliadi = tatliadi;
    }
    public String getTatliresim() {
        return tatliresim;
    }

    public void setTatliresim(String tatliresim) {
        this.tatliresim = tatliresim;
    }

    public String getTatliadi() {
        return tatliadi;
    }

    public void setTatliadi(String tatliadi) {
        this.tatliadi = tatliadi;
    }

}*/

