import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.naming.MalformedLinkException;

public class PageDownloader {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        prompt(sc);
    }

    private static void prompt(Scanner console) {
        try {

            System.out.print("Enter the URL> ");
            String websiteURL = console.nextLine();
    
            URL url = new URL(websiteURL);
    
            Scanner sc = new Scanner(url.openStream());
    
            while (sc.hasNext()) {
                System.out.println(sc.nextLine());
            }
        } catch ( MalformedURLException e) {
            //TODO: handle exception
            System.out.println("Invalid URL!");
            prompt(console);
        } catch( IOException e){
            System.out.println("Can't open URL!");
            prompt(console);
        }
    }
}
