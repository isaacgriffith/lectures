---
author:
- Isaac Griffith
title: Graph Coverage for Design Elements
institute: |
  CS 4422 and CS 5522

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

At the end of Today's Lecture you will be able to:

* Understand approaches and limitations of OO Testing

# Inspiration

\vfill
\centering
> "Testers don’t like to break things; they like to dispel the illusion that things work." -- Kaner, Bach, Pettichord

# OO Software and Designs

* Emphasis on modularity and reuse puts **complexity** in the **design connections**
* Testing **design relationships** is more important than before
* Graphs are based on the **connections** among the software components
  - Connections are dependency relations, also called **couplings**

# Call Graph

* The most common graph for structural design testing
* **Nodes:** Units (in Java - methods)
* **Edges:** Calls to units

::: columns
:::: column
\centering
\includegraphics[width=.5\textwidth]{images/Testing/Graph/callgraph.eps}

Example Call Graph
::::
:::: column

\textbf{\underline{Node Coverage} :} call every unit at least once (method coverage)
\vskip1em
\textbf{\underline{Edge Coverage} :} execute every call at least once (call coverage)

::::
:::

# Call Graphs on Classes

* Node and edge coverage of class call graphs often do not work very well
* Individual methods might not call each other at all!

::: columns
:::: column
## Class Stack

```java
public void push(Object o)
public Object pop()
public boolean isEmpty()
```
::::
:::: column
\centering
\includegraphics[width=.75\textwidth]{images/Testing/Graph/call_graphs_classes.eps}
::::
:::

\begin{center}
\Large \textbf{Other types of testing are needed - do \underline{not} use graph criteria}
\end{center}

# Inheritance & Polymorphism

\centering
**Caution**: Ideas are preliminary and not widely used

::: columns
:::: column
\centering
\includegraphics[width=.4\textwidth]{images/Testing/Graph/ex_inherit_hier.eps}

Example Inheritance Hierarchy Graph

* Classes are not executable so this graph is not directly testable
::::
:::: column
* We need \underline{objects}

\begin{center}
\includegraphics[width=.75\textwidth]{images/Testing/Graph/ih_objects.eps}
\end{center}

* What is coverage on this graph?
::::
:::

# Coverage on Inheritance Graph

* Create an object for each class?
  - This seems weak because there is no execution
* Create an object for each class and apply call coverage?

  - \textbf{\underline{OO Call Coverage}:} TR contains each reachable node in the call graph of an object instantiated for each class in the class hierarchy
  - \textbf{\underline{OO Object Call Coverage}:} TR contains each reachable node in the call graph of \underline{every} object instantiated for each class in the class hierarchy.

* Data flow is probably more appropriate ...

# Data Flow at the Design Level

* Data flow couplings among units and classes **are more complicated** than control flow couplings
  - When values are passed, they "change names"
  - Many different ways to share data
  - Finding defs and uses can be difficult - finding which uses a def can reach is very difficult
* When software gets complicated ... testers should get interested
  - That's where the faults are!

# Preliminary Definitions

* **Caller**: A unit that invokes another unit
* **Callee**: The unit that is called
* **Callsite**: Statement or node where the call appears
* **Actual parameter**: Variable in the caller
* **Formal parameter**: Variable in the callee

# Example Call Site

\begin{center}
\includegraphics[width=.65\textwidth]{images/Testing/Graph/example_callsite.eps}
\end{center}

* Applying data flow criteria to def-use pairs between units is **too expensive**
* Too many possibilities
* But this is integration testing, and we really only care about the **interface** ...

# Inter-procedural DU Pairs

* If we focus on the interface, then we just need to consider the **last definitions** of variables before calls and returns and **first uses** inside units and after calls
* **Last-def**: the set of nodes that define a variable `x` and has a def-clear path from the node through a callsite to a use in the other unit
  - Can be from caller to callee (parameter or shared variable) or from callee to caller as a return value
* **First-use**: The set of nodes that have uses of a variable `y` and for which there is a def-clear and use-clear path from the callsite to the nodes

# Inter-procedural DU Pairs Example

\begin{center}
\includegraphics[width=.4\textwidth]{images/Testing/Graph/inter_proc_du.eps}
\end{center}

# Inter-procedural DU Pairs Example

\begin{center}
\includegraphics[width=.95\textwidth]{images/Testing/Graph/inter_proc_du2.eps}
\end{center}

# Example - Quadratic

::: columns
:::: column
\tiny
```java
1 // Program to compute the quadratic root for two numbers
2 import java.lang.Math;
3
4 class Quadratic
5 {
6    private static float Root1, Root2;
7
8    public static void main (String[] argv)
9    {
10     int X, Y, Z;
11     boolean ok;
12     int controlFlag = Integer.parseInt (argv[0]);
13     if (controlFlag == 1)
14     {
15          X = Integer.parseInt (argv[1]);
16          Y = Integer.parseInt (argv[2]);
17          Z = Integer.parseInt (argv[3]);
18     }
19     else
20     {
21           X = 10;
22           Y = 9;
23           Z = 12;
24     }
```
::::
:::: column
\tiny
```java
25     ok = Root (X, Y, Z);
26     if (ok)
27       System.out.println
28         (“Quadratic: ” + Root1 + Root2);
29     else
30       System.out.println (“No Solution.”);
31   }
32
33 // Three positive integers, finds quadratic root
34   private static boolean Root (int A, int B, int C)
35   {
36      double D;
37      boolean Result;
38      D = (double) (B*B) -  (double) (4.0*A*C );
39      if (D < 0.0)
40      {
41         Result = false;
42         return (Result);
43      }
44      Root1 = (double) ((-B + Math.sqrt(D))/(2.0*A));
45      Root2 = (double) ((-B – Math.sqrt(D))/(2.0*A));
46      Result = true;
47      return (Result);
48   } // End method Root
49 } // End class Quadratic
```
::::
:::

