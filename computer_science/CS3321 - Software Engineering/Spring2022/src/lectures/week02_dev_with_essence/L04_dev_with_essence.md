---
author:
- Dr. Isaac Griffith
title: Developing with Essence
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
* Understand how to apply essence in small scale development
* Understand how to use essence to track progress and perform basic planning
* Understand how to play "Serious Games"
* Understand several techniques to track the progress and health of your endeavor
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears.jpg}
::::
:::

# Applying Essence in the Small

* Software Development team performance is strongly dependent upon effective communication, common understanding and trust.
  - Having a simple practical way to share our approach to Software Development and the guidelines that drive our decision is key
* Essence kernel and practice elements can be represented as poker-sized cards.
  - A card provides a concise description of the most important information about its element.
* Essence can be used leveraging these cards to facilitate team discussions and agreements
  - in a tacit manner without explicitly described practices on top of it.
  - we will also introduce some simple, small but very useful techniques to facilitate working together within a team

\centering

**We call these techniques games – serious games**

# Playing Serious Games

* The serious games utilized in software engineering are:
  - collaborative cooperative games rather than competitive games
* Serious games helps achieve several key goals
  - Facilitate team communication, needed because different members within a team often have different backgrounds, experiences and project status perceptions
  - Players must express their thoughts clearly, listen to one another, share information and resources, learn from one another, identify solutions, negotiate, and make common decisions
  - Teams can use the cards to look ahead at states and checklists not yet achieved thus stimulating discussion on what is most important to do next.
* We will introduce four games using Alpha State Cards:
  1. Progress Poker
  2. Chasing the State
  3. Objective Go
  4. Checkpoint Construction

#

\centering
\vfill
\begin{minipage}{.45\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Serious Games
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Game 1: Progress Poker

* One of the most important questions teams often face is “Are we done?” referring to a particular piece of work being completed.
* While there are several definitions of done, Essence definition relates
to:
  - the movement of an alpha from one state to another state
* The goal of this game is to assess the state achieved by an Alpha

::: columns
:::: {.column width=.667}

For example:

* **Software System** alpha:
  - Over the lifecycle of a software system it moves over six different states.
* **What does it take for example to move from _Architecture Selected_ to _Demonstrable_?**
  - The State card Demonstrable has a checklist of what it means to have achieved such state
  - Yet, the team could be in disagreement on some of the checklist items

::::
:::: {.column width=.333}

\includegraphics[width=.65\textwidth]{images/Essence/slide6.eps}

::::
:::

# Why play Progress Poker

* Take for instance the item:
  - Key architectural characteristics demonstrated.
* Is the meaning of this checklist item clear?
  - Some people would say they know what it means, but within a team members can make several interpretations.
    * One team member may say that this means that the key architectural characteristics have been agreed to and demonstrated to the team members,
    * Another may think it means the agreement and demonstration must involve external stakeholders.
  - It is true that the checklist items do not provide a precise definition.
    * If they were they would likely be unintelligible to most developers.
* They are subject for interpretation by the team members
* **One way to reach an agreement is by playing the game Progress Poker.**

# How to play Progress Poker

* Progress Poker is a game played to facilitate the discussion and achieve understanding of the current state of a particular alpha.
  - It is played one alpha at the time
  - Each team member should have the full deck of cards
* For the particular alpha the team is trying to gain an
understanding of the current state, you need
  - the Alpha Overview card and
  - the Alpha State cards
* There is no single winner
  - The winner is the whole team and **the winning hand is the team’s common agreement on the endeavor status**
* Progress Poker may be played by any number of players
  - Teams consisting of three to nine players are most effective

# Requirements state with Progress Poker

As an example: these are the cards used to assess the requirement alpha state

\centering
\includegraphics[width=.65\textwidth]{images/Essence/slide9.eps}

# A Progress Poker Hand

::: columns
:::: column

\footnotesize

\begin{itemize}
\item Place the alpha card being assessed in the center of the table
\item \textbf{Each player selects from their deck the state card that represents the state of that Alpha, in their opinion}, and places it on the table covered (confidential)
\begin{itemize}
  \scriptsize
  \item So, they make sure that everyone's initial opinion is not affected any anyone else's opinion.
\end{itemize}
\item The players then turn their chosen state card face up and compare the results
\only<2>{
\item \textbf{If all players have selected the same state card}
\begin{itemize}
  \scriptsize
  \item They have the same understanding of the endeavor status
  \item The game is over
\end{itemize}}
\only<3>{
\item \textbf{If the cards are different}
\begin{itemize}
  \scriptsize
  \item The players have to discuss their choices
  \item Usually, the players with the least and the most advanced states should start the discussion motivating their reasons
  \item The discussion helps to reveal the details of the endeavor status
\end{itemize}}
\end{itemize}
::::
:::: column

\footnotesize

* After the discussion a next round of status card selection is done
* The **game ends as soon as a consensus is reached** on the current state that has been achieved for a particular alpha
* There is no fixed duration of the game
  - \scriptsize Teams familiar with the states and checklists may only take a few minutes to play

* In contrast to the original poker game, **everyone has to take part** in all the rounds of the game
  - \scriptsize The winning hand here is the agreement of the entire team

::::
:::

# TravelEssence Example

::: columns
:::: column

\footnotesize

* Smith and his team are assigned to add to TravelEssence a recommendation engine for travellers
  - \scriptsize Specifically to recommend hotels and discount deals to travellers based on their travel history

::::
:::: column

\footnotesize

* The team played the Progress Poker game seven times
  - \scriptsize once for each alpha
* They were already initially in agreement for all the alphas except for **Stakeholders** and **Requirements** alphas

::::
:::

\vskip.5em

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/Essence/slide11a.eps}

