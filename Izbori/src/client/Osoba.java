package client;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;

public class Osoba {
    int JMBG;
    String ime;
    String prezime;
    String mjestoRodjenja;
    Date datumRodjenja;
    int idOpstine;
    public Osoba(){}
   public Osoba(int JMBG, String ime, String prezime, String mjestoRodjenja, Date datumRodjenja, int idOpstine){
        this.JMBG=JMBG;
        this.ime=ime;
        this.prezime=prezime;
        this.mjestoRodjenja=mjestoRodjenja;
        this.datumRodjenja=datumRodjenja;
        this.idOpstine=idOpstine;


      /* try {
           this.datumRodjenja = new SimpleDateFormat("dd/MM/yyyy").parse(datumRodjenja);
       } catch (ParseException e) {
           e.printStackTrace();
       }*/

   }

    public int getJMBG() {
        return JMBG;
    }

    public void setJMBG(int JMBG) {
        this.JMBG = JMBG;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getMjestoRodjenja() {
        return mjestoRodjenja;
    }

    public void setMjestoRodjenja(String mjestoRodjenja) {
        this.mjestoRodjenja = mjestoRodjenja;
    }

    public Date getDatumRodjenja() {
        return datumRodjenja;
    }

    public void setDatumRodjenja(Date datumRodjenja) {
        this.datumRodjenja = datumRodjenja;
    }

    public int getIdOpstine() {
        return idOpstine;
    }

    public void setIdOpstine(int idOpstine) {
        this.idOpstine = idOpstine;
    }
}
