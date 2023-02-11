\chapter{Background and Related Work}\label{chap:background}

This chapter explores the main concepts and foundational work on which the
proposed research is based. This includes software decay, technical debt (TD),
software product quality,and design pattern evolution. The chapter concludes
with a section identifying the gaps in existing research.

\section{Software Aging and Decay}\label{sec:aging}

Software evolution describes those processes which affect changes that refine
the requirements and functionality of a software system. \textit{Software
decay}, a specific form of software evolution, describes a system that has
evolved to become ``harder to change than it should be'' \cite{eick_does_2001}.
Parnas \cite{parnas_software_1994} later identified a complementary phenomenon
known as \textit{software aging}. Software aging describes the effects on system
value due to changes in the system's environment.
Several studies have been conducted on software decay and aging, as well as on
the rejuvenation of software as a means to circumvent the effects of these
phenomena
\cite{grottke_fundamentals_2008,huang_software_1995,trivedi_modeling_2000,eick_does_2001,ohlsson_code_1999}.

\subsection{Design Disharmonies}\label{sec:design_defects}

Design disharmonies are a form of software decay which have been categorized in
order to understand their nature. These categories are separated by the level of
abstraction in which they occur (e.g., statements, methods, classes, etc.). They
may also be categorized by the types of software artifacts affected, e.g. source
code, unit tests, or databases. In the following subsections we discuss design
defects affecting software systems at the statement, method, class, pattern,
module, and system level.

\subsubsection*{Code Smells}\label{subsec:code_smells}
Fowler et al. \cite{fowler_refactoring:_1999} initially described 22 code smells
which indicate (possibly vehemently) that refactoring should be performed. These
descriptions also included possible corrective refactorings. Since then, several
others have extended this library of code smells. Kerievsky
\cite{kerievsky_refactoring_2005} added 5 additional code smells and helped to
further explain several of the original code smells, while providing several new
corrective refactorings. M\"{a}ntyl\"{a} \cite{mantyla_bad_2003} and
M\"{a}ntyl\"{a} et al. \cite{mantyla_taxonomy_2003} describe a taxonomy
re-classifying the original 22 code smells based on how each affects a system.

% Van Emden and Moonen \cite{van_emden_java_2002} initially defined the basic
% notion of a code smell detector. Their work also included the two basic
% notions for code smell dectection: \emph{primitive smell aspects} and
% \emph{derived smell aspects}. Continuing this work, Trifu and Marinescu
% \cite{trifu_diagnosing_2005} in an early work helped pave the way to using
% metrics as a means to identify code smell affected areas of a code base. This
% work provided a template to describe code smells similar to the way design
% patterns are describe in \cite{gamma_design_1994}. %Continuing this work Lanza
% and Marinescu not only propose their own specifications for detecting and
% correcting code smells, but also define a classification taxonomy for the
% smells and define 5 additional smells.
%  Finally, beyond the classification, initial concepts of detection and
% correction, and the ever growing library of code smells is the notion of
% properties associated with these smells.
% The first set of these properties, i.e., relationships between code smells,
% were identified by Pietrzak and Walter \cite{pietrzak_leveraging_2006}. They
% identified 6 relationships that can occur between code smells and provided
% examples thereof. Along this line, Liu et. al.
% \cite{liu_initial_2012,liu_facilitating_2009,liu_schedule_2012} identified
% order relationships existing between detection and correction sequences for
% different code smells (with examples).% which can greatly increase the
% efficiency of both detection and correction.

\subsubsection*{Anti-Patterns}\label{subsec:antipatterns}
Brown et al. \cite{brown_antipatterns:_1998} first identified anti-patterns,
which are patterns of doing things incorrectly. Several subtypes of
anti-patterns were identified including software development, software
architecture, and software project management. They also define a
language of anti-patterns, similar to design patterns \cite{gamma_design_1994},
and what they call mini anti-patterns. Though Brown et al.
\cite{brown_antipatterns:_1998} compiled a listing of existing anti-patterns,
prior evidence was provided by Riel \cite{riel_object-oriented_1996}.

\subsubsection*{Modularity Violations}\label{subsec:mod_violations}
 Modularity violations, introduced by Wong et al. \cite{wong_detecting_2011}, are
 violations of architectural design principles concerning the coupling between
 different system modules. They propose an approach utilizing design matrix
 visualizations of the system architecture (focusing of modules). Based on these
 techniques, Schwanke et al. \cite{schwanke_measuring_2013} investigated the use
 of modularity violations as an approach to evaluate architectural quality.
 Furthermore, they conducted an empirical enquiry of open source
 Java\texttrademark\ software systems. Their results showed that the fan-out
 metric is reliable in predicting locations of future faults. Reimanis et al
 \cite{reimanis_replication_2014} later confirmed Schwanke et al's results
 through a replication study of commercial software.

\subsubsection*{Design Pattern Disharmonies}\label{subsec:grime}
Initially, Moha et al. \cite{moha_naouel_taxonomy_2005} defined a taxonomy of
potential design pattern disharmonies and conducted an empirical study to
investigate their existence. This taxonomy includes the following four types of
defects: \textit{Missing} refers to a design missing a needed design
pattern. \textit{Deformed} patterns are those which are not correctly
implemented according to Gamma et al's \cite{gamma_design_1994} definition but which are not
themselves erroneous. \textit{Excess} is the over use of design patterns in a
software design. \textit{Distorted} design patterns are distorted instances of a
design pattern. Their study was conducted across several versions of an open
source Java\texttrademark\ project. They detected 38 design patterns instances
of which 3 were found to be non-harmful deformed design patterns. Furthermore,
their research presented and evaluated multiple detection techniques including manual,
semi-automatic, and automatic techniques based on a combination of detection
strategies and constraint satisfaction techniques. Unfortunately, this taxonomy
was not formally defined.

Izurieta and Bieman \cite{izurieta_how_2007} presented another taxonomy of
design pattern decay. Seminal work by Izurieta \cite{izurieta_decay_2009} found
that pattern realizations tend to accumulate artifacts that obscure the intended
use of patterns. Two distinct categories of design pattern decay were
identified:
\begin{description}
  \item[Design Pattern Grime] -- accumulation of unnecessary or unrelated
  software artifacts within the classes of a design pattern instance.
  \item[Design Pattern Rot] -- violations of the structure or architecture of a
  design pattern.
\end{description}
Comparing to the Moha et al. taxonomy, grime relates most closely to the concept
of deformed patterns, while rot relates most closely to distorted design
patterns. Empirical studies showed only the presence of grime, which has led to
the further development of three types of grime:
\textit{modular}, \textit{class}, and \textit{organizational} grime, each
defined as follows:
\begin{description}
 \item[Modular grime] build up of relationships involving the classes of a
 design pattern instance, where the relationships are unnecessary to facilitate
 the operation of the pattern.
 \item[Class grime] build up of fields and/or methods in the classes of a
 pattern instance, where these artifacts are unnecessary to facilitate the
 operation of the pattern.
 \item[Organizational grime] the unnecessary distribution of pattern instance
 classes across namespaces or packages.
