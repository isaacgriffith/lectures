---
author:
- Isaac Griffith
title: Experiment Design & Operation
institute: |
  CS 6620

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

#

\vfill
\centering
\Huge Experimental Planning
\vskip.5em
\large \color{Roarange} \textbf{Design Types} \color{Black}

# Design Types

* In this lecture we will consider design for:
  - One factor with two treatments
  - One factor with more than two treatments
  - Two factors with two treatments
  - More than two factors each with two treatments

* Note: There are many more designs, if you are truly interested in experimentation:
  - Read: "Design and Analysis of Experiments" by Douglas Montgomery
  - Take MATH 4458/5558 - Experimental Design

* **Notation**
  - $\mu_i$ - the mean of the dependent variable for treatment $i$
  - $y_{ij}$ - the $j$th measure of the dependent variable for treatment $i$

#

\vfill
\centering
\Huge \textbf{Design Types}

\large \color{Roarange} **One Factor with Two Treatments**


# Completely Randomized Design

::: columns
:::: column

- Compares treatment means
- Same objects for both treatments
- Subjects randomly assigned to treatments
- Each subject uses one Treatment on one object
- Hypotheses:
  - $H_0$: $\mu_1 = \mu_2$
  - $H_A$: $\mu_1 \ne \mu_2$, $\mu_1 < \mu_2$, $\mu_1 > \mu_2$
- Analyses:
  - t-test
  - Mann-Whitney

::::
:::: column

\footnotesize
**EX:** Assigning Subjects to Treatments

+--------------+-----------------+-----------------+
| **Subjects** | **Treatment 1** | **Treatment 2** |
+:============:+:===============:+:===============:+
| 1            | X               |                 |
+--------------+-----------------+-----------------+
| 2            |                 | X               |
+--------------+-----------------+-----------------+
| 3            |                 | X               |
+--------------+-----------------+-----------------+
| 4            | X               |                 |
+--------------+-----------------+-----------------+
| 5            |                 | X               |
+--------------+-----------------+-----------------+
| 6            | X               |                 |
+--------------+-----------------+-----------------+

::::
:::


# Paired Comparison Design

::: columns
:::: column

* Makes comparisons on paired data
* Each subject uses both treatments on some object
* Compares difference to zero
* Hypotheses
  - $d_j = y_{1j} - y_{2j}$
  - $\mu_d$ is mean of diff
  - $H_0$: $\mu_d = 0$
  - $H_A$: $\mu_d \ne 0$, $\mu_d < 0$, $\mu_d > 0$

::::
:::: column

\footnotesize
**EX:** Assigning Subjects to Treatments

+--------------+-----------------+-----------------+
| **Subjects** | **Treatment 1** | **Treatment 2** |
+:============:+:===============:+:===============:+
| 1            | 2               | 1               |
+--------------+-----------------+-----------------+
| 2            | 1               | 2               |
+--------------+-----------------+-----------------+
| 3            | 2               | 1               |
+--------------+-----------------+-----------------+
| 4            | 2               | 1               |
+--------------+-----------------+-----------------+
| 5            | 1               | 2               |
+--------------+-----------------+-----------------+
| 6            | 1               | 2               |
+--------------+-----------------+-----------------+

\small

* Analyses
  - Paired t-test
  - Sign Test
  - Wilcoxson

::::
:::

#

\vfill
\centering
\Huge \textbf{Design Types}

\large \color{Roarange} **One Factor with more than Two Treatments**

# Completely Randomized Design

::: columns
:::: column

* Random order of tests
* Uniform experiment environment
* One object to all treatments
* Subjects assigned randomly to treatments
* Hypotheses:
  - $H_0$: $\mu_1 = \mu_2 = \mu_3 = \ldots = \mu_A$
  - $H_A$: $\mu_i \ne \mu_j$ for at least one pair $(i,j)$

::::
:::: column

\centering
**Example Assingment**

\footnotesize
+--------------+------------------+------------------+------------------+
| **Subjects** | **Treatment 1**  | **Treatment 2**  | **Treatment 3**  |
+:============:+:================:+:================:+:================:+
| 1            |                  | X                |                  |
+--------------+------------------+------------------+------------------+
| 2            |                  |                  | X                |
+--------------+------------------+------------------+------------------+
| 3            | X                |                  |                  |
+--------------+------------------+------------------+------------------+
| 4            | X                |                  |                  |
+--------------+------------------+------------------+------------------+
| 5            |                  | X                |                  |
+--------------+------------------+------------------+------------------+
| 6            |                  |                  | X                |
+--------------+------------------+------------------+------------------+

