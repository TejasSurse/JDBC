// in this we pass driver class name by using system variable and inbuilt driver for jdbc = java -Djdbc.drivers = oracle.jdbc.driver.OracleDriver approach9
public class approach9 {
    public static void main(String[] args) throws Exception {
        String s1 = System.getProperty("k1");
        Class.forName(s1);
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
