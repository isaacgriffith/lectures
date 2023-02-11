---
author:
- Isaac Griffith
title: Tries, Skiplists, and Huffman Coding
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
\Huge Tries and Skiplists

# Outcomes

At the end of Today's Lecture you will be able to:

* Understand and be capable of implementing Tries
* Understand and be capable of implementing SkipLists
* Understand and be capable of implementing Huffman Coding

#

\vfill
\begin{center}
{\Huge Tries}
\end{center}

# Introduction

* Strings can be viewed as the most important and common topics for a variety of programming problems.
* String processing has a variety of real world applications:
  * Search Engines
  * Genome Analysis
  * Data Analytics

* All of the content presented to us in textual form can be visualized as simply strings.

# Tries

* Simply a tree data structure based on the *prefix of a string*
* They are used to represent the "Retrieval" of data

# Prefix? What is Prefix?

The prefix of a string is any $n$ letters, where $n \leq |S|$ that can be considered beginning strictly from the start of a string.

For example the word "abacaba" has the following prefixes:

* a
* ab
* aba
* abac
* abaca
* abacab

# Trie

\begin{center}
\includegraphics[width=.5\textwidth]{images/Module4/Tries/trie02.eps}
\end{center}

# Useful?

* Typically used for a group of strings
* This aids in solving well known problems:
  * Dictionary based string matching

* Rather than trying to match every prefix, we can just traverse the Trie.

# Example

* A trie consisting of the English language would start with the root node.
* The root would then have 26 outgoing edges

# Insertion

* How would insertion into a Trie work?

\pause

```Java
void insert(Stirng s) {
  for (each char in string s) {
    if (child node belonging to current char is null)
    {
      chld node = new Node()
    }
    current_node = child_node
  }
}
```

# Example

To Check if a single word exists in a dictionary of words:

```Java
boolean check(String s) {
  for (every char in String s) {
    if (child node is null) {
      return false
    }
  }
  return true
}
```

# Another Example of a Trie

The following encodes (car, card, carry, cart, cat, cel, celery, close, closely, closet, clue)

\begin{center}
\includegraphics[width=.45\textwidth]{images/Module4/Tries/trie01.eps}
\end{center}

# Implementation

Besides a "Dictionary" what else could we implement with a Trie?

# Implementation

If we want to implement a **set**

* store a Boolean value in each node: *true* if the node is "final", *false* otherwise

```Java
public class TrieNode {
  private char character;
  private boolean last;
  private Set<TrieNode> children;
  ...
}
```

# Implementation

To implement a **dictionary**

* store the corresponding value in final nodes, and null in non-final nodes

```Java
public class TrieNode {
  private char character;
  private String definition;
  private Set<TrieNode> children;
  ...
}
```

# Implementation

In general, we can use anything for keys and values

```Java
public class TrieNode<C, D> {
  private C character;
  private D definition;
  private Set<TrieNode<C, D>> children;
}
```

Though in this case, keys would be some sort of C array, so using it with string keys m

# Your Turn?

Work together to develop a "Dictionary" interface and implement it with a Trie.

# Uses

Tries can also be used for spell checkers

How would this work?

# Variations

* You can save memory by turning the underlying tree into a graph:

::: columns
:::: column
\vspace{-1em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Tries/trie03.eps}
\end{center}
::::
:::: column
* How does this complicate insertion and deletion?
::::
:::

#

\vfill
\begin{center}
{\Huge SkipLists}
\end{center}

# LinkedList Benefits/Drawbacks

* Benefits:
  - Easy to insert & delete in O(1) time
  - Don't need to estimate total memory needed
* Drawbacks:
  - Hard to search in less than O(n) time (binary search doesn't apply)
  - Hard to jump to the middle
* Skip Lists:
  - Fix these drawbacks
  - Good data structure for a dictionary/map ADT

# Skip Lists

* Invented around 1990 by Bill Pugh
* Generalization of sorted linked lists - easy to implement
* Expected search time is O(log n)
* *Randomized* data structure:
  - Uses random coin flips to build the data structure

# Perfect Skip Lists

\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/SkipLists/Skip01.eps}
\end{center}

# Perfect Skip Lists

