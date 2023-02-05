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

::::
:::: {.column width=.25}
\vfill
\vspace{7.25em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

# Introduction to Graphs

* Graphs can model relations between pairs of objects and are fundamental in Discrete Mathematics.
* In prior lectures we covered *directed graphs*, now let's spend some time with *undirected graphs*!
* **Definition:** A *graph* $G = (V, E)$ consists of a non-empty set of *vertices* (*nodes*) $V$ and a set of *edges* $E$.

::: columns
:::: column

\footnotesize
\centering

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

::::
:::: column

\footnotesize
\centering

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (a);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (c);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to [out=10, in=170, looseness=1.15] (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (c) to [out=190, in=350, looseness=1.15] (b);

\end{tikzpicture}

::::
:::

# Introduction to graphs

* A *vertex* is usually represented by a dot with a label
* Each *edge* in $E$ is a set of two vertices from $V$ and is drawn as a line connecting two vertices

::: columns
:::: column

* each *edge* has either 1 or 2 vertices associated with it, call **endpoints**
* An edge **connects** its *endpoints*

* An **infinite graph** is a graph with infinite number of *vertices* or *edges*
* A **finite graph** is a graph with a finite vertex set and a finite edge set

::::
:::: column

\footnotesize
\centering

\vspace{.5em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

\vspace{2em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (a);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (c);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to [out=10, in=170, looseness=1.15] (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (c) to [out=190, in=350, looseness=1.15] (b);

\end{tikzpicture}

::::
:::

# Introduction to Graphs

* In **directed graphs** (**digraphs**) all edges have *direction*. An Edge $\left(a,b\right)$ *starts* at $a$ and *ends* at $b$.

\vfill

::: columns
:::: column

\footnotesize
\centering

\vspace{1em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

\vspace{.5em}

**Undirected Graph**

\vspace{2em}

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [left of=a] {b};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\end{tikzpicture}

\vspace{.5em}

**Undirected edge $\{a, b\}$**

::::
:::: column

\footnotesize
\centering

\vspace{1em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (a);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (c);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to [out=10, in=170, looseness=1.15] (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (c) to [out=190, in=350, looseness=1.15] (b);

\end{tikzpicture}

\vspace{.5em}

**Directed Graph**

\vspace{2em}

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [left of=a] {b};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (b);
\end{tikzpicture}

\vspace{.5em}

**Directed edge $\left(a, b\right)$**

::::
:::

# Introduction to Graphs

* **Definition:** A **simple (directed) graph** is a graph in which each edge connects two different vertices (no loops) and where no two edges connect the same pair of vertices

::: columns
:::: column

\footnotesize
\centering

\vspace{.5em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\draw [line width=0.25mm, FireOpal] (b) to [out=135, in=45, looseness=5] (b);

\end{tikzpicture}

\vspace{2em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (a);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (c);

\draw [-Latex, line width=0.25mm, FireOpal] (b) to [out=15, in=165, looseness=1] (c);
\draw [-Latex, line width=0.25mm, FireOpal] (b) to [out=25, in=155, looseness=1.5] (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (c) to [out=190, in=350, looseness=1.15] (b);

\end{tikzpicture}

::::
:::: column

**Simple Graphs:**

\footnotesize
\centering

\vspace{.5em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

\vspace{2em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (a);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (c);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to [out=10, in=170, looseness=1.15] (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (c) to [out=190, in=350, looseness=1.15] (b);

\end{tikzpicture}

::::
:::

# Introduction to Graphs

* **Definition** A **multigraph** is an *undirected graph* in which multiple edges connect the same vertices, but no loops

::: columns
:::: column

\footnotesize
\centering

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (a);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (c);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to [out=15, in=165, looseness=1] (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to [out=25, in=155, looseness=1.5] (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (c) to [out=190, in=350, looseness=1.15] (b);

\end{tikzpicture}

\vspace{1em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (a);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (c);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to [out=15, in=165, looseness=1] (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to [out=25, in=155, looseness=1.5] (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (c) to [out=190, in=350, looseness=1.15] (b);

\draw [-latex, line width=0.25mm, BlueDeFrance] (a) to [out=225, in=135, looseness=8] (a);

\end{tikzpicture}

::::
:::: column

\footnotesize
\centering

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\draw [line width=0.25mm, BlueDeFrance] (b) to [out=15, in=110, looseness=1.15] (d);
\draw [line width=0.25mm, BlueDeFrance] (b) to [out=45, in=90, looseness=1.15] (d);
\draw [line width=0.25mm, BlueDeFrance] (a) to [out=0, in=210, looseness=1.15] (c);

\end{tikzpicture}

\vspace{1em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\draw [line width=0.25mm, BlueDeFrance] (b) to [out=135, in=45, looseness=5] (b);
\draw [line width=0.25mm, BlueDeFrance] (a) to [out=0, in=210, looseness=1.15] (c);

\end{tikzpicture}

::::
:::

* **Definition** A **directed multigraph** is a *directed graph* in which multiple edges connect the same vertices, and loops are allowed.

# Introduction to Graphs

* **Definition** A **multigraph** is an *undirected graph* in which multiple edges connect the same vertices, but no loops

::: columns
:::: column

\footnotesize
\centering

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (a);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (c);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to [out=15, in=165, looseness=1] (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to [out=25, in=155, looseness=1.5] (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (c) to [out=190, in=350, looseness=1.15] (b);

\end{tikzpicture}

\vspace{1em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (a);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (d) to (c);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to [out=15, in=165, looseness=1] (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to [out=25, in=155, looseness=1.5] (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (c) to [out=190, in=350, looseness=1.15] (b);

\draw [-latex, line width=0.25mm, BlueDeFrance] (a) to [out=225, in=135, looseness=8] (a);

\end{tikzpicture}

::::
:::: column

\footnotesize
\centering

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\draw [line width=0.25mm, BlueDeFrance] (b) to [out=15, in=110, looseness=1.15] (d);
\draw [line width=0.25mm, BlueDeFrance] (b) to [out=45, in=90, looseness=1.15] (d);
\draw [line width=0.25mm, BlueDeFrance] (a) to [out=0, in=210, looseness=1.15] (c);

\end{tikzpicture}

\only<1>{
\vspace{1em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\draw [line width=0.25mm, FireOpal] (b) to [out=135, in=45, looseness=5] (b);
\draw [line width=0.25mm, BlueDeFrance] (a) to [out=0, in=210, looseness=1.15] (c);

\end{tikzpicture}
}

\only<2>{
\vspace{1em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\draw [line width=0.25mm, FireOpal] (b) to [out=135, in=45, looseness=5] (b);
\draw [line width=0.25mm, BlueDeFrance] (a) to [out=0, in=210, looseness=1.15] (c);

\draw [line width=0.25mm, FireOpal] (1,1.5) to (2, -0.25);
\draw [line width=0.25mm, FireOpal] (0,-0.25) to (3, 1.5);

\end{tikzpicture}
}

::::
:::

\only<2>{
\begin{itemize}
\item \textbf{Definition} A \textbf{directed multigraph} is a \textit{directed graph} in which multiple edges connect the same vertices, and loops are allowed.
\end{itemize}
}
\only<1>{
\begin{itemize}
\item \textbf{Some authors allow multigraphs to have loops, while others call these \textit{pseudographs}, reserving the term multigraph for the case with no loops}
\end{itemize}
}

# Introduction to Graphs

\vfill

::: columns
:::: column

edge $\{b, d\}$ has multiplicity 3

\vskip.5em

edge $\{a, c\}$ has multiplicity 2

::::
:::: column

\footnotesize

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\draw [line width=0.25mm, BlueDeFrance] (b) to [out=15, in=110, looseness=1.15] (d);
\draw [line width=0.25mm, BlueDeFrance] (b) to [out=45, in=90, looseness=1.15] (d);
\draw [line width=0.25mm, BlueDeFrance] (a) to [out=0, in=210, looseness=1.15] (c);

\end{tikzpicture}

::::
:::

* **edge of multiplicity $m$**: $m$ different undirected edges are associated to the same pair of different vertices

# Introduction to Graphs

* **Definition:** A **pseudograph** is an undirected graph that may include loops, and possibly multiple edges connecting the same pair of vertices or a vertex to itself.

\footnotesize
\centering

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\draw [line width=0.25mm, FireOpal] (b) to [out=15, in=110, looseness=1.15] (d);
\draw [line width=0.25mm, FireOpal] (b) to [out=45, in=90, looseness=1.15] (d);
\draw [line width=0.25mm, FireOpal] (a) to [out=0, in=210, looseness=1.15] (c);

\end{tikzpicture}

# Introduction to Graphs

* **Definition:** A **mixed graph** is a graph with both undirected and directed edges

\footnotesize
\centering

\vspace{.5em}

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2.25,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

# Introduction to Graphs

**Graph Terminology**

+-----------------------+------------+-----------------------------+--------------------+
| **Type**              | **Edges**  | **Multiple Edges Allowed?** | **Loops Allowed?** |
+:=====================:+:==========:+:===========================:+:==================:+
| Simple Graph          | undirected | No                          | No \vskip.5em      |
+-----------------------+------------+-----------------------------+--------------------+
| Multigraph            | undirected | Yes                         | No \vskip.5em      |
+-----------------------+------------+-----------------------------+--------------------+
| Pseudograph           | undirected | Yes                         | Yes \vskip.5em     |
+-----------------------+------------+-----------------------------+--------------------+
| Simple Directed Graph | directed   | No                          | No \vskip.5em      |
+-----------------------+------------+-----------------------------+--------------------+
| Directed Multigraph   | directed   | Yes                         | Yes \vskip.5em     |
+-----------------------+------------+-----------------------------+--------------------+
| Mixed Graph           | both       | Yes                         | Yes                |
+-----------------------+------------+-----------------------------+--------------------+

# Introduction to Graphs

* Graphs are used in a wide variety of models. When we build a graph model we need to answer the following three key questions:
  * Are the edges *directed*, *undirected*, or *both*?
  * If the graph is undirected: are *multiple edges* or *loops* present?

    If the graph is directed: are *multiple edges* present?
  * Are *loops* present?

# Graph Models

* Graphs can be used to model many different concepts including
  * Social Networks - Acquaintanceship Graphs, Influence Graphs, Collaboration Graphs, and Academic Collaboration Graphs
  * Communication Networks - Call Graphs
  * Information Networks - The Web Graph, Citation Graphs
  * Software Design Applications - Module Dependency Graphs, Control Flow Graphs, Precedence Graphs
  * Transportation Networks - Airline Routes, Road Networks
  * Biological Networks - Niche Overlap Graphs, Protein Interaction Graphs, Semantic Networks
  * Tournaments - Round-Robin Tournaments, Single-Elimination Tournaments

* We will look at a few of these

# Social Networks

* Graphs are used to model social structures based on different kinds of relationships between people or groups of people.
  * *vertices*: individuals (organizations)
  * *edges*: relationships between individuals (organizations)

# Acquaintanceship Graphs

::: columns
:::: column

* No loops (not including self-knowledge)/loops (including)
* No multiple edges
* *vertices*: individuals
* *edges*: friendship/acquaintanceship between individuals

::::
:::: column

\centering
\footnotesize

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

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);

\draw [line width=0.25mm, BlueDeFrance] (1) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (9);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (9);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (6);

\draw [line width=0.25mm, BlueDeFrance] (7) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (8) -- (9);

\draw [line width=0.25mm, BlueDeFrance] (7) -- (10);
\draw [line width=0.25mm, BlueDeFrance] (10) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (9) -- (12);
\draw [line width=0.25mm, BlueDeFrance] (7) -- (11);
\draw [line width=0.25mm, BlueDeFrance] (9) -- (14);

\draw [line width=0.25mm, BlueDeFrance] (10) -- (11);

\draw [line width=0.25mm, BlueDeFrance] (10) -- (13);
\draw [line width=0.25mm, BlueDeFrance] (11) -- (14);

\draw [line width=0.25mm, BlueDeFrance] (1) -- (15);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (16);


\end{tikzpicture}

::::
:::

# Influence Graphs

::: columns
:::: column

* Models group behavior observed where certain people influence the thinking of others.
* _vertex_: individuals
* *edges*: directed edge from vertex a to vertex b when person a influences person b.

::::
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) [label=above:{Linda}] {};
\node[main] (2) [label=above:{Brian}, right of=1] {};
\node[main] (3) [label=below:{Deborah}, below of=1] {};
\node[main] (4) [label=below:{Fred}, right of=3] {};
\node[main] (5) [label=below:{Yuame}, right of=4] {};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) -- (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) -- (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) -- (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) -- (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) -- (4);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=0, in=90, looseness=.75] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=180, in=270, looseness=.75] (2);
\end{tikzpicture}

::::
:::

# Collaboration Graphs

::: columns
:::: column

* no loops
* no multiple edges
* *vertices*: individuals
* *edges*: between individuals who work together in a particular way

::::
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) [label=above:{Tom}] {};
\node[main] (2) [label=above:{Juan}, above right of=1] {};
\node[main] (3) [label=below:{Olivia}, right of=2] {};
\node[main] (4) [label=below:{Fred}, below right of=1] {};
\node[main] (5) [label=below:{Maria}, below right of=3] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (3);

\end{tikzpicture}

::::
:::

* **Hollywood Graph:** a collaboration graph that represents actors by vertices and connects two actors if they have worked together on a movie or TV show.
  * Huge: > 1.5 million vertices (as of 2011)

# Biological Networks

::: columns
:::: column

* \textbf{Niche Overlap Graphs in Ecology} - used to model the interactions of different species of animals.
  - Each species is represented by a vertex.
  - An undirected edge connects two vertices if the two species represented compete for the same resources.

::::
:::: column

\centering

\footnotesize

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

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);

\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (6);

\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (6);

\draw [line width=0.25mm, BlueDeFrance] (4) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (9);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (9);

\draw [line width=0.25mm, BlueDeFrance] (7) -- (8);

\draw [line width=0.25mm, BlueDeFrance] (1) to [out=90, in=90, looseness=.75] (3);
\draw [line width=0.25mm, BlueDeFrance] (7) to [out=270, in=270, looseness=.75] (9);
\end{tikzpicture}

::::
:::

# Semantic Networks

::: columns
:::: column

* Models **semantic relations** which are relationships between two or more words based on the meaning of the words.
  * Used in *Natural Language Understanding* and *Information Retrieval*
  * Semantic relations are extracted from large bodies of text
  * Commonly have over 100,000 vertices and over 500,000 edges
* *vertices:* individual words
* *edges:* semantic relations
* No loops and edges are undirected

::::
:::: column

\begin{center}

\footnotesize

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) [label=below right:{Mouse}] {};
\node[main] (2) [label=below:{Trackpad}] at (2,0) {};
\node[main] (3) [label=right:{Keyboard}] at (1.5,.5) {};
\node[main] (4) [label=right:{Router}] at (2.5,.65) {};
\node[main] (5) [label=above right:{Laptop}] at (2.5,1.25) {};
\node[main] (6) [label=above right:{Tablet}] at (3.25,1.25) {};
\node[main] (7) [label=above:{Printer}] at (1.5,2) {};
\node[main] (8) [label=left:{Desktop}] at (1.25,1) {};

\node[main] (9) [label=above right:{Rabbit}] at (-.85,.65) {};
\node[main] (10) [label=above right:{Fox}] at (-1.45,1) {};
\node[main] (11) [label=above:{Wolf}] at (-1.85,1.25) {};
\node[main] (12) [label=below right:{Rat}] at (-1,0) {};
\node[main] (13) [label=left:{Cat}] at (-1.5,-.1) {};
\node[main] (14) [label=left:{Dog}] at (-1.5,.5) {};

\node[main] (15) [label=right:{Lizard}] at (-.5,-.75) {};
\node[main] (16) [label=left:{Duck}] at (-1.5,-.75) {};
\node[main] (17) [label=left:{Turtle}] at (-1,-1.15) {};
\node[main] (18) [label=right:{Fly}] at (0,-1.5) {};
\node[main] (19) [label=left:{Spider}] at (-.65,-1.65) {};
\node[main] (20) [label=left:{Cockroach}] at (-.1,-2) {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (7) -- (8);

\draw [line width=0.25mm, BlueDeFrance] (1) -- (9);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (12);
\draw [line width=0.25mm, BlueDeFrance] (9) -- (10);
\draw [line width=0.25mm, BlueDeFrance] (9) -- (14);
\draw [line width=0.25mm, BlueDeFrance] (12) -- (14);
\draw [line width=0.25mm, BlueDeFrance] (12) -- (13);
\draw [line width=0.25mm, BlueDeFrance] (13) -- (14);
\draw [line width=0.25mm, BlueDeFrance] (14) -- (10);
\draw [line width=0.25mm, BlueDeFrance] (10) -- (11);

\draw [line width=0.25mm, BlueDeFrance] (1) -- (15);
\draw [line width=0.25mm, BlueDeFrance] (15) -- (16);
\draw [line width=0.25mm, BlueDeFrance] (15) -- (17);
\draw [line width=0.25mm, BlueDeFrance] (15) -- (18);
\draw [line width=0.25mm, BlueDeFrance] (18) -- (19);
\draw [line width=0.25mm, BlueDeFrance] (18) -- (20);

\end{tikzpicture}

\end{center}

::::
:::

# Transportation Networks

* Graphs an be used to model road, air, rail, shipping, etc. networks

# Airline routes

* *vertices*: airports
* *edges*: direct flight (and back) - usually both ways
* Undirected multigraph

::: columns
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/graphs/DeltaUS-Route-map.png}

::::
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/graphs/airports-world-network.png}

::::
:::

# Road Networks

::: columns
:::: column

* *vertices*: intersections
* *edges*: roads
* One-way roads: directed edges
* Two-way roads: undirected edges
* Mixed graph

::::
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/graphs/nettopology.png}

::::
:::

# Tournaments

* Graphs can be used to model different kinds of tournaments

* *vertices*: players/teams
* *edges*: one round of play / tournament
* directed/undirected edges: depends
* If directed: shows who won

# Single-Elimination Tournament

::: columns
:::: column

* *vertices*: players/teams
* *edges*: one round
* undirected: each contestant is eliminated after one loss
* no loops
* no multiple edges (i.e., simple graph)

::::
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) [label=below:{Team 7}] {};
\node[main] (2) [label=above right:{Team 1}, left of=1] {};
\node[main] (3) [label=above left:{Team 7}, right of=1] {};

\node[main] (4) [label=above right:{Team 1}, above left of=2] {};
\node[main] (5) [label=above:{Team 1}] at (-3.5,1.65) {};
\node[main] (6) [label=above:{Team 2}] at (-3.5,0.5) {};

\node[main] (7) [label=below right:{Team 4}, below left of=2] {};
\node[main] (8) [label=above:{Team 3}] at (-3.5,-1.65) {};
\node[main] (9) [label=above:{Team 4}] at (-3.5,-0.5) {};

\node[main] (10) [label=above left:{Team 6}, above right of=3] {};
\node[main] (11) [label=above:{Team 5}] at (3.5,1.65) {};
\node[main] (12) [label=above:{Team 6}] at (3.5,0.5) {};

\node[main] (13) [label=below left:{Team 7}, below right of=3] {};
\node[main] (14) [label=above:{Team 7}] at (3.5,-1.65) {};
\node[main] (15) [label=above:{Team 8}] at (3.5,-0.5) {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);

\draw [line width=0.25mm, BlueDeFrance] (4) -| (2);
\draw [line width=0.25mm, BlueDeFrance] (5) -| (4);
\draw [line width=0.25mm, BlueDeFrance] (6) -| (4);

\draw [line width=0.25mm, BlueDeFrance] (7) -| (2);
\draw [line width=0.25mm, BlueDeFrance] (8) -| (7);
\draw [line width=0.25mm, BlueDeFrance] (9) -| (7);

\draw [line width=0.25mm, BlueDeFrance] (10) -| (3);
\draw [line width=0.25mm, BlueDeFrance] (11) -| (10);
\draw [line width=0.25mm, BlueDeFrance] (12) -| (10);

\draw [line width=0.25mm, BlueDeFrance] (13) -| (3);
\draw [line width=0.25mm, BlueDeFrance] (14) -| (13);
\draw [line width=0.25mm, BlueDeFrance] (15) -| (13);
\end{tikzpicture}

::::
:::

#

\ts{Graph Terminology}

# Graph Terminology

* **Definition:** Two vertices $u$ and $v$ in an *undirected graph* $G$ are called **adjacent** (**neighbors**) in $G$ if $u$ and $v$ are endpoints of an edge $e$ of $G$
  * Such an edge is called **incident with** vertices $u$ and $v$, and is said to **connect** $u$ and $v$.

\footnotesize
\centering

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\node[text width=10mm, align=center, Olivine] (adj) at (-0.75,1) {adjacent\\vertices};
\node[text width=25mm, align=center, Amethyst] (conn) at (-.15, -.75) {connects b and d};
\node[text width=25mm, align=center, BurntSienna] (inci) at (2.5, 1.75) {incident with\\vertices a and c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\draw [-Latex, line width=0.25mm, Olivine] (adj) -- (a);
\draw [-Latex, line width=0.25mm, Olivine] (adj) -- (b);
\draw [-Latex, line width=0.25mm, Amethyst] (conn) -- (1.7, 0.15);
\draw [-Latex, line width=0.25mm, BurntSienna] (inci) -- (1.7, 0.55);

\end{tikzpicture}

# Graph Terminology

* **Definition:** **neighborhood** of $v$, $N(v)$, is the set of all neighbors of $v$

  \vfill

  ::: columns
  :::: column

  Neighborhood of $a$: $N(a) = \{b,c\}$,

  Neighborhood of $b$: $N(b) = \{a, d\}$,

  Neighborhood of $c$: $N(c) = \{a\}$,

  Neighborhood of $d$: $N(d) = \{b\}$

  ::::
  :::: column

  \footnotesize
  \centering

  \begin{tikzpicture}
  [node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

  \node[main] (a) {a};
  \node[main] (b) at (1,1) {b};
  \node[main] (d) at (2,-0.25) {d};
  \node[main] (c) at (3.25, 1) {c};

  \node[text width=10mm, align=center, Olivine] (adj) at (-0.75,1.5) {adjacent\\vertices};

  \draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
  \draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
  \draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

  \draw [-Latex, line width=0.25mm, Olivine] (adj) -- (a);
  \draw [-Latex, line width=0.25mm, Olivine] (adj) -- (b);
  \draw [-Latex, line width=0.25mm, Olivine] (adj) -- (c);

  \end{tikzpicture}

  ::::
  :::

# Graph Terminology

* **Definition:** the **degree of a vertex** in an *undirected graph* is the number of edges incident with it, except that a *loop* at a vertex *contributes twice* to the degree of that vertex.
  * denoted: $\deg(v)$

::: columns
:::: column

  $$\begin{array}{rcl}
  \deg(a) & = & 2 \\
  \deg(b) & = & 2 + 2 = 4 \\
  \deg(c) & = & 1 \\
  \deg(d) & = & 1
  \end{array}$$

::::
:::: column

  \footnotesize
  \centering

  \begin{tikzpicture}
  [node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

  \node[main] (a) {a};
  \node[main] (b) at (1,1) {b};
  \node[main] (d) at (2,-0.25) {d};
  \node[main] (c) at (3.25, 1) {c};

  \node[text width=10mm, align=left, Olivine] (adj) at (4,.25) {pendant};

  \draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
  \draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
  \draw [line width=0.25mm, BlueDeFrance] (b) -- (d);
  \draw [line width=0.25mm, BlueDeFrance] (b) to [out=135, in=45, looseness=8] (b);

  \draw [-Latex, line width=0.25mm, Olivine] (adj) -- (c);
  \draw [-Latex, line width=0.25mm, Olivine] (adj) -- (d);

  \end{tikzpicture}

  \normalsize

  * **isolated:** a vertex of degree 0
  * **pendant:** a vertex of degree 1

::::
:::

# Handshaking Theorem

* **The Handshaking Theorem:** Let $G = (V,E)$ be an undirected graph with $m$ edges. Then

  $$2m = \underset{v \in V}{\sum}\deg(v)\,\,\,\,\text{or }\,\, \underset{v \in V}{\sum}\deg(v) = 2 |E|$$

  ::: columns
  :::: column

  * $m = 4$
  * $\deg(a) = 2$, $\deg(b) = 4$, $\deg(c) = 1$, $\deg(d) = 1$
  * $2 \times 4 = 2 + 4 + 1 + 1 \to 8 = 8$

  ::::
  :::: column

  \footnotesize
  \centering

  \begin{tikzpicture}
  [node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

  \node[main] (a) {a};
  \node[main] (b) at (1,1) {b};
  \node[main] (d) at (2,-0.25) {d};
  \node[main] (c) at (3.25, 1) {c};

  \draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
  \draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
  \draw [line width=0.25mm, BlueDeFrance] (b) -- (d);
  \draw [line width=0.25mm, BlueDeFrance] (b) to [out=135, in=45, looseness=8] (b);

  \end{tikzpicture}

  ::::
  :::

* **Theorem:** An undirected graph has an *even* number of vertices of *odd degree*

# Graph Terminology

* We can take a *directed graph* and convert it to an *undirected graph* by ignoring the directions. Such a graph is called the **underlying undirected graph**
* The directed graph and its underlying undirected graph have the same number of edges

::: columns
:::: column

\footnotesize
\centering

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) -- (d);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) to [out=135, in=225, looseness=8] (a);

\end{tikzpicture}

::::
:::: column

\footnotesize
\centering

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (a) to [out=135, in=225, looseness=8] (a);

\end{tikzpicture}

::::
:::

# Example

* \ex Recall the *Hollywood* graph
  a. What does the degree of a vertex represent in the Hollywood graph?
     - \only<2->{\sol the degree of a vertex represents the number of times the actor worked with other actors on a movie or a TV show}

  \vskip.5em

  b. What does the neighborhood of a vertex represent?
     - \only<4->{\sol $N(a)$ represents the lit of all actors the actor worked with on a movie or a TV show}

  \vskip.5em

  c. What do *isolated* and *pendant* vertices represent?
     - \only<6->{\sol Isolated vertices represent actors who didn't work with any other actor (present in the graph) on a movie or a TV show}
     - \only<7->{\sol Pendant vertices represent only actors with one collaboration}

# Exercise

* What are the degrees of the vertices in Graphs $G$ and $H$

::: columns
:::: column
\centering

\textbf{\underline{G}}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {A};
\node[main] (5) [right of=1] {F};
\node[main] (6) [right of=5] {E};
\node[main] (7) [right of=6] {G};
\node[main] (2) [above of=5] {B};
\node[main] (3) [right of=2] {C};
\node[main] (4) [right of=3] {D};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (6);

\end{tikzpicture}

::::
:::: column

\centering

\textbf{\underline{H}}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {A};
\node[main] (2) [right of=1] {B};
\node[main] (3) [right of=2] {C};
\node[main] (4) [below of=1] {E};
\node[main] (5) [right of=4] {D};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);

\draw [line width=0.25mm, BlueDeFrance] (2) to [out=135, in=45, looseness=8] (2);
\draw [line width=0.25mm, BlueDeFrance] (1) to [out=255, in=105, looseness=1.25] (4);
\draw [line width=0.25mm, BlueDeFrance] (1) to [out=285, in=75, looseness=1.25] (4);
\draw [line width=0.25mm, BlueDeFrance] (4) to [out=15, in=165, looseness=1.25] (5);
\draw [line width=0.25mm, BlueDeFrance] (4) to [out=-15, in=195, looseness=1.25] (5);

\end{tikzpicture}

::::
:::

\pause

\vskip1em

::: columns
:::: column

* $deg(A) = 2$
* $deg(B) = deg(c) = deg(F) = 4$
* $deg(D) = 1$
* $deg(E) = 3$
* $deg(G) = 0$

::::
:::: column

* $deg(A) = 4$
* $deg(B) = 6$
* $deg(C) = 1$
* $deg(D) = 5$
* $deg(E) = 6$

::::
:::

# Regular Graph

* **Definition:** A graph with all the vertices of the same degree is called a **regular graph**

* In a **d-regular graph**, all the vertices have degree $d$

\centering

**3-regular graphs**

::: columns
:::: {.column width=.333}

\footnotesize
\centering

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {};
\node[main] (b) [above of=a] {};
\node[main] (c) [right of=b] {};
\node[main] (d) [right of=a] {};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (a);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

::::
:::: {.column width=.333}

\footnotesize
\centering

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {};
\node[main] (b) [above of=a] {};
\node[main] (c) [right of=b] {};
\node[main] (d) [right of=a] {};
\node[main] (e) [above right of=a] {};
\node[main] (f) [above right of=b] {};
\node[main] (g) [above right of=c] {};
\node[main] (h) [above right of=d] {};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (a);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (f);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (g);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (h);
\draw [line width=0.25mm, BlueDeFrance] (e) -- (f);
\draw [line width=0.25mm, BlueDeFrance] (f) -- (g);
\draw [line width=0.25mm, BlueDeFrance] (g) -- (h);
\draw [line width=0.25mm, BlueDeFrance] (h) -- (e);

\end{tikzpicture}

::::
:::: {.column width=.333}

\footnotesize
\centering

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {};
\node[main] (b) [above of=a] {};
\node[main] (c) [right of=b] {};
\node[main] (d) [right of=a] {};
\node[main] (e) [below left of=a] {};
\node[main] (f) [above left of=b] {};
\node[main] (g) [above right of=c] {};
\node[main] (h) [below right of=d] {};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (a);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (f);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (g);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (h);
\draw [line width=0.25mm, BlueDeFrance] (e) -- (f);
\draw [line width=0.25mm, BlueDeFrance] (f) -- (g);
\draw [line width=0.25mm, BlueDeFrance] (g) -- (h);
\draw [line width=0.25mm, BlueDeFrance] (h) -- (e);

\end{tikzpicture}

::::
:::

# Subgraph

* **Definition:** A graph $H = (V_H, E_H)$ is a **subgraph** of a graph $G = (V_G, E_G)$ if $V_H \subseteq V_G$ and $E_H \subseteq E_G$.

* **Note:** graph $G$ is a subgraph of itself

::: columns
:::: column

\footnotesize
\centering

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) at (1,1) {b};
\node[main] (d) at (2,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (a) to [out=135, in=225, looseness=8] (a);

\end{tikzpicture}

\normalsize

**G**

::::
:::: column

\footnotesize
\centering

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (b) at (1,1) {b};
\node[main] (d) at (2,-0.25) {d};
\node[main] (c) at (3.25, 1) {c};

\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);

\end{tikzpicture}

\normalsize

**H**

::::
:::

* **Definition:** Let $G = (V,E)$ be a simple graph. The **subgraph induced** by a subset $W$ of the vertex set $V$ is the graph $(W,F)$, where the edge set $F$ contains an edge in $E$ iff both endpoints of this edge are in $W$.

# Graph Unions

* The **union** of two simple graphs $G_1 = (V_1, E_1)$ and $G_2 = (V_2, E_2)$ is the simple graph
  - Vertex set $V_1 \cup V_2$
  - Edge set $E_1 \cup E_2$

* The union of $G_1$ and $G_2$ is denoted by $G_1 \cup G_2$

* \textbf{Example:} Find the union of $G_1$ and $G_2$ below:

::: columns
:::: {.column width=.33}
\centering

\textbf{\underline{G\textsubscript{1}}}
\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {a};
\node[main] (2) [right of=1] {b};
\node[main] (3) [right of=2] {c};
\node[main] (4) [below of=1] {d};
\node[main] (5) [right of=4] {e};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);

\end{tikzpicture}
::::
:::: {.column width=.33}

\centering

\textbf{\underline{G\textsubscript{2}}}
\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {a};
\node[main] (2) [right of=1] {b};
\node[main] (3) [right of=2] {c};
\node[main] (4) [below of=1] {d};
\node[main] (5) [below of=3] {f};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);

\end{tikzpicture}
::::
:::: {.column width=.33}

\pause

\centering

\textbf{\underline{$G_1 \cup G_2$}}
\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {a};
\node[main] (2) [right of=1] {b};
\node[main] (3) [right of=2] {c};
\node[main] (4) [below of=1] {d};
\node[main] (5) [below of=2] {e};
\node[main] (6) [below of=3] {f};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);

\end{tikzpicture}
::::
:::

# Special Simple Graphs

* Complete Graphs ($K_n$, for $n \in \mathbb{Z}^+$)
* Cycles ($C_n$, for $n \in \mathbb{Z}^+$ and $n \geq 3$)
* Wheels ($W_n$, for $n \in \mathbb{Z}^+$ and $n \geq 3$)
* n-cubes ($Q_n$, for $n \in \mathbb{Z}^+$)

# Complete Graphs

::: columns
:::: {.column width=.33}

\centering

\textbf{\underline{K\textsubscript{1}}}
\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};

\end{tikzpicture}

\vskip4em

\normalsize
\textbf{\underline{K\textsubscript{4}}}
\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

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
:::: {.column width=.33}

\centering

\textbf{\underline{K\textsubscript{2}}}
\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);

\end{tikzpicture}

\vskip3em

\normalsize
\textbf{\underline{K\textsubscript{5}}}
\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [below left of=1] {};
\node[main] (3) [below right of=1] {};
\node[main] (4) [below of=2] {};
\node[main] (5) [below of=3] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);

\end{tikzpicture}

::::
:::: {.column width=.33}

\centering

\textbf{\underline{K\textsubscript{3}}}

\footnotesize

\vskip.5em

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [below left of=1] {};
\node[main] (3) [below right of=1] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);

\end{tikzpicture}

\vskip.5em

\normalsize
\textbf{\underline{K\textsubscript{6}}}
\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above right of=1] {};
\node[main] (3) [right of=2] {};
\node[main] (4) [below right of=1] {};
\node[main] (5) [right of=4] {};
\node[main] (6) [below right of=3] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (6);

\end{tikzpicture}

::::
:::

* A **complete graph $K_n$** on $n$ vertices is a simple graph that contains exactly one edge between each pair of distinct vertices. $n = 1, 2, 3, 4, \ldots$
* Sometimes $K_n$ is called a *clique of size n* or *n-clique*

# Bipartite Graphs

* Bipartite graphs can be used to model many types of applications that involve matching the elements of one set to elements of another

  \vskip.5em

::: columns
:::: column
  \ex Suppose there are $m$ employees in a group and $n$ different jobs that need to be done, where $m \leq n$. Each employee is trained to do one or more of these jobs. We want to assign *one employee* to each job.

  \vskip.5em

  Use bipartite graphs to model the situation!

  $m$ employees

  $n$ different jobs, where $m \geq n$

  \vskip.5em

  *vertices*: employees and jobs

  \vskip.5em

  *edges*: connect employees with jobs he/she can do

::::
:::: column

  \centering
  \footnotesize

  \begin{tikzpicture}
  [node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

  \node[main] (1) [label=above:{Design}] {};
  \node[main] (2) [right of=1,label=above:{Testing}] {};
  \node[main] (3) [right of=2,label=above:{Implementation}] {};
  \node[main] (4) [below of=1,label=below:{Collins}] {};
  \node[main] (5) [right of=4,label=below:{Smith}] {};
  \node[main] (6) [right of=5,label=below:{Chen}] {};
  \node[main] (7) [left of=4,label=below:{Yamagata}] {};
  \node[main] (8) [right of=6,label=below:{Rodriguez}] {};

  \draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
  \draw [line width=0.25mm, BlueDeFrance] (1) -- (7);
  \draw [line width=0.25mm, BlueDeFrance] (1) -- (8);
  \draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
  \draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
  \draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
  \draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
  \draw [line width=0.25mm, BlueDeFrance] (3) -- (6);
  \draw [line width=0.25mm, BlueDeFrance] (3) -- (7);
  \draw [line width=0.25mm, BlueDeFrance] (3) -- (8);
  \end{tikzpicture}

* A **matching** $M$ is a set of edges from simple graph $G$ such that for any $\{s,t\}$ and $\{u,v\} \in M$, $s,t,u$, and $v$ are different vertices

::::
:::

# Complete Bipartite Graphs

* A **Complete bipartite graph $K_{m,n}$** is a graph that has its vertex set partitioned into two subsets of $m$ and $n$ vertices, respectively with an edge between two vertices iff one vertex is in the first subset, and the other is in the second.

::: columns
:::: {.column width=.33}
\centering

\textbf{\underline{K\textsubscript{2,3}}}

\vskip.5em
\footnotesize

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above right of=1] {};
\node[main] (3) [right of=1] {};
\node[main] (4) [above right of=3] {};
\node[main] (5) [right of=3] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (4);

\end{tikzpicture}
::::
:::: {.column width=.33}
\centering

\textbf{\underline{K\textsubscript{3,3}}}

\footnotesize

\vskip.5em

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [right of=2] {};
\node[main] (4) [below of=1] {};
\node[main] (5) [right of=4] {};
\node[main] (6) [right of=5] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (6);

\end{tikzpicture}

\normalsize

\vskip.5em

\centering

\textbf{\underline{K\textsubscript{2,5}}}

\footnotesize

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

\draw [line width=0.25mm, BlueDeFrance] (6) -- (1);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (7) -- (1);
\draw [line width=0.25mm, BlueDeFrance] (7) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (7) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (7) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (7) -- (5);
\end{tikzpicture}
::::
:::: {.column width=.33}
\centering

\textbf{\underline{K\textsubscript{3,5}}}

\footnotesize

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

\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (8);
\end{tikzpicture}
::::
:::

# Cycles

::: columns
:::: {.column width=.25}

\centering

\textbf{\underline{C\textsubscript{3}}}

\vskip.5em
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [below left of=1] {};
\node[main] (3) [below right of=1] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);

\end{tikzpicture}

::::
:::: {.column width=.25}

\centering

\textbf{\underline{C\textsubscript{4}}}
\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [right of=1] {};
\node[main] (3) [below of=1] {};
\node[main] (4) [right of=3] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);

\end{tikzpicture}

::::
:::: {.column width=.25}

\centering

\textbf{\underline{C\textsubscript{5}}}
\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [below left of=1] {};
\node[main] (3) [below right of=1] {};
\node[main] (4) [below of=2] {};
\node[main] (5) [below of=3] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);

\end{tikzpicture}

::::
:::: {.column width=.25}

\centering

\textbf{\underline{C\textsubscript{6}}}

\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above right of=1] {};
\node[main] (3) [right of=2] {};
\node[main] (4) [below right of=1] {};
\node[main] (5) [right of=4] {};
\node[main] (6) [below right of=3] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (6);

\end{tikzpicture}

::::
:::

* A cycle $C_n$ on $n$ vertices consists of $n$ vertices $v_1, v_2, \ldots, v_n$ and edges $\{v_1, v_2\},\,\{v_2, v_3\},\,\ldots,\,\{v_{n-1},v_n\}$ $n = 3, 4, 5, \ldots$.

# Wheels

::: columns
:::: {.column width=.25}

\centering

\textbf{\underline{W\textsubscript{3}}}

\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [below left of=1] {};
\node[main] (3) [below right of=1] {};
\node[main] (4) [above of=1] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);

\end{tikzpicture}

::::
:::: {.column width=.25}

\centering

\textbf{\underline{W\textsubscript{4}}}
\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above left of=1] {};
\node[main] (3) [above right of=1] {};
\node[main] (4) [below left of=1] {};
\node[main] (5) [below right of=1] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (3);

\end{tikzpicture}

::::
:::: {.column width=.25}

\centering

\textbf{\underline{W\textsubscript{5}}}
\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above left of=1] {};
\node[main] (3) [above right of=1] {};
\node[main] (4) [below left of=1] {};
\node[main] (5) [below right of=1] {};
\node[main] (6) [above of=1] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (3);

\end{tikzpicture}

::::
:::: {.column width=.25}

\centering

\textbf{\underline{W\textsubscript{6}}}

\vskip.5em

\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {};
\node[main] (2) [above left of=1] {};
\node[main] (3) [above right of=1] {};
\node[main] (4) [below left of=1] {};
\node[main] (5) [below right of=1] {};
\node[main] (6) [left of=1] {};
\node[main] (7) [right of=1] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (7);

\end{tikzpicture}

::::
:::

* A wheel $W_n$ can be obtained from cycle $C_n$ by adding an additional vertex and connecting this new vertex with each of the $n$ vertices in $C_n$, for $n = 3,4,5,\ldots$

# n-Cubes

::: columns
:::: {.column width=.33}

\centering

\textbf{\underline{Q\textsubscript{1}}}

\vskip.5em
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {0};
\node[main] (2) [right of=1] {1};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);

\end{tikzpicture}

::::
:::: {.column width=.33}

\centering

\textbf{\underline{Q\textsubscript{2}}}

\vskip.5em
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {10};
\node[main] (2) [right of=1] {11};
\node[main] (3) [below of=1] {00};
\node[main] (4) [right of=3] {01};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);

