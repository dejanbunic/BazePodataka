package client;

public class Grad {
    int idGrada;
    int brojGlasaca;
    int glasalo;

    @Override
    public String toString() {
        return naziv;
    }

    public Entitet getEntitet() {
        return entitet;
    }

    public void setEntitet(Entitet entitet) {
        this.entitet = entitet;
    }

    String naziv;
    Entitet entitet;
public    Grad(int idGrada,int brojGlasaca,int glasalo){
        this.idGrada=idGrada;
        this.brojGlasaca=brojGlasaca;
        this.glasalo=glasalo;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Grad(){

}
    public int getIdGrada() {
        return idGrada;
    }

    public void setIdGrada(int idGrada) {
        this.idGrada = idGrada;
    }

    public int getBrojGlasaca() {
        return brojGlasaca;
    }

    public void setBrojGlasaca(int brojGlasaca) {
        this.brojGlasaca = brojGlasaca;
    }

    public int getGlasalo() {
        return glasalo;
    }

    public void setGlasalo(int glasalo) {
        this.glasalo = glasalo;
    }
}
