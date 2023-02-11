---
author:
- Dr. Isaac Griffith
title: Predicate Logic
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Predicate Logic

* Often we need to reason about statements of the form:
  * *everything has the property $p$*
  * *something has the property $p$*

\vskip.5em

* However, propositional logic is not expressive enough to support such reasoning

\vskip.5em

* Predicate logic, an extension to propositional logic, adds *quantifiers* to allow this type of reasoning.
  * If also includes all the definitions, inference rules, theorems, algebraic laws, etc.

# Outline

::: columns
:::: {.column width=.7}
* Language of Predicate Logic
* Translating English to Logic
* Computing with Quantifiers
* Inference with Predicates
* Algebraic Laws of Predicate Logic
* Proof Concepts
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
\Huge Language of Predicate Logic
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Predicates

* **Predicate:** A statement that an object $x$ has a certain property
  * such statements may be either `True` or `False`
  * **Example:** `x > 5`

\vskip.5em

* Predicates may extend over multiple variables
  * **Example:** `x > y`

\vskip.5em

* Conditional expressions in programs are a form of predicate

\vskip.5em

* Predicates are typically written in the concise form $F(x)$
  * $F$ is the predicate, $x$ is the variable
  * $G(x,y)$ is a multivariate predicate
  * Can be thought of as a function that returns a Boolean

# Predicates

* Any term in the form $F(x)$, where $F$ is the predicate name and $x$ is a variable name, is a WFF
  * $F(x_1,x_2,\ldots,x_k)$ is a WFF that is a predicate with $k$ variables

\vskip.5em

* **Universe of Discourse (U)** - also called *universe*, is the set of possible values that the variables can have
  * Typically specified once, at the start of a piece of reasoning

\vskip.5em

* In predicate logic, the following standards apply
  * Universe is called $U$
  * Constants are lowercase letters (typically $c$ and $p$)
  * Variables are lowercase letters (typically $x$, $y$, $z$)
  * Predicates are uppercase letters, i.e., $F(x)$
  * Generic predicates start with a lowercase letter, i.e., $f(x)$

# Quantifiers

* **Universal Quantification ($\forall$):** If $F(x)$ is a WFF containing the variable $x$, then $\forall x.\,\, F(x)$ is a WFF
  * This is a statement that *everything* in the universe has a certain property
  * Says: "For all $x$ in the universe, the predicate $F(x)$ holds"
  * Used to state required properties

\vskip.5em

* **Existential Quantification ($\exists$):** If $F(x)$ is a WFF containing the variable $x$, then $\exists x.\,\, F(x)$ is a WFF
  * This is a statement that *something* in the universe has a certain property
  * Says: "Some $x$ has the property $F$"
  * Used to state a property must occur at least once

\vskip.5em

* **Note:** we can also nest quantifiers: $\forall x.\,\, \exists y.\,\, x < y$

# Quantifiers

* Let $U$ be the set of even numbers. Let $E(x)$ mean $x$ is even. Then,

  $\forall x.\,\, E(x)$ is a WFF that is true

\vskip.5em

* Let $U$ be the set of natural numbers. Let $E(x)$ mean $x$ is even, then

  $\forall x.\,\, E(x)$ is a WFF that is false

\vskip.5em

* Let $U$ be the set of natural numbers and $F(x, y)$ be $2x = y$, then
  * $\exists x.\,\, F(x, 6)$ is a WFF and is True
  * $\exists x.\,\, F(x, 7)$ is a WFF and is False

# Expanding Quantified Expressions

* If we have a finite universe
  * Quantified expressions can be interpreted as ordinary terms in propositional logic
  * The quantifiers simply act as syntactic abbreviations

    \vskip.5em

    Suppose: $U = \{c_1,c_2,\ldots,c_n\}$ (of size $n$), then

    \vskip.5em

    $\begin{array}{rclcl}
    \forall x.\,\, F(x) & = & F(c_1) \land F(c_2) \land \ldots \land F(c_n) & = & \overset{n}{\underset{i = 1}{\bigwedge}}F(c_i) \\ \\
    \exists x.\,\, F(x) & = & F(c_1) \lor F(c_2) \lor \ldots \lor F(c_n) & = & \overset{n}{\underset{i = 1}{\bigvee}}F(c_i)
    \end{array}$

  * Quantifiers make reasoning practical