\end{tikzpicture}

::::
:::: {.column width=.33}

\centering

\textbf{\underline{Q\textsubscript{3}}}

\vskip.5em
\footnotesize

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

::::
:::

* Graph of $Q_n$ has $2^n$ vertices

* n-Cubes can represent *bit strings* of length $n$, where $n = 1, 2, 3, 4, \ldots$

#

\ts{Representing Graphs}

# Representing Graphs

* When we are working on an algorithm for graphs, it is inconvenient to get the graphs as pictures.

* Even without an algorithm, the "same" graph can be drawn differently!

::: columns
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [above right of=a] {b};
\node[main] (d) [below right of=b] {d};
\node[main] (c) [above right of=d] {c};
\node[main] (e) [below right of=a] {e};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

::::
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (e) [below left of=a] {e};
\node[main] (c) [below right of=a] {c};
\node[main] (b) [above right of=a] {b};
\node[main] (d) [above right of=c] {d};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

::::
:::

$$\begin{array}{rcl}
V & = & \{a,b,c,d,e\} \\
E & = & \{\{a,b\},\{a,c\},\{a,e\},\{b,c\},\{b,d\}\}
\end{array}$$

* Therefore, there are several ways to represent graphs so they can be easily "processed"

# Adjacency Lists

* specify vertices that are adjacent to each vertex in the graph

