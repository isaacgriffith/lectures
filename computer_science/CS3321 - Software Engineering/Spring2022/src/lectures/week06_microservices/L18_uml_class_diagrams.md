---
author:
- Dr. Isaac Griffith
title: UML Object and Class Diagrams
institute: |
  CS 3321

  Department of Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outline

* UML Class Diagrams
* UML Object Diagrams

# Object

* Individuals of a system

* Alternative notations:

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams01.eps}
\end{center}

# Object Diagrams

* Objects of a system and their relationships (links)
* Snapshot of objects at a specific moment in time

\begin{center}
\includegraphics[width=.75\textwidth]{images/ClassDiagrams/ClassDiagrams02.eps}
\end{center}

# From Object to Class

\footnotesize
* Individuals of a system often have identical characteristics and behavior
* A class is a construction plan for a set of similar objects of a system
* Objects are instances of Classes
* Attributes; structural characteristics of a class
  - Different value for each instance (= object)

* Operations: behavior of a class
  - Identical for all objects of a class (not depicted in object diagram)

::: columns
:::: column
\begin{center}
\includegraphics[width=.35\textwidth]{images/ClassDiagrams/ClassDiagrams03.eps}
\end{center}
::::
:::: column
\begin{center}
\includegraphics[width=.35\textwidth]{images/ClassDiagrams/ClassDiagrams04.eps}
\end{center}
::::
:::

# Class

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams05.eps}
\end{center}

# Attribute Syntax

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams06.eps}
\end{center}

# Attribute Syntax - Visibility

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams07.eps}
\end{center}

::: columns
:::: {.column width=.4}
\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams08.eps}
\end{center}
::::
:::: {.column width=.6}
* Who is permitted to access the attribute
  - \+ ... public: everybody
  - \- ... private: only the object itself
  - \# ... protected: class itself and subclasses
  - ~ ... package: classes that are in the same package
::::
:::

# Attribute Syntax - Derived Attributes

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams09.eps}
\end{center}

::: columns
:::: {.column width=.4}
\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams10.eps}
\end{center}
::::
:::: {.column width=.6}
* Attribute value is derived from other attrib utes
  - **age**: calculated from the date of birth
::::
:::

# Attribute Syntax - Name

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams11.eps}
\end{center}

::: columns
:::: {.column width=.4}
\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams12.eps}
\end{center}
::::
:::: {.column width=.6}
* Name of the attribute
::::
:::

# Attribute Syntax - Type

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams13.eps}
\end{center}

::: columns
:::: {.column width=.4}
\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams14.eps}
\end{center}
::::
:::: {.column width=.6}
* Type
  - User-defined classes
  - Data type
    - Pre-defined: Boolean, Integer, UnlimitedNatural, String
    - User-defined: $\ll$primitive$\gg$
    - Composite data type: $\ll$datatype$\gg$
    - Enumerations: $\ll$enumeration$\gg$

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams15.eps}
\end{center}
::::
:::

# Attribute Syntax - Multiplicity

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams16.eps}
\end{center}

::: columns
:::: {.column width=.4}
\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams17.eps}
\end{center}
::::
:::: {.column width=.6}

* Number of values an attribute may contain
* Default value: 1
* Notation: **[min..max]**
  - no upper limit: `[*]` or `[0..*]`

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams18.eps}
\end{center}

::::
:::

# Attribute Syntax - Default Value

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams19.eps}
\end{center}

::: columns
:::: {.column width=.4}
\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams20.eps}
\end{center}
::::
:::: {.column width=.6}
* Default value
  - Used if the attribute value is not set explicitly by the user
::::
:::

# Attribute Syntax - Properties

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams21.eps}
\end{center}

\vspace{-1em}
::: columns
:::: {.column width=.4}
\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams22.eps}
\end{center}
::::
:::: {.column width=.6}

\footnotesize
* Pre-defined Properties
  - \scriptsize`{readOnly}` ... value cannot be changed
  - `{unique}` ... no duplicates permitted
  - `{non-unique}` ... duplicates permitted
  - `{ordered}` ... fixed order of the values
  - `{unordered}` ... no fixed order to the values

\footnotesize
* Attribute specification
  - \scriptsize Set: `{unordered, unique}`
  - Multi-set: `{unordered, non-unique}`
  - Ordered set: `{ordered, unique}`
  - List: `{ordered, non-unique}`
::::
:::

# Operation Syntax - Parameters

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams23.eps}
\end{center}

\vspace{-1.5em}

::: columns
:::: {.column width=.35}
\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams24.eps}
\end{center}
::::
:::: {.column width=.65}
\footnotesize
* Notation similar to attributes
* Direction of the parameter
  - \scriptsize`in` ... input parameter
    - \scriptsize When the operation is used, a value is expected from this parameter
  - `out` ... output parameter
    - \scriptsize After the execution of the operation, the parameter has adopted a new value
  - `inout` ... combined input/output parameter
