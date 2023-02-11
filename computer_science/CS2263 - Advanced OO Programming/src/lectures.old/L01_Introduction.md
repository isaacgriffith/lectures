---
author:
- Isaac Griffith
title: Introduction
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

* Understand the reason for this course
* Understand the requirements of this course and policies of the course as laid out in thy syllabus
* Describe the need for teamwork and what makes for a good team
* Describe the need for software engineering in a larger context

# Inspiration

\vfill
\centering
> "Nine women cannot make a baby in one month." -- Fred Brooks

#

\vfill
\centering
\Huge Syllabus Review

# Why care about Software Engineering?

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

#

\vfill
\begin{center}
{\Huge Programming in the Large}
\end{center}

# Programming in the Small vs Large

::: columns
:::: column
**Programming in the Small:**

* Programs do one relatively simple task well
* Team is typically small, even one engineer
* Program created is complete within itself
* Ready to run on system in which developed
* Typically, short-lived projects
::::
:::: column
**Programming in the Large:**

* Programs typically perform man complicated tasks
* Medium - Large-sized industrial teams
* Programs are split into several or hundreds of modules
  - Each module is similar in complexity to a single program
* Requires ongoing testing, maintenance, and documentation
* Work requires many months to several years
::::
:::

# Software Engineering Practice

\vspace{-1.5em}
 \begin{center}
  \includegraphics[width=.7\textwidth]{images/Intro/practice}
 \end{center}

# Software Engineering Practice

\textbf{Understand the Problem}
\begin{itemize}
 \item Who are the stakeholders?
 \item What functions and features are required to solve the problem?
 \item Is it possible to create smaller problems that are easier to understand?
 \item Can a graphic analysis model be created?
\end{itemize}
\vskip1em
\textbf{Plan the Solution}
\begin{itemize}
 \item Have you seen similar problems before?
 \item Has a similar problem been solved?
 \item Can readily solvable subproblems be defined?
 \item Can a design model be created?
\end{itemize}

# Creating a "Jelled" Team

* A team of people so strongly knit that the whole is greater than the sum of its parts

\vskip1em

* Characteristics of a jelled team:

  * Very low turnover rate
  * Strong sense of identity
  * A feeling of eliteness
  * Team vs. individual ownership of the project
  * Team members enjoy their work

# Motivating People

* Motivation is the greatest influence on performance
* Monetary rewards usually do not motivate
* Suggested motivating techniques:

  * 20% time rule
  * Peer-to-peer recognition awards
  * Team ownership (refer to the team as "we")
  * Allow members to focus on what interests them
  * Utilize equitable compensation
  * Encourage group ownership
  * Provide for autonomy, but trust the team to deliver

# Handling Conflict

* Preventing or mitigating conflict:

  * Cohesiveness has the greatest effect
  * Clearly defining roles and holding team members accountable
  * Establish work & communications rules in the project charter

\vskip1em

* Additional techniques:

  * Clearly define plans for the project
  * Make sure the team understands the importance of the project
  * Develop detailed operating procedures
  * Develop a project charter
  * Develop a schedule of commitments in advance
  * Forecast other priorities and their impact on the project



# Environment & Infrastructure

* Environment--Choose the right set of tools

  * Use appropriate CASE tools to:

    * Increase productivity and centralize information (repository)
    * Utilize diagrams--more easily understood

  * Establish standards to reduce complexity

* Infrastructure--Document the project appropriately

  * Store deliverables & communications in a project binder
  * Use Unified Process standard documents
  * Don't put off documentation to the last minute

# Think Pair Share

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
Consider the notion of a jelled team. Today, have multiple teams and team members working on a project separated by distance is a common practice. How would distance affect the ability of maintaining a Jelled team?
\end{minipage}
\vskip1em
\begin{minipage}{50pt}
\includegraphics[width=50pt]{images/idea.png}
\end{minipage}
\begin{minipage}[adjusting]{4in}
Pair up with your neighbor and take the next few minutes to discuss your thoughts.
\end{minipage}

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
