---
author:
- Isaac Griffith
title: Introduction to Program Analysis
institute: |
  CS 4423 and CS 5523

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outline

1. Verification: semantics and properties

2. \color{LightGray} Undecidability

3. Approaches to program verification

4. Outline

# Verification: a first definition

In this course, we consider how to **verify specific properties about program executions**:

* absence of execution errors
  - i.e., crashes due to pointer or arithmetic errors
* preservation of invariants
* termination
* absence of information flows and other security breaches...

# Verification: a first definition

We are not interested in purely syntactic properties

\begin{block}{Verification}
Make sure that $[\![P]\!] \subseteq \mathcal{S}$ where
\begin{itemize}
\item \textbf{the semantics} $[\![P]\!]$ describes the \textbf{set of behaviors} $P$,
\item \textbf{the specification} $\mathcal{S}$ describes the set of acceptable behaviors
\end{itemize}
\end{block}

\textbf{Behaviors} are still an abstract notion at this point

# Semantics and semantic properties

There exists **several forms of semantics** $[\![P]\!]$ that convey:

* reachable states, input/output relations (e.g., described by a function), execution traces of program states (finite, infinite, or both)

We will consider two styles of semantics:

* **compositional style** ("denotational")
  - intuitively, $[\![AB]\!] = \ldots [\![A]\!] \ldots [\![B]\!] \ldots$
* **transitional style** ("operational")
  - intuitively, $[\![AB]\!] = {s_{0} \hookrightarrow s_{1} \hookrightarrow \ldots, \ldots}$
* **A right semantics style facilitates the design of static analysis**

# Semantics and semantic properties

**Specification** (or **semantic properties** of interest):

* sets of executions (that are considered to satisfy a specification)
* property can be expressed by $[\![P]\!] \subseteq \mathcal{S}$
* there exist **several interesting classes of semantic properties**

# Safety

\begin{block}{Intuitive definition: safety}
\textbf{A safety property asserts that some kind of behaviors that are observable in finite time will never occur.}
\end{block}

\footnotesize
**Examples:**

* absence of some class of crashing error
  - e.g., null pointer exception in Java, arithmetic or memory error in C
* preservation of a general invariant
  - e.g., some data structure should never get broken
* assertion on output value
  - e.g., the output value of a function should always lie in a given range

**Proof method: by invariance**

* i.e., a safety property $\mathcal{S}$ holds if and only if there exists a program **invariant** stronger than $\mathcal{S}$

# Liveness

\begin{block}{Intuitive definition: liveness}
\textbf{A liveness property asserts that some kind of behaviors that are only observable in infinite time will never occur.}
\end{block}

**Examples:**

* non-termination
* live lock
* unbounded repetition of a given behavior
  - note termination and live-lock are special cases of this one

**Proof method: with a variance argument**

* e.g., for termination, **ranking functions:**
  - search for a measure that decrease during execution and that cannot decrease forever

# Trace properties

Not all trace properties are safety or liveness. **What about others?**

\begin{block}{Theorem (Alpern and Schneider)}
Given a trace property $\mathcal{T}$ (i.e., a set of finite or infinite program executions), then there exists two trace properties $\mathcal{S}$ and $\mathcal{L}$ such that:

\begin{itemize}
 \item $\mathcal{T} = \mathcal{S} \cap \mathcal{L}$
 \item $\mathcal{S}$ \textbf{is a safety property}
 \item $\mathcal{L}$ \textbf{is a liveness property}
\end{itemize}
\end{block}

# Trace properties

**Application:** the proof of safety property boils down to

1. a proof of safety, by variance
2. a proof of liveness, by invariance

**Example:** total correctness = partial correctness and abscence of crashes + termination

\centering
\Large\color{Roarange} **How to make such proofs automatic?**

# Beyond trace properties: security, dependencies...

Many important semantic properties **cannot be described only by a set of executions.**

For instance,

* **dependence:**
  - $y$ depends on $x$ if and only if running the program with distinct values for $x$ yields distinct observations for $y$
* **absence of information flow** (**security** property):
  - absence of dependences of public outputs on private data

To prove/disprove these properties, one needs to reason simultaneiously on **pairs of traces**

\centering
\Large\color{Roarange} **How to make such proofs automatic?**

# Outline

1. \color{LightGray} Verification: semantics and properties

2. \color{Black} Undecidability

3. \color{LightGray} Approaches to program verification

4. Outline

# The termination problem

\begin{block}{Termination}
\textbf{Program $P$ terminates on input} $X$ if and only if \textbf{any execution of $P$, with input $X$ eventually reaches a final state}
\end{block}

