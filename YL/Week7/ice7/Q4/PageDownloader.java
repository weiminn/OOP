import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class PageDownloader {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        System.out.print("Enter the URL> ");
        String websiteURL = console.nextLine();

        try{
            URL url = new URL(websiteURL);

            Scanner sc = new Scanner(url.openStream());

            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
        } catch (MalformedURLException e){
            System.err.println(e.getMessage());
        } catch (IOException e){
            System.err.println(e.getMessage());
        }
        
    }
}
