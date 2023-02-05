---
author:
- Dr. Isaac Griffith
title: More Haskell and Equational Reasoning
shortTitle: Haskell and Equational Reasoning
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Inspiration

> "My basic idea is that programming is the most powerful medium of developing the sophisticated and rigorous thinking needed for mathematics, for grammar, for physics, for statistics, for all the "hard" subjects ... In short, I believe more than ever that programming should be a key part of the intellectual development of people growing up." -- Seymour Papert

# Outcomes

After today's lecture you will:

::: columns
:::: {.column width=.7}
* Learn more about Haskell
  - Pattern matching in function definitions
  - Higher order functions
  - Conditional Expressions
  - Let Expressions
  - Type Variables
  - Common List Functions
  - Type Definitions and Type Classes
* Learn and be able to use Equational Reasoning
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
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Functions
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Pattern Matching

* \small The standard means of defining a function requires a name which will take on a value during function application.

\vskip.1em

* \small However there is another approach called \textcolor{Roarange}{\textbf{Pattern Matching}}
  - \footnotesize allows us to setup a series of cases, which against which the input is checked.
  - \footnotesize it is wise to start with the most specific and ending with the most general

\vskip.1em

* \small What can we match against
  - \footnotesize Constant values such as `3` or `"abc"`
  - \footnotesize Empty lists or empty tuples: `[]` or `()`
  - \footnotesize A placeholder for which we don't care about: `_`

\vskip.1em

* \small Example:

  \footnotesize
  ```haskell
  is_three :: Int -> Bool
  is_three 3 = True
  is_three _ = False
  ```

# Pattern Matching Tuples

* \small We can pattern match on tuples to have direct access to its contents:

  ```haskell
    fst :: (a, b) -> a  -- argument is a pair
    fst (x, y) = x

    snd :: (a, b) -> b
    snd (x, y) -> y
  ```

\vskip.5em

* \small If we need access to the original tuple we can use the following notation:
  - `pair@(x, y)`
  - Here `pair` is the name storing the original argument, and `x` and `y` the contents

# Pattern Matching Lists

* \small Because we can construct lists with the cons `(:)` operator, we can use this to match on a list

  \footnotesize
  ```haskell
    isEmpty :: [a] -> Bool
    isEmpty [] = True      -- matches on the empty list (most specific)
    isEmpty (x:xs) = False -- matches a list with at least one item, x, and a following list xs
  ```

\vskip.5em

* \small Again, we can access the original containing list as follows:
  - \footnotesize `list@(x:xs)`
  - \footnotesize Where `list` is the name storing the original list, `x` the first item of the list, and `xs` the remainder of the list (or the empty list).

\vskip.5em

* \small Additionally:
  - \footnotesize `(x:y:xs)` - allows access to the first two items of the list and will only match a list with 2 or more items
    - \scriptsize `x` is the first item, `y` is the second item, and `xs` the rest of the list, or the empty list

# Higher Order Functions

* \small Haskell considers functions to be \textcolor{Buttons}{\textit{first class objects}}
  - \footnotesize Functions can be stored in data structures
  - \footnotesize Functions can be passed as arguments to other functions
  - \footnotesize Functions can be used to create new functions

\vskip.5em

* \small \textcolor{Roarange}{\textbf{First Order Function}} - any function whose arguments and results are ordinary data values

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Higher Order Function}} - any function that takes a function as an argument, or that returns a function as a result
  - \footnotesize These lead to extremely power programming techniques

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Full Application}} - an expression providing all arguments to a function

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Partial Application}} - an expression providing less than the required arguments, which results in a new function

# Higher Order Functions

\centering
\Large Example: `twice`
\normalsize

\vskip1em

::: columns
:::: column

\textcolor{Roarange}{\textbf{Definition}}

  \scriptsize

  ```haskell
  twice :: (a -> a) -> a -> a
  twice f x = f (f x)
  ```

::::
:::: column

\textcolor{Roarange}{\textbf{Equational Reasoning}}