* **Final state:** final point in the program (i.e., not error)
* **We may want to ensure termination:**
  - processing of a task, such as, e.g., printing a document
  - computation of a mathematical function
* **We may want to ensure non-termination:**
  - operating system
  - device drivers

<!-- \begin{block}{The termination problem}
Can we find a program \verb|Pt| that \textbf{takes as argument a program $P$ and data $X$ and that returns} "\verb|true|" \textbf{if $P$ terminates on $X$ and} "\verb|false|" \textbf{otherwise?}
\end{block} -->

# TP is not computable

* **Proof by reductio ad absurdum**, using a diagonal argument
  - We assume **there exists a program** `Pa` **such that**:
    * `Pa` always terminates
    * `Pa`$(P,X) = 1$ **if** $P$ **terminates** on input $X$
    * `Pa`$(P,X) = 0$ **if** $P$ **does not terminate** on input $X$
* We consider the following program
  \footnotesize
  ```c
    void P0( P ) {
      if ( Pa( P, P ) == 1 ) {
        while ( 1 ) {
          // loop forever
        } else {
          return; // do nothing
        }
      }
    }
  ```
  \small
* **What is the return value of** `Pa`$(P0, P0)$?
  - i.e., \color{Roarange} **does P0 terminate on input P0?**

# TP is not computable

* **What is the return value of** `Pa`$(P0,P0)$?
  - We know `Pa` always terminates and returns either 0 or 1 (assumption).
    * if `Pa(P0, P0)` returns 1, then `P0(P0)` **loops forever**, thus `Pa(P0, P0)` should return 0, so we have reached a \color{Roarange} **contradiction** \color{Black}
    * if `Pa(P0, P0)` returns 0, then `P0(P0)` **terminates**, thus `Pa(P0, P0)` should 1, so we have reached a \color{Roarange} **contradiction** \color{Black}

* In both cases, we **reach a contradiction**

* Therefore we conclude \color{Roarange} **no such** `Pa` **exists** \color{Black}

## TP is not decidable

\centering
**There exists no program** `Pt` **that always terminates and always recognizes whether a program** $P$ **terminates on input** $X$

# Verification Problem Undecidability

We assume a **turning complete language** $\mathbb{L}$

There is no computable algorithm **Exact** such that

\begin{center}
For all $P \in \mathbb{L}$, \textbf{Exact($P$)}$= [\![P]\!]$
\end{center}

Otherwise, we could solve the termination problem by using such **Exact**.

\begin{block}{Undecidability of non-trivial semantic properties}
Let $\mathcal{S}$ be a non-trivial semantic property (non-trivial: neither true for all programs nor false for all programs).

\textbf{Then $\mathcal{S}$ is not decidable on $\mathbb{L}$}.
\end{block}

# Verification Problem Undecidability

There is no fully automatic and exact algorithm deciding $\mathcal{S}$.

For instance:

* The halting problem is not decidable
* The absence of runtime errors is not decidable...
* Total correctness is not decidable

# Outline

1. \color{LightGray} Verification: semantics and properties

2. Undecidability

3. \color{Black} Approaches to program verification

4. \color{LightGray} Outline

# Inexact verification: soundness and completeness

As we have seen automatic and exact verification is impossible.

How to retain automation, while still verifying programs?

\begin{block}{}
\textbf{Approximate verification}, reaches for a \textbf{weaker goal} than exact verification
\end{block}

**Two important notations:**

* **Soundness:** analysis($P$) = yes $\Longrightarrow P$ satisfies the specification
  - i.e., rejects any program that violates the specification
* **Completeness:** analysis($P$) = yes $\Longleftarrow P$ satisfies the specification
  - i.e., accepts any program that satisfies the specification

In the following, we consider various verification techniques, that give up partially on either automation, soundness or completeness.

# Testing

\begin{block}{Principle}
\begin{enumerate}
 \item \textbf{Consider finitely many, finite executions}
 \item For each of them, \textbf{check whether it violates the specification}
\end{enumerate}
\end{block}

\footnotesize
* Very natural idea, used on all software projects, at all levels (from unit testing to integration testing)
* Many advanced techniques (e.g., to choose "good" test samples)
* Challenging to apply in presence of non-determinism (reproducibility issue) or for hyperproperties (need to talk about several executions in one)...
* **In general unsound:** when state space is infinite or even finite, but just too big (testing does not scale), soundness cannot be ensured
* **Complete:** when a violation is discovered, a counter-example can be produced

# Machine assisted proving

