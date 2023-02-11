# What I learned today

This is an in-class group exercise. You can work with as many of your classmates as you wish. Print all names on the top of the page.

  1. Write down three things that you learned from "A Historical Introduction to Software Maintenance & Evolution."
  
# First Test

This is an in-class individual exercise. Use your own paper and print your name on the top of the page.

Design tests for this simple method. Your tests should include input values and expected outputs.


```java
int f(boolean X, boolean Y)
{
    if (X || Y)
        return 42;
    else
        return 0;
}
```

# What I learned from Chapter 1

This is an in-class group exercise. You can work with as many of your classmates as you wish. Print all names on the top of the page.

  1. In a few words, describe how a software fault differs from a software failure.
  2. Why don't we simply let users find all of our software faults?
  3. Tell me one thing you learned from Chapter 1 that you didn't already know.
  
# Myth Discussion

This is an in-class group exercise. Work with some of your near neighbors. Print all names on the top of the page.

We discussed several myths about software changes. Pick one, and discuss it with your teammates. Summarize your discussion on paper for submission.

Note: I will check your summary for evidence that your discussion was substantive, and not just "let's pick myth 5, write down that change is not easy, and then talk about something else."

# Evolutionary Design Discussion

This is an in-class group exercise. Work with some of your near neighbors. Print all names on the top of the page.

We discussed the idea of evolutionary design. Discuss and answer the following question with your partners.

  1. In your own words, and in one sentence, describe *evolutionary design*.
  
  
This is an in-class group exercise. Work with some of your near neighbors. Print all names on the top of the page.

We discussed the idea that the web allows software engineers to use evolutionary design. Answer the following questions with your partners.

  1. Name the key factors that allow evolutionary design in software.
  2. What do we lose with evolutionary design?
  
# Finding Coding Standards

This is an in-class group exercise. Work with some of your near neighbors. Print all names on the top of the page.

Find a coding standards document online. Pick the programming language as a group.

  * Discuss the requirements
  * Do you disagree with any of the standards?
  * Does it leave anything out?
  
Write down the location of the document and indicate which language. Write down which standards you disagreed with and whether anything was left out.

# Critique Coding Style

This is an in-class group exercise. Work with some of your near neighbors. Print all names on the top of the page.

Find a Java class from GitHub or something one of you wrote. Any Java class works. Critique the coding style as a group.

  * Does it exhibit an apparent coding style?
  * Is the coding style consistent?
  * Which style decisions do you agree with and disagree with?
  
Write your answers down and submit them before leaving class.

# Design Pattern

This is an in-class group exercise. Work with some of your near neighbors. Print all names on the top of the page.

Find a project one of you built for a previous course. The program needs to have at least 4 separate class files. Discuss the overall design of the project.

  * Can you find a discernible design pattern in this software?
  * What is is?
  * Based on what you know now, how should it be different, and why?
  
Note: Try not to get defensive if your group picks on your design... you're a student so you should be getting better.

Write down your answers and submit them before leaving class.

# Chapter 2 Inventory

This is an in-class group exercise. Work with some of your near neighbors. Print all names on the top of the page. You have 5 minutes.

  1. How are test requirements and test criteria related?
  2. What is model-driven test design?

# Chapter 2 Thinking Questions

This is an in-class group exercise. Form small groups and discuss the questions amongst yourselves. You have 5 minutes per question.

  * (after slide 2) Discuss **software correctness**. Have you thought of correctness in software as possible or impossible? Do you agree with the claim in the book, or is it hard to accept?
  * (after slide 6) Discuss **test oracles**. Have you written many automated tests? How did you decide what assertions to write? Do you think you ever checked the wrong part of the state?
  * (after slide 23) Discuss **coverage criteria**. Why do software organizations use coverage criteria? Why don't more software organizations use coverage criteria?
  
# Chapter 3 Inventory

This is an in-class group exercise. Work with some of your near neighbors. Print all names on the top of the page. You have 5 minutes per question.

  1. Name as many components of a test as you can.
  2. What is a data-driven test?
  
# User Stories

This is an in-class group exercise. Work with some of your near neighbors. Print all names on the top of the page. Submit your papers on the way out. If we have time we will also present some in class.

Write user stories for new functionalities for the retakes web app we use to schedule retake quizzes. Use the style illustrated in the readings. Write one user story for each of the following three functionalities:

  1. Canceling a retake appointment.
  2. Entering retake dates, times, and locations
  3. Setting up a new course

Pick one of your user stories. Design at least three TDD tests for that user story. "Design"  means to describe the inputs and expected outputs -- you do not need to implement them in JUnit.

# Acceptance TDD Discussion

This is an in-class group exercise. Work with some of you near neighbors. Print all names on the top of the page.

We will stop periodically during the lecture for discussion.

# RIPR Review

This is an in-class group exercise. Work with some of your near neighbors. Print all names on the top of the page.

Answer the following questions for the Java method shown.

