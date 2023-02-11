---
author:
- Isaac Griffith
title: UML Class Diagrams part 2
institute: |
  CS 3321

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outline

* UML Class Diagrams
* UML Object Diagrams

# Shared Aggregation

* Expresses a weak belonging of the parts to a whole
  - Parts also exist independently of the whole
* Multiplicity at the aggregating end may be > 1
  - One element can be part of multiple other elements
* Spans a directed acyclic graph
* Syntax: Hollow diamond at the aggregating end
* Example:
  - `Student` is part of `LabClass`
  - `Course` is part of `StudyProgram`

\begin{center}
\includegraphics[width=.45\textwidth]{images/ClassDiagrams/ClassDiagrams54.eps}
\end{center}

# Composition

* Existence dependency between the composite object and its parts
* One part can only be contained in at most one composite object at one specific point in time
  - Multiplicity at the aggregating end max: 1
  - The composite objects form a tree
* If the composite object is deleted, its parts are also deleted
* Syntax: Solid diamond at the aggregating end
* Example: `Beamer` is part of `LectureHall` is part of `Building`

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams55.eps}
\end{center}

# Shared Aggregation and Composition

* Which model applies?

\includegraphics[width=.45\textwidth]{images/ClassDiagrams/ClassDiagrams56.eps}


# Shared Aggregation and Composition

* Which model applies?

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams57.eps}
\end{center}

# Generalization

::: columns

:::: {.column width=.6}
\footnotesize
* Characteristics (attributes and operations), associations, and aggregations that are specified for a general class (superclass) are passed on to its subclasses.
* Every instance of a subclass is simultaneously an indirect instance of the superclass.
* Subclass inherits all characteristics, associations, and aggregations of the superclass except private ones.
* Subclass may have further characteristics, associations, and aggregations.
* Generalizations are transitive.

::::
:::: {.column width=.4}
\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams58.eps}
\end{center}
::::
:::

# Abstract Class

* Used to highlight common characteristics of their subclasses.
* Used to ensure that there are no direct instances of the superclass.
* Only its non-abstract subclasses can be instantiated.
* Useful in the context of generalization relationships.
* Notation: keyword `{abstract}` or class name in italic font.

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams59.eps}
\end{center}

# Multiple Inheritance

* UML allows multiple inheritance.
* A class may have multiple superclasses

* Example:

\begin{center}
\includegraphics[width=.55\textwidth]{images/ClassDiagrams/ClassDiagrams60.eps}
\end{center}

# With/Without Generalization

\begin{center}
\includegraphics[width=.95\textwidth]{images/ClassDiagrams/ClassDiagrams61.eps}
\end{center}

# Creating a Class Diagram

\footnotesize
* Not possible to completely extract classes, attributes and associations from a natural language text automatically.
* Guidelines
  - \scriptsize Nouns often indicate classes
  - Adjectives indicate attribute values
  - Verbs indicate operations
* \footnotesize Example: The library management system stores users with their unique ID, name and address as well as books with their title, author and ISBN number. Ann Foster wants to use the library.

\vspace{-.5em}
\begin{center}
\includegraphics[width=.5\textwidth]{images/ClassDiagrams/ClassDiagrams62.eps}
\end{center}


# Creating a Class Diagram

\footnotesize
* Not possible to completely extract classes, attributes and associations from a natural language text automatically.
* Guidelines
  - \scriptsize Nouns often indicate classes
  - Adjectives indicate attribute values
  - Verbs indicate operations
* \footnotesize Example: The library management system stores users with their unique ID, name and address as well as books with their title, author and ISBN number. Ann Foster wants to use the library.

\vspace{-.5em}
\begin{center}
\includegraphics[width=.5\textwidth]{images/ClassDiagrams/ClassDiagrams63.eps}
\end{center}

# Example - University Info Sys

\scriptsize
* A university consists of multiple faculties which are composed of various institutes. Each faculty and each institute has a name. An address is know for each institute.
* Each faculty is led by a dean, who is an employee of the university.
* The total number of employees is known. Employees have a social security number, a name, and an email address. There is a distinction between research and administrative personnel.
* Research associates are assigned to at least one institute. The field of study of each research associate is known. Furthermore, research associates can be involved in projects for a certain number of hours, and the name, starting date, and end date of the projects are known. Some research associates hold courses. Then they are called lecturers.
* Courses have a unique number (ID), a name, and a weekly duration in hours.

