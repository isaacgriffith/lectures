\chapter{Collecting Design Pattern Data}
\label{chap:dpd}

\begin{quote}
\centering
\textit{Design patterns require neither unusual language features nor amazing
programming tricks with which to astound your friends and managers.}\\--Gamma
\etal \cite{gamma_design_1994}
\end{quote}

\section{Introduction}
This chapter presents our approach to collecting design pattern data from a 
software system. One of the most difficult aspects of design pattern grime 
research is collecting the initial data. Unlike other forms of phenomena 
identification which work with artifacts of the language (i.e., static analysis 
issues, code smells, or antipatterns), it is difficult to detect grime directly. 
Grime detection subdivides into two steps. The first step involves the 
collection of the raw data from a design pattern detection tool, and the second 
step involves the cleansing of the data into a form suitable for identifying 
issues such as grime.

Similarly, experimentation with grime wherein we inject the grime instances is 
also tricky. This difficulty stems from the fact in order to inject grime that 
we must first have a design pattern instance. ``Wild'' design pattern instances 
(those found in open-source or industry software) do not distribute evenly (if 
at all) across pattern types or already contain an unknown level of grime. Thus, 
it is to our benefit to have the ability to generate design patterns instances 
to alleviate these issues.

This chapter grime detection and the two primary problems note prior. The first 
problem in grime detection is the need to detect design patterns. The detection 
tool we have selected, and its underlying operation are described in Section 
\ref{sec:dpd}. This section further describes the subproblems related to pattern 
detection. These problems include evaluating the quality of the data and 
connecting pattern instances across versions of the software system. We 
alleviate these issues through the development of several techniques described 
in Section \ref{sec:dpd}. The second problem of generating design pattern 
instances, for use in experimentation, is described in Section \ref{sec:dp_gen}. 
This section further illustrates how this process integrates into the Arc 
Framework. Finally, this chapter is concluded in Section \ref{sec:dp_con}.

\section{Design Pattern Detection}\label{sec:dpd}
The first requirement to understanding and experimenting with design pattern 
grime is the ability to detect a software systems existing design pattern 
instances. Several methods have been proposed based analyzing the structural and 
behavioral aspects extracted from the software. Initially, techniques focused 
only on the structural aspects 
\cite{asencio_relating_2002,bansiya_automating_1998,beyer_simple_2003,
costagliola_design_2005,costagliola_case_2006,ferenc_design_2005,
gueheneuc_y-g_fingerprinting_2004,kaczor_efficient_2006,kramer_design_1996, 
hong_jbooret_2001,smith_spqr:_2003,streitferdt_searching_2005, 
tsantalis_design_2006,zhi-xiang_zhang_new_2004} but as research progressed 
approaches began to focus on a combination of structural and behavioral analysis 
with or without semantic analysis 
\cite{antoniol_design_1998,heuzeroth_automatic_2003,heuzeroth_generating_2003, 
huang_practical_2005,shi_reverse_2006,tonella_object_1999,wei_wang_design_2005,
wendehals_improving_2003,seemann_pattern-based_1998,blewitt_automatic_2001,
dong_dp-miner:_2007,dong_visualizing_2007}. 

Upon reviewing the available methods and their proposed tools, we selected the 
Similarity Scoring Approach (SSA) as implemented by Tsantilis \etal 
\cite{tsantalis_design_2006} in their tool Pattern4. This tool was selected to 
fulfill the following requirements: (i) simple, quick execution separate from 
other tools such as IDEs, (ii) executable at the command line, (iii) capable of 
detecting a majority of the GoF design patterns, (iv) capable of analyzing Java 
software systems, and (v) ease of processing results. The Pattern4 tool fulfills 
these requirements, and next, we discuss its underlying algorithm.


