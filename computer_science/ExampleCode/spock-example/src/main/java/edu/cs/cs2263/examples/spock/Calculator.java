package edu.cs.cs2263.examples.spock;

import java.util.List;

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int add(List<Integer> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("List cannot be empty");
        int sum = 0;
        for (int i : list)
            sum += i;
        return sum;
    }

    public int subtract(int a, int b) {
        return a - b;
    }
}