\end{description}
Empirical studies further showed only significant results for modular grime
\cite{izurieta_testing_2008}.

The modular grime results led Schanz and Izurieta \cite{schanz_object_2010} to
further expand the taxonomy of modular grime. A series of empirical studies
across open source systems was conducted to validate the existence of these
types of grime. Further empirical studies on grime have shown implications in
the area of testing \cite{izurieta_testing_2008}. Based on this work Izurieta et
al \cite{izurieta_organizing_2012} indicated that the technical debt landscape
should include design pattern decay along with other types of design defects,
such as code smells, anti-patterns, modularity violations, and certain lower
level code issues that affect design patterns.

More recent work involving design pattern grime has been conducted by Dale and
Izurieta \cite{dale_impacts_2014} and Griffith and Izurieta
\cite{griffith_design_2014}. Dale and Izurieta evaluated the effects of modular
grime on technical debt. Their work show, through experimentation, that
temporary modular grime types have the largest effect on technical debt.
Griffith and Izurieta further developed the class grime taxonomy and showed,
through experimentation, that each type of class grime negatively affects
understandability of a pattern instance. Both of these studies utilized an early
form of software injection to facilitate the experimental process. Specifically,
Dale and Izurieta used a method which injects modular grime into
Java\texttrademark\ bytecode \cite{dale_impacts_2014}. Griffith and Izurieta
used a method which modifies a model of the source code
\cite{griffith_design_2014}.

Another line of research into design pattern disharmonies has been conducted by
Bouhours et al
\cite{bouhours:hal-00522587,bouhours_sharing_2010,bouhours_spoiled_2014}. They
have studied what they term \textit{spoiled patterns}
\cite{bouhours_sharing_2010}. Spoiled patterns are essentially the results of
incomplete or failed instantiation of a design pattern either intentionally or
unintentionally. This research is motivated to improve design pattern education,
to motivate better indication of when patterns need to be refactored, and to
improve forward-driven and evolutionary design techniques
\cite{bouhours:hal-00522587}. Bouhours et al's study involved the manual
collection of spoiled patterns based on student implementations rather than
those from open source or industry software
\cite{bouhours:hal-00522587,bouhours_sharing_2010,bouhours_spoiled_2014}.

\subsection{Design Disharmony Detection}\label{subsec:defect_detect}
The notion of design defect detection has been around nearly as long as the
notion of design defects themselves. Detection efforts can be broken down into
three major approaches: metric based approaches
\cite{miceli_metric_1999,van_emden_java_2002,marinescu_detection_2004,walter_multi-criteria_2005,munro_product_2005,marticorena_extending_????},
machine learning and artificial intelligence methods
\cite{salehie_metric-based_2006,khomh_bayesian_2009,khomh_squad:_2009,polasek_extended_2012,marticorena_raul_parallel_????,kessentini_design_2011,kessentini_search-based_2011},
and a combination of structural information and metrics
\cite{moha_automatic_2006,moha_domain_2008,moha_decor:_2010}.

One of the most widely extended methodologies is the \textit{detection
strategies} approach proposed by Marinescu \cite{marinescu_detection_2004}. A
detection strategy is a filtering method which utilizes a combination of metric
thresholds and set theory to identify probable locations of design disharmonies
in code. Ratiu et al. \cite{rapu_using_2004} extended the detection strategy
approach by including history and evolution information. This approach increased
code smell detection accuracy by observing metrics across multiple versions
rather than a single version. Ratiu et al. \cite{ratiu_evolution-enriched_2004}
and G\^{i}rba et al. \cite{girba_identifying_2004,girba_using_2007} utilize
Formal Concept Analysis in order to allow historical analysis and change
analysis to be coupled to the original detection strategy framework.

% Given the overwhelming attempts to detect known design defects it would seem
% that a specific and precise definition of what a design defect is needed.
% Unfortunately, this is not a well researched area \cite{liu_schedule_2012}.
% Research in this area has progressed as follows: M\"{a}ntyl\"{a}, Vanhanen,
% and Lassenius \cite{mantyla_taxonomy_2003} organized the various Code Smells
% into a taxonomy based on how the underlying code is affected, yet this did
% nothing to make the definitions of these design defects more precise. From
% this, Marinescu developed detection strategies which views design defects via
% the symptoms they display, in order to assign metrics which can help detect
% the existence of these defects in a code base \cite{marinescu_detection_2004}.

Following Marinescu, Munro \cite{munro_product_2005} also used product metrics
to help define detection algorithms for design defects. Munro, however, took it
a step further (towards formalization) by defining a template to describe each
design defect. Where the template consists of: bad smell name,
measurement/process for detection, and an interpretation (set of rules) defining
the defect \cite{munro_product_2005}.

To better understand the nature of code smells and to improve detection
techniques Pietrzak and Walter \cite{pietrzak_leveraging_2006} investigated the
possibility of inter-smell relations. This work paved the road to formalizing
the idea of relationships that exist between design disharmonies. Walter and
Pietrzak \cite{walter_multi-criteria_2005} conducted additional research
utilizing multiple criteria vectors including programmer experience, metrics,
coding rules, historical information, and other detected code smells in order to
increase detection capabilities.

Along the lines of further understanding of design disharmonies, Moha et al
\cite{moha_automatic_2006,moha_domain_2008,moha_decor:_2010} conducted a domain
analysis to develop a domain specific language for detection rule definitions, a
process called DECOR. This model was designed to encompass the notions of
metrics, inter-relationships, and structural features.

An extension of Moha et al's DECOR approach was the HIST tool of Palomba et al
\cite{palomba_detecting_2013}. Polomba et al's approach utilizes historical
information to detect code smells and anti-patterns which normally could not be
detected. HIST was evaluated on the change histories of several large open
source Java\texttrademark\ projects in order to provide proof-of-concept. The
authors do note that the main limitation in their approach is the requirement of
having a sufficiently long version history.

Due to the typical nature of design defects definitions as informally specified
issues in designs or code, several approaches have been proposed to automate the
process of developing the algorithms for detection. This notion of automation
has progressed from the semi-automated to fully automated generation of
detection algorithms. The first approach was proposed by Mihancea and Marinescu
\cite{mihancea_towards_2005}. They used a genetic algorithm to tune the
parameters for each filter in order to improve the accuracy of detection
strategies.

