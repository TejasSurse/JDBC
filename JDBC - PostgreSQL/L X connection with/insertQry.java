import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class insertQry {
    
    public static void main(String[] args)  throws Exception{
        Class.forName("org.postgresql.Driver");
        Connection conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/StudentDB", "postgres", "root");

        try (Statement st = conn.createStatement()) {
            int rs = st.executeUpdate("Insert into StudentTab values( 999, 'tejassurse', 'gangapur')");
            System.out.println(rs);
        }
        conn.close();
        
    }
}
