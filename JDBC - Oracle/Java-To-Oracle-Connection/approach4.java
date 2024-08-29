//this apporach is similar to approach 1;
import java.sql.Connection;
import java.sql.DriverManager;
public class approach4 {
    public static void main(String[] args) {
        DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott" , "tiger");
        if(conn != null){
            System.out.println("Connection established ");
        }
        else{
            System.out.println("Connection is not established");
        }    
    }
}