::: columns
:::: column

\footnotesize

\begin{tikzpicture}
[node distance={15mm},
node of list/.style = {
             draw,
             minimum height=4mm,
             minimum width=4mm,
             node distance=5mm,
             BurntSienna
   },
link/.style = {
     -Latex,
     shorten >=1pt,
     BlueDeFrance
     },
array element/.style = {
    draw,
    minimum width = 4mm,
    minimum height = 5mm
},
main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [above right of=a] {b};
\node[main] (d) [below right of=b] {d};
\node[main] (c) [above right of=d] {c};
\node[main] (e) [below right of=a] {e};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\foreach [count=\i] \index/\list in {a/{b,c,e}, b/{a,c,d}, c/{a,b}, d/{b}, e/{a}} {
   \node[array element] (aux) at (4,-\i*.5 + 1.5) {\index};
   \LinkedList{\list}
}
\end{tikzpicture}

::::
:::: column

* What time does it take to
  * Build the adjacency list
    * list the neighbors of a vertex $v$ is proportional to $\deg(v)$, so the total time is proportional to $\underset{v \in V}{\sum}\deg(v)$
  * Locate an element (i.e., determine if $\{a,b\}$ is an edge)?
    * To determine if $\{a,b\}$ is an edge: it is enough to scan the list of $a$'s neighbors or the list of $b$'s neighbors. In the worst case, the time required is proportional to the $\min(\deg(a), \deg(b))$

::::
:::

# Adjacency Lists

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},
node of list/.style = {
             draw,
             minimum height=4mm,
             minimum width=4mm,
             node distance=5mm,
             BurntSienna
   },
