# Introduction {#chap:intro}

\begin{quote}
\centering
\textit{Quality is free, but only to those who are willing to pay heavily for 
it.}\\--T. DeMarco and T. Lister
\end{quote}

In 1992, Ward Cunningham developed a financial metaphor to explain the need for 
continuous refactoring to stakeholders, coining the term technical debt 
\cite{cunningham_wycash_1992}. Technical debt has since gained traction as a 
major concern for software engineers, as detailed in a 2012 CAST Research report 
\cite{sappidi_jay_crash_2012}. This report detailed the analysis of 745 
applications comprising 365 million lines of code and found that, on average, 
there is \$3.61 of technical debt per line of code. This result implies that 
technical debt is a significant factor in the long-term cost and sustainability 
of a software product. A fact later enshrined in the following 
definition of technical debt:

\begin{quote} ``In software intensive systems, 
technical debt--is a design or implementation construct that is expedient in the 
short term, but sets up a technical context that can make a future change more 
costly or impossible. Technical debt is a contingent liability whose impact is 
limited to internal system qualities, primarily maintainability and 
evolvability.'' \cite{avgeriou_managing_2016}
\end{quote}


## Motivation {#sec:intro_motiv}

The research community has explored many different aspects of Technical Debt, 
but the primary focus of this dissertation is Technical Debt Management. 
Technical Debt Management has the primary goal of allowing forward progress in 
product development while identifying, remediating, and measuring technical 
debt. Technical debt identification concerns the detection of issues that 
adversely affect software maintainability and evolvability. Technical debt 
remediation deals with the application of techniques, such as refactoring, to 
remove these issues from the underlying software. Finally, the evaluation of the 
development of techniques to quantify technical debt is the realm of technical 
debt measurement.

Several Technical debt measures 
\cite{de_groot_what_2012,nugroho_empirical_2011,curtis_estimating_2012,
curtis_estimating_2012-1,chin_economics_2010,nord_search_2012,
letouzey_managing_2012,letouzey_sqale_2012,gaudin_evaluate_2009} have been 
proposed, and, although often presumed, the relationship between these measures 
and existing quality models remains undefined 
\cite{griffith_correspondence_2014}. This gap stems from existing quality models 
lacking representation of known forms of technical debt, such as those form this 
technical debt landscape \cite{izurieta_organizing_2012}. The technical debt 
landscape includes several types of software phenomena, all deserving of study, 
but utmost importance to this research is the type known as design pattern 
grime \cite{izurieta_decay_2009}.

Grime was selected as it affects a software artifact that has a known 
specification, \textit{design patterns} \cite{gamma_design_1994}. Patterns are a 
widely known approach for describing generalized solutions to well-known 
problems that occur during software development, and they also provide a means 
to encode software design principles and practices, i.e., design knowledge. 
Furthermore, this knowledge formalized through pattern specification languages, 
such as the Role-Based Meta-modeling Language (RBML) 
\cite{france_uml-based_2004}, provides the basis for the definition and 
evaluation of pattern instance decay.

This decay occurs when a pattern instance deviates from its specification 
\cite{izurieta_testing_2008} by introducing artifacts or relationships which are 
not functionally or structurally necessary, we call this \textit{design pattern 
grime} \cite{izurieta_decay_2009}. Grime, as we are considering it, is then a 
negative evolution of a pattern instance's architecture, and an evolution away 
from good design. Furthermore, grime embodies both design and architectural, 
technical debt (technical debt due to introduced in the design phase or which 
affect the design or architecture of a system and all of its dependencies). 
These forms of technical debt have far-reaching consequences, as both guide, the 
implementation of the software 
\cite{martini_architecture_2014,nord_search_2012,martini_investigating_2015,
xiao_quantifying_2015}. Thus, studying a phenomenon that is both forms of 
technical debt can provide insight into techniques to address these larger 
problems. With this in mind, we present the following hypothesis underlying this 
work:

<!--% Beyond design debt, grime also factors into understanding a software systems 
% architectural debt. Architectural debt, is the technical debt at the 
% architectural level which deeply impacts the entire software project [X]. 
% further highlighted by the fact that design pattern instances form software 
% system micro-architectures. thus not only does insight into grime provide an 
% understanding of design debt (technical debt due to design) but also towards an 
% understanding of architectural debt (technical debt affecting the system 
% architecture). Architectural debt has further been shown to be one of the most 
% important forms of technical debt. -->

### Hypothesis

\textit{Design pattern grime is an important form of 
design disharmony which has a direct impact on the quality and technical debt of 
both design pattern instances and their enclosing software products, for the 
following reasons:}

* _A pattern instance, affected by grime, continues to accumulate grime until either the instance is refactored or removed from the enclosing software system._
* _Design pattern instances, affected by grime, are harder to maintain than those unaffected._
* _Design pattern instances, afflicted by grime, are more difficult to evolve than those unaffected._


\noindent This hypothesis leads to the following set of critical predictions: 

* _As a design pattern instance evolves there is a corresponding change in the amount of grime contained within the pattern._
* _As design pattern grime increases within a design pattern instance, then the quality of both the pattern instance and its enclosing software product will decrease._
* _As design pattern grime increases within a design pattern instance, then the technical debt associated with the given design pattern instance and its enclosing software product will increase._

## Research Goals {#sec:goals}

To evaluate this hypothesis we have used the Goal Question Metric (GQM) 
\cite{basili_software_1992} approach to define the following research goals:

```{=latex}
\begin{enumerate}[leftmargin=1.5cm,label=\bfseries RG\arabic*:]
  \item Analyze design patterns to elaborate on the complete taxonomy of class 
and organizational grime (see Chapter \ref{chap:taxonomies}).
    
  \item Analyze design pattern instances afflicted with grime for the purpose of 
evaluation with respect to the ISO/IEC 25010 Quality Characteristics 
\cite{noauthor_iso/iec_2011}, from the perspective of researchers, in the 
context of generated Java\texttrademark\ design pattern instances. (see Chapter 
\ref{chap:ex_grime_and_quality}).

  \item Analyze design pattern instances afflicted with grime for evaluation 
with respect to the Technical Debt Principal, from the perspective of 
researchers, in the context of generated Java\texttrademark\ design pattern 
instances. (see Chapter \ref{chap:ex_grime_and_td}).
  
  \item Analyze design pattern instances to compare injected and observed 
instances of grime with respect to their ISO/IEC 25010 quality attributes and 
technical debt principal from the perspective of researchers in the context of 
open-source Java\texttrademark\ software projects (see Chapter 
\ref{chap:cs_ex_validation}).
  
  \item Analyze pattern instances to identify intra- and inter-relationships 
with respect to grime subtypes from the perspective of researchers in the 
context of open source projects (see Chapter \ref{chap:cs_grime_relationships}).
  
  \item Analyze pattern chains to understand design pattern grime evolution with 
respect to grime accumulation from the perspective of researchers, in the 
context of open-source Java\texttrademark\ software systems (see Chapter 
\ref{chap:cs_grime_buildup}).

\end{enumerate}
```

\noindent These goals are refined, in subsequent chapters, into a set of 
research questions (RQ), leading to the development of a set of metrics (M) used 
in later experiments and case studies.

## Summary of the Approach

In summary, the overarching goal of this research is to evaluate grime and its 
effects on quality and technical debt indices by characterizing its nature, 
taxonomy, and effects using a measurement-driven approach. This approach, though 
specific to design pattern grime, will serve as a general approach useful in 
developing a deeper understanding of software engineering phenomena. The 
phenomenon of study in this work, as noted above, is design pattern grime.

