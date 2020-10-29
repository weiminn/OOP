/**
 * Created by yeowleong on 13/3/16.
 */
public class FindTheMissingNumberTest {

    public static void testNull() {
        try {
            NumberUtils.findTheMissingNumber(null, 0);
            System.out.println("Test 1 (pass in null): fail");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 1 (pass in null): pass");
        } catch (Throwable e) {
            System.out.println("Test 1 (pass in null): fail");
            e.printStackTrace();
        }

    }
    public static void testMissingOneInArrayOfSizeOne() {
        try {
            int[] arr = new int[0];
            int actual = NumberUtils.findTheMissingNumber(arr, 1);
            int expected = 1;
            if (actual == expected) {
                System.out.println("Test 2 (find missing one in array of size 1): pass");
            } else {
                System.out.println("Test 2 (find missing one in array of size 1): fail");
                System.out.println("Expected: " + expected);
                System.out.println("Actual:   " + actual);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Test 2 (find missing one in array of size 1): fail");
        } catch (Throwable e) {
            System.out.println("Test 2 (find missing one in array of size 1): fail");
            e.printStackTrace();
        }
    }

    public static void testMissingOne() {
        try {
            int[] arr = new int[] {4, 1, 6, 2, 5};
            int actual = NumberUtils.findTheMissingNumber(arr, 6);
            int expected = 3;
            if (actual == expected) {
                System.out.println("Test 3 (missing one): pass");
            } else {
                System.out.println("Test 3 (missing one): fail");
                System.out.println("Expected: " + expected);
                System.out.println("Actual:   " + actual);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Test 3 (missing one): fail");
        } catch (Throwable e) {
            System.out.println("Test 3 (missing one): fail");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        testNull();
        System.out.println();

        testMissingOneInArrayOfSizeOne();
        System.out.println();

        testMissingOne();
        System.out.println();

    }
}
