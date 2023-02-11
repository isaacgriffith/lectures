---
author:
- Dr. Isaac Griffith
title: Design
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

* How we extract responsibilities from Use Cases
* How we select and identify classes that will be constructed in the software

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
\Huge Design
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Introduction

* \small We now have the requirements of the system specified
* \small We next begin the task of designing our system
* \small \textcolor{Roarange}{\textbf{Goal:}} design a system which behaves as specified by our model
  - \footnotesize \textcolor{Roarange}{\textbf{Tool:}} UML Sequence Diagrams
* \small \textcolor{Roarange}{\textbf{Tasks:}}
  - \footnotesize Breakdown system actions into specific tasks
  - \footnotesize Breakdown tasks into responsibilities
  - \footnotesize Assign these responsibilities to system entities
    - \scriptsize identify the public methods of each class
    - \scriptsize describe the function of each method
* \small \textcolor{Roarange}{\textbf{Outcome:}} A design which specifies enough detail to be implemented in code.
  - \footnotesize Moving us into the implementation phase

# Design Questions

\footnotesize \textcolor{Roarange}{\textbf{We must answer the following questions}}

1. \scriptsize On what platform(s) (hardware and software) will the system run?
   - \tiny Linux
   - \tiny MacOS
   - \tiny Windows
   - \tiny A combination thereof

2. \scriptsize What languages and paradigms will be used for implementation?
   - \tiny Functional vs. Imperative
   - \tiny Procedural vs. OO
   - \tiny Java, C++, Scala, Ruby, Go, C, etc.
   - \tiny Will depend on the needs of the project and the expertise of the engineers

3. \scriptsize What user interfaces will the system provide?
   - \tiny CLI, GUI, Web

4. \scriptsize What classes and interfaces need to be coded? What are their responsibilities?

# Design Questions

\footnotesize \textcolor{Roarange}{\textbf{We must answer the following questions}}

5. \footnotesize How is data stored on a permanent basis?
   - \scriptsize What medium will be used?
   - \scriptsize What model will be used for data storage?

6. \footnotesize What happens if there is a failure?
   - \scriptsize We should strive to prevent data loss
   - \scriptsize What mechanisms are needed for realizing this?

7. \footnotesize Will the system use multiple computers.
   - \scriptsize What are the issues related to data and code distribution?

8. \footnotesize What kind of protection mechanisms will the system use?

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Design Phase
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Design Phase

* \small In this phase we have several steps to complete
  1. \footnotesize Identify the major subsystems
  2. \footnotesize Create the Software Classes
  3. \footnotesize Assign Responsibilities to the Classes
  4. \footnotesize Transition from Software Classes to Implementation Classes
  5. \footnotesize User Interface
  6. \footnotesize Data Storage

# Major Subsystems

* \small Our first step is to identify the major subsystems of our system.

* \small In the Library Example, we have two major subsystems:
  - \footnotesize \textcolor{Roarange}{\textbf{Business Logic:}}
    - \scriptsize Input data processing
    - \scriptsize Data creation
    - \scriptsize Queries
    - \scriptsize Data Updates
    - \scriptsize External storage, storing/retrieving data

  - \footnotesize \textcolor{Roarange}{\textbf{User Interface:}}
    - \scriptsize Interacts with the user
    - \scriptsize Accepts and outputs information

* \small We should apply good design principles here
  - \footnotesize Separation of Concerns and Encapsulate what Varies
  - \footnotesize High Cohesion in the modules

# Creating Software Classes

* \small In the prior phase we created conceptual classes and class diagrams
  - \footnotesize Conceptual classes are from the "essential perspective"
  - \footnotesize In this phase we want transition to \textcolor{Roarange}{\textbf{Software Classes}}
    * \scriptsize The conceptual classes act as a starting point, or first guess
* small \textcolor{Roarange}{\textbf{Software Classes}} - are a more "concrete" set of classes which will correspond to system components.
* \small This transition is an iterative process:
  1. \footnotesize Come up with a set of classes
  2. \footnotesize Assign responsibilities to the classes and determine the necessary data structures and methods
  - \footnotesize Will most likely require several iterations, where classes may be
    * \scriptsize Added
    * \scriptsize Removed
    * \scriptsize Merged
    * \scriptsize Split

# Which Classes

* \small Using our conceptual classes as a starting point
* \small We review the classes identified to see if the will remain going forward
* \small The conceptual classes were as follows:
  - \footnotesize Member
  - \footnotesize Book
  - \footnotesize Library
  - \footnotesize Borrows
  - \footnotesize Holds

# Conceptual Model

\centering
\includegraphics[width=.8\textwidth]{images/design/analysis08-inv.eps}

# Member, Book, Library

* \small Both `Member` and `Book` are key concepts to the system
  - \footnotesize These are definitely here to stay

\vskip.5em

* \small `Library` is a more difficult concept
  - \footnotesize This is where the key business logic will be implemented or called from
  - \footnotesize Additionally, just like a real library, it will need to track collections, specifically
    - \scriptsize A collection of members -> Which we will implement as the singleton class `MemberList`
    - \scriptsize A collection of books -> Which we will implement as the singleton class `Catalog`

# Borrows and Holds

* \small These are the two association classes
  - \footnotesize Because association classes have no representation in code, we need to deal with them
* \small \textcolor{Roarange}{\textbf{Borrows}}
  - \footnotesize This is on a one-to-many relationship, and thus we can simply move all of its attributes to the many side
