---
author:
- Isaac Griffith
title: Maintenance Processes
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
* IEEE/EIA 1219 Maintenance Process
* ISO/IEC 14764 Maintenance Process
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
\begin{minipage}{.95\textwidth}
\Huge Maintenance Standards

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# Software Maintenance Standard

* IEEE and ISO have both addressed software maintenance processes

* IEEE/EIA 1219 and ISO/IEC 14764 as a part of ISO/IEC 12207 (life cycle processes)

* IEEE/EIA 1219 organizes the maintenance process in seven phases:
  - **problem identification**, **analysis**, **design**, **implementation**, **system test**, **acceptance test** and **delivery**

* ISO/IEC 14764 describes software maintenance as an iterative process for managing and executing software maintenance activities

* The activities which comprise the maintenance process are:
  - **process implementation**, **problem and modification analysis**, **modification implementation**, **maintenance review/acceptance**, **migration** and **retirement**

* Each of these maintenance activities is made up of tasks. Each task describes a specific action with inputs and outputs.

#

\centering
\vfill
\begin{minipage}{.775\textwidth}
\begin{minipage}{3.5em}
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge IEEE/EIA 1219

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# IEEE/EIA 1219 Maintenance Process

The standard focuses on seven-phases:

::: columns
:::: {.column width=.33}

* Problem Identification
* Analysis
* Design
* Implementation
* System Test
* Acceptance Test
* Delivery

::::
:::: {.column width=.66}

\centering
\vskip-1.5em
\includegraphics[width=.95\textwidth]{images/standards/standards01.eps}

::::
:::

# IEEE/EIA 1219 Maintenance Process

Each of the seven activities has five associated attributes as follows:

* **Activity definition:** This refers to the implementation process of the activity
* **Input:** This refers to the items that are required as input to the activity
* **Output:** This refers to the items that are produced by the activity
* **Control:** This refers to those items that provide control over the activity
* **Metrics:** This refers to the items that are measured during the execution of the activity

# Problem Identification Phase

::: columns
:::: {.column width=.4}

\scriptsize
* A request for change to the software is normally made by the users of the software system or the customers, and it starts the maintenance process
* The change request (CR) is submitted in the form of a modification requires (MR) for a correction or for an enhancement.
  - \scriptsize MR & CR are used interchangeably

::::
:::: {.column width=.6}

\centering
\includegraphics[width=\textwidth]{images/standards/standards02.eps}

::::
:::

\footnotesize
* Activities included in this phase are as follows:
  1. \scriptsize reject or accept the MR
  2. \scriptsize identify and estimate the resources needed to change the system
  3. \scriptsize put the MR in a batch of changes scheduled for implementation

# Analysis Phase

::: columns
:::: {.column width=.4}

The process is viewed to have two major components:

1. feasibility analysis
2. detailed analysis

::::
:::: {.column width=.6}

\centering
\includegraphics[width=\textwidth]{images/standards/standards03.eps}

::::
:::

::: columns
:::: column

\footnotesize
\vskip-3em

**Feasibility analysis is performed to:**

1. determine the impact of the change
2. investigate other possible solutions including prototyping
3. assess both short-term and long-term costs
4. determine the benefits of making the change

::::
:::: column

\vskip1em

\footnotesize
**Detailed analysis determines**

1. firm modification requirements
2. the software components involved
3. an overall test strategy
4. an implementation plan

::::
:::

# Design Phase

::: columns
:::: {.column width=.35}

**Activities:**
\footnotesize

1. identify the affected software components
2. modify the software components
3. document the changes
4. create a test suite for the new design
5. select test cases for regression testing

::::
:::: {.column width=.65}

\centering
\includegraphics[width=\textwidth]{images/standards/standards04.eps}

::::
:::

# Implementation Phase

::: columns
:::: {.column width=.35}

**Activities:**
\footnotesize

- Writing new code and performing unit testing
- Integrating changed code
- Conducting integration and regression testing
- Performing risk analysis
- Reviewing the system for test-readiness

::::
:::: {.column width=.65}

\centering
\includegraphics[width=\textwidth]{images/standards/standards05.eps}

::::
:::

# System Test Phase

\footnotesize
Tests are performed on the full system to ensure that the modified system complies with the original requirements as well as the new modifications.

\vskip.5em

::: columns
:::: {.column width=.3}

**Activities**

- functionality testing
- robustness testing
- stability testing
- load testing
- performance testing
- security testing
- regression testing

::::
:::: {.column width=.7}

\centering
\includegraphics[width=\textwidth]{images/standards/standards06.eps}

::::
:::

# Acceptance Test Phase

\footnotesize
Testing is performed on a completely integrated system, and it involves customers, users, or their representatives

\vskip1em

::: columns
:::: {.column width=.3}

