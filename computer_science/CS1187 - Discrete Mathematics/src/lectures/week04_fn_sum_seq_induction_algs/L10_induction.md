---
author:
- Dr. Isaac Griffith
title: Induction, Inductive Sets, and Matrices
course: CS 1187
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

#

\titleslide{.375\textwidth}{Induction}

# Mathematical Induction

* Many theorems state that $P(n)$ is true for all positive integers $n$, where $P(n)$ is a propositional function, such as the statement that $1 + 2 + \ldots + n = \frac{n (n + 1)}{2}$ or the statement that $n \leq 2^n$

\vskip.5em

* **Mathematical Induction** is a technique for proving theorems of this kind

\vskip.5em

* In other words, mathematical induction is used to prove propositions of the form: $\forall_x P(x)$, where the universe of discourse is the set of positive integers.

# Mathematical Induction

**Principle of Mathematical Induction**

* A proof by mathematical induction that $P(x)$ is true for every positive integer $n$ consists of two steps:

  1. **Basis Step:** The proposition $P(1)$ is shown to be true.
  2. **Inductive Step:** The implication $P(k) \to P(k + 1)$ is shown to be true for every positive integer $k$

\vskip.5em

* Here, the statement $P(k)$ for a fixed positive integer $k$ is called the **inductive hypothesis**

\vskip.5em

* When we complete both steps of a proof by mathematical induction, we have proved that $P(n)$ is true for all positive integers $n$; that is we have shown that $\forall_n P(n)$ is true.

\vskip.5em

* Expressed as a rule of inference, this proof technique can be stated as:

$$\left[P(1) \wedge \forall_k (P(k)) \to P(k + 1)) \right] \to \forall_n P(n)$$

# Mathematical Induction

$$\left[P(1) \wedge \forall_k (P(k)) \to P(k + 1)) \right] \to \forall_n P(n)$$

* To prove $\forall n.\,\,P(n)$ is true $\forall n \in \mathbb{Z}^{+}$:
  \footnotesize
  1. Show that $P(1)$ is true.
     * This amounts to showing that the particular statement obtained when $n$ is replaced by $1$ in $P(n)$ is true.
  2. Show that $P(k) \to P(k + 1)$ is true for every positive integer $k$.
     \scriptsize
     1. To prove that this implication is true for every positive integer $k$ we need to show that $P(k + 1)$ cannot be false when $P(k)$ is true.
     2. Assume that $P(k)$ is true.
     3. Show that **under this hypothesis** $P(k+1)$ must also be true.

<!--
* **Note:** In a proof by mathematical induction it is **not** assumed that $P(k)$ is true for all positive integers! It only shows that if it is **assumed** that $P(k)$ is true, then $P(k + 1)$ is also true. Thus, a proof by mathematical induction is not a case of begging the question or circular reasoning.
-->

# Proof Examples

::: columns
:::: column

**Example:** $P(n): 2^n < n!$ for $n \geq 4$

**Proof:**

\vskip.5em
\footnotesize

**Basis Step:** $P(4): 2^4 = 16 < 24 = 4!$ **true**

**Inductive Step:** Assume $P(k)$ is true $\left(k \geq 4\right)$

\scriptsize
\vskip.5em

Multiply both sides by 2

$\begin{array}{rcl}
2 \cdot 2^k & < & 2 \cdot k! \\
            & < & (k + 1) \cdot k! \\
            & = & (k + 1)!
\end{array}$

::::
:::: column

**Example:** $P(n): 4n < (n^2 - 7)$ for $n \geq 6$

\vskip.5em

**Proof:**

\vskip.5em
\footnotesize

**Basis Step:** $P(6): 24 < 29$ **true**

**Inductive Step:** Assume $P(k)$ is true. $\left(k \geq 6\right)$

\scriptsize
\vskip.5em

We want to show that $4(k + 1) < (k + 1)^2 - 7$

$\begin{array}{rclcl}
4k       & < & (k^2 - 7) & & \\
4k + 4   & < & (k^2 - 7) + 4 & < & (k^2 - 7) + (2k + 1) \\
         &   &               & = & k^2 + 2k + 1 - 7 \\
4(k + 1) &   &               & = & (k + 1)^2 - 7
\end{array}$

