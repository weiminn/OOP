import java.io.FileNotFoundException;
import java.util.Arrays;

public class UtilityTest {
    public static void main(String[] args) throws FileNotFoundException {

        char[][] board1 = Utility.readFromFile("board.txt");
        System.out.println("Test 1 (valid board): ");
        System.out.println("Expected: ");
        System.out.println("[#, #, #, #, #, #, #, #, #, #, #, #, #, #, #]");
        System.out.println("[#, #, O, #, #, #, #, #, #, #, #, #, #, #, #]");
        System.out.println("[#, #, #, X, #, #, #, #, #, #, #, #, #, #, #]");
        System.out.println("[#, #, #, #, O, #, #, #, #, #, #, #, #, #, #]");
        System.out.println("[#, #, #, #, O, O, X, #, #, #, #, #, #, #, #]");
        System.out.println("[#, #, #, O, X, X, O, O, #, #, #, #, #, #, #]");
        System.out.println("[#, #, #, X, O, O, X, X, #, #, #, #, #, #, #]");
        System.out.println("[#, #, #, #, X, O, X, X, #, #, #, #, #, #, #]");
        System.out.println("[#, #, #, #, #, X, O, #, X, #, #, #, #, #, #]");
        System.out.println("[#, #, #, #, X, #, #, O, #, O, #, #, #, #, #]");
        System.out.println("[#, #, #, #, #, #, #, #, #, #, #, #, #, #, #]");
        System.out.println("[#, #, #, #, #, #, #, #, #, #, #, #, #, #, #]");
        System.out.println("[#, #, #, #, #, #, #, #, #, #, #, #, #, #, #]");
        System.out.println("[#, #, #, #, #, #, #, #, #, #, #, #, #, #, #]");
        System.out.println("[#, #, #, #, #, #, #, #, #, #, #, #, #, #, #]");
        System.out.println("Actual: ");
        for (int i = 0; i < board1.length; i++) {
            System.out.println(Arrays.toString(board1[i]));
        }


        System.out.println();
        System.out.println("Test 2 (read invalid1.txt)");
        char[][] board2 = Utility.readFromFile("invalid1.txt");
        System.out.println("Expected: 0 ");
        System.out.println("Actual  : " + board2.length);

        System.out.println();
        System.out.println("Test 3 (read invalid-board-2.txt)");
        char[][] board3 = Utility.readFromFile("invalid2.txt");
        System.out.println("Expected: 0 ");
        System.out.println("Actual  : " + board3.length);

        System.out.println();
        System.out.println("Test 4 (read invalid-board-4.txt)");
        char[][] board4 = Utility.readFromFile("invalid3.txt");
        System.out.println("Expected: 0 ");
        System.out.println("Actual  : " + board4.length);

        System.out.println();
        System.out.println("Test 5 (read missing-file.txt)");
        char[][] board5 = Utility.readFromFile("missing-file.txt");
        System.out.println("Expected: 0 ");
        System.out.println("Actual  : " + board5.length);

    }
}
