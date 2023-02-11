---
author:
- Isaac Griffith
title: Project Planning
institute: |
  CS 3321

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Topics Covered

* Software pricing
* Plan-driven development
* Project scheduling

# K-W-L

* Create a version of the following chart.

\footnotesize
\begin{center}
\begin{tabular}{|c|l|l|l|}
\hline
\textbf{Topic} & \textbf{K:} & \textbf{W:} & \textbf{L:}\tabularnewline
 & \textbf{What do you Know?} & \textbf{What do you want to know?} & \textbf{What did you learn?}\tabularnewline
\hline
Software Pricing &  &  & \tabularnewline
\hline
Plan-driven Dev &  &  & \tabularnewline
\hline
Project Scheduling &  &  & \tabularnewline
\hline
\end{tabular}
\end{center}
\small

* Ensure to add enough room in each row to answer the questions.
* Take **3 minutes** to answer the **K** and **W** questions, we will come back to **L** at the end of the lecture.

# Project planning

* Project planning involves breaking down the work into parts and assigning these to project team members, anticipating problems that might arise and preparing tentative solutions to those problems.

* The project plan, which is create at the start of a project, is used to communicate how the work will be done to the project team and customers, and to help assess progress on the project.

# Planning stages

* At the proposal stage, when you are bidding for a contract to develop or provide a software system
* During the project startup phase, when you have to plan who will work on the project, how the project will be broken down into increments, how resources will be allocated across your company, etc.
* Periodically throughout the project, when you modify your plan in the light of experience gained and information from monitoring the progress of the work.

# Proposal planning

* Planning may be necessary with only an outline of software requirements
* The aim of planning at this stage is to provide information that will be used in setting a price for the system to customers.
* Project pricing involves estimating how much the software will cost to develop, taking factors such as staff costs, hardware costs, software costs, etc. into account.

# Project startup planning

* At this stage, you know more about the system requirements but do not have design or implementation information
* Create a plan with enough detail to make decisions about the project budget and staffing.
  - This plan is the basis for project resource allocation
* The startup plan should also define project monitoring mechanisms
* A startup plan is still needed for agile development to allow resources to be allocated to the project.

# Development planning

* The project plan should be regularly amended as the project progresses and you know more about the software and its development.
* The project schedule, cost-estimate and risks have to be regularly revised.

#

\centering
\vfill
\Huge Software pricing

# Software pricing

* Estimates are made to discover the cost, to the developer, of producing a software system
  - You take into account, hardware, software, travel, training and effort costs.

* There is not a simple relationship between the development cost and the price charged to the customer.
* Broader organizational, economic, political and business considerations influence the price charged.

# Software pricing factors

\scriptsize
+---------------------------+---------------------------------------------------------------+
| **Factor**                | **Description**                                               |
+:==========================+:==============================================================+
| Contractual terms         | A customer may be willing to allow the developer to retain    |
|                           | ownership of the source code and reuse it in other projects.  |
|                           | The price charged may then be less than if the software       |
|                           | source code is handed over to the customer.\vskip.1em         |
+---------------------------+---------------------------------------------------------------+
| Cost estimate uncertainty | If an organization is unsure of its cost estimate, it may     |
|                           | increase its price by a contingency over and above its        |
|                           | normal profit.\vskip.1em                                      |
+---------------------------+---------------------------------------------------------------+
| Financial health          | Developers in financial difficulty may lower their price to   |
|                           | gain a contract. It is better to make a smaller than normal   |
|                           | profit or break even than to go out of business. Cash flow is |
|                           | more important than profit in difficult economic times.       |
+---------------------------+---------------------------------------------------------------+

# Software pricing factors

\scriptsize
+-------------------------+---------------------------------------------------------------+
| **Factor**              | **Description**                                               |
+:========================+:==============================================================+
| Market opportunity      | A development organization may quote a low price              |
|                         | because it wishes to move into a new segment of the           |
|                         | software market. Accepting a low profit on one project may    |
|                         | give the organization the opportunity to make a greater       |
|                         | profit later. The experience gained may also help it develop  |
|                         | new products.\vskip.1em                                       |
+-------------------------+---------------------------------------------------------------+
| Requirements volatility | If the requirements are likely to change, an organization     |
|                         | may lower its price to win a contract. After the contract is  |
|                         | awarded, high prices can be charged for changes to the        |
|                         | requirements.                                                 |
+-------------------------+---------------------------------------------------------------+

# Pricing strategies

* Under pricing
  - A company may under price a system in order to gain a contract that allows them to retain staff for future opportunities
  - A company may under price a system to gain access to a new market area

* Increased pricing
  - The price may be increased when a buyer wishes a fixed-price contract and so the seller increase the price to allow for unexpected risks.

# Pricing to win

