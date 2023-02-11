---
author:
- Dr. Isaac Griffith
title: Trees
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

* Tree Basics
* Applications of Trees
  * Prefix Trees and Huffman Coding
  * Decision Trees
  * BSTs
  * Game Trees
* Tree Traversals
  * Pre-, In-, Post-order
* Tree Induction
* Spanning Trees
  * BFS and DFS
* Minimum Spanning Trees

::::
:::: {.column width=.25}
\vfill
\vspace{7.25em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\ts{Introduction to Trees}

# What's Trees?

* A **tree** is a connected undirected graph with no simple circuits

::: columns
:::: {.column width=.25}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (A) {};
\node[main] (B) [right of=A] {};
\node[main] (C) [below of=A] {};
\node[main] (D) [right of=C] {};
\node[main] (E) [below of=C] {};
\node[main] (F) [right of=E] {};

\draw [line width=0.25mm, BlueDeFrance] (A) -- (C);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (C);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (E) -- (F);
\end{tikzpicture}

::::
:::: {.column width=.25}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (A) {};
\node[main] (B) [right of=A] {};
\node[main] (C) [below of=A] {};
\node[main] (D) [right of=C] {};
\node[main] (E) [below of=C] {};
\node[main] (F) [right of=E] {};

\draw [line width=0.25mm, BlueDeFrance] (A) -- (C);
\draw [line width=0.25mm, BlueDeFrance] (A) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (E);
\draw [line width=0.25mm, BlueDeFrance] (D) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (E) -- (F);
\end{tikzpicture}

::::
:::: {.column width=.25}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (A) {};
\node[main] (B) [right of=A] {};
\node[main] (C) [below of=A] {};
\node[main] (D) [right of=C] {};
\node[main] (E) [below of=C] {};
\node[main] (F) [right of=E] {};

\draw [line width=0.25mm, BlueDeFrance] (A) -- (B);
\draw [line width=0.25mm, BlueDeFrance] (A) -- (C);
\draw [line width=0.25mm, BlueDeFrance] (A) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (E);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (D) -- (E);
\end{tikzpicture}

::::
:::: {.column width=.25}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={15mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (A) {};
\node[main] (B) [right of=A] {};
\node[main] (C) [below of=A] {};
\node[main] (D) [right of=C] {};
\node[main] (E) [below of=C] {};
\node[main] (F) [right of=E] {};

\draw [line width=0.25mm, BlueDeFrance] (A) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (E);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (E);
\end{tikzpicture}

::::
:::

* **Theorem:** An undirected graph is a tree iff there is a unique simple path between any two of its vertices

# Rooted Trees

* A **rooted tree** is a tree in which one vertex has been designated as the **root** and every edge is directed away from the root.

::: columns
:::: {.column width=.333}

\centering
\vskip1em

\small

\begin{tikzpicture}
[node distance={15mm}, main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (1) [label=below:{b}] {};
\node[main] (2) [below left of=1,label=below:{a}] {};
\node[main] (3) [above left of=2,label=below:{d}] {};
\node[main] (4) [above left of=1,label=below:{f}] {};
\node[main] (5) [above right of=1,label=below:{g}] {};
\node[main] (6) [below right of=2,label=below:{c}] {};
\node[main] (7) [above right of=6,label=below:{e}] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (7);
\end{tikzpicture}

::::
:::: {.column width=.333}

\centering
\vskip1em

\small

\begin{tikzpicture}
[every node/.style = {shape=circle, draw=white, fill=AshGray, line width=0.25mm, align=center},]
\node [label=above:{a}] {}
  child {node [label=left:{b}] {} edge from parent [-Latex, line width=0.25mm, BlueDeFrance]
  child {node [label=below:{g}] {}}
  child {node [label=below:{f}] {}}}
  child {node [label=left:{c}] {} edge from parent [-Latex, line width=0.25mm, BlueDeFrance]
  child {node [label=below:{e}] {}}}
  child {node [label=right:{d}] {} edge from parent [-Latex, line width=0.25mm, BlueDeFrance]};
\end{tikzpicture}

::::
:::: {.column width=.333}

\centering
\vskip1em

\small

\begin{tikzpicture}
[every node/.style = {shape=circle, draw=white, fill=AshGray, line width=0.25mm, align=center},]
\node [label=above:{c}] {}
  child {node [label=left:{a}] {} edge from parent [-Latex, line width=0.25mm, BlueDeFrance]
    child {node [label=left:{b}] {}
      child {node [label=left:{f}] {}}
      child {node [label=right:{g}] {}}}
    child {node [label=right:{d}] {}}}
  child {node [label=right:{e}] {} edge from parent [-Latex, line width=0.25mm, BlueDeFrance]};
\end{tikzpicture}

::::
:::

# Terminologies of Rooted Trees

::: columns
:::: column

* If $v$ is a vertex in $T$ other than the root, the **parent** of $v$ is the unique vertex $u$ such that there is a directed edge from $u$ to $v$

\vskip0.5em

* If $u$ is the parent of $v$, $v$ is called a **child** of $u$

\vskip0.5em

* Vertices with the same parent are called **siblings**

::::
:::: column

\centering

\includegraphics[width=.85\textwidth]{images/trees/tree_term_1.eps}

::::
:::

# Terminologies of Rooted Trees

* The **ancestors** of a vertex other than the root are the vertices in the path from the root to this vertex, excluding the vertex itself and including the root

\vskip0.5em

* The **descendants** of a vertex $v$ are those vertices that have $v$ as an ancestor

\vskip0.5em

* A vertex of a tree is called a **leaf** if it has no children

\vskip0.5em

* Vertices that have children are called **internal vertices**

\vskip0.5em

* If $a$ is a vertex is a tree, the **subtree** with $a$ as its root is the subgraph of the tree consisting of $a$ and its descendants and all edges incident to these descendants.

# m-Ary Trees

* A rooted tree is called an **m-ary tree** if every internal vertex has no more than $m$ children. The tree is called a **full m-ary tree** if every internal vertex has exactly $m$ children. An m-ary tree with $m = 2$ is called a **binary tree**

\vskip0.5em

* An **ordered rooted tree** is a rooted tree where the children of each internal vertex are ordered. Ordered rooted trees are drawn so that the children of each internal vertex are shown in order from left to right.

\vskip0.5em

* In an ordered binary tree (usually just called a binary tree), if an internal vertex has two children, the first child is called the **left child** and the second child is called the **right child**. The tree rooted at the left child (or right child, respectively) of a vertex is called the **left subtree** (or **right subtree**, respectively) of this vertex.

# Tree Terminologies

::: columns
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/trees/tree_term_2.eps}

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/trees/full_binary_tree.eps}

**Example Full Binary Tree**

::::
:::

# Properties of Trees

* **Theorem:** A tree with $n$ vertices has $n - 1$ edges

\vskip1em

* **Theorem:** A full m-ary tree with $i$ internal vertices contains $n = mi + 1$ vertices

# Properties of Trees

* **Theorem:** A full m-ary tree with
  1. $n$ vertices has $i = (n - 1) / m$ internal vertices and $l = [(m - 1) n + 1] / m$ leaves
  2. $i$ internal vertices has $n = mi + 1$ vertices and $l = (m - 1) i + 1$ leaves
  3. $l$ leaves has $n = (ml -1) / (m - 1)$ vertices and $i = (l - 1) / (m - 1) internal vertices

\vskip0.5em

* **Theorem:** There are at most $m^h$ leaves in any m-ary tree of height $h$

#

\ts{Trees in Haskell}

# Representing Trees in Haskell

* The representation of a *binary tree* in Haskell is as follows (limited to integer data)

```Haskell
data BinTree a
  = BinLeaf
  | BinNode a (BinTree a) (BinTree a)
  deriving Show
```

* That is a tree is either
  * A leaf without a value, or
  * A node with a value and a right and a left subtree

# Haskell Example

::: columns
:::: column

**Example tree**

```haskell
tree :: BinTree Int
tree = BinNode 4
         (BinNode 2
            (BinNode 1 BinLeaf BinLeaf)
            (BinNode 3 BinLeaf BinLeaf)
         (BinNode 6
            (BinNode 5 BinLeaf BinLeaf)
            (BinNode 7 BinLeaf BinLeaf))
```

::::
:::: column

\centering
\small

\begin{tikzpicture}
[every node/.style = {line width=0.25mm, circle, align=center, draw=white},]
\node {$4$} [sibling distance = 30mm]
  child {node {$2$} edge from parent [line width=0.25mm, BlueDeFrance, sibling distance = 15mm]
    child {node {\textcolor{white}{$1$}} [sibling distance = 10 mm]
      child {node {}}
      child {node {}}}
    child {node {\textcolor{white}{$3$}} [sibling distance = 10 mm]
      child {node {}}
      child {node {}}}}
  child {node {\textcolor{white}{$6$}} edge from parent [line width=0.25mm, BlueDeFrance, sibling distance = 15mm]
    child {node {\textcolor{white}{$5$}} [sibling distance = 10 mm]
      child {node {}}
      child {node {}}}
    child {node {\textcolor{white}{$1$}} [sibling distance = 10 mm]
      child {node {}}
      child {node {}}}};
\end{tikzpicture}

::::
:::

#

\ts{Applications of Trees}

# Binary Search Trees

* **Binary Search Tree:** a binary tree in which each child of a vertex is designated as a right or left child, no vertex has more than one right or left child, and each vertex is labeled with a key, which is one of the items.

\vskip0.5em

* Vertices are assigned keys so that the key of a vertex is both larger than keys of all vertices in its left subtree and smaller than the keys of all vertices in its right subtree.

# Binary Search Trees

\centering
\includegraphics[width=.95\textwidth]{images/trees/bst_formation.eps}

# Searching a BST

* We can implement a BST in Haskell as follows:

```haskell
bstSearch :: Ord a => a -> BinTree (a, b) -> Maybe b
bstSearch key BinLeaf = Nothing
bstSearch key (BinNode (x, y) t1 t2) =
  if key == x
    then Just y
    else if key < x
      then bstSearch key t1
      else bstSearch key t2
```

# Adding Items to a BST

\small

\begin{algorithmic}
\Procedure{insertion}{$T$: binary search tree, $x$ item}
  \State $v \coloneqq$ root of $T$
  \State \{a vertex is not present in $T$ has the value \textit{null}\}
  \While{$v \ne null$ and $label(v) \ne x$}
    \If{$x < label(v)$}
      \If{left child of $v \ne null$}
        \State $v \coloneqq$ left child of $v$
      \Else
        \State add $new\,\,vertex$ as a left child of $v$ and set $v \coloneqq null$
      \EndIf
    \Else
      \If{right child of $v \ne null$}
        \State $v \coloneqq$ right child of $v$
      \Else
        \State add $new\,\,vertex$ as a right child of $v$ and set $v \coloneqq null$
      \EndIf
    \EndIf
  \EndWhile
  \If{root of $T = null$}
    \State add a vertex $v$ to the tree and label it with $x$
  \ElsIf{$v$ is null or $label(v) \ne x$}
    \State label $new\,\,vertex$ with $x$ and let $v$ be this new vertex
  \EndIf
  \State \Return $v$ \{$v$ = location of $x$\}
\EndProcedure
\end{algorithmic}

# BST Insertion

* The prior algorithm for insertion can be implemented as follows in Haskell:

```haskell
insert :: Ord a => (a, b) -> BinTree (a, b) -> BinTree (a, b)
insert (key, d) BinLeaf = BinNode (key, d) BinLeaf BinLeaf
insert (key, d) (BinNode (x, y) t1 t2) =
  if key == x
    then BinNode (key, d) t1 t2
    else if key < x
      then BinNode (x, y) (insert (key, d) t1) t2
      else BinNode (x, y) t1 (insert (key, d) t2)
```

# Decision Trees

::: columns
:::: column

* **Decision tree:** a rooted tree in which each internal vertex corresponds to a decision with a subtree at these vertices for each possible outcome fo the decision.

\vskip0.5em

* Such trees can be used to model problems in which a series of decisions leads to a solution.

::::
:::: column

\ex Decision tree for sorting three distinct elements

\centering
\includegraphics[width=.95\textwidth]{images/trees/decision_tree.eps}

::::
:::

# Prefix Codes

* **Prefix Codes:** codes wherein a bit string represents a letter, and no bit strings corresponds to more than one sequence of letters.

\vskip0.5em

* **Huffman coding:** a special case of prefix codes
  * Uses frequencies of symbols in a string and produces as output a prefix code that encodes the string using the fewest possible bits, among all possible binary prefix codes for these symbols.

# Huffman Coding

\begin{algorithmic}
\Procedure{Huffman}{$C$: symbols $a_i$ with frequencies $w_i$, $i = 1, \ldots, n$}
  \State $F \coloneqq$ forest of $n$ rooted trees, each consisting of a single vertex $a_i$ and assigned weight $w_i$
  \While{$F$ is not a tree}
    \State Replace the rooted trees $T$ and $T'$ of least weights from $F$ with $w(T) \geq w(T')$ with a tree
    \State having a new root that has $T$ as it left subtree and $T'$ as its right subtree. Label the new
    \State edge to $T$ with $0$ and the new edge to $T'$ with $1$.
    \State Assign $w(T) + w(T')$ as the weight of the new tree
  \EndWhile
  \State \{the Huffman coding for the symbol $a_i$ is the concatenation of the labels of the edges in the
  \State unique path from the root to the vertex $a_i$\}
\EndProcedure
\end{algorithmic}

# Huffman Coding Example

* \ex Use Huffman coding to encode the following symbols with the frequencies: A: 0.08, B: 0.10, C: 0.12, D: 0.15, E:0.20, F: 0.35

::: columns
:::: {.column width=.6}

\centering
\includegraphics[width=\textwidth]{images/trees/huffman.eps}

::::
:::: {.column width=.4}

\small

* \sol This encodes A by 111, B by 110, C by 011, D by 010, E by 10, and F by 00.

  \vskip.5em

  The average number of bits used to encode a symbol using this encoding is:

  $$\begin{array}{l}
  3\, \cdot\, 0.08 + 3\, \cdot\, 0.10 + 3\, \cdot\, 0.12 + \\
  3\, \cdot\, 0.15 + 2\, \cdot\, 0.020 + 2\, \cdot\, 0.35 = 2.45
  \end{array}$$

::::
:::

# Game Trees

* Trees can be used to analyze certain types of games
  * Tic-tac-toe
  * Checkers
  * Chess
  * Nim

\vskip0.5em

* These types of games are called perfect-information games
  * both players know the moves of the other players
  * the state of the game is known by both players
  * No chance involved

# Game Trees

* **Game Trees:** where the vertices represent the positions that a game can be in as it progresses, and the edges represent legal moves.
  * Tend to be very large but can be simplified by combining all symmetric positions into the same node
  * Root node represents the starting position.
  * Even levels are represented by boxes and are the first player's move
  * Odd levels are represented by circles and are the second player's moves
  * We assign values to leaves to represent the payoff to the first player if the game terminates (terminal vertices are represented by boxes)

# The Game of Nim

::: columns
:::: column

* At the start of the game there are a number of piles of stones.

\vskip0.5em

* Players take turns making moves
  * A legal move consists of removing one or more stones from one of the piles, without removing all stones left.
  * A player without a legal move loses

\vskip0.5em

* A game tree for this game is shown

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/trees/nim_game_tree.eps}

