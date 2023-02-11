\chapter{The Arc Experimentation Framework}\label{chap:arc_framework}

\begin{quote} \centering \textit{The study of software engineering is a 
laboratory science.}\\--Professor Victor R. Basili \end{quote}

\section{Introduction}\label{sec:mqtd_ex_runner} This chapter details the inner 
workings of the Arc Experimental Framework. The Arc framework, simply put, is a 
tool execution and data aggregation framework. This framework was designed and 
implemented with the following goals in mind: (i) execution of internal and 
external tools, (ii) data model definition for tool results, (iii) aggregation 
of these results into the higher-level measurements, and (iv) process 
automation. Other tools, such as SonarQube\footnote{\url{https://sonarqube.org}} 
and Jenkins\footnote{\url{https://jenkins.io}}, share these goals, and although 
they provide similar capabilities, they do not provide the level of detail and 
level of automation provided by the Arc framework.

\paragraph*{Organization} This chapter is organized as follows. Section 
\ref{sec:mqtd_ex_runner} describes the underlying architecture of the Arc 
Framework. The framework defines a data model through which all of our data may 
be persisted, described in Section \ref{sec:data_model}. The described data 
model, to be useful, is utilized by a tool execution and workflow-based process, 
as discussed in Section \ref{sec:workflows}. Section \ref{sec:mqtd_exr_tools} 
describes the integration of various Java\texttrademark software analysis tools 
into the Arc framework. Finally, Section \ref{sec:arc_framework_conclude} 
concludes this chapter.

\section{Arc Architecture}\label{sec:mqtd_exr_arch}
The Arc framework provides a platform to collect software engineering artifact 
data. This data is to be used to conduct or prepare to conduct experiments and 
observational studies. These studies necessitate that we collect data related to 
software projects (across multiple versions), including software metrics and 
their measurements, results of static analysis, results of pattern detection, 
and results from software quality analysis. Although each of these types of data 
is necessary for our work, we also note that the framework must be extensible to 
provide the capability to add new forms of data later.

Each of these data requirements leads to the underlying architecture for the Arc 
Framework, as depicted in Figure \ref{fig:arc_framework}. This Figure is a very 
high-level conceptual view, which shows the various data types contained within 
the \textit{Arc Db} provided via a series of commands/tools executed using a 
workflow process, and interacting with a well-defined data model. The key to 
this framework is the workflow and command structure.

\begin{figure}[!t]
    \centering 
    \includegraphics[width=0.75\textwidth]{arc_images/arc_arch} 
    \caption{Illustration of the overall Arc conceptual framework.}
    \label{fig:arc_framework}
\end{figure}

\section{Workflows}\label{sec:workflows} The workflow process of the Arc 
Framework is based upon the metamodel depicted in Figure 
\ref{fig:workflow_model}. The basic component of this model is the 
\textit{Workflow}, which contains a sequence of \textit{Phases}, each of which 
can contain a list of \textit{Command}(s). Along with Commands is the concept of 
\textit{Collectors}. Essentially, Commands are the component which executes any 
portion of a workflow to prepare the System for the collection of data. Data 
collection provided by a subtype of Command known as a Collector, which collects 
tool output into the data model.

\begin{figure}[!tb]
    \centering 
    \includegraphics[width=\textwidth]{arc_images/workflows} 
    \caption{Workflow model}
    \label{fig:workflow_model} 
\end{figure}

The \textit{Command} structure, as depicted in \ref{fig:workflow_model}, is 
divided into three distinct parts. The first are the \textit{ToolCommand}(s) 
which are based on an externally defined command line driven tool. Second, are 
the commands in the \textit{AbstractCommand} hierarchy consisting of the five 
subtypes: \textit{PrimaryAnalysisCommand}, \textit{SecondaryAnalysisCommand}, 
\textit{RepositoryCommand}, \textit{ArtifactIdentifierCommand} and
\textit{BuildCommand}. Finally, there are the Collectors which extract data from 
results files into the data model. We next further describe the 
\textit{AbstractCommand} hierarchy.

The \textit{AbstractCommand} hierarchy decomposes non-tool command types into 
five distinct subtypes. The first is \textit{PrimaryAnalysisCommand} is the base 
conceptual class representing a tool or command which collects data related to 
immediately observable aspects of a software project. An example of such an 
aspect, are basic code metrics such as Lines of Code or Number of Methods. Thus, 
an instance of a PrimaryAnalysisCommand would be a metrics measurement tool or 
tool which extracts the underlying structural information of a software project. 
Next, the \textit{SecondaryAnalysisCommand} is the base conceptual class 
representing a tool or other command which utilizes the results of 
PrimaryAnalysisCommands along with other data collected locally to evaluate 
derived measures. An example of such a command would be a 
command which executes a Software Quality or Technical Debt analysis. 
Next, \textit{RepositoryCommand} is the base command for accessing the commands 
of a source code management library such as \textit{git}, \textit{mercurial}, or 
\textit{subversion}. Next, \textit{ArtifactIdentifierCommand} is the base class 
for those tools which identify file based artifacts within a project directory. 
Lastly, the \textit{BuildCommand} is the base class for tools based on the 
libraries used to execute or analyze build and dependency management tools. 
Beyond the tools of the \textit{AbstractCommand} hierarchy are the 
\textit{Collectors}.

\textit{Collectors} collect the output a tool produces. This output is 
preprocessed and then inserted into the data model. At this time, there is only 
one base class, \textit{FileCollector}, which extracts information from tool 
output files. An example of this is the SpotBugsFileCollector. The SpotBugs tool 
executes across the binary class files of a project via a ToolCommand 
implementation. As SpotBugs executes, it writes the results of its analysis to a 
temporary XML file. This file contains a set of rule violations and the location 
in the program where the violation occurred. For each violation, the 
SpotBugsCollector generates a Finding. Each Finding links to a Reference 
representing the artifact where the violation occurred.  The SpotBugsCollector 
stores these pairs in the data model.  Once the data is stored, the collector 
deletes the intermediary results file.

\subsection{Example Workflow}\label{sec:workflow_example} A workflow is simply a 
composition of several phases, which are then composed of several commands. 
These commands either read or write data to the data model. Thus, a typical Java 
workflow would look something like the one depicted in Figure 
\ref{fig:java_workflow}.

This example defines a workflow named ``Java Example'' which contains three 
phases: ``prelim'', ``primary analysis'' and ``secondary analysis''. The 
``prelim'' phase works in sequence, first cloning the git repository, then 
identifying any artifacts in the project, then executing a parser to extract the 
java components from the code, and finally building the project for later 
analysis.

\begin{figure}[!tb] \begin{lstlisting}[language=flow]
workflow 'Java Example' { 
    phase 'prelim' { 
        git()
        java_ai()
        java_components()
        build(P)
    }
    phase 'primary analysis' in parallel { 
        metrics()
        pmd()
        findbugs()
    }
    phase 'secondary analysis' in parallel { 
        quamoco()
        tech_debt()
    }
} 
\end{lstlisting}
\caption{Example workflow for a Java Project.} \label{fig:java_workflow} 
\end{figure}

The ``primary analysis'' phase executes three specific analyses. Initially, a 
metrics analysis executes across the source code. Next, the PMD tool executes 
and its results collected. Finally, the SpotBugs tool executes, and its results 
collected. These executions, as noted, occur in parallel, rather than in a 
sequential fashion. The results of this execution, stored in the database, can 
then act as input to the ``secondary analysis'' phase.

The ``secondary analysis'' phase works with prior collected data and executes 
the two derived analyses. The first command executes the Quamoco quality 
framework to evaluate the internal quality of the software system under analysis 
based on the aggregation of both measures and findings and storing these results 
as measures. The second command executes a technical debt analysis. This 
analysis aggregates findings and metrics values into a single index. 
Additionally, the technical debt analysis tools can produce an estimate of 
effort (to remediate the technical debt issues) based on the calculated index. 
As with the ``primary analysis'' phase, the commands in this phase execute in 
parallel.

\subsection{Data Model}\label{sec:data_model} The goal of this framework is the 
efficient and automated collection of data, in support of empirical studies, 
from several external and internal tools. The selected tools will differ 
depending on the languages in which the software studied has been implemented. 
Thus, we have developed an underlying data model that provides the basis and 
depth necessary for the collection of data from several disparate sources. The 
following describes this data model.

The data model has four main sections: the essential components relating to the 
metadata for a system under analysis, the components to contain pattern related 
data, the components to store information relating to static analysis results, 
finally, the components necessary to contain the information concerning project 
artifact data. The following subsubsections detail each of the sections of the 
model.

\subsubsection*{System Data.} Figure \ref{fig:system_data} defines the data 
model subsection concerning the System under analysis. This metamodel contains 
three primary data collection components. The first is the \textit{System} 
class, which maintains the necessary information concerning the System under 
analysis. A system under analysis may have multiple versions. Each version 
analyzed becomes a member of the set of \textit{Project}s. Each Project 
maintains the version of the System under analysis, the languages of source code 
contained in the project.

Additionally, the Project uses the \textit{SCM} class to maintain information 
regarding source code management information. This information includes the 
repository URL, repository type, and the branch/tag to which the project 
belongs. The Project acts as the nexus point through which the remaining three 
sections interconnect.

\begin{figure}[tb]
    \centering 
    \includegraphics[width=\textwidth]{arc_images/system_data}
    \caption{System data section of the data model.}
    \label{fig:system_data} 
\end{figure}

\subsubsection*{Pattern Data.} The pattern section of the data model, depicted 
in Figure \ref{fig:pattern_data}, contains six main components divided into two 
categories. The first category describes design pattern definitions composed of 
three components. The first is the \textit{Pattern} class, which contains 
information relevant to specific pattern types, i.e., the strategy pattern. The 
second component is the \textit{Role}, which represents the individual 
structural components, such as classifiers and features, contained within a 
specific pattern type. The third component, the \textit{PatternRepository} 
class, which provides a namespace for different pattern types and an overall 
pattern type container. An example used in the Arc Framework is the \textit{GoF} 
repository containing the selected Gang of Four design patterns provided by the 
Pattern4 detection tool \cite{tsantalis_design_2006}.

\begin{figure}[tb] 
    \centering 
    \includegraphics[width=0.8\textwidth]{arc_images/pattern_data} 
    \caption{Pattern section of the data model.}
    \label{fig:pattern_data} 
\end{figure}

The second category, in the pattern data section, is related to pattern 
instances found within project artifacts and contains several primary 
components. The main component is the \textit{PatternInstance} class, which 
represents an instance of a specific pattern type realized within the project 
under analysis. A project's artifacts, when needed outside of the main project 
hierarchy, can be accessed through the use of \textit{Reference}s. References, 
in the case of PatternInstances, are linked to a given Pattern's Roles to 
construct \textit{RoleBinding}s. A set of \textit{RoleBinding}s then composes a 
PatternInstance. A PatternInstance, which has representation across multiple 
versions of a system, forms a \textit{PatternChain}. These PatternChains are 
associated with the System and provide the ability to evaluate how a pattern 
instance changes rather than simply to analyze a pattern instance alone.

\subsubsection*{Static Analysis Data} This section of the data model, as 
depicted in Figure \ref{fig:static_analysis_data} contains data related to 
issues detected using static analysis tools and measures collected using metrics 
tools. This section is composed of the following two partitions.

\begin{figure}[tb]
    \centering 
    \includegraphics[width=\textwidth]{arc_images/static_analysis_data} 
    \caption{Static analysis data section of the data model.} 
    \label{fig:static_analysis_data} 
\end{figure}

The first partition concerns static analysis data and focuses on issue data in 
the form of a \textit{Finding}. A Finding is a single data point relating an 
artifact within the System to a static analysis issue. \textit{Rule}s represent 
Issues within the data model. In the model each Rule is a member of a 
\textit{RuleRepository}, i.e. \textit{pmd} or \textit{findbugs} for 
Java\texttrademark\ , and contains a \textit{Priority}  and a collection of 
\textit{Tag}s. Each Tag provides metadata related to some more general category, 
i.e., security or technical debt, to which a rule belongs.

The second partition concerns measurement data. This data represented is the 
result of the application of a metrics tool to the System under study and is 
encapsulated in the \textit{Measure} class. A Measure is a single data point, 
specific to a given project, evaluating some referenced artifact by a rule 
defined by a metric. \textit{Metric}s, in the data model, contains related 
Measures and is contained within a \textit{MetricRepository}, i.e., arc-metrics, 
but is not specific to any system or project.

\subsubsection*{Project Artifact Data.} This is the largest but most easily 
understood section of the data model. This section, depicted in Figure 
\ref{fig:artifact_data}, directly relates to logical and language constructs to 
which most computer scientists and software engineers are familiar. The major 
components of this section are the \textit{Module}, \textit{Namespace}, 
\textit{File}, \textit{Type} and its subclasses, and \textit{Member} and its 
subclasses. Component definitions depend on the languages used within a project.

\begin{figure}[!tb] 
    \centering 
    \includegraphics[width=\textwidth]{arc_images/artifact_data} 
    \caption{Project artifact data section of the data model.} 
    \label{fig:artifact_data}
\end{figure}

Structurally, for the Project artifact data, we have made some assumptions. 
First, we assume a Project has at least one Module. A Module, we assume, will 
contain at least one Namespace. In the case that neither of these two 
assumptions is true, a default Module or a default Namespace will be created. 
Namespaces, rather than modules, contain Files. Files contain Imports (i.e., 
Java import or C\# using statements) and have an assigned type. A File's 
assigned type is selected from the \textit{FileType} enumeration. These 
containment relationships simplify the overall structure to a tree form and 
allow a logical structure more closely representing project file structures. The 
remaining items from this section of the data model are related to source code 
artifacts. 

These artifacts all derive from the base class \textit{Component}. Components 
have a key, name, and \textit{Accessibility} and a start and end line to define 
their location within a containing File. Furthermore, Components can be either a 
\textit{Type} or a \textit{Member}. The latter representing artifacts contained 
within the former. The subtypes of both Member and Type are representative of 
typical concepts found in most object-oriented languages. They should be 
self-explanatory, with exception to this is the \textit{Unknown} type. Unknowns 
are simply types referenced in the System under analysis, but which the System 
does not contain. These can be either language system provided types or library 
provided types.

\section{Integration of Tools}\label{sec:mqtd_exr_tools} The goal is to 
efficiently execute tools in the proper order. Toward this goal, each of the 
integrated tools is encapsulated, via Commands as depicted in Figure 
\ref{fig:workflow_model} and a ToolCommand using the Apache Commons Exec 
framework\footnote{\url{https://commons.apache.org/proper/commons-exec/}} to 
represent and execute external tools. Although tools may have specific 
constraints (such as requiring the project to be compiled before analysis), the 
framework does not explicitly enforce any such constraints. Rather, we expect 
that those who implement the workflows will have created phases meet these 
conditions. As an example, static analysis often requires a compiled software 
system for analysis. Understanding this issue, we have incorporated the 
capability to execute build tools such as Apache 
Maven\footnote{\url{https://maven.apache.org}} and the Gradle Build 
Tool\footnote{\url{https://gradle.org}}, within sequential phases of a 
workflow. Besides, the previously mentioned build tools, we have implemented 
commands for several other tools for the Java\texttrademark\ ecosystem.

Currently we have implemented commands for the following tools: Maven, Gradle, 
SpotBugs\footnote{\url{https://spotbugs.github.io/}}\cite{
hovemeyer_finding_2004} , PMD\footnote{\url{https://pmd.github.io/}}, 
Git\footnote{\url{https://git-scm.com/}}, the Pattern4 pattern 
detector\cite{tsantalis_design_2006}, an implementation of the Quamoco quality 
measurement approach\cite{wagner_quamoco_2012}, an internal Metrics tool, and a 
Technical Debt measurement tool. Finally, it should be noted that each tool and 
any required collectors are provided to Arc via an implementation of a 
\textit{Tool}. Several of these tools and thier implementations and integration 
into the Arc framework are described in the following subsections.

\subsection{Java\texttrademark\ Artifact Identification} The first tool, and 
arguably one of the most important, is the Java\texttrademark\ Artifact 
Identifier (JAI). JAI scans the project directory and identifies and adds those 
files pertinent to the analysis into the data model. Specifically, it identifies 
source files, binary files, and build files each needed during different stages 
of the analysis.

\begin{figure}[!tb]
    \centering 
    \includegraphics[width=\textwidth]{arc_images/javaai_integration} 
    \caption{Integration of Java Artifact Identification with Arc.} 
    \label{fig:java_integration}
\end{figure}

Figure \ref{fig:java_integration} depicts the JAI tool integration execution 
flow. This flow, the numbers encircled in green, is as follows: 1.) The Arc 
Context loads the Arc configuration when the Arc system begins running. 2.) The 
JavaTool is loaded and provides the JavaAICommand. 3.) The JavaAICommand 
executes and requests 4.) the System and Project information. 5.) This provided 
information allows the JavaAICommand to initiate the JavaArtifactIdentifier, 
which using the ArcConfig and information searches the Project directory for 
related Java files. 6.) The Java files found by the JavaArtifactIdentifier are 
then stored in the Files section of the Data Model.

\subsection{Java Component Analysis} A key capability of the Arc Framework is 
the ability to provide a basis upon which measurements and issues can use in a 
component-level quality evaluation process. This process provided for the 
Java\texttrademark\ language, through the Java Component Analysis (JavaComp) 
tool, uses an internal Java\texttrademark\ 
ANTLR\footnote{\url{http://www.antlr.org}} parser. This parser, in turn, 
provides a \textit{DataModelBuilder} for the Java\texttrademark\ language. These 
two components work together to populate the component level portions of the 
data model, providing the capability for metrics and other higher-level 
analyses.

\begin{figure}[!tb] 
    \centering 
    \includegraphics[width=\textwidth]{arc_images/javacomp_integration} 
    \caption{Integration of the Java Component Analysis with Arc.} 
    \label{fig:javacomp_integration} 
\end{figure}

The analyses provided by the JavaComp tool and its Arc framework integration. 
Figure \ref{fig:javacomp_integration} depicts the JavaComp integration and 
execution flow. This flow, the numbers encircled in green, is as follows: 1.) 
Initially, the Arc Context loads the Arc configuration when the Arc system 
begins running. 2.) Once the system is running, the JavaCompTool is loaded and 
provides the JavaCompCommand. 3.) The JavaCompCommand executes and requests 4.) 
the System and Project information. 5.) The JavaCompCommand executes the 
JavaDMBuilder, which, using the ArcConfig and information provided by 
JavaCompCommand, executes the ANTLR parser to extract type and member level 
components from the project source code files. 6.) The Components section of the 
data model stores this component-level information.

\subsection{GitHub Search} In order to conduct empirical studies across open 
source software, we need a collection of open source projects to analyze. The 
projects we are limited to analyzing, due to current tooling, are 
Java\texttrademark\ based projects. Such a project can be found in several 
open-source repositories hosting sites. Several sites, over the years, have come 
and gone, but Github has become one of the most prominent sites and currently 
hosts a significant body of code. Thus, we selected to extract software 
currently hosted on their site and developed a tool to extract the necessary 
information.

\begin{figure}[!tb] 
    \centering 
    \includegraphics[width=\textwidth]{arc_images/ghsearch_integration} 
    \caption{Integration of Github Search with Arc.}
    \label{fig:ghsearch_integration} 
\end{figure}

Figure \ref{fig:ghsearch_integration} depicts the GitHubSearch tool integration, 
and execution flow. This flow, the numbers encircled in green, is as follows: 
1.) The Arc Context loads the Arc configuration when the Arc system begins 
running. 2.) Once running, the \textit{GHSearchTool} initializes and provides to 
Arc the \textit{GHSearchCommand}. 3.) The \textit{GHSearchCommand} utilizes the 
GitHub REST API, provided via the GitHub API for 
Java\footnote{\url{http://github-api.kohsuke.org}}. 4.) This library, when 
parameterized with the appropriate credentials from the ArcConfig, provides the 
ability to access and search GitHub for suitable systems for analysis. 5.) The 
tool extracts System version information and repository information into Project 
and SCM classes, respectively.

\subsection{Git Execution} The previous tool provides the means to extract 
Software Projects from GitHub, along with metadata, which would allow these 
systems to be analyzed. One component of this metadata is the actual git URL to 
the project's repository. In order to use this, we must have a git client which 
would provide the means to download and extract the software project. Thus, we 
have implemented a tool that utilizes the 
JGit\footnote{\url{https://www.eclipse.org/jgit/}} Java library to clone the git 
repositories of each project to analyze. A part of this analysis the 
GHSearchTool extracts version information for each project from the list of tags 
in the repository. This information, once collected, provides the ability to 
conduct historical or longitudinal studies later. The Arc Frameworks facilitates 
these studies by allowing the use of the Git tool in workflows.

\begin{figure}[!tb] \centering 
\includegraphics[width=\textwidth]{arc_images/git_integration} 
\caption{Integration of Git with Arc.} \label{fig:git_integration} \end{figure}

Figure \ref{fig:git_integration} depicts the Git tool integration execution 
flow. The flow, the numbers encircled in green, is as follows: 1.) The Arc 
Context loads the Arc configuration when the Arc system begins running. 2.) Once 
running, the \textit{GitTool} initializes and provides to Arc the 
\textit{GitCommand}. 3.) The \textit{GitCommand} utilizes the 
JGit\footnote{\url{https://www.eclipse.org/jgit/}} Java library to clone the Git 
repositories of each project to analyze. 4.) This library, when parameterized 
with the appropriate credentials from the ArcConfig, and the Project/System SCM 
information, allows Arc to clone the project properly. 5.) The project is then 
cloned by the GitCommand into an appropriate analysis directory, which then 6.) 
becomes the project root.

\subsection{Static Analysis Tools} In software system analysis, the types of 
tools that detect quality-related issues fall into two main categories: static 
and dynamic analysis. Static analysis tools are those which evaluate the static 
structural elements of the software project. Precisely, they extract project 
artifacts such as source code, executable files, project directory structures, 
or build files. These artifacts provide the necessary information used to 
conduct analyses. These analyses include metrics measurement, identification of 
coding issues, identification of potential bugs, and identification of coding 
standard conformity issues, to name a few.

Dynamic analysis, on the other hand, typically works by executing the software 
either via symbolic execution or through actual activation of the System. In the 
latter case, the tool monitors execution behavior in order to understand 
potential issues. Such an approach can evaluate test-case coverage, security 
issues, and parallel/concurrent programming issues (such as livelock and 
deadlock). Although such issues are essential, the availability of supporting 
tools is an issue; thus, for this research, we have limited ourselves to static 
analysis.

\subsubsection*{SpotBugs} SpotBugs is a fork of the widely popular Java static 
analysis tool FindBugs developed at UMD College 
Park\cite{hovemeyer_finding_2004}. This tool uses a codification of known issues 
and good practices forming a set of rules. Rule violations detected by the tool 
are collected and output in XML format. The results provide input to the Arc 
framework data collectors extracted the data and entered it into the database. 
Although SpotBugs is a static analysis tool, it is dependent on the use of Java 
Reflection and thus requires the software project to be compiled into bytecode 
before analysis. The results of this analysis, along with the results of another 
tool, PMD, are used, in part, to evaluate Java project quality, as described in 
Chapter \ref{chap:quality}.

\begin{figure}[!tb] 
    \centering 
    \includegraphics[width=\textwidth]{arc_images/findbugs_integration} 
    \caption{Integration of SpotBugs with Arc.} 
    \label{fig:findbugs_integration} 
\end{figure}

The SpotBugs tool integration is depicted in Figure 
\ref{fig:findbugs_integration}. The Figure depicts the path of execution as 
numbers encircled in green. This path follows two possible routes both of which 
routes start by 1.) Initialization of the SpotBugsTool by the Arc system. The 
SpotBugsTool provides three components. The first is the 
\textit{SpotBugsRuleProvider} which adds several SpotBugs related 
RuleRepositories to the data model. The second is the \textit{SpotBugsCommand} 
which executes the SpotBugs external tool. Finally, the last item is the 
\textit{SpotBugsCollector} which extracts issues from the resulting XML file. 
2.a.) The SpotBugsRuleProvider, during system data model initialization, will 
construct the RuleRepositories and add Rule definitions to each repository. Each 
repository, once constructed, is (3.a.) added (along with its containing rules) 
to the data model. 2.b.) During the execution of the Arc system, the 
SpotBugsCommand extracts file information from the data model, and (3.b.) uses 
this to execute the SpotBugs external tool. 4.) SpotBugs produces a results 
file, which 5.) is then read by the SpotBugsCollector. The SpotBugsCollector 
extracts the found issues. 6.) These issues are used to construct and store 
Findings in the data model.

