---
author:
- Isaac Griffith
title: Heaps and Priority Queues
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
\Huge Heaps and Priority Queues

# Outcomes

At the end of Today's Lecture you will be able to:

* Understand and be capable of implementing Priority Queues
* Understand and be capable of implementing Heaps

#

\vfill
\begin{center}
{\Huge Heaps}
\end{center}

# Introduction

* A Heap is a binary tree that stores entries at each of its positions

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap01.eps}
\end{center}

# Heap Properties

* A heap must maintain the following two properties:
  - **Relational Property**: In a heap **T**, for every position p other than the root, the key stored at p is ______ to the key stored at p's parent.
  - Depending on the type of heap the blank can be filled in, in one of two ways:
    - MAX Heap -- In a heap **T**, for every position p other than the root, the key stored at p is *less than or equal to* the key stored at p's parent.
    - MIN Heap -- In a heap **T**, for every position p other than the root, the key stored at p is *greater than or equal to* the key stored at p's parent.

# MAX Heap

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap02.eps}
\end{center}

# MIN Heap

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap03.eps}
\end{center}

# Heap Properties

* A heap must maintain the following two properties:
  - Relational Property
  - **Structural Property**: A heap **T**, with height h is a *complete* binary tree if levels (or plys), 0, 1, 2, ..., h
    * **1 of T** have the maximum nodes possible (namely, level **I** has $2^i$ nodes, for $0 \leq i \leq h - 1$) and the remaining nodes at level h reside in the leftmost positions at that level.

# Heap Property Consequences

* Relational Property Consequences:
  - The root or the "top of the heap" always contains either the minimum or maximum value in a MIN or MAX Heap, respectively

* Structural Property Consequences:
  - Ensures the maximum efficiency of the heap by maintaining the smallest height possible.
  - What is the height of a heap?

  # Heap Property Consequences

  * Relational Property Consequences:
    - The root or the "top of the heap" always contains either the minimum or maximum value in a MIN or MAX Heap, respectively

  * Structural Property Consequences:
    - Ensures the maximum efficiency of the heap by maintaining the smallest height possible.
    - What is the height of a heap? $h = floor(\log n)$

#

\vfill
\begin{center}
{\Huge Heap Implementation}
\end{center}

# The Heap ADT

* A Heap has the following basic operations:
  - `size()`
  - `isEmpty()`
  - `top()`
  - `removeTop()`

* How could we implement such a data structure?

# Inserting into a Heap

* Insertion is always at the bottom of the heap, the last rightmost position of level h, or the leftmost position of the next level.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap03.eps}
\end{center}

# Inserting into a Heap

* Insertion is always at the bottom of the heap, the last rightmost position of level h, or the leftmost position of the next level.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap03.eps}
\end{center}

# Inserting into a Heap

* Insertion is always at the bottom of the heap, the last rightmost position of level h, or the leftmost position of the next level.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap04.eps}
\end{center}

# Inserting into a Heap

* Insertion is always at the bottom of the heap, the last rightmost position of level h, or the leftmost position of the next level.

* The new node needs to then be moved up the heap until the relational property is maintained.

* This involves swapping **values** between nodes until the new child is no longer < or > its parent (depending on whether it is a max or min heap), or it is at the top of the heap.

# Insertion Example

Insert 3 into the following Heap

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap07.eps}
\end{center}

# Insertion Example

Insert 3 into the following Heap

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap08.eps}
\end{center}

1. Insert at the bottom of the Heap

# Insertion Example

Insert 3 into the following Heap

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap09.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example

Insert 3 into the following Heap

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap10.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example

Insert 3 into the following Heap

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap11.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example

Insert 3 into the following Heap

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap12.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example

Insert 3 into the following Heap

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap13.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example

Insert 3 into the following Heap

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap14.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example

Insert 3 into the following Heap

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap15.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example

Insert 3 into the following Heap

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap16.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example

Insert 3 into the following Heap

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap17.eps}
\end{center}

3. Top was reached, and now the heap properties are satisfied.

# Insertion Example 2

Insert 2 into the following Heap

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap18.eps}
\end{center}

