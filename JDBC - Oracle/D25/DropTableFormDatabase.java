// programm to drop table form database 
import java.sql.*;
public class DropTableFormDatabase 
{
	public static void main(String[] args) throws Exception
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		Statement st = Conn.createStatement();
		String qry = "Drop table company";
		
		Conn.close();
		//rs.close();
		st.close();
	}
}
