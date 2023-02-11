---
author:
- Isaac Griffith
title: Conducting Research
institute: |
  CS 4422 and CS 5599

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

At the end of this lecture you should be able to:

* Understand the research process
* Conduct background research
* Develop a research proposal
* Understand the structure of a research proposal paper

# Inspiration

\vfill
\centering
> "Research is an organized method of trying to find out what your are going to do after you cannot do what you are doing now" -- Charles F. Kettering

#

\vfill
\centering
\Huge Research Process

# Process

\centering
\includegraphics[width=.75\textwidth]{images/Research/process.eps}

# Ideation

Your goal is to find a problem or knowledge gap that is important to the software engineering industry, software engineering researchers, or even better both.

* We do this typically in the following ways:
  * Reviewing recent research
  * Working with industry
  * Using existing tools
* Identify current problems and why they are important.
  * Industry problems that have academic impact
  * Prior study future work and challenges.
  * Identifying serious flaws or missing features of existing tools

* You want to find something that is interesting to you

# Initial Problem Formation

From your initial ideation begin formulating you problem

* Your initial problem is probably too large
  - Identify sub-problems you can solve now
  - Select the most interesting sub-problem
  - Write a formal problem statement

# Initial Background Research

Once you have your initial problem defined, it is time to see what has already been done in this area. This is what we call the "background research".

