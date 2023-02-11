\chapter{Design Pattern Grime Detection}\label{chap:detect}

\begin{quote}
\centering
\textit{Up to a point, it is better to just let the snags [bugs] be there than
to spend such time in design that there are none.}\\--Alan M. Turing
\end{quote}

\section{Introduction}
Design pattern grime research, up to now, has been stagnated due to a limitation 
of manual identification processes. This has further limited our ability to 
understand the effects of grime within the context of software systems, and has 
become a significant issue worthy of study in and of itself. Similarly, research 
into other design disharmonies, such as code smells and antipatterns, has also 
suffered a similar problem. For these disharmonies the problem of automated 
detection has been addressed through a variety of methods 
\cite{miceli_metric_1999,van_emden_java_2002,hallal_antipattern-based_2004,
marinescu_detection_2004,girba_identifying_2004,rapu_using_2004,
walter_multi-criteria_2005,mihancea_towards_2005,trifu_diagnosing_2005,
moha_automatic_2006,salehie_metric-based_2006,girba_using_2007,
fokaefs_jdeodorant:_2007,van_rompaey_detection_2007,moha_domain_2008,
tsantalis_jdeodorant:_2008,garcia_identifying_2009,llano_uml_2009,
khomh_bayesian_2009,roperia_jsmell:_2009,moha_decor:_2010,jancke_smell_2010,
luo_ontological_2010,kessentini_deviance_2010,kessentini_design_2011,
kessentini_search-based_2011,kessentini_design_2011-1,wong_detecting_2011,
mathur_java_2011,polasek_extended_2012,fontana_automatic_2012,liu_schedule_2012,
mahouachi_new_2012}.
This chapter details efforts to address this problem for design
pattern grime through the adoption of techniques known to work for other design 
disharmonies.

These approaches use the properties and measures of the components of a system 
understudy to formulate a hierarchy of filters used to identify artifacts 
afflicted with design disharmonies. Our approach implements the concepts from 
both the Detection Strategy \cite{marinescu_detection_2004} and Decor 
\cite{moha_decor:_2010} approaches, along with some new operators and filtering 
techniques necessary to facilitate the detection of grime.

This chapter is organized as follows. Section \ref{sec:detect_frame} describes 
the underlying architecture of the detection framework. Section 
\ref{sec:grime_detect} describes how the detection framework is used to detect 
the different forms of grime. Section \ref{sec:grime_integration} describes the 
integration of the detection system into the Arc Framework. Finally, Section 
\ref{grime_conclude} concludes this chapter.

\section{Detection Framework}\label{sec:detect_frame}
This approach is based on the \textit{Detection Strategy} concept proposed by 
Marinescu \cite{marinescu_detection_2004}. In this approach, disharmony 
detectors filter source artifacts using properties such as metrics and 
architectural changes. The basic approach in developing these filters follows a 
top-down decomposition of the disharmony into the properties which can be 
directly measured or provided through surrogate metrics. These individual 
filters are then combined to form a composite filter or hierarchy of composite 
filters, which will correctly identify artifacts afflicted with the disharmony 
in question.

\begin{figure}[!tb]
    \centering
    \includegraphics[width=\textwidth]{arc_images/detection_cd}
    \caption{Disharmony detection strategies \mm .}
    \label{fig:detection_mm}
\end{figure}

Marinescu \cite{marinescu_detection_2004} and, later, Moha \etal
\cite{moha_decor:_2010} identified capable of detecting both AntiPatterns and 
Code Smells. We have further developed additional filter types to be used 
specifically in the context of multiple versions of pattern instances, as needed 
for detecting design pattern grime. We have defined a \mm\ for describing 
detection strategies, as depicted in Figure \ref{fig:detection_mm}.

The model, as shown, has two main components: \textit{DetectionStrategy} and 
\textit{Filter}. A \textit{DetectionStrategy} has a name, a description, and a
\textit{Type} representing the type of Measurable (c.f. \ref{sec:data_model}) 
that the detection strategy can be applied to, and a single filter representing 
the highest level in the composite filter framework. The operation 
\textit{detect(\ldots)} calls the \textit{filter(\ldots)} operation on the 
contained filter for each type
appropriate for the filter and returns the filtered Measurables.

The \textit{Filter} component provides the base class for all the
specializations used to compose a detection strategy filter hierarchy. There are 
currently three subtypes of \textit{Filter}: \textit{ConditionalFilter}, 
\textit{MarginalFilter}, and \textit{CompositeFilter}. The 
\textit{ConditionalFilter} filters a specific type of Measurable via a provided 
condition. Thus, the result set is composed of all Measurables which meet the 
condition imposed. The following paragraphs describe the remaining two filters.

\textit{MarginalFilter}(s) filter by identifying one extremity of the result
set. Each \textit{MarginalFilter} defines the metric, to perform the
filtering, and value, to threshold the measured results. The
\textit{StatisticalFilter} is a special form of the \textit{MarginalFilter}
which utilizes a statistical distribution of the measured values for the
provided metric. A \textit{StatThresholds} value to determine the statistical 
operation used to calculate the actual threshold value for filtering metric 
measures. A \textit{Direction} selects which side of the threshold will be 
filtered out.

