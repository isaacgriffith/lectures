---
author:
- Dr. Isaac Griffith
title: Functions, Sequences, Summations, and Induction
course: CS 1187
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Inspiration

> "The full beauty of the subject of generating functions emerges only from tuning in on both channels: the discrete and the continuous." -- Herbert Wilf


# Outline

The lecture if structured as follows:

::: columns
:::: {.column width=.7}
* Functions
* Sequences and Summations
* Induction
* Defining Sets Inductively
::::
:::: {.column width=.25}
\vfill
\vspace{7.25em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\titleslide{.375\textwidth}{Functions}

# Functions

* A **function** from set $A$ to set $B$ is an assignment of exactly one element of $B$ to each element of $A$
  - We write $f(a) = b$ if $b$ is an unique element of $B$ assigned by the function $f$ to the element $a$ of $A$.
  - If $f$ is a function from $A$ to $B$, we write $f : A \to B$
  - Functions are also called *mappings* or *transformations*
  - **Note:** a function is a special kind of relation

\vskip.5em
\centering
\includegraphics[width=.45\textwidth]{images/fns/fn_def.eps}

# Functions

::: columns
:::: column

* For a function $f : A \to B$ (read as "$f$ **maps** $A$ to $B$")
  * **Domain** of $f$ is $A$
    * $domain\,\,f = \{x\,\,|\,\,\exists y.\,\,(x,y) \in f\}$
  * **Codomain** of $f$ is $B$ (also called the *range* or *image* of $f$)

\vskip.5em

* If $f(a) = b$, we say that
  * $b$ is the **image** of $a$ and $a$ is the **preimage** of $b$
    * $image\,\,f = \{y\,\,|\,\,\exists x.\,\,(x,y) \in f\}$
  * **range** or **image** of $f$ is the set of all images of elements of $A$

::::
:::: column

**Example:** $f: \mathbb{Z} \to \mathbb{Z}$, where $f(x) = x^2$

\vskip.5em

\centering
\includegraphics[width =.85\textwidth]{images/fns/fn_x2.eps}

::::
:::

# Functions

* Let $f_1$ and $f_2$ be functions from $A$ to $\mathbb{R}$. Then $f_1 + f_2$ and $f_1\cdot f_2$ are also functions from $A$ to $\mathbb{R}$ defined for all $x \in A$ by:

  * $\left(f_1 + f_2\right)(x) = f_1(x) + f_2(x)$
  * $\left(f_1 \cdot f_2\right)(x) = f_1(x) \cdot f_2(x)$

\vskip.5em

* **Example:** $f_1,f_2: \mathbb{R} \to \mathbb{R}$
  - $f_1(x) = x^2$, $f_2(x) = x - x^2$

  $\begin{array}{rcl}
  (f_1 + f_2)(x) & = & f_1(x) + f_2(x) = x^2 + (x - x^2) = x \\
  (f_1 \cdot f_2)(x) & = & f_1(x) \cdot f_2(x) = x^2(x - x^2) = x^3 - x^4
  \end{array}$

\vskip.5em

* Let $f : A \to B$ and $S \subseteq A$. The **image** of $S$ under $f$ is the subset $B$ that consists of the images of elements of $S$. We denote the image of $S$ by $f(S)$, so

  $$f(S) = \{t\,\,|\,\,\exists s \in S (t = f(s))\}$$

  - The shorthand for this is $\{f(s)\,\,|\,\,s \in S\}$ (where $f(s)$ is a set not a function)

# Inductively Defined Functions

* A function in the following form, where $h$ is a non-recursive function, is **inductively defined**:

::: columns
:::: column

\begin{center}
$\begin{array}{rcl}
f(0) & = & k \\
f(n) & = & h(f(n - 1))
\end{array}$
\end{center}

::::
:::: column

```haskell
f 0 = 0
f n = n + f (n - 1)
```

::::
:::

\vskip.5em

* A function $f$ is **primitive recursive** if its definition has the following form, where $g$ and $h$ are primitive recursive functions.

::: columns
:::: column

\begin{center}
$\begin{array}{rcl}
f(0, x) & = & g(x) \\
f((k + 1, x) & = & h(f(k, x), k x)
\end{array}$
\end{center}

::::
:::: column

```haskell
factorial k = f k undefined
where f 0 x = 1
      f (k + 1) x = (k + 1) * (f k x)
```
::::
:::

# Primitive Recursion Example

\begin{center}
$\begin{array}{rl}
& factorial\,\,4 \\
= & 4 \times f\,\,3\,\,\bot \\
= & 4 \times (3 \times f\,\,2\,\,\bot) \\
= & 4 \times (3 \times (2 \times f\,\,1\,\,\bot)) \\
= & 4 \times (3 \times (2 \times (1 \times f\,\,0\,\,\bot))) \\
= & 4 \times (3 \times (2 \times (1 \times 1))) \\
= & 4 \times (3 \times (2 \times 1)) \\
= & 4 \times (3 \times 2) \\
= & 4 \times 6 \\
= & 24
\end{array}$
\end{center}

# One-to-One (Injective)

* A function $f$ is said to be **one-to-one**, or an **injection**, iff $f(a) = f(b)$ implies $a = b$ for all $a$ and $b$ in the domain of $f$.
  * A function is said to be **injective** if it is one-to-one.
  * We could also say the holds if $f(x) \ne f(y)$ whenever $x \ne y$

\vskip.5em

::: columns
:::: column

\scriptsize

**Example:** Determine whether the function $f$ from $\{a, b, c, d\}$ to $\{1,2,3,4,5\}$ with $f(a) = 4$, $f(b) = 5$, $f(c) = 1$, and $f(d) = 3$ is one-to-one.

\normalsize

::::: columns
:::::: column

\vspace{-1em}

\begin{center}
\begin{tikzpicture}
  \node[ellipse,
    draw = white,
    thick,
    text = white,
    minimum width = 1cm,
    minimum height = 2.5cm] (A) at (0,0) {};

  \node[ellipse,
    draw = white,
    thick,
    text = white,
    minimum width = 1cm,
    minimum height = 3cm] (B) at (2,0) {};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]A.south) {D};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]B.south) {R};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]A.north) (a) {a};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]a.south) (b) {b};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]b.south) (c) {c};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]c.south) (d) {d};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]B.north) (r1) {1};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]r1.south) (r2) {2};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]r2.south) (r3) {3};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]r3.south) (r4) {4};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]r4.south) (r5) {5};

  \draw[-latex, thick, Roarange] (a.east) -- (r4.west) {};
  \draw[-latex, thick, Roarange] (b.east) -- (r5.west) {};
  \draw[-latex, thick, Roarange] (c.east) -- (r1.west) {};
  \draw[-latex, thick, Roarange] (d.east) -- (r3.west) {};
