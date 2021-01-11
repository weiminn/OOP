import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class UnionApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter first line: ");
        String first = sc.nextLine();
        System.out.print("Enter second line: ");
        String second = sc.nextLine();

        String[] _first = first.split(",");
        String[] _second = second.split(",");

        Set<Integer> iSet = new HashSet<>();
        for (int i = 0; i < _first.length; i++) {
            iSet.add(Integer.parseInt(_first[i]));
        }
        for (int i = 0; i < _second.length; i++) {
            iSet.add(Integer.parseInt(_second[i]));
        }

        Iterator<Integer> iter = iSet.iterator();
        if(iter.hasNext()){
            System.out.print(iter.next());
        }

        while(iter.hasNext()){
            System.out.print("," + iter.next());
        }
    }
}