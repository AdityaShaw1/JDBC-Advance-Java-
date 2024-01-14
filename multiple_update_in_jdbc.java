import java.io.*;
import java.sql.*;
class multipleupdate{
    public static void main(String args[])throws IOException
    {
        DataInputStream ds = new DataInputStream(System.in);
        System.out.println("enter empid where contact no. & name is to be updated");
        String eno=ds.readLine();
        
         System.out.println("enter the new contact no.");
        String ncno=ds.readLine();
        
        System.out.println("enter the new name");
        String nname=ds.readLine();
        
        
        
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt = con.createStatement();
            String q1 = "update e_reg set e_cno='"+ncno+"',e_name='"+nname+"' where e_id='"+eno+"'";
            int x = stmt.executeUpdate(q1);
            if(x>0)
            {
                System.out.println("update success");
            }
            else
            {
                System.out.println("update unsuccess");
            }
            
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
}
