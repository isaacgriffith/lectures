---
author:
- Dr. Isaac Griffith
title: Graph Coverage Overview
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

# Graph Coverage

\begin{center}
\includegraphics[width=.825\textwidth]{images/Testing/Graph/structures.eps}
\end{center}

# Covering Graphs

* Graphs are the most **commonly** used structure for testing

\vskip.5em

* Graphs can come from **many sources**
  - Control flow graphs
  - Design structure
  - FSMs and statecharts
  - Use cases

\vskip.5em

* Tests usually are intended to "**cover**" the graph in some way

# Definition of a Graph

* A set $N$ of **nodes**, $N$ is not empty
* A set $N_0$ of **initial nodes**, $N_0$ is not empty
* A set $N_f$ of **final nodes**, $N_f$ is not empty
* A set $E$ of **edges**, each edge from one node to another
  - $\left(n_i, n_j\right)$, $i$ is **predecessor**, $j$ is **successor**

\begin{center}
\includegraphics[width=.5\textwidth]{images/Testing/Graph/isgraph_q.eps}
\end{center}

# Definition of a Graph

* A set $N$ of **nodes**, $N$ is not empty
* A set $N_0$ of **initial nodes**, $N_0$ is not empty
* A set $N_f$ of **final nodes**, $N_f$ is not empty
* A set $E$ of **edges**, each edge from one node to another
  - $\left(n_i, n_j\right)$, $i$ is **predecessor**, $j$ is **successor**

\begin{center}
\includegraphics[width=.5\textwidth]{images/Testing/Graph/isgraph_yes.eps}
\end{center}

# Example Graphs

\begin{center}
\includegraphics[width=.7\textwidth]{images/Testing/Graph/examples.eps}
\end{center}

# Example Graphs

\begin{center}
\includegraphics[width=.7\textwidth]{images/Testing/Graph/examples_star.eps}
\end{center}

# Paths in Graphs

* **Path**: A sequence of nodes - $[n_1, n_2, \ldots, n_M]$
  - Each pair of nodes is an edge
* **Length**: The number of edges
  - A single node is a path of length 0
* **Subpath**: A subsequence of nodes in $p$ is a subpath of $p$

::: columns
:::: column
\begin{center}
\includegraphics[width=.6\textwidth]{images/Testing/Graph/path_ex.eps}
\end{center}
::::
:::: column
##

Write down three paths in this graph
::::
:::

# Paths in Graphs

* **Path**: A sequence of nodes - $[n_1, n_2, \ldots, n_M]$
  - Each pair of nodes is an edge
* **Length**: The number of edges
  - A single node is a path of length 0
* **Subpath**: A subsequence of nodes in $p$ is a subpath of $p$

::: columns
:::: column
\begin{center}
\includegraphics[width=.6\textwidth]{images/Testing/Graph/path_ex.eps}
\end{center}
::::
:::: column

##

Write down three paths in this graph

* [1, 4, 8]
* [2, 5, 9]
* [3, 7, 10]
::::
:::

# Test Paths and SESEs

* **Test Path**: A path that starts at an initial node and ends at a final node
* Test paths represent execution of test cases
  - Some test paths can be executed by many tests
  - Some test paths cannot be executed by any tests
* **SESE graphs**: All test paths start at a single node and end at another node
  - Single-entry, Single-exit
  - $N_0$ and $N_f$ have exactly one node

::: columns
:::: column
\vskip-1em
\begin{center}
\includegraphics[width=.7\textwidth]{images/Testing/Graph/sese.eps}
\end{center}
::::
:::: column

##

Write down all the test paths in this graph

::::
:::

# Test Paths and SESEs

* **Test Path**: A path that starts at an initial node and ends at a final node
* Test paths represent execution of test cases
  - Some test paths can be executed by many tests
  - Some test paths cannot be executed by any tests
* **SESE graphs**: All test paths start at a single node and end at another node
  - Single-entry, Single-exit
  - $N_0$ and $N_f$ have exactly one node

::: columns
:::: column
\vskip-1em
\begin{center}
\includegraphics[width=.7\textwidth]{images/Testing/Graph/sese.eps}
\end{center}
::::
:::: column

\vskip-3em

## Double-diamond Graph

**Four Test paths**

1. [1, 2, 4, 5, 7]
2. [1, 2, 4, 6, 7]
3. [1, 3, 4, 5, 7]
4. [1, 3, 4, 6, 7]
::::
:::

# Visiting and Touring

* **Visit**
  - A test path $p$ **visits** node $n$, if $n$ is in $p$
  - A test path $p$ **visits** edge $e$, if $e$ is in $p$
* **Tour**: A test path $p$ **tours** subpath $q$, if $q$ is a subpath of $p$

##

**Test Path**: [1, 2, 4, 5, 7]

