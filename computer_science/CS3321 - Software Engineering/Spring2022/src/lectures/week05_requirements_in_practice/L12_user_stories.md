---
author:
- Dr. Isaac Griffith
title: User Stories
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
* Have an understanding of user stories
* Have an understanding of how user stories relate to requirements
* Have an understanding of how to put user stories into practice
::::
:::: {.column width=.25}
\vfill
\vspace{5.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

# Introduction

* The User Story practice is a popular practice, in particular for small teams.
  - \footnotesize It originated from Extreme Programming (XP), a lightweight, efficient, low-risk way to develop software.
  - \footnotesize User stories have the benefit of getting the team to think, inquire and understand the value of what they do from the   point of view of their users.

\vskip1em
\pause

* The User Story Lite practice is a simplified version of the User Story practice
  - \footnotesize It was created just for the readers of this book to understand how to Essentialize a practice and how to use an Essentialized practice

# User Stories Explained

* A user story describes functionality in the system we are building that is valuable to a user of a system.

\vskip1em
\pause

* A user story includes a written description that is used when discussing the story along with tests to help communicate what is needed to complete the story.
  - \footnotesize The idea of user stories is to provide a way to facilitate discussion to help clarify who (i.e. a role) a piece of functionality is for and how it benefits the role.

# Capturing User Stories

::: columns
:::: column

* A user story is often captured on a card using a very concise format

  \vskip0.5em

  \textcolor{RoarangeLight}{\footnotesize \textit{As a <role, of type of user>,\\
  I want to < list here the function you want the system to do>,\\
  so that <list here the object you want to achieve>\\}}

  \vskip0.75em

\pause

* This template helps to ensure that the "Who", "What", and "Why" are all considered and captured

::::
:::: column

\pause

* An example could be:

  \vskip0.5em

  \textcolor{RoarangeLight}{\footnotesize \textit{As a bank customer\\
  I want to have a direct deposit capability\\
  so that my employer can electronically send me my paycheck.\\}}

  \vskip0.75em

\pause

Who -- will get the value?

What -- do we need to achieve?

Why -- are we doing it?

::::
:::

# User Story Lite Practice Big Picture

::: columns
:::: column

\vspace{-1em}
\begin{center}
\includegraphics[width=\textwidth]{images/UserStories/slide06.eps}
\end{center}

::::
:::: column

\pause

* \scriptsize \textcolor{Roarange}{\textbf{Card}} -- a succinct headline description, as captured on a Story Card

\vskip.5em
\pause

* \scriptsize \textcolor{Roarange}{\textbf{Conversation}} -- the actual users of the proposed system and developers discuss what is needed to converge on the best solution

\vskip.5em
\pause

* \scriptsize \textcolor{Roarange}{\textbf{Confirmation}} -- acceptance criteria, captured as bullet-point statements, which can be captured on the back of the Story Card.

::::
:::

# How to Write Good User Stories: INVEST

::: columns
:::: column

1. \footnotesize \textcolor{Roarange}{\textbf{\underline{I}ndependent}} -- *independent* of each other
   - \scriptsize So that each can be developed separately.

\vskip1em
\pause

2. \footnotesize \textcolor{Roarange}{\textbf{\underline{N}egotiable}} -- written to promote negotiation between the user and developers
   - \scriptsize Negotiation promotes understanding and commitment

\vskip1em
\pause

3. \scriptsize \textcolor{Roarange}{\textbf{\underline{V}aluable}} -- A user story should be *valuable* to the user.
   - \scriptsize To understand the real intent of a requirement

::::
:::: column

\pause

4. \footnotesize \textcolor{Roarange}{\textbf{\underline{E}stimatable}} -- enough details to allow the developer to estimate the work effort required to implement the story

\vskip1em
\pause

5. \footnotesize \textcolor{Roarange}{\textbf{\underline{S}mall}} -- to fit within a given iteration
   - \scriptsize Stories that are too large to fit within an iteration are referred to as Epics.

\vskip1em
\pause

6. \footnotesize \textcolor{Roarange}{\textbf{\underline{T}estable}} -- when completed it has to be *testable*
   - \scriptsize Writing the tests first helps ensure the story is testable and helps ensure both users and developers are in agreement on what it means to complete the story.

::::
:::

# Why Do We Need the "So That" Clause?

* To ensure developers \textcolor{Roarange}{\textbf{understand the end objective of the user}}

\vskip1em
\pause

* This helps to support evolutionary requirements development.
  - \footnotesize By evolutionary requirements development we mean that the requirements may evolve as we learn more about the available options and needs of the user.

\vskip1em
\pause

* This also keeps the developer's options open in providing alternative solutions.

# User Stories Essentialized Practice

* For a deep dive on User Stories other literature provides complete and detailed presentation

\vskip1em
\pause

* Our \textcolor{Roarange}{\textbf{goal is to show how to essentialize a Practice}}
  - \footnotesize This is a Lite practice because we have selected what we deem as a minimal core of the practice
    * \scriptsize Minimal for demonstration but in the real world would require much more technical detail

\vskip1em
\pause

* How to describe the User Stories Lite Practice using Essence?
  - \footnotesize The first questions we always ask when essentializing a practice are:
    * \scriptsize What are the things you need to work with?
    * \scriptsize What are the activities you do?

# User Stories Practice Expressed In Essence

::: columns
:::: column

* \footnotesize \textcolor{Roarange}{\textbf{Requirements}} are decomposed into \textcolor{Roarange}{\textbf{User Stories}}

\pause

* \footnotesize Each User Story is:
  - \scriptsize Described by a \textcolor{Roarange}{\textbf{Story Card}}
  - \scriptsize Verified by a \textcolor{Roarange}{\textbf{Test Case}}
  - \scriptsize Singleton work products for each User Story

\pause

* \footnotesize The practice has several activities:
  1. \scriptsize Find User Stories
  2. \scriptsize Prepare User Story
  3. \scriptsize Accept User Story

\pause

* \footnotesize A pattern \textcolor{Roarange}{\textbf{\textit{Splitting User Stories}}} represents the approach to help teams split user stories to ease development

::::
:::: column

\vspace{-1em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/UserStories/slide10.eps}
\end{center}

::::
:::

<!--
# Elements of the User Story Practice

::: columns
:::: column

\begin{table}[]
\begin{tabular}{lll}
\hline
\textbf{Element}                                            & \textbf{Type}                                          & \textbf{Description}                                                                                                                                                                   \\ \hline
User Story                                                  & Alpha                                                  & \begin{tabular}[c]{@{}l@{}}Something that a software\\ system could be extended to\\ do, expressed in terms of the\\ value that it will provide to a\\ user of the system\end{tabular} \\
\rowcolor[HTML]{EFEFEF}
Story Card                                                  & \begin{tabular}[c]{@{}l@{}}Work\\ Product\end{tabular} & \begin{tabular}[c]{@{}l@{}}An index card, or equivalent,\\ that captures the essential\\ details of a user story\end{tabular}                                                          \\
Test Case                                                   & \begin{tabular}[c]{@{}l@{}}Work\\ Product\end{tabular} & \begin{tabular}[c]{@{}l@{}}Defines test inputs and\\ expected results to evaluate\\ whether a user story is fully\\ and correctly implemented\end{tabular}                             \\
\rowcolor[HTML]{EFEFEF}
\begin{tabular}[c]{@{}l@{}}Find User\\ Stories\end{tabular} & Activity                                               & \begin{tabular}[c]{@{}l@{}}Identify things of value that a\\ software system could do.\\ Capture these as simple and\\ succinct headline descriptions\\ on story cards.\end{tabular}   \\ \hline
\end{tabular}
\end{table}

::::
:::: column

\begin{table}[]
\begin{tabular}{lll}
\hline
\textbf{Element}                                                   & \textbf{Type} & \textbf{Description}                                                                                                                                                                                                                                                                       \\ \hline
\rowcolor[HTML]{EFEFEF}
\begin{tabular}[c]{@{}l@{}}Prepare a\\ User Story\end{tabular}     & Activity      & \begin{tabular}[c]{@{}l@{}}A user story is prepared for\\ development by discussion with\\ users to build understanding\\ and refinement of its\\ acceptance criteria and test\\ cases\end{tabular}                                                                                        \\
\rowcolor[HTML]{FFFFFF}
\begin{tabular}[c]{@{}l@{}}Accept a\\ User Story\end{tabular}      & Activity      & \begin{tabular}[c]{@{}l@{}}The user story implementation\\ is evolved in close collaboration\\ with the customer/user until it\\ is acceptable to and accepted\\ by the customer/user\\ representative\end{tabular}                                                                        \\
\rowcolor[HTML]{EFEFEF}
\begin{tabular}[c]{@{}l@{}}Splitting\\ User\\ Stories\end{tabular} & Activity      & \begin{tabular}[c]{@{}l@{}}Small things get done faster. In\\ agile development there is a\\ continuous and relentless drive\\ to reduce the size of user\\ stories by splitting bigger\\ stories into smaller ones. The\\ key is to ensure that each story\\ delivers value.\end{tabular}
\end{tabular}
\end{table}

::::
:::
-->

# User Story Alpha

* \footnotesize A User Story is something that a software system could be extended to do, expressed in terms of the value that it will provide to a user of the system.

\pause

::: columns
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/UserStories/slide12.png}
\end{center}

