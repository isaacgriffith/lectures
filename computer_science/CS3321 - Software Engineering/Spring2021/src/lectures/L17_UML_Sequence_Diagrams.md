---
author:
- Isaac Griffith
title: UML Sequence Diagrams
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

* UML Sequence Diagrams

# Introduction

* Modeling inter-object behavior
  - interactions between objects
* Interaction
  - Specifies how messages and data are exchanged between interaction partners
* Interaction partners
  - Human (lecturer, administrator, ...)
  - Non-human (server, printer, executable software, ...)
* Examples of interactions
  - Conversation between persons
  - Message exchange between humans and a software system
  - Communication protocols
  - Sequence of method calls in a program
  - ...

# Interaction Diagrams

* Used to specify interactions
* Modeling concrete scenarios
* Describing communication sequences at different levels of detail

* Interaction Diagrams show the following:
  - Interaction of a system with its environment
  - Interaction between system parts in order to show how a specific use case can be implemented
  - Interprocess communication in which the partners involved must observe certain protocols
  - Communication at class level (operation calls, inter-object behavior)

# Sequence Diagram

* Two-dimensional diagram
  - Horizontal axis: involved interaction partners
  - Vertical axis: chronological order of the interaction
* Interaction = sequence of event specifications

\begin{center}
\includegraphics[width=0.5\textwidth]{images/SequenceDiagrams/SequenceDiagram01.eps}
\end{center}

# Interaction Partners

* Interaction partners are depicted as lifelines
* Head of the lifeline
  - Rectangle that contains the expression **roleName:Class**
  - Roles are a more general concept than objects
  - Object can take on different roles over its lifetime
* Body of the lifeline
  - Vertical, usually dashed line
  - Represents the lifetime of the object associated with it

\begin{center}
\includegraphics[width=0.85\textwidth]{images/SequenceDiagrams/SequenceDiagram02.eps}
\end{center}

# Exchanging Messages

* Interaction: sequence of events
* Message is defined via send event and receive event

* Execution specification
  - Continuous bar
  - Used to visualize when an interaction partner executes some behavior

\begin{center}
\includegraphics[width=0.65\textwidth]{images/SequenceDiagrams/SequenceDiagram03.eps}
\end{center}

# Exchanging Messages

**Order of messages:**

::: columns
:::: column
\begin{center}
... on one lifeline

\includegraphics[width=0.5\textwidth]{images/SequenceDiagrams/SequenceDiagram04.eps}
\end{center}

\begin{center}
... on different lifelines which exchange messages

\includegraphics[width=0.33\textwidth]{images/SequenceDiagrams/SequenceDiagram06.eps}
\end{center}

::::
:::: column
\begin{center}
... on different lifelines

\includegraphics[width=0.33\textwidth]{images/SequenceDiagrams/SequenceDiagram05.eps}
\end{center}

::::
:::



# Messages

::: columns
:::: {.column width=.8}
\footnotesize
* Syncronous message
  - \scriptsize Sender waits until it has received a response message before continuing
  - Syntax of message name: `msg(par1, par2)`
    * \scriptsize `msg`: the name of the message
    * `par`: parameters separated by commas
::::
:::: {.column width=.2}
\begin{center}
\includegraphics[width=0.75\textwidth]{images/SequenceDiagrams/SequenceDiagram07.eps}
\end{center}
::::
:::


::: columns
:::: {.column width=.8}
\footnotesize
* Asynchronous message
  - \scriptsize Sender continues without waiting for a response message
  - Syntax of message name: `msg(par1, par2)`
::::
:::: {.column width=.2}
\begin{center}
\includegraphics[width=0.75\textwidth]{images/SequenceDiagrams/SequenceDiagram08.eps}
\end{center}
::::
:::

::: columns
:::: {.column width=.8}
\footnotesize
* Response message
  - \scriptsize May be omitted if content and location are obvious
  - Syntax: `att=msg(par1, par2) : val`
    * \scriptsize `att`: the return value can optionally be assigned to a variable
    * `msg`: the name of the message
    * `par`: parameters separated by commas
    * `val`: return value
::::
:::: {.column width=.2}
\begin{center}
\includegraphics[width=0.75\textwidth]{images/SequenceDiagrams/SequenceDiagram09.eps}
\end{center}
::::
:::

# Messages

::: columns
:::: {.column width=.8}
\footnotesize
* Object creation
  - \scriptsize Dashed arrow
  - Arrowhead points to the head of the lifeline of the object to be created
  - Keyword **new**
::::
:::: {.column width=.2}
\begin{center}
\includegraphics[width=0.5\textwidth]{images/SequenceDiagrams/SequenceDiagram10.eps}
\end{center}
::::
:::