In order to deal with the issues of manual or semi-automatic design defect
detection several approaches have been developed. Kessentini et al. have
developed and evaluated numerous approaches to these problems
\cite{kessentini_design_2011,kessentini_design_2011-1,kessentini_search-based_2011,mahouachi_new_2012,mansoor2013code,ouni_maintainability_2013}.
In these studies, supervised learning approaches are used to generate detection
rules. The results show that rules generated using simulated annealing, harmonic
search, genetic algorithms, and genetic programming approaches all out perform
the results of the original DECOR \cite{moha_decor:_2010} rules, on DECOR's own
training data.

Mahouachi et al. \cite{mahouachi_new_2012} extend the genetic programming
approach by including both detection and correction (via refactoring) together
in order to improve both steps simultaneously. Mansoor et al
\cite{mansoor2013code} have also extended the genetic programming approach to
utilize a multi-objective approach to increase both precision and recall of the
generated rules. Other machine learning based approaches have been developed.
Specifically, Khomh et al. \cite{khomh_bayesian_2009,khomh_bdtex:_2011} have
conducted research into the use of Bayesian belief networks to both specify and
detect anti-patterns. Recently, Fontana et al.
\cite{fontana_code_2013,arcelli_fontana_comparing_2015} have detailed an
approach to use machine learning techniques for code smell and anti-pattern
detection. This work facilitated the development of a benchmark dataset and the
evaluation of multiple classification algorithms against existing tools. Their
results show that high accuracy can be achieved using various classification
techniques, given training data exists.

Given the reliance of detection approaches on software metrics, it is
surprising that there is little empirical research into the feasibility of these
approaches. Schumacher et al. \cite{schumacher_building_2010}
conducted an empirical study of automated detection within an industry setting.
Using the CodeVizard tool \cite{zazworka_codevizard:_2010}, which is based on a
metric driven approach to automated detection, they found that in comparison to
human classification the automated detection performed very well. They also
identified that combining automated detection with human review decreases
overall maintenance effort required. Further research into the evaluation of
automated detection was conducted by Fontana et al
\cite{fontana_automatic_2012}. This latter study compared four code smell
detection tools across six versions of a single Java\texttrademark\ open source
project. The results of this study show that the tools evaluated had a tendency
to disagree, and that although these tools may prove useful they are far from
adequate.

\subsection{Design Disharmonies and Quality}\label{subsec:dd_quality}
A large body of prior research exists concerning the relationship between design
disharmonies and software quality. A large portion of this research has been
focused specifically on the effects of code smells and anti-patterns on software
maintainability. Early work was conducted by Olbrich et al
\cite{olbrich_evolution_2009} including two longitudinal case studies across the
version history of two open source software projects. They showed that the
affected classes are more likely to change and the studied code smells have a
negative impact on maintainability. A larger study by Khomh et al
\cite{khomh_exploratory_2009} conducted a similar longitudinal case study, but
considered the relationships between change-proneness and 29 different code
smells. The results of this study similarly showed that affected classes are
highly change-prone.

Olbrich et al. \cite{olbrich_are_2010} conducted another longitudinal study
across three open source systems. They found that, in the systems studied, the
instances of god classes and brain classes studied exhibit less change and
defects when normalized for size, contradicting previous results. Later, Kohmh
et al. \cite{khomh_exploratory_2012} conducted a study on 13 anti-patterns in
several releases of 4 open source software systems. The results show that those
classes affected by anti-patterns are more change- and fault-prone than others,
when accounting for size. A further study of 16 open source Java\texttrademark\
system change histories conducted by Romano et al. \cite{romano_analyzing_2012}
showed that changes are more common in those classes affected by anti-patterns.
Another study by Yamashita and Counsell \cite{yamashita_code_2013} found that
code smells are significantly affected by size, making comparisons between
systems of varying size impossible.

Unfortunately change- and fault-proneness are not comprehensive indicators of
maintainability. Because of this, Yamashita and Moonen
\cite{yamashita_code_2012} conducted an empirical study to connect code smells
to maintainability. This study connected maintainability factors defined by
experts to developer impressions identified during their industrial case study.
Yamashita and Moonen conducted a second multiple case study to further develop
the connection between code smells and maintainability
\cite{yamashita_what_2013}. Both studies found that typical indicators such as
change size or complexity are not enough to assess the ability of code smells to
predict maintainability issues. A study by Sjoberg et al
\cite{sjoberg_quantifying_2013} further refined these results while also
indicating that maintenance effort was not significantly affected by studied
code smells. Each of these studies indicated that interactions between code
smells should be studied to better understand how maintainability is affected
\cite{yamashita_code_2012,yamashita_what_2013,yamashita_assessing_2014}.

Following this research, Yamashita and Moonen \cite{yamashita_exploring_2013}
evaluated the effects of inter-smell relations (previously identified and
studied by Pietrzak and Walter \cite{pietrzak_leveraging_2006} and Fontana and
Zanoni \cite{fontana_investigating_2011}). This study was conducted across four
Java\texttrademark\ systems known to have code smells. They found that when
artifacts are affected with multiple code smells these smells tend to interact,
and that this interaction affects maintainability. Furthermore, Yamashita and
Counsell \cite{yamashita_code_2013} found that there is no difference between
smell co-location and coupling when considering the effect on maintainability.
Overall, they found that a code smell based approach to maintainability
assessment is superior to a metrics only approach.

A more quantitative approach to evaluating the effect of code smells on software
quality was conducted by Fontana et al. \cite{fontana_investigating_2013}. This
study was conducted across the set of Java\texttrademark\ open source systems
collected in the \textit{Qualitas Corpus} \cite{tempero_qualitas_2010}. Their
results indicate that the most prevalent code smells are Duplicate Code, Data
Class, God Class, Schizophrenic Class and Long Method, not discounting
false-positives due to tool error. They also show that in those systems with a
high number of code smells there is a greater indication of deterioration in
maintainability. Finally the research by Fontana et al. indicates that there is a
connection between the system domain and the effect that code smells have on
maintainability, a finding that is confirmed by Hall et al
\cite{hall_code_2014}.

B\'{a}n and Ferenc's study \cite{murgante_recognizing_2014} was conducted using
228 open-source Java\texttrademark\ systems and PROMISE data concerning bug
information for 34 of the systems. This study investigated the relationship
between maintainability and anti-patterns and the correlation between
anti-patterns and identified bugs. The results of this study showed that there
is a positive correlation between anti-pattern affected areas of code and bug
incidents, and that there is a negative correlation between anti-patterns and
maintainability (as measured using the Columbus quality model
\cite{bakota_probabilistic_2011}).

