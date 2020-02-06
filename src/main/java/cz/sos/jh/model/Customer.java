package cz.sos.jh.model;

import java.util.List;

public class Book {
    String nazev;
    String zanr;
    String autor;
    String datum_vydani;
    String jazyk;
    String vydavatel;
    int pocetKnih;


    public int getPocetKnih() {
        return pocetKnih;
    }

    public void setPocetKnih(int pocetKnih) {
        this.pocetKnih = pocetKnih;
    }


    public String getNazev() {
        return nazev;
    }

    public void setNazev(String nazev) {
        this.nazev = nazev;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDatum_vydani() {
        return datum_vydani;
    }

    public void setDatum_vydani(String datum_vydani) {
        this.datum_vydani = datum_vydani;
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
}
