---
author:
- Dr. Isaac Griffith
title: Recursion
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Recursion

* A *self referential* style of definition useful when it is difficult to directly define objects

\vskip.5em

* We can use recursion to define
  * Sequences
  * Functions
  * Algorithms
  * Data Structures

\vskip.5em

* A **recursive** or **inductive definition** requires two components
  * **Basis Step (or Base Case):** which defines an initial element or defines the simplest form of a problem that can be directly solved
  * **Recursive Step:** provides a rule by which the current element uses a previous one, or a means by which a larger problem is subdivided into the smaller problem

\vskip.5em

* The functional form of recursion is a form of the **Divide and Conquer** algorithm design strategy

# Outline

The lecture if structured as follows:

::: columns
:::: {.column width=.7}
* Recursively Defined Functions
* Algorithms
  * Search
  * Sorting
  * String Matching
  * Greedy
* Data Recursion
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
\begin{minipage}{.775\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Recursively Defined Functions
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Recursively Defined Functions

* Recursively defined functions are **well-defined**
  * for every positive integer, the value of the function at this integer is determined in an unambiguous way.

::: columns
:::: column

* Suppose $f$ is defined recursively by:

  $\begin{array}{rcl}
  f(0)     & = & 3 \\
  f(n + 1) & = & 2 f(n) + 3
  \end{array}$

\vskip.5em

* Find $f(1)$, $f(2)$, $f(3)$, $f(4)$:

  $\begin{array}{rclclcl}
  f(1) & = & 2f(0) + 3 & = & 2 \cdot 3 + 3  & = & 9 \\
  f(2) & = & 2f(1) + 3 & = & 2 \cdot 9 + 3  & = & 21 \\
  f(3) & = & 2f(2) + 3 & = & 2 \cdot 21 + 3 & = & 45 \\
  f(4) & = & 2f(3) + 3 & = & 2 \cdot 45 + 3 & = & 93
  \end{array}$

::::
:::: column

* Give a recursive definition of:

  \begin{equation*}
  \overset{n}{\underset{k = 0}{\sum}}a_k
  \end{equation*}

  **Basis Case:** $\overset{0}{\underset{k = 0}{\sum}}a_k = a_0$

  \vskip.5em

  **Recursive Case:** $\overset{n + 1}{\underset{k = 0}{\sum}}a_k = \left(\overset{n + 1}{\underset{k = 0}{\sum}}a_k\right) + a_{n+1}$

::::
:::

# Factorial

* We can define the function $n!$ as: $n! = 1 \times 2 \times \ldots \times n$

\vskip.5em

* However, this is far too imprecise for implementation

::: columns
:::: column

* We can define $n!$ recursively

  \vskip.5em

  **Basis Step:** $0! = 1$

  \vskip.5em

  **Recursive Step:** $\left(n + 1\right)! = (n + 1) \times n!$

::::
:::: column

**Haskell Implementation:**

```haskell
factorial :: Int -> Int
factorial 0 = 1
factorial (n + 1) = (n + 1) * factorial n
```

::::
:::

# Recursion Over Lists

* Recursion over lists
  * *Base Case:* `[]`, the empty list
  * *Recursive Case:* the non-empty list i.e., `(x:xs)`

::: columns
:::: column

* General Form:

  \scriptsize

  ```haskell
  f :: [a] -> type of result
  f []     = result of empty list
  f (x:xs) = result defined using (f xs) and x
  ```
  \normalsize

\vskip.5em

* Example: `length`

  \scriptsize

  ```haskell
  length :: [a] -> Int
  length []     = 0
  length (x:xs) = 1 + length xs
  ```

::::
:::: column

```
length [1,2,3]
  = 1 + length [2,3]
  = 1 + (1 + length [3])
  = 1 + (1 + (1 + length []))
  = 1 + (1 + (1 + 0))
  = 3
```

* It is better to think of recursion as a systematic calculation using a high-level equational view rather than via a low-level machine view

::::
:::

# Recursion Over Lists

::: columns
:::: column

* Another Simple Example: `sum`

  ```haskell
  sum :: Num a => [a] -> a
  sum []     = 0
  sum (x:xs) = x + sum xs
  ```

  \vskip.5em

  ```
  sum [1,2,3]
    = 1 + sum [2,3]
    = 1 + (2 + sum [3])
    = 1 + (2 + (3 + sum []))
    = 1 + (2 + (3 + 0))
    = 6
  ```

::::
:::: column

* Returning a List: `(++)`

  ```haskell
  (++) :: [a] -> [a] -> [a]
  [] ++ ys     = ys
  (x:xs) ++ ys = x : (xs ++ ys)
  ```

  \vskip.5em

  ```
  [1,2,3] ++ [9,8,7,6]
    = 1 : ([2,3] ++ [9,8,7,6])
    = 1 : (2 : ([3] ++ [9,8,7,6]))
    = 1 : (2 : (3 : ([] ++ [9,8,7,6])))
    = 1 : (2 : (3 : [9,8,7,6]))
    = 1 : (2 : [3,9,8,7,6])
    = 1 : [2,3,9,8,7,6]
    = [1,2,3,9,8,7,6]
  ```

::::
:::


# Recursion Over Lists

::: columns
:::: column

* Recursing over 2 lists: `zip`

  \scriptsize

  ```haskell
  zip :: [a] -> [b] -> [(a, b)]
  zip [] ys         = []
  zip xs []         = []
  zip (x:xs) (y:ys) = (x, y) : zip xs ys
  ```

  \vskip.5em

  ```
  zip [1,2,3,4] ['A','*','q']
    = (1, 'A') : zip [2,3,4] ['*', 'q']
    = (1, 'A') : ((2, '*') : zip [3,4] ['q'])
    = (1, 'A') : ((2, '*') : ((3, 'q') : zip [4] []))
    = (1, 'A') : ((2, '*') : ((3, 'q') : []))
    = (1, 'A') : ((2, '*') : [(3, 'q')])
    = (1, 'A') : [(2, '*'), (3, 'q')]
    = [(1, 'A'), (2, '*'), (3, 'q')]
  ```

::::
:::: column

* Recursing a list of lists: `concat`

  \scriptsize

  ```haskell
  concat :: [[a]] -> [a]
  concat []       = []
  concat (xs:xss) = xs ++ concat xss
  ```

  \vskip.5em

  ```
  concat [[1], [2,3], [4,5,6]]
    = [1] ++ concat [[2,3], [4,5,6]]
    = [1] ++ ([2,3] ++ concat [[4,5,6]])
    = [1] ++ ([2,3] ++ [4,5,6])
    = [1] ++ [2,3,4,5,6]
    = [1,2,3,4,5,6]
  ```

::::
:::

# Higher-Order Recursive Functions

* Each of the prior recursive functions are quite similar

\vskip.5em

* It would be elegant if we had a function which express this general computational pattern

\vskip.5em

* Such a general function would need to be provided both
  * the functions inputs
  * the computation (a function) to perform

\vskip.5em

* Such functions are called **higher order functions** or a **combinator**

\vskip.5em

* We have several choices of **combinators**
  * `map` - takes a function and applies it to all items in a list $\Rightarrow$ List
  * `zipWith` - takes a function and applies it to all items in two lists $\Rightarrow$ List
  * `foldr` and `foldl` - takes a function, aggregation variable, and applies to the function to combine the list values into the var $\Rightarrow$ singleton variable

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Algorithms
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Algorithms

* There are many general classes of problems that arise in Discrete Mathematics and Computing

\vskip.5em

* The key to solving such problems is to
  1. Construct a model that translates the problem into a mathematical context
  2. Define a method that will solve the general problem using the model

\vskip.5em

* The second step is the purview of *algorithm* design

\vskip.5em

* **Algorithm:** a finite sequence of precise instructions for performing a computation or for solving a problem
  * Typically expressed in English or Pseudocode

\vskip.5em

* **Pseudocode:** an intermediate step between an English language description of an algorithm and an implementation of the algorithm in a programming language

# Pseudocode Example

* Finding the maximum element in a finite sequence

  \vskip.5em

  \begin{algorithmic}
  \Procedure{max}{A}
    \State $\mathit{max} \coloneqq A_1$
    \For{$i \coloneqq 2$ \textbf{to} $n$}
      \If{$\mathit{max} < A_i$} $\mathit{max} \coloneqq A_i$ \EndIf
    \EndFor
    \State \Return $\mathit{max}$
  \EndProcedure
  \end{algorithmic}

\vskip.5em

* To gain insight into how an algorithm works it is useful to construct a **trace** that shows the steps for a given specific input.


# Algorithm Properties

* Algorithms generally share several properties:
  * **Input:** An algorithm has input values from a specified set
  * **Output:** From each set of input values an algorithm produces output values from a specific set.
    * The *output* values are the solution to the problem
  * **Definiteness:** The steps of an algorithm must be defined precisely
  * **Correctness:** An algorithm should produce the correct output values for each set of input values
  * **Finiteness:** An algorithm should produce the desired output after a finite (but perhaps large) number of steps for any input in the set
  * **Effectiveness:** It must be possible to perform each step of an algorithm exactly and in a finite amount of time
  * **Generality:** The procedure should be applicable for all problems of the desired form, not just for a particular set of input values.

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Search Algorithms
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Search Algorithms

* **Search Problem Definition:** Locate an element $x$ in a list of distinct elements, $a_1, a_2, \ldots, a_n$, or determine that it is not in the list

\vskip1em

* The solution to this problem is the location of the term int he list that equals $x$ and $0$ if $x$ is not in the list.

\vskip1em

* This is one of the most commonly occurring problems in computer science, and occurs in many different contexts

# Linear Search

* **Linear Search (sequential search):** searches an ordered list $\left(a_1, a_2, \ldots, a_n\right)$ for some value $x$, starting at $a_1$ and ending at $a_n$ terminating when either the value if found (i.e., $x = a_i$) or the end of the list is reached.

\vskip.5em

::: columns
:::: column

**Iterative Linear Search Alg:**

\vskip.5em

\begin{algorithmic}
\Procedure{linearSearch}{$A,x$}
  \State $i \coloneqq 1$
  \While{$i \leq n$ \textbf{and} $x \neq A_i$}
    \State $i \coloneqq i + 1$
  \EndWhile
  \If{$i \leq n$} $\mathit{location} \coloneqq i$
  \Else $\,\,\mathit{location} \coloneqq 0$
  \EndIf
  \State \Return $\mathit{location}$
\EndProcedure
\end{algorithmic}

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/algs/linsearch_iter.eps}

