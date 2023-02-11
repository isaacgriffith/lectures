---
author:
- Isaac Griffith
- Rosetta Roberts
title: An Approach Towards Merging Grammars
institute: |
  i-ETC 2020
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Motivation

* Software systems are increasingly multilingual
* Posing a challenge for the development of analysis tools
* Island Grammars pose a possible solution
* Experimental results towards automated grammar merging

\centering
\includegraphics[width=.75\textwidth]{images/ietc/concept.eps}

<!-- # Grammars

* **CFG**, $G$, is the tuple $(V,\Sigma,P,S)$, where
  - $V$ is the set of non-terminal symbols
  - $\Sigma$ is the set of terminal symbols
  - $P$ is the set of production rules
  - $S$ is the start symbols

* **Island Grammar**, $G$, is the tuple $(V,\Sigma,P,S,I)$, where
  - $I$ is the set of interests or islands.
  - The remaining components are reduced to catchall or water production(s). -->

# Goals and Questions

<!-- **Hypothesis:** Automated grammar merging is an important and necessary step in the evolution of Island Grammar research. It provides the capability to address difficulties in the initial construction and further maintenance of Island Grammars. -->

<!-- \vskip1em -->

\vfill
**Research Goal:** Evaluate an automated approach for the purpose of automating the merging of grammar rules with respect to the maintenance effort and complexity from the point of view of software language engineers in the context of the creation of island grammars.

* **RQ1**: What effect does merging grammars have on maintenance effort?
  <!-- - **M1**: $\Delta HAL$ - the change in Halstead Effort measured, using the Halstead Effort measure for grammars. -->

* **RQ2**: What effect does merging grammars have on complexity?
  <!-- - **M2**: $\Delta MCC$ - the change in complexity measured, using the McCabe Cyclomatic Complexity metric for grammars. -->

<!-- # Algorithm

::: columns
:::: column
**Algorithm**

\tiny
\begin{algorithmic}
  \Procedure{MergeProductions}{$\mathcal{N}, t$}
    \State $f_1 \gets collect(\textrm{`form1'}, \mathcal{N})$; $f_2
\gets collect(\textrm{`form2'}, \mathcal{N})$    
    \State $p_1 \gets $ \Call{Pairs}{$f_1$}; $p_2 \gets $
\Call{Pairs}{$f_2$}

    \State $\mathcal{Q}_1 \gets$ \Call{Measure}{$p_1,t,S_1$}
    \State $\mathcal{Q}_2 \gets$ \Call{Measure}{$p_2,t,S_2$}
    \State \Call{Process}{$\mathcal{Q}_1,f_1,S_1$};
\Call{Process}{$\mathcal{Q}_2,f_2,S_2$}
  \EndProcedure
  \Function{Process}{$\mathcal{Q},data,func$}
    \While{$\mathcal{Q} \ne \varnothing$}
      \State $p \gets$ \Call{Poll}{$\mathcal{Q}$}
      \State $\mathcal{V} \gets$ \Call{Merge}{$p.pair$}
      \State $\mathcal{Q} \gets$
\Call{Update}{$\mathcal{Q},\mathcal{V},p,data,func$}
    \EndWhile
  \EndFunction
  \Function{Merge}{$pair$}
    \State $rule \gets \varnothing$
    \If{$pair$ is of form1}
      \State $list \gets$ \Call{alignPair}{$pair$}
      \ForAll{$p\in list$}
        \If{$p.left = p.right$}
          \State $rule \gets rule \cdot p.left$
        \Else
          \State $rule \gets rule \cdot (p.left | p.right)$
        \EndIf
      \EndFor
    \Else
      \State $v \gets \varnothing$
      \State $v \gets pair.right.symbols \cup pair.left.symbols$
      \State $rule \gets concat(v)$
    \EndIf
    \State $\mathcal{V} \gets$ \Call{Normalize}{$rule$}
    \State \Return{$\mathcal{V}$}
  \EndFunction  
 \end{algorithmic}

::::
:::: column
**Walkthrough**

* Production Forms:
  * $Form_1$: A production composed of a rule containing at least one symbol, and where all symbols are concatenated with one another.
  * $Form_2$: A production composed of an alternation of one or more symbols.

* Measures:
  * $S_1 = \frac{2|LCS(A, B)|}{|A| + |B|}$
  * $S_2 = \frac{2|A \cap B|}{|A| + |B|}$

::::
::: -->

#

\centering
\vfill
\Huge Experiment Design

# Unit Selection

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/ietc/selection_proc_draw.eps}

# Design

* Data collected from Antlr4 grammar repository
* Two Experiments both using a 3x5 Factorial Design
  - 5 grammar pairs per size per replication
  - 5 replications (based on power analysis)
* Independent Variables
  - Similarity Threshold
  - Size
* Dependent Variables
  - $\Delta HAL$
  - $\Delta MCC$

# Data Collection

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/ietc/data_collect_draw.eps}

