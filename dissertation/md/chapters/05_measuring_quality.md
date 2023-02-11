\chapter{Metrics, Quality and Technical Debt}\label{chap:quality}

\begin{quote} \centering \textit{If you can not measure it, you can not improve 
it.}\\--Lord Kelvin \end{quote}

\section{Introduction}\label{sec:mqtd_intro} The desire to measure the quality 
of software has existed nearly as long as software engineering 
\cite{ferenc_software_2014}. The software industry, with the advent of better 
tools and processes, has been placing a higher priority on the use of quality 
analysis and measurement tools. The measurement of higher-level quantities such 
as Software Quality and Technical Debt is, typically, based on lower-level 
static analysis and metric aggregation. Facilitating this aggregation are models 
and approaches designed to operationalize the underlying quality aspects or 
(\emph{-ilities}). Operationalizing quality models requires the ability to 
efficiently collect metrics measures and software issues in a general enough way 
that allows for a multitude of tools to be used. Our solution to this problem is 
the development of the Arc Framework, as detailed in Chapter 
\ref{chap:arc_framework}.

In this chapter, we connect the components of the Arc Framework with the 
underlying concepts of software metrics analysis, software quality analysis, and 
technical debt analysis. These techniques form the basis of the organization of 
the sections of this chapter. The first section details our approach to 
integrating software metrics collection into the Arc Framework. The second 
section details our implementation of the Quamoco quality measurement approach 
and its integration with the Arc Framework. The third section details our 
approach to measuring technical debt and its integration with the Arc Framework. 
Finally, we conclude with a summary and segue with the upcoming chapters 
concerning the effects of design pattern grime on software quality and technical 
debt.

\section{Metrics Analysis} A key component to an active software measurement 
effort is the identification of the correct metrics by which one may answer the 
questions at hand. This idea is central to any sophisticated software 
engineering enterprise in which one wishes to know what and where improvement 
may be gained and forms the basis of the Goal-Question-Metric paradigm 
\cite{basili_software_1992}. Through our use of the GQM, as described in Chapter 
\ref{chap:intro}, we are intimately familiar with the necessity of identifying 
and utilizing the right metrics. Thus, this section is devoted to providing a 
more in-depth insight into our method of software metrics measurement.

\subsection{Metrics Model} A software metric provides a knowledge extraction 
rule for encoding some software system aspects. These encoded aspects 
represented as either qualitative or quantitative measured values of metrics. 
Metrics can individually, or in combination, act as surrogates for quality 
attributes. Additionally, metrics provide system information useful in their own 
right. This capability has led researchers and industry advocates, seeking to 
improve both the software product and development process, to develop several 
metrics and measurement tools. Having used these tools, we have found that most 
lack a sufficient extension capability to meet our measurement needs. Thus, we 
have developed a metrics analysis system.

In developing this system, we divided the metrics along two axes: Direct/Derived 
and Source/Abstraction, as depicted in Figure \ref{fig:metric_breakdown}. This 
figure depicts the subdivision of the set of all metrics into four subsets along 
the axes. The first axis indicates whether the Metric directly measures the 
artifact under analysis or if it is a metric combining other metrics. The second 
axis indicates whether the artifact measured is actual source code or some 
abstraction contained within a model of the software system (i.e., UML or CFG). 
Understanding this division is better aided through a set of examples.

\begin{figure}[!tb]
\centering
\includegraphics[width=.75\textwidth]{metric_images/breakdown}
\caption{The axes of metrics division with examples 
shown.}\label{fig:metric_breakdown}
\end{figure}