::::
:::

# Linear Search

::: columns
:::: column

**Recursive Linear Search Alg:**

  * $A \to \textrm{array/list to search}$
  * $i \to \textrm{current index}$
  * $j \to \textrm{size of list}$
  * $x \to \textrm{value to find}$

\vskip.5em

\begin{algorithmic}
\Procedure{linSearch}{$A,i,j,x$}
  \If{$A_i = x$}
    \State \Return $i$
  \ElsIf{$i = j$}
    \State \Return 0
  \Else
    \State \Return \Call{linSearch}{$A$, $i+1$, $j$, $x$}
  \EndIf
\EndProcedure
\end{algorithmic}

\vskip.5em

* Requires: $O(n)$ comparisons

::::
:::: column

**Haskell Implementation:**

\scriptsize

```haskell
linSearch :: Eq a => [a] -> Int -> a -> Int
linSearch [] _ _     = 0
linSearch (y:ys) i x =
    if x == y then i
    else linSearch ys (i + 1) x
```

\centering
\includegraphics[width=.65\textwidth]{images/algs/linsearch_rec.eps}

::::
:::

# Binary Search

* Can be used when the list is ordered in either ascending or descending order
* Successively searches smaller and smaller sections, until either the item is found or not
* Requires $O(\log n)$ comparisons

