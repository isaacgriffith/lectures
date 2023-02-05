---
author:
- Isaac Griffith
title: ISP Example
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

* Utilize ISP to develop tests

::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{../../../images/brain-gears.jpg}
::::
:::

# Inspiration

\vfill
> "Blame doesn't fix bugs." – Anonymous

#

\centering
\vfill
\begin{minipage}{.75\textwidth}
\begin{minipage}{3.5em}
\vskip-3em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge ISP Example
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 6630}
\end{minipage}
\end{minipage}

# In-Class Extended Example

* Download the Iterator handout

* Close books
* We will go through the steps for designing an IDM for Iterator
* After each step, we will stop & discuss as a class

# Task I: Determine Characteristics

Step 1: Identify:

* Functional units
* Parameters
* Return types and return values
* Exceptional behavior

\centering
\Large\color{Roarange} \textbf{Work...}

# Task I: Determine Characteristics

\begin{center}
Step 1: Identify:
\end{center}

* `hasNext()` - Returns true if more elements
* `E next()` - Returns next element
  - Exception: `NoSuchElementException`
* `void remove()` - Removes the most recent element returned by the iterator
  - Exception: `UnsupportedOperationException`
  - Exception: `IllegalStateException`
* parameters: state of the iterator
  - iterator state changes with `next()`, and `remove()` calls
  - modifying underlying collection also changes iterator state

# Task I: Determine Characteristics

\begin{center}
Develop Characteristics\\Table A:
\end{center}

\scriptsize

+-----------+--------+---------+-------------+-----------+------+----------------+------------+
| Method    | Params | Returns | Values      | Exception | ChID | Characteristic | Covered By |
+:==========+:=======+:========+:============+:==========+:=====+:===============+:===========+
| `hasNext` | state  | boolean | true, false |           |      |                |            |
+-----------+--------+---------+-------------+-----------+------+----------------+------------+
| `next`    | state  | E       | E, null     |           |      |                |            |
+-----------+--------+---------+-------------+-----------+------+----------------+------------+
| `remove`  | state  |         |             |           |      |                |            |
+-----------+--------+---------+-------------+-----------+------+----------------+------------+

\centering
\Large\color{Roarange} \textbf{Work...}

# Task I: Determine Characteristics

\begin{center}
Develop Characteristics\\Table A:
\end{center}

\scriptsize

+-----------+--------+---------+-------------+-----------+----------------+-------------------------+------------+
| Method    | Params | Returns | Values      | Exception | ChID           | Characteristic          | Covered By |
+:==========+:=======+:========+:============+:==========+:===============+:========================+:===========+
| `hasNext` | state  | boolean | true, false |           | \color{red} C1 | \color{red} More values |            |
+-----------+--------+---------+-------------+-----------+----------------+-------------------------+------------+
| `next`    | state  | E       | E, null     |           |                |                         |            |
+-----------+--------+---------+-------------+-----------+----------------+-------------------------+------------+
| `remove`  | state  |         |             |           |                |                         |            |
+-----------+--------+---------+-------------+-----------+----------------+-------------------------+------------+

# Task I: Determine Characteristics

\begin{center}
Develop Characteristics\\Table A:
\end{center}

\scriptsize

+-----------+--------+---------+-------------+-----------+----------------+-------------------------------------+------------+
| Method    | Params | Returns | Values      | Exception | ChID           | Characteristic                      | Covered By |
+:==========+:=======+:========+:============+:==========+:===============+:====================================+:===========+
| `hasNext` | state  | boolean | true, false |           | C1             | More values                         |            |
+-----------+--------+---------+-------------+-----------+----------------+-------------------------------------+------------+
| `next`    | state  | E       | E, null     |           | \color{red} C2 | \color{red} Returns non-null object |            |
+-----------+--------+---------+-------------+-----------+----------------+-------------------------------------+------------+
| `remove`  | state  |         |             |           |                |                                     |            |
+-----------+--------+---------+-------------+-----------+----------------+-------------------------------------+------------+

# Task I: Determine Characteristics

\begin{center}
Develop Characteristics\\Table A:
\end{center}

\scriptsize

