import java.io.*;
import java.util.Scanner;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        
        long start = System.currentTimeMillis();

        try {
            Scanner sc = new Scanner(new File("names.txt"));
            System.out.println("It exists!");            
        } catch (IOException e) {
            //TODO: handle exception
            System.out.println("It doesn't exist!");
        }


        long end = System.currentTimeMillis();
        // prints the number of milliseconds that has elapsed
        System.out.println(end - start);
    }
}