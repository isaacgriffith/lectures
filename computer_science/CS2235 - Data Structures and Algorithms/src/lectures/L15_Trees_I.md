---
author:
- Isaac Griffith
title: Trees I
institute: |
  CS 2235

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

#

\vfill
\centering
\Huge Trees I

# Outcomes

At the end of Today's Lecture you will be able to:

* Understand the basic concepts of trees
* Understand the terminology surrounding trees

# Tree ADT

* A tree is a structure for storing elements hierarchically
\pause
* Course Organization Tree:

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree01.eps}
\end{center}

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree02.eps}
\end{center}

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree03.eps}
\end{center}

**Node**: The entries that make up the tree (the boxes).

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree04.eps}
\end{center}

**Parent**: For a given node, its parent is the node that directly precedes it in the hierarchy

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree05.eps}
\end{center}

**Parent**: For a given node, its parent is the node that directly precedes it in the hierarchy

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree06.eps}
\end{center}

**Parent**: For a given node, its parent is the node that directly precedes it in the hierarchy

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree07.eps}
\end{center}

**Parent**: For a given node, its parent is the node that directly precedes it in the hierarchy

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree08.eps}
\end{center}

Every node in the tree, except the **top node**, has a parent.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree09.eps}
\end{center}

Nodes may not have multiple parents.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree10.eps}
\end{center}

Nodes may not have multiple parents. That is no longer a tree, it is called a graph.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree11.eps}
\end{center}

**Child**: For a given node, its children are the node(s) that directly follow it in the hierarchy.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree12.eps}
\end{center}

**Child**: For a given node, its children are the node(s) that directly follow it in the hierarchy.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree13.eps}
\end{center}

**Child**: For a given node, its children are the node(s) that directly follow it in the hierarchy.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree14.eps}
\end{center}

The definition of "child" and "parent" are more or less reversed.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree16.eps}
\end{center}

From the definitions, there are two node types:

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree17.eps}
\end{center}

From the definitions, there are two node types:

1. **Internal nodes** are nodes with children

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree18.eps}
\end{center}

From the definitions, there are two node types:

2. **Leaf nodes** are nodes without children

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree19.eps}
\end{center}

Also, the **root** is the top-most node (the only one with no parent).

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree20.eps}
\end{center}

**Edge**: A pair of nodes such that one is the parent of the other.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree21.eps}
\end{center}

**Edge**: A pair of nodes such that one is the parent of the other. (denoted by the line).

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree22.eps}
\end{center}

**Edge**: A pair of nodes such that one is the parent of the other. (denoted by the line).

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree23.eps}
\end{center}

There is no edge between nodes that are not direct parent-child related.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree23.eps}
\end{center}

**Path**: A sequence of nodes such that any two consecutive nodes form an edge.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree24.eps}
\end{center}

Path Example: How do I get to Instructions.pdf?

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree25.eps}
\end{center}

Path Example: How do I get to Instructions.pdf?

* CS 2235 -> Assignments -> PA05 -> Instructions.pdf

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree27.eps}
\end{center}

**Depth**: For a given node, its depth is the number of nodes in the path back to the root.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree26.eps}
\end{center}

**Depth**: For a given node, its depth is the number of nodes in the path back to the root.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree28.eps}
\end{center}

Depth Example: L30 is at depth 2. (Don't count the given node in the node count.)

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree29.eps}
\end{center}

Depth Example.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree30.eps}
\end{center}

**Height**: The height of a tree is the maximum depth of any of its nodes.

# Definitions

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree30.eps}
\end{center}

Height Example: The height of this tree is 3

# Tree Operations

* What kinds of operations do you think we will need to do on a tree?
\pause
  - Insert a node.
  - Remove a node.
  - Get the children of a node.
  - Get the parent of a node.
  - Some sort of a traversal/search.
  - Get depth/height.
  - ...

# Tree Operations

* What kinds of operations do you think we will need to do on a tree?
  - Insert a node.
  - Remove a node.
  - **Get the children of a node.**
  - **Get the parent of a node.**
  - **Some sort of a traversal/search.**
  - **Get depth/height.**
  - ...

* **Some** of these operations don't depend on the purpose of the tree

# Tree Operations

* What kinds of operations do you think we will need to do on a tree?
  - **Insert a node.**
  - **Remove a node.**
  - Get the children of a node.
  - Get the parent of a node.
  - **Some sort of a traversal/search.**
  - Get depth/height.
  - ...

* **Some** of these operations have implementations that depend on what the tree is supposed to do. We will look at several over the next few lectures.

# Binary Tree

* A Binary Tree is a tree with the following properties:
  1. There is an explicit order of the children of each node. (e.g. child 1, child 2, ...). This is called an ordered tree.
  \pause
  2. Every node has at most two children (hence the name "binary").

# Binary Tree

* A Binary Tree is a tree with the following properties:
  1. There is an explicit order of the children of each node. (e.g. child 1, child 2, ...). This is called an ordered tree.
  2. Every node has at most two children (hence the name "binary"). The children are called the left child and right child.

\begin{center}
\includegraphics[width=.33\textwidth]{images/Module4/Trees/tree32.eps}
\end{center}

# Binary Tree

