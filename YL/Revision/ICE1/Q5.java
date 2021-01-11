import java.util.Scanner;

public class Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size: ");
        int size = sc.nextInt();

        for(int i = 0; i < size; i++){
            System.out.print((char) ((i%26) + 97));
            System.out.print(" ");
        }
    }

}