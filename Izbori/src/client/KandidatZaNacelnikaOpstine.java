package client;

import java.sql.Date;

public class KandidatZaNacelnikaOpstine extends Kandidat {
    public KandidatZaNacelnikaOpstine(int JMBG, String ime, String prezime, String mjestoRodjenja, Date datumRodjenja, int idOpstine, int brojGlasova, String naziv){
        super(JMBG,ime,prezime,mjestoRodjenja,datumRodjenja,idOpstine,brojGlasova,naziv);
    }
}