::: columns
:::: column

\begin{algorithmic}
\Procedure{binSearch}{$A,x$}
  \State $i \coloneqq 1$
  \State $j \coloneqq n$
  \While{$i < j$}
    \State $m \coloneqq \floor*{(i + j) / 2}$
    \If{$x > A_m$} $i \coloneqq m + 1$
    \Else $\,\,j \coloneqq m$
    \EndIf
  \EndWhile
  \If{$x = A_j$} $\mathit{location} \coloneqq i$
  \Else $\,\,\mathit{location} \coloneqq 0$
  \EndIf
  \State \Return $\mathit{location}$
\EndProcedure
\end{algorithmic}

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/algs/binsearch_iter.eps}

::::
:::

# Binary Search

::: columns
:::: column

**Recursive Binary Search Alg:**

  * $A \to \textrm{array/list to search}$
  * $i \to \textrm{current index}$
  * $j \to \textrm{size of list}$
  * $x \to \textrm{value to find}$

\vskip.5em

\scriptsize

\begin{algorithmic}
\Procedure{binSearch}{$A,i,j,x$}
  \State $m \coloneqq \floor*{(i + j) / 2}$
  \If{$x = A_m$} \Return $m$
  \ElsIf{$x < A_m$ \textbf{and} $i < m$}
    \State \Return \Call{binSearch}{$A$, $i$, $m - 1$, $x$}
  \ElsIf{$x > A_m$ \textbf{and} $j > m$}
    \State \Return \Call{binSearch}{$A$, $m + 1$, $j$, $x$}
  \Else \Return $0$
  \EndIf
