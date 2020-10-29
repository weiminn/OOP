

/**
 * Created by yeowleong on 15/5/14.
 */
public class ArrayUtilityTest {
    public static void main(String[] args) {

        // test the sum method
        System.out.println("Test sum:");
        System.out.println("Passed in null: " + ArrayUtility.sum(null));
        System.out.println("Passed in empty array: " + ArrayUtility.sum(new int[0]));
        System.out.println("Passed in {1,2,4,7,6,8,9}: " + ArrayUtility.sum(new int[]{1, 2, 4, 7, 6, 8, 9}));

        // test the twoTimes method
        int[] original = new int[]{1, 2, 4, 7, 6, 8, 9};
        int[] twoTimes = ArrayUtility.twoTimes(original);
        System.out.println();
        System.out.println("Test twoTimes:");
        System.out.println("Passed in null: " + ArrayUtility.twoTimes(null));
        System.out.println("Passed in empty array: " + ArrayUtility.printArray(ArrayUtility.twoTimes(new int[0])));
        System.out.println("passing in: " + ArrayUtility.printArray(original));
        System.out.println("getting out: " + ArrayUtility.printArray(twoTimes));


        // test the reverse method
        int[] array = {1,3,7,4,9};
        System.out.println();
        System.out.println("Test reverse:");
        System.out.println("Before reverse: " + ArrayUtility.printArray((array)));
        ArrayUtility.reverse(array);
        System.out.println("After reverse: " + ArrayUtility.printArray((array)));

    }
}
