---
author:
- Isaac Griffith
title: Impact Analysis - Dependency Analysis and Ripple Effect
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
* Have an understanding of and be to conduct a Dependency Analysis using both
  * Call graph based techniques
  * Dependency graph based techniques
* Be able to extract either a static or dynamic slice from a program dependency graph
* Have an understanding of and be able to evaluate the ripple effect of a change
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
\begin{minipage}{.725\textwidth}
\begin{minipage}{3.5em}
\vskip-3em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge Dependency-Based\\ Impact Analysis
\vskip-0.75em
\rule{.75\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# Dependency Analysis

* Source code objects are analyzed to obtain vertical traceability information.
* Dependency based impact analysis techniques identify the impact of changes by analyzing syntactic dependencies
  - Syntactic dependencies are likely to cause semantic dependencies.
* Two traditional impact analysis techniques:
  1. Call graph techniques
  2. Dependency graph techniques

# Call Graph

\footnotesize

* **Call graph** a directed graph, where:
  - **Nodes:** represents a function, a component, or a method.
  - **Edges:** between two nodes, A and B, indicates that A may invoke B

::: columns
:::: {.column width=.55}

* Call graphs are used to understand the potential impacts that a software change may have
* Let:
  - $P$ be a program
  - $G$ be the call graph obtained from $P$
  - $p$ be some procedure in $P$
* **Assumption:** some change in $p$ has the potential to impact changes in all nodes reachable from $p$ in $G$

::::
:::: {.column width=.45}

\centering
\includegraphics[width=.80\textwidth]{images/impact/impact07.eps}

::::
:::

# Call Graph

**Call graph techniques have several disadvantages:**

::: columns
:::: {.column width=.65}

- Can produce an imprecise impact set
  - **Ex:** We cannot determine the conditions that cause impacts to propagate from M to other procedures
- Does not capture propagation due to procedure returns
  - **Ex:** Suppose that, `E` is modified and control returns to `C`.

    \vskip.5em

    When `C` returns, we cannot infer whether impacts of changing `E` propagates into none, both, `A`, or `B`.

::::
:::: {.column width=.35}

\centering
\includegraphics[width=\textwidth]{images/impact/impact07.eps}

::::
:::

# Call Graph

\footnotesize

* Consider the execution trace: `M B r A C D r E r r r r x`
  - Where `r` and `x` represent function returns and program exits

::: columns
:::: {.column width=.65}

* The impact of the modification of `M` is computed by forward searching in the trace to find:
  - procedures indirectly or directly invoked by `E`; and
  - procedures invoked after `E` terminates
* We can identify procedures `E` returns into using a backward search in the trace
* In this trace, `E` does not invoke other entities, but returns into `M`, `A`, and `C`
* A modification in `E` has a potentially impact set: `{M, A, C, E}`

::::
:::: {.column width=.35}

\includegraphics[width=\textwidth]{images/impact/impact07.eps}

::::
:::

# Program Dependency Graph

\footnotesize

* **Program dependency graph (PDG)** a directed graph:
  - Two types of nodes:
    1. Simple statement
    2. Predicate expression
  - Two types of edges in a PDG
    1. Data dependencies
    2. Control dependencies
* Let $v_i$ and $v_j$ be two nodes in a PDG.
  * A \color{Roarange}data dependency\color{Black}\ edge from $v_i$ to $v_j$ indicates that
    - the computations performed at $v_i$ directly depend upon the results of computations performed at $v_j$.
  * A \color{Roarange}control dependency\color{Black}\ edge from $v_i$ to $v_j$ indicates that
    - $v_i$ may execute based on the result of evaluation of a condition at $v_j$.

# Program Dependency Graph

\footnotesize

* Solid Edges -> Data dependencies
* Dashed Edges -> Control dependencies

\vskip-1.5em

::: columns
:::: {.column width=.35}

\scriptsize

```
    begin
S1:     read(X)
S2:     if(X < 0)
        then
S3:         Y = f1(x);
S4:         Z = g1(x);
        else
S5:         if (X = 0)
            then
S6:             Y = f2(X);
S7:             Z = g2(X);
            else
S8:             Y = f3(X);
S9:             Z = g3(X);
            endif;
        endif;
S10:    write(Y);
S11:    write(Z);
    end
```

::::
:::: {.column width=.65}

\vskip1.5em
\includegraphics[width=\textwidth]{images/impact/impact08.eps}

::::
:::

# Static Slice

* A static program slice is extract from a PDG, as follows:
  * for a variable var at node n, identify all reaching definitions of var.
  * find all nodes in the PDG which are reachable from those nodes.
  * The visited nodes in the traversal process constitute the desired slice.

# Static Slice

* Consider variable Y at S10

\centering
\includegraphics[width=.85\textwidth]{images/impact/impact08a.eps}

# Static Slice

* Consider variable Y at S10

\centering
\includegraphics[width=.85\textwidth]{images/impact/impact08b.eps}

# Static Slice

* Consider variable Y at S10

\centering
\includegraphics[width=.85\textwidth]{images/impact/impact08c.eps}

# Static Slice

* Consider variable Y at S10

\centering
\includegraphics[width=.85\textwidth]{images/impact/impact08d.eps}

# Static Slice

* Consider variable Y at S10

\centering
\includegraphics[width=.85\textwidth]{images/impact/impact08e.eps}

# Static Slice

* Consider variable Y at S10

\centering
\includegraphics[width=.65\textwidth]{images/impact/impact08f.eps}

# Dynamic Slice

* A dynamic slice is typically more useful in localizing defects than static slices

\centering
\includegraphics[width=.6\textwidth]{images/impact/impact08g.eps}

# Dynamic Slice

* A dynamic slice is typically more useful in localizing defects than static slices

\centering
\includegraphics[width=.6\textwidth]{images/impact/impact08h.eps}

# Dynamic Slice

* A dynamic slice is typically more useful in localizing defects than static slices

\centering
\includegraphics[width=.65\textwidth]{images/impact/impact08i.eps}

* For −1 as the values of X, if the value of Y is incorrect at S10, one can infer that either $f_i$ is erroneous at S3 or the “if” condition at S2 is incorrect.

# Dynamic Slicing

* Obtaining a dynamic slice
  - Inputs: a test and a PDG
  - We represent the execution history, of the program as a sequence of vertices $\left< v1, v2, ...., vn\right>$.
  - **Execution history** ($hist$): of a program $P$ for a test case, $test$, and a variable $var$ is the set of all statements in $hist$ whose execution had some effect on the value of $var$ as observed at the end of the execution.
  - Then:
    1. for the current test, mark the executed nodes in the PDG.
    2. traverse the marked nodes in the graph.

# Example

* **Goal:** Dynamic Slice for `Y` at end of execution
* **Input:** `X = −1`
* **History:** $\left<S1, S2, S3, S4, S10, S11\right>$

\centering
\includegraphics[width=.65\textwidth]{images/impact/impact08j.eps}

# Example

* **Goal:** Dynamic Slice for `Y` at end of execution
* **Input:** `X = −1`
* **History:** $\left<S1, S2, S3, S4, S10, S11\right>$

\centering
\includegraphics[width=.65\textwidth]{images/impact/impact08k.eps}

# Example

* **Goal:** Dynamic Slice for `Y` at end of execution
* **Input:** `X = −1`
* **History:** $\left<S1, S2, S3, S4, S10, S11\right>$

\centering
\includegraphics[width=.65\textwidth]{images/impact/impact08l.eps}

# Example

* **Goal:** Dynamic Slice for `Y` at end of execution
* **Input:** `X = −1`
* **History:** $\left<S1, S2, S3, S4, S10, S11\right>$

\centering
\includegraphics[width=.65\textwidth]{images/impact/impact08m.eps}

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge Ripple Effect
\vskip-0.75em
\rule{.725\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# Ripple Effect

* Brief History
  * Early 1970s: Haney introduced the concept of ripple effect
  * 1978: Yau, Collofello and McGregor define ripple effect from the functional and performance perspectives
    * Viewed ripple effect as a complexity measure to compare changes to source code.
    * Computed by means of error flow analysis.


# Error Flow Analysis

* In this analysis, program variables involved in a change are considered to be potential sources of errors
* Inconsistency can propagate from those sources to other variables in the program.
* The other sources of errors are successively identified until error propagation is no more possible.
* This work was extended to include stability measure
  * Stability reflects the resistance to the potential ripple effect which a program would have when it is changed.
  * Stability analysis and impact analysis differ as follows:
    * stability analysis considers the total potential ripple effects rather than a specific ripple effect caused by a change.

# Design Stability

\footnotesize

* **Design stability** - Yau and Collofello
  - Developed an algorithm to compute stability based on design documentation.
  - One counts the number of assumptions made about shared global data structures and module interfaces.
* Difference between design level stability and code level stability:
  * Design level stability does not consider change propagation within modules.

# Computing Ripple Effect

\footnotesize
* The basic idea is to identify the impact of a change to one variable on the program.
* We will consider two types of change propagation
  - Intramodule change propagation
  - Intermodule change propagation

# Intramodule Change Propagation

\footnotesize

**Intramodule change propagation:** the propagation of changes from one source code line in a module to another source code line within the same module

**Example:**

::: columns
:::: column

* Consider module m1 containing the three lines of code referring to variables `a`, `b`, `d`.
  - \scriptsize A change in the value of `b` will impact `a` in line (1)
    - \scriptsize The change will propagate to `a` in line (2).
  - \scriptsize Variable `a` affects variable `d` in line (2)
    - \scriptsize This will propagate to variable `d` in line (3).

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/impact/impact09.eps}

::::
:::

# Intermodule Change Propagation

\footnotesize

* **Intermodule change propagation:** Propagation of values of variables in one module to variables in a different module
  * Intermodule change propagation of values of a variable w occurs in the following ways:
    * \scriptsize If `w` is a global variable, then a change made to `w` by one module is seen by another module accessing `w`.
    * \scriptsize If `w` is an input parameter in a call to a second module, then values of w are propagated from the caller to the callee.
    * \scriptsize If `w` is an output parameter, then its value propagates from the module that makes an output to the module that accepts the output.

# Example

::: columns
:::: column
* Variable `d` propagates to any module that calls `m1`, because `d` appears in the return statement.
* If variable `a` is global, its appearance on the left-hand-side of an assignment statement causes its value to be propagated to any module that uses variable `a`.

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/impact/impact09.eps}