Grime, as noted above, is composed of several subtypes, including modular, 
class, and organizational grime. Initially, we explore class and organizational 
grime to develop subtype formal definitions and taxonomies further (see Chapter 
\ref{chap:taxonomies}). These taxonomies (in addition to the extended modular 
grime taxonomy) for the foundation upon which (for each subtype) injection and 
detection strategies are developed (see Chapter \ref{chap:inject}). Injection 
strategies inject instances of a specific grime subtype into a design pattern 
instance, forming the basis of our experiments. These experiments 1) evaluate 
the injected grime's effect on quality attributes, 2) evaluate the injected 
grime's effect on technical debt, and 3) evaluate the effectiveness to detect 
injected grime by specified detection strategies.

Detection strategies are algorithmic approaches to detect instances of grime 
within pattern instance and form the basis of our case studies. The case 
studies, on open source software, serve to 1) evaluate the quality and technical 
debt relationships associated with design pattern grime, 2) identify live 
instances of design pattern grime, and 3) identify relationships between grime 
types. The results from the experiments and case studies provide insight into 
our underlying hypothesis.

## Organization
The remainder of this dissertation is organized as follows. Chapter 
@chap:background provides background on the current issues and concepts 
fundamental to the phenomena under study and the research methods used. The 
research methods used are based upon a data collection and automation framework 
detailed in Chapter @chap:arc_framework called the Arc Framework. This 
framework combines the capabilities to detect and generate design patterns (see 
Chapter \ref{chap:dpd}), to evaluate software quality and technical debt (see 
Chapter \ref{chap:quality}), to inject design pattern grime instances (see 
Chapter \ref{chap:inject}), to automate detection of design pattern grime 
instances via detection strategies (see Chapter \ref{chap:detect}). These 
capabilities and their supporting components are necessary to facilitate our 
general method. This method, as described in Chapter \ref{chap:method} details 
the application of techniques from the Empirical Software Engineering literature 
used to develop the experiments and case studies conducted in Chapters 
@chap:taxonomies -- @chap:cs_grime_buildup.

Chapter @chap:taxonomies develops the formal framework and definitions of 
the subtypes of both class and organizational grime, into a consistent taxonomy. 
This taxonomy is the basis for the experiments and case studies. Chapter 
\ref{chap:ex_grime_and_quality} details the experimental methods, results, 
discussion, and conclusions concerning the effect of design pattern grime on 
quality. Chapter \ref{chap:ex_grime_and_td} details the experimental methods, 
results, discussion, and conclusions concerning the effects of design pattern 
grime on technical debt. Experimental results verified via a set of injection 
experiments within the context of open-source Java\texttrademark\ software 
systems is discussed in Chapter \ref{chap:cs_ex_validation}. This last 
experiment acts as a bridge between the experiments and case studies. Chapter 
\ref{chap:cs_grime_relationships} details the case study design, results, 
interpretation, and conclusions concerning the relationships between design 
pattern grime subtypes. Chapter \ref{chap:cs_grime_buildup} details the case 
study design, results, interpretation, and conclusions concerning the evolution 
of grime in design pattern instances. Finally, we synthesize the results of each 
study and their relation to prior work in design pattern grime and technical 
debt as detailed in Chapter \ref{chap:conclusions}.

<!-- % Grime has been the subject of multiple studies 
% \cite{izurieta_decay_2009,izurieta_how_2007,izurieta_testing_2008, 
% izurieta_multiple_2012}, but our understanding of this phenomena still has 
% several gaps. The first gap focuses on the grime buildup and software product 
% quality relationship. This relationship has been partially examined across 
% multiple studies 
% \cite{izurieta_decay_2009,izurieta_testing_2008,izurieta_multiple_2012, 
% dale_impacts_2014-1,griffith_design_2014}, but we have yet to encompass an 
% entire quality model. Beyond quality, the relationship between grime and 
% technical debt has only been sparsely studied. These studies have been limited 
% to a single Technical Debt metric and a single subtype of 
% grime\cite{dale_impacts_2014}. Grime subtypes inter-relationships and their 
% relationships to other design disharmonies, also remains unexplored and 
% unexploited. Exploring these relationships is expected to provide additional 
% insight into improving methods of grime detection. Grime detection has, until 
% recently \cite{peng_behavioral_2019}, hindered further empirical investigation 
% into the decay of design patterns. -->
