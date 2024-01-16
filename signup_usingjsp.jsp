

<%@page import="java.sql.*" %>
<html>
    <head>
        
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String mail = request.getParameter("email");
            String pass = request.getParameter("password");
            String name = request.getParameter("name");
            String sq = request.getParameter("securityQuestion");
            String ans = request.getParameter("answer");
            String cont = request.getParameter("contactNo");
            
            
            try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt = con.createStatement();
            String q1 ="insert into e_reg1 values('"+mail+"','"+pass+"','"+name+"','"+sq+"','"+ans+"','"+cont+"')";
            int x=stmt.executeUpdate(q1);
            if(x>0){
                out.println("insert success");
            }
            }
            catch(Exception e){
                
                out.println("insert unsuccess");
            }
         %>
    </body>
</html>
