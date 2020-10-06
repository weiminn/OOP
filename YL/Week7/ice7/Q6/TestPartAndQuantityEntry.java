import java.util.*;

public class TestPartAndQuantityEntry {
    public static void main(String[] args) {
        prompt();   
    }

    static void prompt(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter Part Number:");
        int a = sc.nextInt();
        System.out.println("Please enter quantity:");
        int b = sc.nextInt();

        try {
            PartAndQuantityEntry.enterPartAndQuantity(a, b);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage()+"!\nPlease enter again!");
            prompt();
        }
    }
}
