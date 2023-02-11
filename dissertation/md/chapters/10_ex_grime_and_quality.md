\chapter{Experimentation: The Effects of Grime on Maintainability and Technical
Debt}\label{chap:ex_grime_and_quality}

\begin{quote}
\centering
\textit{ It’s hard enough to find an error in your code when you’re looking for it; its even
harder when you’ve assumed your code is error-free.}\\--Steve McConnell
\end{quote}

\section{Introduction}\label{sec:exgq_intro}
The ability to predict the effects on software quality that a design or implementation
decision will have on the underlying software is of great concern. The incursion of
predicting the effects that design pattern grime would have for a given design or
implementation is no different. The first step in this direction is to understand the
relationship between quality and grime before predicting its effects. Thus, this chapter
explores the effects of design pattern grime on software systems' maintainability. The goal
of this experiment, stated in Section \ref{chap:intro}.\ref{sec:goals}, is restated here for
the reader's convenience:

\begin{enumerate}[leftmargin=2.0cm,label=\bfseries RG\arabic*:,start=2]
  \item Analyze design pattern instances afflicted with design pattern grime for the purpose
of evaluation with respect to the ISO/IEC 25010 Quality Characteristic
Maintainability\cite{noauthor_iso/iec_2011}, from the perspective of researchers, in the context of
generated Java\texttrademark\ design pattern instances.
  \item Analyze design pattern instances afflicted with grime for the purpose of
evaluation with respect to the Technical Debt Principal and Interest, from the perspective of
researchers, in the context of generated Java\texttrademark\
design pattern instances.
\end{enumerate}

\noindent This goal leads to our main questions of interest and their corresponding rationales:

\begin{enumerate}[leftmargin=2.0cm,label=\bfseries RQ\arabic*:,start=2]
  \item How does each type of grime affect software product maintainability?\\
  \textbf{Rationale:} Evaluate the assertion that as grime builds up in a pattern instance
or software system, it will negatively affect the software or pattern instance's
maintainability.
  \item How does each type of grime affect a software product's technical debt
  estimate?\\
  \textbf{Rationale:} Evaluate the assertion that as grime builds up in a
  pattern instance or software system, it will increase the technical debt
  principal.
\end{enumerate}

This chapter is organized as follows. Section \ref{sec:gq_methods} describes the
experimental methods used and the corresponding experimentation plan, including the data
collection and analysis procedures. Section \ref{sec:gq_execution} describes the outcome of
the execution of the experiment, including sample characteristics, data preparation steps,
data collection performed, any deviations from the experiment plan. Section
\ref{sec:gq_analysis} describes the results and analysis conducted following the analysis
procedures. Section \ref{sec:gq_interp} discusses the analysis results and their
interpretation within this study's context and prior work. Section \ref{sec:gq_conclude}
concludes this study.

\section{Methods}\label{sec:gq_methods}
This section describes the experimental methods used to answer \textbf{RQ2} and
\textbf{RQ3}. Towards this, this section contains subsections that further refine these
research questions and identify their necessary metrics. Additionally, we describe the
experimental designs, data collection procedures, and analysis procedures used when
answering the research questions. Finally, we end this section with a discussion concerning
the validity of the overall approach.

\subsection{Refined Research Questions and Metrics}\label{sec:gq_refined_gqm}

Following the GQM approach, we begin the experimental design with a refinement of the
questions \textbf{RQ2} and \textbf{RQ3} into a series of directly answerable questions,
their underlying rationale, and a set of metrics defined to facilitate answering these
questions. The refined questions are as follows:

\begin{enumerate}[leftmargin=2.0cm,label=\bfseries RQ2.\arabic*:]
  \item How does each type of grime affect design pattern quality for each of the selected
maintainability sub-characteristics? \\
  \textbf{Rationale:} Evaluate the assertion that as grime builds up in a pattern instance
or software system, it will negatively affect software quality.
  \item What level of grime severity affects a change in design pattern quality for each of
the maintainability sub-characteristics?\\
  \textbf{Rationale:} Evaluate the assertion that grime affects software maintainability
at all severity levels.
  \item What is the difference between the effects of the grime types and their subtypes
on maintainability sub-characteristics?\\
  \textbf{Rationale:} Evaluate the assertion that each grime type or each grime subtype
affects maintainability similarly.
\end{enumerate}

\begin{enumerate}[leftmargin=2.0cm,label=\bfseries RQ3.\arabic*:]
  \item How does each type of grime affect \textit{technical debt principal}, as
  measured using Nugroho et al.'s approach
  \cite{nugroho_empirical_2011}?\\
  \textbf{Rationale:} Evaluate the assertion that as grime builds up in a
  pattern instance or a software system, it will affect the accumulation of the
  software or pattern technical debt principal.
  \item How does each type of grime affect \textit{technical debt interest}, as
  measured using Nugroho et al.'s approach
  \cite{nugroho_empirical_2011}?\\
  \textbf{Rationale:} Evaluate the assertion that as grime builds up in a
  pattern instance or a software system, it will affect the accumulation of the
  software or pattern technical debt principal.
  \item What level of grime severity effects a change in technical debt
  principal?\\
  \textbf{Rationale:} Evaluate the assertion that grime affects technical debt
  at all severity levels.
  \item When an instance is affected with grime, what effect does design pattern
  type have technical debt principal?\\
  \textbf{Rationale:} Evaluate the assertion that the effect of grime on
  technical debt is the same across design pattern types.
  \item What is the difference between the effects on technical debt for each
  grime type and their subtypes?\\
  \textbf{Rationale:} Evaluate the assertion that each grime type or each grime
  subtype affects technical debt similarly.
\end{enumerate}

Maintainability, as defined in the ISO/IEC 25010 Quality Model, is composed of following
five sub-characteristics: Analyzability, Testability, Modifiability, Modularity, and
Reusability. These are the sub-characteristics referenced in \textbf{RQ2.1 -- 2.3}. The
definition of these and other pertinent metrics necessary to answer questions \textbf{RQ2.1
-- 2.3} and \textbf{RQ3.1 -- 3.5} are defined as follows:

\begin{enumerate}[leftmargin=2.0cm,label=\bfseries M2.\arabic*:]
  \item \textit{Analyzability} -- ``degree of effectiveness and efficiency with which it is
possible to assess the impact on a product or system of an intended change to one or more of
its parts, or to diagnose a product for deficiencies or causes of failures, or to identify
parts to be modified'' \cite{noauthor_iso/iec_2011}. Analyzability will be measured using a
modified implementation of the SIG Maintainability \cite{Heitlager_2007} quality model,
which considers Analyzability to be a continuous value falling in the range
$\left[0,5\right]$ stars.
  \item \textit{Testability} -- ``degree of effectiveness and efficiency with which test
criteria can be established for a system, product or component and tests can be performed to
determine whether those criteria have been met'' \cite{noauthor_iso/iec_2011}. This will be
measured using a modified implementation of the SIG Maintainability Model
\cite{Heitlager_2007} quality model, which considers Testability to be a continuous value
falling in the range $\left[0,5\right]$ stars.
  \item \textit{Modifiability} -- ``degree to which a product or system can be effectively
and efficiently modified without introducing defects or degrading existing product
quality''\cite{noauthor_iso/iec_2011}. This will be measured using a modified implementation
of the SIG Maintainability Model \cite{Heitlager_2007} quality model, which considers
Modifiability to be a continuous value falling in the range $\left[0,5\right]$ stars.
  \item \textit{Modularity} -- ``degree to which a system or computer program is composed of
discrete components such that a change to one component has minimal impact on other
components'' \cite{noauthor_iso/iec_2011}. This will be measured using a modified
implementation of the SIG Maintainability Model \cite{Heitlager_2007} quality model, which
considers Modularity to be a continuous value falling in the range $\left[0,5\right]$ stars.
  \item \textit{Reusability} -- ``degree to which an asset can be used in more than one
system, or in building other assets'' \cite{noauthor_iso/iec_2011}. This will be measured
using a modified implementation of the SIG Maintainability Model \cite{Heitlager_2007}
quality model, which considers Reusability to be a continuous value falling in the range
$\left[0,5\right]$ stars.
  \item \textit{Injection Severity} (IS) -- An indicator of the severity of grime affliction
for a given design pattern instance. This metric is measured using the mapping defined as
follows:
  \[
GS(p)=\begin{cases} GP(p)=0\% & 0\,\textrm{(Control)}\\
GP(p)\leq15\% & 1\\
GP(p)\leq30\% & 2\\
GP(p)\leq45\% & 3\\
GP(p)\leq60\% & 4\\
GP(p)\leq75\% & 5\\
\end{cases}
  \]
Where $GP(p)$ is the percentage of grime affecting a pattern instance. $GP(p)$ is calculated
as the ratio of pattern instance members bound to a role defined by the associated pattern
RBML and affected by grime to the total number of pattern instance members bound to a role.
For a measured value of GS, $v$, where $v \in \mathbb{N}^{+}$ and $v \in \left[0,5\right]$,
and is measured on an ordinal scale.
  \item \textit{Pattern Type} (PT) -- the pattern type name for a given pattern instance.
This metric is measured on a \textit{nominal} scale, with each measured value being one  of
the following: (Object) Adapter, Bridge, Chain of Responsibility, Command, Composite,
Decorator, Flyweight, Factory Method, Observer, Prototype, Proxy, Singleton, State,
Strategy, Template Method, or Visitor. These values are limited to those reported by the
Pattern4 tool.
  \item \textit{Injection Type} (IT) -- the grime type for the specific type of grime
affecting a given pattern instance. This metric is measured on a \textit{nominal} scale,
with each measured value being one of the 26 grime type acronyms identified in Chapter
\ref{chap:taxonomies}.
\end{enumerate}
\begin{enumerate}[leftmargin=2.0cm,label=\bfseries M3.\arabic*:]
  \item \textit{Technical Debt Principal} -- A measure of the man-months or monetary value of
the effort required to remediate (via refactoring) the issues identified as technical debt
within a software system. This metric is measured using Nugroho et al.'s method as described
in Section \ref{chap:background}.\ref{sec:tech_debt}. This method measures TD Principal as a
continuous positive value with units in man-months.
  \item \textit{Technical Debt Interest} -- A measure of the effort to remediate the
compounding effect of unremediated technical debt on the maintenance of a software system.
This metric is measured using Nugroho et al.'s approach as described in Section
\ref{chap:background}.\ref{sec:tech_debt}. This method measures TD Interest as a continuous
positive value with units in man-months.
\end{enumerate}

\noindent Using these basic metrics we next identify the experimental designs.

\subsection{Experimental Design}

This study is further decomposed into seven separate experiments. Each experiment considers
one of the corresponding quality attributes: five for the maintainability
sub-characteristics (Analyzability, testability, Modifiability, modularity, and Reusability)
and two for the technical debt components (principal and interest). Each experiment uses a
three-factor factorial design. This design was selected to accommodate the potential
interactions between the independent variables. These variables include Pattern Type,
Injection Severity, and Injection Type. The dependent variable in each experiment is the
corresponding quality attributes. This design will require 2496 experimental subjects,
design pattern instance, per replication.

We generate each replication's pattern instances using the design pattern generation
technique described in Section \ref{chap:dpd}.\ref{sec:dp_gen}. This approach frees us from
any restrictions that a lack of experimental subjects would impose. The following subsection
describes the method used to collect this data.

\subsection{Data Collection}\label{sec:gq_dc_proc} The following describes the data to be
collected, the collection process, and how this data is stored. For each instance under
study, we extract the instance identifier, the grime type injected, the grime severity level
for the grime injected, the pattern type, and the change in the quality attribute of concern
(between pattern generation and grime injection). The ReportGenerator extracts this
information from the PatternInstance, Findings, and Measures tables of the ArcDb. Once
extracted, the ReportGenerator generates a table, similar to the example shown in Table
\ref{tab:gq_dc_ex}, with the following specifications:

\begin{table}[!tb]
\centering
\caption{Example data collection table for grime and quality
experiment.}\label{tab:gq_dc_ex}
\begin{tabular}{c|cccccccc}
\multicolumn{1}{c}{\textbf{ID}} & \textbf{$PT$} & \textbf{$IT$} & \textbf{$IS$}
& \textbf{$\Delta QA$} \tabularnewline
\hline
0 & Singleton & DIPG & 2 & 0.95 \tabularnewline
$\vdots$ & $\vdots$ & $\vdots$ & $\vdots$ & $\vdots$ \tabularnewline
\end{tabular}
\end{table}

\begin{itemize}
  \item Each row of the table represents a single design pattern instance.
  \item The first column of the table is the identifier representing a specific pattern
instance.
  \item The second column of the table represents the design pattern type.
  \item The third column of the table represents the type of grime injected.
  \item The fourth column of the table represents the severity rating for the injected
grime.
  \item The fifth column of the table represents the change in value for the quality
attribute which is the subject of the experiment in question.
\end{itemize}

\begin{figure}[!tb]
  \centering
  \includegraphics[width=\textwidth]{experimental_process/grime_quality_ex_dc}
  \caption{Grime effect on Quality data collection process.}
  \label{fig:gq_data_coll}
