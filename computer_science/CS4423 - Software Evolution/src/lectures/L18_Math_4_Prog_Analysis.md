---
author:
- Isaac Griffith
title:
institute: |
  CS 4423 and CS 5523

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

#

\vfill
\centering
\Huge Title

# Outcomes

At the end of Today's Lecture you will be able to:

*

# General Idea

* In circa 1972, R. G. Canning in his landmark article "The Maintenance 'Iceberg'," discussed the problems of software maintenance.
* Practitioners took a narrow view of maintenance as
  - correcting errors, and
  - enhancing the functionalities of the software
* The ISO/IEC 14764 standard defines software maintenance as
  - "... the totality of activities required to provide cost-effective support to a software system. Activities are performed during the pre-delivery stage as well as the post-delivery stage."
    * Post-delivery activities include changing software, providing training, and operating a help desk.
    * Pre-delivery activities include planning for post-delivery operations.

# Intention-based Classification of Software Maintenance

Maintenance activities are divided into four groups:

* **Corrective maintenance**: The purpose of corrective maintenance is to correct failures: processing failures and performance failures

* **Adaptive maintenance**: The purpose of adaptive maintenance is to enable the system to adapt to changes in its data environment or processing environment.

* **Perfective maintenance**: The purpose of perfective maintenance is to make a variety of improvements, namely, user experience, processing efficiency, and maintainability.

* **Preventive maintenance**: The purpose of preventive maintenance is to prevent problems from occurring by modifying software products.

# Intention-based Classification of Software Maintenance

* **Corrective maintenance**: The purpose of corrective maintenance is to correct failures: processing failures and performance failures.

* Examples of corrective maintenance:
  - A program producing a wrong output is an example of a processing failure.
  - Similarly, a program not being able to meet real-time requirements is an example of a performance failure.

* The process of corrective maintenance includes isolation and correction of defective elements in the software.

* There is a variety of situations that can be described as corrective maintenance such as correcting a program that aborts or produces incorrect results.

* Basically, corrective maintenance is a reactive process, which means that corrective maintenance is performed after detecting defects with the system.

# Intention-based Classification of Software Maintenance

* **Adaptive maintenance**: The purpose of adaptive maintenance is to enable the system to adapt to changes in its data environment or processing environment.

* This process modifies the software to properly interface with a changing or changed environment.

* Adaptive maintenance includes system changes, additions, deletions, modifications, extensions, and enhancements to meet the evolving needs of the environment in which the system must operate.

* Examples of Adaptive maintenance are:
  - Changing the system to support new hardware configuration;
  - Converting the system from batch to on-line operation; and
  - Changing the system to be compatible with other applications.

# Intention-based Classification of Software Maintenance

* **Perfective maintenance**: The purpose of perfective maintenance is to make a variety of improvements, namely, user experience, processing efficiency, and maintainability.

* Examples of perfective maintenance are:
  - The program outputs can be made more readable for better user experience;
  - The program can be modified to make it faster, thereby increasing the processing efficiency;
  - And, the program can be restructured to improve its readability, thereby increasing its maintainability.

* Activities for perfective maintenance include restructuring of the code, creating and updating documentations, and tuning the system to improve performance.

* It is also called "reengineering".

# Intention-based Classification of Software Maintenance

* **Preventive maintenance**: The purpose of preventive maintenance is to prevent problems from occurring by modifying software products.

* Basically, one should look ahead, identify future risks and unknown problems, and take actions so that those problems do not occur.

* Preventive maintenance is very often performed on safety critical and high available software systems.

* The concept of "**software rejuvenation**" is a preventive maintenance measure to prevent, or at least postpone, the occurrences of failures (crash) due to continuously running the software system.

* It involves occasionally terminating an application or a system, cleaning its internal state, and restarting it.

* Rejuvenation may increase the downtime of the application; however, ti prevents the occurrence of more severe failures.

# Activity-based Classification of Software Maintenance

* Kitchenham et al. organizes maintenance modification activities into two categories:
  - **Corrections** - Activities in this category are designed to fix defects in the system, where a defect is a discrepancy between the expected behavior and the actual behavior of the system.
  - **Enhancements** - Activities in this category are designed to effect changes to the system. It is further divided into three subcategories as follows:
    - enhancement activities that modify some of the existing requirements implemented by the system;
    - enhancement activities that add new system requirements; and
    - enhancement activities that modify the implementation without changing the requirements implemented by the system.

