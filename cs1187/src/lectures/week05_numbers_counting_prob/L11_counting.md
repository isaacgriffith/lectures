---
author:
- Dr. Isaac Griffith
title: Counting
institute: |
  CS 1187

  Department of Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Inspiration

> "We have not begun to understand the relationship between combinatorics and conceptual mathematics." -- Jean Dieudonne

# Pigeonhole Principle

* **Pigeonhole Principle:** Let $A$ and $B$ be finite sets, such that $|A| > |B|$ and $|A| > 1$. Let $f : A \to B$. Then

  $$\exists a_1,a_2 \in A.\,\,(a_1 \ne a_2) \land (f(a_1) = f(a_2))$$

# Basics of Counting

* **Product Rule**
  - Suppose that a procedure can be broken down into a sequence of two tasks
  - If there are $n_1$ ways to do the first task and for each of these ways of doing the first task, there are $n_2$ ways to the second task.
  - Then there are $n_{1}n_{2}$ ways to do the Procedure

* **Example:** Numbering with letter (A -- Z) and integer(1 -- 100).
  - Answer: $26 \times 100 = 2600$

* **Example:** License Plate

* **Example:** One-to-one function

# Basics of Counting

* **Sum Rule**
  - if a task can be done either in one of $n_1$ ways or $n_2$ ways, where none of the set of $n_1$ ways is the same as any of the set of $n_2$ ways
  - Then there are $n_1 + n_2$ ways to do the task

::: columns
:::: column

**Example:**

::::
:::: column

**Example:**

::::
:::

# Inclusion-Exclusion Principle

* Suppose that a task can be done in $n_1$ or in $n_2$ ways, but that some of the set of $n_1$ ways to do the task are the same as some of the $n_2$ other ways to do the task.

* In the situation, we cannot use the sum rule to count the number of ways to do the task. Adding the number of ways to do the tasks in these two ways leads to an over count, because the ways to do the task that are in common are counted twice.

# Example

* Determine the number of positive integers $n$ where $n \leq 100$ and $n$ is not divisible by $2$, $3$, or $5$

  - divisible by 2: $\lfloor 100 / 2\rfloor = 50$
  - divisible by 3: $\lfloor 100 / 3\rfloor = 33$
  - divisible by 5: $\lfloor 100 / 5\rfloor = 20$
  - divisible by $2\cdot 3$: $\lfloor 100 / 6\rfloor = 16$
  - divisible by $2\cdot 5$: $\lfloor 100 / 10\rfloor = 10$
  - divisible by $3\cdot 5$: $\lfloor 100 / 15\rfloor = 6$
  - divisible by $2\cdot 3\cdot 5$: $\lfloor 100 / 30\rfloor = 3$

  $$100 - (50 + 33 + 20) + (16 + 10 + 6) - 3 = 26$$


# The Sieve of Eratosthenes

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge The Pigeon-Hole Principle
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Pigeon-Hole Principle

* **Theorem:** If $k+1$ objects are place into $k$ boxes, then there is at least one box containing two or more of the objects.

* **Proof:**
  - **Assume:** Each box can contain at most *1* object
    * If $k$ boxes can hold at most $1$ object then there can only be $k$ objects
    * But there are $k + 1$ objects

    $\therefore$ At least one box must contain two objects

* **Example:**
  - How many students must be in class to guarantee that at least two students receive the same letter grades if there ar e8 different letter grades: `A, A-, B, B-, C+, C, C-`

  - **Answer:** $8 + 1 = 9$

# Pigeon-Hole Principle

* **Theorem:** If $n$ objects are placed into $k$ boxes, then there is at least one box containing at least $\lceil N/k \rceil$ objects.

* **Example**:
  - Among $100$ people there are at least $\lceil 100/12 \rceil = 9$ who were born the same month

* **Example**:
  - How many cards must be selected from a deck of **52** cards to guarantee that at least three cards of the same suit are chosen?
  - **Answer:** two cards each $\times$ 4 suits = 8 $\to$ at least $9$

