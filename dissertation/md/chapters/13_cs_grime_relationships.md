\chapter{Relationships between Grime Subtypes}\label{chap:cs_grime_relationships}

\section{Introduction} \label{sec:grimerel_intro}
To date, little is known about the relationships between different types of
technical debt, and specifically very little is known about the relationships
between types and sub-types of grime. Understanding the relationships between
grime types and subtypes, will yield a means to better detect when these issues
have occurred or are likely to occur. This then yields a benefit to
practitioners and researchers in understanding how grime affects the patterns
they implement, and in discovering other forms of grime possibly present but
unnoticed. The goal of this study was stated in Chapter \ref{chap:intro}. For
the reader's convenience we restate it here:

\begin{enumerate}[leftmargin=2.0cm,label=\bfseries RG\arabic*:,start=5]
\item Analyze pattern instances for the purpose of identifying intra- and
inter-relationships with respect to grime subtypes from the perspective of
researchers in the context of open source projects.
\end{enumerate}

\noindent Following the GQM process this goal then leads to our main
questions of interest:
\begin{enumerate}[leftmargin=2.0cm,label=\bfseries RQ5.\arabic*:]
  \item What are the relationships between subtypes of a grime type?\\
  \textbf{Rationale:} Evaluate the assumption that grime subtypes are disjoint.
  \item What are the relationships between each major type of grime?\\
  \textbf{Rationale:} Evaluate the assumption that grime Types are disjoint.
\end{enumerate}

With these questions in mind, this chapter is organized as follows.
Section \ref{sec:grimerel_design} describes the design of this study.
Section \ref{sec:grimerel_select} describes the selection criteria for each case
selected. Section \ref{sec:grimerel_data}, defines the
data collection procedures. Section \ref{sec:grimerel_ap} defines
the analysis procedures. Section \ref{sec:grimerel_results}
describes the results and their analysis. Section
\ref{sec:grimerel_threats} describes the threats to the validity and other
limitations. Finally, Section \ref{sec:grimerel_conclusions}
provides a summary and concluding remarks.

\section{Design} \label{sec:grimerel_design}
We have elected to use a multiple case study approach. In this approach, the
cases under study are pattern chains meeting a defined selection criteria. The
context for each of these cases are the containing systems for each of the
selected pattern chains. The objects of study in each pattern chain are grime
infected final versions of pattern instances.

In the spirit of the GQM, we have further refined the main questions  into a
series of directly answerable questions, their guiding rationale, and set of
metrics defined to facilitate answering these questions. The questions and
metrics are as follows:

\begin{enumerate}[leftmargin=2.0cm,label=\bfseries RQ5.\arabic*:]
	\item What are the intra-relationships between modular grime sub-types?\\
	\textbf{Rationale:} Evaluates the assertion that modular grime sub-types are
	disjoint and unrelated.
	\item What are the intra-relationships between class grime sub-types?\\
	\textbf{Rationale:} Evaluates the assertion that class grime sub-types are
	disjoint and unrelated.
	\item What are the intra-relationships between organizational grime
	sub-types?\\
	\textbf{Rationale:} Evaluates the assertion is that organizational grime
	sub-types are disjoint and unrelated.
	\item What are the inter-relationships between modular, class, and
	organizational grime types?\\
	\textbf{Rationale:} Evaluates the assertion that grime types are disjoint and
	unrelated.
\end{enumerate}

\begin{enumerate}[leftmargin=2.0cm,label=\bfseries M5.\arabic*:]
  \item \textit{Support} (SUP) -- a form of relationship between one or more
  forms of design disharmony and another form of design disharmony indicating
  that the presence of the former provides supporting evidence of the latter.
  This metric is qualitative rather than quantitative and its measurement is
  described further in section \ref{subsec:gb_support}
\end{enumerate}

