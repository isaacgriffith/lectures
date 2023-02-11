---
author:
- Isaac Griffith
title: Refactoring - Formalisms and Examples
institute: |
  CS 4423 and CS 5523

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

After today's lecture you will:

::: columns
:::: {.column width=.7}
* Be able to describe methods of formalizing refactorings
  - Assertions
  - Graph Transformations
  - Software Metrics
* Understand the effects of refactoring through example
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears.jpg}
::::
:::

#

\centering
\vfill
\begin{minipage}{.85\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.775\textwidth}
\Huge Refactoring Formalisms
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# Formalisms for Refactoring

* Three key formalisms for refactoring are:
  * assertions:
    * Assertions are useful in verifying the assumptions made by programmers.
  * graph transformation:
    * Graph transformation is useful in viewing refactorings as applications of transformation rules.
  * metrics:
    * Metrics are useful in quantifying to what extent the internal and external properties of software entities have changed.

# Assertions

* Programmers make assumptions about the behavior of programs at specific points, and those assumptions can be tested by means of assertions.
* An assertion is specified as a Boolean expression which evaluates to true or false.
* Three kinds of assertions:
  - invariants;
  - preconditions; and
  - postconditions.

# Assertions

* Invariant
  - An \color{Roarange}\textbf{invariant}\color{Black}\ is an assertion that evaluates to \color{Roarange}\textbf{true}\color{Black}\ wherever in the program it is invoked.
  - A \color{Roarange}\textbf{class invariant}\color{Black}\ is an invariant that all instances of that class must satisfy.
* Precondition
  - A \color{Roarange}\textbf{precondition}\color{Black}\ is a condition that must be satisfied \color{Roarange}\textbf{before}\color{Black}\ a computation is performed.
* Postcondition
  - A \color{Roarange}\textbf{postcondition}\color{Black}\ is a condition that must be satisfied \color{Roarange}\textbf{after}\color{Black}\ a computation is performed.

# Assertions

* Invariants, preconditions, and postconditions can be applied to test the behavior preserving property of refactorings.
* Examples of invariant in the context of transformation of database schema is:
  - All instance variables of a class, whether defined or inherited, have distinct names.
  - All methods of a class, whether defined or inherited, have distinct names.
* \color{Roarange}\textbf{Note:}\color{Black}\ Static checking of preconditions, postconditions, and invariants is computationally expensive.

# Graph Transformation

* Programs, class diagrams, and statecharts can be viewed as \color{Roarange}\textbf{graphs}\color{Black}, and refactorings can be viewed as \color{Roarange}\textbf{graph production rules}\color{Black}.
* Classes (C), method signatures (M), block structures (B), variables (V), parameters (P), and expressions (E) are represented by \color{Roarange}\textbf{typed nodes}\color{Black}\ in a graph.
* The possible relationships among the nodes are:

\footnotesize
::: columns
:::: {.column width=.10}
::::
:::: {.column width=.3}
  - method lookup (l)
  - membership (m)
  - expression (e)
  - formal parameter (fp)
  - call (c)
  - update (u)
::::
:::: column
  - inheritance (i)
  - (sub)type (t)
  - actual parameter (ap)
  - cascaded expression ($\cdot$)
  - variable access (a)
::::
:::

# Graph Transformation

* The \color{Roarange}\textbf{Push-Down-Method}\color{Black}\ refactoring has been applied to method \color{Roarange}\textbf{originate}\color{Black}\ to obtain a new graph

::: columns
:::: column

\centering
\includegraphics[width=\textwidth]{images/refactoring/ref05.eps}

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/refactoring/ref06.eps}

::::
:::

# Software Metrics

* Software metrics can be used to quantify the internal and external qualities of software.
* A module consists of many components; each component provides a defined functionality used by other components.
* Measure the \color{Roarange}\textbf{strength of togetherness}\color{Black}\ of components within a module to decide whether or not some components should stay in the same module.

# Software Metrics

* Two metrics considered are:
  - cohesion
  - coupling

* \color{Roarange}\textbf{Cohesion:}\color{Black}\ This metric is used to represent the \color{Roarange}strength of togetherness\color{Black}\ in the same module.

