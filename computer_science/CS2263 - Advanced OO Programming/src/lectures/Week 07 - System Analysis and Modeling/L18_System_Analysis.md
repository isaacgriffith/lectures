---
author:
- Dr. Isaac Griffith
title: System Analysis
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

* \small Understand and describe the activities conducted in the analysis phase
* \small Understand and describe the difference between Functional and Non-Functional requirements
* \small Understand and be able to model the requirements of a system as a set of Use Cases
* \small Understand and be able to describe the concept of Business Rules

::::
:::: {.column width=.25}
\vfill
\vspace{5.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

# Analysis Phase Overview

::: columns
:::: column
* \small \textcolor{Roarange}{\textbf{Typical CS Curriculum Projects}}
  - \footnotesize Well written easy to follow program requirements
  - \footnotesize Requires limited design
  - \footnotesize Requires coding
  - \footnotesize Tend to be small

::::
:::: column
* \small \textcolor{Roarange}{\textbf{Real Life Projects}}
  - \footnotesize Exceptionally larger in scope and size
  - \footnotesize Complex and ambiguous requirements
  - \footnotesize Large amount of money involved
  - \footnotesize Deadlines are typically much "harder"

::::
:::

* \small Yet in both there are still two parties: \textcolor{Roarange}{\textbf{Users}} and \textcolor{Roarange}{\textbf{Developers}}
* \small To achieve success in large projects we need a process to guide us.
* \small The first phase of this process is the \textcolor{Roarange}{\textbf{Analysis Phase}} and it is made up of the following activities:
  1. \footnotesize Gather the requirements (interviews with users, documentation analysis, etc. )
  2. \footnotesize Precisely document the requirements
  3. \footnotesize Develop a conceptual model of the system

#

\centering
\vfill
\begin{minipage}{.675\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Gathering Requirements
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Requirements

* \small Requirements (broadly speaking) come in two forms:
  - \footnotesize \textcolor{Roarange}{\textbf{Functional Requirements:}} Describe the interaction between the system and its users, and between the system and any other systems, which may interact with the system by supplying or receiving data
  - \footnotesize \textcolor{Roarange}{\textbf{Non-functional Requirements:}} Any requirement that does not fall in to the above category. For example:
    * \scriptsize Usability
    * \scriptsize Response time
    * \scriptsize Accuracy
    * \scriptsize Constraints on system development (hardware, software, budget, time)

# Requirements Analysis

\begin{center}
\LARGE This is the most important step in creating a software system
\end{center}
\vskip.5em

* \small \textcolor{Roarange}{\textbf{Goal:}} to define what the new system should do.

* \small Errors made in this step
  - \footnotesize Compound into all following steps
  - \footnotesize Become more and more difficult \textcolor{Roarange}{\textbf{(and costly)}} to undo as time goes on
  - \footnotesize \textcolor{Roarange}{\textbf{Lead to the creation of the wrong system}}

* \small Errors occur for many reasons
  - \footnotesize Clients are not exactly sure of what they want
  - \footnotesize Clients lack the technical skill to understand what technology can/cannot deliver
  - \footnotesize Clients assume too much and analysts skip over "obvious details"

# Requirements Analysis

* \small Requirements are produced by a team of analysts working with client representatives
  - \footnotesize Interviews
  - \footnotesize Surveys
  - \footnotesize Observations
  - \footnotesize Documentation analysis

* \small They then extract requirements into a specification

\pause
\vfill

\centering
\Large \textbf{But, I will save this discussion for \textcolor{Roarange}{CS 3321}}
\vskip1em

# Case Study

* \small Throughout this lecture and the next, we will be considering the development of a basic Library Information Management system.
* \small This system will have the following basic features:
  * \footnotesize Register new Members
  * \footnotesize Add books to the collection
  * \footnotesize Issue a book to a member (or user)
  * \footnotesize Record the return of a book
  * \footnotesize Remove books from the collection
  * \footnotesize Print out a user's transactions
  * \footnotesize Place/remove a hold on a book
  * \footnotesize Renew books issued to a member
  * \footnotesize Notify member of book's availability

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Requirements Specification
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Use Case Analysis

* \small \textcolor{Roarange}{\textbf{Goal}}: To define and document a system's requirements
  - \footnotesize Uses a case-based approach for describing how a system will be used
  - \footnotesize Each use case presents a narrative describing how a user completes a process

* \small Uses cases have the following components
  - \footnotesize Two or more parties interacting
    * \scriptsize \textcolor{Roarange}{\textbf{Actors}}: the user who interacts with the system
    * \scriptsize \textcolor{Roarange}{\textbf{System}}: the system itself

* \small The process is initiated by thinking through how the system will work with the user
  - \footnotesize We can normally assume that there will some form of interface (i.e., UI, CLI, Web, Mobile, etc)
  - \footnotesize We can then use this to consider what the user will need to do (i.e., processes) and how the system will respond

# Use Cases

\small

For the library system we could assume that some sort of menu will provide a list of choices

::: columns
:::: {.column width=.333}
1. \scriptsize Add a member
2. \scriptsize Add books
3. \scriptsize Issue books
4. \scriptsize Return books
5. \scriptsize Remove books
6. \scriptsize Place a hold on a book
7. \scriptsize Remove a hold on a book

::::
:::: {.column width=.333}

8. \scriptsize Process Holds
9. \scriptsize Renew books
10. \scriptsize Print out a member's transactions
11. \scriptsize Store data on disk
12. \scriptsize Retrieve data from disk
13. \scriptsize Exit

::::
:::: {.column width=.333}

\includegraphics[width=.75\textwidth]{images/analysis/analysis01-inv.eps}

::::
:::

# Use Cases

* \small Two-column Format
  - \footnotesize \textcolor{Roarange}{\textbf{Left-column}}: actions actors perform on the system
  - \footnotesize \textcolor{Roarange}{\textbf{Right-column}}: responses of the system

* \small Aspects of use cases:
  1. \footnotesize Every use case is identified by a name
  2. \footnotesize Should represent a reasonably-sized activity in the organization
     - \scriptsize Not all actions and operations should be identified by a Use Case
  3. \footnotesize The first step specifies a "real-world" action which triggers the exchange described by the use case
     - \scriptsize Does not have any real bearing on the system being developed (mostly for completeness)
  4. \footnotesize \textcolor{Roarange}{\textbf{The use case does not specify how the functionality is to be implemented}}
     - \scriptsize This is what design and implementation are for
  5. \footnotesize The use case does not cover all possible situations, only the most commonly-ocurring, or \textcolor{Roarange}{\textbf{main flow}}, scenario is described
     - \scriptsize Errors and exceptions are not detailed

# Use Case 1

\small \textcolor{Buttons}{\textbf{Register New Member}}

\scriptsize
+--------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Actions performed by the actor}}                  | \textcolor{Roarange}{\textbf{Responses from the system}}                          |
+:===============================================================================+:==================================================================================+
| \textcolor{Roarange}{\textbf{1)}} The customer fills out an application form   |                                                                                   |
| containing the customer's name, address, and                                   |                                                                                   |
| phone number and gives this to the clerk                                       |                                                                                   |
+--------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{2)}} The clerk issues a request to add a new      |                                                                                   |
| member                                                                         |                                                                                   |
+--------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
|                                                                                | \textcolor{Roarange}{\textbf{3)}} The system asks for data about the new          |
|                                                                                | member                                                                            |
+--------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{4)}} The clerk enters the data into the system    |                                                                                   |
+--------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
|                                                                                | \textcolor{Roarange}{\textbf{5)}} Reads in data, and if the member can be         |
|                                                                                | added, generates an identification number                                         |
|                                                                                | (which is not necessarily a number in the literal                                 |
|                                                                                | sense just as social security numbers and phone                                   |
|                                                                                | numbers are not actually numbers) for the                                         |
|                                                                                | member and remembers information about the                                        |
|                                                                                | member. Informs the clerk if the member was                                       |
|                                                                                | added and outputs the member's name,                                              |
|                                                                                | address, phone and id                                                             |
+--------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{6)}} The clerk gives the user his identification  |                                                                                   |
| number                                                                         |                                                                                   |
+--------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+