# Evidence-based Classification of Software Maintenance

::: columns
:::: column

* Twelve steps of maintenance activities were grouped into four clusters.

* Modifications performed, detected, or observed on four aspects of the system being maintained are used as the criteria to cluster the types of maintenance activities:
  - the whole software;
  - the external documentation;
  - the properties of the program code; and
  - the system functionality experienced by the customer

::::
:::: column

<!-- image from slide 11 -->

::::
:::

# Evidence-based Classification of Software Maintenance

Classification of maintenance activities is based on changes in the four kinds of entities:

* the whole software;
* the external documentation;
* the properties of the program code; and
* the system functionality experienced by the customer

Evidence of changes to those entities is gathered by comparing the appropriate portions of the software before the activity with the appropriate parts after the execution of the activity.

# Evidence-based Classification of Software Maintenance

* **Training**: This means training the stakeholders about the implementation of the system.

* **Consultive**: In this type, cost and length of time are estimated for maintenance work, personnel run a help desk, customers are assisted to prepare maintenance work requests, and personnel make expert knowledge about the available resources and the system to others in the organization to improve efficiency.

* **Evaluative**: In this type, common activities include reviewing the program code and documentations, examining the ripple effect of a proposed change, designing and executing tests, examining the programming support provided by the operating system, and finding the required data and debugging.

# Evidence-based Classification of Software Maintenance

* **Reformative**: Ordinary activities in this type improve the readability of the documentation, make the documentation consistent with other changes in the ssytem, prepare training materials, and add entries to a data dictionary.

* **Updative**: Ordinary activities in this type are substituting out-of-date documentation with up-to-date documentation, making semi-formal, say, in UML to document current program code, and updating the documentation with test plans.

* **Groomative**: Ordinary activities in this type are substituting components and algorithms with more efficient and simpler ones, modifying the conventions for naming data, changing access authorizations, compiling source code, and doing backups.

# Evidence-based Classification of Software Maintenance

* **Preventive**: Ordinary activities in this type perform changes to enhance maintainability, and establish a base for making a future transition to an emerging technology.

* **Performance**: Activities in performance type produce results that impact the user. Those activities improve system up time and replace components and algorithms with faster ones.

* **Adaptive**: Ordinary activities in this type port the software to a different execution platform, and increase the utilization of COTS components.

# Evidence-based Classification of Software Maintenance

* **Reductive**: Ordinary activities in this type drop some data generated for the customer, decreasing the amount of data input to the system, and decreasing the amount of data produced by the system.

* **Corrective**: Ordinary activities in this type are correcting identified bugs, adding defensive programming strategies, and modifying the ways exceptions are handled.

* **Enhancive**: Ordinary activities in this type are adding and modifying business rules to enhance the system's functionality available to the customer, and adding new data flows into or out of the software.

# Evidence-based Classification of Software Maintenance

::: columns
:::: column

* The impacts of the different types are summarized in the table.

* The first dimension is the customer's ability to perform its business function while continuing to use the system. This is arranged based on the # of diamonds.

* The second dimension is the software. This is arranged from top to bottom.

::::
:::: column

<!-- table from slide 17 -->

::::
:::

# Evidence-based Classification of Software Maintenance

::: columns
:::: column

\underline{\textbf{Decision Tree Based Criteria}}

**Activities are classified into two different types by applying a two-step decision process:**

1. **Apply criteria based decisions to make the clusters of types.**

2. **Apply the type decisions to identify one type within the cluster.**

::::
:::: column

<!-- image from slide 18 -->

::::
:::

# Evidence-based Classification of Software Maintenance

* Sometimes, an objective evidence may be found to be ambiguous. In that case, clusters have their designated default types for use. The overall default type is evaluative, if there are ambiguities in an activity.

