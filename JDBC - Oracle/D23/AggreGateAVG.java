// here we are uing aggregate function to calculate average of employee salaries;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class  AggreGateAVG
{

	public static void main(String[] args) throws Exception 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		Statement st = Conn.createStatement();
		String qry = "Select avg(sal) from emp";
		ResultSet rs = st.executeQuery(qry);
		if(rs.next()){
			System.out.println(rs.getInt(1)); // or we can print rs.getInt("count(*)");
		}
		Conn.close();
		rs.close();
		st.close();

	}
}