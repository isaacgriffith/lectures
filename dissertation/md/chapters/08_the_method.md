\chapter{Putting It All Together: The Method}\label{chap:method}

\begin{quote} \centering \textit{Truth can only be found in one place: the 
code.}\\--Robert C. Martin \end{quote} 

In the field of software engineering, there is an incredible rate of change in 
the methods and tools used, leading to a call for more experimentation in 
software engineering \cite{wohlin_experimentation_2012}. Furthermore, this 
expediency of change has led to the proposal of an ever-increasing number of 
issues purporting to affect the quality of software. However, these claims are 
typically only supported by anecdotal data. The lack of empirical support 
underlying such claims leads to a need to gain more in-depth insight into the 
nature of these phenomena.  To accomplish this, a process which provides the 
logical and scientific methods is required.

The development of such a generalized process would be too broad to be useful 
due to the numerous and profoundly different contexts found within the software 
engineering field. Thus, when considering the nature of design disharmonies and 
other software issues, we have opted to constrain this approach to the context 
of the software itself. Here we consider only the underlying source code, design 
documents, build files, and other artifacts that comprise a software system.

Supporting this process are the frameworks and techniques documented in Chapters 
\ref{chap:dpd}--\ref{chap:detect}. The remainder of this chapter is organized as 
follows: Section \ref{sec:aspects_study} describes the aspects of software 
engineering to study in both isolation and within live systems. Section 
\ref{sec:general_method} describes the general method and its application. 
Section \ref{sec:method_conclude} concludes with a summary and the implications 
of this method on further study of design disharmonies.

\section{Aspects to Study}\label{sec:aspects_study}

\begin{figure}[!tb] 
\centering \includegraphics[width=\textwidth]{method_images/to_study} 
\caption{Software engineering phenomena aspects of study.} \label{fig:to_study} 
\end{figure}

%%%% Description of the fig:to_study

The goal of this process is to increase our understanding of software 
engineering phenomena. Before describing this method, we first describe the 
aspects of the phenomena we wish to study and the phenomena's observational 
context. We consider two main contexts of study, as depicted in Figure 
\ref{fig:to_study}: (i) In Isolation (corresponding to \textit{in vitro} 
studies) and (ii) In System (corresponding to \textit{in vivo} studies). These 
contexts provide multiple lenses through which to study such software 
engineering phenomena and are analogous to the study of biological phenomena. 
Biological phenomena such as pathogens are studied both in isolation in larger 
biological systems such as the human body.

In the case of the phenomena in isolation, we are concerned with the following 
four aspects, as depicted in Figure \ref{fig:to_study}: (i) Definition, (ii) 
Effects, (iii) Detection, and (iv) Correction. In the case of the phenomena in 
system, we are concerned with the following five aspects, as depicted in Figure 
\ref{fig:to_study}: (i) Relations, (ii) Effects, (iii) Evolution, (iv) 
Correction and (iv) Detection. The goals of each of these aspects in their 
respective context are as follows:

\begin{itemize}
\item \textit{Definition:} The goal is to explore the connections between the 
phenomena studied and the greater body of software engineering knowledge. This 
connection relates well-known concepts such as design principles, metrics, and 
quality within an overarching logically consistent framework for the phenomena. 
This framework results in the development of a community or research-driven 
taxonomy of the phenomena and its subtypes. 

\item \textit{Effects:} The goal is the evaluation of the effects that a 
manifestation of the phenomena within software artifacts has on the developed 
product. Such effects may direct, such as changes to the structure or behavior, 
or indirect, such as changes to quality attributes. 

\begin{itemize} 
\item \textbf{In Isolation:} The goal, in isolation, is the evaluation of the 
causal relationship between the manifestation of the phenomena and the change 
this manifestation has on system properties such as software product quality 
attributes.
 
\item \textbf{In System:} The goal, in system, is to observe the changes 
explored in isolation, over time, and to relate these observations to the 
effects of observed phenomena. 
\end{itemize}

\item \textit{Detection:} The goal of detection is to develop techniques by 
which one may identify instances of the phenomena in an automated or 
semi-automated way. 

\begin{itemize}
\item \textbf{In Isolation:} The goal, in isolation, is to define initial 
detection capabilities based upon the theoretical framework, from the 
definitional aspect, in conjunction with knowledge of the effects of the 
phenomena. 