\subsection{Measuring Support}\label{subsec:gb_support}
In answering questions 5.1--5.4 we are concerned with whether there are any
relationships between the types of grime (modular, class, and organizational),
which we will call inter-grime relationships or if there are any relationships
between the subtypes of each type of grime, which we will call intra-grime
relationships. The types of relationships we are specifically looking for are
based on those defined by Pietrzak and Walter \cite{pietrzak_leveraging_2006}
for codesmells, as follows:

\begin{itemize}
	\item \textit{Plain Support}
	  -- Grime type A supports grime type B, if the presence of A indicates a high
	  likelihood of the presence of B.
	\item \textit{Mutual Support} -- Grime type A and B mutually support each
	  other, if the presence of A indicates a high likelihood of the presence of B
	  and the presence of B indicates a high likelihood of the presence of A.
	\item \textit{Aggregate Support} -- The generalization of plain support and
	  rejection, in that there are two sets of grime types
	  $\mathcal{A}$ and $\mathcal{B}$ where the set $\mathcal{A}$ is supporting grime types and set
	  $\mathcal{B}$ is the rejecting grime types. The combination of the two sets
	  indicates with high likelihood of the presence of grime types in a third set,
	  $\mathcal{C}$.
	\item \textit{Transitive Support} -- Grime type A transitively supports grime
	  type C, if there is a relationship such as, grime type A supports grime type B
	  which supports grime type C.
	\item \textit{Rejection} -- Grime type A rejects grime type B, if the
	  presence of A indicates a very low likelihood of the presence of B.
	  (Informative only, rejection will not be considered in this study)
% 	\item \textit{Inclusion} -- Grime type A includes grime type B, if A is a
% 	  special case of B.
	% \item \textit{Common Refactoring} -- Grime type A and grime type B share a
	% common refactoring such that the refactoring of A will partially or completely
	% refactor B \cite{pietrzak_leveraging_2006}.
\end{itemize}

With the questions and metrics of concern fully defined, in the next section we
define the specific criteria for case selection.

\section{Selection} \label{sec:grimerel_select}
The following criteria define the contexts and set of cases to be studied.
Accompanying each criterion is its underlying rationale. The criteria are as
follows:
\begin{itemize}
  \item The pattern instance must be a member of a pattern chain of length
  $\geq$ 2.\\
  \textbf{Rationale:} In order to detect grime, there must be at least
  two consecutive versions of the pattern instance.
  \item A selected pattern instance, must display at least one form of
  grime.\\
  \textbf{Rationale:} Without a displaying form of grime there is no reason to
  evaluate the pattern instance.
\end{itemize}

\section{Data Collection} \label{sec:grimerel_data}

\begin{table}[!tb]
    \centering
  	\caption{Example data table.}\label{tab:grimerel_ex}
  	\begin{tabular}{c|cccc}
	\multicolumn{1}{c}{\textbf{Inst Chain ID}} & \textbf{GT1} & \textbf{GT2} &
	\textbf{GT3} & $\cdots$\tabularnewline
	\hline 
	1 & 1 & 0 & 1 & $\cdots$\tabularnewline
	2 & 0 & 1 & 1 & $\cdots$\tabularnewline
	3 & 1 & 0 & 0 & $\cdots$\tabularnewline
	$\vdots$ & $\vdots$ & $\vdots$ & $\vdots$ & $\ddots$\tabularnewline
	\end{tabular}
\end{table}

This section details the data to be collected, the data collection procedures,
and how this data will be stored. First, we describe the data that must be
collected. For each instance under study, we will extract all instances of grime
that affect the pattern from the ArcDb Findings table. This data is
accumulated into a table with the following specifications:

\begin{itemize}
  \item Each row of the table represents a single design pattern instance pair.
  \item The first column of the table is the pattern chain key for the pattern
  chain containing the pattern instance pair.
  \item The remaining columns are for each subtype of design pattern grime, and
  three for the different types of grime.
  \item Each cell of the table (with exception of the first cell of each row)
  contains either a 1 or 0 indicating the presence or lack thereof,
  respectively, of that form of grime within the pattern instance pair.
\end{itemize}

