---
author:
- Isaac Griffith
title: Impact Analysis - Change Propagation
institute: |
  CS 4423 and CS 5523

  Department of Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge Change Propagation
\vskip-0.75em
\rule{.775\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 4423/5523}
\end{minipage}
\end{minipage}

# Change Propagation Model

* Change propagation means that if an entity, say, a function, is changed, then all related entities in the system are accordingly changed.
* Based on the work of Hassan and Holt, a change propagation model has been illustrated in Figure.

\centering
\includegraphics[width=.85\textwidth]{images/impact/impact10.eps}

# Recall and Precision

* Gurus rarely exist and comprehensive test suites are generally incomplete in large maintenance projects.
* Therefore, software maintenance engineers need good change propagation heuristics, that is, good software tools that can guide them in identifying entities to propagate a change.
* The heuristic should possess the high \color{Roarange}\textbf{precision}\color{Black}\ attribute to be accurate and the high \color{Roarange}\textbf{recall}\color{Black}\ attribute to be complete.
* We explained the concepts of \color{Roarange}\textbf{recall}\color{Black}\ and \color{Roarange}\textbf{precision}\color{Black}\ before.
* Next, we explain the use of those two metrics to measure the change propagation heuristic by means of an example.

# Example

\footnotesize

* Let us assume that Rohan wants to enhance an existing feature of a legacy information system.
  1. He identifies that entity A should be changed
  2. After changing A, a heuristic tool is queried, which suggests entities B and X
  3. B is changed and he determines X should not be changed
  4. The tool is informed that B was changed, it then suggests to change Y and W
  5. Neither Y nor W need to be changed and they are left alone
  6. Rohan consults a Guru, Krushna, who indicates C should be changed
  7. C is modified and the heuristic tool is consulted
  8. D is suggested by the tool
  9. D is changed and Krushna is further queried.
  10. Krushna does not suggest any more entities for change
  11. Rohan stops changing the legacy system.

# Recall and Precision

\footnotesize

* The example entities and their interrelationships are shown in Figure

::: columns
:::: column

* The set of entities that are changed will be called change set ; change = {A, B, C, D}.
* The set of entities suggested by the tool is called a predicted set. In the Rohan example, predicted = {B, X, Y, W, D}.
* The entities that were required to be predicted, but were found from Guru, are put in a set call the occurred set.

::::
:::: column

\begin{center}
\includegraphics[width=.75\textwidth]{images/impact/impact11.eps}
\end{center}

::::
:::

* In the Rohan example, occurred = {B, C, D}. The occurred set does not include A, which was initially selected by Rohan, because there is no need to predict it.  That is, occurred = change - {initial entity}.

# Recall and Precision

* Now, recall and precision for this example are computed as follows:

$$
recall=\frac{\left|predicted\cap occurred\right|}{\left|occurred\right|}=\frac{2}{3}=66\%
$$

$$
precision=\frac{\left|predicted\cap occurred\right|}{\left|predicted\right|}=\frac{2}{5}=40\%
$$

# Recall and Precision

\footnotesize

In the analysis of the example is to measure recall and precision the authors, Hassan and Holt, made three assumptions:

1. \color{Roarange}\textbf{Symmetric suggestions:}\color{Black}\ This assumption means that if the tool suggests entity F to be modified when it is told that entity E was changed, the tool will suggest entity E to be modified when it is told that entity F was changed. This assumption has been depicted in Figure by means of undirected edges.

2. \color{Roarange}\textbf{Single entity suggestions:}\color{Black}\ This assumption means that each prediction by a heuristic tool is performed by considering a single entity known to be in the change set, rather than multiple entities in the change set.

3. \color{Roarange}\textbf{Query the tool first:}\color{Black}\ This assumption means that the maintainer (e.g., Rohan) will query the heuristic before doing so with the Guru (e.g. Krushna).

# Change Propagation Heuristics

\footnotesize

* The “Determine Other Entities to Change” step is executed by means of several heuristics.
* The set of entities that need to be changed as a result of a changed entity is computed in the aforementioned step.
* Modification records are central to the design of the heuristics.
* In general, source control repositories are used to keep track of all the changes made to files in the system.
* Each heuristic discussed here is characterized by:
  1. \scriptsize data source.
  2. \scriptsize pruning technique.

\centering
\includegraphics[width=.5\textwidth]{images/impact/impact10.eps}

# Heuristic Information Sources

* The objectives of the heuristics are to:
  1. ensure that the entities that need to be modified are predicted.
  2. minimize the number of predicted entities that are not going to be modified.

* Some potential information sources are as follows:
  - Entity information
  - Developer information (DEV)
  - Process information
  - Textual information