% \subsection{Our Process}
% 
% Our design pattern detection process combines multiple existing techniques into
% a cohesive Map/Reduce pipeline. The process, as depicted in Figure
% \ref{fig:dpdmr}, works as follows:
% \begin{enumerate}
%  \item We start by extracting a graph representation of the software using
%  static analysis.
%  \item Once this model has been extracted, graph clustering is applied to
%  identify components which are potentially portions of design pattern instances.
%  \item We evaluate each of the components to determine if they contain potential
%  \textit{elemental design patterns} (EDP).
%  \item For each identified potential EDP we apply a similarity scoring algorithm
%  to evaluate the likelihood that the identified component contains a given EDP.
%  We then reduce the potential EDP set for each component using a thresholding
%  approach in conjunction with a maximum filter. Each identified EDP is placed
%  into a set containing instances of that EDP type.
%  \item Each EDP type is linked to a Pattern type, so we then map the identified
%  EDP instances to potential pattern types. Each potential pattern instance is
%  formed by combining connected EDP instances (which are connected by
%  associations, dependencies, generalizations, or realizations).
%  \item We then apply the similarity scoring algorithm to each potential pattern
%  instance to evaluate the likelihood that a pattern instance of the given type
%  has been found. Using a thresholding and maximum filtering approach we reduce
%  the set of scored patterns down to a set of high-likelihood pattern instances.
%  \item At this point we further reduce the set of pattern instances by applying
%  structural and behavioral constrains (for verification of a pattern instance).
%  These constraints are determined by the RBML specification of the pattern type
%  the instance is associated with.
%  \item We then arrive at the final set of pattern instances to be evaluated.
% \end{enumerate}
% 
% \begin{figure}
%  \centering
%  \includegraphics[scale=3.75]{experimental_process/dpd.png}
%  \caption{Design Pattern Detection Map/Reduce Pipeline}\label{fig:dpdmr}
% \end{figure}

\begin{singlespaced}
\begin{algorithm}[tb]
 \caption{Similarity Scoring Algorithm
 \cite{tsantalis_design_2006}}\label{alg:ssa}
 \begin{algorithmic}[1]
  \Require{A: an $n_{A} \times n_{A}$ matrix of a pattern specification graph $G_{A}$}
  \Require{B: an $n_{B} \times n_{B}$ matrix of a system graph $G_{B}$}
  \Ensure{$\mathcal{S}$: an $n_{A} \times n_{B}$ real valued matrix of normalized similarity scores, in range $[0,1]$, where $s_{ij}$ represents the similarity between vertex $j$ in $G_{A}$ and vertex $i$ in $G_{B}$}
  \Statex
  \Function{SimilarityScore}{$A$, $B$}
    \State $A \leftarrow $ \Call{adjMatrix}{$G_{A}$}
    \State $B \leftarrow $ \Call{adjMatrix}{$G_{B}$}
    \State $Z_{0} \leftarrow 1$ // $n_{B} \times n_{A}$ matrix of all 1's
    \Repeat
      \State $Z_{k+1} \leftarrow \frac{BZ_{K}A^{T} + B^{T}Z_{K}A}{||BZ_{K}A^{T} + B^{T}Z_{K}A||_{1}}$ // for an even number of times
    \Until{$convergence$}
    \State $\mathcal{S} \leftarrow Z_{K}$
    \State \Return $\mathcal{S}$
  \EndFunction
 \end{algorithmic}
\end{algorithm}
\end{singlespaced}

The Pattern4 tool employs SSA, as shown in Algorithm \ref{alg:ssa}, to detect 
design patterns given knowledge of their structure. Structural knowledge encodes 
a pattern definition through a set of four structural design matrices: (i) 
associations between class roles, (ii) generalizations between class roles, 
(iii) abstract class roles, and (iv) similar abstract method invocations between 
classes. This data is extracted by the tool using Java\texttrademark\ reflection 
and resulting in a graph of the software system. 

This graph is processed using a set of heuristics (such as starting with 
generalization hierarchies) to locate candidate pattern instances. From these 
candidate pattern instances, it derives their structural matrix representations. 
The extracted matrices and pattern-specific matrices (as an example, see Figure 
\ref{fig:ssa_example}) act as input to the SSA Algorithm. The algorithm compares 
these matrices and results in a similarity score for each pattern type. A 
pattern type that scores above a particular threshold, for a particular 
candidate instance, is assigned to that instance.


\begin{figure*}[!tb]

\centering
    \begin{subfloat}[Associations]{
    	\label{fig:ssa_exA}
        \includegraphics[width=0.45\textwidth]{dpd_images/ssa_ex_assoc}
        }
    \end{subfloat}%
    ~ 
    \begin{subfloat}[Generalizations]{
    	\label{fig:ssa_exB}
        \includegraphics[width=0.45\textwidth]{dpd_images/ssa_ex_gen}
        }
    \end{subfloat}%
    \\
    \begin{subfloat}[Abstract Classes]{
    	\label{fig:ssa_exC}
        \includegraphics[width=0.45\textwidth]{dpd_images/ssa_ex_abstract}
        }
    \end{subfloat}%
    ~ 
    \begin{subfloat}[Similar Abstract Method Invocations]{
    	\label{fig:ssa_exD}
        \includegraphics[width=0.45\textwidth]{dpd_images/ssa_ex_method}
        }
    \end{subfloat}%

