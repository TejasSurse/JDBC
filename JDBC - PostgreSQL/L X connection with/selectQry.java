import java.security.PublicKey;
import java.sql.*;
public class selectQry {
   


    public static void main(String[] args)  throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentDB", "postgres", "root");

        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from StudentTab");
        while(rs.next()){
            System.out.println(rs.getInt(1) + "\t"+  rs.getString(2) + "\t" + rs.getString(3));
        }

    }
}