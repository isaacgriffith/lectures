---
author:
- Isaac Griffith
title: Graphs II
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
\Huge Graphs II

# Outcomes

At the end of Today's Lecture you will be able to:

*

# Introduction

* Okay, we can represent graphs

* Now, we'll implement some useful and non-trivial algorithms

  - Topological sort: Given a DAG, order all the vertices so that every vertex comes before all of its neighbors.

  - Shortest paths: Find the shortest or lowest-cost path from x to y
    * Related: Determine if there even is such a path.

#

\vfill
\begin{center}
{\Huge Topological Sort}
\end{center}

# Topological Sort

* Problem: Given a DAG $G = (V, E)$, output all vertices in an order such that no vertex appears before another vertex that has an edge to it.

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module5/Graphs/graph23.eps}
\end{center}

* One example output:

  126, 142, 143, 374, 373, 417, 410, 413, XYX, 415

# Questions and Comments

* Why do we perform topological sorts only on DAGs?
  \pause
  - Because a cycle means there is no correct answer

* Is there always a unique answer?
  \pause
  - No, there can be 1 or more answers; depends on the graph

* Do some DAGs have exactly 1 answer?
  \pause
  - Yes, including all lists

* Terminology: A DAG represents a *partial order* and a topological sort produces a *total order* that is consistent with it.

# Uses

* Figuring out how to graduate

* Computing an order in which to recompute cells in a spreadsheet

* Determining an order to compile files using a Makefile

* In general, taking a dependency graph and finding an order of execution

* ...

# A First Algorithm

1. Label("mark") each vertex with its in-degree
   - Think "write in a field in the vertex"
   - could also do this via a data structure (e.g., array) on the side

2. While there are vertices not yet output:
   - Choose a vertex **v** with labeled with in-degree of 0
   - Output **v** and *conceptually* remove it from the graph
   * For each vertex **u** adjacent to **v** (i.e., **u** such that $(v, u)$ in $E$), decrement the in-degree of **u**.

# Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module5/Graphs/graph25.eps}
\end{center}

# Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module5/Graphs/graph26.eps}
\end{center}

# Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module5/Graphs/graph27.eps}
\end{center}

# Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module5/Graphs/graph28.eps}
\end{center}

# Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module5/Graphs/graph29.eps}
\end{center}

# Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module5/Graphs/graph30.eps}
\end{center}

# Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module5/Graphs/graph31.eps}
\end{center}

# Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module5/Graphs/graph32.eps}
\end{center}

# Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module5/Graphs/graph33.eps}
\end{center}

# Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module5/Graphs/graph34.eps}
\end{center}

# Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/Module5/Graphs/graph35.eps}
\end{center}

# Notice

* Needed a vertex with in-degree 0 to start
  - Will always have at least 1 because no cycles

* Ties among vertices with in-degrees of 0 can be broken arbitrarily
  - Can be more than one correct answer, by definition, depending on the graph

# Running time?

* What is the worst-case running time?
  - Initialization O(|V| + |E|) (assuming adjacency list)
  - Sum of all find-new-vertex $O(|V|^2)$ (because each $O(|V|)$)
  - Sum of all decrements $O(|E|)$ (assuming adjacency list)
  - So total is $O(|V|^2)$ - not good for a sparse graph!

# Doing Better

* The trick is to avoid searching for a zero-degree node every time!
  - Keep the "pending" zero-degree nodes in a list, stack, queue, bag, table, or something
  - Order we process them affects output but not correctness or efficiency provided add/remove are both O(1)

* Using a queue:
  1. Label each vertex with its in-degree, *enqueue 0-degree nodes*
  2. While queue is not not empty
     1. v = dequeue()
     2. Output **v** and remove it from the graph
     3. For each vertex **u** adjacent to **v** (i.e., **u** such that $(v, u) \in E$), decrement the in-degree of **u**, if new degree is 0, enqueue it.

# Running Time?

