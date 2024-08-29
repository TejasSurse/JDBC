import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class javatosqlDate  {
    
    
    public static void main(String[] args) throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Scanner sc = new Scanner(System.in);
        
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/infoPerson", "root", "root");
        System.out.println("If you want to create new entry Enter 1 ");
        System.out.println("If you want to get  person Data Enter 2");
        Statement st = conn.createStatement();

        int opr = sc.nextInt();
        if(opr == 1){
            System.out.println("Enter Your Id : ");
            int pid = sc.nextInt();
            System.out.println("Enter Name of Person ");
            String pname = sc.next();
            System.out.println("Enter Date of Birth YYYY-MM-DD : ");
            String dob = sc.next();
            java.sql.Date Dob = java.sql.Date.valueOf(dob);
            System.out.println("Enter Date of joining YYYY-MM-DD : ");
            String doj = sc.next();
            java.sql.Date Doj = java.sql.Date.valueOf(doj);
            System.out.println("Enter Date of Date of Leave YYYY-MM-DD : ");
            String dol = sc.next();
            java.sql.Date Dol = java.sql.Date.valueOf(dol);
            String qry = "INSERT INTO Person VALUES ("+ pid + ",'"+pname+ "','"+Dob+"','"+Doj+"','"+Dol+"')";
            System.out.println(qry);
            int rs  = st.executeUpdate(qry);
            System.out.println("Record Inserted Successfully : "+ rs);
        }
        else if(opr == 2){
            System.out.println("Enter Id of Person  :");
            int pid = sc.nextInt();
            ResultSet rs1 = st.executeQuery("Select * from Person where pid="+pid);
            while(rs1.next()){
                System.out.println(rs1.getInt(1)+"\t"+  rs1.getString(2)+ "\t"+ rs1.getDate(3)+ "\t" + rs1.getDate(4)+ "\t" + rs1.getDate(5));
            }    
        }

        
    }
}