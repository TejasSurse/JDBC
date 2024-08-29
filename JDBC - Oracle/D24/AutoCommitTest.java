import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;

public class AutoCommitTest {
    public static void main(String[] args) throws Exception {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Starting range ");
        int start = sc.nextInt();
        System.out.println("Enter Ending range Number");
        int end = sc.nextInt();
        Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
        Statement stmt = conn.createStatement();
        String qry = "DELETE FROM student WHERE sno > " + start + " AND sno < " + end;
        conn.setAutoCommit(false);
        int rs = stmt.executeUpdate(qry);
        System.out.println(rs + " rows deleted");
        conn.rollback();
        conn.close();
        sc.close();
    }
}