* Keys in sorted order.
* O(log n) *levels*
* Each higher level contains 1/2 the elements of the level below it.
* Header & sentinel nodes are in every level

\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/SkipLists/Skip02.eps}
\end{center}

# Perfect Skip Lists

* Nodes are of variable size:
  - contain between 1 and O(log n) pointers
* Pointers point to the start of each node (picture draws pointers horizontally for visual clarity)
* Called *skip lists* because higher level lists let you skip over many items

\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/SkipLists/Skip02.eps}
\end{center}

# Perfect Skip Lists

Find 71

\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/SkipLists/Skip03.eps}
\end{center}

When search for k:
  - If k = key, done!
  - If k < next key, go down a level
  - If k $\geq$ next key, go right

# In other words,

* To find an item, we scan along the shortest list until we would "pass" the desired item.

* At that point, we drop down to a slightly more complete list at one level lower

# Perfect Skip Lists

Find 96

\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/SkipLists/Skip04.eps}
\end{center}

When search for k:
  - If k = key, done!
  - If k < next key, go down a level
  - If k $\geq$ next key, go right

# Search Time

* O(log n) levels -- because you cut the \# of items in half at each level
* Will visit at most 2 nodes per level:
  - If you visit more, then you could have done it on one level higher up.
* Therefore, search time is O(log n)

# Insert & Delete

* Insert & delete might need to rearrange the entire list

* Like Perfect Binary Search Trees, Perfect Skip Lists are *too* structured to support efficient updates.

* Idea:
  - Relax the requirement that each level have exactly half the items of the previous level
  - Instead: design structure so that we *expect* 1/2 the items to be carried up to the next level
  - Skip Lists are a *randomized* data structure: the same sequence of inserts/deletes may produce different structures depending on the outcome of random coin flips.

# Randomization

* Allows for some imbalance
* Expected behavior (over the random choices) remains the same as with perfect skip lists
* Idea: Each node is promoted to the next higher level with probability 1/2
  - Expect 1/2 the nodes at level 1
  - Expect 1/4 the nodes at level 2
  - ...
* Therefore, expect \# of nodes at each level is the same as with perfect skip lists
* Also: expect the promoted nodes will be well distributed across the list

# Randomized Skip List

\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/SkipLists/Skip05.eps}
\end{center}

# Insertion:

Insert 87

\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/SkipLists/Skip06.eps}
\end{center}

# Insertion:

Insert 87

\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/SkipLists/Skip07.eps}
\end{center}

```java
Find k
Insert node in level 0
let i = 1
while FLIP() == "heads":
  insert node into level i // same as list insertion after last node
  i++
```

# Deletion

Delete 87

\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/SkipLists/Skip08.eps}
\end{center}

# Deletion

Delete 87

\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/SkipLists/Skip09.eps}
\end{center}

# No "bad" Sequences

* We expect a randomized skip list to perform about as well as a perfect skip list.

* With some *very* small probability,
  - the skip list will just be a linked list, or
  - the skip list will have every node at every level
  - These *degenerate* skip lists are very unlikely!

* Level structure of a skip list is independent of the keys you insert

* Therefore, there are no "bad" key sequences that will lead to degenerate skip lists

# Skip List Analysis

