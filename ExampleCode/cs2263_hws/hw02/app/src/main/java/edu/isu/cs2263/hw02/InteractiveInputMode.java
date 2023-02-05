/**
 * Copyright 2021 Isaac D. Griffith
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package edu.isu.cs2263.hw02;

import java.util.Scanner;

/**
 * Object to process expressions from user input at the console.
 *
 * It is expected that each line of the file represents an individual expression. Also, the expressions should be properly formatted
 * such that each expression is a sequence of numbers separated by operators (+, -, *, /) and between each number and each operator is
 * a space. For example: 1 + 2 * 3 is properly formatted while 1+2*3 is not.
 *
 * @author Isaac D Griffith
 * @version 1.2.0
 */
public class InteractiveInputMode extends AbstractInputMode {

    /**
     * Constructs a new InteractiveInputMode
     *
     * @param eval The evaluator used to evaluate expressions
     */
    public InteractiveInputMode(Evaluator eval) {
        super(eval);
    }

    /**
     * Drives the processing of user input and passes the input to the given evaluator
     */
    @Override
    public void processInput() {
        Scanner scan = new Scanner(System.in);
        while(true) {
            System.out.print("> ");
            String expr = scan.nextLine();
            printData(expr);
        }
    }

    /**
     * Tests if the input mode is batch or not
     *
     * @return true if the mode is batch, false otherwise.
     */
    @Override
    protected boolean isBatch() {
        return false;
    }
}