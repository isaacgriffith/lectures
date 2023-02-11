---
author:
- Isaac Griffith
title: Stacks and Queues I
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
\Huge Stacks and Queues I

# Outcomes

At the end of Today's Lecture you will be able to:

* Understand the basic operations of the Stack ADT
* Be capable of implementing a stack based on the following underlying data structures:
  - Array
  - LinkedList

# Abstract Data Type

* An Abstract Data Type (ADT) is a conceptual model of organizing and accessing data.
* An ADT is defined by the operations that may be performed on it.
* An ADT specifies \underline{\textit{what}} each operation does, but not \underline{\textit{how}}.
* We use Interfaces to represent this "what but not how" concept.

# Interaces and ADTs

* An Interface is a contract for what capability will be provided by some class.
* An ADT is a list of operations that may be performed.

\vskip2em

\begin{center}
Thus, an Interface is an ADT
\end{center}

# Interfaces and ADTs Example

```java
public interface List<E>() {

    void addFirst(E e);
    void addLast(E e);
    E get(int index);
}
```

```java
public class ArrayList<E> implements List<E> {
    // all the methods from the list interface using an array
}

public class SinglyLinkedList<E> implements List<E> {
    // all the methods from the List interface on a linked list
}
```

# Interfaces and ADTs Example

Now a user can use ANY implementation of the List interface, because they know that methods are available to them.

```java
public interface List<E>() {

    void addFirst(E e);
    void addLast(E e);
    E get(int index);
}

public class NaiveUser {
    List list;
    list.get(7);
    list.get(3);
}
```


# Interfaces and ADTs Example

The specific implementation they choose should depend on their intended use, and the efficiency of the implementation.

```java
public interface List<E>() {

    void addFirst(E e);
    void addLast(E e);
    E get(int index);
}

public class NaiveUser {
    List list = new ArrayList<E>();
    list.get(7);
    list.get(3);
}
```

# Stack ADT

* The Stack ADT is a collection of objects that are inserted and removed according to a **last in, first out** model.
* That is, the last object added to the collection is the first removed.
\pause
* Some examples:
  * Pez dispenser.
  * Back tracing.
  * Stack of plates in the cafeteria.

# Stack ADT

* The Stack ADT is a collection of objects that are inserted and removed according to a **last in, first out** model.

# Stack ADT

* The Stack ADT is a collection of objects that are inserted and removed according to a **last in, first out** model.

# Stack ADT Operations

* `push(e)` -- Puts the new object **e** onto the top of the stack.
* `pop()` -- Removes and returns the object that is at the top of the stack.
* `peek()` -- Returns, but does not remove, the object that is at the top of the stack.
* `size()` -- Returns the number of objects that are in the stack.

# Stack ADT Operations Example

::: columns
:::: column
Operations:

```{=latex}
\hspace{1em}push(5)\\
\only<2->{\hspace{1em}push(10)\\}
\only<3->{\hspace{1em}push(3)\\}
\only<4->{\hspace{1em}pop() $\longleftarrow$ 3\\}
\only<5->{\hspace{1em}push(4)\\}
\only<6->{\hspace{1em}pop() $\longleftarrow$ 4\\}
\only<7->{\hspace{1em}size() $\longleftarrow$ 2\\}
\only<8->{\hspace{1em}peek() $\longleftarrow$ 10\\}
```

::::
:::: column
\vskip2em
\begin{tabular}{|c|}
 \only<1>5\only<2,4,6->{10}\only<3>3\only<5>4\\
 \only<2,4,6->5\only<3,5>{10}\\
 \only<3,5>5\\
 \\
 \\
 \\
 \\
 \hline
\end{tabular}
::::
:::

# Stack Implementation

* How could we implement a stack?
\pause
  1. Array. Make an array to hold the objects. Use a pointer to point to the top of the stack.
  \pause
  2. Linked List. Just keep tack of the head. Add to the front and remove from the front.

# ArrayStack

::: columns
:::: {.column width=.6}
```java
public class ArrayStack<E> {








}
```
::::
:::: {.column width=.4}
\begin{center}
 \includegraphics[width=.25\textwidth]{images/Module3/Stacks/stacks_01}
\end{center}
::::
:::

# ArrayStack

::: columns
:::: {.column width=.6}
```java
public class ArrayStack<E> {
    private E[] stack;  







}
```
::::
:::: {.column width=.4}
\begin{center}
 \includegraphics[width=.5\textwidth]{images/Module3/Stacks/stacks_02}
