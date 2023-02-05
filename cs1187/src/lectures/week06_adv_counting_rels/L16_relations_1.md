---
author:
- Dr. Isaac Griffith
title: Relations
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
* Binary Relations
  * Representing Relations
  * Relation Properties
  * Combining Relations
  * Relation Operations
* $n$-ary Relations
  * Databases
  * Operations
  * SQL
::::
:::: {.column width=.25}
\vfill
\vspace{7.25em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\ts{Binary Relations}

# Binary Relation

* **Definition:** Let $A$ and $B$ be sets. A *binary relation from $A$ to $B$* is a subset of $A \times B$
  * A set of ordered pairs $\left(a, b\right)$ where $a \in A$ and $b \in B$
  * Notation: $aRb$ denotes $\left(a, b\right) \in R$, $a\!\!{\not{R}}b$ denotes $\left(a, b\right) \notin R$

  \pause
  \vskip.5em

  \ex Let $A$ be the set of cities in the US, and let $B$ be the set of the 50 states. Define the relation $R$ by specifying that $\left(a, b\right)$ belongs to $R$ if a city with name $a$ is in the state $b$. Examples in $R$ include:
    - (Bolder, Colorado)
    - (Bangor, Maine)
    - (Ann Arbor, Michigan)
    - (Cupertino, California)

# Relations on a Set

* **Definition:** A *relation on a set $A$* is a relation from $A$ to $A$.
  * Thus, it is a subset of $A \times A$

  \pause
  \vskip1em

  \ex Let $A$ be the set $\{1,2,3,4\}$. Which ordered pairs are in the relation $R = \{(a, b)\,|\, a\, divides\, b\}$?

  \pause
  \vskip1em

  \sol Because $\left(a, b\right)$ is in $R$ iff $a$ and $b$ are positive integers not exceeding 4 such that $a$ divides $b$, we see that:

  $$R = \{(1,1), (1,2), (1,3), (1,4), (2,2), (2,4), (3,3), (4,4)\}$$

# Representing Relations

* We can represent relations in several ways
  * As a function
  * As a matrix
  * As a digraph

# Relations as Functions

* A function $f$ from a set $A$ to a set $B$ assigns exactly one element of $B$ to each element of $A$
  * Thus, a graph of $f$ is the set of ordered pairs $\left(a, b\right)$ such that $b = f(a)$
  * Since, the graph of $f$ is a subset of $A \times B$, it is a relation from $A$ to $B$

\pause
\vskip.5em

* Relations are a generalization of graphs of functions

# Relations as Matrices

* A relation between finite sets can also be represented using a zero-one matrix.

\pause
\vskip.5em

* For a relation $R$ from $A = \{a_1,a_2,\ldots,a_m\}$ to $B = \{b_1,b_2,\ldots,b_n\}$.

\pause
\vskip.5em

* The relation $R$ can be represented by the matrix $\mathbf{M_R} = [m_{ij}]$, where

$$m_{ij} = \begin{cases}
1 & \text{if } (a_i, b_j) \in R \\
0 & \text{if } (a_i, b_j) \notin R
\end{cases}$$

# Relations as Digraphs

* We can also pictorially represent a relationship as a **directed graph** or **digraph**

\pause
\vskip.5em

* In such a representation
  * Each element of each set is represented by a point (or *vertex*)
  * Each ordered pair is represented by an arc, or *edge*, with its direction indicated by an arrow

\pause
\vskip.5em

::: columns
:::: {.column width=.75}

* **Definition:** A *directed graph*, or *digraph*, consists of a set $V$ of *vertices* (or *nodes*) together with a set $E$ of ordered pairs of elements of $V$ called *edges* (or *arcs*). The vertex $a$ is called the *initial vertex* of the edge $\left(a, b\right)$, and the vertex $b$ is called the *terminal vertex* of this edge.

\pause
\vskip.5em

* An edge of the form $\left(a, a\right)$ is represented using an arc from the vertex a back to itself, also called a **loop**.

::::
:::: {.column width=.25}

\centering
\begin{tikzpicture}
[node distance={25mm},main/.style = {draw, circle, line width=0.25mm, white}]

\node[main] (1) [label=above :{a}] {};
\node[main] (2) [label=above left :{b}, right of=1] {};
\node[main] (3) [label=below :{d}, below of=1] {};
\node[main] (4) [label=below :{c}, right of=3] {};

\draw [-Latex, line width=0.25mm, red] (1) to (2);
\draw [-Latex, line width=0.25mm, red] (1) to (3);
\draw [-Latex, line width=0.25mm, red] (4) to (2);
\draw [-Latex, line width=0.25mm, red] (4) to (1);

\draw [-Latex, line width=0.25mm, red] (2) to [out=195, in=75, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, red] (3) to [out=15, in=255, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, red] (2) to [out=0, in=90, looseness=8] (2);

\end{tikzpicture}

::::
:::

# Relations as Digraphs

::: columns
:::: column


\small

\ex The directed graph with vertices $a$, $b$, $c$, and $d$, and edges $\left(a, b\right)$, $\left(a, d\right)$, $\left(b, b\right)$, $\left(b, d\right)$, $\left(c, a\right)$, $\left(c, b\right)$, and $\left(d, b\right)$

\centering
\begin{tikzpicture}
[node distance={25mm},main/.style = {draw, circle, line width=0.25mm, white}]

\node[main] (1) [label=above :{a}] {};
\node[main] (2) [label=above left :{b}, right of=1] {};
\node[main] (3) [label=below :{d}, below of=1] {};
\node[main] (4) [label=below :{c}, right of=3] {};

\draw [-Latex, line width=0.25mm, red] (1) to (2);
\draw [-Latex, line width=0.25mm, red] (1) to (3);
\draw [-Latex, line width=0.25mm, red] (4) to (2);
\draw [-Latex, line width=0.25mm, red] (4) to (1);

\draw [-Latex, line width=0.25mm, red] (2) to [out=195, in=75, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, red] (3) to [out=15, in=255, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, red] (2) to [out=0, in=90, looseness=8] (2);

\end{tikzpicture}

::::
:::: column

\small

\pause
\ex The directed graph of the relation

  $$R_1 = \{(1,1),(1,3),(2,1),(2,3),(2,4),(3,1),(3,2),(4,1)\}$$

  on the set $\{1,2,3,4\}$

\begin{tikzpicture}
[node distance={25mm},main/.style = {draw, circle, line width=0.25mm, white}]

\node[main] (1) [label=above right :{1}] {};
\node[main] (2) [label=above :{2}, right of=1] {};
\node[main] (4) [label=below :{4}, below of=1] {};
\node[main] (3) [label=below :{3}, right of=4] {};

\draw [-Latex, line width=0.25mm, red] (2) to (1);
\draw [-Latex, line width=0.25mm, red] (2) to (4);
\draw [-Latex, line width=0.25mm, red] (4) to (1);

\draw [-Latex, line width=0.25mm, red] (1) to [out=345, in=105, looseness=1.15] (3);
\draw [-Latex, line width=0.25mm, red] (3) to [out=165, in=285, looseness=1.15] (1);
\draw [-Latex, line width=0.25mm, red] (2) to [out=255, in=105, looseness=1.05] (3);
\draw [-Latex, line width=0.25mm, red] (3) to [out=75, in=285, looseness=1.05] (2);
\draw [-Latex, line width=0.25mm, red] (1) to [out=180, in=90, looseness=10] (1);

\end{tikzpicture}

\pause
$$\text{\sol } R_2 = \{(1,3),(1,4),(2,1),(2,2),(2,3),(3,1),(3,3),(4,1),(4,3)\}$$

::::
:::

# Properties of Relations

* There are 4 basic properties of a relation
  * Reflexivity
  * Symmetry and Antisymmetry
  * Transitivity

# Reflexivity

* \small \textbf{Definition:} A relation $R$ on a set $A$ is called *reflexive* if $\left(a, a\right) \in R$ for every element $a \in A$

\pause
\vskip.5em

* \small \textbf{Definition:} A relation $R$ on a set $A$ is called *irreflexive* if, for every element $x \in A$, is is *not* the case that $xRx$

\pause
\vskip.5em

::: columns
:::: column

**Matrix Perspective:**

* \footnotesize A relation $R$ is reflexive iff $m_{ii} = 1$, for $i = 1,2,\ldots,n$. That is, all elements on the main diagonal of $\mathbf{M_R}$ are 1.
* \footnotesize A relation $R$ is irreflexive if there exists a zero on the main diagonal of $\mathbf{M_R}$.

\footnotesize
$$\begin{bmatrix}
1 &   &   &   &   &   &   &   & \\
  & 1 &   &   &   &   &   &   & \\
  &   & 1 &   &   &   &   &   & \\
  &   &   & \cdot &   &   &   & & \\
  &   &   &   & \cdot &   &   & & \\
  &   &   &   &   & \cdot &   & & \\
  &   &   &   &   &   & 1 &   & \\
  &   &   &   &   &   &   & 1 & \\
  &   &   &   &   &   &   &   & 1
\end{bmatrix}$$

::::
:::: column

\pause
**Digraph Perspective:**

* \footnotesize A relation is reflexive iff for every vertex in the digraph, there is a loop

\centering

\small

\begin{tikzpicture}
[node distance={25mm},main/.style = {draw, circle, line width=0.25mm, white}]

\node[main] (1) [label=right :{a}] {};
\node[main] (2) [label=below right:{b}, below left of=1] {};
\node[main] (3) [label=below left:{c}, below right of=1] {};

\draw [-Latex, line width=0.25mm, red] (1) to (2);
\draw [-Latex, line width=0.25mm, red] (1) to (3);
\draw [-Latex, line width=0.25mm, red] (2) to (3);

\draw [-Latex, line width=0.25mm, red] (1) to [out=45, in=135, looseness=10] (1);
\draw [-Latex, line width=0.25mm, red] (2) to [out=180, in=270, looseness=10] (2);
\draw [-Latex, line width=0.25mm, red] (3) to [out=270, in=0, looseness=10] (3);

\end{tikzpicture}

::::
:::

# Reflexivity

**Haskell Perspective:**

* \small The STDM tools provide two functions to determine if a relation over a set is either reflexive or irreflexive

  \small
  ```haskell
  isReflexive :: (Eq a, Show a) => Digraph a -> Bool
  isIrreflexive :: (Eq a, Show a) => Digraph a -> Bool
  ```

  \vskip.5em

  Which of the following digraphs are reflexive and which are irreflexive?

  ```haskell
  a = [1,2,3]
  digraph1 = (a, [(1,1), (1,2), (2,2), (2,3), (3,3)])
  digraph2 = (a, [(1,2), (2,3), (3,1)])
  digraph3 = (a, [(1,1), (1,2), (2,2), (2,3)])
  ```

# Symmetry

* \small \textbf{Definition:} A relation $R$ on a set $A$ is called *symmetric* if $\left(b, a\right) \in R$ whenever $\left(a, b\right) \in R$, for all $a, b \in A$.

  \pause
  \vskip.5em

* \small \textbf{Definition:} A relation $R$ on a set $A$ such that for all $a, b \in R$ and $\left(b, a\right) \in R$, then $a = b$ is called *antisymmetric*.
  * \footnotesize For $R$ to be antisymmetric both of the following must be true:
    * \scriptsize $\forall x,y \in A.\, x \ne y \to \lnot(xRy \land yRx)$
    * \scriptsize $\forall x,y \in A.\, x \ne y \to \lnot xRy \lor \lnot yRx$

::: columns
:::: column

\pause
\small

**Matrix Perspective:**

* \footnotesize A matrix $\mathbf{M_R}$ for relation $R$ depicts symmetry when $m_{ij} = m_{ji}$, for all $i$ and $j$ where $0 \leq i \leq n$ and $0 \leq j \leq n$.
  * \scriptsize $\mathbf{M_R} = (\mathbf{M_R})^T$
* \footnotesize A matrix $\mathbf{M_R}$ for relation $R$ depicts antisymmetric when $m_{ij} = 1$ then $m_{ji} = 0$ and $i \ne j$. That is either $m_{ij} = 0$ or $m_{ji} = 0$ when $i \ne j$.

::::
:::: column

\pause
\small

**Digraph Perspective:**

* \footnotesize A relation is symmetric iff for every edge between distinct vertices there is an edge in the opposite direction (i.e., an edge $\left(x, y\right)$ and $\left(y, x\right)$ both exist)

* \footnotesize A relation is antisymmetric iff there are never two edges in opposite directs between distinct vertices.

::::: columns
:::::: column

\centering

\footnotesize\ **Symmetric**

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm, white}]

