---
author:
- Isaac Griffith
title: Refactoring - Program Restructuring
institute: |
  CS 4423 and CS 5523

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

After today's lecture you will:

::: columns
:::: {.column width=.7}
* Be able to understand and describe various approaches to program restructuring.
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears.jpg}
::::
:::

#

\centering
\vfill
\begin{minipage}{.85\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.775\textwidth}
\Huge Software Restructuring
\vskip-0.75em
\rule{.975\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# Software Restructuring

* Software restructuring dates back to the mid 1960s, as soon as programs were written in Fortran.
* Topics of discussion in this section are:
  - Factors influencing software structure
  - Classification of restructuring approaches
  - Restructuring techniques
    - Elimination-of-goto approach
    - Localization and information hiding approach
    - System sandwich approach
    - Clustering approach
    - Program slicing approach

# Software Structure Factors

* Software structure is a \color{Roarange}set of attributes\color{Black}\ of the software such that the programmer gets a good understanding of software.
* Any factor that can influence the state of software or the programmer’s perception might influence software structure.
* One view of the factors that influence software structure has been shown in Fig. 7.9.

::: columns
:::: {.column width=.05}
::::
:::: {.column width=.3}
- Code
- Tools
- Managers and policies
::::
:::: column
- Documentation
- Programmers
- Environment
::::
:::

# Software Structure Factors

\centering
\includegraphics[width=.65\textwidth]{images/refactoring/ref09.eps}

# Software Structure Factors

* Code
  - Code quality at all levels of details (e.g. variables, constants, statements, function, and module) impact code understanding.
  - Adherence to coding standards improves code quality.
  - Adoption of common architectural styles enhances code understanding.

* Documentation
  - Internal documentation (also known as in-line codumentation)
  - External documentation
    - \color{GrowlingGray}Requirements documents\color{Black}
    - \color{GrowlingGray}Design documents\color{Black}
    - \color{GrowlingGray}User manuals\color{Black}
    - \color{GrowlingGray}Test cases\color{Black}

# Software Structure Factors

* Tools – Programming environment
  - Development tools help programmers better understand the code.
    - \color{GrowlingGray}Tracing of source code help in  understanding the dynamic behavior of the code.\color{Black}
    - \color{GrowlingGray}Animation of algorithms help in understanding the dynamic strategy adopted in algorithms.\color{Black}
    - \color{GrowlingGray}Cross referencing of global variables reveal interactions among modules.\color{Black}
    - \color{GrowlingGray}Tools can reformat code for better readability via pretty printing, highlighting of key words, and color coding of source code.\color{Black}
* Programmers
  - Qualities of programmers influence their perception of structure.
    - \color{GrowlingGray}Individual capabilities\color{Black}
    - \color{GrowlingGray}Education\color{Black}
    - \color{GrowlingGray}Experience and training\color{Black}
    - \color{GrowlingGray}Aptitude\color{Black}

# Software Structure Factors

* Managers and policies
  - Management can play an influencing role in having a good initial structure and sustain it by designing policies and allocating resources.
  - Examples
    - \color{GrowlingGray}Management can design general policies  to adhere to standards.\color{Black}
    - \color{GrowlingGray}Management can tie the annual performance review with the programmer’s adherence to standards.\color{Black}

* Environment
  - This refers to the general working environment of programmers.
  - Example: Physical facilities and availability of resources when needed

# Restructuring Approaches

* A broad classification of software restructuring approaches

\centering
\includegraphics[width=.85\textwidth]{images/refactoring/ref10.eps}

# Restructuring Approaches

* Approaches not involving code changes

  - Train programmers in software engineering, including architectural styles and modularization techniques.
  - Upgrade documentation
    - \color{GrowlingGray}Make in-line comments more accurate and readable.\color{Black}
    - \color{GrowlingGray}Update comments to reflect code changes.\color{Black}
    - \color{GrowlingGray}Update external documentations to make them consistent with code, accurate, and complete.\color{Black}

# Restructuring Approaches

* Approaches involving code changes
  - **Practices:**
    - \color{GrowlingGray}Restructuring code with preprocessors.\color{Black}
    - \color{GrowlingGray}Making code understandable by means of inspection.\color{Black}
    - \color{GrowlingGray}Formatting code by adhering to standards and style guidelines.\color{Black}
    - \color{GrowlingGray}Restructuring code for reusability.\color{Black}
  - **Techniques:**
    - \color{GrowlingGray}Incremental restructuring\color{Black}
    - \color{GrowlingGray}Goto-less approach\color{Black}
    - \color{GrowlingGray}Case-statement approach\color{Black}
    - \color{GrowlingGray}Boolean flag approach\color{Black}
    - \color{GrowlingGray}Clustering approach\color{Black}
  - **Tools**
    - \color{GrowlingGray}Eclipse IDE, IntelliJ IDEA, jFactor, Refactorit, and Clone Doctor\color{Black}

# Restructuring Techniques

* Restructuring techniques
  - Those were developed in the mid-70s, before object-oriented programming.
  - The techniques are applied at different levels of abstractions.
* Example of restructuring techniques
  - Elimination-of-goto Approach
  - Localization and Information Hiding Approach
  - System Sandwich Approach
  - Clustering Approach
  - Program Slicing Approach

# Elimination-of-\color{Roarange}goto\color{Black}\ Approach

- Before the onset of structured programming, much code was written in the ‘70s with \color{Roarange}`goto`\color{Black}\ statements.
- Structured programming puts emphasis on the following control constructs: \color{Roarange}`for`\color{Black}, \color{Roarange}`while`\color{Black}, \color{Roarange}`until`\color{Black}, and, \color{Roarange}`if-then-else`\color{Black}.
- Those constructs make occurrences of loop and branching clear.
- It has been shown that every flowchart program with \color{Roarange}`goto`\color{Black}\ statements can be transformed into a functionally equivalent \color{Roarange}`goto-less`\color{Black}\ program by using \color{Roarange}`while`\color{Black}\ statements.

# Localization Approach

* Localization
  - \color{GrowlingGray}It is a process of collecting the logically related computational resources in one physical module.\color{Black}
    - Functions, procedures, operations, and data types are computational resources.
  - \color{GrowlingGray}By localizing computational resources into separate modules, programmers can restructure a program into a loosely coupled system of sufficiently independent modules.\color{Black}
  - \color{GrowlingGray}Sometimes, localization is difficult to achieve.\color{Black}
    - A variable may be imported into a module by means of the include statement.
    - Data sharing among functions is not explicitly represented in source code.

# Localization Approach

* A restructuring process based on localization of variables and functions
  - \color{GrowlingGray}Localization of variables\color{Black}
    - Organize global variables and functions which refer to those global variables into package-like groups.
    - This organization can be achieved by applying the concept of closure of functions to a set of global variables.
    - This leads to groups of functions and global variables referred to by those functions.
  - \color{GrowlingGray}Localization of functions\color{Black}
    - Put locally called functions and the calling function in the same group.

# Information Hiding Approach

* Information Hiding
  - \color{GrowlingGray}The details of implementations of computational resources can be hidden to make it easier to understand the program.\color{Black}
  - \color{GrowlingGray}For example, a queue is a high level concept which can be implemented by means of a variety of low level data structures.\color{Black}
    - Singly linked list
    - Doubly linked list
    - Arrays
  - \color{GrowlingGray}A programmer can design a function by using \color{Roarange}enqueue\color{GrowlingGray}\ and \color{Roarange}dequeue\color{GrowlingGray}\ calls without any concern for their actual implementations.\color{Black}

# Information Hiding Approach

* A restructuring process based on localization of variables and functions
  - \color{GrowlingGray}Information hiding and hierarchical structuring\color{Black}
    - Organize groups of functions into hierarchical package structures based on the visibility of functions within groups.
    - Those functions and variables which are only externally referable and visible to other packages constitute the package specification.

# System Sandwich Approach

* This approach is applied to those software which cannot be restructured with any hope, but need to be retained for their outputs.
* As illustrated, write a new front-end interface and a new back-end data base so that:
  - \color{GrowlingGray}it is easy to interface with the program; and\color{Black}
  - \color{GrowlingGray}the program’s outputs are recorded in a more structured way.\color{Black}

\centering
\includegraphics[width=.85\textwidth]{images/refactoring/ref11.eps}

# Clustering Approach

* Software modularization is an important design step.

* A program can be remodularized in two ways.
  - \color{GrowlingGray}System level remodularization\color{Black}
    - This is a top-down approach.
    - Partition the program into smaller modules

  - \color{GrowlingGray}Entity level remodularization\color{Black}
    - This is a bottom-up approach.
    - Group a  program’s entities to form larger modules.

# Clustering Approach

\centering
\includegraphics[width=.8\textwidth]{images/refactoring/ref12.eps}

# Clustering Approach

* The concept of clustering is key to modularization.
* Clusters are defined as continuous regions of space containing a relatively high density of points, separated from other such regions by regions containing a relatively low density of points.
* Modularization is defined as the clustering of large amount of entities in groups in such a way that the entities in one group are more closely related, based on some \color{Roarange}similarity metrics\color{Black}.
* While applying the idea of clustering, two factors are taken into account:
  - \color{GrowlingGray}What similarity metrics to consider?\color{Black}

  \vskip1.5em

  - \color{GrowlingGray}What clustering algorithm to use?\color{Black}

# Clustering Approach

* Similarity metrics
  - \color{GrowlingGray}Distance measures\color{Black}
    - Euclidean distance
    - Manhattan distance
  - \color{GrowlingGray}Association coefficients\color{Black}
    - Simple matching coefficient
    - Jaccard coefficient


# Association coefficient examples
- Let $x$ and $y$ be two entities. Let:

  \vskip1em
  $a$ = # of features present for both $x$ and $y$.

  \vskip1em
  $b$ = # of features present for $x$ but not $y$.

  \vskip1em
  $c$ = # of features present for $y$ but not $x$.

  \vskip1em
  $d$ = # of features **not** present for both $x$ and $y$.

  \vskip1em

- Simple matching coefficient: $simple(x, y) = (a + d)/(a + b + c + d)$.
- Jaccard coefficient: $Jaccard(x, y) = a/(a + b + c)$.

# Clustering Approach

* Clustering algorithms: \color{Roarange}three broad techniques\color{Black}\ applied.
  - \color{GrowlingGray}Graph theoretical algorithms\color{Black}
  - \color{GrowlingGray}Construction algorithms\color{Black}
  - \color{GrowlingGray}Optimization algorithms (aka iterative and improvement algorithms)\color{Black}
  - \color{GrowlingGray}Hierarchical algorithms\color{Black}
    - Divisive algorithms
    - Agglomerative algorithms
  - \color{GrowlingGray}The clustering produced by a hierarchical algorithm can be visualized in a \color{Roarange}dendogram\color{Black}
    - The dendogram representation of the hierarchy

# Clustering Approach

* The general structure of an agglomerative algorithm  

```
1. IF there are N entities, begin with N clusters such that each
   cluster contains a unique entity.
   Compute the similarities between the clusters
2. WHILE there is more than a cluster
   DO
      Find the most similar pair of clusters and merge them into
      a single cluster.
      Recompute the similarities between the clusters
   END
```

# Divisive Algorithms

\vskip-1.5em

::: columns
:::: {.column width=.7}

\begin{center}
\includegraphics[width=.95\textwidth]{images/refactoring/ref12.eps}
\end{center}

\tiny
\vskip-2.5em
Illustration of system level remodulariation.

* Bullets represent low level entities
* Dashed shapes represent modules
* Arrows represent progression from one level to the next

::::
:::: {.column width=.3}

\begin{center}
\includegraphics[width=\textwidth]{images/refactoring/ref13.eps}
\end{center}

\tiny
\vskip-2.5em
Dendrogram repsentation of the clustering process

::::
:::

# Agglomerative algorithms

\centering
\includegraphics[width=.725\textwidth]{images/refactoring/ref14.eps}

# Program Slicing Approach

* Two kinds of program slicing
  - \color{Roarange}\textbf{Backward slicing:}\color{Black}\ \color{GrowlingGray}The set of statements that can affect the value of a variable at some point of interest in a program is called a backward slice.\color{Black}
  - \color{Roarange}\textbf{Forward slicing:}\color{Black}\ \color{GrowlingGray}The set of statements that are likely to be affected by the value of a variable at some point of interest in a program is called  a forward slide.\color{Black}
* A key idea in program slicing
  - Identify and extract a cohesive subset of statements from a program.
* Therefore, if a module supports multiple functionalities, a portion of the code can be extracted to form a new module.
* Large functions can be decomposed into smaller functions by means of program slicing to restructure programs.

# For Next Time

::: columns
:::: {.column width=.6}
\footnotesize
* Review EVO Chapter 7.5 - 7.6
* Read EVO Chapter 8.1 - 8.2
* Watch Lecture 20
::::
:::: {.column width=.4}
\centering
\includegraphics[width=.85\textwidth]{images/next_time.png}
::::
:::

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
