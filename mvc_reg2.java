import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import newpackage.*;

public class reg2 extends HttpServlet
{
    protected void doPost(HttpServletRequest req,
            HttpServletResponse res)throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pwl=res.getWriter();
        String name = req.getParameter("n1");
        String roll = req.getParameter("n2");
        
        javabean2 ob = new javabean2();
        ob.setName(name);
        ob.setRoll(roll);
        
        boolean result = ob.InsertMethod();
        if(result==true)
        {
            pwl.println("SUCCESS");
        }
        else
        {
            pwl.println("UNSUCCESS");
        }
        
       // pwl.println("WELCOME "+s1);
    }
    
}
