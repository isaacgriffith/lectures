---
author:
- Isaac Griffith
title: Introduction to Requirements Engineering
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

* Functional and non-functional requirements
* Requirements engineering processes

# Requirements engineering

* The process of establishing the services that a customer requires from a system and the constraints under which it operates and is developed.
* The system requirements are the descriptions of the system services and constraints that are generated during the requirements engineering process.

# What is a requirements?

* It may range from a high-level abstract statement of a service or of a system constraint to a detailed mathematical function specification.
* This is inevitable as requirements may serve a dual function.
  - May be the basis for a bid for a contract - therefore must be open to interpretation;
  - May be the basis for the contract itself - therefore must be defined in detail;
  - Both these statements may be called requirements.

# Requirements Abstraction (Davis)

"If a company wishes to let a contract for a large software development project, it must define its needs in a sufficiently abstract way that a solution is not pre-defined. The requirements must be written so that several contractors can bid for the contract, offering, perhaps, different ways of meeting the client organization’s needs. Once a contract has been awarded, the contractor must write a system definition for the client in more detail so that the client understands and can validate what the software will do. Both of these documents may be called the requirements document for the system."

# Types of requirements

* User requirements
  - Statements in natural language plus diagrams of the services the system provides and its operational constraints. Written for customers.

* System requirements
  - A structured document setting out detailed descriptions of the system's functions, services and operational constraints. Defines what should be implemented so may be part of a contract between client and contractor.

# User and System Requirements

* **User requirements definition:**
  1. The Mentcare system shall generate monthly management reports showing the cost of drugs prescribed by each clinic during that month.

* **System requirements specification:**
  - 1.1. On the last working day of each month, a summary of the drugs prescribed, their cost and the prescribing clinics shall be generated.
  - 1.2. The system shall generate the report for printing after 17.20 on the last working day of the month.
  - 1.3. A report shall be created for each clinic and shall list the individual drug names, the total number of prescriptions, the number of doses prescribed and the total cost of the prescribed drugs.
  - 1.4. If drugs are available in different dose units (e.g. 10mg, 20mg, etc.) separate reports shall be created for each dose unit.
  - 1.5. Access to drug cost reports shall be restricted to authorized users as listed on a management access control list.

# Requirements spec readers

\centering
\vfill
\includegraphics[width=.85\textwidth]{images/reqts/reqts01.eps}

# System stakeholders

* Any person or organization who is affected by the system in some way and so who has a legitimate interest
* Stakeholder types
  - End users
  - System managers
  - System owners
  - External stakeholders

# Mentcare system Stakeholders

* Patients whose information is recorded in the system
* Doctors who are responsible for assessing and treating patients
* Nurses who coordinate the consultations with doctors and administer some treatments
* Medical receptionists who manage patients' appointments
* IT staff who are responsible for installing and maintaining the system

# Mentcare system Stakeholders

* A medical ethics manager who must ensure that the system meets current ethical guidelines for patient care
* Health care managers who obtain management information from the system
* Medical records staff who are responsible for ensuring that system information can be maintained and preserved, and that record keeping procedures have been properly implemented.

# Agile methods and requirements

* Many agile methods argue that producing detailed system requirements is a waste of time as requirements change so quickly.
* The requirements document is therefore always out of date.
* Agile methods usually use incremental requirements engineering and may express requirements as 'user stories'
* This is practical for business systems but problematic for systems that require pre-delivery analysis (e.g., critical systems) or systems developed by several teams.

#

\centering
\vfill
\Huge Functional and Non-functional Requirements

# Requirements types

* Functional requirements
  - Statements of services the system should provide, how the system should react to particular inputs and how the system should behave in particular situations.
  - May state what the system should not do.

* Non-functional requirements
  - Constraints on the services or functions offered by the system such as timing constraints, constraints on the development process, standards, etc.
  - Often apply to the system as a whole rather than individual features or services.

* Domain requirements
  - Constraints on the system from the domain of operation

# Functional requirements

* Describe functionality or system services.
* Depend on the type of software, expected users and the type of system where the software is used.
* Functional user requirements may be high-level statements of what the system should do.
* Functional system requirements should describe the system services in detail.

# Mentcare system: functional req'ts

* A user shall be able to search the appointments lists for all clinics
* The system shall generate each day, for each clinic, a list of patients who are expected to attend appointments that day.
* Each staff member using the system shall be uniquely identified by his or her 8-digit employee number.

# Requirements imprecision

* Problems arise when functional requirements are not precisely stated.
* Ambiguous requirements may be interpreted in different ways by developers and users.
* Consider the term 'search' in requirement 1
  - User intention -- search for a patient name across all appointments in all clinics;
  - Developer interpretation -- search for a patient name in an individual clinic. User chooses clinic then search.