\item \textbf{In System:} The goal, in system, is the improvement of the 
efficiency and accuracy of detection technique or the automated generation of 
improved detection strategies based on the evolving understanding of the 
phenomena under study. 
\end{itemize}

\item \textit{Correction:} The goal is the identification of refactoring 
combinations or other techniques (from here on called \textit{correction 
strategies}) which remediate instances of the phenomena and mitigate its effects 
on the overall software system. 

\begin{itemize} 
\item \textbf{In Isolation:} The goal, in isolation, is the initial 
identification of correction strategies that will remediate instances of the 
phenomena at various levels of severity.

\item \textbf{In System:} The goal, in system, is the improvement of initial 
correction strategy efficiency and accuracy through automated 
generation/improvement techniques. Such techniques may utilize exiting 
correction strategies or generate new ones based on the evolving understanding 
of the phenomena under study.
\end{itemize}

\item \textit{Relations:} This aspect focuses on the exploration of 
relationships between subtypes of the phenomena and relationships to other types 
of software engineering phenomena. The goals, in system, are as follows: (i) to 
further develop the descriptive framework, (ii) to develop a notion of severity, 
and (iii)  to understand relative priorities between phenomena. 

\item \textit{Evolution:} This aspect focuses on how instances of the phenomena 
change over time. The goals, in system, are as follows: (i) To understand how 
software items are affected due to the accumulation of the phenomena over time 
and (ii) To use knowledge accumulation to 
develop an understanding of the susceptibility of the types of artifacts 
affected and of the rarity of such phenomena occurring.

\end{itemize}

\section{The Process}\label{sec:general_method}

Having described the aspects, we are concerned with, the following describes a 
general process to study software engineering phenomena. This approach guides 
this dissertation and is based on the methods and techniques from Empirical 
Software Engineering, as described by Wohlin \etal 
\cite{wohlin_experimentation_2012}, Juristo and Moreno 
\cite{juristo_basics_2001}, and Runeson \etal \cite{runeson_case_2012}. 

We have developed a six-phase process forming the basic philosophy to guide the 
development of experiments and case studies to further our understanding of 
design disharmonies. This process, depicted in Figure \ref{fig:method_process}, 
is divided into four sections: ``\textit{in vitro} Experimentation'', 
``Bridge'', ``\textit{in vivo} Case Studies'', and ``Bridge''. Although 
\textit{in vitro} and \textit{in vivo} approaches are not new in empirical 
software engineering research, the definition of an approach that prescribes a 
method to bridge these two concepts is novel. We consider this last phase to be 
the one with the most impact on both researchers and practitioners. 
Nevertheless, we have yet to complete all the necessary studies to gather the 
data needed to begin the last phase. Thus, we have grayed out the last phase in 
Figure \ref{fig:method_process}, as we leave this to future work. The following 
describes this process in detail.

\begin{figure}[!tb] \centering 
\includegraphics[width=0.75\textwidth]{method_images/method} \vskip1em 
\caption{The methodological process for empirical research concerning software 
artifacts.}\label{fig:method_process} \end{figure}

Central to the application of this process is the utilization of the Arc 
Framework, as detailed in Chapter \ref{chap:arc_framework}. Arc provides, as 
depicted in Figure \ref{fig:method_process}, an internal experience database 
surrounded by the hexagonal barrier with meter icons, we call this the core. The 
core represents the data collection process for each phase, in which the results 
of executed workflows are collected and stored in the database. Automated data 
collection exists for each phase, though the entire process itself is not 
automated, which is appropriate, as each phase is composed of multiple studies, 
requiring a period of refinement between phases. This refinement allows for the 
use of prior phase results and the evolution of the process.

\subsection{\textit{In Vitro} Experimentation} The first section of this process 
is based on \textit{in vitro} experimentation. Principles of experimental design 
(as described by Wohlin \etal \cite{wohlin_experimentation_2012} and Juristo and 
Moreno \cite{juristo_basics_2001}) in concert with the results of prior studies 
and insight of the researchers guide the phases of this section. This section 
contains Phases 1 and 2, described in the following.