\subsubsection*{PMD} PMD is another Java static analysis tool, similar to 
SpotBugs. Like SpotBugs, PMD uses a codification of known issues and good 
practices as a set of rules. The differences in rules, aside, PMD, unlike 
SpotBugs, does not require a compiled program for analysis. Instead, the 
analysis uses only source code to detect rule violations. The tool stores these 
violations in an XML file from which data is extracted and used in the 
evaluation of Java project quality. This process has been codified into the 
PMDToolCommand and integrated into the Arc Framework.

\begin{figure}[!tb]
    \centering 
    \includegraphics[width=\textwidth]{arc_images/pmd_integration} 
    \caption{Integration of PMD with Arc.}
    \label{fig:pmd_integration} 
\end{figure}

Figure \ref{fig:pmd_integration} depicts the PMD tool integration and its 
execution flow. This flow, indicated by the numbers encircled in green, follows 
two possible routes. Initially, both routes start with the 1.) initialization of 
the PMDTool by the Arc system. The PMDTool provides three components. The first 
is the \textit{PMDRuleProvider}, which adds a PMD related RuleRepository to the 
data model. The second is the \textit{PMDCommand}, which executes the PMD 
external tool. Finally, the \textit{PMDCollector} extracts issues from the 
results of executing the PMD external tool. 2.a.) The PMDRuleProvider, during 
system data model initialization, will construct the RuleRepository, add Rule 
definitions to the repository, and then 3.a.) add all of these to the data 
model. 2.b.) During the execution of the Arc system, the PMDCommand extracts 
file information from the data model, and 3.b.) use this to execute the PMD 
external tool within the confines of the project directories. 4.) This execution 
results in the creation of a results XML file, which 5.) is then read by the 
PMDCollector. The PMDCollector then extracts the found issues 6.) to construct 
and store Findings in the data model.