\scriptsize
+--------------+-----------------------------------------------------------------------------------------------------+-----------------------+
| **Criteria** | **Type decision question**                                                                          | **Type**              |
+:=============+:====================================================================================================+:======================+
| A-1          | To train the stakeholders, did the activities utilize the software as subject?                      | Training\vskip.1em    |
+--------------+-----------------------------------------------------------------------------------------------------+-----------------------+
| A-2          | As a basis for consultation, did the activities employ the software?                                | Consultive\vskip.1em  |
+--------------+-----------------------------------------------------------------------------------------------------+-----------------------+
| A-3          | Did the activities evaluate the software?                                                           | Evaluative\vskip.1em  |
+--------------+-----------------------------------------------------------------------------------------------------+-----------------------+
| B-1          | To meet stakeholder needs, did the activities modify the non-code documentation?                    | Reformative\vskip.1em |
+--------------+-----------------------------------------------------------------------------------------------------+-----------------------+
| B-2          | To conform to implementation, did the activities modify the non-code documentation?                 | Updative\vskip.1em    |
+--------------+-----------------------------------------------------------------------------------------------------+-----------------------+
| C-1          | Was maintainability or security changed by the activities?                                          | Groomative\vskip.1em  |
+--------------+-----------------------------------------------------------------------------------------------------+-----------------------+
| C-2          | Did the activities constrain the scope of future maintenance activities?                            | Preventive\vskip.1em  |
+--------------+-----------------------------------------------------------------------------------------------------+-----------------------+
| C-3          | Were performance properties or characteristics modified by the activities?                          | Performance\vskip.1em |
+--------------+-----------------------------------------------------------------------------------------------------+-----------------------+
| C-4          | Were different technology or resources used by the activities?                                      | Adaptive\vskip.1em    |
+--------------+-----------------------------------------------------------------------------------------------------+-----------------------+
| D-1          | Did the activities constrain, reduce, or remove some functionalities experienced by the customer?   | Reductive\vskip.1em   |
+--------------+-----------------------------------------------------------------------------------------------------+-----------------------+
| D-2          | Did the activities fix bugs in customer-experienced functionality?                                  | Corrective\vskip.1em  |
+--------------+-----------------------------------------------------------------------------------------------------+-----------------------+
| D-3          | Did the activities substitute, add to, or expand some functionalities experienced by the customers? | Enhancive             |
+--------------+-----------------------------------------------------------------------------------------------------+-----------------------+

# Categories of Maintenance Concepts

The four categories and the concepts that influence the maintenance process have been illustrated in the following figure:

<!-- Image from slide 20 -->

# Maintained Product

The maintained product dimension is characterized by three conceps:

* \color{Roarange} **Product**: \color{Black} A product is a coherent collection of several different artifacts. Source code is the key component of a software product.

* \color{Roarange} **Product upgrade**: \color{Black} Baseline is an arrangement of related entities that make up a particular software configuration. Any change or upgrade made to a software product relates to a specific baseline.
  - An upgrade can create a new version of the system being maintained, a patch code for an object, or even a notice explaining a restriction on the use of the system.

* \color{Roarange} **Artifacts**: \color{Black} A number of different artifacts are used in the design of a software product. One can find the following types of artifacts: textual and graphical documents, component off-the-shelf products, and object code components.

The key elements of the maintained product are size, age, application type, composition and quality.

# Maintained Product

+---------------------+---------------------------+-------------------+
| Life Cycle Stage    | Maintenance Task          | User Population   |
+:====================+:==========================+:==================+
| Initial development | --                        | --\vskip.1em      |
+---------------------+---------------------------+-------------------+
| Evolution           | Corrections, enhancements | Small\vskip.1em   |
+---------------------+---------------------------+-------------------+
| Servicing           | Corrections               | Growing\vskip.1em |
+---------------------+---------------------------+-------------------+
| Phaseout            | Corrections               | Maximum\vskip.1em |
+---------------------+---------------------------+-------------------+
| Closedown           | Corrections               | Declining         |
+---------------------+---------------------------+-------------------+

# Maintenance Types

Four type of maintenance activities are defined:

* **Investigation activity**: This kind of activities evaluate the impact of making a certain change to the system.
* **Modification activity**: This kind of activities change the system's implementation.
* **Management activity**: This kind of activities relate to the configuration control of the maintained system or the management of the maintenance process.
* **Quality assurance activity**: This kind of activities ensure that modifications performed on a system do not damage the integrity of the system.

\color{Roarange} **Activity:** \color{Black} An activity accepts some artifacts as inputs and produces new or changed artifacts.
\vskip.25em
\color{Roarange} **Artifacts:** \color{Black} Artifacts include plans, documents, system representations, and source and object code items. Artifacts are created during the software development process and changed during maintenance.

# Maintenance Organization Processes

Two different levels of maintenance processes are followed within a maintenance organization:

* \color{Roarange} **Individual-level maintenance processes** \color{Black} followed by maintenance personnel to implement a specific change request, and

