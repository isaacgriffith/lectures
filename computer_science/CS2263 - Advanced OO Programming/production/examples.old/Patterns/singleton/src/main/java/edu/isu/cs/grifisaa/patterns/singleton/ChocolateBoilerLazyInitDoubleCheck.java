package edu.isu.cs.grifisaa.patterns.singleton;

/**
 * A singleton instance using lazy initialization and double-check locking
 *
 * Pros:
 *  1. Lazy initialization is possible
 *  2. It is also thread safe
 *  3. Performance overhead reduce because synchronized block moved into method body
 *
 * Cons:
 *  1. First time, it can affect performance
 */
public class ChocolateBoilerLazyInitDoubleCheck extends AbstractChocolateBoiler {

    // private instance, so that it can be access only by getInstance() method
    private static ChocolateBoiler instance;

    // private constructor
    private ChocolateBoilerLazyInitDoubleCheck() {
        super();
    }

    public static ChocolateBoiler getInstance() {
        if (instance == null) {
            // synchronized block to remove overhead
            synchronized (ChocolateBoilerLazyInitDoubleCheck.class) {
                if (instance == null) {
                    // if instance is null, initialize
                    instance = new ChocolateBoilerLazyInitDoubleCheck();
                }
            }
        }

        return instance;
    }
}