The majority of research has indicated that both code smells and anti-patterns
affect quality by negatively impacting maintainability. Yet, only a single study
has utilized a known quality model to conduct this evaluation
\cite{murgante_recognizing_2014}. Furthermore, all of the studies to date have
been case studies and the results have been restricted to either qualitative
analysis or in the quantitative approaches, only correlation analysis. Given
this, it is pertinent that an approach is necessary which will facilitate
experimentation in order to provide estimation of effect size as well as causal
analysis.

There is also an issue in that current approaches are limited to the evaluation
of only those items that can be detected by existing tools, thus limiting analysis
to code smells and anti-patterns. This is indicative of the need for an approach
which can formalize definitions of design disharmonies in a generalizable way.
Finally, there is no evidence regarding the relationship between design
disharmonies and any other quality characteristics defined in the ISO/IEC 25010
specification \cite{noauthor_iso/iec_2011} such as: \textit{Functional Suitability},
\textit{Reliability}, \textit{Performance Efficiency}, \textit{Usability},
\textit{Security}, \textit{Compatibility}, and \textit{Portability}.

\section{Technical Debt}\label{sec:tech_debt}
Technical debt is a concept introduced by Ward Cunningham
\cite{cunningham_wycash_1992} as a financial metaphor to describe the trade-off
between quality engineering and satisfying short-term goals. The following
subsections describe work in the following areas describing the nature of the
metaphor, methods of managing technical debt, impact and consequence of
technical debt, and techniques for measuring technical debt.

\subsection{Metaphor, Definition, and Properties}\label{subsec:metaphor}
The notions surrounding technical debt until recently have been informal and
under-specified. In lieu of this Tom et al. \cite{tom_exploration_2013} conducted
a systematic literature review to consolidate the concepts surrounding technical
debt into a single taxonomy. This taxonomy classifies technical debt from either
of two perspectives: by the underlying intention behind the decision (or lack
thereof) to take on the debt, or the type of artifact in which the debt occurs.

The intentional perspective is divided into \textit{Strategic Debt, Tactical
Debt, Incremental Debt}, and \textit{Inadvertent Debt}. Strategic Debt is debt
taken on intentionally as part of a larger long-term strategy. Tactical Debt is
debt taken on intentionally as a reactionary response and serves to satisfy
short term needs. Incremental Debt is debt taken as several small steps but
which accrues very easily and rapidly. Finally, Inadvertent Debt is debt taken
on unintentionally and possibly unknowingly by the software development team.
The location or artifact perspective is divided into \textit{Code Debt, Design
and Architectural Debt, Environmental Debt, Knowledge Distribution and
Documentation Debt}, and \textit{Testing Debt}.

Beyond classifying and understanding of how debt occurs, some researchers have
furthered the understanding of the metaphor itself. Nugroho et al
\cite{nugroho_empirical_2011} indicate that the technical debt metaphor has
several contexts from which it can be viewed, and they specifically look at it
from the context of maintainability. Along similar lines Klinger et al
\cite{klinger_enterprise_2011} look at technical debt from the perspective of
enterprise development and indicate that using financial tools, decision theory,
stake-holder based quantification, and developing an understanding of
unintentional debt are potential avenues of interest. Finally, Theodoropoulas et
al \cite{theodoropoulos_technical_2011} view technical debt from the stakeholder
perspective and provide a new definition based on the gap between technology
infrastructure of an organization and its impact on quality.

More recent work has looked into the extent and practicality of the technical
debt metaphor itself. Specifically, Schmid \cite{schmid_limits_2013}
\cite{schmid_formal_2013} notes that as we explore technical debt the metaphor
begins to breakdown. He notes, the intimate connection between future
development and technical debt leads to an inability to objectively measure
technical debt itself. This is due to the nature of the interest property
associated with technical debt items. Since technical debt interest has a
probability which indicates whether it may affect the system, we should instead
focus not on measuring all technical debt (\emph{potential technical debt}) but
rather we should concern ourselves with the debt items that will have an impact
(\emph{effective technical debt}) on upcoming feature development or
maintenance.

\subsection{Technical Debt Management}\label{subsec:managing_td}
Technical Debt Management comprises the actions of identifying, cataloging, and
remediating debt items. The current industry focus has been on identifying
and tracking debt as part of the working project backlog
\cite{mcconnell_managing_2008,brown_managing_2010,kruchten_technical_2012} or as
part of a separate technical debt list
\cite{guo_tracking_2011,seaman_measuring_2011,guo_portfolio_2011}. Essentially,
we can think of the emergence of design disharmonies within a software system
akin to taking on debt, and the longer they are allowed to remain (without
refactoring) the more negative influence they will have on the system
\cite{fontana_investigating_2012}. This influence acts as interest on the debt
by increasing the amount of effort required to evolve the
software\cite{zazworka_investigating_2011}.

Guo and Seaman \cite{guo_tracking_2011,seaman_measuring_2011,guo_portfolio_2011}
proposed a technical debt management framework (TDMF). Central to this framework
is the Technical Debt List (TDL) which stores information pertaining to known
technical debt items within a software system. Three activities support this
framework: Technical Debt Identification, Technical Debt Estimation, and
Decision Making. Recently, Guo et al. \cite{guo_exploring_2014} conducted a case
study to evaluate the costs of using the TDMF. This study showed that after an
initially high startup cost the cost of monitoring and remediation of debt
reduces to a reasonable level. Holvitie and Lepp\"{a}nen
\cite{holvitie_debtflag:_2013} have further enhanced the TDMF with an approach
called DebtFlag. The main purpose of the DebtFlag is to reduce information
redundancy to provide more efficient debt propagation evaluation. This aids in
more accurate estimation of debt impact, interest, and interest probability.

Schmid \cite{schmid_formal_2013,schmid_limits_2013,schmid_technical_2013} has
also focused on developing an approach for selecting which debts should be
removed. Schmid's work is based on a formalization of technical debt concepts to
extend the TDMF using a 2D matrix representation coupled with an approximation
scheme to select those technical debt items to refactor in the next release.
Similarly Stochel et al. \cite{stochel_value-based_2012} approach this problem
using a subsumption model of technical debt based on a modified Value Based
Software Engineering \cite{boehm_value-based_2003} cost and estimation approach
in order to estimate the return on investment (ROI) for each item. A technical
debt versus portfolio assessment matrix, using ROI in a similar approach to that
of Seaman and Guo \cite{seaman_measuring_2011}, is used to evaluate each item
provided the best savings per release (similar to that of Schmid
\cite{schmid_formal_2013,schmid_limits_2013,schmid_technical_2013}). Foganholi
et al. \cite{foganholi_supporting_????} have implemented the TDMF as a tool
connected with SonarQube\texttrademark\ allowing for both automated and manual
identification and tracking of technical debt.

