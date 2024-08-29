import java.sql.*;
public class exTransiction {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdata", "root", "root");
        // to set auto commit false
        conn.setAutoCommit(false);
        Statement st = conn.createStatement();

        st.executeUpdate("Insert into sdata values(222, 'js', 'js@')");
        st.execute(null)
    }
}