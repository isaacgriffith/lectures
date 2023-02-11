---
author:
- Isaac Griffith
title: A Gentle Introduction to Program Analysis
institute: |
  CS 4423 and CS 5523

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Purpose

We aim at describing **the core concepts of static analysis by abstract interpretation, in an intuitive manner:**

1. Concrete semantics
2. Abstraction
3. Abstract interpretation of basic program commands
4. Abstract iteration and widening (to analyze loops)

\begin{block}{}
  \begin{center}
  \textbf{This presentation is done using a small language where programs describe sequences of transformations}
  \end{center}
\end{block}

**No background required!**

# Outline

1. A basic language
2. Abstraction
3. Abstract interpretation
4. Abstract interpretation of a compositional semantics
5. Abstract interpretation of a transitional semantics
6. Conclusion

# Syntax

**Intuition:**

* imperative programs, with a graphical interpretation
* a state is a point in the two-dimensional plane (think of a pair of variables $x,y$)
* starting point in a given region
* basic operations are translations and rotations
* choices (conditions and loop iteration numbers) are non-deterministic

## Syntax

```bnf
p ::= init($\mathfrak{R}$)     // initialization, with a state in $\mathfrak{R}$
   |  translation(u, v)        // translation by vector (u, v)
   |  rotation(u, v, $\theta$) // rotation with center (u, v) and angle $\theta$
   |  p ; p                    // sequence of operations
   |  {p} or {p}               // choice
   |  iter{p}                  // iteration
```

# States and executions

\begin{block}{}
  \begin{itemize}
    \item A \textbf{program state} (or state) is a \textbf{point in the 2D field}
    \item A \textbf{program execution} is defined by sequence of states
  \end{itemize}
\end{block}

**A basic program:**

```
init([0,1]x[0,1]);
translation(1,0);
iter {
  {
    translation(1, 0)
  } or {
    rotation(0,0,90)
  }
}
```

# States and executions

\begin{block}{}
  \begin{itemize}
    \item A \textbf{program state} (or state) is a \textbf{point in the 2D field}
    \item A \textbf{program execution} is defined by sequence of states
  \end{itemize}
\end{block}

**Example executions:**

<!-- Image from slide 5 -->

Note: left execution is terminating; right execution is non-terminating

# A verification problem

In this lecture, we fix a very simple target semantic property:

\begin{block}{Property to verify}
States in a given zone $\mathfrak{D}$ should not be reached by any execution
\end{block}

Example: $\mathfrak{D} = {(x, y) | x < 0}$

<!-- Image from slide 6 -->

# Correct executions and incorrect execution

::: columns
:::: column
Some **correct executions:**

<!-- Image from slide 7 -->

::::
:::: column
An **incorrect execution:**

<!-- Image from slide 7 -->

::::
:::

## Our goal

Set up a **static analysis** (no execution of the program required) to **detect and report all possible incorrect executions**

# Outline

1. A basic language
2. Abstraction
3. Abstract interpretation
4. Abstract interpretation of a compositional semantics
5. Abstract interpretation of a transitional semantics
6. Conclusion

# Notion of abstraction: example of signs

**Observation:**

* sets of points contain far more information than necessary
* as a first step, we may retain only the **signs of variables**

\begin{block}{Abstraction principle}
Use \textbf{predicates} $a$ which describe sets of points noted $\gamma(a)$
\end{block}

**Examples**, using only **sign predicates:**

<!-- images from slide 9 -->

# Abstraction with signs

\begin{block}{Abstract domain definition}
\begin{itemize}
 \item \textbf{Predicates:} one sign predicate per variable. Nonpositive, zero, or nonnegative
 \item \textbf{Representation:} enum type with three values
\end{itemize}

Example abstract states:

<!-- images from slide 10 -->

# Abstraction with boxes

Limitation of signs: **cannot deal with simple translations precisely**