* \color{Roarange} **Organization-level process** \color{Black} followed to manage the change requests from maintenance personnel, users, and customers/clients.

# Maintenance Organization Processes

Three major elements of a maintenance organizations are:

* \color{Roarange} **Event management:** \color{Black} The stream of events, namely, all the change requests from various sources, received by the maintenance organization is handled in an event management process.

* \color{Roarange} **Configuration management:** \color{Black} A system's integrity is maintained by means of a configuration management process. Integrity of a product is maintained in terms of its modification status and version number.

* \color{Roarange} **Change control system:** \color{Black} Evaluation of results of investigations of maintenance events is performed in a process called change control. Based on the evaluation, the organization approves a system change.

# Maintenance Organization Processes

* A maintenance organization handles maintenance change requests from:
  1. Users,
  2. Customers, and
  3. Maintainers.

* After an initial investigation of a change request, a management process is put in place for approving change activities.
* Approval of a change request is normally the responsibility of a change control board.
* A proposed modification activity is scheduled only after the modification is approved by the board and a Service Level Agreement (SLA) is signed with the client.
* Service level agreement **(SLA)** is a contract between the customers and the providers of a maintenance service. Performance targets for the maintenance services are specified in the **SLA**.

# Maintenance Organization Processes

In general, maintenance organizations use three different support levels to organize the staff:

* \color{Roarange} **Level 1:** \color{Black} This group files problem reports and identifies the technical support person who can best assist the person reporting a problem.
* \color{Roarange} **Level 2:** \color{Black} This level includes experts who know how to communicate with users and analyze their problems. These people recommend quick fixes and temporary workarounds.
* \color{Roarange} **Level 3:** \color{Black} This level includes programmers who can perform actual changes to the product software.

# Peopleware

* Maintenance activities cannot ignore the human element, because software production and maintenance are human intensive activities.

* The three people-centric concepts related to maintenance are as follows:
  1. \color{Roarange} **Maintenance organization:** \color{Black} This is the organization that maintains the product(s).
  2. \color{Roarange} **Client organization:** \color{Black} A client organization uses the maintained system.
  3. \color{Roarange} **Human resource:** \color{Black} Human resource includes personnel from the maintenance and client organizations.

# Peopleware

Finally, the following user and customer issues affect maintenance:

* **Size:** The size of the customer base and the number of licenses they hold affect the amount of effort needed to support a system.
* **Variability:** High variability in the customer base impacts the scope of maintenance tasks.
* **Common goals:** The extent to which the users and the customer have common goals affect the SLAs.

Ultimately, customers fund maintenance activities. If the customers do not have a good understanding of the requirements of the actual users, some SlAs may not be appropriate to the end users.

# Evolution of Software Systems

* The term evolution was used by Mark I. Halpern in circa 1965 to define the dynamic growth of software.

* It attracted more attention in the 1980s after Meir M. Lehman proposed eight broad principles about how certain types of software systems evolve.

* Bennett and Rajlich researched the term "software evolution," but found no widely accepted definition of the term.

* Some researchers and practitioners used the term **software evolution** as a substitute for the term **software maintenance**.

# Evolution of Software Systems

Lowell Jay Arthur distinguished the two terms as follows:

* Maintenance means preserving software from decline or failure.
* Evolution means a continuously changing software from a worse state to a better state.
* Software evolution is like a computer program, with inputs, processes, and outputs.
* Keith H. Bennett and Jie Xu use **maintenance** for all post-delivery support, whereas they use **evolution** to refer to perfective modifications - modifications triggered by changes in requirements.

<!-- image from slide 31 -->

# Evolution of Software Systems

Software evolution is studied with two broad, complementary approaches:

* \color{Roarange} **Explanatory (What/Why):** \color{Black}
  1. This approach attempts to explain the causes of software evolution, the processes used, and the effects of software evolution.
  2. The explanatory approach studies evolution from a scientific view point.

* \color{Roarange} **Process Improvement (How):** \color{Black}
  1. This approach attempts to manage the effects of software evolution by developing better methods and tools, namely, design, maintenance, refactoring, and reengineering.
  2. The process improvement approach studies evolution from an engineering view point.

# SPE Taxonomy

* The abbreviation SPE refers to
  - **S (Specified)**
  - **P (Problem)**, and
  * **E (Evolving)** programs

* In circa 1980, Meir M. Lehman proposed an SPE classification scheme to explain the ways in which programs vary in their evolutionary characteristics.