* Expected number of levels = O(log n)
  - E[\# nodes at level 1] = n / 2
  - E[\# nodes at level 2] = n / 4
  - ...
  - E[\# nodes at level log n] = 1

* Still need to prove that \# of steps at each level is small.

# Backward Analysis

Consider the *reverse* of the path you took to find *k*:

\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/SkipLists/Skip10.eps}
\end{center}

Note that you *always* move up if you can. (Because you always enter a node from its topmost level when doing a find).

# Backward Analysis

* What's the probability that you can move up at a given step of the reverse walk?
  \pause
  - 0.5
\pause
* Steps to go up *j* levels =
  \pause
  - Make one step, then make either:
    \pause
    * C(j - 1) steps if this step went up [Prob = 0.5]
    * C(j) steps if this step went left [Prob = 0.5]

\pause
* Expected \# of steps to walk up j levels is:
  \pause
  - C(j) = 1 + 0.5C(j - 1) + 0.5C(j)

# Backward Analysis

* Expected \# of steps to walk up j levels is:
  - C(j) = 1 + 0.5C(j - 1) + 0.5C(j)

* So:
  - 2C(j) = 2 + C(j - 1) + C(j)
  - C(j_ = 2 + (j - 1)
  - Expected \# of steps at each level = 2

* Expanding C(j) above gives us: C(j) = 2j
* Since O(log n) levels, we have O(log n) steps, expected

# Implementation Notes

* Node structures are of variable size

* But once a node is crated, its size won't change

* It's often convenient to assume that you know the maximum number of levels in advance (but this is not a requirement).

#

\vfill
\begin{center}
{\Huge Huffman Coding}
\end{center}

# Introduction

Suppose that we have a 100,000 character data file that we wish to store. The file
contains only 6 characters, appearing with the following frequencies:

+--------------------+-----+-----+-----+-----+------+------+
|                    | a   | b   | c   | d   | e    | f    |
+:===================+:===:+:===:+:===:+:===:+:====:+:====:+
| Frequency in '000s | 45  | 13  | 12  | 16  | 9    | 5    |
+--------------------+-----+-----+-----+-----+------+------+

A **binary code** encodes each character as a binary string or **codeword**. We would
like to find a binary code that encodes the file using as few bits a possible, i.e.,
**compresses it** as much as possible

# Fixed-length Codes

* **Fixed-length codes** - each codeword is same length
* **Variable-length codes** - codewords may have different length

* Examples

+--------------------+-----+-----+-----+-----+------+------+
|                    | a   | b   | c   | d   | e    | f    |
+:===================+:===:+:===:+:===:+:===:+:====:+:====:+
| Frequency in '000s | 45  | 13  | 12  | 16  | 9    | 5    |
+--------------------+-----+-----+-----+-----+------+------+
| a fixed-length     | 000 | 001 | 010 | 011 | 100  | 101  |
+--------------------+-----+-----+-----+-----+------+------+
| a variable-length  |  0  | 101 | 100 | 111 | 1101 | 1100 |
+--------------------+-----+-----+-----+-----+------+------+

# Fixed-length Codes

* The fixed-length code requires **300,000** bits to store the file.
* The variable-length code uses only:

$(5\cdot 1 + 13\cdot 3 + 12\cdot 3 + 16\cdot 3 + 9\cdot 4 + 5\cdot 4)\cdot 1000 = 224,000$ bits

* This saves a lot of space, but can we do better?

# Encoding

* Given: a code (corresponding to some alphabet $\Gamma$) and a message
  - Easy to *encode* the message
  - Simply replace characters by codewords

Example: $\Gamma = {a, b, c, d}$

* Code: $C_1 = {a = 00, b = 01, c = 10, d = 11}$, then **bad** is **010011**
* Code: $C_2 = {a = 0, b = 110, c = 10, d = 111}$, then **bad** is **1101111**

# Decoding

\begin{center}
$C_1 = {a = 00, b = 01, c = 10, d = 11}$\\
$C_2 = {a = 0, b = 110, c = 10, d = 111}$\\
$C_3 = {a = 1, b = 110, c = 10, d = 1111}$
\end{center}

* **decoding** - process of turning an encoded message into clear text.

* A message is **uniquely decodable** if it can only be decoded one way for a given code.

* Example:
  - Relative to $C_1$ **010011** is uniquely decodable to **bad**.
  - Relative to $C_2$ **1101111** is uniquely decodable to **bad**
  - Relative to $C_3$ **1101111** is **not** uniquely decodable since it could have encoded either **bad** or **acad**.

# Decoding

\begin{center}
$C_1 = {a = 00, b = 01, c = 10, d = 11}$\\
$C_2 = {a = 0, b = 110, c = 10, d = 111}$\\
$C_3 = {a = 1, b = 110, c = 10, d = 1111}$
\end{center}

* Example:
  - Relative to $C_1$ **010011** is uniquely decodable to **bad**.
  - Relative to $C_2$ **1101111** is uniquely decodable to **bad**
  - Relative to $C_3$ **1101111** is **not** uniquely decodable since it could have encoded either **bad** or **acad**.

* Using either $C_1$ or $C_2$ we can show any message produced is uniquely decodable.
* Such a property is necessary for a code to be useful.

# Prefix-Codes

* Fixed-length codes are always uniquely decipherable
  - Why is this?

* Though, they do not always give the best compression
  - So we prefer variable length codes

* **Prefix Code**: A code is called a **prefix (free) code** if no codeword is a prefix of another one.
* **Example**: `{a = 0, b = 110, c = 10, d = 111}` is a prefix code.

# Prefix-Codes

* **Important Fact**: Every message encoded by a prefix free code is uniquely decipherable.
  - Since no code-word is a prefix of any other we can always find the first codeword in a message, peel it off, and continue decoding.

* **Example**:

\begin{center}
01101100 = \color{Roarange}0\color{GrowlingGray}110\color{Roarange}110\color{GrowlingGray}0\color{black} = \color{Roarange}a\color{GrowlingGray}b\color{Roarange}b\color{GrowlingGray}a\color{black}
\end{center}

* We are therefore interested in finding good (best compression) prefix-free codes.

# Fixed-Length vs. Variable-Length

**Problem:** Suppose we want to store messages made up of 4 characters $a,\,b,\,c,\,d$ with **frequencies** 60, 5, 30, 5 (percents) respectively. What are the **fixed-length codes** and **prefix-free codes** that use the least space?

\vskip1em
\pause
**Solution:**

characters         a   b   c   d
----------------- --- --- --- ---
frequency          60  5   30  5
fixed-length code  00  01  10  11
prefix code        0  110  10 111
----------------- --- --- --- ---

# Fixed-Length vs. Variable-Length

characters         a   b   c   d
----------------- --- --- --- ---
frequency          60  5   30  5
fixed-length code  00  01  10  11
prefix code        0  110  10 111
----------------- --- --- --- ---

To store 100 of these characters,

1. The fixed-length code requires $100 \times 2 = 200$ bits
2. The prefix code uses only:

   $60 \times 1 + 5 \times 3 + 30 \times 2 + 5 \times 3 = 150$

A 25% savings.

* **Remark:** we will see later that this is the *optimum* (lowest cost) prefix code.

# Optimum Source Coding Problem

**The problem:** Given an \color{Roarange}alphabet $A = {a_1,\ldots,a_n}$ \color{black} with \color{Roarange}frequency distribution $f(a_i)$ \color{black} find a binary prefix code $C$ for $A$ that minimizes the number of bits:

$$B(C) = \overset{n}{\underset{a=1}{\sum}} f(a_i)L(c(a_i))$$

needed to encode a message of $\sum^{n}_{a=1}f(a)$ characters, where $c(a_i)$ is the codeword for encoding $a_i$, and $L(c(a_i))$ is the length of the codeword $c(a_i)$.

* Huffman developed a nice greedy algorithm for solving this problem and producing a minimum-cost prefix code.

* The code that produces it is called a \color{Roarange}*Huffman code*\color{black}.

# Binary Trees and Huffman Codes

::: columns
:::: column
* The Huffman code is expressed as a binary tree.
  - Note that there is a 1-1 correspondence between leaves and characters of the alphabet.

* The left edge is labeled `O`; right edge is labeled `1`

* Path from root to leaf forms codeword associated with character.
::::
:::: column
\vspace{-1em}
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/Huffman/huffman01.eps}
\end{center}

`{a = 000, b = 001, c = 010,`

` d = 011, e = 1}`
::::
:::

# Binary Trees and Huffman Codes

::: columns
:::: column

* Note that \color{Roarange}$d(a_i)$\color{black}, the depth of leaf $a_i$ in tree $T$ is equal to the length, \color{Roarange}$L(c(a_i))$ \color{black} of the codeword in code $C$ associated with that leaf. So,

  $$\overset{n}{\underset{a=1}{\sum}} f(a_i)L(c(a_i)) = \overset{n}{\underset{a=1}{\sum}} f(a_i)d(a_i)$$

* The sum $\sum^{n}_{a=1}f(a_i)d(a_i)$ is the *weighted external pathlength* of tree $T$.

::::
:::: column
\vspace{-1em}
\begin{center}
\includegraphics[width=.95\textwidth]{images/Module4/Huffman/huffman01.eps}
\end{center}

`{a = 000, b = 001, c = 010,`

` d = 011, e = 1}`
::::
:::

# Huffman Coding

* **Step 1:** Pick two letters \color{Roarange}$x, y$ \color{black}from alphabet \color{Roarange}$A$ \color{black} with the smallest frequencies and create a subtree that has these two characters as leaves. \color{GrowlingGray}(greedy idea)\color{black} Label the root of this subtree as \color{Roarange}$z$ \color{black}

* **Step 2:** Set frequency \color{Roarange}$f(z) = f(x) + f(y)$\color{black}. Remove $x, y$ and add $z$ creating new alphabet \color{Roarange}$A' = A \cup {z} - {x, y}$\color{black}. Note that \color{Roarange}$\left|A'\right| = \left|A\right| - 1$\color{black}.

* Repeat this procedure, called \color{GrowlingGray}*merge*\color{black}, with new alphabet $A'$ until an alphabet with only one symbol is left.

* The resulting tree is the \color{Roarange}**Huffman code**\color{black}.

# Example of Huffman Coding

* Let $A = {a/20, b/15, c/5, d/15, e/45}$ be the alphabet and its frequency distribution.

1. Initially Huffman coding merges $c$ and $d$.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Huffman/huffman03.eps}
\end{center}

* Alphabet is now $A_1 = {a/20, b/15, n1/20, e/45}$

# Example of Huffman Coding

* Alphabet is now $A_1 = {a/20, b/15, n1/20, e/45}$

2. Algorithm merges $a$ and $b$ (could have also merged $n1$ and $b$).

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module4/Huffman/huffman04.eps}
\end{center}

