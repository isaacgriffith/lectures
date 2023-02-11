# Object-Oriented Programming

**Lecture Topics**
* L19 - Using collection classes, iterators, and other common library components.

**Learning Outcomes**
1. Define and use iterators and other operations on aggregates, including operations that take functions as arguments, in multiple programming languages, selecting the most natural idioms for each language. [U]

# Basic Type System

**Lecture Topics**
* L03 - Type safety and errors caused by using values inconsistently given their intended types
* Generic types (parametric polymorphism)
  - L02 - Definition
  - L03 - Use for generic libraries such as collections
  - L01 - Comparison with ad hoc polymorphism (overloading) and subtype polymorphism

**Learning Outcomes**
1. Give an example program that does not type-check in a particular language and yet would have no error if run. [F]
2. Discuss the differences among generics, subtyping, and overloading. [F]
3. Explain multiple benefits and limitations of static typing in writing, maintaining, and debugging software. [F]
4. For multiple programming languages, identify program properties checked statically and program properties checked dynamically. [U]  
5. Use types and type-error messages to write and debug programs. [U]
6. Define and use program pieces (such as functions, classes, methods) that use generic types, including for collections. [U]

# Basic Analysis

**Lecture Topics**
* L10, L11 - Differences among best, expected, and worst case behaviors of an algorithm
* L10, L11 - Asymptotic analysis of upper and expected complexity bounds
* L10, L11 - Big O notation: formal definition
* L10, L11 - Complexity classes, such as constant, logarithmic, linear, quadratic, and exponential
* L10, L11 - Empirical measurements of performance
* L04 - L29 - Time and space trade-offs in algorithms

**Learning Outcomes**
1. Explain what is meant by “best”, “expected”, and “worst” case behavior of an algorithm. [F]
2. In the context of specific algorithms, identify the characteristics of data and/or other conditions or assumptions that lead to different behaviors. [A]
3. State the formal definition of big O. [F]
4. List and contrast standard complexity classes. [F]
5. Give examples that illustrate time-space trade-offs of algorithms. [F]
6. Determine informally the time and space complexity of simple algorithms. [U]
7. Perform empirical studies to validate hypotheses about runtime stemming from mathematical analysis. Run algorithms on input of various sizes and compare performance. [A]

# Fundamental Data Structures

**Lecture Topics**
* Abstract data types and their implementation
  - L06 - Stacks
  - L07 - Queues
  - L23 - Priority Queues
  - L21, L22 - Sets
  - L20, L21 - Maps
* L04, L05 - Linked lists
* L04 - L29 - Strategies for choosing the appropriate data structure

**Learning Outcomes**
1. Describe common applications for each of the following data structures: stack, queue, priority queue, set, and map. [F]
2. Compare and contrast the costs and benefits of dynamic and static data structure implementations. [A]
3. Write programs that use each of the following data structures: arrays, records/structs, strings, linked lists, stacks, queues, sets, and maps. [U]
4. Compare alternative implementations of data structures with respect to performance. [A]

# Fundamental Data Structures and Algorithms

**Lecture Topics**
* L09 - Sequential and binary search algorithms
* L17 - Worst case quadratic sorting algorithms (selection, insertion)
* L17, L18 - Worst or average case O(N log N) sorting algorithms (quicksort, heapsort, mergesort)
* L20, L21 - Hash tables, including strategies for avoiding and resolving collisions
* L12, L13, L14, L15 - Binary search trees
  - Common operations on binary search trees such as select min, max, insert, delete, iterate over tree
* Graphs and graph algorithms
  - L28 - Representations of graphs (e.g., adjacency list, adjacency matrix)
  - L15, L28 - Depth- and breadth-first traversals
  - L29 - Shortest-path algorithms (Dijkstra's and Floyd's  algorithms)
  - L29 - Minimum spanning tree (Prim's and Kruskal's algorithms)
* L23 - Heaps
* Pattern matching and string/text algorithms (e.g., substring matching, regular expression matching, longest common subsequence algorithms)

**Learning Outcomes**
1. Implement simple search algorithms and explain the differences in their time complexities. [A]
2. Be able to implement common quadratic and O(N log N) sorting algorithms. [U]
3. Solve problems using fundamental graph algorithms, including depth-first and breadth-first search. [U]
4. Solve problems using graph algorithms, including single-source and all-pairs shortest paths, and at least one minimum spanning tree algorithm. [U]
5. Trace and/or implement a string-matching algorithm. [U]
6. Describe the implementation of hash tables, including collision avoidance and resolution. [F]
7. Discuss the runtime and memory efficiency of principal algorithms for sorting, searching, and hashing. [F]
8. Discuss factors other than computational efficiency that influence the choice of algorithms, such as programming time, maintainability, and the use of application-specific patterns in the input data. [F]
9. Explain how tree balance affects the efficiency of various binary search tree operations. [F]
10. Describe the heap property and the use of heaps as an implementation of priority queues. [F]

# Algorithms and Design

**Lecture Topics**
* Problem-solving strategies
  - L08 - Iterative and recursive mathematical functions
  - L15 - Iterative and recursive traversal of data structures
  - L09 - Divide-and-conquer strategies
* Fundamental design concepts and principles
  - L01 - Abstraction
  - L01 - Program decomposition
  - L02 - Encapsulation and information hiding
  - L02 - Separation of behavior and implementation

**Learning Outcomes**
1. Implement a divide-and-conquer algorithm for solving a problem. [U]
2. Apply the techniques of decomposition to break a program into smaller pieces. [U]
3. Identify the data components and behaviors of multiple abstract data types. [U]
4. Implement a coherent abstract data type, with loose coupling between components and behaviors. [U]
5. Determine whether a recursive or iterative solution is most appropriate for a problem. [A]

# Introduction Modeling and Simulation

**Lecture Topics**
* L02 - Models as abstractions of situations
* L07 - Simulations as dynamic modeling

**Learning Outcomes**
1. Create a simple, formal mathematical model of a real-world situation and use that model in a simulation. [U]
2. Create a simple display of the results of a simulation. [U]
3. Explain the concept of modeling and the use of abstraction that allows the use of a machine to solve a problem. [F]