\node[main] (1) [label=above :{\small a}] {};
\node[main] (2) [label=above :{\small b}, right of=1] {};
\node[main] (3) [label=below :{\small c}, below of=1] {};
\node[main] (4) [label=below :{\small d}, right of=3] {};

\draw [-Latex, line width=0.25mm, red] (1) to [out=255, in=105, looseness=1.05] (3);
\draw [-Latex, line width=0.25mm, red] (3) to [out=75, in=285, looseness=1.05] (1);
\draw [-Latex, line width=0.25mm, red] (1) to [out=300, in=150, looseness=1.05] (4);
\draw [-Latex, line width=0.25mm, red] (4) to [out=120, in=330, looseness=1.05] (1);
\draw [-Latex, line width=0.25mm, red] (1) to [out=345, in=195, looseness=1.05] (2);
\draw [-Latex, line width=0.25mm, red] (2) to [out=165, in=15, looseness=1.05] (1);

\end{tikzpicture}

::::::
:::::: column

\centering

\footnotesize\ **Antisymmetric**

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, line width=0.25mm, white}]

\node[main] (1) [label=above :{\small a}] {};
\node[main] (2) [label=above :{\small b}, right of=1] {};
\node[main] (3) [label=below :{\small c}, below of=1] {};
\node[main] (4) [label=below :{\small d}, right of=3] {};

