\chapter{The Evolution of Grime}\label{chap:cs_grime_buildup}

\section{Introduction}\label{sec:csgb_intro}
To date, there is very little known regarding how design pattern grime evolves
in relation to the evolution of containing design patterns. This is in part due
to a lack of understanding the fundamental nature of design pattern grime.
Without understanding the nature of grime accumulation within design patterns as
the containing system evolves, we cannot evaluate the utility of detecting grime
nor the effect that grime has on quality or technical debt. The overall benefit
of this work is to both practitioners and researchers by providing knowledge of
the forms of grime that will likely infect different pattern types/families as
well as how grime changes over time if unmitigated.
The goal of this study was stated in Chapter \ref{chap:intro}, for the reader's
convenience we restate it here:

\begin{enumerate}[leftmargin=2.0cm,label=\bfseries RG\arabic*:,start=6]
  \item Analyze pattern chains for the purpose of understanding design pattern
  grime evolution with respect to grime accumulation from the perspective of
  researchers, in the context of open source Java\texttrademark\ software
  systems.
\end{enumerate}

\noindent Following the GQM process this goal then leads to our main question of
interest and its corresponding rationale:
\begin{enumerate}[leftmargin=2.0cm,label=\bfseries RQ\arabic*:,start=6]
  \item How does design pattern grime change over time?\\
  \textbf{Rationale:} To evaluate the assertion that the amount of grime in a
  pattern will continue to grow, if left unchecked.
\end{enumerate}

With this question in mind, this chapter is organized as follows.
Section \ref{sec:buildup_design} describes the design of this study.
Section \ref{sec:buildup_select} describes the selection criteria for each case
as a part of this study. Section \ref{sec:buildup_data}, defines the data
collection procedures for this study. Section \ref{sec:buildup_ap} defines the
analysis procedures for this study. Section \ref{sec:buildup_results} describes
the results and their analysis for this study. Section \ref{sec:buildup_threats}
describes the threats to the validity and other limitations of this study.
Finally, Section \ref{sec:buildup_conclusions} provides a summary and concluding
remarks for this study.

\section{Design} \label{sec:buildup_design}
We have elected to use a multiple case study approach. In this approach, the
cases under study are individual pattern chains meeting a defined selection
criteria. The context for each of these cases are the containing systems for
each of the selected pattern chains. This links directly to \textbf{RG6}
reiterated in section \ref{sec:csgb_intro} and further connects to the main
question as we will be tracking the grime changes across the instances in each
case.

In the spirit of the GQM, we have further refined the main question into a
series of directly answerable questions, their rationale, and set of metrics
defined to facilitate answering these questions. The questions and metrics are
as follows:

\begin{enumerate}[leftmargin=2.5cm,label=\bfseries RQ6.\arabic*:]
  \item Which type of grime (\textit{class}, \textit{modular}, or
  \textit{organizational}) is more likely to occur as a pattern instance
  evolves?\\
  \textbf{Rationale:} To evaluate the assertion that no one type of grime is
  more prevalent than another.
  \item Is there a relationship between grime accumulation and pattern instance
  evolution?\\
  \textbf{Rationale:} To evaluate the assertion that as a pattern instance
  changes the level of grime changes as well.
  \item Which pattern types (as identifiable via design pattern detection) are
  more susceptible to grime accumulation?\\
  \textbf{Rationale:} To evaluate the assertion that there is no relationship
  between the accumulation of grime and a pattern instance's pattern type.
  \item Which pattern families (groups of patterns based on common functionality
  or structure: i.e., the 23 patterns defined in Gamma \etal
  \cite{gamma_design_1994} are divided into three groups:
  \textit{Creational Patterns}, \textit{Structural Patterns}, and
  \textit{Behavioral Patterns}) are more susceptible to grime accumulation?\\
  \textbf{Rationale:} To evaluate the assertion that there is no relationship
  between the accumulation of grime and a pattern instance's pattern family.
