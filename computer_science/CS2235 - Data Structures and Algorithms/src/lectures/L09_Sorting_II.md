---
author:
- Isaac Griffith
title: Sorting II
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
\Huge Sorting II

# Outcomes

At the end of Today's Lecture you will be able to:

* Explain Insertion Sort
* Explain Selection Sort
* Understand the lower bound of Comparison Sorting

#

\vfill
\begin{center}
{\Huge InsertionSort - Basics}
\end{center}

# Insertion Sort

* Insertion sort is a simple algorithm that works by building a sorted array from the contents of the input.

# Insertion Sort - Basic Idea

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert01.eps}
\end{center}

Split the array into a sorted and an unsorted part. (Initially, the sorted part is just the first element).

# Insertion Sort - Basic Idea

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert02.eps}
\end{center}

Remove one element at a time from the unsorted part and put it in its rightful spot in the sorted part.

# Insertion Sort - Basic Idea

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert03.eps}
\end{center}

Repeat.

# Insertion Sort - Basic Idea

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert04.eps}
\end{center}

Repeat..

# Insertion Sort - Basic Idea

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert05.eps}
\end{center}

Repeat...

# Insertion Sort - Basic Idea

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert06.eps}
\end{center}

Eventually, all the elements will be in the sorted part, and thus, the array is sorted.

#

\vfill
\begin{center}
{\Huge InsertionSort - Example}
\end{center}

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert07.eps}
\end{center}

1. Initialize the array with a sorted part and an unsorted part

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert08.eps}
\end{center}

1. Initialize the array with a sorted part and an unsorted part

2. Move current one spot, and put that element where it belongs relative to the elements before it.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert09.eps}
\end{center}

1. Initialize the array with a sorted part and an unsorted part

2. Move current one spot, and put that element where it belongs relative to the elements before it.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert10.eps}
\end{center}

1. Initialize the array with a sorted part and an unsorted part

2. Move current one spot, and put that element where it belongs relative to the elements before it.

3. Repeat Step 2.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert11.eps}
\end{center}

1. Initialize the array with a sorted part and an unsorted part

2. Move current one spot, and put that element where it belongs relative to the elements before it.

3. Repeat Step 2.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert12.eps}
\end{center}

1. Initialize the array with a sorted part and an unsorted part

2. Move current one spot, and put that element where it belongs relative to the elements before it.

3. Repeat Step 2.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert13.eps}
\end{center}

1. Initialize the array with a sorted part and an unsorted part

2. Move current one spot, and put that element where it belongs relative to the elements before it.

3. Repeat Step 2.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert14.eps}
\end{center}

1. Initialize the array with a sorted part and an unsorted part

2. Move current one spot, and put that element where it belongs relative to the elements before it.

3. Repeat Step 2.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert15.eps}
\end{center}

1. Initialize the array with a sorted part and an unsorted part

2. Move current one spot, and put that element where it belongs relative to the elements before it.

3. Repeat Step 2.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert16.eps}
\end{center}

1. Initialize the array with a sorted part and an unsorted part

2. Move current one spot, and put that element where it belongs relative to the elements before it.

3. Repeat Step 2.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert17.eps}
\end{center}

Is it clear that this will result in a sorted array?

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert18.eps}
\end{center}

Is it clear that this will result in a sorted array?

Then, the only thing we need to do is figure out the process of "putting the element where it belongs relative to the elements before it."

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert19.eps}
\end{center}

Suppose we have this situation, how should we put the value in the correct spot?

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert20.eps}
\end{center}

Suppose we have this situation, how should we put the value in the correct spot?

Let's make a new pointer and start searching

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert21.eps}
\end{center}

Suppose we have this situation, how should we put the value in the correct spot?

Let's make a new pointer and start searching

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert22.eps}
\end{center}

We are going to search for where the curr value belongs AND shift things to the right as we go.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert23.eps}
\end{center}

We are going to search for where the curr value belongs AND shift things to the right as we go.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert24.eps}
\end{center}

Is temp < array[j]?

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert25.eps}
\end{center}

Is temp < array[j]?
  Yes, so move j's value right and decrement j.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert26.eps}
\end{center}

Is temp < array[j]?
  Yes, so move j's value right and decrement j.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert27.eps}
\end{center}

Is temp < array[j]?
  Yes, so move j's value right and decrement j.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert28.eps}