\end{figure}

Figure \ref{fig:gq_data_coll} depicts an overview of the data collection process. This
process follows the path indicated by the numbers encircled in green, as follows. 1.) The
Arc system executes the \textit{Pattern Generator}, 2.) which utilizes the
\textit{ExperimentalConfig} to define which pattern types to generate and the number of
instances needed. 3.) This process results in generating a project per instance as a
physical project folder. 4.) The workflow shifts to the \textit{SoftwareInjector}, which
uses the \textit{ExperimentalConfig} to determine the type and severity of grime to inject.
5.) The \textit{SoftwareInjector} copies the physical project and injecting the specified
grime into this copy. 6.) Once injected, both copies of the project are then analyzed using
the standard java tooling. 7.) The standard java tooling (which includes the items indicated
by the ``Java Tools'' key on the diagram) stores its results in the ArcDb. 8.) The SIG
Maintainability Model quality analysis executes across all systems in the database and
stores its resulting measures in the ArcDb. 9.) The report generator uses the stored
measures to construct the data table according to the specification previously described.
These results, once gathered, are then analyzed (for each experiment separately) using the
following analysis procedures.

\subsection{Analysis Procedures}\label{sec:ex_ana_proc}

This section describes the analysis models and procedures used for these experiments. The
analysis of these experiments will proceed from the data collection forward, as follows:

\begin{enumerate}
 \item A size analysis conducted to determine the number of replications needed to
achieve the statistical power required.
 \item Data collection occurs according to the data collection procedure.
 \item Descriptive statistics are gathered and recorded based on the collected data.
 \item Evaluate the ANOVA assumptions, as follows:
 \begin{enumerate}
  \item Evaluate the Homogeneity of Variance assumption visually using a residuals vs. fitted values plot and analytically using Levene's test.
  \item Evaluate the Normality of the sample population visually using a QQ-Plot and analytically using the Kolmogorov-Smirnoff test.
  \item For each experiment, following the data collection procedure, the data meets the assumption that the samples are drawn independently of one another.
  \item For each experiment, following the data collection procedure, the observations are sampled randomly and independently of one another.
 \end{enumerate}
 \item If any of the violations of the assumptions are detected, attempts will be made to address these issues. If there are no violations, or they have been addressed, then the ANOVA analysis will continue. If attempts to address violations are unsuccessful, then a permutation f-test will be conducted instead.
 \item If a significant difference is detected (F-test with $p < 0.05$), then the following will occur:
 \begin{enumerate}
   \item Evaluation of the interaction effects in the model. If present, the significant interactions will be noted and the interactions plotted for further evaluation. If such interaction effects are detected, then we will not explore the main effects further.
   \item In the case of a lack of significant interaction effects, the main effects will be considered. Additionally, we will conduct a multiple comparison procedure between the means for all treatment levels and the results recorded.
   \item Finally, in either case, the execution of the pre-planned contrasts will be conducted
and the results recorded.
 \end{enumerate}
 %\item We conduct A power analysis to evaluate the likelihood of a type-II error in the
 %analysis.
\end{enumerate}

We will conduct this analysis using the R Project for statistical computing version 4.1.1 and various R modules.

\subsubsection*{Size Analysis}

A design size analysis determines the number of replications required to achieve the
analytical power necessary to detect a difference. There are four required values to conduct
this analysis: (i) an estimate of the smallest relative distance between means, (ii) an
estimate of the standard deviation, (iii) the alpha level, and (iv) the power level desired.
The latter two are known, but we must estimate the former two based on either prior
knowledge or pilot study results.

Given the lack of prior knowledge, we have selected to conduct a small pilot study. This
study follows the same approach as the primary study. However, with the following
restrictions: (i) we will only generate instances for two patterns: Singleton and State, and
(ii) we will generate 156 instances per pattern (each injection type for each level of
severity). The data collected will be enough to estimate both the smallest relative distance
between means and the standard deviation. We will conduct the design size analysis and
generate the pattern instances for each experiment using this information.

\subsubsection*{ANOVA/Permutation F-test}

For our design and subsequent analysis we have elected to utilize an ANOVA model (and if not
possible a permutation F-test). The model for analysis is as follows:
\begin{eqnarray}
\notag y_{ijkl(m)} & = & \mu + \tau_{i} + \beta_{j} + \gamma_{k} +
\left(\tau\beta\right)_{ij} + \left(\tau\gamma\right)_{ik} + \left(\beta\gamma\right)_{jk} +
\left(\tau\beta\gamma\right)_{ijk} + \epsilon_{ijkl}
\end{eqnarray}

\noindent In this model:
\begin{itemize}
 \item $y_{ijkl}$ represents quality attribute (QA) of concern
 \item $\tau_{i}$ represents the effect of the $i^{th}$ pattern type (PT)
 \item $\beta_{j}$ the effect of the jth injection type (IT)
 \item $\gamma_{k}$ the effect of the kth injection severity (IS)
 \item $\left(\tau\beta\right)_{ij}$, represents the effects of the two-factor
interaction of PT and IT
 \item $\left(\tau\gamma\right)_{ik}$, represents the effects of the two-factor
interaction of PT and IS
 \item $\left(\beta\gamma\right)_{jk}$, represents the effects of the two-factor
interaction of IT and IS
 \item $\left(\tau\beta\gamma\right)_{ijk}$, represents the effects of the three-factor
interaction of PT, IT, and IS
 \item $\epsilon_{ijk(m)}$ represents the random error of the
$k^{th}$ observation of the $(i,j)^{th}$ treatment for the $m^{th}$ quality attribute
\end{itemize}

\noindent Using this model, the ANOVA/permutation F-test analysis determines only if there
is any difference in mean change in the quality attribute of concern due to any treatment.

\subsubsection*{Interaction Effect}

The evaluation of the interaction effects will first determine whether there is any evidence
of a three-way interaction. If this is the case, then the remaining interaction effects,
main effects, multiple comparisons, and pre-planned contrasts will not be considered. If
there is weak or no evidence of such an interaction, we will review each two-factor
interaction. Next, suppose there is evidence suggesting the presence of two-factor
interactions. In that case, we will only consider main effects, multiple comparisons, or
pre-planned contrasts for those effects not contributing to interactions with supporting
evidence. Finally, if weak or no evidence supports any interactions, we will move forward in
considering the main effects, multiple comparisons, and pre-planned contrasts as described
in the following subsections.

\subsubsection*{Main Effects, Multiple Comparisons and Pre-planned Contrasts}

The main effects, $\tau_{i}$, $\beta_{j}$, and $\gamma_{k}$, representing the effect that
pattern type, injection type, and injection severity have on the mean change in quality
attribute, will be evaluated as part of the ANOVA/Permutation F-test. If there is strong
evidence for the main effects, we will execute multiple comparison procedures and
pre-planned contrasts. In such a case, we will execute multiple comparisons with a
Bonferroni corrected p-value. Except for injection severity, we will perform an all-pairs
comparison. For injection severity we will utilize a comparison versus control approach
(such as Dunnett's test\cite{dunnett_multiple_1955} or Steel's
test\cite{steel_multiple_1959}). Evaluating these multiple comparisons will provide detailed
insight into the differences among the specific differences in the effects of different
grime types and grime severity levels. Thus, providing deeper insights into answering
questions \textbf{RQ2.1 -- RQ2.2} and \textbf{RQ3.1 -- RQ3.4}.

To answer questions \textbf{RQ2.3} and \textbf{RQ3.5} we will conduct a series of contrast
analyses to evaluate the following statistical hypotheses related to the research questions.
We derive these contrasts from linear combinations of the mean difference of each specific
grime type used as a treatment. Each combination provides insight into the relative effects
grime subtypes and categories have on the mean change in the quality attribute. In addition,
these combinations provide a relative ranking between subtypes within a category and then
between categories.

\subsection{Evaluation of Validity}

In any empirical inquiry, we are concerned with the reliability and validity of our methods.
In this study, we ensure the reliability and validity of the tools and methods used in the
experiment: We selected third-party tools known to be of high quality and relatively
bug-free. We have thoroughly tested the tools we developed at the unit, integration, and
system level. We include assurance of the validity of the methods as part of the process.
Specifically, for each analysis technique used, we validate the assumptions before executing
the analysis. The pilot study used to evaluate design size serves to test the data
collection method and identify reliability or validity issues in the process. We will
correct any issues identified during the pilot study before commencing the complete study.

\section{Execution}\label{sec:gq_execution}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=\textwidth]{experimental_process/exp_execution.eps}
 \caption{Data collection execution process.}\label{fig:execution}
\end{figure}

The data was collected using the process described in Section \ref{sec:gq_dc_proc}. In
addition to the process defined, we made the following modifications. First, to finish the
experiments in a reasonable amount of time, we spread the execution across multiple
machines. The exact process for this is depicted in Figure \ref{fig:execution} and follows
the process identified by the numbers encircled in green. 1.) We developed a small tool to
generate and separate the experimental configurations for deployment across multiple
machines. The \textit{Experimental Control Generator} performs this function by first
generating all experimental configurations and then randomizing this list. The
\textit{Experimental Control Generator} subdivides this list based on information from 2.)
the provided \textit{ExGen Config} which specifies the number of machines, cores per
machine, and parts per machine for execution. 3.) The \textit{Experimental Control
Generator} combines this data with the experiment executor and several scripts (used to
facilitate automated execution and database management) into an \textit{Experiment Execution
Package}. 4.) We distribute these packages to several execution machines. During the
execution of these experiments, the number of available machines ranged from 6 to 30 desktop
computers. 5.) As experimental packages completed execution, a script collected their
results and stored them for later aggregation. 7.) The \textit{Results Aggregator} performs
the aggregation combining all results from multiple executions into a single results CSV
file for analysis.

\section{Analysis Results}\label{sec:gq_analysis}

This section summarizes the collected data and describes the results of our analysis. This
section contains eight subsections: first, we describe the size analysis results,
identifying the number of replications needed in the subsequent experiments, and the
remaining seven sections detail the results of each experiment conducted.

\subsection{Size Analysis}\label{sec:gq_pilot}

\begin{table}[!tb]
\caption{Size analysis results.}\label{tab:power_analysis}

\centering
\begin{tabular}{l|cccccc|c}
\hline
\multicolumn{1}{c|}{\textbf{Attribute}} & \textbf{$\alpha$} & \textbf{Power} & \textbf{Effect Size} & \textbf{df} & \textbf{Rep Size} & \textbf{Size} & \textbf{Reps} \\ \hline
\textbf{Analyzability} & 0.05 & 0.95 & 0.2255272 & 1875 & 2496 & 5425  & \textbf{3} \\
\textbf{Testability}   & 0.05 & 0.95 & 0.0863064 & 1875 & 2496 & 29506 & \textbf{12}\\
\textbf{Modifiability} & 0.05 & 0.95 & 0.1695395 & 1875 & 2496 & 8536  & \textbf{4} \\
\textbf{Modularity}    & 0.05 & 0.95 & 0.1679058 & 1875 & 2496 & 8661  & \textbf{4} \\
\textbf{TD Principle}  & 0.05 & 0.95 & 0.2456884 & 1875 & 2496 & 4816  & \textbf{2} \\
\textbf{TD Interest}   & 0.05 & 0.95 & 0.1980468 & 1875 & 2496 & 6602  & \textbf{3} \\ \hline
\end{tabular}
\end{table}

We conducted a pilot study to determine the number of replications necessary to achieve the
required statistical power for the hypothesis tests in each of the experiments. This study
used only two patterns (Singleton and State) for each of the six levels of Injection
Severity and all 26 Injection Types. This combination led to the generation of 312 pattern
instances. These instances were analyzed using the same data collection approach defined for
the actual experiments, and the results were collected. These results were analyzed to
determine the number of replications needed for each experiment to achieve 95\% power when
considering the three-way interaction effects. To determine this, we used the G * Power 3.1
\cite{faul2009statistical}. Table \ref{tab:power_analysis} depicts the results of this
analysis.

\subsection{Analyzability}

This subsection describes the results of the Analyzability analysis. We subdivided the
analysis into a subsection describing the data and descriptive statistics, and a subsection
concerns hypothesis testing.

\subsubsection{Descriptive Statistics}

\begin{table}[!tb]
\centering
\caption{Summary of Analyzability data.}\label{tab:ana_summary}
\begin{tabular}{l|llllll}
\hline
\textbf{Experiment} & \textbf{Min} & \textbf{1st Qu.} & \textbf{Median} & \textbf{Mean} & \textbf{3rd Qu.} & \textbf{Max} \\ \hline
Analyzability       & -1.0382265   & -0.0133267       & -0.0038076      & -0.1226307    & -0.0009018       & 0.0          \\ \hline
%Testability         & -1.459066    & -0.021427        & -0.005952       & -0.248710     & -0.001323        & 0.0          \\
%Modifiability       & -1.36        & 0.0              & 0.0             & -0.01526      & 0.0              & 0.49121      \\
%Modularity          & -2.64236     & 0.0              & 0.0             & -0.6583       & 0.0              & 1.23418      \\
%Reusability         & 0.0          & 0.0              & 0.0             & 0.0           & 0.0              & 0.0          \\
%TD Principal        & -0.9351      & 0.0              & 0.1002          & 0.3206        & 0.3937           & 12.7850      \\
%TD Interest         & -0.0072254   & 0.0              & 0.0006794       & 0.0025232     & 0.002888         & 0.0962732    \\ \hline
\end{tabular}
\end{table}