\caption{Example matrix breakdown of the Abstract Factory Pattern. The circles
(nodes) in each graph represent class roles, and links represent the presence
of that type of connection (Association, Generalization, Abstraction, Method
Invocation).}\label{fig:ssa_example}
\end{figure*}

The actual pattern instances, once identified, are then encoded into an XML file 
composed of a single \textit{project} tag, within which are a series of 
\textit{pattern} tags (one for each of the 16 pattern types). Each pattern tag 
is composed of multiple \textit{instance} tags. Each \textit{instance} tag is 
composed of a series of \textit{role} tags. \textit{role} tags each map the 
named Role to an element within the software system (a class or a method). 
Although this process works well and is capable of identifying design pattern 
instances, it is not without its shortcomings. In the following section, we 
address these shortcomings and discuss our approaches to alleviating them.

\subsection{Data Cleansing}
We have identified three major shortcomings through our use of the Pattern4 
tool. The tool's results produced appear, anecdotally, to consider certain 
pattern instances as more than one instance. That is, in cases where 
generalization hierarchies form a main body of the pattern, the tool appears to 
identify multiple pattern instances based on the subtypes, rather than finding a 
single instance based on the root of the hierarchy. The second shortcoming of 
this tool is the lack of identification of several \textit{optional roles} (c.f. 
\ref{subsec:pattern_chains}) along with abstract roles providing generalization 
hierarchies in the pattern specification. The final issue is the inability of 
the tool to report on patterns implemented through language idioms (i.e., an 
observer pattern implemented in Java\texttrademark\ using the Observable 
interface). Although we cannot alleviate the third shortcoming, we alleviate the 
first two through an algorithmic approach based on RBML.

Our approach implements RBML using a YAML specification. These specifications 
provide the framework, along with mappings between RBML roles and Pattern4 
instance roles, the capability to validate detected pattern instances. These 
instances detected using the Pattern4 tool and collected from a result XML file. 
The resulting roles map from their Pattern4 names to the RBML names and connect 
to the identified data model components extracted from the XML file. This 
mapping provides the necessary information to construct pattern instances in the 
 Arc data model. These initial PatternInstances are used as input to the Pattern 
Coalescing Algorithm, as shown in Algorithm \ref{alg:alg_dp_inst_coal}.

\begin{singlespaced}
\begin{algorithm}[tb]
 \caption{Pattern Instance Coalescing Algorithm}\label{alg:alg_dp_inst_coal}
 \begin{algorithmic}[1]
  \Require{$\mathcal{R}$: Result set of Pattern Instances from Pattern
  Detection}
  \Statex
  \Procedure{Coalesce}{$\mathcal{R}$}
    \State $map \gets $ \Call{partition}{$\mathcal{R}$}\Comment{pattern instances keyed by pattern type}
    \ForAll{$(k, \mathcal{P})\in map$}
    	\ForAll{$p\in \mathcal{P}$}
    		\State $p \gets $ \Call{expand}{p}\Comment{Expand each instance}
    	\EndFor
    \EndFor
    \ForAll{$(k, \mathcal{P})\in map$}
    	\State $\mathcal{P} \gets \mathcal{P} \setminus
    	$\Call{compareAndCombine}{$\mathcal{P}$}
    \EndFor
    \State $\mathcal{R} \gets map.values$
    \State \Return $\mathcal{R}$
  \EndProcedure
 \end{algorithmic}
\end{algorithm}
\end{singlespaced}

The algorithm uses the initial PatternInstances to identify instances sharing a 
common subset of roles and pattern type that can coalesce. Coalescence uses a 
two-pass approach, as follows. First, the set of candidate pattern instances 
uses pattern type to form partitions. Once partitioned, the algorithm uses 
contained generalization hierarchies to control expansion (at line 5 of the 
algorithm). Expansion occurs in both directions (up and down the generalization 
and across associations). The pattern instance adds each class, which is not 
already a member (if the class fulfills a role in the pattern, as defined by the 
RBML). Next, the process of combining pattern instances begins.