::: columns
:::: {.column width=.8}
\footnotesize
* Object desctruction
  - \scriptsize Object is deleted
  - Large cross ($\times$) at the end of the lifeline
::::
:::: {.column width=.2}
\begin{center}
\includegraphics[width=0.33\textwidth]{images/SequenceDiagrams/SequenceDiagram11.eps}
\end{center}
::::
:::

\vspace{-1em}
\begin{center}
\includegraphics[width=0.33\textwidth]{images/SequenceDiagrams/SequenceDiagram12.eps}
\end{center}

# Messages

::: columns
:::: {.column width=.8}
\footnotesize
* Found message
  - \scriptsize Sender of a message is unknown or not relevant
::::
:::: {.column width=.2}
\begin{center}
\includegraphics[width=0.33\textwidth]{images/SequenceDiagrams/SequenceDiagram13.eps}
\end{center}
::::
:::

::: columns
:::: {.column width=.8}
\footnotesize
* Lost message
  - \scriptsize Receiver of a message is unknown or not relevant
::::
:::: {.column width=.2}
\begin{center}
\includegraphics[width=0.33\textwidth]{images/SequenceDiagrams/SequenceDiagram14.eps}
\end{center}
::::
:::

::: columns
:::: {.column width=.8}
\footnotesize
* Time-consuming message
  - \scriptsize "Message with duration"
  - Usually messages are assumed to be transmitted without any loss of time
  - Express that time elapses between the sending and the receipt of a message
::::
:::: {.column width=.2}
\begin{center}
\includegraphics[width=0.5\textwidth]{images/SequenceDiagrams/SequenceDiagram15.eps}
\end{center}
::::
:::

\begin{center}
\includegraphics[width=0.5\textwidth]{images/SequenceDiagrams/SequenceDiagram16.eps}
\end{center}

# Combined Fragments

* Model various control structures
* 12 predefined types of operators

\begin{center}
\includegraphics[width=0.75\textwidth]{images/SequenceDiagrams/SequenceDiagram17.eps}
\end{center}

# Branch/Loop Combined Fragments

+----------+-------------------------+
| Operator | Purpose                 |
+:=========+:========================+
| `alt`    | Alternative interaction |
+----------+-------------------------+
| `opt`    | Optional interaction    |
+----------+-------------------------+
| `loop`   | Repeated interaction    |
+----------+-------------------------+
| `break`  | Exception interaction   |
+----------+-------------------------+

# Concurrency Combined Fragments

+------------+------------------------+
| Operator   | Purpose                |
+:===========+:=======================+
| `seq`      | Weak order             |
+------------+------------------------+
| `strict`   | Strict order           |
+------------+------------------------+
| `par`      | Concurrent interaction |
+------------+------------------------+
| `critical` | Atomic interaction     |
+------------+------------------------+

# Filters/Assertions Combined Fragments

+------------+------------------------+
| Operator   | Purpose                |
+:===========+:=======================+
| `ignore`   | Irrelevant interaction |
+------------+------------------------+
| `consider` | Relevant interaction   |
+------------+------------------------+
| `assert`   | Asserted interaction   |
+------------+------------------------+
| `neg`      | Invalid interaction    |
+------------+------------------------+

# `alt` Fragment

::: columns
:::: column
* To model alternative sequences
* Similar to switch stmt in Java
* Guards are used to select the one path to be executed
* Guards
  - Modeled in square brackets
  - default: `true`
  - predefined: `[else]`

* Multiple operands
* Guards have to be disjoint to avoid indeterministic behavior
::::
:::: column
\begin{center}
\includegraphics[width=0.75\textwidth]{images/SequenceDiagrams/SequenceDiagram18.eps}
\end{center}
::::
:::

# `opt` Fragment

::: columns
:::: column
* To model an optional sequence
* Actual execution at runtime is dependent on the guard
* Exactly one operand
* Similar to `if` statement without `else` branch
* Equivalent to `alt` fragment with two operands, one of which is empty
::::
:::: column
\begin{center}
\includegraphics[width=.75\textwidth]{images/SequenceDiagrams/SequenceDiagram19.eps}
\end{center}
::::
:::

# `loop` Fragment

\footnotesize
* To express that a sequence is to be executed repeatedly
* Exactly one operand
* Keyword loop followed by the minimal/maximal number of iterations **(min..max)** or **(min, max)**
  - default: `(*)` .. no upper limit
* Guard
  - Evaluated as soon as the minimum number of iterations has taken place
  - Checked for each iteration within the `(min, max)` limits
  - If the guard evaluates to false, the execution of the loop is terminated