::::
:::

# Minmax

* **Definition:** The *value of a vertex in a game tree* is defined recursively as:
  i. the value of a leaf is the payoff to the first player when the game terminates in the position represented by this leaf.
  ii. the value of an internal vertex at an even level is the maximum of the values of its children, and the value of an internal vertex at an odd level is the minimum of the values of its children.

\vskip0.5em

* **Theorem:** The value of a vertex of a game tree tells us the payoff to the first player if both players follow the minmax strategy and play starts from the position represented by this vertex.

\vskip0.5em

* **Minmax Strategy:** where the first player moves to a position represented by a child with maximum value and the send player moves to a position of a child with minimum value.

\vskip0.5em

* Various approaches can be used to devise good strategies
  * *alpha-beta pruning* eliminates computation by pruning portions of game trees based on ancestor vertex values
  * *evaluation functions* to estimate the value of internal vertices

\vskip0.5em

* More information can be learned by studying **combinatorial game theory**

#

\ts{Tree Traversal}

# Preorder Traversal

* **Definition:** Let $T$ be an ordered rooted tree with root $r$. If $T$ consists only of $r$, then $r$ is the **preorder traversal** of $T$. Otherwise, suppose that $T_1, T_2, \ldots, T_n$ are the subtrees at $r$ from left to right in $T$. The **preorder traversal** begins by visiting $r$. It continues by traversing $T_1$ in preorder, then $T_2$ in preorder, and so on, until $T_n$ is traversed in preorder

