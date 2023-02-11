---
author:
- Isaac Griffith
title: Reengineering Process and Models
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

After today's lecture you will:

::: columns
:::: {.column width=.7}
* Have an understanding of the various approaches to the reengineering process
* Have an understanding of various models and components underlying the reengineering process
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
\begin{minipage}{.775\textwidth}
\begin{minipage}{3.5em}
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge Reengineering Process

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# Reengineering Process

* An ordered set of activities designed to perform a specific task is called a process
* For ease of understanding and communication, processes are described by means of process models
* For example, in the software development domain, the Waterfall process model is widely used in developing well-understood software systems

# Reengineering Process

* Process models are used to comprehend, evaluate, reason about, and improve processes.
* Intuitively, process models are described by means of important relationships among data objects, human roles, activities, and tools
* We will discuss five process models for software reengineering
* The five approaches are different in two aspects:
  1. the extent of reengineering performed
  2. the rate of substitution of the operational system with the new one

# Big Bang Approach

\footnotesize
* The "**Big Bang**" approach replace the whole system at once
* Once a reengineering effort is initiated, it is continued until all the objectives of the project are achieved and the target system is constructed
* This approach is generally used if reengineering cannot be done in parts
* For example, if there is a need to move to a different system architecture, then all components affected by such a move must be changed at once
* The consequent advantage is that the system is brought into its new environment all at once
* The disadvantage of Big Bang is that the reengineering project becomes a monolithic task, which may not be desirable in all situations
* In addition, the Big Bang approach consumes too much resources at once for large systems, and takes a long stretch of time before the new system is visible.

# Incremental Approach

\footnotesize
* In this approach a system is reengineered gradually, one step closer to the target system at a time
* For a large system, several new interim versions are produced and released
* Successive interim versions satisfy increasingly more project goals than their preceding versions
* The advantages of this approach are as follows:
  1. \scriptsize locating errors becomes easier, because one can clearly identify the newly added components
  2. \scriptsize it becomes easy for the customer to notice progress, because interim versions are released
* The disadvantages of the incremental approach are as follows:
  1. \scriptsize with multiple interim versions and their careful version controls, the incremental approach takes much longer to complete
  2. \scriptsize even if there is a need, the entire architecture of the system cannot be changed

# Partial Approach

\footnotesize
* In this approach, only a part of the system is reengineered and then it is integrated with the non-engineered portion of the system
* One must decide whether to use a "Big Bang" approach or an "Incremental" approach for the portion to be reengineered
* The following three steps are followed in the partial approach:
  1. \scriptsize The existing system is partitioned into two parts: one part is identified to be reengineered and the remaining part to be not reengineered
  2. \scriptsize Reengineering work is performed using either the "Big Bang" or the "Incremental" approach
  3. \scriptsize The two parts, namely, the not-to-be-reengineered part and the reengineered part of the system, are integrated to make up the new system
* The partial approach has the advantage of reducing the scope of reengineering that is less time and costs less
* A disadvantage of the partial approach is that modifications are not performed to the interface between the portion modified and the portion not modified

# Iterative Approach

\footnotesize
* The reengineering process is applied on the source code of a few procedures at a time, with each reengineering operation lasting for a short time
* This process is repeatedly executed on different components in different stages
* During the execution of the process, ensure that the four types of components can coexists:
  - old components not reengineered
  - components currently being reengineered
  - components already reenengineered
  - new components added to the system

# Iterative Approach

\footnotesize
* There are two advantages of the iterative reenineering process:
  1. it guarantees the continued operation of the system during the execution of the reengineering process
  2. the maintainers' and the users' familiarities with the system are preserved
* The disadvantage of this approach is the need to keep track of the four types of components during the reengineering process
* In addition, both the old and the newly reengineered components need to be maintained

#  Evolutionary Approach

* In the "Evolutionary" approach components of the original system are substituted with re-engineered components
* In this approach, the existing component are grouped by functions and reengineered into new components
* Software engineers focus their reengineering efforts on identifying functional objects irrespective of the locations of those components within the current system
* As a results, the new system is built with functionally cohesive components as needed

# Evolutionary Approach

* There are two advantages of the "Evolutionary" approach:
  1. the resulting design is more cohesive
  2. the scope of individual components is reduced
* A major disadvantage:
  1. all the functions with much similarities must be first identified throughout the operational system
  2. next, those functions are refined as one unit in the new system

#

\centering
\vfill
\begin{minipage}{.775\textwidth}
\begin{minipage}{3.5em}
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge Reengineering Models

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# Reengineering Ref Model

::: columns
:::: column

