---
author:
- Dr. Isaac Griffith
title: Logic
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Outline

::: columns
:::: {.column width=.7}
* Proof Checking by Computer
* Equational Reasoning
* Logic in Computer Science
* Satisfiability
* Meta-Logic
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
\begin{minipage}{.75\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Proof Checking by Computer
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Proof Checking

* **Proof Checker** -- a program that reads in a theorem and a proof, and determines whether the proof is valid and actually establishes the theorem
  * *Advantage* -- can **always** determine whether a purported proof is valid or invalid. Useful to verify hand checked theorems.

\vskip.5em

* **Theorem Prover** -- a program that reads a theorem and attempts to generate a proof from scratch.
  * *Advantage* -- can sometimes save the user a lot of work
  * *Disadvantage* -- does not always succeed

\vskip.5em

* **Proof Tools** -- any computer software that helps with formal proofs, this includes both proof checkers and theorem provers.
  * Active area of research, but is gaining practical use
  * Most industrial strength poof tools are implemented in functional languages like Haskell


# Example

\begin{center}
**Theorem:** $\vdash Q \to ((P \land Q) \to (R \land Q))$
\end{center}

::: columns
:::: column

\footnotesize

**Proof Tree:**

\begin{prooftree}
\AxiomC{$\cancel{P \land R}$}
  \RightLabel{\scriptsize $\{\land E_R\}$}
  \UnaryInfC{$R$}
\AxiomC{$\cancel{Q}$}
  \RightLabel{\scriptsize $\{\land I$}
  \BinaryInfC{$R \land Q$}
    \RightLabel{\scriptsize $\{\to I\}$}
    \UnaryInfC{$\left(P \land R\right) \to (R \land Q)$}
      \RightLabel{\scriptsize $\{\to I\}$}
      \UnaryInfC{$Q \to ((P \land R) \to (R \land Q))$}
\end{prooftree}

::::
:::: column

\footnotesize

**Code:**

```haskell
proof1 :: Proof
proof1 =
  ImplI
    (ImpI
      (AndI
        ((AndER
            (Assume (And P R))
            R),
          Assume Q)
        (And R Q))
      (Imp (And P R) (And R Q)))
    (Imp Q (Imp (And P R) (And R Q)))
```

::::
:::

# Representing WFFs

::: columns
:::: column

* WFFs can be modeled in Haskell as an Algebraic Data Type
  * Boolean constants are represented by `TRUE` and `FALSE`
  * Propositional variables are represented as upper-case letters (except `T` and `F`)
  * We can make a string a propositional variable using `Pvar "name"`
  * Additional types are for the different operators

::::
:::: column

\vspace{-1em}
\scriptsize

```haskell
data Prop
  = FALSE
  | TRUE
  | A | B | C | D | E | G | H | I | J | K | L | M
  | N | O | P | Q | R | S | U | V | W | X | Y | Z
  | Pvar String
  | And Prop Prop
  | Or Prop Prop
  | Not Prop
  | Imp Prop Prop
  | Equ Prop Prop
  deriving (Eq, Show)
```

::::
:::

# Exercises

* Load `Stdm` and use it to define each of the following in Haskell using the `Prop` type

  * $Q \lor \textsf{False}$ \only<2>{$\Rightarrow$ \textcolor{Roarange}{\texttt{Or Q FALSE}}}
  * $Q \to (P \to (P \lor Q))$ \only<2>{$\Rightarrow$ \textcolor{Roarange}{\texttt{Imp Q (Imp P (Or P Q))}}}

\vskip1em

* Translate the following from Haskell into logical notation:

  * `Imp (Not P) (Or R S)` \only<2>{$\Rightarrow$ \textcolor{Roarange}{$\lnot P \to (R \lor S)$}}
  * `Equ (Imp P Q) (Or (Not P) Q)` \only<2>{$\Rightarrow$ \textcolor{Roarange}{$\left(P \to Q\right) \leftrightarrow (\lnot P \lor Q)$}}

# Representing Proofs

* Just like with WFFs we can also model a proof as a Haskell algebraic data type

\vskip.25em

* A Proof contains both a proposition and a formal argument for the truth of that proposition

\vskip.25em

* We then have the following (1st Arg are the assumptions, 2nd the conclusion)

::: columns
:::: {.column width=.05}

::::
:::: {.column width=.475}

* `Assume Prop`
* `AndI (Proof, Proof) Prop`
* `AndEL Proof Prop`
* `AndER Proof Prop`
* `OrIL Proof Prop`
* `OrIR Proof Prop`

::::
:::: {.column width=.475}

* `OrE (Proof, Proof, Proof) Prop`
* `ImpI Proof Prop`
* `ImpE (Proof Proof) Prop`
* `ID Proof Prop`
* `CTR Proof Prop`
* `RAA Proof Prop`

::::
:::

# Representing Proofs

* We can also represent a theorem as a list of assumptions and a single conclusion

  ```haskell
    data Theorem = Theorem [Prop] Prop
  ```

\vskip.5em

* **Example:** Represent Theorem: $a_1, a_2, a_3 \vdash c$

  ```haskell
    Theorem [a1, a2, a3] c
  ```

\vskip.5em

* All of these data types and the means to check them are provided in the `Stdm` module

#

\centering
\vfill
\begin{minipage}{.575\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Equational Reasoning
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Boolean Algebra

* Takes an *axiomatic* approach to logic based on mathematical reasoning

\vskip.5em

* Originally developed by George Boole

\vskip.5em

* A form of *equational reasoning* embodying two crucial ideas:
  1. We show two values are the same by building up *chains of equalities*
  2. We can *substitute equals for equals* in order to add a new link to the chain

# Boolean Algebra

* A *chain of equalities* relies on the fact that if we know $a = b$ and $b = c$, then we can deduce $a = c$

\vskip.5em

* *substituting equals for equals* means that if we know $x = y$ and we have a big expression containing $x$, we can replace $x$ with $y$ without changing the value of the expression.

::: columns
:::: column

* **Example:**

  $\begin{array}{rcl}
  x & = & 2 + p \\
  y & = & 5x + 3 \\ \\
  y & = & 5(2 + p) + 3
  \end{array}$

::::
:::: column

* **Note:** You should remember to apply parentheses to ensure substitutions act as a single value.

::::
:::

\vskip.5em

* It is good practice to provide justification for each substitution in the chain

# Laws of Boolean Algebra

* **Laws:** set of equations that describe the basic algebraic properties of propositions
  * A law is a proposition that is always true for all assignments to its variables

\vskip.5em

* The essence of Boolean Algebra is:
  * We can use equations to state axioms on a set of operators
  * We can then use equational reasoning to explore the resulting system

# Operations w/ Constants

* These laws describe how $\land$ and $\lor$ interact with the Boolean constants True and False

\vskip.5em

::: columns
:::: column

**Laws:**

\begin{center}
$\begin{array}{rcll}
a \land \textsf{False} & = & \textsf{False} & \{\land\,\, \textrm{null}\} \\
a \lor \textsf{True}   & = & \textsf{True}  & \{\lor\,\, \textrm{null}\} \\
a \land \textsf{True}  & = & a              & \{\land\,\, \textrm{identity}\} \\
a \lor \textsf{False}  & = & a              & \{\lor\,\, \textrm{identity}\}
\end{array}$
\end{center}

::::
:::: column

**Example:**

\vskip.5em

*Proof:* $\left(P \land \textsf{True}\right) \lor \textsf{False} = P$

\begin{center}
$\begin{array}{lr}
\left(P \land \textsf{True}\right) \lor \textsf{False} & \\
\,\,\,= P \land \textsf{True}                          & \{\lor\,\, \textrm{identity}\} \\
\,\,\,= P                                              & \{\land\,\, \textrm{identity}\}
\end{array}$
\end{center}

::::
:::

# Exercises

* Simplify $\left(P \land \textsf{False}\right) \lor (Q \land \textsf{True})$

  \only<2>{
  \vskip.5em
  \textcolor{Roarange}{
  $\begin{array}{lr}
  \left(P \land \textsf{False}\right) \lor (Q \land \textsf{True}) & \\
  = \textsf{False} \lor (Q \land \textsf{True}) & \{\land \textrm{ null}\} \\
  = \textsf{False} \lor Q                       & \{\lor \textrm{ identity}\} \\
  = Q                                           & \{\lor \textrm{ null}\} \\
  \end{array}$
  }}

\vskip.1em

* Prove the Equation: $\left(P \land \textsf{False}\right) \land \textsf{True} = \textsf{False}$

  \only<2>{
  \vskip.5em
  \textcolor{Roarange}{
  $\begin{array}{lr}
  \left(P \land \textsf{False}\right) \land \textsf{True} & \\
  = \textsf{False} \land \textsf{True}                    & \{\land \textrm{null}\} \\
  = \textsf{False}                                        & \{\land \textrm{identity}\} \\
  \end{array}$
  }}

# Basic Properties of $\land$ and $\lor$

* These laws describe the basic properties of the $\land$ and $\lor$ operations
  * **idempotent** - property which allows us to reduce expressions like $a \land a \land a$ to $a$
  * **commutative** - property in which the order of operands can be reversed
  * **associative** - property wherein the grouping of parentheses may be changed without changing the meaning

\vskip.5em

::: columns
:::: column

**Laws:**

\scriptsize
\vspace{-1em}

\begin{center}
$\begin{array}{rcll}
a                   & \to & a \lor b            & \{\textrm{disjunctive implication}\} \\
a \land b           & \to & a                   & \{\textrm{conjunctive implication}\} \\
a \land a           & =   & a                   & \{\land\,\, \textrm{idempotent}\} \\
a \lor a            & =   & a                   & \{\lor\,\ \textrm{idempotent}\} \\
a \land b           & =   & b \land a           & \{\land\,\, \textrm{commutative}\} \\
a \lor b            & =   & b \lor a            & \{\lor\,\, \textrm{commutative}\} \\
(a \land b) \land c & =   & a \land (b \land c) & \{\land\,\, \textrm{associative}\} \\
(a \lor b) \lor c   & =   & a \lor (b \lor c)   & \{\lor\,\, \textrm{associative}\}
\end{array}$
\end{center}

::::
:::: column

**Example:** Prove $\left(\textsf{False} \land P\right) \lor Q = Q$

\vskip.5em
\footnotesize

$\begin{array}{lr}
(\textsf{False} \land P) \lor Q & \\
\,\,\,= (P \land \textsf{False}) \lor Q & \{\land\,\, \textrm{commutative}\} \\
\,\,\,= \textsf{False} \lor Q           & \{\land\,\, \textrm{null}\} \\
\,\,\,= Q \lor \textsf{False}           & \{\lor\,\, \textrm{commutative}\} \\
\,\,\,= Q                               & \{\lor\,\, \textrm{identity}\}
\end{array}$

::::
:::

# Exercises

* Prove: $\left(P \land ((Q \lor R) \lor Q)\right) \land S = S \land ((R \lor Q) \land P)$

  \only<2>{
  \vskip.5em
  \textcolor{Roarange}{
  $\begin{array}{lr}
  \left(P \land ((Q \lor R) \lor Q)\right) \land S = S \land ((R \lor Q) \land P) & \\
  = (P \land ((R \lor Q) \lor Q)) \land S & \{\lor \textrm{commutative}\} \\
  = (P \land (R \lor (Q \lor Q))) \land S & \{\lor \textrm{associative}\} \\
  = (P \land (R \lor Q)) \land S          & \{\lor \textrm{idempotent}\} \\
  = ((R \lor Q) \land P) \land S          & \{\land \textrm{associative}\} \\
  = S \land ((R \lor Q) \land P)          & \{\land \textrm{associative}\}
  \end{array}$
  }}

\vskip.5em

* Prove: $P \land (Q \land (R \land S)) = ((P \land Q) \land R) \land S$

  \only<2>{
  \vskip.5em
  \textcolor{Roarange}{
  $\begin{array}{lr}
  P \land (Q \land (R \land S)) = ((P \land Q) \land R) \land S & \\
  = (P \land Q) \land (R \land S) & \{\land \textrm{associative}\} \\
  = ((P \land Q) \land R) \land S & \{\land \textrm{associative}\}
  \end{array}$
  }}

# Distributive and DeMorgan's Laws

* These laws describe important properties of expressions containing both the $\lor$ and $\land$ operators

**Laws:**

$\begin{array}{rcll}
a \land (b \lor c) & = & (a \land b) \lor (a \land c) & \{\land\,\, \textrm{distributes over}\,\, \lor\} \\
a \lor (b \land c) & = & (a \lor b) \land (a \lor c)  & \{\lor\,\, \textrm{distributes over}\,\, \land\} \\
\lnot (a \land b)  & = & \lnot a \lor \lnot b         & \{\textrm{DeMorgan's law}\} \\
\lnot (a \lor b)   & = & \lnot a \land \lnot b        & \{\textrm{DeMorgan's law}\}
\end{array}$

# Laws of Negation

* These laws state the basic properties of negation

\vskip.5em

::: columns
:::: column

**Laws:**

\begin{center}
$\begin{array}{rcll}
\lnot\textsf{True}  & = & \textsf{False} & \{\textrm{negate}\,\,\textsf{True}\} \\
\lnot\textsf{False} & = & \textsf{True}  & \{\textrm{negate}\,\,\textsf{False}\} \\
a \land \lnot a     & = & \textsf{False} & \{\land\,\,\textrm{complement}\} \\
a \lor \lnot a      & = & \textsf{True}  & \{\lor\,\,\textrm{complement}\} \\
\lnot (\lnot a)     & = & a              & \{\textrm{double negation}\}
\end{array}$
\end{center}

::::
:::: column

**Example:** Simplify $P \land \lnot (Q \lor P)$

\vskip.5em

$\begin{array}{lr}
P \land \lnot (Q \lor P) & \\
\,\,\,= P \land (\lnot Q \land \lnot P)  & \{\textrm{DeMorgan's law}\} \\
\,\,\,= P \land (\lnot P \land \lnot Q)  & \{\land\,\, \textrm{commutative}\} \\
\,\,\,= (P \land \lnot P) \land \lnot Q  & \{\land\,\, \textrm{associative}\} \\
\,\,\,= \textsf{False}\,\, \land \lnot Q & \{\land\,\, \textrm{complement}\} \\
\,\,\,= \lnot Q \land\,\, \textsf{False} & \{\land\,\, \textrm{commutative}\} \\
\,\,\,= \textsf{False}                   & \{\land\,\, \textrm{null}\}
\end{array}$

::::
:::

# Laws of Implication

* These laws are frequently used in solving problems

**Laws:**

\vspace{-1em}
\scriptsize

\begin{center}
$\begin{array}{rcll}
a \land (a \to b)               & \to & b                             & \{\textrm{Modus Ponens}\} \\
(a \to b) \land \lnot b         & \to & \lnot a                       & \{\textrm{Modus Tollens}\} \\
(a \lor b) \land \lnot a        & \to & b                             & \{\textrm{disjunctive syllogism}\} \\
(a \to b) \land (b \to c)       & \to & a \to c                       & \{\textrm{implication chain}\} \\
(a \to b) \land (c \to d)       & \to & (a \land c) \to (b \land d)   & \{\textrm{implication combination}\} \\
(a \land b) \to c               & =   & a \to (b \to c)               & \{\textrm{Currying}\} \\
a \to b                         & =   & \lnot a \lor b                & \{\textrm{implication}\} \\
a \to b                         & =   & \lnot b \to \lnot a           & \{\textrm{contrapositive}\} \\
(a \to b) \land (a \to \lnot b) & =   & \lnot a                       & \{\textrm{absurdity}\}
\end{array}$
\end{center}

\vskip.5em

* Some laws are implications and some are equations

\vskip.5em

* The implications only work in the direction of the arrow and cannot be applied in the opposite direction.

# Equivalence

* Equivalence is no necessarily needed, as shown in the following law:

\begin{center}
$\begin{array}{rcll}
a \leftrightarrow b & = & (a \to b) \land (b \to a) & \{\textrm{equivalence}\}
\end{array}$
\end{center}

* Equivalence is similar to equality, but there is a subtle difference
  * $P \land P \leftrightarrow P$ is a proposition which has the value of **True**
  * $P \land P = P$ is an equation not a proposition
    * However, both the left- and right-hand sides of the equation are propositions

\vskip.5em

* An equation is a statement in the *meta-language*
  * It is a statement *about* propositions expressed using the *object language*

#

\centering
\vfill
\begin{minipage}{.7\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Logic in Computer Science
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Formal Correctness of Software

* We can use English to Logic translation, in the specification of hardware and software systems

\vskip.5em

* We take natural language requirements and translate them to precise and unambiguous specifications

\vskip.5em

* These specifications can then be used as the basis for system development

\vskip0.5em
\pause

* **Example:**
  - Express the specification "The automated reply cannot be sent when the file system is full"
    * $p$: "The automated reply can be sent"
    * $q$: "The file system is full"
    \pause
    * Specification - $q \to \lnot p$

# Isomorphism and Type Systems

* Modern programming languages (especially functional ones) have very powerful and expressive type systems

\vskip.5em

* The rules of logic and those for type systems are deeply connected

\vskip.5em

* Thus, we need effective methods to deal with type systems for
  * Programmers
  * Compiler writers
  * Language designers

# Translating English Sentences

* English (like other human languages) tends to be ambiguous

\vskip.5em

* Hence, translating to propositional logic removes this ambiguity
  - However, this does involve making certain assumptions

\vskip.5em

* Once translated, we must assign truth values to reason about the propositions

# Boolean Searches

* **Boolean Searches** - Logical connectives are extensively used in information searches (such as Google)

\vskip1em
\pause

* **Example queries:**
  - "New Mexico" AND Universities
  - (New AND Mexico OR Arizona) AND Universities
  - (Mexico AND Universities) NOT New

# Digital Hardware Design

* Propositional logic can be applied to the design of computer hardware

\vskip0.5em
\pause

* **Logic Circuit** - receives input signals $p_1,\,p_2,\,\ldots,\,p_n$, each a bit and produces output signals $s_1,\,s_2,\,\ldots,\,s_n$, also each a bit.

\vskip0.5em
\pause

* **Gates** - the basic circuits used to construct more complex logic circuits. The following are the basic gates:

\vskip1em
\pause

\footnotesize

::: columns
:::: {.column width=.333}

\centering

\begin{tikzpicture}

% Circuit style
\ctikzset{
    logic ports=ieee,
    logic ports/scale=0.8,
}

% Logic ports
\node[not port,color=white] (NOTa) at (0,0){};
%\node[or port] (ORb) at (0,-1){};

% Connection
\draw (NOTa.out) -- ++(1,0) node[near end,above]{$\lnot p$};

\draw (NOTa.in 1) -- ++(-1.0,0)node[left]{$p$};

\end{tikzpicture}

**Inverter**

::::
:::: {.column width=.333}

\centering
\pause

\begin{tikzpicture}

% Circuit style
\ctikzset{
    logic ports=ieee,
    logic ports/scale=0.8,
}

% Logic ports
\node[or port,color=white] (ORa) at (0,0){};
%\node[or port] (ORb) at (0,-1){};

% Connection
\draw (ORa.out) -- ++(1,0) node[near end,above]{$p \lor q$};

\draw (ORa.in 1) -- ++(-1.0,0)node[left]{$p$};
\draw (ORa.in 2) -- ++(-1.0,0)node[left]{$q$};

\end{tikzpicture}

**OR Gate**

::::
:::: {.column width=.333}

\centering
\pause

\begin{tikzpicture}

% Circuit style
\ctikzset{
    logic ports=ieee,
    logic ports/scale=0.8,
}

% Logic ports
\node[and port,color=white] (ANDa) at (0,0){};
%\node[and port] (ANDb) at (0,-1){};

% Connection
\draw (ANDa.out) -- ++(1,0) node[near end,above]{$p \land q$};

\draw (ANDa.in 1) -- ++(-1.0,0)node[left]{$p$};
\draw (ANDa.in 2) -- ++(-1.0,0)node[left]{$q$};

\end{tikzpicture}

**AND Gate**

::::
:::

# Logic Circuit Example

\scriptsize
\centering

* \scriptsize Logic Circuit for $\left(p \land \lnot q\right) \lor \lnot r$

\pause

\begin{tikzpicture}

\ctikzset{
  logic ports=ieee,
  logic ports/scale=0.5,
}

% Logic ports

\node[not port,color=white] (NOTa) at (0,0){};
\node[not port,color=white] (NOTb) at (0,-0.75){};
\node[and port,color=white] (ANDa) at (2,0.15){};
\node[or port,color=white] (ORa) at (4,0){};

% Connections

\draw (NOTa.in 1) -- ++(-1.0,0)node[left]{$q$};
\draw (NOTb.in 1) -- ++(-1.0,0)node[left]{$r$};
%\draw (ANDa.in 1) -- ++(-1.0,0)node[left]{$p$};

\draw (NOTa.out) -- node[near start,below]{$\lnot q$}(ANDa.in 2);
\draw (-1.45,0.35) node[left]{$p$} -| (ANDa.in 1);
\draw (NOTb.out) -| node[near start,above]{$\lnot r$}(ORa.in 2);
\draw (ANDa.out) -- node[above]{$p \land \lnot q$}(ORa.in 1);
\draw (ORa.out) -- ++(2.0,0)node[near end,above]{$\left(p \land \lnot q\right) \lor \lnot r$};

\end{tikzpicture}

\vskip1em
\pause

* \scriptsize Logic Circuit for $\left(p \lor \lnot r\right) \land (\lnot p \lor (q \lor \lnot r))$

\pause

\begin{tikzpicture}

\ctikzset{
  logic ports=ieee,
  logic ports/scale=0.5,
}

% Logic ports

\node[not port,color=white] (NOTa) at (0,0){};
\node[not port,color=white] (NOTb) at (0,-0.75){};
\node[not port,color=white] (NOTc) at (0,-1.5){};
\node[or port,color=white] (ORa) at (2,0.15){};
\node[or port,color=white] (ORb) at (2,-1.35){};
\node[or port,color=white] (ORc) at (4,-1){};
\node[and port,color=white] (ANDa) at (7,-0.5){};

% Connections

\draw (ANDa.out) -- ++(3.0,0)node[near end,above]{$\left(p \lor \lnot r\right) \land (\lnot p \lor (q \lor \lnot r))$};
\draw (ORc.out) -| node[near start,below]{$\lnot p \lor (q \lor \lnot r)$}(ANDa.in 2);
\draw (ORa.out) -| node[near start,above]{$p \lor \lnot r$}(ANDa.in 1);
\draw (NOTb.out) -| node[near start,above]{$\lnot p$}(ORc.in 1);
\draw (ORb.out) -| node[near start,below]{$q \lor \lnot r$}(ORc.in 2);
\draw (NOTc.out) -- node[near start,below]{$\lnot r$}(ORb.in 2);
\draw (NOTa.out) -- node[near start,below]{$\lnot r$}(ORa.in 2);
\draw (NOTa.in 1) -- ++(-1.0,0)node[left]{$r$};
\draw (NOTb.in 1) -- ++(-1.0,0)node[left]{$p$};
\draw (NOTc.in 1) -- ++(-1.0,0)node[left]{$r$};
\draw (-1.45,0.35) node[left]{$p$} -| (ORa.in 1);
\draw (-1.45,-1.15) node[left]{$q$} -| (ORb.in 1);

\end{tikzpicture}

# Exercises

Translate the following statements into propositional logic using the propositions provided:

1. \footnotesize You cannot edit a protected Wikipedia entry unless you are an administrator.
   - \scriptsize $e$: "You can edit a protected Wikipedia entry"
   - \scriptsize $a$: "You are an administrator"
   \vskip0.5em
   \pause

   \scriptsize
   **Solution:** **$\lnot a \to \lnot e$**

\pause

2. \footnotesize You can graduate only if you have completed the requirements of your major and you do not owe money to the university and you do not have an overdue library book.
   - \scriptsize $g$: "You can graduate"
   - \scriptsize $m$: "You owe money to the university"
   - \scriptsize $r$: "You have completed the requirements of your major"
   - \scriptsize $b$: "You have an overdue library book"
   \vskip0.5em
   \pause

   \scriptsize
   **Solution:** **$g \to (r \land \lnot m \land \lnot b)$**

# Exercises

Express these specifications using the following propositions:

* \footnotesize $p$: "The user enters a valid password"
* \footnotesize $q$: "Access is granted"
* \footnotesize $r$: "The user has paid the subscription fee"

\vskip0.5em

1. \footnotesize\ "The user has paid the subscription fee, but does not enter a valid password"
   \vskip0.5em
   \pause

   \scriptsize
   **Solution:** **$r \land \lnot p$**

\pause

2. \footnotesize\ "If the user has not entered a valid password but has paid the subscription fee, then access is granted"
   \vskip0.5em
   \pause

   \scriptsize
   **Solution:** **$\left(\lnot p \land \lnot r\right) \to g$**

# Exercise

Construct a combinatorial circuit using inverters, OR gates, and AND gates such that:

- \footnotesize Produces the output $\left((\lnot p \lor \lnot r\right) \land \lnot q) \lor (\lnot p \land (q \lor r))$
- \footnotesize From input bits $p$, $q$, and $r$.

\pause
\scriptsize
\vfill

\centering

\begin{tikzpicture}

\ctikzset{
  logic ports=ieee,
  logic ports/scale=0.5,
}

% Logic ports

\node[not port,color=white] (NOTa) at (0,.65){};
\node[not port,color=white] (NOTb) at (0,0){};
\node[not port,color=white] (NOTc) at (0,-.65){};
\node[not port,color=white] (NOTd) at (0,-1.35){};
\node[or port,color=white] (ORa) at (2,0.15){};
\node[or port,color=white] (ORb) at (2,-2.15){};
\node[or port,color=white] (ORc) at (7,-1){};
\node[and port,color=white] (ANDa) at (4,-0.5){};
\node[and port,color=white] (ANDb) at (4,-1.5){};

% Connections

\draw (ANDa.out) -| node[near start,above]{$\left(\lnot p \lor \lnot r\right) \land \lnot q$}(ORc.in 1);
\draw (ANDb.out) -| node[near start,below]{$\lnot p \land (q \lor r)$}(ORc.in 2);
\draw (ORa.out) -| node[near start,above]{$\lnot p \lor \lnot r$}(ANDa.in 1);
\draw (ORb.out) -| node[near start,below]{$q \lor r$}(ANDb.in 2);
\draw (NOTc.out) -- node[near start,above]{$\lnot q$}(ANDa.in 2);
\draw (NOTd.out) -- node[near start,above]{$\lnot p$}(ANDb.in 1);
\draw (NOTb.out) -- node[near start,above]{$\lnot r$}(ORa.in 2);
\draw (NOTa.out) -| node[near start,above]{$\lnot p$}(ORa.in 1);
\draw (NOTa.in 1) -- ++(-1.0,0)node[left]{$p$};
\draw (NOTb.in 1) -- ++(-1.0,0)node[left]{$r$};
\draw (NOTc.in 1) -- ++(-1.0,0)node[left]{$q$};
\draw (NOTd.in 1) -- ++(-1.0,0)node[left]{$p$};
\draw (ORb.in 1) -- ++(-2.9,0)node[left]{$q$};
\draw (ORb.in 2) -- ++(-2.9,0)node[left]{$r$};
\draw (ORc.out) -- ++(4.0,0)node[near end,above]{$\left((\lnot p \lor \lnot r\right) \land \lnot q) \lor (\lnot p \land (q \lor r))$};

\end{tikzpicture}

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Satisfiability
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Satisfiability

* **Satisfiable** - when a compound proposition has an assignment of truth values to its variables that makes it true (i.e., it is a tautology or contingency)

\vskip.5em
\pause

* **Unsatisfiable** - when a compound proposition is false for all assignments of truth values to its variables
  - A proposition is only unsatisfiable if its negation is true for all assignments of truth values to its variables

\vskip.5em
\pause

* **Solution** - to a satisfiability problem is a particular assignment of truth values that makes a compound proposition true

# Satisfiability Examples

Determine whether the following compound propositions are satisfiable

\vskip.5em

- $\left(p \lor \lnot q\right) \land (q \lor \lnot r) \land (r \lor \lnot p)$
  \pause
  * We can reason about truth value, and with that we can see that this is true, as long as $p$, $q$, and $r$ all have the same truth value

\vskip1em
\pause

- $\left(p \lor q \lor r\right) \land (\lnot p \lor \lnot q \lor \lnot r)$
  \pause
  * Again we reason about truth values, and we can see that as long as one variable is true and another false, then this proposition is true

# Applications of Satisfiability

Satisfiability problems come into play in several areas

\vskip.5em

* Constraint satisfaction
  - \footnotesize Planning systems
  - \footnotesize Suduko
  - \footnotesize N-Queens problems

\vskip.5em

* Complexity Analysis and Theory

# Exercises


* \footnotesize Use the conditional-disjunction equivalence to find an equivalent compound proposition that does not involve conditionals

\centering

\small
$p \to \lnot q$
\pause
\scriptsize
\textcolor{Roarange}{
\begin{eqnarray*}
  p \to \lnot q & \equiv & \lnot p \lor \lnot q \,\,\,\textrm{by the conditional-disjunction equivalence}
\end{eqnarray*}}

\vskip1em
\pause

\small
$\left(p \to q\right) \to r$
\pause
\scriptsize
\textcolor{Roarange}{
\begin{eqnarray*}
    (p \to q) \to r & \equiv & \lnot (p \to q) \lor r \,\,\,\,\,\,\,\,\textrm{by the conditional-disjunction equivalence}\\
                    & \equiv & \lnot (\lnot p \lor q) \lor r \,\,\,\,\,\,\,\textrm{by the conditional-disjunction equivalence} \\
                    & \equiv & (\lnot \lnot p \land \lnot q) \lor r \,\,\,\textrm{by the second De Morgan's Law} \\
                    & \equiv & (p \land \lnot q) \lor r \,\,\,\,\,\,\,\,\,\,\,\textrm{by the Double Negation Law}
\end{eqnarray*}}

<!--
# Exercises

* \footnotesize Determine whether $\left(\lnot \land (p \to q)\right) \to \lnot q$ is a tautology

* \footnotesize Show that $\lnot (p \leftrightarrow q)$ and $p \leftrightarrow \lnot q$ are logically equivalent
-->

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Meta-Logic
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Meta-Logic

* **Meta-Logic:** concerned with stepping outside of the language of logic
  * Allows us to make statements about the properties of a logical system
  * Allows us to talk about logic rather than to simply use logic

\vskip.5em

* We looked at three methods of reasoning, each with different styles
  * Truth tables: enable the calculation of values (meanings) of propositions, yielding *semantic reasoning*
  * Inference rules allowed reasoning based on structure (*syntactic reasoning*)
  * Boolean algebra allowed for reasoning to prove equality of two expressions, or to calculate the values of expressions

# Meta-Logic

* To use meta-logic, we need a vocabulary

\vskip.5em

* Towards this, we have two notions of truth: *semantic* and *syntactic*, corresponding to the $\vDash$ and $\vdash$ operators, respectively
  * $P_1, P_2, \ldots, P_n \vdash Q$ means that there is a proof which infers $Q$ from the assumptions $P_1,P_2,\ldots,P_n$ using rules of inference and natural deduction.
  * $P_1,P_2,\ldots,P_n \vDash Q$ means that $Q$ must be True if $P_1,P_2,\ldots,P_n$ are all true, but it says nothing about whether we have proof or if one is possible.

# Meta-Logic

* **Consistent:** A formal system is consistent if the following statement is true for all WFFs $a$ and $b$:

  $\textsf{If }\,\, a \vdash b\,\,\textsf{ then }\,\, a \vDash b$

  * That is, the system is *consistent* if each proposition is provable using inference rules is *actually* true.

\vskip.5em

* **Complete:** A formal system is complete if the following statement is true for all WFFs $a$ and $b$:

  $\textsf{If }\,\, a \vDash b\,\, \textsf{ then }\,\, a \vdash b$

  * The system is complete if the inference rules are powerful enough to prove every proposition which is true

\vskip.5em

* **Theorem:** Propositional Logic is both consistent and complete

\vskip.5em

* **Godel's Theorem:** Any logical system powerful enough to express ordinary arithmetic must be either inconsistent or incomplete. Thus it is impossible to capture all of mathematics in a safe logical system.

# For Next Time

::: columns
:::: column
* Review DMUC Chapter 6.6 -- 6.10
* Review this Lecture
* Read Chapter 7
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
