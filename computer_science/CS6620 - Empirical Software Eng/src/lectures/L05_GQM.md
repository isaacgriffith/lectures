---
author:
- Isaac Griffith
title: Goal Question Metric (GQM) Method
institute: |
  CS 6620 - Empirical Software Engineering

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outline

At the end of today's lecture you should be able to:

* Understand the basics of the GQM
* Understand the components the GQM
* Be able to generate goals, questions, and metrics using the GQM Method

# Introduction

* Goal-Question-Metric (GQM) has been proposed by Basili and Weiss
* It is a technique to identify meaningful metrics for the measurement process
* You may want to use the GQM method to choose the appropriate metric

# GQM Overview

* Questions are formulated based on a more abstract goal
* Metrics are selected to answer each question
* GQM emphasizes the need to
  - Establish an explicit measurement goal
  - Define a set of questions to achieve the goal
  - Identify metrics to answer the questions

# The GQM Method

* Goals
  - They define What the organization wants to improve

* Questions
  - They refine each goal to a more quantifiable way

* Metrics
  - They indicate the measurable quantities necessary to answer each question

# GQM Representation

\centering
\includegraphics[width=.85\textwidth]{images/gqm/gqm01.eps}

# Example (1)

* Goal
  - Increase productivity

* Questions
  - What are productivity bottlenecks?
  - How can we increase the amount of code we produce?

* Metrics
  - Current lines of code (LOC) per developer

# Example (2)

* Goal
  - Decrease development time

* Questions
  - What are the bottlenecks?
  - How to decrease specification time?

* Metrics
  - Time required for requirements
  - Time required for modeling

# Goal Definition Template

**Analyze** {Object(s) of study}

**for the purpose of** {Purpose}

**with respect to** {Quality focus}

**from the viewpoint of** {Perspective}

**in the context of** {Context}

# Example Components for Goals Def

+---------------------+--------------+-------------------+-------------------+
| **Object of study** | **Purpose**  | **Quality Focus** | **Perspective**   |
+:====================+:=============+:==================+:==================+
| Product             | Characterize | Effectiveness     | Developer         |
+---------------------+--------------+-------------------+-------------------+
| Process             | Monitor      | Cost              | Modifier          |
+---------------------+--------------+-------------------+-------------------+
| Model               | Evaluate     | Reliability       | Maintainer        |
+---------------------+--------------+-------------------+-------------------+
| Metric              | Predict      | Maintainability   | Product Manager   |
+---------------------+--------------+-------------------+-------------------+
| Theory              | Control      | Portability       | Corporate Manager |
+---------------------+--------------+-------------------+-------------------+
|                     | Change       |                   | Customer          |
+---------------------+--------------+-------------------+-------------------+
|                     |              |                   | User              |
+---------------------+--------------+-------------------+-------------------+
|                     |              |                   | Researcher        |
+---------------------+--------------+-------------------+-------------------+


# Example Goals

* RG1: **Analyze** the Health Watcher software architecture **for the purpose of** evaluating architectural components **with respect to** the ability to make Health Watcher more extensible **from the viewpoint of** the software architects performing the work **in the context of** product enhancement over the next three years.

* RG2: **Analyze** the PBR and checklist techniques **for the purpose of** evaluation **with respect to** effectiveness and efficiency
**from the point of view** of the researcher **in the context of** M.Sc. and Ph.D. students reading requirements documents.

# Example Questions for RG1

* Q1: Are architectural components characterized in a manner that modularizes function and related data?

* Q2: Is the complexity of each component within bounds that will facilitate modification and extension?

# Examples of Metrics

* To answer Q1
  - Coupling metrics
  - Cohesion metrics

* To answer Q2
  - Component Size
  - Interface Complexity

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
