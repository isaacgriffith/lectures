---
author:
- Isaac Griffith
title: Introduction
institute: |
  CS 4458 and CS 5558

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Introduction

What we will do today

* Course Introductions
* Syllabus Review
* Introduce the Course


# Who Am I?

::: columns

:::: {.column width=33%}
\vspace{-1em}
\begin{center}
\includegraphics[width=.9\textwidth]{images/Intro/isaac.jpg}
\end{center}
::::
:::: {.column width=67%}  

Isaac Griffith

Assistant Professor of Computer Science

\vskip.75em

Education at Montana State University:

* PhD, MS, BS in Computer Science
* Graduate Certificate in Applied Statistics
* BA in Philosophy at Montana State University

\vskip.75em
Research Interests:

* Empirical Software Engineering
* Augmented and Mixed Reality
* Software Quality
* Software Architecture

::::
:::

# Student Introductions

**Round-Robin Style**

* Your (preferred) Name
* Your year in school
* Your major
* Something interesting about you

# Student Participation Expectations

* Your success in this course relies heavily on your own participation in class.
* You are expected to bring a laptop or other computation device to class each day.
* Each class session will have 1--2 participation activities in which students will work either in groups or individually to solve problems

# Academic Integrity

\vspace{-1em}

* ISU Academic Integrity and Dishonesty Policy can be found at: \url{http://coursecat.isu.edu/undergraduate/academic_integrity_and_dishonesty_policy/}
* Academic Dishonesty is broken down into two groups:

  * Cheating
  * Plagiarism

\vspace{-1.5em}
::: columns
:::: column

* Instructor-Level Penalties:

  * Written Warning
  * Re-submission of work
  * Grade reduction
  * Fail the course

::::
:::: column

* University-Level Penalties:

  * Suspension
  * Expulsion

::::
:::  

* My Policy

  * First-time: Grade Reduction (i.e., fail the associated graded item)
  * Second-time: Fail the Course

# How We Will Spend Class Time

**Each Session will contain:**

* Lecture covering 2 or 3 major topics
* Individual/Group Active Learning exercises related to a major concept.


# How to Study and Prepare for Class

::: columns
:::: column

* Before each Lecture

  * Complete the Readings
  * Complete the Quiz
  * Review Lecture Notes
  * Write down any questions you have

* Come to lecture
* During lecture

  * Listen
  * Participate by asking questions
  * Participate in in-class activities
  * Take notes

::::
:::: column

* After Lecture

  * Review notes
  * Stop by my Office Hours or make an Appointment
  * Complete the assignments

::::
:::

#

\vfill
**Computer Graphics:** The study of creating, manipulating, and using visual images in the computer

#

\vfill
**Computer Graphics:** What you need to show other people your dreams

# Graphics Applications

* Entertainment
  - Film production
  - Film effects
  - Games
* Science and Engineering
  - Computer-aided design
  - Visualization (scientific, information)
* Virtual Prototyping
* Cultural Heritage
* Training & Simulation
* Graphic Arts, Fine Art

# Graphics Applications

* Entertainment
  - Film production
  - Film effects
  - Games

#

\begin{center}
\includegraphics[width=.95\textwidth]{images/Intro/brave.jpg}
\end{center}

*Disney Pixar--Brave*

#

\begin{center}
\includegraphics[width=.95\textwidth]{images/Intro/blue_umbrella.jpg}
\end{center}

*Pixar--The Blue Umbrella (2013)*

#

\begin{center}
\includegraphics[width=.95\textwidth]{images/Intro/hobbit.jpg}
\end{center}

*The Hobbit: An Unexpected Journey (New Line Cinema, 2012) -- visual effects by Weta Digital*

#

\begin{center}
\includegraphics[width=.95\textwidth]{images/Intro/crysis.jpg}
\end{center}

*Crytex--Crysis 3 (2013)*

#

\begin{center}
\includegraphics[width=.95\textwidth]{images/Intro/skyrim.jpg}
\end{center}

*Bethesda--Skyrim*

# Graphics Applications

* Science and Engineering
  - Computer-aided design
  - Visualization (scientific, information)

\begin{center}
\includegraphics[width=.5\textwidth]{images/Intro/alpha1.jpeg}
\end{center}

U. of Utah--Alpha I

#

\begin{center}
\includegraphics[width=.5\textwidth]{images/Intro/deformed.png}
\end{center}

Simulated Deformation of citrate synthase during substrate binding

#

\begin{center}
\includegraphics[width=.5\textwidth]{images/Intro/sintel_test.png}
\end{center}

Blender Sintel Test

# Graphics Applications

* Virtual Prototyping

<!-- #

\begin{center}
\includegraphics[width=.95\textwidth]{images/Intro/autodesk.jpg}
\end{center}
-->

#

\begin{center}
\includegraphics[width=.95\textwidth]{images/Intro/autodesk2.jpg}
\end{center}

#

\begin{center}
\includegraphics[width=.95\textwidth]{images/Intro/david.jpg}
\end{center}

# Graphics Applications

* Graphic Arts, Fine Arts

\begin{center}
\includegraphics[width=.95\textwidth]{images/Intro/akleman.jpg}
\end{center}

# Think-Pair-Share

\begin{minipage}{50pt}
  \includegraphics[width=50pt]{images/5-minutes.png}
 \end{minipage}
 \begin{minipage}[adjusting]{4in}
 Take 2 minutes and think about the following question:
 \end{minipage}
 \vskip1em
 \begin{minipage}{50pt}
  \includegraphics[width=50pt]{images/brainstorming.png}
 \end{minipage}
 \begin{minipage}[adjusting]{4in}
 Given the nature of software and the changes that have happened in your lifetime, what can we say about the changes we may see in the future? How do you think we will be building software in the next 5 years?
 \end{minipage}
 \vskip1em
 \begin{minipage}{50pt}
  \includegraphics[width=50pt]{images/idea.png}
 \end{minipage}
 \begin{minipage}[adjusting]{4in}
 Pair up with your neighbor and take the next few minutes to discuss your thoughts.
 \end{minipage}

#

\vfill
\begin{center}
{\Huge Course Overview}
\end{center}

# Course Mechanics

**You will:**

* Explore fundamental ideas
* Utilize mathematics to generate graphics
* Implement key algorithms
* Write awesome programs
* Learn the basics of OpenGL

**You will not:**

* write very big programs

# General Topics

* Images, image processing, color science
* Modeling in 2D and 3D
* Rendering 3D scenes
  - Using the GPU and possibly ray tracing
* Geometric transformations
* The graphics pipeline
* Animation

# Prerequisites

**Programming**

* Ability to read, write, and debug small C++ programs (10s of classes)
* Understanding of very basic data structures
* No serious software design will be required

**Mathematics**

* Vector geometry (dot/cross products, etc.)
* Linear algebra (just simple matrices in 2-4D)
* Basic calculus (simple derivatives)
* Graphics is a good place to pick up some, but not all, of this.

# Assignments

**Through the assignments you will:**

* Go deeper into OpenGL
* Propose and implement an independent project
* Learn more about
  - OpenGL
  - Architecting good-sized interactive Programs
  - Graphics topics of your choosing!

# Workload

* 5 Assignments (written + programming)
* 2 Exams
* One open-ended project

# Grade Distribution

+------------------+------------------------+
| Grade Event Type | Percent of Final Grade |
+:=================+:======================:+
| Homework         | 30%                    |
+------------------+------------------------+
| Project          | 35%                    |
+------------------+------------------------+
| Exams            | 25%                    |
+------------------+------------------------+
| Outreach         | 10%                    |
+------------------+------------------------+

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Review the Syllabus and Schedule
* Read Chapter 1
* Install OpenGL on your System
* Install CLion (if you don't already have it)
