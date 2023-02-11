---
author:
- Isaac Griffith
title: Tree Traversals
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

# Tree Traversal

* Traversing a linear structure is pretty straight forward:

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt01.eps}
\end{center}

# Tree Traversal

* Traversing a linear structure is pretty straight forward: Start at one end and increment all the way through.

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt02.eps}
\end{center}

\pause

* Even traversing a two dimensional array is pretty simple:

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt03.eps}
\end{center}

# Tree Traversal

* Traversing a linear structure is pretty straight forward: Start at one end and increment all the way through.

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt02.eps}
\end{center}

* Even traversing a two dimensional array is pretty simple: Go through each row, one at a time.

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt04.eps}
\end{center}

# Tree Traversal

* How would you traverse a tree?

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt05.eps}
\end{center}

# Tree Traversal

* There are fundamentally two ways to traverse a tree:
\pause
  - Breadth-First. Breadth first visits all nodes at the same level before progressing to the next level.
  \pause
  * Depth-First. Depth first goes down the tree until it reaches a leaf, then goes up the minimal amount and goes looking for more leaves.

# Breadth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt05.eps}
\end{center}

# Breadth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt05.eps}
\end{center}

::: columns
:::: column
"Visit" is a generic action. The actual action depends on what the application is (ex: print node, compare to value...)
::::
:::: column
\color{ForestGreen} **Visit the root.**
::::
:::

# Breadth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt06.eps}
\end{center}

::: columns
:::: column

::::
:::: column
Visit the root.

\color{ForestGreen} **Visit all the children of the root.**
::::
:::

# Breadth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt07.eps}
\end{center}

::: columns
:::: column

::::
:::: column
Visit the root.

Visit all the children of the root.

\color{ForestGreen} **Visit all the children's children.**
::::
:::

# Breadth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt08.eps}
\end{center}

::: columns
:::: column

::::
:::: column
Visit the root.

Visit all the children of the root.

Visit all the children's children.

...
::::
:::

# Breadth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt09.eps}
\end{center}

::: columns
:::: column

::::
:::: column
Visit the root.

Visit all the children of the root.

Visit all the children's children.

...
::::
:::

# Breadth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt10.eps}
\end{center}

::: columns
:::: column

::::
:::: column
How could we build a method to print out all the nodes of the tree in a breadth first manner?
::::
:::

# Depth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt10.eps}
\end{center}

::: columns
:::: column

::::
:::: column
Depth first traversal is slightly more complicated
::::
:::

# Depth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt10.eps}
\end{center}

::: columns
:::: column

::::
:::: column
**Basic idea**: Instead of going level-by-level, I want to go path by path.
::::
:::

# Depth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt11.eps}
\end{center}

::: columns
:::: column

::::
:::: column
**Basic idea**: Instead of going level-by-level, I want to go path by path.
::::
:::

# Depth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt12.eps}
\end{center}

::: columns
:::: column

::::
:::: column
**Basic idea**: Instead of going level-by-level, I want to go path by path.
::::
:::

# Depth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt13.eps}
\end{center}

::: columns
:::: column

::::
:::: column
**Basic idea**: Instead of going level-by-level, I want to go path by path.
::::
:::

# Depth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt14.eps}
\end{center}

::: columns
:::: column

::::
:::: column
**Basic idea**: Instead of going level-by-level, I want to go path by path.
::::
:::

# Depth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt15.eps}
\end{center}

::: columns
:::: column

::::
:::: column
**Basic idea**: Instead of going level-by-level, I want to go path by path.
::::
:::

# Depth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt16.eps}
\end{center}

::: columns
:::: column

::::
:::: column
**Basic idea**: Instead of going level-by-level, I want to go path by path.
::::
:::

# Depth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt17.eps}
\end{center}

::: columns
:::: column

::::
:::: column
**Basic idea**: Instead of going level-by-level, I want to go path by path.
::::
:::

# Depth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt18.eps}
\end{center}

::: columns
:::: column

::::
:::: column
**Basic idea**: Instead of going level-by-level, I want to go path by path.
::::
:::

# Depth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt19.eps}
\end{center}

::: columns
:::: column

::::
:::: column
**Basic idea**: Instead of going level-by-level, I want to go path by path.
::::
:::

# Depth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt20.eps}
\end{center}

::: columns
:::: column

::::
:::: column
**Basic idea**: Instead of going level-by-level, I want to go path by path.
::::
:::

# Depth-First Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt21.eps}
\end{center}

::: columns
:::: column

::::
:::: column
**Basic idea**: Instead of going level-by-level, I want to go path by path.
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt22.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt23.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt24.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt25.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt26.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt27.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt28.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt29.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt30.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt31.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt32.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt33.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt34.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt35.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt36.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Postorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt37.eps}
\end{center}

::: columns
:::: column
\color{ForestGreen} and so on...
::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt38.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt39.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt40.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt41.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt42.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt43.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt44.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt45.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt46.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt47.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt48.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt49.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt50.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt51.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (Preorder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt52.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (PreOrder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt53.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (PreOrder)

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/tt54.eps}
\end{center}

::: columns
:::: column
\color{ForestGreen} and so on ...
::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt55.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt56.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt57.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt58.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt59.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt60.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt61.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt62.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt63.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt64.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt65.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt66.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt67.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt68.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt69.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt70.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt71.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# Depth-First (InOrder)

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Traversals/tt72.eps}
\end{center}

::: columns
:::: column

::::
:::: column
This leads to a decision:

When should we visit a node?

We could visit it AFTER all its children have been visited
::::
:::

# In Order Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/trav01.eps}
\end{center}

# Pre Order Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/trav02.eps}
\end{center}

# Post Order Traversal

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/trav03.eps}
\end{center}

# Iterative Depth First

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/trav04.eps}
\end{center}

# Iterative Breadth First

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module4/Traversals/trav05.eps}
\end{center}

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

* Review Binary Search Trees
* Review Prior Lectures
* Come To Class!