+-----------+--------+---------+-------------+---------------------------+------+-------------------------+------------------------+
| Method    | Params | Returns | Values      | Exception                 | ChID | Characteristic          | Covered By             |
+:==========+:=======+:========+:============+:==========================+:=====+:========================+:=======================+
| `hasNext` | state  | boolean | true, false |                           | C1   | More values             |                        |
+-----------+--------+---------+-------------+---------------------------+------+-------------------------+------------------------+
| `next`    | state  | E       | E, null     |                           | C2   | Returns non-null object |                        |
+-----------+--------+---------+-------------+---------------------------+------+-------------------------+------------------------+
|           |        |         |             | \color{red} NoSuchElement |      |                         | \color{red} C1         |
+-----------+--------+---------+-------------+---------------------------+------+-------------------------+------------------------+
| `remove`  | state  |         |             |                           |      |                         |                        |
+-----------+--------+---------+-------------+---------------------------+------+-------------------------+------------------------+

# Task I: Determine Characteristics

\begin{center}
Develop Characteristics\\Table A:
\end{center}

\scriptsize

+-----------+--------+---------+-------------+-------------------------+----------------+--------------------------------+------------+
| Method    | Params | Returns | Values      | Exception               | ChID           | Characteristic                 | Covered By |
+:==========+:=======+:========+:============+:========================+:===============+:===============================+:===========+
| `hasNext` | state  | boolean | true, false |                         | C1             | More values                    |            |
+-----------+--------+---------+-------------+-------------------------+----------------+--------------------------------+------------+
| `next`    | state  | E       | E, null     |                         | C2             | Returns non-null object        |            |
+-----------+--------+---------+-------------+-------------------------+----------------+--------------------------------+------------+
|           |        |         |             | NoSuchElement           |                |                                | C1         |
+-----------+--------+---------+-------------+-------------------------+----------------+--------------------------------+------------+
| `remove`  | state  |         |             | \color{red} Unsupported | \color{red} C3 | \color{red} remove() supported |            |
+-----------+--------+---------+-------------+-------------------------+----------------+--------------------------------+------------+

# Task I: Determine Characteristics

\begin{center}
Develop Characteristics\\Table A:
\end{center}

\scriptsize

+-----------+--------+---------+-------------+--------------------------+----------------+-------------------------------------+------------+
| Method    | Params | Returns | Values      | Exception                | ChID           | Characteristic                      | Covered By |
+:==========+:=======+:========+:============+:=========================+:===============+:====================================+:===========+
| `hasNext` | state  | boolean | true, false |                          | C1             | More values                         |            |
+-----------+--------+---------+-------------+--------------------------+----------------+-------------------------------------+------------+
| `next`    | state  | E       | E, null     |                          | C2             | Returns non-null object             |            |
+-----------+--------+---------+-------------+--------------------------+----------------+-------------------------------------+------------+
|           |        |         |             | NoSuchElement            |                |                                     | C1         |
+-----------+--------+---------+-------------+--------------------------+----------------+-------------------------------------+------------+
| `remove`  | state  |         |             | Unsupported              | C3             | remove() supported                  |            |
+-----------+--------+---------+-------------+--------------------------+----------------+-------------------------------------+------------+
|           |        |         |             | \color{red} IllegalState | \color{red} C4 | \color{red} remove() constraint sat |            |
+-----------+--------+---------+-------------+--------------------------+----------------+-------------------------------------+------------+

# Task I: Determine Characteristics

\begin{center}
Step4: Design a partitioning\\
Which methods is each characteristic relevant for?\\
How can we partition each characteristic?\\
Table B:
\end{center}

\centering
\scriptsize

+----+-------------------------+-------------+----------+------------+-----------+
| ID | Characteristic          | `hasNext()` | `next()` | `remove()` | Partition |
+:===+:========================+:============+:=========+:===========+:==========+
| C1 | More values             |             |          |            |           |
+----+-------------------------+-------------+----------+------------+-----------+
| C2 | Returns non-null object |             |          |            |           |
+----+-------------------------+-------------+----------+------------+-----------+
| C3 | remove() supported      |             |          |            |           |
+----+-------------------------+-------------+----------+------------+-----------+
| C4 | remove() constraint sat |             |          |            |           |
+----+-------------------------+-------------+----------+------------+-----------+

