---
author:
- Isaac Griffith
title: Legacy Systems - Basic Migration Methods
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
* Understand and be able to describe the following basic methods for Legacy System migration
  - Cold Turkey
  - Database First
  - Database Last
  - Composite Database
  - Chicken Little
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
\begin{minipage}{.65\textwidth}
\begin{minipage}{3.5em}
\vskip-3em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge Basic Migration Methods
\vskip-0.75em
\rule{.975\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 6630}
\end{minipage}
\end{minipage}

# Migration Methods

* No single migration approach applies to all legacy systems, as they vary in
  - scale
  - complexity
  - risk of failure
* The seven approaches are as follows:
  - **Cold turkey**
  - **Database first**
  - **Database last**
  - **Composite database**
  - **Chicken little**
  - Butterfly
  - Iterative

# Cold Turkey

* aka the **Big Bang approach**
* Involves redesigning and recoding the LIS from the very beginning using:
  - a new execution platform
  - modern software architecture
  - new tools and databases.
* Due to the complexity
  - the renovated system must include many new features + the original functionality
  - the risk of failure is high
* Only use this approach for legacy systems that are
  - stable
  - well-defined functionality
  - small in size

# Database First

\footnotesize
* aka **forward migration method**
  1. migrate the database and data to a modern DBMS
  2. gradually migrates the program
* During migration:
  - LIS operates with the new system via a **forward gateway** while legacy components are migrated
    * A software module which mediates among operational software components

::: columns
:::: column

* This approach allows for:
  - LIS applications to access the database on the target side
  - The forward gateway to translate legacy calls to target calls
  - Translate target database outputs for use by the legacy system

::::
:::: column

\vskip-1em
\centering
\includegraphics[width=\textwidth]{../../../images/part02/legacy/legacy06.eps}

::::
:::

# Database First

\footnotesize
* **Benefits:**
  * \scriptsize Data is migrated first leading to improved productivity
  * \scriptsize Legacy system operates concurrently with migrated components
* **Drawbacks:**
  1. \scriptsize only applicable to a completely decomposable legacy system, with a clean interface to the legacy database
  2. \scriptsize the new database structure must be defined before migration can begin
  3. \scriptsize it is difficult to construct the forward gateway

* **System types:**
  - \scriptsize \color{Roarange}\textbf{decomposable} \color{Black} - the user and system interfaces, applications, and databases are considered to be distinct components connected by clearly defined interfaces.
  - \scriptsize \color{Roarange}\textbf{semidecomposable} \color{Black} - only the user and the system interfaces are separate components; the database service and applications are inseparable.
  - \scriptsize \color{Roarange}\textbf{nondecomposable} \color{Black} - one where no functional components can be separated

# Database Last

* Suitable only for a fully decomposable LIS.
* In this approach
  - legacy applications are incrementally migrated to the target platform
  - the legacy database is done last

::: columns
:::: column

* Target applications access the LIS database via a **reverse gateway**
  - translates new applications calls into legacy database calls
  - supports interoperability between LIS and Target systems

::::
:::: column

\centering
\includegraphics[width=.95\textwidth]{../../../images/part02/legacy/legacy07.eps}


::::
:::

# Database Last

* Main issues with this approach:
  1. Performance is reduced: schema mapping of the target database to the legacy database can be slow
  2. Legacy database may not support useful features of relational databases
     - triggers
     - integrity
     - constraints

# Composite Database

\footnotesize
* Applicable to all types of LIS.
* In this approach:
  - \scriptsize the target system and LIS operate in parallel during migration
    - \tiny forming a composite system through a combination of forward and reverse gateways
  - \scriptsize Initially, the target system is small, but will grow as migration continues
  - \scriptsize At completion, target system provides all functionality

::: columns
:::: column

\footnotesize
* Approach employs a **Transaction Co-ordinator**
  - \scriptsize Allows data duplication across both databases
  - \scriptsize Maintains data integrity
  - \scriptsize Intercepts update requests from both applications to determine if it refer replicated data
    * \tiny If so, propagates update to both the databases using a two-phase commit protocol.
::::
:::: column