\end{enumerate}

\begin{enumerate}[leftmargin=2.5cm,label=\bfseries M6.\arabic*:]
  \item \textit{Grime Size} (GSZ) -- A count of the instances of all types of
  grime as detected across all components of a pattern instance. This metric
  utilizes the detection strategies defined in Chapter \ref{chap:detect} to
  identify the instances of grime. GSZ for pattern instance $p$ is then
  calculated as follows: $GSZ(p) = \|\mathcal{F}_{grime}(p)\|$,
  where $\mathcal{F}_{grime}$ is the set of findings which are grime and
  $\mathcal{F}_{grime}(p)$ is the set of grime findings affecting pattern
  instance $p$. The value measured, $v = GSZ(P)$, has a range $v \in
  \mathbb{N}^{+}$, a scope of Pattern Instance, and a scale of \textit{ordinal},
  with the units as \textit{instances of grime} or \textit{GI}.
% \item \textit{Grime Severity} (GSV) -- The grime size of a pattern instance
% normalized by the size of the pattern instance. GSV for a pattern instance $p$
% is then calculated as follows: $GSV(p) = GSV(p)/PS(p)$. The value measured,
% $v$, has a range $v \in \mathbb{R}^+$, a scope of Pattern Instance, and a
% scale of \textit{ratio}.
% \item \textit{Grime Growth} (GG) -- The rate of change in grime size for a
% given pattern instance across a given time period or for a given number of
% versions. Measured as the change in grime size, $\Delta GS$, divided by the
% change in time, $\Delta t$, where time is either measured in units such as
% hours, days, months, etc. or by the number of versions released. Thus, units
% for this metric can be either \textit{instances of grime per unit of time} or
% \textit{instances of grime per version}. The value measured, $v$, has a range
% $v \in \mathbb{R}$, a scope of Pattern Chain, and a scale of \textit{ratio}.
  \item \textit{Pattern Size} (PS) -- The size of the pattern instance measured
  a weighted sum of the normalized number of methods and fields of each class.
  PS for a pattern instance $p$ is then calculated as follows: $PS(p) = \sum_{c \in
  C(p)}SIZE2(c)$, where $C(p)$ is the set of classifiers composing pattern
  instance $p$ and $SIZE2$ is a size metric calculated by counting the number of
  methods and fields defined in the type \cite{li_object-oriented_1993}. The
  value measured, $v = PS(p)$, has a range $v \in \mathbb{R}^+$, a scope of
  Pattern Instance, and a scale of \textit{ratio}.
  
\end{enumerate}

\noindent With the questions and metrics of concern fully defined, in the next
section we define the specific criteria for case selection.

\section{Case Selection Criteria} \label{sec:buildup_select}
The following criteria define the contexts and set of cases to be studied.
Accompanying each criterion is its underlying rationale. The criteria is as
follows:
\begin{itemize}
  \item A System may be considered a context from which cases will be
  selected, if it contain a minimum of 2 Pattern Chains.\\
  \textbf{Rationale:} We must be able to select from a set of chains, having
  only a single chain does not provide this capability.
  \item A Pattern Chain may be considered a viable case, if it contains a
  minimum of 11 Pattern Instances.\\
  \textbf{Rationale:} To measure grime we need as least $n+1$ versions of a
  pattern instance, ordered by occurrence, where $n$ is the minimal number of
  measurable events (in this case evolution of the system). For the
  analyses used in this study we would need at a minimum 10 measurable events.
  \item For a Pattern Chain to be considered a viable case, it must have at
  least 1 instance with reported grime.\\
  \textbf{Rationale:} Without any grime reported within the lifetime of the
  Pattern Chain, there is no purpose in evaluating how grime evolves across its contained pattern instances.
\end{itemize}

\noindent With the selection criteria defined, we next describe the data
collection procedure for this study.

\section{Data Collection} \label{sec:buildup_data}

