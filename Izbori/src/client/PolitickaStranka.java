package client;

import javafx.scene.control.CheckBox;

public class PolitickaStranka {
String naziv;
String adresa;
CheckBox izaberi1;
public PolitickaStranka(String naziv,String adresa){
    this.naziv=naziv;
    this.adresa=adresa;
    this.izaberi1=new CheckBox();
}

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public CheckBox getIzaberi1() {
        return izaberi1;
    }

    public void setIzaberi1(CheckBox izaberi1) {
        this.izaberi1 = izaberi1;
    }
}