\centering
\includegraphics[width=\textwidth]{../../../images/part02/legacy/legacy08.eps}

::::
:::

# Chicken Little

\footnotesize
* Refines the composite database strategy
  - proposing migration solutions for fully decomposable, semidecomposable, and nondecomposable legacy systems with different kinds of gateways.
  - The differences between those gateways are based upon:
    1. \scriptsize the locations of the gateways in the system; and
    2. \scriptsize the degree of functionality of the gateways.
  - Still maintains concurrent operation of the target and legacy systems during the migration
  - Data is stored in both the migrating legacy system and the evolving target system
* Decomposable LIS:
  - **database gateway:** located between the database service and the application modules
    * can be either a forward gateway or a reverse gateway.

# Chicken Little

* Semidecomposable LIS:
  * **Application gateway** - located between user and system interfaces and the legacy application.
  * Encapsulates from the applications down (from the perspective of interfaces)

\centering
\includegraphics[width=0.85\textwidth]{../../../images/part02/legacy/legacy09.eps}

# Chicken Little

\footnotesize
* Nondecomposable systems LIS
  - \scriptsize \textbf{Information systems gateway} - located between user and other information systems and LIS
  - \scriptsize The entire functionality of the legacy system is encapsulated
    * \tiny Differs from an application gateway which only encapsulates from the application module down.

\centering
\includegraphics[width=0.65\textwidth]{../../../images/part02/legacy/legacy10.eps}

# Chicken Little

\footnotesize
* The Chicken little methodology proposes an 11-step incremental migration strategy
  * For each component to be migrated all steps are executed
  * The process is repeated for each increment

\scriptsize
+--------------+---------------------------------------------------------------------+
| **Step**     | **Description**                                                     |
+:=============+:====================================================================+
| **Step 1:**  | Incrementally analyze the LIS                                       |
+--------------+---------------------------------------------------------------------+
| **Step 2:**  | Incrementally decompose the structure of the LIS                    |
+--------------+---------------------------------------------------------------------+
| **Step 3:**  | Design the interfaces of the target system in an incremental manner |
+--------------+---------------------------------------------------------------------+
| **Step 4:**  | Build the target applications in an incremental manner              |
+--------------+---------------------------------------------------------------------+
| **Step 5:**  | Design the database in an incremental manner                        |
+--------------+---------------------------------------------------------------------+
| **Step 6:**  | Install the target environment in an incremental manner             |
+--------------+---------------------------------------------------------------------+
| **Step 7:**  | Create and install the necessary gateways in an incremental manner  |
+--------------+---------------------------------------------------------------------+
| **Step 8:**  | Migrate the databases in an incremental manner                      |
+--------------+---------------------------------------------------------------------+
| **Step 9:**  | Migrate the legacy applications in an incremental manner            |
+--------------+---------------------------------------------------------------------+
| **Step 10:** | Migrate the legacy interfaces in an incremental manner              |
+--------------+---------------------------------------------------------------------+
| **Step 11:** | Cut over to the target system in an incremental manner              |
+--------------+---------------------------------------------------------------------+



# For Next Time

::: columns
:::: {.column width=.6}
\footnotesize
* Review EVO Chapter 5.5.1 - 5.5.5
* Read EVO Chapter 5.5.6 - 5.6 and 6.1 - 6.2
* Watch Lecture 13
* **4423:**
  - \scriptsize Weekly Quiz due 2/7 @ 11:00 pm
  - \scriptsize Start on Homework 02
* **4423 Project:**
  - \scriptsize Course Project Part 2: System Selection is due 2/5 @ 11:00 pm
  - \scriptsize Team Evaluation Part 2 is due 2/7 @ 11:00 pm
* **5523:**
  - \scriptsize Project Topic Selection Report is due 2/5 @ 11:00 pm
  - \scriptsize Project Topic Selection Lightning Talk is due 2/5 @ 11:00 pm
  - \scriptsize Paper Review 02 is due 2/7 @ 11:00 pm
::::
:::: {.column width=.4}
\centering
\includegraphics[width=.85\textwidth]{../../../images/next_time.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{../../../images/questions.png}

\Huge \textbf{Are there any questions?}