* The software is priced according to what the software developer believes the buyer is willing to pay
* If this is less than the development costs, the software functionality may be reduced accordingly with a view to extra functionality being added an a later release.
* Additional costs may be added as the requirements change and these may be priced at a higher level to make up the shortfall in the original price.

# Write a Summary

* Lets take a break to summary what we learned about software pricing.
  - Take out a sheet of paper, use the paper already out, or use your laptop
  - Take **2 minutes**
  - Summarize the key ideas of software pricing **from your memory**.

#

\centering
\vfill
\Huge Plan-driven development

# Plan-driven development

* Plan-driven or plan-based development is an approach to software engineering where the development process is planned in detail
  - Plan-driven development is based on engineering project management techniques and is the 'traditional' way of managing large software development projects.

* A project plan is created that records the work to be done, who will do it, the development schedule and the work products.

* Managers use the plan to support project decision making and as a way of measuring progress.

# Plan-driven development -- pros and cons

* The arguments in favor of a plan-driven approach are that early planning allows organizational issues (availability of staff, other projects, etc.) to be closely taken into account, and that potential problems and dependencies are discovered before the project starts, rather than once the project is underway.

* The principal argument against plan-driven development is that many early decisions have to be revised because of changes to the environment in which the software is to be developed and used.

# Project plans

* In a plan-driven development project, a project plan sets out the resources available to the project, the work breakdown and a schedule for carrying out the work.

* Plan sections
  - Introduction
  - Project organization
  - Risk analysis
  - Hardware and software resource requirements
  - Work breakdown
  - Project schedule
  - Monitoring and reporting mechanisms

# Project plan supplements

\scriptsize
+-------------------------------+-------------------------------------------------------+
| **Plan**                      | **Description**                                       |
+:==============================+:======================================================+
| Configuration management plan | Describes the configuration management procedures     |
|                               | and structures to be used.\vskip.1em                  |
+-------------------------------+-------------------------------------------------------+
| Deployment plan               | Describes how the software and associated hardware    |
|                               | (if required) will be deployed in the customer’s      |
|                               | environment. This should include a plan for migrating |
|                               | data from existing systems.\vskip.1em                 |
+-------------------------------+-------------------------------------------------------+
| Maintenance plan              | Predicts the maintenance requirements, costs, and     |
|                               | effort.\vskip.1em                                     |
+-------------------------------+-------------------------------------------------------+
| Quality plan                  | Describes the quality procedures and standards that   |
|                               | will be used in a project.\vskip.1em                  |
+-------------------------------+-------------------------------------------------------+
| Validation plan               | Describes the approach, resources, and schedule used  |
|                               | for system validation.                                |
+-------------------------------+-------------------------------------------------------+

# The planning process

* Project planning is an iterative process that starts when you create an initial project plan during the project startup phase

* Plan changes are inevitable
  - As more information about the system and the project team becomes available during the project, you should regularly revise the plan to reflect requirements, schedule and risk changes.
  - Changing business goals also leads to changes in project plans. As business goals change, this could affect all projects, which may then have to be re-planned.

# The project planning process

\centering
\vfill
\includegraphics[width=.95\textwidth]{images/planning/planning01.eps}

# Planning assumptions

* You should make realistic rather than optimistic assumptions when you are defining a project plan.
* Problems of some description always arise during a project, and these lead to project delays.
* Your initial assumptions and scheduling should therefore take unexpected problems into account.
* You should include contingency in your plan so that if things go wrong, then your delivery schedule is not seriously disrupted.

# Risk mitigation

* If there are serious problems with the development work that are likely to lead to significant delays, you need to initiate risk mitigation actions to reduce the risks of project failure.
* In conjunction with these actions, you also have to re-plan the project
* This may involve renegotiating the project constraints and deliverables with the customer. A new schedule of when work should be completed also has to be established and agreed with the customer.

# Short Write

**Question:** Thinking about planning a software project would you want to prescribe an agile approach similar to scrum's planning game, or a more prescriptive approach as we have discussed today? Is this a blanket policy or one which would heavily depend upon the type of software to be developed and/or the organizational culture in which the development is to take place?

