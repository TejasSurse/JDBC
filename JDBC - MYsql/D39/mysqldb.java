import java.sql.*;

public class mysqldb {
    public static void main(String[] args) throws Exception, ClassNotFoundException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testschema", "root", "root");



        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("Select * from info");
        while(rs.next()){
            System.out.println(rs.getString(1) + "Emp salary "+rs.getInt(2));
        }
        rs.close();
        conn.close();
        st.close();
    }    
}