::::
:::

# Proof Examples

**Example:** $P(n): 1 + 2 + 2^2 + \ldots + 2^n = 2^{n+1} - 1$ and $n \geq 0$

**Proof:**

\vskip.5em
\footnotesize

**Basis Step:** $P(0):\,\,2^0 = 1 = 1 = 2^{0 + 1} - 1$ **True**

**Inductive Step:** Assume $P(k)$ is true. $\left(k \geq 0\right)$

\vskip.5em
\scriptsize

We want to show that

$1 + 2 + 2^2 + \ldots + 2^k + 2^{k+1} = 2^{(k+1)+1} - 1 = 2^{k+2} - 1$

$\begin{array}{rcl}
1 + 2 + 2^2 + \ldots + 2^k + 2^{k+1} & = & (1 + 2 + 2^2 + \ldots + 2^k) + 2^{k+1} \\
                                     & = & 2^{k+1} - 1 + 2^{k+1} \\
                                     & = & 2 \cdot 2^{k+1} - 1 \\
                                     & = & 2^{k+2} - 1
\end{array}$

# Induction on Lists

* **Principle of List Induction:** supose $P(xs)$ is a predicate on lists of type `[a]`, for some type `a`.
  * The Base Case is to Suppose that $P([])$ is true
  * Further, suppose that if $P(xs)$ holds for arbitrary `xs :: [a]`, then $P(x:xs)$ also holds for arbitrary `x :: a`.
  * Then, $P(xs)$ holds for every list $xs$ that has finite length

* **Example:** `length (map f xs) = length xs`
  * **Proof:** Induction over `xs`
    * **Base Case:**

      $\begin{array}{lr}
      length\,\, (map\,\,f\,\,[]) & \\
      \,\,= length\,\,[] & \{\,\,map.1\,\,\}
      \end{array}$

    * **Inductive Case:** assume `length (map f xs) = length xs`. Then

      $\begin{array}{lr}
      length\,\, (map\,\,f\,\,(x:xs)) & \\
      \,\,= length\,\,(f\,\,x\,\,:\,\,map\,\,f\,\,xs) & \{\,\,map.2\,\,\} \\
      \,\,= 1 + length\,\,(map\,\,f\,\,xs) & \{\,\,length.2\,\,\} \\
      \,\,= 1 + length\,\,xs & \{\,\,hypothesis\,\,\} \\
      \,\,= length\,\,(x\,\,:\,\,xs) & \{\,\,length.2\,\,\}
      \end{array}$

# Functional Equality

* If two algorithms, defined as functions, are applied to the same arguments they will produce the same result
  * If true, it may seem that we could state $f = g$, when $f$ and $g$ are functions.
  * But, what does $f = g$ mean?

\vskip.5em

* **Intensional Equality:** Two functions $f$ and $g$ are *intensionally equal* if their definitions are identical.
  * For programs this means that the source code is identical

\vskip.5em

* **Extensional Equality:** Two functions $f$ and $g$ are *extensionally equal* if the have the same type $a \to b$ and $f(x) = g(x)$ for all well typed arguments $x : a$. That is, $f = g$ iff

  $$\forall x : a.\,\, f(x) = g(x)$$

  * Proof of this simply requires that we prove the proposition $\forall x : a.\,\, f(x) = g(x)$, by selecting an arbitrary $x : a$ and proving the equation $f(x) = g(x)$

# Strong Induction

* **Strong Induction:** To prove that $P(n)$ is true for all positive integers $n$, where $P(n)$ is a propositional function, we complete two steps:
  * **Basis Step:** We verify that the proposition $P(1)$ is true
  * **Inductive Step:** We show that the conditional statement $[P(1) \land P(2) \land \ldots \land P(k)] \to P(k + 1)$ is true for all positive integers $k$
    * That is, here we show that fall all positive integers $j$ not exceeding $k$, then $P(k + 1)$ is true

\vskip.5em

* For our *inductive hypothesis*, we assume $P(j)$ is true for $j = 1, 2, \ldots, k$

\vskip.5em

* **Well-Ordering Property:** Every nonempty set of nonnegative integers has at least one element.

# Example