\end{center}
::::
:::

# ArrayStack

::: columns
:::: {.column width=.6}
```java
public class ArrayStack<E> {
    private E[] stack;
    private int top = 0;






}
```
::::
:::: {.column width=.4}
\begin{center}
 \includegraphics[width=.5\textwidth]{images/Module3/Stacks/stacks_02}
\end{center}
::::
:::

# ArrayStack

::: columns
:::: {.column width=.6}
```java
public class ArrayStack<E> {
    private E[] stack;
    private int top = 0;

    public void push(E element) {


    }

}
```
::::
:::: {.column with=.4}
\begin{center}
 \includegraphics[width=.5\textwidth]{images/Module3/Stacks/stacks_03}
\end{center}
::::
:::

# ArrayStack

::: columns
:::: {.column width=.6}
```java
public class ArrayStack<E> {
    private E[] stack;
    private int top = 0;

    public void push(E element) {
        E[top] = element;
        top++;  
    } // ignoring overflow issues

}
```
::::
:::: {.column width=.4}
\begin{center}
 \includegraphics[width=.5\textwidth]{images/Module3/Stacks/stacks_03}
\end{center}
::::
:::

# ArrayStack

::: columns
:::: {.column width=.6}
```java
public class ArrayStack<E> {
    private E[] stack;
    private int top = 0;

    public E peek() {



    }
}
```
::::
:::: {.column width=.4}
\begin{center}
 \includegraphics[width=.5\textwidth]{images/Module3/Stacks/stacks_03}
\end{center}
::::
:::

# ArrayStack

::: columns
:::: {.column width=.6}
```java
public class ArrayStack<E> {
    private E[] stack;
    private int top = 0;

    public E peek() {
        if (top > 0)
            return stack[top-1];
        return null;
    }
}
```
::::
:::: {.column width=.4}
\begin{center}
 \includegraphics[width=.5\textwidth]{images/Module3/Stacks/stacks_03}
\end{center}
::::
:::

# ArrayStack

::: columns
:::: {.column width=.6}
```java
public class ArrayStack<E> {
    private E[] stack;
    private int top = 0;

    public E pop() {







    }
}
```

::::
:::: {.column width=.4}
\begin{center}
 \includegraphics[width=.5\textwidth]{images/Module3/Stacks/stacks_03}
\end{center}
::::
:::

# ArrayStack

::: columns
:::: {.column width=.6}
```java
public class ArrayStack<E> {
    private E[] stack;
    private int top = 0;

    public E pop() {
        if (top > 0) {
            top--;
            Element e = stack[top];
            stack[top] = null;
            return e;
        }
        return null;
    }
}
```
::::
:::: {.column width=.4}
\begin{center}
 \includegraphics[width=.5\textwidth]{images/Module3/Stacks/stacks_04}
\end{center}
::::
:::

# LinkedListStack

::: columns
:::: {.column width=.6}
```java
public class LinkedListStack<E> {












}
```
::::
:::: {.column width=.4}
\begin{center}
 \includegraphics[width=.75\textwidth]{images/Module3/Stacks/stacks_05}
\end{center}
::::
:::

# LinkedListStack

::: columns
:::: {.column width=.6}
```java
public class LinkedListStack<E> {
    private Node<E> head;
    private int size = 0;










}
```
::::
:::: column
\begin{center}
 \includegraphics[width=.75\textwidth]{images/Module3/Stacks/stacks_05}
\end{center}
::::
:::

# LinkedListStack

:::
:::: {.column width=.6}
```java
public class LinkedListStack<E> {
    private Node<E> head;
    private int size = 0;


    public void push(E e) {}


    public E peek() {}


    public E pop() {}

}
```
::::
:::: {.column width=.4}
\begin{center}
 \includegraphics[width=.75\textwidth]{images/Module3/Stacks/stacks_05}
\end{center}
::::
:::

# LinkedListStack

::: columns
:::: {.column width=.6}
```java
public class LinkedListStack<E> {
    private Node<E> head;
    private int size = 0;

    // add to front
    public void push(E e) {}

    // look at front
    public E peek() {}

    // remove from front
    public E pop() {}      

}
```
::::
:::: {.column width=.4}
\begin{center}
 \includegraphics[width=.75\textwidth]{images/Module3/Stacks/stacks_05}
\end{center}
::::
:::

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Read Ch 6 Section 2 and 3
* Review prior lectures
* Finish PP 01
* Continue work on PA 02
* Come to class Tuesday.