::::
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/Essence/slide11b.eps}

::::
:::

# Team Positions and Discussion

::: columns
:::: column

**Smith's position**

\footnotesize

* Smith thought the Stakeholders were quite well represented and the members were actively involved helping the team.
  - \scriptsize For example, Angela, as a business analyst was a key stakeholder who he had been talking to about the requirements for the recommendation engine
* Smith thought the Requirements were fairly clear
  - \scriptsize Because of the work Angela had done

::::
:::: column

**Grace's position**

\footnotesize

* Grace pointed out that in the past, business analysts frequently did not represent stakeholders well
  - \scriptsize They would say one thing, and when it was close to delivery, some higher-level authority would say something quite different.
  - \scriptsize Therefore, Grace saw the Stakeholders as Represented, but not Involved.
* Grace also pointed out that it was not clear how the new requirements would affect the existing functionality of the Hotel Management System (HMS).
  - \scriptsize Therefore, Grace saw the Requirements as Bounded, but not Coherent

::::
:::

# After the discussion

* Smith agreed that while Angela had completed some relevant analysis she had not yet gone back to the customer stakeholders to gain their agreement.
  - This created a risk to the endeavor and they all agreed the *Stakeholder* current state is: **Represented**
* They also agreed the *Requirements* had achieved the **Bounded** state, but more work was needed to get to the Coherent state.

# Game 2: Chasing the State

* Often teams are in agreement on which states most of the alphas have without having to play Progress Poker
  - they just look at the cards for each alpha and agree on which state has been achieved
  - this faster way for achieving team agreement on where they are for all the alphas is represented by this card game

* **The goal of this game is to quickly assess the state achieved by all Alphas**

* This game is initiated by laying out all the cards on a table for each alpha.
  - To the very left is the alpha overview card with a picture of all the states of the alpha.
  - To the right are all the alpha state cards with the first state card on the left and the last state card on the right.

# Chasing the State initial board

\includegraphics[width=.8\textwidth]{images/Essence/slide14.eps}

# Assessing Stakeholder State

* The first card for the Stakeholder alpha is discussed
* The team studies the first Stakeholder card (left) and agrees that all criteria are fulfilled, that is the state *Recognized* has been achieved

\centering
\includegraphics[width=.55\textwidth]{images/Essence/slide15.eps}

# Chasing the State: Step 1

As a consequence that all items in the first state card checklist are marked **Done**

* That card is moved to the left on the table

\includegraphics[width=.75\textwidth]{images/Essence/slide16.eps}