* Prove that every amount of postage of 12 cents or more can be formed using just 4-cent and 5-cent stamps
  * Let $P(n)$ be the statement that postage of $n$ cents can be formed using 4-cent and 5-cent stamps

* **Basis Step:** We can form postage of 12, 13, 14, and 15 cents as follows:
  * P(12) - three 4-cent stamps
  * P(13) - two 4-cent stamps
  * P(14) - one 4-cent stamps and two 5-cent stamps
  * P(15) - three 5-cent stamps

* **Inductive Step:** Assume we can form postage of $j$ cents, where $12 \leq j \leq k$

  - We need to show that under the assumption $P(k + 1)$ is true, we can also form postage of $k+1$ cents.
  - We can assume that $P(k - 3)$ is true because $k - 3 \geq 12$
  - To form postage of k + 1 cents, we need only add another 4-cent stamp to the stamps used for $k-3$ cents.
  - Thus, we've shown the *inductive hypothesis* is true, then $P(K + 1)$ is also true

#

\titleslide{.65\textwidth}{Defining Sets Inductively}

# Defining Sets Using Induction

* Beyond the base and inductive cases, inductive set definition needs one more component: the *extremal clause*

\vskip.5em

* **Extremal Clause:** A statement which excludes anything from the set that are not introduced by the base case, or are instantiations of the induction case, it reads something like the following:

  \vskip.5em

  "Nothing is an element of the set unless it can be constructed by a finite number of uses of the first two clauses"

\vskip.5em

* Thus all inductive set definitions include 3 parts:
  * **Base Case:** a simple statement of some mathematical fact: i.e., $1 \in S$
  * **Induction Case:** an implication in a general form: $\forall\,\, x \in U,\,\, x \in S \to x + 1 \in S$
  * **Extremal Clause:** Nothing is in the set being defined unless it got there by a finite number of uses of the first two cases

# The Natural Numbers

* The set of natural numbers, $\mathbb{N}$, is defined as follows
  * **Base Case:** $0 \in \mathbb{N}$
  * **Induction case:** $x \in \mathbb{N} \to x + 1 \in \mathbb{N}$
  * **Extremal clause:** nothing is an element of the set $\mathbb{N}$ unless it can be constructed with a finite number of uses of the base and induction cases.

\vskip.5em

* We can show that an arbitrary number above and including 0 are in $\mathbb{N}$

  \begin{center}
  $\begin{array}{llr}
  1. & 0 \in \mathbb{N}                      & \textrm{Base Case} \\
  2. & 0 \in \mathbb{N} \to 1 \in \mathbb{N} & instantiation rule, induction case \\
  3. & 1 \in \mathbb{N}                      & \textrm{1, 2, Modus Ponens} \\
  4. & 1 \in \mathbb{N} \to 2 \in \mathbb{N} & \textrm{instantiation rule, induction case} \\
  5. & 2 \in \mathbb{N}                      & \textrm{3, 4, Modus Ponens}
  \end{array}$
  \end{center}

<!--
# Exercises
-->

# Binary Machine Words

* Let $BinDigit$ be the set $\{0, 1\}$. The set $BinWords$ of machine words in binary is defined as follows:
  * **Base Case:** $x \in \texttt{BinDigit} \to x \in \texttt{BinWords}$
  * **Induction Case:** if $x$ is a binary digit and $y$ is a binary word, then their concatenation $xy$ is also a binary word

    \begin{equation*}
    \left(x \in \texttt{BinDigit} \land y \in \texttt{BinWords}\right) \to xy \in \texttt{BinWords}
    \end{equation*}

  * **Extremal Clause:** Nothing is an element of `BinWords` unless it can be constructed with a finite number of uses of the base and induction cases

\vskip.5em

* A set based on another set $S$ in this way is given the name $S^{+}$
  * it is the set of all possible non-empty strings over $S$
  * $S^{*}$ is similar to $S^{+}$ except $S^{*}$ includes the empty string
  * `BinWords` could have also been written as $\texttt{BinDigit}^{+}$

# Haskell Implementation

* We can define a function to create two new `BinWords` based on one that has been provided
  * i.e., given `[1, 0]` it will return `[0, 1, 0]` and `[1, 1, 0]`

    ```haskell
    newBinaryWords :: [Integer] -> [[Integer]]
    newBinaryWords ys = [0:ys, 1:ys]
    ```

