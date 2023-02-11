package edu.isu.cs2235;

public class TrieNode {

    private char label;
    private boolean end;

    public TrieNode(char label, boolean end) {
        this.label = label;
        this.end = end;
    }

    public boolean isRoot() {
        return false;
    }

    public char getLabel() {
        return label;
    }

    public void setLabel(char label) {
        this.label = label;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }
}
