import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Sentence: ");
        String sentence = sc.nextLine();

        String[] splitted = sentence.split(" ");
        for (int i = splitted.length-1; i >= 0; i--) {
            System.out.print(splitted[i] + " ");
        }
    }
}