import java.util.InputMismatchException;
import java.util.Scanner;

public class Adder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        prompt(sc);
    }

    private static void prompt(Scanner sc) {
        try {
            System.out.print("Enter num 1> ");
            int num1 = sc.nextInt();

            System.out.println();
            System.out.print("Enter num 2> ");
            int num2 = sc.nextInt();

            int sum = num1 + num2;

            System.out.println();
            System.out.println("The answer is " + sum);
        } catch (InputMismatchException e) {
            //TODO: handle exception
            System.out.println("Please enter a number!");
            sc.next();
            prompt(sc);
        }   
    }
}