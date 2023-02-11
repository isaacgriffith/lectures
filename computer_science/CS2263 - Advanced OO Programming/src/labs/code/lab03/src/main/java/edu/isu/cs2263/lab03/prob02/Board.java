package edu.isu.cs2263.lab03.prob02;

// Here is another board game example, this time just code for the board
// and there are both 2D and 3D boards.
public class Board {

    private Square[][] squares;
    public void updateSquare(int x, int y,
                  Square aSquare) {
        squares[x][y] = aSquare;
    }

    public Square getSquare(int x, int y) {
        return squares[x][y];
    }

    // ... more methods
}