::::
:::: {.column width=.667}

\footnotesize A User Story progresses through the following states:

\pause

* \scriptsize \textcolor{Roarange}{\textbf{Identified}} -- The user story is identified with its value clearly expressed. It is placed in the team's product backlog.

\vskip.5em
\pause

* \scriptsize \textcolor{Roarange}{\textbf{Ready for Development}} -- The team discusses the details of the user story such that members are clear on what is involved in fulfilling the requirements behind the user story. This might involve details about user interfaces, implementation details, and so on.

\vskip.5em
\pause

* \scriptsize \textcolor{Roarange}{\textbf{In Progress}} -- At this state, the team is working on fulfilling the user story.

\vskip.5em
\pause

* \scriptsize \textcolor{Roarange}{\textbf{Verified}} -- The user story implementation is verified by a qualified user representative, such as a member being the Product Owner.

::::
:::

<!--
# User Story Alpha States

<Image for User Story Alpha States>

* The alpha state cards above help developers understand and agree when the Alpha has achieved a state with specific checklists
-->

# Story Card Product

A Story Card is the written description of a user story

\pause

::: columns
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/UserStories/slide14.png}
\end{center}

::::
:::: {.column width=.667}

\vskip0.5em

A User Story can be at different levels of detail:

\pause

* \scriptsize \textcolor{Roarange}{\textbf{Value Expressed}} -- The value of the user story is clearly expressed, such as using the common format described before (and in the card).

