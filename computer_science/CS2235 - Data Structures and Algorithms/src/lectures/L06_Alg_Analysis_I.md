---
author:
- Isaac Griffith
title: Algorithms Analysis I
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
\Huge Algorithms Analysis I

# Outcomes

At the end of Today's Lecture you will be able to:

* Describe the differences between mathematical and experimental analysis
* Understand the common types of functions used in algorithm analysis
* Undertake the analysis of an implemented algorithm
* Utilize Big-Oh notation to formally analyze an algorithm or algorithm implementation

#

\vfill
\begin{center}
{\Huge Algorithm Analysis}
\end{center}

# Algorithm Analysis

* The goal of algorithm analysis is to quantify the performance of algorithms.
* This can then be used to compare algorithms.
\pause
* What are some metrics we may want to use to characterize performance?
\pause
\begin{itemize}
  \item {\color<4>{Roarange}{Speed}}
  \item {\color<4>{Roarange}{Memory requirements (space)}}
  \item Power consumption
  \item Accuracy
  \item Dependence on external resources
\end{itemize}



# Algorithm Speed

What is algorithm "speed"?

\pause

1. Speed is the time it takes for an implementation of the algorithm to complete.
2. Speed is the number of operations that an algorithm needs to complete.

\vskip1em
\pause
What affects the number of operations an algorithm needs to complete? I.e., given an algorithm, what makes it go through more operations?

\pause
\vskip1em

\begin{center}
Input size. The larger the input, (usually)\\
the longer it will take to run.
\end{center}

# Types of Analysis

Experimental -- Implement the algorithm, run it on a machine, and time how long it takes.

# Example Experimental Analysis

::: columns
:::: {.column width="33%"}
\tiny
\begin{tabular}{|c|c|c|}
\hline
ArraySize & BinaryTime & LinearTime\tabularnewline
\hline
10 & 63 & 64\tabularnewline
\hline
110 & 95 & 105\tabularnewline
\hline
210 & 103 & 170\tabularnewline
\hline
310 & 99 & 243\tabularnewline
\hline
410 & 107 & 310\tabularnewline
\hline
510 & 106 & 377\tabularnewline
\hline
610 & 106 & 439\tabularnewline
\hline
710 & 111 & 507\tabularnewline
\hline
810 & 119 & 593\tabularnewline
\hline
910 & 118 & 628\tabularnewline
\hline
1010 & 122 & 718\tabularnewline
\hline
1110 & 122 & 775\tabularnewline
\hline
1210 & 120 & 869\tabularnewline
\hline
1310 & 122 & 918\tabularnewline
\hline
1410 & 122 & 963\tabularnewline
\hline
1510 & 130 & 1034\tabularnewline
\hline
1610 & 127 & 1089\tabularnewline
\hline
1710 & 130 & 1162\tabularnewline
\hline
1810 & 125 & 1240\tabularnewline
\hline
1910 & 119 & 1316\tabularnewline
\hline
2010 & 122 & 1387\tabularnewline
\hline
2110 & 133 & 1419\tabularnewline
\hline
\end{tabular}

::::
:::: {.column width="67%"}

\begin{center}
 \includegraphics[width=\textwidth]{images/Module2/BigO/experimental}
\end{center}
::::
:::

# Types of Analysis

Experimental -- Implement the algorithm, run it on a machine, and time how long it takes.

::: columns
:::: column

**Pros:**

* Realistic
* Easy if implemented

::::
:::: column
**Cons:**

* Needs to be implemented
* Only know what you test
* Comparison depends on setup
* Values may not be reliable

::::
:::

Mathematical -- Characterize the operations/input relationship, independent of any implementation.

::: columns
:::: column
**Pros:**

* Platform independent
* Defendable


::::
:::: column
**Cons:**

* Need to do math
* May not capture "normal" conditions

::::
:::


# Mathematical Analysis

How do we characterize the relationship between the input size and the number of operations executed?

\pause
\vskip1em
First, we identify a set of "primitive operations" that correspond to low-level instructions that take a fixed execution time

\pause
\vskip1em

E.g. comparing two numbers is done with several machine level operations, but the same number of operations are done, regardless of the numbers being compared*

# Primitive Operations

