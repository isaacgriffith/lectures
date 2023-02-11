---
author:
- Isaac Griffith
title: Refactoring - General Idea and Process
institute: |
  CS 4423 and CS 5523

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand and describe the general idea of refactoring
* Understand and describe the process of refactoring
* Understand and be able to evaluate the impacts of refactoring on quality
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears.jpg}
::::
:::

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.675\textwidth}
\Huge Refactoring
\vskip-0.75em
\rule{.975\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# General Idea

* Developers continuously modify, enhance and adapt software.
* As software evolves and strays away from its original design, three things happen.
  * Decreased understandability
  * Decreased reliability
  * Increased maintenance cost
* Decreased understandability is due to
  * Increased complexity of code
  * Out-of-date documentation
  * Code not conforming to standards

# General Idea

* Decrease the complexity of software by improving its internal quality by  restructuring the software.
* Restructuring applied on object-oriented software is called refactoring.
* Restructuring means reorganizing software (source code + documentation) to give it a different look, or structure.

# General Idea

* Source code is restructured to improve some of its non-functional requirements:
  * Readability			
  * Extensibility
  * Maintainability
  * Modularity
* Restructuring does not modify the software’s functionalities.
* Restructuring can be performed while adding new features.

# General Idea

* Software restructuring is informally stated as the modifications of software to make it
  - easier to understand;
  - easier to change;
  - easier to change its  documentation;
  - less susceptible to faults when changes are made to it.

# General Idea

* A higher level goal of restructuring is to increase the software value
  - external software value: fewer faults in software is seen to be better by customers
  - internal software value: a well-structured system is less expensive to maintain
* Simple examples of restructuring
  - Pretty printing
  - Meaningful names for variables
  - One statement per line of source code

# General Idea

* Developers and managers need to be aware of restructuring for the following reasons
  - better understandability
  - keep pace with new structures
  - better reliability
  - longer lifetime
  - automated analysis

# General Idea

* Characteristics of restructuring and refactoring
  - The objective of restructuring and refactoring is to improve the internal and external values of software.
  - Restructuring preserves the external behavior of the original program.
  - Restructuring can be performed without adding new requirements.
  - Restructuring generally produces a program in the same language.
    - Example: a C program is restructured into another C program.

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge Refactoring Process
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# Refactoring Process Activities

* To restructure a software system, one follows a process with well defined activities.
  - Identify what to refactor.
  - Determine which refactorings to apply.
  - Ensure that refactoring preserves the software’s behavior.
  - Apply the refactorings to the chosen entities.
  - Evaluate the impacts of the refactorings.
  - Maintain consistency.

<!-- make this an image and integrate this image (a a vertical process) with the slides of this section -->

# Identify what to refactor

* The programmer identifies what to refactor from a set of high-level software artifacts.
  - source code;
  - design documents; and
  - requirements documents.
* Next, focus on specific portions of the chosen artifact for refactoring.
  - Specific modules, functions, classes, methods, and data can be identified for refactoring.

# Identify what to refactor

* The concept of code smell is applied to source code to detect what should be refactored.
* A code smell is any symptom in source code that possibly indicates a deeper problem.
* Examples of code smell are:
  - duplicate code;
  - long parameter list;
  - long methods;
  - large classes;
  - message chain.

# Identify what to refactor

* Entities to be refactored at the design level
  * software architecture;
    * class diagram;
    * statechart diagram; and
    * activity diagrams;
  * global control flow; and
  * database schemas.

# Determine refactorings to apply

::: columns
:::: column
\centering
\includegraphics[width=\textwidth]{images/refactoring/ref01.eps}
::::
:::: column

\scriptsize
- R1: \color{Roarange}Rename\color{Black}\ method \color{Roarange}`print`\color{Black}\ to \color{GrowlingGray}`process`\color{Black}\ in class \color{Roarange}`PrintServer`\color{Black}.
- R2: \color{Roarange}Rename\color{Black}\ method \color{Roarange}`save`\color{Black}\ to \color{GrowlingGray}`process`\color{Black}\ in class \color{Roarange}`FileServer`\color{Black}.  (R1 and R2 are to be done together.)
- R3: \color{Roarange}Create\color{Black}\ a superclass \color{GrowlingGray}`Server`\color{Black}\ from \color{Roarange}`PrintServer`\color{Black}\ and \color{Roarange}`FileServer`\color{Black}.
- R4: \color{Roarange}Pull up\color{Black}\ method \color{GrowlingGray}`accept`\color{Black}\ from \color{Roarange}`PrintServer`\color{Black}\ and \color{Roarange}`FileServer`\color{Black}\ to the superclass \color{GrowlingGray}`Server`\color{Black}.
- R5: \color{Roarange}Move\color{Black}\ method \color{GrowlingGray}`accept`\color{Black}\ from \color{Roarange}`PrintServer`\color{Black}\ to class \color{GrowlingGray}`Packet`\color{Black}\, so that data packets themselves will decide what actions to take.

::::
:::

# Determine refactorings to apply

::: columns
:::: column
\centering
\includegraphics[width=\textwidth]{images/refactoring/ref01.eps}
::::
:::: column

\scriptsize
- R6: \color{Roarange}Move\color{Black}\ method \color{GrowlingGray}`accept`\color{Black}\ from \color{Roarange}`FileServer`\color{Black}\ to \color{GrowlingGray}`Packet`\color{Black}.
- R7: \color{Roarange}Encapsulate\color{Black}\ field \color{GrowlingGray}`receiver`\color{Black}\ in \color{GrowlingGray}`Packet`\color{Black}\ so that another class cannot directly access this field.
- R8: \color{Roarange}Add parameter\color{Black}\ \color{GrowlingGray}`p`\color{Black}\ of type \color{GrowlingGray}`Packet`\color{Black}\ to method \color{GrowlingGray}`print`\color{Black}\ in \color{Roarange}`PrintServer`\color{Black}\ to print the contents of a  packet.
- R9: \color{Roarange}Add parameter\color{Black}\ \color{GrowlingGray}`p`\color{Black}\ of type \color{GrowlingGray}`Packet`\color{Black}\ to method \color{GrowlingGray}`save`\color{Black}\ in class \color{Roarange}`FileServer`\color{Black}\ so that the contents of a packet can be saved.

::::
:::

# Determine refactorings to apply

* \color{Roarange}\textbf{R1 -- R9}\color{Black}\ indicate that  a large number of refactorings can be identified even for a small system.
* A subset of the entire set of refactorings need to be carefully chosen because of the following reasons.
  - Some refactorings must be applied together.
    - Example: R1 and R2 are to be applied together.
  - Some refactorings must be applied in certain orders.
    - Example: R1 and R2 must precede R3.
  - Some refactorings can be individually applied, but they must follow an order if applied together.
    - Example: R1 and R8 can be applied in isolation. However, if both of them are to be applied, then R1 must occur before R8.
  - Some refactorings are mutually exclusive.
    - Example: R4 and R6 are mutually exclusive.

# Determine refactorings to apply

* Tool support is needed to identify a feasible subset of refactorings.
* The following two techniques can be used to analyze a set of refactorings to select a feasible subset.
  - **Critical pair analysis**
    - Given a set of refactorings, analyze each pair for conflicts. A pair is said to be conflicting if both of them cannot be applied together.
    - Example: R4 and R6 constitute a conflicting pair.
  - **Sequential dependency analysis**
    - In order to apply a refactoring, one or more refactorings must be applied before.
    - If one refactoring has already been applied, a mutually exclusive refactoring cannot be applied anymore.
    - Example: after applying R1, R2, and R3,  R4 becomes applicable. Now, if R4 is applied, then R6 is not applicable anymore.

# Ensure preservation of behavior

* Ideally, the input/output behavior of a program after refactoring is the same as the behavior before refactoring.
* In many applications, preservation of non-functional requirements is necessary.
* A non-exclusive list of such non-functional requirements is as follows:
* \color{Roarange}\textbf{Temporal constraints:}\color{Black}\ A temporal constraint over a sequence of operations is that the operations occur in a certain order.
  * For real-time systems, refactorings should preserve temporal constraints.
* \color{Roarange}\textbf{Resource constraints:}\color{Black}\ The software after refactoring does not demand more resources: memory, energy, communication bandwidth, and so on.
* \color{Roarange}\textbf{Safety constraints:}\color{Black}\ It is important that the software does not lose its safety properties after refactoring.

# Ensure preservation of behavior

* Two pragmatic ways of showing that refactoring preserves the software’s behavior.
  - Testing
    * Exhaustively test the software before and after applying refactorings, and compare the  observed behavior on a test-by-test basis.
  - Verification of preservation of call sequence
    * Ensure that the  sequence(s) of method calls are preserved in the refactored program.

# Apply the refactorings

\footnotesize
* The following transformation is obtained by:
  - \scriptsize focusing on the classes \color{Roarange}`FileServer`\color{Black}, \color{Roarange}`PrintServer`\color{Black}, and \color{Roarange}`Packet`\color{Black}
  - \scriptsize applying refactorings R1, R2, and R3.

\centering
\vskip-1em
\includegraphics[width=\textwidth]{images/refactoring/ref04.eps}

\tiny
- R1: \color{Roarange}Rename\color{Black}\ method \color{Roarange}`print`\color{Black}\ to \color{GrowlingGray}`process`\color{Black}\ in class \color{Roarange}`PrintServer`\color{Black}.
- R2: \color{Roarange}Rename\color{Black}\ method \color{Roarange}`save`\color{Black}\ to \color{GrowlingGray}`process`\color{Black}\ in class \color{Roarange}`FileServer`\color{Black}.
- R3: \color{Roarange}Create\color{Black}\ a superclass \color{GrowlingGray}`Server`\color{Black}\ from \color{Roarange}`PrintServer`\color{Black}\ and \color{Roarange}`FileServer`\color{Black}.

# Apply the refactorings

\centering
\includegraphics[width=.65\textwidth]{images/refactoring/ref02.eps}

\vskip-10em

::: columns
:::: column

::::
:::: column
\tiny
- R4: \color{Roarange}Pull up\color{Black}\ method \color{GrowlingGray}`accept`\color{Black}\ from \color{Roarange}`PrintServer`\color{Black}\ and \color{Roarange}`FileServer`\color{Black}\ to the superclass \color{GrowlingGray}`Server`\color{Black}.
- R6: \color{Roarange}Move\color{Black}\ method \color{GrowlingGray}`accept`\color{Black}\ from \color{Roarange}`FileServer`\color{Black}\ to \color{GrowlingGray}`Packet`\color{Black}.
::::
:::

# Evaluate impacts on quality

<!-- color according to slide 22 -->
* Refactorings impact both \color{Roarange}\textbf{internal}\color{Black}\ and \color{Roarange}\textbf{external}\color{Black}\ qualities of software.

\vskip1.5em

::: columns
:::: column

* \color{Roarange}\textbf{Internal}\color{Black}\ qualities of software include
  - size
  - complexity
  - coupling
  - cohesion
  - testability

::::
:::: column

* \color{Roarange}\textbf{External}\color{Black}\ qualities of software include:
  - performance
  - reusability
  - maintainability
  - extensibility
  - robustness
  - scalability

::::
:::

# Evaluate impacts on Quality

* In general, refactoring techniques are \color{Roarange}\textbf{highly specialized}\color{Black}, with one technique improving a \color{Roarange}\textbf{small number}\color{Black}\ of quality attributes.

\vskip1.5em

* For example,
  - some refactorings eliminate code duplication;
  - some raise reusability;
  - some improve performance; and
  - some improve maintainability.

# Evaluate impacts on Quality

* By measuring the impacts of refactorings on internal qualities, their impacts on external qualities can be measured.
* Example of measuring external qualities
  - Some examples of software metrics are coupling, cohesion, and size.
  - Decreased coupling, increased cohesion, and decreased size are likely to make a software system more maintainable.
  - To assess the impact of a refactoring technique for better maintainability, one can evaluate the metrics before refactoring and after refactoring, and compare them.

# Maintain Consistency

* Rather than evaluate the impacts \color{Roarange}after applying refactorings\color{Black}, one selects refactorings such that the program \color{Roarange}after\color{Black}\ refactoring possesses better quality attributes.
* The concept of a \color{Roarange}\textbf{soft-goal graph}\color{Black}\ help select refactorings.

# Example

* A soft-goal graph for quality attribute (maintainability) rooted at high maintainability (desired change).

::: columns
:::: {.column width=.65}

\centering
\includegraphics[width=\textwidth]{images/refactoring/ref03.eps}

::::
:::: {.column width=.35}
\footnotesize
* The internal nodes represent successive refinements of the attribute and are basically the soft goals.
* The leaf nodes represent refactoring transformations which contribute positively/negatively to soft-goals which appear above them in the hierarchy.

::::
:::

# Example

* A partial example of a soft goal graph with one leaf node, \color{Roarange}\textbf{Move}\color{Black}

::: columns
:::: {.column width=.7}

\centering
\includegraphics[width=\textwidth]{images/refactoring/ref03.eps}

::::
:::: {.column width=.3}
\footnotesize
* The dotted lines between \color{Roarange}\textbf{Move}\color{Black}\ and three soft goals
  - \scriptsize High Modularity
  - \scriptsize High Module Reuse
  - \scriptsize Low Control Flow Coupling
* Implies that the Move transformation impacts those three soft goals

::::
:::

# For Next Time

::: columns
:::: {.column width=.6}
* Review EVO Chapter 7.1 - 7.2
* Read EVO Chapter 7.3 - 7.4
* Watch Lecture 18
::::
:::: {.column width=.4}
\centering
\includegraphics[width=.85\textwidth]{images/next_time.png}
::::
:::

#

\centering
\vfill
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
