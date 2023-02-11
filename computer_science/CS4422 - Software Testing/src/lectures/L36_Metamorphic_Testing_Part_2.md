---
author:
- Isaac Griffith
title: Metamorphic Testing Part 2
institute: |
  CS 4422 and CS 5599

  Spring 2020

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

At the end of Today's Lecture you will be able to:

*

# Inspiration

#

\vfill
\centering
\Large Theory for Metamorphic Testing

# Metamorphic Testing

* Some reminders
  - MRs not restricted to identify relations and numeric relations
  - Multiple executions
  - Follow-up test cases may depend on the outputs of the source test cases
  - MT is applicable event if test oracle exists

#

\vfill
\centering
\Large Metamorphic Relations

# Metamorphic Relations

* Identification of MRs
* Prioritization of MRs
* Fault Detection Effectiveness of MRs

# Identification of MRs

* MT can be automted except the identification of MRs

* Is it feasible to identify or generate MRs?

# A simple and Intuitive Approach

* Select an input

* Modify it, hopefully that the relevant change of output will be somehow predictable.

* If yes, any generalization?
  - If yes, then identify an MR

# Identification of MRs

Various Approaches

* Machine Learning (Columbia; Colorado State)
* Data mutation (Oxford Brookes)
* Coding (Peking)
* Composition (Swinburne)
* Category-choice framework (HK Poly; Wuhan)
* ....
* ....

# Generation by Composition

* Generation of new MRs from existing MRs by composition

# Example

* Shortest path problem: `SP(G, a, b)`

* Suppose we have the following MRs
  - $MR_A: |SP(G, a, b)| = |SP(G, b, a)|$
  - $MR_B: |SP(G, a, b)| = |SP(G', a', b')$

* By composition, a new MR is defined as
  - $MR_{AB}: |SP(G, a, b)| = |SP(G', a', b')|$

# Prioritization of MRs

Consider $\sin(x)$

  $MR1: \sin(x) = \sin(x + 2\pi)$

  $MR2: \sin(x) = -\sin(x + \pi)$

  $MR3: \sin(-x) = -\sin(x)$

  $MR4: \sin(x) = \sin(\pi - x)$

  $MR5: \sin(x) = -\sin(2\pi - x)$

  ...

# Prioritization Approaches

* Usage Profile

* Algorithm

# Usage Profile

* *Restricted* use of programs -- interested in a subset of properties

* $\sin(x)$
  - Electrical Engineers
    * $\sin(x) = \sin(x + 2\pi)$
  - Land Surveyors
    * $\sin(-x) = -\sin(x)$
    * $\sin(x) = \sin(\pi - x)

# Algorithm

* A problem may be solved by more than one algorithm -- sorting, adaptive random testing

* An algorithm may be implemented in different ways

# Example

* Shortest Path problem:
  `SP(G, a, b)` using forward expansion

Slide 47

# Example

* $|SP(G, a, b)| = |SP(G', a', b')|$
* $|SP(G, a, b)| = |SP(G, a, c)| + |SP(G, c, b)|$
* $|SP(G, a, b)| = |SP(G, b, a)|

# Fault Detection Effectiveness

\vfill
\centering
\large How many MRs are required?

#

\vfill
\centering
\large Empirical Observation: a few diverse MRs

#

Slide 51

#

Slide 52

#

\vfill
\centering
\large Is MT a Black-Box Method?

# Example

\Large
\[\sin(x) = x -0 \frac{x^3}{3!} + \frac{x^5}{5!} -\]

# Example

* MR1: $\sin(-x) = -\sin(x)$

* MR2: $\sin(x) = \sin(x + 2\pi)$

# End-User Software Engineering

* Limited knowledge of teting
* Unaccessibliity to testing tools
* Need a testing method
  - Easy to learn
  - Easy to use
  - Easy to automate

# End-User Software Engineering

* Source test case selection strategy -- any available technique or test suite; otherwise special values, random or ad hoc selection

* Selection of MRs --
  - usage profile
  - end-user's domain knowledge
  - end-user's code knowledge

# Diversity

\vfill
\centering
\large The key underlying concept in test case selection strategies

# Diversity

* Success of MT in revealing faults undetected by other conventional testing methods

* Diverse MRs in MT

# Diversity

\vfill
\centering
\large underlying concept in software testing

# Conclusion

\vfill
\centering
\Huge Simplicity

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
