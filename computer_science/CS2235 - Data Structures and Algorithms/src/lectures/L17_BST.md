---
author:
- Isaac Griffith
title: Binary Search Tree
titlepage-note: |
  This is a the note that goes on the title page. This talk is to be
  given at Doing DH.
institute: |
  CS 3308

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Binary Search Tree

::: columns
:::: column
* A Binary Search Tree is a binary tree where for each Node n:
  - All values in the subtree rooted at the left child of n are less than n
  - All values in the subtree rooted at the right child of n are greater than n
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst01.eps}
\end{center}
::::
:::

# Binary Search Tree

::: columns
:::: column
* Binary Search Tree?

::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst02.eps}
\end{center}
::::
:::

# Binary Search Tree

::: columns
:::: column
* Binary Search Tree?

* Is it a binary tree?
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst03.eps}
\end{center}
::::
:::

# Binary Search Tree

::: columns
:::: column
* Binary Search Tree?

::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst04.eps}
\end{center}
::::
:::

# Binary Search Tree

::: columns
:::: column
* Binary Search Tree?

* \color{SkyBlue}**Is it a binary tree?**

::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst05.eps}
\end{center}
::::
:::

# Binary Search Tree

::: columns
:::: column
* Binary Search Tree?

* \color{SkyBlue}**Is it a binary tree?**

* \color{Black}For each node, are all values to the left less than that node?

::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst05.eps}
\end{center}
::::
:::

# Binary Search Tree

::: columns
:::: column
* Binary Search Tree?

* \color{SkyBlue}**Is it a binary tree?**

* \color{Roarange}**For each node, are all values to the left less than that node?**

::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst06.eps}
\end{center}
::::
:::

# Binary Search Tree

::: columns
:::: column
* Binary Search Tree?

* \color{SkyBlue}**Is it a binary tree?**

* \color{Roarange}**For each node, are all values to the left less than that node?**

* \color{Black}For each node, all all values to the right of that node greater?
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst07.eps}
\end{center}
::::
:::

# Binary Search Tree

::: columns
:::: column
* Binary Search Tree?

* \color{SkyBlue}**Is it a binary tree?**

* \color{Roarange}**For each node, are all values to the left less than that node?**

* \color{Roarange}**For each node, all all values to the right of that node greater?**
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst08.eps}
\end{center}
::::
:::

# Binary Search Tree

::: columns
:::: column
* What's the point?
* Why use a BST?
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst09.eps}
\end{center}
::::
:::

# Binary Tree Properties

* Recall: How long, in terms of number of nodes n, is the longest path from root to leaf in a binary tree that looks like this?

::: columns
:::: {.column width=.7}
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst10.eps}
\end{center}
::::
:::: {.column width=.3}
\pause
log(n) hops

\pause
\vskip1em
So, we can access ANY node in an appropriately structured BST in log(n) hops.
::::
:::

# Binary Search Tree

::: columns
:::: column
* What's the point?
* Why use a BST?

* We can find a value in log(n) time.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst13.eps}
\end{center}
::::
:::

# Binary Search Tree

::: columns
:::: column
* What's the point?
* Why use a BST?

* We can find a value in log(n) time.

* But we can already do that on a sorted array with Binary Search.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst14.eps}
\end{center}
::::
:::

# Binary Search Tree

::: columns
:::: column
* What's the point?
* Why use a BST?

* We can find a value in log(n) time, and insertions do not require shifting entities like it does in an array.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst15.eps}
\end{center}
::::
:::

# Binary Search Tree

* What methods should be built in a BST class?
  - insert()
  - search()
  - remove()

# BST Insertion

::: columns
:::: column
insert(37);

::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst16.eps}
\end{center}
::::
:::

# BST Insertion

::: columns
:::: column
insert(37);

1. Find where it should go.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst17.eps}
\end{center}
::::
:::

# BST Insertion

::: columns
:::: column
insert(37);

1. Find where it should go.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst18.eps}
\end{center}
::::
:::

