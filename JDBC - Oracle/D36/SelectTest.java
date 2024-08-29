import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
public class SelectTest
{
	public static void main(String[] args) throws Exception 
	{
		Class.forName("oracle.jdbc.OracleDriver");
		Connection Conn = DriverManager.getConnection("jdbc:oracle:oci8:@orcl", "scott", "tiger");
		Statement st = Conn.createStatement();
		ResultSet rs = st.executeQuery("Select * from Student");

		for(; rs.next(); ){
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
		}
		rs.close();
		st.close();
		Conn.close();
		System.out.println("Hello World!");
	}
}
