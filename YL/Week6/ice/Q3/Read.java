import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Read {
    public static void main(String[] args) {

        try(Scanner sc = new Scanner(new File("numbers.txt"))){
            sc.useDelimiter("\r\n|\n");
            while(sc.hasNext()){
                String string = sc.next();
                String[] strings = string.split(",");

                int total = 0;
                for (String s : strings) {
                    int num = Integer.parseInt(s);
                    total += num;
                }

                System.out.println(total);
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
    }
}
