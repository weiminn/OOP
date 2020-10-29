import java.util.List;

/**
 * Created by yeowleong on 13/3/16.
 */
public class FindUniquePairsTest {

    public static void testNullArray() {
        try {
            List<Pair> pairs = NumberUtils.findPairs(null, 4);
            String status = "fail";
            if (pairs != null && pairs.isEmpty()) {
                status = "pass";
            }
            if (status.equals("pass")) {
                System.out.println("Test 1 (pass in null): pass");
            } else {
                System.out.println("Test 1 (pass in null): fail");
            }

        } catch (Throwable e) {
            System.out.println("Test 1 (pass in null): fail");
        }
    }

    public static void testEmptyArray() {
        try {
            List<Pair> pairs = NumberUtils.findPairs(new int[]{}, 1);
            String status = "fail";
            if (pairs != null && pairs.isEmpty()) {
                status = "pass";
            }
            if (status.equals("pass")) {
                System.out.println("Test 2 (pass in empty array): pass");
            } else {
                System.out.println("Test 2 (pass in empty array): fail");
            }

        } catch (Throwable e) {
            System.out.println("Test 2 (pass in empty array): fail");
        }

    }

    public static void testNoValidPairs() {
        try {
            List<Pair> pairs = NumberUtils.findPairs(new int[]{1, 2, 3, 4, 2, 1}, 11);
            String status = "fail";
            if (pairs != null && pairs.isEmpty()) {
                status = "pass";
            }
            if (status.equals("pass")) {
                System.out.println("Test 3 (pass in array with no matching result): pass");
            } else {
                System.out.println("Test 3 (pass in array with no matching result): fail");
            }

        } catch (Throwable e) {
            System.out.println("Test 3 (pass in array with no matching result): fail");
        }

    }


    public static void testValidPairs() {
        try {
            List<Pair> pairs = NumberUtils.findPairs(new int[]{ 2, 3, 4, 2, 11, 4, 5, 1, 9, -3, -5}, 4);

            String expected = "[[2, 2], [3, 1], [9, -5]]";
            String actual = pairs.toString();

            if (expected.equals(actual)) {
                System.out.println("Test 4 (valid pairs): pass");
            } else {
                System.out.println("Test 4 (valid pairs): fail");
                System.out.println("Expected: " + expected);
                System.out.println("Actual:   " + actual);
            }
        } catch (Throwable e) {
            System.out.println("Test 4 (valid pairs): fail");
        }

    }

    public static void testValidPairsWithDuplicates() {
        try {
            List<Pair> pairs = NumberUtils.findPairs(new int[]{ 1, 2, 3, 4, 2, 11, 4, 5, 1, 1, 9, -3, -5}, 4);

            String expected = "[[1, 3], [2, 2], [3, 1], [3, 1], [9, -5]]";
            String actual = pairs.toString();

            if (expected.equals(actual)) {
                System.out.println("Test 5 (valid pairs with duplicates): pass");
            } else {
                System.out.println("Test 5 (valid pairs with duplicates): fail");
                System.out.println("Expected: " + expected);
                System.out.println("Actual:   " + actual);
            }
        } catch (Throwable e) {
            System.out.println("Test 5 (valid pairs with duplicates): fail");
        }

    }

    public static void main(String[] args) {
        testNullArray();
        System.out.println();

        testEmptyArray();
        System.out.println();

        testNoValidPairs();
        System.out.println();

        testValidPairs();
        System.out.println();

        testValidPairsWithDuplicates();
        System.out.println();
    }
}
