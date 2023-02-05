---
author:
- Dr. Isaac Griffith
title: Number Theory and Algorithms
course: CS 1187
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Inspiration

\vfill

> "The enemy knows the system" -- Claude Shannon

# Outline

The lecture is structured as follows:

::: columns
:::: {.column width=.7}
* Divisibility and Modular Arithmetic
* Integer Representations
* Integer Algorithms
* Primes and GCD
* Solving Congruences
* Applications of Congruences
* Cryptography
* Program Correctness
::::
:::: {.column width=.25}
\vfill
\vspace{7.25em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\titleslide{.825\textwidth}{Divisibility \& Modular Arithmetic}

# Division

* When an integer is divided by another integer, the result may or may not be an integer.
  * Ex: $12 / 3 = 4$, $11 / 4 = 2.75$

* **Definition:** If $a$ and $b$ are integers with $a \ne 0$, we say $a$ *divides* $b$ if there is an integer $c$ such that $b = ac$ (if $\frac{b}{a}$ is an integer).
  * When $a$ divides $b$ (written $a\, |\, b$) we say $a$ is a *factor* or *divisor* of $b$ and that $b$ is a *multiple* of $a$
  * We an express $a\, |\, b$ logically as $\exists c\,\, (ac = b)$
* *Example:* Determine whether $3\, |\, 7$ and whether $3\, |\, 12$

  \begin{equation*}
  \begin{array}{c}
  3 \not|\, 7 \,\, \text{ because }\,\, 7 / 3 \notin \mathbb{Z} \\
  3\, |\, 12 \,\,\ text{ because }\,\, 12 / 3 = 4
  \end{array}
  \end{equation*}

# Division

* **Theorem:** Let $a$, $b$, and $c$ be integers, where $a \ne c$. Then
  1. if $a\, |\, b$ and $a\, |\, c$, then $a\, |\, (b + c)$
  2. if $a\, |\, b$, then $a\, |\, bc$ for all integers $c$
  3. if $a\, |\, b$ and $b\, |\, c$, then $a\, |\, c$

* **Corollary:** if $a$, $b$, and $c$ are integers, where $a \ne 0$, such that $a\, |\, b$ and $a\, |\, c$, then $a\, |\, mb + nc$ whenever $m$ and $n$ are integers.

# The Division Algorithm

* **The Division Algorithm:** Let $a$ be an integer and $d$ a positive integer. Then there are unique integers $q$ and $r$, with $0 \leq r < d$ such that $a = dq + r$

  ::: columns
  :::: {.column width=.05}
  ::::
  :::: {.column width=.25}

  * $d$ is the *divisor*
  * $a$ is the *dividend*

  \begin{equation*}
  q = a \idiv d
  \end{equation*}

  ::::
  :::: {.column width=.25}

  * $q$ is the *quotient*
  * $r$ is the *remainder*

  \begin{equation*}
  r = a \imod d
  \end{equation*}
  ::::
  :::: {.column width=.45}
  ::::
  :::

\vskip1em

* *Example:* What is the quotient and remainder when 101 is divided by 11?

  \begin{equation*}
  \begin{array}{rcl}
  101 & = & 11 \cdot 9 + 2 \\
  q & = & 101 \idiv 11 = 9 \\
  r & = & 101 \imod 11 = 2
  \end{array}
  \end{equation*}

# Modular Arithmetic

* **Definition:** if $a$ and $b$ are two integers and $m$ is a positive integer, then $a$ is *congruent to $b$ modulo $m$* if $m$ divides $a - b$.
  * Denoted as: $a \equiv b (\imod m) \Rightarrow$ called a **congruence**
  * $m$ is its **modulus**
  * if $a$ and $b$ are not congruent modulo $m$, we write $a \not\equiv b\, (\imod m)$
* **Theorem:** Let $a$ and $b$ be integers, and let $m$ be a positive integer. Then $a \equiv b\, (\imod m)$ iff $a\, \imod m = b\, \imod m$
* *Example:* Determine whether $17 \equiv 5\, (\imod 6)$ and $24 \equiv 14\, (\imod 6)$

  \begin{equation*}
  \begin{array}{rcl}
  6\, |\, (17 - 5 = 12) & \to & 17 \equiv 5\, (\imod 6) \\
  6\, \not|\, (24 - 14 = 10) & \to & 24 \not\equiv 14\, (\imod 6)
  \end{array}
  \end{equation*}

# Modular Arithmetic

* **Theorem:** Let $m$ be a positive integer. The integers $a$ and $b$ are congruent modulo $m$ iff there is an integer $k$ such that $a = b + km$
* **Theorem:** Let $m$ be a positive integer. If $a \equiv b\, (\imod m)$ and $c \equiv d\, (\imod m)$, then

  \begin{equation*}
  \begin{array}{rcl}
  a + c \equiv d\, (\imod m) & \text{and} & ac = bd\, (\imod m)
  \end{array}
  \end{equation*}

* *Example*: because $7 \equiv 2\, (\imod 5)$ and $11 \equiv 1\, (\imod 5)$ it follows that

  \begin{equation*}
  \begin{array}{rcl}
  18 = 7 + 11 & \equiv & 2 + 1 = 3\, (\imod 5) \\
  77 = 7 \cdot 11 & \equiv & 2 \cdot 1 = 2\, (\imod 5)
  \end{array}
  \end{equation*}

# Arithmetic Modulo m

* $\mathbb{Z}_m$: set of non-negative integers less than $m$
* **Arithmetic Modulo m** operators:

  \begin{equation*}
  \begin{array}{rcl}
  a +_{m} b = (a + b) \imod m &  & a \cdot_{m} b = (a \cdot b)\, \imod m
  \end{array}
  \end{equation*}

* Examples: find $7 +_{11} 9$ and $7 \cdot_{11} 9$

  \begin{equation*}
  \begin{array}{rclclcl}
  7 +_{11} 9 & = & (7 + 9)\, \imod 11 & = & 16\, \imod 11 & = & 5 \\
  7 \cdot_{11} 9 & = & (7 \cdot 9)\, \imod 11 & = & 63\, \imod 11 & = & 8
  \end{array}
  \end{equation*}

# Arithmetic Modulo m

* The operators $+_m$ and $\cdot_m$ satisfy the following properties
  * **Closure:** if $a$ and $b \in \mathbb{Z}_m$, then $a +_m b$ and $a \cdot_m b \in \mathbb{Z}_m$
  * **Associativity:** if $a,b,c \in \mathbb{Z}_m$, then $\left(a +_m b\right) +_m c = a +_m (b +_m c)$ and $\left(a \cdot_m b\right) \cdot_m c = a \cdot_m (b \cdot_m c)$
  * **Commutativity:** if $a,b \in \mathbb{Z}_m$, then $a +_m b = b +_m a$ and $a \cdot_m b = b \cdot_m a$
  * **Identity:** The elements 0 and 1 are identity elements for $+_m$ and $\cdot_m$, respectively. If $a \in \mathbb{Z}_m$, then $a +_m 0 = 0 +_m a = a$, and $a \cdot_m 1 = 1 \cdot_m a = a$
  * **Additive Inverses:** If $a \ne 0 \in \mathbb{Z}_m$, then $m - a$ is an additive inverse of $a\, \imod m$ and 0 is its additive inverse. That is $a +_m (m - a) = 0$ and $0 +_m 0 = 0$
  * **Distributivity:** If $a,b,c \in \mathbb{Z}_m$, then $a \cdot_m (b +_m c) = (a \cdot_m b) +_m (a \cdot_m c)$ and $\left(a +_m b\right) \cdot_m c = (a \cdot_m b) +_m (b \cdot_m c)$

#

\titleslide{.635\textwidth}{Integer Representations}

# Integer Representations

* **Base $b$ expansion of $n$:** Let $b$ be an integer $> 1$. Then if $n$ is a positive integer, it can be expressed uniquely in the form

  $$n = a_{k}b^{k} + a_{k-1}b^{k-1} + \ldots + a_{1}b + a_{0}$$

  Where $k$ is a nonnegative integer, $a_0,a_1,\ldots,a_k$ are nonnegative integers less than $b$, and $a_k \ne 0$

::: columns
:::: {.column width=.25}

* **Notes:**
  * A binary digit is called a *bit*
  * 8 bits = 1 *byte* = 2 hexadecimal digits

::::
:::: {.column width=.75}

**Number Systems, Common Expansions to Convert to Decimal:**

* *Decimal (b=10):* $\{0,1,2,3,4,5,6,7,8,9\}$

  $\left(716\right)_{10} = 7\cdot 10^2 + 1 \cdot 10^1 + 6 = 716$

* *Octal (b=8):* $\{0,1,2,3,4,5,6,7\}$

  $\left(7016\right)_8 = 7 \cdot 8^3 + 0 \cdot 8^2 + 1 \cdot 8 + 6 = 3598$

* *Hexadecimal (b=16):* $\{0,1,2,3,4,5,6,7,8,9,A,B,C,D,E,F\}$

  $\left(2AE0B\right)_{16} = 2 \cdot 16^4 + 10 \cdot 16^3 + 14 \cdot 16^2 + 0 \cdot 16 + 11 = 175627$

* *Binary (b=2):* $\{0,1\}$

  $\left(10110\right)_2 = 1 \cdot 2^4 + 0 \cdot 2^3 + 1 \cdot 2^2 + 1 \cdot 2^1 + 0 = 22$

::::
:::

# Base Conversion

* We can construct the base $b$ expansion of integer $n$ as follows
  1. divide $n$ by $b$ to obtain a quotient and remainder ($a_0 =$ rightmost digit in expansion)

     $n = bq_0 + a_0$  $0 \leq a_0 < b$

  2. divide $q_0$ by $b$ to obtain ($a_1$ is second rightmost digit)

     $q_0 = bq_1 + a_1$  $0 \leq a_1 < b$

  3. Continue using these steps moving until you end with a quotient of zero.

::: columns
:::: column

* Find octal expansion of $\left(12345\right)_{10}$

  \begin{equation*}
  \begin{array}{rcl}
  12345 & = & 8 \cdot 1543 + 1 \\
  1543 & = & 8 \cdot 192 + 7 \\
  192 & = & 8 \cdot 24 + 0 \\
  24 & = & 8 \cdot 3 + 0 \\
  3 & = & 8 \cdot 0 + 3 \\
    & = & (30071)_8
  \end{array}
  \end{equation*}

::::
:::: column

* Find the hexadecimal expansion of $\left(177130\right)_{10}$

\begin{equation*}
\begin{array}{rcl}
177130 & = & 16 \cdot 11070 + 10 \\
11070 & = & 16 \cdot 691 + 14 \\
691 & = & 16 \cdot 43 + 3 \\
43 & = & 16 \cdot 2 + 11 \\
2 & = & 16 \cdot 0 + 2 \\
  & = & (2B3EA)_{16}
\end{array}
\end{equation*}

::::
:::

# Base Conversion

**Algorithm:** Constructing Base b Expansions (*greedy algorithm*)

\begin{algorithmic}
\Procedure{baseBExpansion}{n, b}
  \State $q \coloneqq n$
  \State $k \coloneqq 0$
  \While{$q \ne 0$}
    \State $a_k \coloneqq q\,\imod b$
    \State $q \coloneqq q\,\idiv b$
    \State $k \coloneqq k + 1$
  \EndWhile
  \State \Return $\left(a_{k-1},\ldots,a_1,a_0\right)$
\EndProcedure
\end{algorithmic}

\vskip1em

\tiny

\centering
\begin{tabular}{|l|c|c|c|c|c|c|c|c|c|c|c|c|c|c|c|c|}
\hline
\textbf{Decimal}     & 0 & 1 & 2  & 3  & 4   & 5   & 6   & 7   & 8    & 9    & 10   & 11   & 12   & 13   & 14   & 15   \\ \hline
\textbf{Hexadecimal} & 0 & 1 & 2  & 3  & 4   & 5   & 6   & 7   & 8    & 9    & A    & B    & C    & D    & E    & F    \\ \hline
\textbf{Octal}       & 0 & 1 & 2  & 3  & 4   & 5   & 6   & 7   & 10   & 11   & 12   & 13   & 14   & 15   & 16   & 17   \\ \hline
\textbf{Binary}      & 0 & 1 & 10 & 11 & 100 & 101 & 110 & 111 & 1000 & 1001 & 1010 & 1011 & 1100 & 1101 & 1110 & 1111 \\ \hline
\end{tabular}

# Base Conversion

* Binary $\to$ Oct or Hex: easy since each octal digit is a block of 3 bits and each hex digit is a block of 4 bits:
  - Thus, we simply separate the bit string into appropriately sized groups and convert to the number system
* Conversion to binary is a simple lookup on the table

\vskip.5em

::: columns
:::: column
* Ex: Convert $\left(11111010111100\right)_2$ to both octal and hexadecimal

    \begin{equation*}
    \begin{array}{ccccccccc}
    011 & & 111 & & 010 & & 111 & & 100 \\
    3   & & 7   & & 2   & & 7   & & 4   \\
        & &     & &     & &     & = & (37274)_8
    \end{array}
    \end{equation*}

    \vspace{-1em}

    \begin{equation*}
    \begin{array}{ccccccc}
    0011 & & 1110 & & 1011 & & 1100 \\
    3    & & E    & & B    & & C    \\
         & &      & &      & = & (3EBC)_{16}
    \end{array}
    \end{equation*}
::::
:::: column

* Ex: Convert $\left(765\right)_8$ and $\left(A8D\right)_{16}$ to Binary

\begin{equation*}
\begin{array}{rcl}
(765)_8 & = & (111\,\, 110\,\, 101)_2 \\
(A8D)_{16} & = & (1010\,\, 1000\,\, 1101)_2
\end{array}
\end{equation*}

::::
:::

# Addition Algorithm

::: columns
:::: column

**Algorithm:**

\begin{algorithmic}

\Procedure{add}{$a,b$: positive integers}

\Statex \Comment{the binary expansions of $a$ and $b$ are $\left(a_{n-1}a_{n-1}\ldots a_{1}a_{0}\right)_2$ and $\left(b_{n-1}b_{n-1}\ldots b_{1}b_{0}\right)_2$}
  \State $c \coloneqq 0$
  \For{$j \coloneqq 0$ \textbf{to} $n - 1$}
    \State $d \coloneqq \floor*{(a_j + b_j + c) / 2}$
    \State $s_j \coloneqq a_j + b_j + c - 2d$
    \State $c \coloneqq d$
  \EndFor
  \State $s_n \coloneqq c$
  \State \Return $\left(s_{0},s_{1},\ldots,s_{n}\right)$
\EndProcedure
\end{algorithmic}

::::
:::: column

* **Example:** Add $a = (1110)_2$ and $b = (1011)_2$

  \tiny
  \begin{equation*}
  \begin{array}{rcl}
  a_0 + b_0 = 0 + 1 = 0 \cdot 2 + 1           & & c_0 = 0, s_0 = 1 \\
  a_1 + b_1 + c_0 = 1 + 1 + 0 = 1 \cdot 2 + 0 & & c_1 = 1, s_1 = 1 \\
  a_2 + b_2 + c_1 = 1 + 0 + 1 = 1 \cdot 2 + 0 & & c_2 = 1, s_2 = 0 \\
  a_3 + b_3 + c_2 = 1 + 1 + 1 = 1 \cdot 2 + 1 & & c_3 = 1, s_3 = 1 \\
  s_4 = c_3 = 1                               & & s = a + b = (11001)_2
  \end{array}
  \end{equation*}

\normalsize

* **Analysis:**
  * Each pair of bits and the carry requires 2 bit additions but less than twice the number of bits in the expansion
  * Therefore, **O(n)**

::::
:::

# Multiplication Algorithm

::: columns
:::: column

**Algorithm:**

\begin{algorithmic}
\Procedure{multiply}{$a,b$: positive integers}
\Statex \Comment{the binary expansions of $a$ and $b$ are $\left(a_{n-1}a_{n-1}\ldots a_{1}a_{0}\right)_2$ and $\left(b_{n-1}b_{n-1}\ldots b_{1}b_{0}\right)_2$}
\For{$j \coloneqq 0$ \textbf{to} $n - 1$}
  \If{$b_j = 1$} $\,c_j \coloneqq a$ shifted $j$ places
  \Else $\,c_j \coloneqq 0$
  \EndIf
\EndFor
\Statex \Comment{$c_0,c_1,\ldots,c_{n-1}$ are the partial products}
\State $p \coloneqq 0$
\For{$j \coloneqq 0$ \textbf{to} $n - 1$}
  \State $p \coloneqq$ \Call{add}{$p,c_j$}
\EndFor
\State \Return $p$
\EndProcedure
\end{algorithmic}

::::
:::: column

* Example: Find the product of $a = (110)_2$, $b = (101)_2$

  \begin{equation*}
  \begin{array}{rcl}
  ab_0 = 2^0 = (110)_2 \cdot 1 \cdot 2^0 & = & (110)_2 \\
  ab_1 \cdot 2^1 = (110)_2 \cdot 0 \cdot 2^1 & = & (0000)_2 \\
  ab_2 \cdot 2^2 = (110)_2 \cdot 1 \cdot 2^2 & = & (11000)_2 \\
                                             & = & (11110)_2
  \end{array}
  \end{equation*}

* **Analysis**
  * First for loop requires $O(n^2)$ shifts
  * Second for loop requires $n$ $O(n)$ additions which is $O(n^2)$
  * The combination is $O(n^2) + O(n^2)$ which is $O(n^2)$

::::
:::

# Div and Mod Algorithm

::: columns
:::: column

**Algorithm:**

\begin{algorithmic}
\Procedure{division}{}{$a$: integer, $d$: positive integer}
\State $q \coloneqq 0$
\State $r \coloneqq |a|$
\While{$r \geq d$}
  \State $r \coloneqq r - d$
  \State $q \coloneqq q + 1$
\EndWhile
\If{$a < 0$ \textbf{and} $r > 0$}
  \State $r \coloneqq d - r$
  \State $q \coloneqq -(q + 1)$
\EndIf
\State \Return $(q, r)$
\EndProcedure
\end{algorithmic}

::::
:::: column

**Analysis:**

* Assuming $a > d$, the algorithm uses $O(q \log a)$ bit operations

\vskip.5em

* However, there is a faster algorithm which takes $O(\log n \cdot \log d)$ operations

::::
:::

# Modular Exponentiation

* Important for crypto is the ability to efficiently calculate $b^n\, \imod m$ without requiring a large amount of memory.
  * $b$, $n$, and $m$ are integers

**Algorithm:**

\begin{algorithmic}
\Procedure{modExp}{$b$: integer, $n=(a_{k-1}a_{k-2}\ldots a_{1}a_{0})_2$, $m$: positive integer}
  \State $x \coloneqq 1$
  \State $power \coloneqq b\, \imod m$
  \For{$i \coloneqq 0$ \textbf{to} $k - 1$}
    \If{$a_i = 1$} $x \coloneqq (x \cdot power)\, \imod m$ \EndIf
    \State $power \coloneqq (power \cdot power)\, \imod m$
  \EndFor
  \State \Return $x$
\EndProcedure
\end{algorithmic}

* **Analysis:** uses **$O((\log m)^2 \log n)$** bit operations

# Modular Exponentiation

* Example: Using the algorithm to find $3^{644}\, \imod 645$

\begin{equation*}
\begin{array}{lcl}
\color{Roarange}i = 0 & : & a_0 = 0, x = 1,                               power = 3^2\, \imod 645 = 9\, \imod 645 = 9 \\
\color{Roarange}i = 1 & : & a_1 = 0, x = 1,                               power = 9^2\, \imod 645 = 81\, \imod 645 = 81 \\
\color{Roarange}i = 2 & : & a_2 = 1, x = 1 \cdot 81\, \imod 645 = 81,     power = 81^2\, \imod 645 = 6561\, \imod 645 = 111 \\
\color{Roarange}i = 3 & : & a_3 = 0, x = 81,                              power = 111^2\, \imod 645 = 12321\, \imod 645 = 66 \\
\color{Roarange}i = 4 & : & a_4 = 0, x = 81,                              power = 66^2\, \imod 645 = 4356\, \imod 645 = 486 \\
\color{Roarange}i = 5 & : & a_5 = 0, x = 81,                              power = 486^2\, \imod 645 = 236196\, \imod 645 = 126 \\
\color{Roarange}i = 6 & : & a_6 = 0, x = 81,                              power = 126^2\, \imod 645 = 15876\, \imod 645 = 396 \\
\color{Roarange}i = 7 & : & a_7 = 1, x = (81 \cdot 396)\,\imod 645 = 471, power = 396^2\, \imod 645 = 156816\, \imod 645 = 81 \\
\color{Roarange}i = 8 & : & a_8 = 0, x = 471,                             power = 81^2\, \imod 645 = 6561\, \imod 645 = 111 \\
\color{Roarange}i = 9 & : & a_9 = 1, x = (471 \cdot 111)\,\imod 645 = 36
\end{array}
\end{equation*}

**Result:** $3^{644}\, \imod 645 = 36$

#

\titleslide{.45\textwidth}{Primes and GCD}

# Primes

* **Prime:** An integer $p$ greater than 1 where the only positive factors of $p$ are 1 and $p$
* **Composite:** A positive integer that is greater than one and not prime
* *Note:* 1 is not prime, as it only has one *positive* factor
* **Fundamental Theorem of Arithmetic:** Every integer greater than 1 can be written uniquely as a prime or as the product of two or more primes, where the prime factors are written in order of non-decreasing size.
* *Example:* Some prime factorizations
  * $100 = 2 \cdot 2 \cdot 5 \cdot 5 = 2^{2} 5^{2}$
  * $641 = 641$
  * $999 = 3 \cdot 3 \cdot 3 \cdot 37 = 3^{3} 37$
  * $1024 = 2 \cdot 2 \cdot 2 \cdot 2 \cdot 2 \cdot 2 \cdot 2 \cdot 2 \cdot 2 \cdot 2 = 2^{10}$

# Trial Division

* **Theorem:** If $n$ is a composite integer, then $n$ has a prime divisor less than or equal to $\sqrt{n}$

* This leads to a *brute-force algorithm* called **trial division** for showing a number is prime
  1. divide $n$ by all primes not exceeding $\sqrt{n}$
  2. conclude $n$ is prime if it is not divisible by any of these prime numbers
  3. otherwise continue dividing by primes to extract the prime factorization
* Examples:
  * Show 101 is prime: primes $< \sqrt{101}$ are $2, 3, 5, 7$ and 101 is not divisible by any of them $\therefore 101$ is prime
  * Factor $7007$: $7007 = 7 \cdot 1001 = 7 \cdot 7 \cdot 143 = 7 \cdot 7 \cdot 11 \cdot 13 = 7^{2}\cdot 11 \cdot 13$

# Sieve of Eratosthenes

* used to find all primes not exceeding a specified positive number, $n$
* start by finding $\sqrt{n}$, which the largest prime factor of $n$ cannot exceed.

**Example:** 100, $\sqrt{100} = 10$

::: columns
:::: column

\scriptsize

\begin{tabular}{cccccccccc}
1  & 2  & 3  &   & 5  &  & 7  &  & 9  & \\
11 &  & 13 &  & 15 &  & 17 &  & 19 & \\
21 &  & 23 &  & 25 &  & 27 &  & 29 & \\
31 &  & 33 &  & 35 &  & 37 &  & 39 & \\
41 &  & 43 &  & 45 &  & 47 &  & 49 & \\
51 &  & 53 &  & 55 &  & 57 &  & 59 & \\
61 &  & 63 &  & 65 &  & 67 &  & 69 & \\
71 &  & 73 &  & 75 &  & 77 &  & 79 & \\
81 &  & 83 &  & 85 &  & 87 &  & 89 & \\
91 &  & 93 &  & 95 &  & 97 &  & 99 &
\end{tabular}

\tiny remove all numbers divisible by 2 (except 2)

::::
:::: column

\scriptsize

\begin{tabular}{cccccccccc}
1  & 2  & 3  &   & 5  &  & 7  &  &    & \\
11 &    & 13 &   &    &  & 17 &  & 19 & \\
   &    & 23 &   & 25 &  &    &  & 29 & \\
31 &    &    &   & 35 &  & 37 &  &    & \\
41 &    & 43 &   &    &  & 47 &  & 49 & \\
   &    & 53 &   & 55 &  &    &  & 59 & \\
61 &    &    &   & 65 &  & 67 &  &    & \\
71 &    & 73 &   &    &  & 77 &  & 79 & \\
   &    & 83 &   & 85 &  &    &  & 89 & \\
91 &    &    &   & 95 &  & 97 &  &    &
\end{tabular}

\tiny remove all numbers divisible by 3 (except 3)

::::
:::

# Sieve of Eratosthenes

::: columns
:::: column

\scriptsize

\begin{tabular}{cccccccccc}
1  & 2  & 3  &   & 5  &  & 7  &  &    & \\
11 &    & 13 &   &    &  & 17 &  & 19 & \\
   &    & 23 &   &    &  &    &  & 29 & \\
31 &    &    &   &    &  & 37 &  &    & \\
41 &    & 43 &   &    &  & 47 &  & 49 & \\
   &    & 53 &   &    &  &    &  & 59 & \\
61 &    &    &   &    &  & 67 &  &    & \\
71 &    & 73 &   &    &  & 77 &  & 79 & \\
   &    & 83 &   &    &  &    &  & 89 & \\
91 &    &    &   &    &  & 97 &  &    &
\end{tabular}

\tiny remove all numbers divisible by 5 (except 5)

::::
:::: column

\scriptsize

\begin{tabular}{cccccccccc}
1  & 2  & 3  &   & 5  &  & 7  &  &    & \\
11 &    & 13 &   &    &  & 17 &  & 19 & \\
   &    & 23 &   &    &  &    &  & 29 & \\
31 &    &    &   &    &  & 37 &  &    & \\
41 &    & 43 &   &    &  & 47 &  &    & \\
   &    & 53 &   &    &  &    &  & 59 & \\
61 &    &    &   &    &  & 67 &  &    & \\
71 &    & 73 &   &    &  &    &  & 79 & \\
   &    & 83 &   &    &  &    &  & 89 & \\
   &    &    &   &    &  & 97 &  &    &
\end{tabular}

\tiny remove all numbers divisible by 7 (except 7), and all remaining numbers are prime

::::
:::

# Infinitude of Primes

* **Theorem:** There are infinitely many primes
* **Mersenne Primes:** Primes of the form $2^p - 1$, where $p$ is also prime
  * Note that $2^n - 1$ cannot be prime unless $n$ is also prime
  * There is an extremely efficient test to determine if $2^p - 1$ is prime (Lucas-Lehmer Test)
  * Examples:
    * $2^2 - 1 = 3$, $2^3 - 1 = 7$, $2^5 - 1 = 31$, $2^7 - 1 = 127$ are all Mersenne primes
    * $2^{11} - 1 = 2047 = 23 \cdot 89 \therefore$ not prime

# Distribution of Primes

* **Prime Number Theorem:** The ratio of $\pi(x)$, the number of primes not exceeding $x$, and $x / \ln x$ approaches 1 as $x$ grows without bound.
  * Using Trial Division with this theorem does provide a method for factoring and primality testing, but not a very efficient one
  * However, there is a polynomial time algorithm for determining if a number is prime. It was identified by Aggrawal, Kayal, and Saxena
    * Runs in $O((\log n)^6)$ operations
  * Unfortunately factoring large numbers is still exceptionally difficult

# GCD and LCM

* **Greatest Common Divisor (gcd):** Let $a$ and $b$ be integers not both zero. The *gcd* is the largest integer $d$ such that $d\, |\, a$ and $d\, |\, b$. Denoted $\gcd(a, b)$
  * Example: What is the gcd of 24 and 36?
    * Common divisors are: 1, 2, 3, 4, 6, and 12
    * Thus, $\gcd(24, 36) = 12$
* **Least Common Multiple (lcm):** of the positive integers $a$ and $b$ is the smallest positive integer that is divisible by both $a$ and $b$. Denoted $\lcm(a,b)$
* **Theorem:** Let $a$ and $b$ be positive integers. Then

  $$ab = \gcd(a,b) \cdot \lcm(a, b)$$


# GCD, LCM, and Primes

* **Relatively Prime:** The integers $a$ and $b$ are *relatively prime* if $\gcd(a, b) = 1$
* **Pairwise Relatively Prime:** The integers $a_1,a_2,\ldots,a_n$ are *pairwise relatively prime* if $\gcd(a_i, a_j) = 1$ whenever $1 \leq i < j \leq n$
* *Examples:*
  * $\gcd(17,22) = 1 \therefore$ 17 and 22 are relatively prime
  * Are 10, 17, 21 Pairwise relatively prime?
    * $\gcd(10, 17) = 1$
    * $\gcd(10, 21) = 1$
    * $\gcd(17, 21) = 1$
    * $\therefore$ they are pairwise relatively prime

# GCD, LCM, and Primes

* We can use the prime factorizations of the positive integers $a$ and $b$ to find both the $\gcd(a, b)$ and $\lcm(a, b)$
* Suppose the prime factorizations of $a$ and $b$ are:

  \begin{equation*}
  \begin{array}{rcl}
  a & = & p_1^{a_1}p_c^{a_2}\ldots p_n^{a_n} \\
  b & = & p_1^{b_1}p_c^{b_2}\ldots p_n^{b_n}
  \end{array}
  \end{equation*}

  where all primes occurring in either $a$ or $b$ are listed (possibly with zero exponents)

* Then:

  \begin{equation*}
  \begin{array}{rcl}
  \gcd(a, b) & = & p_{1}^{\min(a_1, b_1)}p_{2}^{\min(a_2,b_2)} \ldots p_{n}^{\min(a_n, b_n)} \\
  \lcm(a, b) & = & p_{1}^{\max(a_1, b_1)}p_{2}^{\max(a_2,b_2)} \ldots p_{n}^{\max(a_n, b_n)}
  \end{array}
  \end{equation*}

* Example: What is the lcm of $2^3 3^5 7^2$ and $2^4 3^3$?
  * $\lcm(2^3 3^5 7^2, 2^4 3^3) = 2^{\max(3,4)} 3^{\max(5,3)} 7^{\max(2,0)} = 2^4 3^5 7^2$

# The Euclidean Algorithm

* An efficient algorithm for computing gcd, known since ancient times, is based on the following lemma
* **Lemma:** Let $a = bq + r$, where $a$, $b$, $q$, and $r$ are integers. Then $\gcd(a, b) = \gcd(b, r)$

::: columns
:::: column

**Algorithm:**

\begin{algorithmic}
\Procedure{gcd}{$a,b$: positive integers}
  \State $x \coloneqq a$
  \State $y \coloneqq b$
  \While{$y \ne 0$}
    \State $r \coloneqq x\, \imod y$
    \State $x \coloneqq y$
    \State $y \coloneqq r$
  \EndWhile
  \State \Return $x$
\EndProcedure
\end{algorithmic}

* If $a \geq b$, then $O(\log b)$

::::
:::: column

*Example:* Find $\gcd(414,662)$

\vskip.5em

+-----+-------+-----------+-----------+-------------+
| $j$ | $r_j$ | $r_{j+1}$ | $q_{j+1}$ | $r_{j + 2}$ |
+:===:+:=====:+:=========:+:=========:+:===========:+
| 0   | 662   | 414       | 1         | 248         |
+-----+-------+-----------+-----------+-------------+
| 1   | 414   | 248       | 1         | 166         |
+-----+-------+-----------+-----------+-------------+
| 2   | 248   | 166       | 1         | 82          |
+-----+-------+-----------+-----------+-------------+
| 3   | 166   | 82        | 2         | 2           |
+-----+-------+-----------+-----------+-------------+
| 4   | 82    | 2         | 41        | 0           |
+-----+-------+-----------+-----------+-------------+

\vskip.25em

$\gcd(414, 662) = 2$

::::
:::

# GCDs: Linear Combinations

* **Bézout's Theorem:** If $a$ and $b$ are positive integers, then there exist integers $s$ and $t$ such that $\gcd(a, b) = sa + tb$
  * The coefficients $s$ and $t$ are called **Bézout's coefficients** of $a$ and $b$
  * The equation $\gcd(a, b) = sa + tb$ is called **Bézout's identity**
    * This form shows that $\gcd(a,b)$ can be expressed as a *linear combination*
* **Lemma:** If $a$, $b$, and $c$ are positive integers such that $\gcd(a, b) = 1$ and $a\,|\, bc$, then $a\,|\,c$
* **Lemma:** If $p$ is a prime and $p\,|\,a_1a_2\ldots a_n$, where each $a_i$ is an integer, then $p\,|\,a_i$ for some $i$
* **Theorem:** Let $m$ be a positive integer and let $a$, $b$, and $c$ be integers. If $ac \equiv bc\,(\imod m)$ and $\gcd(c, m) = 1$, then $a \equiv b\, (\imod m)$

#

\titleslide{.575\textwidth}{Solving Congruences}

# Linear Congruences

* **Linear Congruence:** A congruence of the form

  $$ax \equiv b\,(\imod m)$$


  Where:
  - $m$ is a positive integer
  - $a, b$ are integers
  - $x$ is a variable

* **Theorem:** If $a$ and $m$ are relatively prime integers and $m > 1$, then an *inverse* of $a\, \imod m$ exists. Furthermore, this inverse is unique modulo $m$
  * That si, there is a unique positive integer $\overline{a}$ less than $m$ that is the inverse of $a\, \imod m$ and every other inverse of $a\, \imod m$ is congruent to $\overline{a}\, \imod m$

* Once we have an inverse, $\overline{a}$ of $a\, \imod m$, we can solve the congruence $ax \equiv b\,(\imod m)$ by multiplying both sides by $\overline{a}$

# Linear Congruences

* Example: Find an inverse of $3\,\imod 7$ by first finding Bézout coefficients of 3 and 7
  * Because $\gcd(3,7) = 1$, an inverse of $3\, \imod 7$ exists
    - $\gcd(3,7) \Rightarrow 7 = 2 \cdot 3 + 1$
    - from this $-2 \cdot 3 + 1 \cdot 7 = 1$

  * Bézout coefficients are $-2$ and $1$
  * Then, $-2$ is an inverse of $3\, \imod 7$


# Chinese Remainder Theorem

* **Chinese Remainder Theorem:** Let $m_1, m_2, \ldots, m_n$ be pairwise relatively prime positive integers greater than 1 and $a_1, a_2, \ldots, a_n$ arbitrary integers. Then the system

  \begin{equation*}
  \begin{array}{rcl}
  x & \equiv & a_1\, (\imod m_1), \\
  x & \equiv & a_2\, (\imod m_2), \\
    & \vdots & \\
  x & \equiv & a_n\, (\imod m_n)
  \end{array}
  \end{equation*}

  has a unique solution modulo $m = m_{1}m_{2}\ldots m_{n}$

<!--# Chinese Remainder Theorem


# Chinese Remainder Theorem

* Often it is simpler to use the **back substituion method**-->

# Fermat's Little Theorem

* **Fermat's Little Theorem:** If $p$ is prime and $a$ is an integer not divisible by $p$, then

  \begin{equation*}
  a^{p-1} \equiv 1\, (\imod p)
  \end{equation*}

  Furthermore, for every integer $a$ we know

  \begin{equation*}
  a^{p} \equiv a\, (\imod p)
  \end{equation*}

* *Example:* find $7^{222}\,\imod 11$
  * Using Fermat's Little Theorem we know that $7^{10} \equiv 1\, (\imod 11)$, so
    $\left(7^{10}\right)^k \equiv 1\, (\imod 11)\,\, \forall k \in \mathbb{Z}^{+}$
  * We then divide 222 by 10 finding $222 = 22 \cdot 10 + 2$
  * We can then see that $7^{222} = 7^{22\cdot 10 + 2} \equiv (1)^{22} \cdot 40 \equiv 5\, (\imod 11)$
  * Thus, $7^{222}\,\imod 11 = 5$


# Pseudoprimes

* **Pseudoprime:** Let $b$ be a positive integer. If $n$ is a composite positive integer, and $b^{n+1} \equiv 1\, (\imod n)$, then $n$ is called *pseudoprime to the base b*
* **Carmichael Number:** A composite integer $n$ that satisfies the congruence $b^{n-1} \equiv 1\, (\imod n)$ for all positive integer $b$ with $\gcd(b, n) = 1$

#

\titleslide{.75\textwidth}{Applications of Congruences}

# Hashing Functions

* **Hashing Functions:** a hashing function $h$ assigns memory location $h(k)$ to the record that has $k$ as its key.
  * Many different hashing functions are used in practice, one of the most common is:

    $$h(k) = k\, \imod m$$

    Where $m$ is the number of memory locations
  - Should be easy to evaluate
  - Should be onto, so all memory locations are pairwise
* The functions are not one-to-one (more possible keys than memory locations) thus **collisions** may occur
  * Collision handling is necessary
  * Assign first free location following memory location assigned by hashing function:

    $$h(k, i) = h(k) + i\,\imod m\,\,\,\,0 \leq i \leq m - 1$$

# Hashing Functions

* Example: Find the memory location assigned by the hashing function $h(k) = k\,\imod 111$ to the records of customers with social security numbers 064212848 and 037149212.

  \begin{equation*}
  \begin{array}{rcl}
  h(064212848) & = & 064212848\,\imod 111 = 14 \\
  h(037149212) & = & 037149212\,\imod 111 = 65
  \end{array}
  \end{equation*}

* Example: Now assign a memory location to the record of the customer with SSN 107405723

  \begin{equation*}
  \begin{array}{rcl}
  h(107405723) & = & 107405723\,\imod 111 = 14
  \end{array}
  \end{equation*}

  **This caused a collision.** However, 15 is unassigned, thus we can assign 10740523 to 15 instead.

# Pseudorandom Numbers

* **Pseudorandom Numbers:** A sequence of numbers systematically generated and having several properties of randomly selected numbers, without being truly random.
  * Need for computer simulations
* **Linear Congruential Method:** most commonly used procedure for generating pseudorandom numbers. Uses the following recursively defined function:

  $$x_{n+1} = (ax_n + c)\,\imod m$$

  Where: we select the following integers
  - $m$ is the *modulus*
  - $a$ is the *multiplier*
  - $c$ is the *increment*
  - $x_0$ is the *seed* (initial value)
  - and $2 \leq a < m$, $0 \leq c < m$, and $0 \leq x_0 < m$

# Pseudorandom Numbers

* Example: Using the function $x_{n+1} = (7x_n + 4)\, \imod 9$, $x_0 = 3$, we find that

\begin{equation*}
\begin{array}{rcl}
x_1 & = & 7x_0 + 4\, \imod 0 = 7 \cdot 3 + 4\, \imod 9 = 25\, \imod 9 = 7 \\
x_2 & = & 7x_1 + 4\, \imod 0 = 7 \cdot 7 + 4\, \imod 9 = 53\, \imod 9 = 8 \\
x_3 & = & 7x_2 + 4\, \imod 0 = 7 \cdot 8 + 4\, \imod 9 = 60\, \imod 9 = 6 \\
x_4 & = & 7x_3 + 4\, \imod 0 = 7 \cdot 6 + 4\, \imod 9 = 46\, \imod 9 = 1 \\
x_5 & = & 7x_4 + 4\, \imod 0 = 7 \cdot 1 + 4\, \imod 9 = 11\, \imod 9 = 2 \\
x_6 & = & 7x_5 + 4\, \imod 0 = 7 \cdot 2 + 4\, \imod 9 = 18\, \imod 9 = 0 \\
x_7 & = & 7x_6 + 4\, \imod 0 = 7 \cdot 0 + 4\, \imod 9 = 4\, \imod 9 = 4 \\
x_8 & = & 7x_7 + 4\, \imod 0 = 7 \cdot 4 + 4\, \imod 9 = 32\, \imod 9 = 5 \\
x_9 & = & 7x_8 + 4\, \imod 0 = 7 \cdot 5 + 4\, \imod 9 = 39\, \imod 9 = 3 \\
\end{array}
\end{equation*}

  - This generates the sequence: **3**,7,8,6,1,2,0,4,5,**3**,7,8,6,1,2,0,4,5,**3**,$\ldots$
  - The sequence has a cycle of 9 before repeating

#

\titleslide{.375\textwidth}{Cryptography}

# Classical Cryptography

* **Encryption:** The process of making a message secret
* **Decryption:** The process of determining the original message from the encrypted text
* **Caesar's Encryption Method**
  * Replace each letter with its corresponding number from $\mathbb{Z}_{26}$
  * Encrypt using the function $f(p)$, where $p$ is a nonnegative integer less than or equal to 25.

    $$f(p) = (p + 3)\, \imod 26$$

  * Replace the encrypted numbers with their corresponding letters
  * This is a form of a *shift cipher*

# Classical Cryptography

* Example: Use Caesar's cipher to encrypt the message "MEET YOU IN THE PARK"

  ```
        M E E T     Y  O  U   I  N   T H  E    P A  R  K
  1.)  12 4 4 19   24 14 20   8 13  19 7  4   15 0 17 10  // letters -> num
  2.)  15 7 7 22    1 17 23  11 16  22 10 7   18 3 20 13  // encrypt with f(p)
  3.)   P H H  W    B  R  X   L  Q   W  K H    S D  U  N  // num -> letters
  ```

* We can recover the original message, by shifting the letters back by 3 using:

  $$f^{-1}(p) = (p - 3)\, \imod 26$$

# Generalized Shift Cipher

* *Encryption:* Shift letters by $k$ letters

  $$f(p) = (p + k)\, \imod 26$$

* *Decryption:* Shifts letters by $-k$ letters

  $$f^{-1}(p) = (p - k)\, \imod 26$$

* **Affine Cipher:** An enhancement of the shift cipher which provides additional security and uses the following formula

  $$f(p) = (ap + b)\, \imod m$$

  Where $a$ and $b$ are selected so that $f$ is a bijection. Such a mapping is called an *affine transformation*

* **Cryptanalysis:** The process of recovering plaintext from ciphertext without knowledge of both the encryption method and the key.
  * A technique used agains shift and affine ciphers is the frequency attack

# Block Ciphers and Beyond

* **Character or Monoalphabetic Ciphers:** ciphers which proceed by replacing each letter of the alphabet by another letter of the alphabet
  * Shift and affine ciphers are of this type
  * Vulnerable to attack
* To combat these deficiencies better ciphers have been developed
  * For example, Block Ciphers
  * However, they are still prone to attack
* To improve our ability to encrypt and keep data safe, we have developed better methods such as the AES and RSA private key cryptosystems
* Additionally, we have developed public-private key cryptosystems such as gpg.
* If you are interested in these topic I would suggest starting with DMA Chapter 4.6

<!--#

\titleslide{.575\textwidth}{Program Correctness}

# Introduction

# Program Verification

# Program Verification

# Rules of Inference

# Conditional Statements

# Conditional Statements

# Loop Invariants

# Loop Invariants

# Loop Invariants

# Example-->

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
