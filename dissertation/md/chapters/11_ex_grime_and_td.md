\chapter{The Effects of Grime on Technical Debt}\label{chap:ex_grime_and_td}

\section{Introduction}\label{sec:extd_intro}
One of the goals of technical debt management is to understand the effects that
design and management decisions will have on the incurred technical debt of a
system. A primary component of this is the evaluation of the effects of
different forms of technical debt within a software system. Design pattern grime
has been identified as a type of issue in forming the technical debt landscape
\cite{izurieta_organizing_2012}. Thus, in this study we explore the effects of
design pattern grime on a system's technical debt principal. The goal of this
experiment was stated in Section \ref{sec:goals}, and we restate it here for the
reader's convenience:

\begin{enumerate}[leftmargin=2.0cm,label=\bfseries RG\arabic*:,start=3]
  \item Analyze design pattern instances afflicted with grime for the purpose of
evaluation with respect to the Technical Debt Principal, from the perspective of
researchers, in the context of generated Java\texttrademark\
design pattern instances.
\end{enumerate}

\noindent Following the GQM process this goal then leads to our main question of
interest and its corresponding rationale:

\begin{enumerate}[leftmargin=2.0cm,label=\bfseries RQ\arabic*:,start=3]
  \item How does each type of grime affect a software product's technical debt
  estimate?\\
  \textbf{Rationale:} Evaluate the assertion that as grime builds up in a
  pattern instance or software system, it will increase the technical debt
  principal.
\end{enumerate}

With this question in mind, this chapter is organized as follows. Section
\ref{sec:gtd_methods} describes the experimental design used and corresponding
experimentation plan including the data collection and analysis procedures.
Section \ref{sec:gtd_analysis} describes the results and analysis conducted
following the analysis procedures. Section \ref{sec:gtd_interp} discusses the
results from the analysis and their interpretation within the context of this
study and prior work. Section \ref{sec:gtd_conclude} concludes this study.

\section{Methods}\label{sec:gtd_methods}

\subsection{Refined Research Questions and Metrics}\label{sec:gtd_refined_gqm}
This section describes the experimental design, data collection procedures, and
analysis procedures used in evaluating the effects of design pattern grime on
technical debt principal. Our prediction is that \textit{design pattern grime
has the effect of increasing design pattern instance technical debt principal.}
This prediction is our expectation of the result of evaluating \textbf{RQ3}
(c.f. \ref{sec:extd_intro}). In the spirit of the GQM, we have further refined
this question into a series of directly answerable questions, their guiding
rationale, and set of metrics defined to facilitate answering these questions.
These questions and metrics are as follows:

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
\begin{enumerate}[leftmargin=2.0cm,label=\bfseries M3.\arabic*:]
  \item \textit{Technical Debt Principal} -- A measure of the man-hours or
  monetary value of the effort required to remediate (via refactoring) the
  issues identified as technical debt within a software system. This metric is
  measured using Nugroho et al.'s method as described in Section \ref{sec:tech_debt}.
  \item \textit{Technical Debt Interest} -- ... This metric is measured using Nugroho et al.'s
  approach as described in Section \ref{sec:tech_debt}.
  \item \textit{Injection Type} (IT) -- as defined in Section \ref{sec:gq_refined_gqm}.
  \item \textit{Injection Severity} (IS) -- as defined in Section
  \ref{sec:gq_refined_gqm}.
  \item \textit{Pattern Type} (PT) -- as defined in Section \ref{sec:gq_refined_gqm}.
\end{enumerate}

\subsection{Design Selection, Subjects, and Replication}

