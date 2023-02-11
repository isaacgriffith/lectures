---
author:
- Dr. Isaac Griffith
title: UML Overview
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Outcomes

After today's lecture you will:

::: columns
:::: {.column width=.7}
* Have and understanding of the different types of UML Diagrams
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert.jpg}
::::
:::

# A Reminder

\vfill
\begin{center}
\includegraphics[width=.95\textwidth]{images/intro/intro_03-inv.eps}
\end{center}

#

\centering
\vfill
\begin{minipage}{.45\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Introducing UML
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Describing OO Systems

* The Unified Modeling Language (UML) is a standard for documenting OO systems
* UML provides a graphical notation for documenting the artifacts (classes, objects, and packages) of an OO system.
* UML diagrams can be divided into 3 categories
  - \footnotesize \textbf{Structural Diagrams}
  - \footnotesize \textbf{Behavior Diagrams}
  - \footnotesize \textbf{Interaction Diagrams}

# Structural Diagrams

::: columns
:::: column
* \footnotesize Show the static architecture of the system irrespective of time.
* \footnotesize Structural Diagrams may be any of the following:
  - \scriptsize \textbf{Class Diagrams} - shows classes, methods and fields
  - \scriptsize \textbf{Composite Structure Diagrams} - provides a means for presenting the details of a structural element (i.e., a class)
  - \scriptsize \textbf{Component Diagrams} - Shows the details of components (software entities that satisfy functional requirements)
::::
:::: column
\centering
\includegraphics[width=\textwidth]{images/uml/struct_dia.eps}
::::
:::

# Structural Diagrams

::: columns
:::: column
* \footnotesize Show the static architecture of the system irrespective of time.
* \footnotesize Structural Diagrams may be any of the following:
  - \scriptsize \textbf{Deployment Diagrams} - Shows the assignment of executable files to computing elements and the communication between entities.
  - \scriptsize \textbf{Object Diagrams} - Shows how objects related at runtime
  - \scriptsize \textbf{Package Diagrams} - Shows packages and the dependencies between them.
::::
:::: column
\centering
\includegraphics[width=\textwidth]{images/uml/struct_dia.eps}
::::
:::

# Behavior Diagrams

::: columns
:::: column
* \footnotesize Depict the behavior of a system or business process
* \footnotesize Behavior diagrams may be any of the following:
  - \scriptsize \textbf{Activity Diagrams} - similar to a flowchart and shows the events of an activity
  - \scriptsize \textbf{Use Case Diagrams} - shows the interaction involved in a use case.
  - \scriptsize \textbf{State Machine Diagrams} - shows the sequence of states that an object goes through in its lifetime
::::
:::: column
\centering
\includegraphics[width=\textwidth]{images/uml/beh_dia.eps}
::::
:::

# Interaction Diagrams

::: columns
:::: column
* \footnotesize Show the methods, interactions, and activities of the objects
* \footnotesize Interaction diagrams may be any of the following:
  - \scriptsize \textbf{Sequence Diagrams} - details how operations are carried out
  - \scriptsize \textbf{Timing Diagrams} - shows an object's change in state over time as it reacts to events
  - \scriptsize \textbf{Communication Diagrams} - has the same purpose as a sequence diagram, but with a different layout
  - \scriptsize \textbf{Interaction Overview Diagrams} - shows the high-level control flow in a system
::::
:::: column
\centering
\includegraphics[width=\textwidth]{images/uml/inter_dia.eps}
::::
:::

# Class Diagrams

::: columns
:::: column
* \footnotesize Each class is represented by a box or a box divided into three sections.
  - \scriptsize The top section displays the name of the class
  - \scriptsize The middle section displays the attributes (fields, properties)
  - \scriptsize The bottom section displays the operations (methods, functions)

* \footnotesize Attributes are defined as follows:
  - \scriptsize an access modifier (`+`, `-`, `#`, `~`)
  - \scriptsize attribute name
  - \scriptsize colon (:) and
  - \scriptsize attribute type
::::
:::: column
\centering
\includegraphics[width=\textwidth]{images/uml/class_dia.eps}
::::
:::

# Class Diagrams

::: columns
:::: column
\footnotesize

* \footnotesize Methods are defined as follows:
  - \scriptsize an access modifier (`+`, `-`, `#`, `~`)
  - \scriptsize method name
  - \scriptsize parameter list in parentheses
    * \scriptsize a comma-separated list of:

      `name : type`
  - \scriptsize colon (:) and
  - \scriptsize return type

* \footnotesize Access Modifiers
  \scriptsize

  `+` - public

  `#` - protected

  `~` - package/default

  `-` - private
::::
:::: column
\centering
\includegraphics[width=\textwidth]{images/uml/class_dia.eps}
::::
:::

# Associations

* \footnotesize Associations depict some relationship between two classes
  * \scriptsize The example shows that the `Accounts` instance contains zero or more `BankAccount` instances
  * \scriptsize The numbers are called the multiplicity and indicate that the opposite side is connected to the number and number's side class.
    - \scriptsize That is each `BankAccount` is related to exactly 1 `Accounts`
  * \scriptsize The most basic association is simply a solid line with no arrows (indicating bidirectionality)

\begin{center}
\includegraphics[width=0.65\textwidth]{images/uml/associations.eps}
\end{center}

# Interfaces and Implementations

::: columns
:::: column
* \footnotesize Class diagrams can also depict interfaces and their realizations

* \footnotesize These relationships are depicted by **a dashed line with a white triangular arrowhead** point towards the interface.

* \footnotesize For example:
  - \scriptsize We show that the `StudentLinkedList` implements the `StudentList` interface
  - \scriptsize It should also be noted that the interface's operations are assumed to be **abstract**
  - \scriptsize Thus, the implementing class (`StudentLinkedList`) should also have the same methods
::::
:::: column
\centering
\includegraphics[width=.65\textwidth]{images/uml/interfaces.eps}
::::
:::

# Use Cases

* Constructed during the Analysis Phase
* Describes a feature of an application system
  * \footnotesize Describes the interaction between an **actor** (human, software, or hardware)
  * \footnotesize Does **not** describe **how** the system carries out the task
* Uses cases may be textually describe in a table with two columns
  * \footnotesize First column describes what the actor does
  * \footnotesize Second column describes the system's response
* The use case does not depict all possible situations, but rather only the **main flow**

# ATM System Use Case

\footnotesize
+----+------------------------------------------------+----+-----------------------------------------------------------+
|    | **Action performed by the actor**              |    | **Responses from the system**                             |
+:==:+:===============================================+:==:+:==========================================================+
| 1  | Inserts debit card into the 'Insert card' slot |    |                                                           |
+----+------------------------------------------------+----+-----------------------------------------------------------+
|    |                                                | 2  | Asks for the PIN number                                   |
+----+------------------------------------------------+----+-----------------------------------------------------------+
| 3  | Enters the PIN number                          |    |                                                           |
+----+------------------------------------------------+----+-----------------------------------------------------------+
|    |                                                | 4  | Verifies the PIN. If the PIN is invalid displays an error |
|    |                                                |    | and goes to Step 8. Otherwise, asks for the amount        |
+----+------------------------------------------------+----+-----------------------------------------------------------+
| 5  | Enters the amount                              |    |                                                           |
+----+------------------------------------------------+----+-----------------------------------------------------------+
|    |                                                | 6  | Verifies that the amount can be withdrawn.                |
|    |                                                |    | If not, display an error and goes to Step 8.              |
|    |                                                |    | Otherwise, dispenses the amount and updates the balance   |
+----+------------------------------------------------+----+-----------------------------------------------------------+
| 7  | Takes the cash                                 |    |                                                           |
+----+------------------------------------------------+----+-----------------------------------------------------------+
|    |                                                | 8  | Ejects the card                                           |
+----+------------------------------------------------+----+-----------------------------------------------------------+
| 9  | Takes the card                                 |    |                                                           |
+----+------------------------------------------------+----+-----------------------------------------------------------+

# Use Case Diagrams

::: columns
:::: column
\footnotesize
* A Visual Diagram depicting the use cases of a system and their relationships.
* A Use Case Diagram is composed of the following components
  - \scriptsize A rectangle with a system name depicting the system boundaries
  - \scriptsize Stick figures representing actors
    - \tiny Actors to the left, **primary actors**, directly start interactions with the system
    - \tiny Actors to the right, **secondary actors**, react to system events
    - \tiny Actors, being separate from the system, must be outside the system boundary
::::
:::: column
\centering
\includegraphics[width=\textwidth]{images/uml/use_case_dia.eps}
::::
:::

  - \scriptsize Lines between actors and use cases indicate association.

# Sequence Diagrams

\centering
\includegraphics[width=.4\textwidth]{images/uml/seq_dia.eps}

# UML Tools

* Violet UML (free)
  - http://horstmann.com/violet/
* StarUML (semi-free)
  - http://staruml.io
* LucidCharts (free for student use)
  - http://lucidcharts.com
* Rational Rose
  - http://www.rational.com/
* There are many others, but most are commercial

#

\centering
\vfill
\begin{minipage}{.35\textwidth}
\includegraphics[width=13pt]{images/mark.png}
\Huge LucidChart
\vskip-.25em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# For Next Time

::: columns
:::: column
* Review Chapters 2.7
* Review this lecture
* Come to class
* Read Chapter 3
* Continue working on Homework 02
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert.png}
::::
:::

#

\centering
\includegraphics[scale=.40]{images/questions-invert.png}

\Huge \textbf{Are there any questions?}
