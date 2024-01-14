import java.io.*;
import java.sql.*;
class delete{
    public static void main(String args[])throws IOException
    {
        DataInputStream ds = new DataInputStream(System.in);
        System.out.println("enter empid whose record is to be deleted");
        String eno=ds.readLine();
        
         
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt = con.createStatement();
            String q1 = "delete from e_reg where e_id='"+eno+"'";
            int x = stmt.executeUpdate(q1);
            if(x>0)
            {
                System.out.println("delete success");
            }
            else
            {
                System.out.println("delete unsuccess");
            }
            
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
}