For each pattern type and the instances assigned to that pattern type, we call 
the method \textit{compareAndCombine(\ldots)}. This method takes a set of 
pattern instances as input and compares each pair, merging those which share a 
common set of classes. Finally, the algorithm updates both $map$ and the set 
$\mathcal{R}$ to reflect the current set of complete instances, returning 
$\mathcal{R}$. 

\subsection{Pattern Chains}\label{subsec:pattern_chains}
A part of the research herein is to evaluate the evolution of design patterns. 
The evolution of a single design pattern instance, observed at discrete instants 
of time (i.e., releases), forms a sequence, which we call a \textit{pattern 
chain}. A pattern chain provides a useful concept for evaluating the evolution 
of a pattern instance but adds a layer of complexity in the process. This 
complexity stems from the requirement to both identify patterns across 
observations, a process we call \textit{pattern tracking}.

Tracking pattern instances across observations require that we define a 
\textit{pattern instance identity}. An initial definition, derived from the 
specification of the parent pattern type, can be simply stated as a set of 
Classifier Roles, Feature Roles (fulfilling the field and methods within the 
classifiers), and Relationship Roles. A pattern instance is then a mapping from 
the entities in the RBML roles to the actual artifacts in the software system, 
which is called a \textit{binding}. 

For a binding to work as the definition of an instance's identity, we must 
consider role types. A role is either optional or mandatory, where a 
\textit{mandatory role} plays a role contributing to a design pattern 
specification with a multiplicity having a lower bound greater than or equal to 
1. Having a lower bound multiplicity of 0, on the other hand, indicates an 
\textit{optional role}. A \textit{role binding} refers to the pairing of a role 
with a component in the system. Putting this together, we define a 
\textit{Pattern Instance Identity} as \textit{the collection of role bindings 
for all mandatory roles in the pattern specification.}

This definition works well for a single version of a software system. It 
provides a distinction between both pattern instances of the same type and 
pattern instances of the same type. Such a distinction is necessary, but also 
insufficient to distinguish among the same pattern instance across multiple 
versions of a software system. Thus we need to refine the notion of identity 
further. 

Across multiple versions of a system the core identity component, the set of 
role bindings, may change in size as the pattern evolves. This change in size 
presents a significant problem in tracking the pattern. To address this we 
define the \textit{pattern chaining operator}, $\prec_{p}$, such that for any 
two pattern instances $P_1$ and $P_2$, $P_1 \prec_{p} P_2$ indicates that $P_1$ 
precedes $P_2$ in the chain and that $P_1$ and $P_2$ are the same pattern 
instance separated by versions of the software. The semantics of this operator 
is defined as follows: $P_{1} \prec_{p} P_{2} \equiv \left[\left(B(P_1) 
\subseteq B(P_2)\right) \wedge \left(B(P_1)_m \setminus B(P_2)_m = 
\varnothing\right)\right]\vee \left[\left(B(P_2) \subseteq B(P_1)\right) \wedge 
\left(B(P_2)_m \setminus B(P_1)_m = \varnothing\right)\right]$. Where, $B(X)$ is 
the set of role bindings for pattern instance $X$ and $B(X)_m$ is the set of 
role bindings for pattern instance $X$ concerning only those roles which meet 
the previous definition of mandatory roles. This operator is designed to 
encompass the logic of identifying a pattern instance as it either grows or 
shrinks throughout its evolution. 

Pattern evolution creates 5 cases to address. (i) The pattern expands by adding 
new role bindings. (ii) The pattern shrinks by removing role bindings. (iii) The 
pattern remains unchanged. (iv) The pattern no longer exists, or (v) the pattern 
reappears. In the first case (expansion), a chain links two versions of a 
pattern instance, $P_1$ and $P_2$. This link occurs iff either the set of role 
bindings of $P_1$, $B(P_1)$, is a subset of the role bindings of $P_2$ and the 
set difference between the set of role bindings for mandatory roles of $P_1$ and 
the set of role bindings for mandatory roles of $P_2$ is the empty set. Thus, 
for expansion, the prior version of the pattern instance should contain the same 
role bindings as the following version and thus will be a subset of the 
following version. Furthermore, the difference in mandatory roles (those 
comprising the identity of an individual version), when using symmetric set 
difference focusing on the following version, $P2$, the difference should be the 
empty set. A similar line of reasoning follows for the second case, but we swap 
the versions as we expect the pattern to be contracting, and thus role bindings 
have been removed. These two cases are indicated in the pattern chaining 
operator by the clauses separated by the primary or operator. Additionally, the 
first two cases capture the third case. The fourth and fifth cases require the 
tracking approach to look at all chains (including those which have ended) as 
possible chain candidates.