# Chasing the State: Steps 2 & 3

The game continues and the second Stakeholder state card is examined

\scriptsize

* The team agrees that this state has also been achieved
  - \tiny So that card is also moved to the left close to the first state card
* Thus, the third state card is studied
  - \tiny Here the team agrees that the criteria are not fulfilled so this card is not moved and it stays were it is.

\includegraphics[width=.6\textwidth]{images/Essence/slide17.eps}

# Chasing the State: ... at Game Over

\scriptsize

* The Chasing the State continues with the *Opportunity* alphas, the *Requirements* alpha, etc.
  - \tiny In this example we ended up with the situation shown
* If the team can't easily agree on a specific alpha, they can play Progress Poker for the particular alpha that is not easy to agree upon

\includegraphics[width=.7\textwidth]{images/Essence/slide18.eps}

# Game 3: Objective Go

\begin{center}
\textbf{The Objective Go game is played to agree upon where you need to go next.}
\end{center}

\footnotesize

* To know where to go next you of course need to know where you are.
  - \scriptsize This game is played after you have assessed the current states of all the alphas after you have played the Chasing the State game.
* Let us therefore take the start position for the game as in the previous figure
  - \scriptsize In this position, the team asks the question
    * \tiny "Which is the next step we should take to progress the endeavor?"
    * \tiny "Which are the next set of alpha states we shoujld achieve?" (in Essence words)
* The team decides that their goal is to progress the state of several selected Alphas
  - \scriptsize We have learned through experience that the alphas often progress in "waves" that cross multiple Alphas
* A simple example is
  - \scriptsize \textbf{Rquirements} alpha cannot be progressed without also progressing the **Stakeholders** alpha
  - \scriptsize to achieve the *Coherent state* of **Requirements** you need to have **Stakeholders** *Involved*

\begin{center}
\textbf{The outcome of this game is the list of alphas to which\\ we want to focus on to progress the state}
\end{center}

# Ex Goal: Software System @ Demonstrable

* As an example we assume the team agreed their next goal is to reach the Software System: Demonstrable state
  - This means the team agrees that there are checklist item(s) in the Demonstrable state that have not been achieved

::: columns
:::: column

\footnotesize

* Suppose the team felt they had not demonstrated a key performance requirement to a key stakeholder
  - \scriptsize The team would then discuss and agree to conduct a demonstration for that key stakeholder
* The team looks at each alpha deemed interesting to progress in the next step
  - \scriptsize For each alpha they discuss the next state that should be achieved
  - \scriptsize which checklist items for that state are not yet achieved
  - \scriptsize What tasks they need to do to get there

::::
:::: column

\vspace{-1em}
\includegraphics[width=.7\textwidth]{images/Essence/slide20.eps}

::::
:::

# The Objective Go targets in the board

For each alpha the team has agreed to progress to a higher state, its corresponding state card is moved to the middle of the table as shown here

\includegraphics[width=.7\textwidth]{images/Essence/slide21.eps}

# Game 4: Checkpoint Construction

\footnotesize

* Usually, organizations have defined lifecycles that consist of phases that are separated by checkpoints
  - \scriptsize Checkpoints are intentionally independent of the practices a team agrees to use because one of their main purposes is to assess the endeavor from different viewpoints such as value, funding, readiness.
  - \scriptsize In this sense checkpoints can be viewed as critical points in the life cycle of an endeavor where the definition of "done" for the phases needs to be specified.
  - \scriptsize At each checkpoint, a decision is made whether to proceed to the next phase or not

* Since an endeavor can have many teams working in parallel, to synchronize between the teams, they usually all need to have the same checkpoints.

* Therefore, the checkpoints for an endeavor are normally specified by the stakeholders of the whole endeavor and not by every team participating in the endeavor.

\begin{center}
\textbf{The Checkpoint Constrution game is played}\\
\textbf{to specify agreed checkpoints of the project life cycle}
\end{center}

* This game is played by the stakeholder team, or a few of the key stakeholders.

# Checkpoint Construction Example

* To illustrate the use of this technique, we will use a simple lifecycle made up of three phases:
  - pre-development, development, and post-development
