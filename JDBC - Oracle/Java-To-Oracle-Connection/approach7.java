import java.sql.*;
// passing driver name form command promt 
import oracle.jdbc.driver.OracleDriver;
public class approach7 {
    public static void main(String[] args) throws Exception {
        // loads the jdbc driver 
        class.forName(args[0]);
        Connection conn = DriverManager.getConnection("jdbc:oracle:oracleDSN","scott" , "t311");
        System.out.println("Connection class :"+ conn.getClass());;
        if(conn != null){
            System.out.println("Connection established ");
        }
        else{
            System.out.println("Connection is not established");
        } 
    }
}

// javac approach7.java
// java approach7 oracle.jdbc.driver
