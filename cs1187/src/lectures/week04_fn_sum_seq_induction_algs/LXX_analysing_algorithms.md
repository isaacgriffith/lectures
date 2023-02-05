---
author:
- Dr. Isaac Griffith
title: Algorithm Analysis and Midterm Review
course: CS 1187
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

#

\titleslide{.55\textwidth}{Growth of Functions}

# Big-O Notation


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

**O**: Upper bound

* $f(n) = O(g(n))$ iff there exists constants $c$ and $k$ such that:

  $$|f(n)| \leq c|g(n)|\,\textrm{for}\,n \geq k$$

* **Note:** we need only find one pair of constants $c$ and $k$
* **Note:** $O()$ is asymptotic

**$\Omega$**: Lower bound

* $f(n) = \Omega(g(n))$ iff there exists constants $c$ and $k$ such that

  $$|f(n)| \geq c|g(n)|\,\textrm{for}\,n \geq k$$

**$\Theta$**: Exact bound

* $f(n) = \Theta(g(n))$ iff there exists positive constants $c_1$, $c_2$, and $k$ such that

  $$c_1 |g(n)| \leq |f(n)| \leq c_2 |g(n)|\,\textrm{for}\,n \geq k$$

# Example

# Example

$$\begin{array}{rcl}
  f(n) & = & 5n^3 + 2n^2 + 22n + 6 \\
  f(n) & = & O(n^3)
  \end{array}$$

**Proof:** Let $C = 6$, we want to find the smallest $n$ such that $6n^3 > 5n^3 + 2n^2 + 22n + 6$

# Example

# Big-O

* **Theorem:** Let $f(x) = a_{n}x^{n} + a_{n-1}x^{n-1} + \ldots + a_{1}x_{1} + a_{0}$ then **$f(n) = O(x^{n})$**

* **Examples:**

  ::: columns
  :::: {.column width=.05}
  ::::
  :::: {.column width=.475}

  $\begin{array}{rcl}
  1 + 2 + \ldots + n & & \\
  1 + 2 + \ldots + n & \leq & n + n + n + \ldots + n = n^2 \\
  \therefore 1 + 2 + \ldots + n & = & O(n^2),\,\,c = 1,\,\,k=1
  \end{array}$

  \vskip1em

  $\begin{array}{rcl}
  n! = 1 \cdot 2 \cdot 3 \cdot \ldots \cdot n & & \\
  n! = 1 \cdot 2 \cdot 3 \cdot \ldots \cdot n & \leq & n \cdot n \cdot n \cdot \ldots \cdot n = n^n \\
  \therefore n! & = & O(n^n),\,\, c = 1,\,\, k = 1
  \end{array}$

  \vskip1em

  ::::
  :::: {.column width=.475}

  $\begin{array}{rcl}
  f(x) & = & 3n \log (n!) + (n^2 + 3) \log n \\
       & = & O(n \log n) + O(n^2 \log n) \\
       & = & O(n^2 \log n) \\
       & \therefore & O(n^2 \log n)
  \end{array}$

  \vskip.5em

  **Note:** $\log n! \leq \log n^n = n \log n$

  \vskip1em

  $\begin{array}{rcl}
  f(x) & = & (x + 1) \log (x^2 + 1) + 3x^2 \\
       & = & O(x \log x) + O(x^2) \\
       & \therefore & O(x^2)
  \end{array}$

  ::::
  :::

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

#

\titleslide{.575\textwidth}{Program Correctness}
