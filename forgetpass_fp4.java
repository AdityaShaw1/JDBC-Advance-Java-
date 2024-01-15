import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;

public class fp4 extends HttpServlet
{
    public void doPost(HttpServletRequest req,
            HttpServletResponse res)throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pwl=res.getWriter();
        String pass=req.getParameter("n1");
        String mail=req.getParameter("Email");
        //pwl.println
        //("<html><body bgcolor=lightyellow><h1>Security Question<h1><br><br>  </body></html>");
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt = con.createStatement();
            String q1 = "update e_reg1 set password='"+pass+"' where email='"+mail+"'";
            pwl.println(q1);
            //ResultSet rs = stmt.executeQuery(q1);
            int x = stmt.executeUpdate(q1);
            if(x>0)
            {
                
                pwl.println("<html>\n" +
"    <head>\n" +
"        <title></title>\n" +
"        \n" +
"    </head>\n" +
"    <body bgcolor=\"orange\">\n" +
"        <h1>\n" +
"            PASSWORD SET Successfully!\n" +
"        </h1>\n" +
"        <br>\n" +
"        <br>\n" +
"        <a href=\"login.html\" >Go to Login Page</a>\n" +
"    </body>\n" +
"</html>\n" +
"");
            }
            else
            {
                pwl.println("Update Unsuccess");
            }
            
            con.close();
        }
        catch(Exception e)
        {
            pwl.println(e);
        }
        
        
    }
    
}