\end{center}

Is temp < array[j]?

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert29.eps}
\end{center}

Is temp < array[j]?

  Yes, so move j's value right and decrement j.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert30.eps}
\end{center}

Is temp < array[j]?

  Yes, so move j's value right and decrement j.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert31.eps}
\end{center}

Is temp < array[j]?

  Yes, so move j's value right and decrement j.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert32.eps}
\end{center}

Is temp < array[j]?

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert33.eps}
\end{center}

Is temp < array[j]?

  Yes, so move j's value right and decrement j.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert34.eps}
\end{center}

Is temp < array[j]?

  Yes, so move j's value right and decrement j.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert35.eps}
\end{center}

Is temp < array[j]?

  Yes, so move j's value right and decrement j.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert36.eps}
\end{center}

Is temp < array[j]?

  No, ...

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert37.eps}
\end{center}

Is temp < array[j]?

  No, so put the temp value in spot j + 1.

This means that we have found the spot where old curr value (temp) must belong.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert38.eps}
\end{center}

One special case for us to think about

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert39.eps}
\end{center}

Is temp < array[j]?

  Yes, so move j's value right and decrement j.

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert40.eps}
\end{center}

Now what?

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert41.eps}
\end{center}

Now what?

Let's stoop the loop when either we find a value less than temp (since that is the spot we need), or j < 0 (since the new value must be smaller than everything).

# Insertion Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert42.eps}
\end{center}

Now what?

Let's stoop the loop when either we find a value less than temp (since that is the spot we need), or j < 0.

Then, we can just put the value in spot j + 1, regardless of the reason we stopped.

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Best Case:

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Best Case: No searching/shifting of values needs to be done. When does this happen?

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Best Case: No searching/shifting of values needs to be done. This happens when each value is larger than the largest value in the sorted part (i.e., sorted input). O(?)

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Best Case: No searching/shifting of values needs to be done. This happens when each value is larger than the largest value in the sorted part (i.e., sorted input). O(n)

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Best Case: No searching/shifting of values needs to be done. This happens when each value is larger than the largest value in the sorted part (i.e., sorted input). O(n)

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert43.eps}
\end{center}

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Best Case: No searching/shifting of values needs to be done. This happens when each value is larger than the largest value in the sorted part (i.e., sorted input). O(n)

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert44.eps}
\end{center}

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Best Case: No searching/shifting of values needs to be done. This happens when each value is larger than the largest value in the sorted part (i.e., sorted input). O(n)

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert45.eps}
\end{center}

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Worst Case:

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Worst Case: Lots of searching/shifting of values needs to be done. When does this happen?

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Worst Case: Lots of searching/shifting of values needs to be done. This happens when each value is smaller than the smallest value in the sorted part (i.e., reverse sorted input). O(?)

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Worst Case: Lots of searching/shifting of values needs to be done. This happens when each value is smaller than the smallest value in the sorted part (i.e., reverse sorted input). O($n^2$)

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert47.eps}
\end{center}

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Worst Case: Lots of searching/shifting of values needs to be done. This happens when each value is smaller than the smallest value in the sorted part (i.e., reverse sorted input). O($n^2$)

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert48.eps}
\end{center}

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Worst Case: Lots of searching/shifting of values needs to be done. This happens when each value is smaller than the smallest value in the sorted part (i.e., reverse sorted input). O($n^2$)

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert49.eps}
\end{center}

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Worst Case: Lots of searching/shifting of values needs to be done. This happens when each value is smaller than the smallest value in the sorted part (i.e., reverse sorted input). O($n^2$)

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Insert50.eps}
\end{center}

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Worst Case: Lots of searching/shifting of values needs to be done. This happens when each value is smaller than the smallest value in the sorted part (i.e., reverse sorted input). O($n^2$)

So, the total number of constant operations is the total number of shifts:

1 + 2 + 3 + ... + n, ????

# Insertion Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

Worst Case: Lots of searching/shifting of values needs to be done. This happens when each value is smaller than the smallest value in the sorted part (i.e., reverse sorted input). O($n^2$)

So, the total number of constant operations is the total number of shifts:

1 + 2 + 3 + ... + n, which is in O($n^2$)

# Insertion Sort Space Complexity

Given an array of size n, how much extra space (beyond the initial array) does insertion sort need?

# Insertion Sort Space Complexity