\vskip.5em

* If we have an infinite universe
  * It is impossible to expand quantifiers

\vskip.5em

* All WFFs must have a finite size (even if the universe itself is infinite)

# Expanding Quantified Expressions

* Let $U = \{1,2,3\}$ with the following predicates

  $\begin{array}{rcl}
  even\,\,x & = & (x \mod 2 = 0) \\
  odd\,\,x  & = & (x \mod 2 = 1)
  \end{array}$

**Universal Expansion**

\footnotesize
$\begin{array}{l}
\forall x.\,\, (even\,\, x \to \lnot(odd\,\, x)) \\
\,\, = (even\,\, 1 \to \lnot(odd\,\,1)) \land (even\,\, 2 \to \lnot (odd\,\, 2)) \land (even\,\, 3 \to \lnot (odd\,\, 3)) \\
\,\, = (\textsf{False} \to \lnot \textsf{True}) \land (\textsf{True} \to \lnot \textsf{False}) \land (\textsf{False} \to \lnot \textsf{True}) \\
\,\, = \textsf{True} \land \textsf{True} \land \textsf{True} \\
\,\, = \textsf{True}
\end{array}$

**Existential Expansion**

\footnotesize
$\begin{array}{l}
\exists x.\,\, (even\,\, x \land odd\,\, x) \\
\,\, = (even\,\, 1 \land odd\,\,1) \lor (even\,\, 2 \land odd\,\, 2) \lor (even\,\, 3 \land odd\,\, 3) \\
\,\, = (\textsf{False} \land \textsf{True}) \lor (\textsf{True} \land \textsf{False}) \lor (\textsf{False} \land \textsf{True}) \\
\,\, = \textsf{False} \lor \textsf{False} \lor \textsf{False} \\
\,\, = \textsf{False}
\end{array}$

# Exercises

* Let $U = \{1,2,3\}$, expand the following expression into propositional term
  * $\forall x.\,\, F(x)$

    \vskip.5em
    \only<2>{
    \textcolor{Roarange}{
    $\begin{array}{l}
    \forall x.\,\, F(x) \\
    \,\,= F(1) \land F(2) \land F(3)
    \end{array}$
    }}

  * $\exists x.\,\, \forall y.\,\, G(x, y)$

    \vskip.5em
    \only<2>{
    \textcolor{Roarange}{
    $\begin{array}{l}
    \exists x.\,\, G(x, y) \\
    \,\,= G(1,1) \lor G(1,2) \lor G(1,3) \lor G(2,1) \lor G(2,2) \lor G(2,3) \lor G(3,1) \lor G(3,2) \lor G(3,3)
    \end{array}$
    }}

\vskip.5em

* Expand the following expression

  $\forall x \in \{1,2,3,4\}.\,\, \exists y \in \{5,6\}.\,\, F(x, y)$

  \vskip.5em
  \only<2>{
  \textcolor{Roarange}{
  $\begin{array}{l}
  \forall x.\,\, \exists y.\,\, F(x, y) \\
  \,\,= (F(1,5) \lor F(1,6)) \land (F(2,5) \lor F(2,6)) \land (F(3,5) \lor F(3,6)) \land (F(4,5) \lor F(4,6))
  \end{array}$
  }}

# Variable Bindings

* **Binding:** Quantifiers *bind* variables by assigning them values from a universe
  * **Dangling expressions:** expressions without explicit quantification have no explicit binding: $x + 2$

\vskip.5em

* **Scope:** Extent of a binding
  * Convention: Quantifiers extend over the smallest sub-expression possible. So use parentheses to make meaning clear.

\vskip.5em

* **Example**: $\forall x,y.\,\, (p(x) \to q (x, y)) \land r(z)$
  * $x$, $y$ are bound
  * $z$ is free
  * All are in the scope of $\forall x,y$ except $r(z)$
  * $r(z)$ is a dangling expression

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Translating English to Logic
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# English $\to$ Logic

