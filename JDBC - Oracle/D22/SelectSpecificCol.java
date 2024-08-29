/// Example applicaton on sending and executing selecct sql queries that selects specific 
// columns values off a database table  
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
public class SelectSpecificCol
{
	public static void main(String[] args) throws Exception
	{
		// loading oracle java class
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		Statement st = conn.createStatement();
		String qry = "Select sno,  sadd from student";
		System.out.println(qry);
		ResultSet rs = st.executeQuery(qry);
		System.out.println("____________________________");
		System.out.println("| roll"+" | \t | "+ "Address |");
		System.out.println("|____________________________|");
		while(rs.next()){
			System.out.println("|"+rs.getInt(1)+" | \t | "+ rs.getString(2)+"\t|");
		}
		System.out.println("|____________________________\t|");
		System.out.println("rs = "+rs.getClass()+" conn = "+conn.getClass()+" statement = "+ st.getClass());
		conn.close();
		st.close();
		rs.close();
	}
}