\begin{block}{Abstract domain definition}
\begin{itemize}
 \item \textbf{Predicates:} a range for each variable, i.e., a pair of bounds
 \item \textbf{Representation:} two values per variable
\end{itemize}
\end{block}

Example abstract states:

<!-- images from slide 11 -->

# Abstraction with polygons

Limitation of boxes: **cannot express any relational constraint**

\begin{block}{Abstract domain definition}
\begin{itemize}
 \item \textbf{Predicates:} a conjunction of linear inequality constraints
 \item \textbf{Representation:} either inequalities or gemetric view (edges + vertices)
\end{itemize}
\end{block}

Example abstract states:

<!-- images from slide 12 -->

# Outline

1. A basic language
2. Abstraction
3. Abstract interpretation
4. Abstract interpretation of a compositional semantics
5. Abstract interpretation of a transitional semantics
6. Conclusion

# Goals of the analysis

\begin{block}{}
 Given a program $P$, compute an abstract element $a$ such that \textbf{the set of all reachable states of $P$ is included in} $\gamma(a)$. Sucha an $a$ is a \textbf{sound abstraction}.
\end{block}

**A basic program:**

```
init([0,1] x [0,1]);
iter {
  {
    translation(1,0);
  } or {
    translation(0.5,0.5);
  }
}
```

# Goal of the analysis

\begin{block}{}
  Given a program $P$, compute an abstract element $a$ such that \textbf{the set of all reachable states of $P$ is included in $\gamma(a)$}. Such an $a$ is a \textbf{sound abstraction}.
\end{block}

**Reachable states** (exact set) and **a sound abstraction**.

<!-- images from slide 14 -->

# Principle of the analysis

Very similar to an **interpreter**, but based on **abstract states**:

1. start with an over-approximation of initial states
2. consider the program operations in sequence for each operation, compute an over-approximate effect
   - all on abstract states

We now consider the main program operations...

# Analysis of initialization

Program start with a random initialization command $init(\mathfrak{R})$.

How to analyze its effect?

\begin{block}{}
  \begin{itemize}
    \item produce \textbf{any abstract state $a$ such that $\mathfrak{R} \subseteq \gamma(a)$}
  \end{itemize}
\end{block}

**Example for** $init([0,1]\times[0,1]);$

<!-- images from slide 16 -->

* note that the choice of $a$ is not unique...
* ... but smaller is better: **more precise abstraction = tighter fit**

# Analysis of a translation

**Command** `translation(u, v)` transforms a state into another.

The analysis should also describe a transformation, but over abstract states.

\begin{block}{}
\begin{itemize}
 \item the analysis \textbf{returns an abstract state containing the translation of the input abstract state, by the same vector} $u, v$
\end{itemize}
\end{block}

Over **intervals** and over **convex polyhedra**:

<!-- images from slide 17 -->

* **soundness**: forget no real behaviors
* **completeness**: no "noise" added, tight abstract post-condition

# Analysis of rotation

**Command** `rotation(u, v, `$\theta$`)` also transforms a state into another, hence so does its analysis.

\begin{block}{}
\begin{itemize}
\item the analysis \textbf{returns an abstract state containing the rotation of the input abstract state, with the same angle, origin parameters}
\end{itemize}
\end{block}

Over **intervals** and over **convex polyhedra**:

<!-- images from slide 18 -->

* **soundness:** forget no real behaviors
* **unavoidable imprecision** with intervals, but not with polyhedra

# Outline

1. A basic language
2. Abstraction
3. Abstract interpretation
4. Abstract interpretation of a compositional semantics
5. Abstract interpretation of a transitional semantics
6. Conclusion

# Principle and anlysis of a basic program

Status so far:

* for **initialization:** produce a state that over-approimates the initial states
* for **basic command** `p`: a function $f_p$ that maps an abstract state (set of input states) to an over-approximate abstract state (super-set of output states)

\begin{block}{}
  \begin{center}
  \textbf{Can we generalize this for composite commands?}
  \end{center}
