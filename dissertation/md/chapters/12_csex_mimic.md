\chapter{Verification Study}\label{chap:cs_ex_validation}

\section{Introduction}\label{sec:csex_intro}
Prior studies involving design pattern grime injection including those referenced
in Chapters \ref{chap:ex_grime_and_quality} and \ref{chap:ex_grime_and_td} and
those found in the literature \cite{dale_impacts_2014-1,griffith_design_2014}
are limited by the grime accumulation process. It is linked to the simulation of
grime injection. Though necessary to conduct the experiments, we also need a
method by which the injection process can be directly compared to reality to
verify its results.

As described in Chapter \ref{chap:method}, we have developed an approach to
resolve this limitation via, what we term, ``Verification Studies.'' In this
chapter we detail a Verification Study that serves two distinct functions.
The first is to build upon the injection studies by validating that the results
found in the previous experiments hold within real software systems when grime
is present using a direct comparison method. The second is to verify that the
results of injected grime match the results of actual instances of that grime.
The goal of this study was stated in Chapter \ref{chap:intro}, and for the
reader's convenience we restate it here:

\begin{enumerate}[leftmargin=2.0cm,label=\bfseries RG\arabic*:,start=4]
  \item Analyze design pattern instances for the purpose of comparing injected
  and observed instances of grime with respect to their ISO/IEC 25010 quality
  attributes and technical debt principal from the perspective of researchers in
  the context of open source Java\texttrademark\ software projects.
\end{enumerate}

\noindent Following the GQM process this goal then leads to our main question of
interest and its corresponding rationale:

\begin{enumerate}[leftmargin=2.0cm,label=\bfseries RQ\arabic*:,start=4]
  \item Do observed and injected grime have a similar effect on quality and
  technical debt principal?\\
  \textbf{Rationale:} Evaluate the assertion that the process of grime injection
  reflects the same effect on quality and technical debt principal as the
  natural process of grime accumulation.
\end{enumerate}

% Clean up
With this question in mind, this chapter is organized as follows. Section
\ref{sec:csex_design} describes the design of this study. Section
\ref{sec:csex_select} describes the selection criteria for each case selected
as a part of this study. Section \ref{sec:csex_data}, defines the data
collection procedures for this study. Section \ref{sec:csex_ap} defines the
analysis procedures for this study. Section \ref{sec:csex_results} describes
the results and their analysis for this study. Section \ref{sec:csex_threats}
describes the threats to the validity and other limitations of this study.
Finally, Section \ref{sec:csex_conclusions} provides a summary and concluding
remarks for this study.

\section{Design}\label{sec:csex_design}
We have elected to use a multiple case study approach. In this approach, the
cases under study are individual pattern chains meeting a defined selection
criteria. The context for each of these cases are the containing systems for
each of the selected pattern instances. This links directly to \textbf{RG4}
reiterated in section \ref{sec:csex_intro} and further connects to the main
question as we compare the effects of both injected and observed grime in each
case. In the spirit of the GQM, we have further refined the main question into a
series of directly answerable questions, their guiding rationale, and a set of
metrics defined to facilitate answering these questions. The questions and
metrics are as follows:

\begin{enumerate}[leftmargin=2.5cm,label=\bfseries RQ4.\arabic*:]
  \item Does grime injection have a similar effect on \textit{functional
  suitability} as the observed effect of grime on \textit{functional
  suitability}?\\
  \textbf{Rationale:} Evaluate the assertion that the process of grime injection
  reflects the same effect on \textit{functional suitability} as the natural
  process of grime accumulation.
  \item Does grime injection have a similar effect on \textit{maintainability}
  as the observed effect of grime on \textit{maintainability}?\\
  \textbf{Rationale:} Evaluate the assertion that the process of grime injection
  reflects the same effect on \textit{maintainability} as the natural process of
  grime accumulation.
  \item Does grime injection have a similar effect on \textit{performance
  efficiency} as the observed effect of grime on \textit{performance
  efficiency}?\\
  \textbf{Rationale:} Evaluate the assertion that the process of grime injection
  reflects the same effect on \textit{performance efficiency} as the natural
  process of grime accumulation.
  \item Does grime injection have a similar effect on \textit{reliability} as
  the observed effect of grime on \textit{reliability}?\\
  \textbf{Rationale:} Evaluate the assertion that the process of grime injection
  reflects the same effect on \textit{reliability} as the natural process of
  grime accumulation.
  \item Does grime injection have a similar effect on \textit{security} as the
  observed effect of grime on \textit{security}?\\
  \textbf{Rationale:} Evaluate the assertion that the process of grime injection
  reflects the same effect on \textit{security} as the natural process of grime
  accumulation.
  \item Does grime injection have a similar effect on \textit{technical debt
  principal} as the observed effect of grime on \textit{technical debt
  principal}?\\
  \textbf{Rationale:} Evaluate the assertion that the process of grime injection
  reflects the same effect on \textit{technical debt principal} as the natural
  process of grime accumulation.