::::
:::

# Computing Ripple Effect

\footnotesize

* A matrix $V_m$ is used to represent the initial starting points for intramodule change propagation.
* The matrix records the following five conditions of the module’s variable x for all x:
  - \scriptsize `x` is defined in an assignment statement.
  - \scriptsize `x` is assigned a value in a read input statement.
  - \scriptsize `x` is an input to an invoked module.
  - \scriptsize `x` is an output from an invoked module.
  - \scriptsize `x` is a global variable.
* In $V_m$, variable definitions are uniquely identified.
* Variable occurrences are provide a value in the matrix
  - occurrence meets one of the above conditions -> value = 1
  - otherwise -> value = 0
* $x^{d}_{i}$ means that the variable $x$ has been **defined** at line (i).
* $x^{u}_{i}$ means that the variable $x$ has been **used** at line (i).

# Computing Ripple Effect

\scriptsize

* In module `m1`, variable `a` is global and it is considered to be defined. Matrix $V_{m1}$ for the lines of code in `m1` is expressed as:

\vskip-2em

$$
V_{m1} = \begin{blockarray}{ccccc}
         a^{d}_{1} & d^{u}_{1} & d^{d}_{2} & a^{u}_{2} & d^{u}_{3} \\
         \begin{block}{(ccccc)}
         1 & 0 & 1 & 1 & 0 \\
         \end{block}
         \end{blockarray}