\small Given an application: `twice sqrt 81`, we can work out its application as follows:

\scriptsize
\begin{eqnarray*}
twice & sqrt & 81 \\
    = & sqrt & (sqrt\,\, 81) \\
    = & sqrt & 9 \\
    = & 3 &
\end{eqnarray*}

::::
:::

# Higher Order and Partial Application

\centering
\Large Example: `prod`
\normalsize

\vskip1em

::: columns
:::: column

\textcolor{Roarange}{\textbf{Definition:}}

\scriptsize
```haskell
twice :: (a -> a) -> a -> a
twice f x = f (f x)

prod :: Integer -> Integer -> Integer
prod x y = x * y
```

::::
:::: column

\textcolor{Roarange}{\textbf{Partial Application:}}

\scriptsize
```haskell
  g = prod 4     -- partial app
  p = g 6        -- full app of g
  q = twice g 3
```

\textcolor{Roarange}{\textbf{Results:}}

\scriptsize
```haskell
  p => 24
  q => 48
```

::::
:::

# Conditional Expressions

* \small \textcolor{Roarange}{\textbf{Conditional Expression}} - an expression using a `Bool` condition to make a choice

\vskip.5em

* \small Syntax:

  \small
  `if` \textcolor{Buttons}{\textit{Boolean\_expression}} `then` \textcolor{Buttons}{\textit{expr1}} `else` \textcolor{Buttons}{\textit{expr2}}

  \vskip.25em

  - \footnotesize All parts must be present
  - \footnotesize If the \textcolor{Buttons}{\textit{Boolean\_expression}} is true, then \textcolor{Buttons}{\textit{expr1}} is executed
  - \footnotesize Otherwise, \textcolor{Buttons}{\textit{expr2}} is executed
  - \footnotesize Type of \textcolor{Buttons}{\textit{expr1}} and \textcolor{Buttons}{\textit{expr2}} must be the same

\vskip.5em

::: columns
:::: column

* \small Example:

  \scriptsize
  ```haskell
  if 2 < 3 then "bird" else "fish"
  ```

::::
:::: column

* \small Example:

  \scriptsize
  ```haskell
  abs :: Integer -> Integer
  abs x = if x < 0 then -x else x
  ```

::::
:::

# Bad Conditional Expressions