The \textit{SemanticalFilter} is a specialization of \textit{MarginalFilter}
which uses a \textit{SemanticThresholds} value to determine the threshold value. 
This filter is divided into two further specializations:
(i) \textit{RelativeSemanticalFilter} and (ii) 
\textit{AbsoluteSemanticalFilter}. The \textit{RelativeSemanticalFilter} uses 
the threshold value to indicate the number of items to be retained, and uses 
either the \textit{TopValues} or \textit{BottomValues} literals from 
\textit{Direction} to make this decision. Items within the group indicated by 
the \textit{Direction} is the returned result set. The
\textit{AbsoluteSemanticalFilter} uses its threshold value as a threshold which 
depending on the direction (either \textit{HigherThan} or \textit{LowerThan}) 
will select those values returned in the result set.

The \textit{CompositeFilter} provides the ability to compose the results from 
multiple filters into a single result set. This is done using one of three set 
operations: (i) \textit{union}, (ii) \textit{intersect}, or (iii) \textit{set 
difference}. These operators allow for the development of a refined filter 
hierarchy with the capability to articulate a composite rule identifying a 
disharmony. The \textit{CompositeFilter} is divided into two specializations: 
(i) \textit{HistoricalFilter} and (ii) \textit{IntervalFilter}. The 
\textit{HistoricalFilter} is composed of a set of filters applied across 
multiple versions of a given component under study. Thus, it requires the 
following additional parameters: (i) the metric to compare between versions, 
(ii) the number of versions to compare, and (iii) the trend to consider (\ie 
decreasing or increasing). The \textit{IntervalFilter} is a specialization of 
\textit{CompositeFilter} composed of two \textit{MarginalFilter}(s) with 
opposing directions. This filter constructs a range of acceptable values, 
filtering out those artifacts with measures inside the defined range.

\section{Grime Detection}\label{sec:grime_detect}
The \mm\ defined in Section \ref{sec:detect_frame} provides the basis for 
developing a DSL. The benefits of such a DSL include the externalization of 
detection strategy definitions outside of the framework and the ability to 
introduce new detection strategies as needed. Thus, we implemented a Groovy DSL 
for detection strategies. This DSL uses the Groovy programming language and the 
detection strategy \mm to defined detection strategies. Appendix \ref{app:ds} 
contains the detection strategy definitions for each grime subtype.

\begin{figure}[!tb]
	\centering
	\begin{lstlisting}[language=java]
			detection_strategy type: 'PATTERN' {
				intersect {
					conditional cond: {(m1, m2) in 'Internal'}
					conditional cond: {(r1, r2) in 'Direct'}
					conditional cond: {r1.attr = r2.attr}
					historical versions: 2, metric: TCC(c), op: decreases
					conditional cond: {c is PatternInstance}
				}
			}
	\end{lstlisting}
	\caption{Example detection strategy for DIPG.}
	\label{fig:ds_cg_ex}
\end{figure}

Figure \ref{fig:ds_cg_ex} illustrates an example of a detection strategy. This 
example begins by defining a detection strategy with the 
\textit{detection\_strategy} keyword. Following this keyword is the definition 
of the type, using the \textit{type:} indicator and a defined name (one of the 
entries in the Type enumeration in Figure \ref{fig:detection_mm}). The strategy 
defines a block, denoted by curly braces, defining the root level filter. 

In the example, the root-level filter is a \textit{CompositeFilter} using the 
\textit{intersect} operator which collects the intersection of the results 
returned by the inner filters. The lines contained within the \textit{intersect} 
filter are each a simpler non-composite filter (with the exception of the 
\textit{union} \textit{CompositeFilter}). The inner filters derive from the 
logical definition for the DIPG class grime type, as defined in Section 
\ref{sec:class_grime_tax}. The following section describes the integration of 
this approach into the Arc framework.

\section{Arc Framework Integration}\label{sec:grime_integration}
\begin{figure}[!tb]
    \centering
    \includegraphics[width=0.75\textwidth]{arc_images/detection_integration}
    \caption{Grime Detection integration with the Arc Framework.}
    \label{fig:gd_integrate}
\end{figure}

To make the detection strategy framework useful, it needs to be integrated into 
the Arc Framework, as depicted in Figure \ref{fig:gd_integrate}. The execution 
of this integration follows the execution path depicted by the numbers encircled 
in green, as follows: 1.) When the Arc System is initialized, it initializes the 
\textit{GrimeDetectTool}, which provides the framework with and instance of the 
\textit{GrimeDetectCommand}. 2.) The \textit{GrimeDetectCommand} performs two 
functions: (i) it controls the operation of the Grime Detector and (ii) provides 
access to the ArcDb via an injected DataModelMediator. 3.) The 
\textit{GrimeDetectCommand} executes the \textit{GrimeDetector} which utilizes 
the detection strategy framework, described in Section \ref{sec:detect_frame}.
4.) The \textit{GrimeDetector} reads in the externally defined 
\textit{DetectionStrategy} (c.f. \ref{sec:grime_detect} and Appendix
\ref{app:ds}) for each grime type across applicable pattern instances. 5.) As 
instances of design pattern grime are detected, each instance is provided to the 
\textit{GrimeDetectCommand} to be encoded into Findings and added to the 
Findings Table of the ArcDb.

\section{Conclusion}\label{grime_conclude}
This chapter defined our approach for the automated detection of design pattern 
grime. This approach uses our implementation of the Detection Strategy concept 
of Marinescu \cite{marinescu_detection_2004} and Moha \etal 
\cite{moha_decor:_2010} as realized via a \mm\ and Groovy DSL. We further 
described the use of this DSL through an example for the DIPG form of class 
grime. Finally, we describe the integration of this system into the Arc 
experimentation framework making the case studies defined in Chapters 
\ref{chap:cs_ex_validation}--\ref{chap:cs_grime_relationships} possible.