\centering
\includegraphics[width=.85\textwidth]{images/trees/preorder.eps}

# Examples of Preorder Traversal

\centering
\includegraphics[width=.85\textwidth]{images/trees/preorder_ex.eps}

# Pseudocode of Preorder Traversal

::: columns
:::: column

*Algorithm:*

\vskip.5em

\begin{algorithmic}
\Procedure{preorder}{$T$: ordered rooted tree}
  \State $r \coloneqq$ root of $T$
  \State $list r$
  \For{each child $c$ of $r$ from left to right}
    \State $T(c) \coloneqq$ subtree with $c$ as its root
    \State \Call{preorder}{$T(c)$}
  \EndFor
\EndProcedure
\end{algorithmic}

::::
:::: column

```haskell
preorder :: BinTree a -> [a]
preorder BinLeaf = []
preorder (BinNode x t1 t2) =
  [x] ++ preorder t1 ++ preorder t2
```

::::
:::

# Inorder Traversal

* **Defintion:** Let $T$ be an ordered rooted tree with root $r$. If $T$ consists only of $r$, then $r$ is the **inorder traversal** of $T$. Otherwise, suppose that $T_1, T_2, \ldots, T_n$ are the subtrees at $r$ from left to right. The **inorder traversal** begins by traversing $T_1$ in inorder, then visiting $r$. It continues by traversing $T_2$ in inorder, then $T_3$ in inorder, $\ldots$, and finally $T_n$ in inorder.

\centering
\includegraphics[width=.5\textwidth]{images/trees/inorder.eps}

# Examples of Inorder Traversal

\centering
\includegraphics[width=.85\textwidth]{images/trees/inorder_ex.eps}

# Pseudocode of Inorder Traversal

::: columns
:::: column

*Algorithm:*

\vskip.5em

\begin{algorithmic}
\Procedure{inorder}{$T$: ordered rooted tree}
  \State $r \coloneqq$ root of $T$
  \If{$r$ is a leaf}
    \State $list r$
  \Else
    \State $l \coloneqq$ first child of $r$ from left to right
    \State $T(l) \coloneqq$ subtree with $l$ as its root
    \State \Call{inorder}{$T(l)$}
    \State list $r$
    \For{each child $c$ of $r$ except for $l$ from left to right}
      \State $T(c) \coloneqq$ subtree with $c$ as its root
      \State \Call{inorder}{$T(c)$}
    \EndFor
  \EndIf
\EndProcedure
\end{algorithmic}

::::
:::: column

*Haskell Implementation:*

\vskip.5em

```Haskell
inorder :: BinTree a -> [a]
inorder BinLeaf = []
inorder (BinNode x t1 t2) =
  inorder t1 ++ [x] ++ inorder t2
```

::::
:::

# Postorder Traversal

* **Definition:** Let $T$ be an ordered rooted tree with root $r$. If $T$ consists only of $r$, then $r$ is the **postorder traversal** of $T$. Otherwise, suppose that $T_1, T_2, \ldots, T_n$ are the subtrees at $r$ from left to right in $T$. The **postorder traversal** begins by traversing $T_1$ in postorder, then $T_2$ in postorder, $\ldots$, then $T_n$ in postorder, and end by visiting $r$.

\centering
\includegraphics[width=.5\textwidth]{images/trees/postorder.eps}

# Examples of Postorder Traversal

\centering
\includegraphics[width=.85\textwidth]{images/trees/postorder_ex.eps}

# Pseudocode of Postorder Traversal

::: columns
:::: column

*Algorithm:*

\vskip.5em

\begin{algorithmic}
\Procedure{postorder}{$T$: ordered rooted tree}
  \State $r \coloneqq$ root of $T$
  \For{each child $c$ of $r$ from left to right}
    \State $T(c) \coloneqq$ subtree with $c$ as its root
    \State \Call{postorder}{$T(c)$}
  \EndFor
  \State list $r$
\EndProcedure
\end{algorithmic}

::::
:::: column

*Haskell Implementation:*

\vskip.5em

```haskell
postorder :: BinTree a -> [a]
postorder BinLeaf = []
postorder (BinNode x t1 t2) =
  postorder t1 ++ postorder t2 ++ [x]
```