\small

* Analyses:
  - ANOVA
  - Kruskal-Wallis

::::
:::

# Randomized Complete Block

::: columns
:::: column

* useful when variability between subjects is large
* each subject (block) uses all treatments and subjects form a homogeneous experiment unit
* one object to all treatments
* subjects order to treatments is random
* Hypotheses:
  - $H_0$: $\mu_1 = \mu_2 = \mu_3 = \ldots = \mu_A$
  - $H_A$: $\mu_i \ne \mu_j$ for at least one pair $(i,j)$

::::
:::: column

\centering
**Example Assingment**

\footnotesize
+--------------+------------------+------------------+------------------+
| **Subjects** | **Treatment 1** | **Treatment 2** | **Treatment 3** |
+:============:+:================:+:================:+:================:+
| 1            | 1                | 3                | 2                |
+--------------+------------------+------------------+------------------+
| 2            | 3                | 1                | 2                |
+--------------+------------------+------------------+------------------+
| 3            | 2                | 3                | 1                |
+--------------+------------------+------------------+------------------+
| 4            | 2                | 1                | 3                |
+--------------+------------------+------------------+------------------+
| 5            | 3                | 2                | 1                |
+--------------+------------------+------------------+------------------+
| 6            | 1                | 2                | 3                |
+--------------+------------------+------------------+------------------+

\small

* Analyses:
  - ANOVA
  - Kruskal-Wallis

::::
:::

#

\vfill
\centering
\Huge \textbf{Design Types}

\large \color{Roarange} **Two Factor with Two Treatments**

# Two Factors

* A bit more complex
* Splits the single hypothesis into 3 separate hypotheses (each factor and the interaction)
* **Notation**
  - $\tau_i$ - effect of treatment $i$ on factor A
  - $\beta_j$ - effect of treatment $j$ on factor B
  - $(\tau\beta)_{ij}$ effect of the interaction between $\tau_i$ and $\beta_j$

# 2x2 Factorial

::: columns
:::: column

* 2 Factors each with 2 Treatments
* Random assignment of subjects to treatment combos
* Analysis: ANOVA

::::
:::: column

* Hypotheses
  - $H_{1,0}$: $\tau_1 = \tau_2 = 0$
  - $H_{1,A}$: at least one $\tau_i \ne 0$
  - $H_{2,0}$: $\beta_1 = \beta_2 = 0$
  - $H_{2,A}$: at least one $\beta_j \ne 0$
  - $H_{3,0}$: $(\tau\beta)_{ij} = 0$ for all $i,j$
  - $H_{3,A}$: at least one $(\tau\beta){ij} \ne 0$ <!-- fix me add the underscore back in -->

::::
:::

\centering
**Example Assignment**

\begin{tabular}{cccc}
\hline
\multicolumn{2}{c}{} & \multicolumn{2}{c}{\textbf{Factor A}}\tabularnewline
\cline{3-4} \cline{4-4}
\multicolumn{2}{c}{} & Treatment A1 & Treatment A2\tabularnewline
\hline
\textbf{Factor B} & Treatment B1 & Subject 4, 6 & Subject 1, 7\tabularnewline
 & Treatment B2 & Subject 2, 3 & Subject 5,8\tabularnewline
\hline
\end{tabular}

# Two Stage Nested

* two factors, each with two or more treatments
* when one factor is similar, but not identical for different treatments of the other factor then the design is hierarchical
* Hypotheses and analyses are same as 2x2 factorial

\centering
**Example Assignment**

\begin{tabular}{cccc}
\hline
\multicolumn{4}{c}{\textbf{Factor A}}\tabularnewline
\hline
\multicolumn{2}{c}{Treatment A1} & \multicolumn{2}{c}{Treatment A2}\tabularnewline
\hline
\multicolumn{2}{c}{\textbf{Factor B}} & \multicolumn{2}{c}{\textbf{Factor B}}\tabularnewline
\hline
Treatment B1' & Treatment B2' & Treatment B1'' & Treatment B2''\tabularnewline
\hline
Subject 1, 3 & Subject 6, 2 & Subject 7, 8 & Subject 5, 4\tabularnewline
\hline
\end{tabular}

#

\vfill
\centering
\Huge \textbf{Design Types}

\large \color{Roarange} **Two Factor with more than Two Treatments**