# Acceptance Tests

* \small As we are writing our use cases, we should be thinking about how we can validate that the requirements encoded in the use case.
* \small To do this we need to create acceptance tests, which are essentially tests based on whether the user will accept that this requirement is met.
* \small These tests use example scenarios similar to a use case and are written using a GIVEN-WHEN-THEN format:
  - \footnotesize \textcolor{Roarange}{\textbf{GIVEN:}} provides the staring condition of the scenario (conditions/data used to configure the test)
  - \footnotesize \textcolor{Roarange}{\textbf{WHEN:}} an event that happens (i.e. the initial event of the use case)
  - \footnotesize \textcolor{Roarange}{\textbf{THEN:}} the expected result as per the defined behavior of the system
* \small Though these three are typically all we will need, we can also add in additional lines to either the GIVEN, WHEN, or THEN using:
  - \footnotesize \textcolor{Roarange}{\textbf{AND}}
  - \footnotesize \textcolor{Roarange}{\textbf{BUT}}

# Acceptance Test Example

\small \textcolor{Buttons}{\textbf{Acceptance Test: Register New Member}}

* \small \textcolor{Roarange}{\textbf{GIVEN:}} A user fill in a form with the provided information

  +--------------------------------------+----------------------------------------------------------------+
  | \textcolor{Roarange}{\textbf{Field}} | \textcolor{Roarange}{\textbf{Value}}                           |
  +:=====================================+:===============================================================+
  | Name                                 | Isaac Griffith                                                 |
  +--------------------------------------+----------------------------------------------------------------+
  | Address                              | 921 S. 8th Ave, Pocatello, ID 83201                            |
  +--------------------------------------+----------------------------------------------------------------+
  | Phone                                | 208-282-4876                                                   |
  +--------------------------------------+----------------------------------------------------------------+

