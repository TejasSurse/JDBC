// In this Program we are using Properties class 
import java.util.Properties;
import java.io.*;
public class FileRead {

    public static void main(String[] args) throws Exception {
         // create the properties file and read it 
         FileInputStream fs = new FileInputStream("file.props");
         // create properties object 
         Properties p = new Properties();
         // load the file 
         p.load(fs);
        System.out.println("PS CONTENTS " + p);
        System.out.println("Name is "+p.getProperty("name") + "age is " + p.getProperty("age"));

    }
}