Decision support approaches for debt acquisition have been less forthcoming than
for debt repayment. Nevertheless, Falessi et al. \cite{falessi_practical_2013}
are exploring current open problems concerning this topic as well as the
required decision support constructs needed to address the problem. Ramasabba
and Kemerer \cite{ramasubbu_towards_2013} developed an optimization approach
utilizing multiple projections of a single codebase to evaluate decisions
regarding both debt acquisition and repayment. Griffith et al
\cite{griffith_simulation_2014} conducted a simulation study of TD management
strategies. The results of these simulations showed that combining automated
detection with a maximum TD threshold and remediation sprints is a superior
combination. Furthermore, the models explored in the simulation study are
representative of the models identified as used in practice by Martini et al
\cite{martini_architecture_2014,martini_investigating_2015}.

As the technical debt landscape has evolved the research community's focus has
moved from identifying technical debt, to the underlying issues
surrounding these items. Specifically Falessi and Voegele
\cite{falessi_validating_2015} have recently conducted a case study to evaluate
industry perspectives on design rule priority and validation. Here design rules
are considered to be any empirically validated design principles that enhance
the quality of software. This study found that classes with high numbers of rule
violations also tend to be defect-prone. Additionally, Tufano et al
\cite{tufano_when_????} conducted a large case study on 200 open source systems
by mining revision history. They found that code smells, known to affect the
maintainability of a software system, are normally introduced at the creation of
the affected artifact. Furthermore, they found that developers at all levels are
prone to creating code smells, and that these smells are introduced more often
due to time constraints. Furthermore, Mamun et al. \cite{mamun_explicating_2014}
have also identified the primary causes for technical debt accumulation as: time
constraints, hardware/software integration issues, improper or incomplete
refactorings, or use of legacy, external, or open source libraries.

\subsection{Impact and Consequences}\label{subsec:td_impact}
The impact of technical debt on engineering effort, project cost, and project
quality is of utmost concern. An initial empirical enquiry conducted by Zazworka
et al. \cite{zazworka_investigating_2011} shows that technical debt has a
negative impact on software quality. Furthermore, Zazworka et al
\cite{zazworka_prioritizing_2011} investigated prioritizing debts using a
cost/benefit analysis approach. This study shows that technical debt negatively
affects the correctness and maintainability of a product. Recently, Griffith et
al \cite{griffith_correspondence_2014} conducted a case study across several
versions of several open source Java\texttrademark\ systems evaluating the
relationship between quality model attributes and technical debt measures.
Results show little evidence of a relationship between the CAST
\cite{curtis_estimating_2012,curtis_estimating_2012-1}, SonarQube\texttrademark\
\cite{gaudin_evaluate_2009}, or Marinescu's \cite{marinescu_assessing_2012-1}
approaches to measuring technical debt principal and quality attributes in the
QMOOD quality model \cite{bansiya_hierarchical_2002}.

A key to understanding technical debt and its effects is to be able to
understand the gaps and overlaps that may exist in the landscape
\cite{izurieta_organizing_2012} of TD item types. Zazworka et al
\cite{zazworka_comparing_2012} identify several types of design debt (e.g., code
smells, modularity violations, and design pattern grime) and tools which detect
them. They identified that all the tools indicate different problems with little
to no overlap. Further exacerbating this issue is the work of Alves et al
\cite{alves_towards_2014} which has further defined the technical debt
landscape. This expanded landscape has been divided into 13 subtypes of
technical debt each consisting of multiple indicators. The original landscape as
proposed by Izurieta et al. \cite{izurieta_organizing_2012} is now encompassed
within the subtype of \textit{Design Debt}. Fontana, Ferme, and Spinelli
\cite{fontana_investigating_2012} state that although code smells are important
components of the technical debt landscape, certain identified debt items may
not actually constitute debt. Instead they indicate that domain knowledge must
be used as a filter in order to identify these misnomers and to ensure that an
accurate indication of technical debt is provided.

\subsection{Measurement}\label{subsec:measure_td}
Lastly, there must be a means to measure technical debt and its associated
properties in a way that is both meaningful to developers and to stakeholders
alike. Seminal work by, Brown et al. \cite{brown_managing_2010} identified the
technical debt metrics of: principal, interest, and interest probability.
Subsequently, Nugroho et al. \cite{nugroho_empirical_2011} contributed a formal
model to calculate measurements for both interest and principal, from a
maintainability perspective. Additional measures, closely related to the
technical debt landscape \cite{kruchten_technical_2012,zazworka_comparing_2012}
have been proposed to index the effect that design flaws (e.g., code smells and
modularity violations) have on technical debt. For example, Marinescu
\cite{marinescu_assessing_2012} proposes a method to index the effect on quality
produced by different code smells and anti-patterns based on the type, influence
and severity of the design flaw instance, thus creating a score which can be
aggregated over the size of the system. In another approach Nord et al
\cite{nord_search_2012} develop a strong foundation for measuring the
architectural technical debt based on the notion of prudent, deliberate, and
intentional debt.

Letouzey \cite{letouzey_sqale_2012} developed the SQALE quality and technical
debt analysis model which provides both the ability to estimate technical debt
principal and several visualizations to illuminate the impact of technical debt.
Recently, Curtis et al. \cite{curtis_estimating_2012} proposed methods to
estimate the principal and interest as well as the size, cost, and type  of
technical debt. Given these various approaches for the quantification of
technical debt and the wide range of differences in values, Izurieta et al
\cite{izurieta_uncertainty_2013} proposed a means to measure the error
associated with the calculation of technical debt for these methods. They argue
that a means to measure the systematic error introduced by these tools should be
included with their values, similar to other scientific tools, and that a means
to compare these tools and their error be developed.

Previous research focus has been on the measurement of technical debt principal,
but more recent research has turned towards measuring interest
\cite{singh_framework_2014,chatzigeorgiou_estimating_????,ampatzoglouestablishing,falessi_towards_????}.
This shift in direction is due to research indicating that large principal
values do not convey understanding of the effect that technical debt will have
on a project \cite{falessi_towards_????}. Falessi and Reichel
\cite{falessi_towards_????} have developed a tool to extract historical and
defect data from repository and bug-tracking information. This tool then
interfaces with SonarQube\texttrademark\ to display TD interest data to
influence developer decisions. Chatzigeorgiou et al
\cite{chatzigeorgiou_estimating_????} are developing an optimization technique
which attempts to optimize the time line for repayment based on historical data
and metrics.