* The game is played for **one checkpoint and in two rounds**
  - One stakeholder accepts the role of facilitator and lays out on the table the seven Alpha Overview cards.
  - The facilitator next describes the checkpoint being considered
    * For this example we assume to aim: **Ready for Development checkpoint**

# 1st Round of Checkpoint Construction

* In the first round each stakeholder considers each of the seven alphas and decides which ones should be considered as part of the checkpoint.
  - They each jot down their choices
  - Then the facilitator for each Alpha Overview card asks the team whether that alpha should be considered in the checkpoint.
    * Each player responds to that question using a thumbs up/thumbs down.

::: columns
:::: column

**In this round the stakeholders just agree on which alphas should be considered for the checkpoint**

::::
:::: column

\includegraphics[width=.8\textwidth]{images/Essence/slide24.eps}

::::
:::

# 2nd Round of Checkpoint Construction

* The facilitator lays out all of the alpha state cards horizontally across the table for all of the selected alphas to be considered for the checkpoint.
  - Each player considers the set of states for each alpha and without informing the other players they identifies the state they believe the alpha needs to be in to pass the checkpoint
* When everyone is ready the players simultaneously share their decision
  - If all players have selected the same state there is consensus
  - If not, the players with the least and most advanced states explain their reasoning
* After discussion the players again vote for the state to achieve until they reach consensus

# Checkpoint Construction conclusions

* The outcome of this game is
  - The list of Alphas
  - For each Alpha, the state that are being assessed to evaluate the checkpoint achievement

* Once the states are agreed the facilitator leads the group through a discussion of potentially additional checklist items to be added for this checkpoint.,
  - In this way the generic checklist items on the cards can be tailored to the context of the specific endeavor

# Reflection on Serious Games

* We found that these serious games using Essence can provide effective facilitation techniques
  - Ideas are never absent when knowledgeable workers come together
  - Cards provide a good avenue to bring these ideas to reality very quickly
  - They engage all members of the team, not just the most vocal or the most experienced or competent
  - The time spent is limited and results are important for project success
* Engaging discussions help
  - the team to think about issues they might not think of from just their own personal experiences
  - They need to agree what those issues mean to their endeavor
  - Ultimately this helps the team address issues and risks early before they become major problems.
* These games and the discussions that are produced help:
  - to keep the endeavor on a healthy course
  - team members learn to collaborate effectively
  - to bring the team together

#

\centering
\vfill
\begin{minipage}{.525\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Tracking Progress
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Cumulative Flow Diagrams

\includegraphics[width=.85\textwidth]{images/Essence/cfd.png}

https://www.microtool.de/en/knowledge-base/what-is-a-cumulative-flow-diagram/

# Kernel State Evolution

\begin{table}[]
\begin{tabular}{lcccccc}
\hline
 & \thead{Start of\\ Iteration 1} & \thead{End of\\ Iteration 1} & \thead{End of\\ Iteration 2} & \thead{End of\\ Iteration 3} & \thead{End of\\ Iteration 4} & \thead{Target} \\ \hline
\textbf{Stakeholders} & 1 & 3 & 4 & 4 & 5 & 5 \\
\textbf{Opportunity} & 2 & 3 & 3 & 3 & 3 & 3 \\
\textbf{Requirements} & 1 & 2 & 5 & 5 & 6 & 6 \\
\textbf{\makecell{Software\\ System}} & 1 & 2 & 2 & 4 & 4 & 4 \\
\textbf{Work} & 1 & 3 & 4 & 4 & 5 & 5 \\
\textbf{Team} & 2 & 3 & 4 & 4 & 4 & 4 \\
\textbf{\makecell{Way of\\ Working}}  & 1 & 3 & 3 & 4 & 5 & 5 \\ \hline
\end{tabular}
\end{table}

# Radar Charts

::: columns
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/Essence/radar1.png}

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/Essence/radar2.png}

::::
:::

https://chachart.net/radar?lang=en

# For Next Time

::: columns
:::: column
* Review Essentials Chapters 8 - 9
* Review this Lecture
* Come to Class
* Read Essentials Chapter 10 and 13
* Review Lecture 05
* Watch Lecture 05
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