Lehman observed a key difference between:

* Software developed to meet a fixed set of requirements, and
* Software developed to solve a real world problem which changes with type
* The observation leads to the identification of tyhpes **S (Specified)**, **P (Problem)**, and **E (Evolving)** programs.

# SPE Taxonomy

**S-type (Specified) programs** have the following characteristics:

* All the non-functional and functional program properties, that are important to its stakeholders, are formally and completely defined.
* Correctness of the program with respect to its formal specification is the only criterion of the acceptability of the solution to its stakeholders.

::: columns
:::: column

Examples of **S-type programs:**

* Calculation of the lowest common multiple of two integers

* Perform matrix addition, multiplication, and inversion

::::
:::: column

<!-- Image from slide 34 -->

::::
:::

# SPE Taxonomy

::: columns
:::: column

* **P-type (Problem) program** is based on a practical abstraction of the problem, instead of relying on a completely defined specification.

* Example: A program that plays chess.

* The **P-type program** resulting from the changes cannot be considered a new solution to a new problem. Rather, it is a modification of the old solution to better fit the existing problem.

* In addition, the real world may change, hence the problem changes.

::::
:::: column

<!-- image from slide 35 -->

::::
:::

# SPE Taxonomy

An **E-type (Evolving) program** is one that is embedded in the real world and it changes as the world does.

::: columns
:::: column

* These programs mechanize a human or society activity, make simplifying assumptions, and interface with the external world by requiring or providing services.
* The acceptance of an E-type program entirely depends upon the stakeholders' opinion and judgment of the solution.

::::
:::: column

<!-- image from slide 36 -->

::::
:::

# SPE Taxonomy

* The first characteristic of an E-type program is that the outcome of executing the program is not definitely predictable
* The second characteristic is that program execution changes its operational domain, and the evolution process is viewed as a feedback system.

<!-- image from slide 37 -->

# Laws of Software Evolution

* Lehman formulated a set of observations that he called laws of evolution.
* The laws themselves have evolved from three in 1974 to eight by 1997.
* These laws are the results of studies of the evolution of large-scale proprietary or closed source systems (CSS).
* The laws concern what Lehman called E-type systems:

\begin{center}
"Monolithic systems produced by a team within an organization that solve a real world problem and have human users."
\end{center}

* Lehman's laws were not meant to be used in a mathematical sense, as, say, Newton's laws are used in physics.
* The term "laws" was used because the observed phenomena were beyond the influence of managers and developers.
* The laws were an attempt to study the nature of software evolutions and the evolutionary trajectory likely taken by software.

# Laws of Software Evolution

\scriptsize
+-----------------------------------------------------+--------------------------------------------------------------------+
| Names of the laws                                   | Brief descriptions                                                 |
+:====================================================+:===================================================================+
| I. Continuing change (1974)                         | E-type programs must be continually adapted, else they             |
|                                                     | become progressively less satisfactory.\vskip.1em                  |
+-----------------------------------------------------+--------------------------------------------------------------------+
| II. Increasing complexity (1974)                    | As an E-type program evolves, its complexity increases             |
|                                                     | unless work is done to maintain or reduce it.\vskip.1em            |
+-----------------------------------------------------+--------------------------------------------------------------------+
| III. Self regulation (1974)                         | The evolution of E-type programs is self regulating,               |
|                                                     | with the time distribution of measures of processes and products   |
|                                                     | being close to normal.\vskip.1em                                   |
+-----------------------------------------------------+--------------------------------------------------------------------+
| IV. Conservation of organizational stability (1978) | The average effective global activity rate in an evolving          |
|                                                     | E-type program is invariant over the product's lifetime.\vskip.1em |
+-----------------------------------------------------+--------------------------------------------------------------------+
| V. Conservation of familiarity (1978)               | The average content of successive releases is constant             |
|                                                     | during the life-cycle of an evolving E-type program.\vskip.1em     |
+-----------------------------------------------------+--------------------------------------------------------------------+
| VI. Continuing growth (1991)                        | To maintain user satisfaction with the program over                |
|                                                     | its lifetime, the functional content of an E-type                  |
|                                                     | program must be continually increased.\vskip.1em                   |
+-----------------------------------------------------+--------------------------------------------------------------------+
| VII. Declining quality (1996)                       | An E-type program is perceived by its stakeholders to have         |
|                                                     | declining quality if it is not maintained and adapted to           |
|                                                     | its environment.\vskip.1em                                         |
+-----------------------------------------------------+--------------------------------------------------------------------+
| VIII. Feedback system (1971-1996)                   | The evolution processes in E-type program constitute               |
|                                                     | multi-agent, multi-level, multi-loop feedback systems.             |
+-----------------------------------------------------+--------------------------------------------------------------------+