This experiment uses a factorial design. We have selected this to accommodate
the potential interactions between the independent variables. Furthermore, we
are not restricted in our design by the number of experimental subjects, as they
are generated using the Design Pattern Generation algorithm (c.f. 
\ref{sec:dp_gen}).
The independent variables are: Grime Severity, Grime Type (Nominal Values
representing the 26 types of Design Pattern Grime), and Pattern Type. The
response variable, in this design, is technical debt principal as measured using
the CAST approach. The experimental subjects are design pattern instances. These
instances are generated using the design pattern generation technique described
in Section \ref{sec:dp_gen}. The generation algorithm utilizes a randomized
process for the creation of design pattern instances. This randomization
provides a process similar to random selection from a population, thus reducing
threats to external validity. The design will then require 2496 pattern
instances (156 instances per pattern type) per replication. The following
subsection describes the method used to collect this data.

\subsection{Data Collection}
The following describes the data to be collected, the data collection process,
and how this data is stored. First, we describe the data that must be collected.
For each instance under study, we extract the instance identifier, the grime
type that was injected, the grime severity for the grime injected, the pattern
type, and the change in the technical debt principal between when the pattern
was generated and the grime was injected. This information is extracted from the
PatternInstance, Findings, and Measures tables of the ArcDb. This data is then
accumulated into a table, similar to the example shown in Table
\ref{tab:gtd_dc_ex}, with the following specifications:

\begin{table}[!tb]
\centering
\caption{Example data collection table for grime and quality
experiment.}\label{tab:gtd_dc_ex}
\begin{tabular}{c|cccc}
\multicolumn{1}{c}{\textbf{ID}} & \textbf{$PT$} & \textbf{$GT$} & \textbf{$GS$} & \textbf{$TD$}\tabularnewline
\hline 
0 & Singleton & DIPG & 2 & 0.95\tabularnewline
$\vdots$ & $\vdots$ & $\vdots$ & $\vdots$ & $\vdots$\tabularnewline
\end{tabular}
\end{table}

\begin{itemize}
  \item Each row of the table represents a single design pattern instance.
  \item The first column of the table is the pattern instance identifier
  representing a specific version of the pattern instance.
  \item The second column of the table represents the design pattern type.
  \item The third column of the table represents the type of grime injected.
  \item The fourth column of the table represents the grime severity rating for
  the injected grime.
  \item The fifth column of the table represents the technical debt principal
  for the pattern instance.
\end{itemize}

\begin{figure}
  \centering
  \includegraphics[width=\textwidth]{experimental_process/grime_td_ex_dc}
  \caption{Grime effects on technical debt data collection process.}
  \label{fig:gtd_data_coll}
\end{figure}

An overview of the data collection process is depicted in Figure
\ref{fig:gtd_data_coll}. This process follows the path indicated by the numbers
encircled in green, as follows. 1.) The Arc system executes the \textit{Pattern
Generator} 2.) which utilizes the \textit{ExperimentalConfig} to define which
patterns to generate and the number of instances needed. 3.) The execution of
the \textit{PatternGenerator} results in the generation of a project per
instance as a physical project folder, and in the generation of elements in the
ArcDb. 4.) The workflow shifts to the \textit{SoftwareInjector}, which uses the
\textit{ExperimentConfig} to determine the type and severity of grime to inject.
5.) This is effected through the copying of the existing physical project and
then injecting the grime into this copy. 6.) This also causes the copying of
elements in the data model and the creation of grime findings for the afflicted
elements in the ArcDb. 7.) The workflow progresses to the execution of the
standard java tooling for the 8.) injected project, and 9.) the original
project. 10.) The results of the execution of the standard java tooling (which
includes the items indicated by the ``Java Tools'' key on the diagram) are then
stored to the ArcDb. 11.) The Quamoco quality analysis is executed for all
systems in the database. 12.) This results in the addition of technical debt principal
measures to the ArcDb for all systems under analysis. 13.) Finally, the report
generator extracts the values to construct the data table according to the
specification described above.

\subsection{Analysis Procedures}
This section describes the analysis models and procedures used for this
experiment. For our design and subsequent analysis we have selected to use the
following ANOVA model:
\begin{eqnarray}
\notag y_{ijkl} & = & \mu + \tau_i + \beta_j + \gamma_k +
\left(\tau\beta\right)_{ij} + \left(\tau\gamma\right)_{ik} +
\left(\beta\gamma\right)_{jk} + \left(\tau\beta\gamma\right)_{ijk} +
\epsilon_{ijkl}
\end{eqnarray}

