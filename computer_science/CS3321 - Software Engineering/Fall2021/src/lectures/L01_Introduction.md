---
author:
- Isaac Griffith
title: Introduction
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

* Syllabus Review
* Course Introduction and Why Software Engineering
* Nature and Role of SE Standards
* Economic Impact of Software
* The "Good Enough" Principle
* Friction-Free Economy
* Ecosystems
* Offshoring and Outsourcing

#

\centering
\vfill
\begin{minipage}{.65\textwidth}
\begin{minipage}{3.5em}
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge Syllabus Overview

\large \color{Roarange}\textbf{CS 3321 | INFO 3307}
\end{minipage}
\end{minipage}

# Prerequisite Overview

The Prerequisite for this course is CS 2263 and not CS/INFO 1182. Therefore I expect you to know and understand the following:

* From CS 2263
  - Git and the use of Git Flow
  - Dependency Management and Build Automation
  - Fundamental OO Design Principles and Practices
  - OO Design Patterns (GoF) and their implementation
  - Practices of Good Programming and Defensive Coding
  - Fundamentals of UML
  - Principles and Practices of TDD
  - Principles and Practices of CI/CD
  - Teamwork and having completed a large project

# Prerequisite Overview

* From CS 2235 (prereq to 2263)
  - Java
  - Basic Data Structures and their Implementation
  - Use of OO in a larger context
  - Basic algorithm implementation
  - Basic algorithm design strategies
  - Ability to complete moderately complex programs

* From CS 1181 (prereq to 2235)
  - Python
  - Basics of programming
  - Basics of OO
  - Ability to complete simple programs

#

\centering
\vfill
\begin{minipage}{.70\textwidth}
\begin{minipage}{3.5em}
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge Software Engineering

\large \color{Roarange}\textbf{CS 3321 | INFO 3307}
\end{minipage}
\end{minipage}

# Why Software Engineering?

::: columns
:::: column
\begin{center}
 \includegraphics[width=\textwidth]{images/Intro/duties}
\end{center}
::::
:::: column
* Interact with clients to determine their system requirements
* Translate user requirements into technical specifications
* Interact with designers to convey the possible interface of the software
* Interact/guide the coders/developers to keep track of system development
* Perform system testing with sample/live data with the help of testers
* Implement the new system
* Prepare high quality documentation
::::
:::

# Defining Software

**What is software?**

\pause

1. instructions (computer programs) that when executed provide desired features, function, and performance;
\pause
2. data structures that enable the programs to adequately manipulate information, and
\pause
3. descriptive information in both hard copy and virtual forms that describes the operation and use of the programs

# Software Deterioration

::: columns
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Intro/failure_rate}
\end{center}
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/Intro/deteriorate}
\end{center}
::::
:::

# Software Domains and Challenges

::: columns
:::: column
\begin{center}
\includegraphics[width=.7\textwidth]{images/Intro/software_domains}
\end{center}
::::
:::: column
* Open-world computing
   - Creating software to allow machines of all sizes to communicate with each other across vast networks

* Netsourcing
   - Architect simple and sophisticated applications that benefit targeted end-user markets worldwide

* Open Source
   - Distributing source code for computing applications so customers can make local modifications easily and reliably
::::
:::

# Legacy Software

**Legacy Software Systems:**

Systems that were developed decades ago and have been continually modified to meet changes in business requirements and computing platforms. The proliferation of such systems is causing headaches for large organizations who find them costly to maintain and risky to evolve.

**Reasons Legacy Systems Evolve:**

* Meet the needs of new computing environments/technologies
* To implement new business requirements
* To inter-operate with other more modern systems or databases
* To become viable within an evolving computing environment

# Changing Nature of Software

The goal of modern software engineering is to "devise methodologies that are founded on the notion of evolution;"

 Software systems continually change and all must interoperate and cooperate with each other.

 Four broad categories are evolving to dominate:
 \begin{center}
  \includegraphics[width=.75\textwidth]{images/Intro/changing}
 \end{center}

# Software Engineering

**Software Engineering (IEEE):**

1. The application of a systematic, disciplined, quantifiable approach to the development, operation, and maintenance of software; that is, the application of engineering to software.
2. The study of approaches as in (1)

* Software engineering encompasses a process, a collection of methods, and an array of tools that allow professionals to build high quality software.
* Software engineers view computer software, as being made up of the programs, documents, and data required to design and build the system.
* Software users are only concerned with whether or not software products meet their expectations and make their tasks easier to complete.

# Software Engineering Realities

* Problem should be understood before software solution is developed
* Design is a pivotal activity
* Software should exhibit high quality
* Software should be maintainable

# Think-Pair-Share

\begin{minipage}{50pt}
\includegraphics[width=50pt]{images/5-minutes.png}
\end{minipage}
\begin{minipage}[adjusting]{4in}
Take 2 minutes and think about the following question:
\end{minipage}
\vskip1em
\begin{minipage}{50pt}
\includegraphics[width=50pt]{images/brainstorming.png}
\end{minipage}
\begin{minipage}[adjusting]{4in}
Given the nature of software and the changes that have happened in your lifetime, what can we say about the changes we may see in the future? How do you think we will be building software in the next 5 years?
\end{minipage}
\vskip1em
\begin{minipage}{50pt}
\includegraphics[width=50pt]{images/idea.png}
\end{minipage}
\begin{minipage}[adjusting]{4in}
Pair up with your neighbor and take the next few minutes to discuss your thoughts.
\end{minipage}

# Software Engineering

* The economies of ALL developed nations are dependent on software.
* More and more systems are software controlled
* Software engineering is concerned with theories, methods and tools for professional software development.
* Expenditure on software represents a significant fraction of GNP in all developed countries.

# Software Costs

* Software costs often dominate computer system costs. The costs of software on a PC are often greater than the hardware cost.
* Software costs more to maintain than it does to develop. For systems with a long life, maintenance costs may be several times development costs.
* Software engineering is concerned with cost-effective software development.

# Software Project Failure

* *Increasing system complexity*
  - As new software engineering techniques help us to build larger, more complex systems, the demands change. Systems have to be built and delivered more quickly; larger, even more complex systems are required; systems have to have new capabilities that were previously thought to be impossible.

* *Failure to use software engineering methods*
  - It is fairly easy to write computer programs without using software engineering methods and techniques. Many companies have drifted into software development as their products and services have evolved. They do not use software engineering methods in their everyday work. Consequently, their software is often more expensive and less reliable than it should be.

# For Next Time

::: columns
:::: column
* Review the Syllabus
* Review this Lecture
* Read Essentials Chapters 1 and 2
* Come to Lecture
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}