// sending driver class as a system property
import java.sql.*;
public class approach8 {
    public static void main(String[] args) throws Exception {
        String s1 = System.getProperty("k1");
        class.forName(s1);
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
