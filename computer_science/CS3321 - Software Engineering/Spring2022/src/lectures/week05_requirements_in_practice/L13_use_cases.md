---
author:
- Dr. Isaac Griffith
title: Use Cases Practice
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
* Have an understanding of use cases
* Have an understanding of how use cases relate to requirements
* Have an understanding of how to put use cases into practice
::::
:::: {.column width=.25}
\vfill
\vspace{5.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

# Introduction

* \small The Use Case practice is a requirements analysis technique that has been widely used in modern software engineering since its introduction by Ivar Jacobson in 1987.
  - \footnotesize Use Cases can help teams understand the bigger picture and how product backlog items are related.

\vskip0.5em

* \small The following briefly introduces Use Cases leaving the details to other literature and presentations

# Use Cases Explained

* \small A Use Case describes all the ways of using a system to achieve a particular goal for a particular user

* \small How do they compare with User Stories?
  - \footnotesize User stories represent stories (each one is a single scenario or example of a story) of using the system
  - \footnotesize User Stories help flesh out missing requirements by encouraging informal discussion between developers and users, yet:
    * \scriptsize Many User stories... sometimes are too many
    * \scriptsize It is not clear how these user stories make up something complete
    * \scriptsize Lack of structure
  - \footnotesize Epics can help consolidate many stories and provide structure

* \small Use cases give requirements a structure, or a systematic way to organize requirements
  - \footnotesize This structure makes it easier for teams to conduct analysis, user interface (UI) design, service design, implementation, tests, and so on.

# Use Case Models

::: columns
:::: column

* \footnotesize In the UML the relationships between users and use cases are represented in what is referred to as a Use-Case Diagram

\vskip0.5em

* \footnotesize Use cases include the actual functionality and behavior of the system
  - \scriptsize Each use case is described in a text Use-Case Narrative
  - \scriptsize This narrative provides a textual description of the sequence of interactions between the actor and the system
  - \scriptsize It also describes what the system does as a response to each message from the actor

::::
:::: column

\vspace{-1em}

\begin{center}
\includegraphics[width=.95\textwidth]{images/UseCases/slide05.eps}
\end{center}

::::
:::

#

\centering
\vfill
\begin{minipage}{.525\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Use Case Diagrams
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Use Cases Narrative

* \small The use case narrative is usually separated into two parts, referred to as the \textcolor{Buttons}{\textit{basic flow}} and the \textcolor{Buttons}{\textit{alternate flows}}

\vskip0.5em

* \small The \textcolor{Roarange}{\textbf{basic flow}} describes a normal or a "basic" use of the described use case and is often called the "happy path scenario"
  - \footnotesize The basic flow is worded in a way you would test and verify the behavior of the functionality
  - \footnotesize It is a sequence of steps you would expect when using or testing the system

\vskip0.5em

* \small The \textcolor{Roarange}{\textbf{alternate flows}} are variations of the basic flow to deal with more specific cases
  - \footnotesize These variations can be enhancements, special cases, etc.
  - \footnotesize There can be multiple alternate flows

# Use Case Narrative Examples

::: columns
:::: column

\small UC \textcolor{Roarange}{\textbf{Make Travel Plans}}

\footnotesize \textcolor{Roarange}{\textbf{Basic Flow:}}

1. \scriptsize Traveler provides travel details (travel dates and destination)
2. \scriptsize System searches and displays hotels for the travel dates and destinations
3. \scriptsize Traveler selects a hotel and room type
4. \scriptsize System computes and displays.
5. \scriptsize System makes a tentative reservation for the traveler on the selected hotel.

\footnotesize \textcolor{Roarange}{\textbf{Alternate Flows:}}

\scriptsize

A1. Travel plan with multiple destinations

A2. Travel plan having a single destination but non-consecutive dates

A3. Travel plan with non-consecutive dates and multiple destinations

::::
:::: column

\footnotesize UC \textcolor{Roarange}{\textbf{Provide Travel Recommendations}}

\scriptsize \textcolor{Roarange}{\textbf{Basic Flow:}}

1. \scriptsize Traveler verifies travel details (travel dates and destination)
2. \scriptsize Traveler requests recommendations
3. \scriptsize System provides list of recommendations
4. \scriptsize Traveler browses recommendations
5. \scriptsize Traveler selects and views recommendation

\scriptsize \textcolor{Roarange}{\textbf{Alternate Flows:}}

\scriptsize

A1. Recommendations of different entities

* \tiny (a) Hotel, (b) Place of Interest

A2. Recommendations

* \tiny Recommendations based on (a) popularity rating, (b) on pricing

A3. Recommendation request trigger

* \tiny (a) User initiated, (b) System triggered

A4. Sorting of recommendations

* \tiny (a) Sorting based on prices

::::
:::

# Use Case Considerations

1. \small The use cases help you see the big picture through the use-case model

\vskip0.5em

2. \small The use case approach provides structure through the separation of basic and alternate flows
   - \footnotesize This structure also makes the requirements easier to understand, especially on endeavors that are large and complex.

\vskip0.5em

3. \small A use case often contains too much functionality to be developed in one iteration, such as a single sprint when using Scrum.
   - \footnotesize That is why a use case is split up into a number of intelligently selected smaller parts that are referred to as use-case slices.
   - \footnotesize These use-case slices taken together represent the whole use case and when all the use-case slices are described, the whole use case is described

# Use Case Slices

* \small A \textcolor{Roarange}{\textbf{use-case slice is a slice through a use case that is meaningful to describe, design, implement and test in one go.}}
  - \footnotesize It doesn't need to by itself give value to a user, but together with all other slices of the same use case, the value is achieved.
  - \footnotesize For example, the basic flow of a use case is a good candidate to become an early use-case slice.
  - \footnotesize Additional slices can then be added to complete the whole use case later.

\vskip0.5em

* \small The slicing mechanism enables you to create slices as big or small as you need \textcolor{Roarange}{\textbf{to drive your development}}.
  - \footnotesize The use-case slices include more than just the requirements.
  - \footnotesize They also slice through all the other aspects of the system (e.g. user experience (user interface), architecture, design, code, test) and its documentation.

# Disclaimer on this Practice

* \small The Use-Case Lite practice that we discuss provides a scalable, agile practice that uses use cases to capture the functionality of a software system and test them to ensure the system fulfills them
  - \footnotesize Use cases provide an approach for putting product backlog items into context from the user’s point of view

\vskip0.5em

* \small It is not our intention in this book to explain why one practice is better than other practices
  - \footnotesize All of the practices we present in this book are example practices.

\vskip0.5em

* \small We want the reader to understand:
  - \footnotesize How they can be represented in an essentialized form
  - \footnotesize What value essentialization brings to comparing practices

# Use Case Essentialized Practice

* How to describe the Use Case Lite Practice using Essence?

\vskip0.5em

* The first questions we always ask when essentializing a practice are:
  - \small What are the things you need to work with?
  - \small What are the activities you do?

# Use Case Practice Essentialized

::: columns
:::: column

* \footnotesize Requirements are decomposed into Use Cases, which in turn are broken down into Use-Case Slices
  - \scriptsize All three are important things we need to work with and progress
  - \scriptsize Alphas represents important things we need to progress

* \footnotesize A Use-Case Model is a tangible description of the Requirements and therefore it is a work product.

* \footnotesize Each use case, within our Use-Case Lite practice, has two related work products:
  1. \scriptsize Use-Case Narrative
     - \tiny Singleton
  2. \scriptsize Use-Case Slice Test Case.
     - \tiny Exists in many instances

::::
:::: column

\vspace{-1em}
\begin{center}
\includegraphics[width=.85\textwidth]{images/UseCases/slide12.eps}
\end{center}

::::
:::

# Activities and Use Case Slices

::: columns
:::: column

\small There are four activities in our  Use-Case Lite practice, namely:

1. \footnotesize \textcolor{Roarange}{\textbf{Find Actors and Use Cases}} to gain an overall understanding of what the system is about.

\vskip0.25em

2. \footnotesize \textcolor{Roarange}{\textbf{Slice the Use Cases}} to break them up into a number of intelligently selected smaller slices that each fit within a single sprint. Such a slice is a Use-Case Slice.

\vskip0.25em

3. \footnotesize \textcolor{Roarange}{\textbf{Prepare a Use-Case Slice}} by enhancing the narrative and test cases to clearly define what it means to successfully implement the slice.

\vskip0.25em

4. \footnotesize \textcolor{Roarange}{\textbf{Test a Use-Case Slice}} to verify it is done and ready for inclusion in a release

::::
:::: column

* \footnotesize Use-case \textcolor{Roarange}{\textbf{slices are identified}} by working through their use case to identify paths, scenarios or as we say the stories that build up the use case.

\vskip0.25em

* \footnotesize Typically a \textcolor{Roarange}{\textbf{\textit{story} is any path that you may want to follow}} going through the use case its basic flow or its alternative flows.

\vskip0.25em

* \footnotesize The \textcolor{Roarange}{\textbf{story idea is similar to the user story idea in the User Story practice}} and is very important to find good use-case slices.

\vskip0.25em

* \footnotesize A \textcolor{Roarange}{\textbf{use-case slice typically includes one or more stories}}.

::::
:::


# Use Case Practice Elements

\tiny

::: columns
:::: column

+--------------------------+--------------+-------------------------------------------------------------------+
| **Element**              | **Type**     | **Description**                                                   |
+:=========================+:=============+:==================================================================+
| Use Case                 | Alpha        | All the ways of using a system to achieve a particular goal for a |
|                          |              | particular user \vskip.25em                                       |
+--------------------------+--------------+-------------------------------------------------------------------+
| Use-Case Narrative       | Work         | Tells the sotry of how the system and its actors work together to |
|                          | Product      | achieve a particular goal \vskip.25em                             |
+--------------------------+--------------+-------------------------------------------------------------------+
| Use-Case Slice           | Alpha        | One or more stories selected from a use case to form a work item  |
|                          |              | that is of clear value to the customer \vskip.25em                |
+--------------------------+--------------+-------------------------------------------------------------------+
| Use Case Model           | Work         | A model that captures and visualizes all of the useful ways to    |
|                          | Product      | use a system \vskip.25em                                          |
+--------------------------+--------------+-------------------------------------------------------------------+
| Use-Case Slice Test Case | Work         | Defines inputs and epxected results to hlep evaluate whether a    |
|                          | Product      | system works correctly.                                           |
|                          |              | There can be one or more Test Cases to verify each Use-Case Slice.|
+--------------------------+--------------+-------------------------------------------------------------------+

::::
:::: column

+--------------------------+--------------+-------------------------------------------------------------------+
| **Element**              | **Type**     | **Description**                                                   |
+:=========================+:=============+:==================================================================+
| Find Actors and          | Activity     | Agree on the goals and value of the system by identifying ways of |
| Use Cases                |              | using and testing it. \vskip.25em                                 |
+--------------------------+--------------+-------------------------------------------------------------------+
| Slice the Use-Cases      | Activity     | Break use case up into a number of intelligently selected smaller |
|                          |              | parts for development \vskip.25em                                 |
+--------------------------+--------------+-------------------------------------------------------------------+
| Prepare a Use-Case Slice | Activity     | Enhance the narrative and test cases to clearly define what it    |
|                          |              | means to successfully implement the slice \vskip.25em             |
+--------------------------+--------------+-------------------------------------------------------------------+
| Test a Use-Case Slice    | Activity     | Verify the slice is done and ready for inclusion in a release     |
+--------------------------+--------------+-------------------------------------------------------------------+

::::
:::

# Use Case Alphas

* \footnotesize The Alpha cards shows the short descriptions and the stated Alphas for this practice

* \footnotesize While the Requirements Alpha is part of the Kernel, Use Case and Use-Case Slices are defined in this Practice

\begin{center}
\includegraphics[width=.25\textwidth]{images/UseCases/slide15a.eps}
\includegraphics[width=.25\textwidth]{images/UseCases/slide15b.eps}
\includegraphics[width=.25\textwidth]{images/UseCases/slide15c.eps}
\end{center}

# Use Case Alpha State Cards

::: columns
:::: column

\vspace{-1em}

\begin{center}
\includegraphics[width=.3\textwidth]{images/UseCases/slide16a.eps}
\includegraphics[width=.3\textwidth]{images/UseCases/slide16b.eps}

\includegraphics[width=.3\textwidth]{images/UseCases/slide16c.eps}
\includegraphics[width=.3\textwidth]{images/UseCases/slide16d.eps}
\includegraphics[width=.3\textwidth]{images/UseCases/slide16e.eps}
\end{center}

::::
:::: column

* \footnotesize \textcolor{Roarange}{\textbf{Goal Established}} -- The scope of a use case is defined (what the actor wants to achieve)

\vskip.25em

* \footnotesize \textcolor{Roarange}{\textbf{Story Structure Understood}} -- One of the key benefits of use cases is that it provides a structure.

\vskip.25em

* \footnotesize \textcolor{Roarange}{\textbf{Simplest Story Fulfilled}} -- Once this code skeleton is formed and stabilized, it becomes easy to implement the rest of the stories.

\vskip.25em

* \footnotesize \textcolor{Roarange}{\textbf{Sufficient Stories Fulfilled}} -- Once sufficient stories are fulfilled, the use case can be evaluated if it achieves
the use case goal well.

\vskip.25em

* \footnotesize \textcolor{Roarange}{\textbf{All Stories Fulfilled}} -- Finally, the entire use case is completed

::::
:::

# Use-Case Slice Alpha State Cards

::: columns
:::: column

\vspace{-1em}

\begin{center}
\includegraphics[width=.3\textwidth]{images/UseCases/slide17a.eps}
\includegraphics[width=.3\textwidth]{images/UseCases/slide17b.eps}

\includegraphics[width=.3\textwidth]{images/UseCases/slide17c.eps}
\includegraphics[width=.3\textwidth]{images/UseCases/slide17d.eps}
\includegraphics[width=.3\textwidth]{images/UseCases/slide17e.eps}
\end{center}

::::
:::: column

* \scriptsize \textcolor{Roarange}{\textbf{Scoped}} -- At this state, the use case slice has been identified and its scope clarified.

\vskip.2em

* \scriptsize \textcolor{Roarange}{\textbf{Prepared}} -- the information the development team needs to implement the use case slice are available, including priorities relative other slices, estimates of cost to implement, dependencies to other use-case slices, etc.

\vskip.2em

* \scriptsize \textcolor{Roarange}{\textbf{Analyzed}} -- At this state, the development team has a common agreement on how the use-case slice will be implemented. This includes agreeing on things like user interfaces, persistence, and so on.

\vskip.2em

* \scriptsize \textcolor{Roarange}{\textbf{Implemented}} -- At this state, the use-case slice is implemented. This involves writing actual code.

\vskip.2em

* \scriptsize \textcolor{Roarange}{\textbf{Verified}} -- At this state, product owners verifies the use-case slice does what it is expected.

::::
:::

# Use Case Model Product

::: columns
:::: {.column width=.667}

\small A use-case model describes not just one but several use cases and how together they provide value to its users (i.e. actors).
Levels of detail:

* \footnotesize \textcolor{Roarange}{\textbf{Value Established}} -- the value of the use cases and hence the use-case model is established. Readers of the use-case model have a good understanding of what the use cases are about, what they do and how actors benefit from them.

\vskip0.5em

* \footnotesize \textcolor{Roarange}{\textbf{System Boundary Established}} -- the scope and boundaries of the Requirements are described. The team and stakeholders have a clear understanding of what is within or out of scope

\vskip0.5em

* \footnotesize \textcolor{Roarange}{\textbf{Structured}} -- The use-case model is well-structured. There is little or no overlap between use cases. The dependencies and relationships between use case are described clearly

::::
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.85\textwidth]{images/UseCases/slide18.eps}
\end{center}

::::
:::

# Use Case Narrative Product

\small A use-case narrative describes the story (i.e. sequence of steps) of how the system and the actors work together to achieve a particular goal

::: columns
:::: {.column width=.667}

\small \textbf{Levels of detail:}

* \footnotesize \textcolor{Roarange}{\textbf{Briefly Described}} -- At this level of detail, the use-case narrative only has a brief description of the use-case goal and some words about what it is about

\vskip0.5em

* \footnotesize \textcolor{Roarange}{\textbf{Bulleted Outline}} -- the story of how the system and actors work together is available

\vskip0.5em

* \footnotesize \textcolor{Roarange}{\textbf{Essential Outline}} -- the story is full blown. In the context of requirements of the software system, the various alternative usages and exceptions to be handled are clearly described.

\vskip0.5em

* \footnotesize \textcolor{Roarange}{\textbf{Fully Described}} -- This is a very detailed description of the use-case. All conversations are clearly spelled out

::::
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.8\textwidth]{images/UseCases/slide19.eps}
\end{center}

