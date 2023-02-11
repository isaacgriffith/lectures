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

# Introduction

\begin{block}{Test Oracle}
Mechanism to decide whether a test output is correct or not
\end{block}

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt01.eps}

# Introduction

\begin{block}{Oracle Problem}
Sometimes it is not feasible to check the correctness of a test output
\end{block}

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt02.eps}

#

\centering
\vfill
\Huge Let's see some examples

# Examples

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt03.eps}

# Examples

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt04.eps}

# Examples

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt05.eps}

# Examples

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt06.eps}

# Metamorphic Testing Process

1. Identification of metamorphic relations.
2. Generation/Selection of source test cases.
3. Generation of follow-up test cases.
4. Checking of metamorphic relations

#

\centering
\vfill
\Huge Oh, I get it. This is about alleviating the oracle problem. Is that it?
\vfill
\Huge Yes! but MT can also support test data generation!

# Test Data Generation

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt07.eps}

# Test Data Generation

\centering
\includegraphics[width=.5\textwidth]{images/Testing/Metamorphic/mt08.eps}

#

\centering
\vfill
\Huge State of the art

# Domains

From a survey of 84 Case Studies

::: columns
:::: column
* Numerical programs ~5%
* Variability and decision support ~5%
* Compilers ~4%
* Components ~3%
* Autonomous Vehicles ~2%
* Bioinformatics ~8%
::::
:::: column
* Machine Learning ~8%
* Simulation and Modeling ~8%
* Embedded Systems ~8%
* Computer Graphics ~11%
* Web Services/Apps ~14%
* Other (Adobe, NASA, CyberSec) ~24%
::::
:::

# Lessons Learned

\begin{block}{Lesson Learned}
Metamorphic testing requires good knowledge of the problem domain
\end{block}

# Lessons Learned

\begin{block}{Lesson Learned}
Different metamorphic relations can have different fault-detection capability
\end{block}

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt09.eps}

# Lessons Learned

\begin{block}{Lesson Learned}
Metamorphic relations should be diverse so they exercise different parts of the program.
\end{block}

\centering
\includegraphics[width=.4\textwidth]{images/Testing/Metamorphic/mt10.eps}

# Lessons Learned

\begin{block}{Lesson Learned}
Two common approaches for the construction of metamorphic relations: \textbf{\underline{input-driven}} vs. output-driven
\end{block}

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt11.eps}

# Lessons Learned

\begin{block}{Lesson Learned}
Two common approaches for the construction of metamorphic relations: input-driven vs. \textbf{\underline{output-driven}}
\end{block}

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt12.eps}

# Lessons Learned

\begin{block}{Lesson Learned}
Metamorphic relations can be combined
\end{block}

\centering
\includegraphics[width=.75\textwidth]{images/Testing/Metamorphic/mt13.eps}

# Lessons Learned

\begin{block}{Lesson Learned}
Metamorphic relations can be combined
\end{block}

\centering
\includegraphics[width=.65\textwidth]{images/Testing/Metamorphic/mt14.eps}

# Lessons Learned

\begin{block}{Lesson Learned}
The automated discovery of metamorphic relations seems feasible in certain domains
\end{block}

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt15.eps}

# Challenges

* Systematic guidelines for the construction of good metamorphic relations
* Generation of likely metamorphic relations
* Non-functional metamorphic testing
* Provide tools to foster the use of the technique

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

#

Lecture borrowed from Segura and Zhou's presentation on "Metamorphic Testing 20 Years Later: A Hands-on Introduction" as presented at the 40th International Conference on Software Engineering.