* We then define the set of `BinWords` as:

  ```haskell
  mappend :: (a -> [b]) -> [a] -> [b]
  mappend f []     = []
  mappend f (x:xs) = f x ++ mappend f xs

  binWords = [0] : [1] : (mappend newBinaryWords binWords)
  ```

# The Set of Integers

* Both of the prior sets are **well-founded**, meaning they are infinite in only one direction, and they have a *least* element
* **Countable Set:** a set which can be counted using the natural numbers
  * Are the integers countable?
    * Doesn't have a least element
    * Infinite in two directions
  * However we can count hem using natural numbers as follows:
    * Start at 0
    * For every number $n \in \mathbb{N}$, we count both $n$ and $-n$ in $\mathbb{Z}$
  * That is, we can consider the set of integers as an infinitely long tape folded in half at 0, and then count the overlapping numbers $\left(i, -i\right)$ for each $i \in \mathbb{N}$
* Yet, this does not specify $\mathbb{Z}$

# The Set of Integers

::: columns
:::: column

* The set $\mathbb{Z}$ of integer is defined as follows:
  * **Base Case:** $0 \in \mathbb{Z}$
  * **Induction Case:** $\left(x \in \mathbb{Z} \land x \geq 0\right) \to x + 1 \in \mathbb{Z} \land -(x + 1) \in \mathbb{Z}$
  * **Extremal Clause:** nothing is in $\mathbb{Z}$ unless its presence is justified by a finite number of uses of the base and induction cases

::::
:::: column

Thus, we can define integers using Haskell, as follows

\scriptsize
```haskell
    build :: a -> (a -> a) -> Set a
    build a f = set
        where set = a : map f set

    builds :: a -> (a -> [a]) -> Set a
    builds a f = set
        where set = a : mappend f set

    nextInteger :: Integer -> [Integer]
    nextInteger x
      = if x > 0 \/ x == 0
          then [x + 1, -(x + 1)]
          else []

    integer :: [Integer]
    integers = builds 0 next Integers
```

::::
:::

#

\titleslide{.375\textwidth}{Matrices}

# Matrices

* **Matrix:** a rectangular array of numbers.
  * Matrix with $m$ rows and $n$ columns is called an $m \times n$ matrix
  * Matrix with the same number of rows and columns is called *square*.
  * Two matrices are equal if they have the same number of rows and the same number of columns and the corresponding entries in every position are equal

* **Example:** a $3 \times 2$ matrix

  \vskip.5em

  $\begin{bmatrix}
  1 & 1 \\
  0 & 2 \\
  1 & 3 \\
  \end{bmatrix}$

# Matrices

::: columns
:::: column

Let $m$ and $n$ be positive integers and let

\begin{equation*}
\mathbf{A} = \begin{bmatrix}
             a_{11} & a_{12} & \ldots & a_{1n} \\
             a_{21} & a_{22} & \ldots & a_{2n} \\
             \cdot & \cdot & & \cdot \\
             \cdot & \cdot & & \cdot \\
             \cdot & \cdot & & \cdot \\
             a_{m1} & a_{m2} & \ldots & a_{mn}
             \end{bmatrix}
\end{equation*}

::::
:::: column

The $i$th *row* of $\mathbf{A}$ is the $1 \times n$ matrix $[a_{i1}, a_{i2}, \ldots, a_{in}]$. The $j$th *column* of $\mathbf{A}$ is the $m \times 1$ matrix

\begin{equation*}
\begin{bmatrix}
a{1j} \\
a_{2j} \\
\cdot \\
\cdot \\
\cdot \\
a_{mj}
\end{bmatrix}
\end{equation*}

::::
:::

\vskip.5em

* The ($i$, $j$)th *element* or *entry* of $\mathbf{A}$ is the element $a_{ij}$, that is, the number in the $i$th row and $j$th column of $\mathbf{A}$. A convenient shorthand notation for expressing the matrix $\mathbf{A}$ is to write $\mathbf{A} = [a_{ij}]$, which indicates that $\mathbf{A}$ is the matrix with its ($i$, $j$)th element equal to $a_{ij}$


# Matrix Sums

