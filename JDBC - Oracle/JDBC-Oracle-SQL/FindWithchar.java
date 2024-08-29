// select * from student where sname like m% and sadd in ('Satara', 'Mumbai');       -> mahesh, mauli, mangu, mona, but lower case m starts with 
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.Scanner;
public class FindWithchar
{
	public static void main(String[] args) throws Exception 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter first character of the name ");
		String c = sc.next();
		System.out.println("Enter Second first city name too searc");
		String condition1 = sc.next();
		System.out.println("Enter Second first city name too search");
		String condition2 = sc.next();
		c = "'"+c+"%'";
		condition1 = "'"+condition1+"'";
		condition2 = "'"+condition2+"'";
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// Establish Connection 
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","scott" , "tiger");
		Statement smt = conn.createStatement();
	// send and execute qry
		String qry = "Select * from student where sname like "+c+" and sadd in ("+condition1+", "+condition2+")";
		ResultSet rs = smt.executeQuery(qry);
		while(rs.next()){
			System.out.println(rs.getInt(1)+" "+ rs.getString(2) +" "+rs.getString(3));
		}
		rs.close();
		smt.close();
		conn.close();
	}
}