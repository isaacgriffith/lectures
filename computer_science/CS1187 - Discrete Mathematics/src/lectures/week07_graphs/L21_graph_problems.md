---
author:
- Dr. Isaac Griffith
title: Graph Problems
institute: |
  CS 1187

  Department of Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Shortest-Path Problems
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Shortest Path Problems

* Graphs that have a number assigned to each edge are called **Weighted Graphs**

* Let the **length** of a path in a weighted graph to be the sum of the weights of the edges of this path

# Dijkstra's Algorithm

\scriptsize

\begin{algorithmic}[1]
\Require $G$ has vertices $a = v_0, v_1, \ldots, v_n = z$ and weights $w(v_i, v_j)$ where $w(v_i, v_j) = \infty$ if $\{v_i, v_j\}$ is not an edge in $G$
\Ensure $L(z)$ is the length of a shortest path from $a$ to $z$
\Procedure{dijkstra}{$G$}
  \For{$i \gets 1$ \textbf{to} $n$}
    \State $L(v_i) \gets \infty$
  \EndFor
  \State $L(a) \gets 0$ \Comment{Labels are initialized so that $a$ is $0$, and}
  \State $S \gets \varnothing$ \Comment{all other labels are $\infty$ and $S$ is the empty set}
  \While{$Z \notin S$}
    \State $u \gets $ a vertex not in $S$ with minimal $L(u)$
    \State $S \gets S \cup \{u\}$
    \For{all vertices $v \notin S$}
      \If{$L(u) + w(u,v) < L(v)$}
        \State $L(v) \gets L(u) + w(u,v)$ \Comment{this adds a vertex to $S$ with minimal label and updates the labels of vertices not in $S$}
      \EndIf
    \EndFor
  \EndWhile
\EndProcedure
\end{algorithmic}

# Dijkstra's Algorithm

* **Theorem:** Dijkstra's algorithm finds the length of a shortest path between two vertices in a connected simple undirected weighted graph.

* **Theorem:** Dijkstra's algorithm uses $O(n^2)$ operations (additions and comparisons) to find the length of a shortest path between two vertices in a connected simple undirected weighted graph with $n$ vertices.

# Traveling Salesman

* The traveling salesman problem asks for the circuit of minimum total weight in a weighted, complete, undirected graph that visits each vertex exactly once and returns to its starting point.

* This is equivalent to asking for a Hamilton circuit with minimum total weight int he complete graph, because each vertex is visited exactly once in the circuit.

* A practical approach is to use an approximation algorithm.

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Planar Graphs
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Planar Graphs

* A graph is called **planar** if it can be drawn in the plane without any edges crossing (where a crossing of edges is the intersection of the lines or arcs representing them at a point other than their common endpoint).

* Such a drawing is called a **planar representation** of the graph.

::: columns
:::: column

* **Example:** Is $K_4$ planar?

::::
:::: column

* **Example:** Is $Q_3$ planar?

::::
:::

* **Example:** Three Houses Problem. Is $K_{3,3} Planar?
  - Is it possible to join three houses and utilities so that none of the connections cross?

# Euler's Formula

* A planar representation of a graph splits the plane into **regions** including an unbounded region.

* **Theorem - Euler's Formula:**
  - Let $G$ be a connected planar simple graph with $e$ edges and $v$ vertices.
  - Let $r$ be the number of regions in a planar representations of $G$. Then
    $$r = e - v + 2$$

* **Corollary:** If $G$ is a connected planar simple graph with $e$ edges and $v$ vertices, where $v \geq 3$, then $e \leq 3v - 6$

* **Corollary:** If $G$ is a connected planar simple graph, then $G$ has a vertex of degree not exceeding 5.

* The **degree** of a region is defined to be the number of edges on the boundary of this region

* **Corollary:** If a connected planar simple graph has $e$ edges and $v$ vertices with $v \geq 3$ and no circuits of length three, then $e \geq 2v - 4$

# Kuratowski's Theorem

* If a graph is planar, so will be any graph obtained by removing an edge $\{u, v\}$ and adding a new vertex $w$ together with edges $\{u, w\}$ and $\{w, u\}$.

* Such an operation is called an **elementary subdivision**.

* The graphs $G_1 = (V_1, E_1)$ and $G_2 = (V_2, E_2)$ are called **homeomorphic** if they can be obtained from the same graph by a sequence of subdivisions

* **Theorem:** A graph is nonplanar iff it contains a subgraph homeomorphic to $k_{3,3}$ or $k_5$

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Graph Coloring
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Graph Coloring

* A **coloring** of a simple graph is the assignment of a color to each vertex of the graph so that no two adjacent vertices are assigned the same color.

* Each map in a plane can be represented by a graph. To setup this correspondence:
  - Each region of the map is represented by a vertex.
  - Edges connect two vertices, if the regions represented by these vertices have a common border.
  - Two regions that touch at only one point are not considered adjacent

* The resulting graph is called the **dual graph** of the map

* **Example:**

# Graph Coloring

* The **chromatic number** of a graph is the least number of colors needed for a coloring of this graph. The chromatic number of a graph $G$ is denoted by $\chi(G)$

* **Theorem - Fair Color Theorem:** The chromatic number of a planar graph is no greater than four.

# For Next Time

::: columns
:::: column
* Review Chapter
* Review this Lecture
* Read Chapter
* Come To Lecture
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
