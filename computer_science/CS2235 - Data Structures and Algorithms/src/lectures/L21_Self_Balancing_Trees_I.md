---
author:
- Isaac Griffith
title: Self Balancing Search Trees I
institute: |
  CS 2235

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Objectives

1. Review midterm
2. Cover Self-Balancing Tree Concepts
3. Cover Red-Black Trees

# Binary Search Trees

* Recall that a **binary search tree** is a binary tree in which every node holds a value >= every value in its left subtree and <= every value in its right subtree.

\centering
\includegraphics[width=.4\textwidth]{images/Module4/RBTree/bst1.png}

# Binary Search Trees

BSTs can be used for:

* **Sorting**: just traverse inorder!
* **Searching** (implementing sets and dictionaries): while searching in a linked list is O(n), searching a randomly generated BST is, on average, O(log n)

# Binary Search Trees

However, not every BST gives logarithmic search performance:

\begin{center}
\includegraphics[width=.5\textwidth]{images/Module4/RBTree/bst2.png}
\end{center}

# Rotations

To deal with the problem of "degenerate" (tall and thin) trees, we define rotation operations.

\centering
\includegraphics[width=.35\textwidth]{images/Module4/RBTree/rotate.png}

# Rotations

In general

\centering
\includegraphics[width=.4\textwidth]{images/Module4/RBTree/rotate2.png}

# Rotations

There are many different strategies for applying rotations.

* Generally you'll want to rotate after any insertion or deletion, which causes the tree to grow "too tall"
  * **AVL** and **Red-Black** trees do this.

* Another approach is to constantly rotate after every insertion, deletion, and lookup so as to bubble the most likely to be looked up elements near the top.
  * **Splay Trees** do this.

#

\vfill
\centering
\huge Red Black Trees

# Definition

A **red-black tree** is a binary search tree in which each node is colored red or black such that

* The root is black
* The children of a red node are black
* Every path from the root to a 0-node or a 1-node has the same number of black nodes.

# Example

\centering
\includegraphics[width=.6\textwidth]{images/Module4/RBTree/rb1.png}

# Definition

Red black trees do not necessarily have minimum height, but they never get really bad.

The height is never greater than $2 \log_{2}(n)$, where $n$ is the number of nodes.

# Overview

* Red Black Trees are Awesome
  * An online, interactive, animation app that will teach you *how* they work, is [here](http://www.cs.armstrong.edu/liang/animation/web/RBTree.html)
* Red Black Trees are Useful
  * Red Black trees are used in many libraries as the foundations for sets and dictionaries
  * They are used to implement the `TreeSet` and `TreeMap` classes in the Java Collections API, as well as the Standard C++ sets and maps.

# How They Work

**Lookup**

* A red black tree is a BST.
* Lookup in an RBT is just the same lookup as in a BST.
* The colors don't matter.


# How They Work

**Insertion**

The Algorithm has three steps

1. Insert as you would into a BST, coloring the node red.
2. If the parent of the node you just inserted was red. you have a double-red problem which you must correct.
3. Color the root node black.

A double red problem is corrected with **zero or more recolorings followed by zero or more restructurings**


# Recoloring

Recolor whenever the *sibling of a red node's red parent is red:*

\centering
\includegraphics[width=.75\textwidth]{images/Module4/RBTree/rb2.png}

# Insertion Restructuring

**Case 1: The sibling s of y is Black**

* The double red is due to the addition of a new red node, x, whose parent, y, and whose grand-parent, z, is black.
* We also know that y has a sibling, s, that is black. What we want is for the two red nodes to be siblings.

**Correction**

* Relabel x, y, and z as a, b, and c (in left-to-right order)
* Replace z with the node labeled b, and make nodes a and c the children of b, keeping inorder relationships unchanged.

# Insertion Restructuring

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/RBTree/insert-case1.eps}
\end{center}

# Insertion Restructuring

\begin{center}
\includegraphics[width=.33\textwidth]{images/Module4/RBTree/insert-case1-result.eps}
\end{center}

# Insertion Restructuring

**Case 2: The Sibling of s of y is Red**

* Here the double red denotes an overflow in the tree

**Correction**

* To fix this problem we do a *recoloring* where we color y and s black and their parent z red (unless z is the root).
* If the double red problem reappears at z, then we repeat the consideration of the two cases at z.
* This problem continues up the tree until the problem is resolved.

# Insertion Recoloring

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/RBTree/insert-case2-recolor.eps}
\end{center}

# Restructuring

Restructure whenever *the red child's red parent's sibling is black or null*. There are four cases:

* Right
* Left
* Right-Left
* Left-Right

When you restructure, the root of the restructured subtree is colored black and its children are colored red.

# Resturcturing

\centering
\includegraphics[width=.4\textwidth]{images/Module4/RBTree/rb3.png}

# Deletion

* Deletion from an RB tree proceeds initially as with a BST.
  - Search to find the node that is to be deleted.
  - If internal, then promote a child node

* Then we need to consider the ramifications to the red-black properties.
  - If a black node is removed then it either had two external children, or one red child with two external children.
  - In the latter case, restore by recoloring the promoted child to black.
  - In the other case, we can get a double-black problem.
  - The remedy has three cases

# Restructuring after Deletion

**Case 1: The sibling y of p is Black and has a Red Child x**

* Do a restructuring.

\begin{center}
\includegraphics[width=.45\textwidth]{images/Module4/RBTree/delete-case1.eps}
\end{center}

# Restructuring after Deletion

**Case 2: The Sibling y of p is Black and Both Children of y are Black**

* Do a recoloring.

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/RBTree/delete-case2.eps}
\end{center}

# Restructuring after Deletion

**Case 3: Sibling y of p is Red**

* Do a restructuring

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/RBTree/delete-case3.eps}
\end{center}

# Red-Black Tree Performance

* Insertion?
* Deletion?

# Red-Black Tree Performance

* Insertion:
  - Inserting an element: O(log n)
  - O(log n) recolorings
  - 1 Restructuring
* Deletion?

# Red-Black Tree Performance

* Insertion:
  - Inserting an element: O(log n)
  - O(log n) recolorings
  - 1 Restructuring (at most)
* Deletion:
  - Deleting an element: O(log n)
  - O(log n) recolorings
  - 2 Restructurings (at most)

#

\vfill
\centering
\Huge
Implementation

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
