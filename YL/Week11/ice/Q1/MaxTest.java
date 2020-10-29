/**
 * Created by yeowleong on 13/3/16.
 */
public class MaxTest {

    public static void testEmptyArray() {
        System.out.print("test empty array: ");
        try {
            NumberUtils.max(new int[]{});
            System.out.println("Test 2(pass in empty array): fail");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 2(pass in empty array): pass");
        }


    }
    public static void testNull() {
        try {
            NumberUtils.max(null);
            System.out.println("Test 1(pass in null): fail");
        } catch (IllegalArgumentException e) {
            System.out.println("Test 1(pass in null): pass");
        }
    }

    public static void testMaxOf3Numbers() {
        String status = "fail";

        int value;
        int expected = 5;
        try {
            value = NumberUtils.max(1, 5, 3);
            if (value == expected) {
                status = "pass";
            }
            System.out.println("Test 3(max of 1,5,3): " +  status);
            if (status.equals("fail"))  {
                System.out.println("expect: " + expected);
                System.out.println("actual: " + value);
            }
        } catch (Throwable e) {
            System.out.println("Test 3(max of 1,5,3): fail");
            e.printStackTrace();
        }

    }

    public static void testMaxOfArray() {
        String status = "fail";

        int value;
        int expected = 12;
        try {
            value = NumberUtils.max(new int[]{1,4,9,2,4,12});
            if (value == expected) {
                status = "pass";
            }
            System.out.println("Test 3(max of {1,4,9,2,4,12}): " +  status);
            if (status.equals("fail"))  {
                System.out.println("expect: " + expected);
                System.out.println("actual: " + value);
            }
        } catch (Throwable e) {
            System.out.println("Test 3(max of 1,5,3): fail");
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        testNull();
        System.out.println();

        testEmptyArray();
        System.out.println();

        testMaxOf3Numbers();
        System.out.println();

        testMaxOfArray();
        System.out.println();


    }
}
