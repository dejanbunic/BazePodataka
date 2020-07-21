package DAO;

import client.Kandidat;
import client.PolitickaStranka;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class StrankaDAO {
    public static ObservableList<PolitickaStranka> prikaziStranke(){
        ObservableList<PolitickaStranka> stranke = FXCollections.observableArrayList();
        Connection c = null;
        PreparedStatement cs = null;
        ResultSet rs = null;
        try {
            // public Kandidat(int JMBG, String ime, String prezime, String mjestoRodjenja, String datumRodjenja, int idOpstine, int brojGlasova, String naziv)
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("select * from politickastranka");
            rs=cs.executeQuery();
            while(rs.next()){
                PolitickaStranka stranka=new PolitickaStranka(
                    rs.getString(1),
                    rs.getString(2)
                );
                stranke.add(stranka);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return stranke;
    }

}
