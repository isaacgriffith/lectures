---
author:
- Dr. Isaac Griffith
title: Class Diagrams
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
* \footnotesize Have an understanding of the different types of UML Diagrams
* \footnotesize Understand the types of relationships between classes/objects
* \footnotesize Be capable of using these relationships in Class Diagrams
* \footnotesize Be capable of translating basic Class Diagrams to working code.
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert.jpg}
::::
:::

#

\centering
\vfill
\begin{minipage}{.55\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge UML Class Diagrams
\end{center}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# What is UML?

* UML: pictures of an OO system
  - \footnotesize programming languages are not abstract enough for OO design
  - \footnotesize UML is an open standard, lots of companies use it

* What is legal UML?
  - \footnotesize a \textcolor{Roarange}{\textit{descriptive}} language: rigid formal syntax (like programming)
  - \footnotesize a \textcolor{Roarange}{\textit{prescriptive}} language: shaped by usage and convention
  - \footnotesize it's okay to omit things from UML diagrams if they aren't needed by team/supervisor/instructor

# Uses for UML

* As a sketch: to communicate aspects of a system
  - \footnotesize \textcolor{Roarange}{\textbf{Forward Design:}} doing UML before coding
  - \footnotesize \textcolor{Roarange}{\textbf{Backward Design:}} doing UML after coding as documentation
  - \footnotesize Often done on whiteboard or paper, but with current collaborative tools, it has become more and more digital
  - \footnotesize Used to get rough selective ideas

* As a blueprint: a complete design to be implemented
  - \footnotesize Sometimes done with CASE (Computer-Aided Software Engineering) tools

* As a programming language: with the right tools, code can be auto-generated and executed from UML
  - \footnotesize Only good if this is faster than coding in a "real" language

# UML Class Diagrams

* **UML class diagram:** a picture of
  - the classes in an OO system
  - their fields and methods
  - connections between the classes
    * that interact or inherit from each other

* \underline{Not} represented in a UML class diagram:
  - details of how the classes interact with each other
  - algorithmic details; how a particular behavior is implemented

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Examples
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Movie Theater

\centering
\includegraphics[width=.85\textwidth]{images/cd_examples/movie_theater.eps}

# Order Handling

\centering
\includegraphics[width=.85\textwidth]{images/cd_examples/customers.eps}

# People

\centering
\includegraphics[width=.75\textwidth]{images/cd_examples/people.eps}

# Retro Video Store

\centering
\includegraphics[width=.65\textwidth]{images/cd_examples/video_store.eps}

# Students

\centering
\includegraphics[width=.6\textwidth]{images/cd_examples/students.eps}

# Common Pitfalls in Modeling

* Confusing basic class relationships (i.e., IS-A, HAS-A, IS-Implemented-Using)
* Poor use of Inheritance
  - \footnotesize Violating encapsulation and/or increasing coupling
  - \footnotesize Base classes do too much or too little
  - \footnotesize Not preserving base class invariants
  - \footnotesize Confusing interface inheritance with implementation inheritance
  - \footnotesize Using multiple inheritance to invert IS-A

# For Next Time

::: columns
:::: column
* Review this Lecture
* Watch the video on creating class diagrams with LucidCharts
* Come to Class
* Read Chapter 4.1 - 4.4
* Read Java 9 Modules Tutorial
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