The following examples note several well-known software metrics and their 
location within the quadrant. The first is an example of a Direct-Source metric 
is \textit{Source Lines of Code}(SLOC) \cite{lorenz_object-oriented_1994}, which 
is simply a count of the number of non-blank non-comment lines within a source 
code file. An example of a Direct-Abstraction metric is McCabe's Cyclomatic 
Complexity \cite{mccabe_complexity_1976}, which is a measure of the complexity 
of a method/function based on the control flow graph representation of a 
method's structure. An example of a Derived-Source metric would be \textit{Lines 
of Code per Class} (LOCC), which is measured at the project or system level and 
is the average number of lines of code per class in the system. The following 
discusses the implementation of the metrics system.

\begin{figure}[!tb] \centering 
\includegraphics[width=\textwidth]{arc_images/metrics_model} \caption{Metrics 
measurement system model.}\label{fig:metric_model} \end{figure}

Figure \ref{fig:metric_model} depicts the metrics \mm\ . The critical component 
of this model is the base class \textit{AbstractMetric}, which provides the 
abstract method \verb|measure(...)| (containing the measurement logic). This 
method computes the Metric across a provided Component and returns this computed 
value encapsulated in a \textit{Measure} object. The returned Measure is stored 
into the Arc data model by the Metric. Extending this base class is the 
\textit{AbstractSourceMetric}, which simply provides the ability to extract the 
underlying source code for the provided \textit{Measurable} item. The final main 
class, \textit{AbstractLOCMetric}, provides the base capabilities to measure 
lines of code metrics. The latter class uses the \textit{LoCProfile} and its 
manager to provide the language-specific values for the AbstractLOCMetric 
fields.

The final components of the \mm\ link to the actual implementations. Each 
implemented Metric provides (through Java\texttrademark/Groovy annotations) a 
\textit{MetricDefinition}, which provides the metric with a name, a description, 
a primary handle (acronym) and a set of \textit{MetricProperties}. The 
MetricProperties further describe the Metric based on the provided enumerations 
for the scale, scope, category, and type. 

\subsection{Implemented Metrics} The metrics analysis system currently includes 
implementations of several metrics needed to conduct software quality 
measurement and to detect design pattern grime within software systems. For the 
measurement of software quality (and specifically for normalizing findings) we 
measure the following metrics: Number of Statements (NOS) 
\cite{lorenz_object-oriented_1994}, Source Lines of Code (SLOC) 
\cite{lorenz_object-oriented_1994}, Number of Fields (NOF) 
\cite{briand_exploring_2000,chidamber_towards_1991,chidamber_metrics_1994}, 
Number of Methods (NOM) \cite{li_object-oriented_1993}, and Number of Classes 
(NC) \cite{goos_using_2001}. For use when detecting Modular Grime, we have 
implemented the following metrics: Afferent Coupling (Ca) 
\cite{martin_design_1994} and Efferent Coupling (Ce) \cite{martin_design_1994} 
at the class level. For use when detecting Class Grime, we have implemented the 
following metrics: Tight Class Cohesion (TCC) \cite{bieman_cohesion_1995} and 
Ratio of Cohesive Interactions (RCI) \cite{briand_measuring_1993} at the class 
level. Finally, for Organizational Grime detection, we have implemented the 
following metrics: Instability (I) \cite{martin_design_1994}, Normalized Main 
Sequence Distance (D') \cite{martin_design_1994}, Common Closure (CC) and Common 
Reuse (CR) (both of these metrics are defined in Section 
\ref{sec:org_grime_tax}) at the pattern and package level.

\subsection{Arc Framework Integration}

\begin{figure}[!tb] \centering 
\includegraphics[width=\textwidth]{arc_images/metrics_integration} 
\caption{Integration of the metrics analysis system with the Arc Framework.} 
\label{fig:metrics_integration} \end{figure}

Figure \ref{fig:metrics_integration} depicts the metrics system integration into 
the Arc Framework and its flow of execution. This flow follows two possible 
routes, the numbers encircled in green, as follows. Both routes start by 1.) 
initializing the ArcContext and the reading of the ArcConfig during Arc system 
initialization. 2.) The process then initializes the \textit{MetricsTool} which 
provides both the \textit{ArcMetricsProvider} and the \textit{MetricsCommand}. 
At this point, the execution can fork. If the system is initializing the data 
model, then 3.a.) the ArcMetricsProvider will construct the Arc metrics 
repository and the Metric definitions associated with it. 4.a.) These values are 
then stored within the data model. If the system is in analysis mode, then 3.b.) 
the MetricsCommand extracts items from 4.b.) the Components section of the data 
model and utilizes the MetricsEngine to calculate metrics. 5.) The MetricsEngine 
using the information provided by a MetricsProfile, the ArcConfig, and the 
components to measure the needed metrics. A MetricsCommand invokes a Metric and 
encapsulates the returned value as a Measure. 6.) These Measures are then added 
to the data model by the MetricsCommand.