* **Visits Nodes**?
* **Visits Edges**?
* **Tours subpaths**?

# Visiting and Touring

* **Visit**
  - A test path $p$ **visits** node $n$, if $n$ is in $p$
  - A test path $p$ **visits** edge $e$, if $e$ is in $p$
* **Tour**: A test path $p$ **tours** subpath $q$, if $q$ is a subpath of $p$

##

**Test Path**: [1, 2, 4, 5, 7]

* **Visits Nodes**? 1, 2, 4, 5, 7
* **Visits Edges**?
* **Tours subpaths**?

# Visiting and Touring

* **Visit**
  - A test path $p$ **visits** node $n$, if $n$ is in $p$
  - A test path $p$ **visits** edge $e$, if $e$ is in $p$
* **Tour**: A test path $p$ **tours** subpath $q$, if $q$ is a subpath of $p$

##

**Test Path**: [1, 2, 4, 5, 7]

* **Visits Nodes**? 1, 2, 4, 5, 7
* **Visits Edges**? (1,2), (2,4), (4,5), (5,7)
* **Tours subpaths**?

# Visiting and Touring

* **Visit**
  - A test path $p$ **visits** node $n$, if $n$ is in $p$
  - A test path $p$ **visits** edge $e$, if $e$ is in $p$
* **Tour**: A test path $p$ **tours** subpath $q$, if $q$ is a subpath of $p$

##

**Test Path**: [1, 2, 4, 5, 7]

* **Visits Nodes**? 1, 2, 4, 5, 7
* **Visits Edges**? (1,2), (2,4), (4,5), (5,7)
* **Tours subpaths**? [1,2,4], [2,4,5], [4,5,7], [1,2,4,5], [2,4,5,7], [1,2,4,5,7]

**(Also, each edge is technically a subpath)**

# Tests and Test Paths

* **path (t)**: The test path executed by test $t$
* **path (T)**: The set of test paths executed by the set of tests $T$
* Each test executes **one an only one** test path
  - Complete execution from a start node to a final node
* A location in a graph (node or edge) can be **reached** from another location if there is a sequence of edges from the first location to the second
  - **Syntactic** reach: A subpath exists in the graph
  - **Semantic** reach: A test exists that can execute that subpath
  - This distinction becomes important in **section 7.3**

# Tests and Test Paths

::: columns
:::: column

\begin{center}
\includegraphics[width=.95\textwidth]{images/Testing/Graph/testpath1.eps}

\textbf{Deterministic software -- test always executes the same test path}
\end{center}

::::
:::: column

\begin{center}
\includegraphics[width=.95\textwidth]{images/Testing/Graph/testpath2.eps}

\textbf{Non-deterministic software -- the same test can execute different test paths}
\end{center}
::::
:::

# Testing and Covering Graphs

* We use graphs in testing as follows:
  - Develop a model of the software as a graph
  - Require tests to visit or tour specific sets of nodes, edges or subpaths

\vskip1em

* **Test Requirements (TR)**: Describe properties of test paths

\vskip.5em

* **Test Criterion**: Rules that define test requirements

\vskip.5em

* **Satisfaction**: Given a set $TR$ of test requirements for a criterion $C$, a set of tests $T$ satisfies $C$ on a graph if and only if for every test requirement in $TR$, there is a test path in path(T) that meets the test requirement $tr$

\vskip.5em

* **Structural Coverage Criteria**: Defined on a graph just in terms of nodes and edges.

# Node and Edge Coverage

* The first (and simplest) two criteria require that each node and edge in a graph be executed

  \vskip.5em

  \underline{\textbf{Node Coverage (NC)}}: Test set $T$ satisfies node coverage on graph $G$ iff for every syntactically reachable node $n$ in $N$, there is some path $p$ in $path(T)$ such that $p$ visits $n$.


\vskip.1em

* This statement is a bit cumbersome, so we abbreviate it in terms of the set of test requirements

  \vskip.5em

  \underline{\textbf{Node Coverage (NC)}}: $TR$ contains each reachable node in $G$.

# Node and Edge Coverage

* Edge coverage is slightly stronger than node coverage

  \vskip.5em

  \underline{\textbf{Edge Coverage (EC)}}: $TR$ contains each reachable path of length up to 1, inclusive, in $G$.

\vskip.5em

* The phrase *"length up to 1"* allows for graphs with one node and no edges.

\vskip.5em

* NC and EC are only different when there is an edge and another subpath between a pair of nodes (as in an "if-else" statement)

::: columns
:::: column
\begin{center}
\includegraphics[width=.575\textwidth]{images/Testing/Graph/ifelse.eps}
\end{center}
::::
:::: column
**Node Coverage**