\end{tikzpicture}
\end{center}

::::::
:::::: column

\scriptsize

*Solution*: $f$ is one-to-one since $f$ takes on different values at the four elements of its domain.

::::::
:::::

::::
:::: column

\scriptsize

**Example:** Determine whether $f(x^2)$ is one-to-one

::::: columns
:::::: column

function $x^2$

\begin{center}
\begin{tikzpicture}
  \node[ellipse,
    draw = white,
    thick,
    text = white,
    minimum width = 1cm,
    minimum height = 3cm] (A) at (0,0) {};

  \node[ellipse,
    draw = white,
    thick,
    text = white,
    minimum width = 1cm,
    minimum height = 3.1cm] (B) at (2,0) {};

  \node[anchor=north,
    font=\color{white}\footnotesize]
    at ([yshift=-2pt]A.south) {D};

  \node[anchor=north,
    font=\color{white}\footnotesize]
    at ([yshift=-2pt]B.south) {R};

  \node[anchor=north,
    font=\color{white}\footnotesize]
    at ([yshift=-2pt]A.north) (a) {-1};

  \node[anchor=north,
    font=\color{white}\footnotesize]
    at ([yshift=-2pt]a.south) (b) {0};

  \node[anchor=north,
    font=\color{white}\footnotesize]
    at ([yshift=-2pt]b.south) (c) {1};

  \node[anchor=north,
    font=\color{white}\footnotesize]
    at ([yshift=-2pt]c.south) (d) {2};

  \node[anchor=north,
    font=\color{white}\footnotesize]
    at ([yshift=2pt]d.south) (e) {$\vdots$};

  \node[anchor=north,
    font=\color{white}\footnotesize]
    at ([yshift=-1pt]B.north) (r1) {0};

  \node[anchor=north,
    font=\color{white}\footnotesize]
    at (r1.south) (r2) {1};

  \node[anchor=north,
    font=\color{white}\footnotesize]
    at (r2.south) (r3) {2};

  \node[anchor=north,
    font=\color{white}\footnotesize]
    at (r3.south) (r4) {3};

  \node[anchor=north,
    font=\color{white}\footnotesize]
    at (r4.south) (r5) {4};

  \node[anchor=north,
    font=\color{white}\footnotesize]
    at ([yshift=4pt]r5.south) (r6) {$\vdots$};

  \draw[-latex, thick, Roarange] (a.east) -- (r2.west) {};
  \draw[-latex, thick, Roarange] (b.east) -- (r1.west) {};
  \draw[-latex, thick, Roarange] (c.east) -- (r2.west) {};
  \draw[-latex, thick, Roarange] (d.east) -- (r5.west) {};
\end{tikzpicture}
\end{center}

::::::
:::::: column

\vspace{1em}

\centering
\begin{tikzpicture}
  \draw[-latex, thick] (-1, 0) -- (2, 0) node[right] {$x$};
  \draw[-latex, thick] (0, -0.5) -- (0, 2) node[above] {$f(x)$};
  \draw[scale=0.25, domain=-3:3, smooth, thick, variable=\x, Roarange] plot ({\x}, {\x*\x});
  \draw[domain=-1:2, smooth, thick, variable=\x, GrowlingGrayLight] plot ({\x}, {1});
\end{tikzpicture}

\large

*NO!*

::::::
:::::

::::
:::

# One-to-One Conditions

For some function $f$ whose domain and codomain are subsets of $\mathbb{R}$ where $x$ and $y$ are in the domain of $f$, we call $f$:

* **Increasing:** if $f(x) \leq f(y)$ : $\forall x \forall y(x < y \to f(x) \leq f(y))$

\vskip.5em