\EndProcedure
\end{algorithmic}

\normalsize

\vskip.5em

* Requires $O(\log n)$ comparisons

::::
:::: column

**Haskell Implementation**

\footnotesize

```haskell
  binSearch :: (Ord a) => [a] -> a -> Int -> Int -> Int
  binSearch arr x lo hi
    | hi < lo = -1
    | pivot > x = binSearch arr x lo (mid - 1)
    | pivot < x = binSearch arr x (mid + 1) hi
    | otherwise =  mid
    where
      mid = lo + (hi - lo) `div` 2
      pivot = arr!!mid
```

::::
:::

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Sorting Algorithms
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Sorting

* **Sorting:** the problem of ordering a collection of element (i.e., a list or set)
  * This problem occurs in many contexts, including:
    * Telephone directory
    * Addresses in mailing lists
    * Directory of songs for download
    * Dictionaries
* A significant amount of computing resources is devoted to sorting $\Rightarrow$ a large amount of effort has gone into developing efficient sorting algs
  * 100+ existing sorting algorithms
  * Recently Timsort and Library Sort were developed

# Insertion Sort

::: columns
:::: column

\vskip-1em
\scriptsize

\begin{algorithmic}
\Procedure{sort}{$A$}
  \For{$j \coloneqq 2$ \textbf{to} $n$}
    \State $i \coloneqq 1$
    \While{$A_j > A_i$}
      \State $i \coloneqq i + 1$
    \EndWhile
    \State $m \coloneqq A_j$
    \For{$k \coloneqq 0$ \textbf{to} $j - i - 1$}
      \State $A_{j-k} \coloneqq A_{j-k-1}$
    \EndFor
    \State $A_i \coloneqq m$
  \EndFor
\EndProcedure
\end{algorithmic}

\vskip.5em

**Haskell Implementation:**

\vskip-.5em

\tiny

```haskell
    insert :: (Ord a) => a -> [a] -> [a]
    insert x [] = [x]
    insert x (y:ys)
      | x < y     = x:y:ys
      | otherwise = y : (insert x ys)

    sort :: (Ord a) => [a] -> [a]
    sort []     = []
    sort (x:xs) = insert x (sort xs)
```

::::
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/algs/insert_sort.eps}

::::
:::

# Merge Sort

::: columns
:::: column

* Idea is to recursively split the list in half until each piece is size 1 or less
* Each sublist is then merged to form a sorted combined list
* **Lemma:** Two sorted lists with $m$ and $n$ elements can be merged into a sorted list in no more than $m + n - 1$ comparisons.
* **Theorem:** The number of comparisons needed to merge sort a list with $n$ elements is $O(n \log n)$

::::
:::: column

\centering
\includegraphics[width=.7\textwidth]{images/algs/merge_sort.eps}

::::
:::

# Merge Sort

::: columns
:::: column

**The Algorithm**

\footnotesize
\vskip.5em

\begin{algorithmic}
\Procedure{mSort}{$L$}
  \If{$n > 1$}
    \State $m \coloneqq \floor*{n / 2}$
    \State $L1 \gets L_1,L_2,\ldots,L_m$
    \State $L2 \coloneqq L_{m+1},L_{m+2},\ldots,L_n$
    \State $L$ $\coloneqq$ \Call{merge}{\textsc{mSort}($L1$), \textsc{mSort}($L2$)}
  \EndIf
