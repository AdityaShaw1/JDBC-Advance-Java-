
package newpackage;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;

public class javabean2 {
    private String name;
    private String roll;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }
    public boolean InsertMethod()
    {
        try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt = con.createStatement();
            String q1 ="insert into table1 values('"+name+"','"+roll+"')";
            //out.println(q1);
            int x=stmt.executeUpdate(q1);
            if(x>0){
                return true;
            }
            else
            {
                return false;
            }
        //con.close();
        
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        return false;
    }
    
}
