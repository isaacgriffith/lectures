package edu.isu.cs.grifisaa.patterns.singleton;

/**
 * A single instance using Lazy Initialization in a thread safe manner
 *
 * Pros:
 *  1. Lazy initialization is possible
 *  2. It is also thread safe
 *
 * Cons:
 *  1. getInstance() method is synchronized so it causes slow performance as multiple threads can't access it simultaneously
 */
public class ChocolateBoilerLazyInitThreadSafe extends AbstractChocolateBoiler {

    // private instance, so that it can be accessed by only getInstance method
    private static ChocolateBoiler instance;

    // private constructor
    private ChocolateBoilerLazyInitThreadSafe() {
        super();
    }

    // synchronized method to control simultaneous access
    synchronized public static ChocolateBoiler getInstance() {
        if (instance == null) {
            // if instance is null, initialize
            instance = new ChocolateBoilerLazyInitThreadSafe();
        }

        return instance;
    }
}
