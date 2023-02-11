package edu.isu.cs2263.lab03.prob01;

public class Game {
    private Piece[][] board;
    public void move() {
        /* Read user input */
        Point source = readCoordinateFromInput();
        Point dest = readCoordinateFromInput();
        /* Does the source square have a piece? Is the desination empty? */
        if (board[source.x][source.y] == null || board[dest.x][dest.y] != null)
            throw new IllegalMoveException();
        /* ... More rules here .. */
        /* Print out the current state of the board */
        printBoard();
    }

    private Point readCoordinateFromInput() {
        /* Read input from the terminal and convert to a point */
    }
    private void printBoard() {
        /* Printing code here */
    }
}