::::
:::

# Procession Tree Structure

* STDM provides several functions to process a tree, including measuring tree size or the ability to affect its shape

  - `reflect` - takes a binary tree and returns its mirror image

    ```haskell
    reflect :: BinTree a -> BinTree a
    reflect BinLeaf = BinLeaf
    reflect (BinNode n l r) = BinNode n (reflect r) (reflect l)
    ```

  - `height` - measures the height of a tree between its root and its deepest leaf (an empty tree has height zero)

    ```haskell
    height :: BinTree a -> Integer
    height BinLeaf = 0
    height (BinNode x t1 t2) = 1 + max (height t1) (height t2)
    ```

# Procession Tree Structure

* STDM provides several functions to process a tree, including measuring tree size or the ability to affect its shape

  - `size` - calculates the size of a tree, as the number of nodes a tree has

    ```haskell
    size :: BinTree a -> Integer
    size BinLeaf = 0
    size (Node x t1 t2) = 1 + size t1 + size t2
    ```

  - `balanced` - determines if the binary tree is *balanced* or not

    ```haskell
    balanced :: BinTree a -> Bool
    balanced BinLeaf = True
    balanced (BinNode x t1 t2) =
      balanced t1 && balanced t2 && (height t1 == height t2)
    ```
* **Theorem:** Let $h =$ `height` $t$. If `balanced` $t$, then `size` $t = 2^h - 1$

# Evaluating Expression Trees

* Often when working with text we can use trees to represent documents in the language.
* Trees represent the structure of the text while omitting unimportant details
* Examples of this includes programs that manipulate language, as well as compilers and interpreters for programming languages.

# Infix, Prefix, and Postfix Notation

* Examples: infix, prefix, and postfix notations of $a \times b + c$
  * Infix: $a * b + c$ : uses inorder traversal of an expression tree
  * Prefix: $+ * abc$ (also called Polish notation) - uses preorder traversal of an expression tree
  * Postfix: $ab * c +$ - uses postorder traversal of an expression tree

\vskip0.5em

* Represented by ordered rooted trees

\centering
\small

\begin{tikzpicture}
[every node/.style = {line width=0.25mm, align=center, white},]
\node {$+$}
  child {node {$*$} edge from parent [line width=0.25mm, BlueDeFrance]
    child {node {$a$}}
    child {node {$b$}}}
  child {node {$c$} edge from parent [line width=0.25mm, BlueDeFrance]};
\end{tikzpicture}

# Examples of Expression Tree Representation

::: columns
:::: {.column width=.333}

\centering
\small

\begin{tikzpicture}
[every node/.style = {line width=0.25mm, align=center, white},]
\node {$/$} [sibling distance = 30mm]
  child {node {$*$} edge from parent [line width=0.25mm, BlueDeFrance, sibling distance = 15mm]
    child {node {$10$}}
    child {node {$3$}}}
  child {node {$+$} edge from parent [line width=0.25mm, BlueDeFrance, sibling distance = 15mm]
    child {node {$2$}}
    child {node {$1$}}};
\end{tikzpicture}

::::
:::: {.column width=.333}

\centering
\small

\begin{tikzpicture}
[every node/.style = {line width=0.25mm, align=center, white},]
\node {$+$} [sibling distance = 30mm]
  child {node {$*$} edge from parent [line width=0.25mm, BlueDeFrance, sibling distance = 15mm]
    child {node {$10$}}
    child {node {$+$}
      child {node {$2$}}
      child {node {$x$}}}}
  child {node {$+$} edge from parent [line width=0.25mm, BlueDeFrance, sibling distance = 15mm]
    child {node {$1$}}
    child {node {$/$}
      child {node {$8$}}
      child {node {$2$}}}};
\end{tikzpicture}

::::
:::: {.column width=.333}

\centering
\small

\begin{tikzpicture}
[every node/.style = {line width=0.25mm, align=center, white},]
\node {$+$}
  child {node {$x$} edge from parent [line width=0.25mm, BlueDeFrance]}
  child {node {$/$} edge from parent [line width=0.25mm, BlueDeFrance]
    child {node {$y$}}
    child {node {$+$}
      child {node {$x$}}
      child {node {$3$}}}};
\end{tikzpicture}

::::
:::

# Evaluation Expression Trees

* Let's consider the following simple expression language

```haskell
data Exp
  = Const Integer
  | Add Exp Exp
  | Mult Exp Exp
```

* We could then implement a simple programming language interpreter as a tree traversal, The interpretter function `eval`
  takes an expression tree and returns the value it represents

```haskell
eval :: Exp -> Integer
eval (Const n) = n
eval (Add e1 e2) = eval e1 + eval e2
eval (Mult e1 e2) = eval e1 * eval e2
```

#

\ts{Tree Induction}

# Tree Induction

* **Theorem:** _Principle of induction on binary trees_. Let `BinTree a` be a binary tree type as prior defined, and let $P(t)$ be a proposition on trees. Suppose the following two requirements hold:
  * *Base Case:* $P(\texttt{BinLeaf})$
  * *Induction Case:* For all `t1` and `t2` of type `BinTree a`, and all `x :: a`, suppose that the proposition holds for a tree consisting of a node, the value `a`, and the subtrees `t1` and `t2`, provided that the proposition holds for `t1` and `t2`.
    * This can be written as: $P(t_1) \land P(t_2) \to P(\texttt{BinNode x t1 t2})$

  * Then $\forall t \texttt{:: BinTree a}.\,\,P(t)$, thus the proposition holds for all trees of finite size

# Tree Induction Example

\ex Let `t :: BinTree a` be any finite binary tree. Then `length (inorder t) = size t`

\vskip.5em

\prf

::: columns
:::: column

*Base Case:*

```
length (inorder BinLeaf)
  = length []
  = 0
  = size BinLeaf
```

*Inductive Case:*

Assume the induction hypothesis:

```
length (inorder t1) = size t1
length (inorder t2) = size t2
```

::::
:::: column

*Then*

```
length (inorder (BinNode x t1 t2))
  = length (inorder t1 ++ [x] ++ inorder t2)
  = length (inorder t1) + length [x] + length (inorder t2)
  = size t1 + 1 + size t2
  = size (BinNode x t1 t2)
```

Therefore the theorem holds by tree induction

::::
:::

#

\ts{Spanning Trees}

# What is a Spanning Tree

* **Definition:** Let $G$ be a simple graph. A **spanning tree** of $G$ is a subgraph of $G$ that is a tree containing every vertex of $G$.

\centering
\small

**G**

\footnotesize

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (A) [label=above:{a}] {};
\node[main] (B) [right of=A,label=above:{b}] {};
\node[main] (C) [right of=B,label=above:{c}] {};
\node[main] (D) [right of=C,label=above:{d}] {};
\node[main] (E) [below of=A,label=left:{e}] {};
\node[main] (F) [right of=E,label=below:{f}] {};
\node[main] (G) [right of=F,label=right:{g}] {};