* **Strictly Increasing:** if $f(x) < f(y)$ : $\forall x \forall y(x < y \to f(x) < f(y))$

\vskip.5em

* **Decreasing:** if $f(x) \geq f(y)$ : $\forall x \forall y(x < y \to f(x) \geq f(y))$

\vskip.5em

* **Strictly Decreasing:** if $f(x) > f(y)$ : $\forall x \forall y(x < y \to f(x) > f(y))$

\vskip.5em

**Example**: Although $f(x) = x^2$ where $f : \mathbb{R} \to \mathbb{R}$ is not one-to-one. When $f : \mathbb{R}^{+} \to \mathbb{R}^{+}$ it is **strictly increasing** and thus *one-to-one*

# Onto (Surjective)

* A function $f : A \to B$ is called **onto**, or a **surjection**, iff for every element $b \in B$ there is an element $a \in A$ with $f(a) = b$.
  * such a function is called **surjective**
  * $\forall y\exists x(f(x) = y)$
  * Every $y$ in the range has a corresponding $x$ in the domain

\vskip.5em

* **Example:** Determine whether the following function is onto

::: columns
:::: {.column width=.1}
::::
:::: {.column width=.25}

\begin{center}
\begin{tikzpicture}
  \node[ellipse,
    draw = white,
    thick,
    text = white,
    minimum width = 1cm,
    minimum height = 2.5cm] (A) at (0,0) {};

  \node[ellipse,
    draw = white,
    thick,
    text = white,
    minimum width = 1cm,
    minimum height = 2cm] (B) at (2,0) {};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]A.south) {D};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]B.south) {R};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]A.north) (a) {a};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]a.south) (b) {b};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]b.south) (c) {c};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]c.south) (d) {d};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]B.north) (r1) {1};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]r1.south) (r2) {2};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]r2.south) (r3) {3};

  \draw[-latex, thick, Roarange] (a.east) -- (r3.west) {};
  \draw[-latex, thick, Roarange] (b.east) -- (r2.west) {};
  \draw[-latex, thick, Roarange] (c.east) -- (r1.west) {};
  \draw[-latex, thick, Roarange] (d.east) -- (r3.west) {};
\end{tikzpicture}
\end{center}

::::
:::: {.column width=.25}

\centering
\Large
\vskip2.5em

*YES!*

::::
:::: {.column width=.4}

* **Haskell Examples:** The following are surjective functions

  ```haskell
  not :: Bool -> Bool
  member v :: [Int] -> Bool
  increment :: Int -> Int
  id :: a -> a
  ```

::::
:::

# Onto and One-to-One (Bijective)

* The function $f$ is a **one-to-one correspondence**, or a **bijection**, if it is both *one-to-one* and *onto*
  * such a function is called **bijective**

\vskip.5em

* **Example:** Determine whether the following function is a bijection

::: columns
:::: {.column width=.1}
::::
:::: {.column width=.25}

\begin{center}
\begin{tikzpicture}
  \node[ellipse,
    draw = white,
    thick,
    text = white,
    minimum width = 1cm,
    minimum height = 2.5cm] (A) at (0,0) {};

  \node[ellipse,
    draw = white,
    thick,
    text = white,
    minimum width = 1cm,
    minimum height = 2.5cm] (B) at (2,0) {};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]A.south) {D};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]B.south) {R};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]A.north) (a) {a};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]a.south) (b) {b};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]b.south) (c) {c};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]c.south) (d) {d};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]B.north) (r1) {1};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]r1.south) (r2) {2};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]r2.south) (r3) {3};

  \node[anchor=north,
    font=\color{white}]
    at ([yshift=-2pt]r3.south) (r4) {4};

  \draw[-latex, thick, Roarange] (a.east) -- (r4.west) {};
  \draw[-latex, thick, Roarange] (b.east) -- (r2.west) {};
  \draw[-latex, thick, Roarange] (c.east) -- (r1.west) {};
  \draw[-latex, thick, Roarange] (d.east) -- (r3.west) {};
\end{tikzpicture}
\end{center}

::::
:::: {.column width=.25}

\centering
\Large
\vskip2.5em

*YES!*

::::
:::: {.column width=.4}
::::
:::

# Proofs about functions

Suppose we have function: $f : A \to B$

* *To show that $f$ is injective*: show that if $f(x) = f(y)$ for arbitrary $x,y \in A$, then $x = y$

\vskip.5em

* *To show that $f$ is not injective*: find particular elements $x, y \in A$ such that $x \ne y$ and $f(x) = f(y)$

\vskip.5em

* *To show that $f$ is surjective*: Consider an arbitrary element $y \in B$ and find an element $x \in A$ such that $f(x) = y$

\vskip.5em

* *To show that $f$ is not surjective*: Find a particular $y \in B$ such that $f(x) \ne y$ for all $x \in A$

# Evaluate Functions

::: columns
:::: column

* The `Stdm` provides some tools to explore the properties of functions
  * **`isSurjective`** which takes a domain and codomain and the graph representation of a function and determines if it is surjective
  * **`isInjective`** which takes a domain and codomain and the graph representation of a function and determines if it is injective
  * **`isBijective`** which takes a domain and codomain and the graph representation of a function and determines if it is bijective
  * **`functionComposition`** takes graph representations of two functions and returns the graph representation of their composition

