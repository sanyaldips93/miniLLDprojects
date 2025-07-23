import java.util.Arrays;

public class Board {
    private char[][] grid;

    public Board() {
        grid = new char[3][3];
        for (char[] row : grid) {
            Arrays.fill(row, ' ');
        }
    }

    public void display() {
        for (int i = 0; i < 3; i++) {
            System.out.println(grid[i][0] + " | " + grid[i][1] + " | " + grid[i][2]);
            if (i < 2) {
                System.out.println("---------");
            }
        }
        System.out.println();
    }

    public boolean isValidMove(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 3 && grid[row][col] == ' ';
    }

    public void placeSymbol(int row, int col, char symbol) {
        grid[row][col] = symbol;
    }

    public boolean isFull() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Helper for win check (used in Game class)
    public char[][] getGrid() {
        return grid;
    }
}
