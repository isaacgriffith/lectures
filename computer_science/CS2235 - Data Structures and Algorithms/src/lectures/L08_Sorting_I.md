---
author:
- Isaac Griffith
title: Sorting I
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
\Huge Sorting I

# Outcomes

At the end of Today's Lecture you will be able to:

* Understand the operation of MergeSort and QuickSort
* Be capable of implementing these algorithms
* Understand the complexity of both MergeSort and QuickSort

# Introduction

"Since the dawn of computing, the sorting problem has attracted a great deal of research, perhaps due to the complexity of solving it efficiently despite its simple, familiar statement." -- Wikipedia

# Sorting

* There are dozens of sorting algorithms each with pros and cons

* You cannot just know a couple sorting algorithms, you need to also know their capabilities and limitations

* We are going to cover to the following Sorting Algorithms in class:
  - MergeSort
  - QuickSort
  - InsertionSort
  - SelectionSort
  - HeapSort
  - BucketSort

#

\vfill
\begin{center}
{\Huge Merge Sort}
\end{center}

# MergeSort

Merge sort is a basic divide and conquer algorithm:

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge01.eps}
\end{center}

# MergeSort

Merge sort is a basic divide and conquer algorithm:

1. Divide. Split input into two equal parts

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge01.eps}
\end{center}

# MergeSort

Merge sort is a basic divide and conquer algorithm:

1. Divide. Split input into two equal parts

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge02.eps}
\end{center}

# MergeSort

Merge sort is a basic divide and conquer algorithm:

2. Conquer. Sort the parts.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge03.eps}
\end{center}

# MergeSort

Merge sort is a basic divide and conquer algorithm:

2. Conquer. Sort the parts.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge04.eps}
\end{center}

# MergeSort

Merge sort is a basic divide and conquer algorithm:

3. Combine. Merge the sorted parts.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge05.eps}
\end{center}

# MergeSort

Merge sort is a basic divide and conquer algorithm:

3. Combine. Merge the sorted parts.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge06.eps}
\end{center}

# MergeSort

Merge sort is a basic divide and conquer algorithm:

3. Combine. Merge the sorted parts.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge07.eps}
\end{center}

# MergeSort

Merge sort is a basic divide and conquer algorithm:

3. Combine. Merge the sorted parts.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge08.eps}
\end{center}


#

\vfill
\begin{center}
{\Huge Understanding MergeSort}
\end{center}

# MergeSort

Let's look at it more in depth for some array A.

Divide: If A has 0 or 1 elements, return A (since it is already sorted). Otherwise, split A into two arrays, $A_1$ and $A_2$, each containing about half of A.

# MergeSort

Let's look at it more in depth for some array A.

Conquer: Recursively call divide on the smaller arrays ($A_1$, $A_2$), then the next smaller array, then the next ones...until the divide method terminates (happens when the arrays are size 0 or 1).

# MergeSort

Let's look at it more in depth for some array A.

Combine: Given the two smaller arrays, $A_1$ and $A_2$, put the elements from them back into A in sorted order.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge09.eps}
\end{center}

# MergeSort

Let's look at it more in depth for some array A.

Combine: Given the two smaller arrays, $A_1$ and $A_2$, put the elements from them back into A in sorted order.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge10.eps}
\end{center}

# MergeSort

Let's look at it more in depth for some array A.

Combine: Given the two smaller arrays, $A_1$ and $A_2$, put the elements from them back into A in sorted order.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge11.eps}
\end{center}

# MergeSort

Let's look at it more in depth for some array A.

Combine: Given the two smaller arrays, $A_1$ and $A_2$, put the elements from them back into A in sorted order.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge11.eps}
\end{center}

# MergeSort

Let's look at it more in depth for some array A.

Combine: Given the two smaller arrays, $A_1$ and $A_2$, put the elements from them back into A in sorted order.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge13.eps}
\end{center}

# MergeSort

Let's look at it more in depth for some array A.

