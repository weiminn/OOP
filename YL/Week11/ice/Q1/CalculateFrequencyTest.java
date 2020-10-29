import java.util.Map;

/**
 * Created by yeowleong on 12/3/16.
 */
public class CalculateFrequencyTest {
    public static void testNull() {
        try {
            NumberUtils.calculateFrequency(null);
            System.out.println("Test 1 (pass in null): Fail");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 1 (pass in null): Pass");
        }
    }

    public static void testEmptyArray() {
            Map<Integer,Integer> frequency = NumberUtils.calculateFrequency(new int[]{});
        if (frequency.isEmpty()) {
            System.out.println("Test 2 (pass in empty array): Pass");
        } else {
            System.out.println("Test 2 (pass in empty array): Fail");
        }
    }

    public static void testWithNumbers() {
        Map<Integer,Integer> frequency = NumberUtils.calculateFrequency(new int[]{1,2,3,4,4,3,1,1});

        String expected = "{1=3, 2=1, 3=2, 4=2}";
        String actual = frequency.toString();
        if (expected.equals(actual)) {
            System.out.println("Test 3 (pass in some values): Pass");
        } else {
            System.out.println("Test 3 (pass in some values): Fail");
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
