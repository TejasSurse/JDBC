import java.text.SimpleDateFormat;
import java.util.Date;
import java.Sql.Date;
public class DateFromating {
    public static void main(String[] args) {
        // Simple Stirng Date - dd-mmm-YYYY
        String s1 = "12-JANUARY-2003";
        System.out.println("String Date : " + s1);

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
        java.util.Date ud = sdf.parse(s1);
        System.out.println("Util Date : " + ud);

        // convert java.util.Date obj to java.sql.Date object
        long milisec = ud.getTime();
        System.out.println("Date in miliseconds " + milisec);

        java.sql.Date sd1 = new java.sql.Date(milisec);

        System.out.println("SQL Date "+ sd1);

        // ===========================================
        java.util.Date ud1 = (java.util.Date)sd1;
        System.out.println("Util  Date " + ud1);

        /// convert java.util.Date  to Simple date format 
        java.text.SimpleDateFormat  sdf1 = new SimpleDateFormat("yy-MM-dd"); // op date format 
        java.text.SimpleDateFormat sdf2 = new SimpleDateFormat("dd-MMM-yy"); // op Date Format 
        java.text.SimpleDateFormat sdf3 = new SimpleDateFormat("MM-dd-yyyy");


        String s2 = sdf1.format(ud1);
        String s3 = sdf2.format(ud1);
        String s4 = sdf3.format(ud1);

        System.out.println("yy-MM-dd \t " + s2);
        System.out.println("dd-mm-YY \t" + s3);
        System.out.println("MM-dd-yyyy \t" + s4);


    }    
}