\subsection{Architectural Debt}
Recent research has shown that a majority of technical debt stems from issues
with the underlying architecture or with architectural decisions
\cite{holvitie_technical_2014}, hence interest in architecture technical debt
(ATD) has increased. Given this, Martini et al.
\cite{martini_architecture_2014,martini_investigating_2015} conducted an
industrial case study at 5 companies in order to understand the underlying
causes of ATD. Based on the underlying causes they have developed two models of
ATD management: A crisis model describing reactionary recovery when accumulation
reaches a critical point, and the feature-release model which incorporates
constant accumulation with recovery after release. Furthermore, Xiao
\cite{xiao_quantifying_2015} developed a method of quantifying architectural
debts. Xiao defines architectural debts as groups or clusters of files which
incur higher maintenance costs due to an underlying architectural degradation.
Recently, Izurieta et al. \cite{izurieta_preemptive_2015} proposed the
notion of \textit{Model Driven Technical Debt}, which is technical debt incurred
during the model-to-code mapping process in model driven design. The goal of
this work is to classify MDTD in order to provide the ability to reduce TD in
the modeling phase in order to reduce TD in the resulting implementation and
thereby increase the quality of the software product.

\section{Design Pattern Evolution}\label{sec:patterns}
Design patterns were widely introduced to the software engineering community by
Gamma et al. \cite{gamma_design_1994}. Design patterns are an abstraction of
solutions, forged in experience, to commonly recurring design problems. These
patterns are a type of micro-architecture which are subject to both evolutionary
issues and design decay, yet few empirical studies of a relationship between
design pattern evolution and decay exist in the literature. Rather, studies
involving the evolution of design patterns tend to focus on how pattern
change-proneness
\cite{mens_declarative_2001,bieman_design_2003,aversano_empirical_2007,gatrell_design_2009}.

In order to study design pattern instance decay a means to formally specify a
pattern and validate instances is necessary. Various design pattern languages
and specification techniques have been proposed
\cite{eden_precise_1997,mikkonen_formalizing_1998,eide_static_2002,taibi_formal_2003,smith_spqr:_2003,dae-kyoo_kim_role-based_2003,soundarajan_responsibilities_2004,soon-kyeong_kim_using_2004,kim_uml-based_2004}
each with the same goal --a higher level of representational abstraction. Yet,
although the specification aspects may well be understood, the verification of
instances that conform to these specifications remains a hard problem.

The role-based meta-modeling language (RBML) is an approach to specify design
patterns based on an underlying metamodel
\cite{dae-kyoo_kim_role-based_2003,kim_uml-based_2004,france_uml-based_2004}.
This meta-model extends the UML\texttrademark\ meta-model \cite{_omg_2011} which
allows the instances to be visually described and constrained using the Object
Constraint Language (OCL) \cite{omg_ocl_2014}. The use of OCL allows the defined
specifications to have a varying degree of generality. In order to make use of
the specifications a means to validate pattern instances against the
specification is required.

Kim \cite{dae-kyoo_kim_evaluating_2005} initially proposed a method for
evaluating the structural conformance of a pattern instance to the
RBML specification. This proposal was followed by Kim and Shen's
\cite{kim_approach_2007-1,kim_evaluating_2008} divide-and-conquer approach.
Based on this approach Strasser et al. \cite{strasser2011automated} developed a
tool to calculate a score for the conformance rating of a design pattern
instance given its RBML specification. Recently, Lu and Kim
\cite{lu_required_2011,lu_required_2014} have developed an approach to validate
conformance of behavior and sequence diagrams of pattern instances. Kim and Whittle \cite{kim_generating_2005} to
utilized RMBL to help generate designs using design pattern specifications.

% TODO Need to introduce design patterns. Need to update everything to current
% research in 2014. Also for any empirical works we need to describe the major
% findings.

% TODO \msusubsection{Design Pattern Specification}

% TODO Briefly discuss Elemental Design Patterns and RBML approaches and how
% they can benefit this work and the connection of both to design pattern
% detection.

% \section{Design Pattern Detection}\label{sec:detect_patterns} 
% Design pattern detection (DPD) is the process of extracting or identifying
% design pattern instances within a software system.
% Several methods have been proposed based on structural analysis
% \cite{asencio_relating_2002,bansiya_automating_1998,beyer_simple_2003,costagliola_design_2005,costagliola_case_2006,ferenc_design_2005,gueheneuc_y-g_fingerprinting_2004,kaczor_efficient_2006,kramer_design_1996,hong_jbooret_2001,smith_spqr:_2003,streitferdt_searching_2005,tsantalis_design_2006,zhi-xiang_zhang_new_2004}
% or a combination of structural and behavioral analysis with or without semantic
% analysis
% \cite{antoniol_design_1998,heuzeroth_automatic_2003,heuzeroth_generating_2003,huang_practical_2005,shi_reverse_2006,tonella_object_1999,wei_wang_design_2005,wendehals_improving_2003,seemann_pattern-based_1998,blewitt_automatic_2001,dong_dp-miner:_2007,dong_visualizing_2007}.
% A more recent approach by Kniesel and Binun \cite{kniesel_standing_2009} has
% combined the output of several tools (including SSA
% \cite{tsantalis_design_2006}, DP-Miner \cite{dong_dp-miner:_2007}, PINOT
% \cite{shi_reverse_2006}, PTIDEJ \cite{gueheneuc_using_2001}, and FUJABA
% \cite{niere_handling_2003}) in order to produce results with high precision and
% better recall than any single tool. This approach uses tool agreement combined
% with a refinement hierarchy of design patterns. Further work by Binum and
% Kniesel \cite{binun_dpjf_2012} has combined the best parts of the previously
% mention tools and extended them into a new approach call DPJF which touts an
% incredible 100\% precision and a median recall of 89\%. We propose
% reimplementing the DPJF algorithms in a model driven approach in order to expand
% their capabilities to languages beyond Java\texttrademark , C++ and Eiffel. We
% also intend to incorporate the use of design pattern conformance checking
% algorithms
% \cite{kim_approach_2007-1,dae-kyoo_kim_evaluating_2005,kim_evaluating_2008,lu_required_2014,lu_required_2011}
% for RBML \cite{dae-kyoo_kim_role-based_2003} specifications in order to increase
% the recall of DPJF. Using this enhanced process, we will extract
% design patterns without requiring manual verification.

% \msusubsection{Design Pattern Coupling and
% Interaction}\label{sec:pattern_couple} Design patterns tend to be used
% together in the design of software systems. Design pattern coupling is a
% notion which describes the combined use and interactions between two or more
% patterns. Design pattern coupling was initially studied by McNatt and Bieman
% \cite{mcnatt_coupling_2001}. Their goal was to identify how often pattern
% realization coupling occurs and to investigate the benefits of design pattern
% coupling. They found that pattern couplings frequently occur, and that typical
% pattern couplings were of the intersection type (based on use dependencies
% between pattern realizations).
%  Bieman and Wang \cite{bieman_evaluating_2004} examined the effects of pattern
% coupling. They found that couplings tend to introduce dependencies which can
% increase the fault proneness and lower the adaptability of the end product,
% and that couplings based on association (persistent couplings) are more likely
% to be change prone and exhibit higher coupling (leading to a reduced
% modification stability).