\draw [-Latex, line width=0.25mm, red] (1) to (2);
\draw [-Latex, line width=0.25mm, red] (2) to (3);
\draw [-Latex, line width=0.25mm, red] (3) to (4);
\draw [-Latex, line width=0.25mm, red] (1) to (4);
\draw [-Latex, line width=0.25mm, red] (1) to (3);
\draw [-Latex, line width=0.25mm, red] (4) to (2);

\end{tikzpicture}

::::::
:::::

::::
:::

# Symmetry

**Haskell Perspective:**

* \small The STDM tools provide two functions to determine if a relation over a set is either symmetric or antisymmetric

  \small
  ```haskell
  isSymmetric, isAntisymmetric ::
    (Eq a, Show a) => Digraph a -> Bool
  ```

  \vskip1em

  Work out whether the relations in the following expressions are symmetric and whether they are antisymmetric, and then check your conclusions by evaluating the expressions with Haskell:

  ```haskell
  isSymmetric ([1,2,3], [(1,2), (2,3)])
  isSymmetric ([1,2], [(2,2), (1,1)])
  isAntisymmetric ([1,2,3], [(2,1), (1,2)])
  isAntisymmetric ([1,2,3], [(1,2), (2,3), (3,1)])
  ```

# Transitivity

* **Definition:** A relation $R$ on a set $A$ is called *transitive* if whenever $\left(a, b\right) \in R$ and $\left(b, c\right) \in R$, then $\left(a, c\right) \in R$, for all $a, b, c \in A$
  * That is,

    $$\forall x, y, z \in A.\, xRy \land yRz \to xRz$$

::: columns
:::: column

\pause
**Digraph Perspective:**

* \small A relation is transitive iff whenever there is an edge $\left(x,y\right)$ and an edge $\left(y, z\right)$ there is also an edge $\left(x, z\right)$ forming a triangle with the correct direction.

\centering

\begin{tikzpicture}
[node distance={25mm},main/.style = {draw, circle, line width=0.25mm, white}]

\node[main] (1) [label=above :{a}] {};
\node[main] (2) [label=below :{b}, below left of=1] {};
\node[main] (3) [label=below :{c}, below right of=1] {};

