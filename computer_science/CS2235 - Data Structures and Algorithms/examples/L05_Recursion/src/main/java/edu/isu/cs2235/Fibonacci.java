package edu.isu.cs2235l20;

public class Fibonacci {

    public int fibonacci(int index) {
        if (index <= 0) {
            return 0;
        } else if (index < 2) {
            return 1;
        } else {
            return fibonacci(index - 1) + fibonacci(index - 2);
        }
    }
}
