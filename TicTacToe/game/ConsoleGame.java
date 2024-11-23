package TicTacToe.game;

import TicTacToe.Board;
import TicTacToe.player.Player;

public class ConsoleGame implements Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public ConsoleGame(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    @Override
    public void startGame() {
        this.board = new Board(); // Ініціалізація нового ігрового поля
        currentPlayer = player1;
        playGame();
    }

    public void startGame(Board board) {
        this.board = board;
        currentPlayer = player1;
        playGame();
    }

    private void playGame() {
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
