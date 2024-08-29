import java.sql.*;
public class T2Oci 
{
	public static void main(String[] args) throws Exception
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection Conn = DriverManager.getConnection("jdbc:oracle:oci8:@orcl", "scott", "tiger");
		Statement st = Conn.createStatement();
		String qry = "Select * from Student";
		
		ResultSet rs = st.executeQuery(qry);
		while(rs.next()){
			System.out.println(rs.getInt(1));
		}
		
		Conn.close();
		//rs.close();
		st.close();
		
			}
}