% Present the data using descriptive statistics

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/analyzability/table_plot.pdf}

 \caption{Table plot of Analyzability data.}\label{fig:ana_tab_plot}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/analyzability/panels_plot.pdf}

 \caption{Scatterplot matrix of the dependent variable and independent variables for the
Analyzability experiment.}\label{fig:ana_panels}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/analyzability/histogram.pdf}

 \caption{Histogram and boxplot of the change in Analyzability.}\label{fig:ana_histogram}
\end{figure}

% Present the data using descriptive statistics
This section presents the results of the Analyzability experiment using descriptive
statistics and plots. First, we show the summary of the Change in Analyzability (the
dependent variable) in Table \ref{tab:ana_summary}. The table shows the basic statistics
across the 7,488 observations. We note that the max value was 0 stars for the Change in
Analyzability, and the min was -1.0382265 stars. Keeping these values in mind, we begin to
put this data into context when we consider it along with the three factors Pattern Type,
Injection Type, and Injection Severity, as depicted in the table plot in Figure
\ref{fig:ana_tab_plot}. This plot shows several interesting pieces of information.

The first interesting information is that the control level of Injection Severity (ISFactor
= 0) is directly related to zero values for Change in Analyzability (sigAnalyzability). The
second interesting note is that the most prominent values (last ~20\%) of the
sigAnalyzability data seems to be related to only a tiny subset of ITFactor levels. However,
this same data appears to cut across all levels of both the PTFactor and ISFactor (excluding
the control level). The scatterplot matrix, presented in Figure \ref{fig:ana_panels},
further confirms these results (in the lower triangle of the matrix). Additionally, we note
that the distribution of sigAnalyzability is heavily skewed to the right as shown in both
Figure \ref{fig:ana_panels} and Figure \ref{fig:ana_histogram}. With this basic
understanding of the data, we shift to hypothesis testing.

\subsubsection{Hypothesis Testing}

Initially, we begin the analysis by determining if using the parametric ANOVA approach is
appropriate. We determined this by validating the fundamental assumptions of ANOVA. As noted
above, the two fundamental assumptions we are concerned with are the normality and
homogeneity of variances assumptions.

\begin{figure}[!tb]
 \centering
 \includegraphics[width=\textwidth]{analysis/experiments/analyzability/aov_plot.pdf}

 \caption{Analyzability diagnostic plots.}\label{fig:ana_aov}
\end{figure}

\paragraph{Normality Assumption} To evaluate this assumption, we plotted the ANOVA model, as
depicted in Figure \ref{fig:ana_aov}. The pertinent plot here is the ``Normal Q-Q'' Plot in
the upper right quadrant. Here we see deviations from Normal in the tails of the data, which
is a strong indicator of a violation of the normality assumption. This evidence is further
confirmed using the Anderson-Darling normality test \cite{anderson_test_1954} as provided by
the \verb|ad.test| function in the
\verb|nortest|\footnote{\url{https://cran.r-project.org/package=nortest}} package for R.
This test assumes that we have a set of observations sampled from some continuous
distribution, $F(x)$ and that the measurement scale is at least ordinal. If these
assumptions are met, then we can compare $F(x)$ to a hypothesized distribution $F^*(x)$,
such as the normal distribution in this case. The null and alternative hypotheses for such a
two-sided test are as follows:

\vskip-2em
\begin{eqnarray*}
H_{0} & : & F(x) = F^*(X)\\
H_{A} & : & F(x)\neq F^*(X)
\end{eqnarray*}

\noindent The results of this test ($A = 1812.5$, $p < 2.2\mathrm{e}{-16}$) provides strong
evidence to reject the null hypothesis and further confirming the violation of the normality
assumption.

\paragraph{Homogeneity of Variances Assumption} We validated this assumption using a similar
process as the Normality assumption. We again look to Figure \ref{fig:ana_aov}, focusing on
the ``Residual vs. Fitted'' plot in the upper-left quadrant. This plot indicates that there
is a violation of the assumption. To analytically confirm this, we executed Levene's Test
for Homogeneity of Variance \cite{levene_robust_1960} (as provided by the \verb|car| package
in R \cite{fox_companion_2019}). The null and alternative hypotheses for this test are as
follows:

\begin{eqnarray*}
 H_{0} & : & \sigma^2_1 = \sigma^2_2 = \ldots = \sigma^2_n \\
 H_{A} & : & \sigma^2_i \neq \sigma^2_j\,\, \textrm{for some}\,\, i \neq j
\end{eqnarray*}


\noindent The results ($F(2495, 4992) = 1.6523\mathrm{e}{26}$, $p < 2.2\mathrm{e}{-16}$) of
this test provide strong evidence to reject the null hypothesis that the variances are the
same. These results further confirming this assumption has been violated.

\paragraph{Permutation F-Test Analysis}

The results of the assumption validation steps lead to the conclusion that either we
transform the data or we use a permutation F-test approach (according to our analytical
approach defined above in Section \ref{chap:ex_grime_and_quality}.\ref{sec:ex_ana_proc}). After several attempts to adjust
for the violations, we opted to conduct the permutation F-test approach. The permutation
F-Test tests the following null and alternative hypotheses:

\begin{eqnarray*}
H_{1,0} & : & \mu_{111} = \mu_{112} = \ldots = \mu_{ijk} \\
H_{1,1} & : & \mu_{ijk} \neq \mu_{i'j'k'}
\end{eqnarray*}

\noindent Where $\mu_{ijk}$ represents the mean change in Analyzability for the ith Pattern
Type, jth Injection Type, and kth Injection Severity. If the evidence is strong enough to
reject the null hypothesis, $H_{1,0}$, then we will evaluate whether we should consider the
main or the interaction effects. To test this, we used the \verb|lmp| function of the
\verb|lmPerm|\footnote{\url{https://cran.r-project.org/package=lmPerm}} package for R. The
overall results of this test ($F(2495,4992) = 23.68$, $p < 2.2\mathrm{e}{-16}$) indicate
strong evidence to reject the null hypothesis that there is no difference in the mean change
in Analyzability.

\paragraph{Interaction Effects}

\begin{figure}[!tb]
 \centering

\includegraphics[width=.9\textwidth]{analysis/experiments/analyzability/class_grime_interactions.pdf}

 \caption{Analyzability Class Grime interactions part 1.}\label{fig:ana_cls_inter}
\end{figure}

\begin{figure}[!tb]
 \centering

\includegraphics[width=.9\textwidth]{analysis/experiments/analyzability/class_grime_interactions2.pdf}

 \caption{Analyzability Class Grime interactions part 2.}\label{fig:ana_cls_inter2}
\end{figure}

\begin{figure}[!tb]
 \centering

\includegraphics[width=.9\textwidth]{analysis/experiments/analyzability/mod_grime_interactions.pdf}

 \caption{Analyzability Modular Grime interactions.}\label{fig:ana_mod_inter}
\end{figure}

\begin{figure}[!tb]
 \centering

\includegraphics[width=.9\textwidth]{analysis/experiments/analyzability/mod_org_grime_interactions.pdf}

 \caption{Analyzability Modular Organizational Grime interactions part 1.}\label{fig:ana_mod_org_inter}
\end{figure}

\begin{figure}[!tb]
 \centering

\includegraphics[width=.9\textwidth]{analysis/experiments/analyzability/mod_org_grime_interactions2.pdf}

 \caption{Analyzability Modular Organizational Grime interactions part 2.}\label{fig:ana_mod_org_inter2}
\end{figure}

\begin{figure}[!tb]
 \centering

\includegraphics[width=.9\textwidth]{analysis/experiments/analyzability/pkg_org_grime_interactions.pdf}

 \caption{Analyzability Package Organizational Grime interactions.}\label{fig:ana_pkg_org_inter}
\end{figure}

\begin{figure}[!tb]
 \centering

\includegraphics[width=.9\textwidth]{analysis/experiments/analyzability/pkg_org_grime_interactions2.pdf}

 \caption{Analyzability interactions for the PERG subtype.}\label{fig:ana_pkg_org_inter2}
\end{figure}

\begin{figure}[!tb]
 \centering

\includegraphics[width=.9\textwidth]{analysis/experiments/analyzability/pkg_org_grime_interactions3.pdf}

 \caption{Analyzability interactions for the PIRG subtype.}\label{fig:ana_pkg_org_inter3}
\end{figure}

With the knowledge that a difference in the mean Change in Analyzability exists between two
or more treatment combinations, we continue by considering any significant interactions. We
begin by testing the following hypotheses:

\vskip-2em
\begin{eqnarray*}
H_{2,0} & : & \left(\tau\beta\gamma\right)_{111} = \left(\tau\beta\gamma\right)_{112} = \ldots = \left(\tau\beta\gamma\right)_{ijk} \\
H_{2,1} & : & \textrm{at least one}\,\left(\tau\beta\gamma\right)_{ijk} \ne \left(\tau\beta\gamma\right)_{i'j'k'}
\end{eqnarray*}

\noindent In this case, there is strong evidence ($p < 2.2\mathrm{e}{-16}$) to reject
$H_{2,0}$ that there is no difference in the mean change in Analyzability for each level of
the three-way interaction effect. With this in mind, we will consider a graphical analysis
of these interactions. To plot these interactions, we subdivided into grime categories:
Class Grime, Modular Grime, and Organizational Grime (which we further split into Package
Organizational Grime and Modular Organizational Grime). Each grime category plot contains a
matrix of subplots (one per grime type in the category). The y-axis is the change in
Analyzability, the x-axis is the design pattern type, and the points plotted are the values
for each injection severity. We begin with the plots for Class Grime.

Figures \ref{fig:ana_cls_inter} and \ref{fig:ana_cls_inter2} depict the interaction effects
associated with the class grime subtypes. Each subplot in this figure shows that as
injection severity increases, there is a corresponding decrease in the change in
Analyzability across each pattern type. We will note that for the Bridge, Decorator,
Observer, Singleton, and Visitor patterns, there is a more pronounced spike in the change.
Additionally, for DESG and IEPG, there are significant spikes in the Change in Analyzability
for the Singleton pattern. Specifically for DESG when Injection Severity is 3 or 4 and for
IEPG when Injection Severity is 5. Given these results, we now shift to the interaction
plots for the Modular Grime category.

Figure \ref{fig:ana_mod_inter} depicts the interaction effects associated with the modular
grime subtypes. Like the Class Grime subtypes, we can see an apparent corresponding decrease
in the Change in Analyzability across all pattern types as injection severity increases. A
similar relationship appears to be true for each subtype of modular grime, but there is a
stark contrast between PIG and the other forms of Modular Grime.  Additionally, we can see
similar spikes in the Change in Analyzability for Bridge, Decorator, Observer, Singleton,
and Visitor patterns as we did in Class Grime.

Figures \ref{fig:ana_mod_org_inter} and \ref{fig:ana_mod_org_inter2} depict the interaction
effects associated with modular organizational grime subtypes. In Figure
\ref{fig:ana_mod_org_inter2}, for MPECG, MTECG, and MTEUG, we see the familiar trend of a
decrease in the Change in Analyzability as Injection Severity increases across pattern
types. Furthermore, we also can see that there are pronounced spikes at the Bridge,
Decorator, Observer, Singleton, and Visitor design patterns. However, in Figure
\ref{fig:ana_mod_org_inter} there is significant variability in the change between levels of
Injection Severity depending on the pattern type for MPICG, MPIUG, MTICG, and MTIUG. It
appears that for MPICG that regardless of the pattern type and injection severity level, the
effect is nearly the same.

Finally, Figures \ref{fig:ana_pkg_org_inter}, \ref{fig:ana_pkg_org_inter2}, and
\ref{fig:ana_pkg_org_inter3} depict the interaction effects associated with package
organizational grime. For PECG and PICG subtypes, depicted in Figure
\ref{fig:ana_pkg_org_inter}, we note that there is only small variability across design
pattern types for Injection Severity levels of 3 or more. The primary variability in these
grime types occurs for Injection Severity levels 1 and 2. When considering PERG, as depicted
in Figure \ref{fig:ana_pkg_org_inter2}, we note that for Injection Severity levels 3 and
above, there is no discernible variability across patterns, but for levels 1 and 2 pattern
type seems to make some difference, but the actual difference is extremely small
(approximately -0.00055 to -0.00080 stars on average). Finally, when considering PIRG, as
depicted in Figure \ref{fig:ana_pkg_org_inter3}, the familiar interaction pattern returns.
This figure shows a corresponding decrease in Change in Analyzability across patterns as
Injection Severity increases. Again, we also note that there are discernible spikes at the
Bridge, Decorator, Observer, Singleton, and Visitor design pattern types.


\subsection{Testability}

This subsection describes the results of the Testability analysis. We subdivided the
analysis into a subsection describing the data and descriptive statistics, and a subsection
concerns hypothesis testing.

\subsubsection{Descriptive Statistics}

\begin{table}[!tb]
\centering
\caption{Summary of Testability data.}\label{tab:test_summary}
\begin{tabular}{l|llllll}
\hline
\textbf{Experiment} & \textbf{Min} & \textbf{1st Qu.} & \textbf{Median} & \textbf{Mean} & \textbf{3rd Qu.} & \textbf{Max} \\ \hline
%Analyzability       & -1.0382265   & -0.0133267       & -0.0038076      & -0.1226307    & -0.0009018       & 0.0          \\ \hline
Testability         & -1.459066    & -0.021427        & -0.005952       & -0.248710     & -0.001323        & 0.0          \\ \hline
%Modifiability       & -1.36        & 0.0              & 0.0             & -0.01526      & 0.0              & 0.49121      \\
%Modularity          & -2.64236     & 0.0              & 0.0             & -0.6583       & 0.0              & 1.23418      \\
%Reusability         & 0.0          & 0.0              & 0.0             & 0.0           & 0.0              & 0.0          \\
%TD Principal        & -0.9351      & 0.0              & 0.1002          & 0.3206        & 0.3937           & 12.7850      \\
%TD Interest         & -0.0072254   & 0.0              & 0.0006794       & 0.0025232     & 0.002888         & 0.0962732    \\ \hline
\end{tabular}
\end{table}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/testability/table_plot.pdf}

 \caption{Table plot of Testability data.}\label{fig:test_tab_plot}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/testability/panels_plot.pdf}

 \caption{Scatterplot matrix of the dependent variable and independent variables for the Testability experiment.}\label{fig:test_panels}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/testability/histogram.pdf}

 \caption{Histogram and boxplot of the change in Testability.}\label{fig:test_hist}
\end{figure}

% Present the data using descriptive statistics
This section presents the results of the Testability experiment using descriptive statistics
and plots. First, we show the summary of the Change in Testability (the dependent variable)
in Table \ref{tab:test_summary}. The table shows the basic statistics across the 19,968
observations. We note that the max value was 0 stars for the Change in Testability, and the
min was -1.459066 stars. Keeping these values in mind, we begin to put this data into
context when we consider it along with the three factors Pattern Type, Injection Type, and
Injection Severity, as depicted in the table plot in Figure \ref{fig:test_tab_plot}. This
plot shows several interesting pieces of information.

The first interesting information is that just over 15\% of Testability data that is zero
occurs when ISFactor is zero. Second, 20\% of values of Testability that indicate the most
significant changes seem to be related to only ITFactor values ranging from MPECG to PEAG
but cut across all PTFactor and ISFactor levels (excluding ISFactor level 0). The
scatterplot matrix, presented in Figure \ref{fig:test_panels}, further confirms these
observations. Additionally, we note that the distribution of Testability is heavily skewed
to the right, as shown in both Figure \ref{fig:test_panels} and Figure \ref{fig:test_hist},
but has a second peak in the data near -1.3. With this basic understanding of the data, we
shift to hypothesis testing.

% \begin{figure}[H]
%  \centering
%  \includegraphics[width=.85\textwidth]{analysis/experiments/analyzability/boxplots.pdf}
%
%  \caption{}\label{fig:ana_box}
% \end{figure}

\subsubsection{Data Set Reduction}

The initial data collection for this experiment collected 12 replicates consisting of a
total of 29952 observations. However, due to the long processing time, this was reduced to 8
replicates of 19968 total observations.

\subsubsection{Hypothesis Testing}

Initially, we begin the analysis by determining if using the parametric ANOVA approach is
appropriate. We determined this by validating the fundamental assumptions of ANOVA. As noted
above, the two fundamental assumptions we are concerned with are the normality and
homogeneity of variances assumptions.

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/testability/aov_plot.pdf}

 \caption{Testability diagnostic plots.}\label{fig:test_aov}
\end{figure}

\paragraph{Normality Assumption} To evaluate this assumption, we plotted the ANOVA model, as
depicted in Figure \ref{fig:test_aov}. The pertinent plot here is the ``Normal Q-Q'' Plot in
the upper right quadrant. Here we see deviations from normal in the tails of the data, which
is a strong indicator of a violation of the normality assumption. This evidence is further
confirmed using the Anderson-Darling normality test. The results of this test ($A = 5069.2$,
$p < 2.2\mathrm{e}{-16}$) provides strong evidence to reject the null hypothesis and further
confirming the violation of the normality assumption.

\paragraph{Homogeneity of Variances Assumption} This assumption is evaluated using a similar
process as the Normality assumption. We again look to Figure \ref{fig:test_aov}, focusing on
the ``Residual vs. Fitted'' plot in the upper-left quadrant. This plot indicates that there
is a violation of the assumption. To analytically confirm this, we executed Levene's Test
for Homogeneity of Variance. The results ($F(2495, 17472) = 8.7427$, $p <
2.2\mathrm{e}{-16}$) of this test provides strong evidence to reject the null hypothesis
that the variances are the same. These results further confirming this assumption has been
violated.

\paragraph{Permutation F-Test Analysis}

The results of the assumption validation steps lead to the conclusion that either we
transform the data or we use a permutation F-test approach (according to our analytical
approach defined above in Section \ref{chap:ex_grime_and_quality}.\ref{sec:ex_ana_proc})). After several attempts to adjust
for the violations, we opted to conduct the permutation F-test approach. The overall results
of this test ($F(2495,17472) = 627.8$, $p < 2.2\mathrm{e}{-16}$) indicates strong evidence
to reject the null hypothesis that there is no difference in the mean change in Testability.

\paragraph{Interaction Effects}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/testability/class_grime_interactions.pdf}

 \caption{Testability interaction plots for class grime injection.}\label{fig:test_cls_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/testability/mod_grime_interactions.pdf}

 \caption{Testability interaction plots for modular grime injection.}\label{fig:test_mod_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/testability/mod_org_grime_interactions.pdf}

 \caption{Testability interaction plots for modular organizational grime injection.}\label{fig:test_mod_org_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/testability/mod_org_grime_interactions2.pdf}

 \caption{Testability interaction plots for MTEUG subtype.}\label{fig:test_mod_org_inter2}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/testability/pkg_org_grime_interactions.pdf}

 \caption{Testability interaction plots for package organizational grime injection.}\label{fig:test_pkg_org_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/testability/pkg_org_grime_interactions2.pdf}

 \caption{Testability interaction plots for PERG subtype.}\label{fig:test_pkg_org_inter2}
