import java.util.*;

public class Demo {
    public static void main(String[] args) {
        Set<Box> map = new HashSet<>();
        map.add(new Box(12, 12, 12));
        map.add(new Box(12, 12, 12));

        System.out.println(map.size());
    }
}