\centering
\Large\color{Roarange} \textbf{Work...}

# Task I: Determine Characteristics

\begin{center}
Step4: Design a partitioning\\
Relevant characteristics for each method\\
Table B:
\end{center}

\centering
\scriptsize

+----+-------------------------+---------------+---------------+---------------+-----------+
| ID | Characteristic          | `hasNext()`   | `next()`      | `remove()`    | Partition |
+:===+:========================+:=============:+:=============:+:=============:+:==========+
| C1 | More values             | \color{red} X | \color{red} X | \color{red} X |           |
+----+-------------------------+---------------+---------------+---------------+-----------+
| C2 | Returns non-null object |               | \color{red} X | \color{red} X |           |
+----+-------------------------+---------------+---------------+---------------+-----------+
| C3 | remove() supported      |               |               | \color{red} X |           |
+----+-------------------------+---------------+---------------+---------------+-----------+
| C4 | remove() constraint sat |               |               | \color{red} X |           |
+----+-------------------------+---------------+---------------+---------------+-----------+

# Task I: Determine Characteristics

\begin{center}
Step4: Design a partitioning\\
Table B:
\end{center}

\centering
\scriptsize

+----+-------------------------+-------------+----------+------------+--------------------------+
| ID | Characteristic          | `hasNext()` | `next()` | `remove()` | Partition                |
+:===+:========================+:===========:+:========:+:==========:+:=========================+
| C1 | More values             | X           | X        | X          | \color{red} {True,False} |
+----+-------------------------+-------------+----------+------------+--------------------------+
| C2 | Returns non-null object |             | X        | X          | \color{red} {True,False} |
+----+-------------------------+-------------+----------+------------+--------------------------+
| C3 | remove() supported      |             |          | X          | \color{red} {True,False} |
+----+-------------------------+-------------+----------+------------+--------------------------+
| C4 | remove() constraint sat |             |          | X          | \color{red} {True,False} |
+----+-------------------------+-------------+----------+------------+--------------------------+

\begin{center}
\Large \textbf{Done with task I!}
\end{center}

# Task II: Define Test Req'ts

* Step 1: Choose coverage criterion
* Step 2: Choose base cases if needed

\centering
\Large\color{Roarange} \textbf{Work...}

# Task II: Define Test Req'ts

* Step 1: Base coverage criterion (**BCC**)
* Step 2: Happy path (**all true**)
* Step 3: Test requirements...

# Task II: Define Test Req'ts

* Step 3: Test Requirements

\begin{center}
Table C:
\end{center}

\scriptsize

+-----------+-----------------+-------------------+----------------+
| Method    | Characteristics | Test Requirements | Infeasible TRs |
+:==========+:================+:==================+:===============+
| `hasNext` | C1              |                   |                |
+-----------+-----------------+-------------------+----------------+
| `next`    | C1 C2           |                   |                |
+-----------+-----------------+-------------------+----------------+
| `remove`  | C1 C2 C3 C4     |                   |                |
+-----------+-----------------+-------------------+----------------+

\centering
\Large\color{Roarange} \textbf{Work...}

# Task II: Define Test Requirements

* Step 3: Test Requirements

\begin{center}
Table C:
\end{center}

\scriptsize

+-----------+-----------------+--------------------------------------------------+----------------+
| Method    | Characteristics | Test Requirements                                | Infeasible TRs |
+:==========+:================+:=================================================+:===============+
| `hasNext` | C1              | \color{red} \{**T**, F\}                         |                |
+-----------+-----------------+--------------------------------------------------+----------------+
| `next`    | C1 C2           | \color{red} \{**TT**, FT, TF\}                   |                |
+-----------+-----------------+--------------------------------------------------+----------------+
| `remove`  | C1 C2 C3 C4     | \color{red} \{**TTTT**, FTTT, TFTT, TTFT, TTTF\} |                |
+-----------+-----------------+--------------------------------------------------+----------------+

