---
author:
- Dr. Isaac Griffith
title: Graphs
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

#

\ts{Graphs}

# Introduction to Graphs

* **Definition:** A **simple graph** $G = (V, E)$ consists of $V$, a nonempty set of vertices, and $E$ a set of *unordered pairs* of *distinct* elements of $V$ called edges.
* For each $e \in E$, $e = \{u, v\}$ where $u, v \in V$
* An undirected graph (not simple) may contain loops.
  * An edge $e$ is a *loop* if $e = \{u, u\}$ for come $u \in V$

# Introduction to Graphs

* **Definition:** A **directed graph** $G = (V, E)$ consists of a set $V$ of vertices and a set $E$ of edges that are ordered pairs of elements in $V$.

* For each $e \in E$, $e = (u, v)$ where $u, v \in V$
* An edge $e$ is a loop if $e = (u, u)$ for some $u \in V$
* A simple graph is just like a directed grah, but with no specified direction of its edges

# Graphs

::: columns
:::: column

* \footnotesize \textcolor{Roarange}{\textbf{Graph}} $G = (V, E)$
  - \scriptsize $V$ - a non-empty set of **vertices** (or **nodes**). $|V| = n$
  - \scriptsize $E$ - a set of **edges**. $|E| = m$
  - \scriptsize Each edge has either one or two vertices associated with it.
    * \tiny These vertices are called the **endpoints**
    * \tiny An edge is said to **connect** its endpoints

::::
:::: column

* \footnotesize \textcolor{Roarange}{\textbf{Directed Graph (or digraph)}} $G = (V, E)$
  - \scriptsize $V$ - a non-empty set of **vertices**
  - \scriptsize $E$ - a set of **directed edges** (or **arcs**)
  - \scriptsize Each directed edge is associated with an ordered pair of vertices
    - \tiny The directed edge associated with the ordered pair $(u, v)$ is said to **start** at $u$ and **end** at $v$.

::::
:::

\vskip1.5em

::: columns
:::: {.column width=.33}
\centering

\scriptsize

\textbf{\underline{Pseudo Graph}}
\vskip1em

\tiny

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above right of=1] {};
\node[main] (3) [below right of=1] {};
\node[main] (4) [above right of=3] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (3) -- (4);

\draw [line width=0.25mm, red] (3) to [out=220, in=320, looseness=10] node[white, midway, below] {loop} (3);
\draw [line width=0.25mm, red] (1) to [out=0, in=270, looseness=1] (2);
\draw [line width=0.25mm, red] (2) to [out=270, in=180, looseness=1] (4);
\draw [line width=0.25mm, red] (1) to [out=90, in=180, looseness=1] (2);
\end{tikzpicture}

::::
:::: {.column width=.33}

\centering

\scriptsize

\textbf{\underline{Multigraph}}
\vskip1em

\tiny

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above right of=1] {};
\node[main] (3) [below right of=1] {};
\node[main] (4) [above right of=3] {};

\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);

\draw [line width=0.25mm, red] (1) to [out=0, in=270, looseness=1] (2);
\draw [line width=0.25mm, red] (1) to [out=90, in=180, looseness=1] (2);
\draw [line width=0.25mm, red] (3) to [out=90, in=180, looseness=1] (4);
\draw [line width=0.25mm, red] (3) to [out=0, in=270, looseness=1] (4);
\end{tikzpicture}

::::
:::: {.column width=.33}

\centering

\scriptsize

\textbf{\underline{Simple Graph}}
\vskip1em

\tiny

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above right of=1] {};
\node[main] (3) [below right of=1] {};
\node[main] (4) [above right of=3] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (3) -- (4);
\end{tikzpicture}

::::
:::

# Graph Models

::: columns
:::: column

* \footnotesize \textbf{Niche Overlap Graphs in Ecology} - used to model the interactions of different species of animals.
  - \scriptsize Each species is represented by a vertex.
  - \scriptsize An undirected edge connects two vertices if the two species represented compete for the same resources.

::::
:::: column

\centering

\scriptsize

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) [label=below left:{Raccoon}] {};
\node[main] (2) [label=below left:{Hawk},right of=1] {};
\node[main] (3) [label=below left:{Owl},right of=2] {};

\node[main] (4) [label=above left:{Opossum},below of=1] {};
\node[main] (5) [label=above right:{Squirrel},right of=4] {};
\node[main] (6) [label=below right:{Crow},right of=5] {};

\node[main] (7) [label=below left:{Shrew},below of=4] {};
\node[main] (8) [label=below:{Moose},right of=7] {};
\node[main] (9) [label=below right:{Woodpecker},right of=8] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (2) -- (3);

\draw [line width=0.25mm, red] (1) -- (5);
\draw [line width=0.25mm, red] (2) -- (6);
\draw [line width=0.25mm, red] (3) -- (6);

\draw [line width=0.25mm, red] (4) -- (5);
\draw [line width=0.25mm, red] (5) -- (6);

\draw [line width=0.25mm, red] (4) -- (7);
\draw [line width=0.25mm, red] (4) -- (9);
\draw [line width=0.25mm, red] (5) -- (9);