::::
:::

\vspace{-2em}
\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams25.eps}
\end{center}

# Operation Syntax - Type

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams26.eps}
\end{center}

::: columns
:::: column
\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams26a.eps}
\end{center}
::::
:::: column
* Type of the return value
::::
:::


# Class Variable and Class Operation

\footnotesize
* Instance variable (= instance attribute): attributes defined on instance level
* Class Variable (= class attribute, static attribute)
  - \scriptsize Defined only once per class, i.e., shared by all instances of the class
  - E.g. counters for the number of instances of a class, constants, etc.
\footnotesize
* Class operation (= static operation)
  - \scriptsize Can be used if no instance of the corresponding class was created
  - E.g. constructors, counting operations, math functions (sin(x)), etc.
\footnotesize
* Notation: underlining name of class variable/class operation

\vspace{-1em}
\begin{center}
\includegraphics[width=.60\textwidth]{images/ClassDiagrams/ClassDiagrams27.eps}
\end{center}

# Specification of Classes

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams28.eps}
\end{center}

# Association

* Models possible relationships between instances of classes

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams29.eps}
\end{center}

# Binary Association

* Connects instances of two classes with one another

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams30.eps}
\end{center}

# Binary Association - Navigation

* Navigability: an object knows its partner objects and can therefore access their visible attributes and operations
  - Indicated by an open arrow head
* Non-navigability
  - Indicated by cross
* Example:
  - **A** can access the visible attributes and operations of **B**
  - **B** cannot access any attributes and operations of **A**
* Navigability undefined
  - Bidirectional navigability is assumed

::: columns
:::: column
\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams31.eps}
\end{center}
::::
:::: column
\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams32.eps}
\end{center}
::::
:::

# Navigability Best Practices

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams33.eps}
\end{center}

# Binary Association as Attribute

\begin{center}
\includegraphics[width=.5\textwidth]{images/ClassDiagrams/ClassDiagrams34.eps}
\end{center}

* Java-like notation:

\begin{center}
\includegraphics[width=.5\textwidth]{images/ClassDiagrams/ClassDiagrams35.eps}
\end{center}

# Multiplicity and Role

* Multiplicity: Number of objects that may be associated with exactly one object of the opposite side

\begin{center}
\includegraphics[width=.5\textwidth]{images/ClassDiagrams/ClassDiagrams36.eps}
\end{center}

* Role: describes the way in which an object is involved in an association relationship

\begin{center}
\includegraphics[width=.33\textwidth]{images/ClassDiagrams/ClassDiagrams37.eps}
\end{center}

# `xor` Constraint

* "exclusive or" constraint

* An object of class **A** is to be associated with an object of class **B** or an object of class **C** but not with both

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams38.eps}
\end{center}

# Unary Association

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams39.eps}
\end{center}

# Unary Association

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams40.eps}
\end{center}

# n-ary Associations

* More than two partner objects are involved in the relationship
* No navigation directions

\begin{center}
\includegraphics[width=.5\textwidth]{images/ClassDiagrams/ClassDiagrams41.eps}
\end{center}

# n-ary Associations

* Example
  - `(Student, Exam)` -> `(Lecturer)`
    - One student takes one exam with one or no lecturer
  - `(Exam, Lecturer)` -> `(Student)``
    - One exam with one lecturer can be taken by any number of students
  - `(Student, Lecturer)` -> `(Exam)`
    - One student can be graded by one **Lecturer** for any number of exams

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams42.eps}
\end{center}

# Association Class

* Assign attributes to the relationship between classes rather than to a class itself

\begin{center}
\includegraphics[width=.5\textwidth]{images/ClassDiagrams/ClassDiagrams43.eps}
\end{center}

# Association Class

\begin{center}
\includegraphics[width=.65\textwidth]{images/ClassDiagrams/ClassDiagrams45.eps}
\end{center}

# Association vs. Regular Classes

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams50.eps}
\end{center}

# Association Class

::: columns
:::: column

* Default: no duplicates

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams51.eps}
\end{center}

::::
:::: column

* non-unique: duplicates allowed

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams52.eps}
\end{center}

::::
:::

# Association Class

\begin{center}
\includegraphics[width=.85\textwidth]{images/ClassDiagrams/ClassDiagrams53.eps}
\end{center}

# Aggregation

* Special form of association
* Used to express that a class is part of another class
* Properties of the aggregation association
  - **Transitive:** if `B` is part of `A` and `C` is part of `B`, `C` is also part of `A`
  * **Asymmetric:** It is not possible for `A` to be part of `B` and `B` to be part of `A` simultaneously.

* Two types;
  - Shared aggregation
  - Composition

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
