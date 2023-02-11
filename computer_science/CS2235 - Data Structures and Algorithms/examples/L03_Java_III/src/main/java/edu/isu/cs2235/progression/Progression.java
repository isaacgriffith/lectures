package edu.isu.cs2235l20.progression;

public class Progression extends AbstractProgression {

    public Progression() { super(); }

    public Progression(long start) {
        super(start);
    }

    @Override
    protected void advance() {
        current++;
    }

}