\end{enumerate}

\begin{enumerate}[leftmargin=2.5cm,label=\bfseries M4.\arabic*:]
  \item \textit{Analyzability} -- as defined in Section
  \label{sec:gq_refined_gqm}.
  \item \textit{Testability} -- as defined in Section
  \label{sec:gq_refined_gqm}.
  \item \textit{Modifiability} -- as defined in Section
  \label{sec:gq_refined_gqm}.
  \item \textit{Modularity} -- as defined in Section
  \label{sec:gq_refined_gqm}.
  \item \textit{Reusability} -- as defined in Section
  \label{sec:gq_refined_gqm}.
  \item \textit{Technical Debt Principal} -- as defined in Section
  \ref{sec:gtd_refined_gqm}.
  \item \textit{Technical Debt Interest} -- as defined in Section
  \ref{sec:gtd_refined_gqm}.
\end{enumerate}

\section{Selection}\label{sec:csex_select}
The following criteria define the contexts and set of cases to be studied.
Accompanying each criterion is its underlying rationale. The criteria is as
follows:
\begin{itemize}
  \item For a System to be considered a context from which cases will be
  selected, it must have at least two Pattern Chains to ensure capability of
  random selection.\\
  \textbf{Rationale:} We must be able to select from a set of chains, having
  only one chain does not provide a choice.
  \item For a PatternInstance to be considered a viable case, there must be a
  change in grime accumulation between itself and its following versions.\\
  \textbf{Rationale:} For the comparison method described in the following
  section to be used, we must first observe that a change in grime has occurred.
\end{itemize}

\section{Data Collection}\label{sec:csex_data}

\begin{table}[!tb]
\centering
\caption{Example data table.}
\label{tab:csex_ex}
\begin{tabular}{c|cccccc}
\multicolumn{1}{c}{\textbf{ID}} & $\Delta QA_{1}$ & $\Delta QA_{2}$ & $\Delta QA_{3}$ & $\Delta QA_{4}$ & $\Delta QA_{5}$ & $\Delta TD$\tabularnewline
\hline 
0 & 0.01 & 0.2 & -0.2 & 0.0 & -0.25 & 1.0\tabularnewline
$\vdots$ & $\vdots$ & $\vdots$ & $\vdots$ & $\vdots$ & $\vdots$ & $\vdots$\tabularnewline
\end{tabular}
\end{table}

The following describes the data to be collected, the data collection process,
and how this data is to be stored. For each instance under study, we extract the
instance identifier, quality attribute values, and technical debt principal
value from the PatternInstance and Measures tables of the ArcDb. This data is
then accumulated into a table, similar to the example shown in Table
\ref{tab:csex_ex}, with the following specifications:

\begin{itemize}
  \item Each row of the table represents the change between the observed
  changes in versions and the changes due to injection for a pattern instance.
  \item The first column of the table is the pattern instance identifier
  representing a specific pattern instance.
  \item The second through sixth columns of the table represent the difference
  in quality attribute values.
  \item The seventh column of the table represents the difference in technical
  debt principal values.
\end{itemize}

\begin{figure}[!tb]
  \centering
  \includegraphics[width=0.75\textwidth]{experimental_process/grimebuild_cs_dc}
  \caption{Data collection process.}
  \label{fig:csex_cs_dc}
\end{figure}