\end{figure}

With the knowledge that a difference in the mean change in Testability exists between two or
more treatment combinations, we continue by considering significant interactions. In this
case, there is strong evidence ($p < 2.2\mathrm{e}{-16}$) to reject $H_{2,0}$ that there is
no difference in the mean change in Testability for each level of the three-way interaction
effect. With this in mind, we will consider a graphical analysis of these interactions. To
plot these interactions, we subdivided them into grime categories: Class Grime, Modular
Grime, and Organizational Grime. Each grime category plot contains a matrix of subplots (one
per grime type in the category). The subplot matrix contains interaction plots. The y-axis
is the change in Testability, the x-axis is the design pattern type, and the points plotted
are the values for each injection severity. We will begin with the plots for Class Grime.

Figure \ref{fig:test_cls_inter} depicts the interaction effects associated with the class
grime subtypes. Each subplot in this figure shows that as injection severity increases,
there is a corresponding decrease in the change in Testability across each pattern type. We
will note that there is a more pronounced spike in the change for the Bridge, Decorator,
Observer, Singleton, and Visitor patterns. Given these results, we now shift to the
interaction plots for the Modular Grime category.

Figure \ref{fig:test_mod_inter} depicts the interaction effects associated with the modular
grime subtypes. Similar to the Class Grime subtypes, we see an apparent corresponding
decrease in the change in Testability across all pattern types as injection severity
increases. This relationship appears to be true for each subtype of modular grime, but there
is a stark contrast between PIG and the other forms of Modular Grime. Additionally, we can
see similar spikes in the change in Testability for Bridge, Decorator, Observer, Singleton,
and Visitor patterns as we did in Class Grime.

Figures \ref{fig:test_mod_org_inter} and \ref{fig:test_mod_org_inter2} depict the
interaction effects associated with modular organizational grime subtypes. As depicted in
Figure \ref{fig:test_mod_org_inter}, we can see an apparent corresponding decrease in the
change in Testability as Inject Severity increases across all pattern types. The difference
here is that there is significant variability in the change between levels of Injection
Severity depending on the pattern type for MPECG, MPIUG, MTECG, MTICG, and MTIUG. It appears
that for MPICG, as depicted in Figure \ref{fig:test_mod_org_inter2} the familiar pattern of
decreasing Change in Testability as Injection Severity increases across Pattern Types. We
can also see spikes for the Bridge, Decorator, Observer, Singleton, and Visitor patterns.

Finally, Figures \ref{fig:test_pkg_org_inter} and  \ref{fig:test_pkg_org_inter2} depict the
interaction effects associated with package organizational grime. As shown in Figure
\ref{fig:test_pkg_org_inter}, there is a corresponding decrease in the Change in Testability
as the Injection Severity level increases across each Pattern Type. Again, we also note that
there are spikes in the effect level for the Bridge, Decorator, Observer, Singleton, and
Visitor patterns. PERG, on the other hand, as shown in Figure \ref{fig:test_pkg_org_inter2}
shows minimal variability in the Change in Testability for Injection Severity levels of 3 or
higher, but does show some for levels 1 and 2.

\subsection{Modifiability}

This subsection describes the results of the Modifiability analysis. We subdivided the
analysis into a subsection describing the data and descriptive statistics, and a subsection
concerns hypothesis testing.

\subsubsection{Descriptive Statistics}

\begin{table}[!tb]
\centering
\caption{Summary of Modifiability data.}\label{tab:mof_summary}
\begin{tabular}{l|llllll}
\hline
\textbf{Experiment} & \textbf{Min} & \textbf{1st Qu.} & \textbf{Median} & \textbf{Mean} & \textbf{3rd Qu.} & \textbf{Max} \\ \hline
%Analyzability       & -1.0382265   & -0.0133267       & -0.0038076      & -0.1226307    & -0.0009018       & 0.0          \\ \hline
%Testability         & -1.459066    & -0.021427        & -0.005952       & -0.248710     & -0.001323        & 0.0          \\
Modifiability       & -1.36        & 0.0              & 0.0             & -0.01526      & 0.0              & 0.49121      \\ \hline
%Modularity          & -2.64236     & 0.0              & 0.0             & -0.6583       & 0.0              & 1.23418      \\
%Reusability         & 0.0          & 0.0              & 0.0             & 0.0           & 0.0              & 0.0          \\
%TD Principal        & -0.9351      & 0.0              & 0.1002          & 0.3206        & 0.3937           & 12.7850      \\
%TD Interest         & -0.0072254   & 0.0              & 0.0006794       & 0.0025232     & 0.002888         & 0.0962732    \\ \hline
\end{tabular}
\end{table}

% Present the data using descriptive statistics

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/modifiability/table_plot.pdf}

 \caption{Table plot of Modifiability data.}\label{fig:mof_tab_plot}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/modifiability/panels_plot.pdf}

 \caption{Scatterplot matrix of the dependent variable and independent variables for the Modifiability experiment.}\label{fig:mof_panels}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/modifiability/histogram.pdf}

 \caption{Histogram and boxplot of the change in Modifiability.}\label{fig:mof_hist}
\end{figure}

This section presents the results of the Modifiability experiment using descriptive
statistics and plots. First, we show the summary of the Change in Modifiability (the
dependent variable) in Table \ref{tab:mof_summary}. Next, the table shows the basic
statistics across the 7,488 observations. We note that for the Change in Modifiability, the
max value was 0.49121 stars, and the min was -1.36 stars. Keeping these values in mind, we
begin to put this data into context when we consider it along with the three factors Pattern
Type, Injection Type, and Injection Severity, as depicted in the table plot in Figure
\ref{fig:mof_tab_plot}. This plot shows several interesting pieces of information.

There appear to be both negative and positive changes to Modifiability (sigModifiability).
Furthermore, it appears that the positive changes to Modifiability are only affected by a
small subset of pattern types but cut across both Injection Type and Injection Severity. The
scatterplot matrix, presented in Figure \ref{fig:mof_panels}, further confirms these
results. Additionally, we note that the distribution of Modifiability is heavily skewed to
the right as shown in both Figure \ref{fig:mof_panels} and Figure \ref{fig:mof_hist}. With
this basic understanding of the data, we shift to hypothesis testing.

\subsubsection{Hypothesis Testing}

Initially, we begin the analysis by determining if using the parametric ANOVA approach is
appropriate. We determined this by validating the fundamental assumptions of ANOVA. As noted
above, the two fundamental assumptions we are concerned with are the normality and
homogeneity of variances assumptions.

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/modifiability/aov_plot.pdf}

 \caption{Modifiability diagnostic plots.}\label{fig:mof_aov}
