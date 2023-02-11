---
author:
- Isaac Griffith
title: Lists I
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
\Huge Arrays and Lists

# Outcomes

At the end of Today's Lecture you will be able to:

* Understand and be capable of implementing a Singly Linked List
* Understand and be capable of implementing a Circularly Linked List
* Understand and be

#

\vfill
\begin{center}
\includegraphics[width=.45\textwidth]{images/Modules/module03.eps}
\end{center}

#

\vfill
\begin{center}
{\Huge Lists}
\end{center}

# Lists

Suppose we want to keep track of the top 5 rated books on Amazon. Our application will have the following properties:

1. It will be able to accept books, and add them to the list if they have enough stars (top 5).
2. It will be able to have books from the list removed.
3. It will be able to print out the list in order.


# Lists

1. It will be able to accept books, and add them to the list if they have enough stars (top 5).
    1. Unbroken -- 4.8
    2. All the Light We Cannot See -- 4.6
    3. American Sniper -- 4.5
    4. The Girl on the Train -- 4.4
    5. Publication Manual -- 4.1

\begin{center}
Add Book: {\color{Roarange} The Life-Changing Magic of Tidying Up -- 4.5}
\end{center}

# Lists

1. It will be able to accept books, and add them to the list if they have enough stars (top 5).
    1. Unbroken -- 4.8
    2. All the Light We Cannot See -- 4.6
    3. The Life-Changing Magic of Tidying Up -- 4.5
    4. American Sniper -- 4.5
    5. The Girl on the Train -- 4.4
    6. \St{Publication Manual -- 4.1}

\begin{center}
Add Book: {\color{Roarange} The Life-Changing Magic of Tidying Up -- 4.5}
\end{center}

# Lists

1. It will be able to accept books, and add them to the list if they have enough stars (top 5).
    1. Unbroken -- 4.8
    2. All the Light We Cannot See -- 4.6
    3. The Life-Changing Magic of Tidying Up -- 4.5
    4. American Sniper -- 4.5
    5. The Girl on the Train -- 4.4

\begin{center}
Add Book: {\color{Roarange} Zero Belly Diet -- 3.7}
\end{center}

# Lists

2. It will be able to have books from the list removed
    1. Unbroken -- 4.8
    2. All the Light We Cannot See -- 4.6
    3. The Life-Changing Magic of Tidying Up -- 4.5
    4. American Sniper -- 4.5
    5. The Girl on the Train -- 4.4

Remove Book: {\color{red} 2}

# Lists

2. It will be able to have books from the list removed
    1. Unbroken -- 4.8
    2. \St{All the Light We Cannot See -- 4.6}
    3. The Life-Changing Magic of Tidying Up -- 4.5
    4. American Sniper -- 4.5
    5. The Girl on the Train -- 4.4

Remove Book: \color{red} 2

# Lists

2. It will be able to have books from the list removed
    1. Unbroken -- 4.8
    2. The Life-Changing Magic of Tidying Up -- 4.5
    3. American Sniper -- 4.5
    4. The Girl on the Train -- 4.4

Remove Book: \color{red} 2

# Lists

1. It will be able to print out the list in order.

Output:
```
 1) Unbroken -- 4.8
 2) All the Light We Cannot See -- 4.6
 3) American Sniper -- 4.5
 4) The Girl on the Train -- 4.4
 5) Publication Manual -- 4.1
```

#

\vfill
\begin{center}
{\Huge Implementation}
\end{center}

# Implementation

How can we implement this?

\pause

Well, we only really know about arrays, so may as well use those.

# Implementation

Are there any problems with using an array?

1. Insertions and deletions take a while
2. Would be tough to do this for an arbitrary long list

\pause This sounds like a job for: Linked Lists

# Basic Concept -- The Node

* A Node is simply a container for data
* It also holds references to one or more other nodes.
* Nodes form the basis of most common data structures.

\begin{center}
\includegraphics[width=.5\textwidth]{images/Module3/Lists/sll_01}
\end{center}

# Basic Concept -- The Node

* Initially the references to another node is null

\begin{center}
\includegraphics[width=.25\textwidth]{images/Module3/Lists/sll_02}
\end{center}

# Basic Concept -- The Node

* Initially the references to another node is null
* But over time as we acquire more data, we create new nodes and link them together.
* This forms a List.

\begin{center}
\includegraphics[width=.5\textwidth]{images/Module3/Lists/sll_03}
\end{center}

#

\vfill
\begin{center}
{\Huge Singly Linked Lists}
\end{center}

# Singly-Linked Lists

* A data structure composed of a series of nodes, each having a link to the next node.

\begin{center}
\includegraphics[width=.8\textwidth]{images/Module3/Lists/sll_04}
\end{center}

# Singly-Linked Lists

* A data structure composed of a series of nodes, each having a link to the next node.
* The SinglyLinkedList class contains a reference to the front of the list called head.
* Optionally a reference to the end of the list, called tail, can also be used.

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_05}
\end{center}

# Basic List Operations

* `first()` -- Retrieve value of first element
* `last()` -- Retrieve value of last element
* `addFirst(item)` -- Add the given item to front of list
* `addLast(item)` -- Add the give item to end of list
* `removeFirst()` -- Remove the first element of the list
* `removeLast()` -- Remove the last element of the list
* `size()` -- Retrieve the number of elements in the list
* `isEmpty()` -- Test if the list is empty

# Advanced List Operations

* `insert(item, ndx)` -- Inserts given item at specified index
* `remove(ndx)` -- Removes item at specified indx
* `get(ndx)` -- Retive element value at specified index

