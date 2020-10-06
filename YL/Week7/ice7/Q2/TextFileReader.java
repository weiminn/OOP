package ice7.Q2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextFileReader {
    public static void main(String[] args) {
        String fileNameAndPath = "ice7/Q1/data/students.txt";

        long start = System.currentTimeMillis();
        try (Scanner sc = new Scanner(new File(fileNameAndPath))){
            System.out.println("Yes, " + fileNameAndPath + " exists");
        } catch (FileNotFoundException e){
            System.out.println("No, " + fileNameAndPath + " does not exist");
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }
}
