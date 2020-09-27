import java.util.*;
import java.io.*;

public class InventoryApp {
    public static void main(String[] args) {
        stockTaking("product.csv");
    }

    private static void stockTaking(String fileNameAndPath) {
        try(Scanner sc = new Scanner(new File(fileNameAndPath))){
            sc.useDelimiter("\r\n|\n");
            while(sc.hasNext()){
                String string = sc.next();
                String[] product = string.split(",");

                System.out.printf("There are %d %s, each cost $%.2f%n",
                Integer.parseInt(product[0]), product[1], Double.parseDouble(product[2]));
            }
        } catch (FileNotFoundException e){
            System.err.println(e.getMessage());
        }
        
    }
    
}