$$

\vskip-3em

* A zero-one (0−1) matrix $Z_m$ indicates values of what variables propagate to other variables in the same module.
* Individual occurrences of variables are denoted by rows and columns of $Z_m$.
* The source code of module m1 results in the following matrix:

\vskip-2em

$$
Z_{m1} = \begin{blockarray}{cccccc}
         & a^{d}_{1} & d^{u}_{1} & d^{d}_{2} & a^{u}_{2} & d^{u}_{3} \\
         \begin{block}{c(ccccc)}
         a^{d}_{1} & 1 & 0 & 1 & 1 & 1 \\
         d^{u}_{1} & 1 & 1 & 1 & 1 & 1 \\
         d^{d}_{2} & 0 & 0 & 1 & 0 & 1 \\
         a^{u}_{2} & 0 & 0 & 1 & 1 & 1 \\
         d^{u}_{3} & 0 & 0 & 0 & 0 & 1 \\
         \end{block}
         \end{blockarray}
$$

\vskip-3em

* It is easy to observe that $Z_{m1}$ is both reflexive and transitive.
The reflexive property implies that every variable propagates to itself. whereas transitivity means that if $v_1$ propagates to $v_2$ and $v_2$ propagates to $v_3$ then $v_1$ also propagates to $v_3$.

