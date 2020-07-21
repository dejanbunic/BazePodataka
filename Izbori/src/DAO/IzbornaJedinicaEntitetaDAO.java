package DAO;

import client.Entitet;
import client.IzbornaJedinicaEntiteta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class IzbornaJedinicaEntitetaDAO {
    public ObservableList<IzbornaJedinicaEntiteta> getIzborneJediniceEntiteta(Entitet entitet){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ObservableList<IzbornaJedinicaEntiteta> izborneJediniceEntiteta= FXCollections.observableArrayList();
        try{
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            ps= c.prepareStatement("select * from izbornajedinicaentiteta where IdEntiteta=? and NazivDrzave=?");
            ps.setInt(1,entitet.getIdEntiteta());
            ps.setString(2,entitet.getNazivDrzave());
            rs=ps.executeQuery();
            while (rs.next()){
                IzbornaJedinicaEntiteta izborna=new IzbornaJedinicaEntiteta();
                izborna.setEntitet(new Entitet(rs.getInt(2),rs.getString(3)));
                izborna.setIdIzborneJediniceEntiteta(rs.getInt(1));
                izborneJediniceEntiteta.add(izborna);
                System.out.println(izborna.getIdIzborneJediniceEntiteta());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return izborneJediniceEntiteta;
    }
}