* **Corrollary:**
  - A function $f$ from a set with $k + 1$ or more elements to a set with $k$ elements is not one-to-one

* **Theorem:**
  - Every sequence of $n^2 + 1$ distinct real numbers contains a subsequence of length $n + 1$ that is either strictly increasing or strictly decreasing.

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Permutations and Combinations
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Permutations

* **Permutation** is an ordered arrangement of a distinct set of objects.
  - **Order matters!!!**
  - Among $n$, select $r$

$$P(n,r) = n(n - 1)(n - 3)\ldots (n - r + 1) = \frac{n!}{(n - r)!}$$

* **Theorem:** If $n$ is a positive integer and $r$ is an integer with $1 \leq r \leq n$, then there are:

  $$P(n, r) = n(n - 1)(n - 2) \ldots (n - r + 1)$$

  r-permutations of a set with $n$ distinct elements.

* **Corollary:** If $n$ and $r$ are integers with $0 \leq r \leq n$, then

$$P(n, r) = \frac{n!}{(n - r)!}$$

# Combinations

* An **r-combination** is an unordered selection of $r$ elements from a set. Thus, it is simply a subset of the set with $r$ elements.
  - Written as $\binom{n}{r}$ and is called a **binomial coefficient**

* **Theorem:** The number of r-combinations of a set with $n$ elements where $n$ is a nonnegative integer and $r$ is an integer with $0 \leq r \leq n$, equals

::: columns
:::: column

$$C(n,r) = \frac{n!}{r!(n - r)!}$$

::::
:::: column

$$P(n,r) = C(n,r) \cdot P(r,r)$$

::::
:::

* **Corollary:** Let $n$ and $r$ be nonnegative integers with $r \leq n$. Then

$$C(n,r) = C(n, n-r)$$

# Combinatorial Proofs

* **Combinatorial Proof:** a proof of an identity that uses counting arguments to prove that both sides of the identity count the same objects but in different ways.

* **Example:** How many permutations of the letters **ABCDEFGH** contain the string **ABC**

  - **Answer:** $P(6, 6) = 6!$

* **Example:** How many ways are there for 8 men and 5 women to stand in a line so that no two women stand next to each other?

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Binomial Coefficients
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Binomial Theorem

- Let $x$ and $y$ be variables and let $n$ be a nonnegative integer. Then

\begin{eqnarray*}
(x + y)^n & = & \overset{n}{\underset{j = 0}{\sum}}\binom{n}{j}x^{n - j}y^{j} \\
          & = & \binom{n}{0}x^n + \binom{n}{1}x^{n-1}y + \binom{n}{2}x^{n-2}y^{2} + \ldots + \binom{n}{n - 1}xy^{n-1} + \binom{n}{n}y^n
\end{eqnarray*}

* **Corollary:** Let $n$ be a nonnegative integer. Then

$$\overset{n}{\underset{k = 0}{\sum}}\binom{n}{k} = 2^n$$

# Binomial Theorem

* **Corollary:** Let $n$ be a positive integer. Then

$$\overset{n}{\underset{k = 0}{\sum}}(-1)^k\binom{n}{k} = 0$$

* **Corollary:** Let $n$ be a nonnegative integer. Then

$$\overset{n}{\underset{k = 0}{\sum}}2^k\binom{n}{k} = 3^n$$

# Binomial Theorem

* **Example:** What is the expansion of $\left(x + y\right)^4$

\begin{eqnarray*}
(x + y)^4 & = & \binom{4}{0}x^4 + \binom{4}{1}x^3y + \binom{4}{2}x^2y^2 + \binom{4}{3}xy^3 + \binom{4}{4}y^4 \\
          & = & x^4 + 4x^3y + 6x^2y^2 + 4xy^3 + y^4
\end{eqnarray*}

* **Example:** What is the coefficient of $x^{12}y^{13}$ in the expansion of $\left(x + y\right)^{25}$

$$= \binom{25}{12}\,\textrm{or}\,\binom{25}{13}$$

# Pascal's Identity

* Let $n$ and $k$ be positive integers with $n \geq k$. Then