\begin{singlespaced}
\begin{algorithm}[tb]
 \caption{Pattern Instance Chaining Algorithm}\label{alg:alg_chaining}
 \begin{algorithmic}[1]
  \Require{$\mathcal{P}$: Current project under analysis}
  \Statex
  \Procedure{ChainDetection}{$\mathcal{P}$}
    \State $s \gets \mathcal{P}.system$
  	\State $chains\gets s.\textrm{patternChains}$
    \If{$chains = \varnothing$}
    	\State \Call{createChains}{$\mathcal{P}.patterns$}
    \Else
	  	\ForAll{$p\in \mathcal{P}.patterns$}
	    	\State $chain\gets \varnothing$
	        \ForAll{$c\in chains$}
	        	\If{$c.matches(p)$}
	            	\State $chain\gets c$
	                \State \textbf{break}
	            \EndIf
	        \EndFor
	        \If{$chain \ne \varnothing$}
	        	\State $chain\gets p$
	        \Else
	        	\State $chains\gets $ \Call{createChain}{$p$}
	        \EndIf
		\EndFor
	\EndIf
  \EndProcedure
 \end{algorithmic}
\end{algorithm}
\end{singlespaced}

Algorithm \ref{alg:alg_chaining} defines the process for constructing pattern 
chains. This algorithm takes as input the Project under analysis, which is 
associated with a particular version of a software system. As depicted in 
Chapter \ref{chap:arc_framework} Figure \ref{fig:pattern_data} each project is 
contained with a System, and that System also contains a collection of 
PatternChain(s). Each PatternChain is composed of a set of PatternInstances 
forming the chain across each of the Projects. Thus, we can extract all the 
needed information from the Project alone.  Initially, the provided Project is 
used to extract the parent System. The System provides its set of PatternChains, 
to the variable $chains$. If the set is empty, then this is the first version 
(or Project within the System) to be processed. At this point, the algorithm 
constructs a new chain per individual unknown pattern instance, as detailed in 
Lines 6 through 21.

In the case of existing chains, for each pattern instance in the Project, the 
algorithm determines if it is a member of an existing chain or the start of a 
new chain. Thus, for each chain in the set of known pattern chains, the 
algorithm determines if the current pattern instance, $p$, matches the chain. 
The \textit{matches(\ldots)} operation is an implementation of the pattern 
chaining operator which tests whether $p_{-1} \prec_p p_0$, where $p_{-1}$ is 
the previous version's pattern instance in the chain and the current version, 
$p_0$. In the case of a match, the algorithm sets the variable $chain$ to the 
match, and the algorithm stops searching. Otherwise, the algorithm will continue 
searching for a match. If there is a match, the algorithm adds the current 
pattern instance, $p$, to that chain. Otherwise, the pattern instance starts a 
new chain.

In the following subsection, we discuss how the pattern detection tool, pattern 
coalescing algorithm, and pattern chaining algorithm work together. We also 
discuss the combination of these three components via their integration into the 
Arc Framework.

\subsection{Integration into Arc}
The goal of the described tools is to provide the capability for pattern data 
collection. Pattern data collection is a small part of the larger data 
collection framework, including related software quality measurements, metrics 
measurements, and issues affecting the software product, as described in Chapter 
\ref{chap:arc_framework}. Thus, to further complete the Arc framework, pattern 
data collection is integrated as follows.

Figure \ref{fig:p4arc} depicts the Pattern4 tool integration, and  execution 
flow. The flow, the numbers encircled in green, is as follows: 1.) The system 
initializes the \textit{DPDTool} which then initializes the components: 
\textit{Pattern4Command} and \textit{Pattern4Collector}. 2.) The 
\textit{Pattern4Command} then executes the design pattern detection process 
embodied in \textit{Pattern4Tool}. 3.) The \textit{Pattern4Tool} executes the 
command line Pattern4 tool across the compiled version of the Project, which 
generates the Results XML file. 4.) The \textit{Pattern4Collector} then reads 
these results. 5.) The \textit{Pattern4Collector} utilizes the data from the 
results XML file and 6.) the Component Table(s) and Project Table of the ArcDb 
to generate candidate PatternInstance(s). 7.) These candidate PatternInstances 
are then passed to the \textit{Pattern4Command}. 8.) The 
\textit{Pattern4Command} executes the \textit{InstanceCoalesce} algorithm (see 
Algorithm \ref{alg:alg_dp_inst_coal}) to reduce the set of candidate instances 
to the set of actual pattern instances. 9.) The final set of PatternInstances is 
entered into the Arc data model and passed through the \textit{PatternChaining} 
algorithm (see Algorithm \ref{alg:alg_chaining}) to produce new pattern chains 
or expand existing chains. 10.) Finally, the created or expanded chains are then 
entered or updated in the Arc data model.