* New alphabet is $A_2 = {n2/35, n1/20, e/45}$

# Example of Huffman Coding

* Alphabet is $A_2 = {n2/35, n1/20, e/45}$

3. Algorithm merges $n1$ and $n2$.

\begin{center}
\includegraphics[width=.5\textwidth]{images/Module4/Huffman/huffman05.eps}
\end{center}

* New alphabet is $A_3 = {n3/55, e/45}$.

# Example of Huffman Coding

* Current alphabet is $A_3 = {n3/55, e/45}$.

4. Algorithm merges $e$ and $n3$ and finishes.

\begin{center}
\includegraphics[width=.4\textwidth]{images/Module4/Huffman/huffman06.eps}
\end{center}

# Example of Huffman Coding

::: columns
:::: column
* Huffman code is obtained from the Huffman tree.

* Huffman code is:
  - `a = 000`
  - `b = 001`
  - `c = 010`
  - `d = 011`
  - `e = 1`

* This is the optimum (minimum-cost) prefix code for this distribution.
::::
:::: column

\includegraphics[width=.95\textwidth]{images/Module4/Huffman/huffman07.eps}

::::
:::


# Huffman Coding Algorithm

::: columns
:::: column
* Given an alphabet $A$ with frequency distribution ${f(a) : a \in A}$
* The binary Huffman tree is constructed using a priority queue, $Q$, of nodes, with labels (frequencies) as keys.

* Running time is $O(n \log n)$, as each priority queue operation takes time $O(\log n)$.
::::
:::: column
```{=latex}
\begin{algorithm}[H]
\caption{Huffman(A)}
\DontPrintSemicolon
  \KwIn{$A$ an alphabet}
  $n = \left|A\right|$\;
  $Q = A$\;
  \For{$i = 1$ \textbf{to} $n - 1$} {
    $z = new\, node$\;
    $left[z] = extractMin(Q)$\;
    $right[z] = extractMin(Q)$\;
    $f[z] = f[left[z]] + f[right[z]]$\;
    $insert(Q, z)$;
  }
  \Return{$extractMin(Q)$}\;  
\end{algorithm}
```
::::
:::

# Huffman Codes are Optimal

**Lemma:** Consider the two letters, $x$ and $y$ with the *smallest frequencies*. Then $T$ is an optimal code tree in which these two letters are sibling leaves in the tree in the lowest level.

\vskip1em

**Lemma:** The tree for any *optimal prefix code* must be **"full"** meaning that every internal node has exactly two children.

\vskip1em

**Theorem:** Huffman's algorithm produces an optimum prefix code tree.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Read Ch 9 Sections 1 - 5
* Review prior lectures
* Come to class!