* \small The following are examples of poorly constructed conditional expression (which won't compile)

  \scriptsize
  ```haskell
  if 2 < 3 then 10            -- missing else expression
  if 2 + 2 then 1 else 2      -- must be Bool after if
  if True then "bird" else 7  -- different types
  ```

# Local Variables: `let` Expressions

* \small `let` expressions set up an explicit local scope to define a set of variables for use in an expression

\vskip.5em

* \small General form:

  \scriptsize
  ```haskell
    let equation
        equation
        ...
        equation
    in expression
  ```

\vskip.5em

* \small Components of this are:
  - \footnotesize The \textcolor{Buttons}{\textit{equations}} define the variables local to the let scope
  - \footnotesize The `in` \textcolor{Buttons}{\textit{expression}} is the value of the entire `let` expression

\vskip.5em

* \small `let` expressions may be used anywhere an expression may be used

# `let` Expression Examples

\scriptsize
```haskell
  quadratic :: Double -> Double -> Double -> (Double, Double)
  quadratic a b c
    = let d = sqrt (b^2 - 4 * a * c)
          x1 = (-b + d) / (2 * a)
          x2 = (-b - d) / (2 * a)
        in (x1, x2)
```

\vskip.5em

\scriptsize
```haskell
  2 + let x = sqrt 9 in (x + 1) * (x - 1)
    => 10.0
```

# Type Variables

* \small Often we want to define functions that accept \textcolor{Buttons}{\textit{any}} type in their arguments

\vskip.5em

* \small To do this we use \textcolor{Roarange}{\textbf{type variables}}
  - \footnotesize These must begin with a lower case letter (convention is to use `a`, `b`, and so on)

\vskip.5em

* \small Examples:

  \scriptsize
  ```haskell
    fst :: (a, b) -> a
    snd :: (a, b) -> b
  ```

\vskip.5em

* \small Functions using type variables are said to be \textcolor{Roarange}{\textbf{polymorphic}}
  - \footnotesize Additionally, they enhance reusability

#

\centering
\vfill
\begin{minipage}{.625\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Common List Functions
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# `length` and `(!!)`

::: columns
:::: column

\textcolor{Roarange}{\textbf{The `length` Function}}

* \small Returns the number of elements in a list

  \scriptsize
  ```haskell
    length :: [a] -> Int

    length [2,8,1] => 3
    length [] => 0
    length "hello" => 5
    length [1..n] => n
    length [1..] => infinite loop
  ```

::::
:::: column

\textcolor{Roarange}{\textbf{The `!!` (index) Operator}}

* \small Accesses a list element by index (starting at 0)

  \scriptsize
  ```haskell
    (!!) :: [a] -> Int -> a

    [1,2,3] !! 0 => 1
    "abcde" !! 2 => 'c'
  ```

::::
:::

# `take` and `drop`

::: columns
:::: column

\textcolor{Roarange}{\textbf{The `take` Function}}

* \small extracts the first `n` elements from a list

  \scriptsize
  ```haskell
    take :: Int -> [a] -> [a]

    take 2 [1,2,3] => [1,2]
    take 0 [1,2,3] => []
    take 4 [1,2,3] => [1,2,3]
  ```

::::
:::: column

\textcolor{Roarange}{\textbf{The `drop` (index) Operator}}

* \small removes the first `n` elements form a list

  \scriptsize
  ```haskell
    drop :: Int -> [a] -> [a]

    drop 2 [1,2,3] => [3]
    drop 0 [1,2,3] => [1,2,3]
    drop 4 [1,2,3] => []
  ```

::::
:::

# `(++)` and `map`

::: columns
:::: column

\textcolor{Roarange}{\textbf{The `++` (append) Operator}}

* \small joins two lists (of the same type) together

  \scriptsize
  ```haskell
    (++) :: [a] -> [a] -> [a]

    [1,2] ++ [3,4,5] => [1,2,3,4,5]
    [] ++ "abc" => "abc"
  ```

::::
:::: column

\textcolor{Roarange}{\textbf{The `map` Function}}

* \small Applies a given function (first arg) to each element of a list (second arg)

  \scriptsize
  ```haskell
    map :: (a -> b) -> [a] -> [b]

    map toUpper "the cat" => "THE CAT"
    map (* 10) [1,2,3] => [10,20,30]
  ```

* \small Effectively this is a replacement for a \textcolor{Roarange}{\textbf{for}} loop

::::
:::

# `zip` and `zipWith`

::: columns
:::: column

\textcolor{Roarange}{\textbf{The `zip` Function}}

* \small pairs up the elements of two lists

  \tiny
  ```haskell
    zip :: [a] -> [b] -> [(a, b)]

    zip [1,2,3] "abc" => [(1, 'a'), (2, 'b'), (3, 'c')]
    zip [1,2,3] "ab" => [(1, 'a'), (2, 'b')]
    zip [1,2] "abc" => [(1, 'a'), (2, 'b')]
  ```

::::
:::: column

\textcolor{Roarange}{\textbf{The `zipWith` Function}}

* \small applies a function to each pair of items from two lists

  \tiny
  ```haskell
    zipWith :: (a -> b -> c) -> [a] -> [b] -> [c]

    zipWith (+) [2,4,..10] [1,3,..10] => [3,7,11,14,19]
    zipWith (*) [1,2,3] [1,2,3] => [1,4,9]
  ```

::::
:::

# `foldl` and `foldr`

* \small \textcolor{Roarange}{\textbf{fold}} - iteration across a list executing a function to reduce the list to an accumulated value

::: columns
:::: column

\textcolor{Roarange}{\textbf{The `foldl` Function}}

* \small A fold starting from the left

  \scriptsize
  ```haskell
    foldl (+) a [p,q,r,s]
      = (((a + p) + q) +  r) + s
  ```

  - `(+)` - function to be applied
  - `a` - starting value
  - `[p,q,r,s]` input list
::::
:::: column

\textcolor{Roarange}{\textbf{The `foldr` Function}}

* \small A fold starting from the right

  \scriptsize
  ```haskell
    foldr :: (a -> b -> b) -> b -> [a] -> b

    foldr (+) a [p,q,r,s]
      = p + (q + (r + (s + a)))
  ```

  - `(+)` - function to be applied
  - `a` - starting value
  - `[p,q,r,s]` input list
::::
:::

# `foldl` and `foldr`

::: columns
:::: column

\textcolor{Roarange}{\textbf{The `foldl` Function}}

\scriptsize
```haskell
  foldl max 0 [1,2,3]
    => max (max (max 0 1) 2) 3
    => max (max 1 2) 3
    => max 2 3
    => 3

  foldl (-) 0 [1,2,3]
    => (-) ((-) ((-) 0 1) 2) 3
    => (-) ((-) -1 2) 3
    => (-) -3 3
    => -6
```

::::
:::: column

\textcolor{Roarange}{\textbf{The `foldr` Function}}

\scriptsize
```haskell
  foldr (-) 0 [1,2,3]
    => (-) 1 ((-) 2 ((-) 3 0))
    => (-) 1 ((-) 2 3)
    => (-) 1 -1
    => 2

  foldr (:) [3,4,5] [1,2]
    => (:) 1 ((:) 2 [3,4,5])
    => [1,2,3,4,5]

  foldr (||) False [True, False, True] => True
```

::::
:::

# Composition

\textcolor{Roarange}{\textbf{The `.` (composition) Operator}}

* \small Allows us to create a pipeline of function applications, each of which is awaiting an argument

  \scriptsize
  ```haskell
    (toUpper . toLower) 'A' => 'A'

    ((:) . toUpper) 'a' "bc" => "Abc"
  ```

#

\centering
\vfill
\begin{minipage}{.57\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Data Type Definitions
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Data Type Definitions

* \small Often we need to define data types that are better suited to our needs than lists or tuples

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Algebraic Data Types}} - a flexible form of user-defined data structure is there to help.
  - \footnotesize Additionally, these support pattern matching (just as Lists and Tuples did)

\vskip.5em

* \small Example: Colors

  \scriptsize
  ```haskell
    data Color = Red | Orange | Yellow
               | Green | Blue | Violet
  ```

# Constructors and Fields

* \small Each of the color names (i.e., `Red`, `Orange`, etc.) are \textcolor{Roarange}{\textbf{constructors}} for the type `Color`
  - \footnotesize Constructors always start with a *capital letter}}
    * \scriptsize Consider the definition of `Bool`:

      \scriptsize
      ```haskell
        data Bool = False | True
      ```

  - Thus a list like: `[Red, Orange, Yellow]` has a type of `[Color]`


