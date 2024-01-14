import java.io.*;
import java.sql.*;
class insert{
    public static void main(String args[])throws IOException
    {
        DataInputStream ds = new DataInputStream(System.in);
        System.out.println("enter empid");
        String eno=ds.readLine();
        
         System.out.println("enter emp name");
        String ename=ds.readLine();
        
         System.out.println("enter emp contact");
        String cno=ds.readLine();
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt = con.createStatement();
            String q1 = "insert into e_reg values('"+eno+"','"+ename+"','"+cno+"')";
            int x = stmt.executeUpdate(q1);
            if(x>0)
            {
                System.out.println("insert success");
            }
            else
            {
                System.out.println("insert unsuccess");
            }
            
            con.close();
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
}
