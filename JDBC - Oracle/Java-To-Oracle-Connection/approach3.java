import java.sql.Connection;
import java.sql.DriverManager;
// this approach is similar to approach 2 but the explicitely creatd anonyoms onbject nameless object will be wasted 
import oracle.jdbc.driver.OracleDriver;
public class approach3 {
    public static void main(String[] args) {
        new OracleDriver();
        Connection conn = DriverManager.getConnection("jdbc:odbc:OracleDSN", "scott", "t3111");
        if(conn != null){
            System.out.println("Connection established ");
        }
        else{
            System.out.println("Connection is not established");
        }    
    }
    
};
