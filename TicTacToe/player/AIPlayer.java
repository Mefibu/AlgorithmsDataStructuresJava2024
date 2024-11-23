package TicTacToe.player;

import TicTacToe.Board;

public class AIPlayer implements Player {
    private char symbol;
    private int difficulty;

    public AIPlayer(char symbol, int difficulty) {
        this.symbol = symbol;
        this.difficulty = difficulty;
    }

    @Override
    public void makeMove(Board board) {
        System.out.println("Computer is making its move...");
        int[] bestMove = findBestMove(board, difficulty);
        board.updateBoard(bestMove[0], bestMove[1], symbol);
    }

    @Override
    public char getSymbol() {
        return symbol;
    }

    private int[] findBestMove(Board board, int depth) {
        char[][] grid = board.getGrid();
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ' ') {
                    grid[i][j] = symbol;
                    int score = minimax(board, depth - 1, false);
                    grid[i][j] = ' ';
                    if (score > bestScore) {
                        bestScore = score;
                        bestMove = new int[]{i, j};
                    }
                }
            }
        }
        return bestMove;
    }

    private int minimax(Board board, int depth, boolean isMaximizing) {
        char[][] grid = board.getGrid();
        if (board.checkWin(symbol)) return 10;
        if (board.checkWin(getOpponentSymbol())) return -10;
        if (board.isDraw() || depth == 0) return 0;

        int bestScore = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == ' ') {
                    grid[i][j] = isMaximizing ? symbol : getOpponentSymbol();
                    int score = minimax(board, depth - 1, !isMaximizing);
                    grid[i][j] = ' ';
                    bestScore = isMaximizing
                            ? Math.max(bestScore, score)
                            : Math.min(bestScore, score);
                }
            }
        }
        return bestScore;
    }

    private char getOpponentSymbol() {
        return (symbol == 'X') ? 'O' : 'X';
    }
}