\paragraph*{Phase 1: Meta-Studies and Experiential Studies.} Phase 1 comprises 
the initial examination of the phenomena of concern, through a combination of 
several studies. The initial study focuses on a full literature review. Such 
reviews may be formal or informal meta-studies such as Systematic Literature 
Reviews (SLR) and mapping studies. These studies result in the development of an 
initial set of guiding questions and research goals and an initial theoretical 
framework.

The initial goals and questions, extracted from identified gaps in current 
knowledge, are refined using the GQM approach, central to the entire method. 
Following the GQM approach, researchers use the questions to develop a set of 
metrics (as indicated by the meter icons in Figure \ref{fig:method_process}). 
Finally, the researchers store the results (literature review results and 
refined GQM) in the experience database (via the Arc Framework) for later 
analysis and consultation.

The development of theoretical frameworks, e.g., taxonomies or ontologies of the 
phenomena, should be developed based on existing knowledge of the phenomena and 
their relationship to existing software engineering knowledge, through a 
coherent, logical structure. A consistent structure is necessary if the 
framework is to be the basis for the development/evaluation of tools used to 
detect instances of the phenomena. Additionally, these theoretical frameworks 
are subject to validation by the research and practitioner communities.

Replication or pilot studies provide the necessary validation and experience 
with the theoretical models. These studies have the following goals: (i) to 
provide experience with current processes, tools, and methods, (ii) to identify 
issues such tools, processes, and methods, (iii) to validate prior research in 
new contexts, and (iv) to validate the theoretical frameworks derived from prior 
meta-studies. The following provides a detailed overview of the inner workings 
of this phase.

\begin{figure}[!tb] \centering 
\includegraphics[width=.75\textwidth]{method_images/phase01} \caption{Phase 1 
overview.} \label{fig:phase1_overview}  \end{figure}

%%%%% Phase 1 Overview

Figure \ref{fig:phase1_overview} depicts the high-level overview of Phase 1. 
This phase has three basic steps, as indicated by the numbers encircled in 
green: 1.) Initially conduct a meta-study such as an SLR or Mapping Study to 
gather an understanding of the current research. The goal is the development of 
both a theoretical framework defining the phenomena and the development of an 
initial GQM hierarchy based on the current gaps in research. 2.) Refine the GQM 
hierarchy through initial studies, such as community surveys (within both the 
industry and research communities) and pilot studies. 3.) The study results 
should lead to a finalized theoretical framework and GQM hierarchy. Furthermore, 
this phase results in an initial instrumentation and setup of methods used in 
subsequent phases. If the researchers elected to complete pilot studies, then 
exemplary instances of the phenomena should be collected for further 
examination. The remainder of this section details the two subsections of this 
phase.

%%%%%

%%%%% Phase 1a. In Detail

Figure \ref{fig:phase1a_details} depicts the meta-study process. This process 
follows the sequence indicated by the numbers encircled in green, as follows. 
1.) There are two possible paths (though there are other study types and less 
formal approaches): (i) SLR and (ii) Mapping Studies. 2.) Both study types 
initiate a GQM process to formulate the goals, questions, and metrics, and 
defining the study GQM hierarchy. 3.) The constructed GQM hierarchy guides the 
studies per the guidelines of Wohlin \etal \cite{wohlin_experimentation_2012}. 
4.) These guidelines inform the query protocols defined for the collection of 
primary studies and the inclusion and exclusion criteria defined to filter the 
primary studies. Secondary studies are collected using the snowballing technique 
(tracing back from initial studies to identify other pertinent studies through 
references). The combined process of collecting primary and secondary studies 
continues until the set of new studies found is empty. 5.) Researchers refine 
the collected studies to a final set used during data analysis. 6.) The data 
analysis serves to answer the questions defined in the study's GQM hierarchy. 
7.) The results of this analysis refine the synthesized theoretical framework 
and the initial GQM hierarchy for use in subsequent phases.

\begin{figure}[!tb] \centering 
\includegraphics[width=\textwidth]{method_images/phase01a} \caption{Phase 1 
Meta-Studies details.} \label{fig:phase1a_details}  \end{figure}

%%%%%

\begin{figure}[!tb] \centering 
\includegraphics[width=\textwidth]{method_images/phase01b} \caption{Phase 1 
Experiencial Studies details.} \label{fig:phase1b_details}  \end{figure}

%%%%% Phase 1b In Detail