\section{Quality Measurement}\label{sec:mqtd_qm} The field of Software Quality 
Assessment has, as described in Chapter \ref{chap:background}, developed several 
descriptive quality models (such as the ISO/IEC 25010 standard). Each of these 
descriptive models comprises a set of characteristics and sub-characteristics. 
Though these characteristics and sub-characteristics define quality concepts, 
they do not define a means of assessment. Thus, model operationalization is a 
critical step in providing pragmatic solutions that can be readily adopted by 
software development organizations in the industry. Further, the deployment of 
operationalized quality models allows for continuous monitoring of the quality 
of an organization's software components.

The connection to higher levels of abstraction helps an organization's 
decision-makers assess potential economic impacts of breakdowns in quality in a 
holistic manner. To facilitate an understanding of quality issues that affect 
decision-makers as well as developers, we focused on the comparison between 
quality models \cite{griffith_industry_2017}. This study led to our 
implementation of the Quamoco quality modeling and assessment approach within 
the SonarQube\texttrademark\ system. SonarQube\texttrademark\'s limitations 
required a shift towards the development of the Arc Framework. In the following 
section, we describe, in detail, the Quamoco architecture, method of assessment, 
and the integration within the Arc Framework.

\subsection{Quamoco Architecture}\label{sec:mqtd_qm_arch} As described in 
Chapter \ref{chap:arc_framework} we have developed a framework to meet the needs 
of our research and more generally the requirements for software measurement via 
an extensible architecture. Additionally, this architecture extends to 
incorporate the Quamoco quality modeling and assessment approach. This 
extension, depicted in Figure \ref{fig:quamoco_integration}, has four key 
components: the 
\textit{QuamocoTool}, the \textit{QuamocoMetricProvider}, the 
\textit{QuamocoCommand}, and the \textit{QuamocoConfig}. The following describes 
the execution of Quamoco by the Arc system.

\begin{figure}[!t] \centering 
\includegraphics[width=\textwidth]{arc_images/quamoco_integration} 
\caption{Integration of the Quamoco quality measurement approach with the Arc 
Framework.} \label{fig:quamoco_integration} \end{figure}

Figure \ref{fig:quamoco_integration} depicts the execution of Quamoco as one of 
two distinct paths, as indicated by the numbers encircled in green, as follows. 
Both paths start by 1.) the initialization of the \textit{QuamocoTool}. At this 
point, the execution is dependent on the current mode of operation of the Arc 
system. 2.a.) During initialization mode, the \textit{QuamocoMetricProvider} 
constructs the required Metrics and containing MetricRepository for the Quamoco 
implementation used in the QuamocoEngine. 3.a.) The QuamocoEngine stores the 
MetricRepository and contained Metrics in the data model. 

The \textit{QuamocoCommand} initializes and operates the QuamocoEngine during 
system analysis mode. 3.b.) In this mode, a local \textit{QuamocoConfig} 
configures the QuamocoEngine used by the QuamocoCommand. 4.) The QuamocoCommand 
extracts Findings (as provided by prior static analysis) and low-level measures 
(acquired during metrics analysis) and provides these to the QuamocoEngine to 
facilitate quality analysis. 5.) The QuamocoEngine, once configured and supplied 
with the necessary Findings and Measures, then loads the applicable QualityModel 
and calculates the system quality (as described in the following sections). 6.) 
Once the calculations are complete, Measures for each quality attribute produced 
by the QuamocoEngine are then stored in the data model by the QuamocoCommand.

