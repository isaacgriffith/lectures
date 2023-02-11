---
author:
- Dr. Isaac Griffith
title: Graph Coverage Overview Part 2
course: CS 3321
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Inspiration

\vfill
\centering
> "All software is a graph" -- Anonymous

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand the basic concepts of graph coverage
* Understand def, use, and du pairs
* Evaluate a given graph for graph coverage criteria
::::
:::: {.column width=.25}
\vfill
\vspace{7.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

# Simple Paths and Prime Paths

* **Simple Path**: *A path from node $n_i$ to $n_j$ is simple if no node appears more than once, except possibly the first and last nodes are the same*
  - No internal loops
  - A loop is a simple path
* **Prime Path**: *A simple path that does not appear as a proper subpath of any other simple path*

::: columns
:::: {.column width=.33}
\includegraphics[width=.75\textwidth]{images/Testing/Graph/loop.eps}
::::
:::: {.column width=.66}

##

Write down the simple and prime paths for this graph

\only<2>{
\textbf{Simple Paths:}

[1,2,4,1], [1,3,4,1], [2,4,1,2], [2,4,1,3], [3,4,1,2], [3,4,1,3], [4,1,2,4], [4,1,3,4], [1,2,4], [1,3,4], [2,4,1], [3,4,1], [4,1,2], [4,1,3], [1,2], [1,3], [2,4], [3,4], [4,1], [1], [2], [3], [4]

\textbf{Prime Paths:}

[2,4,1,2], [2,4,1,3], [1,3,4,1], [1,2,4,1], [3,4,1,2], [4,1,3,4], [4,1,2,4], [3,4,1,3]
}
::::
:::

# Prime Path Coverage

* A simple, elegant and finite criterion that requires **loops** to be executed as well as skipped

  \vskip.5em

  \underline{\textbf{Prime Path Coverage (PPC)}}: $TR$ contains each prime path in $G$

\vskip.5em

* Will tour all paths of length 0, 1, ...

\vskip.5em

* That is, it **subsumes** node and edge coverage

\vskip.5em

* PPC almost, but **not quite**, subsumes **EPC** ...

# PPC Does Not Subsume EPC

* If a node **$n$** has an edge to itself (*self edge*), **EPC** requires **$[n, n, m]$** and **$[m, n, n]$**
* **$[n, n, m]$** is not prime
* Neither **$[n, n, m]$** nor **$[m, n, n]$** are simple paths (not prime)

::: columns
:::: column
\includegraphics[width=.20\textwidth]{images/Testing/Graph/ppcepc.eps}
::::
:::: column
* **EPC Requirements:**

  \vskip.5em

  TR = \only<1>{?}\only<2>{\{[1,2,3], [1,2,2], [2,2,3], [2,2,2]\}}

\vskip.5em

* **PPC Requirements:**

  \vskip.5em

  TR = \only<2>{?}\only<2>{\{[1,2,3], [2,2]\}}
::::
:::

# Prime Path Example

* The previous example has 38 **simple** paths
* Only **nine** prime paths

::: columns
:::: {.column width=.25}
\centering
\includegraphics[width=.825\textwidth]{images/Testing/Graph/sc_example.eps}
::::
:::: {.column width=.75}
## Prime Paths

\only<1>{Write down all 9 prime paths}
\only<2>{
[1, 2, 3, 4, 7]

[1, 2, 3, 5, 7]

[1, 2, 3, 5, 6]

[1, 3, 4, 7]

[1, 3, 5, 7] -> Execute Loop 0 times

[1, 3, 5, 6] -> Execute loop once

[6, 5, 7]

[6, 5, 6] -> Execute loop more than once

[5, 6, 5]
}
::::
:::

# Touring, Sidetrips, and Detours

* Prime paths do not have **internal loops** .. test paths \underline{might}

\vskip.5em

* **Tour**: *A test path $p$ tours subpath $q$ if $q$ is a subpath of $p$*

\vskip.5em

* **Tour With Sidetrips**: *A test path $p$ tours subpath $q$ with sidetrips iff every edge in $q$ is also in $p$ in the same order*
  - The tour can include a sidetrip, as long as it comes back to the same node

\vskip.5em

* **Tour With Detours**: *A test path $p$ tours subpath $q$ with detours iff every node in $q$ is also in $p$ in the same order*
  - The tour can include a detour from node $n_i$, as long as it comes back to the prime path at a successor of $n_i$

# Sidetrips and Detours Example

\begin{center}
\includegraphics[width=.35\textwidth]{images/Testing/Graph/sidetrip_ex.eps}
\end{center}

# Infeasible Test Requirements

* An **infeasible** test requirement \underline{cannot be satisfied}
  - Unreachable statement (dead code)
  - Subpath that can only be executed with a contradiction $\left(X > 0\right)$ and $\left(X < 0\right)$
* Most test **criteria** have some infeasible test requirements
* It is usually **undecidable** whether all test requirements are feasible
* When sidetrips are not allowed, many structural criteria have **more infeasible test requirements**
* However, always allowing **sidetrips weakens** the test criteria

## Practical Recommendation--Best Effort Touring

* Satisfy as many test requirements as possible without sidetrips
* Allow sidetrips to try to satisfy remaining test requirements

# Simple \& Prime Path Example

::: columns
:::: {.column width=.33}
\begin{center}
\includegraphics[width=.7\textwidth]{images/Testing/Graph/sc_example.eps}
\end{center}
::::
:::: {.column width=.67}
## Simple Paths

\only<1>{
Write all paths of length 0

Write Paths of length 1

Write paths of length 2

Write paths of length 3

Write paths of length 4
}
\only<2>{
Length 0: [1] [2] [3] [4] [5] [6] [7]!

\vskip.5em

Length 1: [1,2] [1,3] [2,3] [3,4] [3,5] [4,7]! [5,7]! [5,6] [6,5]

\vskip.5em

Length 2: [1,2,3] [1,3,4] [1,3,5] [2,3,4] [2,3,5] [3,4,7]! [3,5,7]! [3,5,6] [5,6,5]* [6,5,7]! [6,5,6]*

\vskip.5em

Length 3: [1,2,3,4] [1,2,3,5] [1,3,4,7]! [1,3,5,7]! [1,3,5,6]! [2,3,4,7]! [2,3,5,6]! [2,3,5,7]!

\vskip.5em

Length 4: [1,2,3,4,7]! [1,2,3,5,7]! [1,2,3,5,6]!

\vskip.5em

\large Prime Paths?

\vskip.5em

\small

! means path terminates

\* means path is cyclic
}
\only<3>{
Length 0: [1] [2] [3] [4] [5] [6] [7]!

\vskip.5em

Length 1: [1,2] [1,3] [2,3] [3,4] [3,5] [4,7]! [5,7]! [5,6] [6,5]

\vskip.5em

Length 2: [1,2,3] [1,3,4] [1,3,5] [2,3,4] [2,3,5] [3,4,7]! [3,5,7]! [3,5,6]! \textbf{[5,6,5]* [6,5,7]! [6,5,6]*}

\vskip.5em

Length 3: [1,2,3,4] [1,2,3,5] \textbf{[1,3,4,7]! [1,3,5,7]! [1,3,5,6]!} [2,3,4,7]! [2,3,5,6]! [2,3,5,7]!

\vskip.5em

Length 4: \textbf{[1,2,3,4,7]! [1,2,3,5,7]! [1,2,3,5,6]!}

\vskip.5em

\small

! means path terminates

* means path is cyclic

\textbf{Bold} means prime path
}
::::
:::

# Round Trips

* **Round-Trip Path**: *A prime path that starts and ends at the same node*

  \vskip.5em

  \underline{\textbf{Simple Round Trip Coverage (SRTC)}}: $TR$ contains at least one round-trip path for each reachable node in $G$ that begins and ends a round-trip path

  \vskip.5em

  \underline{\textbf{Complete Round Trip Coverage (CRTC)}}: $TR$ contains all round-trip paths for each reachable node in $G$.

\vskip.5em

* These criteria **omit nodes and edges** that are not in round trips

\vskip.5em

* Thus, they do **not** subsume edge-pair, edge, or node coverage

# Data Flow Criteria

\begin{center}
\textbf{Goal: Ensure that values are computed and used correctly}
\end{center}

* **Definition (def)**: A location where a value for a variable is stored into memory.

* **Use**: A location where a variable's value is accessed

::: columns
:::: column
\includegraphics[width=.75\textwidth]{images/Testing/Graph/dfc.eps}
::::
:::: column
## Fill in the Sets

```
Defs: { }

Uses: { }
```
::::
:::

# Data Flow Criteria

::: columns
:::: column
\includegraphics[width=.95\textwidth]{images/Testing/Graph/dfc.eps}
::::
:::: column
## Fill in the Sets

```
Defs: {
  def (1) = { X }
  def (5) = { Z }
  def (6) = { Z }
}

Uses: {
  use (5) = { X }
  use (6) = { X }
}
```
::::
:::

\centering
The values given in **defs** should **reach** at least one, some, or all possible **uses**

# DU Pairs and DU Paths

* **def(n) or def (e)**: The set of variables that are defined by node $n$ or edge $e$

\vskip.5em

* **use (n) or use (e)**: The set of variables that are used by node $n$ or edge $e$

\vskip.5em

* **DU pair**: A pair of locations ($l_i, l_j$) such that a variable $v$ is defined at $l_i$ and used at $l_j$

\vskip.5em

* **Def-clear**: A path from $l_i$ to $l_j$ is *def-clear* with respect to variable $v$ if $v$ is not given another value on any of the nodes or edges in the path

# DU Pairs and DU Paths

* **Reach**: If there is a def-clear path from $l_i$ to $l_j$ with respect to $v$, the def of $v$ at $l_i$ reaches the use at $l_j$

\vskip.5em

* **du-path**: A simple subpath that is def-clear with respect to $v$ from a def of $v$ to a use of $v$

\vskip.5em

* **du($n_i, n_j, v$)** - the set of du-paths from $n_i$ to $n_j$

\vskip.5em

* **du($n_i, v$)** - the set of du-paths that start at $n_i$

# Touring DU-Paths

* A test path p **du-tours** subpath $d$ with respect to $v$ if $p$ tours $d$ and the subpath taken is def-clear with respect to $v$

\vskip.5em

* **Sidetrips** can be used, just as with previous touring

\vskip.5em

* Three criteria
  - Use every def
  - Get to every use
  - Follow all du-paths

# Data Flow Test Criteria

* First, we make sure **every def** reaches **a use**

  \vskip.5em

  \underline{\textbf{All-defs coverage (ADC):}} For each set of du-paths $S = du(n, v)$, TR contains at least one path $d \in S$.

\vskip.5em

* Then we make sure that **every def** reaches **all** possible **uses**

  \vskip.5em

  \underline{\textbf{All-uses coverage (AUC):}} For each set of du-paths to uses $S = du(n_i, n_j, v)$, TR contains at least one path $d \in S$

\vskip.5em

* Finally, we cover **all the paths** between defs and uses

  \vskip.5em

  \underline{\textbf{All-du-paths coverage (ADUPC):}} For each set $S = du(n_i, n_j, v)$, TR contains every path $d \in S$.


# Data Flow Example

::: columns
:::: column

\vfill

\begin{center}
\includegraphics[width=.95\textwidth]{images/Testing/Graph/dfc.eps}
\end{center}

::::
:::: column

## Exercise

* Write down paths to satisfy ADC for X.

  \only<2>{
  \vskip.5em
  \textbf{All-defs for X:} [1, 2, 4, 5]
  }

  \vskip.5em

* Write down paths to satisfy AUC for X.

  \only<2>{
  \vskip.5em
  \textbf{All-uses for X:} [1, 2, 4, 5] [1, 2, 4, 6]
  }

  \vskip.5em

* Write down paths to satisfy ADUPC for X.

  \only<2>{
  \vskip.5em
  \textbf{All-du-paths for X:} [1, 2, 4, 5], [1, 3, 4, 5], [1, 2, 4, 6], [1, 3, 4, 6]
  }

::::
:::

# Graph Coverage Criteria Subsumption

\begin{center}
\includegraphics[width=.95\textwidth]{images/Testing/Graph/subsumption.eps}
\end{center}

# Summary

* Graphs are a very **powerful abstraction** for designing tests

\vskip.5em

* The various criteria allow lots of **cost/benefit** tradeoffs

\vskip.5em

* These two sections are entirely at the "**design abstraction level**" from chapter 2

\vskip.5em

* Graphs appear in **many situations** in software
  - As discussed in the remainder of chapter 7

# For Next Time

::: columns
:::: column

* Review the Reading
* Review this Lecture
* Come to Class

::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