\begin{center}
\includegraphics[width=.75\textwidth]{images/SequenceDiagrams/SequenceDiagram20.eps}
\end{center}

# `break` Fragment

::: columns
:::: column
* Simple form of exception handling
* Exactly one operand with a guard
* If the guard is true:
  - Interactions within this operand are executed
  - Remaining operations of the surrounding fragment are omitted
  - Interaction continues in the next higher level fragment
  - Different behavior than `opt` fragment
::::
:::: column
\begin{center}
\includegraphics[width=.5\textwidth]{images/SequenceDiagrams/SequenceDiagram21.eps}
\end{center}
::::
:::

# `loop`/`break` Example

\begin{center}
\includegraphics[width=.65\textwidth]{images/SequenceDiagrams/SequenceDiagram22.eps}
\end{center}

# `seq` Fragment

* Default order of events
* Weak sequencing:
  1. The ordering of events within each of the operands is maintained in the result.
  2. Events on different lifelines from different operands may come in any order.
  3. Events on the same lifeline from different operands are ordered such that an event of the first operand comes before that of the second operand.

\begin{center}
\includegraphics[width=.65\textwidth]{images/SequenceDiagrams/SequenceDiagram23.eps}
\end{center}

# `seq` Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/SequenceDiagrams/SequenceDiagram24.eps}
\end{center}

# `strict` Fragment

* Sequential interaction with order
* Order of events occurrences on different lifelines between different operands is significant
  - Messages in an operand that is higher up on the vertical axis are always exchanged before the messages in an operand that is lower down on the vertical axis

\begin{center}
\includegraphics[width=.65\textwidth]{images/SequenceDiagrams/SequenceDiagram25.eps}
\end{center}

# `strict` Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/SequenceDiagrams/SequenceDiagram26.eps}
\end{center}

# `par` Fragment

* To set aside chronological order between messages in different operands
* Execution paths of different operands can be interleaved
* Restrictions of each operand need to be respected
* Order of the different operands is irrelevant
* Concurrency, no true parallelism

\begin{center}
\includegraphics[width=.5\textwidth]{images/SequenceDiagrams/SequenceDiagram27.eps}
\end{center}

# `par` Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/SequenceDiagrams/SequenceDiagram28.eps}
\end{center}

# Coregion

* To model concurrent events of a single lifeline
* Order of event occurrences within a coregion is not restricted
* Area of the lifeline to be covered by the coregion is marked by square brackets rotated 90 degrees

\begin{center}
\includegraphics[width=.6\textwidth]{images/SequenceDiagrams/SequenceDiagram29.eps}
\end{center}

# Coregion Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/SequenceDiagrams/SequenceDiagram30.eps}
\end{center}

# `critical` Fragment

* Atomic area in the interaction (one operand)
* To make sure that certain perats of an interaction are not interrupted by unexpected events
* Order within `critical:` default order `seq`

\begin{center}
\includegraphics[width=.6\textwidth]{images/SequenceDiagrams/SequenceDiagram31.eps}
\end{center}

# `critical` Example

\begin{center}
\includegraphics[width=.7\textwidth]{images/SequenceDiagrams/SequenceDiagram32.eps}
\end{center}

# `ignore` Fragment

* To indicate irrelevant messages
* Messages may occur at runtime but have no further significance
* Exactly one operand
* Irrelevant messages in curly brackets after the keyword `ignore`

\begin{center}
\includegraphics[width=.3\textwidth]{images/SequenceDiagrams/SequenceDiagram33.eps}
\end{center}

# `consider` Fragment

* To specify those messages that are of particular importance for the interaction under consideration
* Exactly one operand, dual to ignore fragment
* Considered messages in curly brackets after the keyword `consider`

\begin{center}
\includegraphics[width=.3\textwidth]{images/SequenceDiagrams/SequenceDiagram34.eps}
\end{center}

# `ignore` vs. `consider`

\begin{center}
\includegraphics[width=.85\textwidth]{images/SequenceDiagrams/SequenceDiagram35.eps}
\end{center}

# `assert` Fragment

* To identify certain modeled traces as mandatory
* Deviations that occur in reality but that are not included in the diagram are not permitted
* Exactly one operand

\begin{center}
\includegraphics[width=.33\textwidth]{images/SequenceDiagrams/SequenceDiagram36.eps}
\end{center}

# `neg` Fragment

* To model invalid interactions
* Describing situations that must not occur
* Exactly one operand
* Purpose
  - Explicitly highlighting frequently occurring errors
  - Depicting relevant, incorrect sequences

