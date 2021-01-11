public class GomokuTest {

    public static void testConstructor() {
        char[][] board1 = {
            //    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 0
                {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 1
                {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 2
                {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 3
                {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 4
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 5
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 6
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 7
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 8
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 9
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 10
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 11
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 12
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 13
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}};      // 14

        char[][] board2 = {
                //    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 0
                {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 1
                {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 2
                {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 3
                {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 4
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 5
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 6
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 7
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 8
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 9
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 10
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 11
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 12
                {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}}; // 13


        try {
            System.out.println("Test 5.1");
            Gomoku game = new Gomoku(board1);
            System.out.println("Result:Fail");
        } catch (GameException e) {
            if (e.getMessage().equals("Invalid columns count:1")) {
                System.out.println("Result:Pass");
            } else {
                System.out.println("Result:Fail");
            }
        }
        System.out.println();

        try {
            System.out.println("Test 5.2");
            Gomoku game = new Gomoku(board2);
            System.out.println("Result:Fail");
        } catch (GameException e) {
            //System.out.println(e.getMessage());
            if (e.getMessage().equals("Rows (Expected:15; Actual:14)")) {
                System.out.println("Result:Pass");
            } else {
                System.out.println("Result:Fail");
            }
        }
        System.out.println();

        try {
            System.out.println("Test 5.3");
            Gomoku game = new Gomoku(null);
            //System.out.println("Result:Fail");
        } catch (GameException e) {
            //System.out.println(e.getMessage());
            if (e.getMessage().equals("board is null")) {
                System.out.println("Result:Pass");
            } else {
                System.out.println("Result:Fail");
            }
        }
        System.out.println();

    }

    public static void testDiagonalBackwardSlash() {
        try {
            char[][] board = {
                //    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14
                    {'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 0
                    {'#', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 1
                    {'#', '#', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 2
                    {'#', '#', '#', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 3
                    {'#', '#', '#', '#', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 4
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 5
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 6
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 7
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 8
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 9
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 10
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 11
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 12
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 13
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}}; // 14

            Gomoku game = new Gomoku(board);


            System.out.println("Test 1.1");
            int count1 = game.count('X', 0, 0, Direction.DIAGONAL_BACKWARD_SLASH);
            System.out.println("Expected:5");
            System.out.println("Actual  :" + count1);
            System.out.println();

            System.out.println("Test 1.2");
            int count2 = game.count('X', 1, 1, Direction.DIAGONAL_BACKWARD_SLASH);
            System.out.println("Expected:5");
            System.out.println("Actual  :" + count2);
            System.out.println();

            System.out.println("Test 1.3");
            int count3 = game.count('X', 2, 2, Direction.DIAGONAL_BACKWARD_SLASH);
            System.out.println("Expected:5");
            System.out.println("Actual  :" + count3);
            System.out.println();

            System.out.println("Test 1.4");
            int count4 = game.count('X', 3, 3, Direction.DIAGONAL_BACKWARD_SLASH);
            System.out.println("Expected:5");
            System.out.println("Actual  :" + count4);
            System.out.println();

            System.out.println("Test 1.5");
            int count5 = game.count('X', 4, 4, Direction.DIAGONAL_BACKWARD_SLASH);
            System.out.println("Expected:5");
            System.out.println("Actual  :" + count5);
            System.out.println();
        } catch (GameException e) {
            System.out.println("You shouldnt reach here!!!");
        }
    }

    public static void testDiagonalForwardSlash() {
        try {
            char[][] board = {
                //    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 0
                    {'#', '#', '#', '#', '#', '#', 'X', '#', '#', '#', '#', '#', '#', '#', '#'},  // 1
                    {'#', '#', '#', '#', '#', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 2
                    {'#', '#', '#', '#', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 3
                    {'#', '#', '#', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 4
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 5
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 6
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 7
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 8
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 9
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 10
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 11
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 12
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 13
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}}; // 14

            Gomoku game = new Gomoku(board);

            System.out.println("Test 2.1");
            int count4 = game.count('X', 5, 2, Direction.DIAGONAL_FORWARD_SLASH);
            System.out.println("Expected:0");
            System.out.println("Actual  :" + count4);
            System.out.println();

            System.out.println("Test 2.2");
            int count3 = game.count('X', 4, 3, Direction.DIAGONAL_FORWARD_SLASH);
            System.out.println("Expected:4");
            System.out.println("Actual  :" + count3);
            System.out.println();

            System.out.println("Test 2.3");
            int count1 = game.count('X', 3, 4, Direction.DIAGONAL_FORWARD_SLASH);
            System.out.println("Expected:4");
            System.out.println("Actual  :" + count1);
            System.out.println();

            System.out.println("Test 2.4");
            int count2 = game.count('X', 2, 5, Direction.DIAGONAL_FORWARD_SLASH);
            System.out.println("Expected:4");
            System.out.println("Actual  :" + count2);
            System.out.println();

        } catch (GameException e) {
            System.out.println("You shouldnt reach here!!!");
        }

    }


    public static void testHorizontal() {
        try {
            char[][] board = {
                //    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 0
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 1
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 2
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 3
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 4
                    {'#', '#', '#', '#', '#', 'O', 'O', 'O', 'O', 'O', 'O', '#', '#', '#', '#'},  // 5
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 6
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 7
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 8
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 9
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 10
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 11
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 12
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 13
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}}; // 14

            Gomoku game = new Gomoku(board);

            System.out.println("Test 3.1");
            int count1 = game.count('O', 5, 5, Direction.HORIZONTAL);
            System.out.println("Expected:6");
            System.out.println("Actual  :" + count1);
            System.out.println();

            System.out.println("Test 3.2");
            int count2 = game.count('O', 5, 6, Direction.HORIZONTAL);
            System.out.println("Expected:6");
            System.out.println("Actual  :" + count2);
            System.out.println();

            System.out.println("Test 3.3");
            int count3 = game.count('O', 5, 7, Direction.HORIZONTAL);
            System.out.println("Expected:6");
            System.out.println("Actual  :" + count3);
            System.out.println();

            System.out.println("Test 3.4");
            int count4 = game.count('O', 5, 8, Direction.HORIZONTAL);
            System.out.println("Expected:6");
            System.out.println("Actual  :" + count4);
            System.out.println();

            System.out.println("Test 3.5");
            int count5 = game.count('O', 5, 9, Direction.HORIZONTAL);
            System.out.println("Expected:6");
            System.out.println("Actual  :" + count5);
            System.out.println();

            System.out.println("Test 3.6");
            int count6 = game.count('O', 5, 10, Direction.HORIZONTAL);
            System.out.println("Expected:6");
            System.out.println("Actual  :" + count6);
            System.out.println();

        } catch (GameException e) {
            System.out.println("You shouldnt reach here!!!");
        }
    }

    public static void testVertical() {
        try {
            char[][] board = {
                //    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 0
                    {'#', 'O', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 1
                    {'#', 'O', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 2
                    {'#', 'O', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 3
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 4
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 5
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 6
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 7
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 8
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 9
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 10
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 11
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 12
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 13
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}}; // 14

            Gomoku game = new Gomoku(board);

            System.out.println("Test 4.1");
            int count1 = game.count('O', 1, 1, Direction.VERTICAL);
            System.out.println("Expected:3");
            System.out.println("Actual  :" + count1);
            System.out.println();

            System.out.println("Test 4.2");
            int count2 = game.count('O', 2, 1, Direction.VERTICAL);
            System.out.println("Expected:3");
            System.out.println("Actual  :" + count2);
            System.out.println();

            System.out.println("Test 4.3");
            int count3 = game.count('O', 3, 1, Direction.VERTICAL);
            System.out.println("Expected:3");
            System.out.println("Actual  :" + count3);
            System.out.println();
        } catch (GameException e) {
            System.out.println("You shouldnt reach here!!!");
        }
    }

    public static void testPlaceMoveWin() {
        try {
            char[][] board = {
                //    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 0
                    {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 1
                    {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 2
                    {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 3
                    {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 4
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 5
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 6
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 7
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 8
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 9
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 10
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 11
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 12
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 13
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}}; // 14

            Gomoku game = new Gomoku(board);
            boolean hasWin = game.placeMove('O', 5, 1);
            System.out.println("Expected:true");
            System.out.println("Actual  :" + hasWin);
            System.out.println();
        } catch (GameException e) {
            System.out.println("You shouldnt reach here!!!");
        }
    }

    public static void testPlaceMoveLose() {
        try {
            char[][] board = {
                //    0    1    2    3    4    5    6    7    8    9   10   11   12   13   14
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 0
                    {'#', 'O', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 1
                    {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 2
                    {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 3
                    {'#', 'O', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 4
                    {'#', '#', 'X', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 5
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 6
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 7
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 8
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 9
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 10
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 11
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 12
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},  // 13
                    {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}}; // 14

            Gomoku game = new Gomoku(board);
            boolean hasWin = game.placeMove('O', 1, 2);
            System.out.println("Expected:false");
            System.out.println("Actual  :" + hasWin);
            System.out.println();
        } catch (GameException e) {
            System.out.println("You shouldnt reach here!!!");
        }
    }

    public static void main(String[] args) {


        testDiagonalBackwardSlash();

        testDiagonalForwardSlash();

        testHorizontal();

        testVertical();

        testPlaceMoveWin();

        testPlaceMoveLose();

        testConstructor();

    }
}
