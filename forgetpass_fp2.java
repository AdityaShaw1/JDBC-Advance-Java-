import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;

public class fp2 extends HttpServlet
{
    public void doPost(HttpServletRequest req,
            HttpServletResponse res)throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pwl=res.getWriter();
        String mail=req.getParameter("email");
        //pwl.println
        //("<html><body bgcolor=lightyellow><h1>Security Question<h1><br><br>  </body></html>");
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt = con.createStatement();
            String q1 = "select * from e_reg1 where email='"+mail+"'";
            ResultSet rs = stmt.executeQuery(q1);
            if(rs.next())
            {
                
                pwl.println("\n" +
"<html>\n" +
"    <head>\n" +
"        <title></title>\n" +
"        \n" +
"    </head>\n" +
"    <body bgcolor=\"lightgreen\">\n" +
"        <h1>\n" +
"            SECURITY QUESTION\n" +
"        </h1>\n" +
"        <form method=\"post\" action=\"fp3\">\n" +
"            Answer: <input type=\"text\" name=\"n1\" placeholder=\"Enter your ans..\">\n" +
"            <br>\n" +
"            <br>\n" +
"            \n" +
"            Email: <input type=\"email\" name=\"Email\" placeholder=\"Enter your mail id\">\n" +
"            <br>\n" +
"            <br>\n" +
"            \n" +
"            <input type=\"submit\" value=\"Submit\">\n" +
"            \n" +
"        </form>\n" +
"    </body>\n" +
"</html>\n" +
"");
            }
            else
            {
                pwl.println("not found");
            }
            
            con.close();
        }
        catch(Exception e)
        {
            pwl.println(e);
        }
        
        
    }
    
}
