---
author:
- Isaac Griffith
title: Simulation Reporting Guidelines
institute: |
  CS 6620

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Report Identification

* Similar to all reports, a simulation study should contain the following identifying components
  - **Authorship** information
  - **Title** and **keywords** to objectively identify the report
  - **Structured abstract** summarizing the contents

# Context and Research Questions

* Simulation studies are performed both
  - **in virtuo** - where human subjects interact with a computerized environment
  - **in silico** - where both subjects and the environment are computerized
* In both the object of the study is related to the simulation model
  - May be the simulation itself
  - May be the phenomenon/system/process abstracted over time

# Context

* We should use a broad perspective approach to describe the context
* Essentially describing the context in a way to answer questions like
  - "What technology is most effective for whom, performing that specific activity on that kind of system, under which set of circumstances"\

# Research Goals

* The problem statement is then situated in the defined context
* Problem statements should be of the following structure:
  - (Description of ideal scenario). However (or other adversative conjunction),
  - (The reality of the situation). Thus (or other conclusive conjunction),
  - (The consequences for the involved people).
* We can then utilize the GQM to define our research goals
  - Noting that the goals should match the capabilities of the simulation model
  - Common goals include:
    - developing a basic understanding (characterization) of a particular simulation model of the phenomena
    - finding robust or optimum decisions
    - comparing the merits of various decisions

# Metrics and Statistics

* With the goal and questions defined
  - Use the questions to identify needed metrics
  - Metrics allow us to transform questions into hypotheses
* With the hypotheses in hand
  - Identify statistical tests and methods

# Feasibility

* With the study definition documented, feasibility analysis can be performed
* Feasibility analysis should follow Balci (1990)'s approach
  - cost
  - time
  - benefits
  - relationships between
* Remember: goal of simulation is beyond its output
  - explain how the phenomenon occurs
  - what changes in processes, products, or people give a suitable solution
  - designed to support decision making

# Background and Related Work

* Only describe essential background knowledge
\vskip1em
* Only provide essential related works

# Sim Environment

* You must know the model in detail
  - Know the simulation approach
  - Know the underlying conceptual model
    - variables
    - parameters
    - metrics
  - Know the underlying assumptions
  - Know the calibration procedures
* In addition to this information, the report should include
  - diagrams presenting the whole idea
  - diagrams presenting the conceptual model
  - equations underlying the model (for replication)
  - text descriptions to clarify

# Validation

* Model validity should be addressed
  - Study validity relies upon model validity
  - Experimenter should be aware of model V&V procedures
    - Necessary if using an unvalidated model
* Should (though not usual in SE) evaluate performance measures (Burton et al. 2006)
  - Bias
  - Accuracy
  - Coverage
  - Confidence Intervals

# Subjects

* Human Subjects Characterization influences in virtuo results
  - characteristics (level of expertise, etc.)
  - number per group (treatment, control, etc.)
  - assignment process used

# Experimentation

* Need to identify the following elements
  - Causal model
  - Independent and Dependent variables
  - Nature of cause-effect
* Select an experimental design method
  - Factorial
  - Response-surface for max/min of parameter combinations
  - Variation reduction techniques
  - Ranking and selection techniques

# Experimentation

* What is the experiment that is being ran?
  - Validated models as control, other models as treatments
  - Single model, different datasets as treatments

# Number of Runs

* Need to identify the number of simulation runs to execute
  - More scenarios yields more required replications (runs) (see Houston et al. 2001 and Wakeland et al. 2004)
  - Stochastic modeling requires many runs of the same scenario
    - replications utilize PRNs to simulate the same scenario (see Burton et al. 2006)

# Data & Calibration

* Though the simulation model is important supporting data is as well
* Data availability factors into feasibility and must be reported
* Data is necessary for calibration
  - generation of equations and parameters
  - determination of random variable distributions
  - should report if/if not the model was calibrated
* We can use synthetic data
  - must be based on evidence of validity
  - must report "how far is the simulated data from real-system data?"

# Data Collection

* Data collection
  - planned to avoid measurement errors
  - needs to include quality assurance procedures
    - consistency
    - accuracy
    - outlier avoidance

# Environment and Tools

* We need to describe the simulation environment
* This should include the following:
  - supporting tools
  - associated costs
  - decision to use a specific simulation package

# Output Analysis

* Concentrates on understanding and quantifying tends of output variables
  - Typically done using charts
  - Often better to combine with statistical tests or descriptive statistics
* Regardless of method, need to ensure they are adequately selected

# Threats to Validity

::: columns
:::: column
* **Model Validity** - ensures that the study can represent the actual phenomena
  - Model structure
  - Supporting data
  - Input parameters
  - Scenarios
  - Simulation output
::::
:::: column
* **Experimental Validity**
  - External validity - concerns the possibility of reproducing empirical behaviors and consistent behaviors across different simulation studies.
  - Conclusion validity - related to
    * sample size
    * number of simulation runs
    * model coverage
    * degree of representation of the simulation scenarios for possible situations
::::
:::

# Conclusions and Future Works

* Express the main contributions of the study
  - key findings
  - linked to original research goals
* Should include implications of the applicability of the solution to real situations (practical use)
* Future works
  - further work
  - research challenges
  - hot topics

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
