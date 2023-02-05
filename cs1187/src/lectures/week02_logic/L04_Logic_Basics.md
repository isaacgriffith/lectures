---
author:
- Dr. Isaac Griffith
title: Basics of Propositional Logic
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Inspiration

> "Language is remarkable, except under the extreme constraints of mathematics and logic, it never can talk only about what it's supposed to talk about but is always spreading around." -- Howard Nemerov

# Propositional Logic

* Logic is used extensively through CS

\vskip.25em

* It provides an extremely powerful tool for reasoning

\vskip.25em

* Examples of Use:
  * SE: Software Specification
  * Program Correctness
  * IR: Web Search
  * AI: Simulated Intelligent Thought
  * ECE: Digital Circuit Design
  * CS: Typechecking in Compilers
  * PL: Lambda Calculus
  * Theory: Abstract Machine Models

# Logic Forms

* **Propositional Logic:** The simplest form of logic, for which we will consider the following forms of reasoning
  * **Truth Tables:** Define the meanings of logical operators, to calculate the values of expressions, and to prove two propositions are equal
  * **Natural Deduction:** formalization of the basic principles of reasoning based on a set of *inference rules* and uses a syntactic approach
  * **Boolean Algebra:** another form of syntactic formalism, using a set of equations to specify that certain propositions are equal

\vskip.5em

* **Predicate Logic**

\vskip.5em

* **Advanced Logics**

# Lecture Outline

Today's lecture will cover:

::: columns
:::: {.column width=.7}
* Propositional Logic
* Logical Operators
* Language of Logic
* Sematic Reasoning using Truth Tables
* Inference Reasoning using Natural Deduction
::::
:::: {.column width=.25}
\vfill
\vspace{5.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\centering
\vfill
\begin{minipage}{.525\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Propositional Logic
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# The Need for Formalism

* Natural languages, by their very nature are rich, expressive, and unfortunately ambiguous
* This presents significant difficulty in attempting to reason in natural language directly
* Instead, we separate the logical structure of an argument from the English connotations

\vskip1em

* **Propositions** -- symbolic variables whose vale must be either `True` or `False` and which stand for some english statement.
* These *propositional variables** are used instead of the natural language statements

# Propositions and Variables

\small The process of reasoning using logic:

1. We identify the propositions from text:

   \footnotesize
   \begin{eqnarray*}
   A & = & \textrm{The sun is shining}\\
   B & = & \textrm{I feel happy.}\\
   C & = & \textrm{Cats are furry.}\\
   D & = & \textrm{Elephants are heavy.}
   \end{eqnarray*}

2. We translate complete English sentences into mathematical statements composed of only Propositional variables and logical operators:

   \footnotesize
   \begin{eqnarray*}
   \textrm{The sun is shining and I feel happy.} & \longrightarrow & A \textrm{ and } B \\
   \textrm{Cats are furry and elephants are heavy.} & \longrightarrow & C \textrm{ and } D
   \end{eqnarray*}

* Unfortunately, not all statements can be expressed using Propositional logic

#

\centering
\vfill
\begin{minipage}{.475\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Logical Operators
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Logical And ($\land$)

::: columns
:::: column

* Corresponds to *'and'* in English
* Claims that two statements are both **true**
* **Symbols:** $\land$, $\cdot$, `&&`, `AND`

\vskip.25em

* $A \land B$ as a proposition means:
  * $A$ is True
  * $B$ is True
  * No connection between $A$ and $B$

\vskip.25em

* We can build large propositions by simply adding them together
  * $A \land B$
  * $\left(A \land B\right) \land C$

::::
:::: column

\centering
\footnotesize
**Truth Tables**

+---+---+--------------+
| A | B | A $\land$ B |
+:=:+:=:+:============:+
| F | F | F            |
+---+---+--------------+
| F | T | F            |
+---+---+--------------+
| T | F | F            |
+---+---+--------------+
| T | T | T            |
+---+---+--------------+

+---+---+--------------+
| A | B | A $\land$ B |
+:=:+:=:+:============:+
| 0 | 0 | 0            |
+---+---+--------------+
| 0 | 1 | 0            |
+---+---+--------------+
| 1 | 0 | 0            |
+---+---+--------------+
| 1 | 1 | 1            |
+---+---+--------------+

::::
:::

# Inclusive Logical Or ($\lor$)

::: columns
:::: column

* Corresponds to English word *'or'*
* Returns true if either argument (or both) are true, false otherwise
* **Symbols:** $\lor$, $+$, `OR`, `||`

\vskip.5em

* $A \lor B$ as a proposition means;
  * Perhaps $A$ is true
  * Perhaps $B$ is true
  * No connection between $A$ or $B$

::::
:::: column

\centering
\footnotesize
**Truth Tables**

+---+---+------------+
| A | B | A $\lor$ B |
+:=:+:=:+:==========:+
| F | F | F          |
+---+---+------------+
| F | T | T          |
+---+---+------------+
| T | F | T          |
+---+---+------------+
| T | T | T          |
+---+---+------------+

+---+---+------------+
| A | B | A $\lor$ B |
+:=:+:=:+:==========:+
| 0 | 0 | 0          |
+---+---+------------+
| 0 | 1 | 1          |
+---+---+------------+
| 1 | 0 | 1          |
+---+---+------------+
| 1 | 1 | 1          |
+---+---+------------+

::::
:::

# Exclusive Logical Or ($\bigoplus$)

::: columns
:::: column

* Corresponds to the English use of the word 'or': *one or the other but not both*
  * Thus, we must be careful when translating sentences using "or"
* **Symbols:** $\oplus$, `XOR`

::::
:::: column

\centering
\footnotesize
**Truth Tables**

+---+---+--------------+
| A | B | A $\oplus$ B |
+:=:+:=:+:============:+
| F | F | F            |
+---+---+--------------+
| F | T | T            |
+---+---+--------------+
| T | F | T            |
+---+---+--------------+
| T | T | F            |
+---+---+--------------+

+---+---+--------------+
| A | B | A $\oplus$ B |
+:=:+:=:+:============:+
| 0 | 0 | 0            |
+---+---+--------------+
| 0 | 1 | 1            |
+---+---+--------------+
| 1 | 0 | 1            |
+---+---+--------------+
| 1 | 1 | 0            |
+---+---+--------------+

::::
:::

# Logical Not ($\lnot$)

::: columns
:::: column

* Corresponds to english word *'not'*
* Negates a given proposition
* **Symbols:** $\lnot$, $\overline{X}$, `!`, `NOT`

::::
:::: column

\centering
\footnotesize
**Truth Tables**

+---+----------+
| A | $\lnot$A |
+:=:+:========:+
| F | T        |
+---+----------+
| T | F        |
+---+----------+

+---+----------+
| A | $\lnot$A |
+:=:+:========:+
| 0 | 1        |
+---+----------+
| 1 | 0        |
+---+----------+

::::
:::

# Logical Implication ($\to$)

::: columns
:::: column

* Corresponds to conditional statements in English
  * i.e., The proposition $A \to B$ corresponds to "If $A$ is true, then $B$ is true"
* Also closely related to the **if ... then ...** construct in programming
* **Symbols:** $\to$, $\Rightarrow$, $\supset$

::::
:::: column

\centering
\footnotesize
**Truth Tables**

+---+---+-----------+
| A | B | A $\to$ B |
+:=:+:=:+:=========:+
| F | F | T         |
+---+---+-----------+
| F | T | T         |
+---+---+-----------+
| T | F | F         |
+---+---+-----------+
| T | T | T         |
+---+---+-----------+

+---+---+-----------+
| A | B | A $\to$ B |
+:=:+:=:+:=========:+
| 0 | 0 | 1         |
+---+---+-----------+
| 0 | 1 | 1         |
+---+---+-----------+
| 1 | 0 | 0         |
+---+---+-----------+
| 1 | 1 | 1         |
+---+---+-----------+

::::
:::

# Logical Implication ($\to$)

* Does not actually imply a *cause-and-effect* relationship.
* It merely states that *if $A$ is true, then $B$ is true* **NOT** *because $A$ is true, $B$ is true*

**Examples**

\footnotesize

\centering

$\begin{array}{ll}
  A & \textrm{It is sunny today.} \\
  B & \textrm{There will be a picnic.} \\
  A \to B & \textrm{If it is sunny today, then there will be a picnic.}
\end{array}$

$\begin{array}{ll}
  A & \textrm{The moon orbits the earth.} \\
  B & \textrm{The sun is hot.} \\
  A \to B & \textrm{If the moon orbits the earth, then the sun is hot.}
\end{array}$

# Logical Equivalence ($\leftrightarrow$)

::: columns
:::: column

* Claims that two propositions have the same value
* May be translated to English as:

  \vskip.25em

  \footnotesize "Saying A is just the same as saying B"

  \vskip.25em

* $A \leftrightarrow B$ can also be expressed as $\left(A \to B\right) \land (B \to A)$

\vskip.5em

* **Note:** Logical equivalence is similar to *but not the same* as ordinary equality

::::
:::: column

\centering
\footnotesize
**Truth Tables**

+---+---+-----------------------+
| A | B | A $\leftrightarrow$ B |
+:=:+:=:+:=====================:+
| F | F | T                     |
+---+---+-----------------------+
| F | T | F                     |
+---+---+-----------------------+
| T | F | F                     |
+---+---+-----------------------+
| T | T | T                     |
+---+---+-----------------------+

+---+---+-----------------------+
| A | B | A $\leftrightarrow$ B |
+:=:+:=:+:=====================:+
| 0 | 0 | 1                     |
+---+---+-----------------------+
| 0 | 1 | 0                     |
+---+---+-----------------------+
| 1 | 0 | 0                     |
+---+---+-----------------------+
| 1 | 1 | 1                     |
+---+---+-----------------------+

::::
:::

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Language of Logic
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Language of Logic

* Logic has the following advantages of English
  * Formal
  * Precise
  * Unambiguous

\vskip.5em

* Furthermore Logic has a formal grammar
* **Well-Formed Formula (WFF):** a proposition which "makes sense"
  * Has a well-defined meaning
  * its truth value can be discerned

\vskip.5em

* Saying a formula is WFF is like saying a Boolean expression in a programming language is syntactically valid

# WFF Syntax

* **Formula** -- a term in propositional logic
* **Well-Formed Formula** -- a term that is correctly constructed, following all syntax rules

\vskip.5em

* **WFF Examples:**
  * $\left(P \land (\lnot P)\right)$
  * $\left(A \to (B \land (\lnot A))\right)$

\vskip.5em

* **Non-WFF Examples:**
  * $\lor AB \lnot C$
  * $P \lor \to Q$

# WFF Syntax Rules

\small The rules for constructing WFFs are as follows:

\vskip.5em

* The constants `False` and `True` are WFFs
* Any propositional variable is a WFF
* If $a$ and $b$ are WFFs, then so is
  * $\left(\lnot a\right)$
  * $\left(a \land b\right)$
  * $\left(a \lor b\right)$
  * $\left(a \to b\right)$
  * $\left(a \leftrightarrow b\right)$

# WFF Syntax Rules

* These rules can be applied *recursively* to build nested formulas, or to verify a formula is a WFF
  * $\left(P \to (Q \land R)\right)$

    \vskip.5em

    1. $P$, $Q$, and $R$ are propositional variables, so they are all WFFs
    2. Since, $Q$ and $R$ are WFFs, so is $\left(Q \land R\right)$
    3. Since, $P$ and $\left(Q \land R\right)$ are WFFs, so is $\left(P \to (Q \land R)\right)$

\vskip.5em

* **Exercise:** Use this reasoning to determine whether or not the following are WFFs:
  * $\left(P \lor \land Q\right)$ \only<2>{ $\longrightarrow$ **Not a WFF**}
  * $P \to \lnot$ \only<2>{ $\longrightarrow$ **Not a WFF**}
  * $\left(P \land Q\right) \lor \lnot(A \land \lnot B)$ \only<2>{ $\longrightarrow$ **A WFF**}

# Logical Operator Precedence

\small WFFs are fully parenthesized, so there is no ambiguity in interpretation. However, for the sake of readability parentheses are often omitted.

\vskip.5em

* Thus, we have the following order of precedence for operators. The lower the number, the more closely the operator binds with its arguments. Which means that it is evaluated before those below it.

1. $\lnot$
2. $\land$
3. $\lor$
4. $\rightarrow$
5. $\leftrightarrow$

# Meta-Logic

* Propositional logic provides an adequate language for WFFs
  * We call this the **object language**, and WFFs are the **objects**

\vskip.5em

* However, to reason *about* WFFs we need a different and richer language
  * We call this the **meta-language** as it allows us to talk *about* propositions
  * We add three additional operators: $\vdash$, $\vDash$, and $=$ as part of our meta-logic

# Logic and Bit Operation

::: columns
:::: column

* **Bit** - (binary digit) is a symbol with two possible values: 0 (zero) and 1 (one)
  * $1 \leftrightarrow True$
  * $0 \leftrightarrow False$

\pause

* **Boolean variable** - a variable whose value can be either true or false
  * can be represented by a bit

\pause

* **Bit Operations**
  * $AND \leftrightarrow \land$
  * $OR \leftrightarrow \lor$
  * $XOR \leftrightarrow \oplus$

\pause

* **Bit String** - a sequence of zero or more bits
  - **length** of this string is the number of bits in the string

::::
:::: column

\pause

* **Example**

```
        1 0 1 1 0 1 1 0
        0 0 0 1 1 1 0 1
        ---------------
    OR  1 0 1 1 1 1 1 1
    AND 0 0 0 1 0 1 0 0
    XOR 1 0 1 0 1 0 1 1
```

::::
:::

# Bit Operator Truth Table

\centering
\vfill

\footnotesize

+-----+-----+-------------+------------+-------------+
| $p$ | $q$ | $p$ AND $q$ | $p$ OR $q$ | $p$ XOR $q$ |
+:===:+:===:+:===========:+:==========:+:===========:+
| 1   | 1   | 1           | 1          | 0           |
+-----+-----+-------------+------------+-------------+
| 1   | 0   | 0           | 1          | 1           |
+-----+-----+-------------+------------+-------------+
| 0   | 1   | 0           | 1          | 1           |
+-----+-----+-------------+------------+-------------+
| 0   | 0   | 0           | 0          | 0           |
+-----+-----+-------------+------------+-------------+

# Computing w/ Boolean Expressions

* Using the provided software, we can write logic statements in Haskell:
  * $\lnot x$ is written as: `not x`
  * $a \land b$ is written as either: `a && b` or as `a /\ b`
  * $a \lor b$ is written as either: `a || b` or as `a \/ b`
  * $a \to b$ is written as: `a ==> b`
  * $a \leftrightarrow b$ is written as: `a <=> b`

# Exercises

* Check your understanding of logic by evaluating the following statements, first in you own head, and then using the `Stdm` module and Haskell:
  * `False /\ True`  \only<2>{ $\longrightarrow$ **False**}
  * `True \/ (not True)` \only<2>{ $\longrightarrow$ **True**}
  * `True <=> (False ==> False)` \only<2>{ $\longrightarrow$ **True**}
  * `False ==> False` \only<2>{ $\longrightarrow$ **True**}
  * `False <=> (True /\ (False ==> True))` \only<2>{ $\longrightarrow$ **False**}

#

\centering
\vfill
\begin{minipage}{.55\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Semantic Reasoning
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Truth Tables

* Truth tables make for an easy method to reason about propositions
* Each proposition is treated as an expression to be evaluated
* It can be quite tedious to write out `True`, and `False` for each value
  * Can be shortened to `T` and `F` or `1` and `O`

# Calculating Truth Tables

* **Tautology:** a proposition that is always `True`, regardless of the values of its variables
* **Contradiction:** a proposition that is always `False`, regardless of the values of its variables
* **Contingency:** a proposition whose truth value is dependent upon the truth values of its variables
* **Satisfiable:** a proposition wherein at least one combination of values for its variables leads to a `True` value for the entire proposition.

\vskip.5em

* You can use a truth table to determine if formula is a *tautology* or *contradiction*, by looking at the column of the formula
  * If the column contains only `True` values, then it is a *tautology*
  * If the column contains only `False` values, then it is a *contradiction*

* $P_1,P_2,\ldots,P_n \models Q$ means that if all the propositions $P_1,P_2,\ldots,P_n$ are true then, the proposition $Q$ is also true.
  * $\models$ is a meta-logic operator (double-turnstile) concerning the *semantics*, or meaning, of the proposition(s).

# Examples

\footnotesize

+-----+-----+-----------+-----------+---------------------------------------+-----------+-----------------------------------------------------+
| $A$ | $B$ | $A \to B$ | $\lnot B$ | $\left(A \to B\right) \land \lnot B$  | $\lnot A$ | $\left((A \to B) \land \lnot B\right) \to \lnot A$  |
+:===:+:===:+:=========:+:=========:+:=====================================:+:=========:+:===================================================:+
| F   | F   | T         | T         | T                                     | T         | T                                                   |
+-----+-----+-----------+-----------+---------------------------------------+-----------+-----------------------------------------------------+
| F   | T   | T         | F         | F                                     | T         | T                                                   |
+-----+-----+-----------+-----------+---------------------------------------+-----------+-----------------------------------------------------+
| T   | F   | F         | T         | F                                     | F         | T                                                   |
+-----+-----+-----------+-----------+---------------------------------------+-----------+-----------------------------------------------------+
| T   | T   | T         | F         | F                                     | F         | T                                                   |
+-----+-----+-----------+-----------+---------------------------------------+-----------+-----------------------------------------------------+

+-----+-----------+------------------+--------------------+
| $P$ | $\lnot P$ | $P \lor \lnot P$ | $P \land \lnot P$ |
+:===:+:=========:+:================:+:==================:+
| F   | T         | T                | F                  |
+-----+-----------+------------------+--------------------+
| T   | F         | T                | F                  |
+-----+-----------+------------------+--------------------+

# Limitations of Truth Tables

* Although simple to use, truth tables have some limitations
  * Provides no insight into *why* a proposition is True or False
  * The Table requires $2^k$ lines, where $k$ is the number of propositional variables
  * Tables for a large number of variables are unwieldy

# Exercises

* Use truth tables to determine which of the following are tautologies:

\centering

\footnotesize

::: columns
:::: column

\centering

$\left(\textsf{True} \land P\right) \lor Q$

::::
:::: column

\centering

$\left(P \lor Q\right) \to (Q \lor P)$

::::
:::

\pause

\scriptsize

::: columns
:::: column

+-----+-----+-------------------------+----------------------------------------------+
| $P$ | $Q$ | $\textsf{True} \land P$ | $\left(\textsf{True} \land P \right) \lor Q$ |
+:===:+:===:+:=======================:+:============================================:+
| F   | F   | F                       | F                                            |
+-----+-----+-------------------------+----------------------------------------------+
| F   | T   | F                       | T                                            |
+-----+-----+-------------------------+----------------------------------------------+
| T   | F   | T                       | T                                            |
+-----+-----+-------------------------+----------------------------------------------+
| T   | T   | T                       | T                                            |
+-----+-----+-------------------------+----------------------------------------------+

**Not a Tautology**

::::
:::: column

+-----+-----+------------+------------+----------------------------------------+
| $P$ | $Q$ | $P \lor Q$ | $Q \lor P$ | $\left(P \lor Q\right) \to (Q \lor P)$ |
+:===:+:===:+:==========:+:==========:+:======================================:+
| F   | F   | F          | F          | T                                      |
+-----+-----+------------+------------+----------------------------------------+
| F   | T   | T          | T          | T                                      |
+-----+-----+------------+------------+----------------------------------------+
| T   | F   | T          | T          | T                                      |
+-----+-----+------------+------------+----------------------------------------+
| T   | T   | T          | T          | T                                      |
+-----+-----+------------+------------+----------------------------------------+

**Tautology**

::::
:::

# Exercises

* Verify each of the following is a WFF, then build a truth table for the formula, finally, determine if the formula is either a *tautology*, a *contradiction*, or not a tautology but *satisfiable*

::: columns
:::: column

\centering
\footnotesize $\left(P \to Q\right) \land (P \to \lnot Q)$

::::
:::: column

\centering
\footnotesize $\left(P \to Q\right) \leftrightarrow (\lnot Q \to \lnot P)$

::::
:::

\pause

\scriptsize

::: columns
:::: column

+-----+-----+-----------+-----------------+----------------------------------------------+
| $P$ | $Q$ | $P \to Q$ | $P \to \lnot Q$ | $\left(P \to Q\right) \land (P \to \lnot Q)$ |
+:===:+:===:+:=========:+:===============:+:============================================:+
| F   | F   | T         | T               | T                                            |
+-----+-----+-----------+-----------------+----------------------------------------------+
| F   | T   | T         | T               | T                                            |
+-----+-----+-----------+-----------------+----------------------------------------------+
| T   | F   | F         | T               | F                                            |
+-----+-----+-----------+-----------------+----------------------------------------------+
| T   | T   | T         | F               | F                                            |
+-----+-----+-----------+-----------------+----------------------------------------------+

**Satisfiable**

::::
:::: column

+-----+-----+-----------+-----------------------+--------------------------------------------------------------+
| $P$ | $Q$ | $P \to Q$ | $\lnot Q \to \lnot P$ | $\left(P \to Q\right) \leftrightarrow (\lnot Q \to \lnot P)$ |
+:===:+:===:+:=========:+:=====================:+:============================================================:+
| F   | F   | T         | T                     | T                                                            |
+-----+-----+-----------+-----------------------+--------------------------------------------------------------+
| F   | T   | T         | T                     | T                                                            |
+-----+-----+-----------+-----------------------+--------------------------------------------------------------+
| T   | F   | F         | F                     | T                                                            |
+-----+-----+-----------+-----------------------+--------------------------------------------------------------+
| T   | T   | T         | T                     | T                                                            |
+-----+-----+-----------+-----------------------+--------------------------------------------------------------+

**Tautology**

::::
:::

#

\centering
\vfill
\begin{minipage}{.55\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Inference Reasoning
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Natural Deduction

* **Natural Deduction** -- A formal logic system that allows for reasoning directly with propositions using *inference*
  * Does not require substituting truth values for variables or evaluation of expressions
  * Provides a solid foundation for formal logic
  * Focuses on *why* propositions are `True` or `False`

\vskip.5em

* **Infer** -- to reason about statements in order to reach a conclusion

\vskip.5em

* **Logical Inference** -- reasoning *formally* about a set of statements in order to decide what is true. This requires:
  * The set of statements to reason about $\to$ *The Object Language*
  * Methods for inferring facts from given information $\to$ *Rules of Inference*
  * A precise argument form from which we can determine argument validity $\to$ *The Meta-Language*

# Natural Deduction

* **Sequent** -- The notation $P_1,P_2,\ldots,P_n \vdash Q$
  * **Meaning:** if all propositions $P_1,P_2,\ldots,P_n$ are known, then the proposition $Q$ can be inferred using the rules of inference
  * The notation $P \vdash Q \to P$ means *there is a proof* of $Q \to P$ which assumes $P$

\vskip.5em

* We can't simply make intuitive arguments in Logic
  * Every step of reasoning must be backed up by an inference rule

# Natural Deduction

* Inference rules are written using **meta-variables**
  * these are lower-case letters which can stand for any WFF
  * On the other hand propositional, or object, variables use upper-case letters

\vskip.5em

* **Example:**

  \footnotesize

  \begin{prooftree}
  \AxiomC{$a$}
  \AxiomC{$b$}
    \RightLabel{\tiny $\{\land I\}$}
    \BinaryInfC{$a \land b$}
  \end{prooftree}

  * Here $a$ and $b$ are the meta-variables, which can be replaced by WFFs such as $P$, $Q \to R$, etc.
  * the components above the line are called the **assumptions**
  * we use the assumptions to *infer* the **conclusion** (component below the line)
  * The rule of inference labels the line itself

# `True`, $\lnot$, $\leftrightarrow$

* Natural deduction uses a minimal set of operators, including:
  * The constant `False`
  * The three basic operators: $\lor$, $\land$, and $\to$

* The constant `True` and the operators $\lnot$ and $\leftrightarrow$ are abbreviations defined as follows:

\footnotesize
\vskip.5em
\begin{center}
$\begin{array}{rcl}
\textsf{True}       & = & \textsf{False} \to \textsf{False} \\
\lnot a             & = & a \to \textsf{False} \\
a \leftrightarrow b & = & (a \to b) \land (b \to a)
\end{array}$
\end{center}

# And Introduction $\{\land I\}$

::: columns
:::: column

**Rule:**

\begin{prooftree}
\AxiomC{$a$}
\AxiomC{$b$}
  \RightLabel{\scriptsize\{$\land I$\}}
  \BinaryInfC{$a \land b$}
\end{prooftree}

\vskip.5em

**Meaning:** If you know that some prop $a$ is `True` and you also know that $b$ is `True`, then you may infer that the prop $a \land b$ is `True`

::::
:::: column

**Examples:**

* **Theorem:** $P,\,Q \vdash P \land Q$

\footnotesize
\begin{prooftree}
\AxiomC{P}
\AxiomC{Q}
  \RightLabel{\tiny $\{\land I\}$}
  \BinaryInfC{$P \land Q$}
\end{prooftree}

* **Theorem:** $P,\,Q,\,R \vdash (P \land Q) \land R$

\footnotesize
\begin{prooftree}
\AxiomC{$P$}
\AxiomC{$Q$}
  \RightLabel{\tiny $\{\land I\}$}
  \BinaryInfC{$P \land Q$}
\AxiomC{ }
  \noLine
  \UnaryInfC{$R$}
    \RightLabel{\tiny $\{\land I\}$}
    \BinaryInfC{$\left(P \land Q\right) \land R$}
      \RightLabel{\tiny $\{\land I\}$}
\end{prooftree}

::::
:::

# Exercises

* Consider the following two propositions:

\vskip.5em

  \footnotesize
  \begin{center}
  $\begin{array}{rcl}
  x & = & A \land (B \land (C \land D)) \\
  y & = & (A \land B) \land (C \land D)
  \end{array}$
  \end{center}

\vskip.5em

* Describe the shapes of the proofs for $x$ and $y$. Assuming $A$, $B$, $C$, and $D$

# And Elimination $\{\land E_L\}$, $\{\land E_R\}$

::: columns
:::: column

**Rules:**

\begin{prooftree}
\AxiomC{$a \land b$}
  \RightLabel{\tiny $\{\land E_L\}$}
  \UnaryInfC{$a$}
\end{prooftree}

\begin{prooftree}
\AxiomC{$a \land b$}
  \RightLabel{\tiny $\{\land E_R\}$}
  \UnaryInfC{$b$}
\end{prooftree}

::::
:::: column

**Examples:**

* **Theorem:** $P,\,Q \land R \vdash P \land Q$

\footnotesize
\begin{prooftree}
\AxiomC{$P$}
\AxiomC{$Q \land R$}
  \RightLabel{\tiny $\{\land E_L\}$}
  \UnaryInfC{$Q$}
\RightLabel{\tiny $\{\land I\}$}
\BinaryInfC{$P \land Q$}
\end{prooftree}

* **Theorem:** $P \land Q \vdash Q \land P$

\footnotesize
\begin{prooftree}
\AxiomC{$P \land Q$}
  \RightLabel{\tiny $\{\land E_R\}$}
  \UnaryInfC{$Q$}
  \AxiomC{$P \land Q$}
  \RightLabel{\tiny $\{\land E_L\}$}
  \UnaryInfC{$P$}
\RightLabel{\tiny $\{\land I\}$}
\BinaryInfC{$Q \land P$}
\end{prooftree}

::::
:::

# Additional Example:

* **Theorem:** For any well-formed propositions $a$, $b$, and $c$

$$a \land (b \land c) \vdash (a \land b) \land c$$

* *Proof:*

\begin{prooftree}
\AxiomC{$a \land (b \land c)$}
  \RightLabel{\tiny $\{\land E_L\}$}
  \UnaryInfC{$a$}
\AxiomC{$a \land (b \land c)$}
  \RightLabel{\tiny $\{\land E_R\}$}
  \UnaryInfC{$b \land c$}
    \RightLabel{\tiny $\{\land E_L\}$}
    \UnaryInfC{$b$}
      \RightLabel{\tiny $\{\land I\}$}
      \BinaryInfC{$a \land b$}
\AxiomC{$a \land (b \land c)$}
  \RightLabel{\tiny $\{\land E_R\}$}
  \UnaryInfC{$b \land c$}
    \RightLabel{\tiny $\{\land E_R\}$}
    \UnaryInfC{$c$}
      \RightLabel{\tiny $\{\land I\}$}
      \BinaryInfC{$\left(a \land b\right) \land c$}
\end{prooftree}

# Exercise

* Prove $\left(P \land Q\right) \land R \vdash P \land (Q \land R)$

  \pause

  \vskip1em

  \footnotesize
  **Solution:**

  \begin{prooftree}
  \AxiomC{$\left(P \land Q\right) \land R$}
    \RightLabel{\tiny $\{\land E_L\}$}
    \UnaryInfC{$P \land Q$}
      \RightLabel{\tiny $\{\land E_L\}$}
      \UnaryInfC{$P$}
  \AxiomC{$\left(P \land Q\right) \land R$}
    \RightLabel{\tiny $\{\land E_L\}$}
    \UnaryInfC{$P \land Q$}
      \RightLabel{\tiny $\{\land E_R\}$}
      \UnaryInfC{$Q$}
  \AxiomC{$\left(P \land Q\right) \land R$}
    \RightLabel{\tiny $\{\land E_R\}$}
    \UnaryInfC{$R$}
      \RightLabel{\tiny $\{\land I\}$}
      \BinaryInfC{$Q \land R$}
        \RightLabel{\tiny $\{\land I\}$}
        \BinaryInfC{$P \land (Q \land R)$}
  \end{prooftree}

# Imply Elimination $\{\to E\}$

::: columns
:::: column

**Rule:**

\begin{prooftree}
\AxiomC{$a$}
\AxiomC{$a \to b$}
  \RightLabel{\scriptsize $\{\to E\}$}
  \BinaryInfC{$b$}
\end{prooftree}

\vskip0.5em

**Meaning:** If you know $a$ is true, and also that $a \to b$, then you can infer $b$.

\vskip1em

**Latin Name:** *Modus Ponens*

::::
:::: column

**Example:**

* **Theorem:** $Q \land P$, $P \land Q \to R \vdash R$

\footnotesize

\begin{prooftree}
\AxiomC{$Q \land P$}
  \RightLabel{\tiny $\{\land E_R\}$}
  \UnaryInfC{$P$}
\AxiomC{$Q \land P$}
  \RightLabel{\tiny $\{\land E_L\}$}
  \UnaryInfC{$Q$}
\RightLabel{\tiny $\{\land I\}$}
\BinaryInfC{$P \land Q$}
\AxiomC{$P \land Q \to R$}
  \RightLabel{\tiny $\{\to E\}$}
  \BinaryInfC{$R$}
\end{prooftree}

* **Theorem:** For all propositions $a$, $b$ and $c$, $a$, $a \to b$, $b \to c \vdash c$.

\footnotesize

\begin{prooftree}
\AxiomC{$a$}
\AxiomC{$a \to b$}
  \RightLabel{\tiny $\{\to E\}$}
  \BinaryInfC{$b$}
\AxiomC{$b \to c$}
  \RightLabel{\tiny $\{\to E\}$}
  \BinaryInfC{$c$}
\end{prooftree}

::::
:::

# Exercise

* Prove $P$, $P \to Q$, $\left(P \land Q\right) \to (R \land S) \vdash S$.

  \footnotesize

  \pause

  \vskip1em

  **Solution:**

  \begin{prooftree}
  \AxiomC{$P$}
  \AxiomC{$\cancel{P}$}
  \AxiomC{$P \to C$}
    \RightLabel{\tiny $\{\to E\}$}
    \BinaryInfC{$Q$}
      \RightLabel{\tiny $\{\land I\}$}
      \BinaryInfC{$P \land Q$}
  \AxiomC{$\left(P \land Q\right) \to (R \land S)$}
    \RightLabel{\tiny $\{\to E\}$}
    \BinaryInfC{$R \land S$}
      \RightLabel{\tiny $\{\land E_R\}$}
      \UnaryInfC{$S$}
  \end{prooftree}

# Imply Introduction $\{\to I\}$

::: columns
:::: column

**Rule:**

\begin{prooftree}
\AxiomC{$a \vdash b$}
  \RightLabel{\scriptsize\{$\to I$\}}
  \UnaryInfC{$a \to b$}
\end{prooftree}

\vskip.5em

**Meaning:** in order to infer the logical implication $a \to b$, you must have a proof of $b$ using $a$ as an assumption.

::::
:::: column

**Example:**

* **Theorem:** $\vdash (P \land Q) \to Q$

\footnotesize

\begin{prooftree}
\AxiomC{$P \land Q$}
  \RightLabel{\tiny $\{\land E_R\}$}
  \UnaryInfC{$Q$}
\RightLabel{\tiny $\{\land \to I\}$}
\UnaryInfC{$P \land Q \to Q$}
\end{prooftree}

::::
:::

# Imply Introduction $\{\to I\}$

* **Discharged Assumptions** -- assumptions used temporarily to establish a sequent, after which they are thrown away.
  * In proofs we will either place discharged assumptions in square brackets, "[ ]", surround them by a box, or draw a line through the discharged assumptions

::: columns
:::: column

* Using the prior example:

\footnotesize

\begin{prooftree}
\AxiomC{$\cancel{P \land Q}$}
  \RightLabel{\tiny $\{\land E_R\}$}
  \UnaryInfC{$Q$}
\RightLabel{\tiny $\{\to I\}$}
\UnaryInfC{$P \land Q \to Q$}
\end{prooftree}

::::
:::: column

* **Theorem:** (Implication chain rule). For all propositions $a$, $b$ and $c$. $a \to b$, $b \to c \vdash a \to c$

\footnotesize

\begin{prooftree}
\AxiomC{$\cancel{a}$}
\AxiomC{$a \to b$}
  \RightLabel{\tiny $\{\to E\}$}
  \BinaryInfC{$b$}
\AxiomC{$b \to c$}
  \RightLabel{\tiny $\{\to E\}$}
  \BinaryInfC{$c$}
\RightLabel{\tiny $\{\to I\}$}
\UnaryInfC{$a \to c$}
\end{prooftree}

::::
:::

# Or Introduction $\{\lor I_L\}$, $\{\lor I_R\}$

::: columns
:::: column

**Rules:**

\begin{prooftree}
\AxiomC{$a$}
  \RightLabel{\scriptsize\{$\lor I_L$\}}
  \UnaryInfC{$a \lor b$}
\end{prooftree}

\begin{prooftree}
\AxiomC{$b$}
  \RightLabel{\scriptsize\{$\lor I_R$\}}
  \UnaryInfC{$a \lor b$}
\end{prooftree}

\vskip1em

**Meaning:** If the proposition $a$ is true, then both $a \lor b$ and $b \lor a$ must also be true.

::::
:::: column

**Example:**

* **Theorem:** $P \land Q \vdash P \lor Q$
  * Alternative Proof 1:

    \begin{prooftree}
    \AxiomC{$P \land Q$}
      \RightLabel{\tiny $\{\land E_L\}$}
      \UnaryInfC{$P$}
    \RightLabel{\tiny $\{\lor I_L\}$}
    \UnaryInfC{$P \lor Q$}
    \end{prooftree}

  \vskip1em

  * Alternative Proof 2:

    \begin{prooftree}
    \AxiomC{$P \land Q$}
      \RightLabel{\tiny $\{\land E_R\}$}
      \UnaryInfC{$Q$}
    \RightLabel{\tiny $\{\lor I_R\}$}
    \UnaryInfC{$P \lor Q$}
    \end{prooftree}

::::
:::

# Exercise

* Prove $P \to \textsf{False} \lor P$

  \footnotesize

  \pause

  \vskip1em

  **Solution:**

  \begin{prooftree}
  \AxiomC{$P$}
    \RightLabel{\tiny $\{\lor I_R\}$}
    \UnaryInfC{$\textsf{False} \lor P$}
  \end{prooftree}

# Or Elimination $\{\lor E\}$

::: columns
:::: column

**Rule:**

\begin{prooftree}
\AxiomC{$a \lor b$}
\AxiomC{$a \vdash c$}
\AxiomC{$b \vdash c$}
  \RightLabel{\scriptsize\{$\lor E$\}}
  \TrinaryInfC{$c$}
\end{prooftree}

\vskip1em

**Meaning:** Unfortunately if we know $a \lor b$ is true, we cannot directly conclude anything about $a$ or $b$. However, if we also know there is a conclusion $c$ which can be inferred from both $a$ and $b$, then we know $c$ must be true.

::::
:::: column

**Example:**

* **Theorem:** $\left(P \land Q\right) \lor (P \land R) \vdash P$

\footnotesize

\begin{prooftree}
\AxiomC{$\left(P \land Q) \lor (P \land R)\right)$}
\AxiomC{$\cancel{P \land Q}$}
  \RightLabel{\tiny $\{\land E_L\}$}
  \UnaryInfC{$P$}
\AxiomC{$\cancel{P \land R}$}
  \RightLabel{\tiny $\{\land E_L\}$}
  \UnaryInfC{$P$}
\RightLabel{\tiny $\{\lor E\}$}
\TrinaryInfC{$P$}
\end{prooftree}

::::
:::

# Identity $\{ID\}$

::: columns
:::: column

**Rule:**

\begin{prooftree}
\AxiomC{$a$}
  \RightLabel{\scriptsize\{$ID$\}}
  \UnaryInfC{$a$}
\end{prooftree}

\vskip1em

**Meaning:** If we know $a$ is true, then we know $a$ is true

::::
:::: column

**Examples:**

* **Theorem:** $P \vdash P$

\footnotesize
\begin{prooftree}
\AxiomC{$P$}
  \RightLabel{\tiny $\{ID\}$}
  \UnaryInfC{$P$}
\end{prooftree}

* **Theorem:** $\vdash \textsf{True}$

\footnotesize
\begin{prooftree}
\AxiomC{$\cancel{\textsf{False}}$}
  \RightLabel{\tiny $\{ID\}$}
  \UnaryInfC{$\textsf{False}$}
    \RightLabel{\tiny $\{\to I\}$}
    \UnaryInfC{$\textsf{False} \to \textsf{False}$}
\end{prooftree}

::::
:::

# Contradiction $\{CTR\}$

::: columns
:::: column

**Rule:**

\begin{prooftree}
\AxiomC{$\textsf{False}$}
  \RightLabel{\scriptsize\{$CTR$\}}
  \UnaryInfC{$a$}
\end{prooftree}

\vskip1em

**Meaning:** We can infer *anything at all* given the assumption that `False` is true. This then describes the truthfulness of `False` indirectly.

::::
:::: column

**Example:**

* **Theorem:** $P$, $\lnot P \vdash Q$

  \vskip1em

  \footnotesize
  \begin{prooftree}
  \AxiomC{$P$}
  \AxiomC{$P \to \textsf{False}$}
    \RightLabel{\tiny $\{\to E\}$}
    \BinaryInfC{$\textsf{False}$}
      \RightLabel{\tiny $\{CTR\}$}
      \UnaryInfC{$Q$}
  \end{prooftree}

::::
:::

# Contradiction $\{CTR\}$

* **Theorem:** For all propositions $a$ and $b$, $a \lor b$, $\lnot a \vdash b$

  \vskip1em

  \footnotesize
  \begin{prooftree}
  \AxiomC{$a \lor b$}
  \AxiomC{$\cancel a$}
  \AxiomC{$a \to \textsf{False}$}
    \RightLabel{\tiny $\{\to E\}$}
    \BinaryInfC{$\textsf{False}$}
      \UnaryInfC{$b$}
  \AxiomC{$\cancel b$}
    \RightLabel{\tiny $\{ID\}$}
    \UnaryInfC{$b$}
  \RightLabel{\tiny $\{\lor E\}$}
  \TrinaryInfC{$b$}
  \end{prooftree}

# *Reductio ad Absurdum* $\{RAA\}$

::: columns
:::: column

**Rule:**

\begin{prooftree}
\AxiomC{$\lnot a \vdash \textsf{False}$}
  \RightLabel{\scriptsize\{$RAA$\}}
  \UnaryInfC{$a$}
\end{prooftree}

\vskip1em

**Meaning:** If we can infer `False` from an assumption of $\lnot a$, then $a$ must be true.

\vskip1em

* This is the underpinning of the *proof by contradiction strategy*
  * First, we assume the contradiction $\lnot a$ and infer $\textsf{False}$
  * Then, using $\{RAA\}$ we infer $a$

::::
:::: column

**Examples:**

* **Theorem:** (Double negation) $\lnot\lnot a \vdash a$

  \vskip.5em

  \footnotesize
  We will use the general form:
  \vskip.5em
  \begin{prooftree}
  \AxiomC{$\lnot a$}
  \AxiomC{$\lnot\lnot a$}
    \BinaryInfC{$\textsf{False}$}
  \end{prooftree}

  \vskip.5em

  Recall: $\lnot a = a \to \textsf{False}$ thus, $\lnot\lnot a = (a \to \textsf{False}) \to \textsf{False}$

  \vskip.5em

  \begin{prooftree}
  \AxiomC{$\cancel{a \to \textsf{False}}$}
  \AxiomC{$\left(a \to \textsf{False}\right) \to \textsf{False}$}
    \RightLabel{\tiny $\{\to E\}$}
    \BinaryInfC{$\textsf{False}$}
      \RightLabel{\tiny $\{RAA\}$}
      \UnaryInfC{$a$}
  \end{prooftree}

::::
:::

# For Next Time

::: columns
:::: column
* Review DMUC Chapter 6.1 -- 6.5
* Review this Lecture
* Read Chapter 6.6 -- 6.10
* Come To Lecture
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
