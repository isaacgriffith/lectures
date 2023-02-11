---
author:
- Dr. Isaac Griffith
title: Requirements Elicitation, Specification, and Validation
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
* Have an understanding of the different approaches to gathering requirements.
* Have an understanding of the different ways of specifying requirements.
* Have an understanding of how we can validate requirements.
* Understand how we deal with changing requirements.
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert.jpg}
::::
:::

#

\centering
\vfill
\begin{minipage}{.65\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Requirements Elicitation
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Requirements elicitation and analysis

* Sometimes called requirements elicitation or requirements discovery.
* Involves technical staff working with customers to find out about the application domain, the services that the system should provide and the system's operational constraints.
* May involve end-users, managers, engineers involved in maintenance, domain experts, trade unions, etc. These are called *stakeholders*.

# Requirements elicitation

* Software engineers work with a range of system stakeholders to find out about the application domain, the services that the system should provide, the required system performance, hardware constraints, other systems, etc.

* Stages include:
  - Requirements discovery,
  - Requirements classification and organization,
  - Requirements prioritization and negotiation,
  - Requirements specification

# Problems of requirements elicitation

* Stakeholders don't know what they really want
* Stakeholders express requirements in their own terms.
* Different stakeholders may have conflicting requirements.
* Organizational and political factors may influence the system requirements.
* The requirements change during the analysis process. New stakeholders may emerge and the business environment may change.

# Req'ts elicitation and analysis

\vfill
\centering
\includegraphics[width=.55\textwidth]{images/Reqts/reqts04.eps}

# Process activities

* \textcolor{Roarange}{Requirements discovery}
  - \footnotesize Interacting with stakeholders to discover their requirements. Domain requirements are also discovered at this stage.

* \textcolor{Roarange}{Requirements classification and organization}
  - \footnotesize Groups related requirements and organizes them into coherent clusters.

* \textcolor{Roarange}{Prioritization and negotiation}
  - \footnotesize Prioritizing requirements and resolving requirements conflicts

* \textcolor{Roarange}{Requirements specification}
  - \footnotesize Requirements are documented and input into the next round of the spiral

# Requirements Discovery

* The process of gathering information about the required and existing systems and distilling the user and system requirements from this information
* Interaction is with system stakeholders from managers to external regulators
* Systems normally have a range of stakeholders

# Interviewing

* Formal or informal interviews with stakeholders are part of most RE processes.

* Types of interview
  - Closed interviews based on pre-determined list of questions
  - Open interviews where various issues are explored with stakeholders

* Effective interviewing
  - Be open-minded, avoid pre-conceived ideas about the requirements and are willing to listen to stakeholders.
  - Prompt the interviewee to get discussions going using a springboard question, a requirements proposal, or by working together on a prototype system.

# Interviews in practice

* Normally a mix of closed and open-ended interviewing
* Interviews are good for getting an overall understanding of what stakeholders do and how they might interact with the system.
* Interviewers need to be open-minded without pre-conceived ideas of what the system should do.
* You need to prompt the user to talk about the system by suggesting requirements rather than simply asking them what they want.

# Problems with interviews

* Application specialists may use language to describe their work that isn't easy for the requirements engineer to understand
* Interviews are not good for understanding domain requirements
  - Requirements engineers cannot understand specific domain terminology;
  - Some domain knowledge is so familiar that people find it hard to articulate or think that it isn't worth articulating

# Ethnography

* A social scientist spends a considerable time observing and analyzing how people actually work.
* People do not have to explain or articulate their work.
* Social and organizational factors of importance may be observed.
* Ethnographic studies have shown that work is usually richer and more complex than suggested by simple system models.

# Scope of ethnography

* Requirements that are derived from the way that people actually work rather than the way in which process definitions suggest that they ought to work.
* Requirements that are derived form cooperation and awareness of other people's activities
  - Awareness of what other people are doing leads to changes in the ways in which we do things.
* Ethnography is effective for understanding existing processes but cannot identify new features that should be added to a system.

# Focused ethnography

* Developed in a project studying the air traffic control process
* Combines ethnography with prototyping
* Prototype development results in unanswered questions which focus the ethnographic analysis.
* The problem with ethnography is that it studies existing practices which may have some historical basis which is no longer relevant.

# Ethnography and prototyping

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/Reqts/reqts05.eps}