#

\vfill
\begin{center}
{\Huge SLL Operations}
\end{center}

# Operations

* The basic operations are quite easy to implement, if we maintain both a reference to the head and tail of the list.
* `first()` and `last()` simply require us to ask the head and tail, respectively, for their value.
* `size()` and `isEmpty()` are easy if we also maintain a variable which tracks such information.

# Operations -- addFirst()

1. Create the new Node

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_06}
\end{center}

# Operations -- addFirst()

2. Set the new node's next reference to the current head

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_07}
\end{center}

# Operations -- addFirst()

3. Set List's head reference to the new node

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_08}
\end{center}

# Operations -- addLast()

1. Create the new Node

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_09}
\end{center}

# Operations -- addLast()

2. Set List's tail reference next to the new node.

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_10}
\end{center}

# Operations -- addLast()

3. Set List's tail reference to the new node.

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_11}
\end{center}

# Operations -- removeFirst()

1. Create a temporary reference and set it to head

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_12}
\end{center}

# Operations -- removeFirst()

2. Set List's head reference to head's next reference

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_13}
\end{center}

# Operations -- removeFirst()

3. Set temp's next reference to null

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_14}
\end{center}

# Operations -- removeLast()

1. Create a temporary reference to head

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_15}
\end{center}

# Operations -- removeLast()

2. Using `temp.getNext()` iterate while `temp.getNext() != null` or iteration `count < size - 1` setting `temp = temp.getNext()`

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_16}
\end{center}

# Operations -- removeLast()

3. Set temp's next reference to null

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_17}
\end{center}

# Operations -- removeLast()

4. Set List's tail reference to temp.

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_18}
\end{center}

#

\vfill
\begin{center}
{\Huge SLL Advanced Ops}
\end{center}

# Operations -- Advanced

* `remove(int ndx)`
  * Same as `removeLast()`, but we simply stop at the provided index - 1.

* `get(int ndx)`
  * Use the same step 1 as `removeLast()` and `remove()`, but we go until we reach the index specified and simply returns the value held by that node.

# Remove

1. Create a temporary reference to head

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_19}
\end{center}

# Remove

2. Using `temp.getNext()` iterate until `count < ndx` setting `temp = temp.getNext()`

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_20}
\end{center}

# Remove

3. Set temp's next reference to `temp.getNext().getNext()`

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_21}
\end{center}

# Remove

4. Set temp's next reference to `null`.

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_22}
\end{center}

# Insert

1. Create a temporary reference to head, and walk to `ndx`. Create a new Node for the data to be inserted.

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_23}
\end{center}

# Insert

2. Using `temp.getNext()` iterate until `count < ndx` setting `temp = temp.getNext()`.

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_24}
\end{center}

# Insert

3. Set the `newNode.next = temp.getNext()`

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_25}
\end{center}

# Insert

4. Set temp's next to be the new node.

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/sll_26}
\end{center}

# Implementation Notes

* Need to decide what to do if the Element provided is equal to null.
* Need to decide how to handle removal when the list is empty.
* Need to decide how to handle indexes that are greater than the size of the list or less than 0.

# Circularly Linked List

* A Singly Linked List whose tail's next reference points to the head reference

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/cll_01}
\end{center}

# Circularly Linked List

* How would we implement this?

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/cll_01}
\end{center}

\pause

* No change to the node class, we need only ensure that the first element points to itself when the list is initialized.

# Circularly Linked List

* When could this be useful?

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/cll_01}
\end{center}

\pause
* Keeping track of whose turn it is.
* Representing circular paths (i.e., scavenger hunts).

# Array vs. Linked List

\begin{tabulary}{\linewidth}{|L|L|L|}
\hline
\textbf{List Type} & \textbf{Array} & \textbf{Linked List} \tabularnewline
\hline
Accessing a specific spot & \only<2->{\cellcolor{green!25}Can go directly to any spot.} & \only<2->{\cellcolor{red!25}Need to traverse the list to access a spot.}\tabularnewline
\hline
Insert at beginning & \only<3->{\cellcolor{red!25}Need to shift everything below it down.} & \only<3->{\cellcolor{green!25}Don't need to shift anything.}\tabularnewline
\hline
Insert at end & \only<4->{\cellcolor{yellow!25}Easy...unless we need to resize the array.} & \only<4->{\cellcolor{green!25}Easy...so long as we have our tail pointer.}\tabularnewline
\hline
Insert in middle & \only<5->{\cellcolor{yellow!25}Search time + shifting down.} & \only<5->{\cellcolor{yellow!25}Search time.}\tabularnewline
\hline
Remove from beginning & \only<6->{\cellcolor{red!25}Need to shift everything up.} & \only<6->{\cellcolor{green!25}Just move head pointer.}\tabularnewline
\hline
Remove from end & \only<7->{\cellcolor{yellow!25}Easy...unless we need to resize the array.} & \only<7->{\cellcolor{green!25}Just move tail pointer and dereference old tail.}\tabularnewline
\hline
\cellcolor{white}Remove from middle & \only<1-7>{\cellcolor{white}}\only<8->{\cellcolor{yellow!25}Search time + shifting up.} & \only<1-7>{\cellcolor{white}}\only<8->{\cellcolor{yellow!25}Search time.}\tabularnewline
\hline
\end{tabulary}

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Read Ch 3 Sections 3.4 - 3.6
* Review prior lectures
* Continue working on PP 01
* Start working on PA 02
* Come to Class!