% TODO Need to talk a little about what kinds of coupling exist and produce the
% percentage of couplings that occur.

% \msusection{Refactoring}\label{sec:refactor}

% Refactoring is a term which describes behavior-preserving transformations to
% software artifacts such as source code, databases, and test code. Refactoring
% was first described by Opdyke \cite{opdyke_refactoring_1992} whose ideas where
% furthered by Roberts \cite{roberts_practical_1999}. This work is connected to
% code smells by Fowler et al. \cite{fowler_refactoring:_1999} which suggests
% that code smells are indications of source code that is dire need of
% refactoring.

% TODO Update to 2014

% TODO Link this to technical debt and reference concepts such as correction
% strategies and other strategies mentioned by Kerievsky, Fowler, Kessentini,
% and Lanza and Marinescu (at a minimum).

% \msusubsection{Automated Refactoring}\label{automate_refactor} Design defects
% for the most part have been proposed as issues that identify when refactoring
% should be applied \cite{fowler_refactoring:_1999}. Recently Lanza and
% Marinescu \cite{lanza_object-oriented_2006} have proposed more formal
% definitions for the remediation of design defects called correction strategies
% and propose several combined correction strategies for classes of design
% defects. Other works, such as Luo, Hoss, and Carver
% \cite{luo_ontological_2010} work to show the intricate relationships between
% code smells, anti-patterns, design patterns, and refactoring. Along a similar
% line Liu et al. \cite{liu_schedule_2012} developed an understanding of the
% order relationship between detection and correction of design defects. That
% is, given the correction of one set of defects this, as a side effect, may
% correct other defects not yet detected, thus making their detection redundant
% and which can reduce the overall detection search space.
%  Given the concept that we can identify algorithm approaches using code smells
% to identify when refactoring needs to take place and we can utilize the
% correction strategies defined for each defect then we can possibly marry both
% the detection and correction of design defects in a fully automated way. For
% this to occur, we must know if refactoring can be automated. In this context,
% several works have moved to show that for the most part refactoring can be
% completely automated and can be done in an efficient manner using such
% techniques as simulated annealing, genetic algorithms, evolutionary
% algorithms, and other heuristic search algorithms
% \cite{okeeffe_search-based_2008} \cite{okeeffe_search-based_2008-1}.
%  Using the knowledge that refactoring can, for the most part, be automated one
% final issue must be dealt with before it can be utilized. This final issue is
% that the behavior preservation property must be provable and must be
% automatable. This requires a formal notion of refatoring which Opdyke
% \cite{opdyke_refactoring_1992}, Roberts \cite{roberts_practical_1999}, Kataoka
% \cite{kataoka_toward_2006}, Mens \cite{mens_use_2006} and Mens and Tourwe
% \cite{mens_survey_2004} developed. Given these formalization and connection to
% design defects several works have moved to combine the two, such as: Griffith
% et. al. \cite{griffith_evolution_2011} \cite{griffith_i._truerefactor:_2011},
% Jancke \cite{jancke_smell_2010}, and Fokaefs et al.
% \cite{fokaefs_jdeodorant:_2007}.
%  Finally Mahouachi, Kessentini, and Ghedira \cite{mahouachi_new_2012} develop
% a method to automate the correction and detection of design defects. This
% approach utilizes the work by Kessentini et. al.
% \cite{kessentini_design_2011,kessentini_design_2011-1,kessentini_search-based_2011,kessentini_deviance_2010}
% to detect design defects by example. This approach incorporates automatic
% correction through automated correction strategy generation using what they
% term correction possibilities created by a genetic algorithm. This approach
% deals with the apparent disconnect between detection approaches and correction
% approaches, where they perceive that most proposed detection approaches either
% do not attempt correction or treat it as a separate step.

\section{Software Quality}\label{sec:qual_eval}

Quality models provide references that software components can be measured
against. Theoretical models such as ISO specifications
\cite{noauthor_iso/iec_2001}\cite{noauthor_iso/iec_2011} go only as far as
offering guidelines along many dimensions of quality which must be
operationalized to provide a working solution that can be used by the
engineering community. A common criticism of theoretical models is that they are
too ambiguous to be directly measurable. A comprehensive description of quality
models is beyond the scope of this paper, however Wagner
\cite{wagner_software_2013} and Ferenc et al. \cite{ferenc_software_2014} provide
a significant account and history of quality models. We selected two
operationalizations of ISO theoretical models:
SQALE\cite{letouzey_sqale_2012} and Quamoco
\cite{wagner_quamoco_2012}.

In the last decade, the research community has also observed how technical debt
has become a popular approach, supported by many tools, to track the progress of
source code development by pointing out disharmonies (i.e. code smells) that
need refactoring
\cite{marinescu_assessing_2012,de_groot_what_2012,falessi_validating_2015}.
Their remediation can either be undertaken immediately, or scheduled for a later
date at the expense of incurring debt (i.e. principal and interest)
\cite{brown_managing_2010,nugroho_empirical_2011,alves_towards_2014,kruchten_technical_2012}.
Technical debt should not be confused with software quality, as the former is a
metric that only characterizes the maintainability of a system. The new
definition of technical debt (16K definition) explicitly states that
``\emph{technical debt is a contingent liability whose impact is limited to
internal system qualities, primarily maintainability and evolvability.}"
\cite{avgeriou_managing_2016}. Although the focus of the definition is on only
one aspect of the many dimensions that make up ISO based quality models, it is
important to mention that the SQALE method to managing technical debt associates
remediation costs that affect the technical debt index of a system by using a
remediation function that takes into account all dimensions of quality, not just
maintainability \cite{letouzey_managing_2012}. The SonarQube\texttrademark\
operationalization of SQALE deviates in its calculation of technical debt by
only focusing on the technical debt ratio associated with maintainability. For a
more comprehensive comparison between technical debt calculations and quality
assessment approaches see Griffith et al. \cite{griffith_correspondence_2014}.

\subsection{SQALE}\label{subsec:sqale}
The SQALE (Software Quality Assessment based on Lifecycle Expectations) quality
model is a generic approach to modeling software quality and can be applied to
any language. It is based on the ISO/IEC 9126-1:2001 standard
\cite{noauthor_iso/iec_2001} (further referred to as ISO 9K). The approach is
based on eight code characteristics that are organized chronologically in
pyramidal form. At the bottom of the pyramid is testability, followed above by
reliability, changeability, efficiency, security, maintainability, portability
and at the top of the pyramid, reusability. Quality requirements such as
``Exception Handling shall not catch Null Pointer Exception," are associated
with characteristics in the pyramid and have a remediation cost. If more that
one characteristic is affected by a quality requirement then an association with
the lowest characteristic is formed. The characteristics at the bottom of the
pyramid represent more important dimensions of quality and are meant to aid
practitioners when prioritizing requirements that need refactoring in the code
base. SQALE is published under the open source licence and it is implemented by
many vendors. This case study uses the implementation of SonarQube's plug-in as
it has become widely adopted by organizations.