::::
:::: column

\scriptsize

```haskell
fun_domain = [1,2,3]
fun_codomain = [4,5,6]

fun1 = [(1, Value 4), (2, Value 6), (3, Value 5)]
fun2 = [(1, Value 4), (2, Value 4), (3, Value 5)]
fun3 = [(1, Value 4), (2, Undefined), (3, Value 5)]

isInjective fun_domain fun_codomain
    (functionalComposition fun1 fun2)
isSurjective fun_domain fun_codomain
    (functionalComposition fun1 fun2)
isBijective fun_domain fun_codomain
    (functionalComposition fun1 fun2)
```
::::
:::

# Inverse Functions

* Let $f : A \to B$ be a bijective. The **inverse function** of $f$ is the function that assigns to an element $b \in B$ the unique element $a \in A$ such that $f(a) = b$.
  * We denote the inverse of $f$ as $f^{-1}$.
  * When $f(a) = b$ then $f^{-1}(b) = a$

::: columns
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/fns/fn_inv.eps}

\vskip.5em

* **Example:** $f(x) = x^2$, is $f$ invertible?
  - **Answer:** No, since $f(x) = x^2$ is not one-to-one

::::
:::: column

\vspace{-2em}

**Example:**

::::: columns
:::::: column

\centering
\includegraphics[width=.85\textwidth]{images/fns/inv_fn.eps}

::::::
:::::: column

$\begin{array}{rcl}
f(a) & = & 2 \\
f(b) & = & 3 \\
f(c) & = & 1 \\
f^{-1}(1) & = & c \\
f^{-1}(2) & = & a \\
f^{-1}(3) & = & b
\end{array}$

::::::
:::::

\vskip.5em

**Haskell Example**

\scriptsize

```haskell
increment, decrement :: Integer -> Integer
increment x = x + 1
decrement x = x - 1
```

::::
:::

# Composition of Functions

* Let $g : A \to B$ and let $f : B \to C$. The **composition** of the functions $f$ and $g$, denoted $\forall a \in A$ as $f \circ g$, is the function from $A$ to $C$ defined by:

  $$\left(f \circ g\right) = f(g(a))$$

::: columns
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/fns/fn_comp.eps}

::::
:::: column

**Example:** $f(x) = 2x + 3$ and $g(x) = 3x + 2$

\vskip.5em

\begin{center}
$\begin{array}{rcl}
(f\circ g)(x) & = & f(g(x)) \\
              & = & f(3x + 2) \\
              & = & 2(3x + 2) + 3 \\
              & = & 6x + 7 \\ \\
(g\circ f)(x) & = & g(f(x)) \\
              & = & g(2x_3) \\
              & = & 3(2x + 3) + 2 \\
              & = & 6x + 11
\end{array}$
\end{center}

::::
:::

# Functional Composition

* We can often think of function composition as setting up a processing pipeline.
* Additionally, Functional composition ($\circ$) is associative. That is for all functions $h : a \to b$, $g : b \to c$, $f : c \to d$

\vspace{-.5em}

$$f \circ (g \circ h) = (f \circ g) \circ h$$

* The Haskell function composition operator is:

  \scriptsize

  ```haskell
  (.) :: (b -> c) -> (a -> b) -> (a -> c)
  (f.g) x = f (g x)
  ```

  \normalsize

* **Example**

  \scriptsize

  ```haskell
  -- we could write:
  map increment (map snd lstpairs)

  -- but it often clearer to write
  map (increment.snd) lstpairs
  ```

# Graphs of Functions

* **Application** of the function $f$ to the argument $x$, provided that $f : A \to B$, is written as $f(x)$, and its value is $y$ if the ordered pair $\left(x, y\right)$ is in the graph of $f$, otherwise the application is undefined:

    $$f(x) = y \leftrightarrow (x, y) \in f$$

  * We denoted 'f is undefined' as $f(x) = \bot$

\vskip.5em

* **Graph of a Function:** the set of ordered pairs $\{(a, b)\,\,|\,\, a \in A and f(a) = b\}$ for a function $f : A \to B$

# Examples

::: columns
:::: column

* **Example:** $\mathbb{N} \to \mathbb{N}$, $f(n) = 2n + 1$

  \vskip.5em

  \centering
  \includegraphics[width=.625\textwidth]{images/fns/graph_2n1.eps}

::::
:::: column

* **Example:** $\mathbb{Z} \to \mathbb{Z}$, $f(n) = n^2$

  \vskip.5em

  \centering
  \includegraphics[width=.75\textwidth]{images/fns/graph_x2.eps}

::::
:::

# Floor and Ceiling

::: columns
:::: column

* **floor():** assigns to the real number $x$ the largest integer that is less than or equal to $x$. Denoted $\floor*{x}$

\vskip.5em

* **ceil():** assigns to the real number $x$ the smallest integer that is greater than or equal to $x$. Denoted $\ceil*{x}$

\vskip.5em

* **Example:**
  - *Floor:* $\floor*{2.7} = 2$, $\floor*{-1/2} = -1$
  - *Ceiling:* $\ceil*{2.7} = 3$, $\ceil*{-1/2} = 0$

    \scriptsize

    ```haskell
    ceiling 2.7
    > 3
    floor 2.7
    > 2
    ```