# Computing Ripple Effect

\scriptsize

* Suppose that module $m_1$ is called by $m_2$, $a$ is a global variable, and $m_2$ and $m_3$ use $a$.
* If values of the variable corresponding to row $i$ propagate to the module corresponding to column $j$, then the (i, j)th entry of the zero-one matrix is set to 1.
* For all the variables of a module m1, propagation of their values to other modules is captured by an $X$ matrix, denoted by $X_{m1}$ as follows:

\vskip-2.5em

$$
X_{m1} = \begin{blockarray}{cccc}
         & m_{1} & m_{2} & m_{3} \\
         \begin{block}{c(ccc)}
         a^{d}_{1} & 0 & 1 & 1 \\
         d^{u}_{1} & 0 & 0 & 0 \\
         d^{d}_{2} & 0 & 0 & 0 \\
         a^{u}_{2} & 0 & 0 & 0 \\
         d^{u}_{3} & 0 & 0 & 1 \\
         \end{block}
         \end{blockarray}
$$

\vskip-2.5em

The intermodule change propagation for variables occurring in $m_1$ is obtained by means of the Boolean product of the two matrices $Z_{m1}$ and $X_{m1}$, as follows:

\vskip-1.75em

$$
Z_{m1}X_{m1}=\begin{pmatrix}1 & 0 & 1 & 1 & 1\\
1 & 1 & 1 & 1 & 1\\
0 & 0 & 1 & 0 & 1\\
0 & 0 & 1 & 1 & 1\\
0 & 0 & 0 & 0 & 1
\end{pmatrix}\begin{pmatrix}0 & 1 & 1\\
0 & 0 & 0\\
0 & 0 & 0\\
0 & 0 & 0\\
0 & 0 & 1
\end{pmatrix}=\begin{pmatrix}0 & 1 & 1\\
0 & 1 & 1\\
0 & 0 & 1\\
0 & 0 & 1\\
0 & 0 & 1
\end{pmatrix}
$$

\vskip-1.75em

In the Boolean product $Z_{m1}X_{m1}$, the "1" in row 2, column 3 indicates change propagation from $b^{u}_{1}$ to $m_3$; similarly, the "0" in row 3, column 2 indicates no change propagation from $d^{d}_{2}$ to $m_2$.

# Computing Ripple Effect

\scriptsize

The Boolean product of $V_{m1}$ and $Z_{m1}X_{m1}$ indicates the variable definitions that propagate from $m_1$ to other modules:

\vskip-2em

$$
V_{m1}Z_{m1}X_{m1}=\begin{pmatrix}1 & 0 & 1 & 1 & 0\end{pmatrix}\begin{pmatrix}0 & 1 & 1\\
0 & 0 & 0\\
0 & 0 & 0\\
0 & 0 & 0\\
0 & 0 & 1
\end{pmatrix}=\begin{pmatrix}0 & 1 & 3\end{pmatrix}
$$

\vskip-1.5em

Now, $V_{m1}Z_{m1}X_{m1}$ indicates that there are no change propagations to $m_1$, one change propagation to $m_2$, and three change propagations to $m_3$.

* Concerning the complexity of making changes, the more complex a module is, the more resources are needed to change the module.
* Therefore, a measure of complexity can be factored into the calculation of change propagation to obtain a measure of the complexity of modifying the definitions of variables.
* The well-known McCabe’s cyclomatic complexity can be integrated with the ongoing computation of change propagation.

# Computing Ripple Effect

\scriptsize

* A $C$ matrix of dimensions $1 \times n$ is chosen to represent McCabe’s cyclomatic complexity, where n is the number of modules:

\vskip-2em