# Task II: Define Test Requirements

* Step 3: Test Requirements

\begin{center}
Table C:
\end{center}

\scriptsize

+-----------+-----------------+------------------------------------+-----------------+
| Method    | Characteristics | Test Requirements                  | Infeasible TRs  |
+:==========+:================+:===================================+:===============:+
| `hasNext` | C1              | {**T**, F}                         | \color{red}none |
+-----------+-----------------+------------------------------------+-----------------+
| `next`    | C1 C2           | {**TT**, FT, TF}                   | \color{red}FT   |
+-----------+-----------------+------------------------------------+-----------------+
| `remove`  | C1 C2 C3 C4     | {**TTTT**, FTTT, TFTT, TTFT, TTTF} | \color{red}FTTT |
+-----------+-----------------+------------------------------------+-----------------+

* C1 = F: has no values
* C2 = T: returns non-null

# Task II: Define Test Req'ts

* Step 5: Revised infeasible test requirements

\begin{center}
Table C:
\end{center}

\scriptsize

+-----------+-----------------+------------------------------------+----------------+-----------------------------+--------------+
| Method    | Characteristics | Test Requirements                  | Infeasible TRs | Revised TRs                 | #TRs         |
+:==========+:================+:===================================+:==============:+:===========================:+:============:+
| `hasNext` | C1              | {**T**, F}                         | none           | \color{red}n/a              | \color{red}2 |
+-----------+-----------------+------------------------------------+----------------+-----------------------------+--------------+
| `next`    | C1 C2           | {**TT**, FT, TF}                   | FT             | \color{red}FT -> F**F**     | \color{red}3 |
+-----------+-----------------+------------------------------------+----------------+-----------------------------+--------------+
| `remove`  | C1 C2 C3 C4     | {**TTTT**, FTTT, TFTT, TTFT, TTTF} | FTTT           | \color{red}FTTT -> F**F**TT | \color{red}5 |
+-----------+-----------------+------------------------------------+----------------+-----------------------------+--------------+

\begin{center}
\Large \textbf{Done with task II!}
\end{center}

# Task III: Automate Tests

* First, we need an implementation of Iterator
  - (`Iterator` is just an interface)
  - `ArrayList` implements `Iterator`
* Test fixture has two variables:
  - `List` of strings
  - `Iterator` for strings
* `setUp()`
  - Creates a list with two strings
  - Initializes an iterator

# Task III: Automate Tests

* `remove()` adds another complication

\begin{block}

\textit{"The behavior of an iterator is unspecified if the underlying collection is modified while the iteration is in progress in any way other than by calling this method"}

\end{block}

* Subsequent behavior of the iterator is undefined!
  - This is a constraint on the caller: i.e., a precondition
* Preconditions are usually bad:
  - Legitimate callers often make the call anyway and then depend on whatever the implementation happens to do
  - Malicious callers deliberately exploit "bonus behavior"

# Task III: Automate Tests

* A merely competent tester...

  \pause
  would not test preconditions

  \pause
  All specified behaviors have been tested!

\pause
* A good tester...

  \pause
  ... with a mental discipline of quality ...

  \pause
  would ask ...

\pause

\centering
\Large \textbf{What happens if a test violates the precondition?}

# Tests that Violate Preconditions

* Finding inputs that violate a precondition is easy
  - But what assertion do you write in the JUnit test?

```java
   List<String> list = ... // [cat, dog]
   Iterator<String> itr = list.iterator();
   itr.next(); // can assert! return value is cat
   list.add("elephant"); // just killed the iterator
   itr.next(); // cannot assert!
```

* Note: In the Java collection classes, the `Iterator` precondition has been replaced with defined behavior
  - `ConcurrentModificationException`
* That means we can write tests in this context

# Task I: Determine Characteristics

\begin{center}
Cycle back to add another exception -- Table A revised
\end{center}

\scriptsize

+-----------+--------+---------+------------+------------------------+------+-------------------------+------------+
| Method    | Params | Returns | Values     | Exception              | ChID | Characteristic          | Covered By |
+:==========+:=======+:========+:===========+:=======================+:=====+:========================+:===========+
|           |        |         |            |                        |      |                         |            |
+-----------+--------+---------+------------+------------------------+------+-------------------------+------------+

