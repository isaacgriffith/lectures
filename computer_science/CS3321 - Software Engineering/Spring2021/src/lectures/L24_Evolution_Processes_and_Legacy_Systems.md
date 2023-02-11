---
author:
- Isaac Griffith
title: Evolution Process and Legacy Systems
institute: |
  CS 3321

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Topics covered

* Evolution processes
* Legacy systems

# Software change

* Software change is inevitable
  - New requirements emerge when the software is used;
  - The business environment changes;
  - Errors must be repaired;
  - New computers and equipment is added to the system;
  - The performance or reliability of the system may have to be improved.
* A key problem for all organizations is implementing and managing change to their existing software systems.

# Importance of evolution

* Organizations have huge investments in their software systems - they are critical business assets.
* To maintain the value of these assets to the business, they must be changed and updated.
* The majority of the software budget in large companies is devoted to changing and evolving existing software rather than developing new software.

# The spiral model

\begin{center}
\includegraphics[width=.65\textwidth]{images/evolution/evolution01.eps}
\end{center}

# Evolution and servicing

\begin{center}
\includegraphics[width=.85\textwidth]{images/evolution/evolution02.eps}
\end{center}

# Evolution and servicing

* Evolution
  - The stage in a software system’s life cycle where it is in operational use and is evolving as new requirements are proposed and implemented in the system.
* Servicing
  - At this stage, the software remains useful but the only changes made are those required to keep it operational i.e. bug fixes and changes to reflect changes in the software’s environment. No new functionality is added.
* Phase-out
  - The software may still be used but no further changes are made to it.

#

\centering
\vfill
\Huge Evolution processes

# Evolution processes

* Software evolution processes depend on
  - The type of software being maintained;
  - The development processes used;
  - The skills and experience of the people involved.
* Proposals for change are the driver for system evolution.
  - Should be linked with components that are affected by the change, thus allowing the cost and impact of the change to be estimated.
* Change identification and evolution continues throughout the system lifetime.

# Change identification and evolution processes

\begin{center}
\includegraphics[width=.65\textwidth]{images/evolution/evolution03.eps}
\end{center}

# The software evolution process

\begin{center}
\includegraphics[width=.85\textwidth]{images/evolution/evolution04.eps}
\end{center}

# Change implementation

\begin{center}
\includegraphics[width=.85\textwidth]{images/evolution/evolution05.eps}
\end{center}

# Change implementation

* Iteration of the development process where the revisions to the system are designed, implemented and tested.
* A critical difference is that the first stage of change implementation may involve program understanding, especially if the original system developers are not responsible for  the change implementation.
* During the program understanding phase, you have to understand how the program is structured, how it delivers functionality and how the proposed change might affect the program.

# Urgent change requests

* Urgent changes may have to be implemented without going through all stages of the software engineering process
  - If a serious system fault has to be repaired to allow normal operation to continue;
  - If changes to the system’s environment (e.g. an OS upgrade) have unexpected effects;
  - If there are business changes that require a very rapid response (e.g. the release of a competing product).

# The emergency repair process

\begin{center}
\includegraphics[width=.85\textwidth]{images/evolution/evolution06.eps}
\end{center}

# Agile methods and evolution

* Agile methods are based on incremental development so the transition from development to evolution is a seamless one.
  - Evolution is simply a continuation of the development process based on frequent system releases.
* Automated regression testing is particularly valuable when changes are made to a system.
* Changes may be expressed as additional user stories.

# Handover problems

* Where the development team have used an agile approach but the evolution team is unfamiliar with agile methods and prefer a plan-based approach.
  - The evolution team may expect detailed documentation to support evolution and this is not produced in agile processes.
* Where a plan-based approach has been used for development but the evolution team prefer to use agile methods.
  - The evolution team may have to start from scratch developing automated tests and the code in the system may not have been refactored and simplified as is expected in agile development.  

#

\centering
\vfill
\Huge Legacy systems

# Legacy systems

* Legacy systems are older systems that rely on languages and technology that are no longer used for new systems development.
* Legacy software may be dependent on older hardware, such as mainframe computers and may have associated legacy processes and procedures.
* Legacy systems are not just software systems but are broader socio-technical systems that include hardware, software, libraries and other supporting software and business processes.