Figure \ref{fig:phase1b_details} depicts the details of conducting the 
experiential studies. This process follows the sequence indicated by the numbers 
encircled in green, as shown: 1.) are the two paths previously mentioned: (i) 
Surveys and (ii) Pilot or Replication Studies. 2.) In both cases, the GQM 
process formulates the goals of the study into a GQM hierarchy. 3.) This 
hierarchy guides the study following the guidelines of Wohlin \etal 
\cite{wohlin_experimentation_2012}. 4.) For either study type, a randomization 
method selects the experimental subjects, and the experiment conducted. 5.) 
During execution, the instruments (such as the survey itself or metrics tools) 
collect data. 6.) The results of the data collection process are analyzed to 
answer the questions initially posed. 7.) The results are used in the following 
ways. First, the results refine the overarching GQM hierarchy and theoretical 
frameworks. Second, the data collected provides example instances of the 
phenomena for further study. Finally, the process of completing these studies 
yields the initial tooling/instrumentation needed to conduct further studies.

%%%%%

Phase 1 studies culminated in the development of both the background and 
literature review (found in Chapter \ref{chap:background}) and in the 
development of the extended grime taxonomy (found in Chapter 
\ref{chap:taxonomies}). Furthermore, we conducted a pilot study based on this 
foundational knowledge \cite{griffith_design_2014} to validate our initial Class 
Grime taxonomy. The combined results of these initial works are documented in 
the current grime taxonomy found in Chapter \ref{chap:taxonomies} and the GQM 
hierarchy found in Chapter \ref{chap:intro} and further developed in Chapters 
\ref{chap:taxonomies}--\ref{chap:cs_grime_relationships}.

\paragraph*{Phase 2: Injection Experiments.} This phase begins with the review 
and refinement of the GQM hierarchy developed as a result of Phase 1. This 
phase's goal is to develop a set of experiments, guided by the GQM hierarchy and 
based on the injection process, to study the effects of these phenomena. The 
experiments evaluate the effects on instances of the phenomena injected via 
Injection Strategies. These Injection Strategies derive from the Phase 1 
framework describing the phenomena and are central to the experiments. The 
combination of these injection strategies and the operationalization of metrics 
defined in the GQM hierarchy form the method and instrumentation needed to 
support the experiments performed in this phase.

The experiments execute after the refinement of the experimental methods, and 
the initial setup of instrumentation. The goal of these experiments is to 
examine causal relationships between selected measures and that the phenomena 
under study. Examining these relationships allows us to develop a theoretical 
basis upon which later studies can build. Regardless of whether the results are 
positive or negative, the system stores the results within the experience 
database for later use.

\begin{figure}[!tb] \centering 
\includegraphics[width=\textwidth]{method_images/phase02} \caption{Phase 2 
details.} \label{fig:phase2_details}  \end{figure}

%%%%% Phase 2 in detail

Figure \ref{fig:phase2_details} depicts the details of conducting the Phase 2 
experiments. This process follows the sequence indicated by the numbers 
encircled in green, as follows: 1.) Resulting from Phase 1 experiential studies 
is a collection of example instances of the phenomena. 2.) These examples, 
combined with the theoretical framework, allow researchers to distill Injection 
Strategies describing the phenomena. These injection strategies generate 
instances of the phenomena as part of a process akin to the growing of cultures 
in pathological studies. This process allows for the investigation into the 
effects the investigated phenomena have on software systems. 3.) The result of 
this is a collection of Injection Strategies used during the data collection 
process of the experiments. 4.) Phase 2 experiments subdivide into three 
specific types: (i) Effects experiments, (ii) Detection experiments, and (iii) 
Correction experiments. The following further describes these experiments.

Each of the following experiments explores a specific facet of the phenomena in 
order to gain a complete understanding. Effects experiments establish the causal 
relationships between the manifestation of the phenomena and the effect it has 
on measures such as software quality. The Detection experiments establish the 
accuracy and effectiveness of proposed Detection Strategies on the detection of 
injected instances of the phenomena. These experiments also calibrate Detection 
Strategies, ensuring that the broadest variation of instances can be detected. 
Correction experiments define and establish the effectiveness of correction 
strategies concerning the mitigation of injected instances of the phenomena. 
This phase continues with the execution of the experiments selected.

