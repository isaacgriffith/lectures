---
author:
- Dr. Isaac Griffith
title: Set Theory
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Inspiration

> "The subject for which I am asking your attention deals with the foundations of mathematics. To understand the development of the opposing theories existing in this field one must first gain a clear understnding of the concept "science"; for it is as a part of science that mathematics originally took its place in human thought." -- L. E. J. Brouwer

# Set Theory

* **Set Theory:** One of the fundamental branches of mathematics

\vskip.5em

* Has a deep connection to Logic, as we'll see

\vskip.5em

* The notation and terminology is quite useful for describing both *data types* and *algorithms*

# Outline

The lecture if structured as follows:

::: columns
:::: {.column width=.7}
* Set Notation
* Set Operations
* Finite Sets with Equality
* Set Laws (Identities)
* Proofs with Sets
* Advanced Concepts
::::
:::: {.column width=.25}
\vfill
\vspace{7.25em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Set Notation
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Set Notation

* A **set** is a collection of objects called *members* or *elements*

\vskip.5em

* We can describe a set simply by listing all of its elements between branches $\{\ldots\}$, this is called the **roster method**
  * **Example:**

    $\begin{array}{rcl}
    A & = & \{\textrm{dog},\,\textrm{cat},\,\textrm{horse}\} \\
    C & = & \{0,1,2,3,4\} \\
    E & = & \{\} \\
    N & = & \{0,1,2,3,\ldots\}
    \end{array}$

\vskip.5em

* An element may only occur once in a given set
  * Thus, we can test membership using the membership operator $\in$ which returns `True` or `False`
  * Similarly, we can test lack of membership with the not a member operator $\notin$
  * **Examples:**

    $\begin{array}{rcl}
    \textrm{dog} \in A    & = & True \\
    \textrm{dog} \notin A & = & False
    \end{array}$

# Set Notation

::: columns
:::: column

* Sets can have any number of elements
  * $A$ has 3 elements
  * $C$ has 5 elements
  * $E$ has 0 elements
  * $N$ has infinite elements

\vskip.5em

* The empty set, $\{ \}$, is special and is denoted as $\varnothing$

\vskip.5em

* Sets tend to be denoted using a capital letter or as block font (i.e., $\mathbb{S}$)

::::
:::: column

**Some Important Sets**

* $\mathbb{N} = \{0,1,2,3,\ldots\}$, the set of natural numbers
* $\mathbb{Z} = \{\ldots,-2,-1,0,-1,-2,\ldots\}$, the set of all integers
* $\mathbb{Z}^+ = \{1,2,3,\ldots\}$, the set of all positive integers
* $\mathbb{Q} = \{p/q\,\, |\,\, p \in \mathbb{Z}, q \in \mathbb{Z}, q \neq 0\}$, the set of all rational numbers
* $\mathbb{R}$ = the set of real numbers
* $\mathbb{Q}^+ \{x \in \mathbb{R}^+\,\, |\,\, x = \frac{p}{q},$ for some positive integers $p, q\}$, the set of positive rational numbers
* $\mathbb{R}^+$, the set of positive real numbers
* $\mathbb{C}$, the set of all complex numbers

::::
:::

# Set Notation

* Another standard method of set notation is the **set comprehension** or **set builder** notation
  * In its simplest form, it is written as:

    \begin{equation*}
    \{x\,\, |\,\, p\,\, x\}
    \end{equation*}

    Where:
      * **$p x$** is a predicate, which defines those items to be included
      * **Read as:** "The set of $x$ such that $p x$"
  * **General Form:**

    \begin{equation*}
    \{f\,\, x\,\, |\,\, p\,\, x\}
    \end{equation*}

    - Set contains values of the results of applying $f$ to those values which satisfy $p\,\, x$

\vskip.5em

* **Example:**
  * Set of even numbers $\{x\,\, |\,\, x \in \mathbb{N} \land even\,\, x\}$

# Set Notation

* In calculus, we study sets called **intervals**, which are sets of real numbers between two numbers $a$ and $b$, and may include/exclude $a$ and $b$.

\vskip.5em

* If $a, b \in \mathbb{R} \land a \leq b$, we denote these intervals by:

\begin{center}
$\begin{array}{rc clcl}\label{x}
& [a,b] & = & \{x\,\, |\,\, a \leq x \leq b \} & \Rightarrow & \textrm{closed interval} \\
& [a,b) & = & \{x\,\, |\,\, a \leq x < b \} & & \\
& (a,b] & = & \{x\,\, |\,\, a < x \leq b \} & & \\
& (a,b) & = & \{x\,\, |\,\, z < x < b \} & \Rightarrow & \textrm{open interval}
\end{array}$
\end{center}

\vskip.5em

* In CS, the concept of a *data type* or *type* is based on the set concept
  * **Data type** or **type** is the name of a set, together with a set of operations that can be performed on objects of that set.

  * **Example:** Boolean = {True, False} together with the operators $\land, \lor, \to, \leftrightarrow, \lnot$

# Venn Diagrams

* A graphic notation for sets named after John Venn who introduced these diagrams in 1881

\vskip.5em

* Starts with a rectangle labeled $U$, which represents the **universal set** that contains all objects under consideration

\vskip.5em

* Inside the rectangle we use shapes, typically circles or ellipses, to represent sets

\vskip.5em

* Inside sets, we can use points to show specific members


# Subsets

* **Subset:** the set $A$ is a *subset* of $B$, and $B$ is a *superset* of $A$, iff every element of $A$ is also an element of $B$

\begin{center}
$\begin{array}{rcl}
A \subseteq B & - & \textrm{A is a subset of B} \\
B \supseteq A & - & \textrm{B is a superset of A} \\
A \subseteq B & \equiv & B \supseteq A \\
A \subseteq B & \leftrightarrow & \forall\,\,x. \,\, (x \in A \to x \in B)
\end{array}$
\end{center}

\vskip.5em

::: columns
:::: {.column width=.7}

* To show that $A$ is a subset of $B$
  * Show that if $x$ belongs to $A$, then $x$ also belongs to $B$

\vskip.5em

* To show that $A$ is not a subset of $B$
  * To show $A \nsubseteq B$, find a single $x \in A$ such that $x \notin B$

\vskip.5em

* For every set $S$:
  * $\varnothing \subseteq S$
  * $S \subseteq S$

::::
:::: {.column width=.3}

\centering

\begin{tikzpicture}[thick,
    set/.style = {circle,
        minimum size = 2cm}]

\draw[draw=white,thick] (-1.5,-1.2) rectangle (1.5,1.4);

% Set B
\node[set,fill=DarkGrey,label={[white]135:$B$},DarkGray] (B) at (0,0) {};

% Circles outline
\draw (0,0) circle(1cm);

\draw (0,0) circle(.5cm);

\node[Roarange] at (1.2,1.2) {$U$};

\node[white] at (0,0) {$A$};

\end{tikzpicture}

::::
:::

# Set Equality

* **Set Equality:** To show that two sets $A$ and $B$ are equal, show that $A \subseteq B$ and $B \subseteq A$

\vskip.5em

* If we have two sets $A$ and $B$, where $A$ is a subset of $B$ but where $A \neq B$, then we call $A$ a **proper subset** of $B$, denoted as:

  \begin{equation*}
  A \subset B
  \end{equation*}

  For $A \subset B$ to be true, then

  \begin{equation*}
  \forall\,\, x.\,\, (x \in A \to x \in B) \land \exists\,\,x.\,\, (x \in B \land x \notin A)
  \end{equation*}

\vskip.5em

* **Note:** Sets may also contain other sets as members

  $A = \{\varnothing, \{a\}, \{b\}, \{a, b\}\}$ and $B = \{x\,\, |\,\, x \subseteq \{a,b\}\}$

  $A = B$

# Cardinality

* **Cardinality:** Let $S$ be a set. If there are exactly $n$ distinct elements in $S$ where $n$ is a nonnegative integer, we say $S$ is a **finite set** and that $n$ is the **cardinality** of $S$.
  * We denote the cardinality of a set $S$ as: $|S|$

\vskip.5em

* **Example:**
  * The set, $A$, of odd positive integers < 10. $|A| = 5$
  * The set, $S$, of letters in the English alphabet. $|S| = 26$
  * The empty set. $|\varnothing| = 0$

\vskip.5em

* A set is said to be **infinite** if it is not finite.
  * $\mathbb{Z}^+$ is infinite

# Power Sets

* **Powerset:** Let $A$ be a set. The *powerset*, written $\mathcal{P}(A)$, is the set of all subsets of $A$:

  \begin{equation*}
  \mathcal{P}(A) = \{s\,\, |\,\, s \subseteq A\}
  \end{equation*}

\vskip.5em

* **Examples:**
  * $\mathcal{P}(\varnothing) = \{\varnothing\}$
  * $\mathcal{P}(\{a\}) = \{\varnothing, \{a\}\}$
  * $\mathcal{P}(\{a,b\}) = \{\varnothing, \{a\}, \{b\}, \{a, b\}\}$
  * $\mathcal{P}(\{a,b,c\}) = \{\varnothing, \{a\}, \{b\}, \{c\}, \{a,b\}, \{a,c\}, \{b,c\}, \{a,b,c\}\}$

\vskip.5em

* If $|A| = n$, then $|\mathcal{P}(A)| = 2^n$

# Cartesian Products

* Often order of elements is important, but sets are unordered, so we often need something else

\vskip.5em

* **Ordered n-tuple:** $\left(a_1,a_2,\ldots,a_n\right)$ is an ordered collection that has $a_1$ as its first element, $a_2$ as its second element, $\ldots$, and $a_n$ as its $n^{th}$
  * we say two ordered n-tuples are equal iff each corresponding pair is equal
  * Ordered 2-tuples are called **ordered pairs**
    * The ordered pairs $\left(a,b\right)$ and $\left(c,d\right)$ are equal iff $a = b$ and $c = d$

\vskip.5em

* **Cartesian Product:** Let $A$ and $B$ be sets. The *cartesian product* of $A$ and $B$, denoted $A \times B$, is the set of all ordered pairs $\left(a,b\right)$, where $a \in A$ and $b \in B$

  \begin{equation*}
  A \times B = \{(a, b)\,\, |\,\, a \in A \land b \in B\}
  \end{equation*}

\vskip.5em

* **Example:** $A = \{1,2\}$, $B = \{a,b,c\}$

  $A \times B = \{(1,a),(1,b),(1,c),(2,a),(2,b),(2,c)\} \Rightarrow$ The $zip$ function comes to mind

# Cartesian Products

* The **cartesian product** of the sets $A_1, A_2, \ldots, A_n$, denoted by $A_1 \times A_2 \times \ldots \times A_n$, is the set of ordered n-tuples $\left(a_1,a_2,\ldots,a_n\right)$, where $a_i$ belongs to $A_i$ for $i = 1, 2, \ldots, n$

\begin{equation*}
A_1 \times A_2 \times \ldots \times A_n = \{(a_1,a_2,\ldots,a_n)\,\, |\,\, a_i \in A_i \textrm{ for } i = 1,2,\ldots,n\}
\end{equation*}

\vskip.5em

* **Example:** $A = \{0, 1\}$, $B = \{1, 2\}$, $C = \{0, 1, 2\}$

  $\begin{array}{rcl}
  A \times B \times C & = & \{(0,1,0),(0,1,1),(0,1,2),(0,2,1),(0,2,1),(0,2,2), \\
                      &   & (1,1,0),(1,1,1),(1,1,2),(1,2,0),(1,2,1),(1,2,2),\}
  \end{array}$

\vskip.5em

* A subset $R$ of the Cartesian product $A \times B$ is called a **relation** from the set $A$ to the set $B$, where the elements of $R$ are ordered pairs, with the first element belonging to $A$ and the second to $B$.

# Sets and Quantifiers

* Often we restrict the domain of a quantified statement

  \vskip.5em

  $\forall\,\, x \in S(P(x))$, which is shorthand for $\forall\,\, x. (x \in S \to P(x))$

    \hspace{2em}"Universal quantification of $P(x)$ over all elements in $S$"

  \vskip.5em

  $\exists\,\, x \in S(P(x))$, short hand for $\exists\,\, x. (x \in S \land P(x))$

    \hspace{2em}"Existential quantification of $P(x)$ over all elements in $S$"

\vskip.5em

* **Truth Set:** Given a predicate $P$, and a domain $D$, the *truth set* of $P$ is the set of elements $x \in D$ for which $P(x)$ is true.

  \vskip.5em

  That is the Truth Set of $P(x) = \{x \in D\,\, |\,\, P(x)\}$

  * $\forall\,\, x. P(x)$ is true over the domain $U$ iff the truth set of $P$ is $U$
  * $\exists\,\, x. P(x)$ is true over the domain $U$ iff the truth set of $P$ is not empty.

#

\centering
\vfill
\begin{minipage}{.4\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Set Operations
\end{center}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Union, Intersection, and Difference

::: columns
:::: {.column width=.75}

* **Union ($\cup$):** The *union* of two sets $A$ and $B$, written $A \cup B$, is the set that contains all elements that are in either $A$ or $B$, or both

\vskip-.5em
\begin{equation*}
A \cup B = \{x\,\, |\,\, x \in A \lor x \in B\}
\end{equation*}

* **Intersection ($\cap$):** The *intersection* of two sets $A$ and $B$, written $A \cap B$, is the set that contains all elements that are in *both* $A$ and $B$.

\vskip-.5em
\begin{equation*}
A \cap B = \{x\,\, |\,\, x \in A \land x \in B\}
\end{equation*}

* **Difference ($-$):** The *difference* of two sets $A$ and $B$, written $A - B$, is the set of all elements that are in $A$ but not in $B$

\vskip-.5em
\begin{equation*}
A - B = \{x\,\, |\,\, x \in A \lor x \notin B\}
\end{equation*}

* $|A \cup B| = |A| + |B| - |A \cap B|$
  * *Note:* $|A| + |B|$ counts elements twice hence the need to subtract $|A \cap B|$

::::
:::: {.column width=.25}

\centering

\begin{tikzpicture}

% Set A
\node [circle,
    fill=Roarange,
    minimum size =1.5cm,
    label={135:$A$}] (A) at (0,0){};

% Set B
\node [circle,
    fill=Roarange,
    minimum size =1.5cm,
    label={45:$B$}] (B) at (.85,0){};

\draw[white,thick] (-1.15,-1) rectangle (2,1.25);

% Circles outline
\draw[white,thick] (0,0) circle(.75cm);
\draw[white,thick] (.85,0) circle(.75cm);

% Union text label
\node[Roarange] at (0.45,1) {$U$};

\end{tikzpicture}

\begin{tikzpicture}[thick,
    set/.style = {circle,
        minimum size = 1.5cm,
        color=white}]

\draw[white,thick] (-1.15,-1) rectangle (2,1.25);

% Set A
\node[set,label={135:$A$}] (A) at (0,0) {};

% Set B
\node[set,label={45:$B$}] (B) at (.85,0) {};

% Intersection
\begin{scope}
    \clip (0,0) circle(.75cm);
    \clip (.85,0) circle(.75cm);
    \fill[Roarange](0,0) circle(.75cm);
\end{scope}

% Circles outline
\draw (0,0) circle(.75cm);
\draw (.85,0) circle(.75cm);

\node[Roarange] at (0.45,1) {$U$};

\end{tikzpicture}

\begin{tikzpicture}[thick,
    set/.style = { circle, minimum size = 1.5cm}]

\draw[white,thick] (-1.15,-1) rectangle (2,1.25);

% Set A
\node[set,fill=Roarange,label={135:$A$}] (A) at (0,0) {};

% Set B
\node[set,fill=DarkGray,label={45:$B$}] (B) at (0:.85) {};

% Circles outline
\draw (0,0) circle(.75cm);
\draw (.85,0) circle(.75cm);

\node[Roarange] at (0.45,1) {$U$};

\end{tikzpicture}

::::
:::

# Union, Intersection, and Difference

* **Example:** $A = \{1,2,3\}$, $B = \{3,4,5\}$, $C = \{4,5,6\}$

::: columns
:::: column

\centering

$\begin{array}{rcl}
A \cup B & = & \{1,2,3,4,5\} \\
A \cap B & = & \{3\} \\
A - B    & = & \{1,2\} \\
\end{array}$

::::
:::: column

\centering

$\begin{array}{rcl}
A \cup C & = & \{1,2,3,4,5,6\} \\
A \cap C & = & \varnothing \\
A - C    & = & \{1,2,3\} \\
\end{array}$

::::
:::

* **Example:** Let

\centering

$\begin{array}{rclcl}
\mathbb{Z} & = & \{\ldots,-2,-1,0,1,2,\ldots\}                    & \Rightarrow & \textrm{Set of integers} \\
\mathbb{N} & = & \{0,1,2,\ldots\}                                 & \Rightarrow & \textrm{Set of natural numbers} \\
\mathbb{H} & = & \{-2^{15},\ldots,-2,-1,0,1,2,\ldots,2^{15} - 1\} & \Rightarrow & \textrm{Integers representable using 16-bit word} \\
\mathbb{W} & = & \{-2^{31},\ldots,-2,-1,0,1,2,\ldots,2^{31} - 1\} & \Rightarrow & \textrm{Integers representable using 32-bit word}
\end{array}$

$\mathbb{I} - \mathbb{W}$ is the set of integers not representable  in a word

# Symmetric Difference

* **Symmetric Difference:** The symmetric difference of two sets $A$ and $B$, written $A \oplus B$ is the set containing those elements in either $A$ or $B$, but not is both $A$ and $B$

\begin{equation*}
A \oplus B = \{x | (x \in A \land x \notin B) \lor (x \notin A \land x \in B)\}
\end{equation*}

::: columns
:::: column

**Identities:**

::::: columns
:::::: {.column width=.35}

* $A \oplus A = \varnothing$
* $A \oplus U = \overline{A}$
* $A \oplus \varnothing = A$
* $A \oplus \overline{A} = U$

::::::
:::::: {.column width=.65}

* $A \oplus B = B \oplus A$
* $\left(A \oplus B\right) \oplus B = A$
* $A \oplus B = (A \cup B) - (A \cap B)$
* $A \oplus B = (A - B) \cup (B - A)$

::::::
:::::

::::
:::: column

**Venn Diagram:**

\centering

\begin{tikzpicture}[thick,
    set/.style = {circle,
        minimum size = 2cm}]

\draw[white,thick] (-1.35,-1.2) rectangle (2.4,1.4);

% Set A
\node[set,fill=Roarange,label={135:$A$}] (A) at (0,0) {};

% Set B
\node[set,fill=Roarange,label={45:$B$}] (B) at (1,0) {};

% Intersection
\begin{scope}
    \clip (0,0) circle(1cm);
    \clip (1,0) circle(1cm);
    \fill[DarkGray](0,0) circle(1cm);
\end{scope}

% Circles outline
\draw (0,0) circle(1cm);
\draw (1,0) circle(1cm);

\node[Roarange] at (0.55,1.2) {$U$};

\end{tikzpicture}

::::
:::

# Disjoint Sets

* **Disjoint Sets:** For any two sets $A$ and $B$, if $A \cap B = \varnothing$ then $A$ and $B$ are *disjoint sets*

\vskip.5em

* **Example:** $A = \{1,3,5,7,9\}$ and $B = \{2,4,6,8,10\}$

  \vskip.5em

  $A \cap B = \varnothing$, thus $A$ and $B$ are disjoint

\vskip.5em

* **Venn Diagram:**

\centering

\begin{tikzpicture}[thick,
    set/.style = {circle,
        minimum size = 1.5cm}]

\draw[white,thick] (-1.35,-1.2) rectangle (2.4,1.4);

% Set A
\node[set,fill=Roarange,label={135:$A$}] (A) at (-0.35,0) {};

% Set B
\node[set,fill=GrowlingGray,label={45:$B$}] (B) at (1.35,0) {};

% Circles outline
\draw (-0.35,0) circle(.75cm);
\draw (1.35,0) circle(.75cm);

\node[Roarange] at (0.55,1.2) {$U$};

\end{tikzpicture}

<!--
# Exercises
-->

# Set Complement

* **Complement:** Let $U$ be the *universal set* and $A$ be a set. The *complement* of $A$, written $A'$ or $\overline{A}$, is the set $U - A$

  \begin{equation*}
  \overline{A} = \{x \in U | x \notin A\}
  \end{equation*}

\vskip.25em

* **Note:** $A - B = A \cup \overline{B}$

::: columns
:::: column

**Example:**

$\begin{array}{rcl}
D & = & \{0,1,2,\ldots,9\} \\
L & = & \{a,b,\ldots,z\} \\
U & = & L \cup D \\
\overline{D} & = & L \\
\overline{L} & = & D
\end{array}$

\vskip.25em

**Example:** $U = \{1,2,3,4,5\}$

\vskip.25em

$\overline{\{1,2\}} = \{3,4,5\}$

::::
:::: column

**Venn Diagram:**

\begin{tikzpicture}[thick,
    set/.style = {circle,
        minimum size = 2cm}]

\draw[draw=white,fill=Roarange,thick] (-1.5,-1.2) rectangle (1.5,1.4);

% Set A
\node[set,fill=DarkGrey,label={[DarkGray]135:$A$},DarkGray] (A) at (0,0) {};

% Circles outline
\draw (0,0) circle(1cm);

\node[DarkGray] at (0.55,1.2) {$U$};

\end{tikzpicture}

::::
:::

#

\centering
\vfill
\begin{minipage}{.625\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Finite Sets with Equality
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Finite Sets with Equality

* **Finite Set with Equality:** a set with a finite number of elements and for which we have a function to test the equality of two elements from the universe
  * These are important in computation as they can ensure computation over finite sets may terminate

\vskip.5em

* We can represent sets using a list, but there are important differences between lists and sets:
  1. Lists can have duplicate items
  2. These is a fixed order to the elements of a list
  3. All elements in a list must be of the same type

# Finite Sets with Equality

* To perform any useful computations involving sets, we must be able to determine if an element is in the set
  * This requires the ability to test if two values are the same (using `==`)
    * Simple for elementary types, but difficult for compound types and functions
  * In Haskell, we can express the fact that it is possible to compare elements for equality, by using type restrictions:

    ```haskell
    Eq a => [a] -- as we use a list to represent a set
    ```

\vskip.5em

* Additionally, we want the ability to print the set, so we add the following additional restriction:

  ```haskell
  (Eq, Show) a => [a]
  ```

# Finite Sets with Equality

* Using lists to represent sets requires some care, specifically because
  * There is a possibility of duplicates
  * There is an ordering of the elements

\vskip.5em

* To ensure we do not allow duplicates, we need a means by which we can represent sets using a **normal form**, which contains no duplicates
  * All operations will then ensure their results are in normal form

\vskip.5em

* However, because order matters in lists, but not in sets the list `[3, 2, 1]` is different from the list `[1, 2, 3]`, but as sets these are the same.
  * Thus, to alleviate this issue, we will ensure the sets are similarly ordered

# Finite Sets With Equality

* An ordered list, requires that the contained elements are comparable using the (`<, =, >`) operators
  * This requires we add another type constraint:

    ```haskell
    Ord a => [a]
    ```

  * This says that there must be an ordering on the element type `a`, which can be used to determine the relations $<,\leq,=,\neq,>,\geq$

\vskip.5em

* The methods to define lists can also be used to define sets
  * Enumerated set: defined by simply listing the elements (roster method)
  * **Sequence:** when enumeration is too tedious: $\{0,1,2,\ldots,1000\}$ $\Rightarrow$ `[0,1..1000]`
  * **Set Comprehension:** $\{x^2\,\,|\,\, x \in \{0,1,\ldots,n\}\}$ $\Rightarrow$ `[x^2 | x <- [0..n]]`

# Computing with Sets

* We can define a *set type* as:

  ```haskell
  type Set a = [a]
  ```

\vskip.5em

* The universe of discourse

  ```haskell
  universe -- global var
  ```

**Operations:**

* The following are functions we can use on finite sets with equality. Each of these functions always returns a set in *normal form*

  ```haskell
  normalForm :: (Eq a, Show a) => [a] -> Bool -- checks if in normal form
  normalizeSet :: (Eq a, Show a) => [a] -> Bool -- normalizes a set
  ```

# Computing with Sets

* Symbolic operators for set operations

  \vskip.5em

  $\begin{array}{ccc}
  \texttt{A+++B} & = & A \cup B \\
  \texttt{A***B} & = & A \cap B \\
  \texttt{A\textasciitilde\textasciitilde\textasciitilde B} & = & A - B
  \end{array}$

  \scriptsize
  ```haskell
  (+++) :: (Eq a, Show a) => Set a -> Set a -> Set a
  (***) :: (Eq a, Show a) => Set a -> Set a -> Set a
  (~~~) :: (Eq a, Show a) => Set a -> Set a -> Set a
  ```
  \normalsize

* **Other Operations**

  \scriptsize
  ```haskell
  subset, properSubset :: (Eq a, Show a) => Set a -> Set a -> Bool
  setEq :: (Eq a, Show a) => Set a -> Set a -> Bool
  complement S = universe ~~~ S
  powerset :: (Eq a, Show a) => Set a -> Set (Set a)
  crossproduct :: (Eq a, Show a, Eq b, Show b) => Set a -> Set b -> Set (a, b)
  ```

# Other Representations

* There are many ways to represent sets using computers
  * For example, ti may be tempting to store a set in an ad hoc unordered way
  * However, this is inefficient due to the large number of searches required to perform the various basic set operations

\vskip.5em

* Another way is to use an arbitrary ordering of elements on the universal set

\vskip.5em

* This requires a few assumptions
  1. The universe is finite
  2. The $|U| <$ memory size of the computer

# Other Representations

* We first specify the arbitrary ordering (i.e., ascending in value)
  * This creates the sequence in $U: a_1, a_2, \ldots, a_n$

\vskip.5em

* We then represent a subset $A$ of $U$ with a length $n$ bit string
  * where the $ith$ bit is $1$ if $a_i$ belongs to $A$ and is $0$ otherwise

\vskip.5em

* **Example:**

  \vskip.5em

  $\begin{array}{rcl}
  U & = & \{1,2,3,4,5,6,7,8,9,10\} \\
  O & = & \textrm{the odd numbers in U} = \{1,3, 5, 7, 9\} \\
  E & = & \textrm{the even numbers in U} = \{2,4,6,8,10\}
  \end{array}$

  \vskip.5em

  O is represented as: $10\,\,1010\,\,1010$

  \vskip.5em

  E is represented as: $01\,\,0101\,\,0101$

# Other Representations

**Operations:**

* **Complement:** of a set $S$ is performed by taking the bitwise `NOT` of each bit in the bit string
* **Union:** of sets $S$ and $T$ is performed by taking the bitwise `OR` of $S$ and $T$'s' bit string representations
* **Intersection:** of sets $S$ and $T$ is performed by taking the bitwise `AND` of $S$ and $T$'s  bit string representations

**Example:**

\scriptsize

$E = \overline{O} = \texttt{NOT}\,\, 1010101010 = 0101010101$

::: columns
:::: column

$E \cup O$

```
     0101010101
     1010101010
     ----------
  OR 1111111111
```

::::
:::: column

$E \cap O$

```
     0101010101
     1010101010
     ----------
 AND 0000000000
```

::::
:::

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Sets Laws
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Set Laws

* Often in carrying out set operations or in describing the properties of algorithms, we often need to use several operators together

\vskip.5em

* Fortunately, set operations satisfy a number of basic laws that simplify their use

::: columns
:::: column

* The first of which is:

  \vskip.5em

  **$\subseteq$ Transitivity:** Let $A$, $B$, and $C$ be sets. If $A \subseteq B$ and $B \subseteq C$, then $A \subseteq C$

::::
:::: column

**Proof:** Let $x$ be any element of the universe

\vskip.5em

$\begin{array}{rlr}
1. & A \subseteq B & \{\textrm{Premise}\} \\
2. & x \in A \to x \in B & \{\textrm{Def. }\,\subseteq\} \\
3. & B \subseteq C & \{\textrm{Premise}\} \\
4. & x \in B \to x \in C & \{\textrm{Def. }\,\subseteq\} \\
5. & x \in A \to x \in C & \{\textrm{2, 4, chain rule}\} \\
6. & \forall\,\,x.\,\, (x \in A \to x \in C) & \{\forall\,\,\textrm{introduction}\} \\
7. & A \subseteq C & \{\textrm{Def. }\,\subseteq\}
\end{array}$

::::
:::

<!--
# Exercises
-->

# Basic Laws

**Laws:** For any set $A$ in universe $U$

\vskip.5em

::: columns
:::: column

*Identity Laws*

\vskip1em

$\begin{array}{rcl}
A \cap U           & = & A \\
A \cup \varnothing & = & A
\end{array}$

::::
:::: column

*Domination Laws*

\vskip1em

$\begin{array}{rcl}
A \cup U           & = & U \\
A \cap \varnothing & = & \varnothing
\end{array}$

::::
:::

\vskip2em

::: columns
:::: column

*Idempotent Laws*

\vskip1em

$\begin{array}{rcl}
A \cup A & = & A \\
A \cap A & = & \varnothing
\end{array}$

::::
:::: column

*Double Complementation Law*

\vskip1em

$\begin{array}{rcl}
\overline{(\overline{A})} & = & A
\end{array}$

::::
:::

# Commutative and Associative

**Laws:** For all sets $A$, $B$, and $C$

\vskip.5em

::: columns
:::: column

*Associative Laws*

\vskip1em

$\begin{array}{rcl}
A \cup (B \cup C) & = & (A \cup B) \cup C \\
A \cap (B \cap C) & = & (A \cap B) \cap C
\end{array}$

\vskip2em

*Set Difference*

\vskip1em

$\begin{array}{rcl}
A - B & = & A \cap \overline{B}
\end{array}$

::::
:::: column

*Commutative Laws*

\vskip1em

$\begin{array}{rcl}
A \cup B = B \cup A \\
A \cap B = B \cap A
\end{array}$

\vskip1em

**Example:** Prove $A \cap B = B \cap A$

\vskip.5em

$\begin{array}{lll}
1. & x \in A \cap B                                                    & \{\textrm{Premise}\} \\
2. & x \in A \land x \in B                                             & \{\textrm{Def. }\,\cap\} \\
3. & x \in B \land x \in A                                             & \{\textrm{Comm. }\,\land\} \\
4. & x \in B \cap A                                                    & \{\textrm{Def. }\, \cap\} \\
5. & \forall\,\,x \in U. x \in A \cap B \leftrightarrow x \in B \cap A & \{\{\forall I\}\} \\
6. & A \cap B = B \cap A                                               & \{\textrm{Def. set eq.}\}
\end{array}$

::::
:::

# Distribution and DeMorgan's

**Laws:** For any sets $A$, $B$, $C$ and universe $U$

\vskip.5em

::: columns
:::: column

*Distributive Laws:*

\vskip1em

$\begin{array}{rcl}
A \cap (B \cup C) & = & (A \cap B) \cup (A \cap C) \\
A \cup (B \cap C) & = & (A \cup B) \cap (A \cup C)
\end{array}$

\vskip1em

::::
:::: column

*DeMorgan's Laws*

\vskip1em

$\begin{array}{rcl}
\overline{A \cap B} & = & \overline{A} \cup \overline{B} \\
\overline{A \cup B} & = & \overline{A} \cap \overline{B}
\end{array}$

::::
:::

\vskip2em

::: columns
:::: column

*Absorption Laws*

\vskip1em

$\begin{array}{rcl}
A \cup (A \cap B) & = & A \\
A \cap (A \cup B) & = & A
\end{array}$

::::
:::: column

*Complement Laws*

\vskip1em

$\begin{array}{rcl}
A \cup \overline{A} & = & U \\
A \cap \overline{A} & = & \varnothing
\end{array}$

::::
:::


#

\centering
\vfill
\begin{minipage}{.45\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Proofs with Sets
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Using Membership Tables

* We can prove set identities using set membership tables
  * Here, we consider each combination of atomic sets (original sets used to produce the sets on each side of an identity) that an element can belong to.
  * We then verify that elements on the same combinations belong to both the sets in the identity
  * To indicate an element is in a set we us a 1, otherwise a 0

* **Example:** Show $A \cap (B \cup C) = (A \cap B) \cup (A \cap C)$

\scriptsize

+-----+-----+-----+------------+---------------------+------------+------------+-----------------------------------------+
| $A$ | $B$ | $C$ | $B \cup C$ | $A \cap (B \cup C)$ | $A \cap B$ | $A \cap C$ | $\left(A \cap B\right) \cup (A \cap C)$ |
+:===:+:===:+:===:+:==========:+:===================:+:==========:+:==========:+:=======================================:+
| 1   | 1   | 1   | 1          | **1**               | 1          | 1          | **1**                                   |
+-----+-----+-----+------------+---------------------+------------+------------+-----------------------------------------+
| 1   | 1   | 0   | 1          | **1**               | 1          | 0          | **1**                                   |
+-----+-----+-----+------------+---------------------+------------+------------+-----------------------------------------+
| 1   | 0   | 1   | 1          | **1**               | 0          | 1          | **1**                                   |
+-----+-----+-----+------------+---------------------+------------+------------+-----------------------------------------+
| 1   | 0   | 0   | 0          | **0**               | 0          | 0          | **0**                                   |
+-----+-----+-----+------------+---------------------+------------+------------+-----------------------------------------+
| 0   | 1   | 1   | 1          | **0**               | 0          | 0          | **0**                                   |
+-----+-----+-----+------------+---------------------+------------+------------+-----------------------------------------+
| 0   | 1   | 0   | 1          | **0**               | 0          | 0          | **0**                                   |
+-----+-----+-----+------------+---------------------+------------+------------+-----------------------------------------+
| 0   | 0   | 1   | 1          | **0**               | 0          | 0          | **0**                                   |
+-----+-----+-----+------------+---------------------+------------+------------+-----------------------------------------+
| 0   | 0   | 0   | 0          | **0**               | 0          | 0          | **0**                                   |
+-----+-----+-----+------------+---------------------+------------+------------+-----------------------------------------+

# Using Identities

* Once we have proved set identities (laws), we can use them to prove new identities through equational reasoning

\vskip.5em

* **Example:** Let $A$, $B$, and $C$ be sets

  \vskip.5em

  Show that $\overline{A \cup (B \cap C)} = (\overline{C} \cup \overline{B}) \cap \overline{A}$

  \vskip.5em

  $\begin{array}{lr}
  \overline{A \cup (B \cap C)} & \\
  \,\,\,= \overline{A} \cap \overline{(B \cap C)} & \{\textrm{DeMorgan's law}\} \\
  \,\,\,= \overline{A} \cap (\overline{B} \cup \overline{C}) & \{\textrm{DeMorgan's law}\} \\
  \,\,\,= (\overline{B} \cup \overline{C}) \cap \overline{A} & \{\textrm{Commutative law}\} \\
  \,\,\,= (\overline{C} \cup \overline{B}) \cap \overline{A} & \{\textrm{Commutative law}\}
  \end{array}$

#

\centering
\vfill
\begin{minipage}{.535\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Advanced Concepts
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Generalized Union and Intersection

* We can calculate the union of several sets using the $\cup$ operator.
  * Because it is associative, statements such as $A \cup B \cup C$ are unambiguous
* Similarly we can also find the intersection of multiple sets using a statement such as $A \cap B \cap C \cap D$
* However, attempting to visualize the union or intersection of 4+ sets starts to get difficult.

::: columns
:::: column

\centering

\begin{tikzpicture}[thick,
    set/.style = {circle,
        minimum size = 1.5cm}]

\draw[draw=white,thick] (-1.5,-1.1) rectangle (2.5,2.4);

% Set A
\node[set,fill=Roarange,label={135:$A$}] (A) at (0,0) {};

% Set B
\node[set,fill=Roarange,label={45:$B$}] (B) at (1.1,0) {};

% Set C
\node[set,fill=Roarange,label=$C$] (C) at (0.55,1) {};

% Circles outline
\draw (0,0) circle(.75cm);
\draw (1.1,0) circle(.75cm);
\draw (0.55,1) circle(.75cm);

\node[Roarange] at (2.3,2.1) {$U$};

\end{tikzpicture}

**$A \cup B \cup C$**

::::
:::: column

\centering

\begin{tikzpicture}[thick,
    set/.style = {circle,
        minimum size = 1.5cm}]

\draw[draw=white,thick] (-1.5,-1.1) rectangle (2.5,2.4);

% Set A
\node[set,label={135:$A$}] (A) at (0,0) {};

% Set B
\node[set,label={45:$B$}] (B) at (1.1,0) {};

% Set C
\node[set,label=$C$] (C) at (0.55,1) {};

% Intersection
\begin{scope}
    \clip (0,0) circle(.75cm);
    \clip (1.1,0) circle(.75cm);
    \clip (0.55,1) circle(.75cm);
    \fill[Roarange](0,0) circle(.75cm);
\end{scope}

% Circles outline
\draw (0,0) circle(.75cm);
\draw (1.1,0) circle(.75cm);
\draw (0.55,1) circle(.75cm);

\node[Roarange] at (2.3,2.1) {$U$};

\end{tikzpicture}

**$A \cap B \cap C$**

::::
:::

# Generalized Union and Intersection

* Sometimes it becomes necessary to compute the union or intersection of a collection of sets.

\vskip.5em

* The corresponding operations which handle this are often called *big union* and *big intersection*

\vskip.5em

* Let $C$ be a non-empty collection of subsets of $U$. Let $I$ be a non-empty set, and for each $i \in I$ let $A_i \subseteq C$, then

  $\underset{i \in I}{\bigcup} A_i = \{x\,\, |\,\, \exists\,\, i \in I.\,\, x \in A_i\}$ \hspace{1em} $\underset{i \in I}{\bigcap} A_i = \{x\,\, |\,\, \forall\,\, i \in I.\,\, x \in A_i\}$

\vskip.5em

* We could also consider writing these same definitions as follows:

  $\underset{A \in C}{\bigcup} A = \{x\,\, |\,\, \exists\,\, A \in C.\,\, x \in A\}$ \hspace{1em} $\underset{A \in C}{\bigcap} A = \{x\,\, |\,\, \forall\,\, A \in C.\,\, x \in A\}$

\vskip.5em

* In either case

  $A_1 \cup A_2 \cup \ldots \cup A_n = \overset{n}{\underset{i = 1}{\bigcup}} A_i$ \hspace{1em} $A_1 \cap A_2 \cap \ldots \cap A_n = \overset{n}{\underset{i = 1}{\bigcap}} A_i$

# Multisets

* **Multiset:** An unordered collection of elements, where an element can occur as a member more than once
  * *Notation:* $\{m_1 \cdot a_1, m_2 \cdot a_2, \ldots, m_r \cdot a_r\}$ denotes the multiset with element $a_1$ occurring $m_1$ times, element $a_2$ occurring $m_2$ times and so on.
    * The numbers $m_i$, $i = 1, 2, \ldots, r$ are called **multiplicities** of the elements $a_i$, $i = 1, 2, \ldots, r$
    * Elements not in the multiset have a multiplicity of 0

\vskip.5em

 **Cardinality:** The cardinality of a multiset is defined as the sum of the multiplicities of its elements


\vskip.5em

* **Examples:**

  $\begin{array}{rcl}
  P   & = & \{4 \cdot a, 1 \cdot b, 3 \cdot c\} \\
  |P| & = & 4 + 1 + 3 = 8
  \end{array}$

# Multiset Operations

* **Union:** the *union* of multisets $P$ and $Q$ is the multiset in which the multiplicity of an element is the maximum of its multiplicities in $P$ and $Q$. Written as $P \cup Q$

\vskip.5em

* **Intersection:** the *intersection* of multisets $P$ and $Q$ is the multiset in which the multiplicity of an element is the minimum of its multiplicities in $P$ and $Q$. Written as $P \cap Q$

\vskip.5em

* **Difference:** the *difference* of multisets $P$ and $Q$ is the multiset in which the multiplicity of an element is the multiplicity of the element in $P$ less its multiplicity in $Q$ unless the difference is negative, in which case the multiplicity is 0. Written as $P - Q$

\vskip.5em

* **Sum:** the *sum* of multisets $P$ and $Q$ is the multiset in which the multiplicity of an element is the sum of the multiplicities in $P$ and $Q$. Written as $P + Q$

# Multiset Operation Examples

* **Example:** $P = \{4 \cdot a, 1 \cdot b, 3 \cdot c\}$ and $Q = \{3 \cdot a, 4 \cdot b, 2 \cdot d\}$

  \vskip.5em

  $\begin{array}{rcl}
  P \cup Q & = & \{\max(4,3)a, \max(1,4)b, \max(3,0)c, \max(0,2)d\} \\
           & = & \{4 \cdot a, 4 \cdot b, 3 \cdot c, 2 \cdot d\} \\ \\
  P \cap Q & = & \{\min(4,3)a, \min(1,4)b, \min(3,0)c, \min(0,2)d\} \\
           & = & \{3 \cdot a, 1 \cdot b, 0 \cdot c, 0 \cdot d\} \\ \\
  P - Q    & = & \{\max(4 - 3, 0)a, \max(1 - 4, 0)b, \max(3 - 0, 0)c, \max(0 - 2, 0)d\} \\
           & = & \{1 \cdot a, 3 \cdot c\}\\ \\
  P + Q    & = & \{(4 + 3)a, (1 + 4)b, (3 + 0)c, (0 + 2)d\} \\
           & = & \{7 \cdot a, 5 \cdot b, 3 \cdot c, 2 \cdot d\}
  \end{array}$

# Fuzzy Sets

* *Fuzzy sets* are a type of set typically used in AI and ML

\vskip.5em

* Each element in the universe $U$ has a degree of membership, in fuzzy set $S$
  * *Degree of membership* is a real number $[0,1]$

\vskip.5em

* A fuzzy set is denoted by listing the elements with their degree
  * elements with degree 0 are not listed

\vskip.5em

* **Example:** $\{0.6\,\, Alice, 0.9\,\, Brian, 0.4\,\, Fred, 0.1\,\, Oscar, 0.5\,\, Rita\} = F$

\vskip.5em

* A traditional, or **crisp set**, is a fuzzy set where all elements that are members have a degree of 1.0 and all other elements have a degree of 0.0

# Fuzzy Set Operations

* **Union ($\cup$):** The union of two fuzzy sets $S$ and $T$ is the fuzzy set $S \cup T$ where the degree of membership of an element in $S \cup T$ is the maximum of the degrees of membership of this element in $S$ and $T$

\vskip.5em

* **Intersection ($\cap$):** The intersection of two fuzzy sets $S$ and $T$ is the set $S \cap T$, where the degree of membership of an element in $S \cap T$ is the minimum of the degrees of membership of this element in $S$ and in $T$.

\vskip.5em

* **Complement:** The complement of a fuzzy set $S$ is the set $\overline{S}$, with the degree of membership of an element in $\overline{S}$ equal to 1.0 minus the degree of membership fo the element in $S$

# For Next Time

::: columns
:::: column
* Review DMUC Chapter 8
* Review DMA Chapter 2.1 -- 2.2
* Review this Lecture
* Read DMUC Chapter 3
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
