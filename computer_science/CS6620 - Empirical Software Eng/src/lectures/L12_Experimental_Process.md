---
author:
- Isaac Griffith
title: Experimental Process
institute: |
  CS 6620

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Introduction

* Starting-Points for experimentation
  - An idea of a cause-effect relationship
  - A theory, or
  - Able to formulate a hypothesis

* Advantages of Experimentation
  - Control of subjects, objects, and instrumentation -> generalization of conclusions
  - Ability to perform statistical analysis
  - Opportunities for replication

# Main Objectives

* **Main objective of experimentation**
  - to evaluate a hypothesis -> hypothesis testing
  - to evaluate a relationship -> relational model building (i.e., regression)

* **Main objective of an experimental process**
  - Provide support in setting up and conducting an experiment

# Experimental Principles

\centering
\includegraphics[width=.8\textwidth]{images/experiments/ex_principles.eps}

# Experimental Design

There are four components to any experimental design:

* Variables
* Treatments
* Objects
* Subjects

# Variables

* In an experiment we study the outcome of the varying of input variables to a process

* There are two kinds of variables in an experiment
  - \color{Roarange}\textbf{Dependent Variables (response variables)} \color{Black} - Those variables we wish to study (often there is only one)
  - \color{Roarange}\textbf{Independent Variables (exploratory variables)} \color{Black} - The variables in a process that are manipulated and controlled

# Features and Treatments

* The independent variables which are varied during an experiment are called \color{Roarange} factors \color{Black}

* The remaining variables are controlled at a **fixed level**, thus allowing us to evaluate cause and effect

* A \color{Roarange}treatment \color{Black} is one particular value of a factor

# Treatments and Variables

\vfill
\centering
\includegraphics[width=.9\textwidth]{images/experiments/treat_var.eps}

# Objects and Subjects

* Treatments are applied to combinations of \color{Roarange} **objects** \color{Black} and \color{Roarange} **subjects** \color{Black}
  * \color{Roarange} **Object:** \color{Black} An artifact to which a treatment (technique, took, process, etc.) is applied
  * \color{Roarange} **Subject:** \color{Black} The people that apply the treatment

* The characteristics of both objects and subjects may be encoded as independent variables

# Experimental Error

* Experiments consist of **tests** (or trials)
* Each test is a combination of **treatment**, **subject** and **object**
* The number of tests affects experimental error and provides a mean effect of any experimental error
* Experimental error affects the confidence in the results of the experiment

# Experimental Orientation

::: columns
:::: column
**Human-Oriented Experiments**

* Subjects: humans
* apply treatments to objects
* Limited control:
  - variability in skills and abilities
  - humans learn over time -> **learning bias**
  - influences and threats to experiments -> human's try to guess experimenter's motivation

::::
:::: column
**Technology-Oriented Experiments**

* Subject: The experimenter
* Easier to control -> technology may be made deterministic
* Independent variable may be the objects selected
* Tools or techniques may be program specific -> thus not applicable to all objects

::::
:::

# Process

* Processes provide guidelines/checklists of
  - what to do
  - how to do it
* The process of an experiment is similar to all other empirical studies.
* Yet, unlike case studies, rather than an incremental approach experiments execute the process just once.

# Process

\centering
\includegraphics[width=.9\textwidth]{images/experiments/ex_process.eps}

# Process

* Starting Point: an insight or idea for an experiment as a means to evaluate what we are interested in
  - Experimentation must be an appropriate empirical method to address the question we are investigating
  - Unfortunately this is usually not obvious as empirical studies are not often used in SE/CS

* Upon having this insight, we must realize that the experiment must be carefully planned

# Activities

* The process is not a "true" waterfall approach
  - Each activity need not finish before starting the next
* The order of activities indicates starting order
  - The process is partly iterative
  - You may need to go back and refine a previous activity before continuing
* The only exception to this is:
  - Once the experiment is started you cannot go back to scoping and planning

# Scoping

* The first activity
* Hypothesis must be stated clearly but not necessarily formally
* Goal is formulated from the problem to be solved
* Scope capturing framework:
  - Object of Study (what is studied?)
  - Purpose (what is the intentions?)
  - Perspective (whose view?), and
  - Context (where is the study conducted?)

# Planning

* lay down the foundation of the experiment
* context is determined in detail (including personnel and environment)
* hypotheses are stated formally (including both null and alternative hypotheses)
* Determine variables and the values they can take, identify scale of variables
  - Independent (inputs)
  - Dependent (outputs)
* Identify subjects

# Planning

* Experiment is designed
  - Design type is selected
  - Preparations are made for instrumenting the experiment
  - Objects identified and prepared
  - Guidelines developed
  - Measurement procedures defined

# Planning

* Considerations of validity
  - Internal: concerned with the validity of the given environment and reliability of results
  - External: a question of how general the findings are
  - Construct: does the treatment reflect the cause construct and does the outcome provide a true picture of the effect construct
  - Conclusion: concerned with the relationship between the treatment and the outcome

# Operation

**Three steps**

1. **Preparation:** prepare subjects and materials needed (e.g., data collection forms)
   - subjects must be informed about intention, consent must be obtained, they must be committed
2. **Execution:** ensure experiment is conducted according to the plan and design, including data collection
3. **Data Validation:** ensure data collected is correct and provides a valid picture of the experiment

# Analysis and Interpretation

* Input: data collected during operation
* Analysis steps
  - Data Visualization
  - Descriptive Statistics for informed understanding
  - Consider reducing the data set
    - reduce number of variables
    - evaluating variables to identify those which provide information
  - Perform hypothesis testing
* Interpretation
  - Decision Making
  - Conclusions

# Presentation and Package

* Documentation of results
  - Research paper
  - Lab package (for replication purposes)

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