# The elements of a legacy system

\begin{center}
\includegraphics[width=.85\textwidth]{images/evolution/evolution07.eps}
\end{center}

# Legacy system components

* **System hardware** Legacy systems may have been written for hardware that is no longer available.
* **Support software** The legacy system may rely on a range of support software, which may be obsolete or unsupported.
* **Application software** The application system that provides the business services is usually made up of a number of application programs.
* **Application data** These are data that are processed by the application system. They may be inconsistent, duplicated or held in different databases.

# Legacy system components

* **Business processes** These are processes that are used in the business to achieve some business objective.
* **Business processes** may be designed around a legacy system and constrained by the functionality that it provides.
* **Business policies** and rules These are definitions of how the business should be carried out and constraints on the business. Use of the legacy application system may be embedded in these policies and rules.

# Legacy system layers

\begin{center}
\includegraphics[width=.5\textwidth]{images/evolution/evolution08.eps}
\end{center}

# Legacy system replacement

* Legacy system replacement is risky and expensive so businesses continue to use these systems
* System replacement is risky for a number of reasons
  - Lack of complete system specification
  - Tight integration of system and business processes
  - Undocumented business rules embedded in the legacy system
  - New software development may be late and/or over budget

# Legacy system change

* Legacy systems are expensive to change for a number of reasons:
  - No consistent programming style
  - Use of obsolete programming languages with few people available with these language skills
  - Inadequate system documentation
  - System structure degradation
  - Program optimizations may make them hard to understand
  - Data errors, duplication and inconsistency

# Legacy system management

* Organizations that rely on legacy systems must choose a strategy for evolving these systems
  - Scrap the system completely and modify business processes so that it is no longer required;
  - Continue maintaining the system;
  - Transform the system by re-engineering to improve its maintainability;
  - Replace the system with a new system.
* The strategy chosen should depend on the system quality and its business value.

# Example system assessment

\begin{center}
\includegraphics[width=.5\textwidth]{images/evolution/evolution08.eps}
\end{center}

# Legacy system categories

* Low quality, low business value
  - These systems should be scrapped.
* Low-quality, high-business value
  - These make an important business contribution but are expensive to maintain. Should be re-engineered or replaced if a suitable system is available.
* High-quality, low-business value
  - Replace with COTS, scrap completely or maintain.
* High-quality, high business value
  - Continue in operation using normal system maintenance.

# Business value assessment

* Assessment should take different viewpoints into account
  - System end-users;
  - Business customers;
  - Line managers;
  - IT managers;
  - Senior managers.
* Interview different stakeholders and collate results.

# Issues in business value assessment

* The use of the system
  - If systems are only used occasionally or by a small number of people, they may have a low business value.
* The business processes that are supported
  - A system may have a low business value if it forces the use of inefficient business processes.
* System dependability
  - If a system is not dependable and the problems directly affect business customers, the system has a low business value.
* The system outputs
  - If the business depends on system outputs, then the system has a high business value.

# System quality assessment

* Business process assessment
  - How well does the business process support the current goals of the business?
* Environment assessment
  - How effective is the system’s environment and how expensive is it to maintain?
* Application assessment
  - What is the quality of the application software system?

# Business process assessment

* Use a viewpoint-oriented approach and seek answers from system stakeholders
  - Is there a defined process model and is it followed?
  - Do different parts of the organization use different processes for the same function?
  - How has the process been adapted?
  - What are the relationships with other business processes and are these necessary?
  - Is the process effectively supported by the legacy application software?
* Example - a travel ordering system may have a low business value because of the widespread use of web-based ordering.

# Key points

* Software development and evolution can be thought of as an integrated, iterative process that can be represented using a spiral model.
* For custom systems, the costs of software maintenance usually exceed the software development costs.
* The process of software evolution is driven by requests for changes and includes change impact analysis, release planning and change implementation.
* Legacy systems are older software systems, developed using obsolete software and hardware technologies, that remain useful for a business.

# Key points

* It is often cheaper and less risky to maintain a legacy system than to develop a replacement system using modern technology.
* The business value of a legacy system and the quality of the application should be assessed to help decide if a system should be replaced, transformed or maintained.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
