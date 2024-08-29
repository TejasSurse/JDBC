import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
public class insertDataIntoTable 
{
	public static void main(String[] args) throws Exception 
	{
		System.out.println("Student Details");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Studetn Roll NO. ");
		int rollNo = sc.nextInt();
		System.out.println("Enter Student Name " );
		String name = sc.next();
		System.out.println("Enter Student City");
		String city = sc.next();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		String qry = "Insert into student values("+rollNo+",'"+name+"','"+city+"')";
		System.out.println(qry);
		Statement st = conn.createStatement();
		int result = st.executeUpdate(qry);
		conn.close();
		st.close();
	}
}
