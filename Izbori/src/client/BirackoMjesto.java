package client;

public class BirackoMjesto {
    int idBirackogMjesta;
    int idIzbora;
    String adresa;
    int brojGlasaca;
    int glasalo;

    public BirackoMjesto(int idBirackogMjesta,int idIzbora,String adresa,int brojGlasaca,int glasalo){
        this.idBirackogMjesta=idBirackogMjesta;
        this.idIzbora=idIzbora;
        this.adresa=adresa;
        this.brojGlasaca=brojGlasaca;
        this.glasalo=glasalo;
    }

    public int getIdBirackogMjesta() {
        return idBirackogMjesta;
    }

    public void setIdBirackogMjesta(int idBirackogMjesta) {
        this.idBirackogMjesta = idBirackogMjesta;
    }

    public int getIdIzbora() {
        return idIzbora;
    }

    public void setIdIzbora(int idIzbora) {
        this.idIzbora = idIzbora;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
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