\EndProcedure
\end{algorithmic}

\vskip1em

\begin{algorithmic}
\Procedure{merge}{$L1,L2$}
  \State $L \coloneqq [\,\,]$
  \While{$L1$ and $L2$ are both nonempty}
    \State remove smaller of $L1_1$ and $L2_1$, add to $L$
  \EndWhile
  \If{one list is empty}
    \State remove all elements of the other list and append to $L$
  \EndIf
  \State \Return $L$
\EndProcedure
\end{algorithmic}

::::
:::: column

**Haskell Implementation**

\tiny

```haskell
  merge :: (Ord a) => [a] -> [a] -> [a]
  merge [] [] = []
  merge [] ys = ys
  merge xs [] = xs
  merge allX@(x:xs) allY@(y:ys)
    | x > y     = y : merge allX ys
    | otherwise = x : merge xs allY

  sort :: (Ord a) => [a] -> [a]
  sort [] = []
  sort [a] = [a]
  sort [a,b]
    | a > b     = [b, a]
    | otherwise = [a, b]
  sort list =
    let split = splitAt(length list `div` 2) list
        firstHalf  = sort (fst split)
        secondHalf = sort (snd split)
    in merge firstHalf secondHalf
```

::::
:::

# QuickSort

* A sorting approach based on the idea of *divide and conquer* where we take a list and we attempt to successively cut it in half to make the problem size smaller

\vskip.5em

* The goal is to gain more than by reducing by one while also ensuring the recursion will complete

\vskip.5em

* The algorithm in a nutshell works as follows:
  * **Base Case:** empty list $\to$ empty list
  * **Recursive Case:** non-empty list
    * Select a *pivot* (typically the first or last item in the list)
    * We then select all items from the list < pivot and quick sort those and add them before the pivot
    * We select all items from the list $\geq$ pivot and quick sort them and place them after the pivot

# QuickSort

::: columns
:::: {.column width=.6}

**The Algorithm:**

\vskip.5em

\scriptsize

::::: columns
:::::: column

\begin{algorithmic}
\Procedure{sort}{$L,\mathit{lo},\mathit{hi}$}
  \If{$\mathit{lo} \geq \mathit{hi}$ \textbf{or} $\mathit{lo} < 0$}
    \State \Return
  \EndIf
  \State $p \coloneqq $ \Call{partition}{$L, \mathit{lo}, \mathit{hi}$}
  \State \Call{sort}{$L,\mathit{lo},p - 1$}
  \State \Call{sort}{$L,p + 1, \mathit{hi}$}
\EndProcedure
\end{algorithmic}

::::::
:::::: column

\begin{algorithmic}
\Procedure{partition}{$L,\mathit{lo},\mathit{hi}$}
  \State $\mathit{pivot} \coloneqq L_{\mathit{lo}}$
  \State $i \coloneqq \mathit{lo}$
  \For{$j \coloneqq \mathit{lo}$ \textbf{to} $\mathit{hi} - 1$}
    \If{$L_i \leq \mathit{pivot}$}
      \State $i \coloneqq i + 1$
      \State swap $L_i$ with $L_j$
    \EndIf
  \EndFor
  \State swap $L_i$ with $L_{\mathit{lo}}$
  \State \Return $i$
\EndProcedure
\end{algorithmic}

::::::
:::::

**Haskell Implementation:**

\scriptsize

```haskell
quickSort :: Ord a => [a] -> [a]
quickSort [] = []
quickSort (pivot:xs) =
  quickSort [y | y <- xs, y < pivot]
  ++ [pivot]
  ++ quicksort [y | y <- xs, y >= pivot]
```

::::
:::: {.column width=.4}

\vfill
\centering
\includegraphics[width=.85\textwidth]{images/algs/quick_sort.eps}

::::
:::

#

