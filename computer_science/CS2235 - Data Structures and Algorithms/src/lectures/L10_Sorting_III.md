---
author:
- Isaac Griffith
title: Sorting III and Iterators
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
\Huge Sorting III and Iterators

# Outcomes

At the end of Today's Lecture you will be able to:

* Understand and implement a Non-comparison sort
* Understand and implement the HeapSort algorithm
* Understand and utilize Iterators

#

\vfill
\begin{center}
{\Huge Sorting}
\end{center}

# Non-Comparison Sorting

* This restriction only applies if the algorithm depends on comparing values to sort.
\pause
* Can you think of a way to sort something without comparing values?
\pause
* Suppose I had a set of n integers and that the values were between 0 and 100. Can you think of a clever way to sort them?

# Non-Comparison Sorting

* Suppose I had a set of n integers and that the values were between 0 and 100. Can you think of a clever way to sort them?

* First, make a "counting" array with 100 spots.

* Then, go through the n elements and use the element to index into the counting array, and at that spot, increment the value.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/NonCom01.eps}
\end{center}

# Non-Comparison Sorting

* Suppose I had a set of n integers and that the values were between 0 and 100. Can you think of a clever way to sort them?

* First, make a "counting" array with 100 spots.

* Then, go through the n elements and use the element to index into the counting array, and at that spot, increment the value.

* Then, go through the counting array and put the index value back into the initial array the number of times equal to the value in the counting array.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom02.eps}
\end{center}

* Go through the n elements and use the element to index into the counting array, and at that spot increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom03.eps}
\end{center}

* Go through the n elements and use the element to index into the counting array, and at that spot increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom04.eps}
\end{center}

* Go through the n elements and use the element to index into the counting array, and at that spot increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom05.eps}
\end{center}

* Go through the n elements and use the element to index into the counting array, and at that spot increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom06.eps}
\end{center}

* Go through the counting array and change each count to be the number of elements less than that index

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom07.eps}
\end{center}

* Go through the counting array and change each count to be the number of elements less than that index

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom08.eps}
\end{center}

* Go through the counting array and change each count to be the number of elements less than that index

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom09.eps}
\end{center}

* Go through the counting array and change each count to be the number of elements less than that index

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom10.eps}
\end{center}

* Go through the counting array and change each count to be the number of elements less than that index

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom11.eps}
\end{center}

* Go through the counting array and change each count to be the number of elements less than that index

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom12.eps}
\end{center}

* Go through the counting array and change each count to be the number of elements less than that index

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom13.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom14.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom15.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom16.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom17.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom18.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom19.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom20.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom21.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom22.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom23.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom24.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom25.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom26.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom27.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/NonCom28.eps}
\end{center}

* Go through the n elements and put each into an array at the index equal to the value in the count array and increment the value.

# Non-Comparison Sorting

* How long did it take (input size-n, range of values-k)?
\pause
  - n to populate the counting array
  - k to change count to number previous
  - n to put into sorted form
  - another n if you want it back into the original array
\pause
* So, n + k + n + n = O(n + k). If k is in O(n), then the whole thing runs in O(n).

* This is called either Bucket-Sort or Counting Sort.

#

\vfill
\begin{center}
{\Huge HeapSort}
\end{center}

# Heaps

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

# HeapSort

* We utilize the concept of a heap (which is a data structure we will discus at a later date) to sort an array, in place. It takes 4 basic steps:

1. Construct (n + 1) / 2 elementary heaps with one entry each.
2. Form (n + 1)/ heaps, each storing 3 items, by joining pairs of elementary heaps and adding a new entry at the top (note swaps may need to occur to maintain heap properties).
3. Form $(n + 1)/2^i$ heaps, by joining pairs of heaps storing $(2^{i-1} - 1)$ entries, and adding a new entry (initially at top, but can be swapped down)
4. For the final heap, storing all n entries, by joining two heaps storing (n - 1) / 2 entries and adding a new entry (which may be swapped down).

# HeapSort

1. Construct(n + 1) / 2 elementary Heaps

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap38.eps}
\end{center}

# HeapSort

1. Construct(n + 1) / 2 elementary Heaps

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap39.eps}
\end{center}

# HeapSort

1. Construct(n + 1) / 2 elementary heaps

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap40.eps}
\end{center}

# HeapSort

2. Construct (n + 1) / 4 heaps, by combining pairs of elementary heaps and adding one item at the top.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap41.eps}
\end{center}

# HeapSort

2. Construct (n + 1) / 4 heaps, by combining pairs of elementary heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap42.eps}
\end{center}

# HeapSort

2. Construct (n + 1) / 4 heaps, by combining pairs of elementary heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap43.eps}
\end{center}

# HeapSort

2. Construct (n + 1) / 4 heaps, by combining pairs of elementary heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap44.eps}
\end{center}

# HeapSort

2. Construct (n + 1) / 4 heaps, by combining pairs of elementary heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap45.eps}
\end{center}

# HeapSort

3. Construct (n + 1) / 8 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap46.eps}
\end{center}