* When an English statement has no internal structure relevant to reasoning, we can use simple propositional variables:

  \vskip.5em
  \begin{center}
  $\begin{array}{rcl}
  A & \equiv & \textsf{Elephants are big.} \\
  B & \equiv & \textsf{Cats are furry.} \\
  C & \equiv & \textsf{Cats are good pets.}
  \end{array}$
  \end{center}

\vskip.5em

* We can combine statements using the operators corresponding to connective words.

  \vskip.5em
  \begin{center}
  $\begin{array}{rcl}
  \lnot A  & \equiv & \textsf{Elephants are small.} \\
  A \lor B & \equiv & \textsf{Elephants are big and cats are furry.} \\
  B \to C  & \equiv & \textsf{If cats are furry then they make good pets.}
  \end{array}$
  \end{center}

# English $\to$ Logic

* However, when general statements are made about classes of objects, then predicates and quantifiers are needed

\vskip.5em

* For example, these statements are difficult to model with propositional logic:

  \vskip.5em
  \begin{center}
  $\begin{array}{rcl}
  A & \equiv & \textsf{Small animals are good pets.} \\
  C & \equiv & \textsf{Cats are animals.} \\
  S & \equiv & \textsf{Cats are small.}
  \end{array}$
  \end{center}

\vskip.5em

* This leads to weak conclusions such as:
  * $A \land C$
  * $S \lor A$

# English $\to$ Logic

* However, we can model the internal structure of these statements using predicates:

  \vskip.5em
  \begin{center}
  $\begin{array}{rcl}
  A(x)  & \equiv & x\,\,\textsf{is an animal.} \\
  C(x)  & \equiv & x\,\,\textsf{is a cat.} \\
  S(x)  & \equiv & x\,\,\textsf{is small.} \\
  GP(x) & \equiv & x\,\,\textsf{is a good pet.}
  \end{array}$
  \end{center}

\vskip.5em

* Using these we can produce the following richer translations of the english statements:

  \vskip.5em
  \begin{center}
  $\begin{array}{rcl}
  \forall x.\,\,C(x) \to A(x)             & \equiv & \textsf{Cats are animals.} \\
  \forall x.\,\,C(x) \to S(x)             & \equiv & \textsf{Cats are small.} \\
  \forall x.\,\,C(x) \to S(x) \land A(x)  & \equiv & \textsf{Cats are small animals.} \\
  \forall x.\,\,S(x) \land A(x) \to GP(x) & \equiv & \textsf{Small animals are good pets.}
  \end{array}$
  \end{center}

\vskip.5em

* Often the difficulty in translating English to Logic is found in determining what the original speaker meant to say.

#