\draw [line width=0.25mm, red] (7) -- (8);

\draw [line width=0.25mm, red] (1) to [out=90, in=90, looseness=.75] (3);
\draw [line width=0.25mm, red] (7) to [out=270, in=270, looseness=.75] (9);
\end{tikzpicture}

::::
:::

# Graph Models

::: columns
:::: column

* **Acquaintanceship Graphs** - Models relationships between people. Each person in a particular group is represented by a vertex. An undirected edge connects two people who know each other. Loops and multiple edges are not allowed.

::::
:::: column

\centering
\tiny

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) [label=above:{Jan}] {};
\node[main] (2) [label=above left:{Paula}, right of=1] {};
\node[main] (3) [label=above:{Todd}, right of=2] {};
\node[main] (4) [label=above:{Kamlesh}, right of=3] {};
\node[main] (15) [label=below:{Kamini}, below left of=1] {};
\node[main] (16) [label=right:{Eduardo}, above right of=2] {};

\node[main] (5) [label=right:{Amy}, below right of=2] {};
\node[main] (6) [label=below:{Ching}, below of=4] {};

\node[main] (9) [label=right:{Steve}, below right of=5] {};
\node[main] (8) [label=below:{Liz}, below left of=5] {};
\node[main] (7) [label=left:{Lila}, left of=8] {};

\node[main] (10) [label=below right:{Joel}, below of=7] {};
\node[main] (11) [label=below:{Gail}, right of=10] {};
\node[main] (12) [label=below right:{Koko}, below right of=9] {};

\node[main] (13) [label=left:{Kari}, below of=10] {};
\node[main] (14) [label=below:{Shaquira}, below right of=11] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (3) -- (4);

\draw [line width=0.25mm, red] (1) -- (7);
\draw [line width=0.25mm, red] (2) -- (7);
\draw [line width=0.25mm, red] (2) -- (8);
\draw [line width=0.25mm, red] (2) -- (5);
\draw [line width=0.25mm, red] (3) -- (5);
\draw [line width=0.25mm, red] (5) -- (8);
\draw [line width=0.25mm, red] (5) -- (9);
\draw [line width=0.25mm, red] (3) -- (9);
\draw [line width=0.25mm, red] (4) -- (6);

\draw [line width=0.25mm, red] (7) -- (8);
\draw [line width=0.25mm, red] (8) -- (9);

\draw [line width=0.25mm, red] (7) -- (10);
\draw [line width=0.25mm, red] (10) -- (2);
\draw [line width=0.25mm, red] (9) -- (12);
\draw [line width=0.25mm, red] (7) -- (11);
\draw [line width=0.25mm, red] (9) -- (14);

\draw [line width=0.25mm, red] (10) -- (11);

\draw [line width=0.25mm, red] (10) -- (13);
\draw [line width=0.25mm, red] (11) -- (14);

\draw [line width=0.25mm, red] (1) -- (15);
\draw [line width=0.25mm, red] (2) -- (16);


\end{tikzpicture}

::::
:::

# Graph Models

* **Influence Graphs** - Models group behavior observed where certain people influence the thinking of others. Each person is a vertex. There is a directed edge from vertex a to vertex b when person a influences person b.

\centering
\scriptsize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) [label=above:{Linda}] {};
\node[main] (2) [label=above:{Brian}, right of=1] {};
\node[main] (3) [label=below:{Deborah}, below of=1] {};
\node[main] (4) [label=below:{Fred}, right of=3] {};
\node[main] (5) [label=below:{Yuame}, right of=4] {};

\draw [->, line width=0.25mm, red] (2) -- (1);
\draw [->, line width=0.25mm, red] (3) -- (1);
\draw [->, line width=0.25mm, red] (3) -- (2);
\draw [->, line width=0.25mm, red] (3) -- (4);
\draw [->, line width=0.25mm, red] (4) -- (2);
\draw [->, line width=0.25mm, red] (5) -- (4);

\draw [->, line width=0.25mm, red] (2) to [out=0, in=90, looseness=.75] (5);
\draw [->, line width=0.25mm, red] (5) to [out=180, in=270, looseness=.75] (2);
\end{tikzpicture}

#

