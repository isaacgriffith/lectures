---
author:
- Isaac Griffith
title: Maps, Sets, Multimaps
institute: |
  CS 2235

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

* Understand the basic concepts of Maps, Sets, and Multimaps
* Understand the concepts behind hashing.
* Understand the different approaches to hashing and their advantages/disadvantages.

#

\vfill
\centering
\Huge Maps

# Maps

* A data structure to efficiently store/retrieve values using unique **search keys**

* Each pair (key, value) is called an **Entry**

* Keys must be unique in order to define a mapping

# Map ADT

* `size()`: Returns the number of entries in M
* `isEmpty()`: Returns a boolean indicating whether M is empty
* `get(k)`: Returns the value v associated with key *k*, if such an entry exists; otherwise returns null
* `put(k,v)`: If M does not have an entry with key equal to k, then adds entry (k,v) to M and returns null; else, replaces with v the existing value of the entry with key equal to k and returns the old value.
* `remove(k)`: Removes from M the entry with key equal to k, and returns its value; if M has no such entry, then returns null
* `keySet()`: returns an iterable collection containing the keys stored in M
* `values()`: returns an iterable collection containing all the values of entries stored in M (with repetition if multiple keys map to the same value)
* `entrySet()`: Returns an iterable collection containing all the key-value entries in M.

# Map Operations Example

  Method      Return Value   Map
 ----------- -------------- -----
  isEmpty()  true           { }
  put(5,A)   null           {(5,A)}
  put(2,C)   null           {(5,A),(2,C)}
  put(2,E)   C              {(5,A),(2,E)}
  get(4)     null           {(5,A),(2,E)}
  size()     2              {(5,A),(2,E)}
  remove(5)  A              {(2,E)}
  entrySet() {(2,E)}        {(2,E)}
  keySet()   {2}            {(2,E)}
  values()   {E}            {(2,E)}
  isEmpty()  false          {(2,E)}
 ----------- -------------- -----

# The Map ADT

```Java
public interface Map<K, E> {
  int size();
  boolean isEmpty();
  V get(K key);
  V put(K key, V value);
  V remove(K key);
  Iterable<E> keySet();
  Iterable<V> values();
  Iterable<Entry<K, V>> entrySet();
}
```

# AbstractMap Base Class

::: columns

:::: column
Implements:

* isEmpty()
* keySet() and values() based on adaption of entrySet()
* Nested MapEnty Class
::::

:::: column
\centering
\includegraphics[width=\textwidth]{images/Module5/Maps/map01.eps}
::::

:::

# Hash Tables

* One of the most efficient means of implementing a map
* A map, M, supports the abstraction of using keys to address values

* Consider the following:
  - a map with `n` entries uses keys that are known to be integers in a range: O to N - 1
  - we then represent the map as a **lookup table** of length N, as shown
\begin{center}
\includegraphics[width=.5\textwidth]{images/Module5/Maps/map02.eps}
\end{center}
\vspace{-1em}
* In this representation, what is the running time of the following operations?
  - get()
  - put()
  - remove()

# Hash Tables

  * One of the most efficient means of implementing a map
  * A map, M, supports the abstraction of using keys to address values

  * Consider the following:
    - a map with `n` entries uses keys that are known to be integers in a range: O to N - 1
    - we then represent the map as a **lookup table** of length N, as shown
  \begin{center}
  \includegraphics[width=.5\textwidth]{images/Module5/Maps/map02.eps}
  \end{center}
  \vspace{-1em}
  * In this representation, what is the running time of the following operations?
    - get() -- O(1)
    - put() -- O(1)
    - remove() -- O(1)

# Hash Tables: Challenges

1. We may not wish to devote an array of length `N` if $N \gg n$

2. Map keys are not required to be integers

\pause
Both of these challenges are solved with a single solution: **hash functions**

\vspace{-1em}
* map general keys to corresponding indices in a table
* keys should be well distributed across range 0..N-1
* To handle collisions we use a bucket array:

\vspace{-1em}
\centering
\includegraphics[width=.45\textwidth]{images/Module5/Maps/map03.eps}