5.) Each of these experiment types starts with the refinement of their 
respective sections of Phase 1 derived GQM hierarchy. 6.) Following this 
refinement, the study designs follow the guidance of Wohlin \etal 
\cite{wohlin_experimentation_2012}. 7.) The first process, within the 
experiment, is the selection of experimental subjects. Here, entities that are 
typically affected by the phenomena are either randomly selected from existing 
systems or generated via a randomized algorithmic process. 8.) Following 
selection, a refinement of the instrumentation used in Phase 1 experiments 
commences, followed by the execution of the data collection process. 9.) The 
data collected is then analyzed to answer the questions. 10.) These results, 
along with the generated detection strategies and correction, are recorded.

%%%%%

 Chapters \ref{chap:ex_grime_and_quality} and \ref{chap:ex_grime_and_td} 
describe out Phase 2. These studies evaluate the effects of design pattern grime 
on the measured software product quality (c.f. \ref{sec:qual_eval}) and 
technical debt principal (c.f. \ref{sec:tech_debt}) of generated design pattern 
instances (c.f. \ref{sec:dp_gen}). These studies use the software injection 
process detailed in Chapter \ref{chap:inject}. The results of these studies form 
the basis for understanding the relationship between grime, quality and 
technical debt, and the basis for the verification experiments, case studies, 
and evolutionary studies detailed in the following subsections.

\subsection{Bridge: \textit{In Vitro} to \textit{In Vivo}} The knowledge gained 
from experimentation provides a capability for causal reasoning, but it is not 
without limitations. Specifically, this experimental approach relies on the 
analysis of injected instances of software phenomena. Such an approach precludes 
the capability to observe the effects of ``wild'' instances found in live 
software systems. This capability, On the other hand, is inherent in case 
studies and longitudinal studies. Although, these studies typically preclude the 
ability for causal reasoning. Thus, a means by which we can bridge the gap 
between a strong foundation provided through experimentation and the insights 
gained via observational field studies are needed, leading to a combined form of 
study we call \textit{Verification Experiments}.

\textit{Verification Experiments} are experimental case studies conducted to 
validate the results of Effects, Inject, Correction, and Detection experiments 
within the context of real software systems. The key to this is the controlled 
use of software injection within real software systems allowing for the 
validation of the injection process itself. This approach provides an 
intermediate layer connecting the case studies of Phase 4 with the experiments 
of Phase 2. Phase 3, the single phase within this section, embodies the 
intermediate layer.

\paragraph*{Phase 3: Verification Experiments.} In this phase, we connect the 
approach used in the \textit{in vitro} experiments with the observational nature 
of the \textit{in vivo} case studies. There are two goals to this process. The 
first is to verify that the injection process works as expected (i.e., that it 
correctly injects the issues/items of concern). Secondly, this process verifies 
the accuracy of the injection process, such that injected instances are similar 
to those observed.

\begin{figure}[!tb] \centering 
\includegraphics[width=\textwidth]{method_images/phase03} \caption{Phase 3 
details.} \label{fig:phase3_details}  \end{figure}

%%%%% Phase 3 Details

Figure \ref{fig:phase3_details} depicts the details of conducting Phase 3 
verification experiments. This process follows the sequence indicated by the 
numbers encircled in green, as follows. 1.) There are two main 
verification experiments of concern: (i) Effects Verification and (ii) 
Correction Strategy Verification. 2.) Both experiment types begin with a
refinement of the respective section of the GQM hierarchy (from Phase 1). 3.) 
Following this refinement, the study is designed following the guidance of 
Wohlin \etal \cite{wohlin_experimentation_2012} and Runeson \etal 
\cite{runeson_case_2012}. 4.) Each study type begins with a project selection 
process, based on a rigorously defined case selection criteria. 5.) Detection 
strategies are executed across the selected projects to identify pairs of 
subsequent versions where the phenomena manifest. For the Effects Verification 
study, potential experimental subjects are those artifacts appearing in each 
version wherein the latter project contains the artifact afflicted. For the 
Correction Strategy Verification, potential experimental subjects are those 
artifacts appearing in each version wherein the former project contains the 
artifacts afflicted. The selection process then randomly selects from those 
identified pairs. 6.) When selection completed, the data collection process 
begins.

