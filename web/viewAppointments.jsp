<%@page import="java.sql.*,health.check.pack.Database" %>
<html>
    <head>
        <title>Demo of tables</title>
    </head>
    <body>
        <table border=0  width=50% align=center>
            <tr bgcolor=grey>
                <td colspan=2  align=center>
                    <img src=SchoolImg.jpg height="200" width="100%">
                </td>
            </tr>	

            <tr>
                <td bgcolor=grey width=20% height="300" align="center">
                    <!--Body Starts Here-->

                    <%
                        try {
                            Connection con = Database.getCon();
                            String query = "select name,mobile,gender,age from admincreds";
                            PreparedStatement st = con.prepareStatement(query);
                            ResultSet rs = st.executeQuery();
                            ResultSetMetaData rsmd = rs.getMetaData();
                            int cols = rsmd.getColumnCount();
                            out.print("<table border=1 bgcolor=grey align=center>");
                            out.print("<tr>");
                            out.print("<h3> All Appointments</h3>");
                            for (int i = 1; i < cols; i++) {
                                out.print("<th bgcolor=yellow>" + rsmd.getColumnName(i) + " </th> ");
                            }
                            out.print("<th bgcolor=yellow colspan=2 align=center>Action</th>");
                            out.print("</tr>");
                            while (rs.next()) {
                                out.print("<tr>");
                                
                                //String id= rs.getString(1);
                                String name=rs.getString("name");
                                String cg=rs.getString("mobile");
                                String add=rs.getString("gender");
                                
                               // out.print("<td bgcolor=lightblue align=center><a href=/StudentApp/ViewRemaining.jsp?sno="+id+">"+id+"</a></td>");
                                for (int i = 2; i < cols; i++) {
                                    out.print("<td bgcolor=lightblue align=center>"+rs.getString(i)+"</td>");
                                }
                                //out.print("<td bgcolor=lightblue align=center><a href=/StudentApp/RemoveStudent?sno="+id+">Delete</a></td>");
                               // out.print("<td bgcolor=lightblue align=center><a href=/StudentApp/EditStudent.jsp?sno="+id+" & p="+name+ "& grade="+cg+ "& v="+add+">Update</a></td>");
                                System.out.print("</tr>");
                            }
                            out.print("</table>");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    %>  

                    <!--Body Ends Here-->
                </td>
            </tr>
            <tr bgcolor=grey>
                <td colspan=2 align=center><h1>Code Brains</h1></td>

            </tr>	

        </table>

    </body>
</html>