* Take a couple of minutes to contemplate your answer and then add it to the discussion at the provided link.
* Link: [https://www.kialo-edu.com/invited?token=005-ddca5016-0744-4184-b498-38f0e7f165f3](https://www.kialo-edu.com/invited?token=005-ddca5016-0744-4184-b498-38f0e7f165f3)

#

\centering
\vfill
\Huge Project Scheduling

# Project Scheduling

* Project scheduling is the process of deciding how the work in a project will be organized as separate tasks, and when and how these tasks will be executed.
* You estimate the calendar time needed to complete each task, the effort required and who will work on the tasks that have been identified.
* You also have to estimate the resources needed to complete each task, such as the disk space required on a server, the time required on specialized hardware, such as a simulator, and what the travel budget will be.

# Project scheduling activities

* Split project into tasks and estimate time and resources required to complete each task.
* Organize tasks concurrently to make optimal use of workforce
* Minimize task dependencies to avoid delays caused by one task waiting for another to complete.
* Dependent on project managers intuition and experience.

# The project scheduling process

\centering
\vfill
\includegraphics[width=.95\textwidth]{images/planning/planning02.eps}

# Scheduling problems

* Estimating the difficulty of problems and hence the cost of developing a solution is hard.
* Productivity is not proportional to the number of people working on a task.
* Adding people to a late project makes it later because of communication overheads.
* The unexpected always happens. Always allow contingency in planning.

# Schedule presentation

* Graphical notations are normally used to illustrate the project structure
* These show the project breakdown into tasks. Tasks should not be too small. They should take about a week or two.
* Calendar-based
  - Bar charts are the most commonly used representation for project schedules. They show the schedule as activities or resources agains time.
* Activity networks
  - Show task dependencies

# Project activities

* Project activities (tasks) are the basic planning element. Each activity has:
  - a duration in calendar days or months.
  - an effort estimation, which shows the number of person-days or person-months to complete the work,
  - a deadline by which the activity should be complete,
  - a defined end-point, which might be a document, the holding of a review meeting, the successful execution of all tests, etc.

# Milestones and deliverables

* Milestones are points in the schedule against which you can assess progress, for example, the handover of the system for testing
* Deliverables are work products that are delivered to the customer, e.g., a requirements document for the system.

# Tasks, durations, and dependencies

\scriptsize
+----------+--------------------------+---------------------+------------------+
| **Task** | **Effort (person-days)** | **Duration (days)** | **Dependencies** |
+:========:+:========================:+:===================:+:================:+
| T1       | 15                       | 10                  |                  |
+----------+--------------------------+---------------------+------------------+
| T2       | 8                        | 15                  |                  |
+----------+--------------------------+---------------------+------------------+
| T3       | 20                       | 15                  | T1 (M1)          |
+----------+--------------------------+---------------------+------------------+
| T4       | 5                        | 10                  |                  |
+----------+--------------------------+---------------------+------------------+
| T5       | 5                        | 10                  | T2, T4 (M3)      |
+----------+--------------------------+---------------------+------------------+
| T6       | 10                       | 5                   | T1, T2 (M4)      |
+----------+--------------------------+---------------------+------------------+
| T7       | 25                       | 20                  | T1 (M1)          |
+----------+--------------------------+---------------------+------------------+
| T8       | 75                       | 25                  | T4 (M2)          |
+----------+--------------------------+---------------------+------------------+
| T9       | 10                       | 15                  | T3, T6 (M5)      |
+----------+--------------------------+---------------------+------------------+
| T10      | 20                       | 15                  | T7, T8 (M5)      |
+----------+--------------------------+---------------------+------------------+
| T11      | 10                       | 10                  | T9 (M7)          |
+----------+--------------------------+---------------------+------------------+
| T12      | 20                       | 10                  | T10, T11 (M8)    |
+----------+--------------------------+---------------------+------------------+

# Activity bar chart

\centering
\vfill
\includegraphics[width=.65\textwidth]{images/planning/planning03.eps}

# Staff allocation chart

\centering
\vfill
\includegraphics[width=.65\textwidth]{images/planning/planning04.eps}

# K-W-L Closure

* Return to the chart you created at the beginning of this lecture

\footnotesize
\begin{center}
\begin{tabular}{|c|l|l|l|}
\hline
\textbf{Topic} & \textbf{K:} & \textbf{W:} & \textbf{L:}\tabularnewline
 & \textbf{What do you Know?} & \textbf{What do you want to know?} & \textbf{What did you learn?}\tabularnewline
\hline
Software Pricing &  &  & \tabularnewline
\hline
Plan-driven Dev &  &  & \tabularnewline
\hline
Project Scheduling &  &  & \tabularnewline
\hline
\end{tabular}
\end{center}
\small

* Take the remaining **3 minutes** to answer the **L** question for each topic.

# Key points

* The price charged for a system does not just depend on its estimated development costs and the profit required by the development company. Organizational factors may mean that the price is increased to compensate for increased risk or decreased to gain competitive advantage.

* Software is often priced to gain a contract and the functionality of the system is then adjusted to meet the estimated price.

* Plan-driven development is organized around a complete project plan that defines the project activities, the planned effort, the activity schedule and who is responsible for each activity.

# Key points

* Project scheduling involves the creation of various graphical representations of part of the project plan. Bar charts, which show the activity duration and staffing timelines, are the most commonly used schedule representations.

* A project milestone is a predictable outcome of an activity or set of activities. At each milestone, a formal report of progress should be presented to management. A deliverable is a work product that is delivered to the project customer.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