* \small \textcolor{Roarange}{\textbf{AND:}} The user has handed the form to the clerk
* \small \textcolor{Roarange}{\textbf{AND:}} The clerk has requested to add a new user
* \small \textcolor{Roarange}{\textbf{WHEN:}} Clerk enters this information into the system as a new user

* \small \textcolor{Roarange}{\textbf{THEN:}} The clerk provides the user with ID Number 123

# Use Case 2

\small \textcolor{Buttons}{\textbf{Adding New Books}}

\scriptsize
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Actions performed by the actor}}                    | \textcolor{Roarange}{\textbf{Responses from the system}}                          |
+:=================================================================================+:==================================================================================+
| \textcolor{Roarange}{\textbf{1)}} Library receives a shipment of books from      |                                                                                   |
| the publisher                                                                    |                                                                                   |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{2)}} The clerk issues a request to add a new book   |                                                                                   |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
|                                                                                  | \textcolor{Roarange}{\textbf{3)}} The system asks for the identifier, title, and  |
|                                                                                  | author name of the book                                                           |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{4)}} The clerk generates the unique identifier,     |                                                                                   |
| enters the identifier, title, and author name of a                               |                                                                                   |
| book                                                                             |                                                                                   |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
|                                                                                  | \textcolor{Roarange}{\textbf{5)}} The system attempts to enter the information    |
|                                                                                  | in the catalog and echoes to the clerk the title,                                 |
|                                                                                  | author name, and id of the book. It then asks if                                  |
|                                                                                  | the clerk wants to enter information about                                        |
|                                                                                  | another book                                                                      |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{6)}} The clerk answers in the affirmative or in the |                                                                                   |
| negative                                                                         |                                                                                   |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
|                                                                                  | \textcolor{Roarange}{\textbf{7)}} If the answer is in the affirmative, the system |
|                                                                                  | goes to Step 3, Otherwise, it exits.                                              |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+

# Use Case 3

\small \textcolor{Buttons}{\textbf{Book Checkout}}

\tiny
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Actions performed by the actor}}                   | \textcolor{Roarange}{\textbf{Responses from the system}}                        |
+:================================================================================+:================================================================================+
| \textcolor{Roarange}{\textbf{1)}} The member arrives at the check-out counter   |                                                                                 |
| with a set of books and supplies the clerk with                                 |                                                                                 |
| his/her identification number                                                   |                                                                                 |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{2)}} The clerk issues a request to check out books |                                                                                 |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{3)}} The system asks for the user ID               |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{4)}} The clerk inputs the user ID to the system    |                                                                                 |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{5)}} The system asks for the ID of the book        |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{6)}} The clerk inputs the ID of a book that the    |                                                                                 |
| user wants to check out                                                         |                                                                                 |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{7)}} The system records the book as having been    |
|                                                                                 | issued to the member; it also records the                                       |
|                                                                                 | member as having possession of the book. It                                     |
|                                                                                 | generates a due-date. The system displays the                                   |
|                                                                                 | book title and due-date and asks if there are any                               |
|                                                                                 | more books                                                                      |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{8)}} The clerk stamps the due-date on the book     |                                                                                 |
| and replies in the affirmative or negative                                      |                                                                                 |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{9)}} If there are more books, the systems moves to |
|                                                                                 | Step 5; otherwise it exits                                                      |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{10)}} The customer collects the books and leaves   |                                                                                 |
| the counter                                                                     |                                                                                 |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+

