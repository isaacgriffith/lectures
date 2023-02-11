---
author:
- Dr. Isaac Griffith
title: Advanced Counting
course: CS 1187
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Outline

The lecture is structured as follows:

::: columns
:::: {.column width=.7}
* Applications of Recurrence Relations
* Divide-and-Conquer Algorithms and Recurrence Relations
::::
:::: {.column width=.25}
\vfill
\vspace{7.25em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

# Recurrence Relations

* **Definition:** A \textit{recurrence relation} for a sequence $\{a_n\}$ is an equation that expresses $a_n$ in terms of one or more previous elements $a_0, \ldots a_{n-1}$ of the sequence, for all $n \geq n_0$

\pause
\vskip.5em

* **Definition:** A particular sequence (described non-recursively) is said to solve the given recurrence relation if it is consistent with the definition of the recurrence.

  - A given recurrence relation may have many solutions

\pause
\vskip.5em

* Such relations can be used for many things:
  * Study and solve counting problems beyond the basic counting techniques discussed previously
  * Modeling a wide variety of problems, including
    * Compound Interest
    * Counting rabbits on an island
    * Tower of Hanoi
  * Additionally, when algorithms such as Mergesort, we can use *divide-and-conquer recurrence relations* to evaluate the time complexity of this class of algorithms

# Rabbits and Fibonacci Numbers

* A young pair of rabbits (one of each sex) is placed on an island.
  * A pair of rabbits does not breed until they are 2 months old.
  * After they are 2 months old, each pair of rabbits produces another pair each month

+-----------+-----------------------+-----------------+-----------------+
| **Month** | **Reproducing Pairs** | **Young Pairs** | **Total Pairs** |
+:=========:+:=====================:+:===============:+:===============:+
| **1**     | 0                     | 1               | **1**           |
+-----------+-----------------------+-----------------+-----------------+
| **2**     | 0                     | 1               | **1**           |
+-----------+-----------------------+-----------------+-----------------+
| **3**     | 1                     | 1               | **2**           |
+-----------+-----------------------+-----------------+-----------------+
| **4**     | 1                     | 2               | **3**           |
+-----------+-----------------------+-----------------+-----------------+
| **5**     | 2                     | 3               | **5**           |
+-----------+-----------------------+-----------------+-----------------+
| **6**     | 3                     | 5               | **8**           |
+-----------+-----------------------+-----------------+-----------------+

\pause

* Find a recurrence for the number of pairs of rabbits on the island after $n$ months, assuming that no rabbits ever die.

# Rabbits and Fibonacci Numbers

* \sol Denote by $f_n$ the number of pairs of rabbits after $n$ months.
  - We can see that $f_n$, for $n = 1, 2, 3, \ldots$, are the terms of the Fibonacci sequence
  - After the first month the number of pairs is $f_1 = 1$
  - After the second month the number of pairs is $f_2 = 1$
  - To find the number of pairs after $n$ months simply add the number on the island from the previous month, $f_{n-1}$, and the number of newborn pairs, $f_{n - 2}
  - The sequence $\{f_n\}$ satisfies the following recurrence relation:

  $$f_n = f_{n-1} + f_{n-2},\,\,\,f_1 = 1\,\,f_2 = 1$$

# Tower of Hanoi

* **Problem:** Get all disks from peg 1 to peg 2
  * Only move 1 disk at a time
  * Never set a larger disk on top of a smaller one

\centering
\includegraphics[width=.5\textwidth]{images/recurrence/hanoi1.eps}

# Tower of Hanoi

\centering
\includegraphics[width=\textwidth]{images/recurrence/hanoi_seq.eps}

# Tower of Hanoi

* \sol Let $H_n =$ number of moves for a stack of $n$ disks

  \vskip.5em

  Optimal strategy:

  - Move top $n - 1$ disks to spare peg. ($H_{n-1}$ moves)
  - Move bottom disk. (1 move)
  - Move top $n - 1$ disks to bottom disk. ($H_{n-1}$ moves)

  \vskip.5em

  Note: $H_n = 2H_{n-1} + 1$

\centering
\includegraphics[width=.5\textwidth]{images/recurrence/hanoi10.eps}

# Tower of Hanoi

\sol Using the Iterative Method

  $$\begin{array}{rcl}
  H_n & = & 2h_{n - 1} + 1 \\
      & = & 2(2H_{n-2} + 1) + 1 = 2^2H_{n-2} + 2 + 1 \\
      & = & 2^2(2H_{n-3} + 1) + 2 + 1 = 2^3H_{n-3} + 2^2 + 2 + 1 \\
      &   & \vdots \\
      & = & 2^{n-1}H_1 + 2^{n-2} + \ldots + 2 + 1 \\
      & = & 2^{n-1} + 2^{n-2} + \ldots + 2 + 1\,\,(\text{since}\,\,H_1 = 1) \\
      & = & \underset{i = 0}{\overset{n - 1}{\sum}}2^i \\
      & = & 2^n - 1
  \end{array}$$

# Catalan Numbers

* \ex Find a recurrence relation for $C_n$, the number of ways to parenthesize the product of $n + 1$ numbers, $x_0 \cdot x_1 \cdot x_2 \cdot \cdots \cdot x_n$, to specify the order of multiplication.

  - For example: $C_3 = 5$ because there are 5 ways to parenthesize $x_0 \cdot x_1 \cdot x_2 \cdot x_3$ to determine the order of multiplication:

  $$\begin{array}{c}
  ((x_0 \cdot x_1)) \cdot x_2) \cdot x_3) \\
  x_0 \cdot ((x_1 \cdot x_2) \cdot x_3)
  \end{array}\,\,\,\begin{array}{c}
  (x_0 \cdot (x_1 \cdot x_2) \cdot x_3) \\
  x_0 \cdot (x_1 \cdot (x_2 \cdot x_3))
  \end{array}\,\,\,\begin{array}{c}
  (x_0 \cdot x_1) \cdot (x_2 \cdot x_3)
  \end{array}$$

