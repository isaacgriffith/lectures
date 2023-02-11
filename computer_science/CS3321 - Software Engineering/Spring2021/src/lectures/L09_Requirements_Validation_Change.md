---
author:
- Isaac Griffith
title: Requirements Validation and Change
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

* Requirements validation
* Requirements change

#

\centering
\vfill
\Huge Requirements validation

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

* Requirements reviews
  - Systematic manual analysis of the requirements
* Prototyping
  - Using an executable model of the system to check requirements.
* Test-case generation
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
\Huge Requirements change

# Changing requirements

* The business and technical environment of the system always changes after installation
  - New hardware may be introduced, it may be necessary to interface the system with other systems, business priorities may change (with consequent changes in the system support required), and new legislation and regulations may be introduced that the system must necessarily abide by.

* The people who pay for a system and the users of that system are rarely the same people.
  - System customers impose requirements because of organizational and budgetary constraints. These may conflict with end-user requirements and, after delivery, new features may have to be added for user support if the system is to meet its goals.

# Changing requirements

* Large systems usually have a diverse user community, with many users having different requirements and priorities that may be conflicting or contradictory.
  - The final system requirements are inevitably a compromise between them and, with experience, it is often discovered that the balance of support given to different users has to be changed.

# Requirements evolution

\vfill
\centering
\includegraphics[width=.85\textwidth]{images/reqts/reqts08.eps}

# Requirements management

* Requirements management is the process of managing changing requirements during the requirements engineering process and system development.
* New requirements emerge as a system is being developed and after it has gone into use.
* You need to keep track of individual requirements and maintain links between dependent requirements so that you can assess the impact of requirements changes. You need to establish a formal process for making change proposals and linking these to system requirements.

# Requirements management planning

* Establishes the level of requirements management detail that is required.

* Requirements management decisions:
  - *Requirements identification* - Each requirement must be uniquely identified so that it can be cross-referenced with other requirements.
  - A *change management process* - This is the set of activities that assess the impact and cost of changes. I discuss this process in more detail in the following section.
  - *Traceability policies* - These policies define the relationships between each requirement and between the requirements and the system design that should be recorded.
  - *Tool support* - Tools that may be used range from specialist requirements management systems to spreadsheets and simple database systems.

# Requirements change management

* Deciding if a requirements change should be accepted
  - *Problem analysis and change specification*
    - During this stage, the problem or the change proposal is analyzed to check that it is valid. This analysis is fed back to the change requestor who may respond with a more specific requirements change proposal, or decide to withdraw the request.

  - *Change analysis and costing*
    - The effect of the proposed change is assessed using traceability information and general knowledge of the system requirements. Once this analysis is completed, a decision is made whether or not to proceed with the requirements change.

  - *Change implementation*
    - The requirements document and, where necessary, the system design and implementation, are modified. Ideally, the document should be organized so that changes can be easily implemented.

# Requirements change management

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/reqts/reqts09.eps}

# Key points

* Requirements validation is the process of checking the requirements for validity, consistency, completeness, realism and verfiability.
* Business, organizational and technical changes inevitably lead to changes to the requirements for a software system. Requirements management is the process of managing and controlling these changes.

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
