import java.util.Scanner;
import java.io.*;
import org.apache.commons.csv.*;

public class App {
    public static void main(String[] args) {
        try {

            Reader in = new FileReader("result.csv");
            Iterable<CSVRecord> records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
            for (CSVRecord record : records) {
                
                try {
                    if(Double.parseDouble(record.get("GPA")) >= 3.7){
                        System.out.println(record.get("name"));
                    }    
                } catch (NumberFormatException e) {
                    //TODO: handle exception
                    System.out.println("Parse Error: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
    
}