$$
C=\begin{array}{cc}
\begin{array}{c}
m_{1}\\
m_{2}\\
m_{3}
\end{array} & \begin{pmatrix}1\\
1\\
1
\end{pmatrix}\end{array}
$$

\vskip-1.5em

Because the complete codes for $m_1$, $m_2$, and $m_3$ have not been given, we assume their arbitrary complexity values for example purpose. The product of $V_{m1}Z_{m1}X_{m1}$ and $C$ is:

\vskip-1.5em

$$
V_{m1}Z_{m1}X_{m1}C=\begin{pmatrix}0 & 1 & 3\end{pmatrix}\begin{pmatrix}1\\
1\\
1
\end{pmatrix}=\left(4\right)
$$

\vskip-1.5em

The complexity-weighted total propagation of variable definitions for $m_1$ is represented by $V_{m1}Z_{m1}X_{m1}C$. The quantity $V_{m1}Z_{m1}X_{m1}C / |V_{m1}|$, where $|V_{m1}|$ represents the total member of variable definitions in $m_1$, represents the mean complexity-weighted propagation of variable definitions in $m_1$. In the aforementioned example, $|V_{m1}| = 3$, and it means that ripple in module $m_1$ is caused by three sources. For module $m_1$, the mean complexity-weighted propagation of variable is $4/3 = 1.33$. The general expression for calculating the ripple effect for a program (REP) is as follows:

\vskip-2em

$$
REP=\frac{1}{n}\overset{n}{\underset{m=1}{\sum}}\frac{V_{m}\cdot Z_{m}\cdot X_{m}\cdot C}{\left|V_{m}\right|}
$$

where $m$ = module and $n$ = number of modules


# Computing Ripple Effect

* Sue Black examined some links between ripple effect and Lehman's Laws

\scriptsize

+---------------------------------------------+-------------------------------------------------------+
| **Lehman's Laws**                           | **Relevance to ripple effect**                        |
+:============================================+:======================================================+
| I Continuing change                         | Compare versions of program \vskip0.1em               |
|                                             | Highlight complex modules \vskip0.1em                 |
|                                             | Measure stability over time \vskip0.1em               |
|                                             | Highlight areas ripe for restructuring/refactoring    |
|                                             | \vskip0.25em                                          |
+---------------------------------------------+-------------------------------------------------------+
| II Increasing complexity                    | Determine which module needs maintenance \vskip0.1em  |
|                                             | Measure growing complexity                            |
|                                             | \vskip0.25em                                          |
+---------------------------------------------+-------------------------------------------------------+
| III Self regulation                         | Helps measure rate of change of system \vskip0.1em    |
|                                             | Helps look at patterns/trends of behavior \vskip0.1em |
|                                             | Determine the state of the system                     |
+---------------------------------------------+-------------------------------------------------------+

# Computing Ripple Effect

* Sue Black examined some links between ripple effect and Lehman's Laws

\scriptsize

+---------------------------------------------+-------------------------------------------------------+
| **Lehman's Laws**                           | **Relevance to ripple effect**                        |
+:============================================+:======================================================+
| IV Conservation of organizational stability | Not relevant                                          |
|                                             | \vskip0.25em                                          |
+---------------------------------------------+-------------------------------------------------------+
| V Conservation of familiarity               | Provide system change data                            |
|                                             | \vskip0.25em                                          |
+---------------------------------------------+-------------------------------------------------------+
| VI Continuing growth                        | Measure impact of new modules on a system \vskip0.1em |
|                                             | Help determine which modules in use in a new version  |
|                                             | \vskip0.25em                                          |
+---------------------------------------------+-------------------------------------------------------+
| VII Declining quality                       | Highlight areas of increasing complexity \vskip0.1em  |
|                                             | Determine which modules need maintenance \vskip0.1em  |
|                                             | Measure stability over time                           |
|                                             | \vskip0.25em                                          |
+---------------------------------------------+-------------------------------------------------------+
| VIII Feedback system                        | Provide feedback on stability/complexity of system    |
+---------------------------------------------+-------------------------------------------------------+

# For Next Time

::: columns
:::: {.column width=.6}
\footnotesize
* Review EVO Chapter 6.3
* Read EVO Chapter 6.4 - 6.6 & 7.1 - 7.3
* Watch Lecture 16
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