# Step 1: Identify Classes

::: columns
:::: column
\scriptsize
* A **university** consists of multiple **faculties** which are composed of various **institutes**. Each faculty and each institute has a name. An address is know for each institute.
* Each faculty is led by a **dean**, who is an **employee** of the university.
* The total number of employees is known. Employees have a social security number, a name, and an email address. There is a distinction between **research** and **administrative personnel**.
* Research associates are assigned to at least one institute. The field of study of each research associate is known. Furthermore, research associates can be involved in **projects** for a certain number of hours, and the name, starting date, and end date of the projects are known. Some research associates hold **courses**. Then they are called **lecturers**.
* Courses have a unique number (ID), a name, and a weekly duration in hours.

::::
:::: column
\vspace{-1.5em}
\begin{center}
\includegraphics[width=.65\textwidth]{images/ClassDiagrams/ClassDiagrams64.eps}
\end{center}

::::
:::

# Step 2: Identify Attributes

::: columns
:::: column
\scriptsize
* A university consists of multiple faculties which are composed of various institutes. Each faculty and each institute has a **name**. An **address** is know for each institute.
* Each faculty is led by a dean, who is an employee of the university.
* The total **number of employees** is known. Employees have a **social security number**, a **name**, and an **email address**. There is a distinction between research and administrative personnel.
* Research associates are assigned to at least one institute. The field of study of each research associate is known. Furthermore, research associates can be involved in projects for a certain number of **hours**, and the **name**, **starting date**, and **end date** of the projects are known. Some research associates hold courses. Then they are called lecturers.
* Courses have a **unique number** (ID), a **name**, and a **weekly duration** in hours.

::::
:::: column
\vspace{-1.5em}
\begin{center}
\includegraphics[width=.5\textwidth]{images/ClassDiagrams/ClassDiagrams67.eps}
\end{center}

::::
:::

# Step 2: Identify Relationships

::: columns
:::: {.column width=.6}
* Three kinds of relationships:
  - Association
  - Generalization
  - Aggregation

* Indication of generalization
* *"There is a distinction between research and administrative personnel."*
* *"Some research associates hold courses. Then they are called lecturers."*

::::
:::: {.column width=.4}
\vspace{-1.5em}
\begin{center}
\includegraphics[width=.65\textwidth]{images/ClassDiagrams/ClassDiagrams68.eps}
\end{center}

::::
:::

# Step 2: Identify Relationships

* "A university consists of multiple faculties which are composed of various institutes."

\begin{center}
\includegraphics[width=.65\textwidth]{images/ClassDiagrams/ClassDiagrams69.eps}
\end{center}

# Step 2: Identify Relationships

* "Each faculty is led by a dean, who is an employee of the university"

\begin{center}
\includegraphics[width=.65\textwidth]{images/ClassDiagrams/ClassDiagrams70.eps}
\end{center}

# Step 2: Identify Relationships

* "Research associates are assigned to at least one institute."

\begin{center}
\includegraphics[width=.65\textwidth]{images/ClassDiagrams/ClassDiagrams71.eps}
\end{center}


# Step 2: Identify Relationships

* "Furthermore, research associates can be involved in projects for a certain number of hours."

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams72.eps}
\end{center}

# Step 2: Identify Relationships

* "Some research associates hold courses. Then they are called lecturers."

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams73.eps}
\end{center}

# Complete Class Diagram

\begin{center}
\includegraphics[width=.45\textwidth]{images/ClassDiagrams/ClassDiagrams74.eps}
\end{center}

# Code Generation

* Class diagrams are often created with the intention of implementing the modeled elements in an object-oriented programming language.
* Often, translation is semi-automatic and requires only minimal manual intervention.

# Code Generation

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams75.eps}
\end{center}

# Code Generation

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams76.eps}
\end{center}

# Code Generation

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams77.eps}
\end{center}

# Code Generation

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams78.eps}
\end{center}

# Code Generation

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams79.eps}
\end{center}

# Code Generation

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams80.eps}
\end{center}

# Notation Elements

