import java.sql.*;
import java.text.*;
import java.util.Scanner;
public class tosqldate {
    public static void main(String[] args) {
        try{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Date " );
        String date = sc.nextLine();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        java.util.Date ud = sdf.parse(date);
        long ms = ud.getTime();
        java.sql.Date sqd1 = new java.sql.Date(ms);
        System.out.println(sqd1);
    }
    catch(Exception e){
        System.out.println("error");
    }
    }
}