\end{figure}

\paragraph{Normality Assumption} To evaluate this assumption, we plotted the ANOVA model, as
depicted in Figure \ref{fig:mof_aov}. The pertinent plot here is the ``Normal Q-Q'' Plot in
the upper right quadrant. Here we see deviations from Normal in the tails of the data, which
is a strong indicator of a violation of the normality assumption. This evidence is further
confirmed using the Anderson-Darling normality test. The results of this test ($A = 3211$,
$p < 2.2\mathrm{e}{-16}$) provides strong evidence to reject the null hypothesis and further
confirming the violation of the normality assumption.

\paragraph{Homogeneity of Variances Assumption} This assumption is evaluated using a similar
process as the Normality assumption. We again look to Figure \ref{fig:mof_aov}, focusing on
the ``Residual vs. Fitted'' plot in the upper-left quadrant. This plot indicates that there
is a violation of the assumption. To analytically confirm this, we executed Levene's Test
for Homogeneity of Variance. The results ($F(2495, 7488) = 2.5321$, $p <
2.2\mathrm{e}{-16}$) of this test provides strong evidence to reject the null hypothesis
that the variances are the same. These results further confirming this assumption has been
violated.

\paragraph{Permutation F-Test Analysis}

The assumption validation steps result in the conclusion that we must either transform the
data or use a permutation F-test approach. After several attempts to adjust for the
violations, we moved forward with the permutation F-test approach. The overall results of
this test ($F(2495,7488) = 4.636$, $p < 2.2\mathrm{e}{-16}$) indicates strong evidence to
reject the null hypothesis that there is no difference in the mean change in Modifiability.

\paragraph{Interaction Effects}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modifiability/class_grime_interactions.pdf}

 \caption{Modifiability interaction plots for class grime injection.}\label{fig:mof_cls_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modifiability/class_grime_interactions2.pdf}

 \caption{Modifiability interaction plots for DISG.}\label{fig:mof_cls_inter2}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modifiability/mod_grime_interactions.pdf}

 \caption{Modifiability interaction plots for modular grime injection.}\label{fig:mof_mod_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modifiability/mod_grime_interactions2.pdf}

 \caption{Modifiability interaction plots for PEAG and TEAG.}\label{fig:mof_mod_inter2}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modifiability/mod_org_grime_interactions.pdf}

 \caption{Modifiability interaction plots for modular organizational grime injection.}\label{fig:mof_mod_org_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modifiability/mod_org_grime_interactions2.pdf}

 \caption{Modifiability interaction plots for MTEUG.}\label{fig:mof_mod_org_inter2}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modifiability/pkg_org_grime_interactions.pdf}

 \caption{Modifiability interaction plots for PECG and PICG.}\label{fig:mof_pkg_org_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modifiability/pkg_org_grime_interactions2.pdf}

 \caption{Modifiability interaction plots for PERG.}\label{fig:mof_pkg_org_inter2}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modifiability/pkg_org_grime_interactions3.pdf}

 \caption{Modifiability interaction plots for PIRG.}\label{fig:mof_pkg_org_inter3}
\end{figure}

With the knowledge that a difference in the mean change in Modifiability exists between two
or more treatment combinations, we continue by considering any significant interactions. In
this case, there is strong evidence ($p < 2.2\mathrm{e}{-16}$) to reject $H_{2,0}$ that
there is no difference in the mean change in Modifiability for each level of the three-way
interaction effect. With this in mind, we will consider a graphical analysis of these
interactions. To plot these interactions, we subdivided them into grime categories: Class
Grime, Modular Grime, and Organizational Grime. Each grime category plot contains a matrix
of subplots (one per grime type in the category). The y-axis is the change in Modifiability,
the x-axis is the design pattern type, and the points plotted are the values for each
injection severity. We will begin with the plots for Class Grime.

We begin with the interaction plots for Class Grime as depicted in Figures
\ref{fig:mof_cls_inter} and \ref{fig:mof_cls_inter2}. This figure shows us that not all
pattern types afflicted with class grime have an impact on Modifiability. However, it does
suggest that for several levels of injection severity, Decorator, Prototype, and Visitor
afflicted with Class Grime will have a positive change in Modifiability. Additionally, there
is evidence, as depicted in Figure \ref{fig:mof_cls_inter2}, that for DISG subtype with
Injection Severity level 1 that Factory Method instances negatively impact the Change in
Modifiability. Finally, there appears to be no direct relationship between the severity and
the change in Modifiability.

Next, we look in detail at the interactions associated with Modular Grime types as depicted
in Figures \ref{fig:mof_mod_inter} and \ref{fig:mof_mod_inter2}. Figure
\ref{fig:mof_mod_inter2} shows some interesting interactions. We begin by considering the
two afferent grime subtypes PEAG and TEAG. In these two cases, injection severity levels of
at least four across all pattern types (excluding Prototype) presents significant negative
changes in Modifiability. This relationship is in stark contrast to the other four subtypes,
depicted in \ref{fig:mof_mod_inter}, which appear to be more similar to the class grime
interactions. Again, for these four subtypes (PEEG, TEEG, PIG, and TIG), they have a mostly
positive effect on Modifiability and are focus on only a few pattern types, namely
Decorator, Prototype, and Visitor. Additionally, there appears to be no direct relationship
between injection severity and the change in Modifiability.

Next, we look at Modular Organizational Grime type interactions as depicted in Figures
\ref{fig:mof_mod_org_inter} and \ref{fig:mof_mod_org_inter2}. Notably, across all subtypes
of grime depicted, the patterns Decorator, Prototype, and visitor seem to be the key pattern
types. We also note that internal cyclic forms of Modular Organizational Grime (namely MPICG
and MTICG) appear to have a negative effect, whereas the other subtypes have a predominately
positive effect. However, there appears to be no relationship between injection severity and
the effect on the Change in Modifiability for these same subtypes. Additionally, we note
that other pattern types appear to be prominent for the internal cyclic forms, particularly
Observer, Singleton, and Adapter.

Finally, we look at Package Organizational Grime type interactions as depicted in Figure
\ref{fig:mof_pkg_org_inter}. This figure shows that for PECG, PERG, and PICG subtypes,
Decorator, Prototype, and Visitor again provide positive effects. Additionally, for the
cyclic subtypes (PECG and PICG) Factory Method shows some involvement. The remaining
subtype, PIRG, shows significant effects on Modifiability across all pattern types with
predominantly adverse effects. The only exceptions to this are the positive effect found for
Prototype and Visitor. Thus, again, there appears to be no relationship between injection
severity and the change in Modifiability.

\subsection{Modularity}

This subsection describes the results of the Modularity analysis. We subdivided the
analysis into a subsection describing the data and descriptive statistics, and a subsection
concerns hypothesis testing.

\subsubsection{Descriptive Statistics}

\begin{table}[!tb]
\centering
\caption{Summary of Modularity data.}\label{tab:mod_summary}
\begin{tabular}{l|llllll}
\hline
\textbf{Experiment} & \textbf{Min} & \textbf{1st Qu.} & \textbf{Median} & \textbf{Mean} & \textbf{3rd Qu.} & \textbf{Max} \\ \hline
%Analyzability       & -1.0382265   & -0.0133267       & -0.0038076      & -0.1226307    & -0.0009018       & 0.0          \\ \hline
%Testability         & -1.459066    & -0.021427        & -0.005952       & -0.248710     & -0.001323        & 0.0          \\
%Modifiability       & -1.36        & 0.0              & 0.0             & -0.01526      & 0.0              & 0.49121      \\
Modularity          & -2.64236     & 0.0              & 0.0             & -0.6583       & 0.0              & 1.23418      \\ \hline
%Reusability         & 0.0          & 0.0              & 0.0             & 0.0           & 0.0              & 0.0          \\
%TD Principal        & -0.9351      & 0.0              & 0.1002          & 0.3206        & 0.3937           & 12.7850      \\
%TD Interest         & -0.0072254   & 0.0              & 0.0006794       & 0.0025232     & 0.002888         & 0.0962732    \\ \hline
\end{tabular}
\end{table}

% Present the data using descriptive statistics

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/modularity/table_plot.pdf}

 \caption{Table plot of Modularity data.}\label{fig:mod_tab_plot}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/modularity/panels_plot.pdf}

 \caption{Scatterplot matrix of the dependent variable and independent variables for the Modularity experiment.}\label{fig:mod_panels}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/modularity/histogram.pdf}

 \caption{Histogram and boxplot of the change in Modifiability.}\label{fig:mod_hist}
\end{figure}

This section presents the results of the Modularity experiment using descriptive statistics
and plots. First, we show the summary of the Change in Modularity (the dependent variable)
in Table \ref{tab:mod_summary}. The table shows the basic statistics across the 7,488
observations. We note that for the Change in Modularity, the max value was 1.23418 stars,
the min was -2.64232 stars, and the mean was -0.6583 stars. Keeping these values in mind, we
begin to put this data into context when we consider it along with the three factors Pattern
Type, Injection Type, and Injection Severity, as depicted in the table plot in Figure
\ref{fig:mod_tab_plot}. This plot shows several interesting pieces of information.

Similar to Modifiability, Modularity shows both negative and positive effects. For both, it
appears that only a few Injection Types provide the largest effects in both directions, but
this crosscuts both pattern types and injection severity. The scatterplot matrix, presented
in Figure \ref{fig:mod_panels}, further confirms these results. Additionally, we note the
distribution of Modularity is slightly skewed to the right as shown in both Figure
\ref{fig:mod_panels} and Figure \ref{fig:mod_hist} with a more spread out distribution
centered at zero. With this basic understanding of the data, we shift to hypothesis testing.

\subsubsection{Hypothesis Testing}

Initially, we begin the analysis by determining if using the parametric ANOVA approach is
appropriate. We determined this by validating the fundamental assumptions of ANOVA. As noted
above, the two fundamental assumptions we are concerned with are the normality and
homogeneity of variances assumptions.

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/modularity/aov_plot.pdf}

 \caption{Modularity diagnostic plots.}\label{fig:mod_aov}
\end{figure}

\paragraph{Normality Assumption} To evaluate this assumption, we plotted the ANOVA model, as
depicted in Figure \ref{fig:test_aov}. The pertinent plot here is the ``Normal Q-Q'' Plot in
the upper right quadrant. Here we see deviations from Normal in the tails of the data, which
is a strong indicator of a violation of the normality assumption. This evidence is further
confirmed using the Anderson-Darling normality test. The results of this test ($A = 1122.3$,
$p < 2.2\mathrm{e}{-16}$) provides strong evidence to reject the null hypothesis and further
confirming the violation of the normality assumption.

\paragraph{Homogeneity of Variances Assumption} This assumption is evaluated using a similar
process as the Normality assumption. We again look to Figure \ref{fig:test_aov}, focusing on
the ``Residual vs. Fitted'' plot in the upper-left quadrant. This plot indicates that there
is a violation of the assumption. To analytically confirm this, we executed Levene's Test
for Homogeneity of Variance. The results ($F(2495, 7488) = 3.1551$, $p <
2.2\mathrm{e}{-16}$) of this test provides strong evidence to reject the null hypothesis
that the variances are the same. These results further confirming this assumption has been
violated.

\paragraph{Permutation F-Test Analysis}

The assumption validation steps indicate that we must either transform the data or use a
permutation F-test approach. After several attempts to adjust for the violations, we moved
forward with the permutation F-test approach. The overall results of this test
($F(2495,7488) = 57.63$, $p < 2.2\mathrm{e}{-16}$) indicates strong evidence to reject the
null hypothesis that there is no difference in the mean change in Modularity.

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modularity/class_grime_interactions.pdf}

 \caption{Modularity interaction plots for class grime injection.}\label{fig:mod_cls_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modularity/mod_grime_interactions.pdf}

 \caption{Modularity interaction plots for modular grime injection.}\label{fig:mod_mod_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modularity/mod_grime_interactions2.pdf}

 \caption{Modularity interaction plots for PEAG and TEAG.}\label{fig:mod_mod_inter2}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modularity/mod_org_grime_interactions.pdf}

 \caption{Modularity interaction plots for modular organizational grime injection.}\label{fig:mod_mod_org_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modularity/mod_org_grime_interactions2.pdf}

 \caption{Modularity interaction plots for MTEUG.}\label{fig:mod_mod_org_inter2}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/modularity/pkg_org_grime_interactions.pdf}

 \caption{Modularity interaction plots for package organizational grime injection.}\label{fig:mod_pkg_org_inter}
\end{figure}

With the knowledge that a difference in the mean change in Modularity exists between two or
more treatment combinations, we continue by considering any significant interactions. In
this case, there is strong evidence ($p < 2.2\mathrm{e}{-16}$) to reject $H_{2,0}$ that
there is no difference in the mean change in Modularity for each level of the three-way
interaction effect. With this in mind, we will consider a graphical analysis of these
interactions. To plot these interactions, we subdivided them into grime categories: Class
Grime, Modular Grime, and Organizational Grime. Each grime category plot contains a matrix
of subplots (one per grime type in the category). In these plots, the y-axis is the change
in Modularity, the x-axis is the design pattern type, and the points plotted are the values
for each injection severity. We will begin with the plots for Class Grime.

