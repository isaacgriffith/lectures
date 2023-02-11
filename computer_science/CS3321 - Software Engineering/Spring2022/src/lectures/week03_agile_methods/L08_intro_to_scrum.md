---
author:
- Dr. Isaac Griffith
title: Introduction to Scrum
institute: |
  CS 3321

  Department of Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

After today's lecture you will:

::: columns
:::: {.column width=.7}
* Have a deeper understanding of Scrum
* See how scrum is essentialized
* See what it takes to use Scrum in practice
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears.jpg}
::::
:::

# What is Scrum?

* Scrum is currently the most popular agile practice at the time of this writing.
* Jeff Sutherland and Ken Schwaber created Scrum to get teams to work iteratively and to collaborate more effectively by following a number of practical and proven activities.

# Scrum Overview

\vskip-1em
\centering
\includegraphics[width=.75\textwidth]{images/Scrum/slide3.eps}

# Scrum Team

\vskip-1em
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide4.eps}
\end{center}

Scrum targets a small development team with about 7 plus or minus 2 members working together

# Scrum Elements

\vskip-1em
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide5.eps}
\end{center}

The **Product Backlog** is an ordered list of things to do, sorted by importance. It is made up of *Product Backlog Items (PBIs)*

* PBI: a piece of a requirement, needed improvements, or even defects to be fixed

# Scrum Roles in Detail

* **Team members:** cross-functional people responsible for estimating the effort for implementing PBIs and, of course, develop them.
* **Product Owner (PO):** incarnates the Client’s vision,  is responsible for feeding the Product Backlog based on his interaction with customers and users. He also prioritizes the PBIs
* **Scrum master (SM):** a servant leader, a person who facilitates the Scrum activities and motivates the team members to follow the Scrum activities. (problem-solver, team defender)

# Scrum Elements

\vskip-1em
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide7.eps}
\end{center}

The PBIs are moved from the PRoduct Backlog to the **Sprint Backlog** by the whole team during **Sprint Planning**.
* Sprint planning determines what can be delivered in the next iteration (and how)

# Scrum Elements

\vskip-1em
\begin{center}
\includegraphics[width=.65\textwidth]{images/Scrum/slide8.eps}
\end{center}

* **Sprint:** a fixed length period of time, usually 1 - 4 weeks, during which the team meets a certain goal.
* **Potentially Shippable Increment:** A usable increment of the product produced as part of the goal of a sprint.

# Scrum Elements

\vskip-1.5em
\begin{center}
\includegraphics[width=.60\textwidth]{images/Scrum/slide10.eps}
\end{center}

* **Daily Standup:** a meeting performed each day by the team, usually no longer than 15 minutes.
  - Each team member explains the following:
    * What he/she did since the last meeting
    * What he/she plans to do today
    * What is getting in his/her way

# Scrum and Scrum Lite

* Scrum is a set of practices, i.e., a repeatable systematic and verifiable approach to doing something with a specific purpose in mind.

* Scrum focuses on improving team collaborations and performance in order to conduct iterative development in a collaborative manner.

* Scrum is not simple
  - Thus, we introduce a simplified version called **Scrum Lite**
  - This captures the core elements of Scrum

# Scrum

\begin{center}
\includegraphics[width=.85\textwidth]{images/Scrum/slide10.eps}
\end{center}

# Essence Elements within Scrum

\begin{center}
\includegraphics[width=.85\textwidth]{images/Scrum/slide13.eps}
\end{center}

# Scrum Lite Practice

\begin{center}
\includegraphics[width=.65\textwidth]{images/Scrum/slide14.eps}
\end{center}

# Scrum Lite Alphas: Sprint

::: columns
:::: column

A time-box of one month or less during which a _"Done"_, usable and potentially shippable Product Increment is created. A new Sprint starts immediately after the conclusion of the previous Sprint.

::::
:::: column

\vspace{-2em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide16.png}
\end{center}

::::
:::

# Scrum Lite Alphas: Sprint States

\begin{center}
\includegraphics[width=.85\textwidth]{images/Scrum/slide17.eps}
\end{center}

# Scrum Lite Alphas: PBI

::: columns
:::: column

**Product Backlog Item**: A change to be made to the product in a future release (for example a feature, user story, requirement, enhancement, or fix).

::::
:::: column

\vspace{-2em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide18.png}
\end{center}

::::
:::

# SL Work Products: Product Backlog

::: columns
:::: column

A priority ordered list of everything that might be needed in the product. The single source of requirements for any changes to be made to the product.

::::
:::: column

\vspace{-2em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide19.png}
\end{center}

::::
:::

# SL Work Products: Sprint Backlog

::: columns
:::: column

The set of PBIs selected for the Sprint, plus a plan for delivering the Increment and realizing the Sprint Goal. The Sprint Backlog makes visible all of the work the Development Team identifies as necessary to fulfill the Sprint Goal.

::::
:::: column

\vspace{-2em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide20.png}
\end{center}

::::
:::

# SL Work Products: Increment

::: columns
:::: column

The sum of all PBIs completed during a Sprint and value of the Increments of all previous Sprints

::::
:::: column

\vspace{-2em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide21.png}
\end{center}

::::
:::

# Scrum Lite Elements: Roles

* Scrum Lite identifies two explit roles:
  - **Product Owner**
  - **Scrum Master**

* A role is a list of responsibilities that one or more people accept.

