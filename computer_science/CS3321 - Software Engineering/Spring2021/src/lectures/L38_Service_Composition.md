---
author:
- Isaac Griffith
title: Service Composition
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

* Service composition

# Software development with services

* Existing services are composed and configured to create new composite services and applications
* The basis for service composition is often a workflow
  - Workflows are logical sequences of activities that, together, model a coherent business process
  - For example, provide a travel reservation services which allows flights, car hire and hotel bookings to be coordinated

# Vacation package workflow

\begin{center}
\includegraphics[width=.85\textwidth]{images/service-oriented/service09.eps}
\end{center}

# Service construction by composition

\begin{center}
\includegraphics[width=.85\textwidth]{images/service-oriented/service10.eps}
\end{center}

# Construction by composition

* Formulate outline workflow
  - In this initial stage of service design, you use the requirements for the composite service as a basis for creating an ‘ideal’ service design.
* Discover services
  - During this stage of the process, you search service registries or catalogs to discover what services exist, who provides these services and the details of the service provision.
* Select possible services
  - Your selection criteria will obviously include the functionality of the services offered. They may also include the cost of the services and the quality of service (responsiveness, availability, etc.) offered.

# Construction by composition

* Refine workflow.
  - This involves adding detail to the abstract description and perhaps adding or removing workflow activities.
* Create workflow program
  - During this stage, the abstract workflow design is transformed to an executable program and the service interface is defined. You can use a conventional programming language, such as Java or a workflow language, such as WS-BPEL.
* Test completed service or application
  - The process of testing the completed, composite service is more complex than component testing in situations where external services are used.

# Workflow design and implementation

* WS-BPEL is an XML-standard for workflow specification. However, WS-BPEL descriptions are long and unreadable
* Graphical workflow notations, such as BPMN, are more readable and WS-BPEL can be generated from them
* In inter-organizational systems, separate workflows are created for each organization and linked through message exchange.
* Workflows can be used with both SOAP-based and RESTful services.

# A fragment of a hotel booking workflow

\begin{center}
\includegraphics[width=.85\textwidth]{images/service-oriented/service11.eps}
\end{center}

# Interacting workflows

\begin{center}
\includegraphics[width=.85\textwidth]{images/service-oriented/service12.eps}
\end{center}

# Testing service compositions

* Testing is intended to find defects and demonstrate that a system meets its functional and non-functional requirements.
* Service testing is difficult as (external) services are ‘black-boxes’. Testing techniques that rely on the program source code cannot be used.

# Service testing problems

* External services may be modified by the service provider thus invalidating tests which have been completed.
* Dynamic binding means that the service used in an application may vary - the application tests are not, therefore, reliable.
* The non-functional behavior of the service is unpredictable because it depends on load.
* If services have to be paid for as used, testing a service may be expensive.
* It may be difficult to invoke compensating actions in external services as these may rely on the failure of other services which cannot be simulated.

# Key points

* The development of software using services involves composing and configuring services to create new composite services and systems.
* Graphical workflow languages, such as BPMN, may be used to describe a business process and the services used in that process.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