link/.style = {
     -Latex,
     shorten >=1pt,
     BlueDeFrance
     },
array element/.style = {
    draw,
    minimum width = 4mm,
    minimum height = 5mm
},
main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [above right of=a] {b};
\node[main] (d) [below right of=b] {d};
\node[main] (c) [above right of=d] {c};
\node[main] (e) [below right of=a] {e};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\foreach [count=\i] \index/\list in {a/{b,c,e}, b/{a,c,d}, c/{a,b}, d/{b}, e/{a}} {
   \node[array element] (aux) at (4,-\i*.5 + 1.5) {\index};
   \LinkedList{\list}
}
\end{tikzpicture}
\end{center}

* Implementation in Imperative languages (i.e., Java/Python)
  * Dictionaries/Maps (keys; letters/strings, values: lists) or
  * Lists of lists (position: index of the vertex, each element is a list)

# Adjacency Lists

* For directed graphs it is similar:

\centering
\footnotesize

\begin{tikzpicture}
[node distance={15mm},
node of list/.style = {
             draw,
             minimum height=4mm,
             minimum width=4mm,
             node distance=5mm,
             BurntSienna
   },
link/.style = {
     -Latex,
     shorten >=1pt,
     BlueDeFrance
     },
array element/.style = {
    draw,
    minimum width = 4mm,
    minimum height = 5mm
},
main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [above right of=a] {b};
\node[main] (d) [below right of=b] {d};
\node[main] (c) [above right of=d] {c};
\node[main] (e) [below right of=a] {e};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) -- (d);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (b) to [out=135, in=45, looseness=8] (b);