$$\binom{n + 1}{k} = \binom{n}{k - 1} + \binom{n}{k}$$

* **Pascal's Triangle**

::: columns
:::: column

$$
\begin{array}{ccccccccc}
 &  &  &  & \binom{0}{0}\\
 &  &  & \binom{1}{0} &  & \binom{1}{1}\\
 &  & \binom{2}{0} &  & \binom{2}{1} &  & \binom{2}{2}\\
 & \binom{3}{0} &  & \binom{3}{1} &  & \binom{3}{2} &  & \binom{3}{3}\\
\binom{4}{0} &  & \binom{4}{1} &  & \binom{4}{2} &  & \binom{4}{3} &  & \binom{4}{4}
\end{array}
$$

::::
:::: column
\vskip1em
$$
\begin{array}{ccccccccc}
  &   &   &   & 1\\
  &   &   & 1 &   & 1\\
  &   & 1 &   & 2 &   & 1\\
  & 1 &   & 3 &   & 3 &   & 1\\
1 &   & 4 &   & 6 &   & 4 &   & 1
\end{array}
$$

::::
:::

# Vander Monde's Identity

* Let $m$, $n$, and $r$ be nonnegative integers with $r$ not exceeding either $m$ or $n$. Then

$$\overset{r}{\underset{k=0}{\sum}}\binom{m}{r-k}\binom{n}{k}$$

* **Corrollary:** If $n$ is a nonegative integer, then

$$\binom{2n}{n} = \overset{n}{\underset{k = 0}{\sum}}\binom{n}{k}^{2}$$

* **Theorem:** Let $n$ and $r$ be nonnegative integers with $r \leq n$. Then

$$\binom{n + 1}{r + 1} = \overset{n}{\underset{j = r}{\sum}}\binom{j}{r}$$

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Generalized Permutations
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Permutations with Repetition

* **Theorem:** The number of **r-permutations** of a set of $n$ objects with repetion allowed is $n^r$

* **Example:** How many strings of length $k$ can be formed from the English alphabet?

  - **Answer:** $26^k$

# Combinations with Repetition

* **Theorem:** Theare are $C(n+r-1, r) = C(n+r-1, n-1)$ r-combinations from a set with $n$ elements when repetition of elements is allowed.
  - In other words: for $n$ kinds and $r$ items $\binom{n + r -1}{n-1}$

* **Example:** How many ways are there to select 4 pieces of fruit from the bowl?

* **Example:** A bakery bakes cookies $A$, $B$, $C$, $D$. How many ways can 6 cookies be choosen?

  $$\binom{4 + 6 - 1}{6} = \binom{9}{6} = \frac{9!}{3!2!} = 84$$

# Permutations w/Indistinguishable Objects

* **Theorem:** The number of different permutations of $n$ objects, where there are $n_1$ indistinguishable objects of type 1, $n_2$ indistinguishable objects of type 2, $\ldots$, and $n_k$ indistinguishable objects of type $k$ is

$$\frac{n!}{n_1!n_2!\ldots n_k!}$$

* **Example:** How many different strings can be made by reordering the letters of the word: "SUCCESS"?
  - If each letter is distinct then $7!$
  - However, since the **S**'s and **C**'s are not distinct

$$\frac{7!}{2!3!}$$

# Distribution of Objects into Boxes

* **Theorem:** The number of ways to distribute $n$ distinguishable objects into $k$ distinguishable boxes so that $n_i$ objects are placed into box $i$, where $i = 1, 2, \ldots, k$ equals

$$\frac{n!}{n_1! n_2! \ldots n_k!}$$

* **Example:** How many ways are there to distribute hands of 5 cars to each of 4 players from the standard deck of 52 cards?

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Discrete Probability
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Finite Probability

* If $\mathcal{S}$ is a finite sample space of equally likely outcomes, and $E$ is an event, that is, a subset of $\mathcal{S}$, then the **probability** of $E$ is

$$P(E) = \frac{|E|}{|\mathcal{S}|}$$