\centering
\vfill
\begin{minipage}{.525\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Graph Terminology
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Basic Terminology

* \footnotesize \textcolor{Roarange}{\textbf{Adjacent Vertices:}} two vertices, $u$ and $v$, in an undirected graph $G$ are __*adjacent*__ if $u$ and $v$ are endpoints of an edge of $G$.
  * \scriptsize \textcolor{Roarange}{\textbf{Incidence:}} if and edge $e$ is associated with $\{u, v\}$, the edge $e$ is _**incident with**_ the vertices $u$ and $v$.
  * \scriptsize \textcolor{Roarange}{\textbf{Connection:}} the edge $e$ is said to _**connect**_ $u$ and $v$ if it is incident with them.
  * \scriptsize \textcolor{Roarange}{\textbf{Endpoints:}} the vertices $u$ and $v$ are _**endpoints**_ of an edge associated with $\{u, v\}$

\vskip1em

* \footnotesize \textcolor{Roarange}{\textbf{Degree:}} the _**degree of a vertex**_ in an undirected graph is the number of edges incident with it, except that a loop at a vertex contributes twice to the degree of that vertex.
  - \scriptsize Degree of the vertex $v$ is denoted as $deg(v)$
  - \scriptsize A vertex is called \textcolor{Roarange}{\textbf{isolated}} if it has degree 0.
  - \scriptsize A vertex is called \textcolor{Roarange}{\textbf{penchant}} if it has degree 1.

# Exercise

* What are the degrees of the vertices in Graphs $G$ and $H$

::: columns
:::: column
\centering

\footnotesize
\textbf{\underline{G}}

\tiny

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {A};
\node[main] (5) [right of=1] {F};
\node[main] (6) [right of=5] {E};
\node[main] (7) [right of=6] {G};
\node[main] (2) [above of=5] {B};
\node[main] (3) [right of=2] {C};
\node[main] (4) [right of=3] {D};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (5);
\draw [line width=0.25mm, red] (2) -- (6);
\draw [line width=0.25mm, red] (2) -- (5);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (2) -- (6);
\draw [line width=0.25mm, red] (3) -- (6);
\draw [line width=0.25mm, red] (3) -- (4);
\draw [line width=0.25mm, red] (3) -- (5);
\draw [line width=0.25mm, red] (5) -- (6);

\end{tikzpicture}

::::
:::: column

\centering

\footnotesize
\textbf{\underline{H}}

\tiny

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {A};
\node[main] (2) [right of=1] {B};
\node[main] (3) [right of=2] {C};
\node[main] (4) [below of=1] {E};
\node[main] (5) [right of=4] {D};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (1) -- (5);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (2) -- (5);
\draw [line width=0.25mm, red] (4) -- (5);

\draw [line width=0.25mm, red] (2) to [out=150, in=30, looseness=7.5] (2);
\draw [line width=0.25mm, red] (1) to [out=255, in=105, looseness=1.25] (4);
\draw [line width=0.25mm, red] (1) to [out=285, in=75, looseness=1.25] (4);
\draw [line width=0.25mm, red] (4) to [out=15, in=165, looseness=1.25] (5);
\draw [line width=0.25mm, red] (4) to [out=-15, in=195, looseness=1.25] (5);

\end{tikzpicture}

::::
:::

\pause

\vskip1em

::: columns
:::: column

* \tiny $deg(A) = 2$
* \tiny $deg(B) = deg(c) = deg(F) = 4$
* \tiny $deg(D) = 1$
* \tiny $deg(E) = 3$
* \tiny $deg(G) = 0$

::::
:::: column

* \tiny $deg(A) = 4$
* \tiny $deg(B) = 6$
* \tiny $deg(C) = 1$
* \tiny $deg(D) = 5$
* \tiny $deg(E) = 6$

::::
:::

# Examples

::: columns
:::: column

\footnotesize

\textbf{\underline{Planar Graphs}}
\vskip1em

\scriptsize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {1};
\node[main] (2) [below of=1] {3};
\node[main] (3) [right of=2] {2};
\node[main] (4) [below of=2] {4};
\node[main] (5) [left of=4] {5};
\node[main] (6) [right of=4] {6};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (1) -- node[midway, above right, white, pos=0.5] {adjacent} (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (2) -- node[midway, above right, sloped, pos=1, white] {penchant} (5);
\draw [line width=0.25mm, red] (4) -- (6);
\draw [line width=0.25mm, red] (3) -- (4);
\draw [line width=0.25mm, red] (3) -- (6);

\end{tikzpicture}

::::
:::: column

\centering

\footnotesize

\textbf{\underline{Complete Graphs}}
\vskip1em

\scriptsize

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [below left of=1] {};
\node[main] (3) [below right of=1] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (1) to [out=150, in=30, looseness=7.5] (1);

\end{tikzpicture}

\small

K\textsubscript{3}

::::
:::

# Handshaking Theorem

* **Handshaking Theorem:** Let $G = (V, E)$ be an undirected graph with $e$ edges. Then

  $$2e=\underset{v\in V}{\sum}deg(v)$$

  (this applies even if multiple edges and loops are present)

* **Theorem:** An undirected graph has an even number of vertices of odd degree.

# Directed Graph Terminology

* \footnotesize \textbf{Adjacency:} when $(u,v)$ is an edge of a Graph $G$ with directed edges, $u$ is said to be **adjacent to** $v$ and $v$ is said to be **adjacent from** $v$.
  - \scriptsize $u$ is the **initial vertex**
  - \scriptsize $v$ is the **terminal vertex** or **end vertex**
  - \scriptsize In a loop the initial and terminal vertices are the same.

* \footnotesize \textbf{Degree:} In a graph with directed edges
  - \scriptsize \textbf{in-degree} of a vertex is denoted by $deg^{-}(v)$ and is the number of edges with $v$ as the terminal vertex
  - \scriptsize \textbf{out-degree} of a vertex is denoted by $deg^{+}(v)$ and is the number of edges with $v$ as their initial vertex.
  - \scriptsize A vertex in a loop contributes 1 to both the *in-degree* and *out-degree* of the vertex.

* \footnotesize \textbf{Theorem:} Let $G = (V,E)$ be a graph with directed edges, then

$$\underset{v\in V}{\sum}deg^{-}(v) = \underset{v\in V}{\sum}deg^{+}(v) = |E|$$

# Example

* Find the in- and out-degree of each vertex of the following graph:

::: columns
:::: column

\centering
\tiny

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {a};
\node[main] (2) [right of=1] {b};
\node[main] (3) [right of=2] {c};
\node[main] (4) [below of=1] {e};
\node[main] (5) [right of=4] {d};

\draw [->,line width=0.25mm, red] (1) -- (2);
\draw [->,line width=0.25mm, red] (3) -- (2);
\draw [->,line width=0.25mm, red] (2) -- (5);
\draw [->,line width=0.25mm, red] (5) -- (3);

\draw [->,line width=0.25mm, red] (1) to [out=95, in=175, looseness=5] (1);
\draw [->,line width=0.25mm, red] (1) to [out=30, in=150, looseness=1.25] (3);
\draw [->,line width=0.25mm, red] (3) to [out=85, in=5, looseness=5] (3);
\draw [->,line width=0.25mm, red] (4) to [out=120, in=250, looseness=1.25] (1);
\draw [->,line width=0.25mm, red] (1) to [out=290, in=70, looseness=1.25] (4);
\draw [->,line width=0.25mm, red] (4) to [out=-15, in=195, looseness=1.25] (5);
\draw [->,line width=0.25mm, red] (5) to [out=165, in=15, looseness=1.25] (4);

\end{tikzpicture}

::::
:::: column

\pause

\scriptsize

+------------+------------------+-----------------------------+
| **Vertex** | **In Degree**    | **Out Degree**              |
+:==========:+:================:+:===========================:+
| a          | $deg^{-}(a) = 2$ | $deg^{+}(a) = 4$ \vskip.5em |
+------------+------------------+-----------------------------+
| b          | $deg^{-}(b) = 2$ | $deg^{+}(b) = 1$ \vskip.5em |
+------------+------------------+-----------------------------+
| c          | $deg^{-}(c) = 3$ | $deg^{+}(c) = 2$ \vskip.5em |
+------------+------------------+-----------------------------+
| d          | $deg^{-}(d) = 3$ | $deg^{+}(d) = 2$ \vskip.5em |
+------------+------------------+-----------------------------+
| e          | $deg^{-}(e) = 2$ | $deg^{+}(e) = 3$ \vskip.5em |
+------------+------------------+-----------------------------+
| f          | $deg^{-}(f) = 0$ | $deg^{+}(f) = 0$            |
+------------+------------------+-----------------------------+

::::
:::

# Complete Graphs

* \scriptsize $K_n$ denotes the *complete graph on n vertices* if
  - \tiny It is a simple graph
  - \tiny Contains exactly one edge between each pair of distinct vertices

* \textbf{Examples:}

\tiny

::: columns
:::: {.column width=.33}

\centering

\textbf{\underline{K\textsubscript{1}}}
\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};

\end{tikzpicture}

\vskip4em

\textbf{\underline{K\textsubscript{4}}}
\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [below of=1] {};
\node[main] (4) [right of=3] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (3) -- (4);

\end{tikzpicture}

::::
:::: {.column width=.33}

\centering

\textbf{\underline{K\textsubscript{2}}}
\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};