\end{block}

**Easy for sequence commands**

\centering
$f_{p_{0}:p_{1}} = f_{p_1} \cdot f_{p_0}$

# Analysis of a choice

**Command** $\{p_0\}or\{p_1\}$ boils down to non-deterministic choice + standard execution

\begin{block}{}
  \begin{enumerate}
  \item analyze both $p_0$ and $p_1$
  \item compute an over-approximation of the results of these analyses typically, by an \textbf{abstract union/convex closure} algorithm
  \end{enumerate}
\end{block}

Over **intervals** and over convex **polyhedra**:

<!-- images from slide 21 -->

* **convex closure** typically loses a lot of precision

# Analysis of a loop: a few iterates

**A first attempt:** rewriting a loop using choice and sequence

<!-- equation from slide 22 -->

**Example**

$init({(x,y) | 0 \leq y \leq 2x$ and $x \leq 0.5); iter {translation(1, 0.5)}$ using convex polyhedra, and covering just a few iterations:

<!-- images from slide 22 -->

# Analysis of a loop: use of widening

Another approach:

* we note $p_0$ for {}, $p_1$ for $\{\} or \{b\}$, $p_2$ for $\{\} or \{b\} or \{b; b\}$ and so on;
* we remark that $p_{k + 1}$ is equivalent to $p_k$ or $\{p_k ; b\}$
* thus, we can do an iterative analysis

  $analysis(p_{k+1},a) = \\union(analysis(p_k,a),analysis(b,analysis(p_k,a)))$

**Same example, with an algorithm to compute the iterations**:

<!-- images from slide 23 -->

**Issue: termination not guaranteed!**

# Analysis of a loop: use of widening

Let us **speed up convergence**:

* termination flows from replacing $union$ with a coarser **widening** operation such that all such sequences terminate
* typical widening technique: let $widen(a_0, a_1)$ return a conjunction of constraints that retains only constraints in $a_0$ that still hold in $a_0$; starting from finitely many constraints, termination is guaranteed

**Same example**:

<!-- images from slide 24 -->

**Issue: precision is not all that great...**

# Analysis of a loop: use of widening and unrolling

Solution: **combine regular union and widening**

* first iteration with $union$
* next iterations using $widen$

**Same example**

<!-- images from slide 25 -->

# Outline

1. A basic language
2. Abstraction
3. Abstract interpretation
4. Abstract interpretation of a compositional semantics
5. Abstract interpretation of a transitional semantics
6. Conclusion

# Semantic style: compositional versus transitional

* compositional semantics function:
  - semantics of $p$ is defined by the semantics of the sub-parts of $p$.

\begin{center}
$[\![AB]\!] = \ldots [\![A]\!] \ldots [\![B]\!] \ldots$
\end{center}

  - proving its soundness is thus by structural induction on $p$

* for some realistic programming languages, defining their compositional ("denotational") semantics is a hurdle.
  - functional calls, exceptions, gotos, functions and jump labels as values

## Transitional-style ("operational") semantics avoids the hurdle

\centering
$[\![AB]\!] = {s_0 \hookrightarrow s_1 \hookrightarrow \ldots, \ldots}$

# Semantics as state transitions

\begin{block}{Definition(Transitional semantics)}
An execution of a program is a sequence of transitions between states.

\begin{itemize}
\item a state is a pair $(l, p)$ of statement label $l$ and an $(x,y)$ point $p$.
\item a single transition
\end{itemize}

\begin{center}
$(l,p) \hookrightarrow (l',p')$
\end{center}

whenever the program statement at $l$ moves the point $p$ to $p'$.
\end{block}

::: columns
:::: column

\[s_1 \hookrightarrow s_2 \hookrightarrow s_5 \hookrightarrow s_3 \hookrightarrow s_8 \hookrightarrow \ldots\\
  s_6 \hookrightarrow s_7 \hookrightarrow s_8 \hookrightarrow s_3 \hookrightarrow s_4 \\
  s_9 \hookrightarrow s_{10} \hookrightarrow s_8 \hookrightarrow s_{11} \hookrightarrow s_8 \hookrightarrow s_{11} \hookrightarrow s_{13}\\
  s_{12} \hookrightarrow s_7 \hookrightarrow s_2 \hookrightarrow s_3 \hookrightarrow s_4 \hookrightarrow s_{14}\]

States $s_1$, $s_6$, $s_9$, and $s_{12}$ are initial states

::::
:::: column

<!-- images from slide 28 -->

::::
:::

\centering
Figure: Transition sequences and the set of occurring states

# Example language, again

```bnf
p ::= init($\mathfrak{R}$)     // initialization, with a state in $\mathfrak{R}$
   |  translation(u, v)        // translation by vector (u, v)
   |  rotation(u, v, $\theta$) // rotation with center (u, v) and angle $\theta$
   |  p ; p                    // sequence of operations
   |  {p} or {p}               // choice
   |  iter{p}                  // iteration
```

We will consider a more dynamic language when covering chapter 4 later.

# Statement labels

::: columns
:::: column

<!-- image from slide 30 -->

\centering (a) Text view, with labels

::::
:::: column

<!-- image from slide 30 -->

\centering (b) Graph view, with labels

::::
:::

\centering
Figure: Example program with statement labels

# States in a transition sequence

<!-- images from slide 31 -->

# Reachability problem and abstraction of states

**Reachability problem:**

* we are interested in the set of all states that can occur during all transition sequences of the input program.

An abstract state is:

* a set of pairs of statement labels and abstract pre-conditions

# Statement-wise abstraction of reachable states

<!-- images from slide 33 -->

# Abstract state transition

\begin{center}
$Step^{#}$: a set of pairs of labels and abstract pre-conditions $\mapsto$ a set of pairs of labels and abstract post-conditions
\end{center}

is

\begin{center}
$Step^{#}(X) = {x' | x \in X, x \hookrightarrow^{#}x'}
\end{center}

where

\begin{center}
\begin{eqnarray}
(or_{l},a_{pre}) & \hookrigharrow^{#} & (next(l), a_{pre})\\
(iter{l},a_{pre}) & \hookrightarrow^{#} & (next(l),a_{pre})\\
(p_{l},a_{pre}) & \hookrightarrow^{#} & (next(l),analysis(p_l,a_{pre}))
\end{eqnarray}
\end{center}

<!-- images from slide 34 -->

# Analysis by global iterations

The analysis goal is to accumulate from the initial abstract state $l$:

\begin{center}
$Step^{#^0}(l) \cup Step^{#^1}(l) \cup Step^{#^2}(l) \cup \ldots$
\center{center}

which is the limit $C_{\infnty}$ of $C_i = Step^{#^0}(l) \cup Step^{#^1}(l) \cup \ldots \cup Step^{#^i}(l)$ where

\begin{center}
$C_{k+1} = C_k \cup Step^{#}(C_k)$.
\end{center}

Thus the analysis algorithm should iterate the operation $C \leftarrow C \cup Step^{#}(C)$ from $l$ until stable:

<!-- algorithm from slide 35 -->

# Analysis in action

<!-- images from slide 36 -->

# Outline

1. A basic language
2. Abstraction
3. Abstract interpretation
4. Abstract interpretation of a compositional semantics
5. Abstract interpretation of a transitional semantics
6. Conclusion

# Important points to remember, and what to learn next

A quick **summary** of the approach that we followed

1. start from a **semantics**, describing program behaviors
2. set up an **abstraction**, that defines a set of logical prediates and a machine representation
3. seek for **analysis algorithms**
   - computation of abstract post-conditions,
   - abstract `union` and `widening`...
4. set up an iteration algorithm: **compositional** or **transitional**

**Next lectures**:

* formalize these steps, and
* provide step-by-step frameworks for designing sound static analyses

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time