# Hash Functions

* **Hash Function:** (h) maps each key `k` onto an integer int he range $[0,N-1$]$
* where: $N$ is the capacity of the bucket array

* The main idea is to use $h(k)$ as an index into the bucket array instead of $k$

* A **collision** occurs when two different entries are mapped to the same bucket in the array.

* We say that a hash function is *good* if:
  - it maps keys such as to minimize collisions
  - is fast and easy to compute

# Hash Functions

* Hash functions are divided into two components:

\begin{center}
\includegraphics[width=.5\textwidth]{images/Module5/Maps/map04.eps}
\end{center}

# Hash Codes

* The first action that a hash function performs is the computation of a **hash code**

* A hash code is simply an integer representation of its bits

* This differs depending on...
  - If the value is a primitive type
  - If the value is an object type

# Hashing Primitive Types

How would we hash the following types?

* short
* int
* char
* byte

\pause
Simply cast to an integer form!

How about for *float*?
\pause

call: `Float.floatToIntBits(x)`

# Hashing Primitive Types

How do we hash a *double* or a *long*, which are 64-bit representations

* Choose either the low order 32-bits or the high order 32-bits. Is there a problem with this?
\pause
* Sum the two components together (and ignore overflow)
* Exclusive-Or the two components together

# Hashing Objects

::: columns
:::: {.column width=40%}
* Polynomial Hash Codes:
  - $x_0a^{n-1}+x_1a^{n-2}+\ldots+x_{n-2}a+x_{n-1}$
  - Where:
    - $x_i$ is a component of the object and
    - $a$ is some non-zero constant, $a \ne 1$
  - Values 33, 37, 39, and 41 are good choices for $a$
::::
:::: {.column width=60%}
* Cyclic-Shift Hash Codes
  - A variant of the polynomial hash code
  ```Java
  static int hashCode(String s) {
    int h = 0;
    for (int i = 0; i < s.length(); i++)
    {
      h = (h << 5) | (h >>> 27);
      h += (int) s.charAt(i);
    }
    return h;
  }
  ```
  \vspace{-1em}
  - Optimum is a 5 bit shift
::::
:::

# Java Hash Codes

* All objects inherit `int hashCode()` from the base super class `Object`
* Default implementation is based on a hash of the memory address of the object (not optimal).
* You should override this method whenever you will be needing to either computer the hash of the object
* Or when you will be overriding the `equals` method:
  - If two objects are equivalent, then their hashcodes should be equal.

# Compression Functions

* A **Compression Function** maps a hashcode to the indexes of a bucket array.
* A good compression function minimizes the collisions for a given set of distinct hashcodes

* There are two methods:
  - Division Method
  - MAD Method

# Division Method

* A function that maps i as follows: $f(i) : i \rightarrow i \mod N$

* where:
  - $N$ is the size of the bucket array (a fixed positive integer)

* Typically it works best (for spreading the values out) if $N$ is a prime number
  - Does not work for patterns: $pN + q$ for several different $p$'s

# MAD Method

* A more sophisticated pattern which avoids the previous issue is the **Multiply-Add-and-Divide** method.

* MAD is a function that map i as follows: $g(i) : i \rightarrow [(ai + b) \mod p] \mod N$

* where:
  - $N$ is the size of the bucket array
  - $p$ is a prime number larger than $N$
  - $a$ and $b$ are random integers selected from $[0,p-1]$, with $a>0$

# Handling Collisions

* Problem: inserting two keys $k_1$ and $k_2$ when $h(k_1) = h(k_2)$

* The existence of such **collisions**
  - Prevents us from inserting $(k,v)$ directly into $A[h(k)]
  - Complicates insertion, search, and deletion operations

* Two methods to deal with this:
  - Separate Chaining
  - Open Addressing

# Separate Chaining

* Simple and efficient
* Basic Idea:
  - Each bucket, $A[j]$ stores a secondary container
  - These containers hold all entries $(k,v)$ such that $h(k) = j$
  - Natural choice is an Ordered List

\vspace{-1em}
\centering
\includegraphics[width=.5\textwidth]{images/Module5/Maps/map05.eps}

