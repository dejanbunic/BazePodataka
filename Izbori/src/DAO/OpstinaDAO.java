package DAO;

import client.Kandidat;
import client.Opstina;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class OpstinaDAO {
    public static ObservableList<String> prikaziDrzave(){
        ObservableList<String> drzave = FXCollections.observableArrayList();
        Connection c = null;
        PreparedStatement cs = null;
        ResultSet rs = null;
        try {
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("select NazivEntiteta from izbori.entitet");
            rs=cs.executeQuery();

            while(rs.next()){
                String drzava= rs.getString(1);
                drzave.add(drzava);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return drzave;
    }
    public static ObservableList<String> prikaziIzborneJediniceDrzave(){
        ObservableList<String> drzave = FXCollections.observableArrayList();
        Connection c = null;
        PreparedStatement cs = null;
        ResultSet rs = null;
        try {
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("select IdIzborneJediniceDrzave from izbori.izbornajedinicadrzave");
            rs=cs.executeQuery();
            while(rs.next()){
                String drzava= rs.getString(1);
                drzave.add(drzava);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return drzave;
    }
    public void dodajOpstinu(String naziv,int brojGlasaca,int idGrada,int idKantona,int idJediniceDrzave,int idEntiteta){
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("call dodajOpstinu(?,?,?,?,?,?)");
            cs.setString(1,naziv);
            cs.setInt(2,brojGlasaca);
            cs.setInt(3,idGrada);
            cs.setInt(4,idKantona);
            cs.setInt(5, idJediniceDrzave);
            cs.setInt(6, idEntiteta);
            rs=cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }
    public ObservableList<Opstina> prikaziOpstine(){
        ObservableList<Opstina> opstine = FXCollections.observableArrayList();
        Connection c = null;
        PreparedStatement cs = null;
        ResultSet rs = null;
        try {
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("select * from opstinaview");
            rs=cs.executeQuery();
            while(rs.next()){
                //String nazivOpstine, String nazivGrada, String nazivKantona,int jedinicaEntiteta, int jedinicaDrzave, String nazivEntiteta, String nazivDrzave
                Opstina opstina= new Opstina(
                    rs.getString(2),
                    rs.getString(5),
                    rs.getString(8),
                    rs.getInt(7),
                    rs.getInt(6),
                    rs.getString(9),
                    rs.getString(10));
                    opstina.setIdOpstine(rs.getInt(1));
                    opstina.setBrojGlasaca(rs.getInt(3));
                opstine.add(opstina);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return opstine;
    }
    public void azurirajOpstinu(int id,String naziv,int brojGlasaca,int idGrada,int idKantona,int idJediniceDrzave,int idEntiteta){
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("call azurirajOpstinu(?,?,?,?,?,?,?)");
            cs.setInt(1,id);
            cs.setString(2,naziv);
            cs.setInt(3,brojGlasaca);
            cs.setInt(4,idGrada);
            cs.setInt(5,idKantona);
            cs.setInt(6, idJediniceDrzave);
            cs.setInt(7, idEntiteta);
            rs=cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }
    public void obrisiOpstinu(int idOpstine){
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("call obrisiOpstinu(?)");
            cs.setInt(1,idOpstine);

            rs=cs.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    }

}
