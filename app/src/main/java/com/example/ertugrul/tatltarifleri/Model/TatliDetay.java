package com.example.ertugrul.tatltarifleri.Model;

public class TatliDetay {
    private String tatlidetayresim;
    private String tatlidetayad;


    public TatliDetay() {
    }

    public TatliDetay(String tatlidetayresim, String tatlidetayad) {
        this.tatlidetayresim = tatlidetayresim;
        this.tatlidetayad = tatlidetayad;

    }

    public String getTatlidetayresim() {
        return tatlidetayresim;
    }

    public void setTatlidetayresim(String tatlidetayresim) {
        this.tatlidetayresim = tatlidetayresim;
    }

    public String getTatlidetayad() {
        return tatlidetayad;
    }

    public void setTatlidetayad(String tatlidetayad) {
        this.tatlidetayad = tatlidetayad;
    }



}
