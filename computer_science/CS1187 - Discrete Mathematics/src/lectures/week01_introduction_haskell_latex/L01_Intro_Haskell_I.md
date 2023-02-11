---
author:
- Dr. Isaac Griffith
title: Introduction and Haskell I
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Inspiration

> "The world is continuous, but the mind is discrete." -- David Mumford

# Outcomes

After today's lecture you will:

::: columns
:::: {.column width=.7}
* Introduce the course and review the syllabus
* Learn the basics of Haskell
  - Running Haskell Scripts and using the GHCi
  - Haskell Types and Expressions
  - Basic Haskell Data Structures
    * Lists and List Comprehensions
    * Tuples
  - Functions
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
\begin{minipage}{.45\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Syllabus Review
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

#

\centering
\vfill
\begin{minipage}{.525\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Course Introduction
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Course Introduction

\centering
\vfill
\Large What is Discrete Structures/Mathematics?

::: columns
:::: column

\begin{figure}
\centering
\includegraphics[width=.45\textwidth]{images/intro/dma.jpg}

\tiny Discrete Mathematics\\and Its Applications, 8th Edition\\Rosen 2019
\end{figure}

::::
:::: column

\begin{figure}
\centering
\includegraphics[width=.385\textwidth]{images/intro/dmuc.jpg}

\tiny Discrete Mathematics Using\\a Computer, 2nd Edition\\O'Donnell, Hall and Page (2006)
\end{figure}

::::
:::


# Course Introduction

* \small \textbf{\underline{Goals of this course}:}
  - \footnotesize To understand and be able to apply the following concepts of discrete mathematics to computing
    * \scriptsize Logic
    * \scriptsize Set Theory
    * \scriptsize Relations and Functions
    * \scriptsize Counting
    * \scriptsize Number Systems and Modular Arithmetic
    * \scriptsize Recursion and Induction
    * \scriptsize Graphs and Trees
  - \footnotesize To be able to use symbolic mathematics, logical laws, and logical inference in mathematical reasoning
  - \footnotesize Assess mathematical and logical arguments for validity, construct mathematical arguments and simple proofs, and apply definitions and theorems

# Course Introduction

* \small In considering this topic:
  - \footnotesize I wanted to better connect the goals of the previous slide to computing
  - \footnotesize I thought: "What better way than through programming itself?"
  - \footnotesize Additionally: "What if the language was a paradigm the students haven't seen and one which is very close to the math itself?"
* \small Towards this, I opted to select the Haskell language, and then found the course book which already
  put all of this together.
* \small This adds four additional goals for this course, provide by Haskell:
  - \footnotesize Be able to understand and use the functional programming paradigm.
  - \footnotesize Be able to use the computer to help you to learn and understand mathematics.
  - \footnotesize Be able to use software tools to make it possible to use the mathematics more effectively.
  - \footnotesize Understand the widespread application of mathematics to computing.

# Haskell Introduction

* Why a functional language? Why Haskell?
  - Allows you to compute directly with fundamental objects of discrete mathematics
  - Haskell is powerful yet expressed simply
  - We reason about Haskell programs in the same way we reason about mathematics
  - Haskell is excellent for *rapid prototyping*
  - Haskell is stable, standard, and well-documented
  - Haskell implementations are free and available on most OSs
  - Haskell can be used interactively

# REPL

* What is a \textcolor{Buttons}{\textit{\textbf{REPL}}}?
  - \textbf{\textcolor{Roarange}{\textit{R}}ead} - reads in code from command prompt
  - \textbf{\textcolor{Roarange}{\textit{E}}valuate} - evaluates the code read in
  - \textbf{\textcolor{Roarange}{\textit{P}}rint} - prints the result of the evaluation to the terminal
  - \textbf{\textcolor{Roarange}{\textit{L}}oop} - loops on REP until the user exits

\vskip.5em

* Several REPLs exist for Haskell
  - \textcolor{Roarange}{\textbf{GHCi}}
  - Hugs
  - nhc

# Running Haskell

* \small To start haskell interactively (with GHCi), do the following (assuming you have installed Haskell):
  1. \footnotesize Open a terminal (Linux/MacOS) or Command Prompt (Windows)

  \vskip.5em

  2. \footnotesize At the prompt, execute the following command (Note the `$` is the prompt not a part of the command)

      \vskip.5em

     `$ ghci`

     \vskip.5em

  3. \footnotesize This should start the interactive haskell system. Additionally it should give you an intro message followed by a prompt, for example:

     \vskip.5em


     ```haskell
     GHCi, version 8.8.4: https://www.haskell.org/ghc/  :? for help
     Prelude>
     ```

     \vskip.5em

     where `Prelude> ` is the prompt.

  \vskip.5em

  4. \footnotesize Personally, I don't like the `Prelude> ` prompt, so I set it to `ghci> ` using the following command:

     \vskip.5em

     `:set prompt "ghci> "`

# Running Haskell

* As noted previously, this prompt is the REPL
  - We can type in *expressions* and see their results (similar to a calculator)

\vskip0.5em

* For example:

    ```haskell
      ghci> 1 + 2
      3
      ghci> 3 * 4
      12
      ghci>
    ```

# Loading Files

* \small When working with haskell, we often need to use definitions stored in scripts
  * \footnotesize Haskell scripts end with the \textcolor{Roarange}{\textbf{.hs}} extension
  * \footnotesize To load a file while in GHCi, we use the load file command:

    \vskip0.5em

    `:load <module>` or `:l <module>`

    \vskip0.5em

    \footnotesize Where `<module>` is the name of the file to load **(without the .hs extension)**.

\vskip0.5em

* \small Throughout this course, we will be using the book's `stdm.hs` file, so you should download it
  - \footnotesize Additionally, I would suggest creating a folder for your Haskell work
  - \footnotesize In this folder should be the `stdm.hs` file
  - \footnotesize This folder is the working directory where you should be prior to starting your Haskell interactive sessions

# Working with definitions

* \small Along with loading prior definitions created by others, we will also want to create our own code.

\vskip.5em

* \small Using a text editor, create a new file `mydefs.hs` and add the following to it:

  \footnotesize

  ```haskell
  y = x + 1
  x = 2 * 3
  ```

\vskip.5em

* \small Save the file to your Haskell working folder. Then load it as follows:

  \footnotesize

  ```haskell
  ghci> :l mydefs
  [1 of 1] Compiling Main             ( mydefs.hs, interpreted )
  Ok, one module loaded.
  ghci>
  ```

# Working with Definitions

* \small After loading `mydefs.hs` both `x` and `y` in the file are definitions, which are now available to us

::: columns
:::: {.column width=0.05}

::::
:::: {.column width=.4}

* \small So we could do something like:

  ```haskell
  ghci> x
  6
  ghci> y
  7
  ghci> x * y
  42
  ghci>
  ```
::::
:::: {.column width=.575}

* \small If we make any changes to the file
  - \footnotesize then we would need to reload it for those changes to take affect in GHCi
    - \footnotesize using the `:reload` or `:r` command, or
    - \footnotesize load again with the `:load` or `:l` command

::::
:::

# GHCi Commands

* All GHCi commands start with ":" which tells the system that we are executing a command for the environment not entering an expression

\vskip.5em

* The commands we will be using the most are:
  - \small `:load <module>` or `:l <module>` which loads the specified module (or file in our case)
  - \small `:reload` or `:r` which reloads the current module set
  - \small `:type <expr>` or `:t <expr>` which identifies the type of the given expression
  - \small `:cd <dir>` change the current working directory to the one specified
  - \small `:set prompt <prompt>` which sets the prompt to the given string
  - \small `:quit` or `Ctrl+D` (on some systems) which exits GHCi

# Haskell Code Structure

* \small Haskell has an apparent lack of structure
  - \footnotesize No extra punctuation (colons, semicolons, braces, begin, end, etc.)
  - \footnotesize Instead, structure is controlled by line endings and indentation
    * \scriptsize Haskell will figure the rest out for us

\vskip.5em

* \small Comments
  - \footnotesize \textcolor{Roarange}{\textbf{line comments}} start with `--` and everything after it is ignored

    \footnotesize
    ```haskell
    x = 2 + 2 -- the result should be 4
    ```

  - \footnotesize \textcolor{Roarange}{\textbf{multiline comments}}: `{- text -}` where the `text` is the comment, and anything
    between `{-` and `-}` will be ignored

    \footnotesize
    ```haskell
      {-
      This is a multiline comment
      -}
      x = 2 + 2
    ```

#

\centering
\vfill
\begin{minipage}{.535\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Haskell Expressions
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Expressions

* We can do a lot with just expressions in Haskell

\vskip.5em

* The following discusses useful kinds of expressions organized according to value \textcolor{Buttons}{\textbf{\textit{type}}}
  - `Integer` and `Int` expressions
  - Rational and Floating Number Expressions
  - Boolean
  - Character and String Expressions

# `Integer` and `Int`

* Integer constants are simply a sequence of digits:

  `2`, `0`, `12345`, `-72`

\vskip.5em

* \textcolor{Roarange}{\textbf{Operators:}}
  - Addition `(+)` : `4 + 3`
  - Subtraction `(-)` : `4 - 3`
  - Multiplication `(*)` : `2 * 3`
  - Exponentiation `(^)` : `2^3`
  - Division `` `div` `` : ``4 `div` 2`` (note the backticks)

# `Integer` and `Int`

* Haskell has two Integer types
  - `Int` - a whole number whose maximum size fits within a \textcolor{Buttons}{\textit{word}} in memory (i.e., 64 bits on a 64bit machine)
  - `Integer` - a type representing mathematical integers
    * Using `Integer` type allows arithmetic operations to satisfy algebraic laws

* The \textcolor{Buttons}{\textit{has type}} operator `(::)`
  - Can be used to force the type specification rather than allow Haskell to infer the type
  - Example: `2::Int` or `2::Integer`

# Floating Point Numbers

* Types of Floating Point numbers:
  - `Float` - single precision
  - `Double` - double precision

\vskip.5em

* Operators:
  - Addition `(+)`
  - Subtraction `(-)`
  - Multiplication `(*)`
  - Division `(/)`
  - Exponentiation `(**)` : `4.0 ** 2`

# Floats are Approximations

* \small Floating points are approximations
  - \footnotesize Cannot guarantee satisfaction of algebraic laws
  - \footnotesize Cannot directly compare two floating point numbers for equality

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Procedure to compare Floating Point numbers:}}
  - \footnotesize for two floating point numbers $x$ and $y$
  - \footnotesize compare the absolute value of the difference: $|x - y|$ to some small error tolerance
  - \footnotesize Mathematically: $|x - y| < 0.001$
  - \small In Haskell:

    ```haskell
      isEqual :: Float -> Float -> Bool
      isEqual x y = (abs (x - y)) < 0.001
    ```

# Rational Numbers

* To get around the limitations of Floating Point arithmetic, Haskell also supports exact arithmetic on rational numbers

\vskip.5em

* To use the exact form we must work with fractions in which both the numerator and denominator are integers

\vskip.5em

* The type of these numbers is `Fractional` and is written as `num/denom`, for example:
  - `2/3`
  - `2/3 + 1/6` $\to$ `5/6`

\vskip.5em

* \textcolor{Roarange}{\textbf{Note:}} Haskell will automatically reduce fractions

# Booleans

* \small Booleans are represented by the `Bool` type which can be one of two values (note the capitalization)
  - \footnotesize `True`
  - \footnotesize `False`

::: columns
:::: {.column width=.4}

\textcolor{Buttons}{\textbf{Comparing Two Numbers}}

* \footnotesize `==  -- equality`
* \footnotesize `/=  -- not equal`
* \footnotesize `<   -- less than`
* \footnotesize `<=  -- less than or equal`
* \footnotesize `>   -- greater than`
* \footnotesize `>=  -- greater than or equal`

::::
:::: {.column width=.6}

\textcolor{Buttons}{\textbf{Boolean Logic}}

* \footnotesize `&&  -- Boolean and (True only if both are True)`
* \footnotesize `||  -- Boolean or (False only if both are False)`
* \footnotesize `not -- Boolean not (Returns opposite truth value)`

::::
:::

# Characters

* \small Characters have type `Char`
* \small Constants are written using single quotes: `'a'`

* \small \textcolor{Roarange}{\textbf{Useful Operations}}
  - \footnotesize Comparison operators can be used
  - \footnotesize `toUpper` - converts lowercase to uppercase (must `import Data.Char`)
  - \footnotesize `toLower` - converts uppercase to lowercase (must `import Data.Char`)
  - \footnotesize Examples:

    \footnotesize
    ```haskell
      ghci> 'c' < 'Z'
      False
      ghci> import Data.Char
      ghci> toUpper 'w'
      'W'
      ghci> toLower 'Q'
      'q'
    ```
* \small Special Character: \textcolor{Buttons}{\textit{newline}} which causes a line break when printed
  - \footnotesize Written as `'\n'`

# Strings

* \small A `String` is a sequence of zero or more characters.

\vskip0.5em

* \small Constants are written inside double quotes:
  - `"tree"`

\vskip0.25em

* \small \textcolor{Roarange}{\textbf{Useful Operators and Operations}}
  - \footnotesize Concatenation `(++)` - joins two strings together
    * \scriptsize Example: `"abc" ++ "defg" => "abcdefg"`
    * \scriptsize Example: `"Here is a line" ++ "\n"`
    * \scriptsize \textcolor{Buttons}{\textbf{Note:}} will not join a `String` to any other type
  - \footnotesize `length` - operation which counts the length of the string
    * \scriptsize Example: `length "abc"` $\to$ `3`
    * \scriptsize Example: `length ""` $\to$ `0`

#

\centering
\vfill
\begin{minipage}{.575\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Basic Data Structures
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Tuples

* \small Tuples provide the capability to store multiple values in a single variable
  - \footnotesize `(1, 2)`
  - \footnotesize `('a', 2, "cab")`

  \vskip0.5em

* \small A tuple type is defined by two characteristics
  - \footnotesize The number of items to be stored, which is fixed once defined
  - \footnotesize The order of types to be stored, types do not need to be homogenous

  \vskip0.5em

* \small Examples:

  \footnotesize
  ```haskell
    ("dog", "cat") :: (String, String)
    (True, 5) :: (Bool, Int)
    ('a', "b") :: (Char, String)
    ("bat", (3.14, False)) :: (String, (Double, Bool))
  ```

# Tuples

* \small The general name is an \textcolor{Buttons}{\textit{n-tuple}} where $n$ the number of components (i.e., 4-tuple)
  - \footnotesize a 2-tuple is also called a \textcolor{Buttons}{\textit{pair}}
  - \footnotesize a 3-tuple is also called a \textcolor{Buttons}{\textit{triple}}
  - \footnotesize no such thing as a 1-tuple
  - \footnotesize However, there is a special 0-tuple in Haskell
    - \scriptsize Written as `()`
    - \scriptsize Often used as a dummy value

\vskip0.5em

* \small Pairs are a commonly used data structure, common operations include:
  - \footnotesize `fst (a, b)` - where the argument to the function is the tuple `(a, b)`, will return the value `a`
  - \footnotesize `snd (a, b)` - where the argument to the function is the tuple `(a, b)`, will return the value `b`

# Lists

* \small Lists are the most common data structure used in functional programming
  - \footnotesize Size: unlimited
  - \footnotesize Type: all elements must be the same type
  - \footnotesize Examples:

    \footnotesize
    ```haskell
      [1, 2, 3]
      ['c', 'a', 'b']
      [] -- empty list
    ```

* \small Type is written as: `[A]` where `A` is the type of the contained elements

  \footnotesize
  ```haskell
    [13,9,-2,100] :: [Int]
    ["cat", "dog"] :: [String]
    [[1,2], [3,7,1], [], [900]] :: [[Int]]
  ```

# Sequences

* \small If we recall, a String is a sequence of characters, well this is just a list:

  \footnotesize
  ```haskell
    "string" == ['s','t','r','i','n','g']
  ```

\vskip.5em

* \small Additionally, we define a list using a range:

  \footnotesize
  ```haskell
    [1..10] == [1,2,3,4,5,6,7,8,9,10]
    [0,2..10] == [0,2,4,6,8,10]
    [10,9..0] == [10,9,8,7,6,5,4,3,2,1,0]
  ```

\vskip.5em

* \small Ranges also work for characters

  \footnotesize
  ```haskell
    ['a'..'z'] == "abcdefghijklmnopqrstuvwxyz"
    ['0'..'9'] == "0123456789"
  ```

# List Notation and `(:)`

The \textcolor{Roarange}{\textbf{Cons Operator}} - `(:)`

- \small We can construct new lists with the `:` operator

\vskip.5em

- \small This is an infix binary operator
  * \footnotesize Left argument is an element to add to the list
  * \footnotesize Right argument is a list
  * \footnotesize Type: `(:) :: a -> [a] -> [a]`

\vskip.5em

- \small Examples:

  ```haskell
    1 : [2, 3] => [1, 2, 3]
    1 : [] -> [1]
  ```

# List Notation and `(:)`

* Thus, we can write a list a series of cons operations:

  ```haskell
    [1, 2, 3, 4] == 1 : (2 : (3 : (4 : [])))
    "abc" == 'a' : ('b' : ('c' : []))
  ```

\vskip.5em

* However, since `(:)` is right-associative, we can drop the parentheses

  ```haskell
    [1, 2, 3, 4] == 1 : 2 : 3 : 4 : []
    "abc" == 'a' : 'b' : 'c' : []
  ```

\vskip.5em

* \textcolor{Roarange}{\textbf{Note:}} that the end of the cons sequence is always the empty list

# List Comprehensions

* \textcolor{Roarange}{\textbf{List Comprehension}} - a simple but powerful syntax to directly define a list
  - based on set comprehensions from mathematics
    * Example set comprehension: $\{x^2 | x \in \mathcal{S}\}$
  - does not require a program to build a list

# List Comprehension Syntax

**General Form:**  `[expression | generator, ..., filter, ...]`

\vskip.5em

- \small Read the `|` as \textcolor{Buttons}{\textit{such that}}

\vskip.5em

- \small `generator` - defines a sequences of values that a variable will take on and is written in the form `var <- list`
  * \footnotesize \textcolor{Roarange}{\textbf{Note:}} there may be more than one generator, one for each variable in the expression (acts like loop nesting)

\vskip.5em

- \small `expression` - evaluated for each value that the generator variable(s)

\vskip.5em

- \small `filter` - are `Bool` expressions that apply to one or more generator variables in order to determine if the value will be included or not
  * \footnotesize If the expression evaluates to `False` then the value is thrown out
  * \footnotesize Filters are optional and there can be more than one filter, each separated by commas

# List Comprehension Examples

* \small List of the product of each pair from another list

  \footnotesize
  ```haskell
    [a * b | (a, b) <- [(1, 2), (10, 20), (6, 6)]]
           => [2, 200, 36]
  ```

  - \footnotesize \textcolor{Buttons}{\textit{expression}} - `a * b`
  - \footnotesize \textcolor{Buttons}{\textit{generator}} - `(a, b) <- [(1, 2), (10, 20), (6, 6)]`

\vskip.5em

* \small List of numbers that are divisible by 5 from the range 1 to 1000

  \footnotesize
  ```haskell
    [a `mod` 5 | a <- [1..1000]]
            => [5, 10, 15, 20, ...]
  ```

  - \footnotesize \textcolor{Buttons}{\textit{expression}} - ``a `mod` 5``
  - \footnotesize \textcolor{Buttons}{\textit{generator}} - `a <- [1..1000]`

# List Comprehension Examples

```haskell
  [(x, y) | x <- [1,2,3], y <- ['a', 'b']]
      => [(1, 'a'), (1, 'b'), (2, 'a'), (2, 'b'), (3, 'a'), (3, 'b')]
```

\vskip.5em

```haskell
  [x | x <- [0..100], x `mod` 2 == 0 && x `mod` 7 == 0]
      => [0,14,28,42,56,70,84,98]
```

\vskip.5em

```haskell
  [x | x <- [1..12], y <- [1..12], x*y == 12]
      => [1,2,3,4,6,12]
```

# Exercises

Work out the values of the following list comprehensions; then check your results by evaluating them with the computer

```haskell
    [x | x <- [1,2,3], False]
```

```haskell
    [not (x && y) | x <- [False, True],
                    y <- [False, True]]
```

```haskell
    [x || y | x <- [False, True],
              y <- [False, True],
              x /= y]
```

# Exercises

Work out the values of the following list comprehensions; then check your results by evaluating them with the computer

```haskell
    [x | x <- [1,2,3], False]
       => []
```

```haskell
    [not (x && y) | x <- [False, True],
                    y <- [False, True]]
       => [False, False, False, True]
```

```haskell
    [x || y | x <- [False, True],
              y <- [False, True],
              x /= y]
       => [True, True]
```

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

# Function Application

* \textcolor{Roarange}{\textbf{Function Application}} - when an expression uses a function
  - \small A function is \textcolor{Roarange}{\textbf{applied}} to its arguments
  - \small Syntax: `func arg1 arg2`
    * \footnotesize `func` is the function name
    * \footnotesize `arg1` and `arg2` are the arguments (may be 0 or more of these all separated by spaces)

\vskip.5em

* Example:

  ```haskell
    sqrt 9.0
    3.4 + sqrt 25 * 100
    2 * sqrt (pi * 5 * 5) + 10
  ```

# Function Types

* Functions like data have types, and these types are quite important

\vskip.5em

* \textcolor{Roarange}{\textbf{Function type}} - for a function, $f$, with an argument of type $a$ and a return type of $b$ has a \textcolor{Buttons}{\textit{function type}} of $a \to b$ (read $a$ arrow $b$).
  - \small Thus we would write: `f :: a -> b`

\vskip.5em

* \textcolor{Roarange}{\textbf{Example Function Types}}

  ```haskell
    sqrt :: Double -> Double
    max :: Integer -> Integer -> Integer -- first two are the args
    not :: Bool -> Bool
    toUpper :: Char -> Char
  ```

# Operators and Functions

* \textcolor{Roarange}{\textbf{Operator}} - a function which takes exactly two arguments
  - \small \textcolor{Roarange}{\textbf{Infix notation}} - when the operator is written between the arguments
    * \footnotesize `(+)` operator - `2 + 4`
    * \footnotesize `min` function - ``2 `min` 4`` the backticks allow it to act as an operator
  - \small \textcolor{Roarange}{\textbf{Prefix notation}} - when the operator
    * \footnotesize `(+)` operator - `(+) 2 4` when used like this or by itself it must be enclosed in parentheses
    * \footnotesize `min` operator - `min 2 4`

\vskip.5em

* All operators are functions, and thus have a function type
  - \small `(+) :: Integer -> Integer -> Integer`
  - \small `(&&) :: Bool -> Bool -> Bool`

# Function Definitions

* A function definition has two parts:
  1. \small \textcolor{Roarange}{\textbf{Type declaration}} which has the following form:

     \vskip.25em
     \small
     $function\_name :: argType_1 \to argType_2 \to \ldots \to argType_n \to resultType$
     \vskip.25em

  2. \small \textcolor{Roarange}{\textbf{Defining Equation}} which has the following form:

     \vskip.25em
     \small
     $function\_name\,\, arg_1\,\, arg_2\,\, \ldots\,\, arg_n = expression\,\, using\,\, the\,\, arguments$
     \vskip.25em

\vskip.5em

* Function definitions should be written in a Haskell script file
  - \small To use the functions, the file should be loaded into GHCi

\vskip.5em

* Example Function Definition

  ```haskell
    square :: Integer -> Integer
    square x = x * x
  ```

# For Next Time

::: columns
:::: column
* Review DMUC Chapter 1.1 - 1.5
* Review this Lecture
* Come To Lecture
* Read DMUC Chapter 1.6 - 1.10
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
