---
author:
- Isaac Griffith
title: Recursion
institute: |
  CS 2235

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

#

\vfill
\centering
\Huge Recursion

# Outcomes

At the end of Today's Lecture you will be able to:

* Use Java Arrays
* Understand the basics of recursion
* Be capable of using recursion in the design of algorithmic solutions to problems

#

\vfill
\begin{center}
{\Huge Java Arrays}
\end{center}

# Arrays

* Solve the problem of storing large numbers of values and manipulating them
* Store a fixed-size sequential collection of elements of the same type

::: columns
:::: column
* Declaration:
  - `double[] temp;`
  - `double temp[];`
  - `double temp[] = new double[24];`
  - `double temp[] = {45.0, 38.6}`
::::
:::: column
* Usage
  - `temp[0] = temp[0] + 5.9`
  - `for (double x : temp) System.out.println(x);`
::::
:::

Note: Array Indexes start at 0!

#

\vfill
\begin{center}
{\Huge Introduction to Recursion}
\end{center}

# Searching

* Given a sorted array and a value, how could we search for that value in the array?

$array \longleftarrow \left[7,\,7,\,9,\,12,\,18,\,34,\,52,\,54,\,59\right]$

$value = 34$

\pause

\vskip2em
\begin{center}
{\huge \color{Roarange}{Linear Search}}
\end{center}

# Searching

* How many elements (at worst) will we have to go through for linear search?

\pause

\begin{center}
The number of elements in the array.
\end{center}

* Can we develop an algorithm that goes faster than linear search (i.e. one that doesn't require going through the entire array)?


# Binary Search

Basic Idea:

1. Compare the value to the midpoint of the array.
2. If the value is larger, search for it in the larger half of the array. If the value is smaller, search for it in the small half of the array.
3. Repeat by calculating the midpoint of the region now being considered and got to step 1.

\pause

\vskip2em
\begin{center}
{\Huge \color{Roarange}{Sounds Like a Job for Recursion!}}
\end{center}

# Introduction

Recursion is a very powerful though initially confusing technique.

* The key is to follow the steps outlined in this lecture and you will not go astray.
* We will begin with a canonical example: Calculating the Fibonacci number for a given index
* We will describe how recursion works and provide some guidelines on using this very powerful technique.


# Example: Fibonacci Numbers

The Fibonacci sequence is defined as follows:

```
index:  0  1  2  3  4  5  6  ...
value:  0  1  1  2  3  5  8  ...
```

Which is a recursive definition that says unless the index is 0 or 1 then the value for an index is the value of the previous index the the value of the 2nd previous index.

Question: Can we implement this using loops? Of course

# Fibonacci Numbers

::: columns
:::: column
Iterative Implementation

\scriptsize

```java
  public int fibonacci(int n)
  {
      if (n < 0)
          return 0;
      else if (n < 2)
          return n;

      int a = 1;
      int b = 1;
      int c = 0;

      for (int i = 0; i < n - 2; i++) {
          c = a + b;
          b = a;
          a = c;
      }

      return a;
  }
```
::::
:::: column
Recursive Implementation

```java
  public int fibRecursive(int n) {
       if (n < 0)
           return 0;
       eles if (n < 2)
           return n;
       else {
           return fibRecursive(n - 2) + fibRecursive(n - 1);
       }       
  }
```

Here the recursive calls using `n-1` and `n-2` are driving the method towards one of the two base cases.
::::
:::

# How Recursion Works


* Recursion works by having a recursive method call itself, but only under certain conditions.
* Basically, we need to define two separate conditions, or cases:

  * **Base Case** -- Also known as the simplest case. These cases have a known answer and can be handled directly by the method without the need for a recursive call.
  * **Recursive Case** -- Handled by recursion in a fashion designed to drive the method towards one of the base cases. That is the goal of each recursive call is to bring us one step closer to the point where we reach a base case.

* The magic here is: *As long as you handle the simplest case first n the base cases part, and only rely on simpler cases in the recursive part, then your method will always work.* **Trust in the method, and ensure that your recursive cases drive towards the base cases**.


# Understanding Fibonacci

\begin{center}
\includegraphics[width=\textwidth]{images/Module2/Recursion/fibtree.png}
\end{center}

# Defining a Recursive Method

There are four rules for defining a recursive method:

1. Identify the base cases first.

2. Identify the simplest form for the recursive part, such that its solution is defined using base cases. In the Fibonacci problem this is Fibonacci(2).

3. Define the method using the following template:

```{=latex}
{\scriptsize
```

```java
      public ReturnType recursiveMethod(Type p1) {
        // parameters should control the recursion
        if (base_condition)
            // directly handle the base case
        else {
            // recursively handle every other case
        }
      }
```

```{=latex}
}
```

4. Follow the rule: Recursive calls should be simpler than the current call, that is, they should always lead in the direction of a base case.

# General Recursive Example

\footnotesize

**Problem -- SumDigits**: Given a non-negative integer `n`, return the sum of its digits recursively. Note that: `123 % 10` evaluates to `3` (the last digit) and that `123 / 10` evaluates to `12` (all but the last digit).

Examples:
```
sumDigits(126) --> 9
sumDigits(49) --> 13
sumDigits(12) --> 3
```

* What are the base cases?

  * `n < 10` will `return n`

* What are the recursive cases?

  * `return n % 10 + sumDigits(n / 10)`


# SumDigits Implementation

## SumDigits

```java
 public int sumDigits(int n) {
     if (n < 10)
        return n;
     else
        return n % 10 + sumDigits(n / 10);
 }
```

#

\vfill
\begin{center}
{\Huge Recursion vs. Loops}
\end{center}

# Recursive Loops

A recursive loop is what occurs when none of the base cases can be reached.

* These occur due to programming errors in the recursive part that prevent the recursive calls from driving down to the base cases.
* Recursive loops should be avoided and are akin to infinite loops.
* In Java, recursive loops will lead to a `StackOverflowError`


# Why Recursion is Important

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Recursion/binarysearch1.png}
\end{center}