# Stories and Scenarios

* Scenarios and user stories are real-life examples of how a system can be used
* Stories and scenarios are a description of how a system may be used for a particular task.
* Because they are based on a practical situation, stakeholders can relate to them and can comment on their situation with respect to the story.

<!--
# Photo sharing in the classromm

\scriptsize
Jack is a primary school teacher in Ullapool (a village in northern Scotland). He has decided that a class project should be focused around the fishing industry in the area, looking at the history, development and economic impact of fishing. As part of this, pupils are asked to gather and share reminiscences from relatives, use newspaper archives and collect old photographs related to fishing and fishing communities in the area. Pupils use an iLearn wiki to gather together fishing stories and SCRAN (a history resources site) to access newspaper archives and photographs. However, Jack also needs a photo sharing site as he wants pupils to take and comment on each others’ photos and to upload scans of old photographs that they may have in their families.


Jack sends an email to a primary school teachers group, which he is a member of to see if anyone can recommend an appropriate system. Two teachers reply and both suggest that he uses KidsTakePics, a photo sharing site that allows teachers to check and moderate content. As KidsTakePics is not integrated with the iLearn authentication service, he sets up a teacher and a class account. He uses the iLearn setup service to add KidsTakePics to the services seen by the pupils in his class so that when they log in, they can immediately use the system to upload photos from their mobile devices and class computers.
-->

# Scenarios

* A structured form of user story
* Scenarios should include
  - A description of the starting situation;
  - A description of the normal flow of event;
  - A description of what can go wrong;
  - Information about other concurrent activities;
  - A description of the state when the scenario finishes.

<!--
# Uploading Photos (iLearn)

\footnotesize
* **Initial assumption**: A user or a group of users have one or more digital photographs to be uploaded to the picture sharing site. These are saved on either a tablet or laptop computer. They have successfully logged on to KidsTakePics.

* **Normal**: The user chooses upload photos and they are prompted to select the photos to be uploaded on their computer and to select the project name under which the photos will be stored. They should also be given the option of inputting keywords that should be associated with each uploaded photo. Uploaded photos are named by creating a conjunction of the user name with the filename of the photo on the local computer.

* On completion of the upload, the system automatically sends an email to the project moderator asking them to check new content and generates an on-screen message to the user that this has been done.

# Uploading Photos

\footnotesize
* **What can go wrong:**

  - No moderator is associated with the selected project. An email is automatically generated to the school administrator asking them to nominate a project moderator. Users should be informed that there could be a delay in making their photos visible.

  - Photos with the same name have already been uploaded by the same user.  The user should be asked if they wish to re-upload the photos with the same name, rename the photos or cancel the upload. If they chose to re-upload the photos, the originals are overwritten. If they chose to rename the photos, a new name is automatically generated by adding a number to the existing file name.

* **Other activities**:  The moderator may be logged on to the system and may approve photos as they are uploaded.

* **System state on completion**: User is logged on. The selected photos have been uploaded and assigned a status ‘awaiting moderation’.  Photos are visible to the moderator and to the user who uploaded them.
-->

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Requirements Specification
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Requirements specification

* The process of writing down the user and system requirements in a requirements document
* User requirements have to be understandable by end-users and customers who do not have a technical background.
* System requirements are more detailed requirements are more detailed requirements and may include more technical information
* The requirements may be part of a contract for the system development
  - It is therefore important that these are as complete as possible.

# Writing sys req'ts specification

