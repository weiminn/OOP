import java.util.Scanner;
import java.io.*;

public class App {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("numbers.txt"));
            // sc.useDelimiter("\n")
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
    }
}
