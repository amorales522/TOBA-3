
package Database;

import JavaBeans.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.sql.DataSource;


public class AccountDB {
    
    @Resource(name = "jdbc/toba")
    private DataSource ds;

    public boolean insertAccount(Account account) {
        int rs1 = 0;
        try {
          Connection conn= Database_Connection.Connection();
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO `toba`.`account` ( `username` , `balance`, `type`) VALUES (?,?,?);");
         
            ps1.setString(1, account.getUser().getUsername());
            ps1.setDouble(2, account.getBalance());
            ps1.setString(3, account.getType().toString());
            
          //  System.out.println(ps1);
             rs1 = ps1.executeUpdate();
            
           } 
             catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs1 > 0;
    }
    
    public boolean UpdateAccount(Account account,String type) {
        int rs1 = 0;
        try {
            Connection conn= Database_Connection.Connection();
            PreparedStatement ps1 = conn.prepareStatement("Update `account` Set `balance`=? where `type`=? and `username` =?");
          
            ps1.setDouble(1, account.getBalance());
            ps1.setString(2, type);
            ps1.setString(3, account.getUser().getUsername());
            
             rs1 = ps1.executeUpdate();
            
           } 
            catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs1 > 0;
    }
    
    public Account getSavingAccount(String username)
    {
        System.out.println("in Saving");
        try {
            Connection conn= Database_Connection.Connection();
            PreparedStatement ps1 = conn.prepareStatement("Select * from  `account` where username =? and type =?");
              ps1.setString(1, username);
               ps1.setString(2, "Savings");
                ResultSet rs  = ps1.executeQuery();
               while(rs.next())
                {
                    System.out.println("in Saving");
                    Account a = new Account();
                    a.setId(rs.getInt("id"));
                    a.getUser().setUsername(rs.getString("username"));
                    a.setBalance(rs.getDouble("balance"));  
                    a.setType(Account.Type.Savings);
                    
                    return a;
                }
                      
        } catch (SQLException ex) {
            Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
    
    public Account getCheckingAccount(String username)
    {
        System.out.println("in Checking");
        try {
            Connection conn= Database_Connection.Connection();
 
            PreparedStatement ps1 = conn.prepareStatement("Select * from  `account` where username =? and type =?");
              ps1.setString(1, username);
              ps1.setString(2, "Checking");
                ResultSet rs  = ps1.executeQuery();
               while(rs.next())
                {
                     System.out.println("in Checking");
                    Account a = new Account();
                    a.setId(rs.getInt("id"));
                    a.getUser().setUsername(rs.getString("username"));
                    a.setBalance(rs.getDouble("balance"));  
                    a.setType(Account.Type.Checking);
                    
                    return a;
                }
                      
        } catch (SQLException ex) {
            Logger.getLogger(AccountDB.class.getName()).log(Level.SEVERE, null, ex);
        }
       return null;
    }
}
