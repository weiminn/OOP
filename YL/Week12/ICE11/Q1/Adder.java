import java.util.*;

public class Adder {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        int total = 0;
        for (int i = 0; i < args.length; i++){
            try {
                Integer n = Integer.parseInt(args[i]);
                total += n;
                numbers.add(n);
            } catch (Exception e) {
                //TODO: handle exception
                System.out.println("position " + i + " not a number");
            }
        }

        Iterator<Integer> i = numbers.iterator();
        if(i.hasNext()){
            System.out.print(i.next());
        }
        while (i.hasNext()) {
            System.out.print(" + " + i.next());
        }

        System.out.print(" = " + total);

    }
    
}