\draw [-Latex, line width=0.25mm, red] (1) to [out=255, in=15, looseness=1.05] (2);
\draw [-Latex, line width=0.25mm, red] (2) to [out=75, in=195, looseness=1.05] (1);
\draw [-Latex, line width=0.25mm, red] (1) to [out=345, in=105, looseness=1.05] (3);
\draw [-Latex, line width=0.25mm, red] (3) to [out=160, in=300, looseness=1.05] (1);
\draw [-Latex, line width=0.25mm, red] (2) to [out=345, in=195, looseness=1.05] (3);
\draw [-Latex, line width=0.25mm, red] (3) to [out=165, in=15, looseness=1.05] (2);
\end{tikzpicture}

::::
:::: column

::::
:::

# Transitivity

**Haskell Perspective:**

* \small The STDM tools provide a function to determine if a relation over a set is transitive

  \small
  ```haskell
  isTransitive :: (Eq a, Show a) => Digraph a -> Bool
  ```

  \vskip1em

  Determine by hand whether the following relations are transitive, and then check your conclusion using the computer

  ```haskell
  isTransitive ([1,2], [(1,2), (2,1), (2,2)])
  isTransitive ([1,2,3], [(1,2)])
  ```

# Examples

\small

\ex consider the following relations on $\{1,2,3,4\}$

  $$\begin{array}{rcl}
  R_1 & = & \{(1,1),(1,2),(2,1),(2,2),(3,4),(4,1)(4,4)\} \\
  R_2 & = & \{(1,1),(1,2),(2,1)\} \\
  R_3 & = & \{(1,1),(1,2),(1,4),(2,1),(2,2),(3,3),(4,1),(4,4)\} \\
  R_4 & = & \{(2,1),(3,1),(3,2),(4,1),(4,2),(4,3)\} \\
  R_5 & = & \{(1,1),(1,2),(1,3),(1,4),(2,2),(2,3),(2,4),(3,3),(3,4),(4,4)\} \\
  R_6 & = & \{(3,4)\}
  \end{array}$$

  Which of these relations are reflexive? symmetric? antisymmetric? transitive?

  \pause
  \sol

  - Reflexive: $R_3$ and $R_5$
  - Symmetric: $R_3$, $R_4$, and $R_6$
  - Antisymmetric: $R_1$, $R_2$, $R_4$, and $R_5$
  - Transitive: $R_4$, $R_5$, and $R_6$

# Combining Relations

* We can combine relations in three distinct ways
  * Using set operators (as a relation from $A$ to $B$ is a subset of $A \times B$)
  * Through composite relations
  * Through Powers of relations

# Set Operations

* Relations are sets, thus the set operations all apply

  \vspace{1em}

  \pause
  \ex Let $A = \{1,2,3\}$ and $B = \{1,2,3,4\}$. The relations $R_1 = \{(1,1), (2,2), (3,3)\}$ and $R_2 = \{(1,1), (1,2), (1,3), (1,4)\}$ can be combined to obtain:

  $$\begin{array}{rcl}
  R_1 \cup R_2 & = & \{(1,1), (1,2), (1,3), (1,4), (2,2), (3,3)\} \\
  R_1 \cap R_2 & = & \{(1,1)\} \\
  R_1 - R_2 & = & \{(2,2), (3,3)\} \\
  R_2 - R_1 & = & \{(1,2), (1,3), (1,4)\}
  \end{array}$$

# Set Operations

* Additionally, we can use the Boolean operations join and meet to find the union and intersection of two matrices representing relations. If we have $\mathbf{M_{R_1}}$ and $\mathbf{M_{R_2}}$ representing relations $R_1$ and $R_2$, then

  $$\mathbf{M_{R_1 \cup R_2}} = \mathbf{M_{R_1}} \lor \mathbf{M_{R_2}}\,\,\,\,\text{and}\,\,\,\,\mathbf{M_{R_1 \cap R_2}} = \mathbf{M_{R_1}} \land \mathbf{M_{R_2}}$$

# Matrix Example

\ex Suppose that the relations $R_1$ and $R_2$ on a set $A$ are represented by the matrices

  $$\mathbf{M_{R_1}} = \begin{bmatrix}
  1 & 0 & 1 \\
  1 & 0 & 0 \\
  0 & 1 & 0
  \end{bmatrix}\,\,\,\,\text{and}\,\,\,\,\mathbf{M_{R_2}} = \begin{bmatrix}
  1 & 0 & 1 \\
  0 & 1 & 1 \\
  1 & 0 & 0
  \end{bmatrix}$$

  What are the matrices representing $R_1 \cup R_2$ and $R_1 \cap R_2$?

\pause
\sol

  $$\mathbf{M_{R_1 \cup R_2}} = \mathbf{M_{R_1}} \lor \mathbf{M_{R_2}} = \begin{bmatrix}
  1 & 0 & 1 \\
  1 & 1 & 1 \\
  1 & 1 & 0
  \end{bmatrix}\,\,\,\,\mathbf{M_{R_1 \cap R_2}} = \mathbf{M_{R_1}} \land \mathbf{M_{R_2}} = \begin{bmatrix}
  1 & 0 & 1 \\
  0 & 0 & 0 \\
  0 & 0 & 0
  \end{bmatrix}
  $$

# Composite Relations