Combine: Given the two smaller arrays, $A_1$ and $A_2$, put the elements from them back into A in sorted order.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge14.eps}
\end{center}

# MergeSort

Let's look at it more in depth for some array A.

Combine: Given the two smaller arrays, $A_1$ and $A_2$, put the elements from them back into A in sorted order.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge15.eps}
\end{center}

# MergeSort

Let's look at it more in depth for some array A.

Combine: Given the two smaller arrays, $A_1$ and $A_2$, put the elements from them back into A in sorted order.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge16.eps}
\end{center}

# MergeSort

Let's look at it more in depth for some array A.

Combine: Given the two smaller arrays, $A_1$ and $A_2$, put the elements from them back into A in sorted order.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge17.eps}
\end{center}

# MergeSort

Let's look at it more in depth for some array A.

Combine: Given the two smaller arrays, $A_1$ and $A_2$, put the elements from them back into A in sorted order.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge18.eps}
\end{center}

# MergeSort

Let's look at it more in depth for some array A.

Combine: Given the two smaller arrays, $A_1$ and $A_2$, put the elements from them back into A in sorted order.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge19.eps}
\end{center}

# MergeSort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge20.eps}
\end{center}

# MergeSort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge21.eps}
\end{center}

# MergeSort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge22.eps}
\end{center}

# MergeSort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge23.eps}
\end{center}

# MergeSort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge24.eps}
\end{center}

# MergeSort - Example

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Merge25.eps}
\end{center}

# MergeSort - Example

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Merge26.eps}
\end{center}

# MergeSort - Example

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Merge27.eps}
\end{center}

# MergeSort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge28.eps}
\end{center}

# MergeSort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge29.eps}
\end{center}

# MergeSort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge30.eps}
\end{center}

# MergeSort - Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module2/Sorting/Merge31.eps}
\end{center}

# MergeSort Running Time

* Given an array of size n, how long will it take for merge sort to run?

# MergeSort Running Time

* Given an array of size n, how long will it take for merge sort to run?

::: columns
:::: {.column width=.75}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Module2/Sorting/Merge32.eps}
\end{center}
::::
:::: {.column width=.25}
What operations do we need to execute for each level?
::::
:::

# MergeSort Running Time

* Given an array of size n, how long will it take for merge sort to run?

::: columns
:::: {.column width=.75}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Module2/Sorting/Merge32.eps}
\end{center}
::::
:::: {.column width=.25}
What operations do we need to execute for each level?
\vskip1em
copy arrays - ?
::::
:::

# MergeSort Running Time

* Given an array of size n, how long will it take for merge sort to run?

::: columns
:::: {.column width=.75}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Module2/Sorting/Merge32.eps}
\end{center}
::::
:::: {.column width=.25}
What operations do we need to execute for each level?
\vskip1em
copy arrays - n
::::
:::

# MergeSort Running Time

* Given an array of size n, how long will it take for merge sort to run?

::: columns
:::: {.column width=.75}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Module2/Sorting/Merge32.eps}
\end{center}
::::
:::: {.column width=.25}
What operations do we need to execute for each level?
\vskip1em
copy arrays - n

merge arrays - ?
::::
:::

# MergeSort Running Time

* Given an array of size n, how long will it take for merge sort to run?

::: columns
:::: {.column width=.75}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Module2/Sorting/Merge32.eps}
\end{center}
::::
:::: {.column width=.25}
What operations do we need to execute for each level?
\vskip1em
copy arrays - n

merge arrays - n
::::
:::

# MergeSort Running Time

* Given an array of size n, how long will it take for merge sort to run?

::: columns
:::: {.column width=.75}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Module2/Sorting/Merge32.eps}
\end{center}
::::
:::: {.column width=.25}
What operations do we need to execute for each level?
\vskip1em
copy arrays - n

merge arrays - n

\vskip1em
So, Total time per level is O(n).
::::
:::

# MergeSort Running Time