Let $\mathbf{A} = [a_{ij}]$ and $\mathbf{B} = [b_{ij}]$ be $m \times n$ matrices:

* **Sum:** the *sum* of $\mathbf{A}$ and $\mathbf{B}$, denoted $\mathbf{A} + \mathbf{B}$, is the $m \times n$ matrix that has $a_{ij} + b_{ij}$ as its ($i$, $j$)th element.
  * That is, $\mathbf{A} + \mathbf{B} = [a_{ij} + b_{ij}]$

    $$
    \begin{bmatrix}
    1 & 0 & -1 \\
    2 & 2 & -3 \\
    3 & 4 & 0
    \end{bmatrix} +
    \begin{bmatrix}
    3 & 4 & -1 \\
    1 & -3 & 0 \\
    - & 1 & 2
    \end{bmatrix} =
    \begin{bmatrix}
    4 & 4 & -2 \\
    3 & -1 & -3 \\
    2 & 5 & 2
    \end{bmatrix}
    $$

# Matrix Multiplication

* Let $\mathbf{A}$ be an $m \times k$ matrix and $\mathbf{B}$ be a $k \times n$ matrix. The *product* of $\mathbf{A}$ and $\mathbf{B}$, denoted by $\mathbf{AB}$, is the $m \times n$ matrix with its ($i$, $j$)th entry equalt to the sum of the products of the corresponding elements from the $i$th row of $\mathbf{A}$ and the $j$th column of $\mathbf{B}$. That is, if $\mathbf{AB} = [c_{ij}]$, then

  $$c_{ij} = a_{i1}b_{1j} + a_{i2}b_{2j} + \ldots + a_{ik}b_{kj}$$

\begin{equation*}
\begin{bmatrix}
a_{11} & a_{12} & \ldots & a_{1k} \\
a_{21} & a_{22} & \ldots & a_{2k} \\
\vdots & \vdots &        & \vdots \\
\color{Roarange}\mathbf{a_{i1}} & \color{Roarange}\mathbf{a_{i2}} & \ldots & \color{Roarange}\mathbf{a_{ik}} \\
\vdots & \vdots &        & \vdots \\
a_{m1} & a_{m2} & \ldots & a_{mk}
\end{bmatrix}
\begin{bmatrix}
b_{11} & b_{12} & \ldots & \color{Roarange}\mathbf{b_{1j}} & \ldots & b_{1n} \\
b_{21} & b_{22} & \ldots & \color{Roarange}\mathbf{b_{2j}} & \ldots & b_{2n} \\
\vdots & \vdots &        & \vdots                          &        & \vdots \\
b_{k1} & b_{k2} & \ldots & \color{Roarange}\mathbf{b_{kj}} & \ldots & b_{kn}
\end{bmatrix} =
\begin{bmatrix}
c_{11} & c_{12} & \ldots & c_{1n} \\
c_{11} & c_{12} & \ldots & c_{1n} \\
\vdots & \vdots & \color{Roarange}\mathbf{c_{ij}} & \vdots \\
c_{m1} & c_{m2} & \ldots & c_{mn}
\end{bmatrix}
\end{equation*}

# Example

Let,

\begin{equation*}
\mathbf{A} = \begin{bmatrix}
             1 & 0 & 4 \\
             2 & 1 & 1 \\
             3 & 1 & 0 \\
             0 & 2 & 2
             \end{bmatrix}
\text{\hspace{1em}and\hspace{1em}}
\mathbf{B} = \begin{bmatrix}
             2 & 4 \\
             1 & 1 \\
             3 & 0
             \end{bmatrix}
\end{equation*}

\begin{equation*}
\mathbf{AB} = \begin{bmatrix}
              (1 \cdot 2) + (0 \cdot 1) + (4 \cdot 3) & (1 \cdot 4) + (0 \cdot 1) + (4 \cdot 0) \\
              (2 \cdot 2) + (1 \cdot 1) + (1 \cdot 3) & (2 \cdot 4) + (1 \cdot 1) + (1 \cdot 0) \\
              (2 \cdot 3) + (1 \cdot 1) + (0 \cdot 3) & (3 \cdot 4) + (1 \cdot 1) + (0 \cdot 0) \\
              (0 \cdot 2) + (2 \cdot 1) + (2 \cdot 3) & (0 \cdot 4) + (2 \cdot 1) + (2 \cdot 0)
              \end{bmatrix}
