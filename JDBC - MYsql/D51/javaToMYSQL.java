import java.sql.*;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

import com.mysql.cj.MysqlType;
public class javaToMYSQL {
    public static void main(String[] args) throws Exception, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testschema", "root", "root");
        
        System.out.println("Enter The Schema");
        Scanner sc = new Scanner(System.in);
        String desg = sc.next();

        CallableStatement cs = conn.prepareCall("{call getExpDetails(?, ?)}");
        // registter out parameters with jdbc types 
        cs.registerOutParameter(2, MysqlType.CURSOR);// package, class, public static variable // pointingg cursor 

        // set values to IN Params 
        cs.setString(1, desg);
        // call the pl/sql procedure 
        cs.execute();
        // collect The  Results 
        Object obj = cs.getObject(2);// 2 is out parameter 
        ResultSet rs = (ResultSet)obj;
        while(rs.next()){
            System.out.println(rs.getString(1)+ " "+  rs.getString(2) + " " +rs.getString(3));
        }
        rs.close();
        cs.close();
        conn.close();
    }    
}
