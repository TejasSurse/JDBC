// This is java programm to connect our jdbc application with oracle 10g database
// we are using here type 4 driver;-> thin
import java.sql.Connection;
import java.sql.DriverManager;
// In this process of creating object for jdbc driver class the jvm executes or loads the jdbc driver class and executes its static block 
// Drivermanager.registerDriver(obj)
import oracle.jdbc.driver.OracleDriver;
public class approach1{
    public static void main(String[] args) throws Exception
    {
		//Driver d = new oracle.jdbc.driver.OracleDriver();
        oracle.jdbc.driver.OracleDriver obj = new oracle.jdbc.driver.OracleDriver();
        DriverManager.registerDriver(obj);
		System.out.println("Driver Register");
		 //DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott" , "tiger");
        if(conn != null){
            System.out.println("Connection established ");
        }
        else{
            System.out.println("Connection is not established");
        }    
       
    }
}