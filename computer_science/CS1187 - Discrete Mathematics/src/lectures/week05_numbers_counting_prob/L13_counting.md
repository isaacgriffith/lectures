---
author:
- Dr. Isaac Griffith
title: Counting
course: CS 1187
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Inspiration

\vfill
> "Many of the things you can count, don't count. Many of the things you can't count, really count." -- Albert Einstein

# Outline

The lecture is structured as follows:

::: columns
:::: {.column width=.7}
* Basics of Counting
* The Pigeonhole Principle
* Binomial Coefficients and their Identities
* Generalized Permutations and Combinations
::::
:::: {.column width=.25}
\vfill
\vspace{7.25em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\ts{Basics of Counting}

# Introduction

* Counting problems arise throughout CS and Math, some examples include
  * What is the number of successful outcomes of a set of experiments?
  * What is the count of the number of operations in an algorithm?
  * How many 6, 7, or 8 character passwords can be generated?

# The Product Rule

* **The Product Rule:** Suppose that a procedure can be broken down into a sequence of two tasks. If there are $n_1$ ways to do task 1 and for each of these ways of doing task 1 there are $n_2$ of doing task 2, then there are $n_1 n_2$ ways to do the procedure.

\pause
\vskip.5em

* \ex The chairs of an auditorium are to be labeled with an uppercase English letter followed by a positive integer not exceeding 100. What is the largest number of chairs that can be labeled differently?

  \pause
  \vskip.5em

  \sol $26 \cdot 100 = 2600$ different ways

\pause
\vskip.5em

* \ex There are 32 computers in a data center each with 24 ports. How many different ports are in the data center?

  \pause
  \vskip.5em

  \sol $32 \cdot 24 = 768$ ports

# The Product Rule

* We can extend the *product rule* for a procedure carried out by performing tasks $T_1,T_2,\ldots,T_m$ in sequence.
  * If each task $T_i$, $i = 1,2,\ldots,n$ can be done in $n_i$ ways, regardless of how previous tasks were done
  * Then, there are $n_1 \cdot n_2 \cdot \ldots \cdot n_m$ ways to carry out the procedure

\vskip.5em

* \ex How many different bit strings of length 7 are there?

  \vskip.5em

  \sol each bit can be chosen in one of two ways: 0 or 1

  $\therefore 2^7 = 128$ different bit strings of length 7

\vskip.5em

* \ex How many license plates contain a sequence of 3 uppercase letters followed by 3 digits (no sequence of letters are prohibited)

  \vskip.5em

  \sol $26 \cdot 26 \cdot 26 \cdot 10 \cdot 10 \cdot 10 = 17,576,000$ license plates

# Algorithm Example

* What is the value of $k$ after the following code has been executed? (where $n_1, n_2, \ldots, n_m$ are positive integers)

\vskip.5em

::: columns
:::: {.column width=.05}
::::
:::: {.column width=.3}

\begin{algorithmic}
\State $k \coloneqq 0$
\For{$i_1 \coloneqq 1$ \textbf{to} $n_1$}
  \For{$i_2 \coloneqq 1$ \textbf{to} $n_2$}
    \State $\vdots$
    \For{$i_m \coloneqq 1$ \textbf{to} $n_m$}
      \State $k \coloneqq k + 1$
    \EndFor
  \EndFor
\EndFor
\end{algorithmic}

::::
:::: {.column width=.65}

\pause

* Let $T_i$ be the task of traversing the $i^{th}$ loop.

\vskip.25em

* The number of times each loop is traversed is the number of ways to do task $T_1, T_2, \ldots, T_m$.

\vskip.25em

* The number of ways to carry out task $T_j$, $j = 1, 2, \ldots, m$, is $n_j$

\vskip.25em

* Since the $j^{th}$ loop is traversed once for each integer $i$ with $1 \leq i_j \leq n_j$

\pause

$$\text{\sol}\,k = n_1 n_2 \ldots n_m$$

::::
:::

# The Sum Rule

* **The Sum Rule:** If a task can be done either in one of $n_1$ ways or in one of $n_2$ ways, where none of the set of $n_1$ ways is the same as any of the sets of $n_2$ ways, then there are $n_1 + n_2$ ways to do the task

\pause
\vskip.5em

* \ex Suppose either a member of the CS faculty or a CS student is chosen as a representative to a university committee. How many choices are there for this representative if there are 37 faculty members and 83 CS majors and no individual is both a student and a faculty member?

  \pause
  \vskip.5em

  \sol $37 + 83 = 120$ ways to pick

# The Sum Rule

* We can extend the *sum rule* to more than two tasks.
  * Suppose a task can be done in one of $n_1$ ways, in one of $n_2$ ways, $\ldots$, or in one of $n_m$ ways
  * Where none of the set of $n_i$ ways is the same as any of the set of $n_j$ ways for all pairs $i$ and $j$ with $1 \leq i < j \leq m$
  * Then the number of ways to do the task is $n_1 + n_2 + \ldots + n_m$

\pause
\vskip.5em

* \ex A student can choose a computer project from one of three lists. The three lists contain 23, 15, and 19 possible projects, respectively. No project is on more than one list. How many possible projects are there to choose from?

  \pause
  \vskip.5em

  \sol $23 + 15 + 19 = 57$ possible ways to choose a project

# Algorithm Example

* What is the value of $k$ after the following code is executed? (where $n_1, n_2, \ldots, n_m$ are positive integers)

::: columns
:::: {.column width=.05}
::::
:::: {.column width=.225}

\begin{algorithmic}
\State $k \coloneqq 0$
\For{$i_1 \coloneqq 1$ \textbf{to} $n_1$}
  \State $k \coloneqq k + 1$
\EndFor
\For{$i_2 \coloneqq 1$ \textbf{to} $n_2$}
  \State $k \coloneqq k + 1$
\EndFor
\State $\vdots$
\For{$i_m \coloneqq 1$ \textbf{to} $n_m$}
  \State $k \coloneqq k + 1$
\EndFor
\end{algorithmic}

::::
:::: {.column width=.725}

\pause

* The initial value of $k$ is 0

\vskip.25em

* There are $m$ loops

\vskip.25em

* Each time a loop is traversed $k$ is incremented by 1

\vskip.25em

* Thus, the value of $k$ is equal to the number of times a loop is traversed

\vskip.25em

* There are $n_i$ ways to traverse the $i^{th}$ loop

\vskip.25em

* We only traverse one loop at a time, thus

\pause

$$\text{\sol}\,\,k = n_1 + n_2 + \ldots + n_m$$

::::
:::

# The Subtraction Rule

* Suppose that a task can be don in one of two ways, but some of the ways to do it are common to both ways
  * Thus, we cannot simply use the sum rule as it will result in an over count due to counting the common ways twice

\vskip.5em

* **The Subtraction Rule:** If a task can be done in either $n_1$ or $n_2$ ways, then the number of ways to do the task is $n_1 + n_2$ minus the number of ways to do that task that are common to both ways.
  * Also known as the *Principle of Inclusion-Exclusion* (for two sets)

\vskip.5em

* Akin to finding the size of the union of two sets:

  $$|\mathbf{A_1} \cup \mathbf{A_2}| = |\mathbf{A_1}| + |\mathbf{A_2}| - |\mathbf{A_1} \cap \mathbf{A_2}|$$

# The Subtraction Rule

* \ex How many bit strings of length eight either start with a 1 or end with 00?

\pause

::: columns
:::: column

\centering
\includegraphics[width=.65\textwidth]{images/counting/bitstrings.eps}

::::
:::: column

\sol

- Number of length 8 bit strings that start with a $1 = 2^7 = 128$
- Number of length 8 bit strings that end with $00 = 2^6 = 64$
- Number of length 8 bit strings that start with a 1 and end with $00 = 2^5 = 32$
- Total number of length 8 bit strings that either start with 1 or end with 00 $= 2^7 + 2^6 - 2^5 = 128 + 64 - 32 = 160$

::::
:::

# The Division Rule

* **The Division Rule:** There are $n / d$ ways to do a task if it can be done using a procedure that can be carried out in $n$ ways, and for every way $w$, exactly $d$ of the $n$ ways correspond to way $w$.
  * In terms of sets: if the finite set $\mathbf{A}$ is the union of $n$ pairwise disjoint subsets each with $d$ elements, then $n = \frac{|\mathbf{A}|}{d}$.

\vskip.5em

* This rule is useful when it appears a task can be done in $n$ different ways, but it turns out for each way of doing the task, there are $d$ equivalent ways of doing it.

# The Division Rule

* \ex\ *counting cows.* Suppose an automated system has been developed to count the legs of cows in a pasture. The system finds that there are 572 legs in a pasture. How many cows are in the pasture (assuming each has 4 legs, and there are no other animals)?

\pause
\vskip-.5em

$$\text{\sol}\,\,572 / 4 = 143\,\,\text{cows}$$

\pause

* \ex How many different ways are there to seat 4 people around a circular table, where two seatings are consider the same when each person has the same left neighbor and the same right neighbor?

  \pause

  $$4! = 24\,\,\text{possible arrangements}$$

  \pause

  however each choice for seat 1 leads to the same arrangement when we consider left and right neighbors. Thus, there are actually

  $$\text{\sol}\,\,24 / 4 = 6\,\,\text{different arrangements}$$

#

\ts{Pigeonhole Principle}

# Introduction

* **The Pigeonhole Principle:** If $k$ is a positive integer and $k + 1$ or more objects are placed into $k$ boxes, there is at least one box containing two or more of the objects.
  * Also called the *Dirichlet drawer principle*

\centering
\includegraphics[width=.65\textwidth]{images/counting/pigeonholes.eps}

# Introduction

* **Corollary:** a function $f$ from a set with $k + 1$ or more elements to a set with $k$ elements is not one-to-one

\vskip.5em

* Examples:
  * Among any group of 367 people there must be at least 2 with the same birthday, because there are only 366 possible birthdays
  * In any group of 27 English words, there must be at least two that begin with the same letter, because there are 26 letters in the english alphabet.
  * How many students must be in a class to guarantee at least 2 students receive the same score on the final exam, if the exam is graded on a scale from 0 to 100 points? *102 students*

# Generalized Pigeonhole Principle

* The pigeonhole principle is useful, but even more can be said when the number of objects exceeds a multiple of the number of boxes.

\pause
\vskip.5em

* **The Generalized Pigeonhole Principle:** If $N$ objects are placed into $k$ boxes, then there is at least one box containing at least $\ceil*{N / k}$ objects.

\pause
\vskip.5em

* \exs
  * Among 100 people there are at least $\ceil*{100 / 12} = 9$ who were born in the same month
  * What is the minimum number of students required in a Discrete Math class to be sure that at least 6 will receive the same grade, if there are 5 possible grades: A, B, C, D, and F? $\ceil*{N / 5} = 6$, $N = 5 \cdot 5 + 1 = 26$

# Generalized Pigeonhole Principle

* \ex How many cards must be selected from a standard deck of 52 cards to guarantee that at least 3 cards of the same suit are selected?

  \pause
  \vskip1em

  \sol

  * 4 boxes: one per suit
  * If $N$ cards selected to guarantee one box contains $\ceil*{N / 4}$ cards
  * If $\ceil*{N / 4} \geq 3$, thus find the smallest integer $N$ that makes this true

    \vskip1em

    $\begin{array}{rcl}
    \ceil*{N / 4} & \geq & 3 \\
    N & = & 2 \cdot 4 + 1 = 9 \\
    \ceil*{9 / 4} & \geq & 3 \\
    \ceil*{2.25} \geq 3 & = & 3 \geq 3
    \end{array}$

#

\ts{Permutations and Combinations}

# Introduction

* Many counting problems can be solved by:
  * Finding the number of ways to arrange the distinct element of a set of a particular size, *when order matters*
  * Finding the number of ways to select a particular number of items form a set of a particular size, *when order does not matter*

# Permutations

* **Permutation:** an ordered arrangement of the objects of a set

\pause
\vskip.5em

* **r-permutation:** an ordered arrangement of $r$ elements of a set

\pause
\vskip.5em

* **Theorem:** If $n$ is a positive integer and $r$ is an integer with $1 \leq r \leq n$, then there are

  $$P(n, r) = n (n - 1) (n - 2) \cdots (n - r + 1) = \frac{n!}{(n - r)!}$$

  r-permutations of a set with $n$ distinct elements

\pause
\vskip.5em

* \ex Let $\mathbf{S} = \{1,2,3\}$. The ordered arrangement 3, 1, 2 is a permutations of $\mathbf{S}$. The ordered arrangement 3, 2 is a 2-permutation of $\mathbf{S}$

# Permutations

* \ex How many ways are there to select a first-prize winner, a second-prize winner, and a third-prize winner from 100 different people who have entered a contest.

  That is how many 3-permutations of a set of 100 elements are there?

  \pause

  $$\text{\sol}\,\,P(100, 3) = \frac{100!}{(100 - 3)!} = \frac{100!}{97!} = 100 \cdot 99 \cdot 98 = 970,200$$

\pause
\vskip.5em

* \ex How many permutations of the letters ABCDEFGH contains the string ABC?

  \pause
  \vskip1em

  \sol

  Because ABC must occur as a block, we need only find the number of permutation of six objects: The block ABC, and D, E, F, G, and H. Since they can occur in any order, there are

  $6! = 720$ permutations

# Combinations

* **r-combinations:** An unordered selection of $r$ elements from a set
  * Simply a subset of size $r$

  \pause

  * \ex Let $\mathbf{S} = \{1,2,3,4\}$, then *$\{1,3,4\}$* is a 3-combination of $\mathbf{S}$

\pause
\vskip.5em

* **Binomial Coefficient:** The number of r-combinations of a set with $n$ distinct elements is denoted as $C(n, r)$ or $\binom{n}{r}$

\pause
\vskip.5em

* **Theorem:** The number of r-combinations of a set with $n$ elements, where $n$ is a nonnegative integer and $r$ is an integer with $0 \leq r \leq n$, equals

  $$C(n,r) = \frac{n!}{r!(n - r)!}$$

  \pause

  - \ex Let $\mathbf{S} = \{a, b, c, d\}$ how many 2-combinations of $\mathbf{S}$ are there:

    \pause

    $$\text{\sol}\,\,C(4,2) = \binom{4}{2} = \frac{4!}{2!(4-2)!} = \frac{4!}{2!2!} = 6$$

# Combinations

* \ex How many poker hands of five cards can be dealt from a standard deck of 52 cards?

  \pause
  \vskip1em

  \sol Because order doesn't matter, there are:

  $$\begin{array}{rcl}
  C(52,5) & = & \frac{52!}{5!47!} = \frac{52 \cdot 52 \cdot 50 \cdot 49 \cdot 48}{5 \cdot 4 \cdot 3 \cdot 2 \cdot 1}\\ \\
          & = & 26 \cdot 17 \cdot 10 \cdot 49 \cdot 12 = 2,598,960
  \end{array}$$

\pause

* **Corollary:** Let $n$ and $r$ be nonnegative integers with $r \leq n$, Then $C(n,r) = C(n, n - r)$

\pause
\vskip.5em

* \ex How many ways are there to select 47 cards from a standard deck of 52 cards?

  \pause

  $$\text{\sol}\,\,C(52, 47) = \frac{52!}{47!5!} = C(52,5) = 2,598,960$$

# Combinations

* **Combinatorial Proof:** a proof of an identity that uses counting arguments to:
  * *double counting proof:* prove that both sides of an identity count the same objects but in different ways
  * *bijective proof:* show that there is a bijection between the sets of objects counted by the two sides of the identity

\vskip.5em

* \ex Show that $C(n,r) = C(n, n-r)$ for all integers $n$ and $r$ with $0 \leq r \leq n$

  \pause
  \vskip1em

  \prf

  Suppose that $\mathbf{S}$ is a set with $n$ elements. The function that maps a subset $\mathbf{A}$ of $\mathbf{S}$ to $\overline{\mathbf{A}}$ is a bijection between subsets of $\mathbf{S}$ with $r$ elements and subsets with $n - r$ elements. The identity $C(n, r) = C(n, n - r)$ follows because when there is a bijection between two finite sets, these sets have the same number of elements.

# Combinations

* \ex How many ways are there to select 5 players from a 10 member tennis team to make a trip to a match at another school?

  \pause

  $$\text{\sol}\,\,C(10, 5) = \frac{10!}{5!5!} = 252$$

#

\ts{Binomial Theorem}

# The Binomial Theorem

* **The Binomial Theorem:** Let $x$ and $y$ be variables, and let $n$ be a nonnegative integer. Then

  $$\left(x + y\right)^n = \overset{n}{\underset{j = 0}{\sum}}\binom{n}{j}x^{n-j}y^{j} = \binom{n}{0}x^n + \binom{n}{1}x^{n - 1}y + \cdots + \binom{n}{n - 1}xy^{n-1} + \binom{n}{n}y^n$$

  * Provides the coefficients of the expansion of powers of binomial expressions
  * A *binomial expression* is simply the sum of two terms such as in $x + y$

\pause
\vskip.5em

* \ex What is the expansion of $\left(x + y\right)^4$?

  \pause
  \vskip1em

  \sol

  $$\begin{array}{rcl}
  (x + y)^4 & = & \overset{4}{\underset{j = 0}{\sum}}\binom{4}{j}x^{4-j}y^j \\
            & = & \binom{4}{0}x^4 + \binom{4}{1}x^3y + \binom{4}{2}x^{2}y^{2} + \binom{4}{3}xy^3 + \binom{4}{4}y^4 \\
            & = & x^4 + 4x^3y + 6x^2y^2 + 4xy^3 + y^4
  \end{array}$$

# The Binomial Theorem

* \ex What is the coefficient of $x^{12}y^{13}$ in the expansion of $\left(x + y\right)^{25}$?

  \pause
  $$\text{\sol}\,\,\binom{25}{13} = \frac{25!}{13!12!} = 5,200,300$$

\pause
\vskip.5em

* \ex What is the coefficient of $x^{12}y^{13}$ in the expansion of $\left(2x - 3y\right)^{25}$?

  \pause
  \vskip1em

  \sol

  $$\begin{array}{rcl}
  (2x + (-3y))^{25} & = & \overset{25}{\underset{j = 0}{\sum}}\binom{25}{j}(2x)^{25 - j}(-3y)^j \\
  \binom{25}{13}2^{12}(-3)^{13} & = & -\frac{25!}{13!12!}2^{12}3^{13}
  \end{array}$$

# The Binomial Theorem

* **Corollary:** Let $n$ be a nonnegative integer. Then

  $$\overset{n}{\underset{k = 0}{\sum}} \binom{n}{k} = 2^n$$

  \pause
  \vskip.5em

* **Corollary:** Let $n$ be a positive integer. Then

  $$\overset{n}{\underset{k = 0}{\sum}}(-1)^k \binom{n}{k} = 0$$

  \pause
  \vskip.5em

* **Corollary:** Let $n$ be a nonnegative integer. Then

  $$\overset{n}{\underset{k = 0}{\sum}}2^k \binom{n}{k} = 3^n$$

# Pascal's Identity

* One of the most important binomial coefficient identity is the following:

\pause
\vskip.5em

* **Pascal's Identity:** Let $n$ and $k$ be positive integers with $n \geq k$. Then

  $$\binom{n + 1}{k} = \binom{n}{k - 1} + \binom{n}{k}$$

\pause
\vskip.5em

* Pascal's identity, together with the initial conditions $\binom{n}{0} = \binom{n}{n} = 1$ for all integers $n$ can be used to recursively define binomial coefficients

\pause
\vskip.5em

* This identity, is the basis of a geometric arrangement, *Pascal's triangle*, wherein the $n^{th}$ row of the triangle is defined as:

  $$\binom{n}{k},\,\,k = 0,1,\ldots,n$$

# Pascal's Triangle

\vfill

::: columns
:::: column

$$
\begin{array}{ccccccccc}
 &  &  &  & \binom{0}{0}\\
 &  &  & \binom{1}{0} &  & \binom{1}{1}\\
 &  & \binom{2}{0} &  & \binom{2}{1} &  & \binom{2}{2}\\
 & \binom{3}{0} &  & \color{BlueDeFrance}\binom{3}{1} &  & \color{BlueDeFrance}\binom{3}{2} &  & \binom{3}{3}\\
\binom{4}{0} &  & \binom{4}{1} &  & \color{BlueDeFrance}\binom{4}{2} &  & \binom{4}{3} &  & \binom{4}{4} \\
  &   &   &   & \cdots & & &  &
\end{array}
$$

::::
:::: column

\pause

\vskip1em
$$
\begin{array}{ccccccccc}
  &   &   &   & 1\\
  &   &   & 1 &   & 1\\
  &   & 1 &   & 2 &   & 1\\
  & 1 &   & \color{BlueDeFrance}3 &   & \color{BlueDeFrance}3 &   & 1\\
1 &   & 4 &   & \color{BlueDeFrance}6 &   & 4 &   & 1 \\
  &   &   &   & \cdots & & &  &
\end{array}
$$

::::
:::

\pause
\vskip1em

* When two adjacent binomial coefficients in the triangle are added, the result is the binomial coefficient appearing between them in the next row

# Other Identities

* **Vendermonde's Identity:** Let $m$, $n$, and $r$ be nonnegative integers with r not exceeding either $m$ or $n$. Then

  $$\binom{m + n}{r} = \overset{r}{\underset{k = 0}{\sum}}\binom{m}{r - k}\binom{n}{k}$$

\pause

* **Corollary:** If $n$ is a nonnegative integer, then

  $$\binom{2n}{n} = \overset{n}{\underset{k=0}{\sum}}\binom{n}{k}^2$$

\pause

* **Theorem:** Let $n$ and $r$ be nonnegative integers with $r \leq n$. Then

  $$\binom{n + 1}{r + 1} = \overset{n}{\underset{j = r}{\sum}}\binom{j}{r}$$

#

\ts{Generalized Counting}

# Introduction

* In many counting problems, elements may be used repeatedly

  \pause

  * \ex a letter or digit may be used more than once in a license plate

\pause
\vskip.5em

* However, the prior definitions for combinations and permutations all an item to be used at most once

  \pause

  * \ex To count the ways in which the letters of the word SUCCESS can be rearranged, we must consider the placement of identical letters

\pause
\vskip.5em

* Thus we need to consider counting problems where
  * Placement of both *indistinguishable* and _distinguishable_ items into _distinguishable_ or _indistinguishable_ boxes

# Permutations with Repetition

* **Theorem:** The number of r-permutations of a set of $n$ objects with repetition allowed is $n^r$

\pause
\vskip.5em

* \ex How many strings of length $r$ can be formed from the uppercase letters of the English alphabet?

  \pause
  $$\text{\sol}\,\,26^r$$

# Combinations with Repetition

* **Theorem:** There are $C(n + r - 1, r) = C(n + r - 1, n - 1)$ r-combinations from a set with $n$ elements when repetition of elements is allowed.

\pause
\vskip.5em

* \ex Suppose a cookie shop has 4 kinds of cookies. How many different ways can six cookies be chosen?

  \pause
  $$\text{\sol}\,\,C(4 + 6 - 1, 6) = C(9, 6) = C(9, 3) = \frac{9 \cdot 8 \cdot 7}{1 \cdot 2 \cdot 3} = 84$$

\pause
\vskip.5em

* \ex How many solutions does the equation $x_1 + x_2 + x_3 = 11$ have where $x_1$, $x_2$, and $x_3$ are nonnegative integers?

  \pause
  $$\text{\sol}\,\,C(3 + 11 - 1, 11) = C(13, 11) = C(13, 2) = \frac{13 \cdot 12}{1 \cdot 2} = 78$$

# Combinations with Repetition

* \ex What is the value of $k$ after the following pseudocode has been executed?

::: columns
:::: {.column width=.05}
::::
:::: {.column width=.3}

\begin{algorithmic}
\State $k \coloneqq 0$
\For{$i_1 \coloneqq 1$ \textbf{to} $n$}
  \For{$i_2 \coloneqq 1$ \textbf{to} $i_1$}
    \State $\vdots$
    \For{$i_m \coloneqq 1$ \textbf{to} $i_{m - 1}$}
      \State $k \coloneqq k + 1$
    \EndFor
  \EndFor
\EndFor
\end{algorithmic}

::::
:::: {.column width=.65}

\pause

\sol

* Initial value of $k$ is 0

\vskip.5em

* 1 is added to $k$ each time the nested loop is traversed with a sequence of integers $i_1,i_2,\ldots,i_m$ such that $i \leq i_m \leq i_{m-1} \leq \ldots \leq i_1 \leq n$

\vskip.5em

* These numbers of such a sequence is the number of ways to choose $m$ integers from $\{1,2,\ldots,n\}$ with repetition allowed

\pause

$$k = C(n + m - 1, m)$$

::::
:::

# Combinations with Repetition

\centering

+---------------+-------------------------+---------------------------------+
| **Type**      | **Repetition Allowed?** | **Formula**                     |
+:==============+:=======================:+:===============================:+
| r-permutation | No                      | $\frac{n!}{(n - r)!}$ \vskip1em |
+---------------+-------------------------+---------------------------------+
| r-combination | No                      | $\frac{n!}{r!(n-r)!}$ \vskip1em |
+---------------+-------------------------+---------------------------------+
| r-permutation | Yes                     | $n^r$ \vskip1em                 |
+---------------+-------------------------+---------------------------------+
| r-combination | Yes                     | $\frac{(n + r - 1)!}{r!(n-1)!}$ |
+---------------+-------------------------+---------------------------------+

# Permutations with Indistinguishable Objects

* **Theorem:** The number of different permutations of $n$ objects, where there are $n_1$ indistinguishable objects of type 1, $n_2$ indistinguishable objects of type 2, $\ldots$, and $n_k$ indistinguishable objects of type $k$, is

  $$C(n, n_1)C(n - n_1, n_2) \cdots C(n - n_1 - \cdots - n_{k-1}, n_k) = \frac{n!}{n_{1}!n_{2}!\cdots n_{k}!}$$

\pause
\vskip.5em

* This avoids counting elements more than once

# Permutations with Indistinguishable Objects

* \ex How many different strings can be made by reordering the letters in the word SUCCESS

  \pause
  \vskip1em

  \sol

  - Note there are not 7 letters but rather 3 S's, 2 C's, 1 U, and 1 E.
  - The S's can be placed among 7 positions yielding $C(7,3)$ ways of placement and leaving 4 free positions
  - The C's can be placed among 4 positions yielding $C(4,2)$ ways of placement and leaving 2 free positions
  - The U can be placed in C(2, 1) ways and the E in C(1,1) ways

  $$\begin{array}{rcl}
  C(7,3) C(4,2) C(2,1) C(1,1) & = & \frac{7!}{3!4!} \cdot \frac{4!}{2!2!} \cdot \frac{2!}{1!1!} \cdot \frac{1!}{1!0!} \\ \\
                              & = & \frac{7!}{3!2!1!1!} \\ \\
                              & = & 420
  \end{array}$$

# Distributing Objects into Boxes

* Many counting problems can be solved by enumerating the ways objects can be placed into boxes (where the order of placement does not matter)

\pause
\vskip.5em

* Both the boxes and the objects can be considered to be either:
  * **Distinguishable:** different from one another (also called *labeled*)
  * **Indistinguishable:** considered identical (also called *unlabeled*)

\pause
\vskip.5em

* There exist closed formula for counting the ways to distribute either type of object into *distinguishable* boxes, but not for *indistinguishable* boxes

\pause
\vskip.5em

* **Closed formula:** an expression that can be evaluated using a finite number of operations and that includes numbers, variables, and values of functions.

# Distinguishable Objects and Boxes

* **Theorem:** The number of ways to distribute $n$ distinguishable objects into $k$ distinguishable boxes so that $n_i$ objects are placed into box $i$, $i = 1,2,\ldots,k$, equals

  $$C(n,n_1) C(n - n_1, n_2) \cdots C(n - n_1 - \cdots - n_{k-1}, n_k) = \frac{n!}{n_{1}!n_{2}! \cdots n_{k}!}$$

\pause
\vskip.5em

* \ex How many ways are there to distribute hands of 5 cards to each of four players from the standard deck of 52 cards?

  \pause
  \vskip1em

  \sol

  $$\begin{array}{rcl}
  C(52,5) C(47,5) C(42,5) C(37,5) & = & \frac{52!}{47!5!} \cdot \frac{47!}{42!5!} \cdot \frac{42!}{37!} \cdot \frac{37!}{32!5!} \\ \\
                                  & = & \frac{52!}{5!5!5!5!32!} \\ \\
                                  & = & 1.478262843×10^{24}
  \end{array}$$

# Indistinguishable Objects and Distinguishable Boxes

* Counting the number of ways of placing $n$ indistinguishable objects into $k$ distinguishable boxes is the same as counting the number of n-combinations for a set with $k$ elements when repetitions is allowed

\pause
\vskip.5em

* Thus, there are $C(n + r - 1, n - 1)$ ways to place $r$ indistinguishable objects into $n$ distinguishable boxes

# Distinguishable Objects and Indistinguishable Boxes

* Counting the ways to place $n$ distinguishable objects into $k$ indistinguishable boxes is more difficult

\pause
\vskip.5em

* There is no simple closed formula, but there is a formula:
  * Let $S(n,j)$ denote the number of ways to distribute $n$ distinguishable objects into $j$ indistinguishable boxes, so that no box is empty.
  * These numbers, $S(n,j)$, are called **Stirling numbers of the second kind**
    $$S(n,j) = \frac{1}{j!}\overset{j - 1}{\underset{i = 0}{\sum}}(-1)^2 \binom{j}{i} (j - i)^n$$
* The number of ways to distribute n distinguishable objects into $k$ indistinguishable boxes is:
  $$\overset{k}{\underset{j = 1}{\sum}}S(n,j) = \overset{k}{\underset{j=1}{\sum}}\frac{1}{j!}\overset{j - 1}{\underset{i = 0}{\sum}}(-1)^2 \binom{j}{i} (j - i)^n$$

# Distinguishable Objects and Indistinguishable Boxes

* \ex How many ways are there to put 4 different employees into 3 indistinguishable offices, when each office can contain any number of employees?

  \pause
  \vskip1em

  \sol

  \vskip.5em

  Represent employees by A, B, C, D

  $$\begin{array}{rcl}
  \overset{3}{\underset{j = 1}{\sum}}S(4,j) & = & \overset{3}{\underset{j=1}{\sum}}\frac{1}{j!}\overset{j - 1}{\underset{i = 0}{\sum}}(-1)^2 \binom{j}{i} (j - i)^4 \\
                                            & = & S(4,1) + S(4,2) + S(4, 3) \\
                                            & = & 1 + 7 + 6 \\
                                            & = & 14
  \end{array}$$

# Indistinguishable Objects and Indistinguishable Boxes

* Also a challenging problem with no closed formula

\pause
\vskip.5em

* However, distributing $n$ indistinguishable objects into $k$ indistinguishable boxes is the same as writing $n$ as the sum of at most $k$ integers in non-increasing order
  * If $a_1 + a_2 + \ldots + a_j = n$, where $a_1,a_2,\ldots,a_j$ are positive integers with $a_1 \leq a_2 \leq \ldots \leq a_j$, the $a_1,a_2,\ldots,a_j$ is a **partition** of the positive integer $n$ into $j$ positive integers

\pause
\vskip.5em

* If $p_k(n)$ is the number of partitions of $n$ into at most $k$ positive integers, then there are $p_k(n)$ ways to distribute $n$ indistinguishable objects into $k$ indistinguishable boxes

# Indistinguishable Objects and Indistinguishable Boxes

* \ex How many ways can we pack 6 copies of a book into 4 identical boxes, where a box can contain as many as 6 books?

  \pause
  \vskip1em

  \sol

  * $[6],\,\, [5,1],\,\, [4,2],\,\, [4,1,1],\,\, [3,3]$
  * $[3,2,1],\,\, [3,1,1,1],\,\, [2,2,2],\,\, [2,2,1,1]$
  * $\therefore$ 9 ways

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
