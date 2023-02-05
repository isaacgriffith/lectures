---
author:
- Dr. Isaac Griffith
title: Graphs
course: CS 1187
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Outline

The lecture is structured as follows:

::: columns
:::: {.column width=.7}

* Connectivity
* Euler and Hamilton Paths
* Shortest-Path Problems
* Planar Graphs
* Graph Coloring

::::
:::: {.column width=.25}
\vfill
\vspace{7.25em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\ts{Connectivity }

# Paths

* Paths in undirected graphs
  * In an undirected graph, a **path** of length $n$ from $u$ to $v$ is a sequence of adjacent edges going from vertex $u$ to vertex $v$
  * A path is a **circuit** if $u = v$
  * A path **traverses** the vertices along it.
  * A path is **simple** if it contains no edge more than once.

\vskip.5em

* Paths in directed graphs
  * Same as in undirected graphs, but the path must go in the direction of the arrows

# Connectedness

* An undirected graph is *connected* iff there is a path between every pair of distinct vertices in the graph.

\vskip.5em

* **Connected Component:** connected subgraph

\vskip.5em

* A **cut vertex** or **cut edge** separates 1 connected component into 2 if removed

\vskip.5em

* **Theorem:** There is a *simple path* between any pair of vertices in a connected *undirected graph*

# Directed Connectedness

* A directed graph is **strongly connected** iff there is a directed path from $a$ to $b$ for any two vertices $a$ and $b$

\vskip.5em

* It is **weakly connected** iff the underlying undirected graph (i.e., with edge directions removed) is connected.

\vskip.5em

* Note strongly implies weakly but not vice-versa

\vskip.5em

* Note that connectedness, and the existence of a circuit or simple circuit of length $k$ are graph invariants with respect to isomorphism.

# Counting Paths Using Adjacency Matrices

* Let $\mathbf{A}$ be the adjacency matrix of graph $G$

\vskip.5em

* The number of paths of length $k$ from $v_i$ to $v_j$ is equal to $\left(\mathbf{A}^k\right)_ij$.

#

\ts{Euler and Hamilton Paths}

# Euler Paths and Circuits

* An **Euler path** in $G$ is a simple path containing every edge of $G$

\vskip.5em

* An **Euler circuit** in a graph $G$ is a simple circuit containing every edge of $G$

\vskip.5em

::: columns
:::: column

\centering
\includegraphics[width=.8\textwidth]{images/graphs/Konigsberg_bridges.png}

::::
:::: column

\vfill
\centering
\footnotesize

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (A) [label=left:{A}] {};
\node[main] (B) [below of=A,label=left:{B}] {};
\node[main] (C) [above of=A,label=left:{C}] {};
\node[main] (D) [right of=A,label=right:{D}] {};

\draw [line width=0.25mm, BlueDeFrance] (A) to [out=225, in=135, looseness=1] (B);
\draw [line width=0.25mm, BlueDeFrance] (A) to [out=135, in=225, looseness=1] (C);
\draw [line width=0.25mm, BlueDeFrance] (A) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (B) to [out=45, in=315, looseness=1] (A);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (C) to [out=315, in=45, looseness=1] (A);
\end{tikzpicture}

::::
:::

# Examples

\vfill

::: columns
:::: {.column width=.333}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) [label=above:{a}] {};
\node[main] (e) [below right of=a,label=right:{e}] {};
\node[main] (b) [above right of=e,label=above:{b}] {};
\node[main] (d) [below left of=e,label=below:{d}] {};
\node[main] (c) [below right of=e,label=below:{c}] {};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (e) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (e) -- (c);
\end{tikzpicture}

::::
:::: {.column width=.333}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) [label=above:{a}] {};
\node[main] (e) [below right of=a,label=right:{e}] {};
\node[main] (b) [above right of=e,label=above:{b}] {};
\node[main] (d) [below left of=e,label=below:{d}] {};
\node[main] (c) [below right of=e,label=below:{c}] {};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (e) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (e) -- (c);

