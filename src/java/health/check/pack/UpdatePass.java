
package health.check.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "UpdatePass", urlPatterns = {"/UpdatePass"})
public class UpdatePass extends HttpServlet {

    
   
       
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        Connection con = null;
        String OldPass = request.getParameter("txtOldPwd");
        String NewPass = request.getParameter("txtNewPwd");
        
        try {

            con = Database.getCon();
            String query = "update admincreds set password=? where password=?";
            PreparedStatement st = con.prepareStatement(query);
           
            st.setString(1, NewPass);
            st.setString(2, OldPass);
            
            int c = st.executeUpdate();
            if (c > 0) 
            {
                out.println("Password Succesfully Updated");
            } 
            else 
            {
                out.println("Old Password is Incorrect");
            }
            st.close();
            con.close();
        } catch (Exception va) {
            va.printStackTrace();
            out.println("Something Wrong");
        }
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   
  
}
