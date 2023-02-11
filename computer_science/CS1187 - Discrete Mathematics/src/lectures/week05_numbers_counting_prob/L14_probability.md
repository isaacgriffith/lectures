---
author:
- Dr. Isaac Griffith
title: Discrete Probability
course: CS 1187
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Inspiration

\vfill
> "We must become more comfortable with probability and uncertainty." -- Nate Silver

# Outline

The lecture is structured as follows:

::: columns
:::: {.column width=.7}
* Discrete Probability
* Probability Theory
::::
:::: {.column width=.25}
\vfill
\vspace{7.25em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\ts{Discrete Probability}

# Introduction

* Probability Theory
  * Introduced in 1526 by Girolamo Cardano an Italian mathematician, physician, and gambler
  * Further refined by Blaise Pascal in the 17th century
  * Later in the 18th century the French mathematician Laplace defined the probability of an event

::: columns
:::: {.column width=.2}
::::
:::: {.column width=.2}
\portrait{Girolamo Cardano}{.85}{images/probability/CardanoGirolamo.jpg}
::::
:::: {.column width=.2}
\portrait{Blaise Pascal}{.85}{images/probability/BlaisePascal.jpg}
::::
:::: {.column width=.2}
\portrait{Pierre-Simon Laplace}{.85}{images/probability/PierreSimonLaplace.jpg}
::::
:::: {.column width=.2}
::::
:::

# Finite Probability

* **Experiment:** a procedure that yields one of a given set of possible outcomes
  * **Sample Space:** of an experiment is the set of possible outcomes
  * **Event:** a subset of the sample space

\pause
\vskip.5em

* **Laplace's Definition of Probability:** If $S$ is a finite nonempty sample space of equally likely outcomes, and $E$ is an event, that is, a subset of $S$, then the *probability* of $E$ is

  $$p(E) = \frac{|E|}{|S|},\,\, 0 \leq p(E) \leq 1$$

# Finite Probability

::: columns
:::: {.column width=.9}

\ex An urn contains four \textcolor{Bluetiful}{blue} balls and five \textcolor{FireOpal}{red} balls. What is the probability that a ball chosen at random from the urn is \textcolor{Bluetiful}{blue}?

\pause
\vskip1em

\sol

$S =$ set of all balls $\Rightarrow |S| = 9$

$E =$ set of events for choosing 4 balls that are blue $\Rightarrow |E| = 4$

$p(E) = \frac{|E|}{|S|} = \frac{4}{9}$

::::
:::: {.column width=.1}

\vspace{-1em}
\begin{center}
\includegraphics[width=.95\textwidth]{images/probability/urn.eps}
\end{center}

::::
:::

\vskip2em

::: columns
:::: {.column width=.10}

\vspace{1em}
\begin{center}
\includegraphics[width=.95\textwidth]{images/probability/dice.png}
\end{center}

::::
:::: {.column width=.9}
\pause

\ex What is the probability that when two dice are rolled, the sum of the numbers on the two dice is 7?

\pause
\vskip1em

\sol

$S =$ set of possible outcomes $\Rightarrow |S| = 36$

$E =$ set of outcomes which total 7 $= \{(1,6), (2,5), (3,4), (4,3), (5,2), (6,1)\} \Rightarrow |E| = 6$

$p(E) = \frac{|E|}{|S|} = \frac{6}{36} = \frac{1}{6}$

::::
:::

# Finite Probability

\ex There are many lotteries now that award prizes to people who correctly *choose* a set of six numbers out of the first $n$ positive integers, where $n$ is usually between 30 and 60. What is the probability that a person picks the correct six numbers out of 40?

\pause

\sol

1. Identify the total number of combinations:

   $$C(40, 6) = \frac{40!}{34!6!} = 3,838,380 = |S|$$

2. Since there is only one winning combination, $|E| = 1$
3. Find the probability:

   $$p(E) = \frac{|E|}{|S|} = \frac{1}{3,838,380} \approx 0.00000026$$

# Finite Probability

::: columns
:::: {.column width=.75}

\ex Find the probability that a hand of five cards contains four cards of one kind.

\pause
\vskip1em

\sol

Using the product rule:

1. $|E| = C(13,1)C(4,4)C(48,1)$ - number of ways to choose 1 kind, then 4 of 4 of that kind, and the remaining card
2. $|S| =$ number of ways to choose 5 cards

$$P(E) = \frac{C(13,1)C(4,4)C(48,1)}{C(52,5)} = \frac{13 \cdot 1 \cdot 48}{2,598,960} \approx 0.00024$$
::::
:::: {.column width=.25}

\centering
\includegraphics[width=.85\textwidth]{images/probability/4-of-a-kind.png}

::::
:::


# Finite Probability

::: columns
:::: {.column width=.75}

\ex What is the probability of a poker hand that contains a full house, that is, 3-of-a-kind and 2-of-another-kind:

\pause
\vskip1em

\sol

Using the product rule:

1. $|E| = P(13,2)C(4,3)C(4,2)$ - number of ways to choose 2 kinds (use permutations because order matters), then choose 3 of 4 for the first kind, and choose 2 of 4 for the second kind.
2. $|S| =$ number of ways to choose 5 cards

$$\begin{array}{rcl}
P(13,2)C(4,3)C(4,2) & = & 12 \cdot 12 \cdot 4 \cdot 6 = |E| = 3744 \\
C(52,5) & = & |S| = 2,598,960 \\
p(E) & = & \frac{3744}{2,598,960} \approx 0.0014
\end{array}$$
::::
:::: {.column width=.25}

\centering
\includegraphics[width=.85\textwidth]{images/probability/full-house.png}

::::
:::


# Exercise

\exercise What is the probability that a five-card poker hand does not contain the queen of hearts?

\pause

\vskip1em

\sol

$$\begin{array}{rcl}
|E| & = & C(51,5) \\
|S| & = & C(52,5) \\
p(E)& = & \frac{C(51,5)}{C(52,5)} \\ \\
    & = & \frac{51!}{5!46!} \cdot \frac{5!47!}{52!} \\ \\
    & = & \frac{47}{52}
\end{array}$$

# Combinations of Events

* We can use counting techniques to find the probability of events derived from other events

\pause

* **Theorem:** Let $E$ be an event in a sample space $S$. The probability of the event $\overline{E} = S - E$, the complementary event of $E$, is given by:

  $$p(\overline{E}) = 1 - p(E)$$

  \prf If $\overline{E} = S - E$, then $|\overline{E}| = |S| - |E|$, thus

  $$p(\overline{E}) = \frac{|S| - |E|}{|S|} = 1 - \frac{|E|}{|S|} = 1 - p(E)$$

\pause

* We can also find the probability of the union of two events

\pause

* **Theorem:** Let $E_1$ and $E_2$ be events in the sample space $S$, then

  $$p(E_1 \cup E_2) = p(E_1) + p(E_2) - p(E_1 \cap E_2)$$

# Combinations of Events

* \ex A sequence of 10 bits is randomly generated. What is the probability that at least one of these bits is 0?

  \pause

  \sol Let $E$ be the event that at least one of the 10 bits is 0, then $\overline{E}$ is the event that all the bits are 1

  $$\begin{array}{rcl}
  p(E) & = & 1 - p(\overline{E}) = 1 - \frac{|\overline{E}|}{|S|} = 1 - \frac{1}{2^{10}} \\
       & = & 1 - \frac{1}{1024} = \frac{1023}{1024}
  \end{array}$$

\pause

* \ex What is the probability that a positive integer selected at random from the set of positive integers not exceeding 100 is divisible by either 2 or 5?

  \pause

  \sol

  Let $E_1 = \{x\, |\, x \in \mathbb{Z}^{+}_{100} \land 2\, |\, x\}$ and $E_2 = \{x\, |\, x \in \mathbb{Z}^{+}_{100} \land 5\, |\, x\}$

  $$\begin{array}{rcl}
  p(E_1 \cup E_2) & = & p(E_1) + p(E_2) - p(E_1 \cap E_2) \\
                  & = & \frac{50}{100} + \frac{20}{100} - \frac{10}{100} = \frac{3}{5}
  \end{array}$$

# Probabilistic Reasoning

* Analyzing the probability of events can be tricky. Thus reasoning about which two events is more likely is quite difficult.

\vskip.25em

* **Monty Hall 3-Door Problem:** 1 Large prize, 2 Losers, 3 Doors

::: columns
:::: column

\centering
\includegraphics[width=.6\textwidth]{images/probability/doors1.eps}

\scriptsize
Select a door.

::::
:::: column

$\Rightarrow$ probability you selected incorrectly $= 1 - p = 2/3$

::::
:::

\vskip1em

::: columns
:::: column

\centering
\includegraphics[width=.6\textwidth]{images/probability/doors2.eps}

\scriptsize
Keep your original choice, or select a different door.

::::
:::: column

$\Rightarrow$ Probability that you will win if you change doors $= 2/3$

$\therefore$ you should always change doors if given the chance.

::::
:::

# Exercises

::: columns
:::: column

\exercise Find the probability of winning a lottery by selecting the correct six integers, where the order in which these integers are selected does not matter, from the positive integers not exceeding 60.

\pause
\vskip1em

\sol

$$\begin{array}{rcl}
|S| & = & C(60,6) = \frac{60!}{6!54!} = 50063860 \\
|E| & = & 1 \\
p(E) & = & \frac{1}{50063860} \approx 0.00000002
\end{array}$$

::::
:::: column

\exercise What is the probability of selecting none of the correct six integers in a lottery, where the order in which these integers are selected does not matter, from the positive integers not exceeding 48

\pause
\vskip1em

\sol

$$\begin{array}{rcl}
|S| & = & C(48,6) = \frac{48!}{6!42!} = 12271512 \\
|E| & = & 1 \\
|p(\overline{E})| & = & 1 - 1 / 12271512 \\
                 & \approx & 0.999999919
\end{array}$$

::::
:::

#

\ts{Probability Theory}

# Introduction

* Laplace's definition of probability of an event assumes that all outcomes are equally likely
  * However, many experiments have outcomes that are not equally likely
  * How can we model such experiments

\pause
\vskip.5em

* In the following we will address such questions using the following concepts:
  * *Conditional Probability*
  * *Independence*
  * *Random Variables*

# Assigning Probabilities

* Let $S$ be the sample space of an experiment with a finite or countable number of outcomes.
  * We assign a probability $p(s)$ to each outcome $s$
  * Two conditions must be met:
    1. $0 \leq p(s) \leq 1$ for each $s \in S$
    2. $\underset{s \in S}{\sum} p(s) = 1$

\pause
\vskip.5em

* **Probability Distribution:** The function $p$ from the set of all outcomes of the sample space $S$
  * To model an experiment, the $p(s)$  assigned to outcome $s$ should equal the limit of the number of times $s$ occurs divided by the number of times the experiment is performed
  * This allows us to model experiments where outcomes are equally likely or not equally likely by choosing the appropriate $p(s)$

# Assigning Probabilities

* **Uniform Distribution:** Suppose $S$ is a set with $n$ elements. The *uniform distribution* assigns the probability $1/n$ to each element of $S$

\pause
\vskip.5em

* **Probability of Event E:** the sum of the probabilities of the outcomes in $E$. That is,

  $$p(E) = \underset{s \in E}{\sum} p(s),\,\, \text{where}\,\, p(\overline{E}) = 1 - p(E)$$

  \vskip.5em

  additionally, when $m = |E|$ and $n = |S|$

  $$p(E) = \underset{i = 1}{\overset{m}{\sum}}\frac{1}{n} = \frac{m}{n}$$

# Assigning Probabilities

* \ex What probabilities should we assign to the outcomes $H$ (heads) and $T$ (tails) when a fair coin is flipped?

  $$\text{\sol}\,\, p(H) = p(T) = 1/2$$

* What probabilities should be assigned to these outcomes when the coin is biased so that heads comes up twice as often as tails?

  \pause
  \vskip.5em

  \sol

  $$\begin{array}{rcl}
  p(H) & = & 2p(T) \\
  p(H) + p(T) & = & 1 \\
  2p(T) + p(T) & = & 1 \\
  3p(T) & = & 1 \\
  p(T) & = & 1/3 \\
  p(H) & = & 2/3
  \end{array}$$

# Assigning Probabilities

* If $E = \{a_1, a_2, \ldots, a_n\}$, then $p(E) = \sum^{n}_{i=1} p(a_i)$

\pause
\vskip.5em

* The experiment of selecting an element from a sample space with a uniform distribution is called selecting an element of $S$ **at random**

\pause
\vskip.5em

* **Sampling** - drawing a sequence , of a particular size, of elements from $S$ at random

\pause
\vskip.5em

* Furthermore, we can *sample* a sample space in two ways:
  * **Sampling with replacement:** where we may randomly select the same element more than once
  * **Sampling without replacement:** where we may randomly select an element only once

# Assigning Probabilities

\ex Suppose that a die is biased (or loaded) so that 3 appears twice as often as each other number, but that the other five outcomes are equally likely. What is the probability that an odd number appears when we roll this die?

\pause

\sol We want to find the probability of the event $E = \{1,3,5\}$

::: columns
:::: column
We know that:

\vskip-1em

$$\begin{array}{rcl}
p(3) & = & 2p(\overline{3}) \\
p(3) + 5p(\overline{3}) & = & 1 \\
2p(\overline{3}) + 5p(\overline{3}) & = & 1 \\
7p(\overline{3}) & = & 1 \\
p(\overline{3}) & = & 1/7 \\
p(3) & = & 2/7
\end{array}$$

::::
:::: column

\vskip1em

$$\begin{array}{rcl}
p(E) & = & p(1) + p(3) + p(5) \\
     & = & 1/7 + 2/7 + 1/7 \\
     & = & 4/7
\end{array}$$

\centering
\includegraphics[width=.2\textwidth]{images/probability/dice.png}

::::
:::

# Exercises

\exercise What probability should be assigned to the outcome of heads when a biased coin is tossed, if heads is three times as likely to come up as tails? What probability should be assigned to tails?

\pause
\vskip1em

\sol

$$\begin{array}{rcl}
p(H) & = & 3p(T) \\
p(H) + p(T) & = & 1 \\
3p(T) + p(T) & = & 1 \\
4p(T) & = & 1 \\
p(T) & = & 1/4 \\
p(H) & = & 3/4
\end{array}$$

# Event Combinations

* As we saw before, $p(E_1 \cup E_2) = p(E_1) + p(E_2) - p(E_1 \cap E_2)$

\pause
\vskip.5em

* However, if $E_1$ and $E_2$ are disjoint, $E_1 \cap E_2 = \varnothing$, then $p(E_1 \cap E_2) = 0$, then

  $$p(E_1 \cup E_2) = p(E_1) + p(E_2)$$

  \pause
\vskip.5em

* This is further generalized by the following theorem

\pause
\vskip.5em

* **Theorem:** If $E_1, E_2, \ldots$ is a sequence of finite or countably infinite number of pairwise disjoint events in a sample space $S$, then

  $$p\left(\underset{i}{\bigcup}E_i \right) = \underset{i}{\sum} p(E_i)$$

# Conditional Probability

* Suppose we flip a coin 3 times, and all 8 possibilities are equally likely.
  * However, if we know that event $F$, the first flip is tails, occurs
  * What is the probability of the event $E$, that an odd number of tails appears?
    * Since there are only 4 outcomes ($TTT$, $TTH$, $THT$, $THH$) and only 3 of them have an odd number of tails, and their is an equal probability of both, then the probability of $E$ is
      $1/2$
    * This is called the *conditional probability* of $E$ given $F$

\pause
\vskip.5em

* **Conditional Probability:** Let $E$ and $F$ be events with $p(F) > 0$. The *conditional probability* of $E$ given $F$, denoted $p(E\,|\, F)$, is defined as:

  $$p(E\,|\, F) = \frac{p(E \cap F)}{p(F)}$$

# Conditional Probability

\ex A bit string of length four is generated at random so that each of the 16 bit strings of length 4 is equally likely. What is the probability that it contains at least two consecutive 0's, given that its first bit is a 0?

\pause
\sol

* Let $E$ be the event that a bit string of length 4 contains at least two consecutive 0's
* Let $F$ be the event that the first bit of a bit string of length 4 is 0

::: columns
:::: column

$$\begin{array}{rcl}
p(E\,|\,F) & = & \frac{P(E \cap F)}{p(F)} \\
           & = & \frac{5/16}{1/2} \\
           & = & \frac{5}{8}
\end{array}$$

::::
:::: column

$$\begin{array}{rcl}
E \cap F & = & \{0000,\,0001,\,0010,\,0011,\,0100\} \\
p(E \cap F) & = & 5 / 16 \\
p(F) & = & 8 / 16 = 1/2
\end{array}$$

::::
:::

# Independence

* If we flipped a coin 3 times, does knowing that the first flip comes up tails (event $F$) alter the probability that tails comes up an odd number of times (event E)?
  * That is, does $p(E\,|\,F) = p(E)$?
  * Since, $p(E\,|\,F) = 1/2$ and $p(E) = 1/2$
  * We can say that $E$ and $F$ are *independent events*
    * Thus, $F$ provides no information about the probability of $E$

\pause
\vskip.5em

* **Independent Events:** The events $E$ and $F$ are *independent* iff

  $$p(E \cap F) = p(E)p(F)$$

# Independence

\footnotesize

\ex Suppose $E$ is the event that a randomly generated bit string of length four begins with a 1 and $F$ is the event that this bit string contains an even number of 1s. Are $E$ and $F$ independent, if the 16 bit strings of length four are equally likely?

\pause

\sol There are 8 length 4 bit strings that begin with 1 (1000, 1001, 1010, 1011, 1100, 1101, 1110, 1111). There are also 8 length 4 bit strings that contain an even number of ones (0000, 0011, 0101, 0110, 1001, 1100, 1111)

$$p(E) = p(F) = 8/16 = 1/2$$

because $E \cap F = \{1111,\,1100,\,1010,\,1001\}$

$$p(E \cap F) = 4/16 = 1/4$$

since,

$$p(E \cap F) = 1/4 = (1/2)(1/2) = p(E)p(F)$$

$\therefore$ $E$ and $F$ are independent

# Pairwise and Mutual Independence

* We can define independence of more than two events
  * However, this leads to two different types of independence

\pause
\vskip.5em

* **Pairwise Independence:** The events $E_1$ and $E_2$ are *pairwise independent* iff

  $$p(E_i \cap E_j) = p(E_i)p(E_j)$$

  for all pairs of integers $i$ and $j$ with $1 \leq i < j \leq n$

\pause
\vskip.5em

* **Mutually Independent:** The events $E_1$ and $E_2$ are *mutually independent* if

  $$p(E_{i_1} \cap E_{i_2} \cap \cdots \cap E_{i_m}) = p(E_{i_1})p(E_{i_2})\cdots p(E_{i_m})$$

  whenever $i_j,j = 1, 2, \ldots, m$, are integers with $1 \leq i_1 < i_2 < \cdots < i_m \leq n$ and $m \geq 2$

\pause
\vskip.5em

* We can then see that every set $n$ of mutually independent events is also pairwise independent but not vice versa.

# Exercises

\exercise Let $E$ and $F$ be the events that a family of $n$ children has children of both sexes and has at most one boy, respectively. Are $E$ and $F$ independent? If $n = 2$?

\pause
\vskip1em

\sol if n = 2: There are four combinations of children: BB, BG, GB, and GG. There are two combinations for a family with two children of both sexes (BG, GB). There are three combinations which have at most one boys (BG, GB, GG). Thus,

$$\begin{array}{rcl}
p(E) & = & 2/4 = 1/2 \\
p(F) & = & 3/4 \\
p(E \cap F) & = & 2/4 = 1/2 \\
p(E \cap F) = 1/2 & \ne & 3/8 = (1/2)(3/4) = p(E)p(F) \\
\end{array}$$

$\therefore$ $E$ and $F$ are not independent

# Bernoulli Trials

::: columns
:::: {.column width=.75}
* Suppose an experiment can have two outcomes
  * When a coin is flipped
  * When a bit is generated at random
* We call such experiments, **Bernoulli Trials**
  * Has two outcomes *success* or *failure*
  * If $p$ is the probability of success, and $q$ the probability of failure, then $p + q = 1$
* Bernoulli trials are *mutually independent* if the conditional probability of success on any given trial is $p$, given any other information about the outcomes of other trials

::::
:::: {.column width=.25}
\centering
\portrait{Daniel Bernoulli}{.7}{images/probability/DanielBernoulli.jpg}
::::
:::

* **Theorem:** The probability of exactly $k$ success in $n$ independent Bernoulli trials with probability of success $p$ and probability of failure $q = 1 - p$, is

  $$C(n,k)p^{k}q^{n-k}$$

# Bernoulli Trials

\ex A coin is biased so that the probability of heads is $2/3$.

What is the probability that exactly four heads come up when the coin is flipped seven times, assuming the flips are independent?

\pause

\sol There are 2^7 = 128 possible outcomes.

The number of ways four of the seven flips can be heads is $C(7,4)$

Because the seven flips are independent, the probability of each of these outcomes (4 H, 3 T) is $\left(2/3\right)^{4}(1/3)^{3}$

$$C(7,4)(2/3)^{4}(1/3)^{3} = \frac{35 \cdot 16}{3^7} = \frac{560}{2187}$$

# Binomial Distribution

* We can denote the probability of $k$ successes in $n$ independent Bernoulli trials with probability of success $p$ and probability of failure $q = 1 - p$ as

  $$b(k;\,n,\, p) = C(n, k)p^{k}q^{n-k}$$

\pause
\vskip.5em

* We call the function $b$ the **binomial distribution**

\pause
\vskip.5em

* The sum of a binomial distribution for $k = 0, 1, 2, \ldots, n$ equals

\pause
\vskip.5em

* \ex Suppose that the probability that a 0 bit is generated is 0.9, that the probability that a 1 bit is generate is 0.1, and that bits are generated independently.

  What is the probability that exactly eight 0 bits are generated when 10 bits are generated?

  $$\text{\sol}\,\,b(8;\,10,\,0.9) = C(10,8)(0.9)^{8}(0.1)^{2} = 0.1937102445$$

# Random Variables

* **Random Variables:** a function from the sample space of an experiment to the set of real numbers. That is, a random variable assigns a real number to each possible outcome.
  * It is neither a variable, nor random!

  $$X : S \to \mathbb{R}$$

\pause
\vskip.5em

* \ex Suppose a coin is flipped 3 times. Let $X(t)$ be the random variable that equals the number of heads that appear when $t$ is the outcome. Then $X(t)$ takes on the following values:

  $$\begin{array}{rcl}
  X(HHH) & = & 3 \\
  X(HHT) & = & X(HTH) = X(THH) = 2 \\
  X(TTH) & = & X(THT) = X(HTT) = 1 \\
  X(TTT) & = & 0
  \end{array}$$

# Random Variables

* **Distribution:** of a random variable $X$ on a sample space $S$ is the set of pairs $\left(r, p(X = r)\right)$ for all $r \in X(S)$, where $p(X = r)$ is the probability that $X$ takes the value $r$
  * The set of pairs in this distribution is determined by the probabilities $p(X = r)$ for $r \in X(S)$

\pause
\vskip.5em

* \ex Each of the eight outcomes when a fair coin is flipped three times has probability $1/8$. Thus, for the random variable $X(t)$ we have:

  \vskip.5em

  ::: columns
  :::: {.column width=.35}
  \centering
  *Definition*
  \vskip.5em

  $\begin{array}{rcl}
  X(HHH) & = & 3 \\
  X(HHT) & = & X(HTH) = X(THH) = 2 \\
  X(TTH) & = & X(THT) = X(HTT) = 1 \\
  X(TTT) & = & 0
  \end{array}$

  ::::
  :::: {.column width=.3}
  \centering
  *Probabilities*
  \vskip.5em

  $\begin{array}{rcl}
  P(X = 3) & = & 1/8 \\
  P(X = 2) & = & 3/8 \\
  P(X = 1) & = & 3/8 \\
  P(X = 0) & = & 1/8
  \end{array}$

  ::::
  :::: {.column width=.3}
  \centering
  *Set of pairs*
  \vskip.5em

  $\begin{array}{r}
  \{(3,1/8), \\
  (2,3/8), \\
  (1,3/8), \\
  (0,1/8)\}
  \end{array}$
  ::::
  :::: {.column width=.05}
  ::::
  :::

# Random Variables

\ex Let $X$ be the sum of the numbers that appear when a pair of dice is rolled.

What are the values of the random variable for the 36 possible outcomes $\left(i,j\right)$, where $i$ and $j$ are the numbers that appear for the first and second die, respectively, when these two dice are rolled?

\pause
\sol The random variable $X$ takes on the following values:

\footnotesize
$$\begin{array}{rcl}
X((1,1)) & = & 2 \\
X((1,2)) & = & X((2,1)) = 3 \\
X((1,3)) & = & X((2,2)) = X((3,1)) = 4 \\
X((1,4)) & = & X((2,3)) = X((3,2)) = X((4,1)) = 5 \\
X((1,5)) & = & X((2,4)) = X((3,3)) = X((4,2)) = X((5,1)) = 6 \\
X((1,6)) & = & X((2,5)) = X((3,4)) = X((4,3)) = X((5,2)) = X((6,1)) = 7 \\
X((2,6)) & = & X((3,5)) = X((4,4)) = X((5,3)) = X((6,2)) = 8 \\
X((3,6)) & = & X((4,5)) = X((5,4)) = X((6,3)) = 9 \\
X((4,6)) & = & X((5,5)) = X((6,4)) = 10 \\
X((5,6)) & = & X((6,5)) = 11 \\
X((6,6)) & = & 12
\end{array}$$

# The Birthday Problem

\ex\ **Birthday Problem** -- What is the minimum number of people who need to be in a room so that the probability that at least two of them have the same birthday is greater than $1/2$?

\pause
\sol

::: columns
:::: column

* *Assumptions:*

  1. Birthdays of people in the room are independent
  2. Each birthday is equally likely
  3. There are 366 days in a year

* *Solution Concept:*

  1. Find $p_n$, probability that these people all have different birthdays
  2. Find $1 - p_n$, probability that at least 2 people have the same birthday
  3. Calculate smallest number of people such that $1 - p_n > 1/2$

::::
:::: column

* for $2 \leq j \leq 366$, the probability of the $j$th person has a different birth than the $j-1$ people is:

  $$\begin{array}{rcl}
  \frac{366 - (j - 1)}{366} & = & \frac{367 - j}{366} \\
  p_n & = & \frac{365}{366} \cdot \frac{364}{366} \cdot \cdots \cdot \frac{367 - n}{366} \\
  1 - p_n & = & 1 - \frac{365}{366} \cdot \frac{364}{366} \cdot \cdots \cdot \frac{367 - n}{366} \\
  n & = & 23 \\
  1 - p_n & \approx & 0.506
  \end{array}$$

::::
:::

# Hashing Collisions

\ex What is the probability that no two keys are mapped to the same location by a hashing function $h(k)$?

\pause
\sol

::: columns
:::: column

* *Assumptions:*

  1. The probability that a randomly selected key is mapped to a location is $1/m$, where $m$ is the number of locations
  2. Keys are uniformly distributed
  3. Keys have an equal probability of being selected $\Rightarrow$ independently selected

::::
:::: column

\scriptsize

* Since keys are independent, the probability that all $n$ keys are mapped to different locations is

  $$p_n = \frac{m-1}{m}\cdot \frac{m-2}{m} \cdot \cdots \cdot \frac{m - n + 1}{m}$$

* The probability that at least one collision occurs is

  $$1 - p_n = 1 - \frac{m-1}{m}\cdot \frac{m-2}{m} \cdot \cdots \cdot \frac{m - n + 1}{m}$$

* Smallest $n$ for $\left(1 - p_n\right) > 1/2$ is $n = 1.777\sqrt{m}$
  * when $m = 1,000,000$ the smallest $n$ for $\left(1 - p_n\right) > 1/2$ is 1178

::::
:::

# Monte Carlo Algorithms

* All of the previous algorithms discussed are _deterministic_
  * That is, they always proceed in the same way for the same input

\pause
\vskip.5em

* Sometimes, we want the algorithm to make a random choice at one or more steps
  * To avoid a huge or unknown number of steps or possible cases

\pause
\vskip.5em

* Such algorithms are called **probabilistic algorithms**
  * A special type, for decision problems, are called *Monte Carlo Algorithms*
    * These algorithms always produce a solution, but there is a small chance it is incorrect

# Monte Carlo Algorithms

* These algorithms provide a solution to a decision problem using a sequence of tests

\pause
\vskip.5em

* The probability of a correct answer increases as more tests are executed
  * Each test can result in:
    * *"True"* $\to$ answer is *true* and no more iterations are needed
    * _"Unknown"_ $\to$ answer could be true or false
  * After all iterations, the final answer is
    * _True_, if one iteration (or more) yielded "True"
    * _False_, if all iterations yielded "Unknown"

\pause
\vskip.5em

* Examples
  * Quality Control
  * Primality Testing

# The Probabilistic Method

* A powerful technique to create _nonconstructive existence proofs_

\pause
\vskip.5em

* The idea is that we want to prove results about a set $S$, such as the existence of an element in $S$ with a specified property
  * To do this, we assign probabilities to the elements of $S$
  * Then to show that such an element exists with the specified property if there is an element $x \in S$ that has a positive probability

\pause
\vskip.5em

* **The Probabilistic Method:** If a probability that an element chosen at random from a set $S$ does not have a particular property is less than $1$, then there exists an element in $S$ with this property

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