\begin{table}[!tb]
    \centering
    \caption{Example data table for grime evolution study.}
    \label{tab:grimebuild_tab}
	\begin{tabular}{c|ccccc}
	\multicolumn{1}{c}{\textbf{Inst ID}} & \textbf{Chain ID} & \textbf{GSZ} & \textbf{PS} & \textbf{PT} & \textbf{PF}\tabularnewline
	\hline 
	0 & 1 & 4 & 10 & Singleton & Creational\tabularnewline
	$\vdots$ & $\vdots$ & $\vdots$ & $\vdots$ & $\vdots$ & $\vdots$\tabularnewline
	\end{tabular}
\end{table}

The following describes the data to be collected, the data collection process,
and how this data is to be stored. First, we describe the data that must be
collected. For each instance under study, we extract the instance identifier,
pattern chain identifier, grime size, pattern size, pattern type, and pattern
family from the PatternChain, PatternInstance, Findings, and Measures tables of
the ArcDb. This data is then accumulated into a table, similar to the example
shown in Table \ref{tab:grimebuild_tab}, with the following specifications:

\begin{itemize}
  \item Each row of the table represents a single design pattern instance pair.
  \item The first column of the table is the pattern instance identifier
  representing a specific version of the pattern instance within a chain.
  \item The second column of the table represents the pattern chain identifier.
  \item The third column of the table represents the measured value for the
  grime size of the instance.
  \item The fourth column of the table represents the measured value for the
  pattern size of the instance.
  \item The fifth column represents the type of pattern from the 16 types
  detectable by the pattern detection tool.
  \item The sixth column represents the family of the pattern.
\end{itemize}

\begin{figure}[!tb]
  \centering
  \includegraphics[width=0.75\textwidth]{experimental_process/grimebuild_cs_dc}
  \caption{Grime buildup case study data collection process.}
  \label{fig:grimebuild_cs_dc}
\end{figure}

An overview of the data collection process is depicted in Figure
\ref{fig:grimebuild_cs_dc}. This process follows the path indicated by the
numbers encircled in green, as follows: 1.) The data for analysis is stored via
previously defined works in the GH-OSS-J (GitHub extracted Open Source
Java\texttrademark\ Systems) instance of the Arc Database. 2.) Using the
criteria set forth in Section \ref{sec:buildup_select} the selected set of
matching Systems and PatternChains are extracted from the ArcDb. For each
PatternChain the appropriate Grime Findings are extracted from the Findings
table. Also, the measures concerning the Systems, PatternChains, contained
PatternInstances, and contained Components (in each pattern instance) are
extracted. 3.) The DataModelMediator facilitates this extraction and provides
the data to the ReportGenerator. 4.) The ReportGenerator uses this data to
construct a data table. 5.) The ReportGenerator outputs this data table to a CSV
file for use in analysis. 6.) Finally, the R statistical system is used to
analyze the results provided from the CSV file, using the provided R script. The
details of this analysis are explained in the following section.