* A Binary Tree is a tree with the following properties:
  1. There is an explicit order of the children of each node. (e.g. child 1, child 2, ...). This is called an ordered tree.
  2. Every node has at most two children (hence the name "binary"). The children are called the left child and right child. The binary tree is called **full** if each internal node has exactly two children.

# Binary Tree

\begin{center}
\includegraphics[width=.5\textwidth]{images/Module4/Trees/tree33.eps}
\end{center}

\begin{center}
\Huge Not Full.
\end{center}

# Binary Tree

\begin{center}
\includegraphics[width=.5\textwidth]{images/Module4/Trees/tree34.eps}
\end{center}

\begin{center}
\Huge Full.
\end{center}

# Binary Tree Properties

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Trees/tree35.eps}
\end{center}

# Binary Tree Properties

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Trees/tree36.eps}
\end{center}

So in general, at dept d, there are at most __ nodes.

# Binary Tree Properties

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/tree37.eps}
\end{center}

So in general, at depth d, there are at most $2^d$ nodes.

# Binary Tree Properties

* If we had a binary tree with n elements, what is the most number of edges we would have to traverse to go from the root to a leaf?

# Binary Tree Properties

* If we had a binary tree with n elements, what is the most number of edges we would have to traverse to go from the root to a leaf? n - 1

\begin{center}
\includegraphics[width=.05\textwidth]{images/Module4/Trees/tree38.eps}
\end{center}

# Binary Tree Properties

* If we had a binary tree with n elements, what is the most number of edges we would have to traverse to go from the root to a leaf? (Officially it is called complete, but don't worry about that right now.)

\begin{center}
\includegraphics[width=.15\textwidth]{images/Module4/Trees/tree39.eps}
\end{center}

# Binary Tree Properties

* If we had a binary tree with n elements, what is the most number of edges we would have to traverse to go from the root to a leaf? (Officially it is called complete, but don't worry about that right now.)

\begin{center}
\includegraphics[width=.5\textwidth]{images/Module4/Trees/tree40.eps}
\end{center}

# Binary Tree Properties

* If we had a binary tree with n elements, what is the most number of edges we would have to traverse to go from the root to a leaf? (Officially it is called complete, but don't worry about that right now.)

\begin{center}
\includegraphics[width=.35\textwidth]{images/Module4/Trees/tree41.eps}
\end{center}

Well, the maximum number of edges to access a leaf is actually the height of the tree.

# Binary Tree Properties

* What if the binary tree with n elements, looked like this? (Officially it is called complete, but don't worry about that right now.)

\begin{center}
\includegraphics[width=.35\textwidth]{images/Module4/Trees/tree42.eps}
\end{center}

Well, the maximum number of edges to access a leaf is actually the height of the tree.

So, $n = 2^1 + 2^2 + 2^3 + \ldots + 2^h$, where $h$ is the tree height.

# Binary Tree Properties

* What if the binary tree with n elements, looked like this? (Officially it is called complete, but don't worry about that right now.)

  - $n = 2^1+2^2+2^3+\ldots+2^h$, where h is the tree height.

  - Now we need to solve for $h$, so we can say the maximum number of edges needed to access a leaf (h) is some function of $n$.

  - We can condense the right hand side since it is a geometric series. Thus:

    $n = 2^{h + 1} - 1$
  \pause
  - Take the log (base 2) to free the h,

    $log(n + 1) = h + 1$
  \pause
  - So, $h = \log(n + 1) - 1$ which is $O(\log(n))$. (proof left up to you)

# Binary Tree Properties

* What does this mean?
  - It means that we can access any node in a specific type of binary tree in $\log(n)$ time.
\pause
* Why does that matter?
\pause
  - We'll find out...

#

\vfill
\centering

\Huge File Tree

# File Tree

Goal: To build a tree that represents a file system that operates in a similar fashion as many OS command-line interfaces.

# Example File Tree

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Trees/ft01.eps}
\end{center}

\pause

* How could we represent this for a computer?
  \pause

  1. Nodes and pointers.
  \pause

  2. Probably some way with array(s). \scriptsize (likely complicated)

# Example File Tree

::: columns
:::: {.column width=.7}
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/Trees/ft01.eps}
\end{center}
::::
:::: {.column width=.3}

**Node Data (Instance Variables)?**
\pause

1. Value (file name)
2. Parent?
3. Children?

::::
:::

# Example File Tree

::: columns
:::: {.column width=.7}
\only<1>{
  \begin{center}
  \includegraphics[width=.95\textwidth]{images/Module4/Trees/ft01.eps}
  \end{center}
}
\only<2>{
  \begin{center}
  \includegraphics[width=.95\textwidth]{images/Module4/Trees/ft02.eps}
  \end{center}
}
::::
:::: {.column width=.3}

**Tree Data (Instance Variables)?**
\pause

1. \color{SeaGreen} Root pointer?
2. \color{CornflowerBlue} Current file pointer?

::::
:::

# Example File Tree

::: columns
:::: {.column width=.7}
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/Trees/ft03.eps}
\end{center}
::::
:::: {.column width=.3}

**Tree Operations (Methods)?**
\pause

1. Move down one.
2. Move up one.
3. Go to home file.
4. Get children.
5. Get location path.
6. Insert file.
7. Remove file.

::::
:::

#

\vfill
\centering
\Huge Lets see the code!

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Review prior lectures
* Finish PA 01 (due Monday 10/07)
* Read/Review Ch 8 Sections 1 - 4
* Come to Class