\vskip.5em
\pause

* \scriptsize \textcolor{Roarange}{\textbf{Acceptance Criteria Listed}} -- The acceptance criteria for the fulfillment of the User Story are clearly expressed.

\vskip.5em
\pause

* \scriptsize \textcolor{Roarange}{\textbf{Conversation Captured}} -- The discussions the team has about the User Story are captured so that the team understands more clearly the requirements for the user story and the rationale behind the details of the User Story.
  - \scriptsize These discussions are usually verbal, but can be written on the story card itself or some electronic means

::::
:::

# Test Case Product

A Test Case defines test inputs and expected results to evaluate whether a user story is fully and correctly implemented.

::: columns
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/UserStories/slide15.png}
\end{center}

::::
:::: {.column width=.667}

\vskip0.5em

A test case has several levels of detail:

\pause

* \scriptsize \textcolor{Roarange}{\textbf{Acceptance criteria captured}} -- The different possible ways for testing the user story are captured

\vskip0.5em
\pause

* \scriptsize \textcolor{Roarange}{\textbf{Scripted}} -- The step-by-step procedure for testing and accepting the user story is available. This necessitates also the preparation of test data and test environment used when executing the test case.

\vskip0.5em
\pause

* \scriptsize \textcolor{Roarange}{\textbf{Automated}} -- The test case is automated and can be executed with little or no intervention

::::
:::

# Kick Starting User Story Practice

\small There were two primary challenges our development team faced that led them to decide to try User Stories Lite on their endeavor

\pause

1. \scriptsize Smith's team members sometimes found themselves wondering about the purpose of the system they were developing.
   - \tiny Instead of just enumerating product backlog items, developing product backlog items in a user story from the resulting requirements would help the team better understand the purpose of the system they were developing.
   - \tiny This would also help Angela (the Product Owner) when discussing the system with her stakeholders, such as Dave.

\pause

2. \scriptsize The second challenge the development team often faced was product backlog items being too large to fit within a single sprint/iteration.

\pause

\small Working with User Stories involves several activities:

\pause

* \scriptsize First the team needs to \textcolor{Roarange}{\textbf{find user stories, prepare each user story}} for development, and then \textcolor{Roarange}{\textbf{accept the implementation of the user story}}

\pause

* \scriptsize The implementation of the user story, (i.e., writing and testing code), is outside the scope of the User Story Lite practice we are describing
  - \tiny It is expected to be addressed by another practice such as the microservice practice presented later.

