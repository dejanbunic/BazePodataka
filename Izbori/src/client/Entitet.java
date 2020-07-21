package client;

public class Entitet {
    int idEntiteta;
    String nazivDrzave;
    String nazivEntiteta;
    int brojGlasaca;
    int glasalo;
    public Entitet(){

    }
    public Entitet(int idEntiteta,String nazivDrzave){
        this.idEntiteta=idEntiteta;
        this.nazivDrzave=nazivDrzave;
    }

    public Entitet(int idEntiteta, String nazivDrzave, String nazivEntiteta, int brojGlasaca, int glasalo) {
        this.idEntiteta = idEntiteta;
        this.nazivDrzave = nazivDrzave;
        this.nazivEntiteta = nazivEntiteta;
        this.brojGlasaca = brojGlasaca;
        this.glasalo = glasalo;
    }

    public int getIdEntiteta() {
        return idEntiteta;
    }

    public void setIdEntiteta(int idEntiteta) {
        this.idEntiteta = idEntiteta;
    }

    public String getNazivDrzave() {
        return nazivDrzave;
    }

    public void setNazivDrzave(String nazivDrzave) {
        this.nazivDrzave = nazivDrzave;
    }

    public String getNazivEntiteta() {
        return nazivEntiteta;
    }

    public void setNazivEntiteta(String nazivEntiteta) {
        this.nazivEntiteta = nazivEntiteta;
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