\foreach [count=\i] \index/\list in {a/{b,c,e}, b/{b,d}, c/{null}, d/{null}, e/{null}} {
   \node[array element] (aux) at (4,-\i*.5 + 1.5) {\index};
   \LinkedList{\list}
}
\end{tikzpicture}

# Adjacency Matrices

::: columns
:::: column

- Using zero-one matrices
- Vertices should be ordered

$$a_{ij} = \begin{cases}
1 & \text{if } (v_i, v_j) \in E \\
0 & \text{otherwise}
\end{cases}$$

\vskip3em

\centering

**Similarly with directed graphs**

::::
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [above right of=a] {b};
\node[main] (d) [below right of=b] {d};
\node[main] (c) [above right of=d] {c};
\node[main] (e) [below right of=a] {e};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

\normalsize
\textbf{$G = (V, E)$}

\end{center}

$$\begin{blockarray}{*{5}{c} l}
  \begin{block}{*{5}c l}
    \color{Olivine}a & \color{Olivine}b & \color{Olivine}c & \color{Olivine}d & \color{Olivine}e & \\
  \end{block}
  \begin{block}{[*{5}{c}] l}
    0 & 1 & 1 & 0 & 1 & \color{Olivine}a \\
    1 & 0 & 1 & 1 & 0 & \color{Olivine}b \\
    1 & 1 & 0 & 0 & 0 & \color{Olivine}c \\
    0 & 1 & 0 & 0 & 0 & \color{Olivine}d \\
    1 & 0 & 0 & 0 & 0 & \color{Olivine}e \\
  \end{block}
