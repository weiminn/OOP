import java.util.Arrays;

public class Array {

    public static void main(String[] args) {
        int[] arr = new int[3];
        System.out.println(arr[0]);
        //default value is 0

        //[] can be before or after variable name with or w/o space
        int[] a1;
        int [] a2;
        int a3[];
        int a4 [];

        //same for multidimensional arrays
        int[][] b1;
        int b2 [][];
        int []b3[]; //2d array
        int [] b4[][]; //3d array

        //different sized
        int[][] differentSized = {{1, 2}, {3}, {4, 5, 6}};

        //declare 2 arrays
        int[] b1, b2;

        //declare an array and an int
        int b3[], b4;

        int[] toSort = {2, 43, 6, 45};
        Arrays.sort(toSort);

        Arrays.asList(toSort);
        Arrays.asList(2, 43, 6, 45);

        //Searching
        //needs to be sorted
        System.out.println(Arrays.binarySearch(toSort, 43));
        //negates the value of the position and substracts 1 it should be in if not found
        
        
    }
    
}
