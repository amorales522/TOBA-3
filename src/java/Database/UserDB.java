
package Database;

import JavaBeans.Account;
import JavaBeans.User;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class UserDB {

    @Resource(name = "jdbc/toba")
    private DataSource ds;

    public boolean insertUser(User user) {
        int rs1 = 0;
        try {
           Connection conn = Database_Connection.Connection();
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO `toba`.`user` ( `username` , `password`, `firstname`, `lastname`, `address`, `phno`, `city`, `state`, `email` ) VALUES (?,?,?,?,?,?,?,?,?);");
           
            ps1.setString(1, user.getUsername());
            ps1.setString(2, user.getPassword());
            ps1.setString(3, user.getFirstName());
            ps1.setString(4, user.getLastName());
            ps1.setString(5, user.getAddress());
            ps1.setString(6, user.getPhno());
            ps1.setString(7, user.getCity());
            ps1.setString(8, user.getState());
            ps1.setString(9, user.getEmail());
            //  System.out.println(ps1);
            rs1 = ps1.executeUpdate();

        }  catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs1 > 0;
    }

    public boolean UpdateUser(User user) {
        int rs1 = 0;
        try {
            Connection conn = Database_Connection.Connection();
            PreparedStatement ps1 = conn.prepareStatement("Update `user` Set  `password`=?, `firstname`=?, `lastname`=?, `address`=?, `phno`=?, `city`=?, `state`=?, `email`=? where `username` =?");
           
            ps1.setString(1, user.getPassword());
            ps1.setString(2, user.getFirstName());
            ps1.setString(3, user.getLastName());
            ps1.setString(4, user.getAddress());
            ps1.setString(5, user.getPhno());
            ps1.setString(6, user.getCity());
            ps1.setString(7, user.getState());
            ps1.setString(8, user.getEmail());
            ps1.setString(9, user.getUsername());
            rs1 = ps1.executeUpdate();

        }  catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs1 > 0;
    }

    public User checkLogin(String username, String password) {
        try {
            Connection conn = Database_Connection.Connection();
            PreparedStatement ps1 = conn.prepareStatement("Select * from  `user` where username = ? and password = ?");
            ps1.setString(1, username);
            ps1.setString(2, password);
            ResultSet rs = ps1.executeQuery();
            while (rs.next()) {
                User a = new User();
                
                a.setId(rs.getInt("id"));
                a.setUsername(username);
                a.setPassword(password);
                a.setFirstName(rs.getString("firstname"));
                a.setLastName(rs.getString("lastname"));
                a.setAddress(rs.getString("address"));
                a.setPhno(rs.getString("phno"));
                a.setCity(rs.getString("city"));
                a.setState(rs.getString("state"));
                a.setEmail(rs.getString("email"));

                return a;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
