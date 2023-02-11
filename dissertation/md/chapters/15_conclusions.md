\chapter{Conclusions and Future Work}\label{chap:conclusions}

\begin{quote}
\centering
\textit{Optimism is an occupational hazard of programming: feedback is the
treatment.}\\--Kent Beck 
\end{quote}

In this dissertation we have detailed the underlying methods to study and extend
our knowledge of the design pattern disharmonies known as design pattern grime.
To facilitate this, we developed a general software artifact disharmony and
issue research process. Following this process we have extended the theoretical
design pattern grime taxonomy to include extensions for both class and
organization grime. From this taxonomy and an initial pilot study involving
design pattern grime \cite{griffith_design_2014}, we further developed the
underlying goals and questions used to guide the remainder of this research.

These initial studies also yielded the initial tooling which was later refined
into the Arc Framework. This framework forms the backbone for collecting the
data from each of the experiments and case studies conducted by following our
research process. As a part of this framework, and using the concepts from the
taxonomy, we developed tools to integrated data from several sources including:
existing issue detection tools such as FindBugs and PMD, Pattern4 pattern
detection tool, software metrics, quality and technical debt analysis, and
design pattern grime detection. We conducted several experiments and case
studies using generated design patterns and those collected from open source
software systems written in the Java\texttrademark programming language.

% Need an additional paragraph for the results and impacts

The remainder of this chapter is organized as follows: Section
\ref{sec:evidence_relate} synthesizes our results and their relations to
existing work concerning design pattern grime. Section \ref{sec:result_impact}
describes the impact of the results and methods developed herein to researchers
and practitioners. Section \ref{sec:result_limit} summarizes the limitations of
the results of the experiments and case studies. Finally, Section
\ref{sec:future} describes the immediate future work and extensions we are
proposing for this research.

\section{Relation to Existing Evidence}\label{sec:evidence_relate}
% Describes the contribution of the study in the context of earlier experiments

\section{Impact}\label{sec:result_impact}
% Identifies the most important findings

\section{Limitations}\label{sec:result_limit}
% Idntifies main limitations of approach i.e. circumstances when the expected benefits will not be delivered

\section{Future Work}\label{sec:future}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=\textwidth]{conclude/future_work}
 \caption{Dimensions of future work.}
 \label{fig:future_work}
\end{figure}

In the future we plan to extend this work along four dimensions, as depicted in
Figure \ref{fig:future_work}. The first in in the domain of Software Quality
Analytics. Though, we have developed an implementation of the Quamoco quality
measurement framework, as described in Chapter \ref{chap:quality} several
extensions are needed to facilitate continued research. We need to extend this
by developing community vetted models for languages beyond Java\texttrademark.
We also intend to extend the Quamoco framework itself to be capable of capturing
other known quality modelling techniques. We intend to improve the capabilities
of Quamoco through research into multi-level calibration techniques. Finally, we
intend to resolve our current limitations in technical debt measurement by
developing implementations of current and proposed techniques.

The second dimension is that of design pattern analysis. Currently we are
utilizing the SSA method implemented in the tool Pattern4 for design pattern
detection. Our goal is to re-implement this technique using our underlying Arc
Data Model, without relying on language specific techniques, in order to provide
a language agnostic approach to design pattern detection. We also intend to
extend our data cleansing techniques to incorporate validation of patterns using
specifications provided in RBML and Elemental Design Patterns
\cite{smith_spqr:_2003}.  The goal of this is to not only improve the detection
results, but to also extend the number of design patterns capable of being
detected.

The third dimension is that of Design Disharmonies. Here we are concerned
not only with the analysis of grime, but also further exploring Design Pattern Rot, and
the relations between these and other well known disharmonies (\ie code smells,
antipatterns, and modularity violations). This research has the goal of
improving detection, knowledge, and prediction of their effects on quality.
Finally, we intend to develop the techniques to remediate these issues via
refactoring.