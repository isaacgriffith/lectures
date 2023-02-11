package edu.isu.cs.grifisaa.patterns.singleton;

/**
 * A single instance using eager initialization
 *
 * Pros:
 *  1. Very simple to implement
 * Cons:
 *  1. May lead to resource wastage. Because instance of class is always created, whether it is used or not.
 *  2. CPU time is also wasted in creation of instance if it is not required.
 *  3. Exception handling is not possible.
 */
public class ChocolateBoilerEagerInit extends AbstractChocolateBoiler {

    // private instance initialized when loading the class
    private static final ChocolateBoiler instance = new ChocolateBoilerEagerInit();

    private ChocolateBoilerEagerInit() {
        super();
    }

    public static ChocolateBoiler getInstance() {
        return instance;
    }
}
