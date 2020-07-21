package client;

import java.sql.Date;

public class Glasac extends Osoba {
    boolean glasao;
    static String staticjmbg;
   public Glasac(int JMBG, String ime, String prezime, String mjestoRodjenja, Date datumRodjenja, int idOpstine, boolean glasao){
        super(JMBG,ime,prezime,mjestoRodjenja,datumRodjenja,idOpstine);
        this.glasao=glasao;
    }
    public Glasac(){
    }
    public Glasac( String staticjmbg){
       this.staticjmbg=staticjmbg;
    }
    public String getJmbg(){
       return staticjmbg;
    }
    public void setJmbg(String staticjmbg){
       this.staticjmbg=staticjmbg;
    }
    public boolean getGlasao() {
        return glasao;
    }

    public void setGlasao(boolean glasao) {
        this.glasao = glasao;
    }
}