We begin with the interaction plots for Class Grime as depicted in Figure
\ref{fig:mod_cls_inter}. This figure shows us that not all pattern types afflicted with
class grime have an impact on Modifiability. However, it does suggest that for several
levels of injection severity, Decorator, Prototype, and Visitor afflicted with Class Grime
will have a positive change in Modularity. Interestingly, there appears to be no direct
relationship between the severity and the change in Modularity.

Next, we look in detail at the interactions associated with Modular Grime types as depicted
in Figures \ref{fig:mod_mod_inter} and \ref{fig:mod_mod_inter2}. Here there are some
interesting interactions. Specifically, we consider the two afferent grime subtypes PEAG and
TEAG. In these two cases, when injection severity is at least four across all pattern types
(excluding Prototype), there are significant negative changes in Modularity. This finding is
in stark contrast to the other four subtypes, which appear to be more similar to the class
grime interactions. Again, these four subtypes (PEEG, TEEG, PIG, and TIG) have a mostly
positive effect on Modularity and focus on only a few pattern types, namely Decorator,
Prototype, and Visitor. Additionally, there appears to be no direct relationship between
injection severity and the change in Modularity.

Next, we look at Modular Organizational Grime type interactions as depicted in Figures
\ref{fig:mod_mod_org_inter} and \ref{fig:mod_mod_org_inter2}. Again, we note that only a few
key patterns appear to affect a change in Modularity when afflicted with these subtypes of
grime. Notably, across all subtypes of grime depicted, the patterns Decorator, Prototype,
and visitor seem to be the key pattern types. We also note that internal cyclic forms of
Modular Organizational Grime (namely MPICG and MTICG) appear to have a negative effect,
whereas the other subtypes have a predominately positive effect. Additionally, we note that
other pattern types appear to be prominent for the internal cyclic forms, particularly
Observer, Singleton, and Adapter. Additionally, looking at Figure
\ref{fig:mod_mod_org_inter2} we can see that it appears that there is minimal variability
across Pattern Types and Injection Severity levels concerning the Change in Modularity.
Rather it appears that for all levels, MTEUG affects nearly 1-star positive change in
Modularity.

Finally, we look at Package Organizational Grime type interactions as depicted in Figure
\ref{fig:mod_pkg_org_inter}. This figure shows that for PECG, PERG, and PICG subtypes,
Decorator, Prototype, and Visitor again provide positive effects. Additionally, for the
cyclic subtypes (PECG and PICG) Factory Method shows some involvement. The remaining
subtype, PIRG, shows significant effects on Modularity across all pattern types with
predominantly negative effects. The only exceptions to this are the positive effect found
for Prototype and Visitor. Again, there appears to be no relationship between injection
severity and the change in Modularity.

\subsection{Reusability}

This subsection describes the results of the Reusability analysis. We subdivided the
analysis into a subsection describing the data and descriptive statistics, and a subsection
concerns hypothesis testing.

\subsubsection{Descriptive Statistics}

\begin{table}[!tb]
\centering
\caption{Summary of Reusability data.}\label{tab:res_summary}
\begin{tabular}{l|llllll}
\hline
\textbf{Experiment} & \textbf{Min} & \textbf{1st Qu.} & \textbf{Median} & \textbf{Mean} & \textbf{3rd Qu.} & \textbf{Max} \\ \hline
%Analyzability       & -1.0382265   & -0.0133267       & -0.0038076      & -0.1226307    & -0.0009018       & 0.0          \\ \hline
%Testability         & -1.459066    & -0.021427        & -0.005952       & -0.248710     & -0.001323        & 0.0          \\
%Modifiability       & -1.36        & 0.0              & 0.0             & -0.01526      & 0.0              & 0.49121      \\
%Modularity          & -2.64236     & 0.0              & 0.0             & -0.6583       & 0.0              & 1.23418      \\
Reusability         & 0.0          & 0.0              & 0.0             & 0.0           & 0.0              & 0.0          \\ \hline
%TD Principal        & -0.9351      & 0.0              & 0.1002          & 0.3206        & 0.3937           & 12.7850      \\
%TD Interest         & -0.0072254   & 0.0              & 0.0006794       & 0.0025232     & 0.002888         & 0.0962732    \\ \hline
\end{tabular}
\end{table}

% Present the data using descriptive statistics

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/reusability/table_plot.pdf}

 \caption{Table plot of Reusability data.}\label{fig:res_tab_plot}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/reusability/panels_plot.pdf}

 \caption{Scatterplot matrix of the dependent variable and independent variables for the Reusability experiment.}\label{fig:res_panels}
\end{figure}

This subsection describes the data collected. Figures \ref{fig:res_tab_plot} and
\ref{fig:res_panels} depict the data shape, distribution, and the relationships between the
dependent variable (sigReusability in the figures) and the independent variables (PTFactor,
ITFactor, and ISFactor in the figures). Figures \ref{fig:res_tab_plot} and
\ref{fig:res_panels} both show all Reusability values are 0 across all values of PTFactor,
ITFactor, and ISFactor. With this basic understanding of the data, we next consider
hypothesis testing.

\subsubsection{Hypothesis Testing}

Initially, we begin the analysis by determining if using the parametric ANOVA approach is
appropriate. We determined this by validating the fundamental assumptions of ANOVA. As noted
above, the two fundamental assumptions we are concerned with are normality and homogeneity
of variances assumptions.

\paragraph{Normality Assumption} Due to the nature of the data, all values for the change in
Reusability being zero, we were unable to evaluate this assumption.

\paragraph{Homogeneity of Variances Assumption} Due to the nature of the data, all values
for the change in Reusability being zero, we were unable to evaluate this assumption.

\paragraph{Permutation F-Test} The nature of the data collected suggests no measurable
effect on Reusability when any form of structural grime is injected. To evaluate this, we
conducted a permutation F-test with the null hypothesis that there is no difference in the
mean change in Reusability due to any combination of pattern type, injection type, and
injection severity. Unfortunately, the data did permit the evaluation of this.

\subsection{Technical Debt Principal}

This subsection describes the results of the Technical Debt Principal analysis. We
subdivided the analysis into a subsection describing the data and descriptive statistics,
and a subsection concerns hypothesis testing.

\subsubsection{Descriptive Statistics}

\begin{table}[!tb]
\centering
\caption{Summary of TD Principal data.}\label{tab:tdp_summary}
\begin{tabular}{l|llllll}
\hline
\textbf{Experiment} & \textbf{Min} & \textbf{1st Qu.} & \textbf{Median} & \textbf{Mean} & \textbf{3rd Qu.} & \textbf{Max} \\ \hline
%Analyzability       & -1.0382265   & -0.0133267       & -0.0038076      & -0.1226307    & -0.0009018       & 0.0          \\ \hline
%Testability         & -1.459066    & -0.021427        & -0.005952       & -0.248710     & -0.001323        & 0.0          \\
%Modifiability       & -1.36        & 0.0              & 0.0             & -0.01526      & 0.0              & 0.49121      \\
%Modularity          & -2.64236     & 0.0              & 0.0             & -0.6583       & 0.0              & 1.23418      \\
%Reusability         & 0.0          & 0.0              & 0.0             & 0.0           & 0.0              & 0.0          \\
TD Principal        & -0.9351      & 0.0              & 0.1002          & 0.3206        & 0.3937           & 12.7850      \\ \hline
%TD Interest         & -0.0072254   & 0.0              & 0.0006794       & 0.0025232     & 0.002888         & 0.0962732    \\ \hline
\end{tabular}
\end{table}

% Present the data using descriptive statistics

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/td_principal/table_plot.pdf}

 \caption{Table plot of TD Principal data.}\label{fig:tdp_tab_plot}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/td_principal/panels_plot.pdf}

 \caption{Scatterplot matrix of the dependent variable and independent variables for the TD Principal experiment.}\label{fig:tdp_panels}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/td_principal/histogram.pdf}

 \caption{Histogram and boxplot of the change in TD Principal.}\label{fig:tdp_hist}
\end{figure}

This section presents the results of the TD Principal experiment using descriptive
statistics and plots. First, we show the summary of the Change in TD Principal (the
dependent variable) in Table \ref{tab:tdp_summary}. This table shows the basic statistics
across the 4,992 observations. We note that for the Change in TD Principal, the max value
was 12.7850 man-months, and the min was -0.9351 man-months. Keeping these values in mind, we
begin to put this data into context when we consider it along with the three factors Pattern
Type, Injection Type, and Injection Severity, as depicted in the table plot in Figure
\ref{fig:tdp_tab_plot}. This plot shows several interesting pieces of information.

The first interesting information is that the control level of Injection Severity (ISFactor
= 0) is directly related to zero values for Change in TD Principal (TD.Principal). The
second interesting note is that the largest negative values of TD Principal appear to be
related to only a small subset of Injection Type levels. While the positive values appear
across all Injection Types. Furthermore, these results appear to cut across all the Pattern
Type and Injection Severity (excluding control level). The scatterplot matrix, presented in
Figure \ref{fig:tdp_panels}, further confirms these results. Additionally, we note the
distribution of TD Principal is heavily skewed to right as shown in both Figure
\ref{fig:tdp_panels} and Figure \ref{fig:tdp_hist}. With this basic understanding of the
data, we commence hypothesis testing.

\subsubsection{Hypothesis Testing}

Initially, we begin the analysis by determining if using the parametric ANOVA approach is
appropriate. We determined this by validating the fundamental assumptions of ANOVA. As noted
above, the two fundamental assumptions we are concerned with are the normality and
homogeneity of variances assumptions.

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/td_principal/aov_plot.pdf}

 \caption{TD Principal diagnostic plots.}\label{fig:tdp_aov}
\end{figure}

\paragraph{Normality Assumption} To evaluate this assumption, we plotted the ANOVA model, as
depicted in Figure \ref{fig:test_aov}. The pertinent plot here is the ``Normal Q-Q'' Plot in
the upper right quadrant. Here we see deviations from Normal in the tails of the data, which
is a strong indicator of a violation of the normality assumption. This evidence is further
confirmed using the Anderson-Darling normality test. The results of this test ($A = 534.18$,
$p < 2.2\mathrm{e}{-16}$) provides strong evidence to reject the null hypothesis and further
confirming the violation of the normality assumption.

\paragraph{Homogeneity of Variances Assumption} This assumption is evaluated using a similar
process as the Normality assumption. We again look to Figure \ref{fig:test_aov}, focusing on
the ``Residual vs. Fitted'' plot in the upper-left quadrant. This plot indicates that there
is a violation of the assumption. To analytically confirm this, we executed Levene's Test
for Homogeneity of Variance. The results ($F(2495, 2496) = 4.254\mathrm{e}{+26}$, $p <
2.2\mathrm{e}{-16}$) of this test provide strong evidence to reject the null hypothesis that
the variances are the same. These results further confirming this assumption has been
violated.

\paragraph{Permutation F-Test Analysis}

The assumption validation steps result in the conclusion that either we transform the data
or use a permutation F-test approach. After several attempts to transform the data, we opted
to move forward with the permutation F-test approach. The overall results ($F(2495,2496) =
6.226$, $p < 2.2\mathrm{e}{-16}$) of this test indicate strong evidence to reject the null
hypothesis that there is no difference in the mean change in TD Principal.

\paragraph{Interaction Effects}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/td_principal/cls_grime_interactions.pdf}

 \caption{TD Principal interaction plots for class grime injection.}\label{fig:tdp_cls_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/td_principal/mod_grime_interactions.pdf}

 \caption{TD Principal interaction plots for modular grime injection.}\label{fig:tdp_mod_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/td_principal/mod_org_grime_interactions.pdf}

 \caption{TD Principal interaction plots for modular organizational grime injection.}\label{fig:tdp_mod_org_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/td_principal/mod_org_grime_interactions2.pdf}

 \caption{TD Principal interaction plots for MTEUG.}\label{fig:tdp_mod_org_inter2}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/td_principal/pkg_org_grime_interactions.pdf}

 \caption{TD Principal interaction plots for PECG and PICG.}\label{fig:tdp_pkg_org_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/td_principal/pkg_org_grime_interactions2.pdf}

 \caption{TD Principal interaction plots for PERG and PIRG.}\label{fig:tdp_pkg_org_inter2}
\end{figure}

With the knowledge that a difference in the mean change in TD Principal exists between two
or more treatment combinations, we continue by determining if significant interactions must
be considered. In this case, there is strong evidence ($p < 2.2\mathrm{e}{-16}$) to reject
$H_{2,0}$ that there is no difference in the mean change in TD Principal for each level of
the three-way interaction effect. With this in mind, we consider a graphical analysis of
these interactions. We subdivided by grime class: Class Grime, Modular Grime, and
Organizational Grime to plot these interactions. Each grime category plot contains a matrix
of subplots (one per grime type in the category). For each plot, the y-axis is the change in
TD Principal, the x-axis is the design pattern type, and the points plotted are the values
for each injection severity. We will begin with the plots for Class Grime.