\centering
\vfill
\begin{minipage}{.425\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge String Matching
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# String Matching

**String Matching:** finding where a particular string of characters $P$, called a *pattern*, occurs, if it does, within another string $T$, called the *text*

* this is another commonly occurring problem with a wide array of applications, including:
  * Text editing
  * Spam filters
  * Detecting network attacks
  * Search engines
  * Plagiarism detection
  * Bioinformatics
  * and many others

# String Matching

::: columns
:::: column

**Naive String Matcher**

\vskip.5em

\footnotesize

\begin{algorithmic}
\Procedure{match}{$n,m,T,P$}
  \For{$s \coloneqq 0$ \textbf{to} $n - m$}
    \State $j \coloneqq 1$
    \While{$j \leq m$ \textbf{and} $T_{s + j} = P_j$}
      \State $j \coloneqq j + 1$
    \EndWhile
    \If{$j > m$} \textbf{print} "s is a valid shift"
    \EndIf
  \EndFor
\EndProcedure
\end{algorithmic}

\normalsize

\vskip.5em

**Haskell Implementation**

\vskip.5em

\scriptsize

```haskell
match :: [Char] -> [Char] -> Int -> [Int]
match [] _ _ = []
match _ [] _ = []
match p allT@(t:ts) i =
  let l = length p
      n = take l allT
  in if (n == p) then i : (match p ts (i + 1))
     else match p ts (i + 1)
```

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/algs/string_match.eps}

::::
:::

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Greedy Algorithms
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Greedy Algorithms

* **Optimization Problems:** Problems where the goal is to find a solution to the given problem that either minimizes or maximizes the value of some parameter. Examples include:
  * Finding a route between two cities with the least total mileage
  * Encoding a message using the fewest bits possible

\vskip.5em

* **Greedy Algorithms:** Algorithm design strategy, wherein we select the "best" choice at each step rather than attempt to consider all sequences of steps that may lead to the optimal solution
  * Once we know a greed alg finds a feasible solution, then we must prove it is an optimal one

\vskip.5em

* Greedy algs are often the approach used to solve optimization problems

# Greedy Algorithms

* Make $n$ cents change with Quarters, dimes, nickels, and pennies using the least total number of coins.

::: columns
:::: column

\begin{algorithmic}
\Procedure{change}{$\mathit{Coins}, n$}
  \For{$i \coloneqq 1$ \textbf{to} $r$}
    \State $D_i \coloneqq 0$
    \While{$n \leq \mathit{Coins}_i$}
      \State $D_i \coloneqq D_i + 1$
      \State $n \coloneqq n - \mathit{Coins}_i$
    \EndWhile
  \EndFor
  \State \Return $D$
\EndProcedure
\end{algorithmic}

* The proof of optimality can be found in DMA on page 211

::::
:::: column

\vskip-1em
\centering
\includegraphics[width=.5\textwidth]{images/algs/change.eps}

::::
:::

#

