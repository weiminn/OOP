import java.util.*;
import java.io.*;

public class test {

    public static ClassA classA = null;
    public static void main(String[] args) {
        classA.aMethod();
        // classA.aIM();

        try (Scanner sc = new Scanner(new File("texst.txt"))){
            String[] strings = sc.useDelimiter("\r\n");
            System.out.println(strings);
        } catch(Exception e){
            e.printStackTrace();
        }

    }
}
