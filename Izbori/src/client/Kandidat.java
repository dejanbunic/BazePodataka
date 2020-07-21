package client;

import javafx.scene.control.CheckBox;

import java.sql.Date;

public class Kandidat extends Osoba {
    int brojGlasova;
    static String staticJmbg;
    static String staticTip;

    public static String getStaticJmbg() {
        return staticJmbg;
    }

    public static void setStaticJmbg(String staticJmbg,String staticTip) {
        Kandidat.staticJmbg = staticJmbg;
        Kandidat.staticTip=staticTip;
    }

    public static void setStaticJmbg(String staticJmbg) {
        Kandidat.staticJmbg = staticJmbg;
    }

    public static String getStaticTip() {
        return staticTip;
    }

    public static void setStaticTip(String staticTip) {
        Kandidat.staticTip = staticTip;
    }

    public Kandidat(){

    }
    public Kandidat( String staticJmbg){
        this.staticJmbg=staticJmbg;
    }
    String naziv;
    CheckBox izaberi;
    public Kandidat(int JMBG, String ime, String prezime, String mjestoRodjenja, Date datumRodjenja, int idOpstine, int brojGlasova, String naziv){
        super(JMBG,ime,prezime,mjestoRodjenja,datumRodjenja,idOpstine);
        this.brojGlasova=brojGlasova;
        this.izaberi=new CheckBox();
        this.naziv=naziv;
    }

    public int getBrojGlasova() {
        return brojGlasova;
    }

    public void setBrojGlasova(int brojGlasova) {
        this.brojGlasova = brojGlasova;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public CheckBox getIzaberi() {
        return izaberi;
    }

    public void setIzaberi(CheckBox izaberi) {
        this.izaberi = izaberi;
    }
}