\tiny
+------------------------------+------------------------------------------------------------------------------+
| **Notation**                 | **Description**                                                              |
+:=============================+:=============================================================================+
| Natural language             | The requirements are written using numbered sentences in natural             |
|                              |  language. Each sentence should express one requirement. \vskip.1em          |
+------------------------------+------------------------------------------------------------------------------+
| Structured natural language  | The requirements are written in natural language on a standard form or       |
|                              | template. Each field provides information about an aspect of the             |
|                              | requirement. \vskip.1em                                                      |
+------------------------------+------------------------------------------------------------------------------+
| Design description languages | This approach uses a language like a programming language, but with more     |
|                              | abstract features to specify the requirements by defining an operational     |
|                              | model of the system. This approach is now rarely used although it can be     |
|                              | useful for interface specifications. \vskip.1em                              |
+------------------------------+------------------------------------------------------------------------------+
| Graphical notations          | Graphical models, supplemented by text annotations, are used to define the   |
|                              | functional requirements for the system; UML use case and sequence            |
|                              | diagrams are commonly used. \vskip.1em                                       |
+------------------------------+------------------------------------------------------------------------------+
| Mathematical specifications  | These notations are based on mathematical concepts such as finite-state      |
|                              | machines or sets. Although these unambiguous specifications can reduce       |
|                              | the ambiguity in a requirements document, most customers don’t               |
|                              | understand a formal specification. They cannot check that it represents what |
|                              | they want and are reluctant to accept it as a system contract                |
+------------------------------+------------------------------------------------------------------------------+

# Requirements and design

* In principle, requirements should state what the system should do and the design should describe how it does this.
* In practice, requirements and design are inseparable
  - A system architecture may be designed to structure the requirements;
  - The system may inter-operate with other systems that generate design requirements;
  - The use of a specific architecture to satisfy non-functional requirements may be a domain requirement.
  - This may be the consequence of a regulatory requirement.

# Natural language specification

* Requirements are written as natural language sentences supplemented by diagrams and tables
* Used for writing requirements because it is expressive, intuitive and universal. This means that the requirements can be understood by users and customers.

# Guidelines for writing req'ts

* Invent a standard format and use it for all requirements.
* Use language in a consistent way. Use **shall** for mandatory requirements, **should** for desirable requirement.
* Use text highlighting to identify key parts of the requirement.
* Avoid the use of computer jargon.
* Include an explanation (rationale) of why a requirement is necessary.

# Problems with natural language

* Lack of clarity
  - Precision is difficult without making the document difficult to read.

* Requirements confusion
  - Functional and non-functional requirements tend to be mixed-up

* Requirements amalgamation
  - Several different requirements may be expressed together.

# Insulin pump software ex req'ts

**3.2** The system shall measure the blood sugar and deliver insulin, if required, every 10 minutes. *(Changes in blood sugar are relatively slow so more frequent measurement is unnecessary; less frequent measurement could lead to unnecessarily high sugar levels.)*

\vskip1em

**3.6** The system shall run a self-test routine every minute with the conditions to be tested and the associated actions defined in Table 1. *(A self-test routine can discover hardware and software problems and alert the user to the fact the normal operation may be impossible.)*

# Structured specifications

* An approach to writing requirements where the freedom of the requirements writer is limited and requirements are written in a standard way.
* This works well for some types of requirements e.g., requirements for embedded control system but is sometimes too rigid for writing business system requirement.

# Form-based specifications

* Definition of the function or entity.
* Description of inputs and where they come from.
* Description of outputs and where they go to.
* Information about the information needed for the computation and other entities used.
* Description of the action to be taken.
* Pre and post conditions (if appropriate)
* The side effects (if any) of the function.

# Structured specification example

\underline{Insulin Pump/Control Software/SRS/3.3.2}

\vskip1em

\footnotesize

**Function:** Compute insulin dose: safe sugar level.

\vskip.5em

**Description:**

Computes the dose of insulin to be delivered when the current measured sugar level is in the safe zone between 3 and 7 units.

\vskip.5em
**Inputs:** Current sugar reading (r2); the previous two readings (r0 and r1)

\vskip.5em
**Source:** Current sugar reading from sensor. Other readings from memory.

\vskip.5em
**Outputs:** CompDose---the dose in insulin to be delivered

\vskip.5em
**Destination:** Main control loop.

# Structured specification example

\footnotesize

**Action:**

CompDose is zero if the sugar level is stable or falling or if the level is increasing but the rate of increase is decreasing. If the level is increasing and the rate of increase is increasing, then CompDose is computed by dividing the difference between the current sugar level and the previous level by 4 and rounding the results. If the result, is rounded to zero then CompDose is set to the minimum dose that can be delivered.

