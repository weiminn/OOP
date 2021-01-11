import java.util.*;

public class Q2 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean success = false;

        while(!success){
            System.out.print("Enter first word: ");
            String first = sc.nextLine();
            System.out.print("Enter second word: ");
            String second = sc.nextLine();

            if(first.charAt(0) == second.charAt(0)){
                success = true;
                System.out.println("Bingo");
            } else {
                System.out.println("Try Again");
            }

        }
    }

}