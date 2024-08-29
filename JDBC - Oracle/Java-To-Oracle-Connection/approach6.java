import java.sql.*;

public class approach6 {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
        if (conn != null) {
            System.out.println("Connection established");
        } else {
            System.out.println("Connection is not established");
        }
		System.out.println(conn.getClass());
        Statement statement = conn.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM Student");
        while (rs.next()) {
            System.out.println("Roll no.- " + rs.getInt(1) + "\t" + "Name - " + rs.getString(2) + "\t" + "City - " + rs.getString(3));
        }
    }
}