\vspace{-1.5em}

* \scriptsize Issues with this use case
  - \tiny How are due dates calculated?
  - \tiny What do we do when things go wrong: (i) Person is not a member or (ii) Clerk entered invalid book ID

# Business Rules

* \small \textcolor{Roarange}{\textbf{Business Rules:}} Often we need to have defined rules for describing how our business operates
* \small Including these in use cases tends to make them messy and overly complicated.
* \small Instead we should create a separate table, and reference these as needed.

\footnotesize
+--------------------------------------------+---------------------------------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Rule Number}} | \textcolor{Roarange}{\textbf{Rule}}                                                                     |
+:===========================================+:========================================================================================================+
| Rule 1                                     | Due-date for a book is one month from the date of issue                                                 |
+--------------------------------------------+---------------------------------------------------------------------------------------------------------+
| Rule 2                                     | All books are issuable                                                                                  |
+--------------------------------------------+---------------------------------------------------------------------------------------------------------+
| Rule 3                                     | A book is removable if it is not checked out and if it has no holds                                     |
+--------------------------------------------+---------------------------------------------------------------------------------------------------------+
| Rule 4                                     | A book is renewable if it has no holds on it                                                            |
+--------------------------------------------+---------------------------------------------------------------------------------------------------------+
| Rule 5                                     | When a book with a hold is returned, the appropriate member will be notified                            |
+--------------------------------------------+---------------------------------------------------------------------------------------------------------+
| Rule 6                                     | Holds can be place only on books that are currently checked out                                         |
+--------------------------------------------+---------------------------------------------------------------------------------------------------------+

# Use Case 3 - Revised

\small \textcolor{Buttons}{\textbf{Book Checkout - Revised}}

\tiny
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Actions performed by the actor}}                   | \textcolor{Roarange}{\textbf{Responses from the system}}                        |
+:================================================================================+:================================================================================+
| \textcolor{Roarange}{\textbf{1)}} The member arrives at the check-out counter   |                                                                                 |
| with a set of books and supplies the clerk with                                 |                                                                                 |
| his/her identification number                                                   |                                                                                 |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{2)}} The clerk issues a request to check out books |                                                                                 |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{3)}} The system asks for the user ID               |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{4)}} The clerk inputs the user ID to the system    |                                                                                 |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{5) If the ID is valid, the system asks for the ID}}|
|                                                                                 | \textcolor{Roarange}{\textbf{of the book; otherwise it prints an appropriate}}  |
|                                                                                 | \textcolor{Roarange}{\textbf{message and exits the use case}}                   |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{6)}} The clerk inputs the ID of a book that the    |                                                                                 |
| user wants to check out                                                         |                                                                                 |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{7)}} The system records the book as having been    |
|                                                                                 | issued to the member; it also records the                                       |
|                                                                                 | member as having possession of the book. It                                     |
|                                                                                 | generates a due-date \textcolor{Roarange}{\textbf{as in Rule 1}}. It then       |
|                                                                                 | displays the book's title and due-date. \textcolor{Roarange}{\textbf{If the}}   |
|                                                                                 | \textcolor{Roarange}{\textbf{book is not issuable as per Rule 2, the system}}   |
|                                                                                 | \textcolor{Roarange}{\textbf{displays a suitable error message.}} The system    |
|                                                                                 | asks if there are more books                                                    |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{8)}} The clerk stamps the due-date, }}prints out}} |                                                                                 |
| \textcolor{Roarange}{\textbf{the transaction (if needed) and replies}}          |                                                                                 |
| \textcolor{Roarange}{\textbf{positively or negatively}}                         |                                                                                 |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{9) If there are more books for checking out, the}} |
|                                                                                 | \textcolor{Roarange}{\textbf{system goes back to Step 5; otherwise it exits}}   |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{10) The clerk stamps the due date and gives the}}  |                                                                                 |
| \textcolor{Roarange}{\textbf{user the books checked out. The customer}}         |                                                                                 |
| \textcolor{Roarange}{\textbf{leaves the counter}}                               |                                                                                 |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------------+