# 2K Factorial

::: columns
:::: column

* $2^k$ combinations, all are tested
* $k$ factors where each has 2 treatments
* Subjects randomly assigned to treatment combinations
* Hypotheses and Analyses same as for 2x2 factorial

::::
:::: column

\footnotesize
+--------------+--------------+--------------+--------------+
| **Factor A** | **Factor B** | **Factor C** | **Subjects** |
+:============:+:============:+:============:+:============:+
| A1           | B1           | C1           | 2, 3         |
+--------------+--------------+--------------+--------------+
| A2           | B1           | C1           | 1, 13        |
+--------------+--------------+--------------+--------------+
| A1           | B2           | C1           | 5, 6         |
+--------------+--------------+--------------+--------------+
| A2           | B2           | C1           | 10, 16       |
+--------------+--------------+--------------+--------------+
| A1           | B1           | C2           | 7, 15        |
+--------------+--------------+--------------+--------------+
| A2           | B1           | C2           | 8, 11        |
+--------------+--------------+--------------+--------------+
| A1           | B2           | C2           | 4, 9         |
+--------------+--------------+--------------+--------------+
| A2           | B2           | C2           | 12, 14       |
+--------------+--------------+--------------+--------------+

::::
:::

# 2K Fractional Factorial

* As $k$ increases the number of factor combos exponentially increases
* Often higher-order interactions can be assumed to be negligible
* Thus, main effects and low-order interactions can be evaluated using only a fraction of the combos
* Based on 3 ideas:
  * **Sparsity of effect principle**: it is likely that the system is primarily driven by main and low-order interaction effects
  * **Projection property**: a stronger design can be obtained by taking a subset of significant factors from the fractional factorial design
  * **Sequential experimentation**:  a stronger design can be obtained by combining sequential runs of two or more fractional factorial design

# Instrumentation

* Experimental Instruments are of 3 types
  - Objects (i.e., specification or code documents)
  - Guidelines (i.e., process descriptions or checklists) - guide the participants
  - Measurement Instruments (i.e., questionnaires or metrics) - data collection

* In planning, instruments are selected
* In execution, instruments are developed

* **Overall goal**: provide means for performing and monitoring the experiment without affecting experimental control.

#

\vfill
\centering
\Huge Experimental Operation

# Operation

There are three steps to experimental operation:

1. **Preparation** - where subjects are choose and forms are prepared
2. **Execution** - where subjects perform their tasks according to different treatments and data is collected
3. **Data Validation** - where the collected data is validated

# Operation

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/experimentation/operation.eps}

# Preparation

* Better preparation -> Easier experiment execution
* Two important aspects of preparation
  1. Select and inform participants
  2. Prepare materials such as forms and tools

# Commit Participants

* Find people whose normal work tasks are similar to the experiment's tasks
* Ensure the participants are representative of the population to which you want to generalize
  - Reduces threats to external validity
* **Goal**: convince the right people to participate

# Instrumentation Concerns

* Before execution, all instruments must be ready, including:
  - Objects
  - Guidelines
  - Measurement forms
    - Must be handed out to participants
    - Anonymous?
  - Measurement tools
* In order to facilitate random order of trials
  - provide a personal set of instruments to each participant
* Additionally, interview questionnaires should be created prior to execution

# Execution

* Experiments may be executed in many ways:
  - Simple experiments may be carried out at one occasion within a single large meeting of participants
    - Limits number of communications with participants
    - Data can be collected directly
    - Can resolve questions immediately and completely
  - More complex experiments will require a longer time span
    - Experimenter cannot participate in every detail of data collection

# Data Collection

* Data Collection Approaches
  - Manual - via participants filling out forms
    * Reduces experimenter effort
    * Increases inconsistencies, uncertainties and flaws
  - Manual - via supported tools
  - Interviews
    * Improves communication with participants
    * Requires more effort from experimenter
  - Automatically - via tools

# Experimental Environment

* Experiments should not affect projects more than necessary
  - This allows effects of treatments to be readily observed
  - Too many changes reduce this visibility
* Interaction with projects is necessary to ensure the protocols are being followed

# Data Validation

* All data collected must be checked for
  - reasonableness
  - correctness
* Did participants fill in the forms correctly?
* Did participants take the experiment seriously?
  - If not their data should be removed.
* Was the experiment conducted as intended?
  - Validate via seminar with participants reviewing the data collected.
    * helps build trust

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