\subsubsection*{Pattern4 Design Pattern Detector} Tsantalis et al. 
\cite{tsantalis_design_2006} developed the Pattern4 design pattern detection 
tool. Chapter \ref{chap:dpd} details the use and integration of this tool and 
other algorithms developed (to collect and cleanse design pattern data) into the 
Arc framework.

\subsubsection*{Metrics Analysis Tool} We have developed a tool to analyze 
software systems, during the primary analysis phase of the workflow, and collect 
several well-known metrics. Metrics analysis works by constructing measures for 
each component measured. The metrics tool then stores these values in the data 
model. Chapter \ref{chap:quality} describes this process, the implemented 
metrics, and the integration into the Arc framework.

\subsection{Build Tools} A build and dependency management system is typically 
employed to package a software system efficiently. Modern programming systems 
provide this capability through a myriad of tooling. Examples of such tools are 
Apache Maven\footnote{\url{https://maven.apache.org/}} and 
Gradle\footnote{\url{https://gradle.org/}} for Java\texttrademark , Scala Build 
Tool\footnote{\url{https://www.scala-sbt.org/}} for Scala, and the combination 
of NuGet\footnote{\url{https://www.nuget.org/}} and 
MS-Build\footnote{\url{https://www.microsoft.com/en-us/build}} for .NET. We have 
focused on the two main Java build and dependency management tools: Apache Maven 
and the Gradle Build tool to facilitate this research. Their use and integration 
are as follows.

\subsubsection*{Maven} The Apache Maven tool provides the capability to build 
nearly any type of Java application through the use of XML configuration files. 
The configuration provides extensive capabilities for building, automated test 
execution, dependency management, and a default project directory structure 
exploitable during analysis.

\begin{figure}[!tb]
  \centering 
  \includegraphics[width=\textwidth]{arc_images/maven_integration} 
  \caption{Integration of Apache Maven with Arc.} 
  \label{fig:maven_integration} 
\end{figure}

Projects utilizing Apache Maven can easily be manually compiled from the command 
line using the Maven command-line tool. Tool execution logic has been 
encapsulated into an Arc ToolCommand for use within Arc workflows, as depicted 
in Figure \ref{fig:maven_integration}. The process of the MavenTool execution is 
as depicted by the numbers encircled in green. The execution flow is as follows: 
1.) The Arc system initializes the \textit{MavenTool}, which then provides the 
\textit{MavenCommand} to the Arc system. 2.) The Arc system then executes the 
MavenCommand, which 3.) extracts from the System, Project, and Files tables the 
necessary information needed to build the System correctly. 4.) At this point, 
the framework executes the Maven command-line tool (as controlled by the 
provided \textit{pom.xml} build configuration file) 5.) utilizing the files in 
the project root. 6.) The output of this execution is the compiled project ready 
for analysis.

\subsubsection*{Gradle} The Gradle tool provides a similarly highly configurable 
capability for building Java\texttrademark\ projects. Unlike Maven, Gradle uses 
a Groovy DSL to control the build process and manage dependencies. Similar to 
Maven, Gradle does provide the ability to utilize the existing Maven 
infrastructure for locating and utilizing dependencies.

\begin{figure}[!tb] 
  \centering 
  \includegraphics[width=\textwidth]{arc_images/gradle_integration} 
  \caption{Integration of Gradle with Arc.}
  \label{fig:gradle_integration} 
\end{figure}

Projects utilizing Gradle can easily be manually compiled from the command line 
using the Gradle command-line tool. The tool execution logic has been 
encapsulated into an Arc ToolCommand, similar to the Maven command, for use 
within Arc workflows, as depicted in Figure \ref{fig:gradle_integration}. The 
process of the GradleTool execution is as depicted by the numbers encircled in 
green. The execution flow is as follows: 1.) The Arc system initializes the 
\textit{GradleTool}, which then provides the \textit{GradleCommand} to the Arc 
system. 2.) The Arc system then executes the GradleCommand, which  3.) extracts 
from the System, Project, and Files tables the necessary information needed to 
build the System correctly. 4.) At this point, the framework executes the Gradle 
command-line tool (as controlled by the provided \textit{build.gradle} build 
configuration file) 5.) utilizing the files in the project root. 6.) The output 
of this execution is the compiled project ready for analysis.

\section{Conclusion}\label{sec:arc_framework_conclude} This chapter describes 
the basic concepts and components of the Arc Framework. This framework is the 
heart of the underlying method, which guides the experiments and studies found 
within this dissertation. In subsequent chapters, we build upon this framework 
and explore the remainder of the methods and techniques used to facilitate data 
collection and execution of our studies.
