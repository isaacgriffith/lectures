---
author:
- Dr. Isaac Griffith
title: The Essence Language and SE Theory
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
* Understand the kernel of the Essence Standard
* Understand how theory and some ideas for SE theory
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears.jpg}
::::
:::

#

\centering
\vfill
\begin{minipage}{.575\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge The Essence Kernel
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# The Essence Kernel

* The Essence kernel is the set of Essence elements that
would always be found in all types of software system
endeavors.
  - For instance, the element architecture was discussed as a kernel   element.
    * The opinion was that while for many systems it is critical to identify an architecture there are many simpler systems where architecture is not an issue.
    * Since it is not common to all projects, architecture is not a concern that every endeavor has to face, it didn’t qualify as a kernel element.
* In the following slides we will illustrate the elements that
are part of Essence Kernel

# Areas of Concern

* The Essence kernel elements are organized around 3 areas of concern (as we have already seen):

\begin{tcolorbox}[colframe=green!75!black,colback=green!25!white,boxrule=1pt,arc=5pt]
\textbf{\textit{Customer}} -- This area of concern contains everything to do with the actual use and exploitation of the software system to be produced.
\end{tcolorbox}

\begin{tcolorbox}[colframe=yellow!75!black,colback=yellow!25!white,boxrule=1pt,arc=5pt]
\textbf{\textit{Solution}} -- This area of concern contains everything related to the specification and development of the software system.
\end{tcolorbox}

\begin{tcolorbox}[colframe=blue!75!black,colback=blue!25!white,boxrule=1pt,arc=5pt]
\textbf{\textit{Endeavor}} -- This area of concern contains everything related to the development team and the way that they approach their work.
\end{tcolorbox}

# The Essence Kernel

The kernel elements are fundamental of four kinds:

1. The essential things to work with -- **Alphas**
2. The essential things to do -- **Activity Spaces**
3. The essential capabilities needed -- **Competencies**
4. The essential arrangements of elements -- **Patterns**

* Finding the right elements is crucial
* They must be universally acceptable, significant, relevant and guided by the notion that:
  - "You have achieved perfection not when there is nothing left to add, but when there is nothing left to take away."

# 1. The Alphas

We have already seen the Kernel Alphas

\centering
\includegraphics[width=.65\textwidth]{images/Essence/slide57.eps}

# Essence Kernel Alpha States

\begin{center}
\includegraphics[width=.475\textwidth]{images/Essence/slide58.eps}
\end{center}

* The OMG standard defines the states for each kernel alpha shown
* The details of each state can be found in the Essence standard, and we will not go deeper into each of them here
* You can download these from Moodle

# 2. The Activities and Activity Spaces

\footnotesize

* In every software development endeavor you carry out a number of activities
  - \scriptsize \textbf{Essence does not define any activities}
    * \tiny how your team goes about capturing and communicating the requirements can be very different from team to team
  - \scriptsize \textbf{Essence defines a number of \color{Roarange}activity Spaces}

\begin{definition}

\textbf{Activity Spaces are generic placeholders for specific activities}

\end{definition}

\scriptsize

  - Since the activity spaces are generic
    * \tiny They are method-independent
    * \tiny They could be standardized and are thus part of the Essence standard.
    * \tiny Each activity space can be extended with concrete activities that progress one or more alphas
  - The activity spaces are packages used to group activities, which are related to one another.
  - The activity spaces represent the essential things that have to be done to develop software.

# Standard Activity Spaces

\centering
\includegraphics[width=.85\textwidth]{images/Essence/slide60.eps}

# Standard Activity Space Descriptions

\vskip-1em

::: columns
:::: {.column width=.333}
\begin{tcolorbox}[colframe=green!75!black,colback=green!25!white,boxrule=1pt,arc=5pt,
                  left=5pt,right=5pt,top=5pt,bottom=5pt,boxsep=0pt]

\textbf{Customer}

\tiny

\begin{itemize}
\item \textbf{Explore Possibilities} -- Explore the possibilities presented by the creation of a new or improved software system. This includes the analysis of the opportunity and the identification of the stakeholders.
\item \textbf{Understand Stakeholder Needs} -- Engage with the stakeholders to understand their needs and ensure that the right results are produced. This includes identifying and working with the stakeholder representatives to progress the opportunity.
\item \textbf{Ensure Stakeholder Satisfaction} -- Share the results of the development work with the stakeholders to gain their acceptance of the system produced and verify that the opportunity has been addressed.
\item \textbf{Use the System} -- Observe the use the system in a live environment and how it benefits the stakeholders.
\end{itemize}

\end{tcolorbox}
::::
:::: {.column width=.333}
\begin{tcolorbox}[colframe=yellow!75!black,colback=yellow!25!white,boxrule=1pt,arc=5pt,
                  left=5pt,right=5pt,top=5pt,bottom=5pt,boxsep=0pt]
\textbf{Solution}

\tiny

\begin{itemize}
\item \textbf{Understand the Requirements} -- Establish a shared understanding of what the system to be produced must do.
\item \textbf{Shape the system} -- Shape the system so that it is easy to develop, change and maintain, and can cope with current and expected future demands. This includes the architecting and overall design of the system to be produced.
\item \textbf{Implement the System} -- Build a system by implementing, testing and integrating one or more system elements. This includes bug fixing and unit testing.
\item \textbf{Test the System} -- Verify that the system produced meets the stakeholders’ requirements.
\item \textbf{Deploy the System} -- Take the tested system and make it available for use outside the development team
\end{itemize}

\end{tcolorbox}
::::
:::: {.column width=.333}
\begin{tcolorbox}[colframe=blue!75!black,colback=blue!25!white,boxrule=1pt,arc=5pt,
                  left=5pt,right=5pt,top=5pt,bottom=5pt,boxsep=0pt]
\textbf{Endeavor}

\tiny

\begin{itemize}
\item \textbf{Prepare to do the Work} -- Set up the team and its working environment. Understand and commit to completing the work.
\item \textbf{Coordinate Activity} -- Co-ordinate and direct the team’s work. This includes all ongoing planning and re-planning of the work, and re-shaping of the team.
\item \textbf{Support the Team} -- Help the team members to help themselves, collaborate and improve their way of working.
\item \textbf{Track Progress} -- Measure and assess the progress made by the team.
\item \textbf{Stop the Work} -- Shut-down the software engineering endeavor and handover of the team’s responsibilities.
\end{itemize}

\end{tcolorbox}
::::
:::

# Activity Space Card

\centering
\includegraphics[width=.65\textwidth]{images/Essence/slide62.png}

# 3. Competencies

\begin{definition}

\textbf{\textit{Competencies} are generic containers for specific skills}

\end{definition}

  - Specific skills, for example Java programming, are not part of the kernel because this skill is not essential on all software engineering endeavors.
  - But competency is always required and it will be up to the individual teams to identify the specific skills needed for their particular software endeavor.

* A common problem on software endeavors is not being aware of the gap between the competencies needed and the competencies available.
  - The kernel approach will raise the visibility of this gap.

# Standard Competencies

* Competencies are aligned to there focus areas
* Essence Kernel Standard competencies are needed for any Software Engineering Endeavor, independently of methods and techniques adopted

\centering
\includegraphics[width=.5\textwidth]{images/Essence/slide64.eps}

# Standard Competencies Descriptions

\vskip-1em

::: columns
:::: {.column width=.333}
\begin{tcolorbox}[colframe=green!75!black,colback=green!25!white,boxrule=1pt,arc=5pt,
                  left=5pt,right=5pt,top=5pt,bottom=5pt,boxsep=0pt]

\textbf{Customer}

\tiny

\begin{itemize}
\item \textbf{Stakeholder Representation} -- This competency encapsulates the ability to gather, communicate, and balance the needs of other stakeholders, and accurately represent their views.
\end{itemize}

\end{tcolorbox}
::::
:::: {.column width=.333}
\begin{tcolorbox}[colframe=yellow!75!black,colback=yellow!25!white,boxrule=1pt,arc=5pt,
                  left=5pt,right=5pt,top=5pt,bottom=5pt,boxsep=0pt]
\textbf{Solution}

\tiny

\begin{itemize}
\item \textbf{Analysis} -- This competency encapsulates the ability to understand opportunities and their related stakeholder needs, and to transform them into an agreed upon and consistent set of requirements.
\item \textbf{Development} -- This competency encapsulates the ability to design, program and code effective and efficient software systems following the standards and norms agreed upon by the team.
\item \textbf{Testing} -- This competency encapsulates the ability to test a system, verify that it is usable and that it meets the requirements.
\end{itemize}

\end{tcolorbox}
::::
:::: {.column width=.333}
\begin{tcolorbox}[colframe=blue!75!black,colback=blue!25!white,boxrule=1pt,arc=5pt,
                  left=5pt,right=5pt,top=5pt,bottom=5pt,boxsep=0pt]
\textbf{Endeavor}

\tiny

\begin{itemize}
\item \textbf{Leadership} -- This competency enables a person to inspire and motivate a group of people to achieve a successful conclusion to their work and to meet their objectives.
\item \textbf{Management} -- This competency encapsulates the ability to coordinate, plan and track the work done by a team
\end{itemize}

\end{tcolorbox}
::::
:::

# Competency Levels

::: columns
:::: column

\footnotesize

Competency levels of achievement:

1. **Assists** -- Demonstrates a basic understanding of the concepts and can follow instructions
2. **Applies** -- Able to apply the concepts in simple contexts by routinely applying the experience gained so far.
3. **Masters** -- Able to apply the concepts in most contexts and has the experience to work without supervision.
4. **Adapts** -- Able to apply judgment on when and how to apply the concepts to more complex contexts. Can enable others to apply the concepts.
5. **Innovates** -- A recognized expert, able to extend the concepts to new contexts and inspire others.

::::
:::: column

* Each of the competencies has a competency level
* The competency level is the same across all of the kernel competencies

::::
:::

# 4. Patterns

\begin{definition}

\textbf{\textit{Patterns} are generic solutions to typical problems}

\begin{itemize}
  \item Patterns is the way \textbf{Essence} allows arrangements of elements to solve a specific problem.
\end{itemize}

\end{definition}

* Patterns are optional elements (not required element of a practice definition) that may be associated with any other language element.

* *Patterns* examples exist in our daily life as well as in Software Engineering:
  - In a classroom, we often see the teacher in front, with rows of desks and chairs for students. This is a common teaching pattern.
  - In SW Eng we use patterns very often. Some examples are:
    * CheckPoints, Student Pairs, etc.

* *Roles* are a special form of *Pattern*

# Pattern Example: Checkpoint

* A *checkpoint* is a set of criteria to be achieved at a specific point in time where an important decision is to be taken.
  - A checkpoint is simply expressed by a set of alpha states that must have been achieved in order to pass the checkpoint

::: columns
:::: column

- This pattern can be reused for other similar endeavors trying to get to the same checkpoint.

::::
:::: column

\includegraphics[width=.75\textwidth]{images/Essence/slide68.png}

::::
:::

# Using the Checkpoint Pattern

* Let's use Checkpoints to decide when to start and when to finish development of a software project.

\vspace{-1em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Essence/slide69.eps}
\end{center}
\vskip-1em

* In this example, there are two checkpoints.
  - What are the checkpoints?
* The criteria for these two checkpoints are expressed using alpha states.
  - What are the Alpha States for each Checkpoint?

# Roles: A Special kind of Pattern

* Roles represent the set of competencies needed to do a job effectively
  - Roles are a special kind of pattern that apply to people
  - Example roles are Coder, Analyst, Tester

::: columns
:::: column

- Responsibilities to achieve a task are assigned to the task owner, that could be playing a role, but the responsibilities are not part of the role definition

::::
:::: column

\includegraphics[width=.75\textwidth]{images/Essence/slide70.png}

::::
:::

# Essence Element Cards Summary

\centering
\includegraphics[width=.80\textwidth]{images/Essence/slide71.png}

#

\centering
\vfill
\begin{minipage}{.8\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Software Engineering Theory
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# What is Essence?

* Essence provides a common ground for Software Engineering
  - It is very important to have such common ground
  - It is more than a conceptual mode
  - It allows to represent any software engineering method
* Essence Kernel is
  - A **thinking framework** for teams to reason about the **progress** they are making and the **health** of their **endeavors**.
  - A **framework** for teams to **assemble** and continuously improve their **way of working**.
  - The **common ground for improved communication**, standardized measurement, and the sharing of best practice.
  - A **foundation for accessible, inter-operable method** and practice definitions.
  - And most importantly, a way to **help teams understand where they are, and what they should do** next.

# Essence Guiding Principles

::: columns
:::: {.column width=.333}

\footnotesize

* Alphas help assess & drive progress and health of the project
* Each state has a checklist
  - \scriptsize Criteria needed to reach the state
* Alphas are method and practice independent

::::
:::: {.column width=.333}

\vspace{-1.5em}
\begin{center}
\includegraphics[width=\textwidth]{images/Theory/slide74.eps}
\end{center}
\vskip-1em

\footnotesize

* Tangible through the cards
  - \scriptsize Cards provide concise reminders
* Practical through Checklists and Prompts
  - \scriptsize Utilizable on a daily basis helping making decisions

::::
:::: {.column width=.333}

\footnotesize

* Practices are distinct, separate, modular units
* Kernel allows us to create or tailor and compose practices to new methods
* Additional Alphas can be added

::::
:::

# Essence and Agile (or other approaches)

::: columns
:::: column

* Essence Kernel doesn't compete with existing methods
* Essence kernel can be used with all the currently popular management and technical practices:
  - Scrum
  - Kanban
  - risk-driven
  - Iterative
  - Waterfall
  - Use-Case driven development
  - Behavior Driven development
  - Continuous Integration
  - Test Driven Development
  - Etc.

::::
:::: column

* It will help all sizes of teams
  - form one-man bands to 1,000 strong software engineering programs

* The kernel supports the values of the Agile Manifesto
  - It values the 'use of methods' over 'the description of method definitions'

::::
:::

# What is a Theory?

* Most theories share three characteristics
  - they attempt to generalize local observations and data into more abstract and universal knowledge
  - they generally have an interest in causality (cause and effect)
  - They often aim to explain or predict a phenomena

* Gregor proposes 4 goals for a theory:
  1. Describe the studied phenomenon
     * Function Point and SWEBOK could serve as an example
  2. Explain the how, why, and when of the topic
     * theory of cognition is aimed at explaining the human mind's limitations
  3. Besides explaining what has already happened also predict what will happen next
     * Cocomo attempts to predict the cost of software projects
  4. Prescribe how to act based on predictions
     * Alan Davis's 201 principles exemplify this goal

# Where is the Theory for SE?

\footnotesize

* Most academic disciplines are very concerned with their theories.
* Why is it that the software engineering community seems so uninterested in discussing its theories?

  * \scriptsize _**Software Engineering Doesn't Need Theory?**_
    - \tiny Software engineering *isn't* doing fine.
    - \tiny All engineering fields need theory
    - \tiny The maturity of scientific disciplines can be measured by the unity of their theories

  * \scriptsize _**Software Engineering Already Has Its Theory?**_
    - \tiny A discipline's significant theories should be able to provide answers to that discipline's significant questions...

  * \scriptsize _**Software Engineering Can't Have a Theory?**_
    - \tiny Software engineering is a practical engineering discipline without scientific ambitions where rules of thumb and guidelines assume the role of theory
    - \tiny We don't believe that there's any rational reason for the lack of theoretical focus in software engineering
    - \tiny Without the predictive and prescriptive support of theory, software engineering would be relegated to the horribly costly design process of trial and error

# Essence is founding the theory of SE

* Theory is generally used to
  1. describe a phenomenon of interest
  2. to explain and predict the phenomenon

* Description precedes prediction and to describe something, a language is needed

* There is currently no widely accepted predictive general theory of software engineering
  - However, the Essence takes the first step by proposing a coherent, general, *descriptive* theory of software engineering, i.e., a language of software engineering
  - But a complete consideration of the causality between concepts and thus prediction is beyond the current version of the Essence.

# Conclusions

* Essence kernel is a spring board towards more mature software engineering practices and a more mature software engineering discipline

* Throughout the remainder of this course, we will demonstrate how Essence helps you and your teams collaborate more effectively

# For Next Time

::: columns
:::: column
* Review Essentials Chapters 6 - 7
* Review this Lecture
* Come to Class
* Read Essentials Chapter 8 and 9
* Review Lecture 04
* Watch Lecture 04
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
