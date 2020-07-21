package DAO;

import client.Entitet;
import client.IzbornaJedinicaEntiteta;
import client.Kanton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class KantonDAO {
        public ObservableList<Kanton> getKanton(Entitet entitet){
            Connection c = null;
            PreparedStatement ps = null;
            ResultSet rs = null;

            ObservableList<Kanton> kantoni= FXCollections.observableArrayList();
            try{
                c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
                ps= c.prepareStatement("select * from kanton where IdEntiteta=?");
                ps.setInt(1,entitet.getIdEntiteta());
                rs=ps.executeQuery();
                while (rs.next()){
                    Kanton kanton=new Kanton();
                    kanton.setEntitet(new Entitet(rs.getInt(4),rs.getString(5)));
                    kanton.setIdKantona(rs.getInt(1));
                    kanton.setNazivKantona(rs.getString(6));
                    kantoni.add(kanton);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
                if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
                if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
            }
            return kantoni;
        }
}