# Separate Chaining

* Worst Case, ops take time proportional to size of bucket

* Assuming a good hash function to index $n$ entries in a bucket array of capacity $N$
  - expected bucket size is $n/N$

* In this case, core operations take $O(\lceil n / N\rceil)$

* The ratio $\lambda = n / N$, is the **load factor** of the table
  - This should be bounded by a small constant, preferably below 1.0

* As long as $\lambda$ is $O(1)$, the core ops run in $O(1)$ time.

# Open Addressing

* Separate Chaining is good, but has one disadvantage:
  - It requires the use of an auxiliary data structure.

* If space is at a premium we have open addressing solutions to use instead

* If we try to insert entry $(k,v)$ into bucket $A[j]$ that is already occupied, where $j = h(k)$
  - try $A[(j + 1) mod N]$, followed by
  - $A[(j + 2) mod N]$, and so on
  - until an empty slot is found, then insert the entry there

* Unfortunately this changes the entire way we search for an entry (which is the first step for get, put, and remove).

# Linear Probing

\centering
\includegraphics[width=.75\textwidth]{images/Module5/Maps/map06.eps}

# Linear Probing

* For deletion, we cannot simply remove an item, as search would then fail for remaining items.

* Instead we use a special DEFUNCT marker in its place.

* These markers are skipped on search, but replaced on insert.

**Disadvantages**

* Tends to cluster entries into runs which may overlap, slowing down search

# Quadratic Probing

* Similar to Linear Probing, but instead tries buckets in the pattern:

$A[h(k) + f(i) mod N]$, for $i = 0,1,2,\ldots$ where $f(i) = i^2$

* Unfortunately this still creates clusters (called **secondary clusters**)

# Double Hashing

* To address the issue with slow search due to clustering that linear and quadratic probing creates.

* We use a **double hashing** approach:
  - choose a secondary hashing function: $h'$
  - if $h'$ maps some key $k$ to bucket $A[h(k)]$ that is already occupied, then
    - iteratively try $A[h(k) + f(i)) mod N] for $i = 1,2,3,\ldots$
    - $f(i) = i * h'(k)$
  - $h'(i)$ cannot evaluate to zero
  - Common choice: $h'(k) = q - (k mod q)$, for some prime $q < N$
  - Note: $N$ should be prime.

# Load Factors and Rehashing

* As mentioned previously $\lambda < 1$
  - Separate Chaining: as $\lambda$ nears 1 the probability of collision increases
    - operation overhead will also increases
    - Thus try to keep $\lambda < 0.9$

  - Open Addressing: as $\lambda$ grows beyond 0.5 clusters begin to grow
    - operation overhead increases
    - Keep $\lambda < 0.5$

* To reduce loading, you will need to...
  - Resize the table
  - Adjust compression function
  - Reinsert all items into the table

# Analysis

Method                   Unsorted List Hash Table
------------------------ ------------- ------------------
get                      $O(n)$        $O_E(1)$ $O_W(n)$
put                      $O(n)$        $O_E(1)$ $O_W(n)$
remove                   $O(n)$        $O_E(1)$ $O_W(n)$
size, isEmpty            $O(1)$        $O_E(1)$ $O_W(1)$
entrySet, KeySet values  $O(n)$        $O_E(n)$ $O_W(n)$
------------------------ ------------- ------------------

#

\vfill
\centering
\Huge Sets and Multimaps

# Definitions

* A **set** is an unordered collection of elements, without duplicates that typically supports efficient membership tests.
  - Elements of a set are like keys of a map, but without any auxiliary values.
* A **multiset** (also known as a **bag**) is a set-like container that allows duplicates.
* A **multimap** is similar to a traditional map, in that it associates values with keys; however, in a multimap the same key can be mapped to multiple values.
  - For example, the index of a book maps a given term to one or more locations at which the term occurs.

# Set ADT

* `add(e)`: Adds the element $e$ to $S$ (if not already present)
* `remove(e)`: Removes the element $e$ from $S$ (if it is present)
* `contains(e)`: Returns whether $e$ is an element of $S$
* `iterator()`: Returns an iterator of the elements of $S$

