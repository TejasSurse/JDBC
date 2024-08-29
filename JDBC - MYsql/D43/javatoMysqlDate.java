import java.text.SimpleDateFormat;
import java.sql.*;
import java.util.*;
public class javatoMysqlDate {
    public static void main(String[] args) {
        try{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Date ");
        
        String date = sc.nextLine();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        java.util.Date ud  = sdf.parse(date);
        long milisec = ud.getTime();
        System.out.println(ud);
        java.sql.Date sqd = new java.sql.Date(milisec);
        System.out.println(sqd);
    }
    catch(Exception e ){
        System.out.println("Exception ");
    }
    }    
}