* **Example:** In a lottery, players win a large prize when they match 4 digits in correct order, 4 digits are selected randomly. What is the probability that a player won the prize?

$$\frac{1}{10000}$$

# Finite Probability

* **Example:** In a lottery, a player wins an enormous prize if he/she picks correctly 6 numbers out of 50 numbers (1 to 50). What is the winning probability?

$$C\binom{50}{6} = \frac{50!}{6!44!} \sim \frac{1}{15\,\textrm{million}}$$

* **Example:** Probability that a hand of 5 cards in poker contains 4 cards of one kind.

$$\frac{\binom{13}{1}\binom{48}{1}}{\binom{52}{5}}$$

# Combinations of Events

* **Theorem:** Let $E$ be an event in sample space $\mathcal{S}$. The probability of the event $\overline{E}$, the complementary event of $E$, is given by

$$P(\overline{E}) = 1 - P(E)$$

* **Theorem:** Let $E_1$ and $E_2$ be events in the sample space $\mathcal{S}$. Then

$$P(E_1 \cup E_2) = P(E_1) + P(E_2) - P(E_1 \cap E_2)$$

# Example

* What is the probability that a positive integer selected at random from the set of positive integers not exceeding 100 is divisible by 2 or 5
  - $E_1 = \textrm{divisible by}\, 2$ $|E_1 = 50|$
  - $E_2 = \textrm{divisible by}\, 5$ $|E_2 = 20|$
  - $|E_1 \cap E_2| = 10$

  \begin{eqnarray*}
  P(E_1 \cup E_2) & = & P(E_1) + P(E_2) - P(E_1 \cap E_2) \\
                                      & = & \frac{50}{100} + \frac{20}{100} - \frac{10}{100} \\
                                      & = & \frac{3}{5}
  \end{eqnarray*}

# Probabilistic Reasoning

# Axioms of Probability

1. Probability of event $E$, $P(E)$ is $0 \leq P(E) \leq 1$
2. For sample space $\mathcal{S}$, $P(\mathcal{S}) = 1$
3. For any sequence of mutually exclusive events, $E_1$, $E_2$, $\ldots$, that is, events for which $E_i \cdot E_j = \varnothing$ when $i \ne j$

$$P\left(\overset{\infty}{\underset{i = 1}{\bigcup}}E_i\right) = \overset{n}{\underset{i = 1}{\sum}}P(E_i)$$

# Axioms of Probability

* **Example:** Tossing a coin

$$P(\{H\}) = P(\{T\}) = \frac{1}{2}$$

* **Example:** Rolling an even number with a die

$$P(\{2, 4, 5\}) = P(\{2\}) + P(\{4\}) + P(\{6\}) = \frac{1}{6} + \frac{1}{6} + \frac{1}{6} = \frac{1}{2}$$

# Axioms of Probability

* **Propositions**
  - $P(\overline{E}) = 1 - P(E)$$
  - If $E \subset F$, then $P(E) \leq P(F)$
  - $P(E \cup F) = P(E) + P(F) - P(E \cap F)$

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Probability Theory
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Assigning Probabilities

* Suppose that $\mathcal{S}$ is a set with $n$ elements. The **uniform distribution** assigns the probability $\frac{1}{n}$ to each element of $\mathcal{S}$

* The **probability** of the event $E$ is the sum of the probabilities of the outcomes in $E$. That is,

  $$P(E) = \underset{\mathcal{s} \in E}{\sum} P(s)$$

  - **Note:** when $E$  is an infinite set, $\underset{s \in E}{\sum} P(s)$ is a convergent infinite series.

# Combinations of Events

* **Theorem:** If $E_1,\,E_3,\,\ldots$ is a sequence of pairwise disjoint events in Sample Space $\mathcal{S}$, then

  $$P\left(\underset{i}{\bigcup}E_i\right) = \underset{i}{\sum}P(E_i)$$

  - **Note:** this theorem applies when the sequence $E_1,\,E_3,\,\ldots$ consists of a finite number or a countable infinite number of pairwise disjoint events.

# Conditional Probability

