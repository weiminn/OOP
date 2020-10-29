import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by yeowleong on 12/3/16.
 */
public class CreateArrayTest {
    public static void testNull() {
        try {
            NumberUtils.createArray(null);
            System.out.println("Test 1 (pass in null): Fail");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 1 (pass in null): Pass");
        }
    }

    public static void testEmptyArray() {
        int[] array = NumberUtils.createArray(new HashMap<Integer,Integer>());
        if (array != null && array.length == 0) {
            System.out.println("Test 2 (pass in empty array): Pass");
        } else {
            System.out.println("Test 2 (pass in empty array): Fail");
        }
    }

    public static void testWithNumbers() {
        Map<Integer, Integer> map = new TreeMap<Integer, Integer>();
        map.put(3,3);
        map.put(2,4);
        map.put(4,5);
        int[] array = NumberUtils.createArray(map);
        Arrays.sort(array);

        String expected = "[2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4]";
        String actual = Arrays.toString(array);
        if (expected.equals(actual)) {
            System.out.println("Test 3 (pass in some values): Pass");
        } else {
            System.out.println("Test 3 (pass in some values): Fail");
            System.out.println("Expected: [2, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4, 4]");
            System.out.println("Actual:   " + actual);
        }
    }

    public static void main(String[] args) {
        testNull();
        System.out.println();

        testEmptyArray();
        System.out.println();

        testWithNumbers();

    }
}
