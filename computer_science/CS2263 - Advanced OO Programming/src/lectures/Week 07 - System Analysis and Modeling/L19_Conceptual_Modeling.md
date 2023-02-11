---
author:
- Isaac Griffith
title: Conceptual Modeling
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

* Why we perform the conceptual modeling step
* How to extract conceptual classes and relationships from Use Cases
* Basic ideas of Domain Analysis

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
\begin{minipage}{.56\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Conceptual Modeling
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Why Conceptual Models

1. \small \textcolor{Roarange}{\textbf{Design Facilitation}}
   - \footnotesize Use Cases determine the functionality
   - \footnotesize Design determines how to implement this functionality
   - \footnotesize Thus we need to setup the design phase as best as possible

\vskip.25em

2. \small \textcolor{Roarange}{\textbf{Added Knowledge}}
   - \footnotesize Use Cases do not completely specify the system
   - \footnotesize Conceptual models can supply what is missing

\vskip.25em

3. \small \textcolor{Roarange}{\textbf{Error Reduction}}
   - \footnotesize This step forces analysts to review the system
   - \footnotesize Additionally, we can show the results to the client for verification

\vskip.25em

4. \small \textcolor{Roarange}{\textbf{Useful Documentation}}
   - \footnotesize Conceptual models can help new personnel get up to speed quickly

# Extracting Classes

* \small The simplest approach for identifying classes is \textcolor{Roarange}{\textbf{Noun-Verb Analysis}} (also called \textcolor{Roarange}{\textbf{Nomative Analysis}}).
  - \footnotesize Verbs are used to identify operations (so for now we will ignore this).
  - \footnotesize Nouns (and adjectives) are useful in identifying:
    - \scriptsize Potential classes
    - \scriptsize Attributes of classes

\vskip.5em

* \small To use this approach:
  1. \footnotesize work through the text of our use cases and highlight the nouns we find.
  2. \footnotesize extract these nouns and analyze for synonyms, duplicates, etc.
  3. \footnotesize identify what they represent (attributes, classes)

# Noun Analysis Example

1. The customer fills out an application form containing the customer's name, address, and phone number and gives this to the clerk
2. The clerk issues a request to add a new member
3. The system asks for data about the new member
4. The clerk enters the data into the system
5. Reads in data and if the member can be added, generates an identification number for the member and remembers information about the member Informs the clerk if the member was added and outputs the member's name address phone and id
6. The clerk gives the user his identification number

# Noun Analysis Example

1. The \textcolor{Roarange}{\textbf{customer}} fills out an \textcolor{Roarange}{\textbf{application form}} containing the \textcolor{Roarange}{\textbf{customer's name}}, \textcolor{Roarange}{\textbf{address}}, and \textcolor{Roarange}{\textbf{phone number}} and gives this to the \textcolor{Roarange}{\textbf{clerk}}.
2. The \textcolor{Roarange}{\textbf{clerk}} issues a \textcolor{Roarange}{\textbf{request}} to add a new \textcolor{Roarange}{\textbf{member}}.
3. \textcolor{Roarange}{\textbf{The system}} asks for \textcolor{Roarange}{\textbf{data}} about the new \textcolor{Roarange}{\textbf{member}}
4. The \textcolor{Roarange}{\textbf{clerk}} enters the \textcolor{Roarange}{\textbf{data}} into the \textcolor{Roarange}{\textbf{system}}.
5. Reads in \textcolor{Roarange}{\textbf{data}}, and if the \textcolor{Roarange}{\textbf{member}} can be added, generates an \textcolor{Roarange}{\textbf{identification number}} for the \textcolor{Roarange}{\textbf{member}} and remembers \textcolor{Roarange}{\textbf{information}} about the \textcolor{Roarange}{\textbf{member}}. Informs the clerk if the member was added and outputs the \textcolor{Roarange}{\textbf{member's name}}, \textcolor{Roarange}{\textbf{address}}, \textcolor{Roarange}{\textbf{phone}}, and \textcolor{Roarange}{\textbf{id}}
6. The \textcolor{Roarange}{\textbf{clerk}} gives the \textcolor{Roarange}{\textbf{user}} his \textcolor{Roarange}{\textbf{identification number}}.

# Noun Analysis Example

* \small In this analysis, we found several nouns, but natural language tends to be imprecise thus duplicates and synonyms will be found
* \small The list is then
  - \scriptsize \textcolor{Roarange}{\textbf{customer}} -> synonym for member
  - \scriptsize \textcolor{Roarange}{\textbf{user}} -> synonym for member
  - \scriptsize \textcolor{Roarange}{\textbf{application form}} and \textcolor{Roarange}{\textbf{request}} -> form is external to the system and request is a menu item (so disregarded)
  - \scriptsize \textcolor{Roarange}{\textbf{customer's name, address}}, and \textcolor{Roarange}{\textbf{phone number}} -> attributes of member
  - \scriptsize \textcolor{Roarange}{\textbf{clerk}} -> no software representation
  - \scriptsize \textcolor{Roarange}{\textbf{identification number}} -> attribute of member
  - \scriptsize \textcolor{Roarange}{\textbf{data}} -> data related to member
  - \scriptsize \textcolor{Roarange}{\textbf{information}} -> data related to member
  - \scriptsize \textcolor{Roarange}{\textbf{system}} -> the software, will be called `Library`

# Noun Analysis Example

* The final list is:
  - \textcolor{Roarange}{\textbf{Member}}
    * name
    * address
    * phone number
    * id
  - \textcolor{Roarange}{\textbf{Library}}

# Trimming Down Classes

* From this analysis we have identified three classes key to the system:
  - Library -> the system itself
  - Book
  - Member

\centering
\includegraphics[width=.75\textwidth]{images/analysis/analysis02-inv.eps}

# Identifying Relationships

\vfill
\centering
\includegraphics[width=.65\textwidth]{images/analysis/analysis05-inv.eps}

# Identifying Relationships

\vfill
\centering
\includegraphics[width=.65\textwidth]{images/analysis/analysis07-inv.eps}

# Final Model

\vfill
\centering
\includegraphics[width=.85\textwidth]{images/analysis/analysis08-inv.eps}

# Finding the Right Classes

1. \footnotesize Select a Use Case
2. \footnotesize Analyze the selected use case
   - \scriptsize Extract out identified Nouns, verbs, etc.
   - \scriptsize Identify potential classes (but keep the initial list of nouns and synonyms)
   - \scriptsize Add the potential classes to the class diagram.
   - \scriptsize Then consider potential relationships between classes, adding them as needed.
3. \footnotesize If there are more Use Cases, return to step 1
4. \footnotesize Once you have the completed conceptual diagram, it will need to be reviewed
   - \scriptsize Using your analysis from each use case (that you saved), return to the Use Case and ensure:
     - \tiny there are no additional classes need that you missed
     - \tiny that you did not miss any relationships
   - \scriptsize For each class and relationship within the diagram
     - \tiny ensure that they really need to be there
   - \scriptsize Finally, consider any possible design patterns that may be applicable

# Conceptual Class Guidelines

1. \small In general, do not build classes around functions
   - \footnotesize Write a description for each class, if it start with "this class performs...", then it should probably be merged with another class
   - \footnotesize Don't name classes with verbs (it is bad form) classes are things not actions

\vskip.5em

2. \small Classes should more often than not have more than one method.
   - \footnotesize A class with a single method is probably begging to be merged with another class

\vskip.5em

3. \small Resist using inheritance (unless you have a predefined taxonomy already)
   - \footnotesize More often than not what you really want to convey is composition
   - \footnotesize Inheritance is for showing a relationship among well-understood abstractions

# Conceptual Class Guidelines

4. \small Be wary of Data Classes
   - \footnotesize Classes with a bunch of fields
   - \footnotesize No real methods only getters and setters
   - \footnotesize These occur for several reasons
     * \scriptsize Attempting to model entities external to the system
     * \scriptsize Encapsulating facilities, constants, or shared variables
     * \scriptsize Classes used to describe non-modifiable objects
5. \small Look for the properties of an \textcolor{Roarange}{\textbf{ideal class}}:
   - \footnotesize clearly associated abstraction, which should be a data abstraction and not a process abstraction
   - \footnotesize a descriptive noun/adjective for the class name
   - \footnotesize a non-empty set of runtime objects
   - \footnotesize queries and commands
   - \footnotesize abstract properties that can be described as pre/post conditions and invariants


# Domain Modeling

* \small \textcolor{Roarange}{\textbf{Domain:}} Any area in which we develop software systems. Examples include
  - \footnotesize Library systems
  - \footnotesize Hotel reservation systems
  - \footnotesize University registration systems

\vskip.5em

* \small Some domains may even encompass subdomains

# Domain Analysis

* \small \textcolor{Roarange}{\textbf{Goal:}} analyze related application systems in a domain in order to discover
  - \footnotesize features they have in common
  - \footnotesize parts that are variable
  - \footnotesize Essentially, we identify common requirements within the domain rather than trying to solve the problem from scratch.

\vskip.5em

* \small \textcolor{Roarange}{\textbf{Goal:}} Reuse. We want to apply what we know of similar systems to speed up:
  - \footnotesize specification
  - \footnotesize design
  - \footnotesize implementation

# Domain Analysis

* \small Domain analysis is performed prior to analysis and construction of a specific system
  - \footnotesize Provides knowledge about the concepts of the domain
  - \footnotesize Provides knowledge about competing products
  - \footnotesize Discovers business rules that any such system must conform to
  - \footnotesize Reduces necessary development time

# Domain Analysis

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/analysis/analysis09-inv.eps}

# For Next Time

::: columns
:::: column
* Review Chapter 6
* Review this lecture
* Read Chapter 7
* Come to Class
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
