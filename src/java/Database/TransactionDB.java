
package Database;

import JavaBeans.Transaction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TransactionDB {
    
     public boolean insertTranction(Transaction transaction,String type) {
        int rs1 = 0;
        try {
           Connection conn= Database_Connection.Connection();
            PreparedStatement ps1 = conn.prepareStatement("INSERT INTO `toba`.`transaction` ( `account` , `amount`, `type`, `time`) VALUES (?,?,?,?);");
         
           DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            Date date = new Date();
            ps1.setInt(1, transaction.getAcount().getId());
            ps1.setDouble(2, transaction.getAmount());
            ps1.setString(3, type);
            ps1.setString(4,dateFormat.format(date) );
           
             rs1 = ps1.executeUpdate();
            
           } 
             catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs1 > 0;
    }
     
      public void getTranction(int accountId, List<Transaction> list ) {
          //List<Transaction> list = new ArrayList<Transaction>();
          ResultSet rs ;
        try {
           Connection conn= Database_Connection.Connection();
            PreparedStatement ps1 = conn.prepareStatement("Select * from  `toba`.`transaction` where account = ?");

            ps1.setInt(1,accountId);
           
             rs = ps1.executeQuery();
            while(rs.next())
                {
                    Transaction t = new Transaction();
                    t.setId(rs.getInt("id"));
                    t.getAcount().setId(rs.getInt("account"));
                    t.setAmount(rs.getDouble("amount"));  
                    t.setType(rs.getString("type"));
                    t.setTime(rs.getString("time"));
                    list.add(t);
                }
           } 
             catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
