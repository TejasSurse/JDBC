// Java APplication for User can enter query based on query we can print results
import java.sql.*;
import java.util.*;
public class execute_QRY {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Query You want to Enter for emp table  ");
        String qry = sc.nextLine();
        Class.forName("com.mysql.cj");
        Connection con = DriverManager.getConnection("jdbc:mysql:thin:@localhost:3306/College", "root", "root");
        Statement st = con.createStatement();
        boolean flag = st.execute(qry);
        if(flag == true){ // True is for select query 
            System.out.println("It is Select Query");
            ResultSet rs = st.getResultSet();
            while(rs.next()){
                System.out.println("Record is "+rs.getString(1)+ "\t"+ rs.getString(2) );
            }
            rs.close();
        }else{
            System.out.println("It is Non Select Query");
            int Result = st.getUpdateCount();
            System.out.println("No. OF Rows Affected "+ Result);

        }
        st.close();
        con.close();
        
    }    
}
