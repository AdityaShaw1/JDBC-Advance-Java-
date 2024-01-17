<%@page import="java.sql.*" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String mail = request.getParameter("email");
            String pass = request.getParameter("password");
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt = con.createStatement();
            String q1 ="select * from e_reg1 where email='"+mail+"' and password='"+pass+"'";
            //int x=stmt.executeUpdate(q1);
            ResultSet rs = stmt.executeQuery(q1);
            if(rs.next())
            {
                out.println("login success");
            }
            else
            {
               out.println("login unsuccess");
            }
            
            con.close();
        
            }
            catch(Exception e){
                
                out.println(e);
            }
            %>
    </body>
</html>
