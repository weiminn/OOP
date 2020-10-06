package ice7.Q1;

import java.io.File;

public class TextFileReader {
    public static void main(String[] args) {
        String fileNameAndPath = "ice7/Q1/data/students.txt";
        
        long start = System.currentTimeMillis();
        File f = new File(fileNameAndPath);
        if (f.exists()) {
            System.out.println("Yes, " + fileNameAndPath + " exists");
        } else {
            System.out.println("No, " + fileNameAndPath + " does not exist");
        }

        long end = System.currentTimeMillis();

        System.out.println(end - start);

    }
}
