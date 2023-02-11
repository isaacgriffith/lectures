package edu.isu.cs2235l20.progression;

public class FibonacciProgression extends Progression {

    protected long prev;

    public FibonacciProgression() { this(0, 1); }

    public FibonacciProgression(long first, long second) {
        super(first);
        prev = second - first;
    }

    @Override
    protected void advance() {
        long temp = prev;
        prev = current;
        current += temp;
    }
}