\draw [line width=0.25mm, red] (1) -- (2);

\end{tikzpicture}

\vskip3em

\textbf{\underline{K\textsubscript{5}}}
\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [below left of=1] {};
\node[main] (3) [below right of=1] {};
\node[main] (4) [below of=2] {};
\node[main] (5) [below of=3] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (1) -- (5);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (2) -- (5);
\draw [line width=0.25mm, red] (3) -- (4);
\draw [line width=0.25mm, red] (3) -- (5);
\draw [line width=0.25mm, red] (4) -- (5);

\end{tikzpicture}

::::
:::: {.column width=.33}

\centering

\textbf{\underline{K\textsubscript{3}}}

\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [below left of=1] {};
\node[main] (3) [below right of=1] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (1) -- (3);

\end{tikzpicture}

\vskip.5em

\textbf{\underline{K\textsubscript{6}}}

\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above right of=1] {};
\node[main] (3) [right of=2] {};
\node[main] (4) [below right of=1] {};
\node[main] (5) [right of=4] {};
\node[main] (6) [below right of=3] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (1) -- (5);
\draw [line width=0.25mm, red] (1) -- (6);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (2) -- (5);
\draw [line width=0.25mm, red] (2) -- (6);
\draw [line width=0.25mm, red] (3) -- (4);
\draw [line width=0.25mm, red] (3) -- (5);
\draw [line width=0.25mm, red] (3) -- (6);
\draw [line width=0.25mm, red] (4) -- (5);
\draw [line width=0.25mm, red] (4) -- (6);
\draw [line width=0.25mm, red] (5) -- (6);

