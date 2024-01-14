import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.*;
import javax.servlet.http.*;

public class registration extends HttpServlet
{
    public void doPost(HttpServletRequest req,
            HttpServletResponse res)throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pwl=res.getWriter();
        String mail=req.getParameter("email");
        String pass=req.getParameter("password");
        String nm=req.getParameter("name");
        String sq=req.getParameter("securityQuestion");
        String ans=req.getParameter("answer");
        String cont=req.getParameter("contact");
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt = con.createStatement();
            String q1 = "insert into e_reg1 values('"+mail+"','"+pass+"','"+nm+"','"+sq+"','"+ans+"','"+cont+"')";
            int x = stmt.executeUpdate(q1);
            if(x>0)
            {
                pwl.println("Insert Success");
            }
            else
            {
               pwl.println("insert unsuccess");
            }
            
            con.close();
        
        }
        catch(Exception e)
        {
            pwl.println(e);
        }
        pwl.println("<html><body bgcolor=lightyellow> <br> <h3> Congrats your details are saved in Database</h3>  </body></html>");
    }
}