1. Explain the fault and propose a fix.
2. If possible, give a test input that does not reach a fault.
3. If possible, give a test input that reaches the fault, but does not result in an error state.
4. If possible, give a test input that results in an error state, but not a failure.
5. Find a test input that results in failure.
6. For the given test case, describe the first error state. Be sure to describe the complete state.

```java
// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 1; page 13

import java.io.*;

public class FindLast
{
  /**
    * Find last index of element
    *
    *  @param x array to search
    *  @param y value to look for
    *  @return last index of y in x; -1 if absent
    *  @throws NullPointerException if x is null
    */
   public static int findLast (int[] x, int y)
   {
      // As the example in the book points out, this loop should end at 0.
      for (int i=x.length-1; i > 0; i--)
      {
         if (x[i] == y)
         {
            return i;
         }
      }
      return -1;
   }
}

test: x = [0, 1, 0]; expected = 2
```

# TDD on Triangle

This is an in-class group exercise. Work with some of your near neighbors. Print all names on the top of the page.

Consider the Triangle program, which has been used in interviews and in research papers for decades. Triangle has a very simple function:

Given three line-segment lengths S1, S2, and S3, what kind of triangle do they form?
Try the TDD approach. Preliminary planning:

  * Why is the problem "hard" enough for an interview question?
  * What should the API look like? Design a happy-path test.
  * What are the options for signaling an invalid triangle?

Now, let's turn to adding functionality with TDD. Write a test for the triangle method.

  1. Implement enough code to make the test pass.
  2. Refactor as needed.
  3. Repeat.
  
# Criteria Discussion

This is an in-class group exercise. Form small groups and discuss the questions amongst yourselves. You have 10 minutes. Print all names on the top of the page.

1. What four structures do we use for test criteria?
2. What usually prevents our tests from achieving 100% coverage?
3. A few software organizations use test criteria and report great success. However, most organizations do not currently use test criteria. Based on your knowledge and experience, why do you think test criteria are not used more?

# Criteria-Based Test Design

Instructions: Work with your neighbors in groups. Consider the leap year function:

```java
  /** 
   * Determines if the argument is a leap year in the Gregorian calendar
   * Assumes that arguments are in Gregorian calendar range (1582 and onwards)
   * 
   * @param year value in range for Gregorian calendar
   * @return true iff year is a leap year
   */
  public static boolean isLeap(int year) {
     
     if (year % 4 != 0) return false;

     if (year % 400 == 0) return true;  

     if (year % 100 == 0) return false;

     return true;
  }
```
Build models for the software, and find tests that "cover" the models. You may find it easier to think about the tests first.

1. What information goes into an input domain model? What tests result?


2. What does a graph model for this function look like? What tests result?


3. What does a logic model for this function look like? What aspect of the program makes this model weak? Is there a refactored program where the logic model is stronger? What tests result?


4. What does a syntax model for this function look like? What tests result? As it turns out, the syntax model addresses the weakness of the logic model. How?

# Input Space Partitioning

Instructions: Work with your neighbors in groups. This is an Input Space Partitioning exercise. It's #4 from exercises 6.2 (page 90). Consider the method intersection() below, along with a defective IDM:

public static Set intersection (Set s1, Set s2)

```java
/**
 * @param  s1, s2 : sets to compute intersection of
 * @return a (non null) Set equal to the intersection of Sets s1 and s2
 * @throws NullPointerException if s1 or s2 is null
*/
```

Characteristic: Type of s1
- s1 = null
- s1 = {}
- s1 has at least one element

Characteristic: Relation between s1 and s2
- s1 and s2 represent the same set
- s1 is a subset of s2
- s2 is a subset of s1
- s1 and s2 do not have any elements in common

* Does the partition for the characteristic "Type of s1" satisfy the completeness property? If not, give a value for s1 that does not fit in any block.

* Does the partition for the characteristic "Type of s1" satisfy the disjointness property? If not, give a value for s1 that fits in more than one block.

* If necessary, fix "Type of s1".

* Repeat the prior 3 steps for the characteristic "Relation between s1 and s2".

* If the "Base Choice" criterion were applied to the two partitions (exactly as written), how many test requirements would result?

* If the "Base Choice" criterion were applied to the repaired partitions, how many test requirements would result? Write out these test requirements.

* Are all of these feasible? If not, what should happen with the infeasible requirements?

* Refine the test requirements into tests.

* If the "Pair Wise" criterion were applied to the repaired partitions, how many test requirements would result? Write out these test requirements. How many would be feasible?

# More Input Space Partitioning

This exercise builds an input domain model with specific focus on the desirable mathemtical properties. The source for this input domain models is the javaDoc description of behavior.

```java
static <E> public int boolean index (List<E> list, E element)
```

1. What exactly does index do?

   More precisely, what is reasonable javaDoc for index?

2. Using the javaDoc, identify some characteristics.

3. For each characteristic, partition the input domain into blocks.

4. Check the partition for the required mathematical properties (namely, pairwise disjointness and completeness).

5. What is a reasonable base-choice? How many base choices tests are there?

6. How many tests are needed to satisfy pair-wise coverage?

# Graph Coverage