\footnotesize

* **Main objective:** assess the overall quality of the system, rather than actively identify defects
* Based on the customer's expectation from the system

::::
:::: {.column width=.7}

\centering
\includegraphics[width=\textwidth]{images/standards/standards07.eps}

::::
:::

# Delivery Phase

\footnotesize
In this phase the changed system is released to customers for installation and operation

\vskip1em

::: columns
:::: {.column width=.3}

\footnotesize
**Activities:**

- notify the user community
- perform installation and training
- develop an archival version of the system for backup

::::
:::: {.column width=.7}

\centering
\includegraphics[width=\textwidth]{images/standards/standards08.eps}

::::
:::

#

\centering
\vfill
\begin{minipage}{.775\textwidth}
\begin{minipage}{3.5em}
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge ISO/IEC 14764

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# ISO/IEC 14764 Maintenance Process

* ISO/IEC 14764 is an international standard for software maintenance

* It describes maintenance using the same concepts as IEEE/EIA 1219 except that they are depicted slightly differently.

* The basic structure of an ISO process is made up of activities, and an activity is made up of tasks.

* Upon an activation of the maintenance process, plans and procedures are developed and resources are allocated to carry out maintenance.

* In response to a changed request, code is modified in conjunction with the relevant documentation.

* Modification of the running software without losing the system's integrity is considered to be the overall objective of maintenance

# Iterative Maintenance Process

The maintenance process comprises the following high level activities:

::: columns
:::: column
1. Process Implementation
2. Problem and Modification Analysis
3. Modification Implementation
4. Maintenance Review and Acceptance
5. Migration
6. Retirement
::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/standards/standards09.eps}

::::
:::

# Process Implementation Activity

\footnotesize
The process implementation activity consists of three major tasks:

* Maintenance plan
* Modification requests (MR/CR)
* Configuration management

\centering
\vskip-2em
\includegraphics[width=.85\textwidth]{images/standards/standards10.eps}

# Maintenance Plan Template

\footnotesize
1. **Introduction**

   This section outlines the goals, purpose, and general scope of the maintenance effort. Also, deviations from the standard are identified.

2. **References**

   The documents that impose constraints on the maintenance effort are identified in this section.

   In addition, other documents supporting maintenance activities are identified.

3. **Definitions**

   All terms required to understand the maintenance plan are defined in this section.

   If some terms are already defined in other documents, then references are provided to those documents.


# Maintenance Plan Template

\footnotesize
4. **Software Maintenance Overview**

   This section briefly describes the following aspects of the maintenance process:

   4.1. Organization

   4.2. Scheduling Priorities

   4.3. Resource Summary

   4.4. Responsibilities

   4.5. Tools, Techniques, and Methods

# Maintenance Plan Template

\footnotesize
5. **Software Maintenance Process**

   This section describes the actions to be executed in each phase of the maintenance process.

   Each action is described in the form of input, output, process, and control

   5.1. Problem Identification/Classification and Prioritization

   5.2. Analysis

   5.3. Design

   5.4. Implementation

   5.5. System Testing

   5.6. Acceptance Testing

   5.7. Delivery

6. **Software Maintenance Reporting Requirements**

   This section briefly describes the process for gathering information and disseminating it to members of the maintenance organization

# Maintenance Plan Template

\footnotesize
7. **Software Maintenance Administrative Requirements**

   Describes the standard practices and rules for anomaly resolution and reporting

   7.1. Anomaly Resolution and Reporting

   7.2. Deviation Policy

   7.3. Control Procedures

   7.4. Standards, Practices, and Conventions

   7.5. Performance Tracking

   7.6. Quality Control Plan

8. **Software Maintenance Documentation Requirements**

   Describes the procedures to be followed in recording and presenting the outputs of the maintenance process

# Modification Request Task Steps

\footnotesize
1. Decide whether or not the maintainer is adequately staffed to make the proposed changes
2. Decide whether or not the maintenance program has received adequate budget
3. Decide whether or not enough resources are available and whether the proposed change will effect some current or future projects
4. Determine the operational issues to be considered
5. Determine handling priority
6. Classify the type of maintenance
7. Determine the impact to current and future users
8. Determine safety and security implications
9. Identify ripple effects

# Modification Request Task Steps

\footnotesize
10. Determine any hardware or software constraints that may result from the proposed changes
11. Estimate the values of the benefits of making the changes
12. Determine the impact on existing schedules
13. Document the risks resulting from the impact analysis
14. Estimate the evaluation to be performed
15. Estimate the cost of management to execute the modification
16. Place developed artifacts under CM

# Modification Analysis

::: columns
:::: {.column width=.25}

\footnotesize
**Tasks:**

- Modification request analysis
- Verification
- Options
- Documentation
- Approval

::::
:::: {.column width=.75}