\end{tikzpicture}

::::
:::

# Cycles

* \scriptsize $C_n$ denotes a cycle of $n$ vertices, when a Graph has
  - \tiny $n \geq 3$ vertices $v_1, v_2, \ldots, v_n$
  - \tiny edges $\{v1, v2\}, \{v_2, v_3\}, \ldots, \{v_{n-1}, v_n\}, and \{v_n, v_1\}$

* \scriptsize \textbf{Examples:}

\tiny
\vskip.5em

::: columns
:::: {.column width=.25}

\centering

\textbf{\underline{C\textsubscript{3}}}

\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [below left of=1] {};
\node[main] (3) [below right of=1] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (1) -- (3);

\end{tikzpicture}

::::
:::: {.column width=.25}

\centering

\textbf{\underline{C\textsubscript{4}}}
\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [below of=1] {};
\node[main] (4) [right of=3] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (3) -- (4);

\end{tikzpicture}

::::
:::: {.column width=.25}

\centering

\textbf{\underline{C\textsubscript{5}}}
\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [below left of=1] {};
\node[main] (3) [below right of=1] {};
\node[main] (4) [below of=2] {};
\node[main] (5) [below of=3] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (3) -- (5);
\draw [line width=0.25mm, red] (4) -- (5);

\end{tikzpicture}

::::
:::: {.column width=.25}

\centering

\textbf{\underline{C\textsubscript{6}}}

\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above right of=1] {};
\node[main] (3) [right of=2] {};
\node[main] (4) [below right of=1] {};
\node[main] (5) [right of=4] {};
\node[main] (6) [below right of=3] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (3) -- (6);
\draw [line width=0.25mm, red] (4) -- (5);
\draw [line width=0.25mm, red] (5) -- (6);

\end{tikzpicture}

::::
:::

# Wheels

* \scriptsize $W_n$ denotes a wheel when we add a vertex to the cycle $C_n$ and connect this new vertex to each of the $n$ vertices in $C_n$.

* \scriptsize \textbf{Examples:}

\tiny
\vskip.5em

::: columns
:::: {.column width=.25}

\centering

\textbf{\underline{W\textsubscript{3}}}

\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [below left of=1] {};
\node[main] (3) [below right of=1] {};
\node[main] (4) [above of=1] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (3) -- (2);
\draw [line width=0.25mm, red] (3) -- (4);
\draw [line width=0.25mm, red] (2) -- (4);

\end{tikzpicture}

::::
:::: {.column width=.25}

\centering

\textbf{\underline{W\textsubscript{4}}}
\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above left of=1] {};
\node[main] (3) [above right of=1] {};
\node[main] (4) [below left of=1] {};
\node[main] (5) [below right of=1] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (1) -- (5);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (4) -- (5);
\draw [line width=0.25mm, red] (5) -- (3);

\end{tikzpicture}

::::
:::: {.column width=.25}

\centering

\textbf{\underline{W\textsubscript{5}}}
\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above left of=1] {};
\node[main] (3) [above right of=1] {};
\node[main] (4) [below left of=1] {};
\node[main] (5) [below right of=1] {};
\node[main] (6) [above of=1] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (1) -- (5);
\draw [line width=0.25mm, red] (1) -- (6);
\draw [line width=0.25mm, red] (2) -- (6);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (4) -- (5);
\draw [line width=0.25mm, red] (5) -- (3);
\draw [line width=0.25mm, red] (6) -- (3);

\end{tikzpicture}

::::
:::: {.column width=.25}

\centering

\textbf{\underline{W\textsubscript{6}}}

\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above left of=1] {};
\node[main] (3) [above right of=1] {};
\node[main] (4) [below left of=1] {};
\node[main] (5) [below right of=1] {};
\node[main] (6) [left of=1] {};
\node[main] (7) [right of=1] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (1) -- (5);
\draw [line width=0.25mm, red] (1) -- (6);
\draw [line width=0.25mm, red] (1) -- (7);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (4) -- (5);
\draw [line width=0.25mm, red] (2) -- (6);
\draw [line width=0.25mm, red] (4) -- (6);
\draw [line width=0.25mm, red] (3) -- (7);
\draw [line width=0.25mm, red] (5) -- (7);

\end{tikzpicture}

::::
:::

# N-Cubes

* \footnotesize The n-dimensional hypercube denoted $Q_n$ is the graph that has vertices representing $2^n$ bit strings of length $n$.

* \footnotesize Two vertices are adjacent only if their bit strings differ in exactly one bit position

\tiny

::: columns
:::: {.column width=.33}

\centering

\textbf{\underline{Q\textsubscript{1}}}

\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {0};
\node[main] (2) [right of=1] {1};

\draw [line width=0.25mm, red] (1) -- (2);

\end{tikzpicture}

::::
:::: {.column width=.33}

\centering

\textbf{\underline{Q\textsubscript{2}}}

