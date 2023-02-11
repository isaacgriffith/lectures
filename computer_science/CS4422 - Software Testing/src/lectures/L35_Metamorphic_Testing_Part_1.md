---
author:
- Isaac Griffith
title: Metamorphic Testing Part 1
institute: |
  CS 4422 and CS 5599

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

# Test Oracle

* A mechanism or procedure against which the computed outputs could be verified

# Example

To find the roots of the following polynomial:

$x^{100} + 3x^{99} - x^{98} + \ldots + 5$

Suppose the solutions for $x$ are: 2.0, 6.5, ...

# Example

* $\sin$ function
  - $\sin(0^{\circ}) = 0$
  - $\sin(30^{\circ}) = 0.5$

* Suppose the program returns:
  - $\sin(29.8^{\circ}) = 0.51234$ incorrect
  - $\sin(29.8^{\circ}) = 0.49876$ correct?

# Example

* Shortest path problem `SP(G, a, b)`
* Suppose the program returns:
  - $|SP(G, a, a)| = 5$  incorrect
  - $|SP(G, a, b)| = 10$ where $a$ and $b$ are neighbors
  - $|SP(G, a, b)| = 1,000,0001$ correct or incorrect?

# Non-Testable Programs

* Absence of test oracle
* Too expensive to apply test oracle

# Intuition of Metamorphic Testing

Though we do not know the correctness of the output of any individual input

We many know the relation between some related inputs and their outputs

# Example

* Suppose $\sin(29.8^{\circ})$ return 0.49876
* $\sin$ function has the following property
  - $\sin(x) = \sin(x + 360)$
* Compute $29.8^{\circ} + 360^{\circ} = 389.8^{\circ}$
* Execute the program with $389.8^{\circ}$ as an input
* Check whether $\sin(29.8^{\circ}) = \sin(389.8^{\circ})$

# Metamorphic Testing (A Simplified Form)

* Define source (initial) test cases using some test case selection strategies
* Identify some properties of the problem (referred to as metamorphic relations)
* Construct follow-up test cases from the source test cases with reference to the identified metamorphic relations
* Verify the metamorphic relations

# Categories of Research in MT

* Applications of MT to specific application domains with oracle problem
* Integration of MT with other software analysis and testing methos
* Theory for MT

#

\vfill
\centering
\Large Applications of MT

# Successful Applications of MT

* Bioinformatics programs
* Embedded systems
* Machine learning software
* Optimization systems
* Compilers
* Simulation systems
* ...

# Interesting Results

Reveal undetected faults

* Siemens suite
  - print_token, schedule, and schedule_2
* Compilers
* Machine learning tool -- Weka
* ....

# Testing Compilers

Using MT, the MR is:

*If programs $P$ and $P'$ are equivalent with respect to input $I$, then their object codes are equivalent with respect to $I$*

[http://blog.regehr.org.archives/1161](http://blog.regehr.org.archives/1161)

#

\vfill
\centering
\Large A New test case selection method!

#

\vfill
\centering
\Large Integration with Other Methods

# Example: Spectrum Based Fault Localization

* A statistical approach to predict how likely a program entity is faulty

* Intuition
  - More likely to be faulty if executed by more failed test cases
  - More likely to be faulty if executed by less passed test cases

# SBFL

* Use a set of test cases with
  - testing results of pass or fail
  - coverage information whether a program entity is executed or not
* Use a formula to predict how likely a program entity is faulty

# Example

\begin{eqnarray*}
 & TS:\left(\begin{array}{cccccc}
t_{1} & t_{2} & t_{3} & t_{4} & t_{5} & t_{6}\end{array}\right)\\
P:\left(\begin{array}{c}
S_{1}\\
S_{2}\\
S_{3}\\
S_{4}\\
S_{5}\\
S_{6}
\end{array}\right) & MS:\left(\begin{array}{cccccc}
1 & 1 & 1 & 1 & 1 & 1\\
1 & 0 & 1 & 1 & 0 & 0\\
0 & 0 & 0 & 1 & 0 & 0\\
0 & 1 & 1 & 1 & 0 & 1\\
1 & 1 & 0 & 1 & 1 & 1\\
1 & 1 & 1 & 1 & 1 & 1
\end{array}\right)\\
 & RE:\left(\begin{array}{cccccc}
p & p & p & p & f & f\end{array}\right)
\end{eqnarray*}

# Example

\begin{eqnarray*}
 & TS:\left(\begin{array}{cccccc}
t_{1} & t_{2} & t_{3} & t_{4} & t_{5} & t_{6}\end{array}\right) & A^{i}:<\begin{array}{cccc}
a_{ef}^{i} & a_{ep}^{i} & a_{nf}^{i} & a_{np}^{i}\end{array}>\\
P:\left(\begin{array}{c}
S_{1}\\
S_{2}\\
S_{3}\\
S_{4}\\
S_{5}\\
S_{6}
\end{array}\right) & MS:\left(\begin{array}{cccccc}
1 & 1 & 1 & 1 & 1 & 1\\
1 & 0 & 1 & 1 & 0 & 0\\
0 & 0 & 0 & 1 & 0 & 0\\
0 & 1 & 1 & 1 & 0 & 1\\
1 & 1 & 0 & 1 & 1 & 1\\
1 & 1 & 1 & 1 & 1 & 1
\end{array}\right) & MA:\left(\begin{array}{cccc}
2 & 4 & 0 & 0\\
0 & 3 & 2 & 1\\
0 & 1 & 2 & 3\\
1 & 3 & 1 & 1\\
2 & 3 & 0 & 1\\
2 & 4 & 0 & 0
\end{array}\right)\\
 & RE:\left(\begin{array}{cccccc}
p & p & p & p & f & f\end{array}\right)
\end{eqnarray*}


#

* Tarantula

\[R_{T}(s_i) = \frac{a^{i}_{ef}}{a^{i}_{ef} + a^{i}_{nf}} / \left(\frac{a^{i}_{ef}}{a^{i}_{ef} + a^{i}_{nf}} + \frac{a^{i}_{ep}}{a^{i}_{ep} + a^{i}_{np}} \right)

* Risk values

\begin{eqnarray*}
 & \left(\begin{array}{cccccc}
s_{1} & s_{2} & s_{3} & s_{4} & s_{5} & s_{6}\end{array}\right)\\
 & \left(\begin{array}{cccccc}
\frac{1}{2} & 0 & 0 & \frac{2}{5} & \frac{4}{7} & \frac{1}{2}\end{array}\right)
\end{eqnarray*}

* Ranking list

\[
<\begin{array}{cccccc}
s_{5} & s_{4} & s_{1} & s_{6} & s_{2} & s_{3}\end{array}>
\]

# SBFL

An Open Problem:

How to apply SBFL on non-testable programs?

# Integration of SBFL with MT

* test case -- metamorphic test group

* pass or failure of a test case -- satisfaction or violation of a metamorphic test group

* coverage by a test case -- coverage by a metamorphic test group

# Integration of SBFL with MT

* Intuition
  - More likely to be faulty if executed by more violated metamorphic test groups
  - More likely to be faulty if executed by less non-violated metamorphic test groups

# Example

slide 27

# Example

slide 28

# Example

slide 29

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
