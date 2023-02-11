---
author:
- Isaac Griffith
title: Personal Software Process
institute: |
  CS 2263

  Department of Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

After today's lecture you will be able to:

* Understand the basic notions of the PSP
* Understand the importance of the PSP
* Be capable of applying the concepts of PSP to your daily practice

# Inspiration

\vfill
\centering

> "One principle problem of educating software engineers is that they will not use a new method until they believe it works and, more importantly, that they will not believe the method will work until they see it for themselves." -- Humphrey, W.S.

# PSP

\begin{center}
\includegraphics[width=.75\textwidth]{images/PSP/cbrown.jpeg}
\end{center}

\centering

**Analogical Reasoning**

World = Software Development Project

Birth = Me joining the development team

# The Personal Software Process (PSP)

* The **software process** is about making software engineering groups/teams work to the best of their abilities
* The **personal software process** is about making individual engineers work to the best of their abilities
* Central to both is feedback ---
  - *through analysis of practical application of the process, the process should be changed for the better*
* Software engineers should accept responsibility for the quality of their work
* Software engineers can do this only if they have a way of evaluating quality and improving quality (through experience)
* The software process improves individual engineers to some extent, but it is possible for a project to succeed even when an individual participant has not!
* The PSP is individual oriented: it is possible for an individual to succeed within a project that fails.

# The Personal Software Process (PSP)

PSP is a structured software development process that is intended to help software engineers understand and improve their performance, by using a "disciplined, data-driven procedure":

* **Improve their estimating and planning skills.**
* Make commitments they can keep.
* Manage the quality of their projects.
* Reduce the number of defects in their work.

The PSP was created by Watts Humphrey to apply the underlying principles of the SEI's Capability Maturity Model (CMM) to the software development practices of a single developer.

# Criticisms of the PSP

The PSP is not universally accepted:

* some think it is a good idea in theory but not in practice
* some think that it is not flexible enough
* some think that it is too time consuming
* some think it should be up to individuals to find their own way of working

In fact, the PSP is only a framework of common sense ideas and suggestions which engineers are encouraged to think about as they learn from experience

\vskip1em

The PSP fails, IMHO, when it is used by the team to criticize individuals. This risk occurs when the PSP is used, rightly, to give feedback to the team-wide process.

\vskip1em

... make up your own minds ...

# Overview of PSP

There are four main areas to examine:

* assumptions
* process stages
* measures; basic and derived
* results: training and industry

**In the case study after this set of lectures you will be asked to run your own PSP while developing a small piece of code.**

\vskip1em

This alone is not enough to let you judge the merits of PSP

\vskip1em

It is enough to give you an idea of how to carry out the process

# PSP Assumptions

* *Software engineers currently learn software development by developing toy programs*
* *They develop their own process since process is not taught in introductory classes*
* *These toy processes do not provide a suitable foundation for large-scale software development*
* *To use effective methods consistently, engineers must believe that they are effective*
* *To believe that they are effective, they must use them*
* *To teach effective system processes we need to start with large system practices, select those that are suitable for individuals and introduce them incrementally*

# PSP Process Stages

* PSP 0 Current Process, Basic Measures
  - PSP 0.1 coding standard, process improvement proposal, size measurement
  - Leads to: **Personal Measurement**
* PSP 1 Size estimating, test, report
  - PSP 1.1. task planning, schedule planning
  - Leads to: **Personal Planning**
* PSP 2 Code reviews, design reviews
  - PSP 2.1 design templates
  - Leads to: **Personal Quality**
* PSP 3 Cyclic Development
  - Leads to: **Scaling Up**

# PSP 0: Personal Measurement

* Engineers gather data on the time they spend by phase and the defects they find
* Generates real, personal data and provides the base benchmark for measuring progress
* 3 Phases: planning, development and postmortem
* PSP 0 adds a coding standard, size measurement and a process improvement proposal

# PSP 1: Personal Planning

* This step must introduce some method for estimating sizes and development times for new programs based on personal data

* The methods employed are usually (should be) based on linear regression with prediction intervals to indicate size and estimate quality

* PSP1.1 adds schedule and task planning

# PSP 2: Personal Quality

* This step introduces defect management

* Using data from PSP exercises, engineers construct and use checklists for design and code review
* From their own data, they see how checklists help personal reviews
* PSP 2.1 adds design specification and analysis techniques along with defect prevention, process analyses and process benchmarks

# PSP 3: Scaling Up

* The final step shows how engineers can couple multiple processes in a cyclic fashion to scale up to developing systems with many thousands of lines of code (LOC)

* It uses an iterative enhancement approach

* *A team software process should be developed as the next step for systems larger than 10K LOC*

# PSP Programming Exercises

The following exercises are widely used and accepted as providing a good case set on which to start developing a PSP:

* calculate mean and standard deviation of numbers in a linked list
* count LOC in a source program
  - enhance to count total and function LOC
* calculate linear regression parameters
* perform numerical integration
  - enhance to calculate prediction interval
* calculate correlation of 2 lists
* chi-squared tests for normal distribution
* calculate multiple regression parameters

# PSP Basic Measures

* **Development Time:** measured in minutes (!) using a *time recording log* designed to account for interruptions

* **Defects:** any change to the design or code to get the program to compile or test correctly; recorded in a *defect recording log*

* **Size:** lines of code, used primarily for estimating development time; new, modified and re-used code is distinguished.

# PSP Derived Measures

* Estimating accuracy --- time and size
* Test defects/KLOC
* Compile defects/KLOC
* yield: % of defects injected before 1st compile that are removed before 1st compile
* appraisal time --- time in review
* failure time --- time in compile and test
* cost of quality -- appraisal time + failure time
* appraisal/failure ratio

# PSP Quality Strategy

* Defects are basic quality measure
* Engineers should
  - remove them
  - determine their cause (type)
  - learn to prevent them
* PSP uses private review with the goal of finding all defects before 1st compile and test

# PSP Training Data

* Each programming assignment results in approx. 70 pieces of data being collected by each engineer
* It is collected and collated by instructors to provide feedback during training
* Thre is a well cited study based on 23 PSP classes consisting of 298 engineers, over 300,000 LOC during > 15,000 hours, about 22,000 defects were found and removed
* Each analysis is based on at least 170 cases where complete data was available

# PSP Statistical Analysis

* Large individual differences are expected when measuring software engineering performance
* Consequently, rather than studying changes in group averages, the study focuses on the average change in engineers
* The repeated measures of variance method analyses the differences across multiple trials to uncover trends

# PSP Sample Exercise (spiral walker)

::: columns
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/PSP/spiral.eps}
\end{center}
::::
:::: column
* You are to implement a function, f, in Java that takes as input the:
  - size of a square grid
* Calculates the x,y coordinates of the robot after it has walked *half way* around the grid following a spiral walk, starting at 0,0 and moving clockwise.
* In the example the function calculates
  - f(6) = (2,0)
::::
:::

# PSP Sample Exercise (spiral walker)

* Estimate: time of development, LOC
* Note/Count/Measure (for every version, i.e., every time you compile and run):
  - Compile defects - syntax/semantic errors
  - Test defects - code is wrong, design is wrong, test is wrong?
  - LOC - implementation/tests
  - Comments/Code ratio
  - Time spent on each task between versions - testing, coding, designing, commenting
  - The reason for the compile/run - expected *outcome* versus actual *outcome*

#

Technical Interviews

How CS Resumes Should Look

* **One Page Only!** unless > 10 years experience
* **A Real Resume Format** with organized columns
* **Short** (1 -- 2) line bullets
* **Focus on Accomplishments** not responsibilities
 - "Accomplished X by implementing Y which led to Z"
* **GPA** if at lest 3.0 min (in-major, overall)
* **3 -- 4 Projects** Courses & independent, finished or unfinished
* **List of Technical Skills** Short! Cut the "fluff"
* **No Objective** -- Objectives/summaries are almost always useless

# Coding Interviews

* Can be part of
 - On-site Interview
 - Remote Interview

* Typically involve a non-ide based coding process
 - Whiteboard
 - Collaborative Editor

# How You're Judged

\begin{center}
\Large How did you do \textbf{RELATIVE to other} candidates on the \textbf{SAME} question?
\end{center}

* It's not about how quickly you solved the problem...

* \color{Roarange}... it's about how quickly you solved it \textbf{\underline{relative}} to other candidates

# What Really Happens

* Knowledge Questions
 - + Coding
* Design/Scalability
 - + Coding
* Algorithms/Problem Solving
 - + Coding

# Technical Questions

1. Ask Questions!
  - Questions are more ambiguous than they appear
2. Talk out loud
  - Show us how you think
3. Think critically
  - Does your algorithm really work? What's the space and time complexity
4. Code slowly and methodically
  - It's not a race
5. Test your code
  - And make CAREFUL fixes

# Knowledge Questions

* If you list it, know it
* If you don't know it, admit it
 - Derive it if possible

# How to Approach

1. \underline{\textbf{S}}cope the Problem
  - Ask questiosn
  - Make appropriate assumptions
2. Define \underline{\textbf{K}}ey Components
  - Can be somewhat naive
3. \underline{\textbf{I}}dentify \underline{\textbf{I}}ssues
  - Bottlenecks, tradeoffs
4. \underline{\textbf{R}}epair & \underline{\textbf{R}}edesign

# How to Prepare

* Read about design of major companies
 - Twitter, Facebook, Quora, Google, etc.
 - Think about WHY they're designed that way