1. Insert at the bottom of the Heap

# Insertion Example 2

Insert 2 into the following Heap

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap19.eps}
\end{center}

1. Insert at the bottom of the Heap

# Insertion Example 2

Insert 2 into the following Heap

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap20.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example 2

Insert 2 into the following Heap

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap21.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example 2

Insert 2 into the following Heap

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap22.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example 2

Insert 2 into the following Heap

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap23.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example 2

Insert 2 into the following Heap

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap24.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example 2

Insert 2 into the following Heap

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap25.eps}
\end{center}

2. Bubble the new value up the heap until the relational property is satisfied or the top is reached.

# Insertion Example 2

Insert 2 into the following Heap

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap26.eps}
\end{center}

3. Position was reached where parent is less than child, and now the heap properties are satisfied.

# Removing From Top of Heap

* Swap the Top value with the Bottom value.

* Remove the Bottom item

* Bubble Down (swapping with the minimum/maximum child each time) the new Top item until all heap properties are satisfied.
  - Until it is either the bottom (last) item, or
  - It is greater than or equal to the maximum child (MAX Heap) or it is less than or equal to the minimum child (MIN Heap).
  - If next pointer is > size + 1, then swap with size + 1 (the bottom).

# Removal Example

Remove the top from the following heap.

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module4/Heaps/Heap26.eps}
\end{center}

# Removal Example

Remove the top from the following heap.

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap27.eps}
\end{center}

1. Swap the Top and Bottom values

# Removal Example

Remove the top from the following heap.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap28.eps}
\end{center}

1. Swap the Top and Bottom values

# Removal Example

Remove the top from the following heap.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap29.eps}
\end{center}

2. Remove the bottom item

# Removal Example

Remove the top from the following heap.

\begin{center}
\includegraphics[width=.6\textwidth]{images/Module4/Heaps/Heap30.eps}
\end{center}

2. Remove the bottom item

# Removal Example

Remove the top from the following heap.

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap31.eps}
\end{center}

3. Bubble down (swapping values) the new top in order to ensure the heap properties are maintained.

# Removal Example

Remove the top from the following heap.

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap32.eps}
\end{center}

3. Bubble down (swapping values) the new top in order to ensure the heap properties are maintained.

# Removal Example

Remove the top from the following heap.

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap33.eps}
\end{center}

3. Bubble down (swapping values) the new top in order to ensure the heap properties are maintained.

# Removal Example

Remove the top from the following heap.

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap34.eps}
\end{center}

3. Bubble down (swapping values) the new top in order to ensure the heap properties are maintained.

# Removal Example

Remove the top from the following heap.

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap35.eps}
\end{center}

3. Bubble down (swapping values) the new top in order to ensure the heap properties are maintained.

# Removal Example

Remove the top from the following heap.

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap36.eps}
\end{center}

3. Bubble down (swapping values) the new top in order to ensure the heap properties are maintained.

# Removal Example

Remove the top from the following heap.

\begin{center}
\includegraphics[width=.55\textwidth]{images/Module4/Heaps/Heap37.eps}
\end{center}

4. Operation complete, all heap properties are maintained.

# Implementation Complexity

\footnotesize
+----------------+---------------------+----------------+
| Structure      | Operations          | Complexity     |
+:===============+====================:+:===============+
| **Array**      | `int size()`        | **O(1)**       |
+----------------+---------------------+----------------+
|                | `boolean isEmpty()` | **O(1)**       |
+----------------+---------------------+----------------+
|                | `E top()`           | **O(1)**       |
+----------------+---------------------+----------------+
|                | `insert(E item)`    | **O(log n)**   |
+----------------+---------------------+----------------+
|                | `E removeTop()`     | **O(log n)**   |
+----------------+---------------------+----------------+
| **LinkedList** | `int size()`        | **O(1)**       |
+----------------+---------------------+----------------+
|                | `boolean isEmpty()` | **O(1)**       |
+----------------+---------------------+----------------+
|                | `E top()`           | **O(1)**       |
+----------------+---------------------+----------------+
|                | `insert(E item)`    | **O(n log n)** |
+----------------+---------------------+----------------+
|                | `E removeTop()`     | **O(n log n)** |
+----------------+---------------------+----------------+
| BinaryTree     | `int size()`        | **O(n)**       |
+----------------+---------------------+----------------+
|                | `boolean isEmpty()` | **O(1)**       |
+----------------+---------------------+----------------+
|                | `E top()`           | **O(1)**       |
+----------------+---------------------+----------------+
|                | `insert(E item)`    | **O(log n)**   |
+----------------+---------------------+----------------+
|                | `E removeTop()`     | **O(log n)**   |
+----------------+---------------------+----------------+