Given an array of size n, how much extra space (beyond the initial array) does insertion sort need?

Constant, just the variables temp and j.

#

\vfill
\begin{center}
{\Huge Selection Sort - Basics}
\end{center}

# Selection Sort

Selection Sort is similar to insertion sort in that we have a sorted and an unsorted part of the array. We still take elements from the unsorted part and put them into the sorted part.

# Selection Sort

::: columns
:::: column
* Insertion Sort: Take the next from unsorted part and find where it goes in sorted part.
::::
:::: column
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select01.eps}
\end{center}
::::
:::
\pause
::: columns
:::: column
* Selection Sort: Find the smallest element of unsorted part, and put it as next element in sorted part.
::::
:::: column
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select02.eps}
\end{center}
::::
:::

#

\vfill
\begin{center}
{\Huge Selection Sort - Example}
\end{center}

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select03.eps}
\end{center}

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select04.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select05.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.
2. Find smallest value from unsorted part.

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select06.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.
2. Find smallest value from unsorted part.
3. Swap the smallest value with the pointer

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select07.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.
2. Find smallest value from unsorted part.
3. Swap the smallest value with the pointer and increment pointer.

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select08.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.
2. Find smallest value from unsorted part.
3. Swap the smallest value with the pointer and increment pointer.

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select08.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.
2. Find smallest value from unsorted part.
3. Swap the smallest value with the pointer and increment pointer.
4. Loop back to step 2 until the unsorted part is empty.

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select09.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.
2. **Find smallest value from unsorted part.**
3. Swap the smallest value with the pointer and increment pointer.
4. Loop back to step 2 until the unsorted part is empty.

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select10.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.
2. Find smallest value from unsorted part.
3. **Swap the smallest value with the pointer and increment pointer.**
4. Loop back to step 2 until the unsorted part is empty.

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select11.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.
2. Find smallest value from unsorted part.
3. **Swap the smallest value with the pointer and increment pointer.**
4. Loop back to step 2 until the unsorted part is empty.

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select11.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.
2. Find smallest value from unsorted part.
3. Swap the smallest value with the pointer and increment pointer.
4. **Loop back to step 2 until the unsorted part is empty.**

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select12.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.
2. **Find smallest value from unsorted part.**
3. Swap the smallest value with the pointer and increment pointer.
4. Loop back to step 2 until the unsorted part is empty.

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select13.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.
2. Find smallest value from unsorted part.
3. **Swap the smallest value with the pointer and increment pointer.**
4. Loop back to step 2 until the unsorted part is empty.

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select14.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.
2. Find smallest value from unsorted part.
3. **Swap the smallest value with the pointer and increment pointer.**
4. Loop back to step 2 until the unsorted part is empty.

# Selection Sort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Select15.eps}
\end{center}

1. Make pointer to differentiate sorted from unsorted.
2. Find smallest value from unsorted part.
3. Swap the smallest value with the pointer and increment pointer.
4. **Loop back to step 2 until the unsorted part is empty.**

# Selection Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

\pause

Is there a different best case from worst case?

\pause

  - No, regardless of how the data looks, we need to do the exact same thing: Search the entire unsorted section for the smallest value.

\pause

So, best case = worst case = ?

\pause

  - For the first element, go through n,
  - n-1 for the second,
  - n-2 for the third,...

# Selection Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

\pause

Is there a different best case from worst case?

\pause

  - No, regardless of how the data looks, we need to do the exact same thing: Search the entire unsorted section for the smallest value.

\pause

So, best case = worst case = n + (n-1) + ... + 1 in O(?)

# Selection Sort Running Time

Given an array of size n, how long will it take for insertion sort to run?

\pause

Is there a different best case from worst case?

\pause

  - No, regardless of how the data looks, we need to do the exact same thing: Search the entire unsorted section for the smallest value.

\pause

So, best case = worst case = n + (n-1) + ... + 1 in O($n^2$)

# Selection Sort Space Complexity

Given an array of size n, how much extra space (beyond the initial array) does insertion sort need?

\pause

  - Constant, just some variables.

# Sorting

* All of the sorting algorithms we have looked at so far are called **comparison sorts**

\pause

* Comparison sorts work by comparing two values at a time.

\pause

* Can you think of a sorting algorithm that does not compare values?
\pause
  - We'll come back to that

# Sorting