# Entity Information

In an heuristic based on entity information, a change propagates to other entities as follows:

- If two entities changed together, then the two are called a historical co-change (HIS).
- Static dependencies between two entities may occur via what is called CUD relations: \color{Roarange}\textbf{call}, \textbf{use} and \textbf{define}\color{Black}. A **call** relation means one function calls another function; a **use** relation means a variable is used by a function; and a **define** relation means a variable is defined in a function or it appears as a parameter in the function.
- The locations of entities with respect to subsystems, files, and classes in the source code are represented by means of a code layout (FIL) relation. Subsystems, files, and classes indicate relations between entities – and, generally, related entities simultaneously.

# Additional Heuristics

\footnotesize

**Developer information (DEV)**

* In an heuristic based on developer information, a change propagates to other entities changed by the same developer.
* In general, programmers develop skills in specific subject matters of the system and it is more likely that they modify entities within their field of expertise.

**Process information**

* In an heuristic based on process information, change propagation depends on the development process followed.
* A modification to a specific entity generally causes modifications to other recently or frequently changed entities.

# Additional Heuristics

**Textual information**

* In an heuristic based on name similarity, changes are propagated to entities with similar names.
* Naming similarities indicate that there are similarities in the role of the entities.

# Pruning Techniques

* A heuristic may suggest a large number of entities to be changed. Several techniques can be applied to reduce the size of the suggested set, and those are called pruning techniques.
  * **Frequency** techniques identify the frequently changing, related components. The number of entities returned by these techniques are constrained by a threshold.
  * **Recency** techniques identify entities that were recently changed, thereby supporting the intuition that modifications generally focus on related code and functionality in a particular time frame.
  * **Random** techniques randomly choose a set of entities, up to a threshold. In the absence of no frequency or recency data, one may use this technique.

# Empirical Studies

* Hassan and Holt studied the performance of four heuristics: \color{Roarange}\textbf{DEV}, \textbf{HIS}, \textbf{CUD}, and \textbf{FIL}\color{Black}\ using the development replay (DR) framework
* To evaluate an heuristic:
  1. historical changes are re-played
  2. the recall and precision attributes are measured for every change set.
* They used five open software systems – \color{Roarange}\textbf{NetBSD}, \textbf{FreeBSD}, \textbf{OpenBSD}, \textbf{Postgres} and \textbf{GCC}\color{Black}\ – and the performance results are given in Table 6.5.

\tiny

\centering

\begin{tabular}{|c|c|c|c|c|c|c|c|c|c|}
\hline
\textbf{Application} & \textbf{Application} & \multicolumn{2}{c|}{\textbf{DEV}} & \multicolumn{2}{c|}{\textbf{HIS}} & \multicolumn{2}{c|}{\textbf{CUD}} & \multicolumn{2}{c|}{\textbf{FIL}}\tabularnewline
\cline{3-10} \cline{4-10} \cline{5-10} \cline{6-10} \cline{7-10} \cline{8-10} \cline{9-10} \cline{10-10}
\textbf{Name} & \textbf{Type} & Recall & Precision & Recall & Precision & Recall & Precision & Recall & Precision\tabularnewline
\hline
NetBSD & OS & 0.74 & 0.01 & 0.87 & 0.06 & 0.37 & 0.02 & 0.79 & 0.16\tabularnewline
FreeBSD & OS & 0.68 & 0.02 & 0.87 & 0.06 & 0.40 & 0.02 & 0.82 & 0.11\tabularnewline
OpenBSD & OS & 0.71 & 0.02 & 0.82 & 0.08 & 0.38 & 0.01 & 0.80 & 0.14\tabularnewline
Postgres & DBMS & 0.78 & 0.01 & 0.86 & 0.05 & 0.47 & 0.02 & 0.77 & 0.12\tabularnewline
GCC & C/C++ & 0.79 & 0.01 & 0.94 & 0.03 & 0.46 & 0.02 & 0.96 & 0.06\tabularnewline
 & Compiler &  &  &  &  &  &  &  & \tabularnewline
\hline
\multicolumn{2}{|c|}{\textbf{Average}} & 0.74 & 0.01 & 0.87 & 0.06 & 0.42 & 0.02 & 0.83 & 0.12\tabularnewline
\hline
\end{tabular}

# For Next Time

::: columns
:::: {.column width=.6}
\footnotesize
* Review EVO Chapter 6.4 - 6.6
* Read EVO Chapter 7.1 - 7.3
* Watch Lecture 17
::::
:::: {.column width=.4}
\centering
\includegraphics[width=.85\textwidth]{images/next_time.png}
::::
:::

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
