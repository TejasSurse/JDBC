import java.util.Scanner;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.*;
public class OracleJavaQry 
{
	public static void main(String[] args) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter Start Range .No \n");
		//int start = sc.nextInt();
		//System.out.println("Enter End Range .NO \n");
		//int end = sc.nextInt();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");

		// Creating statement Object 
		String s = "select * from student where sno>="+start+"and sno<="+end;
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(s);
		//while(rs.next()){
		//	System.out.println(rs.getInt("SNO")+"\t"+rs.getString(2)+"\t"+rs.getString(3));
		//}
		System.out.println(conn.getClass()+" "+st.getClass()+" "+rs.getClass());
		rs.close();
		st.close();
		conn.close();
	}
}