::::
:::

# Use-Case Slice Test Case Product

\small The Use-Case Slice Test Case work product defines the inputs and expected outputs to help evaluate whether a use-case slice is implemented correctly

::: columns
:::: {.column width=.667}

\small \textbf{Levels of detail:}

* \scriptsize \textcolor{Roarange}{\textbf{Scenario Chosen}} -- At this level of detail, the different scenarios required to test the use-case slice are described.
  - \tiny This includes the normal way of using the use-case slice and other variations (alternative usages and exception cases.

* \scriptsize \textcolor{Roarange}{\textbf{Variables Identified}} -- the different variables are listed.
  - \tiny For example, in the variables for testing the Make Travel Plans use case include Traveler identification, destinations, and recommendations popularity ratings.

* \scriptsize \textcolor{Roarange}{\textbf{Variables Set}} -- At this level of detail, the actual variables are defined.
  - \tiny For example, the Traveler might be Sam, whose identification is 12345678. The destination is Singapore. The popularity rating of the Singapore Zoological Gardens, Shangri-La Hotel, are set.

* \scriptsize \textcolor{Roarange}{\textbf{Scripted or Automated}} -- the test cases are clearly described such that a person can run the test case by following a step by step procedure without misinterpretation or a software tool can execute it repeatedly with pass/fail results clearly defined .

::::
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/UseCases/slide20.eps}
\end{center}

