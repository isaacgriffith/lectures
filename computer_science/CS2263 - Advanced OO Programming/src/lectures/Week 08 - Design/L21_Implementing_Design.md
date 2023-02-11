---
author:
- Dr. Isaac Griffith
title: Implementing a Design
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}

* How we generate implementation class diagrams from sequence diagrams
* How we convert class diagrams into code
* How we convert sequence diagrams into code

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
\begin{minipage}{.425\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Class Diagrams
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Class Diagrams

* \small As we complete our sequence diagrams, we should also have identified all necessary software classes.
* \small For the Library System, the software classes are:
  - \footnotesize `Library`
  - \footnotesize `MemberList`
  - \footnotesize `Catalog`
  - \footnotesize `Member`
  - \footnotesize `Book`
  - \footnotesize `Hold`
  - \footnotesize `Transaction`

* \small We then need to flesh out the classes
  - \footnotesize We add methods by examining each sequence diagram
  - \footnotesize We add attributes by examining the methods

# Overall

::: columns
:::: column
* \small We Note the following things
  - \footnotesize Holds is a class between `Book` and `Member`

  \vskip.5em

  - \footnotesize `Transaction` is used to record transactions
    * \scriptsize with connections to book (as it holds the title)

  \vskip.5em

  - \footnotesize `Library` is the \textcolor{Roarange}{\textbf{Facade}} to the business logic
    * \scriptsize All updated are done by invoking methods on the Facade
    * \scriptsize rather than any class/method it controls
::::
:::: column
\centering
\includegraphics[width=\textwidth]{images/design/design11.eps}
::::
:::

# Library

::: columns
:::: column

\textcolor{Roarange}{\textbf{Design}}

* \small All methods and parameters are extracted from the sequence diagrams

\vskip.5em

* \small Method return types are provided (not originally specified in diagrams)

\vskip.5em

* \small Connects to `MemberList` and `Catalog`

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/design/design12.eps}

::::
:::

# Member

::: columns
:::: column

\textcolor{Roarange}{\textbf{Design}}

* \small Sequence diagrams provide
  - \footnotesize Methods
  - \footnotesize Attributes

\vskip.5em

* \small Member generates its own ID
  - \footnotesize We need to ensure that these are unique among instances
  - \footnotesize Thus we will need static methods (not shown)
  - \footnotesize Will provide decentralized control with responsibilities close to the data

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/design/design13.eps}

::::
:::

# Book

::: columns
:::: column

\textcolor{Roarange}{\textbf{Design}}

* \small Use same approach to extract methods, attributes, parameters

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Note:}} No setters (we do not expect to alter data once entered)

::::
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/design/design14.eps}

::::
:::

# Catalog

::: columns
:::: column

\textcolor{Roarange}{\textbf{Design}}

* \small Requires typical methods
  - \footnotesize `search`
  - \footnotesize `insert`
  - \footnotesize `remove`

\vskip.5em

* \small Only attribute
  - \footnotesize an internal collection of books

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/design/design15.eps}

::::
:::

# MemberList

::: columns
:::: column

\textcolor{Roarange}{\textbf{Design}}

* \small Same as was done for `Catalog`

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/design/design16.eps}

::::
:::

# Hold

::: columns
:::: column

\textcolor{Roarange}{\textbf{Design}}

* \small Basic accessors

\vskip.5em

* \small Adds in a method `isValid`
  - \footnotesize checks whether a certain hold is still valid

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/design/design17.eps}

::::
:::

# Transaction

::: columns
:::: column

\textcolor{Roarange}{\textbf{Design}}

* \small Handles data for each individual transaction

\vskip.5em

* \small Transaction dependencies to book represent the different member transactions:
  - \footnotesize Issues a book
  - \footnotesize Returns a book
  - \footnotesize Places a hold on a book
  - \footnotesize Removes a hold from a book

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/design/design18.eps}

::::
:::

# Importing/Exporting Objects

* \small When implementing systems, we need to take care of managing references.

\vskip.5em

* \small It always seems convenient to return a reference to an object or collection of objects. But this can often be the wrong choice.

\vskip.5em

* \small This is where multiplicity comes into play.
  - \footnotesize When implementing our system we need to take care to ensure that the multiplicities are maintained
  - \footnotesize We also need to ensure that objects are not just sharing references around but rather encapsulate the data the contain
  - \footnotesize So remember not to export (share through a getter) contained collections or other internal objects

# User Interface

* \small Presents a menu to the user using a simple CLI:

::: columns
:::: {.column width=.1}

::::
:::: {.column width=.35}
0. \footnotesize Exit
1. \footnotesize Add a member
2. \footnotesize Add books
3. \footnotesize Issue books
4. \footnotesize Return books
5. \footnotesize Renew books
6. \footnotesize Remove books
::::
:::: {.column width=.55}
7. \footnotesize Place a hold on a book
8. \footnotesize Remove a hold on a book
9. \footnotesize Process holds
10. \footnotesize Print a member's transactions on a given date
11. \footnotesize Save data for long-term storage
12. \footnotesize Retrieve data from storage
13. \footnotesize Help
::::
:::

* \small User can enter a number from 0 - 13
* \small Parameters will then be required for the selected operation
* \small Once complete the results will be displayed

# Data Storage

* \small As we have noted before, most systems will need to store data on a long-term basis

\vskip.5em

* \small Towards this end, we originally noted a need for the following two commands
  - \footnotesize A command to save the data on a long-term basis
    * \scriptsize data is copied to a secondary storage device
  - \footnotesize A command to load data from a long-term device
    * \scriptsize data is loaded from a secondary storage device to recreate objects

#

\centering
\vfill
\begin{minipage}{.765\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Implementation Walkthrough
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Facade Pattern

::: columns
:::: column

* \small \textcolor{Roarange}{\textbf{Problem Faced}}   - \footnotesize We have several clients accessing a subsystem
  - \footnotesize The clients have too much access to the underlying details of the subsystem
  - \footnotesize This creates tight coupling between the client and the subsystem

\vskip.5em

* \small Facade solves this by
  - \footnotesize Providing a single point of access to the subsystem
  - \footnotesize Adapts to changes in classes so that the client does not have to

::::
:::: column

\includegraphics[width=\textwidth]{images/patterns/facade/facade01.eps}

::::
:::

# Facade Pattern

::: columns
:::: column
* \footnotesize The `Library Class` is an instance of a \textcolor{Roarange}{\textbf{Facade}} pattern

\vskip.5em

* \footnotesize \textcolor{Roarange}{\textbf{Motivation}}   - \footnotesize  To reduce complexity by minimizing communication and dependencies between a subsystem and its clients
  - \scriptsize Shields the client from the subsystem
  - \scriptsize Enables loose coupling between client and subsystem components

\vskip.5em

* \footnotesize \textcolor{Roarange}{\textbf{Using a Facade}}   - \footnotesize  Employed in a situation where we have:
    1. \scriptsize A system with several individual classes, each with its own set of public methods
    2. \scriptsize An external entity interacting with the systems requires knowledge of the public methods of several classes

::::
:::: column

\includegraphics[width=\textwidth]{images/patterns/facade/facade02.eps}

::::
:::

# For Next Time

::: columns
:::: column
* Review Chapter 7
* Review this lecture
* Come to class
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