* Learn/review key concepts
 - Task queues, databases, sharding, etc.
* Practice questions

# Why?

::: columns
:::: column
* String CS fundamentals
* Analytical skills
* Make tradeoffs
::::
:::: column
* Push through hard problems
* Communication
* How you think
::::
:::

# Essential Knowledge

+-----------------+----------------------+-------------+
| Data Structures | Algorithms           | Concepts    |
+:================+:=====================+:============+
| ArrayLists      | Merge Sort           | Big O Time  |
+-----------------+----------------------+-------------+
| Hash Tables     | Quick Sort           | Big O Space |
+-----------------+----------------------+-------------+
| Trees (+ Tries) | Breadth-First Search | Recursion   |
+-----------------+----------------------+-------------+
| Graphs          | Depth-First Search   | Recursion   |
+-----------------+----------------------+-------------+
| Stacks/Queues   | Binary Search        |             |
+-----------------+----------------------+-------------+
| Heaps           |                      |             |
+-----------------+----------------------+-------------+

\pause

\centering
\Large \textbf{CS 2235!!!}

# Preparation

* Practice Implementation of DS/Algorithms
* MASTER Big O
* Practice with interview questions
* Code on paper/whiteboard
* Mock interviews

\pause

\centering
\Huge \textbf{PUSH YOURSELF!}

# What is NOT expected

* To know the answers
* To solve immediately
* To code perfectly

# What is expected

* Be excited about hard problems
* More than just "correct"
* Drive!
* Keep trying when stuck
* Write real code

\pause

\centering
\large \textbf{Show them how you think!}

# Approach

1. Listen (for clues)
2. Draw an Example
3. Brute Force / Naive
4. Optimize
5. Walkthrough
6. Write Beautiful Code
7. Testing

# Best Conceivable Runtime

* BCR is the runtime you know you can't beat.

* For example:
 - If asked to compute the intersection of two sets
 - You know you can't beat $O(|A| + |B|)$

# Step 1 Listen (for clues)

* **Pay very close attention**
 - absorb all info from the problem description
* You will need this for an optimal algorithm

# What's the clue?

* Anagram server
 - Ex: rates -> aster, stare, taser, tears

* Clue: why is it on a server?

# Step 2 Draw an Example

* Most examples are too small or are special cases

* **Debug your example.**
 - Is there any way it's a special case
 - Is it big enough?

# Example

Intersection of Two Sorted Arrays

* Most people draw something like this:

\begin{center}
\Large
\vspace{-2em}
\[[1, \underline{12}, 15, 19]\]
\[[2, \underline{12}, 13, 20]\]
\end{center}

 - Too small
 - Too special-case-y
   * same size, one common element, same index

# Example

* Better:

\begin{center}
\Large
\vspace{-2em}
\[[1, 12, \underline{15}, \underline{19}, 20, \underline{21}]\]
\[[2, \underline{15}, 17, \underline{19}, \underline{21}, 25, 27]\]
\end{center}

 - Big
 - No special cases

# Step 3

* Get a brute-force solution as soon as possible
* Don't worry about developing an efficient algorithm yet
* State a naive algorithm and its runtime
 - then optimize from there
* Don't code yet!

# Step 4 Optimize

Walkthrough your Brute force with

::: columns
:::: column
* Optimize
 - BUD
 - Space/Time
 - Do it yourself
::::
:::: column
* Solve
 - Recursion
 - Solve "incorrectly"
 - Other data structures (i.e., HashTables)
::::
:::

\centering
**Push Yourself**

# Look for BUD

* \underline{\textbf{B}}ottlenecks
* \underline{\textbf{U}}nnecessary work
* \underline{\textbf{D}}uplicated work

# What's the bottleneck?

* Ex: counting the intersection
\begin{center}
\Large
\vspace{-2em}
\[[1, 12, \underline{15}, \underline{19}, 20, \underline{21}]\]
\[[2, \underline{15}, 17, \underline{19}, \underline{21}, 25, 27]\]
\end{center}

* Bottleneck: searching

# What's unnecessary?

* Ex: $a^3+b^3 = c^3 + d^3$ where (1 <= a, b, c, d <= 1000)

```
   n = 1000
   for a from 1 to n
     for b from 1 to n
       for c from 1 to n
         for d from 1 to n
           if a^3 + b^3 == c^3 + d^3
             print a, b, c, d
```

\pause

* Unnecessary: looking for d

# What's unnecessary?

* Ex: $a^3+b^3 = c^3 + d^3$ where (1 <= a, b, c, d <= 1000)

```
   n = 1000
   for a from 1 to n
     for b from 1 to n
       for c from 1 to n
         d = pow(a^3 + b^3 - c^3, 1/3) // will round to int
         if a^3 + b^3 == c^3 + d^3
           print a, b, c, d
```