% Question can we do this if there are nominal values?

\noindent In this model $y_{ijkl}$ represents technical debt principal (TD),
$\tau_i$ represents the effect of the $i^{th}$ grime type (GT), $\beta_j$
represents the effect of the jth pattern type (PT), $\gamma_k$ represents the effect of the
kth grime severity (GS), $\left(\tau\beta\right)_{ij}$,
$\left(\tau\gamma\right)_{ik}$, and $\left(\beta\gamma\right)_{jk}$ represent
the effects of the two-factor interactions, $\left(\tau\beta\gamma\right)_{ijk}$
represents the effect of the three-factor interaction, $\mu$ represents the
baseline mean TD, and $\epsilon_{ijkl}$ represents the random error of the
$l^{th}$ observation of the $(i,j,k)^{th}$ treatment.

\noindent The evaluation of the following statistical hypotheses will be used to
evaluated the effects of the interactions, and whether or not to adjust the
model to include/exclude interaction terms:

\begin{eqnarray}
\notag H_{1,0}: \left(\tau\beta\gamma\right)_{ijk} & = & 0 \textrm{, for all
ijk}\\	
\notag H_{2,0}: \left(\tau\beta\right)_{ij} & = & 0 \textrm{, for all ij}\\
\notag H_{3,0}: \left(\tau\gamma\right)_{ik} & = & 0 \textrm{, for all ik}\\
\notag H_{4,0}: \left(\beta\gamma\right)_{jk} & = & 0 \textrm{, for all jk}
\end{eqnarray}

The evaluation of Research Question \textbf{RQ3.1} will be answered via the in
part by the interaction effects evaluated by $H_{1,0}$, $H_{2,0}$, $H_{3,0}$, and
$H_{4,0}$. Additionally, we will test the following statistical hypotheses to
evaluate the main effect of grime type when all interactions are held constant:

\begin{eqnarray}
\notag H_{5,0}: \tau_i & = & 0 \textrm{, for all i}\\
\notag H_{5,1}: \tau_i & \ne & 0 \textrm{, for some i}
\end{eqnarray}

The evaluation of Research Question \textbf{RQ3.2} will be answered in part by
the interaction effects evaluated by $H_{1,0}$, $H_{2,0}$, $H_{3,0}$, and
$H_{4,0}$. Additionally, we will test the following statistical hypothesis to
evaluate the main effect of pattern type when all interactions are held
constant:

\begin{eqnarray}
\notag H_{6,0}: \beta_j & = & 0 \textrm{, for all j}\\
\notag H_{6,1}: \beta_j & \ne & 0 \textrm{, for some j}
\end{eqnarray}

The evaluation of Research Question \textbf{RQ3.3} will be answered in part by
$H_{1,0}$, $H_{2,0}$, $H_{3,0}$, and $H_{4,0}$. Additionally, we will test the
following statistical hypothesis to evaluate the effect of grime severity when
all other factors are held constant:

\begin{eqnarray}
\notag H_{7,0}: \gamma_k & = & 0 \textrm{, for all k}\\
\notag H_{7,1}: \gamma_k & \ne & 0 \textrm{, for some k}
\end{eqnarray}

To answer question \textbf{RQ3.4} we will
conduct a series of contrast analyses to evaluate the following statistical
hypotheses, related to the research questions. The first set of contrasts will
be used to determine the relative ranking of grime types:
\begin{eqnarray}
\notag H_{8,0}: \mu_{ORG} & = & \mu_{CLS}\\
\notag H_{9,0}: \mu_{CLS} & = & \mu_{MOD}\\
\notag H_{10,0}: \mu_{MOD} & = & \mu_{ORG}
\end{eqnarray}
\noindent Where $MOD$, $CLS$, and $ORG$ represent modular, class, and
organizational grime, respectively.