# Example - Quadratic

::: columns
:::: column
\tiny
```java
1 // Program to compute the quadratic root for two numbers
2 import java.lang.Math;
3
4 class Quadratic
5 {
6  private static float Root1, Root2; // shared variables
7
8  public static void main (String[] argv)
9  {
10    int X, Y, Z;
11    boolean ok;
12    int controlFlag = Integer.parseInt (argv [0]);
13    if (controlFlag == 1)
14    {
15       X = Integer.parseInt (argv [1]); // last defs
16       Y = Integer.parseInt (argv [2]); // last defs
17       Z = Integer.parseInt (argv [3]); // last defs
18    }
19    else
20    {
21       X = 10; // last defs
22       Y = 9;  // last defs
23       Z = 12; // last defs
24    }
```
::::
:::: column
\tiny
```java
25    ok = Root (X, Y, Z);
26    if (ok) // first use
27      System.out.println
28        (“Quadratic: ” + Root1 + Root2); // first use
29    else
30      System.out.println (“No Solution.”);
31  }
32
33  // Three positive integers, finds the quadratic root
34  private static boolean Root (int A, int B, int C)
35  {
36    double D;
37    boolean Result;
38    D = (double) (B*B) - (double) (4.0*A*C); // first use A,B,C
39    if (D < 0.0)
40    {
41      Result = false; // last def
42      return (Result);
43    }
44    Root1 = (double) ((-B + Math.sqrt (D)) / (2.0*A)); // last def
45    Root2 = (double) ((-B – Math.sqrt (D)) / (2.0*A)); // last def
46    Result = true; // last def
47    return (Result);
48  } / /End method Root
49 } // End class Quadratic
```
::::
:::

# Quadratic - Coupling DU-pairs

\centering

Pairs of locations: **method** name, **variable** name, **statement**

(main(), X, 15) -- (Root(), A, 38)

(main(), Y, 16) -- (Root(), B, 38)

(main(), Z, 17) -- (Root(), C, 38)

(main(), X, 21) -- (Root(), A, 38)

(main(), Y, 22) -- (Root(), B, 38)

(main(), Z, 23) -- (Root(), C, 38)

(Root(), Root1, 44) -- (main(), Root1, 28)

(Root(), Root2, 45) -- (main(), Root2, 28)

(Root(), Result, 41) -- (main(), ok, 26)

(Root(), Result, 46) -- (main(), ok, 26)

# Coupling Data Flow Notes

* Only variables that are **used or defined** in the callee
* **Implicit initializations** of class and global variables

\vskip1em

* **Transitive** DU-pairs are too expensive to handle
  - A calls B, B calls C, and there is a variable defined in A and used in C

\vskip1em

* **Arrays**: a reference to one element is considered to be a reference to all elements

# Inheritance, Polymorphism \& Dynamic Binding

* Additional **control and data connections** make data flow analysis more complex
* The defining and using units may be in **different call hierarchies**
* When inheritance hierarchies are used, a def in one unit could reach uses in **any class** in the inheritance hierarchy
* With **dynamic binding**, the same location can reach different uses depending on the current type of the using object
* The same location can have different definitions or uses at different points in the execution!

# Additional Definitions

* **Inheritance**: If class **B** *inherits* from class **A**, then all variables and methods in **A** are implicitly in **B**, and **B** can add more
  - A is the **parent** or **ancestor**
  - B is the **child** or **descendant**
* An object reference `obj` that is declared to be of type `A` can be assigned an object of either type `A`, `B`, or any of `B`'s descendants
  - **Declared type**: Type used in the declaration: `A obj;`
  - **Actual type**: Type used in object assignment: `obj = new B();`
* **Class (State) Variables**: The variables declared at the class level, often private

# Types of Def-Use Pairs

\begin{center}
\includegraphics[width=.65\textwidth]{images/Testing/Graph/defuse_types.eps}
\end{center}

# OO Data Flow Summary

* The defs and uses could be in the **same class**, or **different** classes

\vskip1em

* **Researchers** have applied data flow testing to the direct coupling OO situation
  - Has not been used in practice
  - No tools available

\vskip1em

* Indirect coupling data flow testing has **not been tried** either in research or in practice
  - Analysis cost may be prohibitive

# Web Applications and Other Distributed Software

\begin{center}
\includegraphics[width=.4\textwidth]{images/Testing/Graph/dist_data_flow.eps}
\end{center}

* "message" could be HTTP, RMI, or other mechanism
* A() and B() could be in the same class or accessing a persistent variable such as in a web session
* Beyond current technologies

# Summary - What Works?

* **Call graphs** are common and very useful ways to design integration tests

* **Inter-procedural data flow** is relatively easy to compute and results in effective integration tests

* The ideas for **OO software** and **web applications** are preliminary and have not been used much in practice

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
