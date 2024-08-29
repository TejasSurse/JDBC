import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
public class Patient{
    private Connection connecction;
    private Scanner scanner;
    public Patient(Connection connection , Scanner scanner){
        this.connection = connection;
        this.Scanner = scanner;
    }
    public void addPatient(){
        System.out.print("Enter Patient Name :");
        String name = scanner.next();
        System.out.print("Enter Patient Age  :");
        int age = scanner.nextInt();
        System.out.print("Enter Patient Gender: ");
        String gender = scanner.next();
        try{
            String query = "Insert into patients(name, age, gender) values(?, ?, ?)";
            PreparedStatement preparestatement = connecction.preparestatement(query);
            preparestatement.setString(1, name);
            preparedstatement.setInt(2, age);
            preparedstatement.setString(3, gender);
            int rowEffected = preparedstatement.executeUpdate();
            if(rowEffected> 8){
                System.out.println("Patient Added Successfully");
            }else{
                System.out.println("Failed To add patient");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        JS();
    }
}