\end{blockarray}$$

::::
:::

# Exercise

\exercise Is every zero-one square matrix that is symmetric and has zeros on the diagonal is the adjacency matrix of a simple graph?

# Adjacency Matrices with Multiple Edges

* vertices should be ordered

$$a_{ij} = \begin{cases}
number\,of\,edges\,(v_i, v_j) & \text{if } (v_i, v_j) \in E \\
0 & \text{otherwise}
\end{cases}$$

::: columns
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [above right of=a] {b};
\node[main] (d) [below right of=b] {d};
\node[main] (c) [above right of=d] {c};
\node[main] (e) [below right of=a] {e};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\draw [line width=0.25mm, BlueDeFrance] (a) to [out=65, in=205, looseness=1.15] (b);
\draw [line width=0.25mm, BlueDeFrance] (b) to [out=15, in=165, looseness=1.15] (c);
\draw [line width=0.25mm, BlueDeFrance] (b) to [out=30, in=150, looseness=1.15] (c);
\draw [line width=0.25mm, BlueDeFrance] (b) to [out=270, in=180, looseness=1.15] (d);

\end{tikzpicture}

\normalsize
\textbf{$G = (V, E)$}

\end{center}

::::
:::: column

$$\begin{blockarray}{*{5}{c} l}
  \begin{block}{*{5}c l}
    \color{Olivine}a & \color{Olivine}b & \color{Olivine}c & \color{Olivine}d & \color{Olivine}e & \\
  \end{block}
  \begin{block}{[*{5}{c}] l}
    0 & 2 & 1 & 0 & 1 & \color{Olivine}a \\
    2 & 0 & 3 & 2 & 0 & \color{Olivine}b \\
    1 & 3 & 0 & 0 & 0 & \color{Olivine}c \\
    0 & 2 & 0 & 0 & 0 & \color{Olivine}d \\
    1 & 0 & 0 & 0 & 0 & \color{Olivine}e \\
  \end{block}