Instructions: Work with your neighbors in groups. This is a Graph Coverage exercise.

Consider the following graph and test paths.

```
N  = { 1, 2, 3, 4, 5, 6, 7, 8 }
N0 = { 1 }
Nf = { 8 }
E  = { (1, 2), (2, 3) (2, 8), (3, 4), (3, 5),
       (4, 3), (5, 6) (5, 7), (6, 7), (7, 2) }

t1 = [1, 2, 8]
t2 = [1, 2, 3, 5, 7, 2, 8]
t3 = [1, 2, 3, 5, 6, 7, 2, 8]
t4 = [1, 2, 3, 4, 3, 5, 7, 2, 8]
t5 = [1, 2, 3, 4, 3, 4, 3, 5, 6, 7, 2, 8]
t6 = [1, 2, 3, 4, 3, 5, 7, 2, 3, 5, 6, 7, 2, 8]
```

1. Give a minimal set of test paths that achieve node coverage.


2. Give a minimal set of test paths that achieve edge coverage.


3. Identify all the edge pairs (14).


4. Give a minimal set of test paths that achieves edge-pair coverage. Are any edge-pairs missed?


5. Identify all the prime paths (19).


6. Give a minimal set of test paths that achieves prime-path coverage. Are any prime paths missed? Do sidetrips help?


# More Graph Coverage

Instructions: Work with your neighbors in groups. This exercise is more Graph Coverage.

Again consider the following graph and test paths. This is the same graph as the exercise last class; today we are focusing on direct coverage vs. sidetrips.

```
N  = { 1, 2, 3, 4, 5, 6, 7, 8 }
N0 = { 1 }
Nf = { 8 }
E  = { (1, 2), (2, 3) (2, 8), (3, 4), (3, 5),
       (4, 3), (5, 6) (5, 7), (6, 7), (7, 2) }

t1 = [1, 2, 8]
t2 = [1, 2, 3, 5, 7, 2, 8]
t3 = [1, 2, 3, 5, 6, 7, 2, 8]
t4 = [1, 2, 3, 4, 3, 5, 7, 2, 8]
t5 = [1, 2, 3, 4, 3, 4, 3, 5, 6, 7, 2, 8]
t6 = [1, 2, 3, 4, 3, 5, 7, 2, 3, 5, 6, 7, 2, 8]
```

1. Identify all of the simple paths between the following nodes. You should get a total of 5.
   - 1 and 6
   - 1 and 8
   - 4 and 6
   - 4 and 8

2. Fill in the following table:


Test Path	Simple Paths Toured Directly	Simple Paths Toured Only With a Sidetrip
t1
 	 
t2
 	 
t3
 	 
t4
 	 
t5
 	 
t6
 	 
# Graph Coverage for Source Code

Instructions: Work with your neighbors in groups. This is a graph coverage for source code exercise. Consider the following code:


  ```java
  /**
   * Returns the mininum element in a list
   * @param list Comparable list of elements to search
   * @return the minimum element in the list
   * @throws NullPointerException if list is null or
   *         if any list elements are null
   * @throws ClassCastException if list elements are not mutually comparable
   * @throws IllegalArgumentException if list is empty
   */
   public static <T extends Comparable<? super T>> T min (List<? extends T> list) {
       Iterator<? extends T> itr = list.iterator();
       if (itr.hasNext() == false) {
          throw new IllegalArgumentException("min: Empty list");
       }

       T result = itr.next();
       if (result == null) throw new NullPointerException("Min.min");

       while (itr.hasNext()) {
           T comp = itr.next();
           if (comp.compareTo(result) < 0) {    // throws NPE, CCE as needed
               result = comp;
           }
       }
       return result;
   }
   ```
    
Develop a control flow graph model of the code.
Obtain test requirements from the graph model: node, edge, edge pair, prime-path.

Develop tests (including expected outputs) that satisfy the test requirements.

# Transition to Logic Testing

Instructions: Work with your neighbors in groups. This is another graph coverage for source code exercise.


```java
// GoodFastCheap: Investigating graph testing with an old engineering joke

public final class GoodFastCheap {

    boolean good  = false;
    boolean fast  = false;
    boolean cheap = false;

    public void makeGood () {
       good = true;
       if (fast && cheap) { cheap = false; }
    }

    public void makeFast () {
       fast = true; 
       if (good && cheap) { good = false; }
    }

    public void makeCheap () {
       cheap = true;
       if (fast && good) { fast = false; }
    }

    public void makeBad ()       { good = false; }
    public void makeSlow ()      { fast = false; }
    public void makeExpensive () { cheap = false; }

    public boolean isSatisfactory() {
       if ((good && fast) || (good && cheap) || (fast && cheap)) {
          return true;
       }
       return false;
    }
}
```

Try to identify a state space suitable for a graph model from the instance variables in this program.
Identify the transitions in this state space. To make this easier, start by ignoring the methods that make things worse.

Choose a coverage criterion and develop tests that satisfy the criterion.

Note: When we get to logic coverage we'll look at when each clause determines the value of a predicate.