\begin{figure}[!tb]
 \centering
 \includegraphics[width=\textwidth]{arc_images/pattern4_integration}
 \caption{Integrating Pattern4 and Design Pattern Data
 cleansing into Arc.}\label{fig:p4arc}
\end{figure}

\subsection{Summary}
This section detailed the pattern data collection approach. This approach 
includes the ability to cleanse the data, ensuring that identified pattern 
instances are complete and accurate. This set of pattern instances forms pattern 
chains across software versions to provide the capability to observe pattern 
evolution. Each component of this approach is integrated into the Arc framework 
to provide the ability to integrate pattern data with the other forms of 
information collected. In the following section, we consider the issue of 
collecting a large enough sample of design pattern instances necessary to 
conduct experiments with design patterns, which leads to an approach for design 
pattern instance generation.

\section{Design Pattern Generation}\label{sec:dp_gen}
Design pattern generation, or a curated collection of verified and validated 
pattern instances, is required as the raw data necessary for design pattern 
experimentation. Experiments evaluating the effects of phenomena, such as design 
pattern grime, on pattern instance measures (such as quality or technical debt) 
require a large sample of each type of pattern. Such a sample, in the naive 
approach, would require data collection across a vast number of software 
projects to identify the number of instances needed. One approach would be to 
utilize existing curated design pattern data sets such as the Percerons 
repository \cite{ampatzoglou_building_2013}. Unfortunately, even this repository 
is limited in the number of collected pattern instances per pattern type and is 
not necessarily free of error due to manual curation. To overcome these 
limitations, we have developed a method using RBML specifications to generate 
design pattern instances that integrates into the Arc framework. This 
integration, the supporting architecture, and the method itself described in the 
following subsections.

\begin{figure}[!tb]
 \centering
 \includegraphics[width=\textwidth]{dpd_images/pattern_gen_cd}
 \caption{Pattern Generation class diagram.}
 \label{fig:pattern_gen_cd}
\end{figure}

\subsection{Design Pattern Generation Architecture and Method}
\label{sec:dp_gen_proc}

Figure \ref{fig:pattern_gen_cd} depicts the design pattern generation 
architecture. The architecture's controlling component is the \textit{Generator} 
class. This class contains a set of \textit{AbstractLanguagePlugin} classes. 
Each class implementing this abstract class, \ie \textit{JavaPlugin}, provide 
four components. The first component is the \textit{AbstractDirStructGenerator}, 
which generates the project directory structure and its containing files. The 
generation of these files requires language-specific functionality. In the case 
of Java\texttrademark\, we have two separate implementations, one for Maven and 
one for Gradle. Both implementations use a language-specific implementation of 
\textit{AbstractFileGenerator}, the second component, to generate basic project 
files (such as a ``README.md'' file). After file generation, the 
\textit{AbstractPatternGenerator}, the third component, provides the logic for 
design pattern generation and is used to generate the data model constructs.

These generated constructs are then placed in the ArcDb and are used by the 
final component, the \textit{AbstractSourceBuilder}. The 
\textit{AbstractSourceBuilder} executes a collection of 
\textit{AbstractArtifactBuilder}(s) to realize the physical file and directory 
contents as represented in the data model. \textit{AbstractArtifactBuilder} is 
specialized into subtypes corresponding to the data model source artifact 
components. The \textit{AbstractSourceBuilder} utilizes the 
\textit{ArtifactBuilderFactory} to construct each of the 
\textit{AbstractArtifactBuilder}(s). Currently this process is only setup for 
the Java\texttrademark\ language, but it can easily be extended to other 
languages. The overall generation is described by Algorithm \ref{alg:alg_gen}.

