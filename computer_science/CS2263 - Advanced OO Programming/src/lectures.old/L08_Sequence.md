---
author:
- Isaac Griffith
title: UML Class Diagrams and Architecture
institute: |
  CS 2263

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

After today's lecture you will be able to:

* Overview of sequence diagrams
* Syntax and semantics
* Examples

# Inspiration

\vfill
\centering

> "The belief that complex systems require armies of designers and programmers is wrong. A system that is not understood in its entirety, or at least to a significant degree of detail by a single individual, should probably not be built." - Niklaus Wirth

#

\vfill
\centering
\Huge An Overview of Sequence Diagrams

# What is a Sequence Diagram?

* **Sequence Diagram**: an "interaction diagram" that models a single scenario executing in a system
  - 2nd most used UML diagram (behind class diagram)
  - Shows what messages are sent and when
\pause
* Relating UML diagrams to other design artifacts:
  - CRC cards -> Class Diagrams
  - Use Cases -> Sequence Diagrams

# Key Parts of a Sequence Diagram

::: columns
:::: column

::::
:::: column
\centering
\includegraphics[]{}
::::
:::

# Key Parts of a Sequence Diagram

::: columns
:::: column
* **Participant**: an object or an entity; the sequence diagram actor
  - sequence diagram starts with an unattached "found message" arrow
\pause
* **Message**: communication between objects
\pause
* Axes in a sequence diagram:
  - **horizontal:** which participant is acting
  - **vertical:** time ($\downarrow$ forward in time)

::::
:::: column
\centering
\includegraphics[]{}
::::
:::

# Key Parts of a Sequence Diagram

::: columns
:::: column
* **Participant**: an object or an entity; the sequence diagram actor
  - sequence diagram starts with an unattached "found message" arrow
* **Message**: communication between objects
* Axes in a sequence diagram:
  - **horizontal:** which participant is acting
  - **vertical:** time ($\downarrow$ forward in time)

::::
:::: column
\centering
\includegraphics[]{}
::::
:::

# Sequence Diagram from a Use Case

::: columns
:::: column
1. The user presses the "check email" button.
2. The client first sends all unsent email to the server.
3. After receiving an acknowledgment, the client asks the server if there is any new email.
4. If so, it downloads the new mail.
5. Next, it deletes old thrashed email from the server.
::::
:::: column
\centering
\includegraphics[]{}
::::
:::

#

\vfill
\centering
\Huge Sequence Diagrams: Syntax and Semantics

# Representing Objects

\includegraphcis[]{}

::: columns
:::: column
* An **object**: a **box** with an \underline{underlined} label that specifies the object type, and optionally the objec tanme.
  - Write the object's name if it clarifies the diagram.
::::
:::: column
\includegraphics[]{}
::::
:::

# Representing Objects

\includegraphcis[]{}

::: columns
:::: column
* An **object**: a **box** with an \underline{underlined} label that specifies the object type, and optionally the object name.
  - Write the object's name if it clarifies the diagram.
* An object's "life line" is represented by a dashed vertical line.
  - Represents the life span of the object during the scenario being modeled.
::::
:::: column
\includegraphics[]{}
::::
:::

# Representing messages between objects

::: columns
:::: column
* A **message** (method call): **horizontal arrow** to the receiving object.
  - Write message name and arguments above the arrow.
::::
:::: column
\includegraphics[]{}
::::
:::

# Different types of messages

::: columns
:::: column
* Type of arrow indicates types of messages:
  - Synchronous message: solid arrow with a solid head.
  - Asynchronous message: solid arrow with a stick head.
  - Return message: dashed arrow with stick head.
::::
:::: column
\centering
\includegraphics[]{}
::::
:::

# Indicating method execution

::: columns
:::: column
* **Activation**: thick box over object's life line, drawn when an object's method is on the stack
  - Either that object is running its code, or it is on the stack waiting for another object's method to finish
* Nest activations to indicate an object calling itself
::::
:::: column
\centering
\includegraphics[]{}
::::
:::

# Lifetime of Objects

::: columns
:::: column
* Object **creating**: an arrow with **new** written above it
  - An object created after the start of the scenario appears lower than the others
* Object **deletion**: **X** at the bottom of object's lifeline
  - Java doesn't explicitly delete objects; they fall out of scope and are garbage collected
::::
:::: column
\centering
\includegraphics[]{}
::::
:::

# Alternatives, options, and loops

* **Frame**: a box around part of a sequence diagram
  - if -> (opt) [condition]
  - if/else -> (alt) [condition], separated by horizontal dashed line
  - loop -> (loop) [condition or items to loop over]

\centering
\includegraphics[]{}

# Example sequence diagram

\centering
\includegraphics[]{}

# Why use Sequence Diagrams?

* A good sequence diagram is still above the level of the real code (not all code is drawn on diagram)
* Sequence diagrams are language-agnostic (can be implemented in many different languages)
* Non-coders can read and write sequence diagrams
* Easier to do sequence diagrams as a team
* Can see many objects/classes at a time on same page (visual bandwidth)

#

\vfill
\centering
\Huge Sequence Diagrams: Examples

# Online bookstore exercise

##

1. The customer begins the interaction by searching for a book by title.
2. The system will return all books with that title.
3. The customer can look at the book description.
4. The customer can place a book in the shopping cart.
5. The customer can repeat the interaction as many times as desired.
6. The customer can purchase the items in the cart by checking out.

# Summary

* A sequence diagram models a single scenario executing in the system.
* Key components include participants and messages.
* Sequence diagrams provide a high-level of control flow patterns through the system.

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