1. Variable assignment.
2. Following object reference (person1.\_\_\_\_\_).
3. Arithmetic.
4. Comparing two numbers.
5. Accessing a spot in an array via index.
6. Calling a method (doesn't count execution).
7. Returning from a method.

# Mathematical Analysis

How do we characterize the relationship between the input size and the number of operations executed?

\vskip1em
First, we identify a set of "primitive operations" that correspond to low-level instructions that take a fixed execution time

\vskip1em
E.g. comparing two numbers is done with several machine level operations, but the same number of operations are done, regardless of the numbers being compared*

\vskip1em
Second, we count the number of primitive operations executed by the algorithm in the **worst case**.

# Mathematical Analysis

Why worst case?

\pause

* Best case is usually pointless. Plenty of simple algorithms run great in their best case.

\vskip1em
\pause

* Average case would be useful information, but then we need to characterize what the input "usually" looks like (application specific).

\pause
\vskip1em

* Worst case gives us an upper bound guarantee and we don't need to know anything about how the algorithm will be used.


# Mathematical Analysis Example

Given linearSearch below, count up the number of primitive operations needed for the following input:\\
\begin{center}
$a \longrightarrow {10,\,15,\,23,\,31,\,74}$ val = 23
\end{center}

\vskip1em

```java
public static boolean linearSearch(int[] a, int val)
{
    for (int i = 0; i < a.length; i++) {
        if (array[i] == val) {
            return true;
        }
    }
    return false;
}
```

#

\vfill
\begin{center}
{\Huge Analysis Examples}
\end{center}

# Example

Can we count up the **worst case** number of primitive operations needed for **general input**?

Suppose the array has **n**-elements (the input is size **n**).

\vskip2em

```java
public static boolean linearSearch(int[] a, int val) {
    for (int i = 0; i < a.length; i++) {
        if (array[i] == val) {
            return true;
        }
    }
    return false;
}
```

# Worst Case LinearSearch

\footnotesize
```java
public static boolean linearSearch(int[] a, int val) {
    for (int i = 0; i < a.length; i++) {
        if (array[i] == val) {
            return true;
        }
    }
    return false;
}
```

\color{Roarange}
What is the worst case? \hfill Traverse the whole array

How many operations to prep the loop? \hfill 1

How many operations per loop iteration? \hfill 4

How many operations after final iteration? \hfill 2

How many operations total? \hfill $4*n + 3$

# Worst Case LinearSearch

```java
public static boolean linearSearch(int[] a, int val) {
    for (int i = 0; i < a.length; i++) {
        if (array[i] == val) {
            return true;
        }
    }
    return false;
}
```

\color{Roarange}
The function f(n) = 4 * n + 3 describes the relationship between the speed (number of operations) and input size (number of elements in the array).

\vskip1em
f(n) is called the growth function. It shows how the running time scales with input size.

# Common Growth Functions

1. Constant: $f(n) = c$ \hspace{1em} e.g. $f(n) = 4$
2. Logarithmic: $f(n) = log(n)$ (unless noted, base 2)
3. Linear: $f(n) = n$
4. n-log-n: $f(n) = n log(n)$
5. Quadratic: $f(n) = n^2$
6. Other Polynomial: $f(n) = a_0+a_1*n+a_2*n^2+\ldots+a_k*n^k$
7. Exponential: $f(n) = c^n$ \hskip1em e.g. $f(n) = 2^n$

# Example: Constant Function

* $f(n) = c$ where $c$ is some constant
* If an algorithm has a constant growth function (constant running time), then the running time is independent of the input size.

\vskip1em

```java
     public boolean isEmpty(int[] a) {
         return a.length == 0;
     }
```

\vskip1em

* Most algorithms of interest are made up of sections of constant time computations (like the iterations of the loop in linear search takes a constant 4 operations), but do not take constant time themselves.


# Comparison of Growth Rates

# Growth Function Comparison

Which would you rather have (for large n)?

* $f(n) = n$
* $g(n) = 100n$
* $h(n) = n^2$

\pause

What is a bigger deal, going from $h(n)$ to $g(n)$, or $f(n)$ to $g(n)$?

\pause

So it seems like as n gets really big, $h(n)$ dwarfs both $g(n)$ and $f(n)$ regardless of the constant factor in $g(n)$ (100 in this case).

# Growth Function Comparison
We want to group growth functions together if they grow more or less at the same rate.

\pause

The way we do that is by identifying the component of that function that contributes the most to growth.

\pause

In the previous example, the $n$ contributes more than the 100, since $f(n)$ and $g(n)$ look the same compared to other functions.

\pause

We group functions together using something called big-oh notation.

#

\vfill
\begin{center}
{\Huge Big-Oh Notation}
\end{center}

# Big-Oh Notation
Big-Oh notation will divide growth functions into groups by saying: "All functions in this group are easily bounded from above by function g(n)".

\pause

Formally, we use this definition:

> Given functions $f(n)$ and $g(n)$, we say that $f(n)$ is in $O(g(n))$ pronounced big-oh of $g(n)$) if there is a real constant $c > 0$ and an integer constant $n_0 \ge 1$ such that,

> $f(n) \le cg(n)$, for all $n \ge n_0$

# Big-Oh Notation

> Given functions $f(n)$ and $g(n)$, we say that $f(n)$ is in $O(g(n))$ pronounced big-oh of $g(n)$) if there is a real constant $c > 0$ and an integer constant $n_0 \ge 1$ such that,

> $f(n) \le cg(n)$, for all $n \ge n_0$

# Big-Oh Notation

> Given functions \textcolor{red}{$f(n)$} and \textcolor{blue}{$g(n)$}, we say that $f(n)$ is in $O(g(n))$ pronounced big-oh of $g(n)$) if there is a real constant $c > 0$ and an integer constant $n_0 \ge 1$ such that,

