package TicTacToe;

import TicTacToe.game.ConsoleGame;
import TicTacToe.player.AIPlayer;
import TicTacToe.player.HumanPlayer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleGame game;
        Board board;

        do {
            System.out.println("Welcome to Tic-Tac-Toe!");
            System.out.println("Choose game mode:");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs Computer");
            int mode = scanner.nextInt();

            if (mode == 1) {
                game = new ConsoleGame(new HumanPlayer('X'), new HumanPlayer('O'));
            } else if (mode == 2) {
                System.out.println("Choose difficulty:");
                System.out.println("1. Easy (1 step ahead)");
                System.out.println("2. Medium (3 steps ahead)");
                System.out.println("3. Hard (9 steps ahead)");
                int difficulty = scanner.nextInt();
                game = new ConsoleGame(new HumanPlayer('X'), new AIPlayer('O', difficulty));
            } else {
                System.out.println("Invalid choice! Exiting...");
                return;
            }

            board = new Board();
            game.startGame(board);

            System.out.println("Do you want to play again? (Y/N)");
        } while (scanner.next().equalsIgnoreCase("Y"));
    }
}
