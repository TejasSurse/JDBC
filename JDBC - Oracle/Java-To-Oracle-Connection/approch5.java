// when jvm load subclass then jvm also load supper class in this process a static blocks of both sub and supper class will executed automatically

// this code register jdbc driver with drivermanager service only once but it does not allow class of the application to etend form other class like frame ,, applet , thredad etc
import java.sql.*;
import oracle.jdbc.driver;
public class approch5 extends OracleDriver{
    public static void main(String[] args)
    throws Exception {
        Connection conn = DriverManager.getConnection("jdbc:oracle:oracleDSN","scott" , "t311");
        if(conn != null){
            System.out.println("Connection established ");
        }
        else{
            System.out.println("Connection is not established");
        }   
    }
}