The data collection process begins with the creation of two data sets. The first 
data set marked (A), contains the natural evolution of the entities. That is, it 
contains the unmodified pairs of data. The second data set marked (B) contains 
the original starting version of the artifacts, and a version artificially 
evolved using either an injection or correction strategy, depending on whether 
it is an injection or correction verification experiment, respectively. Upon 
data set construction, the instrumentation measures metrics (defined by the GQM) 
across the data sets, collecting data necessary to answer the GQM questions. 7.) 
After data collection completes, the results are analyzed to compare the 
differences in measurements, per pair, between the natural evolution and 
artificial evolution due to the application of injection or correction 
strategies. 8.) The system stores the results to the experience database. 
Research then use the analysis results to improve the injection and correction 
strategies.

%%%%%

Following this process, we conduct a verification study to validate that the 
observed effects of injected grime on software quality and technical debt 
principal (as documented in Chapters \ref{chap:ex_grime_and_quality} and 
\ref{chap:ex_grime_and_td}) match the effects we observed due to ``wild'' 
examples of grime found in open source Java\texttrademark\ software systems. 
This study is documented in Chapter \ref{chap:cs_ex_validation}.

\subsection{\textit{In Vivo} Field Studies} The goal of the \textit{in vitro} 
experiments were to form the underlying foundational knowledge of the phenomena. 
This foundational knowledge expands, through \textit{In vivo} studies, by 
observation of afflicted software components in live systems. Specifically, we 
wish to see how the phenomena and the knowledge gained in Phase 1 and 2 unfolds 
in actual software engineering contexts. This section consists of Phases 4 and 
5.

\paragraph*{Phase 4: Case Studies.} In Phase 4, case studies provide a further 
understanding of the nature of the selected phenomenon. These studies provide 
the capability to observe the phenomena in multiple contexts, domains, and 
environments. Contexts to consider are the software type, i.e., open-source, 
industry, or governmental (or military), or the implementation language. 
Software domains may include games, business applications, operating systems, 
\etc\ Operating environments of the software may include, but are not limited 
to, cloud-based, desktop, and mobile environments. The more comprehensive a 
study is, the vaster the knowledge gained from it while reducing threats to 
external and conclusion validity. Additionally, case study methods provide the 
capability to gain an understanding of the phenomena, which is impossible to 
gain through experimentation.

\begin{figure}[!tb] \centering 
\includegraphics[width=\textwidth]{method_images/phase04} \caption{Phase 4 
details.} \label{fig:phase4_details}   \end{figure}

%%%%% Phase 4 Details

Figure \ref{fig:phase4_details} depicts the details of conducting Phase 4 case 
studies. This process follows the sequence indicated by the numbers encircled in 
green, as follows. 1.) There are three types of case studies to consider, as 
follows. \textit{Effects Case Studies} explore the effects of the phenomena on 
measures of interest (\ie software quality aspects). \textit{Priority/Severity 
Case Studies} develop and evaluate phenomena subtype prioritization techniques 
as a means to assign severity to instances of each subtype. \textit{Relations 
Case Studies} explore the relationships between phenomena subtypes and 
relationships between forms of software engineering phenomena. 2.) Each of these 
study types begins with a refinement of the appropriate section of the GQM 
hierarchy extracted in Phase 1.

3.) Following this refinement, the studies design commences using the guidance 
of Runeson \etal \cite{runeson_case_2012}. 4.) Once designed, execution begins 
starting with a random project (case) selection process, based on a rigorously 
defined case selection criteria. 5.) Once projects are selected, detection 
strategies execute within the selected projects to identify artifacts afflicted 
by instances of the phenomena. For Effects Case Studies, the selection process 
considers changes occurring between versions to identify artifacts that become 
afflicted between version changes to evaluate the effects due to that change. In 
Priority/Severity and Relations Case Studies, the selection process only selects 
the current version of individual projects. 6.) The data collection executes the 
metrics (from the GQM hierarchy) measurement instruments. 7.) Researchers 
analyze the collected data to gain insight concerning the effects, 
priority/severity, or relations of the phenomena under study. The system stores 
this data in the experience database for later use.

Chapter \ref{chap:cs_grime_relationships} documents our implementation of this 
phase. Therein, we conducted a multiple case study examining the relationships 
between grime subtypes. This study utilized association rule mining to identify 
a variety of relationships observable in a single version of a software system, 
across multiple open source Java\texttrademark\ software systems. Chapter 
\ref{chap:cs_grime_relationships} further documents the details, results, and 
interpretations of this study.

