
package newpackage;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;


public class javabean3 {
    private String mail;
    private String pass;
    private String name;
    private String sq;
    private String ans;
    private String cont;

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSq() {
        return sq;
    }

    public void setSq(String sq) {
        this.sq = sq;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getCont() {
        return cont;
    }

    public void setCont(String cont) {
        this.cont = cont;
    }
    public boolean InsertMethod()
    {
         try{
                Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","manager");
            Statement stmt = con.createStatement();
            String q1 ="insert into e_reg1 values('"+mail+"','"+pass+"','"+name+"','"+sq+"','"+ans+"','"+cont+"')";
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