* Let $E$ and $F$ be events with $P(F) > 0$. The **conditional probability** of $E$ given $F$, dentoed by $P(E | F)$, is defined as:

$$P(E | F) = \frac{P(E \cap F)}{P(F)}$$

* **Example:** A coin is flipped 3 times. The first outcome was tails what is the probability that an *odd* number of tails appears

  `TTT  TTH  THT  THH`

  Conditional Probability: $\frac{2}{4}$

# Conditional Probability

* **Example:** An urn contains 10 white, 5 yellow, and 10 black marbles. A marble is selected at random from the urn, and it is not black. What is the probability that is is yellow?

$$P(Y | \overline{B}) = \frac{P(Y \cap \overline{B})}{P(\overline{B})} = \frac{5 / 25}{15 / 25} = \frac{1}{3}$$

# Independence

* The events $E$ and $F$ are **independent** iff

$$P(E \cap F) = P(E)P(F)$$

* **Example:** A card is selected at random from an ordinary deck of 52 playing cards. If $E$ is the event that the selected card is an Ace and $F$ is the event that it is a spade, then $E$ and $F$ are independent.

\begin{eqnarray*}
P(E \cap F) & = & \frac{1}{52} \\
P(E) & = & \frac{4}{52} \\
P(F) & = & \frac{13}{52}
\end{eqnarray*}

# Independence

* **Example:** Two coins are flipped
  - $E$ = first coin lands heads
  - $F$ = second coin lands tails
  - $E$ and $F$ are independent

\begin{eqnarray*}
P(E | F) & = & (\{H, T\}) = \frac{1}{4} \\
P(E) & = & P(\{(H, H), (H,T)\}) = \frac{1}{2} \\
P(F) & = & P(\{(H,T),(T,T)\}) = \frac{1}{2}
\end{eqnarray*}

# Bernoulli Trials

* Only two possible outcomes
  1. **Success (p)**
  2. **Failure (q)**

* $p + q = 1$ or $q = 1 - p$

* **Theorem:** The probability of exactly $k$ successes in $n$ independent Bernoulli trials, with probability of success $p$ and probability of failure $q = 1 - p$, is

$$C(n, k)p^kq^{n-k}$$

* **Example:** What is the probability that exactly 4 heads come up when the coin is flipped 8 times, assuming that the flips are independent?

# Random Variables

* Real-valued function defined on the sample space of an experiment. That is, a **random variable** assigns a real value to each possible outcome.

* **Example:** Suppose a coin is flipped three times. Let $X(t)$ be the random variable that equals the number of heads that appear when $t$ is the outcome. Then

\begin{eqnarray*}
X(HHH) & = & 3 \\
X(HTH) & = & X(HHT) = X(THH) = 2 \\
X(HTT) & = & X(THT) = X(TTH) = 1 \\
X(TTT) & = & 0
\end{eqnarray*}

# Random Variables

* Distribution of a random variable $X$ on a sample space $\mathcal{S}$ is the set of pairs $\left(r, P(X = r)\right)$ for all $r \in X(\mathcal{S})$, where $P(X = r)$ is the probability that $X$ takes the value $r$

* A Distribution is usually described by specifying $P(X = r)$ for each $r \in X(\mathcal(S))$

\begin{eqnarray*}
P\{X = 3\} & = & \frac{1}{8} \\
P\{X = 2\} & = & \frac{3}{8} \\
P\{X = 1\} & = & \frac{3}{8} \\
P\{X = 0\} & = & \frac{1}{8}
\end{eqnarray*}

# The Birthday Problem

# The Probabilisitc Method

* **Theorem - The Probabilistic Method:** If the probability that an element of a set $\mathcal{S}$ does not have a particular property is less than 1, there exists an element in $\mathcal{S}$ with this property.

* **Theorem:** If $k$ is an integer with $k \geq 2$, then $R(k, k) \geq 2^{k/2}$

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Bayes' Theorem
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Expected Value and Variance
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# For Next Time

::: columns
:::: column
* Review Chapter
* Review this Lecture
* Read Chapter
* Come To Lecture
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