::::
:::: column

* Useful properties of the Floor and Ceiling
  * ($n$ is an integer, $x$ is a real number)

  $\begin{array}{rcl}
  \floor*{x} = n          & \textrm{iff} & n \leq x < n + 1 \\
  \ceil*{x} = n           & \textrm{iff} & n - 1 < x \leq n \\
  \floor*{x} = n          & \textrm{iff} & x - 1 < n \leq x \\
  \ceil*{x} = n           & \textrm{iff} & x \leq n < x + 1 \\
  \floor*{-x}             & =   & -\ceil*{x} \\
  \ceil*{-x}              & =   & -\floor*{x} \\
  \floor*{x + n}          & =   & \floor*{x} + n \\
  \ceil*{x + n}           & =   & \floor*{x} + n
  \end{array}$

  $x - 1 < \floor*{x} \leq x \leq \ceil*{x} < x + 1$

::::
:::

# Floor and Ceiling Graphs

::: columns
:::: column
\centering

**Floor: $y = \floor*{x}$**

\vskip.25em

\begin{tikzpicture}
    \tkzInit[xmin = -3, xmax = 3, ymin = -3, ymax = 2]
    \tkzDrawXY[color=white,thick]
    \tkzLabelXY[text=white,fill=none]
    \foreach \a in {-3,...,2}{
        \draw[Roarange,thick] (\a, \a) -- (\a + 1, \a);
        \node [circle, draw, thick, fill, line width = .5pt, color = Roarange, inner sep = 0pt, minimum size = 3pt] (ca) at (\a, \a) {};
        \node [circle, draw, thick, fill=none, line width = .5pt, color = Roarange, inner sep = 0pt, minimum size = 3pt] (ca) at (\a + 1, \a) {};
    }
\end{tikzpicture}

::::
:::: column

\centering

**Ceil: $y = \ceil*{x}$**

\vskip.25em

\begin{tikzpicture}
    \tkzInit[xmin = -3, xmax = 3, ymin = -2, ymax = 3]
    \tkzDrawXY[color=white,thick]
    \tkzLabelXY[text=white,fill=none]
    \foreach \a in {-2,...,3}{
        \draw[Roarange,thick] (\a, \a) -- (\a - 1, \a);
        \node [circle, draw, thick, fill, line width = .5pt, color = Roarange, inner sep = 0pt, minimum size = 3pt] (ca) at (\a, \a) {};
        \node [circle, draw, thick, fill=none, line width = .5pt, color = Roarange, inner sep = 0pt, minimum size = 3pt] (ca) at (\a - 1, \a) {};
    }
\end{tikzpicture}

::::
:::

# Partial Functions

* **Partial Function:** a function $f : A \to B$ that is an assignment to each element $a$ in a subset of $A$, called the **domain of definition** of $f$, of a unique element $b \in B$.
  * $A$ is the **domain** of $f$
  * $B$ is the **codomain** of $f$
  * We say $f$ is **undefined** for elements in $A$ that are not in the domain of definition of $f$
* **Total Function:** when the domain of definition of $f$ equals $A$

::: columns
:::: column

* **Example:** $f : \mathbb{Z} \to \mathbb{R}$ where $f(n) = \sqrt{n}$
  * Partial function since the domain of definition is $\mathbb{Z}^{+}$
  * $f$ is undefined for negative integers

::::
:::: column

* **Haskell Example**

  ```haskell
  f :: Integer -> Char
  f 1 = 'a'
  f 2 = 'b'
  f 3 = 'c'
  ```
::::
:::

#

\titleslide{.75\textwidth}{Sequences and Summations}

# Sequences

* **Sequence:** a function from a subset of the set of integers (usually the set $\{0,1,2,\ldots\}$ or the set $\{1,2,3,\ldots\}$) to the set $S$.
  * We use $a_n$ to denote the *image* of the integer $n$. $a_n$ is called a **term**

* **Example:** $\{a_n\}$ where $a_n = \frac{1}{n}$

  \vskip.5em

  The sequence $a_1,a_2,a_3,a_4,\ldots$ begins with $1,\frac{1}{2},\frac{1}{3},\frac{1}{4},\ldots$

::: columns
:::: column

* **Geometric Progression:** a sequence of the form

  \vskip-1em
  $$a, ar, ar^2, \ldots, ar^n$$

  \scriptsize
  Where the *initial term $a$* and *common ratio $r$* are real numbers

  \footnotesize

* **Examples:** $\{b_n\}$ with $b_n = (-1)^n$ and $\{c_n\}$ with $c_n = 2 \cdot 5^n$
  * $b_0,b_1,b_2,b_3,b_4,\ldots \to 1,-1,1,-1,1,\ldots$
  * $c_0,c_1,c_2,c_3,c_4,\ldots \to 2,10,50,250,1250,\ldots$

::::
:::: column

* **Arithmetic Progression:** a sequence of the form

  \vskip-1em
  $$a, a + d, a + 2d, \ldots, a + nd$$

  \scriptsize
  Where the *initial term $a$* and the *common difference $d$* are real numbers

  \footnotesize

* **Examples:** $\{s_n\}$ with $s_n = -1 + 4n$ and $\{t_n\}$ with $t_n = 7 - 3n$
  * $s_0,s_1,s_2,s_3,\ldots \to -1,3,7,11,\ldots$
  * $t_0,t_1,t_2,t_3,\ldots \to 7,4,1,-2,\ldots$
