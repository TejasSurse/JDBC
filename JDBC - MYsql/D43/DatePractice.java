import java.util.*;
import java.text.*;
public class DatePractice{
    public static void main(String[] args) {
        String s1 = "1990-05-14";
        System.out.println("String date :"+s1);
        //                  Text date to sql date 
        java.sql.Date sd1 = java.sql.Date.valueOf(s1);
        System.out.println("SQL Date " + sd1);
        // now convert date form java.sql.date class to simple string 

        // convert java.sql.date to java.util.date formtat
        ///                     typecaasting 
        java.util.Date ud1 = (java.util.Date) sd1;
        System.out.println("Util date" + ud1);

        //convet java .util .date to simple date format 
        java.text.SimpleDateFormat sdf = new SimpleDateFormat("mm-yyyy-dd"); // op date format 
        System.out.println("Simple date format "+sdf);
        java.text.SimpleDateFormat sdf1 = new SimpleDateFormat("dd-mmm-yy"); // output date format 
        System.out.println("Simple date format 2  "+ sdf1);

        String s2 = sdf.format(ud1);

        String s3 = sdf1.format(ud1);

        System.out.println( s2 + "\t" + s3);


        
    }
}