\centering
\vfill
\begin{minipage}{.415\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Data Recursion
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Peano Arithmetic

* This date structure serves as an example of a recursive ADT

  ```haskell
  data Peano = Zero | Succ Peano deriving Show
  ```

* **Example:**

  ```haskell
  1 = Succ Zero
  2 = Succ (Succ (Succ Zero))
  ```

* Some operations:

\vspace{-1em}

::: columns
:::: column

\scriptsize

```haskell
  decrement :: Peano -> Peano
  decrement zero = Zero
  decrement (Succ a) = a

  add :: Peano -> Peano -> Peano
  add Zero b     = b
  add (Succ a) b = Succ (add a b)
```

::::
:::: column

\scriptsize

```haskell
  sub :: Peano -> Peano -> Peano
  sub a Zero            = a
  sub Zero b            = Zero
  sub (Succ a) (Succ b) = sub a b

  lt :: Peano -> Peano -> Bool
  lt a        Zero     = False
  lt Zero     (Succ b) = True
  lt (Succ a) (Succ b) = lt a b
```

::::
:::

# Data Recursion

* Recursive functions are useful in nearly all programming languages
  * They are especially important for data structures such as Trees and Graphs.

\vskip.5em

* **Data Recursion:** An important technique that uses recursion to define data structures

::: columns
:::: {.column width=.05}
::::
:::: {.column width=.475}
* \footnotesize The idea is to define *circular* data structures
* \footnotesize **Example**: An infinite list of 1's

  \footnotesize
  ```haskell
  f :: a -> [a]
  f x = x : fx
  ones = f 1
  ```

* \footnotesize Rather than a function, we could simply use a circular list

  \footnotesize
  ```haskell
  twos = 2 : twos
  ```
::::
:::: {.column width=.475}

\centering
\includegraphics[width=.85\textwidth]{images/algs/circular.eps}

::::
:::

# Data Recursion

* Data recursion is possible in languages like Haskell due to the use of *lazy evaluation*

\vskip.5em

* **Lazy Evaluation:** is a technique where expressions are not evaluated until their value is actually needed

\vskip.5em

* However, most imperative languages (such as C or Java) do not support this and thus we cannot construct infinite data structures in this manner
  * Rather, they would cause an infinite loop

\vskip.5em

* Yet, we can create circular data structures in other ways

# Recursively Defined Strings

* Recursion can play a role when working with strings

\vskip.5em

* We can define a string over an alphabet $\sum$ as a finite sequence of symbols from $\sum$
  * We can then define $\sum^{*}$ as the set of strings over $\sum$
  * The recursive definition is:

    \vskip0.5em

    **Basis Step:** $\lambda \in \sum^{*}$ (where $\lambda$ is the empty string)

    \vskip0.5em

    **Recursive Step:** if $w \in \sum^{*}$ and $x \in \sum^{*}$, then $wx \in \sum^{*}$


\vskip.5em

* **Example:** $\sum = \{0, 1\}$, $\sum^{*} = \{\lambda,\,\, 0,\,\, 1,\,\, 00,\,\, 01,\,\, 10,\,\, 11,\,\, \ldots\}$

* Basic string operations can also be defined recursively, for example
  * Concatenation
  * Length

<!--
# WFFs in Logic

* As we noted in the Logic lectures a the WFF definition is also recursive

  **Basis Step:** $T$, $F$, and $s$, where $s$ is a propositional variable, are WFF

  **Recursive Step:** If $E$ and $F$ are WFF, then $\left(\lnot E\right)$, $\left(E \land F\right)$, $\left(E \lor F\right)$, $\left(E \to F\right)$, and $\left(E \leftrightarrow F\right)$ are WFF
-->

# Recursively Defined Trees

::: columns
:::: column

* **Graph:** A data structure composed of vertices and edges connecting pairs of vertices

  * Graphs can be constructed by defining each node with an equation in a `let` expression
  * Thus, each node can be referred to by any other node (including itself)

    ```haskell
    object = let a = 1 : b
                 b = 2 : c
                 c = [3] ++ a
             in a
    ```

    \vskip1em

    \centering
    \includegraphics[width=.85\textwidth]{images/algs/graph.eps}

::::
:::: column

* **Tree:** A special type of graph

\vskip2.5em

\centering
\includegraphics[width=.85\textwidth]{images/algs/tree.eps}

::::
:::

# Rooted Trees

* **Rooted Tree:** a tree consisting of vertices containing a distinguished vertex called the *root* and edges connecting these vertices.
  * We can define such a structure recursively

::: columns
:::: column

\footnotesize

**Basis Step:** A single vertex $r$ is a rooted tree

\vskip1em

**Recursive Step:** Suppose that $T_1, T_2, \ldots, T_n$ are disjoint rooted trees with roots $r_1, r_2, \ldots, r_n$. Then the graph formed by starting with a root $r$ not in any $T_i$ and adding an edge from $r$ to each of the vertices $r_1, \ldots, r_n$, is also a rooted tree.

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/algs/rooted_trees.eps}

::::
:::

# Binary Trees

* **Binary Tree:** A rooted tree in which a vertex may have only two children, each of which is a subtree
  * **Full Binary Tree:** if a vertex has children, it must have both a left and right child
  * **Extended Binary Tree:** either the left or right subtree may be empty

\centering
\includegraphics[width=.65\textwidth]{images/algs/bintree.eps}

# Extended Binary Trees

::: columns
:::: column

