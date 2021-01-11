import java.util.Scanner;
import java.io.*;

public class InventoryApp {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("product.csv"));
            // sc.useDelimiter("\n")
            int products = 0;
            float value = 0;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] splitted = line.split(",");

                products += Integer.parseInt(splitted[0]);
                value += Float.parseFloat(splitted[2]);

                System.out.printf("There are %d %s, each cost $%.1f%n", 
                    Integer.parseInt(splitted[0]), 
                    splitted[1],
                    Float.parseFloat(splitted[2]));
            }

            System.out.printf("There are %d products with a total value of $%.2f to be sold", products, value);
        } catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
        
    }
}