\paragraph*{Phase 5: Evolutionary Studies} Evolutionary studies aim to expand 
upon the knowledge gained from the previous phase by examining instances of the 
phenomena as they change over time. Similar to case studies, this study includes 
instances across multiple contexts, including time. In the case of software 
systems, the units of time are versions, commits to a repository, release dates, 
or more typical time measurements such as days, weeks, months, or years. The 
aspect of time provides the capability to evaluate both changes in the phenomena 
and the system containing it. A desire to evaluate these changes leads to 
studies concerning the following: the accumulation of the phenomena, the 
susceptibility of artifacts to such accumulation, the priority of subtypes of 
the phenomena (when concerned with the need to address these issues), the 
relative severity of individual phenomena instances, and the ripple effects 
caused by the accumulation within the system.

\begin{figure}[!tb] \centering 
\includegraphics[width=\textwidth]{method_images/phase05}
\caption{Phase 5 details.}\label{fig:phase5_details}
\end{figure}
                          
Figure \ref{fig:phase5_details} depicts the details of conducting Phase 5 
Evolutionary Studies. This process follows the sequence indicated by the numbers 
encircled in green, as shown. 1.) The three types of 
longitudinal studies to be considered. First, \textit{Buildup/Susceptibility 
Studies} explore the accumulation of the phenomena within a software system and 
component susceptibility to accumulation. Secondly, \textit{Priority/Severity 
Studies} evaluate the changes in instances of the phenomena and how this affects 
their priority and severity. Finally, \text{Ripple Effect Studies} evaluate the 
effects on connected components overtime after the point in time that the 
phenomena manifest. 2.) Each of these studies starts with the refinement of the 
appropriate section of the GQM hierarchy developed in Phase 1. 3.) Following 
this refinement, the study design relies on the guidance of Runeson \etal 
\cite{runeson_case_2012} for longitudinal case studies. 4.) Each study type 
begins with a random project selection process, based on a rigorously defined 
case selection criteria. This selection criteria defines the range of 
system/project versions and identifies whether each version contains artifacts 
afflicted by the phenomena under study. 5.) For each phenomenon subtype, 
detection strategies identify afflicted artifacts to study. 6.) Identified 
artifacts are then subject to the data collection process. This process collects 
the metrics identified as part of the GQM hierarchy, using selected 
instrumentation. 7.) This collected data is then analyzed to answer the 
questions and provide further insight concerning buildup/susceptibility, 
priority/severity, or ripple effects of the phenomena under study. Finally, the 
system stores the results of the analysis in the experience database for later 
use.

Chapter \ref{chap:cs_grime_buildup} details an evolutionary study concerning 
the accumulation of design pattern grime. In this study, we explore how grime 
accumulates over time within design pattern instances across multiple versions 
of open source Java\texttrademark\ software systems. Chapter 
\ref{chap:cs_grime_buildup} further details this study design, execution, 
results, and analysis. 

\subsection{Bridge: \textit{In Vivo} Results Informing \textit{In Vitro} 
Experiments}
The results of both the \textit{in vitro} experiments and the \textit{in vivo} 
studies bring together a whole picture of the phenomena under study. The 
knowledge gathered to this point, via a combination of studies, does not provide 
a clear method to operationalize this knowledge towards efficient means of 
detecting or correcting the phenomena studied. Furthermore, it does not provide 
a clear means as to provide the capability to predict the effects of an instance 
in the software, nor does it provide a means to decide if and when such an 
instance should be corrected. To address these limitations and bridge the gap 
between the prior studies and the initial knowledge gathered, we turn towards 
the application of model building studies. Here, the goal shifts from evaluating 
the effects of the phenomena under study and towards prediction and model 
building. This approach will improve our understanding of the effects of this 
phenomenon while developing new models and techniques for efficiently detecting 
and correcting instances of these phenomena. This section consists of a single 
phase, Phase 6.

\paragraph*{Phase 6: Model Building.} In this phase, our goal is to utilize 
machine learning and data science techniques to connect the results of the case 
studies and evolutionary studies to the results of the initial experiments. The 
reason this phase is the last in the process is three-fold. First, we must 
understand the phenomena before developing predictive models for the phenomena's 
effects or its priority/severity. Second, we need confirmed examples of the 
phenomena before generating effective detection or correction strategies. 
Lastly, we require the results of all the prior studies as a foundation to 
develop approaches that determine the future effects of an instance and whether 
such an instance should be corrected.