# Requirements completeness and consistency

* In principle, requirements should be both complete and consistent.
* Complete
  - They should include descriptions of all facilities required.
* Consistent
  - There should be no conflicts or contradictions in the descriptions of the system facilities.
* In practice, because of system and environmental complexity, it is impossible to produce a complete and consistent requirements document.

# Non-functional requirements

* These define system properties and constraints e.g. reliability, response time and storage requirements. Constraints are I/O device capability, system representations, etc.
* Process requirements may also be specified mandating a particular IDE, programming language or development method.
* Non-functional requirements may be more critical than functional requirements. If these are not met, the system may be useless.

# Types of nonfunctional requirement

\centering
\vfill
\includegraphics[width=.85\textwidth]{images/reqts/reqts02.eps}

# Nonfunctional requirements implementation

* Non-functional requirements may affect the overall architecture of a system rather than the individual components.
  - For example, to ensure that performance requirements are met, you may have to organize the system to minimize communications between components.

* A single non-functional requirement, such as a security requirement, may generate a number of related functional requirements that define system services that are required.
  - It may also generate requirements that restrict existing requirements

# Non-functional classifications

* Product requirements
  - Requirements which specify that the delivered product must behave in a particular way e.g. execution speed, reliability, etc.

* Organizational requirements
  - Requirements which are a consequence of organizational policies and procedures e.g., process standards used, implementation requirements, etc.

* External requirements
  - Requirements which arise from factors which are external to the system and its development process e.g. interoperability requirements, legislative requirements, etc.

# Nonfunctional req'ts examples

**Product requirement**

The Mentcare system shall be available to all clinics during normal working hours (Mon–Fri, 0830–17.30). Downtime within normal working hours shall not exceed five seconds in any one day.

\vskip1em

**Organizational requirement**

Users of the Mentcare system shall authenticate themselves using their health authority identity card.

\vskip1em

**External requirement**

The system shall implement patient privacy provisions as set out in HStan-03-2006-priv.

# Goals and requirements

* Non-functional requirements may be very difficult to state precisely and imprecise requirements may be difficult to verify.
* Goal
  - A general intention of the user such as ease of use.
* Verifiable non-functional requirement
  - A statement using some measure that can be objectively tested.
* Goals are helpful to developers as they convey the intentions of the system users.

# Usability requirements

* The system should be easy to use by medical staff and should be organized in such a way that user errors are minimized. (Goal)
* Medical staff shall be able to use all the system functions after four hours of training. After this training, the average number of errors made by experienced users shall not exceed two per hour of system use. (Testable non-functional requirement)

# Metrics for specifying nonfunctional requirements

\scriptsize
+--------------+-------------------------------------------------------+
| **Property** | **Measure**                                           |
+:=============+:======================================================+
| Speed        | Processed transactions/second                         |
|              | User/event response time                              |
|              | Screen refresh time \vskip0.1em                       |
+--------------+-------------------------------------------------------+
| Size         | MBytes                                                |
|              | Number of ROM chips \vskip0.1em                       |
+--------------+-------------------------------------------------------+
| Ease of use  | Training time                                         |
|              | Number of help frames \vskip0.1em                     |
+--------------+-------------------------------------------------------+
| Reliability  | Mean time to failure                                  |
|              | Probability of unavailability                         |
|              | Rate of failure occurrence                            |
|              | Availability \vskip0.1em                              |
+--------------+-------------------------------------------------------+
| Robustness   | Time to restart after failure                         |
|              | Percentage of events causing failure                  |
|              | Probability of data corruption on failure \vskip0.1em |
+--------------+-------------------------------------------------------+
| Portability  | Percentage of target dependent statements             |
|              | Number of target systems                              |
+--------------+-------------------------------------------------------+

#

\centering
\vfill
\Huge Requirements engineering processes

# Requirements engineering processes

* The processes used for RE vary widely depending on the application domain, the people involved and the organization developing the requirements.

* However, there are a number of generic activities common to all processes
  - Requirements elicitation;
  - Requirements analysis;
  - Requirements validation;
  - Requirements management;

* In practice, RE is an iterative activity in which these processes are interleaved.

# A spiral view of the RE process

\vfill
\centering
\includegraphics[width=.65\textwidth]{images/reqts/reqts03.eps}

# Key points

* Requirements for a software system set out what the system should do and define constraints on its operation and implementation
* Functional requirements are statements of the services that the system must provide or are descriptions of how some computations must be carried out.
* Non-functional requirements often constrain the system being developed and the development process being used.
* They often relate to the emergent properties of the system and therefore apply to the system as a whole.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