\end{tikzpicture}

::::
:::: {.column width=.333}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) [label=above:{a}] {};
\node[main] (b) [right of=a,label=above:{b}] {};
\node[main] (d) [below of=b,label=below:{d}] {};
\node[main] (c) [below of=a,label=below:{c}] {};
\node[main] (e) [right of=d,label=below:{e}] {};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (e);
\end{tikzpicture}

::::
:::

# Examples

\vfill

::: columns
:::: {.column width=.333}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) [label=above:{a}] {};
\node[main] (b) [right of=a,label=above:{b}] {};
\node[main] (d) [below of=a,label=below:{d}] {};
\node[main] (c) [right of=d,label=below:{c}] {};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (d);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (c) to (b);

\end{tikzpicture}

::::
:::: {.column width=.333}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) [label=above:{a}] {};
\node[main] (f) [below left of=a,label=left:{f}] {};
\node[main] (g) [below right of=a,label=below:{g}] {};
\node[main] (b) [above right of=g,label=above:{b}] {};
\node[main] (c) [below right of=g,label=below:{c}] {};
\node[main] (d) [below left of=c,label=below:{d}] {};
\node[main] (e) at (-1.1,-3.2) [label=below:{e}] {};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (g);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to (g);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (c) to (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (f);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (e) to (d);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (f) to (a);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (g) to (e);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (g) to (c);

\end{tikzpicture}

::::
:::: {.column width=.333}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) [label=above:{a}] {};
\node[main] (b) [right of=a,label=above:{b}] {};
\node[main] (c) [below of=a,label=below:{c}] {};
\node[main] (d) [right of=c,label=below:{d}] {};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (a);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to (d);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (c) to (d);

\end{tikzpicture}

::::
:::

# Euler Circuits and Paths

* **Theorem:** A connected multigraph has an Euler circuit iff each vertex has even degree

\vskip.5em

* **Theorem:** A connected multigraph has an Euler path (but not an Euler circuit) iff it has exactly 2 vertices of odd degree

# Constructing Euler Circuits

\begin{algorithmic}
\Procedure{Euler}{$G$: connected multigraph with all vertices of even degree}
  \State $circuit \coloneqq$ a circuit in $G$
  \State $H \coloneqq G$ with edges of this circuit removed
  \While{$H$ has edges}
    \State $subcircuit \coloneqq$ a circuit in $H$
    \State $H \coloneqq H$ with the edges of $subcircuit$ removed
    \State $circuit \coloneqq circuit$ with $subcircuit$ inserted at the appropriate vertex
  \EndWhile
\EndProcedure \Comment{$circuit$ is an Euler circuit}
\end{algorithmic}

# Hamilton Paths and Circuits

* A **Hamilton path** is a path that traverses each vertex in $G$ exactly once

\vskip.5em

* A **Hamilton circuit** is a circuit that traverses each vertex in $G$ exactly once

\vskip.5em

