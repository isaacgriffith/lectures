---
author:
- Isaac Griffith
title: Course Introduction and Empirical Methods
institute: |
  CS 6620 - Empirical Software Engineering

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# A Thought

\vfill
\centering
> "Science, done right, works hard to respect absolutely no authority at all other than experience and empirical data. It never succeeds entirely, but it comes closer and has a better track record than any other method we apes have found for learning about the world around us." -- Adam Becker

#

\centering
\vfill
\Huge Syllabus Review

# Course Outline

::: columns
:::: column

**Part 1:** The Basics

* Wk 01: Introduction
* Wk 02: Measurement, Validity, GQM, and Replication
* Wk 03: Scientific Writing

**Part 3:** Evaluation

* Wk 11: Case Study Discus
* Wk 12: Experiment Discus
* Wk 13: Survey/Interview Discus
* Wk 14: Secondary Study Discus

::::
:::: column

**Part 2:** Empirical Methods

* Wk 04: Case Studies
* Wk 05: More on Case Studies
* Wk 06: Experiments
* Wk 07: More on Experiments
* Wk 08: Surveys, Focus Groups and Interviews
* Wk 09: Secondary Studies
* Wk 10: Simulations

**Part 4:** Final Project Presentation

* Wk 15: Presentations

::::
:::

# Course Evaluation

* Students will be evaluated in the following ways:
  - 60% of your grade is based on the Research Project
  - 28% of your grade is based on discussion leadership (4)
  - 12% of your grade is based on class participation

# Research Project

* As this is a 6000 level graduate course, you are expected to complete an individual research project focused on empirical evaluation within the domain of software engineering.
* The project requires that you apply one of the following 5 research methods:
  - Experiment
  - Case Study
  - Secondary Study (SLR/SMS)
  - Simulation Study
  - Replication Study
* The research you conduct must be novel or present novel results.

# Research Project

* The research project is subdivided into 3 components each with 2 graded events:
  - Project Topic Selection
    - Topic Selection Report (12.5%)
    - Topic Selection Presentation/Discussion (7.5%)
  - Project Proposal
    - Project Proposal Report (25%)
    - Project Proposal Presentation/Discussion (7.5%)
  - Final Project
    - Final Project Report (40%)
    - Final Project Presentation/Discussion (7.5%)

#

\centering
\vfill
\Huge Conducting Research

# Is this your research plan?

1. Build a new tool
2. ??
3. Profit

# Engineering vs. Science

**Traditional View:**

::: columns
:::: column

\color{Roarange}Scientists...\color{black}

* Create knowledge
* Study the world as it is
* Are trained in scientific method
* Use explicit knowledge
* Are thinkers

::::
:::: column

\color{Roarange}Engineers...\color{black}

* Apply that knowledge
* Seek to change the world
* Are trained in engineering design
* Use tacit knowledge
* Are doers

::::
:::

# Engineering vs. Science

**More Realistic View:**

::: columns
:::: column

\color{Roarange}Scientists...\color{Black}

* Create knowledge
* Are problem-driven
* Seek to understand and explain
* Design experiments to test theories
* Prefer abstract knowledge
* But rely on tacit knowledge

::::
:::: column

\color{Roarange}Engineers...\color{Black}

* Create knowledge
* Are problem-driven
* Seek to understand and explain
* Design devices to test theories
* Prefer contingent knowledge
* But rely on tacit knowledge

::::
:::

\centering
**Both involve a mix of design and discovery**

# Scientific Method

* No single "official" scientific method
* Somehow, scientists are supposed to this:

\centering
\includegraphics[width=.85\textwidth]{images/intro/intro02.eps}

#

\centering
\vfill
\Huge Observe!

# Scientific Inquiry

\centering
\includegraphics[width=.65\textwidth]{images/intro/intro03.eps}

# Some Characteristics of Science

* Science seeks to improve our understanding of the world.
* Explanations are based on observations
  - Scientific truths must stand up to empirical scrutiny
  - Sometimes "scientific truth" must be thrown out in the face of new findings

* Theory and observation affect one another:
  - Our perceptions of the world affect how we understand it
  - Our understanding of the world affects how we perceive it

* Creativity is important
  - Theories, hypotheses, experimental designs
  - Search for elegance, simplicity

# All Methods are Flawed

* E.g. Laboratory Experiments
  - Cannot study large scale software development in the lab!
  - Too many variables to control them all

* E.g. Case Studies
  - How do we know what's true in one project generalizes to others?
  - Researcher chose what questions to ask, hence biased the study

* E.g. Surveys
  - Self-selection of respondents biases the study
  - Respondents tell you what they think they ought to do, not what they actually do

* ...etc...

# Strategies to overcome weaknesses

* Theory-building
  - Testing a hypothesis is pointless (single flawed study!)...
  - ...unless it \color{Roarange}builds evidence for a clearly stated theory\color{black}

* Empirical Induction
  - Series of studies over time...
  - Each designed to probe more aspects of the theory
  - ...together \color{Roarange}build evidence for a clearly stated theory\color{black}

* Mixed Methods Research
  - Use multiple methods to investigate the same research question
  - Each method compensates for the flaws of the other
  - ...together \color{Roarange}build evidence for a clearly stated theory\color{black}

# Reasoning

The 3 Types of Reasoning

* Deductive - Making an inference based on widely accepted facts or premises
* Inductive - Making an inference based on an observation, often a sample
* Abductive - Making a probable conclusion from what you know.

# Reasoning

\begin{center}
\includegraphics[width=.85\textwidth]{images/intro/intro01.eps}
\end{center}

# Example