\begin{singlespaced}
\begin{algorithm}[tb]
 \caption{Pattern Generation Algorithm}\label{alg:alg_gen}
 \begin{algorithmic}[1]
  \Require{$\mathcal{R}$: RBML Pattern Specification}
  \Require{$\mathcal{L}$: PGCL Pattern Cues}
  \Statex
  \Procedure{GeneratePattern}{$\mathcal{P}$}
    \State $cue \gets$ \Call{selectCue}{$\mathcal{L}$}
    \State \Call{initialize}{$cue$}
    \State $sys \gets$ \Call{createSystem}{$ $}
    \State \Call{createProject}{$sys$}
    \State $map \gets [\,:\,]$
    \ForAll{$j \in \mathcal{R}.joins$}
    	\State $map[j.shared] \gets$ \Call{selectOrCreateType}{j.shared}
    	\ForAll{$b \in j.blocks$}
	    	\If{$b.src = j.shared$}
	    		\State $map[b.dest] \gets $ \Call{selectOrCreateType}{$b.dest$}
	    		\State \Call{createRelation}{$j.shared$, $b.dest$, $b.rel$}
	    	\Else
	    		\State $map[b.src] \gets $ \Call{selectOrCreateType}{$b.src$}
	    		\State \Call{createRelation}{$b.src$, $j.shared$, $b.rel$}
	    	\EndIf		    	
		\EndFor
    \EndFor
  \EndProcedure
 \end{algorithmic}
\end{algorithm}
\end{singlespaced}

This algorithm requires both the RBML pattern specification and the Pattern Cues 
for the pattern type to be constructed. RBML, as described in Chapter 
\ref{chap:background} is used to specify design patterns through an extension to 
the UML combined with OCL. Pattern Cues, specified by the Pattern Generation Cue 
Language (PGCL), as defined in Section \ref{sec:pgcl}, provide additional 
direction to the pattern generation process concerning language specific 
implementation details. A DSL provides the capability used to express these 
specifications as external Groovy scripts. These scripts are loaded at runtime 
by the generation system and provided to the algorithm. The algorithm outputs 
data model constructs and their physical representations in a constructed 
project root and source files. This process, as detailed in the algorithm, 
consists of two parts.

The first part initializes the generator. The algorithm selects one of the cues 
(at random) from the PGCL script provided. Next, the algorithm constructs the 
system and project by calling the \textit{createSystem()} and 
\textit{createProject()} methods, respectively. Once the generator is 
initialized the second part of the process commences.

The second part constructs the components represented in source code. This 
process starts by iterating across each joined set of \textit{role blocks} 
(model blocks sharing a common classifier role). A \textit{role block} is a 
relationship role connecting a pair of classifier roles (which may be the same 
Role). When creating the source and destination types, the 
\textit{selectOrCreateType(\ldots)} method is called. This method selects an 
existing Type (fulfilling the required Role) that does not participate in a 
model block fulfilling the current relationship Role. Otherwise, this method 
creates a new Type (class, interface, or enumeration) as long as the 
multiplicity upper bound of the Role is not exceeded. Once the source and 
destination roles are created/selected, the algorithm constructs the relation 
between them using the \textit{createRelation(\ldots)} method.

These creation methods (\textit{createOrSelectType() and createRelation()}) 
produces two components. The first is an instance of one or more entities from 
the Arc data model. The second component is the physical representation of that 
item (whether it be folders, files, or file contents) on disk generated using a 
set of language-specific templates. These templates use PGCL cues to augment 
their output. Thus, once this algorithm is complete for a given pattern, a 
buildable project exists on disk, and the necessary components exist within the 
ArcDb.

\subsection{Pattern Generation Cue Language}\label{sec:pgcl}
Design patterns help software engineers address commonly occurring design 
problems through a set of general solutions \cite{gamma_design_1994}. This layer 
of abstraction had led to a variety of known implementation approaches of each 
pattern type in a given language (where some are better than others). To address 
language-specific implementation details and to guide generation using 
well-known implementation methods, we created a Groovy DSL. This language's \mm\ 
is depicted in Figure \ref{fig:pgcl_mm}.

\begin{figure}[!tb]
	\centering
	\includegraphics[width=\textwidth]{dpd_images/pgcl_mm}
	\caption{Pattern Generation Cue Language \mm .}
	\label{fig:pgcl_mm}
\end{figure}