* **Defintion:** Let $R$ be a relation from a set $A$ to a set $B$ and $S$ a relation from $B$ to a set $C$. The *composite* of $R$ and $S$ is the relation consisting of ordered pairs $\left(a, c\right)$, where $a \in A$, $c \in C$, and for which there exists an element $b \in B$ such that $\left(a, b\right) \in R$ and $\left(b, c\right) \in S$. We denote the composite of $R and S$ as $R \circ S$

  \pause
  \vskip1em

  \ex What is the composite of the relations $R$ and $S$, where $R$ is the relation from $\{1,2,3\}$ to $\{1,2,3,4\}$ with $R = \{(1,1),(1,4),(2,3),(3,1),(3,4)\}$ and $S$ is the relation from $\{1,2,3,4\}$ to $\{0,1,2\}$ with $S = \{(1,0),(2,0),(3,1),(3,2),(4,1)\}$?

  \pause
  \vskip1em

  \sol $S \circ R = \{(1,0),(1,1),(2,1),(2,2),(3,0),(3,1)\}$

# Finding Composite Relations

* Computing the composite requires we find elements that are the second element of ordered pairs in the first relation and the first element of ordered pairs in the second element

\pause

::: columns
:::: column

* $R = \{(1,1),(1,4),(2,3),(3,1),(3,4)\}$
* $S = \{(1,0),(2,0),(3,1),(3,2),(4,1)\}$

::::
:::: column
\centering
\includegraphics[width=.9\textwidth]{images/relations/composite_digraph.eps}
::::
:::


# Finding Composite Relations

* In the case of the matrix representation, this is handled by using the Boolean product.

  $$\mathbf{M_{S \circ R}} = \mathbf{M_R} \odot \mathbf{M_S}$$

\pause
\ex Find the matrix representing the relations $S \circ R$

  $$\mathbf{M_R} = \begin{bmatrix}
  1 & 0 & 1 \\
  1 & 1 & 0 \\
  0 & 0 & 0
  \end{bmatrix}\,\,\,\,\,\mathbf{M_S} = \begin{bmatrix}
  0 & 1 & 0 \\
  0 & 0 & 1 \\
  1 & 0 & 1
  \end{bmatrix}$$

\pause
\sol The matrix for $S \circ R$ is

  $$\mathbf{M_{S \circ R}} = \mathbf{M_R} \odot \mathbf{M_S} = \begin{bmatrix}
  1 & 1 & 1 \\
  0 & 1 & 1 \\
  0 & 0 & 0
  \end{bmatrix}$$

# Powers of Relations

* **Definition:** Let $R$ be a relation on the set $A$. The *powers $R^n$*, $n = 1, 2, 3, \ldots$, are defined recursively by

  $$R^1 = R\,\,\,\, \text{and}\,\,\,\, R^{n+1} = R^n \circ R$$

  \pause
  \ex Let $R = \{(1,1), (2,1), (3,2), (4,3)\}$. Find the powers $R^n$, $n = 2, 3, 4, \ldots$

  \pause
  \vskip1em

  \sol Because $R^2 = R \circ R$, we find that

  $$\begin{array}{rcl}
  R^2 = \{(1,1),(2,1),(3,1),(4,2)\} \\
  R^3 = R^2 \circ R = \{(1,1), (2,1), (3,1), (4,1)\} \\
  R^4 = R^3 \circ R = \{(1,1), (2,1), (3,1), (4,1)\}
  \end{array}$$

  The same can be said for $n = 5,6,7,\ldots$

\pause
\vskip.5em

* **Theorem:** The relation $R$ on a set $A$ is transitive iff $R^n \subseteq R$ for $n = 1, 2, 3, \ldots$

# Powers of Relations

* In the context of the matrix representation, we can represent composite of two relations as the matrix for $\mathbf{M_{R^n}}$ as

  $$\mathbf{M_{R^n}} = \mathbf{M_{R}^{[n]}}$$

\pause
\ex Find the matrix representing the relation $R^2$, where the matrix representing $R$ is

$$\mathbf{M_R} = \begin{bmatrix}
0 & 1 & 0 \\
0 & 1 & 1 \\
1 & 0 & 0
\end{bmatrix}$$

\pause
\sol The matrix for $R^2$ is

$$\mathbf{M_{R^2}} = \mathbf{M_R^{[2]}} = \begin{bmatrix}
0 & 1 & 1 \\
1 & 1 & 1 \\
0 & 1 & 0
\end{bmatrix}$$

# Relational Composition

* The STDM tools provide some functions to help us find the composition and powers of relations

  \small

  ```haskell
  relationalComposition ::
    (Eq a, Show a, Eq b, Show b, Eq c, Show c) =>
      Set (a,b) -> Set (b,c) -> Set(a,c)
  relationalPower ::
    (Eq a, Show a) => Digraph a -> Int -> Relation a
  ```

  \pause
  \vskip.5em

  \ex: Work out the following relational compositions, then check with a computer

  ```haskell
  relationalComposition [(1,2),(2,3)] [(3,4)]
  relationalComposition [(1,2)] [(1,3)]
  ```

  \pause
  \vskip.5em

  \ex: Work out the values of these expressions, then evaluate using a computer

  ```haskell
  relationalPower ([1,2,3,4], [(1,2), (2,3), (3,4)]) 1
  relationalPower ([1,2,3,4], [(1,2), (2,3), (3,4)]) 2
  relationalPower ([1,2,3,4], [(1,2), (2,3), (3,4)]) 3
  ```

# Exercises

\exercise For each of these relations on the set $\{1,2,3,4\}$, decide whether it is reflexive, whether it is symmetric, whether it is antisymmetric, and whether it is transitive:

\pause
\vskip.5em

::: columns
:::: column