\vskip.5em
**Requirements:** Two previous readings so that the rate of change of sugar level can be computed.

\vskip.5em
**Pre-condition:** The insulin resevoir contains at least the maximum allowed single dose of insulin.

\vskip.5em
**Post-condition:**  r0 is replaced by r1 and r1 is replaced by r2.

\vskip.5em
**Side effects:** None.

# Tabular specification

* Used to supplement natural language
* Particularly useful when you have to define a number of possible alternative courses of action
* For example, the insulin pump systems bases its computations on the rate of change of blood sugar level and the tabular specification explains how to calculate the insulin requirement for different scenarios.

# Tabular specification example

\footnotesize

+-----------------------------------------------------------------------------------------------+------------------------------------------------------------------------------------+
| **Condition**                                                                                 | **Action**                                                                         |
+:==============================================================================================+:===================================================================================+
| Sugar level falling (r2 < r1)                                                                 | CompDose = 0 \vskip.1em                                                            |
+-----------------------------------------------------------------------------------------------+------------------------------------------------------------------------------------+
| Sugar level stable (r2 = r1)                                                                  | CompDose = 0 \vskip.1em                                                            |
+-----------------------------------------------------------------------------------------------+------------------------------------------------------------------------------------+
| Sugar level increasing and rate of increase decreasing ((r2 - r1) < (r1 - r0))                | CompDose = 0 \vskip.1em                                                            |
+-----------------------------------------------------------------------------------------------+------------------------------------------------------------------------------------+
| Sugar level increasing and rate of increase stable or increasing ((r2 - r1) $\geq$ (r1 - r0)) | CompDose = round ((r2 - r1) / 4) if rounded result = 0 then CompDose = MinimumDose |
+-----------------------------------------------------------------------------------------------+------------------------------------------------------------------------------------+

# Use cases

* Use-cases are a kind of scenario that are included in the UML.
* Use cases identify the actors in an interaction and which describe the interaction itself.
* A set of use cases should describe all possible interactions with the system.
* High-level graphical model supplemented by more detailed tabular description.
* UML sequence diagrams may be used to add detail to use-cases by showing the sequence of event processing in the system.

<!--
# Mentcare system use cases

\vfill
\centering
\includegraphics[width=.85\textwidth]{images/Reqts/reqts06.eps}
-->

# The software requirements document

* The software requirements document is the official statement of what is required of the system developers.
* Should include both a definition of user requirements and a specification of the system requirements.
* It is NOT a design document. As far as possible, it should set WHAT the system should do rather than HOW it should do it.

# Requirements document users

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/Reqts/reqts07.eps}

# Requirements document variability

* Information in requirements document depends on type of system and the approach to development used.
* System developed incrementally will, typically, have less detail in the requirements document.
* Requirements documents standards have been designed e.g., IEEE standard. These are mostly applicable to the requirements for large systems engineering projects.

# Requirements document structure

\scriptsize
+------------------------------+----------------------------------------------------------------------------------+
| **Chapter**                  | **Description**                                                                  |
+:=============================+:=================================================================================+
| Preface                      | This should define the expected readership of the document and describe          |
|                              | its version history, including a rationale for the creation of a new version     |
|                              | and a summary of the changes made in each version. \vskip.1em                    |
+------------------------------+----------------------------------------------------------------------------------+
| Introduction                 | This should describe the need for the system. It should briefly describe the     |
|                              | system’s functions and explain how it will work with other systems. It           |
|                              | should also describe how the system fits into the overall business or            |
|                              | strategic objectives of the organization commissioning the software. \vskip.1em  |
+------------------------------+----------------------------------------------------------------------------------+
| Glossary                     | This should define the technical terms used in the document. You should          |
|                              | not make assumptions about the experience or expertise of the reader. \vskip.1em |
+------------------------------+----------------------------------------------------------------------------------+
| User requirements definition | Here, you describe the services provided for the user. The nonfunctional         |
|                              | system requirements should also be described in this section. This               |
|                              | description may use natural language, diagrams, or other notations that          |
|                              | are understandable to customers. Product and process standards that              |
|                              | must be followed should be specified.                                            |
+------------------------------+----------------------------------------------------------------------------------+

