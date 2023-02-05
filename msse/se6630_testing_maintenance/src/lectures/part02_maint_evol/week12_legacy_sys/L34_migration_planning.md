---
author:
- Isaac Griffith
title: Legacy Systems - Migration and Migration Planning
institute: |
  SE 6630 - Software Testing, Maintenance, and Evolution

  Department of Software Engineering

  Idaho State University
fontsize: 12pt
cornerLogo: "../../../images/spirit.png"
wideLogo: "../../../images/wide.png"
lowerCornerLogo: "../../../images/roar.eps"
...

# Outcomes

After today's lecture you will:

::: columns
:::: {.column width=.7}
* Be able to describe the basic approaches for migrating legacy systems
* Be able to describe the process and activities involved in planning a legacy system migration
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{../../../images/brain-gears.jpg}
::::
:::

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.65\textwidth}
\Huge Migration
\vskip-0.75em
\rule{0.85\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 6630}
\end{minipage}
\end{minipage}

# Migration

* Migration of LIS is the best alternative
  - when wrapping is unsuitable, and
  - redevelopment is not acceptable due to substantial risk
* Very complex process typically lasting 5 - 10 years.
* Benefits:
  - improved system understanding
  - easier maintenance
  - reduced cost
  - more flexibility for future requirements.

# Migration

* Migration involves changes, including:
  - restructuring the system
  - enhancing system functionality
  - modifying system attributes.
* Yet it retains the basic system functionality
* LIS migration involves
  - creation of a modern database from the legacy database
  - adaptation of the application program components

# Migration

* In general, migration comprises three main steps:
  1. conversion of the existing schema to a target schema
     - conversion of data
     - conversion of program
  2. Testing and functionality
  3. Cut over (or roll over)

# Schema Conversion

* **Schema conversion**
  - translating a legacy database schema into an equivalent database structure in a new technology.
* This requires two processes.
  1. **DBRE** - to recover the conceptual schema that express the semantics of the source data
  2. Derive the target physical schema from this conceptual schema:
     - Extract an equivalent logical schema the conceptual schema via transformations
     - Extract a physical schema from the logical schema via transformations.

# Data Conversion

* **Data conversion** - transferring data from the legacy database to the target database
* Data conversion requires three steps (ETL):
  1. **Extract** data from the legacy store
  2. **Transform** the extracted data so that their structures match the format
     - Perform data cleansing to fix or discard data that do not fit the target database
  3. **Load** the transformed data in the target database

# Program Conversion

* **Program conversion** - modifying a program to access the migrated database instead of the legacy data.
* While ensuring the LIS functionality is unchanged
* Depends upon the rules used to transform the legacy schema into the target schema.

# Testing and Functionality

* We must ensure that the outputs of the target system are consistent with those of the LIS.
* No new functionality should be introduced during migration
* Same functionality = Verifiability.

\pause
\vfill

##

\centering
\Large In practice, migration projects often add new functionalities (to justify expense)

# Cut Over

* **Cutting over** - shifting to the new system from the old one
  - required to cause minimal disruption to the business process
* There are three kinds of transition strategies.
  - \color{Roarange}\textbf{Cut-and-Run:} \color{Black} simply switch off the legacy system and turn on the new system
  - \color{Roarange}\textbf{Phased Interoperability:} \color{Black} gradually cut-over performed in incremental steps
  - \color{Roarange}\textbf{Parallel Operation:} \color{Black} The target system and the LIS operate at the same time
    - Once the new system is considered to be reliable, the LIS is taken off service.

\pause
\vfill

##

\centering
\Large In practice, a combination of these strategies is used

#

