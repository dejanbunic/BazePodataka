package DAO;

import client.Entitet;

import java.sql.*;

public class EntitetDAO {
    public Entitet getEntitet(String nazivEntiteta){
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Entitet entitet = new Entitet();
        try{
            c= DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            ps= c.prepareStatement("select * from izbori.entitet where NazivEntiteta=?");
            ps.setString(1,nazivEntiteta);
            rs=ps.executeQuery();
            while (rs.next()){
                entitet.setIdEntiteta(rs.getInt(1));
                entitet.setNazivDrzave(rs.getString(5));
                System.out.println(entitet.getIdEntiteta()+"  "+entitet.getNazivDrzave());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (ps != null) { try { ps.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
        return entitet;
    }
}
