
package health.check.pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*create table admincreds(
name varchar(20) NOT NULL,
password varchar(20) NOT NULL
); */

@WebServlet(name = "checkAdmin", urlPatterns = {"/checkAdmin"})
public class checkAdmin extends HttpServlet {

 @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String name = request.getParameter("txtUsr");
        String password = request.getParameter("txtPwd");
	PrintWriter out = response.getWriter();
   try {

            Connection con = Database.getCon();
            String query = "select * from admincreds where name=? and password=?";
            PreparedStatement st = con.prepareStatement(query);
            st.setString(1, name);
            st.setString(2, password);
            ResultSet rs = st.executeQuery();
            if(rs.next())
            {
                
                response.sendRedirect("/HealthCheck/adminHomee.html");
            }
            else
            {
                out.print("Invalid UserName or Password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}