\end{equation*}

\begin{equation*}
\mathbf{AB} = \begin{bmatrix}
              14 & 4 \\
              8 & 9 \\
              7 & 13 \\
              8 & 2
              \end{bmatrix}
\end{equation*}

# Matrix Identity and Powers

* **Identity Matrix of Order $n$ ($\mathbf{I}_n$):** is the $n \times n$ matrix $\mathbf{I}_n = [\delta_{ij}]$, (the *Kronecker delta*) where $\delta_{ij} = 1$ if $i = j$ and $\delta_{ij} = 0$ if $i \ne j$. Hence

::: columns
:::: column

  \begin{equation*}
  \mathbf{I}_n = \begin{bmatrix}
                 1 & 0 & \ldots & 0 \\
                 0 & 1 & \ldots & 0 \\
                 \cdot & \cdot & & \cdot \\
                 \cdot & \cdot & & \cdot \\
                 \cdot & \cdot & & \cdot \\
                 0 & 0 & \ldots & 1
                 \end{bmatrix}
  \end{equation*}

* Multiplying a matrix by its identity matrix does not change the matrix: $\mathbf{AI}_n = \mathbf{I}_m\mathbf{A} = \mathbf{A}$

::::
:::: column

* Powers of a square matrix can be defined because matrix multiplication is associative:
  * $\mathbf{A}^0 = \mathbf{I}_n$
  * $\mathbf{A}^r = \mathbf{AAA\ldots A}$

::::
:::

# Transpose and Symmetry

::: columns
:::: column

* **Transpose:** Let $\mathbf{A} = [a_{ij}]$ be an $m \times n$ matrix. The *transpose* of $\mathbf{A}$, denoted by $\mathbf{A}^T$, is the $n \times m$ matrix obtained by interchanging the rows and columns of $\mathbf{A}$.
  * That is, if $\mathbf{A}^T = [b_{ij}]$, then $b_{ij} = a_{ij}$ for $i = 1,2,\ldots,n$ and $j = 1,2,\ldots,m$

  \begin{equation*}
  \mathbf{A} = \begin{bmatrix}
               1 & 2 & 3 \\
               4 & 5 & 6
               \end{bmatrix}
  \text{\hspace{1em}}
  \mathbf{A}^T = \begin{bmatrix}
                 1 & 4 \\
                 2 & 5 \\
                 3 & 6
                 \end{bmatrix}
  \end{equation*}

::::
:::: column

* **Symmetric:** A square matrix $\mathbf{A}$ is called *symmetric* if $\mathbf{A} = \mathbf{A}^T$. Thus, $\mathbf{A} = [a_{ij}]$ if $a_{ij} = a_{ji}$ for all $i$ and $j$ with $1 \leq i \leq n$ and $1 \leq j \leq n$.

  - **Example:**

    $$\begin{bmatrix}
      1 & 1 & 0 \\
      1 & 0 & 1 \\
      0 & 1 & 0
      \end{bmatrix}$$

::::
:::

# Zero-One Matrices

* **Zero-One Matrix:** a matrix all of whose entries are either 0 or 1
* Arithmetic on these matrices is base on the Boolean operations $\land$ and $\lor$

  $$
  b_1 \land b_2 = \begin{cases}
                  1 & \text{if $b_1 = b_2 = 1$} \\
                  0 & \text{otherwise}
                  \end{cases}
  \text{\hspace{3em}}
  b_1 \lor b_2 = \begin{cases}
                 1 & \text{if $b_1 = 1$ or $b_2 = 1$} \\
                 0 & \text{otherwise}
                 \end{cases}
  $$

# Zero-One Matrix Arithmetic

Let $\mathbf{A} = [a_{ij}]$ and $\mathbf{B} = [b_ij]$ be $m \times n$ zero-one matrices

$$
\mathbf{A} = \begin{bmatrix}
             1 & 0 & 1 \\
             0 & 1 & 0
             \end{bmatrix},
\text{\hspace{3em}}
\mathbf{B} = \begin{bmatrix}
             0 & 1 & 0 \\
             1 & 1 & 0
             \end{bmatrix}
