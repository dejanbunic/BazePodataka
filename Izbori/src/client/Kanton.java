package client;

public class Kanton {
    int idKantona;
    String nazivKantona;
    Entitet entitet;
    int brojGlasaca;
    int glasalo;
    public Kanton(){

    }

    @Override
    public String toString() {
        return
             nazivKantona;
    }

    public Kanton(int idKantona, String nazivKantona, Entitet entitet, int brojGlasaca, int glasalo) {
        this.idKantona = idKantona;
        this.nazivKantona = nazivKantona;
        this.entitet = entitet;
        this.brojGlasaca = brojGlasaca;
        this.glasalo = glasalo;
    }

    public int getIdKantona() {
        return idKantona;
    }

    public void setIdKantona(int idKantona) {
        this.idKantona = idKantona;
    }

    public String getNazivKantona() {
        return nazivKantona;
    }

    public void setNazivKantona(String nazivKantona) {
        this.nazivKantona = nazivKantona;
    }

    public Entitet getEntitet() {
        return entitet;
    }

    public void setEntitet(Entitet entitet) {
        this.entitet = entitet;
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
