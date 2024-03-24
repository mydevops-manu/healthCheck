
package health.check.pack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;


public class Database {
     public static Connection getCon() {
        Connection con = null;
        try {
            String url = "jdbc:oracle:thin:@localhost:1521:XE";
            Class.forName("oracle.jdbc.driver.OracleDriver");//loading Driver
            con = DriverManager.getConnection(url, "system", "manoj");//getting connection

        } catch (Exception e) {
           // e.printStackTrace();
        }
        return con;
        
    }
     
     public static int getMax()
     {
         int max=1;
         try {
            Connection con = Database.getCon();

            String query = "select max(rno) from admincreds";
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
              
            if(rs.next())
            {
                max=rs.getInt(1)+1;
            }
        }     
          catch (Exception e) 
        {
            e.printStackTrace();
        }
         return max;
     }
            
     
}
