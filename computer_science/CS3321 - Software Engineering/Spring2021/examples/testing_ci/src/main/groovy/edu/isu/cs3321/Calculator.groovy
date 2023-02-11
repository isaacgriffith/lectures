package edu.isu.cs3321

class Calculator {

    Stack<Double> stack = new Stack<>()

    void push(double arg) {
        stack.push(arg)
    }

    double divide() {
        return stack.pop() / stack.pop()
    }
}
