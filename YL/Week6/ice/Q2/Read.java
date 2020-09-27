import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Read {
    public static void main(String[] args) {
        prompt();
    }

    private static void prompt() {
        
        Scanner s = new Scanner(System.in);
        System.out.println("Enter a filename:");

        try(Scanner sc = new Scanner(new File(s.nextLine()))){
            sc.useDelimiter("\r\n|\n");
            int total = 0;
            while(sc.hasNext()){
                total += Integer.parseInt(sc.next());
            }
            System.out.println("The sum is " + total);
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
            prompt();
        }

        s.close();
    }
}
