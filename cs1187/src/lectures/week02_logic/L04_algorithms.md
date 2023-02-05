---
author:
- Dr. Isaac Griffith
title: Algorithms
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Overview

* **Computer Science** $\equiv$ The study of algorithms.

* **Algorithm** $\equiv$ A finite set of precise instructions for performing computations or for solving a problem

* **Computational Complexity** $\equiv$ Time and Space
  - **Time Complexity** $\equiv$ An analysis of the time required to solve a problem of a particular size.
    * Can be expressed in terms of the number of steps or operations for a given size
  - **Space Complexity** $\equiv$ An analysis of the computer memory required

# Properties of Algorithms

* **Input**: An algorithm has input values from a specific set
* **Output**: From each set of inputs values an algorithm produces output values from a specific set.
  - These output values are the solution to the problem
* **Definiteness**: The steps of an algorithm must be precisely defined.
* **Correctness**: An algorithm should produce the correct output values for each set of input values.
* **Finiteness**: An algorithm should produce the desired output after a finite number of steps for any input in the set.
* **Effectiveness**: It must be possible to perform each step of an algorithm exactly and in a finite amount of time.
* **Generality**: The procedure should be applicable for all problems of the desired form, not just for a particular set of values.

# Frequency Count

# Linear Search

\begin{algorithmic}
\Procedure{linearSearch}{$x,a_1,a_x,\ldots,a_n,Loc$}
  \State $i \gets 1$
  \While{$i \leq n$ \textbf{and} $x \ne a_i$}
    \State $i \gets i + 1$
  \EndWhile
  \If{$i \leq n$}
    \State $Loc \gets i$
  \Else
    \State $Loc \gets 0$
  \EndIf
\EndProcedure
\end{algorithmic}

* **Time-Complexity** $\equiv$ Number of Comparisons $= 2n + 1$
  - If $x$ is not in the list, then $2n + 2$

# Binary Search

* **Idea**: compare with middle item in list. Decide which sublist that x belongs to. Repeat the process until $|List|$ becomes 1.

::: columns
:::: column

\footnotesize

\begin{algorithmic}
\Procedure{binarySearch}{$x, a_1, a_2, \ldots, a_n, Loc$}
  \State $i \gets 1$
  \State $j \gets n$

  \While{$i < j$}
    \State $m \gets \lfloor(i + j) / 2\rfloor$
    \If{$x > a_m$}
      \State $i \gets m + 1$
    \Else
      \State $j \gets m$
    \EndIf
  \EndWhile

  \If{$x = a_i$}
    \State $Loc \gets i$
  \Else
    \State $Loc \gets 0$
  \EndIf
\EndProcedure
\end{algorithmic}

**Time-Complexity** $\equiv$ $2 \log n + 2$

::::
:::: column

**Example**

\footnotesize

```
x = 17, n = 16
L = [1 2 3 4 6 7 8 10 12 13 14 15 16 17 18]
                   |
                   m
10 < 17 -> right
[12 13 14 15 16 17 18]
          |
          m   
15 < 17 -> right
[16 17 18]
    |
    m
17 = 17 -> found
```
::::
:::

# Bubble Sort

::: columns
:::: column

\begin{algorithmic}
\Procedure{bubbleSort}{$a_1, a_2, \ldots, a_n$}
  \For{$i \gets 1$ \textbf{to} $n - 1$}
    \For{$j \gets 1$ \textbf{to} $n - i$}
      \If{$a_j > a_{j+1}$}
        \State $a_j \leftrightarrow a_{j+1}$
      \EndIf
    \EndFor
  \EndFor
\EndProcedure
\end{algorithmic}

**Time Complexity**
\vskip-2em
$$ (n - 1) + (n - 2) + \ldots + 2 + 1 = \frac{(n - 1)\cdot n}{2} = O(n^2) $$

::::
:::: column

**Example**

::::
:::

# Insertion Sort

::: columns
:::: column

\begin{algorithmic}
\Procedure{insertionSort}{$a_1, a_2, \ldots, a_n : \mathbb{R}\,\textrm{with}\, n \geq 2$}
  \For{$j \gets 2$ \textbf{to} $n$}
    \State $i \gets 1$
    \While{$a_j > a_i$}
      \State $i \gets i + 1$
    \EndWhile
    \State $m \gets a_j$
    \For{$k \gets 0$ \textbf{to} $j - i - 1$}
      \State $a_{j - k} \gets a_{j - k - 1}$
    \EndFor
    \State $a_j \gets m$
  \EndFor
\EndProcedure
\end{algorithmic}

**Time Complexity**

$1 + 2 + \ldots + (n + 1) = \frac{n(n - 1)}{2} = O(n^2)$

::::
:::: column

**Example**

::::
:::

# Greedy Algorithms

#

Growth of Functions

# Motivation

::: columns
:::: column

**Example:** $n^2$ vs. $\frac{2^n}{4}$

if $n < 8$ then $n^2 > \frac{2^n}{4}$

if $n = 8$ then $n^2 = \frac{2^n}{4}$

if $n > 8$ then $n^2 < \frac{2^n}{4}$

::::
:::: column

\centering

\begin{tikzpicture}

\begin{axis}[
  axis lines = left,
  xlabel = \(n\),
  ylabel = {\(T(n)\)},
  xtick={0,8},
  %xmin=0,
  %ymin=0,
]

\addplot [
  domain=0:10,
  samples=100,
  color=GrowlingGray,
]
{x^2};

\addplot [
  domain=0:10,
  samples=100,
  color=Roarange,
]
{(2^x)/4};
\end{axis}
\end{tikzpicture}

::::
:::

# Bounds

## **O**: Upper bound

$f(n) = O(g(n))$ iff there exists constants $c$ and $k$ such that:

$$|f(n)| \leq c|g(n)|\,\textrm{for}\,n \geq k$$

<!-- * **Note:** we need only find one pair of constants $c$ and $k$ -->

## **$\Omega$**: Lower bound

$f(n) = \Omega(g(n))$ iff there exists constants $c$ and $k$ such that

$$|f(n)| \geq c|g(n)|\,\textrm{for}\,n \geq k$$

## **$\Theta$**: Exact bound

$f(n) = \Theta(g(n))$ iff there exists positive constants $c_1$, $c_2$, and $k$ such that

$$|c_1 g(n) \leq f(n) \leq c_2 g(n)\,\textrm{for}\,n \geq k$$

# Example



# Example

# Example

# Theorem 1

# Time Complexity

\centering

\begin{tikzpicture}
\begin{axis}[
  axis lines = left,
  height=7cm,
  width=\textwidth-2cm,
  xlabel = \(n\),
  ylabel = {\(T(n)\)},
  %xtick={0,8},
  %xmin=0,
  %ymin=0,
  ymax=500
]

%\addplot [
%  domain=0:10,
%  samples=100,
%  color=GrowlingGray,
%]
%{factorial(x)};

\addplot [
  domain=0:10,
  samples=100,
  color=Roarange,
]
{2^x};

\addplot [
  domain=0:10,
  samples=100,
  color=Roarange,
]
{x^3};

\addplot [
  domain=0:10,
  samples=100,
  color=Roarange,
]
{x^2};

\addplot [
  domain=0:10,
  samples=100,
  color=Roarange,
]
{x * log2(x)};

\addplot [
  domain=0:10,
  samples=100,
  color=Roarange,
]
{x};

\addplot [
  domain=0:10,
  samples=100,
  color=Roarange
]
{log2(x)};

\addplot [
  domain=0:10,
  samples=100,
  color=Roarange
]
{1};

\end{axis}
\end{tikzpicture}