::::
:::

# Find Actors and Use Cases Activity

\small The Find Actors and Use Cases activity is about agreeing on the goals and value of the Software System by identifying the different ways of using it.

::: columns
:::: {.column width=.667}

\vskip.5em

\small The card also indicates that:

* \footnotesize the use case model needs at a minimum to achieve the \textcolor{Roarange}{\textbf{Value Established}} level of detail

\vskip.5em

* \footnotesize the use case narrative at a minimum must be \textcolor{Roarange}{\textbf{Briefly Described}}.

\vskip.5em

* \footnotesize The use case alpha needs to achieve the \textcolor{Roarange}{\textbf{Goal Established}} state

::::
:::: {.column width=.333}

\vspace{-1em}

\begin{center}
\includegraphics[width=.8\textwidth]{images/UseCases/slide21.png}
\end{center}

::::
:::

# Use Case Model and Narrative Example

::: columns
:::: {.column width=.4}

\vspace{-1em}
\begin{center}
\includegraphics[width=.95\textwidth]{images/UseCases/slide22.eps}
\end{center}

::::
:::: {.column width=.6}

\small UC \textcolor{Roarange}{\textbf{Provide Travel Recommendations}}

* \footnotesize \textcolor{Roarange}{\textbf{Basic Flow:}}
  1. \scriptsize Traveler provides travel details (travel dates and
  destination)
  2. \scriptsize Traveler requests recommendations
  3. \scriptsize System provides list of recommendations
  4. \scriptsize Traveler browse recommendations
  5. \scriptsize Traveler selects and view recommendation.