* Since the best sorting algorithms we have seen have O(n log n) running time, a natural question is, can we do better?
\pause
* How can we answer that question?
\pause
  1. Develop an algorithm that runs faster
  2. Show that such an algorithm could not exist.


# Sorting

* Since the best sorting algorithms we have seen have O(n log n) running time, a natural question is, can we do better?

* How can we answer that question?

  1. Develop an algorithm that runs faster
  2. **Show that such an algorithm could not exist.**

# Comparison Sorting

* We are going to show that **any** comparison sorting algorithm **must** take at least **n log n** time to execute in the worst case.
\pause
  - This means that we are finding a lower bound on performance.
  \pause
  - So far, we have only looked for upper bounds: "Algorithm A runs in at most $n^2$ time".
  \pause
  - This is saying: "Algorithm A needs at least $n^2$ time to run"
  - There is a whole other notation for lower bounds (big-omega).

# Comparison Sorting

* Suppose that the sequence we wish to sort is:
  - $S = {x_0,x_1,x_2,\ldots,x_{n-1}}$

* We will assume that the elements are distinct, and we won't care about implementation details (array vs linked lists, swaps, ...).
\pause
* All we do is count the number of comparisons

# Comparison Sorting

* Suppose that the sequence we wish to sort is:
  - $S = {x_0,x_1,x_2,\ldots,x_{n-1}}$

* Let's think about some generic comparison sorting algorithm. What must it do?
\pause
  - It must compare two values, then execute some operation based on the result.

\pause
* So, any time two values ($x_i$, and $x_j$) are compared, there are two possibilities:
  1. $x_i < x_j$
  2. $x_i > x_j$

# Comparison Sorting

* Suppose that the sequence we wish to sort is:
  - $S = {x_0,x_1,x_2,\ldots,x_{n-1}}$

* Let's think about some generic comparison sorting algorithm. What must it do?
  - It must compare two values, then execute some operation based on the result.

* So, any time two values ($x_i$, and $x_j$) are compared, there are two possibilities:
  1. $x_i < x_j$
  2. $x_i > x_j$

# Comparison Sorting

We can represent this process as a binary decision tree:

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/CompAn01.eps}
\end{center}

# Comparison Sorting

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/CompAn01.eps}
\end{center}

This as a series of questions. For some input sequence, S, the first questions is: "Is the value in the $i^{th}$ spot less than the value in the $j^{th}$ spot?"

# Comparison Sorting

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/CompAn01.eps}
\end{center}

This means that by the time we reach a leaf, we will have traversed a path that uniquely identifies the operations to order that sequence.

# Comparison Sorting

* So we have a one-to-one correspondence between an input ordering (permutation) of S and the operation permutation to sort it.

\pause

* Suppose our input was ${3, 1, 2, 4}$. Then every permutation will be represented in the tree, but the only correct permutation will be:
  - ${x_1, x_2, x_0, x_3} = {1, 2, 3, 4}$

# Comparison Sorting

* So we have a one-to-one correspondence between an input ordering (permutation) of S and the operation permutation to sort it.

* We want to find the height of this tree.

* Specifically, we want to find the minimum depth to the deepest node. That will correspond to the fasted, worst case running time (a lower bound).

# Comparison Sorting

* So we have a one-to-one correspondence between an input ordering (permutation) of S and the operation permutation to sort it.

* How many possible permutations of $S = {x_0, x_1, x_2, \ldots, x_{n-1}}$ are there?
\pause
  - n!
\pause
* What can we say about our tree then?
\pause
  - It must have n! leaves.
\pause
* Can we use that to figure out the height of our tree?

# Comparison Sorting

* Recall that for a binary tree, there are at most $2^d$ nodes at depth d.

* So, with n! leaf nodes, they must reside at depth d, where:
  - $n! = 2^d$
  - $d = log(n!)
\pause
* So, our tree has height log(n!). This means that our generic algorithm must execute at least log(n!) comparisons on its worst case input (whatever that may be).

# Comparison Sorting

* It can be shown that,
  - $\log(n!) \geq n/2 \log n/2$

* which means that the running time of our generic algorithm must be at best **n log n**
\pause
* There cannot exist an algorithm that sorts by doing comparisons with a worst case running time of better than **n log n**.
\pause
* This actually holds for average case to. So, **n log n** is the best we can do for comparison sorting.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Read/Review Ch 12, Sections 1 - 4
* Read/Review Ch 9, Section 4
* Review Lecture Notes
* Come to Class
* Work on PP 01