\vskip.5em


* \small Defining types like this is great, but often we want values that contain fields
  - \footnotesize This allows us to associate information with each of the values
  - \footnotesize Example:

    ```haskell
      data Animal = Cat String | Dog String | Rat
    ```

# Type Variables

* \small If we want to associate arbitrary information, we can use \textcolor{Roarange}{\textbf{type variables}}, for example

  \scriptsize
  ```haskell
    data Animal a b
      = Cat a | Dog b | Rat

    data BreedOfCat = Siamese | Persian | Moggie

    Cat Siamese  :: Animal BreedOfCat b
    Cat Persian  :: Animal BreedOfCat b
    Cat "moggie" :: Animal String b
    Dog 15       :: Animal a Integer
    Rat          :: Animal a b
  ```

# `show` and `Show`

* \small Now if we were to use any of these types in GHCi, we would run into errors anytime it
  attempts to print one of the values.
  - \footnotesize This is because, to print the values it uses the function `show`
  - \footnotesize `show` takes a type derived from `Show` and prints a `String` representation of the
     value to the console
  - \footnotesize We can adjust the `Animal` and `Color` types to accommodate this as follows:

    \scriptsize
    ```haskell
      data Color = Red | Orange | Yellow
                 | Green | Blue | Violet
                 deriving Show

      data Animal a b
        = Cat a | Dog b | Rat
        deriving Show
    ```