\footnotesize
* The SCORE/RM model was proposed by Colbrook, Smythe and Darlison
* The framework consists of four kinds of elements:
  - \scriptsize function
  - \scriptsize documentation
  - \scriptsize repository database
  - \scriptsize metrication
* The function element is divided into 8 layers, namely:
  - \scriptsize encapsulation, transformation
  - \scriptsize normalization, interpretation
  - \scriptsize abstraction, causation
  - \scriptsize regeneration, certification

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/reeng/reeng06.eps}

::::
:::

# Reengineering Ref Model

\footnotesize
* The eight layers provide a detailed approach to:
  1. \scriptsize rationalizing the system to be reengineered by removing redundant data and altering the control flow
  2. \scriptsize comprehending the software's requirements
  3. \scriptsize reconstructing the software according to established practices
* The first six of the eight layers together constitute a process for reverse engineering, and the final three a process for forward engineering
* Improvements in the software as a result of reengineering is quantified by means of the metrication element
* The metrication element is described in terms of the relevant software metrics before executing a layer after executing the same layer
* The repository database is the information store for the entire reengineering process, containing the following kinds of information:
  - \scriptsize metrication
  - \scriptsize documentation
  - \scriptsize both the old and the new source code

# Reengineering Reference Model

\footnotesize
* The interfaces among the elements shown in the figure
* For simplicity, any layer is referred to as (N)-layer, while its next lower and next higher layers are referred to as (N - 1)-layer and the (N + 1)-layer, respectively
* The three types of interfaces are explained as follows:
  - \scriptsize \textbf{Metrication/Function:} (N)-MF -- the structures describing the metrics and their values
  - \scriptsize \textbf{Documentation/Function:} (N)-DF -- the structures describing the documentation
  - \scriptsize \textbf{Function/Function:} (N)-FF -- the representation structures for source code passed between the layers

\centering
\includegraphics[width=.55\textwidth]{images/reeng/reeng07.eps}

# Phase Reengineering Model

\footnotesize
* The phase model software reengineering was originally proposed by Byrne and Gustafson
* The model comprises five phases: analysis and planning, renovation, target system testing, redocumentation, and acceptance testing and system transition

::: columns
:::: column

* The labels on the arcs denote the possible information that flows from the tail entities of the arcs to the head entities
* A major process activity is represented by each phase
* Tasks represent a phase's activities, and tasks can be further decomposed to reveal the detailed methodologies

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/reeng/reeng08.eps}

::::
:::

# Analysis and Planning

\footnotesize
* Analysis addresses three technical and one economic issue
  - Technical Issues:
    1. The present state of the system to be reegineered and understanding its properties
    2. The identification of the need for the system to be reengineered
    3. The specification of the characteristics of the new system to be produced
  - Economic issue:
    - A cost/benefit analysis of the reengineering project
* Planning includes:
  - Understanding the scope of the work
  - Identifying the required resources
  - Identifying the tasks and milestones
  - Estimating the required effort
  - Preparing a schedule

# Analysis and Planning Tasks

\scriptsize
+----------------------------+------------------------------------------------------------------------------+
| **Task**                   | **Description**                                                              |
+:===========================+:=============================================================================+
| Implementation motivations | List the motivations for reengineering the system. List the                  |
|    and objectives          | objectives to be achieved.\vskip0.25em                                       |
+----------------------------+------------------------------------------------------------------------------+
| Analyze environment        | Identify the differences between the existing and the                        |
|                            |    target environments. Differences can influence                            |
|                            |    system changes.\vskip0.25em                                               |
+----------------------------+------------------------------------------------------------------------------+
| Collect inventory          | Form a baseline for knowledge about the operational                          |
|                            |    system by locating all program files, documents, test                     |
|                            |    plans, and history of maintenance.\vskip0.25em                            |
+----------------------------+------------------------------------------------------------------------------+
| Analyze implementation     | Analyze the source code and record the details of the code. \vskip0.25em     |
+----------------------------+------------------------------------------------------------------------------+
| Define approach            | Choose an approach to reengineer the system. \vskip0.25em                    |
+----------------------------+------------------------------------------------------------------------------+
| Define project procedures  | Procedures outline how to perform reviews and report                         |
|    and standards           |    problems. Standards describe the acceptable formats of                    |
|                            |    the outputs of processes. \vskip0.25em                                    |
+----------------------------+------------------------------------------------------------------------------+

# Analysis and Planning Tasks

