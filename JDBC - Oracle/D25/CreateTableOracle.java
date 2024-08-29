// Write programm to Create Table in oracle database
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CreateTableOracle {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
        Statement st = null;
        
        if (conn != null) {
            st = conn.createStatement();
            
            if (st != null) {
                st.executeUpdate("CREATE TABLE class_table (class_name NUMBER, name VARCHAR2(10));");
            } else {
                System.out.println("Statement object not established.");
            }
        } else {
            System.out.println("Connection object not established.");
        }

        if (st != null) {
            st.close();
        }
        
        if (conn != null) {
            conn.close();
        }
    }
}
