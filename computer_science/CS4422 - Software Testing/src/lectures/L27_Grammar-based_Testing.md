---
author:
- Isaac Griffith
title: Grammar-based Testing
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

* Understand the use of mutation testing in source code
* Understand several of the Java Mutation operators
* Understand mutation coverage criteria for source code

# Inspiration

\vfill
\centering
>"A tester has the heart of a developer...

\vfill
>in a jar on the desk..." -- Anonymous

# Applying Syntax-Based Testing

* Syntax-based criteria **originated** with programs and have been used mostly with programs

* **BNF criteria** are most commonly used to test compilers

* **Mutation testing** criteria are most commonly used for unit testing and integration testing of classes

# Instantiating Grammar-Based Testing

\centering
\includegraphics[width=.80\textwidth]{images/Testing/Mutation/prog_based_inst.eps}

# BNF Testing for Compilers

* Testing **compilers** is very complicated
  - Millions of **correct** programs!
  - Compilers must recognize and reject **incorrect** programs
* **BNF criteria** can be used to generate programs to test all language features that compilers must process
* This is a very **specialized** application and not discussed in detail

# Program-based Grammars

* The original and most widely known application of syntax-based testing is to **modify programs**
* **Operators** modify a **ground string** (program under test) to create **mutant program**
* Mutant programs must compile correctly (**valid strings**)
* Mutants are **not tests**, but used to find tests
* Once mutants are defined, **tests** must be found to cause mutants to fail when executed
* This is called **"Killing Mutants"**

# Killing Mutants

\begin{block}

Given a mutant $m \in M$ for a ground string program $P$ and a test $t$, $t$ is said to \textbf{\underline{kill}} $m$ if and only if the output of $t$ on $P$ is different form the output of $t$ on $m$.

\end{block}

* If mutation operators are designed well, the resulting tests will be very powerful
* Different operators must be defined for programming languages and different goals
* Testers can keep adding tests until all mutants have been killed
  - **Dead mutant**: A test case has killed it
  - **Stillborn mutant**: Syntactically illegal
  - **Trivial mutant**: almost every test can kill it
  - **Equivalent mutant**: No test can kill it (same behavior as original)

# Program-based Grammars

\begin{center}
\includegraphics[width=.85\textwidth]{images/Testing/Mutation/prog_based_grammars.eps}
\end{center}

# Syntax-Based Coverage Criteria

\begin{block}{Mutation Coverage (MC):}
For each $m \in M$, TR contains exactly one requirement, to kill $m$.
\end{block}

* The RIPR model form Chapter 2:
  - **Reachability**: The test causes the **faulty statement** to be reached (in mutation -- the **mutated** statement)
  - **Infection**: The test causes the faulty statement to result in an **incorrect state**
  - **Propagation**: The incorrect state **propagates** to incorrect output
  - **Revealability**: The tester must **observe** part of the incorrect output
* The RIPR model leads to **two variants** of mutation coverage...

# Syntax-Based Coverage Criterai

1. **Strongly Killing Mutants**:
   Given a mutant $m \in M$ for a program $P$ and a test $t$, $t$ is said to **strongly kill** $m$ iff the **output** of $t$ on $P$ is different from the output of $t$ on $m$

2. **Weakly Killing Mutants**:
   Given a mutant $m \in M$ that modifies a location $l$ in a program $P$, and a test $t$, $t$ is said to **weakly kill** $m$ iff the **state** of the execution of $P$ on $t$ is different from the state of the execution of $m$ on $t$ immediately after $l$
     - Weakly killing satisfies **reachability** and **infection**, but not **propagation**

# Weak Mutation

\begin{block}{Weak Mutation Coverage (WMC):}
For each $m \in M$, TR contains exactly one requirement, to weakly kill $m$.
\end{block}

* "Weak mutation" is so named because it is **easier to kill** mutants under this assumption
* Weak mutation also requires **less analysis**
* A few mutants can be killed under weak mutation but not under strong mutation (**no propagation**)
* Studies have found that test sets that weakly kill all mutants also strongly kill most mutants

# Weak Mutation Example

* Mutant 1 in the Min() example is:

\includegraphics[width=.25\textwidth]{images/Testing/Mutation/weak_mutation_ex.eps}

* The complete test specification to kill mutant 1:
  - **Reachability**: `true // Always get to that statement`
  - **Infection**: $A \neq B$
  - **Propagation**: `(B < A) = false // skip the next assignment`
  - **Full Test Specification**: $true \wedge (A \neq B) \wedge ((B < A) = false)$

    $\equiv (A \neq B) \wedge (B \geq A)$

    $\equiv (B > A)$
  - Weakly kill mutant 1, but not strongly?

# Equivalent Mutation Example

* Mutant 3 in the Min() example is equivalent:

\includegraphics[width=.25\textwidth]{images/Testing/Mutation/equiv_mutation_ex.eps}

* The infection condition is "**(B < A) != (B < minVal)**"

* However, the previous statement was "**minVal = A**"
  - Substituting, we get: "**(B < A) != (B < A)**"
  - This is a logical **contradiction**!

* **Thus no input can kill this mutant**

# Strong Versus Weak Mutation

\begin{center}
\includegraphics[width=.80\textwidth]{images/Testing/Mutation/strong_vs_weak_mutation.eps}
\end{center}

# Testing Programs with Mutation

\begin{center}
\includegraphics[width=.75\textwidth]{images/Testing/Mutation/testing_with_mutation.eps}
\end{center}

# Why Mutation Works

\begin{block}{Fundamental Premise of Mutation Testing}
If the software contains a fault, there will usually be a set of mutants that can only be killed by a test case that also detects that fault.
\end{block}

