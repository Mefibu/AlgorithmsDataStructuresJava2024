
package TicTacToe.game;

import TicTacToe.Board;
import TicTacToe.player.Player;

public class ConsoleGame implements Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private int winsRequired;
    private int player1Wins;
    private int player2Wins;

    public ConsoleGame(Player player1, Player player2, int winsRequired) {
        this.player1 = player1;
        this.player2 = player2;
        this.winsRequired = winsRequired;
        this.player1Wins = 0;
        this.player2Wins = 0;
    }

    @Override
    public void startGame() {
        while (player1Wins < winsRequired && player2Wins < winsRequired) {
            this.board = new Board();
            currentPlayer = player1;
            playGame();
            System.out.println("Score: Player " + player1.getSymbol() + " - " + player1Wins +
                               " | Player " + player2.getSymbol() + " - " + player2Wins);
        }

        if (player1Wins == winsRequired) {
            System.out.println("Player " + player1.getSymbol() + " wins the match!");
        } else {
            System.out.println("Player " + player2.getSymbol() + " wins the match!");
        }
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
                System.out.println("Player " + currentPlayer.getSymbol() + " wins this round!");
                if (currentPlayer == player1) {
                    player1Wins++;
                } else {
                    player2Wins++;
                }
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
