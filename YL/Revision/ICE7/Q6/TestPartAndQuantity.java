import java.util.Scanner;

public class TestPartAndQuantity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        prompt(sc);
    }

    private static void prompt(Scanner sc) {
        try {   
            System.out.print("Enter part: ");
            int part = sc.nextInt();
            System.out.print("Enter quantity: ");
            int quantity = sc.nextInt();

            PartAndQuantity.enterPartAndQuantity(part, quantity);
            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e.getMessage());
            sc.nextLine();
            prompt(sc);
        }
    }
}
