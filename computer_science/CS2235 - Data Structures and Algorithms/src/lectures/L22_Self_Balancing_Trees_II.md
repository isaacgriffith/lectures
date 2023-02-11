---
author:
- Isaac Griffith
title: Self-Balancing Trees II
institute: |
  CS 2235

  Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Objectives

* Continuation of Self-Balanced Search Trees
  * Deeper Discussion on Rotations
  * Discuss Splay Trees
  * B-Trees
  * Discuss when to use different SBSTs

#

\vfill
\centering
\Huge Recap

# A Deeper Look at Rotations

A Rotation is:

1. A local operation changing $O(1)$ references

2. An in-order search tree before a rotation *stays* an in-order search tree

3. In a rotation, one subtree gets one level closer to the root, and one subtree gets one level further from the root.

# Rotations

::: columns

:::: column
**Left Rotation**

Makes the right child *y* of a node *x* into *x's* parent; *x* becomes the left child of *y*

\centering
\includegraphics[width=.75\textwidth]{images/Module4/RBTree/left_rotate.eps}

::::
:::: column
**Right Rotation**

Makes the left child *x* of a node *y* into *y's* parent; *y* becomes the right child of *x*

\centering
\includegraphics[width=.75\textwidth]{images/Module4/RBTree/right_rotate.eps}

::::
:::

# Think Pair Share
 \begin{minipage}{50pt}
  \includegraphics[width=50pt]{images/5-minutes.png}
 \end{minipage}
 \begin{minipage}[adjusting]{4in}
 Take 2 minutes and think about the following question:
 \end{minipage}
 \vskip1em
 \begin{minipage}{50pt}
  \includegraphics[width=50pt]{images/brainstorming.png}
 \end{minipage}
 \begin{minipage}[adjusting]{4in}
 Given what we know about trees (BST's in particular) and sorting, how would we implement TreeSort?
 \end{minipage}
 \vskip1em
 \begin{minipage}{50pt}
  \includegraphics[width=50pt]{images/idea.png}
 \end{minipage}
 \begin{minipage}[adjusting]{4in}
 Pair up with your neighbor and take the next few minutes to discuss your thoughts.
 \end{minipage}

# Splay Trees

**Definition**: A **Splay tree** is a **binary search tree** that self adjusts after lookup, insert, and delete operations.

* Performs well when some data is accessed more often than others

**Note:** A splay tree does not have a minimum height, nor a logarithmically bounded height.

* It may even be degenerate.
* But, it works well as it keeps most commonly used data near the top

# How It Works

After each insert, delete, or lookup, you **splay**:

* The node you just looked up, or
* The node you just inserted, or
* The parent of the node you just deleted

# Splaying

The splay operation on a node N is as follows:

\tiny
\DontPrintSemicolon
\SetAlgoLined
\While{N is not the root}{
  \eIf{N is a child of the root}{
    // ZIG\;

    Rotate about the root to bring N to the root\;
  }{
    P := N.parent\;

    G := P.parent\; // grandparent of N

    \eIf{N and P are both left or both right children}{
      // ZIG-ZIG

      Rotate about G then about P to bring N up 2 levels\;
    }{
      // ZIG-ZAG:

      Rotate about P then about G to bring N up 2 levels\;
    }
  }
}


# Splaying

\vfill
\centering
\includegraphics[width=.75\textwidth]{images/Module4/SplayTree/splay1.png}

# Splaying

\vfill
\centering
\includegraphics[width=.75\textwidth]{images/Module4/SplayTree/splay2.png}

# (a,b) Trees

**Definition**: An **(a,b) tree** is a **balanced** search tree in which:

* $2\leq a \leq (b + 1) / 2$
* Each internal node (excluding the root) has:
  * at least $a$ children
  * at most $b$ children

An example of a (2,4)-tree:
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/ABTree/abtree1.png}

# (a,b) Trees

* Data is only stored in the internal nodes
* External nodes act as placeholders
* All external nodes have the same depth

* (a,b) Trees are basically the application of general trees to search

# How They Work

**Lookup**

* Proceeds as in any search tree

**Insertion**

1. Add into the proper leaf node.
2. If addition causes an overflow (b items)
    * Split and propagate the middle item

# How They Work

**Deletion**

* If item to delete is not in a leaf node
  * bring its predecessor up into its space
  * delete the predecessor item from its leaf node

* This may require **transfers** and **fusions**
  * **Transfer**: is the movement of an item up or down in the tree
  * **Fusion** is the combining of one or more nodes into a single node
    * Fusions can cause underflow in the parent
    * Thus, this process has to be repeated up the tree

# Insertion

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/ABTree/insert1.png}
\end{center}

# Insertion

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/ABTree/insert2.png}
\end{center}

# Deletion

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/ABTree/delete1.png}
\end{center}

# Deletion

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/ABTree/delete2.png}
\end{center}

# Performance

* Insertion: O(log n)
* Search: O(log n)
* Deletion: O(log n)
* Split,transfer,fusion: O(1)
* Height of tree with n entries: O(log n)

# B and B+ Trees

A B-Tree is an (a,b)-tree with $a = \lceil (b/2) \rceil$

The following are B-Trees:

* (2,3)-tree
* (2,4)-tree
* (3,5)-tree

A **B+ Tree** is a specific variation of the B-tree.

* All elements are stored in the leaves
* Internal nodes repeat keys as necessary
* Leaf nodes are chained together
  * Provides rapid access to entire collection in sorted order

# B+ Tree Example

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/ABTree/bplustree.png}
\end{center}

# SBT's and When to Use Them

**Red-Black Tree**

* Insertion (worst-case): $O(1)$
* Max Height: $2\log(n)$
* Search (worst-case): $O(\log n)$
* Deletion: $O(\log n)$
* Used For: Universal Data Structure
  * Multisets, Multimaps, Maps, Sets, etc.

# SBT's and When to Use Them

**Splay Tree**

* Insertion: Amortized $O(\log n)$
* Max Height: $n$
* Search: $O(\log n)$, but slow
* Deletion: Amortized $O(\log n)$
* Used For: when accessing same element again and again
  * Cache, Garbage Collection

#

\vfill
\centering
\begin{minipage}{100pt}
 \includegraphics[width=100pt]{images/connections.png}
\end{minipage}
\begin{minipage}[adjusting]{3in}
 {\Huge Making Connections}\\
 A Mindmapping Exercise
\end{minipage}

# Mind Map

\vspace{-1.5em}
\begin{center}
\includegraphics[width=\textwidth]{images/Modules/ds_mm.png}
\end{center}

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time...

* Read/Review Ch. 11 in the book.
* Review prior lectures
* Come to Class!
