package client;

public class IzbornaJedinica {
    int idIzborneJedinice;
    int brojGlasova;
    int glasalo;
    IzbornaJedinica(){

    }
    IzbornaJedinica(int idIzborneJedinice,int brojGlasova,int glasalo){
        this.idIzborneJedinice=idIzborneJedinice;
        this.brojGlasova=brojGlasova;
        this.glasalo=glasalo;
    }
    public int getIdIzborneJedinice() {
        return idIzborneJedinice;
    }

    public void setIdIzborneJedinice(int idIzborneJedinice) {
        this.idIzborneJedinice = idIzborneJedinice;
    }

    public int getBrojGlasova() {
        return brojGlasova;
    }

    public void setBrojGlasac(int brojGlasac) {
        this.brojGlasova = brojGlasac;
    }

    public int getGlasalo() {
        return glasalo;
    }

    public void setGlasalo(int glasalo) {
        this.glasalo = glasalo;
    }
}