# `Maybe` and `Just`

* \small Often we write a function that may or may not succeed in computing its result
  - \footnotesize If it succeeds, it returns the result, otherwise it will cause an error and the program will crash
  - \footnotesize To address this we have the `Maybe` type

    \scriptsize
    ```haskell
      data Maybe a = Nothing | Just a
    ```

  - \footnotesize So in the case the computation succeed we return a `Just a` and otherwise we return `Nothing`

# `Maybe` and `Just`

* \small Examples:

  \scriptsize
  ```haskell
    phone_lookup :: [(String, Integer)] -> String -> Maybe Integer
    ...

    phone_messsage :: Maybe Integer -> String
    phone_message Nothing = "Telephone number not found"
    phone_message (Just x) = "The number is " ++ show x
  ```

#

\centering
\vfill
\begin{minipage}{.78\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Type Classes and Overloading
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Class Constraints

* \small There are many operations in Haskell, that can be used on some but not all types

  - Example: `(+)` which adds two numbers, but nothing else

    \scriptsize
    ```haskell
      (+) :: Num a => a -> a -> a
    ```

  - The "`Num`" is the name of a \textcolor{Buttons}{\textit{type class}} which includes `Int`, `Integer`, `Float`, `Double`
  - `Num a =>` is called a \textcolor{Buttons}{\textit{class constraint}} or \textcolor{Buttons}{\textit{context}}

# Type Classes

* \small \textcolor{Roarange}{\textbf{Type Classes}} are sets of types sharing a common property
  - \footnotesize Most important type classes are `Eq`, `Show`, `Num`
    * \scriptsize `Eq` - denotes something that can be compared for equality
    * \scriptsize `Num` - denotes something that acts numerically
    * \scriptsize `Show` - denotes something that can be printed to the console

# Implied Context

* \small Additionally, when we define functions, we must be aware of what operators or function we use imply
  - \footnotesize For example, if we include `(==)` within our function definition
    - \scriptsize This implies that the involved operands derive from `Eq`

  - \footnotesize Example:

    \scriptsize
    ```haskell
      fun a b c = if a then b == c else False -- will not compile

      fun :: Eq b => a -> b -> b -> Bool
      fun a b c = if a then b == c else False -- will compile
    ```

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Rule:}} if your function uses an overloaded operator (one with a type that has a context), then \textcolor{Buttons}{\textit{its}} type must contain that context as well.

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

# Equational Reasoning

* \small \textcolor{Roarange}{\textbf{Equational Reasoning}} is both one of the most powerful and simplest forms of formal methods.
  - \footnotesize Requires only a basic understanding of simple algebra
  - \footnotesize Forms the basis of the most advanced formal methods

# Equations and Substitutions

* \small An equation such as $x = y$ states the following:
  - \footnotesize \textcolor{Roarange}{\textbf{Substitution}} - We can replace any instance of $x$ with $y$, and vice versa
  - \footnotesize At least within the context of this definition

\vskip.5em

* \small Using substitution, definitions, prior axioms, prior theorems, and laws we can begin to reason about
  mathematics and programs.
  - \footnotesize For each step of reasoning, we provide the justification in curly braces (i.e., ${ x }$)

  \scriptsize
  ```
    -- definitions
    x = 8
    y = 4

    -- proof
    2*x + x/y
      = 2*8 + 8/y       { x }
      = 2*8 + 8/4       { y }
      = 16 = 2          { arithmetic }
      = 18              { arithmetic }
  ```

* \small Justifications may be
  - \footnotesize Explicit reference to an equation: `{ x }`
  - \footnotesize Informal reason (trivial or tedious): `{ arithmetic }`
  - \footnotesize A chain of reasoning: `{ multiplication, division }`

