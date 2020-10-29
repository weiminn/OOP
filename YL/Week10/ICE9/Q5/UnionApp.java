import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class UnionApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first line > ");
        String firstLine = sc.nextLine();
        System.out.print("Enter second line > ");
        String secondLine = sc.nextLine();

        Set<String> set = new HashSet<>();
        for (String i: firstLine.split(",")){
            set.add(i);
        }
        for (String i: secondLine.split(",")){
            set.add(i);
        }

        Iterator<String> iter = set.iterator();
        System.out.print(iter.next());
        while(iter.hasNext()){
            System.out.print("," + iter.next());
        }
    }
}