import java.io.*;

/**
 * App
 */
public class App {

    public static void main(String[] args) {
        String fileNameAndPath = "names.txt";
        File f = new File(fileNameAndPath);

        long start = System.currentTimeMillis();
        
        if(f.exists()){
            try (FileWriter fw = new FileWriter(f, true)) {
                fw.append("\nTest");
            } catch (IOException e) {
                //TODO: handle exception
                e.getLocalizedMessage();
            }
        } else {
            System.out.println("File doesn't exist!");
        }

        long end = System.currentTimeMillis();
        // prints the number of milliseconds that has elapsed
        System.out.println(end - start);
        
    }
}