\footnotesize
```java
labelAllAndEnqueueZeros() {
  for (ctr = 0; ctr < numVertices; ctr++) {
    v = dequeue();
    put v next in output
    for each w adjacent to v {
      w.indegree--;
      if (w.indegree == 0)
        enqueue(v);
    }
  }
}
```

\vspace{-1em}
* What is the worst-case running time?
  - Initialization: $O(|V| + |E|)$ (assuming adjacency list)
  - Sum of all enqueues and dequeues: $O(|V|)$
  - Sum of all decrements: $O(|E|)$ (assuming adjacency list)
  - So total is $O(|E| + |V|)$ - much better for sparse graph!

#

\vfill
\begin{center}
{\Huge Graph Traversals}
\end{center}

# Graph Traversals

* Next problem: For an arbitrary graph and a starting node **B**, find all nodes *reachable* from **v** (i.e., there exists a path from **v**)
  - Possibly "do something" for each node
  - Examples: print to output, set a field, etc.

* Subsumed problem: Is an undirected graph connected?
* Related but different problem: Is a directed graph strongly connected?
  - Need cycles back to starting node

* Basic Idea:
  - Keep following nodes
  - But "mark" nodes after visiting them, so the traversal terminates and processes each reachable node exactly once.

# Abstract Idea

```java
traverseGraph(Node start) {
  Set pending = emptySet()
  pending.add(start)
  mark start as visited
  while(pending is not empty) {
    next = pending.remove()
    for each node u adjacent to next {
      if (u is not marked) {
        mark u
        pending.add(u)
      }
    }
  }
}
```

# Running Time and Options

* Assuming **add** and **remove** are $O(1)$, entire traversal is $O(|E|)$
  - Use an adjacency list representation

* The order we traverse depends entirely on **add** and **remove**
  - Popular choice: a stack "depth-first graph search" "DFS"
  - Popular choice: a queue "breadth-first graph search" "BFS"

* DFS and BFS are "big ideas" in computer science
  - Depth: recursively explore one part before going back to the other parts not yet explored
  - Breadth: explore areas closer to the start node first

# Example: Depth First Search

* A tree is a graph and DFS and BFS are particularly easy to "see"

::: columns
:::: {.column width=.3}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Module5/Graphs/graph36.eps}
\end{center}
::::
:::: {.column width=.7}
```java
DFS(Node start) {
  mark and process start
  for each node u adjacent to start
    if u is not marked
      DFS(u)
}
```
::::
:::

* A B D E C F G H

* Exactly what we called a "pre-order traversal" for trees
  - The marking is because we support arbitrary graphs and we want to process each node exactly once.

# Example: Another DFS

* A tree is a graph and DFS and BFS are particularly easy to "see"

::: columns
:::: {.column width=.3}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Module5/Graphs/graph37.eps}
\end{center}
::::
:::: {.column width=.7}
```java
DFS2(Node start) {
  initialize stack s and push start
  mark start as visited
  while (s is not empty) {
    next = s.pop() // and "process"
    for each node u adjacent to next
      if (u is not marked)
        mark u and push onto s
  }
}
```
::::
:::

* A C F H G B E D
* A different but perfectly fine traversal

# Example: Breadth First Search

* A tree is a graph and DFS and BFS are particularly easy to "see"

::: columns
:::: {.column width=.3}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Module5/Graphs/graph38.eps}
\end{center}
::::
:::: {.column width=.7}
```java
BFS (Node start) {
  initialize queue q and enqueue start
  mark start as visited
  while (q is not empty) {
    next = q.dequeue() // and "process"
    for each node u adjacent to next
      if (u is not marked)
        mark u and enqueue onto q
  }
}
```
::::
:::

* A B C D E F G H
* A "level-order" traversal

# Comparison

* Breadth-first always finds shortest paths, i.e., "optimal solutions"
  - Better for "what is the shortest path from **x** to **y**"