We begin with the interaction plots for Class Grime as depicted in Figure
\ref{fig:tdp_cls_inter}. This figure shows that although for each subtype of Class Grime,
all pattern types affect a positive change in TD Principal as the Injection Severity
increases, it appears that some pattern types have a greater impact than others. The
specific patterns which seem to have spikes in the Change in TD Principal across all grime
types appear to be Bridge, Decorator, Observer, Singleton, and Visitor. A final note for
Class Grime is that the level of change in TD Principal is minimal, ranging from 0.0 to
approximately 0.0155 man-months. We next look at the interactions associated with Modular
Grime subtypes.

Modular Grime subtype interactions are depicted in Figure \ref{fig:tdp_mod_inter}. This
figure shows similar information as was seen in the Class Grime interactions. Again we note
that for each grime type, across each pattern type, the are apparent positive effects on the
change in TD Principal for Injection Severity levels 1 - 5. We also note that there are
similar spikes for each type of grime for the Bridge, Decorator, Observer, Singleton, and
Visitor patterns. Additionally, the values of the level of Change in TD Principal associated
with Modular Grime types tend to be very small and ranges from 0.0 to approximately 0.01
man-months. We next discuss the interactions associated with Modular Organizational Grime
subtypes.

Figures \ref{fig:tdp_mod_org_inter} and \ref{fig:tdp_mod_org_inter2} depict Modular
Organizational Grime subtype interactions. Figure \ref{fig:tdp_mod_org_inter} can be further
decomposed into three groups. The first group shows the largest effects on TD Principal from
the MPICG, MPIUG, and MTICG types. The first group ranges from 0.0 to approximately 0.07
man-months. The second group, MPECG, MTECG, and MTIUG, show moderate changes in TD
Principal. The range of the change in TD Principal for this group is between 0.0 and
approximately 0.02 man-months. The third group composed of only MTEUG is the most
interesting in that it shows slight negative changes in TD Principal. Again, the key spikes
for each type of grime occur mainly in the Decorator, Observer, Singleton, and Visitor. The
range for this group is quite small and cannot necessarily be identified from Figure
\ref{fig:tdp_mod_org_inter}. Instead, we have plotted just the MTEUG interactions as shown
in Figure \ref{fig:tdp_mod_org_inter2}. In this figure, the negative spikes become visible
with Command, Decorator, Observer, Singleton, and Visitor showing the most distinct spikes,
including a positive spike for Visitor at Injection Severity level 4. We next discuss the
interactions associated with the Package Organizational Grime subtypes.

Finally, Package Organization Grime subtype interactions are depicted in Figures
\ref{fig:tdp_pkg_org_inter} and \ref{fig:tdp_pkg_org_inter2}. Figure
\ref{fig:tdp_pkg_org_inter} shows similar positive effects on the Change in TD Principal for
PECG and PICG subtypes. It is also noteworthy that for an Injection Severity level 1,
several Pattern Types indicate a negative effect on TD Principal for both PECG and PICG. On
the other hand, Figure \ref{tdp_pkg_org_inter2} shows that PERG and PIRG effects grow from
negative to positive as Injection Severity increases across pattern types. The most
interesting set of interactions is those of the PIRG subtype, which indicates that lower
values (1 - 3) of Injection Severity have a negative impact on TD Principal. Change in TD
Principle borders near or above zero as the Injection Severity levels increase beyond 3 for
each pattern type. Additionally, we see similar spikes across each subtype depicted at the
pattern types Bridge, Decorator, Observer, Singleton, and Visitor.

\subsection{Technical Debt Interest}

This subsection describes the results of the Technical Debt Interest analysis. We subdivided
the analysis into a subsection describing the data and descriptive statistics, and a
subsection concerns hypothesis testing.

\subsubsection{Descriptive Statistics}

\begin{table}[!tb]
\centering
\caption{Summary of TD Interest data.}\label{tab:tdi_summary}
\begin{tabular}{l|llllll}
\hline
\textbf{Experiment} & \textbf{Min} & \textbf{1st Qu.} & \textbf{Median} & \textbf{Mean} & \textbf{3rd Qu.} & \textbf{Max} \\ \hline
%Analyzability       & -1.0382265   & -0.0133267       & -0.0038076      & -0.1226307    & -0.0009018       & 0.0          \\ \hline
%Testability         & -1.459066    & -0.021427        & -0.005952       & -0.248710     & -0.001323        & 0.0          \\
%Modifiability       & -1.36        & 0.0              & 0.0             & -0.01526      & 0.0              & 0.49121      \\
%Modularity          & -2.64236     & 0.0              & 0.0             & -0.6583       & 0.0              & 1.23418      \\
%Reusability         & 0.0          & 0.0              & 0.0             & 0.0           & 0.0              & 0.0          \\
%TD Principal        & -0.9351      & 0.0              & 0.1002          & 0.3206        & 0.3937           & 12.7850      \\
TD Interest         & -0.0072254   & 0.0              & 0.0006794       & 0.0025232     & 0.002888         & 0.0962732    \\ \hline
\end{tabular}
\end{table}

% Present the data using descriptive statistics

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/td_interest/table_plot.pdf}

 \caption{Table plot of TD Interest data.}\label{fig:tdi_tab_plot}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/td_interest/panels_plot.pdf}

 \caption{Scatterplot matrix of the dependent variable and independent variables for the TD Interest experiment.}\label{fig:tdi_panels}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/td_interest/histogram.pdf}

 \caption{Histogram and boxplot of the change in TD Interest.}\label{fig:tdi_hist}
\end{figure}

This section presents the results of the TD Interest experiment using descriptive statistics
and plots. First, we show the summary of the Change in TD Interest (the dependent variable)
in Table \ref{tab:tdi_summary}. The table shows the basic statistics across the 7,488
observations. We note that for the Change in TD Interest the max value was 0.0962732
man-months and the min was -0.0072254 man-months. Keeping these values in mind, we begin to
put this data into context when we consider it along with the three factors Pattern Type,
Injection Type, and Injection Severity, as depicted in the table plot in Figure
\ref{fig:tdi_tab_plot}. This plot show several interesting pieces of information.

The first interesting piece of information is that the control level of Injection Severity
(ISFactor = 0) is directly related to zero values for Change in TD Interest (TD.Interest).
The second interesting note is the largest negative values of TD.Interest appear to be
related to only a small subset of Injection Type levels. While the positive values appear
across all Injection Types. Furthermore, these results appears to cut across all levels of
both the Pattern Type and Injection Severity (excluding control level). These results are
further confirmed in the scatterplot matrix presented in Figure \ref{fig:tdi_panels}, in the
lower triangle of the matrix. Additionally, we should note the distribution of TD.Interest
is heavily skewed to right as shown in both Figure \ref{fig:tdi_panels} and Figure
\ref{fig:tdi_hist}. With this basic understanding of the data we shift to hypothesis
testing.

\subsubsection{Hypothesis Testing}

Initially, we begin the analysis by determining if using the parametric ANOVA approach is
appropriate. This can be determined by evaluating if key assumptions of ANOVA have been met.
As noted above the two key assumptions we are concerned with are the normality and
homogeneity of variances assumptions.

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.95\textwidth]{analysis/experiments/td_interest/aov_plot.pdf}

 \caption{TD Interest diagnostic plots.}\label{fig:tdi_aov}
\end{figure}

\paragraph{Normality Assumption} To evaluate this assumption we plotted the ANOVA model, as
depicted in Figure \ref{fig:test_aov}. The pertinent plot here is the ``Normal Q-Q'' Plot in
the upper right quadrant. Here we see deviations from normal in the tails of the data which
is a strong indicator of a violation of the normality assumption. This evidence is further
confirmed using the Anderson-Darling normality test. The results of this test ($A = 964.57$,
$p < 2.2\mathrm{e}{-16}$) provides strong evidence to reject the null hypothesis and further
confirming the violation of the normality assumption.

\paragraph{Homogeneity of Variances Assumption} This assumption is evaluated using a similar
process as the Normality assumption. We again look to Figure \ref{fig:test_aov}, focusing on
the the ``Residual vs. Fitted'' plot in the upper-left quadrant. This plot indicates that
there is a violation of the assumption. To analytically confirm this we executed Levene's
test for Homogeneity of Variance. The results ($F(2495, 4992) = 1.369$, $p <
2.2\mathrm{e}{-16}$) of this test provide strong evidence to reject the null hypothesis that
the variances are the same. These results further confirming this assumption has been
violated.

\paragraph{Permutation F-Test Analysis}

The results of the assumption validation steps lead to the conclusion that either the
adjustments must be made via transformations or that a permutation F-test approach be used.
After several attempts to adjust for the violations we opted to conduct move forward with
the permutation F-test approach. The overall results of this test ($F(2495,4992) = 11.01$,
$p < 2.2\mathrm{e}{-16}$) indicate strong evidence to reject the null hypothesis that there
is no difference in the mean change in TD Interest.

\paragraph{Interaction Effects}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/td_interest/cls_grime_interactions.pdf}

 \caption{TD Interest interaction plots for class grime injection.}\label{fig:tdi_cls_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/td_interest/mod_grime_interactions.pdf}

 \caption{TD Interest interaction plots for modular grime injection.}\label{fig:tdi_mod_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/td_interest/mod_org_grime_interactions.pdf}

 \caption{TD Interest interaction plots for modular organizational grime injection.}\label{fig:tdi_mod_org_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/td_interest/mod_org_grime_interactions2.pdf}

 \caption{TD Interest interaction plot for MTEUG.}\label{fig:tdi_mod_org_inter2}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/td_interest/pkg_org_grime_interactions.pdf}

 \caption{TD Interest interaction plots for PECG and PICG.}\label{fig:tdi_pkg_org_inter}
\end{figure}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.9\textwidth]{analysis/experiments/td_interest/pkg_org_grime_interactions2.pdf}

 \caption{TD Interest interaction plots for PERG and PIRG.}\label{fig:tdi_pkg_org_inter2}
\end{figure}

With the knowledge that a difference in the mean change in TD Interest exists between two or
more treatment combinations, we continue by determining if there are significant
interactions which must be considered. In this case, there is strong evidence ($p <
2.2\mathrm{e}{-16}$) to reject $H_{2,0}$ that there is no difference in the mean change in
TD Interest for each level of the three-way interaction effect. With this in mind we will
consider a graphical analysis of these interactions. To plot these interactions, we
subdivided by grime class: Class Grime, Modular Grime, and Organizational Grime which was
further subdivided into Package Organizational Grime and Modular Organizational Grime. Each
grime category plot contains a matrix of subplots (one per grime type in the category). The
subplot matrix contains interaction plots where the y-axis is the change in TD Interest, the
x-axis is design pattern type, and the points plotted are the values for each injection
severity. We will begin with the plots for Class Grime.

We begin with the interaction plots for Class Grime as depicted in Figure
\ref{fig:tdi_cls_inter}. This figure shows that although for each subtype of Class Grime all
pattern types affect a positive change in TD Interest as the Injection Severity increases,
it appears that some pattern types have a greater impact than others. The specific patterns
which seem to have spikes in the Change in TD Interest across all grime types appears to be
Bridge, Decorator, Observer, Singleton, and Visitor. A final note for Class Grime is that
the level of change in TD Interest is very small ranging from 0.0 to approximately 0.0155
man-months. We next look at the interactions associated with Modular Grime subtypes.

Modular Grime subtype interactions are depicted in Figure \ref{fig:tdi_mod_inter}. This
figure shows similar information as was seen in the Class Grime interactions. Again we note
that for each grime type, across each pattern type the are apparent positive effects on the
change in TD Interest for Injection Severity levels 1 - 5. We also note that there are
similar spikes for each type of grime for the Bridge, Decorator, Observer, Singleton, and
Visitor patterns. Additionally, the values of level of change in TD Interest associated with
Modular Grime types tends to be very small and ranges from 0.0 to approximately 0.01
man-months. We next discuss the interactions associated with Modular Organizational Grime
subtypes.

Modular Organizational Grime subtype interactions are depicted in Figures
\ref{fig:tdi_mod_org_inter} and \ref{fig:tdi_mod_org_inter2}. This figure can be further
decomposed into two groups. The first group shows the largest effects on TD Interest from
the MPICG, MPIUG, and MTICG types. The first group ranges from 0.0 to approximately 0.07
man-months. The second group, MPECG, MTECG, and MTIUG show moderate changes in TD Interest.
The range of the change in TD Interest for this group is between 0.0 and approximately 0.02
man-months. We have plotted just the MTEUG interactions as shown in Figure
\ref{fig:tdi_mod_org_inter2}. This figure shows slight negative changes in TD Interest.
Again, the key spikes for each type of grime occur mainly in the Command, Decorator,
Observer, Singleton, and Visitor showing the most distinct spikes including a positive spike
for Visitor at Injection Severity level 4. We next discuss the interactions associated with
the Package Organizational Grime subtypes.

