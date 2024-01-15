import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;

public class signin extends HttpServlet
{
    public void doPost(HttpServletRequest req,
            HttpServletResponse res)throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pwl=res.getWriter();
        String email=req.getParameter("email");
        String pass=req.getParameter("password");
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt = con.createStatement();
            String q1 = "select * from e_reg1 where email='"+email+"' and password='"+pass+"'";
            ResultSet rs = stmt.executeQuery(q1);
            if(rs.next())
            {
                pwl.println("login success");
            }
            else
            {
               pwl.println("login unsuccess");
            }
            
            con.close();
        
        }
        catch(Exception e)
        {
            pwl.println(e);
        }
        
    }
    
    
    
}
