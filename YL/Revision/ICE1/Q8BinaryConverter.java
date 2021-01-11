import java.util.Scanner;

public class Q8BinaryConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter decimal number: ");
        int num = sc.nextInt();
        String bString = "";
        while(num != 0){
            if(num%2 == 0){
                bString = "0" + bString;
            } else {
                bString = "1" + bString;
            }
            num /= 2;
        }
        System.out.println(bString);
    }
  
}