* Given an array of size n, how long will it take for merge sort to run?

::: columns
:::: {.column width=.75}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Module2/Sorting/Merge32.eps}
\end{center}
::::
:::: {.column width=.25}
How many levels are there?
::::
:::

# MergeSort Running Time

* Given an array of size n, how long will it take for merge sort to run?

::: columns
:::: {.column width=.75}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Module2/Sorting/Merge32.eps}
\end{center}
::::
:::: {.column width=.25}
How many levels are there?

\vskip1em

O(log(n)) levels
::::
:::

# MergeSort Running Time

* Given an array of size n, how long will it take for merge sort to run?

::: columns
:::: {.column width=.75}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Module2/Sorting/Merge32.eps}
\end{center}
::::
:::: {.column width=.25}
Thus, the running time of merge sort is:
::::
:::

# MergeSort Running Time

* Given an array of size n, how long will it take for merge sort to run?

::: columns
:::: {.column width=.75}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Module2/Sorting/Merge32.eps}
\end{center}
::::
:::: {.column width=.25}
Thus, the running time of merge sort is: O(n log (n))
::::
:::

#

\vfill
\begin{center}
{\Huge MergeSort Coding}
\end{center}

#

\vfill
\begin{center}
{\Huge QuickSort}
\end{center}

# QuickSort

* Similar to merge sort in that it is recursive divide and conquer
\pause
* Recall that for merge sort, all the hard work (merging) is done after the recursive divides.
\pause
* For quick sort, the hard work is all done before the recursive calls.

# QuickSort Overview

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick01.eps}
\end{center}

1. Divide. Pick some element from the array (called the pivot) and split the array into two parts: the part greater than or equal to the pivot, and the part less than the pivot.

# QuickSort Overview

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick02.eps}
\end{center}

1. Divide. Pick some element from the array (called the pivot) and split the array into two parts: the part greater than or equal to the pivot, and the part less than the pivot.

# QuickSort Overview

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick03.eps}
\end{center}

1. Divide. Pick some element from the array (called the pivot) and split the array into two parts: the part greater than or equal to the pivot, and the part less than the pivot.

# QuickSort Overview

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick04.eps}
\end{center}

1. Divide. Pick some element from the array (called the pivot) and split the array into two parts: the part greater than or equal to the pivot, and the part less than the pivot.

# QuickSort Overview

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick05.eps}
\end{center}

2. Split. Recursively call quicksort on the two parts of the array to get them sorted.

# QuickSort Overview

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick06.eps}
\end{center}

2. Split. Recursively call quicksort on the two parts of the array to get them sorted.

# QuickSort Overview

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick07.eps}
\end{center}

2. Split. Recursively call quicksort on the two parts of the array to get them sorted.

# QuickSort Overview

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick08.eps}
\end{center}

The array is now sorted. Why?

# QuickSort Overview

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick09.eps}
\end{center}

The critical element occurred during the divide step

# QuickSort Overview

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick10.eps}
\end{center}

The critical element occurred during the divide step, when we divided the array so that everything in green is less than everything in blue

# QuickSort Overview

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick11.eps}
\end{center}

So, that means that if we can sort everything in green and everything in blue, then the entire thing will be sorted as well.

#

\vfill
\begin{center}
{\Huge QuickSort Detail}
\end{center}

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick12.eps}
\end{center}

Let's think about it in a little more detail. First we need a pivot.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick13.eps}
\end{center}

Let's think about it in a little more detail. First we need a pivot. Let's make our pivot the last value in the array (or sub array).

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick13.eps}
\end{center}

Then, we need to move everything around so that the array is divided into stuff that's smaller, and stuff that's larger (or equal) to the pivot.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick14.eps}
\end{center}

Then, we need to move everything around so that the array is divided into stuff that's smaller, and stuff that's larger (or equal) to the pivot.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick15.eps}
\end{center}

