import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;


public class execute_QRY
{
	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "root");
		// Sensitive  Result Set Object 
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("select * from student");

		// Insesitive ResultSet Object 
		Statement st = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
		ResultSet rs = st.executeQuery("select * from student");

		int cnt = 1;
		
		while(rs.next()){
			System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3));
			if(cnt == 2){
				Thread.sleep(45000); // 45 Seconds 
			}	
			cnt++;			
		}
		rs.close();
		st.close();
		conn.close();
		
	}
}

// sensitive means if we change data between execution time it will reflected in result set 