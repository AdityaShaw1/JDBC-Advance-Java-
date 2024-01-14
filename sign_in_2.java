import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class f2 extends HttpServlet
{
    public void doPost(HttpServletRequest req,
            HttpServletResponse res)throws IOException, ServletException
    {
        res.setContentType("text/html");
        PrintWriter pwl=res.getWriter();
        String nm=req.getParameter("n1");
        pwl.println("<html><body bgcolor=lightyellow><marquee><h1>Welcome to Java World!<h1></marquee><br><h2><marquee >"+nm+"</marquee></h2></body></html>");
    }
}