\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {10};
\node[main] (2) [right of=1] {11};
\node[main] (3) [below of=1] {00};
\node[main] (4) [right of=3] {01};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (3) -- (4);

\end{tikzpicture}

::::
:::: {.column width=.33}

\centering

\textbf{\underline{Q\textsubscript{3}}}

\vskip.5em

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {110};
\node[main] (2) [right of=1] {111};
\node[main] (3) [below left of=1] {100};
\node[main] (4) [below left of=2] {101};
\node[main] (5) [below of=1]{010};
\node[main] (6) [below of=2] {011};
\node[main] (7) [below of=3] {000};
\node[main] (8) [below of=4] {001};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (3) -- (4);
\draw [line width=0.25mm, red] (1) -- (5);
\draw [line width=0.25mm, red] (2) -- (6);
\draw [line width=0.25mm, red] (3) -- (7);
\draw [line width=0.25mm, red] (4) -- (8);
\draw [line width=0.25mm, red] (5) -- (6);
\draw [line width=0.25mm, red] (5) -- (7);
\draw [line width=0.25mm, red] (6) -- (8);
\draw [line width=0.25mm, red] (7) -- (8);

\end{tikzpicture}

::::
:::

# Bipartite Graphs

* **Bipartite Graph:** A simple graph in which the vertex set $V$ can be partitioned into two disjoint sets $V_1$ and $V_2$, such that every edge in the graph connects a vertex in $V_1$ and a vertext in $V_2$
  - The pair $(V_1, V_2)$ is called the **bipartition** of the vertex set $V$ of the graph $G$

* **Example:**

$G_6$ is bipartite because its vertex set can be partitioned into the two sets $V_1 = \{v_1, v_3, v_5\}$ and $V_2 = \{v_2, v_4, v_6\}$ and every edge of $G_6$ connects a vertex in $V_1$ and a vertex in $V_2$.

# Bipartite Graphs

* \scriptsize \textbf{Complete Bipartite Graph} $K_{m, n}$ is the graph that has its vertex set partitioned into two subsets of $m$ and $n$ vertices respectively.
  - \tiny There is an edge between two vertices iff one vertex is in the first subset and the other vertex in the second subset.

* \scriptsize \textbf{Examples}

\tiny

::: columns
:::: {.column width=.33}
\centering

\textbf{\underline{K\textsubscript{2,3}}}

\vskip.5em

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above right of=1] {};
\node[main] (3) [right of=1] {};
\node[main] (4) [above right of=3] {};
\node[main] (5) [right of=3] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (3) -- (2);
\draw [line width=0.25mm, red] (3) -- (4);
\draw [line width=0.25mm, red] (5) -- (2);
\draw [line width=0.25mm, red] (5) -- (4);

\end{tikzpicture}
::::
:::: {.column width=.33}
\centering

\textbf{\underline{K\textsubscript{3,3}}}

\vskip.5em

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [right of=2] {};
\node[main] (4) [below of=1] {};
\node[main] (5) [right of=4] {};
\node[main] (6) [right of=5] {};

\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (1) -- (5);
\draw [line width=0.25mm, red] (1) -- (6);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (2) -- (5);
\draw [line width=0.25mm, red] (2) -- (6);
\draw [line width=0.25mm, red] (3) -- (4);
\draw [line width=0.25mm, red] (3) -- (5);
\draw [line width=0.25mm, red] (3) -- (6);

\end{tikzpicture}

\vskip.5em

\centering

\textbf{\underline{K\textsubscript{2,5}}}

\vskip.5em

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [right of=2] {};
\node[main] (4) [right of=3] {};
\node[main] (5) [right of=4] {};
\node[main] (6) [above left of=3] {};
\node[main] (7) [above right of=3] {};

\draw [line width=0.25mm, red] (6) -- (1);
\draw [line width=0.25mm, red] (6) -- (2);
\draw [line width=0.25mm, red] (6) -- (3);
\draw [line width=0.25mm, red] (6) -- (4);
\draw [line width=0.25mm, red] (6) -- (5);
\draw [line width=0.25mm, red] (7) -- (1);
\draw [line width=0.25mm, red] (7) -- (2);
\draw [line width=0.25mm, red] (7) -- (3);
\draw [line width=0.25mm, red] (7) -- (4);
\draw [line width=0.25mm, red] (7) -- (5);
\end{tikzpicture}
::::
:::: {.column width=.33}
\centering

\textbf{\underline{K\textsubscript{3,5}}}

\vskip.5em

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [right of=2] {};
\node[main] (4) [below of=1] {};
\node[main] (5) [right of=4] {};
\node[main] (6) [right of=5] {};
\node[main] (7) [left of=4] {};
\node[main] (8) [right of=6] {};