> $f(n) \le cg(n)$, for all $n \ge n_0$

# Big-Oh Notation

> Given functions \textcolor{red}{$f(n)$} and \textcolor{blue}{$g(n)$}, we say that $f(n)$ is in $O(g(n))$ pronounced big-oh of $g(n)$) if there is a real constant $c > 0$ and an integer constant \textcolor{purple}{$n_0$} $\ge 1$ such that,

> $f(n) \le$ \textcolor{GrowlingGray}{$cg(n)$}, for all $n \ge$ \textcolor{purple}{$n_0$}

# Simple Example 1
Is $f(n) = 100n$ in $O(g(n))$ for $g(n) = n$?

> i.e. is $f(n)$ in $O(n)$?

\pause

To show this, we need a $c > 0$ and an $n_0 \le 1$ such that:

\begin{align*}
f(n) &\le cg(n) \textrm{, for all } n \ge n_0
\end{align*}

# Simple Example 1
Is $f(n) = 100n$ in $O(g(n))$ for $g(n) = n$?

> i.e. is $f(n)$ in $O(n)$?

To show this, we need a $c > 0$ and an $n_0 \le 1$ such that:

\begin{align*}
f(n) &\le cg(n) \textrm{, for all } n \ge n_0\\
100n &\le cn \textrm{, for all } n \ge n_0
\end{align*}

# Simple Example 1
Is $f(n) = 100n$ in $O(g(n))$ for $g(n) = n$?

> i.e. is $f(n)$ in $O(n)$?

To show this, we need a $c > 0$ and an $n_0 \le 1$ such that:

\begin{align*}
f(n) &\le cg(n) \textrm{, for all } n \ge n_0\\
100n &\le cn \textrm{, for all } n \ge n_0\\
100n &\le 100n \textrm{, for all } n \ge 1
\end{align*}

**Thus $100n$ is in $O(n)$**

# Example 2
Is $f(n) = 2n^2 + 7n - 3$ in $O(n^2)$?

To show this, we need a $c > 0$ and an $n_0 \ge 1$ such that:
\pause
\begin{align*}
f(n) &\le cg(n) \textrm{, for all } n \ge n_0\\
2n^2 + 7n - 3 &\le cn^2 \textrm{, for all } n \ge n_0\\
2n^2 + 7n - 3 &\le 2n^2 + 7n \textrm{, for all } n \ge 1\\
&\le 2n^2 + 7n^2 \textrm{, for all } n \ge 1\\
&\le 9n^2* Understand the basic ideas of testing and their importance to practice
* Implement unit tests using the JUnit framework
* Understand how to select what to test and how to test it
\end{align*}
\pause
Thus, $2n^2 + 7n - 3 \le 9n^2$ for all $n \ge 1$

So, $2n^2 + 7n - 3$ is in $O(n^2)$

# Example 3
Is $f(n) = a_0 + a_1n + a_2n^2 + \ldots + a_kn^k$ in $O(n^k)$?

To show this, we need a $c > 0$ and an $n_0 \ge 1$ such that:
\pause
\begin{align*}
a_0 + a_1n + a_2n^2 + \ldots + a_kn^k &\le cn^k\\
a_0 + a_1n + a_2n^2 + \ldots + a_kn^k &\le \ldots ? \ldots \le cn^k
\end{align*}

Example 3
Is $f(n) = a_0 + a_1n + a_2n^2 + \ldots + a_kn^k$ in $O(n^k)$?

To show this, we need a $c > 0$ and an $n_0 \ge 1$ such that:
\begin{align*}
a_0 + a_1n + a_2n^2 + \ldots + a_kn^k &\le cn^k \textrm{, for all } n \ge n_0\\
a_0 + a_1n + a_2n^2 + \ldots + a_kn^k &\le \ldots ? \ldots \le cn^k\\
a_0 + a_1n + a_2n^2 + \ldots + a_kn^k &\le (|a_0| + |a_1| + |a_2| + \ldots + |a_k|)n^k \textrm{, for all } n \ge 1
\end{align*}
\pause
Thus, $f(n) \le cn^k$ for all $n \ge 1$ and $c = |a_0| + |a_1| + |a_2| + \ldots + |a_k|$

And, $f(n)$ is in $O(n^k)$

# Example 4
Is $f(n) = n^3$ in $O(n^2)$
\pause
We need a $c > 0$ and an $n_0 \ge 1$ such that:

\begin{align*}
f(n) &\le cg(n) \textrm{, for all } n \ge n_0\\
n^3 &\le cn^2 \textrm{, for all } n \ge n_0\\
n &\le c \textrm{, for all } n \ge n_0
\end{align*}

But, since $n$ goes to infinity as $n$ goes to infinity, we can't identify a constant $c$ that is always greater than $n$, as $n$ goes to infinity.

Thus, $n^3$ is not in $O(n^2)$

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Read Ch. 4
* Continue working on PA 01 and PP 01
* Review prior lectures
* Come to Class!