\begin{block}{Principle}
\begin{enumerate}
 \item Use a \textbf{specific language} to \textbf{formalize verification goals}
 \item \textbf{Manually supply proof arguments}
 \item Let the proofs be \textbf{automatically verified}
\end{enumerate}
\end{block}

\footnotesize
* Example of tools: Coq, Isabelle/HOL, PVS...
* **Applications**: CompCert (certified compiler), SeL4 (secure micro-kernel)...
* **Not automatic**: key proof arguments need to be found by users
* **Proof search algorithms** often reduce the amount of proof arguments that need to be supplied manually
* **Sound**, if the formalization is correct
* **Quasi-complete** (only limited by the expressiveness of the logics)

# Finite state model checking

\begin{block}{Principle}
\begin{enumerate}
 \item Focus on \textbf{finite state models} of programs and systems
 \item Perform \textbf{exhaustive exploration} or some \textbf{optimised form of it}
\end{enumerate}
\end{block}

* Example: Uppaal
* **Automatic**
* **Sound** and **complete \color{Roarange} with respect to the model** \color{Black}
* However, general programs require **approximate models** at this stage, one **loses either soundness or completeness**

# Conservative static analysis

\begin{block}{Principle}
\begin{enumerate}
 \item Perform \textbf{automatic verification, yet which may fail}
 \item Compute a \textbf{conservative approximation of the program semantics}
\end{enumerate}
\end{block}

\scriptsize
**Two kinds of approximations are possible** (with mathematical guarantee):

* **Sound, incomplete:** the most common case
* **Complete, unsound:** rare

**Sound, incomplete** static analysis very widely used:

* Examples: type systems, Astree, Facebook Infer, Sparrow...
* Most compilers use it without users even noticing (type system, analyses for optimization or code generation)
* **Automatic**
* Incompleteness means that **safe programs may be rejected** or that **false alarms** may be raised
* Analysis algorithms **reason over program semantics**

# Bug finding

\begin{block}{Principle}
\textbf{Automatic}, \textbf{unsound} and \textbf{incomplete} algorithms
\end{block}

* Examples: Coverity, CodeSonar...
* **Automatic** and **generally fast**
* **No mathematical guarantee about the results**
  - may reject a correct program, and accept an incorrect one
  - may raise false alarm and fail to report true violations
* Typically used to increase software quality without trying to provide any strong guarantee

# High-level comparison

\footnotesize
+--------------------------------------+-----------+-------+-------------------+
|                                      | automatic | sound | complete          |
+:=====================================+:=========:+:=====:+:=================:+
| testing                              | yes       | no    | yes \vskip.1em    |
+--------------------------------------+-----------+-------+-------------------+
| assisted proving                     | no        | yes   | yes/no \vskip.1em |
+--------------------------------------+-----------+-------+-------------------+
| model checking of finite state model | yes       | yes   | yes \vskip.1em    |
+--------------------------------------+-----------+-------+-------------------+
| model checking, at program level     | yes       | yes   | no \vskip.1em     |
+--------------------------------------+-----------+-------+-------------------+
| conservative static analysis         | yes       | yes   | no \vskip.1em     |
+--------------------------------------+-----------+-------+-------------------+
| bug finding                          | yes       | no    | no                |
+--------------------------------------+-----------+-------+-------------------+

\small
No program level approach can be automatic, sound and complete

# Outline

1. \color{LightGray} Verification: semantics and properties

2. Undecidability

3. Approaches to program verification

4. \color{Black} Outline

# Scope and objectives

\begin{block}{}
We consider \textbf{automatic, conservative static analyses}, that compute \textbf{some abstraction of the semantics of programs}
\end{block}

To achieve a good understanding of this family of works, we need to study:

* **the semantics of programs**
  - indeed, it serves as a basis for the definition of abstractions
* **the notion of conservative approximation** of a semantics
  - i.e., what it means to be conservative, how it can be formalized
* **the computation of conservative approximations**
  - using abstract interpretation techniques, step-by-step abstract execution, and widening

\footnotesize
The lectures focus on foundations (intution and formalization).

\vspace{-.45em}
The book also exposes advanced topics

\vspace{-.45em}
We encourage to look at practical chapters (chapter 6 and 7) in the same time as the corresponding notions are considered in the lectures

# Outline of the next lectures

1. Introduction to static analysis (this course) (chapter 1)
2. A gentle introduction to static analysis by abstract interpretation (chapter 2)
3. Basic notions of semantics (sections 3.1 and 4.1)
4. Semantic abstraction (section 3.2)
5. Static analysis based on a compositional semantics
6. Static analysis based on a transitional semantics (sections 4.2 and 4.3)
7. Specialized static analysis frameworks (chapter 10)

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
