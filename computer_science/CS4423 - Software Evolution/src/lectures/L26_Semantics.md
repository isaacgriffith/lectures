---
author:
- Isaac Griffith
title:
institute: |
  CS 4423 and CS 5523

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

#

\vfill
\centering
\Huge Title

# Outcomes

At the end of Today's Lecture you will be able to:

*

# Purpose of this lecture

We set up the bases for being able to study the static analysis of a small language:

* **syntax** of programs
* **semantics** of programs, i.e., formalization of how they run

Semantics is **a crucial prerequisite for static analysis**:

* the structure of semantics guides that of the analysis
* the proof of soundness of the analysis is done with respect to the semantics

We consider two forms of semantics

* **compositional:** functions that compose
* **transitional:** state transitions that step

# Outline

1. A small imperative language
2. Semantics of expressions and conditions
3. A compositional semantics
4. A transitional semantics
5. Conclusion

# Syntax of expressions and conditions

A **few assumptions:**

* $\mathbb{V}$: **set of scalar values**
* $\mathbb{X}$: **finite set of variables**

**Scalar expressions**, meant to evaluate to scalar values, defined by induction, using a grammar

<!-- grammar from slide 4 -->

**Boolean expressions**, meant to evaluate to Booleans:

<!-- grammar from slide 4 -->

# Syntax of commands

**Commands** of a **basic, imperative language**, also defined by induction, using a grammar:

<!-- grammar from slide 5 -->

A program is simply a command

# Example

::: columns
:::: column

```c
x = 0;
while(x < 98) {
  input(y);
  if (y = 10) {
    x = x + 110;
  } else if (y = 20) {
    x = x + 1;
  } else { }
}
```

::::
:::: column

Many possible executions:

* may terminate with `x = 98`
* may terminate with `x = 110 + k` with $1\leq k < 98$
* may not terminate at all...

In fact, there are **infinitely many** possible executions

::::
:::

# Verification problem: value analysis

::: columns
:::: column

```c
x = 0;
while(x < 98) {
  input(y);
  if (y = 10) {
    x = x + 110;
  } else if (y = 20) {
    x = x + 1;
  } else { }
}
```

::::
:::: column

* what is the value of `x` at the exit point?
* same question, but for all program points?
* same question, but regarding to `y`?

::::
:::

# Verification problem: correctness of assertions

::: columns
:::: column

```c
x = 0;
while(x < 98) {
  assert(x >= 0);
  input(y);
  if (y = 10) {
    x = x + 110;
    assert(y < x);
  } else if (y = 20) {
    x = x + 1;
  } else { }
}
assert(x < 200);
```

::::
:::: column

Some assertions were added inside the program.

* Can we assume that no execution will violate them?
* More generally, can we prove that some class of runtime errors will never happen, such as division by zero or array index out-of-bounds dereferences.

::::
:::

To answer such questions, **value information are needed**.

# Verification problem: reachability

::: columns
:::: column

```c
x = 0;
while(x < 98) {
  input(y);
  if (y = 10) {
    x = x + 110;
  } else if (y = 20) {
    x = x + 1;
  } else { }
}
```

::::
:::: column

Are all program points reachable?

\vskip.5em

Useful to reason over:

* code optimization
* correctness (if some commands may perform offending operations)

::::
:::

Again, to answer such questions, **value information are needed**

# Need for a semantics

To assess whether such properties hold one needs to take into account:

* The **control flow** behavior of commands
* The **mathematical definition of operators**
  - i.e., is the addition done with modular arithmetic?
  - i.e., with what precision/rounding are floating point operations computed?
* the **execution order** (if there are side effects)
* the **error semantics**
  - i.e., abrupt crash or undefined behavior? or even, "implementation defined" behavior?

\begin{block}{}
  \centering
  \textbf{To settle all these questions, a formal definition of program behaviors is required; this is the goal of semantics.}
\end{block}

# Outline

1. A small imperative language
2. Semantics of expressions and conditions
3. A compositional semantics
4. A transitional semantics
5. Conclusion

# Memory states

First step: semantics of expressions.

\vskip.25em

To evaluate an expression, one needs to read the value of variables.

\vskip.5em

**Memory state:**

* maps each variable to its value
  - hence, a function

\begin{center}
$m : \mathbb{X} \righarrow \mathbb{V}$
\end{center}

* example: `x` stores 3 and `y` stores 8:

<!-- mapping from slide 12 -->

* for more complex languages with pointer and dynmaic allocation, a more complex definition is needed

# Semantics of expressions

**How to evaluate an expression:**

* maps an **expression** and a **memory state** into a **value**
* the definition of expression is inductive so the **evaluation** also proceeds **by induction over the syntax**

**Definition**

<!-- equations from slide 13 -->

**Example**

<!-- mapping from slide 13 -->

# Semantics of conditions

**Boolean conditions** are very **similar**

* maps an **expression** and a **memory state** into a **Boolean value**

**Definition**

<!-- expressions from slide 14 -->

**Example**

<!-- mapping from slide 14 -->

# Outline

1. A small imperative language
2. Semantics of expressions and conditions
3. A compositional semantics
4. A transitional semantics
5. Conclusion

# Principles and basic constructions

A first view at **commands**:

* **input a memory state**
* **return a modified memory state**

This suggests to define the **semantics of command** $C [\![C]\!] : M \longrightarrow M$, but

* some expressions do not return, e.g., `while (0 < 1) { }`
* some expressions may return several states, e.g., `input(x)`

Thus:

\begin{block}{}
  \centering
  $[\![C]\!]_{\mathcal{P}} : p(\mathbb{M}) \longleftarrow p(\mathbb{M}_{})$
\end{block}

**Compositionality**: the semantics of sequence is compotion; that of skip is identity

<!-- expressions from slide 16 -->

# Memory modifying commands

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time