\centering
\vfill
\begin{minipage}{.715\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Computing with Quantifiers
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Computing w/ Quantifiers

* If the universe is finite, we can utilize computers to evaluate quantified expressions

\vskip.5em

* In the context of Haskell,
  * A *predicate* is a function returning a Boolean value
  * The `forall` function
    * takes in an `Int` list, representing the universe, and a predicate
    * it applies the predicate to each item in the universe and returns the results

    ```haskell
    forall :: [Int] -> (Int -> Bool) -> Bool
    ```

    * uses the `and` function
  * Similarly, the `exists` function
    * applies the `or` function

    ```haskell
    exists :: [Int] -> (Int -> Bool) -> Bool
    ```

\vskip.5em

* Both `forall` and `exists` are defined in the `Stdm` module

# Exercises

* Write the predicate logic expressions corresponding to the following Haskell expressions. Then decide whether the value is `True` or `False`, and finally evaluate each using a computer.

  ```haskell
  forall [1, 2, 3] (==2)
  ```

  \vskip.5em
  \only<2>{
  \textcolor{Roarange}{
  \textbf{Solution:}
  \vskip.25em
  $\forall x \in [1,2,3].\,\, x = 2$
  \vskip.25em
  \textbf{\texttt{False}}
  }}

  \vskip.5em

  ```haskell
  exists [1, 2, 3] (<= 5)
  ```

  \vskip.5em
  \only<2>{
  \textcolor{Roarange}{
  \textbf{Solution:}
  \vskip.25em
  $\exists x \in [1,2,3].\,\, x \leq 5$
  \vskip.25em
  \textbf{\texttt{True}}
  }}

#

\centering
\vfill
\begin{minipage}{.665\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Inference with Predicates
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Inference w/ Predicates

* Inference rules can be extended to predicate logic

\vskip.5em

* An additional four rules are required for dealing with quantifiers

\vskip.5em

* As noted before, if the universe if finite quantification acts as propositions

\vskip.5em

* However, if the universe is infinite, the inference rules of predicate logic allow deductions that are otherwise impossible with propositional logic.

# Universal Introduction $\{\forall I\}$

::: columns
:::: column

**Rule:**

\begin{prooftree}
\AxiomC{$F(x)$}
\AxiomC{$\{\textrm{x arbitrary}\}$}
  \RightLabel{\scriptsize $\{\forall I\}$}
  \BinaryInfC{$\forall x.\,\, F(x)$}
\end{prooftree}

::::
:::: column
::::
:::

\vspace{2em}

::: columns
:::: column

**Meaning:**

* If the expression $a$ (which may contain a variable $x$) can be proved for an *arbitrary $x$*, then we may infer the proposition $\forall x.\,\, a$

::::
:::: column

**Example:** $\vdash \forall x.\,\, E(x) \to (E(x) \lor \lnot E(x))$

\begin{prooftree}
\AxiomC{$\cancel{E(p)}$}
  \RightLabel{\scriptsize $\{\lor I_L\}$}
  \UnaryInfC{$E(p) \lor \lnot E(p)$}
    \RightLabel{\scriptsize $\{\to I\}$}
    \UnaryInfC{$E(p) \to E(p) \lor \lnot E(p)$}
      \RightLabel{\scriptsize $\{\forall I\}$}
      \UnaryInfC{$\forall x.\,\, E(x) \to E(x) \lor \lnot E(x)$}
\end{prooftree}

::::
:::

# Universal Elimination $\{\forall E\}$

::: columns
:::: column

**Rule:**

\begin{prooftree}
\AxiomC{$\forall x.\,\, F(x)$}
  \RightLabel{\scriptsize $\{\forall E\}$}
  \UnaryInfC{$F(p)$}
\end{prooftree}

::::
:::: column
::::
:::

\vspace{2em}

::: columns
:::: column

**Meaning:**

* If we have established $\forall x.\,\, F(x)$ and $p$ is an element of the universe, then you can infer $F(p)$

::::
:::: column

**Example:** $\forall x.\,\, F(x) \to G(x) \vdash G(p)$

\begin{prooftree}
\AxiomC{$F(p)$}
\AxiomC{$\forall x.\,\, F(x) \to G(x)$}
  \RightLabel{\scriptsize $\{\forall E\}$}
  \UnaryInfC{$F(p) \to G(p)$}
    \RightLabel{\scriptsize $\{\to E\}$}
    \BinaryInfC{$G(p)$}
\end{prooftree}

::::
:::

# Exercises

* Prove: $\forall x.\,\, F(x),\,\,\forall x.\,\, F(x) \to G(x) \vdash \forall x.\,\,G(x)$

  \vskip.5em
  \only<2>{
  \textcolor{Roarange}{
  \textbf{Solution:}}
  \vskip.25em

  \begin{prooftree}
  \AxiomC{$\forall x.\,\, F(x)$}
    \RightLabel{\scriptsize $\{\forall E\}$}
    \UnaryInfC{$F(p)$}
  \AxiomC{$\forall x.\,\, F(x) \to G(x)$}
    \RightLabel{\scriptsize $\{\forall E\}$}
    \UnaryInfC{$F(p) \to G(p)$}
      \RightLabel{\scriptsize $\{\to E\}$}
      \BinaryInfC{$G(p)$}
  \AxiomC{$\{\textrm{arbitrary p}\}$}
    \RightLabel{\scriptsize $\{\forall I\}$}
    \BinaryInfC{$\forall x.\,\, G(x)$}
  \end{prooftree}
  }

# Existential Introduction $\{\exists I\}$

::: columns
:::: column

**Rule:**

\begin{prooftree}
\AxiomC{$f(p)$}
  \RightLabel{\scriptsize $\{\exists I\}$}
  \UnaryInfC{$\exists x.\,\, f(x)$}
\end{prooftree}

::::
:::: column
::::
:::

\vspace{2em}

::: columns
:::: column

**Meaning:**

* If $f(p)$ has been established for a particular $p$, then you can infer $\exists x.\,\, f(x)$

::::
:::: column

**Example:** $\forall x.\,\, F(x) \vdash \exists x.\,\, F(x)$

\begin{prooftree}
\AxiomC{$\forall x.\,\, F(x)$}
  \RightLabel{\scriptsize $\{\forall E\}$}
  \UnaryInfC{$F(p)$}
    \RightLabel{\scriptsize $\{\exists I\}$}
    \UnaryInfC{$\exists x.\,\, F(x)$}
\end{prooftree}

::::
:::

# Existential Elimination $\{\exists E\}$

::: columns
:::: column

**Rule:**

\begin{prooftree}
\AxiomC{$\exists x.\,\, F(x)$}
\AxiomC{$F(x) \vdash A$}
\AxiomC{$\{x\,\,\textrm{arbitrary}\}$}
  \RightLabel{\scriptsize $\{\exists E\}$}
  \TrinaryInfC{$A$}
\end{prooftree}

::::
:::: column
::::
:::

\vspace{2em}

::: columns
:::: column

**Meaning:**

* If we know $\exists x.\,\, F(x)$ holds for some $x$, and furthermore that $A$ must hold if $F(x)$ holds for *arbitrary $x$*, then $A$ can be inferred.

::::
:::: column

**Example:** $\exists x.\,\, P(x),\,\, \forall x.\,\, P(x) \to Q(x) \vdash \exists x.\,\, Q(x)$

\begin{prooftree}
\AxiomC{$\exists x.\,\, P(x)$}
\AxiomC{$\cancel{P(c)}$}
\AxiomC{$\forall x.\,\, P(x) \to Q(x)$}
  \RightLabel{\scriptsize $\{\forall E\}$}
  \UnaryInfC{$P(c) \to Q(c)$}
    \RightLabel{\scriptsize $\{\to E\}$}
    \BinaryInfC{$Q(c)$}
      \RightLabel{\scriptsize $\{\exists E\}$}
      \BinaryInfC{$Q(c)$}
        \RightLabel{\scriptsize $\{\exists I\}$}
        \UnaryInfC{$\exists x.\,\,Q(x)$}
\end{prooftree}

::::
:::

# Exercises

* Prove: $\exists x.\,\, \exists y.\,\, F(x,y) \vdash \exists y.\,\, \exists x.\,\, F(x,y)$

  \only<2>{
  \vskip.5em
  \textbf{Solution:}
  \vskip.5em
  \begin{prooftree}
  \AxiomC{$\exists x.\,\, \exists y.\,\, F(x,y)$}
  \AxiomC{$\cancel{\exists y.\,\, F(p, y)}$}
    \RightLabel{\scriptsize $\{\exists E\}$}
    \UnaryInfC{$F(p,q)$}
      \RightLabel{\scriptsize $\{\exists I\}$}
      \UnaryInfC{$\exists x.\,\,F(x, q)$}
        \RightLabel{\scriptsize $\{\exists I\}$}
        \UnaryInfC{$\exists y.\,\, \exists x.\,\,F(x, y)$}
          \RightLabel{\scriptsize $\{\exists E\}$}
          \BinaryInfC{$\exists y.\,\, \exists x.\,\, F(x,y)$}
  \end{prooftree}
  }

#

\centering
\vfill
\begin{minipage}{.875\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Algebraic Laws of Predicate Logic
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Algebraic Laws

* Just as with propositional logic, we have an alternate style of reasoning based on a set of algebraic laws
  * All previous propositional laws apply, as well as new ones we will discuss

\vskip.5em

* Not a minimal, nor a complete set of laws
  * Some correspond to inference rules
  * Some are provable as theorems

\vskip.5em

* Here, we focus on practical use, rather than theoretical foundations

# Algebraic Laws

* These laws are related to rules of inference

\vskip.5em

**Laws:**

\vskip.5em

$\begin{array}{rclr}
\forall x.\,\, f(x) & \to & f(c)            & (7.3) \\
f(c)                & \to & \exists x.\,\, f(x) & (7.4)
\end{array}$

\vskip1em

::: columns
:::: column

**Where:**

* $x$ is bound by the quantifier
* $c$ is a fixed element in the universe

::::
:::: column

**Example:**

* Prove: $\forall x.\,\, f(x) \to \exists x.\,\, f(x)$

  $\begin{array}{rlr}
  \forall x. & f(x) & \\
             & \to f(c)            & \{7.3\} \\
             & \to \exists x.\,\, f(x) & \{7.4\}
  \end{array}$

::::
:::

# Algebraic Laws

* These laws focus on the effects of negation on quantifiers

\vskip.5em

**Laws:**

\vskip.5em

$\begin{array}{rclr}
\forall x.\,\, \lnot f(x) & = & \lnot \exists x.\,\, f(x) & (7.5) \\
\exists x.\,\, \lnot f(x) & = & \lnot \forall x.\,\, f(x) & (7.6) \\
\end{array}$

# Algebraic Laws

* These laws are concerned with how a predicate $f(x)$ combines with a proposition $q$ that does not contain $x$

\vskip.5em

**Laws:**

\vskip.5em

$\begin{array}{rclr}
\left(\forall x.\,\, f(x)\right) \land q & = & \forall x.\,\, \left(f(x) \land q\right) & (7.7) \\
\left(\forall x.\,\, f(x)\right) \lor q  & = & \forall x.\,\, \left(f(x) \lor q \right) & (7.8) \\
\left(\exists x.\,\, f(x)\right) \land q & = & \exists x.\,\, \left(f(x) \land q\right) & (7.9) \\
\left(\exists x.\,\, f(x)\right) \lor q  & = & \exists x.\,\, \left(f(x) \lor q \right) & (7.10)
\end{array}$

# Algebraic Laws

* These laws concern the combination of quantifiers with $\land$ and $\lor$

\vskip.5em

**Laws:**

\vskip.5em

$\begin{array}{rclr}
\forall x.\,\, f(x) \land \forall x.\,\, g(x)     & =   & \forall x.\,\, \left(f(x) \land g(x)\right) & (7.11) \\
\forall x.\,\, f(x) \lor  \forall x.\,\, g(x)     & \to & \forall x.\,\, \left(f(x) \lor g(x)\right)  & (7.12) \\
\exists x.\,\, \left(f(x) \land g(x)\right) & \to & \exists x.\,\, f(x) \land \exists x.\,\, g(x)      & (7.13) \\
\exists x.\,\, f(x) \lor  \exists x.\,\, g(x)     & =   & \exists x.\,\, \left(f(x) \lor g(x)\right)  & (7.14)
\end{array}$

# Examples

* Prove: $\forall x.\,\, \left(f(x) \land \lnot g(x) \right) = \forall x.\,\, f(x) \land \lnot \exists x.\,\, g(x)$

\vskip.5em

  \begin{center}
  $\begin{array}{rlr}
  \forall x.\,\, & \left(f(x) \land \lnot g(x)\right)                  & \\
               = & \forall x.\,\, f(x) \land \forall x.\,\, \lnot g(x) & \{7.11\} \\
               = & \forall x.\,\, f(x) \land \lnot \exists x.\,\, g(x) & \{7.5\}
  \end{array}$
  \end{center}

\vskip.5em

* Prove: $\exists x.\,\, \left(f(x) \to g(x)\right) \land \left(\forall x.\,\, f(x)\right) \to \exists x.\,\, g(x)$

\vskip.5em

  \begin{center}
  $\begin{array}{rlr}
  \exists x. & \left(f(x) \to g(x)\right) \land \left(\forall x.\,\, f(x)\right)       & \\
           = & \left(\exists x.\,\, (f(x) \to g(x))\right) \land (\forall y.\,\, f(y)) & \textrm{change of var} \\
           = & \exists x.\,\, ((f(x) \to g(x)) \land (\forall y.\,\, f(y)))            & \{7.9\} \\
           = & \exists x.\,\, ((f(x) \to g(x)) \land f(x))                             & \{7.3\} \\
         \to & \exists x.\,\, g(x)                                                     & \{Modus Ponens\}
  \end{array}$
  \end{center}

# Mathematical Arguments

* Often include steps where both a rule of inference for propositions and a rule of inference for quantifiers are used.

\vskip.5em

* For example, universal instantiation and *modus ponens* are often used together

\vskip.5em

* When these rules of inference are combined, for example:
  - $\forall x.\,\, (P(X) \to Q(x))$
  - $P(x)$ // where $c$ is a member of the universe of discourse
  - $Q(x)$

#

\centering
\vfill
\begin{minipage}{.425\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Proof Concepts
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Methods of Proving Theorems

* Direct Proof
* Indirect Proofs
  - Proof by contraposition
  - Vacuous and trivial proofs
  - Proof by contradiction

# Direct Proofs

* **Example:** Prove that "if $n$ is an odd integer, then $n^2$ is an odd integer"

  - **Proof:**

    $n$ is odd $\to$ $n = 2k + 1$

    $n^2 = (2k + 1)^2 = 4k^2 + 4k + 1 = 2k(2k + 2) + 1$ which is odd

\vskip.5em

* **Example:** Prove that the sum of two rational numbers is rational
  - rational number $= p/q\,\,(q \ne 0)$
  - **Proof:**

    $\begin{array}{rcl}
     r & = & \frac{p}{q}\,\,(q \ne 0) \\
     s & = & \frac{t}{u}\,\,(u \ne 0) \\
     r + s & = & \frac{p}{q} + \frac{t}{u} = \frac{pu + tq}{qu}
     \end{array}$

    which is rational.

# Indirect Proofs

* Proof by contraposition

\vskip.5em

* Vacuous and Trivial Proofs

\vskip.5em

* Proof by contradiction

# Proof by Contraposition

* Based on the idea: $p \to q \equiv \lnot q \to \lnot p$

\vskip.5em

* Makes use of the fact that the conditional statement $p \to q$ is equivalent to $\lnot q \to \lnot p$

\vskip.5em

* The first step is to take $\lnot q$ as a hypothesis and then using axioms, statements we assume to be true, definitions, and previously proven theorems together with rules of inference, we show that $\lnot p$ must follow.

\vskip.5em

::: columns
:::: column

* **Example:** prove that "if $3n + 2$ is odd, then $n$ is odd"

  - **Proof:** Suppose $n$ is even. Then $n = 2k$

    $3n + 2 = 3(2k) + 2 = 6k + 2 = 2(3k + 1)$ which is even

    $\therefore$ by contraposition if, $3n + 2$ is odd, then $n$ is odd.

::::
:::: column

* **Example:** prove that if $n^2$ is odd, then $n$ is odd

  - **Proof:** Suppose $n$ is even. Then $n = 2k$

    $n^2 = (2k)^2 = 4k^2 = 2(2k)$ which is even

::::
:::

# Vacuous and Trivial Proofs

* **Vacuous Proofs:** if we can show that $q$ is false, then, $p \to q$ will always be true.

\vskip.5em

* **Trivial Proofs:** we can quickly prove $p \to q$ if we know $q$ is true.

# Proof by Contradiction

::: columns
:::: column

* Suppose we want to show that a statement $p$ is true

\vskip.5em

* Suppose we can find a contradiction $q$ such that $\lnot p \to q$ is true

\vskip.5em

* Because $q$ is false, but $\lnot p \to q$ is true, we can conclude $\lnot p$ is false and therefore $p$ is true

\vskip.5em

* How to find the contradiction $q$ to help us in this way:
  - Because the statement $r \wedge \lnot r$ is a contradiction if $r$ is a proposition, we can prove that $p$ is true if we can show that $\lnot p \to (r \wedge \lnot r)$ is true for some proposition $r$

::::
:::: column

* **Example:** Prove that $\sqrt{2}$ is irrational

  - **Proof:** Suppose that $\sqrt{2}$ is rational

    Then: $\sqrt{2} = \frac{a}{b}$ where $a$ and $b$ have no common factor

    square both sides: $2 = \frac{a^2}{b^2}$

    $2b^2 = a^2 \to a$ is even

    $a = 2c$

    $\therefore 2b^2 = 4c^2$

    $b^2 = 2c^2 \to b$ is even

    $\therefore$ The assumption that $a$ and $b$ have no common factor is false so there is a contraction $\to \sqrt{2}$ is irrational.

::::
:::

# Proof Methods and Strategy

* Exhaustive proofs

\vskip.5em

* Proof-by-cases

\vskip.5em

* Existence Proofs

\vskip.5em

* Uniqueness Proofs

# Exhaustive Proof and Proof-by-cases

* There are times when we cannot prove a theorem using a single argument that holds for all cases.

\vskip.5em

* By considering different cases separately we can prove a theorem.

\vskip.5em

* This is based on the following rule of inference:

  $\left(p_1 \vee p_2 \vee p_3 \vee \ldots \vee p_n\right) \to q$

  \vskip.5em

  The tautology: $[(p_1 \vee p_2 \vee \ldots \vee p_n) \to q] \leftrightarrow [(p_1 \to q) \wedge (p_2 \to q) \wedge \ldots \wedge (p_n \to q)]$

# Exhaustive Proof

* Can be proved by examining a relatively small number of examples.

\vskip.5em

* Called exhaustive proof, since these proofs proceed by exhausting all possibilities

\vskip.5em

* It is a special case of proof-by-cases where each case involves checking a single example

# Proof-by-Cases

* Must cover all possible cases that arise in a theorem

\vskip.5em

* Generally, we look for a proof-by-cases when there is no obvious way to begin a proof

\vskip.5em

* **Without Loss of Generality (WLOG)**
  - Used in a proof, we assert that by proving one case of a theorem, no additional argument is required to prove other specified cases

# Existence Proofs

* Many theorems are assertions that objects of a particular type exists

\vskip.5em

* Such a theorem is a proposition of the form $\exists x.\,\, P(x)$, where $P$ is a predicate

\vskip.5em

* Proving this proposition is called an **existence proof**

\vskip.5em

* An existence proof of the form $\exists x.\,\, P(x)$ can be given by finding an element, $a$, such that $P(a)$ is true. This type of existence proof is called
a **constructive proof**.

\vskip.5em

* It is also possible to give a **non-constructive proof**.
  - That is we do not find an element $a$ such that $P(a)$ is true, but rather prove that $\exists x.\,\, P(x)$ is true in some other way.

# Uniqueness Proofs

* Some theorems assert the existence of a unique element with a particular property (one element with this property)

\vskip.5em

* To prove this we need to show that an element with this property exists and that no other element has this property.

\vskip.5em

* The two parts of a **uniqueness proof** are:
  - **Existence:** we show that an element $x$ with the desired property exists.
  - **Uniqueness:** we show that if $y \ne x$, then $y$ does not have the desired property.

\vskip.5em

* Equivalently we can show that if $x$ and $y$ both have the desired property, then $x = y$

\vskip.5em

* This is the equivalent (proving the uniqueness proof) of proving the statement:

  $\exists x.\,\, (P(x) \wedge \forall y.\,\, (y \ne x \to \lnot P(y)))$

# For Next Time

::: columns
:::: column
* Review DMUC Chapter 7
* Review this Lecture
* Read DMUC Chapter 8
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
