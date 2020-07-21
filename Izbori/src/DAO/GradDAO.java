package DAO;

import client.Entitet;
import client.Grad;
import client.Kanton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;

public class GradDAO {
    public ObservableList<Grad> getGrad(Entitet entitet){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        ObservableList<Grad> gradovi= FXCollections.observableArrayList();
        try{
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            ps= c.prepareStatement("select * from grad where IdEntiteta=?");
            ps.setInt(1,entitet.getIdEntiteta());
            rs=ps.executeQuery();
            while (rs.next()){
                Grad grad=new Grad();
                grad.setEntitet(new Entitet(rs.getInt(4),rs.getString(5)));
                grad.setIdGrada(rs.getInt(1));
                grad.setNaziv(rs.getString(6));
                gradovi.add(grad);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return gradovi;
    }
}