#

\vfill
\begin{center}
{\Huge Priority Queues}
\end{center}

# Priority Queues

* Previously we have discussed the following methods of implementing a priority queue:
  - Using a linked list to store items, offering at the front, and walking the list to find the next highest priority item on each poll.
  - Using an ordered linked list to store highest priority items at the front of the list, while adding items in order starting at the front of the list.

* Both of these approaches will work, but as we will see, a Heap offers a more efficient and elegant approach.

# Priority Queues

* First, how would we create a Priority Queue using a Heap?
  \pause
  - Of course as I'm sure you suspected we will simply create a wrapper class which maps the operations of a heap to those of a priority queue.
  - What type of Heap do we want to use?

# Priority Queues

* First, how would we create a Priority Queue using a Heap?
  - Of course as I'm sure you suspected we will simply create a wrapper class which maps the operations of a heap to those of a priority queue.
  - What type of Heap do we want to use? More often than not it will be a MAX heap so that higher priority items are at the front of the list.

# Priority Queues

::: columns
:::: column
**Priority Queue Ops**

* `int size()` $\longrightarrow$
* `boolean isEmpty()` $\longrightarrow$
* `E poll()` $\longrightarrow$
* `E peek()` $\longrightarrow$
* `offer(E item)` $\longrightarrow$
::::
:::: column
**Heap Ops**

* `int size()`
* `boolean isEmpty()`
* `E removeTop()`
* `E top()`
* `insert(E item)`
::::
:::

# Priority Queue

* The final question is: What do we use to handle the assignment of priority?
  \pause
  1. Using `Comparable` or `Comparator` interfaces to define methods to determine priority based on a class' fields
  \pause
  2. Defining a secondary value external to the class which defines the priority:

  ```java
     PriorityQueue<E, P> // where E is the element
                         // P is the priority
  ```

# Priority Queues

\footnotesize
+-----------------+---------------------+----------------+
| Structure       | Operations          | Complexity     |
+:================+====================:+:===============+
| **Heap**        | `int size()`        | **O(1)**       |
+-----------------+---------------------+----------------+
|                 | `boolean isEmpty()` | **O(1)**       |
+-----------------+---------------------+----------------+
|                 | `E peek()`          | **O(1)**       |
+-----------------+---------------------+----------------+
|                 | `offer(E item)`     | **O(log n)**   |
+-----------------+---------------------+----------------+
|                 | `E poll()`          | **O(log n)**   |
+-----------------+---------------------+----------------+
| **OrderedList** | `int size()`        | **O(1)**       |
+-----------------+---------------------+----------------+
|                 | `boolean isEmpty()` | **O(1)**       |
+-----------------+---------------------+----------------+
|                 | `E peek()`          | **O(1)**       |
+-----------------+---------------------+----------------+
|                 | `offer(E item)`     | **O(n)**       |
+-----------------+---------------------+----------------+
|                 | `E poll()`          | **O(1)**       |
+-----------------+---------------------+----------------+
| **LinkedList**  | `int size()`        | **O(1)**       |
+-----------------+---------------------+----------------+
|                 | `boolean isEmpty()` | **O(1)**       |
+-----------------+---------------------+----------------+
|                 | `E peek()`          | **O(n)**       |
+-----------------+---------------------+----------------+
|                 | `offer(E item)`     | **O(1)**       |
+-----------------+---------------------+----------------+
|                 | `E poll()`          | **O(n)**       |
+-----------------+---------------------+----------------+

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Discussing Unit Tests
* Review Prior Lectures
* Come to Class!