$$

\vskip.5em

::: columns
:::: column

**Join:** the *join* of $\mathbf{A}$ and $\mathbf{B}$, denoted $\mathbf{A} \lor \mathbf{B}$, is the zero-one matrix with ($i$, $j$)th entry $a_{ij} \lor b_{ij}$

  $$
  \mathbf{A} \lor \mathbf{B} = \begin{bmatrix}
                               1 \lor 0 & 0 \lor 1 & 1 \lor 0 \\
                               0 \lor 1 & 1 \lor 1 & 0 \lor 0
                               \end{bmatrix} =
                               \begin{bmatrix}
                               1 & 1 & 1 \\
                               1 & 1 & 0
                               \end{bmatrix}
  $$

::::
:::: column

**Merge:** the *merge* of $\mathbf{A}$ and $\mathbf{B}$, denoted $\mathbf{A} \land \mathbf{B}$, is the zero-one matrix with ($i$, $j$)th entry $a_{ij} \land b_{ij}$

  $$
  \mathbf{A} \land \mathbf{B} = \begin{bmatrix}
                                1 \land 0 & 0 \land 1 & 1 \land 0 \\
                                0 \land 1 & 1 \land 1 & 0 \land 0
                                \end{bmatrix} =
                                \begin{bmatrix}
                                0 & 0 & 0 \\
                                0 & 1 & 0
                                \end{bmatrix}
  $$

::::
:::

# Zero-One Matrix Product

* Let $\mathbf{A} = [a_{ij}]$ be an $m \times n$ zero-one matrix and $\mathbf{B} = [b_{ij}]$ be a $k \times n$ zero-one matrix. Then the **Boolean product** of $\mathbf{A}$ and $\mathbf{B}$, denoted by $\mathbf{A} \odot \mathbf{B}$, is the $m \times n$ matrix with ($i$, $j$)th entry $c_{ij}$ where

$$c_{ij} = (a_{i1} \land b_{1j}) \lor (a_{i2} \land b_{2j}) \lor \ldots \lor (a_{ik} \land b_{kj})$$

::: columns
:::: {.column width=.3}

\footnotesize

**Example:** Find the Boolean product of $\mathbf{A} \odot \mathbf{B}$

$$
\mathbf{A} = \begin{bmatrix}
             1 & 0 \\
             0 & 1 \\
             1 & 0
             \end{bmatrix},
\text{\hspace{1em}}
\mathbf{B} = \begin{bmatrix}
             1 & 1 & 0 \\
             0 & 1 & 1
             \end{bmatrix}
$$

::::
:::: {.column width=.7}

\footnotesize

\begin{equation*}
\begin{array}{rcl}

\mathbf{A} \odot \mathbf{B} & = & \begin{bmatrix}
                                  (1 \land 1) \lor (0 \land 0) & (1 \land 1) \lor (0 \land 1) & (1 \land 0) \lor (0 \land 1) \\
                                  (0 \land 1) \lor (1 \land 0) & (0 \land 1) \lor (1 \land 1) & (0 \land 0) \lor (1 \land 1) \\
                                  (1 \land 1) \lor (0 \land 0) & (1 \land 1) \lor (0 \land 1) & (1 \land 0) \lor (0 \land 1)
                                  \end{bmatrix} \\
                            & = & \begin{bmatrix}
                                  1 \lor 0 & 1 \lor 0 & 0 \lor 0 \\
                                  0 \lor 0 & 0 \lor 1 & 0 \lor 1 \\
                                  1 \lor 0 & 1 \lor 0 & 0 \lor 0
                                  \end{bmatrix} \\
                            & = & \begin{bmatrix}
                                  1 & 1 & 0 \\
                                  0 & 1 & 1 \\
                                  1 & 1 & 0
                                  \end{bmatrix}
\end{array}
\end{equation*}

::::
:::

# For Next Time

::: columns
:::: column
* Review DMUC Chapters 4, 9 and 11
* Review DMA Chapters 2.3 - 2.5 and 5.1 - 5.2
* Review this Lecture
* Read DMUC Chapter 11.2.3, 11.2.4, 11.3 - 11.4
* Read DMA Chapters 2.6, 4, 5.5
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