# Use Case 4

\small \textcolor{Buttons}{\textbf{Return Book}}

\scriptsize
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Actions performed by the actor}}                    | \textcolor{Roarange}{\textbf{Responses from the system}}                          |
+:=================================================================================+:==================================================================================+
| \textcolor{Roarange}{\textbf{1)}} The member arrives at the return counter       |                                                                                   |
| with a set of books and leaves them on the                                       |                                                                                   |
| clerk's desk                                                                     |                                                                                   |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{2)}} The clerk issues a request to return books     |                                                                                   |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
|                                                                                  | \textcolor{Roarange}{\textbf{3)}} The system asks for the identifier of the book  |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{4)}} The clerk enters the book identifier           |                                                                                   |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
|                                                                                  | \textcolor{Roarange}{\textbf{5)}} If the identifier is valid, the system marks    |
|                                                                                  | that the book has been returned and informs the                                   |
|                                                                                  | clerk if there is a hold placed on the book;                                      |
|                                                                                  | otherwise it notifies the clerk that the identifier                               |
|                                                                                  | is not valid. It then asks if the clerk wants to                                  |
|                                                                                  | process the return of another book                                                |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{6)}} The clerk answers in the affirmative or in the |                                                                                   |
| negative and sets the book aside in case there is                                |                                                                                   |
| a hold on the book (see Rule 5)                                                  |                                                                                   |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
|                                                                                  | \textcolor{Roarange}{\textbf{7)}} If the answer is in the affirmative, the system |
|                                                                                  | goes to Step 3. Otherwise, it exits                                               |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+

# Use Case 5

\small \textcolor{Buttons}{\textbf{Removing Books}}

\scriptsize
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Actions performed by the actor}}                    | \textcolor{Roarange}{\textbf{Responses from the system}}                          |
+:=================================================================================+:==================================================================================+
| \textcolor{Roarange}{\textbf{1)}} Librarian identifies the books to be deleted   |                                                                                   |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{2)}} The clerk issues a request to delete books     |                                                                                   |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
|                                                                                  | \textcolor{Roarange}{\textbf{3)}} The system asks for the identifier of the book  |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{4)}} The clerk enters the ID for the book           |                                                                                   |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
|                                                                                  | \textcolor{Roarange}{\textbf{5)}} The system checks if the book can be            |
|                                                                                  | removed using Rule 3. If the book can be                                          |
|                                                                                  | removed, the system marks the book as no                                          |
|                                                                                  | longer in the library's catalog. The system                                       |
|                                                                                  | informs the clerk about the success of the                                        |
|                                                                                  | deletion operation. It then asks if the clerk                                     |
|                                                                                  | wants to delete another book                                                      |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{6)}} The clerk answers in the affirmative or in the |                                                                                   |
| negative                                                                         |                                                                                   |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+
|                                                                                  | \textcolor{Roarange}{\textbf{7)}} If the answer is in the affirmative, the system |
|                                                                                  | goes to Step 3. Otherwise, it exits                                               |
+----------------------------------------------------------------------------------+-----------------------------------------------------------------------------------+

# Use Case 6

\small \textcolor{Buttons}{\textbf{Member Transactions}}

\scriptsize
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Actions performed by the actor}}                   | \textcolor{Roarange}{\textbf{Responses from the system}}                  |
+:================================================================================+:==========================================================================+
| \textcolor{Roarange}{\textbf{1)}} The clerk issues a request to get member      |                                                                           |
| transactions                                                                    |                                                                           |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{2)}} The system asks for the user ID of the  |
|                                                                                 | member and the date for which the transactions                            |
|                                                                                 | are needed                                                                |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{3)}} The clerk enters the identity of the user and |                                                                           |
| the date                                                                        |                                                                           |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{4)}} If the ID is valid, the system outputs  |
|                                                                                 | information about all transactions completed                              |
|                                                                                 | by the user on the given date. For each                                   |
|                                                                                 | transaction, it shows the type of transaction                             |
|                                                                                 | (book borrowed, book returned or hold placed)                             |
|                                                                                 | and the title of the book                                                 |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{5)}} Clerk prints out the transactions and hands   |                                                                           |
| them to the user                                                                |                                                                           |
+---------------------------------------------------------------------------------+---------------------------------------------------------------------------+

# Use Case 7