# Catalan Numbers

* \sol
  * We note that however parentheses are inserted, one "$\cdot$" operator always remains outside all parentheses, the final operator
  * This operator occurs between two of the $n_ 1$ numbers, say $x_k$ and $x_{k+1}$
  * There are then $C_kC_{n-k-1}$ ways to insert parentheses
  * Because this final operator can fall between any two of the numbers it follows that

  $$C_n = C_0C_{n-1} + C_1C_{n-2} + \ldots + C_{n-2}C_1 + C_{n-1}C_0 = \overset{n-1}{\underset{k = 0}{\sum}}C_kC_{n-k-1}$$

\pause

* The sequence $\{C_n\}$ is the sequence of **Catalan Numbers**, where $C_n = C(2n,n)/(n + 1) \sim \frac{4^n}{n^{3/2}\sqrt{\pi}}$

# Dynamic Programming

* **Dynamic Programming:** an algorithmic paradigm used in solving optimization problems efficiently. It uses recursion to subdivide a problem into smaller or simpler overlapping subproblems

\pause
\vskip.5em

* Problems to which Dynamic Programming is applicable must have the following characteristics:
  * Problem is easily subdivided into simpler subproblems whose aggregate is a solution to the larger problem.
  * The subproblems overlap, that is the same subproblem will be seen more than once, and we can take advantage of storing the results of calculations for later use in similar subproblems.
  * The process of storing and reusing the results of a calculation is called **Memoization** (it is akin to looking up values in a table)

\pause
\vskip.5em

* This approach was introduced by Richard Bellman in the 1950s.

# Dynamic Programming

* \ex Suppose we have $n$ talks
  * where talk $j$ has the following properties
    * Begins at time $t_j$
    * Ends at time $e_j$
    * Attended by $w_j$ students
  * We want a schedule that maximizes the sum of $w_j$
  * We denote $T(j)$ as the maximum attendees for an optimal schedule from the first $j$ talks
    * $T(n)$ is then the maximal number of total attendees for an optimal schedule of $n$ talks

