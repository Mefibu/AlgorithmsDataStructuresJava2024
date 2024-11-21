package TicTacToe;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Choose game mode:");
        System.out.println("1. Player vs Player");
        System.out.println("2. Player vs Computer");
        int mode = scanner.nextInt();

        if (mode == 1) {
            player1 = new HumanPlayer('X');
            player2 = new HumanPlayer('O');
        } else if (mode == 2) {
            System.out.println("Choose difficulty:");
            System.out.println("1. Easy (1 step ahead)");
            System.out.println("2. Medium (3 steps ahead)");
            System.out.println("3. Hard (9 steps ahead)");
            int difficulty = scanner.nextInt();

            player1 = new HumanPlayer('X');
            player2 = new AIPlayer('O', difficulty);
        } else {
            System.out.println("Invalid choice! Exiting...");
            return;
        }

        board = new Board();
        currentPlayer = player1;
        playGame();
    }

    public void playGame() {
        while (true) {
            System.out.println("\nCurrent board:");
            board.displayBoard();
            System.out.println("Player " + currentPlayer.getSymbol() + ", it's your turn.");
            currentPlayer.makeMove(board);

            if (board.checkWin(currentPlayer.getSymbol())) {
                System.out.println("\nFinal board:");
                board.displayBoard();
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                break;
            }

            if (board.isDraw()) {
                System.out.println("\nFinal board:");
                board.displayBoard();
                System.out.println("It's a draw!");
                break;
            }

            switchPlayer();
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