\noindent The following set of contrasts determine the relative ranking of class
grime subtypes:
\begin{eqnarray}
\notag H_{11,0}: \mu_{DIR} & = & \mu_{IND}\\ % Direct vs Indirect Class Grime
\notag H_{12,0}: \mu_{ICG} & = & \mu_{XCG}\\ % Internal vs External Class Grime
\notag H_{13,0}: \mu_{SIN} & = & \mu_{PAR}   % Singular vs Pair Class Grime
\end{eqnarray}
\noindent Where $DIR$ and $IND$ represent direct and indirect class grime,
respectively. $ICG$ and $XCG$ represent internal and external class grime,
respectively. $SIN$ and $PAR$ represent singular and pair class grime,
respectively.


\noindent The following set of contrasts determine the relative ranking of
modular grime subtypes:
\begin{eqnarray}
\notag H_{14,0}: \mu_{PMG} & = & \mu_{TMG}\\ % Persistent vs Temp Mod Grime
\notag H_{15,0}: \mu_{IMG} & = & \mu_{XMG}\\ % Internal vs External Mod Grime
\notag H_{16,0}: \mu_{AMG} & = & \mu_{EMG}  % Afferent vs Efferent Mod Grime
\end{eqnarray}
\noindent Where $PMG$ and $TMG$ represent persistent and temporary modular
grime, respectively. $IMG$ and $XMG$ represent internal and external modular
grime, respectively. $AMG$ and $EMG$ represent afferent and efferent modular
grime, respectively.

\noindent The final set of contrasts determine the relative ranking of
organizational grime subtypes:
\begin{eqnarray}
\notag H_{17,0}: \mu_{POG} & = & \mu_{MOG}\\ % Package vs Modular Org Grime
\notag H_{18,0}: \mu_{IOG} & = & \mu_{XOG}\\ % Internal vs External Org Grime
\notag H_{19,0}: \mu_{CLS} & = & \mu_{RES}\\ % Closure vs Reuse Org Grime
\notag H_{20,0}: \mu_{CYC} & = & \mu_{UNS}   % Cyclic vs Unstable Org Grime
\end{eqnarray}
\noindent Where $POG$ and $MOG$ represent package and modular organizational
grime. $IOG$ and $XOG$ represent internal and external organizational grime,
respectively. $CLS$ and $RES$ represent closure and reuse organizational grime,
respectively. $CYC$ and $UNS$ represent cyclic and unstable organizational
grime, respectively.

As a part of this analysis, and complimentary to the statistical testing, is the
evaluation of the interaction between the independent variables and the effect
this interaction has on the dependent variables. This model has underlying
assumptions that must be met to ensure its validity. We assume that the mean of
the response and the errors are normally distributed. There is also an
assumption of constant variance and independence for the independent variables.
These assumptions are evaluated as part of the exploratory analysis and
descriptive statistics provided in the following section.

\subsection{Evaluation of Validity}

The reliability of the tools and methods used in the experiment is based on two 
components. First, the selected third-party tools are well known and known to 
be highly tested and relatively bug free. Second, the tools developed as part of
this work have been throughly tested at the unit, integration, and system 
level. As part of the pilot study used to evaluate the design size of the 
experiment, we will conduct an assessment of both the reliability and validity 
of the data collection method. Any issues will be corrected at that time, in 
order to ensure reliability and validity during the execution of the experiment.

\section{Execution}\label{seq:gtd_execution}

\subsection{Sample}

\subsection{Prepartion}

\subsection{Data Collection Performed}

\subsection{Validity}

\section{Analysis}\label{sec:gtd_analysis}

\subsection{Size Analysis}\label{sec:gtd_pilot}

