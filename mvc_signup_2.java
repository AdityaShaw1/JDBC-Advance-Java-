import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import newpackage.*;

public class reg4 extends HttpServlet
{
    protected void doPost(HttpServletRequest req,
            HttpServletResponse res)throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pwl=res.getWriter();
        String mail = req.getParameter("email");
            String pass = req.getParameter("password");
            String name = req.getParameter("name");
            String sq = req.getParameter("securityQuestion");
            String ans = req.getParameter("answer");
            String cont = req.getParameter("contactNo");
        
        javabean3 ob = new javabean3();
        ob.setMail(mail);
        ob.setPass(pass);
        ob.setName(name);
        ob.setSq(sq);
        ob.setAns(ans);
        ob.setCont(cont);
        
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
