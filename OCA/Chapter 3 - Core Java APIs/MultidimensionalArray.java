public class MultidimensionalArray {
    public static void main(String[] args) {
        int[][] twodArr = {{1, 2}, {2, 34, 56}};
        for (int i = 0; i < twodArr.length; i++) {
            for (int j = 0; i < twodArr[i].length; i++) {
                System.out.println(twodArr[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