We conducted a pilot study to determine the number of replications necessary to achieve the
required statistic power for the hypothesis tests in each of the experiments. This study
used only two patterns (Strategy and State) but used all six levels of Injection Severity
and all forms of Grime. This led to an evaluation of 312 generated pattern instances
following the same approach that the actual experiment followed. Validating the experimental
approach was an additional gain from this study. The study's results suggested that to
achieve 95\% power in our analysis each experiment would need at least two total replicates.
Furthermore, this number of replicates would be required in order to evaluate the full
interaction terms, thus for the full experiments we used two replicates each.

%% Mention the use of GPower, and show a table of the results

\begin{table}[!tb]
\caption{Size analysis results.}\label{tab:gtd_power_analysis}

\centering
\begin{tabular}{l|cccccc|c}
\hline
\multicolumn{1}{c|}{\textbf{Attribute}} & \textbf{$\alpha$} & \textbf{Power} & \textbf{Effect Size} & \textbf{df} & \textbf{Rep Size} & \textbf{Size} & \textbf{Reps} \\ \hline
\textbf{TD Principal}  & 0.05 & 0.95 & 0.2456884 & 1875 & 2496 & 4816  & \textbf{2} \\
\textbf{TD Interest}   & 0.05 & 0.95 & 0.1980468 & 1875 & 2496 & 6602  & \textbf{3} \\
\hline
\end{tabular}
\end{table}



\section{Interpretation}\label{sec:gtd_interp}

\subsection{Evaluation of Results and Implications}

\subsubsection{Technical Debt Principal}

\subsubsection{Technical Debt Interest}

\subsection*{Limitations of the Study} This section describes the limitations 
and
threats to the validity of this study. Specifically, we focus on threats to
conclusion, internal, construct, content, and external validity in accordance
with the framework proposed by Campbell and Cook
\cite{campbell_quasi-experimentation:_1979}, Campbell and Stanley
\cite{campbell_experimental_1963}, and Wohlin \etal
\cite{wohlin_experimentation_2012}.

\subsubsection{Conclusion Validity} Conclusion validity is concerned with
establishing statistical significance between the independent variables and the
dependent variables. In order to ensure that there were no threats to conclusion
validity we took the following measures. For each statistical test used we
verified that the assumptions were met. Thus, there are no threats to the
conclusion validity of this study.

\subsubsection{Internal Validity}
Internal validity is concerned with the relationship between the treatments and
the outcomes and whether this relationship is causal or due to other factors. In
this experiment, there is no threat to internal validity due to the experiments
being fully controlled.

\subsubsection{Construct Validity}
Construct validity is concerned with the meaningfulness of measurements and the
quality choices made about independent and dependent variables such that these
variables are representative of the underlying theory. Several measures have
been proposed to measure technical debt principal and interest. In this
experiment only technical debt principal is measured using the most well known
measures. Thus, as we do not cover all the properties of technical debt with our
measures there is a threat to construct validity. This threat is mitigated by
restricting our conclusions to only the concept of technical debt principal.

\subsubsection{Content Validity} Content validity is concerned with how well
the selected measures cover the content domain. In this experiment using the
CAST method for calculating technical debt principal. The technical debt
literature further defines \textit{technical debt interest} and \textit{interest
probability} as measures to understand the future impact of the imposed debt
\cite{}. Not including these measures imposes an additional threat to content
validity. Furthermore, the metrics GS and PT are well defined and cover the
content domain, within the limitations of the underlying tools. The PT metric
only covers 16 of the 23 GoF design patterns, as this is the limit of the
Pattern4 design pattern detection tool which poses a threat to the content
validity of this study.

\subsubsection{External Validity} External validity is concerned with the
ability to generalize the results of a study. The experiments are conducted
using existing open source systems implemented in Java\texttrademark\ . The use
of only one language leads to a potential threat due to only looking at a single
language. Thus, we cannot generalize outside of Java\texttrademark\
implementations. Since the experiments are to be conducted only on open source
systems, there is another threat to external validity.

\subsection*{Inferences}

\subsection*{Lessons Learnt}

\section{Conclusion and Future Work}\label{sec:gtd_conclude}