\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (1) -- (5);
\draw [line width=0.25mm, red] (1) -- (6);
\draw [line width=0.25mm, red] (1) -- (7);
\draw [line width=0.25mm, red] (1) -- (8);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (2) -- (5);
\draw [line width=0.25mm, red] (2) -- (6);
\draw [line width=0.25mm, red] (2) -- (7);
\draw [line width=0.25mm, red] (2) -- (8);
\draw [line width=0.25mm, red] (3) -- (4);
\draw [line width=0.25mm, red] (3) -- (5);
\draw [line width=0.25mm, red] (3) -- (6);
\draw [line width=0.25mm, red] (3) -- (7);
\draw [line width=0.25mm, red] (3) -- (8);
\end{tikzpicture}
::::
:::

* \scriptsize \textbf{Theorem:} A simple graph is bipartite iff it is possible to assign one of two different colors to each vertex of the graph so that no two adjacent vertices are assigned the same color.


# SubGraphs

* \footnotesize A **subgraph of a graph** $G = (V, E)$ is a graph $H = (W, F)$, where:
  - \scriptsize $W \subseteq V$
  - \scriptsize $F \subseteq E$

* \footnotesize A subgraph $H$ of $G$ is a **proper subgraph** of $G$ if $H \ne G$

* \footnotesize \textbf{Examples:}

::: columns
:::: column

\scriptsize
\centering

\textbf{\underline{K\textsubscript{5}}}
\vskip.5em

\tiny

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [below left of=1] {};
\node[main] (3) [below right of=1] {};
\node[main] (4) [below of=2] {};
\node[main] (5) [below of=3] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (1) -- (5);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (2) -- (5);
\draw [line width=0.25mm, red] (3) -- (4);
\draw [line width=0.25mm, red] (3) -- (5);
\draw [line width=0.25mm, red] (4) -- (5);

\end{tikzpicture}

::::
:::: column

\scriptsize
\centering

\textbf{\underline{Subgraph of K\textsubscript{5}}}
\vskip.5em

\tiny

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [below left of=1] {};
\node[main] (3) [below right of=1] {};
\node[main] (5) [below of=3] {};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (3);
\draw [line width=0.25mm, red] (1) -- (5);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (3) -- (5);

\end{tikzpicture}

::::
:::

# Graph Unions

* \footnotesize The **union** of two simple graphs $G_1 = (V_1, E_1)$ and $G_2 = (V_2, E_2)$ is the simple graph
  - Vertex set $V_1 \cup V_2$
  - Edge set $E_1 \cup E_2$

* \footnotesize The union of $G_1$ and $G_2$ is denoted by $G_1 \cup G_2$

* \footnotesize \textbf{Example:} Find the union of $G_1$ and $G_2$ below:

::: columns
:::: {.column width=.33}
\scriptsize
\centering

\textbf{\underline{G\textsubscript{1}}}
\vskip.5em

\tiny

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {a};
\node[main] (2) [right of=1] {b};
\node[main] (3) [right of=2] {c};
\node[main] (4) [below of=1] {d};
\node[main] (5) [right of=4] {e};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (4) -- (5);
\draw [line width=0.25mm, red] (2) -- (5);
\draw [line width=0.25mm, red] (3) -- (5);

\end{tikzpicture}
::::
:::: {.column width=.33}
\scriptsize
\centering

\textbf{\underline{G\textsubscript{2}}}
\vskip.5em

\tiny

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {a};
\node[main] (2) [right of=1] {b};
\node[main] (3) [right of=2] {c};
\node[main] (4) [below of=1] {d};
\node[main] (5) [below of=3] {f};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (2) -- (5);
\draw [line width=0.25mm, red] (3) -- (5);

\end{tikzpicture}
::::
:::: {.column width=.33}

\pause

\scriptsize
\centering

\textbf{\underline{$G_1 \cup G_2$}}
\vskip.5em

\tiny

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {a};
\node[main] (2) [right of=1] {b};
\node[main] (3) [right of=2] {c};
\node[main] (4) [below of=1] {d};
\node[main] (5) [below of=2] {e};
\node[main] (6) [below of=3] {f};

\draw [line width=0.25mm, red] (1) -- (2);
\draw [line width=0.25mm, red] (1) -- (4);
\draw [line width=0.25mm, red] (2) -- (3);
\draw [line width=0.25mm, red] (2) -- (4);
\draw [line width=0.25mm, red] (2) -- (5);
\draw [line width=0.25mm, red] (2) -- (6);
\draw [line width=0.25mm, red] (3) -- (5);
\draw [line width=0.25mm, red] (3) -- (6);
\draw [line width=0.25mm, red] (4) -- (5);

\end{tikzpicture}
::::
:::

#

