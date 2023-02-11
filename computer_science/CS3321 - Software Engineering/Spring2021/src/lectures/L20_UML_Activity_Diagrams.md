---
author:
- Isaac Griffith
title: UML Activity Diagrams
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

* UML Activity Diagrams


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

# Activity Diagram Exercise
The purchasing department handles purchase requests from other departments in the company.  People in the company who initiate the original purchase request are the "customers" of the purchasing department.  A case worker within the purchasing department receives that request and monitors it until it is ordered and received. Case workers process the requests for purchasing products under $1,500, write a purchase order, and then send it to the approved vendor.  Purchase requests over $1,500 must first be sent out for a bid from the vendor that supplies the product.  When the bids return, the case worker selects one bid. Then, the case worker writes a purchase order and sends it to the approved vendor.

# Activity Diagram Exercise
\centering
\includegraphics[width=.5\textwidth]{images/ActivityDiagram/examples/ex1_solution.eps}


#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