\centering
\includegraphics[width=\textwidth]{images/standards/standards11.eps}

::::
:::

# Option Tasks

**Option Task Steps**

1. The MR is assigned a work priority
2. Explore a work-around for the problem. If a work-around exits, provide it to the user
3. Identify concrete requirements for the planned modification
4. Calculate the magnitude and size of the planned modification
5. Identify a variety of options to execute the planned modification
6. Estimate the impacts of the options on the users and system hardware
7. Analyze the risks of each option
8. Document the outcomes of risk analysis for each of the proposed options
9. Develop a widely acceptable plan to implement the modification

# Documentation Tasks

**Documentation Task Steps**

1. Ensure result analyses have been completed and documentation updated. If documentation does not exist, develop new documentation
2. For accuracy, review the planned strategy to perform tests and review the schedule
3. Review resource estimates for accuracy
4. Revise the database for storing accounting status
5. Describe a procedure to decide whether or not to approve the MR

# Modification Implementation Activity

In this activity, maintainers;

1. Identify the items to be modified
2. Execute a development process to actually implement the modifications

\centering
\includegraphics[width=.85\textwidth]{images/standards/standards12.eps}

# Maint Review/Acceptance Activity

By means of this activity it is ensured that:

1. the changes made to the software are correct
2. changes are made to the software according to accepted standards and methodologies

::: columns
:::: {.column width=.3}

\footnotesize
The activity is augmented with the following processes

1. quality management
2. product verification
3. product validation
4. product review

::::
:::: {.column width=.7}

\centering
\includegraphics[width=\textwidth]{images/standards/standards13.eps}

::::
:::

# Review Task

**Review Task Steps**

1. Track the MRs from requirement specification to coding
2. Ensure that the code is testable
3. Ensure that the code conforms to coding standards
4. Ensure that only the required software components were changed
5. Ensure that the new code is correctly integrated with the system
6. Ensure that documentation is accurately updated
7. CM personnel build software items for testing
8. Perform testing by an independent test organization
9. Perform system test on a fully integrated system
10. Develop test report

# Approval Task

**Approval Task Steps**

1. Obtain quality assurance approval
2. Verify that the process has been followed
3. CM prepares the delivery package
4. Conduct functional and physical configuration audit
5. Notify operators
7. Perform installation and training at the operator's facility

# Migration Activity

Migration is effected in two broad phases

1. identify the actions required to achieve migration
2. design and document the concrete steps to be execute to effect migration

\vskip-2em
\centering
\includegraphics[width=.75\textwidth]{images/standards/standards14.eps}

# Migration Plan Task

\footnotesize

1. Analyze the requirements for migration
2. Perform an impact analysis of migrating the software system
3. Make a schedule to execute migration
4. Determine all requirements for data collection to perform post-operation review
5. Identify and record the migration effort
6. Identify and reduce risks
7. Identify the required tools to support migration
8. Determine how the old environment is going to be supported

# Migration Plan Task

\footnotesize

9. Acquire and/or design new tools to support migration
10. Partition software products and data for conversion in an incremental manner
11. Prioritize the activities involving data conversion and software products
12. Execute software products and data conversions
13. Perform migration of software products and data to the new environment
14. Operate the migrated system and the old system in parallel as much as possible
15. Perform testing to ensure the success of migration
16. Should there be a need, continue to provide support for the old environment

# Operation Task

**Parallel Operations Task Steps**

1. Survey the site
2. Install hardware equipment
3. Install the software system
4. Run basic tests to ensure that hardware and software have been correctly installed
5. Run both the new and old systems in parallel, under the desired operational load.
6. Gather data from the old and the new systems.
7. Analyze the collected data

# Training Task

**Training Task Steps**

1. Identify the requirements for migration training
2. Schedule the requirements for migration training
3. Review the migration training
4. Update the plan to provide training

# Retirement Activity

::: columns
:::: {.column width=.3}

**Tasks:**

- Retirement plan
- Notification of intent
- Implement parallel operations and training
- Notification of completion
- Data archival

::::
:::: {.column width=.7}

\centering
\includegraphics[width=\textwidth]{images/standards/standards15.eps}

::::
:::

# Retirement Plan Task

1. Analyze the requirements to retire the systems
2. Determine what impacts that retiring the software will have
3. Identify a product that will replace the software to be retired
4. Make a schedule to retire the software
5. Determine the need for residual support in the future
6. Identify and describe the retirement effort

# For Next Time

::: columns
:::: column
* Review EVO Chapter 3.6 and 3.7
* Read EVO Chapter 3.8 - 3.9
* Watch Lecture 06
* Continue working on Homework 01
* **4423: Course Project Part 1: Team Selection is due Friday at 11:00 pm**
* **4423: Work on Homework 01**
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
