* What is **mutation score**?

  (n) A simple count of the number of mutants killed
  (n) A count of the number of mutants killed by a given test
  (c) A ratio of mutants killed over all mutants
  
* Answer the following questions for the mutant on line 5 in the method findVal()

  ```java
  /**
   * Find last index of element
   *
   * @param numbers array to search
   * @param val value to look for
   * @return last index of val in numbers; -1 if absent
   * @throws NullPointerException if numbers is null
   */
  1. public static int findVal(int numbers[], int val)
  2. {
  3.     int findVal = -1;
  4.
  5.     for (int i = 0; i < numbers.length; i++)
  5'. // for (int i = (0 + 1); i < numbers.length; i++)
  6.         if (numbers[i] == val)
  7.             findVal = i;
  8.     return (findVal);
  9. }
  ```
  
  - If possible, find test inputs that do **not reach** the mutant
  
  - If possible, find test inputs that satisfy reachability but **not infection** for the mutant
  
  - If possible, find test inputs that **strongly kill** the mutants.
  
* Consider the following BNF Grammar:

  ```
  A ::= O B | O M | O B M
  O ::= "w" | "x" | "s" | "m"
  B ::= "i" | "f" | "c" | "r"
  M ::= "o" | "t" | "p" | "a" | "h"
  ```
  
  Answer the following questions
  
  - How many nonterminal symbols are in the grammar?  (c) 4
  - How many terminal symbols are in the grammar?  (c) 13
  - Write **two** strings that are **valid** according to the BNF grammar.
  - For each of your two strings, give two **valid** mutants of the string.
  
* Integration testing focuses on what?
  
  (c) The interactions between components of a system under test
  (n) The interactions within a component of a system under test
  
* Object-oriented Mutation Testing focuses on which of the following programming concepts? (select all that apply)

  (c) Information Hiding
  (c) Overloading
  (c) Dynamic Binding
  (c) Polymorphism
  (c) Inheritance
  (n) Iteration
  (n) Recursion
  (n) None of the other provided answers
  
* Answer the following questions for the given grammar:

  ```
  phoneNumber   ::= exchangePart dsah numberPart
  exchangePart  ::= special zeroOrSpecial other
  numberPart    ::= oridinary{4}
  ordinary      ::= zero | special | other
  zeroOrSpecial ::= zero | special
  zero          ::= "0"
  special       ::= "1" | "2"
  other         ::= "3" | "4" | "5" | "6" | "7" | "8" | "9"
  dash          ::= "-"
  ```

  For the following three questions, identify as true or false whether the given string is a phoneNumber (in the grammar).
  
  - 123-4567  (c) True
  - 012-3456  (c) False
  - 109-1212  (c) True
  
  - Consider the following mutation of the grammar:

    ```
    exchangePart ::= special ordinary other
    ```
    
    If possible, provide the following:

      1. A string that appears in the mutated grammar but not in the original grammar
      2. A string that is in the original grammar but not the mutated grammar
      3. A string in both grammars.

    If it is not possible, state the reason why.

    Please number your answers corresponding to the above.
    
* The IEEE 829-2008 standard defines two types of test plans. What are these and what are the **key** differences between them?

* What is the danger in using test plans and other forms of documentation? Answer from a testing perspective.

* Describe the CITO problem and how it makes testing difficult.


