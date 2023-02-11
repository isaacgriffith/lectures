---
author:
- Isaac Griffith
title: Putting Testing First
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

* Understand the basic concepts of TDD
* Understand the basic concepts of CI
* Understand how to marry TDD and CI

# Inspiration

\vfill
> "If you don’t like unit testing your product, most likely your customers won’t like to test it either." –  Anonymous

#

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Testing/TDD/whatis.png}
\end{center}

# The Increased Emphasis on Testing

* Philosophy of **traditional** software development methods
  - **Upfront** analysis
  - Extensive **modeling**
  - Reveal **problems** as early as possible

\begin{center}
\includegraphics[width=.5\textwidth]{images/Testing/TDD/curve.eps}
\end{center}

# Traditional Assumptions

1. Modeling and analysis can identify potential problems early in development
2. Savings implied by the cost-of-change curve justify the cost of modeling and analysis over the life of the project

* These are true if requirements are always complete and current
* But customers always change their minds!
  - Humans are naturally good at approximating
  - But pretty bad at perfecting
* These two assumptions have made software engineering frustrating and difficult for decades

\centering
**Thus, Agile Methods...**

# Why Be Agile?

* Agile methods start by recognizing that **neither assumption** is valid for many current software projects
  - Software engineers are **not good at developing requirements**
  - We do not anticipate many **changes**
  - Many of the changes we do anticipate are **not needed**
* Requirements (and other "non-executable artifacts") tend to go **out of date** very quickly
  - We seldom take time to **update** them
  - Many current software projects **change continuously**
* Agile methods expect software to **start small and evolve** over time
  - Embraces **software evolution** instead of fighting it.

# Supporting Evolutionary Design

* Traditional design advice says to anticipate changes
* Designers often anticipate changes that don't happen

\begin{center}
\includegraphics[width=.85\textwidth]{images/Testing/TDD/evodesign.eps}
\end{center}

##

\centering
**Both anticipated and unanticipated changes affect design**

# The Test Harness as Guardian

\begin{center}
\large\textbf{What is Correctness?}
\end{center}

::: columns
:::: column

\begin{center}
Traditional Correctness\\
(Universal)\\
$\forall_{x, y}, x \geq y$

\includegraphics[width=.65\textwidth]{images/Testing/TDD/totalcorrect.eps}
\end{center}
::::
:::: column
\begin{center}
Agile Correctness\\
(Existential)
\end{center}

```
{ (1, 1) -> T
  (1, 0) -> T
  (0, 1) -> F
  (10, 5) -> T
  (10, 12) -> F }
```
::::
:::

# A Limited View of Correctness

* In **traditional** methods, we try to define **all correct behavior** completely, at the beginning
  - What is **correctness**?
  - Does "correctness" **mean anything** in large engineering products?
  - People are **VERY BAD** at completely defining correctness
* In **agile** methods, we redefine correctness to be **relative** to a specific set of tests
  - If the software behaves correctly **on the tests**, it is "correct"
  - Instead of **defining all** behaviors, we **demonstrate some** behaviors
  - **Mathematicians** may be disappointed at the lack of completeness

##

\centering
**But software engineers ain't mathematicians!**

# In-Class Exercise

## Group Discussion: **Limited Correctness**

* Do you understand the distinction?

* How does limited correctness relate to evolutionary design?

\centering\color{Roarange}You have ten minutes

# Test Harnesses Verify Correctness

\begin{center}
A \textbf{test harness} runs all automated tests and reports results to the developers
\end{center}

* Tests must be **automated**
  - Test automation is a **prerequisite** to test driven development
* Every test must include a **test oracle** that can evaluate whether that test executed correctly
* The tests replace the **requirements**
* Tests must be **high quality** and must **run quickly**
* We run tests **every time** we make a change to the software

#

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/Testing/TDD/cicd.eps}
\end{center}

# Continuous Integration

* Agile methods work best when the current version of the software can be run against all tests at any time

```{=latex}
\begin{block}
```
A **continuous integration server** rebuilds the system, returns, and re-verifies tests whenever any update is checked into the repository
```{=latex}
\end{block}
```

* Mistakes are caught earlier
* Other developers are aware of changes early
* The rebuild and re-verify must happen as soon as possible
  - Thus, tests need to execute quickly

##

\centering
A **continuous integration server** doesn't just run tests, it decides if a modified system is **still correct**

# CI Reduces Risk

\begin{center}
{\large TDD encourages incremental integration of functionality}
\end{center}

##

\centering
**Non-integrated functionality is dangerous**

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
