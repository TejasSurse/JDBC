// Here we are using Aggregate Function to deal with the overall data of the database table 
// types of aggreegate function 
// min(), max(), count(), avg(), Sum;

// 1. "Select count(*) from student"

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class  AgreeGateQry
{

	public static void main(String[] args) throws Exception 
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		Statement st = Conn.createStatement();
		String qry = "Select count(*) from student";
		ResultSet rs = st.executeQuery(qry);
		if(rs.next()){
			System.out.println(rs.getInt(1)); // or we can print rs.getInt("count(*)");
		}
		Conn.close();
		rs.close();
		st.close();

	}
}