# Analysis

* Using permutation F-Test
  * **$H_{1,0}$**: The effects of interaction term levels are equal
  * **$H_{2,0}$**: The effects of similarity threshold levels are equal
  * **$H_{3,0}$**: The effects of size levels are equal
* Using Steele's multiple comparison to control
  * **$H_{4,0}$**: There is no difference between the median effects of similarity threshold effects and control effects
* Using Jonhckheer's trend test
  * **$H_{5,0}$**: There is no difference in the median effects of the similarity threshold levels

#

\centering
\vfill
\Huge Results

# Experiments

::: columns
:::: column
<!-- **Boxplots** -->

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/ietc/hal_box.eps}

::::
:::: column
<!-- **Interaction Plot** -->

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/ietc/mcc_box.eps}

<!-- \vfill
\centering
\includegraphics[width=.95\textwidth]{images/ietc/ex1_interaction.eps} -->

::::
:::

<!-- # Experiment 2

::: columns
:::: column
**Boxplots**

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/ietc/mcc_box.eps}

::::
:::: column
**Interaction Plot**

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/ietc/ex2_interaction.eps}

::::
::: -->

# Results

**Experiment 1**

\footnotesize
+----------------------------------------------------+------------------+-------------+--------------+
| **Component**                                      | **Evidence**     | **P-Value** | **Decision** |
+:===================================================+:=================+:============+:=============+
| Interaction Effect ($H_{1,0}$)                     | Strong           | < 2.2e-16   | reject       |
+----------------------------------------------------+------------------+-------------+--------------+
| Sim Thresh Effect Equal ($H_{2,0}$)                | Strong           | < 2.2e-16   | reject       |
+----------------------------------------------------+------------------+-------------+--------------+
| Size Level Effect Equal ($H_{3,0}$)                | Strong           | < 2.2e-16   | reject       |
+----------------------------------------------------+------------------+-------------+--------------+
| $\Delta HAL$ Levels = Control ($H_{4,0}$)          | Strong           | < 2.2e-16   | reject       |
+----------------------------------------------------+------------------+-------------+--------------+
| No order to Sim Thresh on $\Delta HAL$ ($H_{5,0}$) | Strong, JT = 767 | 6e-04       | reject       |
+----------------------------------------------------+------------------+-------------+--------------+

# Results

**Experiment 2**

\footnotesize
+----------------------------------------------------+--------------------------+-------------+----------------+
| **Component**                                      | **Evidence**             | **P-Value** | **Decision**   |
+:===================================================+:=========================+:============+:===============+
| Interaction Effect ($H_{1,0}$)                     | Marginal                 | **0.2534**  | fail to reject |
+----------------------------------------------------+--------------------------+-------------+----------------+
| Sim Thresh Effect Equal ($H_{2,0}$)                | Moderate                 | **< 0.141** | reject         |
+----------------------------------------------------+--------------------------+-------------+----------------+
| Size Level Effect Equal ($H_{3,0}$)                | Strong                   | < 2.2e-16   | reject         |
+----------------------------------------------------+--------------------------+-------------+----------------+
| $\Delta HAL$ Levels = Control ($H_{4,0}$)          | Strong (0.25, 0.5, 0.75) | < 2.2e-16   | reject         |
+----------------------------------------------------+--------------------------+-------------+----------------+
|                                                    | None (1.0)               |             |                |
+----------------------------------------------------+--------------------------+-------------+----------------+
| No order to Sim Thresh on $\Delta HAL$ ($H_{5,0}$) | Strong, JT = 742         | 3e-04       | reject         |
+----------------------------------------------------+--------------------------+-------------+----------------+

# Discussion and Interpretation

The results indicate the following:

* The merge process defined by our algorithm reduces maintenance effort as it
  - reduces the Halstead Effort, and
  - reduces the McCabe Cyclomatic Complexity
* That there is an inverse relationship between similarity threshold and both Halstead Effort and MCC
  - Thus smaller values lead to better results

* We can generalize these results to Antlr4 grammars, but not to all grammars in general.

# Validity Threats and Future Work

::: columns
:::: column

**Threats to Validity**

* **Construct**: None
* **Conclusion**: None
* **Internal**: lack of full representation of grammar definition techniques outside of Antlr
* **External**: restricted to representation of grammars to BNF and Antlr4 which preclude other known formats

::::
:::: column

**Future Work**

* Refine and combine our approaches into a framework for the development of software analytics tools.
* Replication of these experiments within the GrammarZoo data set
* Combining current work into a full process for automated Island Grammar generation

::::
:::

#

\vfill
\centering
\includegraphics[width=.95\textwidth]{images/ietc/thankyou.png}

\vskip.5em

\LARGE \color{Roarange} **Are there any questions?**
