---
author:
- Isaac Griffith
title: Lists II
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
\Huge Lists II

# Outcomes

At the end of Today's Lecture you will be able to:

* Understand the concept of the Sentinel Node
* Understand and be able to implement a Doubly Linked List
* Understand the basic design of the lists data structures

\vfill
\begin{center}
{\Huge Doubly Linked Lists}
\end{center}

# Node, Redefined

* The basic node is modified to include an extra reference to the previous node in the sequence.

\begin{center}
\includegraphics[width=.7\textwidth]{images/Module3/Lists/dll_01-1}
\end{center}

# Sentinel Nodes

* Nodes which are ever present and guard the head and tail of the list.
* Sentinel nodes contain no data, but ease the development of a doubly linked list.

\begin{center}
\includegraphics[width=.7\textwidth]{images/Module3/Lists/dll_01-2}
\end{center}

* Note: Either the prev or next reference will always be null.

# Doubly Linked List

* A list consisting of nodes, linked to the next node and previous node in the series, in between a pair of head and tail sentinel nodes
* Potential applications?

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_02}
\end{center}

# Doubly Linked List

* Potential applications?
  - Browser history
  - Undo

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_02}
\end{center}

# List Operations: AddLast

1. Create New Node

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_03}
\end{center}


# List Operations: AddLast

1. Create New Node
   - `prev = tail.getPrev()``
   - `next = tail`

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_04}
\end{center}

# AddLast

2. Set tail.prev.next to NewNode
3. Set tail.prev to NewNode

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_05}
\end{center}

# AddFirst

1. Create new Node

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_07}
\end{center}

# AddFirst

1. Create new Node
   - `prev = head`
   - `next = head.getNext()``

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_08}
\end{center}

# AddFirst


2. Set head.next to NewNode
3. Set NewNode.next.prev to NewNode

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_09}
\end{center}


# RemoveFirst

1. Create reference temp to head.getNext()

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_11}
\end{center}

# RemoveFirst

2. Set head.next to temp.getNext()
3. Set temp.next.prev to head
4. Set temp.next and temp.prev to null


\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_13}
\end{center}


# RemoveFirst

5. Set temp.next and temp.prev to null

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_14}
\end{center}

# RemoveFirst

5. Set temp.next and temp.prev to null

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_15}
\end{center}

# RemoveLast

1. Create reference temp to tail.getPrev()

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_16}
\end{center}

# RemoveLast

2. Set tail.prev to temp.getPrev()

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_17}
\end{center}

# RemoveLast

3. Set temp.prev.next to tail

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_18}
\end{center}

# RemoveLast

4. Set temp.prev and temp.next to null

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_19}
\end{center}

# RemoveLast

4. Set temp.prev and temp.next to null

\begin{center}
\includegraphics[width=.8\textwidth]{images/Module3/Lists/dll_20}
\end{center}

# Remove

1. Starting at head or tail (depending on which is closer to location to remove) create a temporary reference to the next or prev node.

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_21}
\end{center}

# Remove

2. Using a while or for lop move towards the removal location by calling getNext() or getPrev() and reassigning the temp variable to the result of that method call.

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_22}
\end{center}

# Remove

2. Once temp = the location you wish to remove
3. Set temp.next.prev = temp.getPrev()
4. Set temp.prev.next = temp.getNext()

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_23}
\end{center}

# Remove

5. Set temp.next and temp.prev to null

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_24}
\end{center}

# Insert

1. Create a new node
2. Starting at head or tail create a temporary reference to the next or prev node.

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module3/Lists/dll_26}
\end{center}

# Insert

3. Using a while or for loop move towards the insertion location by calling getNext() or getPrev() and reassigning the temp variable to the result of that method call

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module3/Lists/dll_25}
\end{center}

# Insert

3. Once temp = the location next to where you want to insert create a new node.
   - `next = temp.getNext()``
   - `prev = temp`

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_27}
\end{center}

# Insert

4. Set temp.next to the new node
5. Set NewNode.next.prev to NewNode

\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Lists/dll_28}
\end{center}

#

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module3/Lists/design}
\end{center}

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Read Ch 6 Sections 1 - 3
* Review prior Lectures
* Finish and Submit PP 01
* Continue working on PA 02
* Come to class!
