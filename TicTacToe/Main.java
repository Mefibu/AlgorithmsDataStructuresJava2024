
package TicTacToe;

import TicTacToe.game.ConsoleGame;
import TicTacToe.player.AIPlayer;
import TicTacToe.player.HumanPlayer;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsoleGame game;

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Enter the number of wins required to finish the match:");
        int winsRequired = scanner.nextInt();

        do {
            System.out.println("\nChoose game mode:");
            System.out.println("1. Player vs Player");
            System.out.println("2. Player vs Computer");
            System.out.println("3. Computer vs Computer");
            int mode = scanner.nextInt();

            if (mode == 1) {
                game = new ConsoleGame(new HumanPlayer('X'), new HumanPlayer('O'), winsRequired);
            } else if (mode == 2) {
                System.out.println("Choose difficulty for AI:");
                System.out.println("1. Easy (1 step ahead)");
                System.out.println("2. Medium (3 steps ahead)");
                System.out.println("3. Hard (9 steps ahead)");
                int difficulty = scanner.nextInt();
                game = new ConsoleGame(new HumanPlayer('X'), new AIPlayer('O', difficulty), winsRequired);
            } else if (mode == 3) {
                System.out.println("Choose difficulty for AI 1:");
                int difficulty1 = scanner.nextInt();
                System.out.println("Choose difficulty for AI 2:");
                int difficulty2 = scanner.nextInt();
                game = new ConsoleGame(new AIPlayer('X', difficulty1), new AIPlayer('O', difficulty2), winsRequired);
            } else {
                System.out.println("Invalid choice! Exiting...");
                return;
            }

            game.startGame();

            System.out.println("Do you want to play again? (Y/N)");
        } while (scanner.next().equalsIgnoreCase("Y"));
    }
}
