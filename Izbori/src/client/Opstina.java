package client;

public class Opstina {
    String nazivOpstine;
    String nazivKantona;
    String nazivGrada;
    String nazivEntiteta;
    String nazivDrzave;
    int jedinicaDrzave;
    int jedinicaEntiteta;
    int idOpstine;
    int brojGlasaca;
    int glasalo;
    int idGrada;
    public Opstina(){

    }
    public Opstina(int idOpstine,int brojGlasaca,int glasalo,int idGrada){
        this.idOpstine=idOpstine;
        this.brojGlasaca=brojGlasaca;
        this.glasalo=glasalo;
        this.idGrada=idGrada;
    }

    public Opstina(String nazivOpstine, String nazivGrada, String nazivKantona,int jedinicaEntiteta, int jedinicaDrzave, String nazivEntiteta, String nazivDrzave ) {
        this.nazivOpstine = nazivOpstine;
        this.nazivKantona = nazivKantona;
        this.nazivGrada = nazivGrada;
        this.nazivEntiteta = nazivEntiteta;
        this.nazivDrzave = nazivDrzave;
        this.jedinicaDrzave = jedinicaDrzave;
        this.jedinicaEntiteta = jedinicaEntiteta;
    }

    public String getNazivOpstine() {
        return nazivOpstine;
    }

    public void setNazivOpstine(String nazivOpstine) {
        this.nazivOpstine = nazivOpstine;
    }

    public String getNazivKantona() {
        return nazivKantona;
    }

    public void setNazivKantona(String nazivKantona) {
        this.nazivKantona = nazivKantona;
    }

    public String getNazivGrada() {
        return nazivGrada;
    }

    public void setNazivGrada(String nazivGrada) {
        this.nazivGrada = nazivGrada;
    }

    public String getNazivEntiteta() {
        return nazivEntiteta;
    }

    public void setNazivEntiteta(String nazivEntiteta) {
        this.nazivEntiteta = nazivEntiteta;
    }

    public String getNazivDrzave() {
        return nazivDrzave;
    }

    public void setNazivDrzave(String nazivDrzave) {
        this.nazivDrzave = nazivDrzave;
    }

    public int getJedinicaDrzave() {
        return jedinicaDrzave;
    }

    public void setJedinicaDrzave(int jedinicaDrzave) {
        this.jedinicaDrzave = jedinicaDrzave;
    }

    public int getJedinicaEntiteta() {
        return jedinicaEntiteta;
    }

    public void setJedinicaEntiteta(int jedinicaEntiteta) {
        this.jedinicaEntiteta = jedinicaEntiteta;
    }

    public int getIdOpstine() {
        return idOpstine;
    }

    public void setIdOpstine(int idOpstine) {
        this.idOpstine = idOpstine;
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

    public int getIdGrada() {
        return idGrada;
    }

    public void setIdGrada(int idGrada) {
        this.idGrada = idGrada;
    }
}
