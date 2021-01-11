import java.util.Arrays;

public class MatrixTest {

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};
        int[][] one = {
                {0,1,0,1,1},
                {1,0,1,1,1},
                {0,1,0,0,0},
                {1,1,0,0,0},
                {1,1,0,1,0}
        };

        String[] names2 = {"Bravo", "B", "C", "D", "E", "F", "G"};
        int[][] two = {
                {0,0,0,0,1,1,0},
                {0,1,1,0,1,0,1},
                {0,1,0,0,0,1,1},
                {0,0,0,1,1,1,0},
                {1,1,0,1,1,1,0},
                {1,0,1,1,1,0,1},
                {0,1,1,0,0,1,0}
        };
        
        
        int num = 1;
        System.out.println();
        System.out.println("Test :" + num++);
        System.out.println("Expected: 1");
        System.out.println("Actual  : " + MatrixRepresentation.countFriends(one, names,"C"));

        System.out.println();
        System.out.println("Test :" + num++);
        System.out.println("Expected: 3");
        System.out.println("Actual  : " + MatrixRepresentation.countFriends( one, names, "E"));

        
        System.out.println();
        System.out.println("Test :" + num++);
        System.out.println("Expected: 5");
        System.out.println("Actual  : " + MatrixRepresentation.countFriends( two, names2,"E"));


        System.out.println();
        System.out.println("Test :" + num++);
        System.out.println("Expected: [B]");
        System.out.println("Actual  : " + Arrays.toString(MatrixRepresentation.commonFriends(one, names,"A", "C")));

        System.out.println();
        System.out.println("Test :" + num++);
        System.out.println("Expected: [B, D]");
        System.out.println("Actual  : " + Arrays.toString(MatrixRepresentation.commonFriends(one, names,"E", "A")));

        System.out.println();
        System.out.println("Test :" + num++);
        System.out.println("Expected: {2=[Bravo], 3=[C, D, G], 4=[B], 5=[E, F]}");
        System.out.println("Actual  : " + MatrixRepresentation.getSociableStats(two, names2));


    }


}
