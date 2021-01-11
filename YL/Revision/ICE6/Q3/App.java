import java.util.Scanner;
import java.io.*;

public class App {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("numbers.txt"));
            // sc.useDelimiter("\n")
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splitted = line.split(",");
                int total = 0;
                for(int i = 0; i < splitted.length; i++){
                    total += Integer.parseInt(splitted[i]);
                }
                System.out.println(total);

            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
    }
}
