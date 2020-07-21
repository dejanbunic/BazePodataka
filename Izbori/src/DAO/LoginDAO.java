package DAO;

import java.sql.*;

public class LoginDAO {
    public int login(String JMBG,String sifra,String tip){
        Connection c = null;
        CallableStatement cs = null;
        ResultSet rs = null;
        int i=0;
        try {
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/izbori","root","0709");
            cs=c.prepareCall("{call prijava(?,?,?)}");
            cs.setString(1,JMBG);
            cs.setString(2,sifra);
            cs.setString(3,tip);
            rs=cs.executeQuery();
            while(rs.next()){
                i++;
                System.out.println(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) { try { rs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (cs != null) { try { cs.close(); } catch (SQLException e) { e.printStackTrace(); } }
            if (c != null) { try { c.close(); } catch (SQLException e) { e.printStackTrace(); } }
        }
    return i;
    }
    public static void main(String args[]){
        LoginDAO l= new LoginDAO();
       System.out.println(l.login("1111111111111","0709","Administrator"));
    }
}
