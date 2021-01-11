import java.util.*;

public class Q4 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        theLoop: while(true) {
            System.out.print("Enter number: ");
            int num = sc.nextInt();
            if(num < 0){
                break theLoop;
            }
            list.add(num);
        }

        Iterator<Integer> i = list.iterator();
        int product = 1;
        if(i.hasNext()){
            int next = i.next();
            System.out.print(next);
            product *= next;
        }

        while(i.hasNext()){
            int next = i.next();
            System.out.print(" x " + next);
            product *= next;
        }

        System.out.print(" = " + product);
    }

}