\subsection{Quamoco Processing}\label{sec:mqtd_qm_proc} The QuamocoEngine 
utilizes an external definition of a quality model, encoded in XML (possibly 
across multiple files). These files are instances of the Quamoco \mm\, as 
defined by Wagner et al. \cite{wagner_quamoco_2012,wagner_quamoco_2016}. The 
\mm\ , although useful for describing a quality model, provides far more detail 
than necessary to assess the quality of a software system accurately. Therefore 
we extract a reduced-form representation called the \textit{processing graph}.

% \begin{figure}[!tb] 
%   \centering    
% \includegraphics[width=\textwidth]{arc_images/quamoco_nodes}   
% \caption{Quamoco processing graph nodes model.} 
%   \label{fig:quamoco_nodes} 
% \end{figure}

The processing graph is a directed acyclic graph distilled from a 
language-specific combined quality model. The model is processed to form a graph 
composed of four types of nodes, as depicted in Fig. \ref{fig:graph}. 
FactorNodes represent the higher-level abstractions related to quality 
characteristics and sub-characteristics. MeasureNodes correspond to lower-level 
issues (\ie FindBugs rule ME\_ENUM\_FIELD\_SETTER which detects methods within a 
Java\texttrademark\ enum, which sets the value of one of its 
fields\footnote{\url{
http://findbugs.sourceforge.net/bugDescriptions.html\#ME\_ENUM\_FIELD\_SETTER}}) 
applicable to entities found within source code (e.g., types, methods or 
fields). Finding and Value Nodes correspond to static analysis tool rules or 
metric values, respectively.

% \begin{figure}[!tb]
%   \centering
%   \includegraphics[width=\textwidth]{arc_images/quamoco_edges}
%   \caption{Quamoco processing graph edges model.}
%   \label{fig:quamoco_edges}
% \end{figure}

\begin{figure}[!t] \centering 
\includegraphics[width=3.25in]{arc_images/distilled_dag.pdf} 
\caption{Representation of the processing graph.} \label{fig:graph} \end{figure}

Each FactorNode has an attached Evaluator which handles the evaluation of 
afferent (incoming) measures through finding the mean of the normalized value of 
the findings set or value set, or through a weighted sum of afferent factors. 
Similarly, MeasureNodes each have an attached Aggregator applicable to the type 
of aggregation necessary: \textit{union} or \textit{intersection} for finding 
sets (propagated from attached finding nodes or other finding based measures) or 
\textit{mean}, \textit{min}, or \textit{max} for ValueNodes. FindingNodes and 
ValueNodes provide the ability to collect either Findings (for named issues) or 
Values (for named metrics), respectively. Edges connect these different nodes 
and provide the path for aggregation.

Edges between FactorNodes provide the necessary afferent weights (i.e., 
coefficients of source FactorNodes) used to aggregate the values at the 
destination FactorNode. Edges between FactorNodes and MeasureNodes, which convey 
sets of findings, provide a means to normalize the Finding set using an 
associated Normalization Measure and Range. These edges also provide a linearly 
increasing or decreasing function used to constrain the normalized value between 
0.0 and 1.0.

% \begin{figure}[!tb]
%   \centering 
%   \includegraphics[width=\textwidth]{arc_images/quamoco_processors} 
%   \caption{Quamoco processing graph processors model.} 
%   \label{fig:quamoco_processors}
% \end{figure}

\subsection{Collecting Findings}\label{sec:mqtd_qm_find} As shown in Figure 
\ref{fig:quamoco_integration} the QuamocoCommand extracts, from the Arc data 
model, Findings and Measures. A set of Findings provided to each FindingNode 
specific representing the Finding's Rule in the QualityModel. Thus, each 
provided Finding from the data model is added to the processing graph at a 
FindingNode with a matching Rule name and Repository 
name.\subsubsection*{Evaluation of Quality}\label{subsec:qual_eval} The Quamoco 
model evaluates the quality of a system by aggregating the measures and issues 
affecting the system. These values form the lowest level of a Quamoco model 
hierarchy and provide input to the measure level. Each Measure refines another 
measure or is an input to a factor. A factor uses either the combination of 
measures or factors, but not both to compute its value. This value is always in 
the range [0.0, 1.0] and represents the presence of that Factor within the 
software system. On the other hand, Measures pass up the hierarchy sets of 
Findings. Once these Findings reach a factor, they must be normalized into a 
value in the range [0.0, 1.0] representing the presence, in the system, of the 
underlying issue represented by the Finding.

Finding sets are normalized by summing a normalization measure (such as SLOC) 
across the entities (i.e., a method, class, or file) where the Findings occur. 
This sum, reduced by dividing by the system-level summation of the same Metric, 
acts as input to a linear increasing/decreasing function. This function converts 
the cardinality of the Finding set to a value in the range [0.0, 1.0] suitable 
for use by a Factor. 

A Factor that is evaluated by a set of other Factors calculates its value using 
a weighted sum. The weights, assigned to each incoming Factor, derive from that 
Factor's assigned rank. This derivation uses the \textit{Rank-Order Centroid} 
method \cite{barron_decision_1996} and \textit{Swing} approach 
\cite{edwards_smarts_1994}, such that the generated weights then sum to 1.0. The 
model stores the weights along the edges to facilitate a simplified graph 
processing algorithm for quality evaluation.

Quality evaluation occurs through a simple recursive depth-first search based 
algorithm. The algorithm starts at the sink Factor, ``Quality", then requests 
the values for each incoming edge. This process continues recursively requesting 
the values of the source side node for each incoming Factor. When the algorithm 
reaches a measure to factor edge, it either requests the set of findings or the 
set of values from the source (depending on the type of Measure the source side 
is). The recursion stops upon reaching either a FindingNode or ValueNode. The 
values/finding sets are propagated back up the graph. During the propagation 
stage, the algorithm aggregates these values/finding sets as they pass through 
each processing graph node, stopping at the original start node.

\subsubsection*{Publishing Quality Information} Once the processing graph has 
completed the evaluation, the QuamocoCommand extracts and encapsulates 
high-level quality attribute values as Measures in the data model. Thus, the 
data model provides a simple means to access quality information through a 
request for the specific Measure of concern.

\section{Technical Debt Measurement}\label{sec:mqtd_td} The growing 
concern for technical debt and its lasting effects, has prompted the development 
of several methods of estimating a software system's level of technical debt 
\cite{curtis_estimating_2012-1,curtis_estimating_2012,gaudin_evaluate_2009,
letouzey_managing_2012,letouzey_sqale_2012,marinescu_assessing_2012-1,
nugroho_empirical_2011,chin_economics_2010}. To date, there have been few 
studies which evaluate the effect of issues considered technical debt on 
software quality indicators. This relationship is key to understanding software 
disharmonies. First, though, we must have an approach to estimate a system's 
current level of technical debt.

\subsection{Calculating Technical Debt} In prior work 
\cite{griffith_correspondence_2014}, we evaluated the connection between several 
technical debt estimates and a known quality model. We found that of all the 
technical debt estimation approaches evaluated, the CAST method 
\cite{curtis_estimating_2012-1,curtis_estimating_2012} was the most accurate (of 
those methods evaluated) concerning the current definition of technical debt. 
There are potentially more accurate methods available, such as the approach 
proposed by Nugroho et al. \cite{nugroho_empirical_2011}, but without empirical 
data, we opted to use the CAST method.

The CAST approach focuses on estimating the technical debt principal 
(effectively the cost/effort to remediate the underlying issue) using a  static 
analysis based parameterized cost model. Three key parameters guide this model's 
operation: (i) Percent of Finding to be Fixed per Finding Severity Level, (ii) 
Hours to Fix per Finding Severity Level, and (iii) The Cost per Hour per 
Finding. Parameters values are prescribed by Curtis, Sippidi, and Szynkarski 
\cite{curtis_estimating_2012} defining the three models shown in Table 
\ref{table:tde_curtis}.

\begin{table}[t!]
\centering
\caption{Values for models of TDE as proposed by Curtis, Sippidi, and 
Szynkarski\cite{curtis_estimating_2012,griffith_correspondence_2014}.}
\label{table:tde_curtis}

\begin{tabular}{c|cccc} \multicolumn{1}{c}{} & \textbf{Severity} & \textbf{Model 
1} & \textbf{Model 2} & \textbf{Model 3}\tabularnewline \hline Percent of & High 
& 50\% & 100\% & 100\%\tabularnewline Findings & Medium & 25\% & 50\% & 
\textemdash{}\tabularnewline to be Fixed & Low & 10\% & \textemdash{} & 
\textemdash{}\tabularnewline \hline \multirow{8}{*}{Time to Fix} & High & 1 hr & 
2.5 hrs & 10\% \textendash{} 1 hr\tabularnewline &  &  &  & 20\% \textendash{} 2 
hrs\tabularnewline &  &  &  & 40\% \textendash{} 4 hrs\tabularnewline &  &  &  & 
15\% \textendash{} 6 hrs\tabularnewline &  &  &  & 10\% \textendash{} 8 
hrs\tabularnewline &  &  &  & 5\% \textendash{} 16 hrs\tabularnewline & Medium & 
1 hr & 1 hr & \textemdash{}\tabularnewline & Low & 1 hr & \textemdash{} & 
\textemdash{}\tabularnewline \hline Cost to Fix & All & \$75 & \$75 & 
\$75\tabularnewline \end{tabular} \end{table}

The values of the parameters \emph{time to fix} and \emph{cost to fix} calculate 
a monetary value based on the percentage of findings to fix. These values 
combine in the following equation to estimate the Technical Debt principal using 
the values from Table \ref{table:tde_curtis} and the countes of collected 
Findings: 
\begin{eqnarray} 
\label{eqn:tde_curtis} TDE & = & \left(\Sigma 
HS*\%HS*HS_{fix}*HS_{cost}\right)\\ \notag & + & \left(\Sigma 
MS*\%MS*MS_{fix}*MS_{cost}\right)\\ \notag    & + & \left(\Sigma 
LS*\%LS*LS_{fix}*LS_{cost}\right) \end{eqnarray}

\noindent Where $\Sigma HS$, $\Sigma MS$, and $\Sigma LS$ are the counts of 
\emph{high severity}, \emph{medium severity}, and \emph{low severity} 
violations, respectively. The variables $\%HS$, $\%MS$, and $\%LS$ represent the 
percentages of high, medium, and low severity violations intended to be fixed. 
The variables $HS_{fix}$, $MS_{fix}$, and $LS_{fix}$ represent the average time 
(in hours) required to fix per instance of each severity level. Finally, the 
variables $HS_{cost}$, $MS_{cost}$, and $LS_{cost}$ represent the monetary cost 
per hour to perform each fix. 

\subsection{Technical Debt Measurement Architecture}\label{sec:mqtd_td_arch}

\begin{figure}[!tb] \centering 
\includegraphics[width=\textwidth]{arc_images/td_integration} 
\caption{Integration of technical debt measurement system with the Arc 
Framework.} \label{fig:td_integration} \end{figure}

The evaluation of a Software System's Quality and Technical Debt is one of the 
primary motivations of the Arc Framework. Thus, the Arc Framework integrates the 
above method of technical debt estimation. This integration and its flow of 
execution are depicted in Figure \ref{fig:td_integration}. The execution flow, 
the numbers encircled in green, follows two possible paths. Both paths begin 
with 1.) the initialization of the Arc system which then provides an 
\textit{ArcContext} initialized with a \textit{ArcConfig} provided via an 
\textit{ArcConfigProvider}. 2.) Next, the system initializes the TechDebtTool. 
The TechDebtTool provides two major components: the 
\textit{TechDebtMetricProvider} and the \textit{TechDebtCommand}. At this point, 
the execution path forks and depends upon the operational mode of the Arc 
system.

When the Arc system in is the data model initialization mode 3.a.) the 
TechDebtMetricProvider constructs the MetricRepository and Metrics and, 4.a.) 
adds them to the data model. When the Arc system is in the system analysis mode 
3.b.), the TechDebtCommand controls the technical debt analysis. 4.b.) This 
analysis extracts static analysis findings, for the system under analysis, and 
passes this information to the TechDebtEngine. 5.) The TechDebtEngine uses these 
findings, their associated Rule Priorities, and the ArcConfig information to 
calculate the value of the system's technical debt. 6.) The calculated value is 
returned to the TechDebtCommand, wherein it is encapsulated into a Measure and 
added to the data model.