# Requirements document structure

\scriptsize
+-----------------------------------+---------------------------------------------------------------------------------------------+
| **Chapter**                       | **Description**                                                                             |
+:==================================+:============================================================================================+
| System Architecture               | This chapter should present a high-level overview of the anticipated                        |
|                                   | system architecture, showing the distribution of functions across system                    |
|                                   | modules. Architectural components that are reused should be highlighted.\vskip.1em          |
+-----------------------------------+---------------------------------------------------------------------------------------------+
| System requirements specification | This should describe the functional and nonfunctional requirements in more                  |
|                                   | detail. If necessary, further detail may also be added to the nonfunctional                 |
|                                   | requirements. Interfaces to other systems may be defined. \vskip.1em                        |
+-----------------------------------+---------------------------------------------------------------------------------------------+
| System models                     | This might include graphical system models showing the relationships between                |
|                                   | the system components and the system and its environment. Examples of                       |
|                                   | possible models are object models, data-flow models, or semantic data models. \vskip.1em    |
+-----------------------------------+---------------------------------------------------------------------------------------------+
| System evolution                  | This should describe the fundamental assumptions on which the system is                     |
|                                   | based, and any anticipated changes due to hardware evolution, changing user                 |
|                                   | needs, and so on. This section is useful for system designers as it may help them           |
|                                   | avoid design decisions that would constrain likely future changes to the system.            |
+-----------------------------------+---------------------------------------------------------------------------------------------+

# Requirements document structure

\scriptsize
+-----------------------------------+---------------------------------------------------------------------------------------------+
| **Chapter**                       | **Description**                                                                             |
+:==================================+:============================================================================================+
| Appendices                        | These should provide detailed, specific information that is related to the                  |
|                                   | application being developed; for example, hardware and database descriptions.               |
|                                   | Hardware requirements define the minimal and optimal configurations for the                 |
|                                   | system. Database requirements define the logical organization of the data used              |
|                                   | by the system and the relationships between data.  \vskip.1em                               |
+-----------------------------------+---------------------------------------------------------------------------------------------+
| Index                             | Several indexes to the document may be included. As well as a normal                        |
|                                   | alphabetic index, there may be an index of diagrams, an index of functions, and             |
|                                   | so on.                                                                                      |
+-----------------------------------+---------------------------------------------------------------------------------------------+

#

