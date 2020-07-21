package client;

public class IzbornaJedinicaEntiteta extends IzbornaJedinica {
    int idIzborneJediniceEntiteta;
    Entitet entitet;

    public int getIdIzborneJediniceEntiteta() {
        return idIzborneJediniceEntiteta;
    }

    public void setIdIzborneJediniceEntiteta(int idIzborneJediniceEntiteta) {
        this.idIzborneJediniceEntiteta = idIzborneJediniceEntiteta;
    }

    public Entitet getEntitet() {
        return entitet;
    }

    public void setEntitet(Entitet entitet) {
        this.entitet = entitet;
    }

    public IzbornaJedinicaEntiteta(){

    }
    public IzbornaJedinicaEntiteta(int idIzborneJediniceEntiteta, Entitet entitet) {
        this.idIzborneJediniceEntiteta = idIzborneJediniceEntiteta;
        this.entitet = entitet;
    }

    public IzbornaJedinicaEntiteta(int idIzborneJedinice, int brojGlasova, int glasalo, int idIzborneJediniceEntiteta, Entitet entitet) {
        super(idIzborneJedinice, brojGlasova, glasalo);
        this.idIzborneJediniceEntiteta = idIzborneJediniceEntiteta;
        this.entitet = entitet;
    }
}