+----------------+---------------------------------------------------------------------------------+----------------------------------------------------------------+
| Name           | Notation                                                                        | Description                                                    |
+:===============+:===============================================================================:+:===============================================================+
| Class          | \includegraphics[width=.15\textwidth]{images/ClassDiagrams/ClassDiagrams81.eps} | Description of the structure and behavior of a set of objects. |
+----------------+---------------------------------------------------------------------------------+----------------------------------------------------------------+
| Abstract Class | \includegraphics[width=.25\textwidth]{images/ClassDiagrams/ClassDiagrams82.eps} | Class that cannot be instantiated                              |
+----------------+---------------------------------------------------------------------------------+----------------------------------------------------------------+
| Association    | \includegraphics[width=.25\textwidth]{images/ClassDiagrams/ClassDiagrams83.eps} | Relationship between classes                                   |
+----------------+---------------------------------------------------------------------------------+----------------------------------------------------------------+

# Notation Elements

+--------------------+---------------------------------------------------------------------------------+--------------------------------------------------------------------------------------------------------+
| Name               | Notation                                                                        | Description                                                                                            |
+:===================+:===============================================================================:+:=======================================================================================================+
| n-ary Association  | \includegraphics[width=.25\textwidth]{images/ClassDiagrams/ClassDiagrams84.eps} | Relationship between n (here 3)  classes                                                               |
+--------------------+---------------------------------------------------------------------------------+--------------------------------------------------------------------------------------------------------+
| Association Class  | \includegraphics[width=.25\textwidth]{images/ClassDiagrams/ClassDiagrams85.eps} | More detailed description of an association                                                            |
+--------------------+---------------------------------------------------------------------------------+--------------------------------------------------------------------------------------------------------+
| `xor` Relationship | \includegraphics[width=.25\textwidth]{images/ClassDiagrams/ClassDiagrams86.eps} | An object of `C` is in a relationship with an object of `A` or with an object of `B` but not with both |
+--------------------+---------------------------------------------------------------------------------+--------------------------------------------------------------------------------------------------------+

# Notation Elements

+--------------------+---------------------------------------------------------------------------------+-------------------------------------------------------------------+
| Name               | Notation                                                                        | Description                                                       |
+:===================+:===============================================================================:+:==================================================================+
| Shared Aggregation | \includegraphics[width=.25\textwidth]{images/ClassDiagrams/ClassDiagrams87.eps} | Parts-whole relationship (`A` is part of `B`)                     |
+--------------------+---------------------------------------------------------------------------------+-------------------------------------------------------------------+
| Composition        | \includegraphics[width=.25\textwidth]{images/ClassDiagrams/ClassDiagrams88.eps} | Existence-dependent parts-whole relationship (`A` is part of `B`) |
+--------------------+---------------------------------------------------------------------------------+-------------------------------------------------------------------+
| Generalization     | \includegraphics[width=.25\textwidth]{images/ClassDiagrams/ClassDiagrams89.eps} | Inheritance relationship (`A` inherits from `B`)                  |
+--------------------+---------------------------------------------------------------------------------+-------------------------------------------------------------------+
| Object             | \includegraphics[width=.15\textwidth]{images/ClassDiagrams/ClassDiagrams90.eps} | Instance of a class                                               |
+--------------------+---------------------------------------------------------------------------------+-------------------------------------------------------------------+
| Link               | \includegraphics[width=.25\textwidth]{images/ClassDiagrams/ClassDiagrams91.eps} | Relationship between objects                                      |
+--------------------+---------------------------------------------------------------------------------+-------------------------------------------------------------------+

# Trial 1: Home Heating System

**Problem:** Design a simple Home Heating System. This system includes at least a thermostat and a heater. The house is a combination of rooms and a thermostat controls the heater output for a room. A heater can have one thermostat. We know about a specific type of heater called an electric heater and a specific type of thermostat called the AubeTH101D.

# Trial 2: Chess Game Backend

**Problem:** Describe, using a class diagram, the pieces, board, and game tree for a simple chess game. These components will be used to create a chess game used for play either standalone or in network mode.

# Trial 3: Domain Model of Outside

**Problem:** Describe, using a class diagram, the relationships between the following concepts: Oak tree, Maple tree, Shrub, Branch, Lawn, Leaf, Grass.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
