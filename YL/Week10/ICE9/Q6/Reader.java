import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Reader {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(new File("result.csv"))) {
            sc.useDelimiter("\r\n|\n");
            while (sc.hasNext()) {
                sc.next();
                String str = sc.next();
                String[] sArr = str.split(",");
                // System.out.println(str);

                try{
                    if((Double.parseDouble(sArr[3])) >= 3.7){
                        System.out.print("\n" + sArr[0]);
                        System.out.print(" " + sArr[1]);
                        System.out.print(" " + sArr[3]);
                    }
                } catch (NumberFormatException e){
                    System.out.println("Can't cast to double!");
                }
            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
        }
    }
}