# Dynamic Programming

* Initial idea:
  1. Sort the talks in order of increasing end time, and renumber them such that:

     $$e_1 \leq e_2 \leq ... \leq e_n$$

     * Two talks are deemed *compatible* if they can be on the same schedule without overlapping.

  \pause
  \vskip.5em

  2. Define $p(j)$

     $$p(j) = \begin{cases}
     \text{largest } i & i < j\, \text{for which } e_i \leq s_j \\
     0 & \text{otherwise (no such talk exists)}
     \end{cases}$$

# Dynamic Programming

* Consider the following talks:

  ::: columns
  :::: {.column width=.05}
  ::::
  :::: {.column width=.45}

  1. 8 am -- 10 am
  2. 9 am -- 11 am
  3. 10:30 am -- 12 pm
  4. 9:30 am -- 1:00 pm
  5. 8:30 am -- 2:00 pm
  6. 11:00 am -- 2:00 pm
  7. 1:00 pm -- 2:00 pm

  \vskip.5em

  * Find $p(j)$ for $j = 1,2,\ldots,7$

  ::::
  :::: {.column width=.5}

  \centering

  \vfill
  \includegraphics[width=\textwidth]{images/recurrence/talks.eps}

  ::::
  :::

# Dynamic Programming

* To construct a dynamic programming algorithm, we first need a recurrence relation
  * Note if $j \leq n$, there are two possibilities for an optimal schedule of the first $j$ talks
    (i) talk j belongs to the optimal schedule
    (ii) it does not

\pause
\vskip.5em

* *Case (i):* talks $p(j) + 1, \ldots, j - 1$ do not belong to the schedule. The other talks in the schedule must comprise an optimal schedule of talks $1,2,\ldots,p(j)$.
  * Thus, we have $T(j) = w_j + T(p(j))$

\pause
\vskip.5em

* *Case (ii):* When talk $j$ does not belong to the optimal schedule, it follows that an optimal schedule from talks $1,2,\ldots,j$ is the same as one from talks $1,2,\ldots,j-1$.
  * Thus, we have $T(j) = T(j-1)$

# Dynamic Programming

* We combine the cases and get the following recurrence relation:

  $$T(j) = \max(w_j + T(p(j)), T(j - 1))$$

::: columns
:::: column