1. $\{(2,2),(2,3),(2,4),(3,2),(3,3),(3,4)\}$
2. $\{(1,1),(1,2),(2,1),(2,2),(3,3),(4,4)\}$
3. $\{(2,4),(4,2)\}$
4. $\{(1,2),(2,3),(3,4)\}$
5. $\{(1,1),(2,2),(3,3),(4,4)\}$
6. $\{(1,3),(1,4),(2,3),(2,4),(3,1),(3,4)\}$

::::
:::: column

\pause
\sol

* Reflexive: 2, 5
* Symmetric: 2, 3, 5
* Antisymmetric: 4, 5
* Transitive: 1, 2, 5

::::
:::

# Exercises

\exercise Represent each of these relations on $\{1,2,3\}$ with a matrix and a digraph

1. $\{(1,1),(1,2),(1,3)\}$
2. $\{(1,1),(1,2),(1,3),(2,2),(2,3),(3,3)\}$

\pause
\sol

::: columns
:::: {.column width=.333}
$$\mathbf{M_1} = \begin{bmatrix}
1 & 1 & 1 \\
0 & 0 & 0 \\
0 & 0 & 0
\end{bmatrix}$$

$$\mathbf{M_2} = \begin{bmatrix}
1 & 1 & 1 \\
0 & 1 & 1 \\
0 & 0 & 1
\end{bmatrix}$$

::::
:::: {.column width=.333}

\centering
\begin{tikzpicture}
[node distance={25mm},main/.style = {draw, circle, line width=0.25mm, white}]

\node[main] (1) [label=left :{1}] {};
\node[main] (2) [label=above :{2}, right of=1] {};
\node[main] (3) [label=left :{3}, below of=1] {};

\draw [-Latex, line width=0.25mm, red] (1) to (2);
\draw [-Latex, line width=0.25mm, red] (1) to (3);

\draw [-Latex, line width=0.25mm, red] (1) to [out=45, in=135, looseness=10] (1);

\end{tikzpicture}

::::
:::: {.column width=.333}

\centering
\begin{tikzpicture}
[node distance={25mm},main/.style = {draw, circle, line width=0.25mm, white}]

\node[main] (1) [label=left :{1}] {};
\node[main] (2) [label=above :{2}, right of=1] {};
\node[main] (3) [label=left :{3}, below of=1] {};

\draw [-Latex, line width=0.25mm, red] (1) to (2);
\draw [-Latex, line width=0.25mm, red] (1) to (3);
\draw [-Latex, line width=0.25mm, red] (2) to (3);

\draw [-Latex, line width=0.25mm, red] (1) to [out=45, in=135, looseness=10] (1);
\draw [-Latex, line width=0.25mm, red] (2) to [out=315, in=45, looseness=10] (2);
\draw [-Latex, line width=0.25mm, red] (3) to [out=225, in=315, looseness=10] (3);

\end{tikzpicture}

::::
:::

#

\ts{N-ary Relations}

# N-ary Relations

* In addition to binary relations, we can consider relations between many sets.

\pause
\vskip.5em

* **Definition:** Let $A_1,A_2,\ldots,A_n$ be sets. An *n-ary relation* on these sets is a subset of $A_1 \times A_2 \times \cdots \times A_n$. These sets $A_1,A_2,\ldots,A_n$ are called the *domains* of the relation, and $n$ is called its *degree*.

\pause
\vskip.5em

* These types of relations form the basis for databases

# Examples

* \ex Let $R$ be the relation consisting of 5-tuples $\left(A, N, S, D, T\right)$, representing airplane flights, where $A$ is the airline, $N$ is the flight number, $S$ is the starting point, $D$ is the destination, and $T$ is the departure time, the the following is an example of a particular tuple:

  \vskip1em

  (Nadir, 963, Newark, Bangor, 15:00)

  \pause
  \vskip1em

  - The degree of this relation is 5
  - The domain of this relation is
    - The set of all airlines
    - The set of all flight numbers
    - The set of cities
    - The set of cities (again)
    - The set of times

# Databases and Relations

* **Relational data model** - one of the various approaches for representing databases based on the concept of a relation
  * These methods make the operations (adding, deleting, updating, querying records) and storage of information efficient

\pause
\vskip.5em

* Database components
  * **Records:** $n$-tuples consisting of *fields*
  * **Fields:** entries in the $n$-tuples (i.e., a student record may have fields such as name, student number, major, and gpa).
  * **Table:** another name for the relations that represent databases.
    * Each column of the table corresponds to an *attribute* or *field* of the database, and each row to a **record**

# Keys

* Keys uniquely identify a $n$-tuple, or record, in a relation. There are two types of keys:
  * **Primary Key:** the domain of an $n$-ary relation, where the value of the $n$-tuple from this domain determines the $n$-tuple.
    * A domain is a *primary key* when no two $n$-tuples in the relation have the same value from this domain
  * **Composite Key:** often combinations of domains can be used to uniquely identify $n$-tuples in an $n$-ary relation. The Cartesian product of these domains is called a *composite key*

\pause
\vskip.5em

* Records are often added to or deleted from databases
  * **Extension:** of a relation is the current collection of $n$-tuples in the relation
  * **Intension:** is the permanent components (i.e., table structure) of the database
  * However, a key should be time-independent
  * Thus a key should be selected which will remain one as that database changes, thus it should be valid across all possible extensions

# N-ary Relation Operations

* **Definition:** Let $R$ be an n-ary relation and $C$ a condition that elements in $R$ must satisfy. Then the *selection operator* $s_C$ maps the n-ary relation $R$ to the n-ary relation of all n-tuples from $R$ that satisfy the condition $C$.

\pause
\vskip.5em