# Laws of Software Evolution

**First Law Continuing Change:** E-type programs must be continually adapted, else they become progressively less satisfactory.

* Many assumptions are embedded in an E-type program.
* A subset of those assumptions may be complete and valid at the initial release of the product.
* As the application's environment changes in terms of the number of sophisticated users, a growing number of assumptions become invalid.
* Consequently, new requirements and new change requests will emerge.
* When the updated and modified program is reintroduced into the operational domain, it continues to satisfy user needs for a while.
* Next, more changes occur in the operation environment, additional user needs are identified, and additional change requests are made.
* As a result, the evolution process moves into a vicious cycle.

# Laws of Software Evolution

**Second Law Increasing Complexity:** As an E-type program evolves, its complexity increases unless work is done to maintain or reduce it.

* As the program evolves, its complexity grows because of the imposition of changes after changers on the program.
* In order to incorporate new changes, more objects, modules, and sub-systems are added to the system.
* These changes lead to a decline in the product quality, unless additional work is performed to arrest the decline.
* The only way to avoid this from happening is to invest in preventive maintenance.
* In preventive maintenance, one spends time to improve the structure of the software without adding to its functionality.

# Laws of Software Evolution

**Third Law Self Regulation:** The evolution process of E-type programs is self regulating, with the time distribution of measures of processes and products being close to normal.

* This law states that large programs have a dynamics of their own.
* Attributes such as size, time between releases, and the number of reported faults are approximately invariant from release to release.
* The various groups within the large organization apply constraining information controls and reinforcing information controls influenced by past and present performance indicators.
* Their actions control, check and balance the resource usage, which is a kind of feedback-driven growth and stabilization mechanism.
* This establishes a self-controlled dynamic system whose process and product parameters are normally distributed as a result of a huge number of largely independent implementation and managerial decisions.

# Laws of Software Evolution

**Forth Law Conservation of organizational stability:** The average effective global activity rate in an evolving E-type program is invariant over the product's lifetime.

* This law suggests that most large software projects work in a "stationary" state, which means that changes in resources or staffing have small effects on long-term evolution of the software.
* To a certain extent management certainly do control resource allocation and planning of activities. However, as suggested by the third law, program evolution is essentially independent of management decisions.
* Activities during the lifecycle of a system are not exclusively decided by management, but by a wide spectrum of controls and feedback inputs.

# Laws of Software Evolution

**Fifth Law Conservation of Familiarity:** The average content of successive releases is constant during the life-cycle of an evolving E-type program.

* The law suggests that one should not include a large number of features in a new release without taking into account the need for fixing the newly introduced faults.
* Conservation of familiarity implies that maintenance engineers need to have the same high-level of understanding of a new release even if more functionalities have been added to it.

# Laws of Software Evolution

**Sixth Law Continuing Growth:** To maintain user satisfaction with the program over its lifetime, the functional content of an E-type program must be continually increased.

* It is important to distinguish this law from the first law which focuses on "Continuing Change."
* The first law captures the fact that an E-type software's operational domain undergoes continual changes.
* Those changes are partly driven by installation and operation of the system and partly by other forces.
* An example of other forces is human desire for improvement and perfection.
* These two laws -- the first and the sixth -- reflect distinct phenomena and different mechanisms.
* When phenomena are observed, it is often difficult to determine which of the two laws underlies the observation.

# Laws of Software Evolution

**Seventh Law Declining Quality:** An E-type program is perceived by its stakeholders to have declining quality if it is not maintained and adapted to its environment.

* This law directly follows from the first and the sixth laws.
* An E-Type program must undergo changes in the forms of adaptations and extensions to remain satisfactory in a changing operational domain.
* Those changes are very likely to degrade the performance and will potentially inject more faults into the evolving program.
* In addition, the complexity of the program in terms of interactions between its components increases, and the program structure deteriorates.
* The term for this increase in complexity over time is called **entropy**.
* The average rate at which software **entropy** increase is about 1-3 percent per calendar year.

# Laws of Software Evolution

**Seventh Law Declining Quality:** An E-type program is perceived by its stakeholders to have declining quality if it is not maintained and adapted to its environment.