\draw [line width=0.25mm, BlueDeFrance] (A) -- (B);
\draw [line width=0.25mm, BlueDeFrance] (A) -- (E);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (G);
\draw [line width=0.25mm, BlueDeFrance] (E) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (E) to [out=315, in=225, looseness=1] (G);
\draw [line width=0.25mm, BlueDeFrance] (F) -- (G);
\end{tikzpicture}

::: columns
:::: {.column width=.333}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (A) [label=above:{a}] {};
\node[main] (B) [right of=A,label=above:{b}] {};
\node[main] (C) [right of=B,label=above:{c}] {};
\node[main] (D) [right of=C,label=above:{d}] {};
\node[main] (E) [below of=A,label=left:{e}] {};
\node[main] (F) [right of=E,label=below:{f}] {};
\node[main] (G) [right of=F,label=right:{g}] {};

\draw [line width=0.25mm, BlueDeFrance] (A) -- (B);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (G);
\draw [line width=0.25mm, BlueDeFrance] (E) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (E) to [out=315, in=225, looseness=1] (G);
\draw [line width=0.25mm, BlueDeFrance] (F) -- (G);
\end{tikzpicture}

::::
:::: {.column width=.333}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (A) [label=above:{a}] {};
\node[main] (B) [right of=A,label=above:{b}] {};
\node[main] (C) [right of=B,label=above:{c}] {};
\node[main] (D) [right of=C,label=above:{d}] {};
\node[main] (E) [below of=A,label=left:{e}] {};
\node[main] (F) [right of=E,label=below:{f}] {};
\node[main] (G) [right of=F,label=right:{g}] {};

\draw [line width=0.25mm, BlueDeFrance] (A) -- (B);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (G);
\draw [line width=0.25mm, BlueDeFrance] (E) to [out=315, in=225, looseness=1] (G);
\draw [line width=0.25mm, BlueDeFrance] (F) -- (G);
\end{tikzpicture}

::::
:::: {.column width=.333}

\centering
\footnotesize