# Hand-Execution

* \small \textcolor{Roarange}{\textbf{Hand-Execution}} - technique or capability of a programmer to think through the execution of their program.
  - \footnotesize In the context of \textcolor{Buttons}{\textit{imperative languages}} such as Python, Java, or C++
    - \scriptsize We simulate the operation of the computer based on the commands in the program
  - \footnotesize In the context of \textcolor{Buttons}{\textit{functional languages}} such as Haskell
    - \scriptsize We instead use Equational Reasoning

::: columns
:::: column

\textcolor{Roarange}{\textbf{A Haskell Script}}

\scriptsize
```haskell
  f :: Integer -> Integer -> Integer
  f x y = (2 + x) * g y

  g :: Integer -> Integer
  g z = 8 - z
```

::::
:::: column

\textcolor{Roarange}{\textbf{Equational Reasoning}}

\scriptsize
```
  f 3 4
    = (2+3) * g 4     { f }
    = (2+3) * (8-4)   { g }
    = 20              { arithmetic }
```

::::
:::

# Equational Reasoning Considerations

* \small We must be careful during hand-execution when considering the following:
  - \footnotesize Use of parentheses
  - \footnotesize Variable names and scope
  - \footnotesize Multiple\scriptsize definitions of a function
    * \scriptsize Use either the number `{ f.1 }` or pattern for justifications

# Conditionals

* \small A conditional satisfies the following equations:

  \scriptsize
  ```haskell
    if True  then e2 else e3 = e2   { if True }
    if False then e2 else e3 = e3   { if False }
  ```

\vskip.5em

* \small Example:

::: columns
:::: {.column width=.35}

\textcolor{Roarange}{\textbf{Script}}

\scriptsize
```haskell
  f :: Double -> Double
  f x =
    if x >= 0
      then sqrt x
      else 0
```

::::
:::: {.column width=.65}

\textcolor{Roarange}{\textbf{Reasoning}}

\footnotesize

\scriptsize
```
  f (-3)
    = if (-3) >= 0 then sqrt (-3) else 0   { f }
    = if False then sqrt (-3) else 0       { arithmetic }
    = 0                                    { if False }
```

::::
:::

# Equational Reasoning with Lists

* \small Proving the following theorem:
  - `length (map f (xs ++ ys)) = length xs + length ys`

\vskip.5em

* \small We require the following theorems:
  1. \footnotesize `length (++)`: `length (xs ++ ys) = length xs + length ys`
  2. \footnotesize `length map`: `length (map f xs) = length xs`
  3. \footnotesize `map (++)`: `map f (xs ++ ys) = map f xs + map f ys`

# Equational Reasoning with Lists

* \small Proof:

  \scriptsize
  ```haskell
    length (map f (xs ++ ys))
      = length (map f xs ++ map f ys)          { map (++) }
      = length (map f xs) + length (map f ys)  { length (++) }
      = length xs + length ys                  { length map }
  ```

# Language's Role

* \small Due to the mathematical nature of Haskell, equations are actual equations

\vskip.5em

* \small This fact leads to Haskell's property of \textcolor{Roarange}{\textbf{referential transparency}}
  - \footnotesize Allowing for substitution

\vskip.5em

* \small This is unlike imperative languages which feature \textcolor{Buttons}{\textit{assignment}} rather than equations

# Rigor and Formality

* \small \textcolor{Roarange}{\textbf{Rigorous Proof}} - A proof which is thought through, and does not contain shortcuts, but possibly omits trivial details.
  - \footnotesize includes only the essential details

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Formal Proof}} - A proof consisting of solid reasoning based on a clearly specified set of axioms
  - \footnotesize No details omitted
  - \footnotesize No sloppiness allowed
  - \footnotesize Can be checked using software

# For Next Time

::: columns
:::: column
* Review Chapter DMUC 1.6 - 1.10 and 2
* Review this Lecture
* Come To Class
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
