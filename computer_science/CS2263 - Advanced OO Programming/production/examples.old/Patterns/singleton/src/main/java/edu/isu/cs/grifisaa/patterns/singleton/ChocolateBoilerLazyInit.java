package edu.isu.cs.grifisaa.patterns.singleton;

/**
 * A singleton instance created using the Lazy Initialization approach
 *
 * Pros:
 *  1. Object is created only if it is needed. It may overcome resource and CPU time wastage
 *  2. Exception handling is also permitted in getInstance method
 *
 * Cons:
 *  1. Every time a condition of null has to be checked
 *  2. Instance can't be directly accessed
 *  3. In multithreaded environment, may break singleton property
 */
public class ChocolateBoilerLazyInit extends AbstractChocolateBoiler {

    // private instance, so that it can be accessed only by getInstance() method
    private static ChocolateBoiler instance;

    // private constructor
    private ChocolateBoilerLazyInit() {
        super();
    }

    // method to return instance of class
    public static ChocolateBoiler getInstance() {
        if (instance == null) {
            // if instance is null, initialize
            instance = new ChocolateBoilerLazyInit();
        }

        return instance;
    }
}