First, let's make pointers to the front and back of our array:
  - The left pointer is looking for values that are larger or equal to the pivot
  \pause
  - The right pointer is looking for values that are smaller than the pivot.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick15.eps}
\end{center}

First, let's make pointers to the front and back of our array:
  - If left and right both find values that they are looking for, we will swap those values.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick15.eps}
\end{center}

left = 85 which IS $\geq$ pivot (50). Thus, the left pointer found a troublesome value.

\pause

right = 96 which is NOT < pivot (50). So, right is going to decrement and keep looking.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick16.eps}
\end{center}

left = 85 which IS $\geq$ pivot (50). Thus, the left pointer found a troublesome value.

\pause

right = 96 which is NOT < pivot (50). So, right is going to decrement and keep looking.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick17.eps}
\end{center}

left = 85 which IS $\geq$ pivot (50). Thus, the left pointer found a troublesome value.

\pause

right = 31 which IS < pivot (50). Thus, the right pointer found a troublesome value too.


# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick18.eps}
\end{center}

left = 85 which IS $\geq$ pivot (50). Thus, the left pointer found a troublesome value.

\pause

right = 31 which IS < pivot (50). Thus, the right pointer found a troublesome value too.


# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick19.eps}
\end{center}

left = 85 which IS $\geq$ pivot (50). Thus, the left pointer found a troublesome value.

\pause

right = 31 which IS < pivot (50). Thus, the right pointer found a troublesome value too.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick19.eps}
\end{center}

\pause

left = 24 which is NOT $\geq$ pivot (50). So, left is going to increment and keep looking.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick20.eps}
\end{center}

\pause

left = 24 which is NOT $\geq$ pivot (50). So, left is going to increment and keep looking.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick20.eps}
\end{center}

left = 63 which IS $\geq$ pivot (50). Thus, the left pointer found a troublesome value.

\pause

right = 17 which IS < pivot(50). Thus, the right pointer found a troublesome value too.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick21.eps}
\end{center}

left = 63 which IS $\geq$ pivot (50). Thus, the left pointer found a troublesome value.

right = 17 which IS < pivot(50). Thus, the right pointer found a troublesome value too.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick22.eps}
\end{center}

left = 63 which IS $\geq$ pivot (50). Thus, the left pointer found a troublesome value.

right = 17 which IS < pivot(50). Thus, the right pointer found a troublesome value too.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick23.eps}
\end{center}

left = 63 which IS $\geq$ pivot (50). Thus, the left pointer found a troublesome value.

right = 17 which IS < pivot(50). Thus, the right pointer found a troublesome value too.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick23.eps}
\end{center}

Now what?

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick24.eps}
\end{center}

left = 45 which is NOT $\geq$ pivot(50). So, increment left and keep looking.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick24.eps}
\end{center}

Now left > right, so stop. What do we know?
\pause
1. Everything from left onward is $\geq$ pivot
2. Everything before left is < pivot.
\pause

The last thing to do is swap left and pivot.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick25.eps}
\end{center}

Now left > right, so stop. What do we know?
\pause
1. Everything from left onward is $\geq$ pivot
2. Everything before left is < pivot.
\pause

The last thing to do is swap left and pivot.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick26.eps}
\end{center}

Now left > right, so stop. What do we know?
\pause
1. Everything from left onward is $\geq$ pivot
2. Everything before left is < pivot.
\pause

The last thing to do is swap left and pivot. Then, the pivot is in its final spot (it is sorted relative to the rest of the array).

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick27.eps}
\end{center}

Now left > right, so stop. What do we know?
\pause
1. Everything from left onward is $\geq$ pivot
2. Everything before left is < pivot.
\pause

The last thing to do is swap left and pivot. Then, the pivot is in its final spot (it is sorted relative to the rest of the array).

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick27.eps}
\end{center}

So, we have accomplished the divide step.

\pause

We now recursively call quickSort() on the sub arrays.

\pause

How do we reference the sub arrays?

