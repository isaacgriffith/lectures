package edu.isu.cs2235l20.progression;

public class ArithmeticProgression extends Progression {

    protected long increment;

    public ArithmeticProgression() { this(1, 0); }

    public ArithmeticProgression(long stepsize) { this(stepsize, 0); }

    public ArithmeticProgression(long stepsize, long start) {
        super(start);
        increment = stepsize;
    }

    @Override
    protected void advance() {
        current += increment;
    }
}