\centering
\vfill
\begin{minipage}{.775\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge Migration Planning
\vskip-0.75em
\rule{.925\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 6630}
\end{minipage}
\end{minipage}

# Migration Planning

\color{Roarange}\textbf{Migration planning comprises 13 steps:}\color{Black}

\scriptsize

::: columns
:::: column
1. Perform portfolio analysis
2. Identify the stakeholders
3. Understand the requirements
4. Create a business case
5. Make a go or no-go decision
6. Understand the LIS
7. Understand the target technology
::::
:::: column
8. Evaluate the available technologies
9. Define the target architecture
10. Define a strategy
11. Reconcile the strategy with the needs of the stakeholder
12. Determine the resources required
13. Evaluate the feasibility of the strategy
::::
:::

# 1. Perform Portfolio Analysis

\footnotesize

* **Portfolio analysis** - establish measures of technical quality and business value for a set of software systems
  - \scriptsize Using identified metrics with min/max thresholds scaled between 0.0 and 1.0

::: columns
:::: {.column width=.6}

* Represented on a chi-square chart, where

  - \scriptsize \textbf{Quadrant 1:} Systems with low technical quality and low business value
    - \tiny Candidates for replacement with a commercial product, if one is available.

  - \scriptsize \textbf{Quadrant 2:} Systems with high technical quality but low business value
    - \tiny Can be left alone

  - \scriptsize \textbf{Quadrant 3:} Systems with high technical quality and high business value
    - \tiny Candidates for active evolution

  - \scriptsize \textbf{Quadrant 4:} Systems with low technical quality but high business value
    - \tiny Candidate for redevelopment or migration

::::
:::: {.column width=.4}

\centering
\includegraphics[width=0.65\textwidth]{../../../images/part02/legacy/legacy05.eps}

::::
:::

# 2. Identify the stakeholders

* **Stakeholders** - the people or organizations that influence a system’s behavior, or those who are impacted by the system.
  - System architects
  - Developers
  - Maintainers
  - Managers
  - Customers
  - End users
* They judge the outcome and impact of the migration project
  * Bring their own perspectives to the table
  * Necessary to obtain their agreement and support

# 3. Understand the requirements

* **Requirements** - a description of the needs and desires of stakeholders that a system is expected to implement
* There are two challenges in defining requirements.
  1. ensure that the right requirements are captured.
  2. express the requirements in such a way that the stakeholders can easily review and confirm their correctness.
* Thus we need to
  - Capture requirements in an unambiguous representation
  - Store this representation in a database
  - Make the database available to stakeholders
* Requirements can come from:
  - Legacy Information System
  - Business Process Reengineering
  - Stakeholders

# 4. Create a business case

\footnotesize
* The business case allows executive management to decide whether the migration project
  - Will increase quality
  - Reduce maintenance costs
  - Be financially viable.
* In general, a good business case provides the following information about the migration project:
  - \scriptsize Problem statement
  - \scriptsize Solution
  - \scriptsize Risks and Benefits.


# 4. Create a business case
\scriptsize
+---------------------------------+------------------------------------------------------------------------+
| **Objective**                   | **Sample quantifiable benefit metrics**                                |
+:================================+:=======================================================================+
| Lower maintenance cost          | Average cycle time to close problem reports                            |
+---------------------------------+------------------------------------------------------------------------+
|                                 | Average labor hours to close problem reports                           |
+---------------------------------+------------------------------------------------------------------------+
|                                 | Total staff consensus                                                  |
+---------------------------------+------------------------------------------------------------------------+
|                                 | Average problem-report backlog                                         |
+---------------------------------+------------------------------------------------------------------------+
|                                 | Post-release fix rework hours                                          |
+---------------------------------+------------------------------------------------------------------------+
| Add new functionality           | Count of new functions added to the product                            |
+---------------------------------+------------------------------------------------------------------------+
|                                 | Value added or revenue generated by new functions                      |
+---------------------------------+------------------------------------------------------------------------+
| Increase performance            | Number of delivered operations, such as transactions, per unit time    |
+---------------------------------+------------------------------------------------------------------------+
| Replace old equipment           | Net annualized cost of purchase and maintenance                        |
+---------------------------------+------------------------------------------------------------------------+
| Recode in different languages   | Number of modules in each programming language                         |
+---------------------------------+------------------------------------------------------------------------+
| Reuse of existing artifacts     | Number of artifacts used in other products                             |
+---------------------------------+------------------------------------------------------------------------+
| Data rationalization            | Number of redundant database objects removed                           |
+---------------------------------+------------------------------------------------------------------------+
| Integrate disjoint applications | Number of unified applications accessible to users                     |
+---------------------------------+------------------------------------------------------------------------+
|                                 | Measures of usability and training time required for application suite |
+---------------------------------+------------------------------------------------------------------------+

# Business Case in hand

**Step 5: Make a go or no-go decision**

* It is reviewed by the stakeholders
* If deemed unsatisfactory, the migration project is terminated
* Otherwise,

**Step 6. Understand the LIS**

* We then work to understand the LIS
  - considered essential to project success
* Techniques available to meet this challenge
  - Program comprehension
  - Reverse engineering.

# 7. Understand target technology

\footnotesize
* Can proceed in **parallel with Step 6**, as we need to understand both
  - \scriptsize The technologies that can be used in the migration effort
  - \scriptsize The technologies that have been used in the legacy system
* In general, four types of technologies are of interest to the migration effort:
  1. \scriptsize \textbf{Languages and DBMS available}
  2. \scriptsize \textbf{Distributed transaction models}
     - \tiny distributed communication technologies
     - \tiny transaction technologies
  3. \scriptsize \textbf{Middleware technologies and standards}
  4. \scriptsize \textbf{Tools that are available to assist in migration of the LIS}

# Technology & Architecture

**Step 8. Evaluate available technologies**

* Compare and contrast available technologies and their capabilities
  - If the capabilities overlap: appraise these technologies for the QoS applicable to the migration process
  - Results inform the architecture and design of the new system

**Step 9. Define target architecture**

* **Target architecture** - the desired architecture of the new system
  - Models the stakeholders’ vision of the new system
  - Should be modeled using different views at different levels of granularity
  - Likely to evolve during the migration process
  - Should be continually reevaluated and updated during the migration process

# 10. Define a strategy

\footnotesize
* **Strategy** - defines the overall process of transforming the LIS to the new system, including:
  - \scriptsize Migration methodology
    - \tiny Schema conversion
    - \tiny Data conversion
    - \tiny Program conversion
    - \tiny Testing
* Mission-critical legacy systems deployment tends to be risky
  - \scriptsize It should be evolved incrementally to the new system

# 10. Define a strategy

* During migration many things can change and must be accommodated for, this includes:
  - \scriptsize user requirements
  - \scriptsize system knowledge
  - \scriptsize technology
* To accommodate these changes, a migration strategy need to:
  - \scriptsize minimize risk
  - \scriptsize minimize development and deployment costs
  - \scriptsize support an aggressive but reliable schedule
  - \scriptsize meet system quality expectations.

# 11. Reconcile stakeholder needs

* Before implementation stakeholder consensus is needed
  - The strategy then needs to be reconciled to stakeholder's needs
  - Stakeholder's are then briefed on:
    - The approach
    - The target architecture
    - The strategy.
* They evaluates the strategy and provides input for the final consensus profile

# 12. Determine resources required

* Estimate project resources and cost
  - Can use a variety of estimation approaches, but a good one is COCOMO II
  - COCOMO II addresses:
    - non-sequential process models
    - reengineering work
    - reuse-driven approaches
  - The COCOMO II model provides
    - estimates of effort
    - schedule by phases
    - staffing by phases and activities.

# 13. Evaluate strategy feasibility

* At this point management should have an understanding of:
  - System under migration
  - Available technology options
  - Target architecture
  - Migration strategy
  - Cost of migration
  - Migration schedule
* Management now determines strategy feasibility
  - If found viable -> the migration plan is finalized
  - Otherwise -> a detailed report is produced, and we can revise until:
    1. a feasible approach is identified, or
    2. no feasible approach is identified and the project is terminated

# For Next Time

::: columns
:::: column
* Review EVO Chapter 5.3 - 5.4
* Read EVO Chapter 5.4 - 5.6
* Watch Lecture 12
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{../../../images/next_time.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{../../../images/questions.png}

\Huge \textbf{Are there any questions?}
