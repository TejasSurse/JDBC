import java.sql.*;
import java.util.*;

public class UpdatableSCTest {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "root");
        Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet rs = st.executeQuery("Select * from sdata");
        
        System.out.println("\n insert the new Record");
        // ISNERT  
        rs.moveToInsertRow();  // it creates an empty record in rs object
        rs.updateInt(1, 345);
        rs.updateString(2, "Tejas Bhau");
        rs.updateString(3, "Chhatrapati Sambhajinagar");
       
        rs.insertRow();
        
        while (rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2)+ " " + rs.getString(3));
         }


        rs.close();
        conn.close();
        st.close();
        

    }
}

// this is updatable 