* \color{Roarange}\textbf{Coupling:}\color{Black}\ This metric is used to represent the \color{Roarange}strength of dependency\color{Black}\ between separate modules.

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{minipage}{3.5em}
\vskip-3em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.675\textwidth}
\Huge More Refactoring\\ Examples
\vskip-0.75em
\rule{.975\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# More Examples of Refactoring

* More examples are intuitively explained here.
  * Substitute algorithm;
  * Replace parameter with methods;
  * Push Down Method;
  * Parameterize Methods;

# Substitute algorithm

* Replace algorithm `X` with algorithm `Y` because:
  1. implementation of `Y` is clearer than `X`
  2. `Y` performs better than `X`
  3. standardization bodies want `X` to be replaced with `Y`
* Algorithm substitution is easier if both `X` and `Y` have the same input-output behaviors.

# Replace parameters with methods

Consider the following code segment, where the method `bodyMassIndex` has two formal parameters.

```java
	int person;
	:
	// person is initialized here;
	:
	int bodyMass = getMass(person);
	int height = getHeight(person);
	int BMI = bodyMassIndex(bodyMass, height);
	:
```

* The above code segment can be rewritten such that the new `bodyMassIndex` method accepts one formal	parameter, namely, \color{Roarange}`person`\color{Black}, and internally computes the values of \color{Roarange}`bodyMass`\color{Black} and \color{Roarange}`height`\color{Black}.

# Replace parameters with methods

* The refactored code segment has been shown in the following:

  ```java
  int person;
  :
  // person is initialized here;
  :
  int BMI = bodyMassIndex(person);
  :
  ```

* The advantage of this refactoring is that it reduces the 	number of parameters passed to methods.
* Such reduction is important because one can easily make 	errors while passing long parameter lists.

# Push Down Method

\footnotesize
- Assume that \color{Roarange}`Executive`\color{Black}\ and \color{Roarange}`Clerk`\color{Black}\ are two subclasses of the superclass \color{Roarange}`Employee`\color{Black}
- Method \color{Roarange}`overTimePay`\color{Black}\ has been defined in \color{Roarange}`Employee`\color{Black}\ class
- If \color{Roarange}`overTimePay` is used in the \color{Roarange}`Clerk`\color{Black}\ class, but not in the \color{Roarange}`Executive`\color{Black}\ class, then the programmer can push down \color{Roarange}`overTimePay`\color{Black}\ to the \color{Roarange}`Clerk`\color{Black}\ class

\centering
\includegraphics[width=.75\textwidth]{images/refactoring/ref07.eps}

# Parameterize Methods

- Sometimes programmers may find multiple methods performing the same computations on different input data sets.
- Those methods can be replaced with a new method with additional formal parameters.

# Parameterize Methods

- We start with the \color{Roarange}`Communication`\color{Black}\ class with four methods: \color{Roarange}`bluetoothInterface`\color{Black}, \color{Roarange}`wifiInterface`\color{Black}, \color{Roarange}`threeGInterface`\color{Black}, and \color{Roarange}`fourGInterface`\color{Black}.

\centering
\includegraphics[width=.85\textwidth]{images/refactoring/ref08.eps}

# Parameterize Methods

- After refactoring we have the \color{Roarange}`Communication`\color{Black}\ class with just one method, \color{Roarange}`wirelessInterface`\color{Black}\, with \color{GrowlingGray}one parameter\color{Black}, \color{Roarange}`radio`\color{Black}.

\centering
\includegraphics[width=.85\textwidth]{images/refactoring/ref08.eps}

# Parameterize Methods

- The method \color{Roarange}`wirelessInterface`\color{Black}\ can be invoked with different values of \color{Roarange}`radio`\color{Black}\ so that the \color{Roarange}`wirelessInterface`\color{Black}\ method can in turn invoke different \color{Roarange}`radio`\color{Black}\ interfaces.

\centering
\includegraphics[width=.85\textwidth]{images/refactoring/ref08.eps}

# For Next Time

::: columns
:::: {.column width=.6}
\footnotesize
* Review EVO Chapter 7.3 - 7.4
* Read EVO Chapter 7.5 - 7.6
* Watch Lecture 18
::::
:::: {.column width=.4}
\centering
\includegraphics[width=.85\textwidth]{images/next_time.png}
::::
:::

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
