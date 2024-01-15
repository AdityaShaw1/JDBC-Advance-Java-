import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;

public class Records extends HttpServlet
{
    public void doPost(HttpServletRequest req,
            HttpServletResponse res)throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pwl=res.getWriter();
        String ans=req.getParameter("n1");
        String mail=req.getParameter("Email");
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt = con.createStatement();
            String q1 ="select * from e_reg1";
            ResultSet rs = stmt.executeQuery(q1);
            
            pwl.println("<html><body><table border=2 width=100%>");
            pwl.println("<tr><td>Email</td><td>Password</td><td>Name</td><td>Security Question</td></tr>");
            while(rs.next()){
                pwl.println("<tr><td>"+rs.getString(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td></tr>");
            }
            pwl.println("</table></body></html>");
        }
        catch(Exception e){
            
        }
        
    }
    
}