\end{blockarray}$$

::::
:::

# Incidence Matrices

::: columns
:::: column

- Using zero-one matrices
- Rows are the vertices, Columns are the edges

$$a_{ij} = \begin{cases}
1 & \text{when edge } e_j\,\,\text{is incident with } v_i \\
0 & \text{otherwise}
\end{cases}$$

\vskip3em

\centering

**Similarly with directed graphs**

::::
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [above right of=a] {b};
\node[main] (d) [below right of=b] {d};
\node[main] (c) [above right of=d] {c};
\node[main] (e) [below right of=a] {e};


\draw [line width=0.25mm, BlueDeFrance] (a) -- node[white, midway, above right, sloped] {$e_2$} (e);
\draw [line width=0.25mm, BlueDeFrance] (a) -- node[white, midway, above right, sloped] {$e_3$} (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- node[white, midway, above right, sloped] {$e_4$} (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- node[white, midway, above right, sloped] {$e_5$} (d);

\end{tikzpicture}

\normalsize
\textbf{$G = (V, E)$}

\end{center}

$$\begin{blockarray}{*{5}{c} l}
  \begin{block}{*{5}c l}
    \color{Olivine}e\textsubscript{1} & \color{Olivine}e\textsubscript{2} & \color{Olivine}e\textsubscript{3} & \color{Olivine}e\textsubscript{4} & \color{Olivine}e\textsubscript{5} & \\
  \end{block}
  \begin{block}{[*{5}{c}] l}
    1 & 1 & 1 & 0 & 0 & \color{Olivine}a \\
    1 & 0 & 0 & 1 & 1 & \color{Olivine}b \\
    0 & 0 & 1 & 1 & 0 & \color{Olivine}c \\
    0 & 0 & 0 & 0 & 1 & \color{Olivine}d \\
    0 & 1 & 0 & 0 & 0 & \color{Olivine}e \\
  \end{block}
\end{blockarray}$$

::::
:::

# Graph Representations

* Choosing between Adjacency Lists and Adjacency Matrices
  - For **sparse graphs**, that contain *relatively few edges*, adjacency lists are preferred
  - For **dense graphs**, that contain *more than half of all possible edges*, adjacency matrices are preferred

* Some things to consider
  * matrices contain $|V|^2$ entries (for any type of graph)
  * adjacency lists use less space (for sparse graphs)
  * To determine whether a vertex $v_i$ is adjacent to $v_j$:
    * matrices: just examine $a_{ij}$ entry
    * lists: can require up to $c|V|$, $c \in \mathbb{Z}^+$ comparisons

# Graph Isomorphism

* Consider the two graphs

::: columns
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [above right of=a] {b};
\node[main] (d) [below right of=b] {d};
\node[main] (c) [above right of=d] {c};
\node[main] (e) [below right of=a] {e};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

\end{center}

::::
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {c};
\node[main] (b) [above right of=a] {d};
\node[main] (d) [below right of=b] {a};
\node[main] (c) [above right of=d] {e};
\node[main] (e) [below right of=a] {b};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

\end{center}

::::
:::

* They look similar, but they are not quite the same

# Graph Isomorphism

* Consider the other two graphs:

::: columns
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [above right of=a] {b};
\node[main] (d) [below right of=b] {d};
\node[main] (c) [above right of=d] {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

\end{center}

::::
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {1};
\node[main] (3) [above right of=a] {3};
\node[main] (2) [below right of=b] {2};
\node[main] (4) [above right of=d] {4};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);

\end{tikzpicture}

\end{center}

::::
:::

* They do not look similar at all!

# Graph Isomorphism

* Nevertheless, it is possible to find a correspondence of vertices in each pair of the graphs that will yield the correspondence of the edges in the graphs (i.e., every edge in the graph on the left will correspond to an edge in the graph on the right, and vice versa).

::: columns
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [above right of=a] {b};
\node[main] (d) [below right of=b] {d};
\node[main] (c) [above right of=d] {c};
\node[main] (e) [below right of=a] {e};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

\end{center}

::::
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {c};
\node[main] (b) [above right of=a] {d};
\node[main] (d) [below right of=b] {a};
\node[main] (c) [above right of=d] {e};
\node[main] (e) [below right of=a] {b};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

\end{center}

::::
:::

::: columns
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [above right of=a] {b};
\node[main] (d) [below right of=b] {d};
\node[main] (c) [above right of=d] {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

\end{center}

::::
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {1};
\node[main] (3) [above right of=a] {3};
\node[main] (2) [below right of=b] {2};
\node[main] (4) [above right of=d] {4};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);

\end{tikzpicture}

\end{center}

::::
:::

# Graph Isomorphism

* **Definition:** Let $G = (V, E)$ and $G' = (V', E')$ be simple graphs. $G$ and $G'$ are **isomorphic** if there is a *bijection* (one-to-one correspondence) $f : V \to V'$ such that for every pair of vertices $x, y \in V$, $\{x, y\} \in E$ iff $\{f(x), f(y)\} \in E'$.

* The function $f$ is called an **isomorphism** from $G$ to $G'$

* Two simple graphs that are not isomorphic are called **nonisomorphic**

# Example

\ex Consider two graphs: $G$ and $H$. Let's try to see if they are isomorphic or not

::: columns
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main,FireOpal] (a) {a};
\node[main,Olivine] (b) [above right of=a] {b};
\node[main,Jasmine] (d) [below right of=b] {d};
\node[main,Amethyst] (c) [above right of=d] {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

\normalsize
\textbf{$G = (V_1, E_1)$}

\end{center}

::::
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main,FireOpal] (1) {1};
\node[main,Amethyst] (3) [above right of=a] {3};
\node[main,Olivine] (2) [below right of=b] {2};
\node[main,Jasmine] (4) [above right of=d] {4};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);