::::
:::

# Use Case Model and Narrative Example

::: columns
:::: {.column width=.4}

\vspace{-1em}
\begin{center}
\includegraphics[width=.95\textwidth]{images/UseCases/slide22.eps}
\end{center}

::::
:::: {.column width=.6}

\small UC \textcolor{Roarange}{\textbf{Provide Travel Recommendations}}

* \footnotesize \textcolor{Roarange}{\textbf{Alternate Flows:}}
  1. \scriptsize Recommendations of different entities

     \tiny (a) Hotel, (b) Place of Interest

  2. \scriptsize Recommendation computation

     \tiny (a) Recommendations based on popularity rating

     \tiny (b) Recommendations based on pricing

     \tiny (c) \#\textcolor{Roarange}{\textbf{New}} Recommendations based on advertisements

     \tiny (d) \#\textcolor{Roarange}{\textbf{New}} Recommendations based on favorites

     \tiny (e) \#\textcolor{Roarange}{\textbf{Updated}} Weighting function for the above parameters (popularity, pricing)

  3. \scriptsize Recommendation request trigger

     \tiny (a) User initiated, (b) System triggered

  4. \scriptsize Sorting of recommendations

     \tiny (a) Sorting based on prices, (b) \#\textcolor{Roarange}{\textbf{New}} Sorting based on vicinity

  5. \scriptsize \#\textcolor{Roarange}{\textbf{New}} Recommendation actions

     \tiny (a) \#\textcolor{Roarange}{\textbf{New}} Add selected recommendations to favorites