\small \textcolor{Buttons}{\textbf{Place a Hold}}

\scriptsize
+----------------------------------------------------------------------------------+--------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Actions performed by the actor}}                    | \textcolor{Roarange}{\textbf{Responses from the system}}                       |
+:=================================================================================+:===============================================================================+
| \textcolor{Roarange}{\textbf{1)}} The clerk issues a request to place a hold     |                                                                                |
+----------------------------------------------------------------------------------+--------------------------------------------------------------------------------+
|                                                                                  | \textcolor{Roarange}{\textbf{2)}} The system asks for the book's ID, the ID of |
|                                                                                  | the member, and the duration of the hold                                       |
+----------------------------------------------------------------------------------+--------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{3)}} The clerk enters the identity of the user, the |                                                                                |
| identity of the book and the duration                                            |                                                                                |
+----------------------------------------------------------------------------------+--------------------------------------------------------------------------------+
|                                                                                  | \textcolor{Roarange}{\textbf{4)}} The system checks that the user and book     |
|                                                                                  | identifiers are valid and that Rule 6 is satisfied.                            |
|                                                                                  | If yes, it records that the user has a hold on the                             |
|                                                                                  | book and displays that; otherwise, it outputs an                               |
|                                                                                  | appropriate error message                                                      |
+----------------------------------------------------------------------------------+--------------------------------------------------------------------------------+

# Use Case 8

\small \textcolor{Buttons}{\textbf{Remove a Hold}}

\scriptsize
+---------------------------------------------------------------------------------+--------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Actions performed by the actor}}                   | \textcolor{Roarange}{\textbf{Responses from the system}}                       |
+:================================================================================+:===============================================================================+
| \textcolor{Roarange}{\textbf{1)}} The clerk issues a request to remove a hold   |                                                                                |
+---------------------------------------------------------------------------------+--------------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{2)}} The system asks for the book's ID and the ID |
|                                                                                 | of the member                                                                  |
+---------------------------------------------------------------------------------+--------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{3)}} The clerk enters the identity of the user and |                                                                                |
| the identity of the book                                                        |                                                                                |
+---------------------------------------------------------------------------------+--------------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{4)}} The system removes the hold that the user    |
|                                                                                 | has on the book (if any such hold exists), prints                              |
|                                                                                 | a confirmation and exits                                                       |
+---------------------------------------------------------------------------------+--------------------------------------------------------------------------------+

# Use Case 9

\small \textcolor{Buttons}{\textbf{Process Holds}}

\scriptsize
+---------------------------------------------------------------------------------+-----------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Actions performed by the actor}}                   | \textcolor{Roarange}{\textbf{Responses from the system}}                    |
+:================================================================================+:============================================================================+
| \textcolor{Roarange}{\textbf{1)}} The clerk issues a request to process holds   |                                                                             |
| (so that Rule 5 can be satisfied)                                               |                                                                             |
+---------------------------------------------------------------------------------+-----------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{2)}} The system asks for the book's ID         |
+---------------------------------------------------------------------------------+-----------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{3)}} The clerk enters the ID of the book           |                                                                             |
+---------------------------------------------------------------------------------+-----------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{4)}} The system returns the name and phone     |
|                                                                                 | number of the first member with an unexpired                                |
|                                                                                 | hold on the book. If all holds have expired, the                            |
|                                                                                 | system responds that there is no hold. The                                  |
|                                                                                 | system then asks if there are any more books to                             |
|                                                                                 | be processed                                                                |
+---------------------------------------------------------------------------------+-----------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{5)}} If there is no hold, the book is then shelved |                                                                             |
| back to its designated location in the library.                                 |                                                                             |
| Otherwise, the clerk prints out the information,                                |                                                                             |
| places it in the book and replies in the                                        |                                                                             |
| affirmative or negative                                                         |                                                                             |
+---------------------------------------------------------------------------------+-----------------------------------------------------------------------------+
|                                                                                 | \textcolor{Roarange}{\textbf{6)}} If the answer is yes, the system goes to  |
|                                                                                 | Step 2; otherwise, it exits                                                 |
+---------------------------------------------------------------------------------+-----------------------------------------------------------------------------+

# Use Case 10

\small \textcolor{Buttons}{\textbf{Renew Books}}

