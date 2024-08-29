// 4 highest salary employess form the database;
import java.sql.*;

public class FourHighestSal 
{
	public static void main(String[] args) throws Exception 
	{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection Conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		Statement st = Conn.createStatement();
		String qry = "Select * from (select * from emp order by sal desc) where rownum <= 4";
		ResultSet rs = st.executeQuery(qry);
		int i = 1;
		while(rs.next()){
			
		}
		Conn.close();
		rs.close();
		st.close();

	}
}
