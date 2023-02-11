package edu.cs.cs2263.examples.spock

import spock.lang.Specification
import spock.lang.Unroll


class CalculatorSpec extends Specification {

    def calculator

    def setup() {
        given:
          calculator = new Calculator()
        and: "nothing is done to the calculator before addition"
    }

    @Unroll
    def "BDD add two numbers"() {
        when: "adding two values together"
          def sum = calculator.add(a, b)
        then: "the result is the expected sum"
          sum == c
        where:
          a | b || c
          2 | 2 || 4
          2 | 3 || 5
          3 | 2 || 5
          0 | 1 || 1
    }

    @Unroll
    def "BDD subtract two numbers"() {
        when: "subtracting two values"
          def diff = calculator.subtract(a, b)
        then: "the result is the expect difference"
          diff == c
        where:
          a   | b  || c
          3   | 2  || 1
          3   | 3  || 0
          2   | 3  || -1
          100 | 80 || 20
    }

    @Unroll
    def "BDD add a list of number"() {
        when: "provided a list of numbers to be added"
          def sum = calculator.add(list)
        then: "the result is the sum across the list"
          sum == expected
        where:
          list      || expected
          [1,2,3]   || 6
          [0,0,0]   || 0
          [-1,-2,1] || -2
    }

    @Unroll
    def "Bad input when summing array"() {
        when: "attempt to add across the array"
          calculator.add(list)
        then:
          thrown ex
        where:
          list || ex
          null || NullPointerException.class
          []   || IllegalArgumentException.class
    }
}