\centering
\footnotesize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) at (0,-1) {};
\node[main] (3) at (-.75,-1.5) {};
\node[main] (4) at (.75,-1.5) {};
\node[main] (5) at (-.5, -2) {};
\node[main] (6) at (.5, -2) {};
\node[main] (7) at (-.75, -2.5) {};
\node[main] (8) at (.75, -2.5) {};
\node[main] (9) at (0, -3.75) {};
\node[main] (10) at (0, -3) {};
\node[main] (11) at (-1.25, -2.75) {};
\node[main] (12) at (1.25, -2.75) {};
\node[main] (13) at (-1, -3.85) {};
\node[main] (14) at (1, -3.85) {};
\node[main] (15) at (-1.65, -1.85) {};
\node[main] (16) at (1.65, -1.85) {};
\node[main] (17) at (-2.5, -1.75) {};
\node[main] (18) at (2.5, -1.75) {};
\node[main] (19) at (-1.5, -4.5) {};
\node[main] (20) at (1.5, -4.5) {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (7) -- (10);
\draw [line width=0.25mm, BlueDeFrance] (8) -- (10);
\draw [line width=0.25mm, BlueDeFrance] (10) -- (9);
\draw [line width=0.25mm, BlueDeFrance] (9) -- (13);
\draw [line width=0.25mm, BlueDeFrance] (9) -- (14);
\draw [line width=0.25mm, BlueDeFrance] (14) -- (12);
\draw [line width=0.25mm, BlueDeFrance] (13) -- (11);
\draw [line width=0.25mm, BlueDeFrance] (7) -- (11);
\draw [line width=0.25mm, BlueDeFrance] (8) -- (12);
\draw [line width=0.25mm, BlueDeFrance] (11) -- (15);
\draw [line width=0.25mm, BlueDeFrance] (12) -- (16);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (15);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (16);
\draw [line width=0.25mm, BlueDeFrance] (15) -- (17);
\draw [line width=0.25mm, BlueDeFrance] (16) -- (18);
\draw [line width=0.25mm, BlueDeFrance] (13) -- (19);
\draw [line width=0.25mm, BlueDeFrance] (14) -- (20);
\draw [line width=0.25mm, BlueDeFrance] (17) -- (19);
\draw [line width=0.25mm, BlueDeFrance] (18) -- (20);
\draw [line width=0.25mm, BlueDeFrance] (19) -- (20);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (17);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (18);

\end{tikzpicture}

# Examples

\vskip.5em

::: columns
:::: column

::::: columns
:::::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [below of=1] {};
\node[main] (4) [right of=3] {};
\node[main] (5) at (.75, -2.5) {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);

\end{tikzpicture}

::::::
:::::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={25mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [below of=1] {};
\node[main] (4) [right of=3] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);

\end{tikzpicture}

::::::
:::::

::::
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={25mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [below of=1] {};
\node[main] (4) [right of=3] {};

\node[main] (5) [right of=2]{};
\node[main] (6) [right of=4] {};
\node[main] (7) [right of=6] {};


\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (7);

\end{tikzpicture}

::::
:::

\vskip2em

::: columns
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={25mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [below of=1] {};
\node[main] (4) [right of=3] {};

\node[main] (5) [right of=2]{};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);

\end{tikzpicture}

::::
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={25mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) at (0, 2) {};
\node[main] (2) [below of=1] {};
\node[main] (3) at (2.5, .9) {};
\node[main] (4) at (5, 2) {};
\node[main] (5) [below of=4]{};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);

\end{tikzpicture}

::::
:::

# Some Useful Theorems

* **Dirac's Theorem:** If (but not only if) $G$ is connected, simple, has $n \geq 3$ vertices, and $\forall v\,:\, \deg(v) \geq n/2$, then $G$ has a Hamilton circuit

\vskip.5em

* **Ore's Theorem:** If $G$ is a simple graph with $n$ vertices with $n \geq 3$ such that $\deg(u) + \deg(v) \geq n$ for every pair of nonadjacent vertices $u$ and $v$ in $G$, then $G$ has a Hamilton circuit

#

\ts{Shortest-Path Problems}

# Shortest-Path Problems

::: columns
:::: column

* Weighted Graphs $G(V, E, w)$
  * $V$: a vertex set
  * $E$: an edge set
  * $w$: a weighting function on $E$

\vskip.5em

* The length of a path, e.g.

  $$\begin{array}{l}
  w(\{a, b\}, \{b, d\}, \{d, f\}) \\
  = w(\{a, b\}) + w(\{b, d\}) + w(\{d, f\}) \\
  = 1 + 3 + 5 \\
  = 9
  \end{array}$$

* The shortest path

::::
:::: column

\centering
\small

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) [label=left:{b}] {};
\node[main] (2) [right of=1,label=right:{c}] {};
\node[main] (3) [below of=1,label=left:{d}] {};
\node[main] (4) [right of=3,label=right:{e}] {};
\node[main] (5) [label=below:{f}] at (1.5, -4) {};
\node[main] (6) [label=above:{a}] at (1.5, 1.25) {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- node[white, midway, left] {3} (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- node[white, midway, above left, sloped] {3} (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[white, midway, below left, sloped] {10} (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[white, midway, right] {3} (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- node[white, midway, below] {5} (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- node[white, midway, below] {1} (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[white, midway, above] {1} (6);
\draw [line width=0.25mm, BlueDeFrance] (1) -- node[white, midway, above] {4} (6);

\end{tikzpicture}

::::
:::

# Examples

::: columns
:::: column

* Some paths between $a$ and $f$
  * Path ({a, b}, {b, d}, {d, f}):

    length of ({a, b}, {b, d}, {d, f}) =

    w({a, b}) + w({b, d}) + w({d, f}) =

    1 + 2 + 5 = 9

  \vskip.5em

  * Path ({a, b}, {b, e}, {e, f}):

    length of ({a, b}, {b, e}, {e, f}) =

    w({a, b}) + w({b, e}) + w({e, f}) =

    1 + 3 + 1 = 5

  \vskip.5em

  * Path ({a, c}, {c, e}, {e, f}):

    length of ({a, c}, {c, e}, {e, f}) =

    w({a, c}) + w({c, e}) + w({e, f}) =

    4 + 3 + 1 = 8

::::
:::: column

\centering
\small

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) [label=left:{b}] {};
\node[main] (2) [right of=1,label=right:{c}] {};
\node[main] (3) [below of=1,label=left:{d}] {};
\node[main] (4) [right of=3,label=right:{e}] {};
\node[main] (5) [label=below:{f}] at (1.5, -4) {};
\node[main] (6) [label=above:{a}] at (1.5, 1.25) {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- node[white, midway, left] {3} (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- node[white, midway, above left, sloped] {3} (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[white, midway, below left, sloped] {10} (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[white, midway, right] {3} (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- node[white, midway, below] {5} (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- node[white, midway, below] {1} (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[white, midway, above] {1} (6);
\draw [line width=0.25mm, BlueDeFrance] (1) -- node[white, midway, above] {4} (6);

\end{tikzpicture}

::::
:::

# Dijkstra's Algorithm

\begin{algorithmic}
\Procedure{Dijkstra}{$G$: a weighted connected simple graph with all weights positive, $a$ is the source, $z$ is the destination}
  \State \Comment{there exists a path from $a$ to $z$}
  \For{$i \coloneqq 1$ \textbf{to} $n$}
    \State $L(v_i) \coloneqq \infty$
  \EndFor
  \State $L(a) \coloneqq 0$
  \State $S \coloneqq \varnothing$
  \While{$z \notin S$}
    \State $u \coloneqq a$ vertex not in $S$ with $L(u)$ minimal
    \State $S \coloneqq S \cup \{u\}$
    \For{all vertices $v$ not in $S$}
      \If{$L(u) + w(u,v) < L(V)$}
        \State $L(v) \coloneqq L(u) + w(u, v)$
      \EndIf
    \EndFor
  \EndWhile
  \State \Comment{$L(z) =$ length of a shortest path from $a$ to $z$}
\EndProcedure

\end{algorithmic}

# Example of Dijkstra's Algorithm

::: columns
:::: column

* Find the shortest path between $a$ and $f$

\vskip.5em

* Find the shortest path between $d$ and $c$

::::
:::: column

\centering
\small

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) [label=left:{b}] {};
\node[main] (2) [right of=1,label=right:{c}] {};
\node[main] (3) [below of=1,label=left:{d}] {};
\node[main] (4) [right of=3,label=right:{e}] {};
\node[main] (5) [label=below:{f}] at (1.5, -4) {};
\node[main] (6) [label=above:{a}] at (1.5, 1.25) {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- node[white, midway, left] {3} (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- node[white, midway, above left, sloped] {3} (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[white, midway, below left, sloped] {10} (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[white, midway, right] {3} (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- node[white, midway, below] {5} (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- node[white, midway, below] {1} (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[white, midway, above] {1} (6);
\draw [line width=0.25mm, BlueDeFrance] (1) -- node[white, midway, above] {4} (6);

\end{tikzpicture}

::::
:::

# Traveling Salesman Problem

* The traveling salesman problem asks for the circuit of minimum total weight in a weighted, complete, undirected graph that visits each vertex exactly once and returns to its starting point.

\vskip.5em

* No algorithm with polynomial worst-case time complexity is known.

\vskip.5em

* $c$-approximation algorithms: $W \leq W' \leq cW$
  * $W$: total length of an exact solution
  * $W'$: total weight of a Hamilton circuit
  * $c$: a constant

#

\ts{Planar Graphs}

# Planar Graphs

* A graph is called **planar** if it can be drawn in the plane without any edges crossing. Such a drawing is called a *planar representation* of the graph.

\vskip.5em

* Example:

::: columns
:::: column

\vspace{1.5em}
\centering
\footnotesize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [below of=1] {};
\node[main] (4) [right of=3] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);

\end{tikzpicture}

::::
:::: column

\vspace{-5em}
\centering
\footnotesize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [below of=1] {};
\node[main] (4) [right of=3] {};

\draw [line width=0.25mm, FireOpal] (1) -- (2);
\draw [line width=0.25mm, FireOpal] (1) -- (3);
\draw [line width=0.25mm, FireOpal] (1) to [out=45, in=45, looseness=2] (4);
\draw [line width=0.25mm, FireOpal] (2) -- (3);
\draw [line width=0.25mm, FireOpal] (2) -- (4);
\draw [line width=0.25mm, FireOpal] (3) -- (4);

\end{tikzpicture}

::::
:::

# More Examples

::: columns
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [below left of=1] {};
\node[main] (4) [below left of=2] {};
\node[main] (5) [below of=1] {};
\node[main] (6) [below of=2] {};
\node[main] (7) [below of=3] {};
\node[main] (8) [below of=4] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (7) -- (8);

\end{tikzpicture}

\small
\textbf{\underline{Q\textsubscript{3}}}

\vspace{2em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [below of=1] {};
\node[main] (4) [right of=3] {};
\node[main] (5) [above left of=1] {};
\node[main] (6) [above right of=2] {};
\node[main] (7) [below left of=3] {};
\node[main] (8) [below right of=4] {};

\draw [line width=0.25mm, FireOpal] (1) -- (2);
\draw [line width=0.25mm, FireOpal] (1) -- (3);
\draw [line width=0.25mm, FireOpal] (2) -- (4);
\draw [line width=0.25mm, FireOpal] (3) -- (4);
\draw [line width=0.25mm, FireOpal] (1) -- (5);
\draw [line width=0.25mm, FireOpal] (2) -- (6);
\draw [line width=0.25mm, FireOpal] (3) -- (7);
\draw [line width=0.25mm, FireOpal] (4) -- (8);
\draw [line width=0.25mm, FireOpal] (5) -- (6);
\draw [line width=0.25mm, FireOpal] (5) -- (7);
\draw [line width=0.25mm, FireOpal] (6) -- (8);
\draw [line width=0.25mm, FireOpal] (7) -- (8);

\end{tikzpicture}

::::
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [left of=1] {};
\node[main] (3) [right of=1] {};
\node[main] (4) [above left of=3] {};
\node[main] (5) [above right of=2] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);

\end{tikzpicture}

\small
\textbf{\underline{K\textsubscript{2,3}}}

\vspace{2em}

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above of=1] {};
\node[main] (3) [below of=1] {};
\node[main] (4) [right of=1] {};
\node[main] (5) [left of=1] {};

\draw [line width=0.25mm, FireOpal] (1) -- (2);
\draw [line width=0.25mm, FireOpal] (1) -- (3);
\draw [line width=0.25mm, FireOpal] (2) -- (4);
\draw [line width=0.25mm, FireOpal] (2) -- (5);
\draw [line width=0.25mm, FireOpal] (3) -- (4);
\draw [line width=0.25mm, FireOpal] (3) -- (5);

\end{tikzpicture}

::::
:::

# Euler's Formula

* Let $G$ be a connected planar simple graph with $e$ edges and $v$ vertices. Let $r$ be the number of regions in a planar representation fo $G$. Then $r = e - v + 2$

\vskip.5em

* **Corollary:** If $G$ is a connected planar simple graph with $e$ edges and $v$ vertices, where $v \geq 3$, then $e \leq 3v - 6$

\vskip.5em

* \prf

  1. $2e \geq 3r$
  2. $r = e - v + 2$

# Euler's Formula

* **Corollary:** If $G$ is a connected planar simple graph, then $G$ has a vertex of degree not exceeding five.

\vskip.5em

* Show that $K_5$ is nonplanar using above corollary.

\vskip.5em

* \exercise If a connected planar simple graph has $e$ edges and $v$ vertices with $v \geq 3$ and no circuits of length three, then $e \leq 2v - 4$

# Kuratowski's Theorem

* If a graph is planar, any graph is obtained by removing an edge $\{u, v\}$ and adding a new vertex $w$ together with edges $\{u, w\}$ and $\{w, v\}$. Such an operation is called an elementary subdivision.

\vskip.5em

* The graphs $G_1 = (V_1, E_1)$ and $G_2 = (V_2, E_2)$ are called **homeomorphic** if they can be obtained from the same graph by a sequence of elementary subdivision.

\vskip.5em

* **Kuratowski's Theorem:** A graph is nonplanar iff it contains a subgraph *homeomorphic* to $K_{3,3}$ or $K_5$.

<!--# Examples

* Some Examples

::: columns
:::: {.column width=.333}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [left of=1] {};
\node[main] (3) [right of=1] {};
\node[main] (4) [above left of=3] {};
\node[main] (5) [above right of=2] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);

\end{tikzpicture}

::::
:::: {.column width=.333}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [left of=1] {};
\node[main] (3) [right of=1] {};
\node[main] (4) [above left of=3] {};
\node[main] (5) [above right of=2] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);

\end{tikzpicture}

::::
:::: {.column width=.333}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [left of=1] {};
\node[main] (3) [right of=1] {};
\node[main] (4) [above left of=3] {};
\node[main] (5) [above right of=2] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);

\end{tikzpicture}

::::
:::

* Is the Petersen graph planar?

Images from slide 56
-->

#

\ts{Graph Coloring}

# Graph Coloring

* A coloring of a simple graph is the assignment of a color to each vertex of the graph so that no two adjacent vertices are assigned the same color.

\vskip.5em

* The **chromatic number** of a graph $G$, denoted by $\chi(G)$ is the least number of colors needed for a coloring of this graph.

\centering
\small

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, fill, circle, line width=0.25mm}]

\node[main,color=Amethyst] (b) [label=above:{b}] {};
\node[main,color=FireOpal] (d) [below right of=b,label=right:{d}] {};
\node[main,color=Jasmine] (e) [above right of=d,label=above:{e}] {};
\node[main,color=Jasmine] (c) [below left of=d,label=below:{c}] {};
\node[main,color=Amethyst] (f) [below right of=d,label=below:{f}] {};
\node[main,color=FireOpal] (a) [below left of=b,label=left:{a}] {};
\node[main,color=FireOpal] (g) [below right of=e,label=right:{g}] {};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (f);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (f);
\draw [line width=0.25mm, BlueDeFrance] (e) -- (f);
\draw [line width=0.25mm, BlueDeFrance] (e) -- (g);
\draw [line width=0.25mm, BlueDeFrance] (f) -- (g);
\end{tikzpicture}

# Coloring of Maps

* Color a *map* such that two adjacent regions don't have the same color

\vskip.5em

* Each map in the plane can be represented by a dual planar graph

\begin{center}
\includegraphics[width=.5\textwidth]{images/graphs/coloring.eps}
\end{center}

* **The Four Color Theorem:** The chromatic number of a planar graph is no greater than four.

# Example

* What is the chromatic number of the graphs?

::: columns
:::: column

\centering
\small

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (b) {};
\node[main] (d) [below right of=b] {};
\node[main] (e) [above right of=d] {};
\node[main] (c) [below left of=d] {};
\node[main] (f) [below right of=d] {};
\node[main] (a) [below left of=b] {};
\node[main] (g) [below right of=e] {};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (f);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (f);
\draw [line width=0.25mm, BlueDeFrance] (e) -- (f);
\draw [line width=0.25mm, BlueDeFrance] (e) -- (g);
\draw [line width=0.25mm, BlueDeFrance] (f) -- (g);
\draw [line width=0.25mm, FireOpal] (a) to [out=90, in=90, looseness=1.25] (g);
\end{tikzpicture}

::::
:::: column

\vspace{3em}

\centering
\small

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above right of=1] {};
\node[main] (3) [below right of=1] {};
\node[main] (4) [above right of=3] {};
\node[main] (5) [below right of=4] {};
\node[main] (6) [above right of=4] {};
\node[main] (7) [above right of=2] {};
\node[main] (8) [above right of=6] {};
\node[main] (9) [below right of=8] {};
\node[main] (10) [above right of=9] {};
\node[main] (11) [below right of=10] {};
\node[main] (12) [above right of=11] {};
\node[main] (13) [below right of=11] {};
\node[main] (14) [above right of=13] {};
\node[main] (15) [below right of=14] {};
\node[main] (16) [below right of=13] {};
\node[main] (17) [below left of=13] {};
\node[main] (18) at (3.5,-.7) {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (18);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (9);
\draw [line width=0.25mm, BlueDeFrance] (7) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (8) -- (9);
\draw [line width=0.25mm, BlueDeFrance] (8) -- (10);
\draw [line width=0.25mm, BlueDeFrance] (9) -- (10);
\draw [line width=0.25mm, BlueDeFrance] (9) -- (11);
\draw [line width=0.25mm, BlueDeFrance] (10) -- (11);
\draw [line width=0.25mm, BlueDeFrance] (10) -- (12);
\draw [line width=0.25mm, BlueDeFrance] (11) -- (12);
\draw [line width=0.25mm, BlueDeFrance] (11) -- (13);
\draw [line width=0.25mm, BlueDeFrance] (11) -- (14);
\draw [line width=0.25mm, BlueDeFrance] (12) -- (14);
\draw [line width=0.25mm, BlueDeFrance] (13) -- (14);
\draw [line width=0.25mm, BlueDeFrance] (13) -- (16);
\draw [line width=0.25mm, BlueDeFrance] (13) -- (17);
\draw [line width=0.25mm, BlueDeFrance] (14) -- (15);
\draw [line width=0.25mm, BlueDeFrance] (15) -- (16);
\draw [line width=0.25mm, BlueDeFrance] (16) -- (17);
\draw [line width=0.25mm, BlueDeFrance] (17) -- (18);

\end{tikzpicture}

::::
:::

* What is the chromatic number of $K_n$?

\vskip.5em

* What is the chromatic number of $K_{m,n}$?

<!--# Frequency Assignment

* Broadcast radio system
  * Two radio stations can't have the same channel if their receiving regions are within the same overlapping area.
  * Broadcast stations are represented by vertices
  * Two vertices have an edge if their receiving regions are within some overlapping area.
  * Frequency assignment problem is to find the smallest number of channels
-->

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