Finally, Package Organization Grime subtype interactions are depicted in Figures
\ref{fig:tdi_pkg_org_inter} and \ref{fig:tdi_pkg_org_inter2}. Figure
\ref{fig:tdi_pkg_org_inter} shows similar positive effects on the Change in TD Interest for
PECG and PICG subtypes. It is also noteworthy, that for an Injection Severity level 1
several Pattern Types indicate a negative effect on TD Interest for both PECG and PICG. On
the other hand Figure \ref{fig:tdi_pkg_org_inter2} shows that PERG and PIRG effects grow from
negative to positive as Injection Severity increases across pattern types. The most
interesting set of interactions is those of the PIRG subtype which indicates that lower
values (1 - 3) of Injection Severity have a negative impact on TD Interest, but as the
levels increase beyond 3 for each pattern type they tend to border near or above zero.
Additionally across each subtype depicted, we see similar spikes at the pattern types
Bridge, Decorator, Observer, Singleton, and Visitor.

\section{Interpretation}\label{sec:gq_interp}

\subsection{Evaluation of Results and Implications}

\subsubsection*{RQ2.1 How does each type of grime affect design pattern quality for each of
the selected maintainability sub-characteristics?}

We found that across all grime types we note that Grime has an negative effect on
Analyzability. Additionally, we found that across all pattern types and all grime types the
injection of grime will negatively impact the testability of a pattern instance. This
provides further support for the implications to testability first identified by Izurieta
and Bieman \cite{izurieta_testing_2008,izurieta_multiple_2012}. We do note with the
exception of MPECG, MPICG, MPIUG, MTECG, MTICG, MTIUG, and PERG types size of the effect
grime has on Testability is greatly dependent on the pattern type. Of note here are the
patterns Bridge, Decorator, Observer, Singleton, and Visitor as their Testability appears to
be affected more by grime than that of other pattern types. Furthermore, Grime affects
Modifiability both negatively and positively, but is dependent on a pattern instance's type.
Pattern instances of Decorator, Prototype, and Visitor will have their Modifiability
positively impacted by all forms of grime except PEAG, TEAG, MPICG, MTICG, and PIRG. Of
these, MPICG and MTICG will negatively impact these same pattern types, but the PEAG, TEAG
and PIRG negatively impact the Modifiability of all pattern types. Additionally, we have
found that Modularity is affected by all forms of grime. This impact on Modularity may be
positive or negative, depending on the type of grime, pattern type, and injection severity.
Finally, grime type appears to have no impact on Reusability.

\subsubsection*{RQ2.2 What level of injection severity affects a change in design pattern
quality for each of the maintainability sub-characteristics?}

Across all grime types and pattern types, we noted for all levels wherein grime was
injected, there was a negative change in Analyzability. The only exception to this was for
PECG and the Prototype Pattern Type, in which at an Injection Severity level of 1 the mean
change in Analyzability was 0. Similarly, across all grime types and pattern types, we noted
that for all levels wherein grime was injected, there was negative change in Testability.
Modifiability, on the other hand, is not affected for all patterns and all types of grime
and at all levels of severity, rather may be positively or negatively affected for specific
pattern types (see RQ2.3 below) and when the Injection Severity level is 3 or more. The
effects of grime on Modularity, in general, occur at all levels of injection severity. When
considering Class Grime often the positive effects depend upon the level of injection
severity and their does appear to be any specific relationship between Injection Severity
and effect on Modularity. When considering the negative effects from grime on Modularity,
these occur across all patterns and, in general, at all levels of injection severity.
Finally, grime severity appears to have no affect on Reusability.

\subsubsection*{RQ2.3 What is the difference between the effects of the grime types and
their subtypes on maintainability sub-characteristics?}

The effect of grime on Analyzability differs in magnitude depending on which grime category
is being looked at. Of the three grime categories (class, modular, and organizational) the
greatest impact on Analyzability stems from the Organizational Grime category. In
comparison, the effects of class and modular grime are quite small. Yet, when evaluating
these forms of grime, it becomes apparent that pattern type must be taken into account as
Pattern types such Bridge, Decorator, Observer, Singleton, and Visitor tend to be affected
more than others.

The effect of grime on Testability differs in magnitude depending on which grime category is
being looked at. Of the three grime categories (class, modular, and organizational) the
greatest impact on Analyzability stems from the Organizational Grime category. In
comparison, the effects of class and modular grime are quite small. Yet, when evaluating
these forms of grime, it becomes apparent that pattern type must be taken into account as
Pattern types such Bridge, Decorator, Observer, Singleton, and Visitor tend to be affected
more than others.

The key differences between grime types and their subtypes when considering the affect on
Modifiability does not lie between the categories of grime, but rather within. That said,
There is one stark difference is that the negatively affecting Grime Types PEAG, TEAG,
MPICG, and MTICG and all others in that they have the largest magnitude of change.
Additionally PEAG and TEAG and affect all pattern types rather than a small handful. The
remaining grime types are relatively indistinguishable in that they affect Modifiability
positively with nearly the same level of impact and only for the few pattern types noted
above.

The key differences between how grime types and their subtypes affect maintainability is
sharply divided between Organizational Grime types and those found in Class and Modular
Grime (excluding PEAG and TEAG). Class and Modular grime (excluding PEAG and TEAG) affect
modularity in a small but positive way. On the other hand the PEAG and TEAG forms of Modular
Grime along with the Modular Organizational Grime subtypes have a significantly negative
effect modularity. Of these Both MTICG and MPICG are the most pronounced. On the other hand,
MTEUG and the Package Organizational Grime subtypes have significantly positive effect on
modularity.

Overall, grime severity appears to have no affect on Reusability.

\subsection*{RQ2: Summary}
In summary, design pattern grime can be a concern for overall maintainability of a design
pattern instance, but may also be a boon depending on a developer's/teams specific concerns.
With the exception of Reusability, the level of concern developers or teams should have will
be dependent on the type of pattern affected, the type grime it is afflicted with, and the
amount of grime present. We do know that in general as severity increases the effects that
grime has (either positive or negative) will increase in magnitude. We also know that grime
does not affect the Reusability of a pattern instance.

\subsubsection*{RQ3.1 How does each type of grime affect design pattern technical debt
principal and interest?}

The impact of all grime categories on TD Principle and TD Interest are very similar. All
grime subtypes excluding MTEUG, PECG and PICG appear to affect a positive change in TD
Principal across all pattern types which increases as the amount of injected grime
increases. These results are in line with the work from Dale and
Izurieta\cite{dale_impacts_2014} which showed similar results for Modular Grime. The
remaining three subtypes are much more interesting, specifically MTEUG. MTEUG apparently
negatively impacts TD Principal and Interest, suggesting that it reduces technical debt
across all pattern types and for all injection severity levels. This finding will require
further investigation.

\subsubsection*{RQ3.2 What level of grime severity affects a change in design pattern
technical debt principal and interest?}

As noted above in RQ3.1 all severity levels affect technical, and with the exception of the
MTEUG subtype, they affect a positive change in TD Principal and Interest. Additionally,
similar to the results of Dale and Izurieta\cite{dale_impacts_2014} for all grime subtypes
as the injection severity increases the change in TD Principal and Interest also increases
in magnitude (either positively or negatively).

\subsubsection*{RQ3.3 What is the difference between the effects of the grime types and their subtypes on technical debt principal and interest?}

The key difference in the effects of grime on TD Principal and Interest between can be
separated into two groups. The first group contains the subtypes for Class and Modular
grime. In this group there is relatively little difference between the effects on either TD
Principal or Interest across grime types. Rather, the primary difference is in the effects
of pattern type and injection severity. The key pattern types of concern here Decorator,
Observer, Singleton, and Visitor, in which the effect on TD Principal and Interest is
markedly higher than for other patterns affected by the same type of grime. The second group
are the Organizational Grime subtypes, in which they follow a similar trend as that of the
first group (with the exception of MTEUG), but the magnitude of the effects tends to be much
higher. Lastly, there is MTEUG, which has small effects on TD Principal and Interest but
these effects are negative rather than positive. Additionally, MTEUG also spikes on Command
rather than the Bridge pattern and also on the Template Method pattern.

\subsection*{RQ3: Summary}
In summary, design pattern grime is something of serious concern for technical debt
management. Grime will increase a pattern instance's TD Principal and Interest. Developers should keep
this in mind especially when working with pattern instances of type Bridge, Decorator,
Observer, Singleton, or Visitor. On caveat to this is that MTEUG does reduce both the TD Principal and Interest
of a pattern instance regardless of the pattern type. Thus, if this form of grime manifests
within a pattern instance already afflicted by other forms of grime, it may mask the true issues at hand.
These issues are of specific concern as it has been shown in prior work that grime will continue to build up unless
remediated \cite{izurieta_multiple_2012,schanz_object_2010,feitosa_evolution_2017}.

\subsection{Limitations of the Study} This section describes the limitations and threats to
the validity of this study. Specifically, we focus on threats to conclusion, internal,
construct, content, and external validity, in accordance with the framework proposed by
Campbell and Cook \cite{campbell_quasi-experimentation:_1979}, Campbell and Stanley
\cite{campbell_experimental_1963}, and Wohlin \etal \cite{wohlin_experimentation_2012}.

\subsubsection{Conclusion Validity} Conclusion validity is concerned with establishing
statistical significance between the independent and dependent variables. In order to ensure
that there are no threats to conclusion validity, we took the following measures. For each
statistical test used, we verified that the assumptions were met. Thus, there are no threats
to the conclusion validity of this study.

\subsubsection{Internal Validity} Internal validity is concerned with the relationship
between the treatments and the outcomes and whether this relationship is causal or other
factors. In this experiment, there is no threat to internal validity due to the experiments
being fully controlled.

\subsubsection{Construct Validity} Construct validity is concerned with the meaningfulness
of measurements and the quality choices made about independent and dependent variables such
that these variables are representative of the underlying theory. In this experiment, we
used a Java\texttrademark\ specific calibration of the ISO/IEC 25010 quality model
maintainability sub-characteristics via our implementation of the SIG Maintainability
measurement method. Using this approach, we adequately measure the quality characteristics
of concern within the scope of the tools provided. Thus, there are no threats to construct
validity.

\subsubsection{Content Validity} Content validity is concerned with how well the selected
measures cover the content domain. In this experiment, we measure software maintainability
using an implementation of the SIG Maintainability Model. This model was calibrated for the
Java\texttrademark\ language using open source projects from the Qualitas
Corpus\cite{tempero_qualitas_2010}. This model adequately covers the five maintainability
sub-characteristics of concern. Furthermore, the metrics IT, IS, and PT are well defined and
cover the content domain within the underlying tools' limitations. The PT metric only covers
16 of the 23 GoF design patterns, as this is the limit of the Pattern4 design pattern
detection tool, which poses a threat to this study's content validity.

\subsubsection{External Validity} External validity is concerned with the ability to
generalize the results of a study. We conducted the experiment using generated instances of
Java\texttrademark\ pattern implementations. As we did not generate the studied instances
within existing software systems, nor are they instances extracted from existing software
systems, we cannot directly generalize to either open source or industry software, which is
a threat. Furthermore, the use of only Java\texttrademark\ limits our ability to generalize
to Java\texttrademark\ instances of design patterns, which is another threat.

\subsection{Inferences}

Since each experiment was a randomized experiment, one may infer the difference in the
change in Analyzability, Testability, Modifiability, Modularity, TD Principal, and TD
Interest was caused by the difference in Injection Type, Injection Severity, and Pattern
Type. Because the subjects were generated randomly based on Java\texttrademark\ design
pattern templates designed to mimic the structure of design patterns found in professional
grade software there is a case that these results can be extended to pattern instances found
in professional-grade Java\texttrademark\ software. This is a minor issue, and the strength of
these results stands even if it only applies to generated pattern instances.

\section{Conclusion and Future Work}\label{sec:gq_conclude}

In this study we conduct seven experiments to understand the relationships effects of design
pattern grime on software maintainability and technical debt. Each experiment was conducted
as a full-factorial design using the software injection process to inject each of the 26
design pattern grime types at 6 severity levels into 16 generated pattern types. The results
showed that indeed design pattern grime has significant effects on both software
maintainability sub-characteristics as well as technical debt interest and principal, but
this effect is dependent upon the grime type, pattern type, and level of severity.

Our results have provided support for some of our initial hypotheses identified in Section
\ref{chap:intro}.\ref{sec:intro_motiv}. Furthermore, these results have provided
confirmation of prior works from Izurieta and
Bieman\cite{izurieta_testing_2008,izurieta_multiple_2012} as well as Dale and
Izurieta\cite{dale_impacts_2014}. Yet, the underlying experimental conditions leave us
without the ability to know if these results apply within actual software systems.

Future work will consist of conducting case studies to further study grime in actual
software systems and design pattern instances to further explore these results.
Additionally, we need return to these experiments and focus on the interesting issues that
we have identified. Specifically, further explorations of the relationships between the MTIUG
type and TD Principal and Interest.
