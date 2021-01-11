import java.util.ArrayList;
import java.util.Random;

public class Minesweeper {
    public char[][] board;
    public char[][] countTable;

    public Minesweeper(int numRows, int numColumns, int numBombs) {
        board = new char[numRows][numColumns];
        placeBombs(numBombs);
        countBombs();
    }

    private void countBombs() {
        countTable = new char [board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) { 

                if(board[i][j] != 'B'){
                    for(int y = Math.max(0, i-1); y < Math.min(board.length, i+2); y++){
                        for(int x = Math.max(0, j-1); x < Math.min(board[y].length, j+2); x++){
                            if(!(i == y && j == x)){
                                if(board[y][x] == 'B'){
                                    char c = countTable[i][j];
                                    // System.out.println("Value at current position: " + c);
                                    if(c == Character.MIN_VALUE){
                                        countTable[i][j] = Character.forDigit(1, 10);
                                    } else {
                                        Integer curr = Integer.valueOf(String.valueOf(c)) + 1;
                                        countTable[i][j] = Character.forDigit(curr, 10);
                                    }        
                                }
                            }
                        }
                    }
                } else {
                    countTable[i][j] = 'B';
                }
            }
        }
    }

    private void placeBombs(int numBombs) {
        ArrayList<Integer[]> combs = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {    
                Integer[] toAdd = {i, j};            
                combs.add(toAdd);
            }
        }

        // System.out.println("All combs: " + combs.size());
        for(int i = 0; i < numBombs; i++){
            // System.out.println("Random generated: " + (int) (Math.random()*combs.size()));
            Integer[] pos = combs.remove((int) (Math.random()*combs.size()));
            // System.out.println("random position popped: " + pos[0] + ", " + pos[1]);
            board[pos[0]][pos[1]] = 'B';
        }
    }

    public String toString() {
        String toReturn = "";
        for (int i = 0; i < countTable.length; i++) {
            for (int j = 0; j < countTable[i].length; j++) {     
                if(countTable[i][j] == Character.MIN_VALUE) {
                    toReturn +=("- | ");
                } else {
                    toReturn += (countTable[i][j] + " | ");
                }
            }
            toReturn += "\n";
        }
        return toReturn;
    };
    
}