::::
:::

# Strings

* **Strings:** sequences of the form $a_1,a_2,\ldots,a_n$
  * may also be denoted $a_1a_2\ldots a_n$

\vskip.5em

* **Length:** a string's length is simply the number of terms in the string.

\vskip.5em

* **Empty String ($\lambda$):** is the string that has no terms
  * Length of $\lambda$ is 0

# Examples

* **Example:** find the formulas for the following sequences with the first five terms
  - $1,\,\frac{1}{2},\,\frac{1}{4},\,\frac{1}{8},\,\frac{1}{16} \longrightarrow a_n = (\frac{1}{2})^{n-1}$
  - $1,\,3,\,5,\,7,\,9 \longrightarrow a_n = 2n - 1$
  - $1,\,-1,\,1,\,-1,\,1 \longrightarrow a_n = (-1)^{n-1}$ or $\left(-1\right)^{n+1}$

\vskip.5em

* **Example:** $5,11,17,23,29,35,41,47 \longrightarrow a_n = 6n - 1$

# Recurrence Relations

* A **Recurrence Relation:** for the sequence $\{a_n\}$ is an equation that expresses $a_n$ in terms of one or more of the previous terms of the sequence, namely, $a_0,a_1,\ldots,a_n-1$, for all integers $n$ with $n \geq n_0$, where $n_0$ is a nonnegative integer.
  * A sequence is called a **solution** of a recurrence relation if its terms satisfy the recurrence relation.
  * A *recurrence relation* recursively defines a sequence

\vskip.5em

* **Initial Conditions** specify the terms that precede the first term where the recurrence relation takes effect.

\vskip.5em

* **Closed Formulat:** an explicit formula for the terms in the sequence

\vskip.5em

* **Example:** Let $\{a_n\}$ be a sequence that satisfies the recurrence relation $a_n = a_{n-1} + 3$ for $n = 1,2,3,\ldots$ and suppose that $a_0 = 2$.

  $\begin{array}{rcl}
  a_1 & = & a_0 + 3 = 2 + 3 = 5 \\
  a_2 & = & 5 + 3 = 8 \\
  a_3 & = & 8 + 3 = 11
  \end{array}$

# Fibonacci Sequence

* *Fibonacci sequence:* $f_0,f_1,f_2,\ldots$ is defined by the initial conditions $f_0 = 0, f_1 = 1$, and the recurrence relation

  $$f_n = f_{n-1} + f_{n-2}$$

  for $n = 2,3,4,\ldots$

\vskip.5em

* **Example:**

  $\begin{array}{rcl}
  f_2 & = & f_1 + f_0 = 1 + 0 = 1, \\
  f_3 & = & f_2 + f_1 = 1 + 1 = 2, \\
  f_4 & = & f_3 + f_2 = 2 + 1 = 3, \\
  f_5 & = & f_4 + f_3 = 3 + 2 = 5, \\
  f_6 & = & f_5 + f_4 = 5 + 3 = 8
  \end{array}$

# Iteration

* **Iteration:** The successive application of the recurrence relation to solve the recurrence and identify the closed formula.

\begin{center}
Let $\{a_n\}$ be a sequence that satisfies the recurrence relation $a_n = a_{n-1} + 3$ for $n = 1,2,3,\ldots$ and suppose that $a_0 = 2$.
\end{center}

::: columns
:::: column

**Forward Substitution:**

$\begin{array}{rcl}
a_2 & = & 2 + 3 \\
a_3 & = & (2 + 3) + 3 = 2 + 3 \cdot 2 \\
a_4 & = & (2 + 2 \cdot 3) + 3 = 2 + 3 \cdot 3 \\
    & \vdots & \\
a_n & = & a_{n-1} + 3 = (2 + 3 \cdot (n - 2)) + 3 \\
    &   & = 2 + 3(n - 1)
\end{array}$

::::
:::: column

**Backward Substitution:**

$\begin{array}{rcl}
a_n & = & a_{n-1} + 3 \\
    & = & (a_{n-2} + 3) = a_{n-2} + 3 \cdot 2 \\
    & = & (a_{n-3} + 3) + 3 \cdot 2 = a_{n-3} + 3 \cdot 3 \\
    & \vdots & \\
    & = & a_2 + 3(n-2) = (a_1 + 3) + 3(n - 2) \\
    &   & = 2 + 3(n - 1)
\end{array}$

::::
:::

# Summations

* **Summation Notation:** provides a concise notation for describing the sum of a sequence.
  * Given the sequence $a_m,a_{m+1},\ldots,a_n$ from the sequence $\{a_n\}$ we can describe the summation using:

    $$\overset{n}{\underset{j = m}{\sum}}a_j,\,\,\,\,\sum_{m\leq j\leq n}a_j$$

    \begin{center}
    or $\sum^{n}_{j=m}a_j$
    \end{center}

  * Read as the sum from $j = m$ to $j = n$ of $a_j$ to represent $a_m + a_{m + 1} + \ldots + a_n$
  * $j$ is the **index of summation** which starts from the **lower limit** $m$ and runs up through and ends with the **upper limit** $n$.