- Research Indexes aggregating CS and SE conference and journal proceedings:
  * [IEEExplore](https://ieeexplore.ieee.org)
  * [ACM Digital Library](https://portal.acm.org)
  * [SpringerLink](https://springerlink.com)
  * [ScienceDirect](https://sciencedirect.com)
- You can access them via the [library](http://isu.libguides.com/az.php?q=)

# Initial Background Research

\begin{center}
\includegraphics[width=.9\textwidth]{images/Research/initial_background.eps}
\end{center}

<!-- Using these indexes you need to search for works related to the problem you are intending to solve. This serves the following goals:

1. we need to know what has already been done in trying to solve the same problem
2. we need to know what has already been done in attempting to solve similar problems
3. we need to understand the basis of current thought surrounding these underlying concepts

I suggest that you select keywords and phrases from your problem statement

* These keywords then serve as your search terms
* I would also suggest only looking back the last 3--5 years

# Problem Refinement

The resulting articles that form the initial background research will be necessary to help you refine your problem statement.

* By reading these related work you may find:
  - that your initial understanding of the problem may have been flawed
  - that your initial solution has already been tried

* Regardless of the outcome, you will need to revise and tighten up your initial problem statement.
* At this point, you should begin sketching out your research approach. -->

# Scoping

The goal of sketching out your research approach is to determine if you can complete the research project in the time allotted to you.

* You need to determine the following:
  - the scope of the problem you have defined
  - your ability to implement by the deadline, the following:
    - your research approach
    - data collection
    - results analysis
    - reporting and presentation

#

\vfill
\centering
\Huge The Full Background Search

<!-- # What has already been done?

* Before you start a research project, you first need to determine if it is worth doing
* Part of this is determining what has already been done.
  - In essence, we need to search for work that will be the basis of our research
  - We also need to find similar work that has been done. -->

# Finding Studies

<!-- * Well this is an involved process
  1. Identify keywords and search terms from your problem statement or research question (be as broad as possible at first)
  2. Using Google Scholar, IEEExplore, ACM Digital Library, SpringerLink, and ScienceDirect search for these terms over the last 3-5 years

* Relevant papers can only be found by reading the paper, but that does not necessarily mean reading the entire paper. -->

\centering
\includegraphics[width=.85\textwidth]{images/Research/finding_studies.eps}

# Snowballing

<!-- You will find that no matter how good your search on the indexes was you will miss some relevant articles. To handle this we have two approaches:

* **Backward Snowballing**: For each paper you select as relevant to your work, you need to review its references and identify those papers which it cites that you have not already selected or rejected. You can then search for these either with Google Scholar or the indexes. You should continue this process until you find nothing new.
* **Forward Snowballing**: For each paper you select as relevant to your work, you need to find those papers citing that paper. This can be done by searching for the paper you selected on google scholar and once found clicking the "cited by" link under the paper. -->

\centering
\includegraphics[width=.85\textwidth]{images/Research/snowballing.eps}

# Two Piles

Once you have completed your paper reviews and identified those pertinent to your project, you should break them down into the following two piles.

::: columns
:::: column
**Pile 1: Foundational Work**

* Describe tools you are reviewing
* Describe the techniques you use
* Provide theoretical foundations
::::
:::: column
**Pile 2: Related Work**

* Provide alternative approaches to the same problem.
* Provide alternative solutions to the similar problems.
* Or, they solve related but different problems.
::::
:::

# Reading Papers - 3PM

\begin{center}
\large \textbf{The Three Pass Method}
\end{center}

\vskip.5em

::: columns
:::: {.column width=.33}
**First Pass**

1. Read the title
2. Read the abstract
::::
:::: {.column width=.34}

**Second Pass**

1. Read the title
2. Read the abstract
3. Read the introductory section
4. Read the conclusions
::::
:::: {.column width=.33}

**Final Pass**

1. Review your previous notes
2. Start from the title and read the entire paper
   - Focus on methods, results, and discussion
::::
:::

\vspace{-2em}

**All Passes**

* Take notes along the way
* At any time during your reading that you realize this paper is not pertinent, discard it.

# Too Many Papers?

\centering
\includegraphics[width=.9\textwidth]{images/Research/ref_mgmt.eps}

#

\vfill
\centering
\Huge Writing the Proposal

# Structuring Your Proposal

::: columns
:::: column
Title, Authors, Abstract

1. Introduction Section
   - Motivation
   - Problem Statement
   - Research Questions
   - Paper Organization

2. Background and Related Work Section
   - Foundational Knowledge
   - Related Works
   - Contributions
::::
:::: column
3. Methods (not methodology) Section
   - Approach
   - Experimental/Case Study Design
   - Metrics and Measures
   - Analysis Procedures
   - Data Sources

4. Conclusions
   - Summary of your approach
   - Limitations of your approach
   - Timeline and Project Scope
::::
:::

# Abstract

* A summary regarding the content of the paper
* Before the introduction
* After the title and authors of the paper
* Similar to an "executive summary"

For this course, we will use a form called a **Structured Abstract**

# Section 1: Introduction

This section sets the scope and defines the objective of the research.

* The motivation of the work to capture the readers' interest.
* Describe the need for the research
* Present the context within which the research is conducted
* Research objectives and Problem statement

## The Funnel

* Start with the large and important problem that needs to be addressed
* Then address a sub-problem which is the focus of the research

# Research Objectives

* Use the Goal-Question-Metric (GQM) approach.
* The GQM goal template looks something like this:

```
      Analyze <Object(s) of study>
      for the purpose of <Purpose>
      with respect to their <Quality focus>
      from the point of view of the <Perspective>
      in the context of <Context>
```

* This scopes and describes the objective in a single statement

\centering
Review Table 7.3 on page 87 of "Experimentation in Software Engineering" for examples of each of the items in angle brackets.

# Questions and Metrics

* Refine your research goal into a set of questions.
* These questions help define your empirical approach.
  * Your approach serves to answer these questions
* You then define a set of metrics
  - When measured (data collection) provide the results for analysis
  - Examples: Lines of Code, Code Coverage, Number of Methods, Days Worked, etc.

# Paper Organization

Alerts the reader to the structure of the paper.

* Something like: "The remainder of this paper is organized as follows. Sec. 2 ... Sec. 3 ... Sec 4. ... ... Finally, Sec. 7. summarizes the findings and describes the avenues for future work."

* Integrate at end of the introduction section
* Needed to address the break in flow from the background section

# Section 2: Related Work

* A synthesis of your background research:
* It typically has two main subsections
  - **Theoretical Foundations** -- A synthesis of the most important concepts and findings from the "Foundational Work" pile.
  - **Related Work** -- A synthesis of the most important concepts and findings from the "Related Work" pile
    - with special emphasis on the gaps that your work is going to fill.

# Section 3: Research Methods

* This is the subject of the last section of this talk

# Section 4: Conclusion

* **Conclusion** - This presents a summary of the paper specifically including:
  - Key findings and their relation to other works
  - How the key findings related to the larger problem from the introduction
  - Limitations of your work.
  - The next steps and future work.

* For a proposal, since you have no results yet:
  - summarize of your proposed approach
  - discuss expected findings
  - provide a scoping and timeline of the project

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
