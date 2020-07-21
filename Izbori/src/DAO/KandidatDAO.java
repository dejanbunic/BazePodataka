package DAO;

import client.Glasac;
import client.Kandidat;
import client.KandidatZaNacelnikaOpstine;
import client.KandidatZaOdbornikaOpstine;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class KandidatDAO {
    static Glasac glasac = new Glasac();
    public ObservableList<String> politickePartije() {
        ObservableList<String> stranke = FXCollections.observableArrayList();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori", "root", "0709");
            s = (Statement) c.createStatement();
            rs = s.executeQuery("Select * from politickastranka");
            while (rs.next()) {
                //System.out.println(rs.getString(1));
                // String str = rs.getString(1);
                stranke.add(rs.getString(1));
                // stranke.add(str);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return stranke;
    }

    public ObservableList<String> gradovi() {
        ObservableList<String> stranke = FXCollections.observableArrayList();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori", "root", "0709");
            s = (Statement) c.createStatement();
            rs = s.executeQuery("Select * from grad");
            while (rs.next()) {
                //System.out.println(rs.getString(1));
                // String str = rs.getString(1);
                stranke.add(rs.getString(6));
                // stranke.add(str);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return stranke;
    }
    public ObservableList<String> opstine() {
        ObservableList<String> opstine = FXCollections.observableArrayList();
        Connection c = null;
        Statement s = null;
        ResultSet rs = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori", "root", "0709");
            s = (Statement) c.createStatement();
            rs = s.executeQuery("Select * from opstina");
            while (rs.next()) {
                //System.out.println(rs.getString(1));
                // String str = rs.getString(1);
                opstine.add(rs.getString(8));
                // stranke.add(str);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return opstine;
    }

    public void dodajKandidata(String JMBG, String ime, String prezime, String mjestoRodjenja, Date datumRodjenja,
                               String politickaPartija, String opstina, String grad, String tipKandidata) {
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        int i=0;
        try {
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("call dodajKandidata(?,?,?,?,?,?,?,?,?)");
            cs.setString(1,JMBG);
            cs.setString(2,ime);
            cs.setString(3,prezime);
            cs.setString(4,mjestoRodjenja);
            cs.setDate(5, datumRodjenja);
            cs.setString(6, politickaPartija);
            cs.setString(7,opstina);
            cs.setString(8,   grad);
            cs.setString(9, tipKandidata);
            rs=cs.executeQuery();
            // while(rs.next()){
            //    i++;
            //  System.out.println(rs.getString(1));
            //  }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }
    public static ObservableList<Kandidat> prikaziKandidateZaOdbornika(){
        ObservableList<Kandidat> kandidati = FXCollections.observableArrayList();
        Connection c = null;
        PreparedStatement cs = null;
        ResultSet rs = null;
        try {
            // public Kandidat(int JMBG, String ime, String prezime, String mjestoRodjenja, String datumRodjenja, int idOpstine, int brojGlasova, String naziv)
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("select * from osoba natural join kandidat natural join kandidatzaodbornikaopstine where IdOpstine=(select IdOpstine from osoba where JMBG="+glasac.getJmbg()+")");
            rs=cs.executeQuery();
             while(rs.next()){
                 Kandidat kandidat=new Kandidat(
                     rs.getInt(1),
                     rs.getString(2),
                     rs.getString(3),
                     rs.getString(4),
                     rs.getDate(5),
                     rs.getInt(6),
                     rs.getInt(7),
                     rs.getString(8)
                 );
                 kandidati.add(kandidat);
             }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return kandidati;
    }
    public static ObservableList<Kandidat> prikaziKandidateZaNacelnika(){
        ObservableList<Kandidat> kandidati = FXCollections.observableArrayList();
        Connection c = null;
        PreparedStatement cs = null;
        ResultSet rs = null;
        try {
            System.out.println(glasac.getJmbg()+"madara");
            // public Kandidat(int JMBG, String ime, String prezime, String mjestoRodjenja, String datumRodjenja, int idOpstine, int brojGlasova, String naziv)
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("select * from osoba natural join kandidat natural join kandidatzanacelnikaopstine where IdOpstine=(select IdOpstine from osoba where JMBG="+glasac.getJmbg()+")");
            rs=cs.executeQuery();

            while(rs.next()){
                Kandidat kandidat=new Kandidat(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getDate(5),
                    rs.getInt(6),
                    rs.getInt(7),
                    rs.getString(8)
                );
                kandidati.add(kandidat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return kandidati;
    }
    public static ObservableList<KandidatZaNacelnikaOpstine> prikaziKandidateZaNacelnikaOpstine(){
        ObservableList<KandidatZaNacelnikaOpstine> kandidati = FXCollections.observableArrayList();
        Connection c = null;
        PreparedStatement cs = null;
        ResultSet rs = null;
        try {
            // public Kandidat(int JMBG, String ime, String prezime, String mjestoRodjenja, String datumRodjenja, int idOpstine, int brojGlasova, String naziv)
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("SELECT * FROM izbori.kandidatzanacelnikaopstine natural join izbori.kandidat natural join osoba");
            rs=cs.executeQuery();
            while(rs.next()){
                //int JMBG, String ime, String prezime, String mjestoRodjenja, Date datumRodjenja, int idOpstine, int brojGlasova, String naziv
                KandidatZaNacelnikaOpstine kandidat=new KandidatZaNacelnikaOpstine(
                    rs.getInt(1),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getDate(7),
                    rs.getInt(8),
                    rs.getInt(2),
                    rs.getString(3)
                );
                kandidati.add(kandidat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return kandidati;
    }
    public static ObservableList<KandidatZaOdbornikaOpstine> prikaziKandidateZaOdbornikaOpstine(){
        ObservableList<KandidatZaOdbornikaOpstine> kandidati = FXCollections.observableArrayList();

        Connection c = null;
        PreparedStatement cs = null;
        ResultSet rs = null;
        try {
            // public Kandidat(int JMBG, String ime, String prezime, String mjestoRodjenja, String datumRodjenja, int idOpstine, int brojGlasova, String naziv)
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("SELECT * FROM izbori.kandidatzaodbornikaopstine natural join izbori.kandidat natural join osoba");
            rs=cs.executeQuery();
            while(rs.next()){
                KandidatZaOdbornikaOpstine kandidat=new KandidatZaOdbornikaOpstine(
                    rs.getInt(1),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getDate(7),
                    rs.getInt(8),
                    rs.getInt(2),
                    rs.getString(3)
                );
                kandidati.add(kandidat);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return kandidati;
    }
    public void obrisi(String JMBG,String tipKandidata){

        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            // public Kandidat(int JMBG, String ime, String prezime, String mjestoRodjenja, String datumRodjenja, int idOpstine, int brojGlasova, String naziv)
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("call obrisiKandidata(?,?)");

            cs.setString(1,JMBG);
            cs.setString(2,tipKandidata);
            rs=cs.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }
    public Kandidat pronadjiKandidata(String JMBG,String tipKandidata) {
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        Kandidat kandidati = null;
        try {
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori", "root", "0709");
            cs = c.prepareCall("call prikaziKandidata(?,?)");
            cs.setString(1, JMBG);
            cs.setString(2, tipKandidata);
            kandidati = new Kandidat();
            rs = cs.executeQuery();
            while (rs.next()) {
                Kandidat kandidat = new Kandidat(
                    rs.getInt(1),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getDate(7),
                    rs.getInt(8),
                    rs.getInt(2),
                    rs.getString(3)
                );
                kandidati = kandidat;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (cs != null) {
                try {
                    cs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return kandidati;
    }

    public String vratiOpstinu(String JMBG){
        String opstina="";
        Connection c = null;
        PreparedStatement cs = null;
        ResultSet rs = null;
        try {
            // public Kandidat(int JMBG, String ime, String prezime, String mjestoRodjenja, String datumRodjenja, int idOpstine, int brojGlasova, String naziv)
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("SELECT Naziv FROM izbori.opstina natural join osoba where JMBG="+JMBG);
            rs=cs.executeQuery();
            while(rs.next()){
                opstina=rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return opstina;
    }
    public String vratiGrad(String JMBG){
        String grad="";
        Connection c = null;
        PreparedStatement cs = null;
        ResultSet rs = null;
        try {
            // public Kandidat(int JMBG, String ime, String prezime, String mjestoRodjenja, String datumRodjenja, int idOpstine, int brojGlasova, String naziv)
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("SELECT grad.Naziv FROM izbori.osoba  join opstina on osoba.IdOpstine=opstina.IdOpstine join grad on opstina.IdGrada=grad.IdGrada where JMBG="+JMBG);
            rs=cs.executeQuery();
            while(rs.next()){
                grad=rs.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return grad;
    }
    public void azurijajKandidata(String JMBG, String ime, String prezime, String mjestoRodjenja, Date datumRodjenja,
                               String politickaPartija, String opstina, String grad) {
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        int i=0;
        try {
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("call azurirajKandidata(?,?,?,?,?,?,?,?)");
            cs.setString(1,JMBG);
            cs.setString(2,ime);
            cs.setString(3,prezime);
            cs.setString(4,mjestoRodjenja);
            cs.setDate(5, datumRodjenja);
            cs.setString(6, politickaPartija);
            cs.setString(7,opstina);
            cs.setString(8,   grad);
            rs=cs.executeQuery();
            // while(rs.next()){
            //    i++;
            //  System.out.println(rs.getString(1));
            //  }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }

}