* The individuals serving as *Product Owner* and *Scrum Master* and the rest of the team members form the **Scrum Team**

* Essence allows us to model roles and team organization as *patterns*

# SL Pattern: Product Owner

::: columns
:::: column

The Product Owner is the sole person responsible for managing the Product Backlog

\only<2>{
\textbf{Duties include:}

\footnotesize

\begin{itemize}
\item Clearly expressing Product Backlog items
\item Ordering the items to best achieve goals and missions
\item Optimizing (maximizing) the value of the work the Development Team performs
\item Ensuring that the Product Backlog is visible, transparent, and clear to all, and shows what the Scrum Team will work on next
\item Ensuring the Development Team understand items in the Product Backlog
\end{itemize}
}

::::
:::: column

\vspace{-2em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide23.png}
\end{center}

::::
:::

# SL Pattern: Scrum Master

::: columns
:::: column

* The Scrum Master is responsible for ensuring that Scrum is understood and enacted.

* The Scrum Master is the servant leader for the Scrum Team

\only<2>{
\textbf{Duties include:}

\footnotesize

\begin{itemize}
\item Guide Scrum activities
\item Remove impediments
\item Ensure everyone understands Scrum
\item Promote agility
\end{itemize}
}

::::
:::: column

\vspace{-2em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide25.png}
\end{center}

::::
:::

# SL Pattern: Strum Team

::: columns
:::: column

* The Scrum Team consists of:
  - A Product Owner
  - A Scrum Master
  - The Development Team
* Scrum Teams deliver products iteratively and incrementally, maximizing opportunities for feedback on how they are doing and self-improvement

* The best Scrum Team size is small enough to remain nimble but large enough to complete all significant work within a Sprint

::::
:::: column

\vspace{-2em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide27.png}
\end{center}

::::
:::

# Kickstarting Scrum Lite

* Create Team
* Assign Roles (Product Owner, Scrum Master)
* Define Activity Details:
  - Sprint Schedule
  - Sprint Planning
  - Daily Scrum
  - Sprint Review
  - Sprint Retorspective
* Start Scrumming

# SL Activities: Sprint Planning

::: columns
:::: column

* Decide what can be delivered in the Sprint's Increment and how the work needed to be delivered by the agreed time will be achieved.
* **Note**: This is more than simply picking PBIs from the backlog!

::::
:::: column

\vspace{-2em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide29.png}
\end{center}

::::
:::

# SL Activities: Sprint Planning

::: columns
:::: column

Possible Team Questions:

1. Were the items selected for this sprint properly prepared?
2. Could the developers estimate each item?
3. Has the team considered their capacity when deciding if they could commit to the proposed items to complete in this sprint?
4. Are our team members experienced enough to know to ask the preceding questions?

::::
:::: column

\vspace{-2em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide29.png}
\end{center}

::::
:::

# SL Activities: Daily Scrum

::: columns
:::: column

* A simple activity that helps the team keep the Work Under Control

* Guiding Principles:
  - keep the meeting to 15 minutes
  - only the developers speak
  - answer the three main questions:
    * What did I do since the last daily scrum?
    * What do I plan to do next?
    * What osbstacles am I facing?

::::
:::: column

\vspace{-2em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide31.png}
\end{center}

::::
:::

# SL Activities: Sprint Review

::: columns
:::: column

* A review of the product by the stakeholders. The focus is demonstrating what the team produced based on what they **committed to produce**

* Teams do not take "partial credit" for completing part of a backlog item. The product owner explains this during the sprint review and how to address the missing item. The sprint review is also an opportunity to get valuable feedback from the  stakeholders.

::::
:::: column

\vspace{-2em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide32.png}
\end{center}

::::
:::

# SL Activities: Sprint Retrospective

::: columns
:::: column

* The goal isto review how they are doing on their endeavor from the perspective of their agreed to method, and to agree to improvements to their method to do in the next sprint.

* The results of these improvements can be tacit or explicit, which means they may or may not require changes to practice descriptions.

::::
:::: column

\vspace{-2em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Scrum/slide33.png}
\end{center}

::::
:::

# SL Activities: Sprint Retrospective

* A Sprint Retrospective could be represented in the Essence language as an activity within a larger practice, such as Scrum, or as a practice itself.

* Many organizations break their retrospectives out as a separate practice and include in the practice criteria to help teams select practical improvements that can be implemented within the next sprint.

* One example is the **SMART** criteria, which stands for:
  - Small
  - Measurable
  - Attainable
  - Relevant
  - Testable

* These attributes are intended to be used by teams to help them assess if their agreed to improvements can be implemented within the next sprint.

# SL Essentialized: Impact

* Scrum essentialization helps you to focus on the essentials of Scrum in two important ways
  1. Calling out the most important parts of the practice
  2. Making explicit what these important parts are

# SL Essentialized: Impact

* Example: activity spaces populated by Scrum Lite Activities
  - Note: SL only occupies some activity spaces in the endeavor area of concern.
    * In particular, "Stop the Work" is empty


\begin{center}
\includegraphics[width=.85\textwidth]{images/Scrum/slide37.eps}
\end{center}

# SL Essentialized: Impact

* Likewise, Scrum Lite (and Scrum as well) does not provide any guidance on other ares of concern
  - (i.e., the costomer or solution area)

# For Next Time

::: columns
:::: column
* Review this lecture
* Review this video
* Come to class
* Watch the next lecture
* Complete Quiz 02
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