* **Definition:** The *projection* $P_{i_1, i_2, \ldots, i_m}$ where $i_1 < i_2 < \cdots < i_m$, maps the n-tuple $\left(a_1, a_2, \ldots, a_n\right)$ to the m-tuple $\left(a_{i_1},a_{i_2},\ldots, a_{i_m}\right)$, where $m \leq n$.

\pause
\vskip.5em

* **Definition:** Let $R$ be a relation of degree $m$ and $S$ a relation of degree $n$. The *join* $J_p(R,S)$, where $p \leq m$ and $p \leq n$, is a relation of degree $m + n - p$ that consists of all $\left(m + n - p\right)$-tuples $\left(a_1,a_2,\ldots,a_{m-p},c_1,c_2,\ldots,c_p,b_1,b_2,\ldots,b_{n-p}\right)$, where the $m$-tuple $\left(a_1,a_2,\ldots,a_{m-p},c_1,c_2,\ldots,c_p\right)$ belongs to $R$ and the $n$-tuple $\left(c_1,c_2,\ldots,c_p,b_1,b_2,\ldots,b_{n-p}\right)$ belongs to S.
  * In essence, the **join** operator allows us to combine two table into one when the tables share identical fields

# Selection Operator Example

\small

\ex To find the records of computer science majors in the n-ary relation R shown in the table below, we use the operator $s_{C_1}$, where $C_1$ is the condition Major = "Computer Science"

\centering
+----------------+-------------+------------------+-------+
| *Student_name* | *ID_number* | *Major*          | *GPA* |
+:===============+:===========:+:=================+:=====:+
| Ackermann      | 231455      | Computer Science | 3.88  |
+----------------+-------------+------------------+-------+
| Adams          | 888323      | Physics          | 3.45  |
+----------------+-------------+------------------+-------+
| Chou           | 102147      | Computer Science | 3.49  |
+----------------+-------------+------------------+-------+
| Goodfriend     | 453876      | Mathematics      | 3.45  |
+----------------+-------------+------------------+-------+
| Rao            | 678543      | Mathematics      | 3.90  |
+----------------+-------------+------------------+-------+
| Stevens        | 786576      | Psychology       | 2.99  |
+----------------+-------------+------------------+-------+

\pause
\raggedright
\sol

\centering
+----------------+-------------+------------------+-------+
| *Student_name* | *ID_number* | *Major*          | *GPA* |
+:===============+:===========:+:=================+:=====:+
| Ackermann      | 231455      | Computer Science | 3.88  |
+----------------+-------------+------------------+-------+
| Chou           | 102147      | Computer Science | 3.49  |
+----------------+-------------+------------------+-------+

# Projection Operator Example

\ex What is the table obtained when the project $P_{1,2}$ is applied to the relation in the following Table?

::: columns
:::: column

\footnotesize
+-----------+------------------+----------+
| *Student* | *Major*          | *Course* |
+:==========+:=================+:========:+
| Glauser   | Biology          | BI 290   |
+-----------+------------------+----------+
| Glauser   | Biology          | MS 475   |
+-----------+------------------+----------+
| Glauser   | Biology          | PY 410   |
+-----------+------------------+----------+
| Marcus    | Mathematics      | MS 511   |
+-----------+------------------+----------+
| Marcus    | Mathematics      | MS 603   |
+-----------+------------------+----------+
| Marcus    | Mathematics      | CS 322   |
+-----------+------------------+----------+
| Miller    | Computer Science | MS 575   |
+-----------+------------------+----------+
| Miller    | Computer Science | CS 455   |
+-----------+------------------+----------+

::::
:::: column

\pause
\sol

\small
+-----------+------------------+
| *Student* | *Major*          |
+:==========+:=================+
| Glauser   | Biology          |
+-----------+------------------+
| Marcus    | Mathematics      |
+-----------+------------------+
| Miller    | Computer Science |
+-----------+------------------+

::::
:::

# Join Operator Example

\ex What is the join of the following two tables?

::: columns
:::: column

\centering
\footnotesize

+-------------+------------------+-----------------+
| *Professor* | *Department*     | *Course_number* |
+:============+:=================+:===============:+
| Cruz        | Zoology          | 335             |
+-------------+------------------+-----------------+
| Cruz        | Zoology          | 412             |
+-------------+------------------+-----------------+
| Farber      | Psychology       | 501             |
+-------------+------------------+-----------------+
| Farber      | Psychology       | 617             |
+-------------+------------------+-----------------+
| Grammer     | Physics          | 544             |
+-------------+------------------+-----------------+
| Grammer     | Physics          | 551             |
+-------------+------------------+-----------------+
| Rosen       | Computer Science | 518             |
+-------------+------------------+-----------------+
| Rosen       | Mathematics      | 575             |
+-------------+------------------+-----------------+

::::
:::: column

\centering
\footnotesize

+------------------+-----------------+--------+----------+
| *Department*     | *Course_number* | *Room* | *Time*   |
+:=================+:===============:+:======:+:========:+
| Computer Science | 518             | N521   | 2:00 PM  |
+------------------+-----------------+--------+----------+
| Mathematics      | 575             | N502   | 3:00 PM  |
+------------------+-----------------+--------+----------+
| Mathematics      | 611             | N521   | 4:00 PM  |
+------------------+-----------------+--------+----------+
| Physics          | 544             | B505   | 4:00 PM  |
+------------------+-----------------+--------+----------+
| Psychology       | 501             | A100   | 3:00 PM  |
+------------------+-----------------+--------+----------+
| Psychology       | 617             | A110   | 11:00 AM |
+------------------+-----------------+--------+----------+
| Zoology          | 335             | A100   | 9:00 AM  |
+------------------+-----------------+--------+----------+
| Zoology          | 412             | A100   | 8:00 AM  |
+------------------+-----------------+--------+----------+

