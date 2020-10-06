import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Adder {
    public static void main(String[] args) {

        add();
    }

    static void add(){
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter num 1> ");
            int num1 = sc.nextInt();

            System.out.println();
            System.out.print("Enter num 2> ");
            int num2 = sc.nextInt();

            int sum = num1 + num2;

            System.out.println();
            System.out.println("The answer is " + sum);
        } catch (InputMismatchException e){
            System.err.println("OOF! Mismatch exception.\nTry again!");
            add();
        } catch (Exception e){
            System.out.println("OFF! Other exception");
        }
        
    }
}