* Unnecessary: looking for d

# What's duplicated?

* Ex: $a^3+b^3 = c^3 + d^3$ where (1 <= a, b, c, d <= 1000)

```
   n = 1000
   for a from 1 to n
     for b from 1 to n
       for c from 1 to n
         for d from 1 to n
           if a^3 + b^3 == c^3 + d^3
             print a, b, c, d
```

\pause

* Duplicated: c, d pairs

# What's duplicated?

* Ex: $a^3+b^3 = c^3 + d^3$ where (1 <= a, b, c, d <= 1000)

```
   n = 1000
   for a, b from 1, 1 to n, n
     for c, d from 1, 1 to n, n
       if a^3 + b^3 == c^3 + d^3
         print a, b, c, d
```

* Duplicated: c, d pairs

# What's duplicated?

* Ex: $a^3+b^3 = c^3 + d^3$ where (1 <= a, b, c, d <= 1000)

```
   n = 1000
   for c from 1 to n
     for d from 1 to n
       result = c^3 + d^3
       append (c, d) to list at value map[result]
   for a from 1 to n
     for b from 1 to n
       list = map.get(result)
       for each pair in list
         print a, b, pair
```

# What's duplicated?

* Ex: $a^3+b^3 = c^3 + d^3$ where (1 <= a, b, c, d <= 1000)

```
   n = 1000
   for c from 1 to n
     for d from 1 to n
       result = c^3 + d^3
       append (c, d) to list at value map[result]

   for each result, list in map
     for each pair1 in list
       for each pair2 in list
         print pair1, pair2
```

# Space/Time tradeoffs

* Hash tables & other data structures
* Precomputing

# Precomputing

* Find rectangle at origin with biggest sum

* Brute force: compute all rectangles and sums

# Do it yourself

* Find permutations of $s$ within $b$
 - s = abbc
 - b = babcabbacaabcbabcacbb

* Find them!
 - ... now how did you *actually* do it?

# Techniques to Develop Algorithms

::: columns
:::: column
* Optimize
 - BUD
 - Space/Time
 - Do it yourself
::::
:::: column
* Solve
 - Recursion
 - Solve "incorrectly"
 - Other data structures
::::
:::

# Recursion / Base Case & Build

* Subsets of a set
 - {} -> {}
 - {a} -> {}, {a}
 - {a, b} -> {}, {a},. {b}, {a b}
 - {a, b, c} -> ...
* Subsets of ${S_{1}\ldots S_{n-1}} + S_n$ to each

# Solve "incorrectly"

1. Develop **incorrect** solution
2. Identify why **precisely** it's incorrect
3. Repair
4. (& Repeat)

# Other Data Structures

* Giving out phone numbers
 - "I want any available number"
 - "I want **this** number"

* Try: Sorted array? Sorted linked list? Hash table? BST?

# Step 5 Walkthrough

* With optimal solution in hand...
* Walkthrough your approach
* Understand each detail before coding

# Step 6 Implement

Write Beautiful Code

* Be methodical. Don't try to rush.
* Reasonably Bug Free
 - Thorough testing (and careful fixing)
 - Check for error conditions
* Clean coding
 - Use other functions
 - Good use of data structures (define own if useful)
 - Concise and readable
* Refactor

# How to Write Whiteboard Code

::: columns
:::: column
* Write straight
* Top-left corner
* Use arrows if needed

* Error cases / TODOs
* Good variables
* Modularized
::::
:::: column
\includegraphics[width=\textwidth]{images/WhiteBoard/coding.jpg}
::::
:::

\vskip1em
\centering
\large \textbf{Language choice is up to you!}
\vskip1em
\textbf{Practice! Practice! Practice!}

# Step 7 Testing

Test in this order:

1. **Conceptual test:**
  - Walk through you code like you would for a detailed code review.
2. **Unusual** or non-standard code
3. **Hot spots**
  - like arithmetic and null nodes
4. **Small test cases:**
  - It's much faster than a big test case and just as effective
5. **Special cases and edge cases**

* When you find bugs, **fix them carefully!**

#

\vfill
\centering
\Huge Final Thoughts

# After Your Interview

* Follow-up with your recruiter/interviewer
 - No response != rejection
* You have **no idea** how well/poorly you did.
 - Seriously. I know you think you do. But you don't
* Lots of randomness
 - So if you fail, get up and try again.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# References

* The content of this came from Gayle Laakmann McDowell's books "Cracking the Coding Interview"
* And the handout "Cracking the Coding Skills" also by Gayle Laakmann McDowell
* The content of the slides are borrowed from her accompanying slides. I take no credit for this information!

* I suggest that you go out and buy a copy of her book and read it.

# For Next Time

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
