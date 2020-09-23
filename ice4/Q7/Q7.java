import java.util.ArrayList;


public class Q7 {
    public static void main(String[] args) {
        ArrayList container = new ArrayList();
        container.add("apple");
        container.add(1);
        container.add(3.14);
    
        for (Object c : container) {
            System.out.println(c);
        }
    }
}