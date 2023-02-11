package edu.isu.cs2235l20;

/**
 * @author Isaac Griffith
 */
public class Driver {

    public static void main(String[] args) {
        Counter c = new Counter();
        c.increment();
        c.increment(3);
        int temp = c.getCount();
        c.reset();
        Counter d = new Counter(5);
        d.increment();
        Counter e = d;
        temp = e.getCount();
        e.increment();
    }
}