# HeapSort

3. Construct (n + 1) / 8 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap47.eps}
\end{center}

# HeapSort

3. Construct (n + 1) / 8 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap48.eps}
\end{center}

# HeapSort

3. Construct (n + 1) / 8 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap49.eps}
\end{center}

# HeapSort

3. Construct (n + 1) / 8 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap50.eps}
\end{center}

# HeapSort

3. Construct (n + 1) / 8 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap51.eps}
\end{center}

# HeapSort

4. Construct (n + 1) / 16 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap52.eps}
\end{center}

# HeapSort

4. Construct (n + 1) / 16 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap53.eps}
\end{center}

# HeapSort

4. Construct (n + 1) / 16 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap54.eps}
\end{center}

# HeapSort

4. Construct (n + 1) / 16 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap55.eps}
\end{center}

# HeapSort

4. Construct (n + 1) / 16 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap56.eps}
\end{center}

# HeapSort

4. Construct (n + 1) / 16 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap57.eps}
\end{center}

# HeapSort

4. Construct (n + 1) / 16 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap58.eps}
\end{center}

# HeapSort

4. Construct (n + 1) / 16 heaps, by combining pairs of existing heaps and adding one item at the top. Down bubble new top items if necessary to maintain heap properties.

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Heaps/Heap59.eps}
\end{center}

# In Place HeapSort

* Given an array:
  - Using a max heap we can sort in place.
  - Divide the array into two sections: Unsorted and Heap
    * Recursively build a heap from the unsorted section, so that the heap section grows as the unsorted section shrinks.
  - Divide the array into two sections: Heap and Sorted
    * Starting from the end of the array swap out the first item and the end (decreasing by one each time), then maintain the heap.
    * Once the size of the heap is one, the array should be sorted.

# Phase 1: Build Heap

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/HeapSort01.eps}
\end{center}

# Phase 2: Sort

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/HeapSort02.eps}
\end{center}

# Phase 2: Sort

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/HeapSort03.eps}
\end{center}

# Phase 2: Sort

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/HeapSort04.eps}
\end{center}

# Time Complexity

* What is the time complexity of this approach?
\pause
  - Build Heaps: O(n log n)
  - Sort: O(n log n)
\pause
* Thus, 2 n log n which is in O(n log n)
* What is the space complexity?

# Space/Time Complexity

* What is the time complexity of this approach?
\pause
  - Build Heaps: O(n log n)
  - Sort: O(n log n)
\pause
* Thus, 2 n log n which is in O(n log n)
* What is the space complexity? O(n)

#

\vfill
\begin{center}
{\Huge Iterators}
\end{center}

# Iterators

* Suppose we have a linked list filled with things.

\pause

\begin{center}
\includegraphics[width=.7\textwidth]{images/Module1/Java/Iterators/Iter01.eps}
\end{center}

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

\begin{center}
\includegraphics[width=.7\textwidth]{images/Module1/Java/Iterators/Iter01.eps}
\end{center}

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

\begin{center}
\includegraphics[width=.7\textwidth]{images/Module1/Java/Iterators/Iter02.eps}
\end{center}

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

\begin{center}
\includegraphics[width=.7\textwidth]{images/Module1/Java/Iterators/Iter03.eps}
\end{center}

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

\begin{center}
\includegraphics[width=.7\textwidth]{images/Module1/Java/Iterators/Iter04.eps}
\end{center}

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

* Why would we want to traverse it?

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

* Why would we want to traverse it? Any number of reasons:
  - Print elements to the screen.
  - Save elements to a file.
  - Display to GUI.
  - Compare to see if sorted.

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

* Why would we want to traverse it? Any number of reasons.

* What is the problem with this?

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

* Why would we want to traverse it? Any number of reasons.

* What is the problem with this? Each task needs its own method IN the LinkedList class.

\pause

* Is there a better way?

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

* Why would we want to traverse it? Any number of reasons.

* What is the problem with this? Each task needs its own method IN the LinkedList class.

* Is there a better way? Iterators are a structured way of traversing lists. The task performed is implemented by the person using the iterator.

# Iterators

* The iterator will merely keep track of where we are in the list and provide the following methods:

```java
    // indicates there is a next object
    public boolean hasNext();

    // returns the next object and moves
    // on to the next object
    public Object next();
```

# Iterators

* The iterator will merely keep track of where we are in the list and provide the following methods:

```java
public interface Iterator<E> {
    // indicates there is a next object
    public boolean hasNext();

    // returns the next object and moves
    // on to the next object
    public E next();
}
```

# Iterators

* The iterator will merely keep track of where we are in the list and provide the following methods:
  - `public boolean hasNext();`
  - `public E next();`

* The fact there is an interface that dictates how traversing a list occurs is very powerful. Why?
\pause
  - Because the user can traverse a structure and define actions (print, save, compare, ...), without having any idea what the structure is (array, linked list, tree, ...)

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Read Ch 3 Sections 1 - 6
* Review Lecture Notes
* Come to class
* Continue working on PP 01