* \small \textcolor{Roarange}{\textbf{Holds}} is a bit different
  - \footnotesize Because it is on a many-to-many, we cannot just move it to one or the other side
  - \footnotesize Instead we need to create a class which is accessible to both `Members` and `Books`

# Assigning Responsibilities

* \small We now have a good set of software classes:
  - \footnotesize `Member`
  - \footnotesize `Book`
  - \footnotesize `Library`
  - \footnotesize `MemberList`
  - \footnotesize `Catalog`
  - \footnotesize `Hold`

* \small We now need to assign the responsibilities to these classes
  - \footnotesize This is done by expanding out the use cases
  - \footnotesize And devolving this expanded behavior into the respective classes
  - \footnotesize The tool of this devolution is the \textcolor{Roarange}{\textbf{sequence diagram}}

# Sequence Diagrams

* \small To construct our sequence diagrams (and thus assign responsibilities) we have some work ahead of us
* \small For each system response in the right-hand column of each use case:
   - \footnotesize Specify the sequence in which the operations will occur
     * \scriptsize Requires a complete algorithm
   - \footnotesize Specify how each operation will be carried out
     * \scriptsize Specifies the classes involved in each step of the algorithm
     * \scriptsize This should fully specify these classes
     * \scriptsize Should specify the methods, their parameters, and return types
* \small Often, we will need to make design decisions along the way

# Sequence Diagrams

* \small For the Library System we have the following operations to describe:

::: columns
:::: {.column width=.05}
::::
:::: {.column width=.475}
- \footnotesize Register Member
- \footnotesize Add Books
- \footnotesize Issue Books
- \footnotesize Return Books
- \footnotesize Remove Books
::::
:::: {.column width=.475}
- \footnotesize Member Transactions
- \footnotesize Place Hold
- \footnotesize Process Holds
- \footnotesize Remove Hold
- \footnotesize Renew Books
::::
:::


# Register Member

::: columns
:::: {.column width=.3}

\small \textcolor{Roarange}{\textbf{Algorithm}}

1. \footnotesize Create `Member` Object
2. \footnotesize Add the `Member` object to the list of members
3. \footnotesize Return the result of the operation

::::
:::: {.column width=.7}

\centering
\includegraphics[width=.95\textwidth]{images/design/design01.eps}

::::
:::

\vskip-2em
\footnotesize
\textcolor{Roarange}{\textbf{Design Decision}}

* \footnotesize To carry out the first two steps there are two options:
  1. \scriptsize Invoke `Member`'s constructor from within `addMember` of `Library` \textcolor{Roarange}{\textbf{(preferred)}}
  2. \scriptsize Invoke `addNewMember` on `MemberList` passing all the needed info to create a new member there.
* \footnotesize Option 2 introduces unnecessary coupling between `MemberList` and `Member`

# Add Books

::: columns
:::: {.column width=.3}
\small \textcolor{Roarange}{\textbf{Algorithm}}

1. \footnotesize Create a `Book` object
2. \footnotesize Add the `Book` object to the catalog
3. \footnotesize Return the result

::::
:::: {.column width=.7}
\centering
\includegraphics[width=\textwidth]{images/design/design02.eps}
::::
:::

# Issue Books

::: columns
:::: {.column width=.3}

::::
:::: {.column width=.7}
\centering
\includegraphics[width=.75\textwidth]{images/design/design03.eps}
::::
:::

\vskip-1em
\footnotesize
\textcolor{Roarange}{\textbf{Design Decision}}

* \footnotesize We need to determine how to search for members
  1. \scriptsize Iterate across Member objects using an iterator from `MemberList`, and compare ID's to a target ID
  2. \scriptsize Delegate responsibility to `MemberList`
* \footnotesize Option 1 puts too much detail in `Library`

# Return Books

\centering
\includegraphics[width=.8\textwidth]{images/design/design04.eps}

# Remove Books

\centering
\includegraphics[width=.85\textwidth]{images/design/design05.eps}

# Member Transactions

\centering
\includegraphics[width=.95\textwidth]{images/design/design06.eps}

# Place Hold

\centering
\includegraphics[width=.85\textwidth]{images/design/design07.eps}

# Process Holds

\centering
\includegraphics[width=.85\textwidth]{images/design/design08.eps}

# Remove Hold

\centering
\includegraphics[width=.95\textwidth]{images/design/design09.eps}

# Renew Books

\centering
\includegraphics[width=.75\textwidth]{images/design/design10.eps}

# Coupling and Cohesion

* \small We must keep in mind \textcolor{Roarange}{\textbf{coupling}} and \textcolor{Roarange}{\textbf{cohesion}} when designing systems.
  - \footnotesize We want \textcolor{Roarange}{\textbf{good cohesion}} between entities grouped together or placed within a subsystem
  - \footnotesize We want \textcolor{Roarange}{\textbf{loose coupling}} between these same entities
* \small This is why we separated out the two modules of our system:
  - \footnotesize User interface
  - \footnotesize Business Logic
* \small Additionally, we must keep in mind how we assign responsibilities to classes.
  - \footnotesize Classes should only be assigned those responsibilities necessary to utilize the data (fields) of the class
  - \footnotesize These responsibilities then become the class' methods

# For Next Time

::: columns
:::: column
* Review Chapter 7.1
* Review this lecture
* Read Chapter 7.1 - 7.3
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