::: columns
:::: column
* Deduction:
  - Rule: All swans are white
  - Fact: Daisy is a swan
  - Conclusion: Daisy is white

* Induction:
  - Case 1: Daisy is a swan & white
  - Case 2: Danny is a swan & white
  - Case 3: Dante is a swan & white
  - Rule: All swans are white
::::
:::: column
* Abduction:
  - Rule: All swans are white
  - Case: Daisy is white
  - Conclusion: Daisy is a swan
::::
:::

# Reasoning and Empiricism

\centering
\includegraphics[width=0.75\textwidth]{images/intro/intro04a.eps}

# Reasoning and Empiricism

\centering
\vfill
\includegraphics[width=0.95\textwidth]{images/intro/intro04b.eps}

# What is a research contribution?

* A better understanding of how people use software technology?
* Identification of problems with the current state-of-the-art?
* A characterization of the properties of new tools/techniques?
* Evidence that approach A is better than approach B?

\centering
\color{Roarange}\Large How will you validate your claims? \color{black}

# Thinking about Research

* What was the research question?
  - i.e. "Is tool A better than tool B?"
* What would count as an answer?
* What use would the answer be?
  - How is it a "contribution to knowledge"?
* How does this evaluation relate to the existing literature?

# Experiments as Clinical Trials

\centering
\includegraphics[width=.85\textwidth]{images/intro/intro05.eps}

#

\centering
\includegraphics[width=.85\textwidth]{images/intro/intro06.eps}

# Some Definitions

* A \color{Roarange}model\color{black} is an abstract representation of a phenomenon or set of related phenomena
  - Some details included, others excluded
* A \color{Roarange}theory\color{black} is a set of statements that explain a set of phenomena
  - Serves to explain and predict
  - Precisely defined terminology
  - Concepts, relationships, causal inferences
  - (operation definitions for theoretical terms)
* A \color{Roarange}hypothesis\color{black} is a testable statement derived from a theory
  - A hypothesis is not a theory!
  - It does not predict but simply states how the world apparently is.
* In CS, we have mostly \underline{folk theories}

# A Simpler Definition

\centering
\vfill
\Huge A (good) \color{Roarange}Theory\color{black}\ is the

best explanation of all

the available evidence

# The Role of Theory Building

* Theories lie at the heart of what is means to do science.
  - Production of generalizable knowledge
* Theory provides orientation for data collection
  - Cannot observe the world without a theoretical perspective
* Theories allow us to compare similar work
  - Theories include precise definition for the key terms
  - Theories provide a rationale for which phenomena to measure
* Theories support analytical generalization
  - Provide a deeper understanding of our empirical results
  - ...and hence how they apply more generally
  - Much more powerful than statistical generalization

# What Type of Question are you asking?

* Exploratory
* Baserate
* Correlation
* Causal Relationship
* Design

# Exploratory Questions

* Existence:
  - Does X exist?
* Description and Classification
  - What is X like?
  - What are its properties?
  - How can it be categorized?
  - How can we measure it?
  - What are its components?
* Descriptive-Comparative
  - How does X differ from Y?

# Baserate Questions

* Frequency and Distribution
  - How often does X occur?
  - What is an average amount of X?
* Descriptive-Process
  - How does X normally work?
  - By what process does X happen?
  - What are the steps as X evolves?

# Correlation Questions

* Relationship
  - Are X and Y related?
  - Do occurrences of X correlate with occurrences of Y?

# Causal Relationship Questions

* Causality
  - Does X cause Y?
  - Does X prevent Y?
  - What causes X?
  - What effect does X have on Y?
* Causality-Comparative
  - Does X cause more Y than does Z?
  - Is X better at preventing Y than does Z?
  - Does X cause more Y than does Z under one condition but not others?

# Design Questions

* What is an effective way to achieve X?
* How can we improve X?

# Putting the Question in Context

\centering
\includegraphics[width=.85\textwidth]{images/intro/intro07.eps}

# Many Available Methods

::: columns
:::: column

\color{Roarange}**Common "in the lab" methods**\color{Black}

* Controlled Experiments
* Rational Reconstructions
* Exemplars
* Benchmarks
* Simulations

::::
:::: column

\color{Roarange}**Common "in the wild" methods**\color{Black}

* Quasi-experiments
* Case studies
* Survey research
* Ethnographies
* Action research

::::
:::

\centering
* Artifact/Archive analysis ("mining"!)

# Warning

* No method is perfect
* Don't get hung up on methodological purity
* Pick something and get on with it
* Some knowledge is better than none

# Why build a tool?

* Build a tool to test a theory
  - Tool is part of the experimental materials needed to conduct your study
* Build a tool to develop a theory
  - Theory emerges as you explore the tool
* Build a tool to explain your theory
  - Theory as a concrete instantiation of (some aspect of) the theory

# Myths about Science

* "It's just a theory"
  - Theory = "best explanation for the available evidence"
  - Overwhelming evidence doesn't stop it being a theory...
  - ...but lack of evidence does.

::: columns
:::: column

::::
:::: column
Examples:

We have a "law of gravity" ...but no "theory of gravity"

We have a "theory of evolution" ...but no "law of evolution"
::::
:::

# Myths about Science

* "Scientists follow the scientific method"
  - There is no one method
  - Many methods available...
  - ...and all of them have known flaws
  - Scientists use imagination, creativity, prior knowledge, perseverance...

* "Scientific knowledge is general and absolute"
  - Empirical Induction used to build evidence
  - Scientists often get it wrong
  - ...but Science (as a process) is self-correcting
  - All scientific laws and theories have limited scope
    * E.g. biological theories probably only apply on our own planet
    * E.g. laws of classical physics don't apply at the subatomic level

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