That is, Phases 1--5 provide the necessary understanding of the phenomena to 
begin the development of predictive models. These models can indicate the likely 
effects of an instance's continued presence within a software system, and decide 
which instance to remediate. The same information should provide empirical 
results in improving detection strategies and correction strategies using 
automated generation processes (\eg evolutionary programming). Furthermore, the 
studies in Phase 1--5 will produce the necessary datasets used to train these 
techniques.

\begin{figure}[!tb] \centering 
\includegraphics[width=\textwidth]{method_images/phase06} \caption{Phase 6 
details.} \label{fig:phase6_details}  \end{figure}

%%%%% Phase 6 In Detail

Figure \ref{fig:phase6_details} depicts the details of conducting Phase 6 Model 
Building Studies. This process follows the sequence indicated by the numbers 
encircled in green, as follows. 1.) There are five types of model building 
studies to be considered. Firstly, \textit{Detection Strategy Studies} develop 
and evaluate approaches to automated generation of detection strategies. Next, 
\textit{Correction Strategy Studies} develop and evaluate approaches to 
automated generation and evaluation of correction strategies. Next, 
\textit{Effects Studies} develop predictive models of the effects of phenomena 
instances. Next,  \textit{Priority/Severity Studies} develop and evaluate 
techniques for automated assignment of phenomena priority/severity. Finally, 
\textit{Remediation Studies} explore the development of predictive models based 
on prior knowledge concerning the evolution, priority assessment, severity 
assessment, and other properties of the instance and the surrounding system, and 
explore the creation of decision models for instance remediation. 2.) Each of 
these studies begins with the refinement of the appropriate section of the GQM 
hierarchy extracted in Phase 1. 3.) Next, Researchers develop study designs 
following the guidance of Alpaydin \cite{alpaydin_introduction_2010} for machine 
learning experiments. 

4.) Using this guidance, Researchers divide the data sets gathered in prior 
phases randomly into three subsets, as follows: (T) Test for testing the models, 
(Tr) Training for building/training the models and (V) Validation for validating 
the trained models. 5.) Using these datasets, the model building and validation 
step are conducted. As the models are built, a \textit{k-fold cross-validation} 
process is used to evaluate each of the models. Models may be constructed using 
several different model-building techniques that are used as part of this 
process, with the goal of selecting the best one/combination. 6.) Performance 
data is collected by applying the model to the (V) dataset for each of the 
techniques used. The resulting data for each technique are compared and 
statistically analyzed. 7.) The results are stored in the experience database 
for later use. The generated detection and correction strategies replace prior 
versions for use in future studies. The results of the Effects and 
Priority/Severity Studies update the definitions of the phenomena.

%%%%%

\section{Future Implications and Conclusions}\label{sec:method_conclude} This 
chapter illustrated the guiding process embodied within this work and the 
experimental Arc Framework. Through the application of this process and the Arc 
Framework, the following chapters show the power of this approach to explore 
software engineering phenomena with a focus on design pattern grime. Though 
shown within this research is a specific form of design disharmony, this process 
applies to any form of software engineering phenomena manifesting within the 
confines of software artifacts. Examples of such phenomena include (but are not 
limited to) the issues composing the technical debt landscape: antipatterns, 
code smells, design pattern grime, and static analysis issues 
\cite{izurieta_organizing_2012}. Furthermore, by extending the Arc Framework, 
behavioral and dynamic analysis issues are also within the grasp of the study.

Thus, this process is not limited to the source code level. Instead, this 
approach (and its underlying framework, Arc)  applies to the study and 
evaluation of other forms of software artifacts, including requirements, 
documentation, build scripts, and repository information.  These additional 
artifacts require extensions to the Arc framework to construct a sound basis for 
experimentation. However, such a foundation allows for the extension of 
knowledge through the execution of case studies and evolutionary studies. Thus, 
allowing for the interrelation of multiple studies facilitating a deeper 
understanding of the nature of software engineering phenomena. The following 
chapters demonstrate this approach and provide evidence in support of these 
claims.
