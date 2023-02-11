package edu.isu.cs.grifisaa.patterns.singleton;

/**
 * A singleton instance using a static block approach
 *
 * Pros:
 *  1. Very simple to implement
 *  2. No need to implement getInstance() method. Instance can be accessed directly
 *  3. Exceptions can be handled in static block
 *
 * Cons:
 *  1. May lead to resource wastage. Because instance of class is always created, whether it is required or not.
 *  2. CPU time is also wasted in creation of instance if not required
 */
public class ChocolateBoilerStaticBlock extends AbstractChocolateBoiler {

    // public instance
    public static ChocolateBoiler instance;

    // private constructor
    private ChocolateBoilerStaticBlock() {
        super();
    }

    static {
        // static block to initialize instance
        instance = new ChocolateBoilerStaticBlock();
    }
}
