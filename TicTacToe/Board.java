package TicTacToe;

public class Board {
    private char[][] grid;
    private static final int SIZE = 3;

    public Board() {
        grid = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                grid[i][j] = ' ';
            }
        }
    }

    public void displayBoard() {
        System.out.println("---------");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print("| " + grid[i][j] + " ");
            }
            System.out.println("|");
            System.out.println("---------");
        }
    }

    public boolean updateBoard(int row, int col, char symbol) {
        if (row >= 0 && row < SIZE && col >= 0 && col < SIZE && grid[row][col] == ' ') {
            grid[row][col] = symbol;
            return true;
        }
        return false;
    }

    public boolean checkWin(char symbol) {
        for (int i = 0; i < SIZE; i++) {
            if ((grid[i][0] == symbol && grid[i][1] == symbol && grid[i][2] == symbol) ||
                (grid[0][i] == symbol && grid[1][i] == symbol && grid[2][i] == symbol)) {
                return true;
            }
        }
        return (grid[0][0] == symbol && grid[1][1] == symbol && grid[2][2] == symbol) ||
               (grid[0][2] == symbol && grid[1][1] == symbol && grid[2][0] == symbol);
    }

    public boolean isDraw() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setCell(int row, int col, char symbol) {
        grid[row][col] = symbol;
    }
}