::::
:::

# Slice the Use-Cases Activity

::: columns
:::: {.column width=.667}

* \small Slice the Use Cases means to break it up into smaller parts to facilitate development
  - \footnotesize Several alternative paths can be in a single slice.

\vskip.5em

* \small After we implement our chosen slices for each sprint we will need to verify that each one is done and is ready for inclusion in our next Release

::::
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.85\textwidth]{images/UseCases/slide23.png}
\end{center}

::::
:::

# Example of Use Case Slices

Given the use case "Provide Travel Recommendations" the possible initial slices could be:


\centering
\scriptsize

+-------------------------+-----------------------------------------------------+
| **Use-Case Slice Name** | **Use-Case Slice Description**                      |
+:========================+:====================================================+
| Recommendation By       | \#**New** Recommendations based on advertisements   |
| Advertisements          |                                                     |
|                         | \#**Updated** Weighting function for the above      |
|                         | parameters \vskip.25em                              |
+-------------------------+-----------------------------------------------------+
| Sorting by Vicinity     | \#**New** Sorting based on vicinity \vskip.25em     |
+-------------------------+-----------------------------------------------------+
| Handle Favorites        | \#**New** Add selected recommendations to favorites |
|                         |                                                     |
|                         | \#**New** Recommendations based on favorites        |
|                         |                                                     |
|                         | \#**Updated** Weighting function for the above      |
|                         | parameters                                          |
+-------------------------+-----------------------------------------------------+

