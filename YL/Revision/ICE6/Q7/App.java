import java.util.Scanner;
import java.io.*;

public class App {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("numbers.txt"));
            sc.useDelimiter("\\r?\\n");
            while (sc.hasNext()) {
                String line = sc.next();
                // System.out.println(line);
                String[] splitted = line.split(",");

                for(int i = 0; i < splitted.length/2; i++){
                    String temp = (splitted[i]);
                    splitted[i] = splitted[splitted.length-1-i];
                    splitted[splitted.length-1-i] = temp;
                }

                for(int i = 0; i < splitted.length; i++){
                    if(i == 0){
                        System.out.print(splitted[i]);
                    } else {
                        System.out.print("," + splitted[i]);
                    }
                }
                System.out.println();
            }
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
    }
}