::::
:::

# Join Operator Example

\sol Resulting Table

\centering
\small
+-------------+------------------+-----------------+--------+----------+
| *Professor* | *Department*     | *Course_number* | *Room* | *Time*   |
+:============+:=================+:===============:+:======:+:========:+
| Cruz        | Zoology          | 335             | A100   | 9:00 AM  |
+-------------+------------------+-----------------+--------+----------+
| Cruz        | Zoology          | 412             | A100   | 8:00 AM  |
+-------------+------------------+-----------------+--------+----------+
| Farber      | Psychology       | 501             | A100   | 3:00 PM  |
+-------------+------------------+-----------------+--------+----------+
| Farber      | Psychology       | 617             | A110   | 11:00 AM |
+-------------+------------------+-----------------+--------+----------+
| Grammer     | Physics          | 544             | B505   | 4:00 PM  |
+-------------+------------------+-----------------+--------+----------+
| Rosen       | Computer Science | 518             | N521   | 2:00 PM  |
+-------------+------------------+-----------------+--------+----------+
| Rosen       | Mathematics      | 575             | N502   | 3:00 PM  |
+-------------+------------------+-----------------+--------+----------+

# SQL

* SQL (Structured Query Language) is a database query language used to carry out the operations we have previously discussed.

::: columns
:::: column

\footnotesize
+-----------+-----------------+--------+---------------+------------------+
| *Airline* | *Flight_number* | *Gate* | *Destination* | *Departure_time* |
+:==========+:===============:+:======:+:==============+:================:+
| Nadir     | 122             | 34     | Detroit       | 08:10            |
+-----------+-----------------+--------+---------------+------------------+
| Acme      | 221             | 22     | Denver        | 08:17            |
+-----------+-----------------+--------+---------------+------------------+
| Acme      | 122             | 33     | Anchorage     | 08:22            |
+-----------+-----------------+--------+---------------+------------------+
| Acme      | 323             | 34     | Honolulu      | 08:30            |
+-----------+-----------------+--------+---------------+------------------+
| Nadir     | 199             | 13     | Detroit       | 08:47            |
+-----------+-----------------+--------+---------------+------------------+
| Acme      | 222             | 22     | Denver        | 09:10            |
+-----------+-----------------+--------+---------------+------------------+
| Nadir     | 322             | 34     | Detroit       | 09:44            |
+-----------+-----------------+--------+---------------+------------------+

::::
:::: column

\footnotesize

```sql
SELECT Departure_time
FROM Flights
WHERE Destination='Detroit'
```

\centering
\begin{tabular}{c}
\hline
\textit{Departure\_time} \\ \hline
08:10                    \\
08:47                    \\
09:44                    \\ \hline
\end{tabular}

::::
:::

# SQL

* SQL (Structured Query Language) is a database query language used to carry out the operations we have previously discussed.

::: columns
:::: {.column width=.333}

\centering
\footnotesize

+-------------+------------------+-----------------+
| *Professor* | *Department*     | *Course_number* |
+:============+:=================+:===============:+
| Cruz        | Zoology          | 335             |
+-------------+------------------+-----------------+
| Cruz        | Zoology          | 412             |
+-------------+------------------+-----------------+
| Farber      | Psychology       | 501             |
+-------------+------------------+-----------------+
| Farber      | Psychology       | 617             |
+-------------+------------------+-----------------+
| Grammer     | Physics          | 544             |
+-------------+------------------+-----------------+
| Grammer     | Physics          | 551             |
+-------------+------------------+-----------------+
| Rosen       | Computer Science | 518             |
+-------------+------------------+-----------------+
| Rosen       | Mathematics      | 575             |
+-------------+------------------+-----------------+

::::
:::: {.column width=.333}

\centering
\footnotesize

+------------------+-----------------+--------+----------+
| *Department*     | *Course_number* | *Room* | *Time*   |
+:=================+:===============:+:======:+:========:+
| Computer Science | 518             | N521   | 2:00 PM  |
+------------------+-----------------+--------+----------+
| Mathematics      | 575             | N502   | 3:00 PM  |
+------------------+-----------------+--------+----------+
| Mathematics      | 611             | N521   | 4:00 PM  |
+------------------+-----------------+--------+----------+
| Physics          | 544             | B505   | 4:00 PM  |
+------------------+-----------------+--------+----------+
| Psychology       | 501             | A100   | 3:00 PM  |
+------------------+-----------------+--------+----------+
| Psychology       | 617             | A110   | 11:00 AM |
+------------------+-----------------+--------+----------+
| Zoology          | 335             | A100   | 9:00 AM  |
+------------------+-----------------+--------+----------+
| Zoology          | 412             | A100   | 8:00 AM  |
+------------------+-----------------+--------+----------+

::::
:::: {.column width=.333}

\footnotesize

```sql
SELECT Professor, Time
FROM Teaching_assignments as ta,
     Class_schedule as cs
WHERE ta.Department='Mathematics' AND
      cs.Department='Mathematics' AND
      ta.Course_number = cs.Course_number;
```

\centering
\begin{tabular}{lc}
\hline
\textit{Professor} & \textit{Time}    \\ \hline
Rosen     & 3:00 PM \\ \hline
\end{tabular}

::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
