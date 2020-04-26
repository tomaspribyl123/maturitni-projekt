package cz.sos.jh.model;

import java.util.List;

public class Book {
    String nazev;
    String autor;
    String zanr;
    String rok_vydani;
    String jazyk;
    String vydavatel;
    int pocetKnih;


    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getRok_vydani() {
        return rok_vydani;
    }

    public void setRok_vydani(String rok_vydani) {
        this.rok_vydani = rok_vydani;
    }

    public String getJazyk() {
        return jazyk;
    }

    public void setJazyk(String jazyk) {
        this.jazyk = jazyk;
    }

    public String getVydavatel() {
        return vydavatel;
    }

    public void setVydavatel(String vydavatel) {
        this.vydavatel = vydavatel;
    }

    public int getPocetKnih() {
        return pocetKnih;
    }

    public void setPocetKnih(int pocetKnih) {
        this.pocetKnih = pocetKnih;
    }
}