\begin{figure}[!tb]
  \centering
  \includegraphics[width=0.75\textwidth]{experimental_process/grimerel_cs_dc}
  \caption{Data collection process.}
  \label{fig:grimerel_cs_dc}
\end{figure}

An overview of the data collection process is depicted in Figure
\ref{fig:grimerel_cs_dc}. This process follows the execution path identified in
the figure by the numbers encircled in green. 1.) The case study Arc work flows
are executed, which builds up and stores the analysis data in the ArcDb. The Arc
Db in this case is labeled GH-OSS-J, as this data is extracted from
Java\texttrademark\ open source software projects stored on GitHub. This data is
extracted using all of the tools identified in chapters
\ref{chap:arc_framework}--\ref{chap:detect}. 2.) The data we are concerned with
is found within the System, PatternChains, and Findings tables of the ArcDb,
which will be accessed using the DataModelMediator. 3.) The DataModelMediator is
used by the ReportGenerator to extract and filter the data. 4.) The
ReportGenerator takes the filtered data and packages it as a 5.) CSV file in the
format specified above and in Table \ref{tab:grimerel_ex}. 6.) The provided R
Script file and the CSV data are then utilized by R to conduct the analysis.

\subsection*{Data Collection Workflows} The data collection process begins, as
depicted in Figure \ref{fig:grimerel_cs_dc}, with the execution of an Arc work
flow. The workflow utilized for this study is shown in Figure
\ref{fig:grimerel_wf}. Initially, there is a `Construct Systems' phase which
uses the GitHubSearch tool to find and collect System and Project meta-data and
add these entities to the Arc data model. Next, for each System and each
System's project, the project repository is cloned and switched to the
appropriate tag/branch. After cloning, the system is analyzed to identify any
Java\texttrademark\ artifacts. After the artifact data is collected, the project
is parsed and the source code entities are extracted and added to the data
model. Finally, at the end of the `prelim' phase the project is compiled.

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
							    	pairs = GrimeRel.select()
							    	table = GrimeRel.data(pairs)
							    	CSVReport.package(table)
							    }
						    }
  \end{lstlisting}
  \caption{Grime relationships case study data collection workflow.}
  \label{fig:grimerel_wf}
\end{figure}

In the 'primary analysis' phase data concerning software metrics and basic
static analysis issues are collected using the Metrics, PMD, and FindBugs tools.
Once the 'primary analysis' phase is concluded, the 'secondary analysis' phase
begins. Here the Pattern4 tool used to collect pattern information is executed,
this provides not only the pattern instances existing in the software, but also
creates pattern chains. Finally, at the end of the analysis, the GrimeDetector
is executed on the project, if it contributed to adding new information to any
PatternChains. In the last Phase, 'Study', the GrimeRel tool randomly selects
the PatternInstance pairs which meet the study criteria. Using these pairs the
GrimeRel tool, using the DataModelMediator, then extracts the necessary
information and constructs a data table in memory. The last part of the workflow
is the packaging of this extracted data table into CSV format for analysis.

\section{Analysis Procedures} \label{sec:grimerel_ap}
This section describes the analysis procedures used in this study.
Specifically, we detail the means by which we use the data collected to identify
the different relationship types identified in Section
\ref{sec:grimerel_design}.