* But depth-first can use less space in finding a path
  - If *longest path* in the graph is **p** and highest out-degree is **d** then DFS stack never has more than **d * p** elements
  - But a queue for BFS may hold $O(|V|)$ nodes

* A third approach:
  - *Iterative Deepening (IDFS)*:
    * Try DFS but disallow recursion more than **$K$** levels deep
    * If that fails, increment **$K$** and start the entire search over
  - Like BFS, finds shortest paths. Like DFS, less space.

# Saving the Path

* Our graph traversals can answer the reachability questions:
  - "Is there a path from node x to node y?"

* But what if we want to actually output the path?
  - Like getting driving directions rather than just knowing it's possible to get there!

* How to do it:
  - Instead of just "marking" a node, store the previous node along the path (when processing **u** causes us to add**v** to the search, set **v.path** field to be **u**)
  - When you reach the goal, follow **path** fields back to where you started (and then reverse the answer)
  - If just wanted path *length*, could put the integer distance at each node instead.

# Example using BFS

* What is the path from Seattle to Tyler
  - Remember marked nodes are not re-enqueued
  - Note shortest paths may not be unique

\begin{center}
\includegraphics[width=.65\textwidth]{images/Module5/Graphs/graph39.eps}
\end{center}

# Single Source Shortest Paths

* Done: BFS to find the minimum path length from **v** to **u** in $O(|E| + |V|)$

* Actually, can find the minimum path length from **v** to *every node*
  - Still $O(|E| + |V|)$
  - No faster way for a "distinguished" destination in the worst-case

* Now: Weighted graphs
  - Given a weighted graph and node **v**, find the minimum-cost path from **v** to every node

* As before, asymptotically no harder than for one destination

# Applications

* Driving directions

* Cheap flight itineraries

* Network routing

* Critical paths in project management

# Not as easy as BFS

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module5/Graphs/graph40.eps}
\end{center}

* Why BFS won't work: Shortest path may not have the fewest edges
  - Annoying when this happens with costs of flights

* We will assume there are no negative weights
  - Problem is *ill-defined* if there are negative-cost cycles
  - Today's algorithm is wrong if *edges* can be negative
    - There are other, slower (but not terrible) algorithms

#

\vfill
\begin{center}
{\Huge Dijkstra's Algorithm}
\end{center}

# Dijkstra's Algorithm

* Named after its inventor Edsger Dijkstra (1930-2002)
  - Truly one of the "founders" of computer science; this is just one of his many contributions
  - Many people have a favorite Dijkstra story, even if they never met him

"Computer science is no more about computers than astronomy is about telescopes" -- Edsger Dijkstra

# Dijkstra's Algorithm

* The idea; reminiscent of BFS, but adapted to handle weights
  - Grow the set of nodes whose shortest distance has been computed
  - Nodes not in the set will have a "best distance so far"
  - A priority queue will turn out to be useful for efficiency
* An example of a greedy algorithm
  - A series of steps
  - At each one the locally optimal choice is made

# Dijkstra's Algorithm: Idea

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module5/Graphs/graph41.eps}
\end{center}

* Initially, start node has cost 0 and all other nodes have cost $\inf$

* At each step:
  - Pick closest unknown vertex **v**
  - Add it to the "cloud" of known vertices
  - Update distances for nodes with edges from **v**

* That's it (But we need to prove it produces correct answers)

# The Algorithm

1. For each node $v$, set $v.cost = \inf$ and $v.known = false$
2. Set $source.cost = 0$
3. While there are unknown nodes in the graph
   1. Select the unknown node $v$ with lowest cost
   2. Mark $v$ as known
   3. For each edge $(v, u)$ with weight $w$,
      ```java
      c1 = v.cost + w // cost of best path through v to u
      c2 = u.cost // cost of best path to u previously known
      if (c1 < c2) { // if the path through v is better
        u.cost = c1
        u.path = v // for computing actual paths
      }
      ```

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Final Review and Exam
