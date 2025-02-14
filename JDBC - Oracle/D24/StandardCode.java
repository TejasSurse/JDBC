/*
	Update Student name and address.java 

	programm to update modify studdent details basesd on given roll no. 
	Date : 25-4-24
	Author : Tejas Sunil Surse
	Team : CollegeErp
	Version : 1.2.x
*/
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
// Note =  importing all packages specifically by name not by * 

public class StandardCode 
{
	public static void main(String[] args) throws Exception 
	{
		// whenever declare local variable / object in java code they does have default/ initial values the programmer has to explicitely initilize the other values if you want to use 
		Connection conn = null;
		Statement st = null;
		Scanner sc = null;
		// Every suspecious code write in try block
		try{
			// read inputs fornm keyboard 
			sc = new Scanner(System.in);
			int no = 0;
			String newName = null;
			newAddresss = null;
			if(sc != null){
				System.out.println("Enter Existing Studetn Roll. NO. ");
				no = sc.nextInt();
				System.out.println("Enter new Name Of Student \n");
				newName = sc.next();
			}// end of if 
			// Convert input values as required for sql queries 
			newname = "'"+newName+"'";
			newAddress = "'"+newAddress+"'";
			// Register Type 4 Driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Establish the Connection.
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "scott", "tiger");
			if(conn != null){
				st.conn.createStatement();
				// Frame the query 
				// Update student set sname = 'Shankara', sadd = 'napur' where sno = '1111';
				String qry = "Update Student Set sname = "+newName+", sadd="+newAddress+" where sno = "+no;
				System.out.println(qry);
				// send & executeQuery
				int result = 0;
				if(st!= null){
					result = st.executeUpdate(qry);
				}
				// process the result
				if(result != 0){
					System.out.println(result+" Number of Rows Updated SuccessFully");
				}
				else 
					System.out.println("Records not found to updated");
			}// outer if end;
			else{
				System.out.println("Connection not establish !!!");
			}// end of try;
		}
		catch(ClassNotfoundException cnfe){
			cnfe.printStackTrace();
		}
		catch(SQLException se){
			System.out.println("Sql Exception "+se.toString());
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			try{
				if(st!= null)
					st.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}
			try{
				if(conn!= null){
					conn.close();
				}
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		System.out.println("End");
	}
}