\scriptsize
+------------------------------------------------------------------------------+-------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Actions performed by the actor}}                | \textcolor{Roarange}{\textbf{Responses from the system}}                      |
+:=============================================================================+:==============================================================================+
| \textcolor{Roarange}{\textbf{1)}} Member makes a request to renew several of |                                                                               |
| the books that he/she has currently checked out                              |                                                                               |
+------------------------------------------------------------------------------+-------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{2)}} Clerk issues a request to renew books      |                                                                               |
+------------------------------------------------------------------------------+-------------------------------------------------------------------------------+
|                                                                              | \textcolor{Roarange}{\textbf{3)}} System asks for the member's ID             |
+------------------------------------------------------------------------------+-------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{4)}} The clerk enters the ID into the system    |                                                                               |
+------------------------------------------------------------------------------+-------------------------------------------------------------------------------+
|                                                                              | \textcolor{Roarange}{\textbf{5)}} System checks the member's record to find   |
|                                                                              | out which books the member has checked out.                                   |
|                                                                              | If there are none, the system prints an                                       |
|                                                                              | appropriate message and exits; otherwise, it                                  |
|                                                                              | moves to Step 6                                                               |
+------------------------------------------------------------------------------+-------------------------------------------------------------------------------+
|                                                                              | \textcolor{Roarange}{\textbf{6)}} The system displays the title of the next   |
|                                                                              | book checked out to the member and asks whether                               |
|                                                                              | the book should be renewed.                                                   |
+------------------------------------------------------------------------------+-------------------------------------------------------------------------------+
| \textcolor{Roarange}{\textbf{7)}} The clerk replies yes or no                |                                                                               |
+------------------------------------------------------------------------------+-------------------------------------------------------------------------------+
|                                                                              | \textcolor{Roarange}{\textbf{8)}} The system attempts to renew the book using |
|                                                                              | Rule 4 and reports the result. If the system has                              |
|                                                                              | displayed all checked-out books, it reports that                              |
|                                                                              | exits; otherwise the system goes to Step 6                                    |
+------------------------------------------------------------------------------+-------------------------------------------------------------------------------+

# Business Rules & Use Cases

* \small Business rules are the details by which a business implements strategy.
* \small These rules are gathered and documented by \textcolor{Roarange}{\textbf{Business Analysts}}
* \small There are four categories:

# Business Rules & Use Cases

* \small There are four categories:
  - \footnotesize \textcolor{Roarange}{\textbf{Definitional Rules:}} Explain what is meant when a particular word is used in the context of business operations.
    * \scriptsize Ex: In our system "Book" means any book owned by the library.
  - \footnotesize \textcolor{Roarange}{\textbf{Factual Rules:}} Explain things about the business's operations, and how terms connect to each other.
    * \scriptsize Ex: In our system: `Books are issued to Members` and `Members can place holds on Books`
  - \footnotesize \textcolor{Roarange}{\textbf{Constraints:}} Specific conditions that govern the manner in which terms can be connected.
    * \scriptsize Ex: A bank may have the constraint: `balance in an account cannot be less than zero`
  - \footnotesize \textcolor{Roarange}{\textbf{Derivations}} Knowledge that can be derived from the facts and constraints.
    * \scriptsize Ex: A bank may have the constraint: `balance in an account cannot be less than zero` from which we can derive that no withdrawal operation will succeed if it is for greater than the current account balance.

* \small Typically when working with use cases we are only concerned with `Constraints` and `Derivations`

# Use Case Guidelines

1. \small Uses cases must provide value to an actor or the business
   - \footnotesize Once the scenario has played out, the actor has accomplished a task
2. \small Use cases should be \textcolor{Roarange}{\textbf{functionally cohesive}}
   - \footnotesize They encapsulate a single service of the system
3. \small Use cases should be \textcolor{Roarange}{\textbf{temporally cohesive}}
   - \footnotesize There should not be significant delays due to the system
4. \small If there are multiple actors, they should each be involved in at least one use case
5. \small The model is the \textcolor{Roarange}{\textbf{set of use cases}}, there are no relationships between use cases

# Use Case Guidelines

6. \small Exceptional exit conditions are not handled by use cases
   - \footnotesize Assume a reasonable outcome will occur.
7. \small Use cases are from the point of view of the actor, written in active voice
8. \small A use case describe a scenario
   - \footnotesize Tells us the visible outcome and does not detail other requirements
9. \small Use cases change throughout system analysis

# For Next Time

::: columns
:::: column
* Review Chapter 6
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