\scriptsize
+----------------------------+------------------------------------------------------------------------------+
| **Task**                   | **Description**                                                              |
+:===========================+:=============================================================================+
| Identify resources         | Determine what resources are going to be used; ensure                        |
|                            |    that resources are ready to be used. \vskip0.25em                         |
+----------------------------+------------------------------------------------------------------------------+
| Identify tools             | Determine and obtain tools to be used in the reengineering                   |
|                            |    project. \vskip0.25em                                                     |
+----------------------------+------------------------------------------------------------------------------+
| Data conversion planning   | Make a plan to effect changes to databases and files. \vskip0.25em           |
+----------------------------+------------------------------------------------------------------------------+
| Test planning              | Identify test objectives and test procedures, and evaluate                   |
|                            |    the existing test plan. Design new tests if there is a need. \vskip0.25em |
+----------------------------+------------------------------------------------------------------------------+
| Define acceptance criteria | By means of negotiations with the customers, identify                        |
|                            |    acceptance criteria for the target system. \vskip0.25em                   |
+----------------------------+------------------------------------------------------------------------------+

# Analysis and Planning Tasks

\scriptsize
+----------------------------+------------------------------------------------------------------------------+
| **Task**                   | **Description**                                                              |
+:===========================+:=============================================================================+
| Documentation planning     | Evaluate the existing documentation. Develop a plan to                       |
|                            |    redocument the target system. \vskip0.25em                                |
+----------------------------+------------------------------------------------------------------------------+
| Plan system transition     | Develop an end-of-project plan to put the new system into                    |
|                            |    operation and phase out the old one. \vskip0.25em                         |
+----------------------------+------------------------------------------------------------------------------+
| Estimation                 | Estimate the resource requirements of the project: effort,                   |
|                            |    cost, duration, and staffing. \vskip0.25em                                |
+----------------------------+------------------------------------------------------------------------------+
| Define organizational      | Identify personnel for the project, and develop a project                    |
|    structure               |    organization. \vskip0.25em                                                |
+----------------------------+------------------------------------------------------------------------------+
| Scheduling                 | Develop a schedule, including dependencies, for project                      |
|                            |    phases and tasks. \vskip0.25em                                            |
+----------------------------+------------------------------------------------------------------------------+

# Renovation

\footnotesize
* An operational system is modified into the target system in the renovation phase
* Two main aspects of a system are considered in this phase:
  1. representation of the system
     - It refers to source code, but it may include the design model and the requirement specification of the existing system
  2. representation of external data
     - It refers to the database and/or data files used by the system. Often the external data are reengineered, and it is known as data reengineering
* An operational system can be renovated in many ways, depending upon the objectives of the project, the approach followed, and the starting representation of the system
* It may be noted that the starting representation can be source code, design, or requirements

# Renovation Example

\footnotesize
* A project in which the objective is to re-code the system from Fortran to C
* The figure below shows the three possible replacement strategies
  1. \scriptsize To perform source-to-source translation, program migration is used
  2. \scriptsize A high-level design is constructed from the operational source code, say, in Fortran, and the resulting design is re-implemented in the target language, C in this case
  3. \scriptsize A mix of compilation and decompilation is used to obtain the system implementation in C

\centering
\includegraphics[width=.6\textwidth]{images/reeng/reeng09.eps}

# Target System Testing

* In this phase for system testing, faults are detected in the target system
* Those faults might have been introduced during reengineering
* Fault detection is performed by applying the target system test plan on the target system
* The same testing strategies, techniques, methods, and tools that are used in software development are used during reengineering
* For example, apply the existing system-level test cases to both the existing and the new system
* Assuming that the two systems have identical requirements, the test results from both the scenarios must be the same

# Redocumentation

\footnotesize
* Documentations are rewritten, updated, and/or replaced to reflect the target system
* Documents are revised according to the redocumentation plan
* The two major tasks within this phase are:
  1. \scriptsize Analyze new source code
  2. \scriptsize Create documentation
* Documents requiring revision are:
  - \scriptsize Requirement specification
  - \scriptsize Design documentation
  - \scriptsize A report justifying the design decisions, assumptions made in the implementation configuration
  - \scriptsize User and reference manuals
  - \scriptsize On-line help
  - \scriptsize Document describing the differences between the existing and the target system

# Acceptance and System Transition

* In this final phase, the reengineered system is evaluated by performing acceptance testing
* Acceptance criteria should already have been established in the beginning of the project
* Should the reengineered system pass those tests, the faults must be fixed; in some cases, those faults are fixed after the target system is deployed
* Upon completion of the acceptance tests, the reeengineered system is made operational, and the old system is put out of service
* System transition is guided by the prior developed transition plan

# For Next Time

::: columns
:::: column
* Review EVO Chapter 4.4
* Read EVO Chapter 4.5-4.10
* Watch the Lecture 09
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
