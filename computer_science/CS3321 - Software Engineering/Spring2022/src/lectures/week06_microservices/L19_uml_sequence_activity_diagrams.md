---
author:
- Dr. Isaac Griffith
title: UML Sequence and Activity Diagrams
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

* UML Sequence Diagrams
* UML Activity Diagrams

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

#

\Huge Activity Diagrams

# Introduction

* Focus of activity diagram: **procedural processing aspects**
* Flow-oriented language concepts
* Based on
  - languages for defining business processes
  - established concepts for describing concurrent communicating processes (token concept as found in petri nets)
* Concepts and notation variants cover **broad area of applications**
  - Modeling of object-oriented and non-object-oriented systems

# Activity

* Specification of user-defined behavior at different levels of granularity
* Examples:
  - Definition of the behavior of an operation in the form of individual instructions
  - Modeling the course of actions of a use case
  - Modeling the functions of a business process

::: columns
:::: column
* An activity is a directed graph
  - Nodes: actions and activities
  - Edges: for control and object flow
* Control flow and object flow define the execution
* Optional:
  - Parameter
  - Pre- and postconditions

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad01.eps}

::::
:::

# Action

* **Basic element** to specify user-defined behavior
* **Atomic** but can be aborted
* No specific rules for the description of an action
  - Definition in natural language or in any programming language
* Process input values to produce output values
* Special notation for predefined types of actions, most importantly
  - Event-based actions
  - Call behavior actions

# Edges

* Connect activities and actions to one another
* Express the execution order

::: columns
:::: {.column width=.6}

* Types
  - Control flow edges
    * Define the order between nodes
  - Object flow edges
    * Used to exchange data or objects
    * Express a data/causal dependency between nodes
* Guard (condition)
  - Control and object flow only continue if guards in square brackets evaluate to true.

::::
:::: {.column width=.4}

\centering
\includegraphics[width=\textwidth]{images/ActivityDiagram/ad02.eps}

\vskip1em

\centering
\includegraphics[width=.65\textwidth]{images/ActivityDiagram/ad03.eps}

::::
:::

# Token

* **Virtual coordination mechanism** that describes the execution exactly
  - No physical component of the diagram
  - Mechanism that grants the execution permission to actions

* If an action receives a token, the action can be executed
* When the action has completed, it passes the token to a subsequent action and the execution of this action is triggered

::: columns
:::: {.column width=.75}
* Guards can prevent the passing of a token
  - Tokens are stored in previous node
* Control token and object token
  - **Control token:** "execution permission" for a node
  - **Object token:** transport data + "execution permission"

::::
:::: {.column width=.25}

\centering
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad04.eps}

::::
:::


# Activity start and end

* Initial Node \includegraphics[scale=.5]{images/ActivityDiagram/ad05.eps}
  - Starts the execution of an activity
  - Provides tokens at all outgoing edges
  - Keeps tokens until the successive nodes accept them
  - Multiple initial nodes to model concurrency
* Activity final node \includegraphics[scale=.5]{images/ActivityDiagram/ad06.eps}
  - Ends all flows of an activity
  - First token that reaches the activity final node terminates the entire activity
    * Concurrent subpaths included
  - Other control and object tokens are deleted
    * Exception: object tokens that are already present at the output parameters of the activity

# Flow end

* Flow final node \includegraphics[scale=.5]{images/ActivityDiagram/ad07.eps}
  - Ends one execution path of an activity
  - All other tokens of the activity remain unaffected

# Alternative Paths - Decision Node

* To define alternative branches
* "Switch point" for tokens

::: columns
:::: column
* Outgoing edges have guards
  - Syntax: [Boolean expression]
  - Token takes **one** branch
  - Guards must be mutually exclusive
  - Predefined: [else]
::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad08.eps}

::::
:::

\vskip.5em

::: columns
:::: column

* Decision behavior
  - Specify behavior that is necessary for the evaluation of the guards
  - Execution must not have side effects

::::
:::: column

\centering
\includegraphics[width=.45\textwidth]{images/ActivityDiagram/ad09.eps}

::::
:::

# Alternative Paths - Merge Node

* To bring **alternative** subpaths together
* Passes token to the next node

* Combined decision and merge node

\begin{center}
\includegraphics[width=.25\textwidth]{images/ActivityDiagram/ad10.eps}
\end{center}

* Decision and merge nodes can also be used to model loops:

\centering
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad11.eps}


# Example: Alternative Paths

\vfill
\centering
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad12.eps}

# Concurrent Paths - Parellization

* To split path into concurrent subpaths
* Duplicates token for all outgoing edges

* Example:

\centering
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad13.eps}

# Concurrent Paths - Synchronization

* To merge concurrent subpaths
* Token processing
  - Waits until tokens are present at all incoming edges
  - Merges all control tokens into one token and passes it one
  - Passes on all object tokens

* Combined parallelization and synchronization node:

\centering
\includegraphics{images/ActivityDiagram/ad14.eps}

# Example: Equivalent Control Flow

\vfill
\centering
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad15.eps}

# Example: Create and Send Invitations

* While invitations are printed, already printed invitations are addressed.
* When all invitations are addressed, then the invitations are sent.

\vfill
\centering
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad16.eps}

# Example: Conduct Lecture

\vfill
\centering
\includegraphics[width=.55\textwidth]{images/ActivityDiagram/ad17.eps}

# Example: Token (Control Flow)

\vfill
\begin{center}
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad18.eps}
\end{center}

\scriptsize
... all outgoing edges of all initial nodes are assigned a token...

... if all incoming edges of an action have a token, the action is activated and is ready for execution