\centering
\vfill
\begin{minipage}{.575\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Representing Graphs
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Representing Graphs

::: columns
:::: {.column width=.33}

\scriptsize
\centering

\textbf{\underline{The Graph}}
\vskip.5em

\tiny

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {a};
\node[main] (2) [right of=1] {b};
\node[main] (3) [below of=1] {c};
\node[main] (4) [right of=3] {d};

\draw [line width=0.25mm, red] (1) -- node[midway, above, white] {e\textsubscript{1}} (2);
\draw [line width=0.25mm, red] (1) -- node[midway, left, white] {e\textsubscript{2}} (3);
\draw [line width=0.25mm, red] (1) -- node[midway, left, pos=1, white] {e\textsubscript{3}} (4);
\draw [line width=0.25mm, red] (2) -- node[midway, right, pos=1, white] {e\textsubscript{4}} (3);

\end{tikzpicture}

::::
:::: {.column width=.33}

\scriptsize
\centering

\textbf{\underline{Adjacency Matrix}}
\vskip.5em

$$
\begin{aligned} & \begin{array}{ccccc}
 & a & b & c & d\end{array}\\
\begin{array}{c}
a\\
b\\
c\\
d
\end{array} & \left(\begin{array}{cccc}
0 & 1 & 1 & 1\\
1 & 0 & 1 & 0\\
1 & 1 & 0 & 0\\
1 & 0 & 0 & 0
\end{array}\right)
\end{aligned}
$$

::::
:::: {.column width=.33}

\scriptsize
\centering

\textbf{\underline{Incidence Matrix}}
\vskip.5em

$$
\begin{aligned} & \begin{array}{ccccc}
 & e_1 & e_2 & e_2 & e_3\end{array}\\
\begin{array}{c}
a\\
b\\
c\\
d
\end{array} & \left(\begin{array}{cccc}
1 & 1 & 1 & 0\\
1 & 0 & 0 & 1\\
0 & 1 & 0 & 1\\
0 & 0 & 1 & 0
\end{array}\right)
\end{aligned}
$$

::::
:::

# Adjacency Lists

::: columns
:::: column

**Linked List of Header Nodes**

::::
:::: column

**Array of Header Nodes**

::::
:::

# Isomorphism of Graphs

* The simple graphs $G_1 = (V_1, E_1)$ and $G_2 = (V_2, E_2)$ are **isomorphic** if there is
  - a one-to-one and onto function $f$ from $V_1$ to $V_2$ with the property that $a$ and $b$ are adjacent in $G_1$
  - iff $f(a)$ and $f(b)$ are adjacent in $G_2$, for all $a$ and $b$ in $v_1$
  - such a function $f$ is called an **isomorphism**

* **Graph Invariants**
  - A property preserved by isomorphism of graphs (e.g., some number of vertices, some number of edges with same degree)
  - Must show that both graphs have all the same invariants to prove isomorphism

* **Examples**

# Further Examples

# Further Examples

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Connectivity
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Paths

* Let $n$ be a nonnegative integer and $G$ an undirected graph.
  * A **path** of length $n$ from $u$ to $v$ in $G$ is a sequence of $n$ edges $e_1,\,\ldots,\,e_n$ of $G$ such that $e_1$ is associated with ${x_0,X_1}$, $e_2$ is associated with ${x_1,x_2}$, and so on, with $e_n$ associated with ${x_{n-1}, x_n}$, where $x_0 = u$ and $x_n = v$.

  * When the graph is simple, we denote this path by its vertex sequence $x_0,\,x_1,\,\ldots,\,x_n$.
  * The path is a **cicuit** if it begins, and ends at the same vertex, that is, if $u = v$, and has length greater than zero.
  * The path is said to **pass through** the vertices $x_1,\,x_2,\,x_{n-1},\,x_n$ or **traverse** the edges $e_1,\,e_2,\,\ldots,\,e_n$
  * A path is **simple** if it does not contain the same edge more than once.

# Paths

* Let $n$ be a nonnegative integer and $G$ a directed graph
  * A path of length $n$ from $u$ to $v$ in $G$ is a sequence of edges $e_1,\,e_2,\,\ldots,\,e_n$ of $G$ such that $e_1$ is associated with $(x_0, x_1)$, $e_2$ is associated with $(x_1, x_2)$, and so on, with $e_n$ associated with $(x_{n-1},x_n)$, where $x_0 = u$ and $x_n = v$.
  * When there are no multiple edges in the directed graph, this path is denoted by its vertex sequence $x_0,\,x_1,\,x_2\,\ldots,\,x_n$
  * A path or circuit is called simple if it does not contain the same edge more than once.

# Connectedness in Undirected Graphs

* An undirected graph is called **connected** if there is a path between every pair of distinct vertices of the graph

* **Theorem:** There is a simple path between every pair of distinct vertices of a connected graph

* **Examples:**

# Connectedness in Directed Graphs

* A directed graph is **strongly connected** if there is a paht form $a$ to $b$ and from $b$ to $a$ whenever $a$ and $b$ are vertices in the graph

* **Example**

* A directed graph is **weakly connected** if there is a path between every two vertices in the underlying undirected graph

* **Example**

# Counting Paths

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Euler and Hamilton Paths
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Euler Paths and Circuits

* **Euler Circuit:** a simple circuit in a graph $G$ which contains every edge of $G$.

* **Euler Path:** a simple path in graph $G$ containing every edge of $G$

* **Theorem:** A connected multigraph with at least two vertices has an Euler cicuit iff each of its vertices has even degree.
* **Theorem:** A connected multigraph has an Euler path but not an Euler cicuit iff it has exactly two vertices of odd degrees.

* **Examples:**

# Clique



# Independent Set

# Hamilton Paths and Circuits