# Prepare a Use-Case Slice Activity

::: columns
:::: {.column width=.667}

* \small The Prepare a Use Case Slice activity enhances the use-case narrative and the use-case slice test cases to clearly define what it means to successfully implement the use-case slice.

\vskip.5em

* \small This is an activity performed for each slice
  - \footnotesize For brevity, we will show in next slides only one use-case slice: Handle Favorites.

::::
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.85\textwidth]{images/UseCases/slide25.png}
\end{center}

::::
:::

# Preparing "Handle Favorites" Slice

* \small Favorites are just a list, which the application stores.

\vskip0.25em

* \small If a user determines that a recommendation is useful for him/her, he might want to store this recommendation in his favorites list.

\vskip0.25em

* \small This favorite list also acts as an input to the recommendation engine.

\centering
\scriptsize

+----------------------------------+----------------------------------------------------------------------+
| **Use-Case Slice Instance**      | **Use-Case Test Cases**                                              |
+:=================================+:=====================================================================+
| \#**New** Add selected           | 1.) New Favorite                                                     |
| recommendations to favorites     |                                                                      |
|                                  | 2.) Favorite already exists                                          |
|                                  |                                                                      |
|                                  | 3.) Maximum number of favorites \vskip.25em                          |
+----------------------------------+----------------------------------------------------------------------+
| \#**New** Recommendations        | 1.) No Favorites                                                     |
| based on favorites               |                                                                      |
|                                  | 2.) One Favorite within vicinity of traveler destination             |
|                                  |                                                                      |
|                                  | 3.) One Favorite outside vicinity of traveler destination \vskip.25em|
+----------------------------------+----------------------------------------------------------------------+
| \#**Updated** Weighting function | 1.) Weightage of favorites set to zero                               |
| for the above parameters         |                                                                      |
|                                  | 2.) Weightage of favorites set to 0.5                                |
+----------------------------------+----------------------------------------------------------------------+

