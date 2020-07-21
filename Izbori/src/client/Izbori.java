package client;

import java.util.Date;

public class Izbori {
    int idIzbora;
    int nivo;
    Date datumIzbora;
    public Izbori(int idIzbora,int nivo,Date datumIzbora){
        this.idIzbora=idIzbora;
        this.nivo=nivo;
        this.datumIzbora=datumIzbora;
    }

    public int getIdIzbora() {
        return idIzbora;
    }

    public void setIdIzbora(int idIzbora) {
        this.idIzbora = idIzbora;
    }

    public int getNivo() {
        return nivo;
    }

    public void setNivo(int nivo) {
        this.nivo = nivo;
    }

    public Date getDatumIzbora() {
        return datumIzbora;
    }

    public void setDatumIzbora(Date datumIzbora) {
        this.datumIzbora = datumIzbora;
    }
}