\pause

What if quickSort() took three parameters, the array, the start index, and the end index?

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick28.eps}
\end{center}

\pause

First quickSort() call:

Array = **A**

\pause

startIndex = ?  What is the first index of the subarray we wish to sort?

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick29.eps}
\end{center}

First quickSort() call:

Array = **A**

startIndex = 0  What is the first index of the subarray we wish to sort?

\pause

endIndex = ?  What is the final index of the subarray we wish to sort?

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick30.eps}
\end{center}

First quickSort() call:

Array = **A**

startIndex = 0  What is the first index of the subarray we wish to sort?

endIndex = array.length - 1  What is the final index of the subarray we wish to sort?

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick31.eps}
\end{center}

Back to the second quickSort() call.

\pause

What are the start and end indices of the subarray we wish to call quickSort() on?

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick32.eps}
\end{center}

Back to the second quickSort() call.

What are the start and end indices of the subarray we wish to call quickSort() on?

\pause

::: columns
:::: column
start1 = ?

end1 = ?
::::
:::: column
start2 = ?

end2 = ?
::::
:::

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick32.eps}
\end{center}

Back to the second quickSort() call.

What are the start and end indices of the subarray we wish to call quickSort() on?

\pause

::: columns
:::: column
start1 = startIndex

end1 = left - 1
::::
:::: column
start2 = left + 1

end2 = endIndex
::::
:::

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick33.eps}
\end{center}

Let's look at the first subarray. What do we do?
\pause

* Make the last value the pivot

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick34.eps}
\end{center}

Let's look at the first subarray. What do we do?

* Make the last value the pivot

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick35.eps}
\end{center}

Let's look at the first subarray. What do we do?

* Make the last value the pivot
* Get left and right pointers

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick36.eps}
\end{center}

Let's look at the first subarray. What do we do?

* Make the last value the pivot
* Get left and right pointers
* Move things around until left > right. (nothing moves here since everything is less than pivot of 45).

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick36.eps}
\end{center}

Recursively call quickSort() with:

::: columns
:::: column
startL = ?

endL = ?
::::
:::: column
startR = ?

endR = ?
::::
:::

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick36.eps}
\end{center}

Recursively call quickSort() with:

::: columns
:::: column
startL = start1

endL = left - 1
::::
:::: column
startR = ?

endR = ?
::::
:::


# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick36.eps}
\end{center}

Recursively call quickSort() with:

::: columns
:::: column
startL = start1

endL = left - 1
::::
:::: column
startR = left + 1

endR = end1
::::
:::

\pause
Problem?

\pause
When do we stop recursively calling quickSort()?

I.e. When is an array guaranteed to be sorted?

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick36.eps}
\end{center}

Recursively call quickSort() with:

::: columns
:::: column
startL = start1

endL = left - 1
::::
:::: column
startR = left + 1

endR = end1
::::
:::

Problem?

When do we stop recursively calling quickSort()?

Whenever the array has size 1 or less.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick36.eps}
\end{center}

Recursively call quickSort() with:

::: columns
:::: column
startL = start1

endL = left - 1
::::
:::: column
startR = left + 1

endR = end1
::::
:::

How do we tell if the array being sorted has size at most 1?

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick36.eps}
\end{center}

Recursively call quickSort() with:

::: columns
:::: column
startL = start1

endL = left - 1
::::
:::: column
startR = left + 1

endR = end1
::::
:::

How do we tell if the array being sorted has size at most 1? array.length?
\pause

No, because we pass the full array each time.

# QuickSort - Detail

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick36.eps}
\end{center}

Recursively call quickSort() with:

::: columns
:::: column
startL = start1

endL = left - 1
::::
:::: column
startR = left + 1

endR = end1
::::
:::

How do we tell if the array being sorted has size at most 1?

if startIndex $\geq$ endIndex, then the array is sorted.

# Quick Sort Running Time