\begin{center}
\includegraphics[width=.33\textwidth]{images/SequenceDiagrams/SequenceDiagram37.eps}
\end{center}

# Interaction Reference

* Integrates one sequence diagram in another sequence diagram

\begin{center}
\includegraphics[width=.85\textwidth]{images/SequenceDiagrams/SequenceDiagram38.eps}
\end{center}

# Gate

* Allows you to send and receive messages beyond the boundaries of the interaction fragment

\begin{center}
\includegraphics[width=.9\textwidth]{images/SequenceDiagrams/SequenceDiagram39.eps}
\end{center}

# Continuation Marker

* Modularizes the operands of an `alt` fragment
* Breaks down complex interactions into parts and connect them to one another with markers
* Start marker points to target marker
* No return to the start marker (in contrast to an interaction reference)

\begin{center}
\includegraphics[width=.75\textwidth]{images/SequenceDiagrams/SequenceDiagram40.eps}
\end{center}

# Local Attributes and Parameters

* Every sequence diagram is enclosed by a rectangular frame with a small pentagon in the upper left corner
* Keyword `sd`, name of the sequence diagram, parameters (optional)
* Example:
  ```java
     void func (int par1, int par2) {
         int x = 0;
         String y = "Test";
         ...
     }
  ```

\begin{center}
\includegraphics[width=.75\textwidth]{images/SequenceDiagrams/SequenceDiagram41.eps}
\end{center}

# Time Constraints

::: columns
:::: column
* Types
  - Point in time for event occurrence
    * Relative: e.g., `after(5sec)`
    * Absolute: e.g., `at(12.00)`
  - Time period between two events
    * `{lower..upper}`
    * E.g., `{12.00..13.00}`
* Predefined actions
  - `now`: current time
    * Can be assigned to an attribute and then used in a time constraint
  - Duration: calculation of the duration of a message transmission
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/SequenceDiagrams/SequenceDiagram42.eps}
\end{center}
::::
:::

# State Invariant

* Asserts that a certain condition must be fulfilled at a certain time
* Always assigned to a specific lifeline
* Evaluation before the subsequent event occurs
* If the state invariant is not true, either the model or the implementation is incorrect
* Three alternative notations:

\begin{center}
\includegraphics[width=.5\textwidth]{images/SequenceDiagrams/SequenceDiagram43.eps}
\end{center}

# Four Types of Interaction Diagrams

* Based on the same concepts
* Generally equivalent for simple interactions, but different focus

::: columns
:::: column
* Sequence Diagram
  - Vertical axis: chronological order
  - Horizontal axis: interaction partners
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/SequenceDiagrams/SequenceDiagram44.eps}
\end{center}
::::
:::

# Four Types of Interaction Diagrams

* Communication Diagram
  - Models the relationships between communication partners
  - Focus: Who communicates with whom
  - Time is not a separate dimension
  - Message order via decimal classification

\begin{center}
\includegraphics[width=.5\textwidth]{images/SequenceDiagrams/SequenceDiagram45.eps}
\end{center}

# Four Types of Interaction Diagrams

* Timing Diagram
  - Shows state changes of the interaction partners that result from the occurrence of events
  - Vertical axis: interaction partners
  - Horizontal axis: chronological order

\begin{center}
\includegraphics[width=.5\textwidth]{images/SequenceDiagrams/SequenceDiagram46.eps}
\end{center}

# Four Types of Interaction Diagrams

* Interaction Overview Diagram
  - Visualizes order of different interactions
  - Allows to place various interaction diagram sin a logical order
  - Basic notation concepts of activity diagram

\begin{center}
\includegraphics[width=.8\textwidth]{images/SequenceDiagrams/SequenceDiagram47.eps}
\end{center}

# Sequence Diagram Exercise
Use the following class diagram and method definitions to create the sequence diagram for moving a song from the song pool to the play list.

::: columns

:::: column
\centering
\includegraphics[width=\textwidth]{images/SequenceDiagrams/examples/mixed_tape_cd.png}
::::
:::: column
\tiny
**In the MixTapeModel class:**
```java
/** Move a song from the pool to the playlist */
public boolean addToMix(int position)
```

**In the PlayList class:**
```java
/** Determine if the tape has room for a specific song. */
public boolean hasRoom(Song newSong)

/** Accessor to the available time remaining on the tape,
that is, unused space. */
public TimeDuration getRemainingTime()

/** Adds up the total time taken by the current songs in
this play list. */
public TimeDuration getTotalTime()
```
::::

:::

# Sequence Diagram Exercise
\centering
\includegraphics[width=.5\textwidth]{images/SequenceDiagrams/examples/sd_solution.eps}

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
