package edu.isu.cs2263.lab03.prob02;

public class ThreeDBoard extends Board {

    private Square[][][] squares;
    public void updateSquare(int x, int y, int z,
                  Square aSquare) {
        squares[x][y][z] = aSquare;
    }

    public Square getSquare(int x, int y, int z) {
        return squares[x][y][z];
    }

    // ... more methods
}
