import java.util.*;
import java.text.*;
import java.sql.*;
public class ConverstSqlDateToString{
    public static void main(String[] args){
        // taking simple stirng in yyyy-mm-dd format 
        String s1 = "2004-05-23";
        System.out.println("String Date is : "+ s1);

        // Convetrt that string date to java.sql.date fromat 
        java.sql.Date sd1 = java.sql.Date.valueOf(s1);
        System.out.println("Sql Date : " + sd1);


        // Convert java.sql.date to java.util.date Class Object 
        java.util.Date ud1 = (java.util.Date)sd1;
        System.out.println("Util Date : "+ ud1);


        // convert java.util.date to simple date format 
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("MM-yyyy-dd");
        java.text.SimpleDateFormat sdf1 = new SimpleDateFormat("mm-yyyy-dd");
        java.text.SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yy");
        java.text.SimpleDateFormat sdf3 = new SimpleDateFormat("dd-mmm-yy");
        
        
        String S2 = sdf.format(ud1);
        String S3 = sdf1.format(ud1);
        String S4 = sdf2.format(ud1);
        String S5 = sdf3.format(ud1);

        System.out.println(S2 + " \n" + S3 + "\n" + S4 + "\n" + S5);
    }
}