# Test Use-Case Slice Activity

::: columns
:::: {.column width=.667}

* \small The goal of the Test a Use-Case Slice activity is to verify that the slice is done and ready for inclusion in a release

\vskip.5em

* \small The Use-Case Slice test cases chosen in previous slides are input to this activity.

\vskip.5em

* \small During testing, these test cases are refined further with additional details to make sure that they are repeatable

::::
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\includegraphics[width=.85\textwidth]{images/UseCases/slide27.png}
\end{center}

::::
:::

# Impact of Use Cases for the Team

* \small Use cases helps the team found they could see the big picture of the system better through their use case diagrams and use case model

\vskip.5em

* \small This is made visible by looking at the Use Case Lite’s coverage of the solution activity spaces

\begin{center}
\includegraphics[width=.6\textwidth]{images/UseCases/slide28.eps}
\end{center}

# Monitoring the Project Progress

* \small Teams work with multiple use-case slices from multiple use cases at any point in time.

\vskip0.5em

* \small They complete use-case slices within each sprint
  - \footnotesize i.e. drive them to the Use-Case Slice Verified state.

\vskip0.5em

* \small While individual use-case slices are completed in each sprint, often it requires multiple sprints to complete a full use case.

\vskip1em

* \small How to monitor the progress and health of Use Cases and Use Cases Slices?
  - \footnotesize \textcolor{Roarange}{\textbf{The alpha state cards for Use Case and Use-Case Slices provide a tool for this purpose}}

# Example Project and the Other Practices

\small
\begin{center}
\textcolor{Roarange}{\textbf{\textit{TravelEssence}}} team has chosen multiple practices: Therefore, they have a number of alphas to juggle
\end{center}

From the \textcolor{Buttons}{\textbf{Scrum Lite practice}}

* \scriptsize \textcolor{Roarange}{\textbf{Sprint}} -- focusing on the goals for the Sprint
* \scriptsize \textcolor{Roarange}{\textbf{Product Backlog Item}} -- a change to be made to the product in a future release

\small From the \textcolor{Buttons}{\textbf{Use-Case Lite practice}}

* \scriptsize \textcolor{Roarange}{\textbf{Use-Case Slices}} -- the UC Slices to be Verified by the end of the Sprint
* \scriptsize \textcolor{Roarange}{\textbf{Use Cases}} -- they need not be completed for each sprint, but they are useful for determining which use-case slices should be implemented first.
  - \tiny Thus, different use cases will be at different states at the end of each sprint.

\small From the \textcolor{Buttons}{\textbf{Essence kernel}}

* \scriptsize \textcolor{Roarange}{\textbf{Work}} -- the team needs to maintain the Under Control state as development progresses.
* \scriptsize \textcolor{Roarange}{\textbf{Requirements}} -- the Requirements alpha progresses towards Addressed or Fulfilled depending on the goals of the sprint

# For Next Time

::: columns
:::: column
* Review Chapter 16
* Review this Lecture
* Come to Class
* Watch Lecture 14 Video
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