# Set ADT

There is also support for the traditional mathematical set operations of **_union_**, **_intersection_**, and **_subtraction_** of two sets $S$ and $T$:

$$S \cup T = \{e | e \in S \vee e \in T\}$$
$$S \cap T = \{e | e \in S \wedge e \in T\}$$
$$S - T = \{e | e \in \wedge e \notin T\}$$

* `addAll(T)`: Updates $S$ to also include all elements of set $T$, effectively replacing $S$ by $S \cup T$
* `retainAll(T)`: Updates $S$ so that it only keeps those elements that are also elements of set $T$, effectively replacing $S$ by $S \cap T$.
* `removeAll(T)`: Updates $S$ by removing any of its elements that also occur in set $T$, effectively replacing $S$ by $S - T$.

# Storing a Set in a List

* WE can implement a set with a list.
* Elements are stored sorted according to some canonical ordering
* The space used is **O(n)**

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module5/Sets/sets01.eps}
\end{center}

# Generic Merging

::: columns
:::: column
* Generalized merge of two sorted lists $A$ and $B$
* Template method `genericMerge`
* Auxiliary methods:
  - `aIsLess`
  - `bIsLess`
  - `bothAreEqual`
* Runs in **$O(n_A + n_B)$** time provided the auxiliary methods run in **$O(1)$** time
::::
:::: column

```{=latex}
\tiny
\begin{algorithm}[H]
\caption{genericMerge(A, B)}
\DontPrintSemicolon
  \KwIn{$A, B$ sets to be merged}
  $S \leftarrow $ empty sequence\;
  \While{$\not A.isEmpty() \wedge \not B.isEmpty()$}{
    $a \leftarrow A.first().element()$\;
    $b \leftarrow B.first().element()$\;
    \If{$a < b$} {
      $aIsLess(a, S)$\;
      $A.remove(A.first())$\;
    } \ElseIf{$b < a$} {
      $bIsLess(b, S)$\;
      $B.remove(B.first())$\;
    } \Else {
      $bothAreEqual(a, b, S)$\;
      $A.remove(A.first())$\;
      $B.remove(B.first())$\;
    }
  }
  \While{$\not A.isEmpty()$}{
    $aIsLess(a, S)$\;
    $A.remove(A.first())$;
  }
  \While{$\not B.isEmpty()$}{
    $bIsLess(b, S)$\;
    $B.remove(B.first())$\;
  }
  \Return{$S$}\;
\end{algorithm}
```

::::
:::

# Using Generic Merge

* Any of the set operations can be implemented using a generic merge
* For example:
  - For **intersection**: only copy elements that are duplicated in both lists
  - For **union**: copy every element from both lists except for the duplicates
* All methods run in linear time.

# Multimap

* A **multimap** is similar to a map, except that it can store multiple entries with the same key
* We can implement a multimap $M$ by means of a map $M'$
  - For every key $k$ in $M$, let $E(k)$ be the list of entries of $M$ with key $k$
  - The entries of $M'$ are the pairs $(k, E(k))$

# Multimap ADT

* `get(k)`: Returns a collection of all values associated with key $k$ in the multimap.
* `put(k, v)`: Adds a new entry to the multimap associating key $k$ with value $v$, without overwriting any existing mappings for key $k$.
* `remove(k, v)`: Removes an entry mapping key $k$ to value $v$ from the multimap (if one exists).
* `removeAll(k)`: Removes all entries having key equal to $k$ from the multimap.
* `size()`: Returns the number of entries of the multiset (including multiple associations).

# Multimap ADT

* `entries()`: Returns a collection of all entries in the multimap.
* `keys()`: Returns a collection of keys for all entries int he multimap (including duplicates for keys with multiple bindings).
* `keySet()`: Returns a nonduplicative collection of keys in the multimap.
* `values()`: Returns a collection of values for all entries in the multimap.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}


# For Next Time

* Review Prior Lectures
* Start working on PA04
* Read Chapter 14
* Come to Class
* Enjoy your weekend