* Given an array of size n, how long will it take for quick sort to run?
\pause
* What is the best case scenario for quickSort()?
\pause
  - If it divides the array in half each time.

# Quick Sort Running Time

* Given an array of size n, how long will it take for quick sort to run?

* Suppose it divides the array in half each time. What is the height of our recursion tree?
\pause
  - O(log n) just like mergeSort()
\pause
* How many operations does it take to divide our array?
\pause
  - O(n), because we pass through the array once swapping "troublesome" values.
\pause
* So, how long does it take for quickSort() to run in the best case?
\pause
  - O(n log n)

# Quick Sort Running Time

* Given an array of size n, what is the worst case running time for quickSort()?
\pause
* Suppose one of the subarrays is empty each iteration.
* What is the height of the recursion tree then?
\pause
  - O(n), since each recursive call only removes one element from the next subarray.
\pause
* How many operations to divide the array?
\pause
  - Still O(n) because we still go through the whole thing.
\pause
* So, how long does it take for quickSort() to run in the worst case?
\pause
  - $O(n^2)$

# Quick Sort Running Time

* Given an array of size n, what is the worst case running time for quickSort()?
* Another way to see this is to add up the number of operations per level:
  - $n + (n - 1) + (n - 2) + \ldots + 2 + 1 = (n^2 + n) / 2$
  - which is in $O(n^2)$

# Quick Sort Running Time

* Given an array of size n, what is the worst case running time for quickSort()?
* When can this situation arize? What sort of input an cause our quickSort() method to take $O(n^2)$ time?
\pause
* What input will cause all values to be on one side of the pivot?
\pause
* Sorted input!!!
\pause
\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick37.eps}
\end{center}

# Quick Sort Running Time

* Given an array of size n, what is the worst case running time for quickSort()?
* When can this situation arise? What sort of input an cause our quickSort() method to take $O(n^2)$ time?
* What input will cause all values to be on one side of the pivot?
* Sorted input!!!

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick38.eps}
\end{center}

# Quick Sort Running Time

* Given an array of size n, what is the worst case running time for quickSort()?
* When can this situation arise? What sort of input an cause our quickSort() method to take $O(n^2)$ time?
* What input will cause all values to be on one side of the pivot?
* Sorted input!!!

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick39.eps}
\end{center}

# Quick Sort Running Time

* Given an array of size n, what is the worst case running time for quickSort()?
* When can this situation arise? What sort of input an cause our quickSort() method to take $O(n^2)$ time?
* What input will cause all values to be on one side of the pivot?
* Sorted input!!!

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick40.eps}
\end{center}

# Quick Sort Running Time

* Given an array of size n, what is the worst case running time for quickSort()?
* When can this situation arise? What sort of input an cause our quickSort() method to take $O(n^2)$ time?
* What input will cause all values to be on one side of the pivot?
* Sorted input!!!

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module2/Sorting/Quick41.eps}
\end{center}

# Quick Sort Running Time

* Given an array of size n, what is the worst case running time for quickSort()?
* When can this situation arise? What sort of input an cause our quickSort() method to take $O(n^2)$ time?
* What input will cause all values to be on one side of the pivot?
* Sorted input!!!

* Can we do anything to reduce the likelihood of this situation arising?
\pause
  - What if we pick the pivot value at random?

# Quick Sort Space Complexity

* Given an array of size n, how much extra space (beyond the initial array) does quick sort need?
\pause
  - None? Constant?

# Quick Sort Space Complexity

* Given an array of size n, how much extra space (beyond the initial array) does quick sort need?
* How much space do we need for one iteration of quickSort()?
\pause
  - Constant: pivot, left, right, temp...
\pause
* So, does that mean we need constant space?
\pause
* How many iterations of quickSort() can we have running at once (optimally)?
\pause
  - O(log n) => space needed = O(log n)

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Review Lecture Notes
* Read/Review Ch 12 Sections 1 - 4
* Read Ch 9 Section 4
* Finish PA 01
* Come to Class
