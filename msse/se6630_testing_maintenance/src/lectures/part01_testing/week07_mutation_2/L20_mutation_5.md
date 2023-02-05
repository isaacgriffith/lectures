---
author:
- Isaac Griffith
title: Model-Based Grammars
institute: |
  SE 6630 - Software Testing, Maintenance, and Evolution

  Department of Software Engineering

  Idaho State University
fontsize: 12pt
cornerLogo: "../../../images/spirit.png"
wideLogo: "../../../images/wide.png"
lowerCornerLogo: "../../../images/roar.eps"
...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}

* Understand the basics of FSMs
* Understand how FSMs can be mutated
* Understand how FSM mutation can be used in testing

::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{../../../images/brain-gears.jpg}
::::
:::

# Inspiration

\vfill
\centering
> "More than the act of testing, the act of designing tests is one of the best bug preventers known. The thinking that must be done to create a useful test can discover and eliminate bugs before they are coded – indeed, test-design thinking can discover and eliminate bugs at every stage in the creation of software, from conception to specification, to design, coding and the rest." -- Boris Beizer

#

\centering
\vfill
\begin{minipage}{.75\textwidth}
\begin{minipage}{3.5em}
\vskip-3em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge Model-Based Grammars
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 6630}
\end{minipage}
\end{minipage}

# Model-based Grammars

\begin{block}{}
\centering
\textbf{\underline{Model-based}}
languages that describe software in abstract terms
\end{block}

* **Formal** specification languages
  - Z, SMV, OCL, ...
* **Informal** specification languages
* **Design** notations
  - Statecharts, FSMs, UML notations
* **Model-based** languages are becoming more widely used

# Instantiating Grammar-Based Testing

\centering
\includegraphics[width=.8\textwidth]{../../../images/part01/mutation/model_based_inst.eps}

# BNF Grammar Testing

* Terminal symbol coverage and production coverage have only been applied to **algebraic** specifications

\vskip1em

* Algebraic specifications are **not widely used**

\vskip1em

* This is essentially **research-only**, so not covered in this book

# Specification-based Mutation

* A **finite state machine** is essentially a graph **G**
  - Nodes are states
  - Edges are transitions

\vskip1em

* A *formalization* of an FSM is:
  - *States* are **implicitly defined** by declaring variables with limited range
  - The *state space* is then the **Cartesian product** of the ranges of the variables
  - *Initial states* are defined by **limiting the ranges** of some or all of the variables
  - *Transitions* are defined by **rules** that characterize the source and target of each transition

# Example SMV Machine

::: columns
:::: {.column width=.33}
\scriptsize
```
MODULE main
#define false 0
#define true 1
VAR
      x, y: boolean;
ASSIGN
      init(x) := false;
      init(y) := false;
      next(x) := case
          !x & y : true;
          !y     : true;
          x      : false;
          true   : x;
      esac;

      next(y) := case
          x & !y : false;
          x & y  : y;
          !x & y : false;
          true   : true;
      esac;
```
::::
:::: {.column width=.67}
* Initial state: **(F, F)**
* Value for **x** in next state:
  - if **x = F** and **y = T**, next state has **x = T**
  - if **y = F**, next state has **x = T**
  - if **x = T**, next state has **x = F**
  - otherwise, next state **x** does not change
::::
:::

# Example SMV Machine

::: columns
:::: {.column width=.33}
\scriptsize
```
MODULE main
#define false 0
#define true 1
VAR
      x, y: boolean;
ASSIGN
      init(x) := false;
      init(y) := false;
      next(x) := case
          !x & y : true;
          !y     : true;
          x      : false;
          true   : x;
      esac;

      next(y) := case
          x & !y : false;
          x & y  : y;
          !x & y : false;
          true   : true;
      esac;
```
::::
:::: {.column width=.67}
* Value for **y** in next state
  - if **(T, F)**, next state has **y = f**
  - if **(T, T)**, next state **y** does not change
  - if **(F, T)**, next state has **y=F**
  - otherwise, next state has **y = T**
* Any ambiguity in SMV is resolved by the order of the cases
* "**true : x**" corresponds to "**default**" in programming
::::
:::

# Example SMV Machine

::: columns
:::: {.column width=.33}
\scriptsize
```
MODULE main
#define false 0
#define true 1
VAR
      x, y: boolean;
ASSIGN
      init(x) := false;
      init(y) := false;
      next(x) := case
          !x & y : true;
          !y     : true;
          x      : false;
          true   : x;
      esac;

      next(y) := case
          x & !y : false;
          x & y  : y;
          !x & y : false;
          true   : true;
      esac;
```
::::
:::: {.column width=.67}
\begin{center}
\includegraphics[width=.5\textwidth]{../../../images/part01/mutation/fsm_smv_ex.eps}
\end{center}

* Converting from SMV to FSM is mechanical and easy to automate
* SMV notation is **smaller** than graphs for **large** finite state machines
::::
:::

# Using SMV Descriptions

* Finite state descriptions can capture **system behavior** at a very high level - suitable for communicating with end users
* The verification community has built **powerful analysis tools** for finite state machines expressed in SMV
* These tools produce **explicit evidence** for properties that are **not true**
* This "*evidence*" is presented as sequences of states, called "**counterexamples**"
* Counterexamples are *paths* through the FSM that can be used as **test cases**

# Mutations and Test Cases

* Mutating FSMs requires **mutation operators**
* Most FSM mutation operators are **similar** to program language operators

## Constant Replacement Operator:

\footnotesize
* changes a constant to each other constant
* in the **next(y)** case: **!x & y : false** is mutated to **!x & y : true**
* To kill this mutant, we need a **sequence of states** (a path) that the **original machine allows** but the mutated machine **does not**
* This is what **model checkers** do
  \scriptsize
  - Model checkers find **counterexamples** - paths in the machine that violate some **property**
  - Properties are written in "**temporal logic**" - logical statements that are true for some period of time
  - **!x & y : false** has different results from **!x & y : true**

# Counter-Example for FSM

\centering
\includegraphics[width=.8\textwidth]{../../../images/part01/mutation/cex_fsm_ex.eps}

# Counter-Example for FSM

* The model checker should produce:

\begin{center}
\includegraphics[width=.5\textwidth]{../../../images/part01/mutation/checker_output.eps}
\end{center}

* This represents a test case that goes from nodes FF to TT to FT to TF in the original FSM
  - The last step in the mutated FSM will be to TT, killing the mutant
* If no sequence is produced, the mutant is equivalent
  - Equivalence is **undecidable** for programs, but **decidable** for FSMs

# Model-Based Grammars Summary

* **Model-Checking** is slowly growing in use

\vskip.5em

* **Finite state machines** can be encoded into model checkers

\vskip.5em

* Properties can be defined on FSMs and model checking used to find **paths that violate** the properties

\vskip.5em

* **No equivalent** mutants

\vskip.5em

* Everything is **finite**

# For Next Time

::: columns
:::: {.column width=.6}

::::
:::: {.column width=.4}
\centering
\includegraphics[width=.85\textwidth]{../../../images/next_time.png}
::::
:::

#

\centering
\vfill
\includegraphics[scale=.40]{../../../images/questions.png}

\Huge \textbf{Are there any questions?}