The TechDebtCommand extracts Findings from the Arc data model and provides these 
to the TechDebtEngine. During this process, the Priority of each Rule, to which 
a Finding is associated, is extracted. These priorities partition the findings 
into specific severity groups according to the models in Table 
\ref{table:tde_curtis}. The Rule Priorities are more fine-grained than accounted 
for by the technical debt models. Thus, we map these Priorities to the severity 
levels in the models. This mapping works as follows (priorities on the left of 
the arrow and severity on the right of the arrow): $\{VERY\_HIGH,\, HIGH\} 
\rightarrow HIGH$, $\{MEDIUM\} \rightarrow MEDIUM$ and $\{LOW,\, VERY\_LOW\} 
\rightarrow LOW$.

\begin{figure}[!tb] \centering 
\includegraphics[width=0.75\textwidth]{arc_images/td_strategy} 
\caption{Technical debt calculation model (for CAST method only).} 
\label{fig:td_model} \end{figure}

Figure \ref{fig:td_model} depicts this approach's underlying \mm\ . In this 
model, there are four simple components. The primary component, 
\textit{TechnicalDebtCalcStrategy}, uses a strategy design pattern to provide 
for multiple calculation algorithms. These algorithms implement the operation, 
\verb|calculate(...)|. The \verb|calculate(...)|, when implemented, is provided 
necessary information to estimate technical debt principal through to utilize 
the provided parameters (from the \textit{TDParams} instance). Both TDParams and 
TechnicalDebtCalcStrategy are then implemented in the CAST specific classes: 
\textit{CastTD} and \textit{CastTDParams}, respectively. As noted above and in 
Chapter \ref{chap:background}, there are several alternative approaches to 
estimate technical debt, which can expand our data model using a strategy 
pattern.

\section{Conclusion}\label{sec:mqtd_conclusions} This chapter provides the 
details concerning the measurement of both software quality and technical debt 
necessary for the experiments and case studies found in Chapters 
\ref{chap:ex_grime_and_quality} through \ref{chap:cs_grime_relationships}. This 
chapter further develops the reasoning for the construction of the Arc 
Framework, while also describing the integration of the metrics, quality, and 
technical debt analysis framework components. These components along with those 
defined in Chapters \ref{chap:arc_framework}, \ref{chap:dpd}, \ref{chap:inject}, 
and \ref{chap:detect} implement the central ideas of the method presented in 
Chapter \ref{chap:method} which lays out this research's guiding principles and 
processes.
