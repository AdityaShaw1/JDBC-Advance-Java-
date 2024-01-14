import java.io.*;
import java.sql.*;
class fetch{
    public static void main(String args[])throws IOException
    {
        DataInputStream ds = new DataInputStream(System.in);
        System.out.println("enter empid whose data is to be fetched");
        String eno=ds.readLine();
        
         
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt = con.createStatement();
            String q1 = "select * from e_reg where e_id='"+eno+"'";
            ResultSet rs = stmt.executeQuery(q1);
            if(rs.next())
            {
                System.out.println("emp_id is "+rs.getString(1));
                System.out.println("emp_name is "+rs.getString(2));
                System.out.println("emp_contact is "+rs.getString(3));
            }
            else
            {
                System.out.println("not found");
            }
            
            con.close();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
    }
}