\end{tikzpicture}

\normalsize
\textbf{$H = (V_2, E_2)$}

\end{center}

::::
:::

\begin{equation*}\begin{array}{rcl}
f & : & V_1 \to V_2 \\
\color{FireOpal}a & \to & \color{FireOpal}1 \\
\color{Olivine}b & \to & \color{Olivine}2 \\
\color{Amethyst}c & \to & \color{Amethyst}3 \\
\color{Jasmine}d & \to & \color{Jasmine}4
\end{array}\end{equation*}

\centering

**$G$ and $H$ are isomorphic!**

# Exercise

\exercise Are the following graphs isomorphic? If yes, give an isomorphism.

::: columns
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [above of=a] {b};
\node[main] (c) [right of=b] {c};
\node[main] (d) [right of=a] {d};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

\end{center}

::::
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (y) {y};
\node[main] (x) [above of=a] {x};
\node[main] (w) [right of=b] {w};
\node[main] (z) [right of=a] {z};

\draw [line width=0.25mm, BlueDeFrance] (x) -- (w);
\draw [line width=0.25mm, BlueDeFrance] (w) -- (z);
\draw [line width=0.25mm, BlueDeFrance] (w) -- (y);
\draw [line width=0.25mm, BlueDeFrance] (y) -- (z);

\end{tikzpicture}

\end{center}

::::
:::

# Evaluating Isomorphism

* Sometimes, it is easy to see that two graphs are *not isomorphic*: check the *number of vertices* and the *number of edges*, they should be equal accordingly.

  \begin{equation*}\begin{array}{rcl}
  |V_1| & = & |V_2| \\
  |E_1| & = & |E_2|
  \end{array}\end{equation*}

* Also, the *degrees of vertices* in isomorphic graphs *must be the same*

* Properties above are **graph invariants**
  * *graph invariant* - a property preserved by isomorphism

# Example

\ex Are the graphs $G_1$ and $G_2$ isomorphic? If yes, give their isomorphism.

::: columns
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (a) {a};
\node[main] (b) [above right of=a] {b};
\node[main] (e) [below right of=a] {e};
\node[main] (d) [right of=b] {d};
\node[main] (c) [below right of=d] {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (e);

\end{tikzpicture}

\normalsize
\textbf{$G_1 = (V_1, E_1)$}

\end{center}

::::
:::: column

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main] (1) {1};
\node[main] (5) [above right of=1] {5};
\node[main] (4) [right of=5] {4};
\node[main] (2) [below right of=5] {2};
\node[main] (3) [right of=4] {3};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);

\end{tikzpicture}

\normalsize
\textbf{$G_2 = (V_2, E_2)$}

\end{center}

::::
:::

\sol

$$|E_1| = {\color{Roarange}6}, |E_2| = {\color{Roarange}7}$$

\centering
\vskip-1em

**Hence the graphs are not isomorphic**

# Exercise

\exercise Are the graphs with the following adjacency matrices isomorphic? If yes, give an isomorphism

::: columns
:::: column

\begin{equation*}\begin{bmatrix}
0 & 1 & 1 & 0 & 1 \\
1 & 0 & 1 & 1 & 0 \\
1 & 1 & 0 & 0 & 0 \\
0 & 1 & 0 & 0 & 0 \\
1 & 0 & 0 & 0 & 0
\end{bmatrix}\end{equation*}

**$$\mathbf{M}_G$$**

::::
:::: column

\begin{equation*}\begin{bmatrix}
1 & 0 & 0 & 1 & 1 \\
1 & 1 & 0 & 0 & 0 \\
1 & 0 & 1 & 1 & 0 \\
0 & 0 & 0 & 0 & 0 \\
0 & 0 & 1 & 0 & 0
\end{bmatrix}\end{equation*}

**$$\mathbf{M}_H$$**

::::
:::

# Evaluating Isomorphism

* *In general:* to check if graphs $G_1$ and $G_2$ are isomorphic (and we are not given a correspondence function $f$ to check), there are $|V|!$ possible bijections to check, which is impractical for large |V|.
  * Assume $|V| = n$, then there are $n$ options to choose from for the correspondence $v_1 \to \ldots$
  * $n-1$ options to choose from for the correspondence $v_2 \to \ldots$
  * $\ldots$
  * $1$ option to choose from for the correspondence $v_n \to \ldots$.
  * So we get $n(n-1)(n-2)\ldots 2 \cdot1 = n!$
* However a recent algorithm shows that this can be done in pseudopolynomial time

# Evaluating Isomorphism

* To show that a function $f : V_1 \to V_2$ is an isomorphism of graphs $G_1 = (V_1, E_1)$ and $G_2 = (V_2, E_2)$, we need to show that $f$ *preserves* the *presence and the absence of edges*
  * One way to do this is with adjacency matrices

::: columns
:::: {.column width=.333}

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main,FireOpal] (a) {a};
\node[main,Olivine] (b) [above right of=a] {b};
\node[main,Jasmine] (d) [below right of=b] {d};
\node[main,Amethyst] (c) [above right of=d] {c};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);

\end{tikzpicture}

\normalsize
\textbf{$G = (V_1, E_1)$}

\end{center}

$$\begin{blockarray}{*{4}{c} l}
  \begin{block}{*{4}c l}
    \color{FireOpal}a & \color{Olivine}b & \color{Amethyst}c & \color{Jasmine}d & \\
  \end{block}
  \begin{block}{[*{4}{c}] l}
    0 & 1 & 1 & 0 & \color{FireOpal}a \\
    1 & 0 & 1 & 1 & \color{Olivine}b \\
    1 & 1 & 0 & 0 & \color{Amethyst}c \\
    0 & 1 & 0 & 0 & \color{Jasmine}d \\
  \end{block}
\end{blockarray}$$

::::
:::: {.column width=.333}

\begin{center}
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm}]

\node[main,FireOpal] (1) {1};
\node[main,Amethyst] (2) [above right of=1] {2};
\node[main,Olivine] (4) [below right of=2] {4};
\node[main,Jasmine] (3) [above right of=4] {3};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (4);

\end{tikzpicture}

\normalsize
\textbf{$H = (V_2, E_2)$}

\end{center}

$$\begin{blockarray}{*{4}{c} l}
  \begin{block}{*{4}c l}
    \color{FireOpal}1 & \color{Olivine}4 & \color{Amethyst}2 & \color{Jasmine}3 & \\
  \end{block}
  \begin{block}{[*{4}{c}] l}
    0 & 1 & 1 & 0 & \color{FireOpal}1 \\
    1 & 0 & 1 & 1 & \color{Olivine}4 \\
    1 & 1 & 0 & 0 & \color{Amethyst}2 \\
    0 & 1 & 0 & 0 & \color{Jasmine}3 \\
  \end{block}
\end{blockarray}$$

::::
:::: {.column width=.333}

\begin{equation*}\begin{array}{rcl}
f & : & V_1 \to V_2 \\
\color{FireOpal}a & \to & \color{FireOpal}1 \\
\color{Olivine}b & \to & \color{Olivine}4 \\
\color{Amethyst}c & \to & \color{Amethyst}2 \\
\color{Jasmine}d & \to & \color{Jasmine}3
\end{array}\end{equation*}

::::
:::

# Evaluating Isomorphism

* **Drawback:** If the given function is not an isomorphism, it **doesn't guarantee that the two graphs are not isomorphic**. There might be another correspondence of the vertices in graphs that is an isomorphism.

* The best known algorithms for determining whether two graphs are isomorphic was *exponential worst-case time complexity* (in $|V|$) until Babai developed one which had $O(2^{f(n)})$ time where $f(n)$ is $O((log n)^3)$.

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
