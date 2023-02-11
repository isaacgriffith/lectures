package edu.isu.cs.grifisaa.patterns.flyweight;

public class Glyph {

    private char _c;

    public Glyph(char c) {
        _c = c;
    }

    public String myPosition(int position) {
        return "" + position + " " + _c + ": " + this;
    }
}