\begin{tikzpicture}
[node distance={10mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (A) [label=above:{a}] {};
\node[main] (B) [right of=A,label=above:{b}] {};
\node[main] (C) [right of=B,label=above:{c}] {};
\node[main] (D) [right of=C,label=above:{d}] {};
\node[main] (E) [below of=A,label=left:{e}] {};
\node[main] (F) [right of=E,label=below:{f}] {};
\node[main] (G) [right of=F,label=right:{g}] {};

\draw [line width=0.25mm, BlueDeFrance] (A) -- (B);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (E) to [out=315, in=225, looseness=1] (G);
\draw [line width=0.25mm, BlueDeFrance] (F) -- (G);
\end{tikzpicture}

::::
:::

\small

* **Theorem:** A simple graph is connected iff it has a spanning tree


# How to Construct Spanning Trees?

Two approaches

* Depth-first search (DFS)
* Breadth-first search (BFS)

# Algorithm: Depth-First Search

* Idea form a rooted tree by arbitrarily selecting a root
  * Form a path by successively adding vertices and edges incident with the last vertex selected
    * Only select those edges/vertices not already in the graph
  * If we can no longer go forward, we backtrack and try again.
  * This process is repeated until all nodes are visited.

\vskip0.5em

* Also called **backtracking** as the algorithm returns to vertices previously visited to add new paths.

\begin{algorithmic}
\Procedure{DFS}{$G$: connected graph with vertices $v_1,v_2,\ldots,v_n$}
  \State $T \coloneqq$ tree consisting only of the vertex $v_1$
  \State \Call{visit}{$v_1$}
\EndProcedure
\Statex

\Procedure{visit}{$v$: vertex of $G$}
\For{each vertex $w$ adjacent to $v$ and not yet in $T$}
  \State add vertex $w$ and edge $\{v, w\}$ to $T$
  \State \Call{visit}{$w$}
\EndFor
\EndProcedure
\end{algorithmic}

# Example of DFS

\centering
\includegraphics[width=.95\textwidth]{images/trees/dfs_ex.eps}

# Backtracking Applications

* Backtracking as used in DFS can also be used as a technique for the exhaustive search of all possible solutions, application of this technique include
  * Graph colorings
  * The $n$-Queens problem
  * Sums of Subsets
* Additionally, we can apply DFS (and of course BFS) in graphs and digraphs. When applied to digraphs some useful applications occur
  * Webcrawlers and Internet Search Engines
* It provides the ability to backtrack and try another path when it is known that the current path will provide no viable solutions.
  * Additionally, another *algorithmic strategy* can be applied called **branch-and-bound**
  * In **branch-and-bound** when we see a similar subtree which has already been shown to been shown that it will not render the optimal solution, rather than continuing down that path, we simply bound over it to the next subtree.

# Breadth-First Search

* Rather than processing all nodes and backtracking when we reach an end, here we instead process each all successive vertices of vertex.

\vskip0.5em

* The idea is as follows: select an arbitrary root
  * Add all edges incident to the selected vertex
  * We then visit each of these nodes in the same way before processing their successive nodes.

# Algorithm: Breadth-First Search

\begin{algorithmic}
\Procedure{BFS}{$G$: connected graph with vertices $v_1,v_2,\ldots,v_n$}
  \State $T \coloneqq$ tree consisting only of the vertex $v_1$
  \State $L \coloneqq$ empty list
  \State put $v_1$ in the list $L$ of unprocessed vertices
  \While{$L$ is not empty}
    \State remove the first vertex, $v$, from $L$
    \For{each neighbor $w$ of $v$ and not yet in $T$}
      \If{$w$ is not in $L$ and not in $T$}
        \State add $w$ to the end of the list $L$
        \State add $w$ and edge $\{v, w\}$ to $T$
      \EndIf
    \EndFor
  \EndWhile
\EndProcedure
\end{algorithmic}

# Example of Breadth-First Search

\centering
\includegraphics[width=.6\textwidth]{images/trees/bfs_ex.eps}

# DFS vs. BFS

* Although we can specify the DFS and BFS algorithms as already stated, we can create a general iterative algorithm for both:

\begin{algorithmic}
\Procedure{generalSearch}{$G$: connected graph with vertices $v_1, v_2, \ldots, v_n$}
  \State $T \coloneqq$ tree consisting only of the vertex $v_1$
  \State $L \coloneqq$ empty list
  \State \Call{enque}{$L$, $v_1$}
  \While{$L$ is not empty}
    \State $v \coloneqq$ \Call{deque}{$L$}
    \For{each neighbor $w$ of $v$ and not yet in $T$}
      \If{$w$ is not in $L$ and not in $T$}
        \State \Call{enque}{$L$, $w$}
        \State add $w$ and edge $\{v, w\}$ to $T$
      \EndIf
    \EndFor
  \EndWhile
\EndProcedure
\end{algorithmic}

# DFS vs. BFS

* For DFS, $L$ is a Stack (LIFO)
  * `enque` is the stack `push` method (adding an item to the front of the list)
  * `deque` is the stack `pop` method (removing the first item from the list)

\vskip0.5em

* For BFS, $L$ is a Queue (FIFO)
  * `enque` is the queue `offer` method (adding an item to the end of the list)
  * `deque` is the queue `poll` method (removing the first item from the list)

#

\ts{Minimum Spanning Trees}

# Minimum Spanning Trees

* If $T$ is a spanning tree in a weighted graph $G(V, E, w)$, the weight of $T$, denoted by $w(T)$, is the sum of weights of edges in $T$.

  $$w(t) = \underset{e \in T}{\sum}w(e)$$

\vskip0.5em

* Given a weighted graph $G(V, E, w)$, the minimum spanning tree problem is to find a spanning tree in $G$ that has the smallest weight

# Cost of a Computer Network

* What is the smallest total cost to maintain a connected network between those five cities?

\vskip.5em
\centering
\small

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (1) [label=left:{San Francisco}] {};
\node[main] (2) [label=below:{Denver}] at (2.5, -1) {};
\node[main] (3) [label=above:{Chicago}] at (3, 1) {};
\node[main] (4) [label=above:{New York}] at (6, 2) {};
\node[main] (5) [label=below:{Atlanta}] at (5.5, -2) {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- node[Olivine, midway, below, sloped] {\$1200} (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- node[Olivine, midway, below, sloped] {\$900} (2);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[Olivine, midway, above, sloped] {\$1300} (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[Olivine, midway, below right, sloped] {\$1600} (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- node[Olivine, midway, above right, sloped] {\$700} (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- node[Olivine, midway, below, sloped] {\$800} (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[Olivine, midway, above, sloped] {\$1400} (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- node[Olivine, midway, above, sloped] {\$1000} (4);
\draw [line width=0.25mm, BlueDeFrance] (1) to [out=45, in=165, looseness=1] node[Olivine, midway, above, sloped] {\$2000} (4);
\draw [line width=0.25mm, BlueDeFrance] (1) to [out=300, in=210, looseness=1] node[Olivine, midway, below, sloped] {\$2200} (5);
\end{tikzpicture}

# Some Spanning Trees

::: columns
:::: column

\small

* $T_1 = \left\{\begin{array}{c}
               \{Chicago, SF\},\,\{Chicago, Denver\},\\
               \{Chicago, Atlanta\},\,\{Chicago, NY\}
               \end{array}\right\}$

  \vskip.5em

  $$\begin{array}{rcl}
  w(T_1) & = & w(\{Chicago, SF\}) + w(\{Chicago, Denver\}) \\
         &   & + w(\{Chicago, Atlanta\}) + w(\{Chicago, NY\}) \\
         & = & \$1200 + \$1300 + \$700 + \$1000 = \$4200
    \end{array}$$

::::
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (1) [label=left:{San Francisco}] {};
\node[main] (2) [label=below:{Denver}] at (2, -1) {};
\node[main] (3) [label=above:{Chicago}] at (2.5, 1) {};
\node[main] (4) [label=above:{New York}] at (5.5, 2) {};
\node[main] (5) [label=below:{Atlanta}] at (5, -2) {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- node[Olivine, midway, below, sloped] {\$1200} (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[Olivine, midway, above, sloped] {\$1300} (3);
\draw [line width=0.25mm, BlueDeFrance] (3) -- node[Olivine, midway, above right, sloped] {\$700} (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- node[Olivine, midway, above, sloped] {\$1000} (4);

\draw [line width=0.25mm, dashed, AshGray] (1) -- node[AshGray, midway, below, sloped] {\$900} (2);
\draw [line width=0.25mm, dashed, AshGray] (2) -- node[AshGray, midway, below right, sloped] {\$1600} (4);
\draw [line width=0.25mm, dashed, AshGray] (4) -- node[AshGray, midway, below, sloped] {\$800} (5);
\draw [line width=0.25mm, dashed, AshGray] (2) -- node[AshGray, midway, above, sloped] {\$1400} (5);
\draw [line width=0.25mm, dashed, AshGray] (1) to [out=45, in=165, looseness=1] node[AshGray, midway, above, sloped] {\$2000} (4);
\draw [line width=0.25mm, dashed, AshGray] (1) to [out=300, in=210, looseness=1] node[AshGray, midway, below, sloped] {\$2200} (5);
\end{tikzpicture}

::::
:::

# Some Spanning Trees

::: columns
:::: column

\small

* $T_2 = \left\{\begin{array}{c}
               \{Chicago, SF\},\,\{SF, Denver\},\\
               \{Chicago, Atlanta\},\,\{Atlanta, NY\}
               \end{array}\right\}$

  \vskip.5em

  $$\begin{array}{rcl}
  w(T_1) & = & w(\{Chicago, SF\}) + w(\{SF, Denver\}) \\
         &   & + w(\{Chicago, Atlanta\}) + w(\{Chicago, NY\}) \\
         & = & \$1200 + \$900 + \$700 + \$800 = \$3600
    \end{array}$$

::::
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (1) [label=left:{San Francisco}] {};
\node[main] (2) [label=below:{Denver}] at (2, -1) {};
\node[main] (3) [label=above:{Chicago}] at (2.5, 1) {};
\node[main] (4) [label=above:{New York}] at (5.5, 2) {};
\node[main] (5) [label=below:{Atlanta}] at (5, -2) {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- node[Olivine, midway, below, sloped] {\$1200} (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- node[Olivine, midway, below, sloped] {\$900} (2);
\draw [line width=0.25mm, BlueDeFrance] (3) -- node[Olivine, midway, above right, sloped] {\$700} (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- node[Olivine, midway, below, sloped] {\$800} (5);

\draw [line width=0.25mm, dashed, AshGray] (2) -- node[AshGray, midway, above, sloped] {\$1300} (3);
\draw [line width=0.25mm, dashed, AshGray] (2) -- node[AshGray, midway, below right, sloped] {\$1600} (4);
\draw [line width=0.25mm, dashed, AshGray] (2) -- node[AshGray, midway, above, sloped] {\$1400} (5);
\draw [line width=0.25mm, dashed, AshGray] (3) -- node[AshGray, midway, above, sloped] {\$1000} (4);
\draw [line width=0.25mm, dashed, AshGray] (1) to [out=45, in=165, looseness=1] node[AshGray, midway, above, sloped] {\$2000} (4);
\draw [line width=0.25mm, dashed, AshGray] (1) to [out=300, in=210, looseness=1] node[AshGray, midway, below, sloped] {\$2200} (5);
\end{tikzpicture}

::::
:::

# Some Spanning Trees

::: columns
:::: column

\small

* $T_3 = \left\{\begin{array}{c}
               \{Chicago, Denver\},\,\{Denver, SF\},\\
               \{Denver, Atlanta\},\,\{Atlanta, NY\}
               \end{array}\right\}$

  \vskip.5em

  $$\begin{array}{rcl}
  w(T_1) & = & w(\{Chicago, Denver\}) + w(\{Denver, SF\}) \\
         &   & + w(\{Denver, Atlanta\}) + w(\{Atlanta, NY\}) \\
         & = & \$1300 + \$900 + \$1400 + \$800 = \$4400
    \end{array}$$

::::
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (1) [label=left:{San Francisco}] {};
\node[main] (2) [label=below:{Denver}] at (2, -1) {};
\node[main] (3) [label=above:{Chicago}] at (2.5, 1) {};
\node[main] (4) [label=above:{New York}] at (5.5, 2) {};
\node[main] (5) [label=below:{Atlanta}] at (5, -2) {};

\draw [line width=0.25mm, BlueDeFrance] (2) -- node[Olivine, midway, above, sloped] {\$1300} (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- node[Olivine, midway, below, sloped] {\$1200} (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[Olivine, midway, above, sloped] {\$1400} (5);
\draw [line width=0.25mm, BlueDeFrance] (4) -- node[Olivine, midway, below, sloped] {\$800} (5);

\draw [line width=0.25mm, dashed, AshGray] (1) -- node[AshGray, midway, below, sloped] {\$900} (2);
\draw [line width=0.25mm, dashed, AshGray] (2) -- node[AshGray, midway, below right, sloped] {\$1600} (4);
\draw [line width=0.25mm, dashed, AshGray] (3) -- node[AshGray, midway, above right, sloped] {\$700} (5);
\draw [line width=0.25mm, dashed, AshGray] (3) -- node[AshGray, midway, above, sloped] {\$1000} (4);
\draw [line width=0.25mm, dashed, AshGray] (1) to [out=45, in=165, looseness=1] node[AshGray, midway, above, sloped] {\$2000} (4);
\draw [line width=0.25mm, dashed, AshGray] (1) to [out=300, in=210, looseness=1] node[AshGray, midway, below, sloped] {\$2200} (5);
\end{tikzpicture}

::::
:::

* Problem: Which one is the one with the smallest weight among all possible spanning trees?

# Prim's Algorithm

\begin{algorithmic}
\Procedure{Prim}{$G$: weighted connected undirected graph with $n$ vertices}
  \State $T \coloneqq$ a minimum-weighted edge
  \For{$i \coloneqq 1$ \textbf{to} $n - 2$}
    \State $e \coloneqq$ an edge of minimum weight incident to a vertex in $T$ and not forming a simple circuit
    \State in $T$ if added to $T$
    \State $T \coloneqq T$ with $e$ added
  \EndFor
  \State \{$T$ is a minimum spanning tree of $G$\}
\EndProcedure
\end{algorithmic}

# An Example of Prim's Algorithm

\vfill

::: columns
:::: column

\centering
\footnotesize

+-----------------------+----------------------+----------+
| **Choice**            | **Edge**             | **Cost** |
+:=====================:+:=====================+=========:+
| \color{BlueDeFrance}1 | \{Atlanta, Chicago\} | \$700    |
+-----------------------+----------------------+----------+
| \color{FireOpal}2     | \{Atlanta, NY\}      | \$800    |
+-----------------------+----------------------+----------+
| \color{Amethyst}3     | \{Chicago, SF\}      | \$900    |
+-----------------------+----------------------+----------+
| \color{Jasmine}4      | \{Denver, SF\}       | \$1200   |
+-----------------------+----------------------+----------+
|                       | **Total**            | \$3600   |
+-----------------------+----------------------+----------+

::::
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (1) [label=left:{San Francisco}] {};
\node[main] (2) [label=below:{Denver}] at (1.5, -.75) {};
\node[main] (3) [label=above:{Chicago}] at (2, .75) {};
\node[main] (4) [label=above:{New York}] at (5, 1.5) {};
\node[main] (5) [label=below:{Atlanta}] at (4.5, -1.5) {};

\draw [line width=0.25mm, BlueDeFrance] (3) -- node[Olivine, midway, above right, sloped] {\$700} (5);
\draw [line width=0.25mm, FireOpal] (4) -- node[Olivine, midway, below, sloped] {\$800} (5);
\draw [line width=0.25mm, Amethyst] (1) -- node[Olivine, midway, below, sloped] {\$1200} (3);
\draw [line width=0.25mm, Jasmine] (1) -- node[Olivine, midway, below, sloped] {\$900} (2);

\draw [line width=0.25mm, dashed, AshGray] (2) -- node[AshGray, midway, above, sloped] {\$1300} (3);
\draw [line width=0.25mm, dashed, AshGray] (2) -- node[AshGray, midway, below right, sloped] {\$1600} (4);
\draw [line width=0.25mm, dashed, AshGray] (2) -- node[AshGray, midway, above, sloped] {\$1400} (5);
\draw [line width=0.25mm, dashed, AshGray] (3) -- node[AshGray, midway, above, sloped] {\$1000} (4);
\draw [line width=0.25mm, dashed, AshGray] (1) to [out=45, in=165, looseness=1] node[AshGray, midway, above, sloped] {\$2000} (4);
\draw [line width=0.25mm, dashed, AshGray] (1) to [out=300, in=210, looseness=1] node[AshGray, midway, below, sloped] {\$2200} (5);
\end{tikzpicture}

::::
:::

# Kruskal's Algorithm

\begin{algorithmic}
\Procedure{Kruskal}{$G$: weighted connected undirected graph with $n$ vertices}
  \State $T \coloneqq$ empty graph
  \For{$i \coloneqq 1$ \textbf{to} $n - 1$}
    \State $e \coloneqq$ an edge in $G$ with smallest weight that does not form a simple circuit when added to $T$
    \State $T \coloneqq T$ with $e$ added
  \EndFor
  \State \{$T$ is a minimum spanning tree of $G$\}
\EndProcedure
\end{algorithmic}

# An Example of Kruskal's Algorithm

* First, sort all edges based on their weight in ascending order.
  * \{Atlanta, Chicago\}, \{Atlanta, NY\}, \{Denver, SF\}, \{Chicago, NY\}, \{Chicago, SF\}, \{Chicago, Denver\}, \{Atlanta, Denver\}, \{Denver, NY\}, \{NY, SF\}, \{Atlanta, SF\}

\vskip0.5em

* Examine each edge one by one until a spanning tree is constructed

::: columns
:::: column

\centering
\footnotesize

+-----------------------+----------------------+----------+
| **Choice**            | **Edge**             | **Cost** |
+:=====================:+:=====================+=========:+
| \color{BlueDeFrance}1 | \{Atlanta, Chicago\} | \$700    |
+-----------------------+----------------------+----------+
| \color{FireOpal}2     | \{Atlanta, NY\}      | \$800    |
+-----------------------+----------------------+----------+
| \color{Amethyst}3     | \{Denver, SF\}       | \$900    |
+-----------------------+----------------------+----------+
| \color{Jasmine}4      | \{Chicago, SF\}      | \$1200   |
+-----------------------+----------------------+----------+
|                       | **Total**            | \$3600   |
+-----------------------+----------------------+----------+

::::
:::: column

\centering
\footnotesize

\begin{tikzpicture}
[node distance={30mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (1) [label=left:{San Francisco}] {};
\node[main] (2) [label=below:{Denver}] at (1.5, -.75) {};
\node[main] (3) [label=above:{Chicago}] at (2, .75) {};
\node[main] (4) [label=above:{New York}] at (5, 1.5) {};
\node[main] (5) [label=below:{Atlanta}] at (4.5, -1.5) {};

\draw [line width=0.25mm, BlueDeFrance] (3) -- node[Olivine, midway, above right, sloped] {\$700} (5);
\draw [line width=0.25mm, FireOpal] (4) -- node[Olivine, midway, below, sloped] {\$800} (5);
\draw [line width=0.25mm, Amethyst] (1) -- node[Olivine, midway, below, sloped] {\$900} (2);
\draw [line width=0.25mm, Jasmine] (1) -- node[Olivine, midway, below, sloped] {\$1200} (3);

\draw [line width=0.25mm, dashed, AshGray] (2) -- node[AshGray, midway, above, sloped] {\$1300} (3);
\draw [line width=0.25mm, dashed, AshGray] (2) -- node[AshGray, midway, below right, sloped] {\$1600} (4);
\draw [line width=0.25mm, dashed, AshGray] (2) -- node[AshGray, midway, above, sloped] {\$1400} (5);
\draw [line width=0.25mm, dashed, AshGray] (3) -- node[AshGray, midway, above, sloped] {\$1000} (4);
\draw [line width=0.25mm, dashed, AshGray] (1) to [out=45, in=165, looseness=1] node[AshGray, midway, above, sloped] {\$2000} (4);
\draw [line width=0.25mm, dashed, AshGray] (1) to [out=300, in=210, looseness=1] node[AshGray, midway, below, sloped] {\$2200} (5);
\end{tikzpicture}

::::
:::

# Finding a Spanning Tree with Minimum Weight

\centering
\small

\begin{tikzpicture}
[node distance={25mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (1) [label=above:{a}] {};
\node[main] (2) [right of=1,label=above:{b}] {};
\node[main] (3) [right of=2,label=above:{c}] {};
\node[main] (4) [right of=3,label=above:{d}] {};
\node[main] (5) [below of=1,label=left:{e}] {};
\node[main] (6) [right of=5,label=above left:{f}] {};
\node[main] (7) [right of=6,label=above left:{g}] {};
\node[main] (8) [right of=7,label=right:{h}] {};
\node[main] (9) [below of=5,label=below:{i}] {};
\node[main] (10) [right of=9,label=below:{j}] {};
\node[main] (11) [right of=10,label=below:{k}] {};
\node[main] (12) [right of=11,label=below:{l}] {};

\draw [line width=0.25mm, BlueDeFrance] (1) -- node[Amethyst, midway, above] {2} (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- node[Amethyst, midway, left] {3} (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[Amethyst, midway, above] {3} (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- node[Amethyst, midway, left] {3} (6);
\draw [line width=0.25mm, BlueDeFrance] (3) -- node[Amethyst, midway, above] {1} (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- node[Amethyst, midway, left] {3} (7);
\draw [line width=0.25mm, BlueDeFrance] (4) -- node[Amethyst, midway, right] {5} (8);

\draw [line width=0.25mm, BlueDeFrance] (5) -- node[Amethyst, midway, above] {4} (6);
\draw [line width=0.25mm, BlueDeFrance] (5) -- node[Amethyst, midway, left] {4} (9);
\draw [line width=0.25mm, BlueDeFrance] (6) -- node[Amethyst, midway, above] {3} (7);
\draw [line width=0.25mm, BlueDeFrance] (6) -- node[Amethyst, midway, left] {3} (10);
\draw [line width=0.25mm, BlueDeFrance] (7) -- node[Amethyst, midway, above] {3} (8);
\draw [line width=0.25mm, BlueDeFrance] (7) -- node[Amethyst, midway, left] {1} (11);
\draw [line width=0.25mm, BlueDeFrance] (8) -- node[Amethyst, midway, right] {3} (12);

\draw [line width=0.25mm, BlueDeFrance] (9) -- node[Amethyst, midway, above] {3} (10);
\draw [line width=0.25mm, BlueDeFrance] (10) -- node[Amethyst, midway, above] {3} (11);
\draw [line width=0.25mm, BlueDeFrance] (11) -- node[Amethyst, midway, above] {1} (12);


\end{tikzpicture}

# Finding a Spanning Tree with Minimum Weight

\centering
\small

\begin{tikzpicture}
[node distance={25mm},main/.style = {draw=white, fill=AshGray, circle, line width=0.25mm}]

\node[main] (1) [label=above:{a}] {};
\node[main] (2) [right of=1,label=above:{b}] {};
\node[main] (3) [right of=2,label=above:{c}] {};
\node[main] (4) [right of=3,label=above:{d}] {};
\node[main] (5) [below of=1,label=left:{e}] {};
\node[main] (6) [right of=5,label=above left:{f}] {};
\node[main] (7) [right of=6,label=above left:{g}] {};
\node[main] (8) [right of=7,label=right:{h}] {};
\node[main] (9) [below of=5,label=below:{i}] {};
\node[main] (10) [right of=9,label=below:{j}] {};
\node[main] (11) [right of=10,label=below:{k}] {};
\node[main] (12) [right of=11,label=below:{l}] {};

\draw [line width=0.25mm, FireOpal] (1) -- node[Amethyst, midway, above] {2} (2);
\draw [line width=0.25mm, FireOpal] (1) -- node[Amethyst, midway, left] {3} (5);
\draw [line width=0.25mm, FireOpal] (2) -- node[Amethyst, midway, above] {3} (3);
\draw [line width=0.25mm, FireOpal] (2) -- node[Amethyst, midway, left] {3} (6);
\draw [line width=0.25mm, FireOpal] (3) -- node[Amethyst, midway, above] {1} (4);
\draw [line width=0.25mm, FireOpal] (3) -- node[Amethyst, midway, left] {3} (7);
\draw [line width=0.25mm, AshGray, dashed] (4) -- node[Amethyst, midway, right] {5} (8);

\draw [line width=0.25mm, AshGray, dashed] (5) -- node[Amethyst, midway, above] {4} (6);
\draw [line width=0.25mm, AshGray, dashed] (5) -- node[Amethyst, midway, left] {4} (9);
\draw [line width=0.25mm, AshGray, dashed] (6) -- node[Amethyst, midway, above] {3} (7);
\draw [line width=0.25mm, FireOpal] (6) -- node[Amethyst, midway, left] {3} (10);
\draw [line width=0.25mm, FireOpal] (7) -- node[Amethyst, midway, above] {3} (8);
\draw [line width=0.25mm, FireOpal] (7) -- node[Amethyst, midway, left] {1} (11);
\draw [line width=0.25mm, AshGray, dashed] (8) -- node[Amethyst, midway, right] {3} (12);

\draw [line width=0.25mm, FireOpal] (9) -- node[Amethyst, midway, above] {3} (10);
\draw [line width=0.25mm, AshGray, dashed] (10) -- node[Amethyst, midway, above] {3} (11);
\draw [line width=0.25mm, FireOpal] (11) -- node[Amethyst, midway, above] {1} (12);


\end{tikzpicture}

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