\centering
\vfill
\begin{minipage}{.65\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Requirements Validation
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Requirements validation

* Concerned with demonstrating that the requirements define the systems that the customer really wants.
* Requirements error costs are high so validation is very important
  - Fixing a requirements error after delivery may cost up to 100 times the cost of fixing an implementation error.

# Requirements checking

* Validity. Does the system provide the functions which best support the customer's needs?
* Consistency. Are there any requirements conflicts?
* Completeness. Are all functions required by the customer included?
* Realism. Can the requirements be implemented given available budget and technology.
* Verifiability. Can the requirements be checked?

# Requirements validation techniques

* \textcolor{Roarange}{Requirements reviews}
  - Systematic manual analysis of the requirements
* \textcolor{Roarange}{Prototyping}
  - Using an executable model of the system to check requirements.
* \textcolor{Roarange}{Test-case generation}
  - Developing tests for requirements to check testability.

# Requirements reviews

* Regular reviews should be held while the requirements definition is being formulated.
* Both client and contractor staff should be involved in reviews.
* Reviews may be formal (with completed documents) or informal. Good communications between developers, customers and users can resolve problems at an early stage.

# Review checks

* \color{Roarange} **Verificability** \color{Black}
  - Is the requirement realistically testable?

* \color{Roarange} **Comprehensibility** \color{Black}
  - Is the requirement properly understood?

* \color{Roarange} **Traceability** \color{Black}
  - Is the origin of the requirement clearly stated?

* \color{Roarange} **Adaptability** \color{Black}
  - Can the requirement be changed without a large impact on other requirements?

#

\centering
\vfill
\begin{minipage}{.6\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Requirements Change
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Changing requirements

* \footnotesize The business and technical environment of the system always changes after installation
  - \scriptsize New hardware may be introduced, it may be necessary to interface the system with other systems, business priorities may change (with consequent changes in the system support required), and new legislation and regulations may be introduced that the system must necessarily abide by.

* \footnotesize The people who pay for a system and the users of that system are rarely the same people.
  - \scriptsize System customers impose requirements because of organizational and budgetary constraints. These may conflict with end-user requirements and, after delivery, new features may have to be added for user support if the system is to meet its goals.

* \footnotesize Large systems usually have a diverse user community, with many users having different requirements and priorities that may be conflicting or contradictory.
  - \scriptsize The final system requirements are inevitably a compromise between them and, with experience, it is often discovered that the balance of support given to different users has to be changed.

# Requirements evolution

\vfill
\centering
\includegraphics[width=.85\textwidth]{images/Reqts/reqts08.eps}

# Requirements management

* Requirements management is the process of managing changing requirements during the requirements engineering process and system development.
* New requirements emerge as a system is being developed and after it has gone into use.
* You need to keep track of individual requirements and maintain links between dependent requirements so that you can assess the impact of requirements changes. You need to establish a formal process for making change proposals and linking these to system requirements.

# Requirements management planning

* Establishes the level of requirements management detail that is required.

* Requirements management decisions:
  - \footnotesize \textcolor{Roarange}{\textit{Requirements identification}} - Each requirement must be uniquely identified so that it can be cross-referenced with other requirements.
  - \footnotesize A \textcolor{Roarange}{\textit{change management process}} - This is the set of activities that assess the impact and cost of changes. I discuss this process in more detail in the following section.
  - \footnotesize \textcolor{Roarange}{\textit{Traceability policies}} - These policies define the relationships between each requirement and between the requirements and the system design that should be recorded.
  - \footnotesize \textcolor{Roarange}{\textit{Tool support}} - Tools that may be used range from specialist requirements management systems to spreadsheets and simple database systems.

# Requirements change management

* Deciding if a requirements change should be accepted
  - \footnotesize \textcolor{Roarange}{\textit{Problem analysis and change specification}}
    - \scriptsize During this stage, the problem or the change proposal is analyzed to check that it is valid. This analysis is fed back to the change requestor who may respond with a more specific requirements change proposal, or decide to withdraw the request.

  - \footnotesize \textcolor{Roarange}{\textit{Change analysis and costing}}
    - \scriptsize The effect of the proposed change is assessed using traceability information and general knowledge of the system requirements. Once this analysis is completed, a decision is made whether or not to proceed with the requirements change.

  - \footnotesize \textcolor{Roarange}{\textit{Change implementation}}
    - \scriptsize The requirements document and, where necessary, the system design and implementation, are modified. Ideally, the document should be organized so that changes can be easily implemented.

# Requirements change management

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/Reqts/reqts09.eps}

# Key points

* \scriptsize The requirements engineering process is an iterative process that includes requirements elicitation, specification and validation
* \scriptsize Requirements elicitation is an iterative process that can be represented as a spiral of activities -- requirements discovery, requirements classification and organization, requirements negotiation and requirements documentation.
* \scriptsize You can use a range of techniques for requirements elicitation including interviews and ethnography. User stories and scenarios may be used to facilitate discussions.
* \scriptsize Requirements specification is the process of formally documenting the user and system requirements and creating a software requirements document.
* \scriptsize The software requirements document is an agreed statement of the system requirements. It should be organized so that both system customers and software developers can use it.
* \scriptsize Requirements validation is the process of checking the requirements for validity, consistency, completeness, realism and verfiability.
* \scriptsize Business, organizational and technical changes inevitably lead to changes to the requirements for a software system. Requirements management is the process of managing and controlling these changes.

# For Next Time

::: columns
:::: column
* Review this Lecture
* Review the video
* Come to Lecture
* Continue working on Homework 02
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert.png}

\Huge \textbf{Are there any questions?}