# Recursively Analyzing an Array

In the basic array analysis, we want to process each element of the array, similar to how we do that in a `for` loop.

* With recursion, unlike loops, we have the ability to do things like simultaneously start at both ends and work towards the center.
* We can start in the center and work towards one or the other ends
* Or, we could even process the array like a tree, as shown in the binary search example.
* Although some of this is possible without recursion, recursion makes it so much easier.

Given these choices we will focus simply on the case where we want to explore the array from one side to the other

# Recursively Analyzing an Array

* Typically our base cases include:

  * `array.length == 0`, check to ensure the array is not empty
  * `index == array.length - 1`, check to see if we have reached our target goal, here it is the end of the array

* Typically Recursive Array Methods need at a minimum the following parameters:

  * The array we are processing.
  * The current index where we are at in the array.

* The recursive part then increments or decrements the index value in order to reach a known base case.


# Recursion on Arrays

::: columns
:::: column
\vspace{-2em}
\begin{center}
\includegraphics[width=\textwidth]{images/Module2/Recursion/arrays.png}
\end{center}
::::
:::: column
\scriptsize
Here we are processing the array moving the indexes towards the green cells with "O"'s in them. The cells already processed have X's. The goal is such that the indexes finally point to green cells.
::::
:::

# Simple Array Processing Example

\footnotesize

**Problem -- Array11**: Given an array of integers, recursively compute the number of times the value 11 appears in the array, starting at index 0.

Examples:
```
array11({1, 2, 11}, 0) --> 1
array11({11, 11}, 0) --> 2
array11({1, 2, 3, 4}, 0) --> 0
```
\scriptsize

* What are the base cases?

  \pause

  * `index == nums.length - 1` will `if (nums[index] == 11) return 1; else return 0;`
  * `nums.length == 0` will `return 0`

* What is the recursive case:

  \pause

```java
    if (nums[index] == 11)
       return 1 + array11(nums, index + 1);
    else
       return array11(nums, index + 1);
```

# Array11 Implementation

## Array11

```java
 public int array11(int nums[], int index) {
     if (nums.length == 0 || index == nums.length)
         return 0;
     else if (nums[index == 11])
         return 1 + array11(nums, index + 1);
     else
         return array11(nums, index + 1);
 }
```

# Recursively Analyzing Strings

* Similar to how we process an array, working from one end of the string to the other (or from both ends to the center)
* Basically, the recursion works by calling the recursive method on an ever shrinking substring of the original string.
* We could also simply create a character array by calling `String.toCharacterArray()` and process that array recursively.
* Our typical bases cases, at a minimum, are:

  * `str == null`
  * `str.isEmpty()``
  * checking if the size is less than the minimum size of the substring you are checking for (i.e. `str.size() == 1`)

* The recursive case call typically looks like:
```java
  recursiveMethod(str.substring(1));
```

# Recursion on Strings

\begin{center}
\includegraphics[scale=1.0]{images/Module2/Recursion/strings.png}
\end{center}

# Simple String Processing Example

\footnotesize

**Problem -- CountX**: Given a string, compute recursively (no loops) the number of lower case "x" characters in the string

Examples:
```
countX("xxhixx") --> 4
countX("xhixhix") --> 3
countX("hi") --> 0
```

* What are the base cases?

  \pause

  * `str == null` will `return 0`
  * `str.isEmpty()` will `return 0`

* What is the recursive case?

  \pause

  * `if (str.charAt(0) == 'x')` will `return 1 + countX(str.substring(1))`
  * `else return countX(str.substring(1))`

# CountX Implementation

## CountX

```java
 public int countX(String str) {
    if (str == null || str.isEmpty())
        return 0;
    else if (str.charAt(0) == 'x')
        return 1 + countX(str.substring(1));
    else
        return countX(str.substring(1));
 }