::: columns
:::: column

**Ex:** What is the value of $\overset{5}{\underset{j = 1}{\sum}}j^2$

$\begin{array}{rcl}
\overset{5}{\underset{j = 1}{\sum}}j^2 & = & 1^2 + 2^2 + 3^2 + 4^2 + 5^2 \\
                                       & = & 1 + 4 + 9 + 16 + 25 \\
                                       & = & 55
\end{array}$

::::
:::: column

**Ex:** What is the value of $\overset{8}{\underset{k = 4}{\sum}}(-1)^k$

$\begin{array}{rcl}
\overset{8}{\underset{k = 4}{\sum}}(-1)^k & = & (-1)^4 + (-1)^5 + (-1)^6 \\
                                          &   & + (-1)^7 + (-1)^8 \\
                                          & = & 1 + (-1) + 1 + (-1) + 1 \\
                                          & = & 1
\end{array}$

::::
:::

<!--
* **Theorem:**

\[\overset{n}{\underset{j = 1}{\sum}}a \cdot r^i = \left{\begin{array}{r|l}
                                                   \frac{ar^{n+1} - a}{r - 1} & r \ne 1 \\
                                                   (n + 1) a & r = 1
                                                   \end{array}\right}\]
-->

# Useful Summation Formulae

::: columns
:::: column

\small

+-----------------------------------------------------------------+-----------------------------------------------------+
| **Sum**                                                         | **Closed Form**                                     |
+:===============================================================:+:===================================================:+
| $\overset{n}{\underset{k = 0}{\sum}}ar^k (r \ne 0)$             | $\frac{ar^{n+1} - a}{r - 1}$, $r \ne 1$ \vskip.25em |
+-----------------------------------------------------------------+-----------------------------------------------------+
| $\overset{n}{\underset{k = 1}{\sum}}k$                          | $\frac{n (n + 1)}{2}$ \vskip.25em                   |
+-----------------------------------------------------------------+-----------------------------------------------------+
| $\overset{n}{\underset{k = 1}{\sum}}k^2$                        | $\frac{n (n + 1)(2n + 1)}{6}$ \vskip.25em           |
+-----------------------------------------------------------------+-----------------------------------------------------+
| $\overset{n}{\underset{k = 1}{\sum}}k^3$                        | $\frac{n^2 (n + 1)^2}{4}$ \vskip.25em               |
+-----------------------------------------------------------------+-----------------------------------------------------+
| $\overset{\infty}{\underset{k = 0}{\sum}}x^k$, $|x| < 1$        | $\frac{1}{1 - x}$ \vskip.25em                       |
+-----------------------------------------------------------------+-----------------------------------------------------+
| $\overset{\infty}{\underset{k = 0}{\sum}}kx^{k - 1}$, $|x| < 1$ | $\frac{1}{(1 - x)^2}$ \vskip.25em                   |
+-----------------------------------------------------------------+-----------------------------------------------------+

::::
:::: column

* Converting from from an index of $k = 1$ to $k = 0$

  $$\overset{5}{\underset{j = 1}{\sum}}j^2 = \overset{4}{\underset{k = 0}{\sum}}(k + 1)^2$$

* Double summations arise in many contexts
  * We evaluate them by first expanding the inner summation, then computing the out summation:

  \centering

  $\begin{array}{rcl}
  \overset{4}{\underset{i = 1}{\sum}}\overset{3}{\underset{j = 1}{\sum}}ij & = & \overset{4}{\underset{i = 1}{\sum}}(i + 2i + 3i) \\
                                                                           & = & \overset{4}{\underset{i = 1}{\sum}}6i \\
                                                                           & = & 6 + 12 + 18 + 24 \\
                                                                           & = & 60
  \end{array}$

::::
:::

# Examples

::: columns
:::: column

* Evaluate $\underset{S \in {0,2,4}}{\sum}S = 0 + 2 + 4 = 6$

* Find $\overset{100}{\underset{k = 50}{\sum}}k^2$:

  $\begin{array}{rcl}
  \overset{100}{\underset{k = 50}{\sum}}k^2 & = & \overset{50}{\underset{k = 50}{\sum}}k^2 - \overset{49}{\underset{k = 50}{\sum}}k^2 \\ \\
                                            & = & \frac{100 \cdot 101 \cdot 201}{6} - \frac{49 \cdot 50 \cdot 99}{6} \\
                                            & = & 338350 - 40425 \\
                                            & = & 297925
  \end{array}$

::::
:::: column

* **Product Notation:** provides a concise notation for describing the product of a sequence.
  * Given the sequence $a_m,a_{m + 1}, \ldots, a_n$ from the sequence $\{a_n\}$, the product can be denoted:

    $$\overset{n}{\underset{j = m}{\prod}}a_j,\,\,\,\,\prod_{m\leq j\leq n}a_j$$

    \begin{center}
    or $\prod^{n}_{j=m}a_j$
    \end{center}

    \vskip.5em

  * Read as the product from $j = m$ to $j = n$ of $a_j$
::::
:::


# Finite and Infinite Sets

* Bijections are a tool for reasoning about the sizes of tests.
  * We can use these to count a set of objects
  * That is, we associate a number to each element of a set, with the number $n$ associated with the last one, and $n$ is the number of objects
  * Thus, if there is a bijection $f : \{1,2,\ldots,n\} \to S$, $n$ is the size of the set (aka its *cardinality*)