% Clean up
An overview of the data collection process is depicted in Figure
\ref{fig:csex_cs_dc}. This process follows the path indicated by the numbers
encircled in green, as follows: 1.) The data for analysis is stored, via
previously defined workflows, in the GH-OSS-J (GitHub extracted Open Source
Java\texttrademark\ Systems) instance of the Arc Database. 2.) Using the
criteria specified in Section \ref{sec:csex_select} the selected set of matching
\textit{PatternInstance}(s) are extracted from the ArcDb. For each
PatternInstance the appropriate Grime Findings, quality and technical debt
measures are extracted from the Findings and Measures tables, respectively. 3.)
The \textit{DataModelMediator} facilitates this extraction and provides the data
to the \textit{ReportGenerator}. 4.) The \textit{ReportGenerator} uses this
data to construct a data table. 5.) The \textit{ReportGenerator} outputs this
data table to a CSV file for use in analysis. 6.) Finally, the R statistical
system is used to analyze the results provided from the CSV file, using the
provided R script. The details of this analysis are described next.

% Clean up
\subsection*{Data Collection Workflows} The data collection process begins, as
depicted in Figure \ref{fig:csex_cs_dc}, with the execution of an Arc
workflow. The workflow utilized for this study is shown in Figure
\ref{fig:csex_wf}. Initially, there is a 'Construct Systems' phase which
uses the GitHubSearch tool to find and collect System and Project meta-data and
add these entities to the Arc data model. Next, for each System and each
System's project, the project repository is cloned and switched to the
appropriate tag/branch. After cloning, the system is analyzed to identify any
Java\texttrademark\ artifacts. After the artifact data is collected, the project
is parsed and the source code entities are extracted and added to the data
model. Finally, at the end of the 'prelim' phase the project is compiled.

\begin{figure}[!b]
  \singlespacing
  \begin{lstlisting}[language=flow]
							workflow 'Verification Study' {
							    phase 'Construct Systems' {
							        GHSearch()
							    }
							    mediator.getSystems().each { System s ->
							        mediator.getProjects().each { Project p ->
								    	phase 'prelim' {
								    		Git(p)
								    		JavaAI(p)
								    		JavaComponents(p)
								    		Build(p)
								    	}
								    	phase 'primary analysis' {
								    		Metrics(p)
								    		PMD(p)
								    		FindBugs(p)
								    	}
								    	phase 'secondary analysis' {
								    		Pattern4(p)
								    		GrimeDetect(p)
								    	}
							    	}
							    }
							    phase 'Study' {
							    	pairs = GrimeBuild.select()
							    	table = GrimeBuild.data(insts)
							    	CSVReport.package(table)
							    }
						    }
  \end{lstlisting}
  \caption{Grime verification study data collection workflow.}
  \label{fig:csex_wf}
\end{figure}

% Clean up
In the 'primary analysis' phase data concerning software metrics and basic
static analysis issues are collected using the Metrics, PMD, and FindBugs tools.
Once the 'primary analysis' phase is concluded, the 'secondary analysis' phase
begins. Here, the Pattern4 tool used to collect pattern information is executed,
this provides the pattern instances existing in the software, and creates
pattern chains. Finally, at the end of the analysis, the GrimeDetector is
executed on the project, if it contributed to adding new information to any
PatternChains. In the last Phase, 'Study', the GrimeBuild tool randomly selects
the PatternChains which meet the study criteria. Using these chains the
GrimeBuild tool, via the DataModelMediator, then extracts the necessary
information and constructs a data table in memory. Lastly, the collected data is
packaged into CSV format for analysis.

\section{Analysis Procedure}\label{sec:csex_ap}
The following analysis procedures are used in answering the questions posed in
Section \ref{sec:csex_design}. The collected data represents the differences
between the injected grime and observed grime effects on software quality attributes and
technical debt principal. To answer research questions
\textbf{RQ4.1}--\textbf{RQ4.6} we need a method to compare these results. We
expect that if the injected grime effects present a true representation of the
behavior of grime, then the difference between the injected and observed should
be close to 0.0. Thus, for any one of the measures of concern we could
reasonably expect to utilize a two-tailed one-valued t-test to evaluate the mean
results. Yet, because we are looking at multiple results
per item in the dataset, we need to utilize a method which provides correction
for multiple comparisons.

To accommodate this correction, we have selected to use Dunnett's multiple
comparison method \cite{dunnett_multiple_1955}. This approach compares a set of treatments
against a control, while correcting the resulting p-values to account to multiple
comparisons. In this case the control, is simply a vector of zeroes (the
expected value). This method will be used to evaluate the following statistical
hypotheses:

\begin{eqnarray}
\notag H_{1,0}:\,\, \mu_{QA_i} & = & 0\\
\notag H_{1,1}:\,\, \mu_{QA_i} & \ne & 0\\
\notag \\
\notag H_{2,0}:\,\, \mu_{TD} & = & 0\\
\notag H_{2,1}:\,\, \mu_{TD} & \ne & 0
\end{eqnarray}

\noindent Where $\mu_{QA_i}$ is the mean of ith quality attribute and $\mu_{TD}$
is the mean of the technical debt principal. Thus $H_{1,0}$ and ${H_{1,1}}$ will be
evaluated for the five quality attributes of concern: (i) functional
suitability, (ii) maintainability, (iii) performance efficiency, (iv)
reliability, and (v) security. A rejection of either $H_{1,0}$ or $H_{2,0}$
indicates a negative result (when considered in the context of the results of
the experiments from Chapters \ref{chap:ex_grime_and_quality} and
\ref{chap:ex_grime_and_td}) and that there is an issue with either the
definition of the injection strategies or with the fundamental definitions of
grime themselves, either case warrants further investigation.

Dunnett's approach utilizes an underlying t-test and thus has the same basic
assumptions. Specifically, this test assumes that the means of the values are
independent and are normally distributed with a common variance and means. In
the event that these assumptions cannot reasonably be met we will instead
utilize a similar non-parametric method, Steele's test
\cite{steel_multiple_1959-1} which is a rank-sum based approach.

\section{Results and Discussion}\label{sec:csex_results}

\section{Threats to Validity}\label{sec:csex_threats}
This section describes the limitations and threats to the validity of this
study. Specifically, we focus on threats to conclusion validity, internal
validity, construct validity, content validity, external validity, and
reliability in accordance with the framework proposed by Campbell and Cook
\cite{campbell_quasi-experimentation:_1979}, Campbell and Stanley
\cite{campbell_experimental_1963}, and Wohlin et al.
\cite{wohlin_experimentation_2012} for experimentation and the insights of Yin
\cite{yin_case_2009} and Runeson et al. \cite{runeson_case_2012} concerning case
studies.

\subsection*{Internal Validity}
This validity check is concerned with the ability to show a causal relationship
between outcomes and treatments. The prior studies showed the causal
relationship between grime and quality and technical debt, via the injection
process. In this study we validated this relationship with evidence that the
nature of the injection process matches that of observed occurrences of grime
in open source systems. Thus, there are no threats to internal validity.

\subsection*{Construct Validity} This validity check is concerned with the use
of correct operational measures for the concepts being studied. We utilized
detection techniques based directly on the definitions of each form of grime
presented in Chapter \ref{chap:taxonomies} and by Schanz and Izurieta
\cite{schanz_object_2010}. Furthermore, operationalized measures for the main
characteristics of quality from the ISO/IEC 25010 specification as
operationalized by our implementation of the Quamoco method. We also selected
the CAST approach to measuring technical debt principal. As each of these
measures are designed to measure exactly what was intended, we have no threats
to the construct validity of this study.

\subsection*{Content Validity} Content validity is concerned with how well the
selected measures cover the content domain. The selected measure evaluates
simple relationships between design pattern grime types. In this experiment
using the CAST method for calculating technical debt principal. The technical
debt literature further defines \textit{technical debt interest} and
\textit{interest probability} as measures to understand the future impact of the
imposed debt \cite{}. Not including these measures imposes an additional threat
to content validity.

\subsection*{External Validity} This validity check is concerned with the
ability to generalize the results of a study. This study was conducted across
multiple software systems and included multiple types of design patterns.
Unfortunately, as the study considered only open source software systems
implemented in Java\texttrademark , we are unable to extend our results beyond
open source Java software systems which poses a threat to the external validity
of this study.

\subsection*{Reliability} Reliability is concerned with the dependence between
specific researchers and the data and analysis. In this case study we utilized
the Arc Framework to gather quantitative data in an automated fashion. Thus, the
data collected is not reliant on any researcher nor are the values collected
left to interpretation. Furthermore the analysis conducted utilized scripts
written for the R statistical processing software. The version of R used and the
scripts used will be made available to all researchers. Hence, there should be
no threats to the reliability of the studies.

\section{Conclusion}\label{sec:csex_conclusions}
