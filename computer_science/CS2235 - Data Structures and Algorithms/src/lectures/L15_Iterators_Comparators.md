---
author:
- Isaac Griffith
title: Iterators and Comparators
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

*

# Introduction

#

\vfill
\begin{center}
{\Huge Concept 1}
\end{center}

# Iterators

* Suppose we have a linked list filled with things.

\pause

\begin{center}
\includegraphics[]{}
\end{center}

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

\begin{center}
\includegraphics[]{}
\end{center}

`Node current = head`

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

\begin{center}
\includegraphics[]{}
\end{center}

`current = current.getNextNode()`

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

\begin{center}
\includegraphics[]{}
\end{center}

`current = current.getNextNode()`

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

* Why would we want to traverse it?

# Iterators

* Suppose we have a linked list filled with things. How do we traverse it?

* Why would we want to traverse it? Any number of reasons:
  - Print elements to the screen
  - Save elements to file.
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

* Is there a better way? Iterators are a structured way of traversing lists. The task performed is implemented by the person using the iterator (i.e., the customer).

# Iterators

* The iterator will merely keep track of where we are in the list and provide the following methods:

  - `public boolean hasNext()` - Indicates if there is a next object
  - `public Object next()` - returns the next object and moves on to that next object

\pause

What have we just described?

# Iterators

* The iterator will merely keep track of where we are in the list and provide the following methods:

```java
public interface Iterator<E> {
  // indicates if there is a next object
  boolean hasNext();

  // returns the next object and moves on
  // to that next object
  E next();
}
```

# Iterators

* The iterator will merely keep track of where we are in the list and provide the following methods:

  - `boolean hasNext()`
  - `E next()`

* The fact there is an interface that dictates how traversing a list occurs is very powerful. Why?

# Iterators

* The iterator will merely keep track of where we are in the list and provide the following methods:

  - `boolean hasNext()`
  - `E next()`

* The fact there is an interface that dictates how traversing a list occurs is very powerful. Why?
  - The user can traverse a structure and define actions (print, save, compare, ...), without having any idea what the structure is (array, linked list, tree, ...).
