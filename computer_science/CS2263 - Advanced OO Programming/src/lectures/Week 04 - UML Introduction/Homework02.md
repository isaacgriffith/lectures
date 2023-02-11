# Homework 02

## Part 01 - Exercises

Complete the following exercises. The number of the exercises is <chapter>.<questions>. For example, exercise 1.3 would be Chapter 1 Question 3. Additonally, the page numbers are based on the physical book and the mobile or e-reader edition. Writeup the answers in a PDF file formatted using LaTeX (I suggest using [Gij's Homework Template](https://www.overleaf.com/latex/templates/gijss-homework-template/xrhhfgqcfbft) from [Overleaf](https://overleaf.com)). For the exercises with code be sure to add the code into the PDF (and make it look nice). For the exercises requiring UML (use LucidCharts, I do not accept hand-drawn diagrams).

* Exercise 5.1
* Exercise 5.4
* Exercise 5.6
* Exercise 6.3
* Exercise 6.4
* Exercise 6.6
* Exercise 6.7
* Exercise 6.9
* Exercise 6.11
* Exercise 6.13
* Exercise 7.2
* Exercise 7.3
* Exercise 7.6

## Part 02 - Project

1. Create a new repo on GitHub (make it public)
2. Clone the repo on your local machine
3. Open the local directory on your machine and initialize it as a gradle project
   - make it a Java Library project
   - use "edu.isu.cs.cs2263.hw02" as your base package
4. Study the class `java.util.StringTokenizer`. Implement the following interface, `PushbackTokenizer`, as a **class adaptor** with `StringTokenizer` as the adaptee.

    ```java
    public interface PushbackTokenizer {

      // return the next token
      String nextToken();

      // returns true if and only if there are more tokens
      boolean hasMoreTokens();

      // the token read is pushed back, so it can be read again using nextToken.
      void pushback();
    }
    ```
5. Add a quick `Driver.java` or `App.java` class to act as the `Client` of the PushbackTokenizer. Execute a few experiments
6. Commit and Push your changes.
7. Add the URL of your repo to the PDF containing the answers to the exercises above.

## Submission

* Submit a single PDF to moodle