\centering
\Large\color{Roarange} \textbf{Work...}

# Task I: Determine Characteristics

\begin{center}
Cycle back to add another exception -- Table A revised
\end{center}

\scriptsize

+-----------+--------+---------+------------+------------------------------------+-----------------+-------------------------+---------------+
| Method    | Params | Returns | Values     | Exception                          | ChID            | Characteristic          | Covered By    |
+:==========+:=======+:========+:===========+:===================================+:================+:========================+:==============+
| `hasNext` | state  | boolean | true,false |                                    | C1              | More values             |               |
+-----------+--------+---------+------------+------------------------------------+-----------------+-------------------------+---------------+
|           |        |         |            | \color{red}Concurrent Modification |                 |                         | \color{red}C5 |
+-----------+--------+---------+------------+------------------------------------+-----------------+-------------------------+---------------+
| `next`    | state  | E       | E, null    |                                    | C2              | Returns non-null        |               |
+-----------+--------+---------+------------+------------------------------------+-----------------+-------------------------+---------------+
|           |        |         |            | NoSuchElement                      |                 |                         | C1            |
+-----------+--------+---------+------------+------------------------------------+-----------------+-------------------------+---------------+
|           |        |         |            | \color{red}Concurrent Modification |                 |                         | \color{red}C5 |
+-----------+--------+---------+------------+------------------------------------+-----------------+-------------------------+---------------+
| `remove`  | state  |         |            | Unsupported                        | C3              | remove() supported      |               |
+-----------+--------+---------+------------+------------------------------------+-----------------+-------------------------+---------------+
|           |        |         |            | IllegalState                       | C4              | remove() constraint sat |               |
+-----------+--------+---------+------------+------------------------------------+-----------------+-------------------------+---------------+
|           |        |         |            | \color{red}Concurrent Modification | \color{red}C5   | Collection not modified |               |
+-----------+--------+---------+------------+------------------------------------+-----------------+-------------------------+---------------+

# Task II: Define Test Requirements

* Cycle back to step 5: Revised infeasible test requirements

\begin{center}
Table C revised:
\end{center}

\centering
\scriptsize

+--------+-----------------+-------------------+----------------+-------------+-------+
| Method | Characteristics | Test Requirements | Infeasible TRs | Revised TRs | # TRs |
+:=======+:================+:==================+:===============+:============+:======+
|        |                 |                   |                |             |       |
+--------+-----------------+-------------------+----------------+-------------+-------+

\centering
\Large\color{Roarange} \textbf{Work...}

# Task II: Define Test Requirements

* Cycle back to step 5: Revised infeasible test requirements

\begin{center}
Table C revised:
\end{center}

\scriptsize

+-----------+----------------------------------------+------------------------------------------------+----------------+--------------------+---------------------------+
| Method    | Characteristics                        | Test Requirements                              | Infeasible TRs | Revised TRs        | # TRs                     |
+:==========+:=======================================+:===============================================+:===============+:===================+:=========================:+
| `hasNext` | C1 \color{red}C5\color{black}          | {**TT**, FT, TF}                               | none           | n/a                | \color{red}3\color{black} |
+-----------+----------------------------------------+------------------------------------------------+----------------+--------------------+---------------------------+
| `next`    | C1 C2 \color{red}C5\color{black}       | {**TTT**, FTT, TFT, TTF}                       | FTT TTF        | FTT -> F**F**T     | \color{red}4\color{black} |
+-----------+----------------------------------------+------------------------------------------------+----------------+--------------------+---------------------------+
| `remove`  | C1 C2 C3 C4 \color{red}C5\color{black} | {**TTTTT**, FTTTT, TFTTT, TTFTT, TTTFT, TTTTF} | FTTTT          | FTTTT -> F**F**TTT | \color{red}6\color{black} |
+-----------+----------------------------------------+------------------------------------------------+----------------+--------------------+---------------------------+

# Task III: Automate Tests

\vfill

## Test Availability

All tests are available on the Moodle

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