* There is significant decline is stakeholder satisfaction because of growing entropy, declining performance, increasing number of faults, and mismatch of operational domains.
* The above factors also cause a decline in software quality from the user's perspective.
* The decline of software quality over time is related to the growth in entropy associated with software product **aging or code decay.**
* Therefore, it is important to continually undertake preventive measures to reduce the entropy by improving the software's overall architecture, high-level and low-level design, and coding.

# Laws of Software Evolution

There are two types of **aging** in software lifecycles:

* \color{Roarange} **software process execution aging:** \color{Black} It manifests in degradation in performance or transient failures in continuously running the software system,
* \color{Roarange} **software product aging:** \color{Black} It manifests in degradation of quality of software code and documentation due to frequent changes.

The symptoms of Aging in software were:

* \color{Roarange} **Pollution:** \color{Black} Pollution means that there are many modules or components in a system which are not used in the delivery of the business functions of the system.
* \color{Roarange} **Embedded knowledge:** \color{Black} Embedded knowledge is the knowledge about the application domain that has been spread throughout the program such that the knowledge cannot be precisely gathered from the documentation.
* \color{Roarange} **Poor lexicon:** \color{Black} Poor lexicon means that the component identifiers have little lexical meaning or are incompatible with the commonly understood meaning of the components that they identify.
* \color{Roarange} **Coupling:** \color{Black} Coupling means that the programs and their components are linked by an elaborate network of control flows and data flows.

# Laws of Software Evolution

\underline{\textbf{Code decay}}

The code is said to have decayed if it is very difficult to change it, as reflected by the following three key responses:

1. The cost of the change, which is effective only on the personnel cost for the developers who implement it.
2. The calendar or clock time to make the changes; and
3. The quality of the changed software

It is important to note that code decay is antithesis of evolution in the sense that while the evolution process is intended to make the code better, changes are generally degenerative thereby leading to code decay.

# Laws of Software Evolution

**Eighth Law Feedback system:** The evolution processes in E-type programs constitute multi-agent, multi-level, multi-loop feedback systems.

The eight law is based on the observation that evolution process of the E-type software constitutes a multi-level, multi-loop, multi-agent feedback system:

* multi-loop means that it is an iterative process;
* multi-level refers to the fact that it occurs in more than one aspect of the software and its documentation; and
* a multi-agent software system is a computational system where software agents cooperate and compete to achieve some individual or collective tasks. Feedback will determine and constrain the manner in which the software agents communicate among themselves to change their behavior.

# Empirical Studies

* In circa 1976, Belady and Lehman studied 20 releases of the OS/360 O.S.

* The results of their study led them to postulate five laws of software evolution:
  1. \color{Roarange} **Continuing change**
  2. \color{Roarange} **Increasing Complexity**
  3. \color{Roarange} **Self Regulation**
  4. \color{Roarange} **Conservation of Organizational Stability**
  5. \color{Roarange} **Conservation of Familiarity**

* Yuen, a collaborator of Lehman, notes that the last three of the aforementioned laws are more based upon those of human organizations involved int he maintenance process rather than the properties of the software itself.

# Empirical Studies

