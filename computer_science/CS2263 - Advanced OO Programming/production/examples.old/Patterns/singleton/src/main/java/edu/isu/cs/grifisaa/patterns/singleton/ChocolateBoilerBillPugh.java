package edu.isu.cs.grifisaa.patterns.singleton;

/**
 * A Singleton instance based on the Bill Pugh approach with an internal helper class
 *
 * Pros:
 *  1. Lazy Initialization, INSTANCE is only created when needed
 *  2. Multithreaded support without synchronization
 *  3. Simplicity
 *
 * Cons:
 */
public class ChocolateBoilerBillPugh extends AbstractChocolateBoiler {

    // private constructor
    private ChocolateBoilerBillPugh() {
        super();
    }

    public static ChocolateBoilerBillPugh getInstance() {
        return BoilerHelper.INSTANCE;
    }

    // internal helper class
    private static class BoilerHelper {
        static final ChocolateBoilerBillPugh INSTANCE = new ChocolateBoilerBillPugh();
    }
}