* \footnotesize \ex Assume $w_1 = w_2 = w_3 = 25$, $w_4 = w_5 = 50$, and $w_6 = w_7 = 75$

  \footnotesize
  \vspace{-2.5em}
  $$\begin{array}{rcl}
  T(1) & = & \max(25 + T(0), T(0)) = \max(25, 0) \\
       & = & 25\,\text{// store for later} \\
  T(2) & = & \max(25 + T(0), T(1)) = \max(25, 25) \\
       & = & 25\,\text{// retrieve T(1), store T(2)} \\
  T(3) & = & \max(25 + T(1), T(2)) = \max(50, 25) \\
       & = & 50\,\text{// retrieve T(1),T(2), store T(3)} \\
  T(4) & = & \max(50 + T(0), T(3)) = \max(50, 50) \\
       & = & 50\,\text{// retrieve T(3), store T(4)} \\
  T(5) & = & \max(50 + T(0), T(4)) = \max(50, 50) \\
       & = & 50\,\text{// retrieve T(4), store T(5)} \\
  T(6) & = & \max(75 + T(2), T(5)) = \max(75 + 25, 50) \\
       & = & 100\,\text{// retrieve T(2),T(5), store T(6)} \\
  T(7) & = & \max(75 + T(4), T(6)) = \max(75 + 50, 100) \\
       & = & 125\,\text{// retrieve T(4),T(6), store T(7)}
  \end{array}$$

  \vspace{-1.5em}
  \sol: 125 students will attend for the optimal schedule (1 -> 3 -> 7 or 4 -> 7)

::::
:::: column

\centering

\vfill
\includegraphics[width=\textwidth]{images/recurrence/talks.eps}

::::
:::

# Dynamic Programming

* We combine the cases and get the following recurrence relation:

  $$T(j) = \max(w_j + T(p(j)), T(j - 1))$$

\pause
\vskip.5em

* To make this efficient we store the value of $T(j)$ after we compute it.
  * In most dynamic programming this type of calculation tends to be highly complex and thus costly to execute
  * So we store it and when the same subproblem occurs again, rather than recompute it we simply look up the value. This process is called **memoization**

\pause
\vskip.5em

* In this case, without *memoization* the algorithm would have an exponential worst-case complexity.

# Dynamic Programming

The Algorithm for Maximum Attendees of a Optimal Schedule

\vskip.5em

::: columns
:::: {.column width=.7}

\begin{algorithmic}
\Procedure{maxAttendees}{$s_1,s_2,\ldots,s_n$: start times, $e_1,e_2,\ldots,e_n$: end times, $w_1, w_2, \ldots, w_n$: number of attendees}
  \State \Comment{sort talks by end times and relabel so that $e_1 \leq e_2 \leq \ldots \leq e_n$}
  \For{$j \coloneqq 1$ \textbf{to} $n$}
    \If{no job $i$ with $i < j$ is compatible with job $i$}
      \State $p(j) \coloneqq 0$
    \Else $\,p(j) \coloneqq \max$ \Comment{$i$ --- $i < j$ and job $i$ is compatible with job $j$}
    \EndIf
    \State $T(0) \coloneqq 0$
  \EndFor
  \For{$j \coloneqq 1$ \textbf{to} $n$}
    \State $T(j) \coloneqq \max(w_j + T(p(j)), T(j - 1))$
  \EndFor
  \State \Return $T(n)$
\EndProcedure
\end{algorithmic}

::::
:::: {.column width=.3}

::::
:::

<!--#

\ts{Solving Recurrence Relations}

# Solving Recurrences

* **Definition:** A *linear homogeneous recurrence of degree $k$ with constant coefficients* is a recurrence of the form

  $$a_n = c_1a_{n-1} + \ldots + c_ka_{n - k}$$

  where the $c_2,c_2,\ldots,c_k$ are real numbers, and $c_k \ne 0$.

  - such a recurrence is *linear* since the right-hand side is a sum of previous terms of the sequence each multiplied by a function of $n$
  - it is *homogenous* because no terms occur that are not multiples of the $a_j$s
  - the coefficients of the terms are all *constants*
  - the degree is $k$


# Solving LiHoReCoCos

* Basic idea: Look for solutions of the form $a_n = r^a$, where $r$ is a constant
* Bring $a_n = r^n$ back to the recursive equation

  $$\begin{array}{c}
  r^n = c_1r^{n-1} + \cdots + c_kr^{n - k}, \\
  \text{i.e.,}\,\, r^{n-k}(r^k - c_1r^{k - 1} - \cdots - c_k) = 0.
  \end{array}$$

* The characteristic equation:

  $$r^k - c_1r^{k-1} - \cdots - c_k = 0$$

* The solutions (characteristic roots) can yield an explicit formula for the sequence

# Solving 2-LiHoReCoCos

* Consider an arbitrary 2-LiHoReCoCo

  $$a_n = c_1a^n-1 + c_2a^{n-2}$$

* It has the characteristic equation (C.E.):

  $$r^2 - c_1r - c_2 = 0$$

* **Theorem:** Let $c_1$ and $c_2$ be real numbers with $c_2 \ne 0$. Suppose that $r^2 - c_1r - c_2 = 0$ has only one root $r_0$. A sequence $\{a_n\}$ is a solution of the recurrence relation $a_n = c_1a_{n-1} + c_2a_{n-2}$ iff $a_n = \alpha_1r_0^n + \lapha_2nr_0^n$, for $n = 0, 1, 2, \ldots$, where $\alpha_1$ and $\alpha_2$ are constants.

# Solving LiHoReCoCos

\ex Solve the recurrence $a_n = a_{n-1} + 2a_{n-2}$ given the initial conditions $a_0 = 2$ and $a_1 = 7$

\sol

* Here $c_1 = 1$ and $c_2 = 2$. Then, the CE is $r^2 - r - 2 = 0$. We can get $r = 2$ or $r = -1$. So, assume

  $$a_n = \alpha_12^n + \alpha_2(-1)^n$$

* To find $\alpha_1$ and $\alpha_2$, solve the equations by the initial conditions $a_0 = 2$ and $a_1 = 7$:

  $$\begin{array}{rcl}
  a_0 & = & 2 = \alpha_1 2^0 + \alpha_2(-1)^0 \\
  a_1 & = & 7 = \alpha_1 2^1 + \alpha_2(-1)^1
  \end{array}\Rightarrow\begin{array}{rcl}
  \alpha_1 + \alpha_2 & = & 2 \\
  2\alpha_1 - \alpha_2 & = & 7
  \end{array}$$

  We can get $\alpha_1 = 3$ and $\alpha_2 = -1$, So, $a_n = 3 \cdot 2^n - (-1)^n$

# Solving LiHoReCoCos

\ex Solve the recurrence relation $a_n = 7a_{n - 1} - 10 a_{n-2}$ for $n \geq 2$ with $a_0 = 2$ and $a_1 = 1$ by characteristic equations.

\sol Let $a_n = r^n$

* Then, the C.E. is $r^2 - 7r + 10 = 0$
* There are two distinguishable roots $r = 2$ and $r = 5$. So, the two basic solutions are $2^n$ and $5^n$
* Assume $a_n = \alpha_1 2^n + \alpha_2 5^n$, we have $2\alpha_1 + 5\alpha_2 = 1$ Thus, we can get $\alpha_1 = 3$ and $\alpha_2 = -1$
* So, $a_n = 3 \cdot 2^n - 5$

# Solving LiHoReCoCos - General Case

* **Theorem:** Let $c_1,c_2,\ldots,c_k$ be real numbers. Suppose that the characteristic equation

  $$r^k - c_1r^{k-1} - \cdots - c_k = 0$$

  has $k$ distinct roots $r_1,r_2,\ldots, r_k$. Then a sequence $\{a_n\}$ is a solution of the recurrence relation

  $$a_n = c_1a_{n-1} + c_2a_{n - 2} + \cdots + c_ka_{n-k}$$

  iff

  $$a_n = \alpha_1 r_1^n + \alpha_2 r_2^n + \cdots + \alpha_k r_k^n$$

  for $n = 0, 1, 2, \ldots$, where $\alpha_1, \alpha_2, \ldots, \alpha_k$ are constants

# Example

# Solving LiHoReCoCos

* **Theorem:** Let c_1,c_2,\ldots,c_k$ be real numbers, Suppose that the characteristic equation

  $$r^k - c_1r^{k-1} - \cdots - c_k = 0$$

  has $t$ distinct roots $r_1,r_2,\ldots,r_t$ with multiplicities $m_1,m_2,\ldots,m_t$, respectively, so that $m_i \geq 1$ for $i = 1, 2, \ldots, t$ and $m_1 + m_2 + \ldots + m_t = k$. Then a sequence $\{a_n\}$ is a solution of the recurrence relation

  $$a_n = c_1a_{n-1} + c_2a_{n-2} + \cdots + c_ka_{n-k}$$

  iff

  $$\begin{array}{rcl}
  a_n & = & (\alpha_{1,0} + \alpha_{1,1}n + \cdots + \alpha_{1,m_{1}-1}n^{m_1-1}r^n_1) \\
      &   & + (\alpha_{2,0} + \alpha_{2,1}n + \cdots + \alpha_{2,m_{2}-1}n^{m_2-1}r^n_2) \\
      &   & + \cdots + (\alpha_{t,0} + \alpha_{t,1}n + \cdots + \alpha_{t,m_{t}-1}n^{m_t-1}r^n_t)
  \end{array}$$

  for $n = 0, 1, 2, \ldots$, where $a_{i,j}$ are constants for $1 \leq i \leq t$ and $0 \leq j \leq m_i - 1$

# Example

# Solving LiNoReCoCos

* We can also solve certain classes of *linear nonhomogeneous recurrence relations with constant coefficients.
* Such recurrence relations are of the following form:

  $$a_n = c_1a_{n-1} + c_2a_{n-2} + \cdots + c_ka_{n-k} + F(n)$$

  - where:
    * $c_1,c_2,\ldots,c_k$ are real numbers
    * $F(n)$ is a function not identically zero depending on $n$.

  - The *associated homogeneous recurrence relation* plays an important role in the solution of the nonhomogeneous recurrence relation, it forms the part:

    $$a_n = c_1a_{n-1} + c_2a_{n-2} + \cdots + c_ka_{n-k}$$

* \ex Each of the recurrence relations $a_n = a_{n-1} + 2^n$, $a_n = a_{n-1} + a_{n-2} + n^2 + n + 1$, $a_n = 3a_{n-1} + n3^n$, and $a_n = a_{n-1} + a_{n-2} + a_{n-3} + n!$ is a linear nonhomogeneous recurrence relation with constant coefficients. The associated linear homogeneous recurrence relations are $a_n = a_{n-1}$, $a_n = a_{n-1} + a_{n-2}$, $a_n = 3a_{n-1}$, and $a_n = a_{n-1} + a_{n-2} + a_{n-3}$, respectively

# Solving LiNoReCoCos

* **Theorem:** If $\{a^{(p)}_n\}$ is a particular solution of the nonhomogeneous linear recurrence relation with constant coefficients

  $$a_n = c_1a_{n-1} + c_2a_{n-2} + \cdots + c_ka_{n-k} + F(n)$$

  then every solution is of the form $\{a^{(p)}_n + a^{(h)}_n\}$, where $\{a^{(h)}_n\}$ is a solution of the associated homogeneous recurrence relation

  $$a_n = c_1a_{n-1} + c_2a_{n-2} + \cdots + c_ka_{n-k}$$
-->

#

\ts{Divide-and-Conquer Algorithms}

# Introduction

* Many types of problems are solvable by reducing a problem of size $n$ into some number of $a$ independent subproblems, each of size $\leq \ceil*{\frac{n}{b}}$, where $a \geq 1$ and $b > 1$

\pause
\vskip.5em

* The time complexity to solve such problems is given by a recurrence relation

  $$f(n) = af\left(\ceil*{\frac{n}{b}}\right) + g(n)$$

\pause
\vskip.5em

* Such a recurrence is called a **divide-and-conquer recurrence relation**

# Basic Analysis

* **Theorem 1:** Let $f$ be an increasing function that satisfies the recurrence relation

  $$f(n) = af(n/b) + c$$

  whenever $n$ is divisible by $b$, where $a \geq 1$, $b$, is an integer greater than 1, and $c$ is a positive real number. Then

  $$f(n) = \begin{cases}
  O(n^{\log_b a}) & \text{if }a > 1\\
  O(\log n) & \text{if } a = 1
  \end{cases}$$

  Furthermore, when $n = b^k$ and $a \ne 1$, where $k$ is a positive integer,

  $$f(n) = C_1n^{\log_b a} + C_2$$

  where $C_1 = f(1) + c/(a - 1)$ and $C_2 = -c / (a - 1)$

# Basic Analysis Example

\ex Let $f(n) = 5f(n/2) + 3$ and $f(1) = 7$. Find $f(2^k)$, where $k$ is a positive integer. Also, estimate $f(n)$ if $f$ is an increasing function.

\pause
\vskip.5em

\sol With $a = 5$, $b = 2$, and $c = 3$, we see that if $n = 2^k$, then

  $$\begin{array}{rcl}
  f(n) & = & a^k\left[f(1) + c/(a - 1)\right] + \left[-c / (a - 1)\right] \\
       & = & 5^k\left[7 + (3 / 4)\right] - 3 / 4 \\
       & = & 5^k\left(31 / 4\right) - 3 / 4
  \end{array}$$

  By Theorem 1, we know that $f(n)$ is $O(n^{\log_b a}) = O(n^{\log 5})$

# Exercises

\exercise Give the big-O estimate for $f(n) = f(n/2) + 1$ if $f$ is an increasing function

\pause

* \sol By Theorem 1, $f(n)$ is $O(\log n)$

\pause
\vskip2em

\exercise Give the big-O estimate for $f(n) = 2f(n/3) + 4 if $f$ is an increasing function

\pause

* \sol By Theorem 1, $f(n)$ is $O(n^{\log_3 2})$

# The Master Theorem

* **The Master Theorem:** Consider a function $f(n)$ that, for all $n = b^k$, for all $n = b^k$ for all $k \in \mathbb{Z}^+$, satisfies the recurrence relating

  $$f(n) = af\left(\frac{n}{b}\right) + cn^d$$

  with $a \geq 1$, integer $b > 1$, real $c > 0,\,d \geq 0$. Then.

  $$f(n) = \begin{cases}
  O(n^{d}) & \text{if }a<b^{d}\\
  O(n^{d}\log n) & \text{if }a=b^{d}\\
  O(n^{\log_{b}a}) & \text{if }a>b^{d}
  \end{cases}$$

# Binary Search

::: columns
:::: column
**Algorithm:**

\small


\begin{algorithmic}
\Procedure{binSearch}{$A,x$}
  \State $i \coloneqq 1$
  \State $j \coloneqq n$
  \While{$i < j$}
    \State $m \coloneqq \floor*{(i + j) / 2}$
    \If{$x > A_m$} $i \coloneqq m + 1$
    \Else $\,\,j \coloneqq m$
    \EndIf
  \EndWhile
  \If{$x = A_j$} $\mathit{location} \coloneqq i$
  \Else $\,\,\mathit{location} \coloneqq 0$
  \EndIf
  \State \Return $\mathit{location}$
\EndProcedure
\end{algorithmic}

\centering

\vskip1em

\includegraphics[width=.4\textwidth]{images/recurrence/binsearch.eps}

\pause

::::
:::: column

\small

**Recurrence Relation:**

* \small Break list into 1 sub-problem (smaller list) (so $a = 1$) of size $\leq \ceil*{\frac{n}{2}}$ (so $b = 2$) or simply $n / 2$ when $n$ is even.
* \small Additionally, two comparison are needed to implement this reduction ($g(n) = 2$)
  * \footnotesize One to determine which half of the list and one to determine if any terms of the list remain

  $$f(n) = f\left(\ceil*{\frac{n}{2}}\right) + 2$$

\pause

**Complexity** (from Theorem 1):

* \small Since the recurrence relation is $f(n) = f(n/2) + 2$ when $n$ is even
* \small $f$ is then the number of comparisons required to perform a binary search on a sequence of size $n$
* \small By Theorem 1, the time complexity of $f(n)$ is $O(\log n)$

::::
:::

# Finding Min/Max of a Sequence

::: columns
:::: column
**Algorithm:**

\vskip.5em
\centering
\includegraphics[width=.825\textwidth]{images/recurrence/minmax.eps}

\pause

::::
:::: column

\small

**Recurrence Relation:**

* \small Break the sequence into two subproblems (so $a = 2$) of size $\leq \ceil*{\frac{n}{2}}$ (so $b = 2$)

* \small We then require two comparisons
  * \footnotesize One to compare the maxima
  * \footnotesize One to compare the minima

  $$f(n) = 2f(n/2) + 2$$

pause

**Complexity** (from Master Theorem):

* \small Since the recurrence relation is $f(n) = 2f(n/2) + 2$ when $n$ is even
* \small $f$ is the number of comparisons required to find the minima and maxima of a sequence of size $n$
* \small By Theorem 1, the time complexity of $f(n)$ is $O(n^{\log 2}) = O(n)$

::::
:::

# Fast Multiplication of Integers

::: columns
:::: column
**Algorithm:**

\small


* \small Suppose $a$ and $b$ are integers with binary expansions of length $2n$

  $$\begin{array}{rcl}
  a & = & (a_{2n-1}a_{2n-2}\cdots a_1a_0)_2 \\
  b & = & (b_{2n-1}b_{2n-2}\cdots b_1b_0)_2 \\
  \end{array}$$

* \small Let $a = 2^nA_1 + A_0$ and $b = 2^nB_1 + B_0$, where

  $$\begin{array}{rcl}
  A_1 & = & (a_{2n- 1}\cdots a_{n+1}b{n})_2 \\
  A_0 & = & (a_{n-1}\cdots a_1a_0)_2 \\
  B_1 & = & (b_{2n- 1}\cdots b_{n+1}b{n})_2 \\
  B_0 & = & (b_{n-1}\cdots b_1b_0)_2
  \end{array}$$

* \small We can then rewrite $ab$ as

  $$ab = (2^{2n} + 2^n)A_1B_1 + 2^n(A_1 - A_0)(B_0 - B_1) + (2^n + 1)A_0B_0$$

\pause

::::
:::: column
\small

**Recurrence Relation:**

* \small We split the multiplication of $2n$-bit integers into 3 multiplications ($a = 3$) of $n$-bit integers ($b = 2$), plus shifts and additions (a constant $C$)

  $$f(n) = 3f(n/2) + Cn$$

\pause

**Complexity** (from Master Theorem):

* \small Since the recurrence relation is $f(n) = 3f(n/2) + Cn$, when $n$ is even
* \small Where $f(n)$ is the number of bit operations needed to multiply to $n$-bit integers
* \small By the Master Theorem, $f(n)$ is $O(n^{\log 3})$ which is considerably faster than $O(n^2)$ of the conventional algorithm
::::
:::

# Mergesort

::: columns
:::: {.column width=.55}
**Algorithm:**

\small
\vskip.5em

\begin{algorithmic}
\Procedure{mSort}{$L$}
  \If{$n > 1$}
    \State $m \coloneqq \floor*{n / 2}$
    \State $L1 \gets L_1,L_2,\ldots,L_m$
    \State $L2 \coloneqq L_{m+1},L_{m+2},\ldots,L_n$
    \State $L$ $\coloneqq$ \Call{merge}{\textsc{mSort}($L1$), \textsc{mSort}($L2$)}
  \EndIf
\EndProcedure
\end{algorithmic}

\vskip1em

\begin{algorithmic}
\Procedure{merge}{$L1,L2$}
  \State $L \coloneqq [\,\,]$
  \While{$L1$ and $L2$ are both nonempty}
    \State remove smaller of $L1_1$ and $L2_1$, add to $L$
  \EndWhile
  \If{one list is empty}
    \State remove all elements of the other list and append to $L$
  \EndIf
  \State \Return $L$
\EndProcedure
\end{algorithmic}

\pause

::::
:::: {.column width=.45}

\small

**Recurrence Relation:**

* \small Break list of length $n$ into 2 sublists ($a = 2$), each of size $\leq \ceil*{\frac{n}{2}}$ (so $b = 2$), then using $< n$ comparisons merge them. So

  $$M(n) = 2M\left(\ceil*{\frac{n}{2}}\right) + n$$

\pause

**Complexity** (from Master Theorem):

* \small Since the recurrence relation is $M(n) = 2M(n/2) + n$, when n is even
* \small Where $M(n)$ is the number of comparisons needed to sort $n$ elements in a list
* \small By the Master Theorem, we find that $M(n)$ is $O(n\log n)$

::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