\vskip.5em

* **Finite Set:** A set $S$ is *finite* iff there is a natural number $n$ such that there is a bijection mapping the natural number $\{0,1,\ldots,n - 1\}$ to $S$.
  * The cardinality of $S$ is $n$, and is written as $|S|$

\vskip.5em

* **Infinite Set:** A set $A$ is *infinite* if there exists an injective function $f : A \to B$ such that $B \subset A$

\vskip.5em

* We can use function properties for a function $f$ over a finite domain $A$ and result type $B$ to determine relative cardinalities
  * If $f$ is a surjection then $|A| \geq |B|$
  * If $f$ is an injection then $|A| \leq |B|$
  * If $f$ is a bijection then $|A| = |B|$


# Integers are Countable

* **Equinumerous:** Two sets $A$ and $B$ have the same cardinality if there is a bijection $f : A \to B$

\vskip.5em

* We can place the set $\mathbb{Z}$ of integers into one-to-one correspondence with the set $\mathbb{N}$ of natural numbers:

  \vskip.5em

  \begin{center}
  $\begin{array}{rlcccccccc}
  \mathbb{N} & = & 0 & 1 & 2 & 3 & 4 & 5 & 6 & \ldots \\
  \mathbb{Z} & = & 0 & -1 & 1 & -2 & 2 & -3 & 3 & \ldots
  \end{array}$
  \end{center}

  \vskip.5em

* **Countable:** A set $S$ is *countable* iff there is a bijection $f : \mathbb{N} \to S$
  * That is a set is countable if it has the same cardinality as $\mathbb{N}$
  * Thus, if a set can be *enumerated* (even if it is infinite) it is countable
  * Countably infinite sets are said to be in $\aleph_0$

# The Rational Numbers are Countable

* **Rational Number:** a fraction of the form $x/y$, where $x$ and $y$ are integers.
  * We can represent a ratio as a pair of integers
    * First number is numerator
    * Second number is denominator

* We setup a correspondence between $\mathbb{Q}^{+}$ and $\mathbb{N}$ as follows
  1. We create a series of columns, each having an index $n$ indicating its place in the series
     - each column gives all possible fractions with $n$ as the numerator
  2. Since every line in this sequence is finite, it can be printed completely before the next line is started
  3. Each line makes progress in all columns before another row is added

::: columns
:::: column

\centering
\scriptsize

$\begin{array}{ccccc}
(1,1) & & & & \\
(1,2) & (2, 1) & & & \\
(1,3) & (2, 2) & (3,1) & & \\
(1,4) & (2, 3) & (3,2) & (4,1) & \\
(1,5) & (2, 4) & (3,3) & (4,2) & (5,1) \\
\vdots & \vdots & \vdots & \vdots & \vdots
\end{array}$

::::
:::: column

* Every ratio will eventually appear. Thus $\mathbb{Q}^{+}$ is in one-to-one correspondence with $\mathbb{N}$ and is *countable*

::::
:::

# Real Numbers are Not Countable

* Some *infinite sets* are not countable.
  * Such sets are so much larger than $\mathbb{N}$ that there is no way to make a one-to-one correspondence.
  * We can prove this using an approach called *diagonalization* and a proof by contradiction.

* **Proof:**
  * Suppose the set of real numbers is countable. Then the real numbers between $0$ and $1$ is countable.
  * Therefore, all the real numbers between 0 and 1 can be listed as follows:

::: columns
:::: column

\begin{center}
$\begin{array}{ccccccc}
0 . & d_{11} & d_{12} & d_{13} & d_{14} & d_{15} & \ldots \\
0 . & d_{21} & d_{22} & d_{23} & d_{24} & d_{25} & \ldots \\
0 . & d_{31} & d_{32} & d_{33} & d_{34} & d_{35} & \ldots \\
0 . & d_{41} & d_{42} & d_{43} & d_{44} & d_{45} & \ldots \\ \\
r = 0. & \overline{d_{11}} & \overline{d_{22}} & \overline{d_{33}} & \overline{d_{44}} & \overline{d_{55}} & \ldots
\end{array}$
\end{center}

::::
:::: column

$$d_{ij} \in \{0,...,9\}$$

* We can form a new real number $r$ as follows:
  1. select the first digit from the first row, and change it to it's 9's complement.
  2. Take the second digit from the second row and change it to its 9's complement and so on.

     $0 \leftrightarrow 9\,\,1 \leftrightarrow 8\,\,2\leftrightarrow 7\,\,3 \leftrightarrow 6\,\, 4 \leftrightarrow 5$

::::
:::

# Real Numbers are Not Countable

* We claim that $r$ is not listed on the original table
  * Because $r$ differs at least one digit from any row
  * We assumed that we listed all real numbers, but we found a new one $r$ $\Rightarrow$ **Contradiction**
  * Therefore, the set of real numbers is uncountable

# For Next Time

::: columns
:::: column
* Review DMUC Chapter 11
* Review DMA Chapters 2.3 - 2.5
* Review this Lecture
* Read DMUC Chapter 4, 9
* Read DMA Chapters 5.1 - 5.2
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
