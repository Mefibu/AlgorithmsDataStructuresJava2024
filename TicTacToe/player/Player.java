package TicTacToe.player;

import TicTacToe.Board;

public interface Player {
    void makeMove(Board board);
    char getSymbol();
}