... before the execution, the action consumes one token from every incoming edge; after the execution, the action passes one token to every outgoing edge

... a decision node passes the token to one outgoing edge (depending on the result of the evaluation of the guard)

... a merge node individually passes each token it gets to its outgoing edge

# Example: Token (Control Flow)

\vfill
\begin{center}
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad18.eps}
\end{center}

\scriptsize
... a parallelization node duplicates an incoming token for all outgoing edges

... a synchronization node waits until all incoming edges have a token, merges them to a single token and passes it to its outgoing edge

... the first token that reaches the activity final node terminates the entire activity

# Object Node

* Contains object tokens
* Represents the exchange of data/objects
* Is the source and target of an object flow edge
* Optional information: type, state

\begin{center}
\includegraphics[width=.5\textwidth]{images/ActivityDiagram/ad19.eps}
\end{center}

# Object Node

* Notation variant: object node as parameter
  - For activities

  \begin{center}
  \includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad20.eps}
  \end{center}

  - For actions

  \begin{center}
  \includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad21.eps}
  \end{center}

# Example: Object Node

\vfill
\begin{center}
\includegraphics[width=.75\textwidth]{images/ActivityDiagram/ad22.eps}
\end{center}

# Central Buffer

* For saving and passing on object tokens
* Transient memory
* Accepts incoming object tokens from object nodes and passes them on to other object nodes
* When an object token is read from the central buffer, it is deleted from the central buffer and cannot be consumed again

\vfill
\begin{center}
\includegraphics[width=.65\textwidth]{images/ActivityDiagram/ad23.eps}
\end{center}

# Data Store

* For saving and passing on object tokens
* Permanent memory
* Saves object tokens permanently, passes copies to other nodes

\vfill
\begin{center}
\includegraphics[width=.8\textwidth]{images/ActivityDiagram/ad24.eps}
\end{center}

# Weight of Edges

* Minimal number of tokens that must be present for an action to be executed
* Default: **`1`**
* All tokens present have to be consumed: **`0`** (also **`all`** or **`*`**)

\vfill
\begin{center}
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad25.eps}
\end{center}

# Connector

* Used if two consecutive actions are far apart in the diagram
* Without connector:

\vfill
\begin{center}
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad26.eps}
\end{center}

* With connector:

\vfill
\begin{center}
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad27.eps}
\end{center}

# Event-Based Actions

* To send signals
  - Send signal action

  \begin{center}
  \includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad28.eps}
  \end{center}

* To accept events
  - Accept event action

  \begin{center}
  \includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad29.eps}
  \end{center}

# Example: Accept Event Action

\vfill
\begin{center}
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad30.eps}
\end{center}

# Call Behavior Action

* The execution of an action can call an activity
* Content of the called activity can be modeled elsewhere
* Advantages:
  - Model becomes clearer
  - Reusability

\begin{center}
\includegraphics[width=.65\textwidth]{images/ActivityDiagram/ad31.eps}
\end{center}

# Partition

\footnotesize
* "Swimlane"
* Graphically or textual
* Allows the grouping of nodes and edges of an activity due to responsibilities
* Responsibilities reflect organizational units or roles
* Makes the diagram more structured
* Does not change the execution semantics
* Example: partitions `Student` and `Institute Employee` (with subpartitions `Professor` and `Secretary`)

\begin{center}
\includegraphics[width=.65\textwidth]{images/ActivityDiagram/ad32.eps}
\end{center}

# Example: Partitions

\vfill
\begin{center}
\includegraphics[width=.65\textwidth]{images/ActivityDiagram/ad33.eps}
\end{center}

# Multidimensional Partitions

::: columns
:::: column

* Graphical notation

\vfill
\begin{center}
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad34.eps}
\end{center}

::::
:::: column

... or alternatively textual notation

\vfill
\begin{center}
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad35.eps}
\end{center}

::::
:::

# Example

* State machine diagram of Student ID:

\begin{center}
\includegraphics[width=.75\textwidth]{images/ActivityDiagram/ad36.eps}
\end{center}

\vskip-1.5em

* Activity diagram -- control flow:

\begin{center}
\includegraphics[width=.75\textwidth]{images/ActivityDiagram/ad37.eps}
\end{center}


# Example

* Control flow (green) and object flow (red) in one activity diagram

\begin{center}
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad38.eps}
\end{center}

# Exception Handling

* Predefined exceptions
* Defining how the system has to react in a specific error situation
* The exception handler replaces the action where the error occurred

::: columns
:::: column

\begin{center}
\includegraphics[width=.85\textwidth]{images/ActivityDiagram/ad39.eps}
\end{center}

::::
:::: column

* If the error `e` occurs...
  - All tokens in `Action A` are deleted
  - The exception handler is activated
  - The exception handler is executed instead of `Action A`
  - Execution then continues regularly

::::
:::

# Example: Exception Handler

\vfill
\begin{center}
\includegraphics[width=.7\textwidth]{images/ActivityDiagram/ad40.eps}
\end{center}

# Interruptible Activity Region

* Defining a group of actions whose execution is to be terminated immediately if a specific event occurs. In that case, some other behavior is executed

\begin{center}
\includegraphics[width=.5\textwidth]{images/ActivityDiagram/ad41.eps}
\end{center}

* If `E` occurs while `B` or `C` are executed
  - Exception handling is activated
  - All control tokens within the dashed rectangle (= within `B` and `C`) are deleted
  - `D` is activated and executed

* No “jumping back” to the regular execution!

# Example: Interruptible Activity Region

\vfill
\begin{center}
\includegraphics[width=.65\textwidth]{images/ActivityDiagram/ad42.eps}
\end{center}