\subsection*{Data Collection Workflows} The data collection process begins, as
depicted in Figure \ref{fig:grimebuild_cs_dc}, with the execution of an Arc
workflow. The workflow utilized for this study is shown in Figure
\ref{fig:grimebuild_wf}. Initially, there is a 'Construct Systems' phase which
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
							workflow 'Grime Relations' {
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
  \caption{Grime buildup case study data collection workflow.}
  \label{fig:grimebuild_wf}
\end{figure}

In the 'primary analysis' phase data concerning software metrics and basic
static analysis issues are collected using the Metrics, PMD, and FindBugs tools.
Once the 'primary analysis' phase is concluded, the 'secondary analysis' phase
begins. Here the Pattern4 tool used to collect pattern information is executed,
this provides not only the pattern instances existing in the software, but also
creates pattern chains. Finally, at the end of the analysis, the GrimeDetector
is executed on the project, if it contributed to adding new information to any
PatternChains. In the last Phase, 'Study', the GrimeBuild tool randomly selects
the PatternChains which meet the study criteria. Using these chains the
GrimeBuild tool, via the DataModelMediator, then extracts the necessary
information and constructs a data table in memory. Lastly, the collected data is
packaged into CSV format for analysis.

\section{Analysis Procedures} \label{sec:buildup_ap}
The following analysis procedures are used in answering the questions posed in
Section \ref{sec:buildup_design}. Thus, we have selected to utilize longitudinal
analysis models. For each question the following describes the models to be
used.

To answer question 5.1 we utilize multi-variate linear mixed effects regression
model. Here we are concerned with the effects of the changes in pattern
instances across version on the amount of different types of grime accumulated
in the pattern. Thus, our response variable are measures of the metric $GSZ$
partitioned into three categories matching the three types of grime:
\textit{class}, \textit{modular}, and \textit{organizational} and the
explanatory variables are the pattern type and pattern size as fixed effects.
Because the response variables are based on counts observed over changes in
pattern instance version; the model is based on a Poisson distribution with a
log link. The three models (one per grime type) are as follows:
\begin{eqnarray}\label{eqn:rq4.1}
\log\left(GSZ_{cls}\right) & = & \beta_0 + \beta_1\times PT + \beta_2\times PS
+ \beta_3\times PF + \epsilon\\
\log\left(GSZ_{mod}\right) & = & \beta_0 + \beta_1\times PT + \beta_2\times PS +
\beta_3\times PF + \epsilon\\
\log\left(GSZ_{org}\right) & = & \beta_0 + \beta_1\times PT + \beta_2\times PS +
\beta_3\times PF + \epsilon
\end{eqnarray}

\noindent In each of these models, $GSZ_{type}$ is the grime counts for the
subscripted type of grime, $PT$ is the type of pattern, and $PS$ is the size of
the pattern as measured by the Pattern Size metric. $PT$ is a categorical value
and is one of the 16 patterns capable of being detected by the Pattern4 tool. To
evaluate the three predictor variables we will apply multivariate regression
analysis with the goal of testing the following statistical hypotheses:

\begin{eqnarray}
\notag H_{1,1}:\,\, \mu_{GAZ_{cls}} & \ne & \mu_{GAZ_{mod}}\\
\notag H_{2,1}:\,\, \mu_{GAZ_{cls}} & \ne & \mu_{GAZ_{org}}\\
\notag H_{3,1}:\,\, \mu_{GAZ_{mod}} & \ne & \mu_{GAZ_{org}}\\
\notag H_{4,1}:\,\, \beta_1 & \ne & 0\\
\notag H_{5,1}:\,\, \beta_2 & \ne & 0
\end{eqnarray}

To answer questions 5.2, 5.3 and 5.4 we use a linear mixed effects regression
model. Here we are concerned with the effect of the changes in pattern instances
across versions on the amount of grime accumulated in the pattern. Thus, our
response variable is measures of the metric $GSZ$ and the explanatory variables
are the version of the pattern instance, pattern type, and pattern family, as a
fixed effects, and pattern chain id, as a random effect (to correlate between
the observations within each chain). Since the response variable is based on
counts observed over changes in versions; the model is based on a Poisson
distribution with a log link. The basic model is defined as follows:

\begin{eqnarray}\label{eqn:rq4.2}
\log(GSZ) & = & \beta_0 + \beta_1\times InstID + \beta_2\times PT +
\beta_3\times PF\\
\notag & + & \left(b_{0} + b_{1}\times ID\right) + \epsilon
\end{eqnarray}

In this model, $GSZ$ is the count of all grime findings affecting
components within the pattern instance measured, $Version$ is the version of the
pattern instance, and $ID$ is the pattern chain identifier. To evaluate the
change in pattern grime as a pattern instance changes, we will utilize logistic
regression via the model in Equation \ref{eqn:rq4.2}. Using this model we will
test the following statistical hypotheses:

\begin{eqnarray}
\notag H_{6,1}:\,\, \beta_1 & > & 0 \,\,\,\,\,\,\textrm{(RQ 4.2)}\\
\notag H_{7,1}:\,\, \beta_2 & > & 0 \,\,\,\,\,\,\textrm{(RQ 4.3)}\\
\notag H_{8,1}:\,\, \beta_3 & > & 0 \,\,\,\,\,\,\textrm{(RQ 4.4)}
% \notag H_{7,1}:\,\, b_1 & > & 0
\end{eqnarray}

Each of these models has underlying assumptions that must be met to ensure the
validity of the model. For each model we assume that the mean of the response,
the random effects, and the errors are normally distributed. We also assume that
the random effects and errors are normally distributed. For these models there
is also an assumption of constant variance and independence for the independent
variables. These assumptions are evaluated as part of the exploratory analysis
and descriptive statistics provided in the following section.

\section{Results and Discussion} \label{sec:buildup_results}

\section{Threats to Validity} \label{sec:buildup_threats}
This section describes the limitations and threats to the validity of this
study. Specifically, we focus on threats to conclusion validity, internal
validity, construct validity, content validity, external validity, and
reliability in accordance with the framework proposed by Campbell and Cook
\cite{campbell_quasi-experimentation:_1979}, Campbell and Stanley
\cite{campbell_experimental_1963}, Wohlin \etal
\cite{wohlin_experimentation_2012} and the insights of Yin \cite{yin_case_2009}
and Runeson \etal \cite{runeson_case_2012}.

\subsection*{Conclusion Validity} 
Conclusion validity is concerned with establishing statistical significance
between the explanatory and response variables. As discussed Section
\ref{sec:buildup_results} the significance of the findings from the presented
models meets our expectations. Thus, there are no threats to conclusion
validity.

\subsection*{Internal Validity}
This validity check is concerned with the ability to show a causal relationship
between outcomes and treatments. Given that this was a case study focused on the
observation of grime relationships and which did not use random selection or
random assignment, we cannot statistically show a causal relationship between
grime size (GSZ) and pattern type or pattern size.

\subsection*{Construct Validity} This validity check is concerned with the use
of correct operational measures for the concepts being studied. We utilized
detection techniques based directly on the definitions of each form of grime
presented in Chapter \ref{chap:taxonomies} and by Schanz and Izurieta
\cite{schanz_object_2010}. We also utilized techniques based directly on the
definitions of the relationships for their detection as well. Therefore, there
are no threats to construct validity.

\subsection*{Content Validity}
Content validity is concerned with how well the selected measures cover the
content domain. The selected measures evaluate the known types of design pattern
grime in relation to design pattern instances and pattern chains. The current
set of measures cover the differences between patterns and adequately cover the
domain of grime and design pattern knowledge, thus, there are no threats to the
content validity.

\subsection*{External Validity} This validity check is concerned with the
ability to generalize the results of a study. This study was conducted across
multiple software systems and included multiple types of design patterns.
Unfortunately, as the study considered only open source software systems
implemented in Java\texttrademark , we are unable to extend our results beyond
these open source Java software systems. However, through the use of
random selection of our cases along with the use of multiple contexts, we are
not limited to simply the cases evaluated and can advance exploratory
inferences.

\subsection*{Reliability} Reliability is concerned with the dependence between
specific researchers and the data and analysis. In this case study we utilized
the Arc Framework to gather quantitative data in an automated fashion. Thus, the
data collected is not reliant on any researcher nor are the values collected
left to interpretation. Furthermore the analysis conducted utilized scripts
written for the R statistical processing software. The version of R used and the
scripts used will be made available to all researchers. Hence, there should be
no threats to the reliability of the studies.

\section{Conclusions} \label{sec:buildup_conclusions}
