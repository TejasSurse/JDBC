// Gathering sttudent data based on city name 
import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.util.Scanner;
public class SelectCity
  
{
	public static void main(String[] args) throws Exception 
	{
		try{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter City name too begin/ start search");
		String city = sc.next(); // nashik 
		// city = " ' "+city+" ' ";
		// register Driver class name
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
		Statement s = conn.createStatement();
		// matching city names 
		String qry = "Select * from Student where sadd='"+city+"'";
		System.out.println("SQL query = "+qry);
		
		// send & execute sellect qry in db sw;
		ResultSet rs = st.executeQuery(qry);
		
		// we can use directly next 

		while(rs.next()){
			System.out.println(rs.getInt(1)+"\t"+ rs.getString("sname") +"\t" + rs.getString(3));
		}
		}
		catch(SQLException e){
			System.out.println("Sql Exception "+e);
		}
		
		rs.close();
		conn.close();
		s.close();
		//adrak//adipatta//beat	//gajar//palak//kakdi
		//System.out.println("Hello World!");
	}
}