# BST Insertion

::: columns
:::: column
insert(37);

1. Find where it should go.
2. Modify pointers
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst19.eps}
\end{center}
::::
:::

# BST Insertion

::: columns
:::: column
insert(87);

::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst20.eps}
\end{center}
::::
:::

# BST Insertion

::: columns
:::: column
insert(87);

1. Find where it should go.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst21.eps}
\end{center}
::::
:::

# BST Insertion

::: columns
:::: column
insert(87);

1. Find where it should go.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst22.eps}
\end{center}
::::
:::

# BST Insertion

::: columns
:::: column
insert(87);

1. Find where it should go.
2. Modify pointers
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst23.eps}
\end{center}
::::
:::

# BST Insertion

::: columns
:::: column
insert(??);

::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst24.eps}
\end{center}
::::
:::

# BST Insertion

::: columns
:::: column
insert(??);

* Can we draw any conclusions about inserting?

::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst25.eps}
\end{center}
::::
:::

# BST Insertion

::: columns
:::: column
insert(??);

* Can we draw any conclusions about inserting?

* We always insert a new _____.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst26.eps}
\end{center}
::::
:::

# BST Insertion

::: columns
:::: column
insert(??);

* Can we draw any conclusions about inserting?

* We always insert a new leaf. So, we don't even need to worry about children.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst27.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
How to delete from a BST?

::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst28.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 1: The node has no children.

\vskip1em

E.g. remove(68);

::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst29.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
How to delete from a BST?

\vskip1em

E.g. remove(68);

1. Find the Node in the tree
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst30.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
How to delete from a BST?

\vskip1em

E.g. remove(68);

1. Find the Node in the tree
2. Change the parent to point to null.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst31.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 2: The node has one child.

\vskip1em

E.g. remove(82);
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst32.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 2: The node has one child.

\vskip1em

E.g. remove(82);

1. Find the Node in the tree
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst33.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 2: The node has one child.

\vskip1em

E.g. remove(82);

1. Find the Node in the tree
2. Change the parent to point to the child.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst34.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 2: The node has one child.

\vskip1em

E.g. remove(82);

1. Find the Node in the tree
2. Change the parent to point to the child.
3. Change the child to point to the parent.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst35.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 2: The node has one child.

\vskip1em

E.g. remove(82);

1. Find the Node in the tree
2. Change the parent to point to the child.
3. Change the child to point to the parent.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst36.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 3: The node has two children.

\vskip1em

E.g. remove(88);
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst37.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 3: The node has two children.

\vskip1em

E.g. remove(88);

1. Find the Node in the tree
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst38.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 3: The node has two children.

\vskip1em

E.g. remove(88);

1. Find the Node in the tree
2. ????????
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst39.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 3: The node has two children.

\vskip1em

E.g. remove(88);

1. Find the Node in the tree
2. Find the next smallest value.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst40.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 3: The node has two children.

\vskip1em

E.g. remove(88);

1. Find the Node in the tree
2. Find the next smallest value.
3. Put that value in the Node being removed
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst41.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 3: The node has two children.

\vskip1em

E.g. remove(88);

1. Find the Node in the tree
2. Find the next smallest value.
3. Put that value in the Node being removed
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst42.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 3: The node has two children.

\vskip1em

E.g. remove(88);

1. Find the Node in the tree
2. Find the next smallest value.
3. Put that value in the Node being removed
4. Remove the Node with the next smallest value.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst43.eps}
\end{center}
::::
:::

# BST Deletion

::: columns
:::: column
Case 3: The node has two children.

\vskip1em

E.g. remove(88);

1. Find the Node in the tree
2. Find the next smallest value.
3. Put that value in the Node being removed
4. Remove the Node with the next smallest value.
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/BST/bst44.eps}
\end{center}
::::
:::

#

\vfill
\begin{center}
\Huge Lets Look at Some Code
\end{center}

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Review Prior Lectures
* No Class Thursday
* Next Week Midterms
* Start Working on PA03 and PP02