```

# Binary Search Explained

\scriptsize

* We initially have a sorted array, called `nums`, (assuming sorted in ascending order (smallest to largest))
* We also assume we know the `target` value we want to look for.
* Finally, we have three indexes, the current `index` where we are looking and two indexes that bound our search area within the array: `begin` and `end`.
* We start out having `begin = 0`, and `end = nums.length - 1`, while current `index` is in the center of the array.
* We have three base cases:

  * `nums.length == 0`, an empty array, for which we `return -1`, since the target cannot be in the array
  * `nums[index] == target`, we found the target at the current index, `return index`
  * `begin >= end`, we did not find the target anywhere in the array, `return -1`

* There are two recursive cases:

  * `target < array[index]`, return a recursive call, setting the new current `index = (begin + (index - begin) / 2)`, set the `end = index - 1` and keep `begin` the same
  * `target > array[index]`, return a recursive call, setting the new current `index = (index + (end - index) / 2)`, set the `begin = index + 1` and keep `end` the same

* The next slide shows how this works and how the algorithm is implemented


# Binary Search Explained

\begin{center}
\includegraphics[scale=0.75]{images/Module2/Recursion/binarysearch2.png}
\end{center}

#

\vfill
\begin{center}
{\Huge Using Recursion}
\end{center}

# Example 1

Given a string, find all possible palindromic partitions of the string

```
Input: nitin
Output: n i t i n
        n iti n
        nitin

Input: geeks
Output: g e e k s
        g ee k s
```

# Example 2

Given an array of integers, print a sum triangle from it such that the first level has all array elements. From then, at each level number of elements is one less than the previous level and elements at the level is be the Sum of consecutive two elements in the previous level.

\scriptsize

```
Input : A = {1, 2, 3, 4, 5}
Output : [48]
         [20, 28]
         [8, 12, 16]
         [3, 5, 7, 9]
         [1, 2, 3, 4, 5]

Explanation :
Here,   [48]
        [20, 28] -->(20 + 28 = 48)
        [8, 12, 16] -->(8 + 12 = 20, 12 + 16 = 28)
        [3, 5, 7, 9] -->(3 + 5 = 8, 5 + 7 = 12, 7 + 9 = 16)
        [1, 2, 3, 4, 5] -->(1 + 2 = 3, 2 + 3 = 5, 3 + 4 = 7, 4 + 5 = 9)
```

# Example 2 -- Solution

\scriptsize
::: columns
:::: column
```java
// Java program to create Special triangle.
import java.util.*;
import java.lang.*;

public class ConstructTriangle
{
    // Function to generate Special Triangle.
    public static void printTriangle(int[] A)
    {
        // Base case
        if (A.length < 1)
            return;

        // Creating new array which contains the
        // Sum of consecutive elements in
        // the array passes as parameter.
        int[] temp = new int[A.length - 1];
        for (int i = 0; i < A.length - 1; i++)
        {
            int x = A[i] + A[i + 1];
            temp[i] = x;
        }
```
::::
:::: column
```java
      // Make a recursive call and pass
      // the newly created array
      printTriangle(temp);

      // Print current array in the end so
      // that smaller arrays are printed first
      System.out.println(Arrays.toString(A));
  }

  // Driver function
  public static void main(String[] args)
  {
      int[] A = { 1, 2, 3, 4, 5 };
      printTriangle(A);
  }
}
```
::::
:::

# Example 3

Given a singly linked list delete node at k-th position without using loop.

```
  Input : list = 9->8->3->5->2->1
            k = 4
  Output : 9->8->3->2->1

  Input  : list = 0->0->1->6->2->3
              k = 3
  Output : 0->0->6->2->3
```

# Example 4

::: columns
:::: column
**Problem**

\footnotesize

Given a set of characters generate all possible passwords from them. This means we should generate all possible permutations of words using the given characters, with repetitions and also up to a given length.

```
  Input : arr[] = {a, b},
            len = 2.
  Output :
  a b aa ab ba bb
```

::::
:::: column
\pause
**Solution**

\scriptsize
* Use recursion on the given character array.
* The idea is to pass all possible lengths and an empty string initially to a helper function.
* In the helper function we keep appending all the characters one by one to the current string and recur to fill the remaining string till the desired length is reached.
* It can be better visualized using the below recursion tree:

```
        (a, b)
         /   \
        a     b
       / \   / \
      aa  ab ba bb
```
::::
:::

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time