* This is not an absolute!
* The mutants guide the tester to an effective set of tests
* A very challenging problem:
  - Find a **fault** and a set of **mutation-adequate tests** that do **not** find the fault
* Of course, this depends on the mutation operators...

# Designing Mutation Operators

* At the **method level**, mutation operators for different programming languages are similar
* Mutation operators do one of **two things**:
  - Mimic typical programmer **mistakes** (incorrect variable name)
  - Encourage common test **heuristics** (cause expressions to be 0)
* Researchers design lots of operators, then experimentally **select** the most useful

## Effective Mutation Operators

If tests that are created specifically to kill mutants created by a collection of mutation operators $O = {o_1, o_2, \ldots}$ also kill mutants created by all remaining mutation operators with very high probability, then $O$ defines an **effective** set of mutation operators.

# Mutation Operators for Java

1. **ABS** -- Absolute Value Insertion
2. **AOR** -- Arithmetic Operator Replacement
3. **ROR** -- Relational Operator Replacement
4. **COR** -- Conditional Operator Replacement
5. **SOR** -- Shift Operator Replacement
6. **LOR** -- Logical Operator Replacement
7. **ASR** -- Assignment Operator Replacement
8. **UOI** -- Unary Operator Insertion
9. **UOD** -- Unary Operator Deletion
10. **SVR** -- Scalar Variable Replacement
11. **BSR** -- Bomb Statement Replacement

# Mutation Operators for Java

1. ABS -- Absolute Value Insertion:

   Each arithmetic expression (and subexpression) is modified by the functions `abs()`, `negAbs()`, and `failOnZero()`

   \includegraphics[width=.25\textwidth]{images/Testing/Mutation/abs_ex.eps}

2. AOR -- Arthmetic Operator Replacement:

   Each occurrence of one of the arithmetic operators `+`, `-`, `*`, `/`, and `%` is replaced by each of the other operators. In addition, each is replaced by the special mutation operators `leftOp` and `rightOp`

   \includegraphics[width=.25\textwidth]{images/Testing/Mutation/aor_ex.eps}

# Mutation Operators for Java (2)

3. ROR -- Relational Operator Replacement:

   Each occurrence of one of the relation operators ($<$, $\leq$, $>$, $\geq$, $=$, $\neq$) is replaced by each of the other operators and by `falseOp` and `trueOp`

   \includegraphics[width=.25\textwidth]{images/Testing/Mutation/ror_ex.eps}

4. COR -- Conditional Operator Replacement:

   Each occurrence of one of the logical operators (and - `&&`, or - `||`, and with no conditional evaluation - `&`, or with no conditional evaluation - `|`, not equivalent - `^`) is replaced by each of the other operators; in addition, each is replaced by `falseOp`, `trueOp`, `leftOp`, and `rightOp`

   \includegraphics[width=.40\textwidth]{images/Testing/Mutation/cor_ex.eps}

# Mutation Operators for Java (3)

5. SOR -- Shift Operator Replacement:

   Each occurrence of one of the shift operators `<<`, `>>`, and `>>>` is replaced by each of the other operators. In addition, each is replaced by the special mutation operator `leftOp`

   \includegraphics[width=.25\textwidth]{images/Testing/Mutation/sor_ex.eps}

6. LOR -- Logical Operator Replacement:

   Each occurrence of one of the logical operators (bitwise and - `&`, bitwise or - `|`, exclusive or - `^`) is replaced by each of the other operators; in addition, each is replaced by `leftOp` and `rightOp`

   \includegraphics[width=.25\textwidth]{images/Testing/Mutation/lor_ex.eps}

# Mutation Operators for Java (4)

7. ASR -- Assignment Operator Replacement:

   Each occurrence of one of the assignment operators (`=`, `+=`, `-=`, `*=`, `/=`, `%=`, `&=`, `|=`, `^=`, `<<=`, `>>=`, `>>>=`) is replaced by each of the other operators

   \includegraphics[width=.25\textwidth]{images/Testing/Mutation/asr_ex.eps}

8. UOI -- Unary Operator Insertion:

   Each unary operator (arithmetic `+`, arithmetic `-`, conditional `!`, logical `~`) is inserted in front of each expression of the correct type

   \includegraphics[width=.25\textwidth]{images/Testing/Mutation/uoi_ex.eps}

# Mutation Operators for Java (5)

9. UOD -- Unary Operator Deletion:

   Each unary operator (arithmetic `+`, arithmetic `-`, conditional `!`, logical `~`) is deleted.

   \includegraphics[width=.25\textwidth]{images/Testing/Mutation/uod_ex.eps}

10. SVR -- Scalar Variable Replacement:

    Each variable reference is replaced by every other variable of the appropriate type that is declared in the current scope.

    \includegraphics[width=.25\textwidth]{images/Testing/Mutation/svr_ex.eps}

# Mutation Operators for Java (6)

11. BSR -- Bomb Statement Replacement:

    Each statement is replaced by a special Bomb() function

    \includegraphics[width=.25\textwidth]{images/Testing/Mutation/bsr_ex.eps}

# Summary: Subsuming Other Criteria

* Mutation is widely considered the **strongest** test criterion
  - and most **expensive**!
  - By far the most test requirements (each mutant)
  - Usually the most tests
* Mutation **subsumes** other criteria by including specific mutation operators
* Subsumption can only be defined for **weak mutation** - other criteria only impose local requirements
  - Node coverage, Edge coverage, Clause coverage
  - General active clause coverage: **Yes-Requirement on single tests**
  - Correlated active clause coverage: **No-Requirement**

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