# Find User Stories Activity

::: columns
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/UserStories/slide17.eps}
\end{center}

::::
:::: {.column width=.667}

* \small The Find User Stories activity is about agreeing on how the users are going to use the Software System for something that brings value to them.
  - \footnotesize For each User Story found, a Story Card is created with a simple headline and the value expressed.

\vskip.5em
\pause

* \small The card indicates that:
  - \footnotesize The Story Card needs at a minimum to achieve the \textcolor{Roarange}{\textbf{Value Expressed}} level of detail
  - \footnotesize The user story alpha needs to achieve the \textcolor{Roarange}{\textbf{Identified}} state

::::
:::

# Prepare a User Story Activity

::: columns
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/UserStories/slide18.eps}
\end{center}

::::
:::: {.column width=.667}

* \small The Prepare a User Story activity is about discussing how the user will interact with the system
  - \footnotesize The discussion aims to achieve a better understanding of the system to be developed, estimate the effort to implement and describe the acceptance criteria

\vskip.5em
\pause

* \small The card indicates that:
  - \footnotesize The user story alpha needs to achieve the \textcolor{Roarange}{\textbf{Ready for Development}} state by having:
    * \scriptsize The Story Card to have achieved a minimum of \textcolor{Roarange}{\textbf{Acceptance Criteria Listed}} level of detail
    * \scriptsize The Test Case needs to have achieved at a minimum the \textcolor{Roarange}{\textbf{Test Ideas Captured}} level of detail

::::
:::

# TravelEssence Performing the Practice

\small Angela and the team were discussing which product backlog items they would target for the next iteration. They selected the following three backlog-items:

\pause

1. \footnotesize Improve algorithms to rank destinations according to traveller specific preference

\pause

2. \footnotesize Improve algorithms to rank destinations according to general popularity of destinations

\pause

3. \footnotesize Collect user data from users and analyze them

\pause
\small Together as a team they expressed the user stories as shown:

\pause
\begin{center}
\includegraphics[width=.6\textwidth]{images/UserStories/slide19.eps}
\end{center}

# What is the Outcome for the Team?

* \footnotesize Tom, Joel, and Grace were much happier with the user story form as it  helped them better understand the purpose of the system they were developing.
  \pause
  - \scriptsize The added detail helped them estimate each story and ensure each story was small enough to fit in an iteration.
  \pause
  - \scriptsize In the first and second user stories, because we now have agreed to acceptance criteria the team better understands what Angela will accept for improve algorithms
  \pause
  - \scriptsize In the third user story because it specifies "count clicks" and creates a "trend chart" the team better understands what Angela will accept for the data to be collected and how she expects it to be analyzed.
  \pause
  - \scriptsize The user stories would also help Angela when explaining to Dave, her boss, the specific requirements that the team would be focusing on in the next sprint.

\vskip.5em
\pause

* \footnotesize Angela mentioned that expressing the requirements in a user story format demanded more effort from her
  \pause
  - \scriptsize But after some discussion, she agreed that this small upfront investment was worthwhile because it made her think more about what she wanted.

# Applying Splitting User Stories Pattern

::: columns
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/UserStories/slide21.png}
\end{center}

::::
:::: {.column width=.667}

* \small As part of preparing user stories for development, the team proceeded to split each user story that was too large
  - \footnotesize The outcome are smaller stories that are more aligned to the INVEST criteria
    * \scriptsize Especially the testable criteria

\vskip.5em
\pause

* \small Having smaller stories, with clear test criteria, makes each story easier to complete
  - \footnotesize This rewards team members with a sense of achievement, and
  - \footnotesize Improves team member progress assessments

::::
:::

# TravelEssence Splitting User Stories

As an example, this Figure shows how the first user story was split into 3 smaller ones:

\begin{center}
\includegraphics[width=.85\textwidth]{images/UserStories/slide22.eps}
\end{center}

# Accept a User Story Activity

::: columns
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/UserStories/slide23.eps}
\end{center}

::::
:::: {.column width=.667}

* \small The Accept a User Story activity is about having the customer representative accept that the User Story is implemented
  - \footnotesize The card indicates that:
    * \scriptsize The user story alpha achieve the \textcolor{Roarange}{\textbf{Done}} state

\pause

\small
## TravelEssence

* \footnotesize Acceptance criteria expressed clearly was an investment that paid off as developers had a clearer idea what had to be done
  - \scriptsize The result was reduced disagreements when accepting the story.