* TR? = \only<2>{\{1,2,3,4\}}
* Test Paths = \only<2>{[1, 2, 4] [1, 3, 4]}

**Edge Coverage**

* TR? = \only<2>{\{(1,2), (1,3), (2,4), (3,4)\}}
* Test Paths = \only<2>{[1, 2, 4] [1, 3, 4]}
::::
:::

# Paths of Length 1 and 0

* A graph with **only one node** will not have any edges

\begin{center}
\includegraphics[width=.05\textwidth]{images/Testing/Graph/onenode.eps}
\end{center}

* It may seem trivial, but formally, Edge Coverage needs to require Node Coverage on this graph
* Otherwise, Edge Coverage will not subsume Node Coverage
  - So we define "**length up to 1**" instead of simply "length 1"

::: columns
:::: column
* We have the same issue with graphs that only have **one edge**
  - for Edge-Pair Coverage ...
::::
:::: column
\begin{center}
\includegraphics[width=.075\textwidth]{images/Testing/Graph/oneedge.eps}
\end{center}
::::
:::

# Covering Multiple Edges

* Edge-pair coverage requires **pairs of edges**, or subpaths of length 2
  \underline{\textbf{Edge-Pair Coverage (EPC)}}: $TR$ contains each reachable path of length up to 2, inclusive, in $G$.

* The phrase "**length up to 2**" is used to include graphs that have less than 2 edges

::: columns
:::: column
\begin{center}
\includegraphics[width=.75\textwidth]{images/Testing/Graph/epcgraph.eps}
\end{center}
::::
:::: column
**Edge-Pair Coverage**:

* TR = \only<1>{?}\only<2>{\{[1,4,5], [1,4,6], [2,4,5], [2,4,6], [3,4,5], [3,4,6]\}}
::::
:::

* The logical extension is to require **all paths** ...

# Covering Multiple Edges

\underline{\textbf{Complete Path Coverage (CPC)}}: $TR$ contains all paths in $G$.

\vskip.5em

Unfortunately, this is **impossible** if the graph has a loop, so a weak compromise makes the tester decide which paths;

\vskip1em

\underline{\textbf{Specified Path Coverage (SPC)}}: $TR$ contains a set $S$ of test paths, where $S$ is supplied as a parameter.

# Structural Coverage Example

::: columns
:::: {.column width=.25}
\begin{center}
\includegraphics[width=.925\textwidth]{images/Testing/Graph/sc_example.eps}
\end{center}
::::
:::: {.column width=.75}
\begin{center}
Write down the TRs and\\
Test paths for these criteria:

\begin{itemize}
\item Node Coverage
\item Edge Coverage
\item Edge-Pair Coverage
\item Complete Path Coverage
\end{itemize}
\end{center}
::::
:::

# Structural Coverage Example

::: columns
:::: {.column width=.25}
\begin{center}
\includegraphics[width=.925\textwidth]{images/Testing/Graph/sc_example.eps}
\end{center}
::::
:::: {.column width=.75}

\scriptsize

* **Node Coverage**

  **TR** = {1, 2, 3, 4, 5, 6, 7}

  **Test Paths**: [1,2,3,4,7] [1,2,3,5,6,5,7]

\vskip.5em

* **Edge Coverage**

  **TR** = {(1,2), (1,3), (2,3), (3,4), (3,5), (4,7), (5,6), (5,7), (6,5)}

  **Test Paths**: [1,2,3,4,7] [1,3,5,6,5,7]

\vskip.5em

* **Edge-Pair Coverage**

  **TR** = {[1,2,3], [1,3,4], [1,3,5], [2,3,4], [2,3,5], [3,4,7], [3,5,6], [3,5,7], [5,6,5], [6,5,6], [6,5,7]}

  **Test Paths**: [1,2,3,4,7] [1,2,3,5,7] [1,3,4,7] [1,3,5,6,5,6,5,7]

\vskip.5em

* **Complete Path Coverage**

  **Test Paths**: [1,2,3,4,7] [1,2,3,5,7] [1,2,3,5,7] [1,2,3,5,6,5,7] [1,2,3,5,6,5,6,5,7] [1,2,3,5,6,5,6,5,6,5,7] ...

::::
:::

# Handling Loops in Graphs

* If a graph contains a loop, it has an **infinite** number of paths

\vskip.5em

* Thus, CPC is **not feasible**

\vskip.5em

* SPC is not satisfactory because the results are **subjective** and vary with the tester

\vskip.5em

* Attempts to "deal with" **loops**:
  - **1970s**: Execute cycles once ([4,5,4] in previous example, informal)
  - **1980s**: Execute each loop, exactly once (formalized)
  - **1990s**: Execute loops 0 times, once, more than once (informal description)
  - **2000s**: Prime paths (touring, sidetrips, and detours)

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