Using the data table constructed using the method described in Section
\ref{sec:grimerel_data} we then use association rule mining to identify the
support relationships. Specifically, we utilize the FP-Growth algorithm as
implemented in the R package
\textit{rCBA}\footnote{\url{https://cran.r-project.org/package=rCBAq}}
\cite{kuchar_easyminer_2015}.

The FP-Growth algorithm, developed by Han, Pei, and Yin \cite{han_mining_2000}
is a machine-learning approach for identifying association rules from a set of
data. Like other similar algorithms it is based on two concepts:
\textit{support} and \textit{confidence}. Support, is an indication of the
frequency that an itemset appears within a data set. Confidence, is an
indication of the frequency that an association rule has been found to be true.
That is, it is the frequency of occurrence of an association rule, $\mathcal{X}
\Rightarrow \mathcal{Y}$, calculated as the count of the occurrences of
$\mathcal{X}$ occurs $\mathcal{Y}$ divided by the total number of rows in the
dataset.

Using these concepts, the FP-Growth algorithm works through the dataset
evaluating the support of each item in the data set constructing a tree of items
that meet a minimum support threshold. Once the tree has been constructed, only
itemsets with a sufficiently large support value remain in the tree, and from
these itemsets, association rules are extracted, which meet the minimum
confidence threshold. Thus, the key to this approach is setting the correct values for
these two thresholds. Furthermore, the rCBA implementation of the FP-Growth
algorithm also has a third parameter for the maximum length of any generated
rule. Much like all other machine-learning algorithms it is imperative that the
parameters of the algorithm are set correctly to ensure good results. The
settings of these parameters determines the utility of the rules produced.

For the purposes of this study, we only need to identify one type of support
relationship using association rule mining: \textit{plain support}. For this
purpose, we set the algorithm parameters as follows: \textit{minimum support} at
0.3, \textit{minimum confidence} at 0.95 and \textit{maximum length} at 2. Using
the set of rules identified, from the data, we can then identify the remaining
support relationships: \textit{mutual support}, \textit{transitive support}, and
\textit{aggregate support} using the plain support rules.

\section{Results and Discussion} \label{sec:grimerel_results}

\section{Threats to Validity} \label{sec:grimerel_threats}
This section describes the limitations and threats to the validity of this
study. Specifically, we focus on threats to conclusion validity, internal
validity, construct validity, content validity, external validity, and
reliability in accordance with the framework proposed by Campbell and Cook
\cite{campbell_quasi-experimentation:_1979}, Campbell and Stanley
\cite{campbell_experimental_1963}, Wohlin \etal
\cite{wohlin_experimentation_2012} and the insights of Yin \cite{yin_case_2009}
and Runeson \etal \cite{runeson_case_2012}.

\subsection*{Internal Validity}
This validity check is concerned with the ability to show a causal relationship
between outcomes and treatments. Given that this was a case study focused on the
observation of the existence of grime relationships, there is no possibility to
observe such phenomena.

\subsection*{Construct Validity} This validity check is concerned with the use
of correct operational measures for the concepts being studied. We utilized
detection techniques based directly on the definitions of each form of grime
presented in Chapter \ref{chap:taxonomies} and by Schanz and Izurieta
\cite{schanz_object_2010}. We also utilized techniques based directly on the
definitions of the relationships for their detection as well. Therefore, there
are no threats to construct validity.

\subsection*{Content Validity}
Content validity is concerned with how well the selected measures cover the
content domain. The selected measure evaluates simple relationships between
design pattern grime types. Pietrzak and Walter \cite{pietrzak_leveraging_2006}
identified three other forms of support relationships: \textit{rejection},
\textit{inclusion} and \textit{common refactoring}, which we have not included
in this work. This exclusion of possible relationship forms could be a threat to
the content validity of this study.

\subsection*{External Validity} This validity check is concerned with the
ability to generalize the results of a study. This study was conducted across
multiple software systems and included multiple types of design patterns.
Unfortunately, as the study considered only open source software systems
implemented in Java\texttrademark , we are unable to extend our results beyond
these open source Java software systems. Furthermore, we did validate the
results of the association rule extraction on an external data set. Both of
these reasons may be cause for threats to the external validity of this study.

\subsection*{Reliability} Reliability is concerned with the dependence between
specific researchers and the data and analysis. In this case study we utilized
the Arc Framework to gather quantitative data in an automated fashion. Thus, the
data collected is not reliant on any researcher nor are the values collected
left to interpretation. Furthermore the analysis conducted utilized scripts
written for the R statistical processing software. The version of R used and the
scripts used will be made available to all researchers. Hence, there should be
no threats to the reliability of the studies.

\section{Conclusion} \label{sec:grimerel_conclusions}