The primary components of this language, as defined in the \mm , are the 
\textit{CuePattern}, \textit{Cue}, and \textit{CueRole}. The \textit{CuePattern} 
shares its name with a given Pattern and contains a collection of 
\textit{Cue}(s). Each \textit{Cue} has a name describing it and contains a 
collection of \textit{CueRole}(s). A \textit{CueRole} defines a section of code 
which replaces the default implementation provided by the internal generator 
templates when data model components are translated to code. When initialized a 
\textit{CueRole} adds an event listener attached to a given role defined in the 
Pattern's RBML specification, which when processed fires the event. When an
event fires, \ie ``FieldsComplete'', either the content or definition values 
held in the \textit{CueRole} will replace the default generated content. In 
addition to replacement, a CueRole can also specify that the role should be 
disregarded when generation occurs, based on the value of the \textit{CueRole}'s 
\textit{disregard} flag.

\begin{figure}[!tb]
\centering
\begin{lstlisting}[language=pgcl]
pattern "Singleton", {
  cue "eagerInit", {
    role "ConcreteSingleton", event: "FieldsComplete", content: '''\
	private [InstName]() {
	}'''

    role "ConcreteSingleton::Instance", definition: '''\
	private static final [TypeName] instance = new [TypeName]();'''

    role "ConcreteSingleton::GetInstance()", content: "return instance;"
  }
}
\end{lstlisting}
\caption{Example PGCL script for an eager initialized singleton instance.}
\label{fig:pgcl_ex}
\end{figure}

Figure \ref{fig:pgcl_ex} depicts an example of the PGCL for a 
Java\texttrademark\ specific implementation of an eagerly initialized Singleton. 
The example begins with the definition of the pattern and the pattern's name 
``Singleton". Within this is the Cue ``eagerInit". The ``eagerInit" cue 
specifies three CueRoles. The first specifies that the PGCL overrides the 
content of the ``ConcreteSingleton" with the content provided. This overriding 
behavior initiates after field generation for any type bound to the 
``ConcreteSingleton" pattern role. A new private constructor replaces the 
content with an empty body. The second CueRole overrides the default 
implementation of the ``ConcreteSingleton::Instance" field role, and defines 
that field using the private constructor. The final CueRole provides an override 
for the Role ``ConcreteSingleton::GetInstance()" such that it simply returns the 
``instance" field. This example is only one of the cues 
for a singleton, but the full definitions for each of the 16 design patterns 
(evaluated in Chapters \ref{chap:ex_grime_and_quality} and 
\ref{chap:ex_grime_and_td}) are defined in Appendix \ref{app:pgcl}.

% \subsection{Role Based metamodelling Language}\label{sec:rbml}
% 
% \subsubsection*{Example}

\subsection{Integration into the Arc Framework}

\begin{figure}[!tb]
	\centering
	\includegraphics[width=.45\textwidth]{arc_images/patterngen_integration}
	\caption{Integration of the Pattern Generator with the Arc Framework.}
	\label{fig:patterngen_integrate}
\end{figure}

Figure \ref{fig:patterngen_integrate} depicts the integration of the pattern 
generation components and their flow of execution. This flow, the sequence of 
numbers encircled in green, is as follows. 1.) The \textit{PatternGenTool} 
provides the framework with an instance of the \textit{PatternGenCommand}. 2.) 
The \textit{PatternGenCommand} provides an interface between the pattern 
generation process and the ArcDb data model. It also executes the 
\textit{PatternGenerator}. 3.) The \textit{PatternGenerator} controls the 
execution of the pattern generation process. 4.) This process begins by loading 
two files for each pattern type to be created: the pattern-specific RBML and 
PGCL files. 5.) The results of this process are the creation of the project 
directory and supporting files, and the construction of pattern source code 
artifacts. These artifacts also have representation in the Arc data model. Steps 
4 and 5 of this process repeated for each pattern instance needed.

\section{Conclusion}\label{sec:dp_con}
In this chapter, we detailed the underlying methods and tools used to extract 
pattern data from software systems. Such data collection is not without its 
limitations. Specifically, collecting enough raw design pattern instances for 
experimentation is difficult and time-consuming. To alleviate this, we have 
detailed the development of a pattern instance generation algorithm. Though this 
algorithm and its results are necessary during experimentation, case studies 
require ``wild'' instances of patterns. To collect these ``wild'' instances from 
actual software systems, we identified the design pattern detection tools which 
will identify the raw instances. To improve the results of this and to cleanse 
the data set, we detailed the pattern coalescence algorithm, which also provides 
the ability to construct pattern chains. With these tools in place, we are 
capable of exploring the effects of grime on pattern instances.
