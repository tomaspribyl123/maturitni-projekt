package cz.sos.jh.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String nazev;
    private String zanr;
    private String autor;
    private String datum_vydani;
    private String jazyk;
    private String vydavatel;

    public Book() {}

    public Book(Long id, String nazev, String zanr, String autor, String datum_vydani, String jazyk, String vydavatel) {
        this.id = id;
        this.nazev = nazev;
        this.zanr = zanr;
        this.autor = autor;
        this.datum_vydani = datum_vydani;
        this.jazyk = jazyk;
        this.vydavatel = vydavatel;
    }

    @Override
    public String toString() {
        return String.format(
                "Kniha[id=%d, nazev='%s', zanr='%s', autor='%s', datum vydani='%d', , jazyk='%s', , vydavatel='%s']",
                id, nazev, autor, datum_vydani, jazyk, vydavatel);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
