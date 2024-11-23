package TicTacToe.player;

import TicTacToe.Board;
import java.util.Scanner;

public class HumanPlayer implements Player {
    private char symbol;

    public HumanPlayer(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void makeMove(Board board) {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        boolean validMove;

        do {
            System.out.println("Enter row (0-2): ");
            row = scanner.nextInt();
            System.out.println("Enter column (0-2): ");
            col = scanner.nextInt();
            validMove = board.updateBoard(row, col, symbol);

            if (!validMove) {
                System.out.println("Invalid move! The cell is already taken or out of range. Try again.");
            }
        } while (!validMove);
    }

    @Override
    public char getSymbol() {
        return symbol;
    }
}