* In a project entitled FEAST (Feedback, Evolution, And Software Technology), Lehman and his colleagues studied evolution of releases from four CSS systems
  1. two operating systems (OS/360 of IBM and VME OS of ICL),
  2. one financial system (Logica's FW banking transaction system), and
  3. a real-time telecommunication system (Lucent Technologies).
* The studies suggest that during the maintenance process a system tracks a growth curve that can be approximated either as linear or inverse-square
* The inverse-square model represents the growth phenomena as an inverse square of the continuing effort.
* Those trends increase the confidence of validity of the following six laws: Continuing Change (I), Increasing complexity (II), Self regulation (III), Conservation of familiarity (V), Continuing growth (VI), Feedback system (VIII).
* Confidence in the seventh law "Declining quality" is based on the theoretical analysis, whereas the fourth law "Conservation of organizational stability" is neither supported nor falsified based onthe metric presented.

# Practical Implications of the Laws

* Lehman suggested more than 50 rules based on the eight laws
* Those 50+ rules are put into three broad categories:
  1. Assumptions Management
  2. Evolution Management
  3. Release Management

# Evolution of FOSS Systems

* The FOSS movement is attributed to Richard M. Stallman, who started the GNU (OS) project
* FOSS -- also referred to as FLOSS (Free/Libre/Open Sources Software).
* FOSS is a class of software that is both free software and open source.
* FOSS have lots of new characteristics. Eric Raymond concisely documented the FOSS approach in an article entitle "The Cathedral and the Bazaar."

::: columns
:::: column

**FOSS is made available to the general public with either relaxed or non-existent intellectual property restrictions. The free emphasizes the freedom to modify and redistribute under the terms of the original license while open emphasizes the accessibility to the source code.**

::::
:::: column

<!-- image from slide 54 -->

::::
:::

# Evolution of FOSS Systems

* There are huge differences between the evolutions of FOSS based software and CSS based software in terms of:
  - team structure
  - process
  - releases
  - global factors

* Example FOSS: Linux - Started by Linus Torvalds

::: columns
:::: column

<!-- Picture of Linus from slide 55 -->

::::
:::: column

<!-- Image from slide 55 -->

::::
:::

# Evolution of FOSS Systems

* In circa 1988, Pirzada pointed out the differences between the evolution of the Unix OS and systems studied by Lehman.
* Pirzada argued that the differences in academic and industrial software development could lead to a difference in the evolutionary pattern.
* \color{Roarange} In circa 2000, empirical study of free and open source software (FOSS) evolution was conducted by Godfrey and Tu. \color{Black}
* They found that the growth trends from 1994-1999 for the evolution of FOSS Linux OS to be super-linear, that is greater than linear.
* \color{Roarange} Robles and his collaborator concluded that Lehman's laws, 3, 4, and 5 are not fitted to large scale FOSS systems such as Linux.

# Evolution of FOSS Systems

<!-- diagram from slide 57 -->

# Maintenance of COTS-based Systems

* A commercial-off-the-shelf (COTS) component is defined as:
  - A unit of composition with contractually specified interfaces and explicit context dependencies only. A software component that can be deployed independently and is subject to composition by third parties.
* The use of COTS components is increasing in modern software development due to the following reasons:
  - there is significant gain in productivity due to reusing commercial components
  - the time to market for the product decreases
  - the product quality is expected to be high, assuming that the COTS components have been well tested
  - there is efficient use of human resources due to the fact that development personnel will be freed up for other tasks
* the black-box nature of COTS components prevents system integrators from modifying the components to better meet user's requirements.
* the integrators have no visibility of the details of the components, their evolutions, or their maintenance.

# Maintenance of COTS-based Systems

* The only source code being written and modified by the integrators is what is needed for integrating the COTS based systems.
* This includes code for:
  - Tailoring and Wrapping the individual components, and
  - Glue code required to put the components together

\vskip.5em

* \color{Roarange} **Wrapper:** \color{Black} A piece of code that one builds to isolate the underlying components from other components of the system.
* \color{Roarange} **Glue:** \color{Black} A component that provides the functionality to combine different components.
* \color{Roarange} **Tailoring:** \color{Black} The ability to enhance the functionality of a component
  - Tailoring is done by adding some elements to a component to enrich it with a functionality not provided by the vendor.
  - Tailoring does not involve modifying the source code of the component.

# Why Maintenance of CBS is Difficult?

* Frozen functionality
* Incompatibility of upgrades
* Trojan horses
* Unreliable COTS components
* Defective middleware

# Maintenance Activities for CBSs

* Vigder and Kark have surveyed several organizations maintaining systems with a significant portion of COTS elements.
* In their study, they identified the following cost-drivers:
  - Component reconfiguration
  - Testing and debugging
  - Monitoring of systems
  - Enhancing functionality for users
  - Configuration management

# Design Properties of CBSs

* The architecture of a CBS has significant impact on its maintainability.
* The main areas influencing CBS maintainability are as follows:
  1. Choice of components
  2. Architecture and design used to perform integration on the components

* Component selection: The following attributes of components effect the evolution maintenance of CBSs:
  1. Openness of components
  2. Tailorability of components
  3. Available support community

# Design Properties of CBSs

The following design attributes of a maintainable CBS have been identified by Vigder and Kark:

* Encapsulated component collaborations
* Controlled component interfaces
* Controlled component dependencies
* Minimal component coupling
* Consistent failure handling
* High level of visibility
* Minimal build and deployment effort

# Summary

* General Idea
* Categories of Maintenance Concepts
* Evolution of Software Systems
* Maintenance of COTS-based Systems

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time
