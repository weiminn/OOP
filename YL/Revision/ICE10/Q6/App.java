import java.util.Scanner;
import java.io.*;

public class App {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("result.csv"));
            sc.nextLine();
            while (sc.hasNextLine()) {
                String record = sc.nextLine();
                String[] _r = record.split(",");
                try {
                    if(Double.parseDouble(_r[3]) >= 3.7){
                        System.out.println(_r[0]);
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
