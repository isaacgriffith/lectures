---
author:
- Isaac Griffith
title: UML Class Diagrams part 1
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

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
