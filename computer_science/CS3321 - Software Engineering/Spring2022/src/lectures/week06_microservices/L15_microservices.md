---
author:
- Dr. Isaac Griffith
title: Microservices
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Outcomes

After today's lecture you will:

::: columns
:::: {.column width=.7}
* \small Have an understanding of Microservices
  - \footnotesize Specificially how Microservices differ from Components
* \small Have an understanding of the Microservices Lite Practice including:
  - \footnotesize Microservices Lite Alphas
  - \footnotesize Microservices Lite Products
  - \footnotesize Microservices Lite Activities
* \small Understand the the Value of the Kernel to the Microservices Practice
* \small Understand the impact of Microservices Lite Practice for the team
::::
:::: {.column width=.25}
\vfill
\vspace{5.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\centering
\vfill
\begin{minipage}{.4\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Microservices
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Introduction to Microservices

* \small Developing software with \textcolor{Roarange}{\textbf{microservices is an evolution of designing software with components}}
  - \footnotesize which facilitates a modular approach to building the software system.

\vskip0.5em

* \small A \textcolor{Roarange}{\textbf{component}} can be described as an element containing code and data.
  - \footnotesize Only the code "inside" the component (object) can modify the data inside the object and it does that when another component sends a message with a request to do that.
  - \footnotesize This idea is known as "\textcolor{Roarange}{\textbf{data hiding}}" (data is hidden to other components) and is an accepted best practice in developing maintainable software.

\vskip0.5em

* \small What Microservices has added is support for components all the way from design, code to deployment

# Components vs. Microservices

* \small Like components
  - \footnotesize microservices are interconnected via interfaces over which messages are sent to allow communication.
  - \footnotesize each microservice can evolve separately from other microservices, thus making it easy to introduce new functionality

\vskip0.5em

* \small In a software system built from microservice, each microservice runs a unique executing process.
  - \footnotesize There may be several such executions or instances of the same program running in parallel.

\vskip0.5em

* \small What microservices bring to software beyond what components already did is the \textcolor{Roarange}{\textbf{ability to also deploy the microservices independently without stopping the execution of the entire software system.}}

# Microservices Big Picture

\vspace{-1em}

\begin{center}
\includegraphics[width=.625\textwidth]{images/microservices/slide05.eps}
\end{center}

* \scriptsize \textcolor{Roarange}{\textbf{User Interface}} -- A user interface is the part of a software system that users interact with. It is the screens, and buttons, and so on.

* \scriptsize \textcolor{Roarange}{\textbf{Application Logic}} -- The code behind the user interface that performs computation, move data around, etc.

* \scriptsize \textcolor{Roarange}{\textbf{Data Store}} -- The data retrievable by the application logic lives in a data store.

* \scriptsize \textcolor{Roarange}{\textbf{Containers}} -- Containers are components of a software system that can be managed separately (i.e. started, stopped, upgraded, and so on)

# Advantages of Microservices

* \small Each microservice runs
  - \footnotesize as a separate process,
  - \footnotesize possibly in its own container or virtual machine
  - \footnotesize it has its own programming language, user interface, application logic and data store.

\vskip0.5em

* \small This architecture allow developers to upgrade each microservice independently
  - \footnotesize For example you can upgraded a microservices from Java 8 to Java 9 or a data store without impacting other microservices.
  - \footnotesize If however, code for different logical software element were to run in the same process or virtual machine, an upgrade of one element may inadvertently impact another element.
  - \footnotesize Thus, \textcolor{Roarange}{\textbf{enhancing the functionality of an existing microservice is easier}} than that of a monolithic software system.

# Microservice Lite Practice

* \small For a deep dive on Microservices other literature provides complete and detailed presentations

\vskip0.5em

* \small Our \textcolor{Roarange}{\textbf{goal is to show how to essentialize a Practice}}
  - \footnotesize This is a Lite practice because we have selected what we deem as a minimal core of the practice;
    * \scriptsize minimal for demonstration but in the real world would require much more technical detail

\vskip0.5em

* \small How to describe Microservices Lite Practice using Essence?
  - \footnotesize The first questions we always ask when essentializing a practice are:
    * \scriptsize What are the things you need to work with?
    * \scriptsize What are the activities you do?

# Microservice Model

::: columns
:::: column

* \small The \textcolor{Roarange}{\textbf{Software System}} is described by a \textcolor{Roarange}{\textbf{Design Model}} and decomposed into \textcolor{Roarange}{\textbf{Microservices}}

\vskip0.15em

* \small Each Microservice is:
  - \footnotesize described by a \textcolor{Roarange}{\textbf{Microservice Design}}
  - \footnotesize built and deployed using \textcolor{Roarange}{\textbf{Microservice Build and Deployment Script}}
  - \footnotesize Verified by a \textcolor{Roarange}{\textbf{Microservice  Test Case}}

\vskip0.15em

* \small The practice has several activities:
  1. \footnotesize Identify Microservices
  2. \footnotesize Make Evolvable
  3. \footnotesize Evolve Microservice

::::
:::: column

\vspace{-1em}

\begin{center}
\includegraphics[width=.75\textwidth]{images/microservices/slide08.eps}
\end{center}

::::
:::

#

\centering
\vfill
\begin{minipage}{.6\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Microservice Elements
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Microservice Alpha

\small The Microservice alpha represents a resilient and elastic piece of the software (i.e. part of the Software System) that delivers a well-defined capability

::: columns
:::: {.column width=.333}

\vspace{-1em}

\begin{center}
\includegraphics[width=.8\textwidth]{images/microservices/slide10.png}
\end{center}

::::
:::: {.column width=.667}

\small Microservices progresses through the following states:

* \footnotesize \textcolor{Roarange}{\textbf{Identified}} -- The scope of the microservice as well as the functionality delivered must be clear.

\vskip0.15em

* \footnotesize \textcolor{Roarange}{\textbf{Rapidly Deployable}} -- A major goal is the ability to quickly change it and re-deploy it to the production environment. It requires low coupling and high cohesion as well as build and deployment scripts

\vskip0.15em

* \footnotesize \textcolor{Roarange}{\textbf{Minimal}} -- team work iteratively to realize the required functionality of the microservice starting with a minimal set of requirements so that it can be integrated and tested in collaboration with other microservices

\vskip0.15em

* \footnotesize \textcolor{Roarange}{\textbf{Complete}} -- fulfilled all the required interfaces of the microservice. Also, refined the structure of the microservice so that it is extensible.

::::
:::

# Microservice Alpha States

\begin{center}
\includegraphics[width=.2\textwidth]{images/microservices/slide11a.eps}
\includegraphics[width=.2\textwidth]{images/microservices/slide11b.eps}
\includegraphics[width=.2\textwidth]{images/microservices/slide11c.eps}
\includegraphics[width=.2\textwidth]{images/microservices/slide11d.eps}
\end{center}

* \small The alpha state cards above help understand and agree when the Alpha has achieved a state with specific checklists

# UML for Microservice Design

\scriptsize

+--------------------+-------------------------------------------------------------------------------------------------+----------------------------------------------------------------------------------------+
| **Element Type**   | **Notation**                                                                                    | **Description**                                                                        |
+:===================+:===============================================================================================:+:=======================================================================================+
| Subsystem          | \begin{minipage}{.2\textwidth}\includegraphics{images/microservices/slide12a.eps}\end{minipage} | \vskip-2em Looks like a Folder, a package contains a group of code or classes to offer |
|                    |                                                                                                 | some functionalities, which clients might want to invoke \vskip.5em                    |
+--------------------+-------------------------------------------------------------------------------------------------+----------------------------------------------------------------------------------------+
| Provided Interface | \begin{minipage}{.2\textwidth}\includegraphics{images/microservices/slide12b.eps}\end{minipage} | \vskip-2em Looks like a lollipop, it is the outward functionality, which a subsystem   |
|                    |                                                                                                 | offers. When using the functionality, the client does not need to                      |
|                    |                                                                                                 | understand what goes on within the subsystem \vskip.5em                                |
+--------------------+-------------------------------------------------------------------------------------------------+----------------------------------------------------------------------------------------+
| Required Interface | \begin{minipage}{.2\textwidth}\includegraphics{images/microservices/slide12c.eps}\end{minipage} | \vskip-2em Looks like a socket. You can plug in stuff into the socket to provide more  |
|                    |                                                                                                 | functionality into a subsystem. For example, on your computer, you can                 |
|                    |                                                                                                 | plug-in hard disks, cameras, etc into your USB port. \vskip.5em                        |
+--------------------+-------------------------------------------------------------------------------------------------+----------------------------------------------------------------------------------------+

* \small we will use UML to describe how Smith’s team makes use of Microservices

# Design Model Product

\small The Design Model is a description of the Software System. It depicts the elements in the Software System and how they interact with one another.

::: columns
:::: {.column width=.333}

\vspace{-1em}

\begin{center}
\includegraphics[width=.8\textwidth]{images/microservices/slide13.eps}
\end{center}

::::
:::: {.column width=.667}

\small A Design Model can be at different levels of detail:

* \footnotesize \textcolor{Roarange}{\textbf{Structure and Approach Described}} -- the Design Model describes clearly the elements the Software System. It will describe how the different parts are organized and the purpose of each part

\vskip.15em

* \footnotesize \textcolor{Roarange}{\textbf{Collaborations and Interfaces Defined}} -- the roles and responsibilities of each part are more detailed

\vskip.15em

* \footnotesize \textcolor{Roarange}{\textbf{Design Patterns identified}} -- common design patterns that can be shared across elements are identified and described. A design pattern is a common design solution to a common design problem

::::
:::

# Recommendation Design

::: columns
:::: {.column width=.333}

\begin{center}
\includegraphics[width=\textwidth]{images/microservices/slide14.eps}
\end{center}

::::
:::: {.column width=.667}

* \small The legacy hotel system provide an interface, referred to an \textcolor{Roarange}{\textbf{eTravelerEvent}} used to push out traveler events

\vskip.15em

* \small The Recommendation subsystem is designed using two microservices
  - \footnotesize the \textcolor{Roarange}{\textbf{Traveler Recommendation}} microservice dealing with specific travelers or groups of travelers,
  - \footnotesize \textcolor{Roarange}{\textbf{Geographical Recommendation}} microservice dealing with specific recommendations related to the traveler’s current or near term planned geographical locations

\vskip.15em

* \small Once the system is deployed there would be multiple microservice processes running
  - \footnotesize one for each traveler group and for each geographical area

\vskip.15em

* \small each with its own datastore for Traveler Recommendations.

::::
:::

# Microservice Design Product

\small The Microservice Design is a work product describing the design of a microservice, from its interfaces to its behavior and internal design.

::: columns
:::: {.column width=.333}

\vspace{-1em}

\begin{center}
\includegraphics[width=.8\textwidth]{images/microservices/slide15.eps}
\end{center}

::::
:::: {.column width=.667}

\small A level of details for this work product are:

* \small \textcolor{Roarange}{\textbf{Required Behavior Defined}} -- the scope of a microservice is described in words.

\vskip.15em

* \small \textcolor{Roarange}{\textbf{Interfaces Specified}} -- the scope of the microservice is described using interfaces.

\vskip.15em

* \small \textcolor{Roarange}{\textbf{Internal Structure Defined}} -- Once the external behavior is agreed, this level of detail describes the elements within the microservice. Developers can then start to write code with a good understanding of this structure.

\vskip.15em

* \small \textcolor{Roarange}{\textbf{Internal Elements Designed}} -- For complex microservices and elements, therein, more details are needed.

::::
:::

# Geographical Recommender Design

::: columns
:::: {.column width=.55}

* \small In addition to the interfaces highlighted in the design model,

\vskip.15em

* \small a microservice also needs interfaces to manage its execution,
  - \footnotesize such as setting configuration parameters, and controlling its execution (starting, pausing, resuming, stopping, reset.)

\vskip.15em

* \small The Geographic Recommendation microservice has
  - \footnotesize `iService` to manage its execution
  - \footnotesize `iRecommendations` to manage its recommendations
  - \footnotesize `iTravelerEventHandler` to handle traveler events

::::
:::: {.column width=.45}

\begin{center}
\includegraphics[width=\textwidth]{images/microservices/slide16.eps}
\end{center}

::::
:::

# Build and Deploy Script Product

\small The Build and Deployment Script is an automated script that supports rapid production and deployment of each microservice independently

- \footnotesize To make the build and deployment process as repeatable as possible, otherwise there is no real advantage of using microservices

::: columns
:::: {.column width=.333}

\vspace{-1em}

\begin{center}
\includegraphics[width=.65\textwidth]{images/microservices/slide17.eps}
\end{center}

::::
:::: {.column width=.667}

\small A level of details for this work product are:

* \footnotesize \textcolor{Roarange}{\textbf{Outlined}} -- there is an agreement as to what rapidly evolvable entails and steps to achieve it are agreed and described.
  - \scriptsize There is not an actual runnable script available yet.
* \footnotesize \textcolor{Roarange}{\textbf{Automated}} -- This is where the real work has been done.
  - \scriptsize The team has written the actual build and deployment script and it has made sure that it works within the development and deployment environment.
* \footnotesize \textcolor{Roarange}{\textbf{Continuous}} -- This is a higher level of detail that ensures that the script runs in continuous support of microservice upgrades without disruption to other microservices.

::::
:::

# Microservice Test Case Product

\small The testing of a microservice follows a similar approach to testing user stories, and use case slices

- \footnotesize The execution of a microservice will likely depend on other microservices. So, you might have to mock out the surrounding dependencies

::: columns
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.7\textwidth]{images/microservices/slide18.eps}
\end{center}

::::
:::: {.column width=.667}

\small A level of details for this work product are:

* \footnotesize \textcolor{Roarange}{\textbf{Test Scenarios Chosen}} -- different scenarios in which the microservice is used are enumerated systematically and prioritized.

\vskip.15em

* \footnotesize \textcolor{Roarange}{\textbf{Test Dependencies Managed}} -- the scope for each test case is agreed, including dependencies, which will be mocked or stubbed.
  - \scriptsize Mocked means to create extra test code that simulates the other side of the interface. Stubbed means rather than simulate the interface to just ensure the test code will execute without the program crashing.

\vskip.15em

* \footnotesize \textcolor{Roarange}{\textbf{Test Automated}} -- At this level of detail, the test cases are scripted and automated. They usually run as part of the build and deployment process.

::::
:::

# Identify Microservices Activity

::: columns
:::: {.column width=.333}

\vspace{-1em}

\begin{center}
\includegraphics[width=.85\textwidth]{images/microservices/slide19.eps}
\end{center}

::::
:::: {.column width=.667}

* \small Identifying microservices requires both the Development and Analysis competencies.
  - \footnotesize These competencies are needed to identify microservices that exhibit high cohesion, low coupling and well-defined interfaces.
  - \footnotesize Identifying microservices with these characteristics helps teams achieve the Software System alpha, Architecture Selected state

\vskip.25em

* \small The card indicates that:
  - \footnotesize The \textcolor{Buttons}{\textit{Software System}} alpha is at \textcolor{Roarange}{\textbf{Architecture Selected}} state and Design Model product details are at \textcolor{Roarange}{\textbf{Structure and Approach described}}
  - \footnotesize \textcolor{Buttons}{\textit{Microservice}} Alpha achieves the \textcolor{Roarange}{\textbf{Identified}} state by having
    * \scriptsize The \textcolor{Buttons}{\textit{Microservice Design}} Product details at \textcolor{Roarange}{\textbf{Required Behavior Defined}}

::::
:::

# Make Evolvable Activity

\small Make Microservice Evolvable activity is about the \textcolor{Roarange}{\textbf{ability to make rapid changes to a software system in the production environment.}}

::: columns
:::: {.column width=.333}

\vspace{-1em}

\begin{center}
\includegraphics[width=.8\textwidth]{images/microservices/slide20.eps}
\end{center}

::::
:::: {.column width=.667}

\footnotesize Goal is to be able to replace a single microservice quickly without affecting other microservices, ensuring

* \scriptsize the modularity and extensibility of each microservice
  - \tiny so that requirements changes are localized to individual microservices,
* \scriptsize development and production environment
  - \tiny so that changes to microservices are repeatable, reliable and fast.

\vskip.15em

\footnotesize This requires the streamlining of the deployment pipeline with \textcolor{Roarange}{\textbf{plenty of automation embodied in the Build and Deployment Script}} work product

\vskip.15em

\footnotesize The card indicates that:

* \scriptsize The \textcolor{Buttons}{\textit{Software System}} alpha is at \textcolor{Roarange}{\textbf{Architecture Selected}} state
* \scriptsize \textcolor{Buttons}{\textit{Microservice}} alpha achieves the \textcolor{Roarange}{\textbf{Rapidly Deployable}} state by having
* \scriptsize The \textcolor{Buttons}{\textit{Build and Deployment Script}} Product details at \textcolor{Roarange}{\textbf{Automated}}

::::
:::

# Impact on the Team

* \small Recall that both User Story Lite and Use Case Lite did not provide any guidance on how to implement the software system.
  - \footnotesize These two practices focused on requirements and tests of the software system.
* \small The Microservice Lite practice addresses implementation guidance
  - \footnotesize Providing guidance on Shape the System and Implement the System activity spaces

\begin{center}
\includegraphics[width=.85\textwidth]{images/microservices/slide21.eps}
\end{center}

# Microservices Considerations

* \small Having many microservices each running separately raises other problems such as:
  - \footnotesize how to manage and coordinate their execution
  - \footnotesize how to propagate the change of data from one microservice to other microservices
  - \footnotesize how to manage the security of each microservice
  - \footnotesize and so on.

\vskip0.5em

* \small Cloud providers offer standard mechanisms to solve them.
  - \footnotesize This allows developers to focus on the application, realizing user requirements, push out functionality to the users quickly, get user feedback, and innovate
    * \scriptsize Rather than the low-level infrastructure plumbing which now happens behind the scenes
    * \scriptsize Such rapid cycles are ultimately the value of microservices

# Progress and Health

* \footnotesize Smith’s team found that the Microservices practice help them provide structure to shape and implement the system
  - \scriptsize What the team realized was that the \textcolor{Roarange}{\textbf{Microservice alpha state provided a way to help them plan and implement all the tasks}} to get the Software System to a state where the customer would be happy with the result.

\vskip.5em

* \footnotesize By the time they explicitly applied the Scrum Lite, Use-Case Lite, and the Microservice Lite practices, they had quite a number of alphas additional to the kernel alphas:
  - \scriptsize Sprint, Product Backlog-Item, Use-Case Slice, Use Cases, Microservice

\vskip.5em

* \footnotesize Someone outside Smith’s team was looking at how they were running development with Essence and the practice.
  - \scriptsize He asked "for a small endeavor like ours, isn’t this too many things to check? It seems that you have many cards!"
  - \scriptsize The usually quiet Grace was quick to reply, "When we were doing the actual work, \textcolor{Roarange}{\textbf{each of us would only focus on achieving a few alpha states}}, for example Use-Case Slice Verified, and Microservice Rapidly Deployable. The \textcolor{Roarange}{\textbf{states are like micro-checklists}} for the small chunks of work we do that could be completed each day. \textcolor{Roarange}{\textbf{They help us split the work into small chunks, and gave us a sense of progress}} during the day."


# Evolve Microservice Activity

\small Once a microservice has been made rapidly deployable and its interfaces identified, it becomes straightforward to evolve each microservice, and thereby introduce new functionality to the entire software system.

::: columns
:::: {.column width=.333}

\vspace{-1em}

\begin{center}
\includegraphics[width=.7\textwidth]{images/microservices/slide24.eps}
\end{center}

::::
:::: {.column width=.667}

\small The card indicates that from:

  - \footnotesize The \textcolor{Buttons}{\textit{Software System}} alpha is at \textcolor{Roarange}{\textbf{Architecture Selected}} state
  - \footnotesize \textcolor{Buttons}{\textit{Microservice}} alpha at \textcolor{Roarange}{\textbf{Selected}} state

\vskip.5em

\small This activity will lead to implement the system by:

  - \footnotesize \textcolor{Buttons}{\textit{Microservice}} Alpha achieves \textcolor{Roarange}{\textbf{Rapidly Deployable}} or beyond state
  - \footnotesize \textcolor{Buttons}{\textit{Microservice Test}} product details at \textcolor{Roarange}{\textbf{Identified}} or beyond
  - \footnotesize \textcolor{Buttons}{\textit{Service Design}} product details at \textcolor{Roarange}{\textbf{Internal Structure Defined}} or beyond

::::
:::

# For Next Time

::: columns
:::: column
* Review this Lecture
* Come to Class
* Watch Lecture 16 Video
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
