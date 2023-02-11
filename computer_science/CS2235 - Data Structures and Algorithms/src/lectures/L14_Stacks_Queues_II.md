---
author:
- Isaac Griffith
title: Stacks and Queues II
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
\Huge Stacks and Queues II

# Outcomes

At the end of Today's Lecture you will be able to:

* Understand the basic operations and uses of the following ADTs
  - Queue
  - Deque
  - Priority Queue
* Understand and be capable of implement the operations required for a:
  - Queue
  - Deque
  - Priority Queue
* Understand the concept of Lazy Evaluation

# Queue ADT

* Recall that a Stack is a collection of objects that are accessed in a **last in, first out** fashion.
* A Queue is a collection of objects that are accessed in a **first in, first out** fashion.
\pause
* That is, the first object added to the collection is the first removed.
* Some examples:
\pause  
  * Lines. (Grocery checkout, toll lanes)

# Stack vs. Queue

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module3/Queues/queues_01}
\end{center}

# Queue ADT Operations

* `offer(e)` -- Add the object **e** to the back of the queue.
\vskip1em
* `poll()` -- Removes and returns the object from the front of the queue
\vskip1em
* `peek()` -- Returns, but does not remove, the object from the front of the queue.
\vskip1em
* `size()` -- Returns the number objects that are in the queue.

# Queue ADT Operations Example

::: columns
:::: column
```{=latex}
Operations:\\
\hspace{1em}offer(5)\\
\only<2->{\hspace{1em}offer(10)\\}
\only<3->{\hspace{1em}offer(3)\\}
\only<4->{\hspace{1em}poll() $\longleftarrow$ 5\\}
\only<5->{\hspace{1em}poll() $\longleftarrow$ 10\\}
\only<6->{\hspace{1em}offer(4)\\}
\only<7->{\hspace{1em}size() $\longleftarrow$ 2\\}
\only<8->{\hspace{1em}peek() $\longleftarrow$ 3\\}
```
::::
:::: column
\vskip2em
\begin{tabular}{|c|}
 \only<1,2,3>5\only<4>{10}\only<5->3\\
 \only<2,3>{10}\only<4>3\only<6->4\\
 \only<3>3\\
 \\
 \\
 \\
 \\
 \hline
\end{tabular}
::::
:::


# Queue Implementation

* How could we implement a queue?
\pause
 1. Linked List. Keep track of the head and tail. Add to back and remove from front.
 \vskip2em
 2. Array. Make an array to hold the objects. Use a pointer to point to the top of the queue and one to point to the bottom.

# LinkedListQueue

::: columns
:::: {.column width=.6}
```java
public class LinkedLIstQueue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    // add to back
    public void offer(E e) {}

    // remove from front
    public E poll() {}

    // look at front
    public E peek() {}
}
```
::::
:::: {.column width=.4}
\begin{center}
\includegraphics[width=1.0\textwidth]{images/Module3/Queues/queues_02}
\end{center}
::::
:::

# ArrayQueue

::: columns
:::: {.column width=.6}
```java
public class ArrayQueue<E> {
    private E[] queue;
    private int top = 0;
    private int bottom;

    // add to back
    public void offer(E e) {}

    // remove from front
    public E poll() {}

    // look at front
    public E peek() {}
}
```
::::
:::: {.column width=.4}
\begin{center}
 \includegraphics[width=.75\textwidth]{images/Module3/Queues/queues_03}
\end{center}
::::
:::

#

\begin{center}
{\Huge Deques}
\end{center}

# Basic Queue

\begin{center}
\includegraphics[width=.25\textwidth]{images/Module3/Queues/adv_q_01}
\end{center}

# Double Ended Queue

\vspace{-1em}
\begin{center}
Written: Deque\hspace{2.5em}Pronounced: "Deck"
\end{center}

::: columns
:::: column
\begin{center}
\vspace{-3em}
\includegraphics[width=.95\textwidth]{images/Module3/Queues/adv_q_02}
\end{center}
::::
:::: column
\pause
How could we implement this?
\pause
* Doubly-Linked List
* Arrays?
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
With your current understanding which data structures would we need and how would you go about performing these tasks:
\begin{itemize}
\item Reversing a List?
\item Reversing a Stack?
\item Reversing a Queue?
\end{itemize}

\end{minipage}
\vskip1em
\begin{minipage}{50pt}
\includegraphics[width=50pt]{images/idea.png}
\end{minipage}
\begin{minipage}[adjusting]{4in}
Pair up with your neighbor and take the next few minutes to discuss your thoughts.
\end{minipage}

#

\begin{center}
{\Huge Priority Queue}
\end{center}

# Priority Queue

::: columns
:::: column
\vspace{-2em}
\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Queues/priority_q_01}
\end{center}
::::
:::: column
Operations:

* insert: Add some data and its priority to the queue.
\vskip1em
* remove: Remove the first occurrence of the highest priority element
::::
:::

# Priority Queue

::: columns
:::: column
\vspace{-2em}
\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Queues/priority_q_01}
\end{center}
::::
:::: column
Operations:

* insert: Add some data and its priority to the queue.
\vskip1em
* remove: Remove the first occurrence of the highest priority element
::::
:::

# Priority Queue

::: columns
:::: column
\vspace{-2em}
\begin{center}
\includegraphics[width=.9\textwidth]{images/Module3/Queues/priority_q_01}
\end{center}
::::
:::: column
How could we implement this?
\pause

* Linked List
* Element class <data, priority>
* insert -> addInOrder()
* remove -> removeFirst()
::::
:::

#

\begin{center}
{\Huge Lazy Evaluation}
\end{center}

# Lazy Evaluation

* Java (and many other languages) employ a technique called lazy evaluation when evaluating Boolean statements.
\pause
```java
 if (condition1 && condition2 && condition3) {
    // do something
 }
```
* To see if this evaluates to true, we have to make sure each condition evaluates to true.
* But, to see if it evaluates to false, we only need one condition to evaluate to false.
\pause
* So...Lazy evaluation is the process of checking each condition, one at a time, and stopping as soon as possible.

# Lazy Evaluation

* Java (and many other languages) employ a technique called lazy evaluation when evaluating Boolean statements.
\pause
```java
 if (condition1 || condition2 || condition3) {
    // do something
 }
```
* To see if this is true, we need only find one value that is true.
* To see if this is false, all conditions must evaluate to false.

# Lazy Evaluation

* This means that I can manipulate my conditions in a way that avoids errors, but checks what I want:
```java
 Node n;

 if (n.getElement() < 10 && n != null) {
   // do something
 }
```
* This will throw a null pointer exception if n is null, because the first thing that is checked involves a method call on n's object.

# Lazy Evaluation

* This means that I can manipulate my conditions in a way that avoids errors, but checks what I want:
```java
 Node n;

 if (n != null && n.getElement() < 10) {
   // do something
 }
```
* This will avoid that exception, because the first thing to be checked is in n is null. If it is null, the entire compound condition will be false, so checking the element is never done.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Read Ch 8
* Finish PA 02
* Start PP 02
* Review Prior Lectures
* Come to Class!