* \footnotesize Over the course of the delivery of each user story, they regularly communicated with Angela and with each other regarding the details of the user story.
  - \scriptsize Angela also participated in the acceptance of each user story
  - \scriptsize Whenever issues arose during the sprint, she worked with the team to refine the acceptance criteria

::::
:::

# The Value of the Kernel to the User Story Practice

* By describing the User Story practice in an essentialized form (i.e., activity cards showing relationships to alphas being progressed) we can see which alphas are being progressed and where the requirements practice still had weaknesses.

\vskip0.5em
\pause

* Specifically the User Story practice helps achieve the following Essence kernel alpha states:
  - \textcolor{Roarange}{\textbf{Requirements}} alpha: \textcolor{GrowlingGrayMedium}{\textit{Bounded}} and \textcolor{GrowlingGrayMedium}{\textit{Coherent}} state
  - \textcolor{Roarange}{\textbf{Work}} alpha: \textcolor{GrowlingGrayMedium}{\textit{Prepared}} state
  - \textcolor{Roarange}{\textbf{Requirements}} alpha: \textcolor{GrowlingGrayMedium}{\textit{Acceptable}} state

# Requirements Alpha: Bounded and Coherent

::: columns
:::: {.column width=.4}

\vspace{-1em}

\begin{center}
\includegraphics[width=.85\textwidth]{images/UserStories/slide25a.eps}
\end{center}

\vspace{-2em}

\begin{center}
\includegraphics[width=.85\textwidth]{images/UserStories/slide25b.eps}
\end{center}

::::
:::: {.column width=.6}

\small
The explicit activities in the user story practice directly supports the team in achieving key checklists within the Requirements alpha: Bounded and Coherent states.

\vskip.5em
\pause

* \footnotesize The User Story practice encouraged stakeholders and team members to discuss and therefore:
  - \scriptsize \textcolor{Roarange}{\textbf{agree on the purpose}} of the new system,
  - \scriptsize \textcolor{Roarange}{\textbf{helping everyone involved to achieve a shared understanding}} of the extent of the proposed system

\vskip.5em
\pause

* \footnotesize Discussions helped both the team members and stakeholders to
  - \scriptsize \textcolor{Roarange}{\textbf{work through issues related to potentially conflicting requirements}}

::::
:::

# Work Alpha: Prepared state

::: columns
:::: column

\vspace{-1em}
\begin{center}
\includegraphics[width=.85\textwidth]{images/UserStories/slide27.eps}
\end{center}

::::
:::: column

\small Achieving the Prepared state of the Work alpha was helped by the User Story practice

\vskip.5em
\pause

* \footnotesize Because it encourages the splitting of each user story
  - \scriptsize In order to break the requirements down into tasks that the team could estimate and commit to completing within a single sprint.

::::
:::

# Requirements Alpha; Acceptable state

::: columns
:::: column

\begin{center}
\includegraphics[width=.85\textwidth]{images/UserStories/slide28.eps}
\end{center}

::::
:::: column

* \small The explicit activities in the User Story practice directly supported the team in achieving key checklists in the Requirements alpha: Acceptable state.

\vskip.5em
\pause

* \small The User Story practice encouraged acceptance criteria to be agreed to
  - \footnotesize This led the team to the importance of describing clear test steps that would lead to an acceptable solution

::::
:::

# Impact of User Stories Practice for the Team

* \small The three activities in the User Story practice only cover two activity spaces
  - \footnotesize No activity covers the "Shape the System" activity space
    * \scriptsize This is the activity space that deals with the structure of the solution area including the structure of requirements

\vskip.5em
\pause

* \small By looking at their practices through the lens of Essence, the team can see the strengths of their current practices, as well as the weaknesses

\vskip.5em
\pause

\begin{center}
\includegraphics[width=.75\textwidth]{images/UserStories/slide29.eps}
\end{center}

# User Stories Bridge to Use Cases

* \small The User Stories practice helped the team progress forward with multiple Essence Kernel Alphas

  \pause

  - \footnotesize Yet, it did not solve all the challenges the development team faced with regard to progressing the Requirements and the Work alphas to satisfy the Product Owner

  \pause

  - \footnotesize They had a list of user stories, but not how stories were related to one another

  \pause

  - \footnotesize In the following lecture we will present Use Cases

# For Next Time

::: columns
:::: column
* Review Chapter 15
* Review this Lecture
* Come to Class
* Read Chapter 16
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