* The set of *extended binary trees* is defined as:

  \footnotesize
  \vskip.5em

  **Basis Step:** the empty set is an extended binary tree

  \vskip.5em

  **Recursive Step:** If $T_1$ and $T_2$ are disjoint extended binary trees, there is an extended binary tree denoted $T_1\cdot T_2$, consisting of a root $r$ together with edges connecting $r$ to the roots of $T_1$ (left) and $T_2$ (right) when $T_1$ and $T_2$ are nonempty.

::::
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/algs/extended_bintree.eps}

::::
:::

# Full Binary Trees

::: columns
:::: column

* Recursively defined as:

  \footnotesize
  \vskip.5em

  **Basis Step:** There is a full binary tree consisting of only a single vertex $r$

  \vskip1em

  **Recursive Step:** If $T_1$ and $T_2$ are disjoint fully binary trees, there is a full binary tree denoted $T_1 \cdot T_2$, consisting of a root $r$ together with edges connecting $r$ to the roots of $T_1$ and $T_2$

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/algs/full_bintree.eps}

::::
:::

<!-- #

\centering
\vfill
\begin{minipage}{.625\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Inductively Defined Sets
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage} -->

# Inductively Defined Sets

* One approach for defining sets is to simply enumerate all of its elements.
  * Unfortunately, this is impractical for all but the smallest sets
  * For larger sets, we could simply use an ellipsis "$\ldots$" to indicate the definition continues.
    * However, this is an informal approach which is both imprecise and ambiguous

\vskip.5em

* What we need is an approach that can define these types of sets which is concise, precise, and unambiguous

# The Idea Behind Induction

* Induction is sort of a form of mathematical programming which produces a proof when needed
  * i.e., we can assert that something is a member of a set defined by induction

\vskip.5em

* **Example:**

  \begin{center}
  $\begin{array}{rcl}
  0 \in S &     & \\
  n \in S & \to & n + 1 \in S
  \end{array}$
  \end{center}

* By *modus ponens* and the first assertion we can deduce $1 \in S$, by similar reasoning we can also deduce $2 \in S$

\vskip.5em

* Furthermore, we can continually build up this chain for **any** natural number

# The Idea Behind Induction

* Such inductive definitions can show that a set contains a value $v$, but requires us to enumerate the values prior to $v$

\vskip.5em

* **Sequence:** a set with an ordering
  * The inductively enumerated values form a *sequence*

\vskip.5em

* Computationally we can use this idea to generate sets

::: columns
:::: column

```haskell
imp1 :: Integer -> Integer
imp1 1 = 2
imp1 x = error "premise does not match"

imp2 :: integer -> Integer
imp2 2 = 3
imp x = error "premise does not match"
```

::::
:::: column

```haskell
s :: [Integer]
s = [1, imp1 (s!!0), imp2 (s!!1)]
```

::::
:::

<!--
# Exercises
-->


# The Induction Rule

* Recall,

\begin{center}
$\begin{array}{rclr}
0 \in S &     & \{\textrm{base case}\} \\
n \in S & \to & \{\textrm{induction case}\}
\end{array}$
\end{center}

\vskip.5em

* The *induction case* generate the links of the chain which define the set, starting from the base case
  * By simply modifying our induction rule, we can create completely different sets

    \begin{equation*}
    n \in S \to n + 2 \in S
    \end{equation*}

    This rule generates the set of even natural number, however if we change the base case to be $1 \in S$, this
    same induction case then generates the set of odd natural numbers.

# The Induction Rule

* Our prior implementation was fairly restricted

\vskip.5em

* If we want to implement the following set:

  \vskip.5em

  $\begin{array}{rcl}
  0 \in S & & \\
  x \in S & \to & x + 1 \in S
  \end{array}$


\vskip.5em

::: columns
:::: column

* We can do the following

  ```haskell
  increment :: Integer -> Integer
  increment x = x + 1

  s :: [Integer]
  s = 0 : map increment s
  ```

::::
:::: column

* This style of programming is called **data recursion**
* *map* will proceed down $s$, creating each value it needs, then using it.

::::
:::

<!--
# Exercises
-->

# For Next Time

::: columns
:::: column
* Review DMUC Chapter 3 and 9
* Review DMA Chapters 3.1 and 5.3 - 5.5
* Review this Lecture
* Read DMUC Chapter 4
* Read DMA Chapters 5.1 - 5.2
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