\subsection{Quamoco}\label{subsec:Quamoco}
The Quamoco quality model was developed explicitly as an extensible meta model.
Its goal was to bridge a gap between abstract concepts and measurable
attributes. The central concept of the model is a factor, meant to represent an
attribute or property of an entity; where the latter represents an important
aspect of quality we want to measure. Two types of factors exist, quality
aspects and product factors. The former represents the more abstract qualities
found in theoretical models such as the ISO standards. The latter represents the
measurable parts of a software component and have an impact on their associated
quality aspect. Factors form hierarchies; where factors can further refine some
aspect of quality. To improve modularization, the meta model is split into
modules; where the root module contains general quality hierarchies and basic
product factors. This allows practitioners to extend the root module for
specific purposes or technologies, and to focus on the qualities relevant to
their specific needs.

Quamoco's base model is an instantiation of the meta model and uses the ISO/IEC
25010:2011\cite{noauthor_iso/iec_2011} (further referred to as ISO 25K) as a
reference. It is the result of many years of collaboration by quality experts
from industry and academia, and it is comprised of a comprehensive set of
factors and measures that capture software quality assessment.

\subsection{High Level Differences between Quality Models}\label{subsec:diffs}
Quamoco and SQALE are both hierarchical models. They link issues found in
software to quality aspects and sub-aspects. Both models use this information as
a means to evaluate the quality of a software component. The more prominent
differences between these models are:

\begin{itemize}
  \item Quamoco is defined using a meta-model which characterizes quality models
  defined for different circumstances. SQALE is limited to the model imposed.
  \item SQALE is limited to the aggregation of effort estimates through
  remediation functions. Quamoco is designed to incorporate weighted  
  aggregation, ranking, and a variety of functions to describe the influence
  between aspects of the quality model.
  \item Quamoco models are defined in separate files and are hierarchical (in
  the sense that one model can inherit from another). The SQALE model is
  proprietary and built into the system.
  \item Quamoco models are defined such that an evaluation of the current level
  of quality can be provided without coaxing issues or rule violations into a
  unit-based measure. SQALE utilizes remediation effort as an index of quality,
  but its proprietary nature utilizes predefined values for each issue without
  the ability to easily tune or parameterize those values.
  \item SQALE is based on ISO 9K, and Quamoco is based on ISO 25K.
\end{itemize}
  
% \section{Software Fault Injection}
%  - What is SFI
%  - Compile-time vs. Runtime
%  - Forms
%    - Bebugging
%    - Mutation Testing
%    - Fuzzing
%  - Why Debt Injection is different (with an image)

\section{Research Gaps}
\label{sec:gaps}
The management of design pattern decay forms an important component, in the
management of software aging and technical debt, and thus warrants further
research. The following is a list of research gaps that have been identified in
this area:
\begin{itemize}
  \item Design Pattern Grime Taxonomy -- Further exploration of organizational
  and class grime types is necessary. Initial studies into these types of grime
  have not yielded any significant results, but unlike modular grime, the
  taxonomy for these types has never been fully developed.
  % \item Pattern Coupling -- Patterns are often used in conjunction with other
  % patterns [33][3]. The exploration of couplings between patterns, and the
  % effects of these couplings on grime requires further investigation.
  \item Quality -- The impact of grime on the quality of both software products
  and pattern realizations has only been subject to limited study
  \cite{izurieta_how_2007,izurieta_testing_2008,izurieta_multiple_2012,dale_impacts_2014-1,griffith_design_2014}.
  \item Technical Debt -- Current research has looked into how grime plays a
  part in the technical debt landscape \cite{izurieta_organizing_2012}. The
  effect of grime on the technical debt value of a software product and pattern
  instances has only been studied for modular grime \cite{dale_impacts_2014-1}.
  \item Relationships -- The notion that different subtypes of grime can be
  interrelated or that subtypes of grime and design defects types can be related
  is another potential area of study.
  \item Automation -- The ability to detect grime is a manual and time-consuming
  process. In part, this is due to a lack of detection tools required to
  identify instances of grime embedded in design patterns realizations.
  \item Empirical Studies -- Only a small body of work concerning empirical
  inquiry of design pattern evolution and decay has been conducted. Of these
  studies only a very small selection of systems have been studied. We expect to
  expand on the number of case studies that address design pattern specific
  issues across a diverse body of software in several languages.
  \item Experimentation -- with the exclusion of machine learning experiments,
  little to no research has been conducted to develop methods for
  experimentation in design disharmony detection and relationships to quality.
\end{itemize}

\section{Research Contributions}
Given the gaps identified in Section \ref{sec:gaps} this research proposes the
following contributions.
\begin{enumerate}
 \item The development of a framework for the automated collection of software
 artifact data, software issue data, design pattern data, and software
 measurement data (see Chapter \ref{chap:arc_framework}).
 \item The improvement of design pattern data collection and the identification
 of design pattern chains, pattern instances across versions (see Chapter
 \ref{chap:dpd}).
 \item The development of a technique for the generation of design pattern
 instances for the facilitation of design pattern experiments. This technique
 culminated in the development of domain specific languages for both RBML and a
 pattern generation cue language (see Chapter \ref{chap:dpd}).
 \item A formal benchmarking approach which injects disharmonies and pattern
 instances into software systems in order to provide both a ``gold standard" to
 compare detection algorithms against as well as providing the basis upon which
 experimentation can be conducted. Our Contribution in this area includes the
 definition of a formal metamodel (see Chapter \ref{chap:inject}).
 \item An approach to automate the detection of design pattern grime,
 culminating in a tool which detects each type of grime (see Chapter
 \ref{chap:detect}).
 \item The development of a general process for research into software artifact
 phenomena and their effects (see Chapter \ref{chap:method}).
 \item The development of an expanded taxonomy of design pattern grime (see
 Chapter \ref{chap:taxonomies}).
 \item Analysis of the impact of grime on software product quality measures. The
 quality measurement tool has been developed (see Chapters \ref{chap:quality}
 and \ref{chap:ex_grime_and_quality}).
 \item Analysis of the impact of grime on the technical debt value of a given
 software product (see Chapter \ref{chap:ex_grime_and_td}).
 \item A categorization of relationships between design pattern grime and
 design patterns types (see Chapter \ref{chap:cs_grime_relationships}).
 \item Empirical confirmation of the existence of the known subtypes of design
 pattern grime (see Chapter \ref{chap:cs_grime_buildup}).
\end{enumerate}