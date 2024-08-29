import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class any {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            String date = sc.nextLine();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date udf = sdf.parse(date);
            long msd = udf.getTime();
            java.sql.Date sqdf = new java.sql.Date.valueOf(msd);
            System.out.println(sqdf);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
