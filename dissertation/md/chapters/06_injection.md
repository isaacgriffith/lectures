\chapter{Software Injection}\label{chap:inject}

\begin{quote}
\centering
\textit{Program testing can be used to show the presence of bugs, but
never to show their absence!}\\--Edsger Dijkstra
\end{quote}

\section{Introduction}
Currently, design disharmony research lacks (excluding code smells and 
antipatterns) automated identification and verification techniques. Without such 
techniques, the ability to cultivate design disharmony datasets is quite 
limited. These limitations, in turn, have slowed the progress in evaluating the 
effects that grime has on quality and technical debt and restricting research to 
observational studies. Such studies reduce the scope of analysis and preclude 
the ability to evaluate causal relationships. Thus, to introduce causal 
analysis, through experimentation, this Chapter describes a framework for the 
injection of design disharmonies.  Injection allows for the controlled 
introduction of design disharmonies instances into software artifacts, thereby 
removing the original limitations.

This Chapter is organized as follows. Section \ref{sec:si_arch} describes the 
architecture of the process governing our software injection system. Section 
\ref{sec:si_grime} provides definitions for the injection of design pattern 
grime into design pattern instances. Section \ref{sec:si_app} details potential 
applications beyond design pattern grime for this framework. Finally, Section 
\ref{sec:si_conclude} concludes this chapter.

\section{Software Injection Architecture}\label{sec:si_arch}
\textit{Software Injection} is a method to include entities of study through a 
software system transformation. These transformations occur through the serial 
application of a set of operators. Each operator either modifying or creating 
artifacts to exemplify affliction with the disharmony injected. The Software 
Injection \mm , depicted in Figure \ref{fig:si_mm}, contains the process' 
necessary components and basic architecture. The following subsections describe 
this architecture.

\subsection{Software Injection Metamodel}
The \mm\ consists of two main sections: (i) the components on the left that 
enact the operators described by (ii) the components on the right, and the 
\textit{ InjectionContext} separates both sections. The section on the right 
describes the transformation operators necessary to effect the injection of a 
disharmony. The primary injection component, the interface 
\textit{SourceTransform}, provides the base interface and logic from which 
concrete realizations derive. These realizations provide the necessary logic to 
inject a disharmony into both the data model and source code artifacts. The 
SourceTransform hierarchy forms the basis of the Command pattern implemented.

The base class, \textit{AbstractSourceTransform}, provides common 
SourceTransform functionality. Many of these operations involve simple update 
operations maintaining consistency between source files and the data model. The 
\textit{AbstractSourceTransform} also provides an association with an 
\textit{InjectionContext}, to provide access to the components managing the 
injection process. Finally, the \textit{AbstractSourceTransform} contains a set 
of \textit{Condition}(s) used to validate the current state of the model permits 
the transform operator execution. Beyond these basic operations and components, 
the AbstractSourceTransform has two specializations.

\begin{figure}[tb]

\centering
\includegraphics[width=\textwidth]{injection/metamodel}
\caption{Software Injection \mm .}
\label{fig:si_mm}
\end{figure}

These specializations include: (i) \textit{BasicSourceTransform} and (ii) 
\textit{CompositeSourceTransform}. The \textit{BasicSourceTransform} is the base 
class for transforms, providing only basic source transformation operations. 
Transformation operations include, but are not limited to, the creation of a 
file, addition of a field, and addition of a constructor. This is in contrast to 
the \textit{CompositeSourceTransform}. \textit{CompositeSourceTransform} 
extensions provide both the base logic for generating code and the ability to 
divide their operation into combinations of other transforms. An example of such 
a transform is \textit{CreateEncapsulatedField}, which creates a new Field and 
provides a getter and setter method for that field. The remaining classes in the 
\mm\ define the operational components for the
injection process.

The main component of the operational section of the \mm\ is the
\textit{TransformInvoker} class. It provides the logic to control the correct 
application of transforms. As each \textit{SourceTransform} is constructed it is 
stored until processing begins, via a concurrent queue,  in the 
\textit{TransformInvoker} controlled by the \textit{InjectionController}. The 
\textit{InjectionController} also controls, for each active file, a set of 
\textit{FileOperations}. The \textit{FileOperations} class provides the logic to 
handle SourceTransform required the file operations (includes basic file I/O and 
the injection of new file content). Figure \ref{fig:inject_process} depicts the 
process of combining these components, which the following subsection describes.

\subsection{The Injection Process}

\begin{figure}[!tb]
 \centering
 \includegraphics[width=.75\textwidth]{injection/process}
 \caption{High-level overview of the software injection
 process.}\label{fig:inject_process}
\end{figure}

The Injection Process uses a combined model and direct source code manipulation 
approach, as opposed to a similar concept using bytecode manipulation developed 
by Dale \cite{dale_impacts_2014-1}, as depicted in Figure 
\ref{fig:inject_process}. This figure depicts the flow of execution, numbers 
encircled in green, as follows: 1.) Initially, the process extracts the data 
model components and their associated source code locations from the data model 
and file system. 2.) The data, extracted into a hierarchical model, via the 
InjectionController acts as input to the injection strategies. 3.) As each 
InjectionStrategy executes, it constructs SourceTransforms, which are passed to 
the TransformInvoker and added to its transform queue. 4.) Each queued transform 
executes to construct injection operators. 5.) These operators modify or 
construct data model elements, and then execute operations within the 
FileOperations entities, 6.) resulting in modified source code.

The novelty of the process described here is in the introduction of artifacts 
such as code smells, antipatterns, design pattern grime, and even design 
patterns using defined and validated injection strategies that control the 
injection process. This process modifies source code using a model-driven 
approach independent of any language-specific features. Furthermore, the ability 
to generate source code escapes the problem of simulation, common to this type 
of approach. Finally, this approach facilitates the ability to inspect the 
generated code to validate the production of these entities, a process that 
bytecode injection prohibits. Key to our approach is the 
\textit{SourceInjector}, as depicted in Figure \ref{fig:injectors_cd}

\begin{figure}[!tb]

\centering
\includegraphics[width=\textwidth]{injection/injectors}
\caption{Software Injection Injectors.}
\label{fig:injectors_cd}
\end{figure}

The \textit{SourceInjector} encodes the logic necessary to generate the sequence 
of transforms needed to inject one or more types of disharmonies into one or 
more software components, what we term \textit{Injection Strategies}. Currently, 
we have developed strategies for modular grime (c.f. 
\ref{subsec:modgrime_inject}), class grime (c.f. \ref{subsec:clsgrime_inject}), 
organizational grime (c.f.
\ref{subsec:orggrime_inject}), and a \textit{NullInjector} for the case of an 
unknown type. These injectors' base class, \textit{GrimeInjector}, contains the 
common operations for each of its subtypes. Subtypes of this class are generated 
and provided to the \textit{InjectionController} via the 
\textit{GrimeInjectorFactory}. Finally, the three interfaces 
\textit{ClassGrimeTypes}, \textit{OrgGrimeTypes}, and
\textit{ModularGrimeTypes} are used simply to hold constants representing the 
names of known subtypes of the respective major-type of grime.

\subsection{Integration into the Arc Framework}
The injection process, described in this Chapter is a necessary component of the 
experimentation method defined in Chapter \ref{chap:method}. This method of 
software injection, to be useful, must be integrated into the Arc Framework 
alongside the methods and tools we described in Chapter \ref{chap:quality}. 
Figure \ref{fig:si_integrate} depicts the integration of Software Injection into 
the Arc framework.

\begin{figure}[!tb]
    \centering
    \includegraphics[width=\textwidth]{arc_images/src_inject_integration}
    \caption{Source Injector integration with the Arc Framework.}
    \label{fig:si_integrate}
\end{figure}

Figure \ref{fig:si_integrate} shows the Software Injection execution path as the 
numbers encircled in green. This path is as follows: 1.) During system 
initialization the
\textit{SourceInjectorTool} is initialized to provide the Arc framework with the 
\textit{InjectorCommand}. 2.) The \textit{InjectorCommand} controls the 
execution of the \textit{SourceInject} tool. The \textit{InjectorCommand} also 
provides the \textit{SourceInjector} with data from the data model 3.) The 
\textit{SourceInjector} tool executes the source injection process according to 
selected detection strategies. 4.) The \textit{SourceInjector}, via the 
\textit{InjectorCommand}, extracts necessary data from the data model and reads 
in information from the source files in the project root. 5.) As the 
\textit{SourceInjector} executes, it modifies both the physical files in the 
project root and the components in the data model. That is, the 
\textit{InjectorCommand} adds basic artifacts that are created and added to the 
data model, along with, Findings for any added disharmonies.

\section{Design Pattern Grime Injection}\label{sec:si_grime}
This section details the injection strategies defined for each of the three 
types of design pattern grime: Modular Grime, Class Grime, and Organizational 
Grime. 

\begin{singlespaced}
\begin{algorithm}[ruled,!tb]
 \caption{Modular Grime Injection Strategy}\label{alg:mod_grime_is}
 
 \begin{algorithmic}[1]
   \Procedure{Inject}{$persist$, $extern$, $efferent$}
   \State $src \gets \varnothing $
   \State $dest \gets \varnothing $
   \State $rel \gets \varnothing $
   \If{$extern$}
        \If{$efferent$}
       \State $src \gets $ \Call{SelectOrCreateExternClass}{$ $}
       \State $dest \gets $ \Call{SelectPatternClass}{$ $}
     \Else
       \State $src \gets $ \Call{SelectPatternClass}{$ $}
       \State $dest \gets $ \Call{SelectOrCreateExternClass}{$ $}
     \EndIf
   \Else
     \State $src, dest \gets $ \Call{Select2PatternClasses}{$ $}
   \EndIf
   \If{$persist$}
     \State $rel \gets $ \Call{SelectPersistentRelationship}{$ $}
   \Else
     \State $rel \gets $ \Call{SelectTempRelationship}{$ $}
   \EndIf
   \State \Call{CreateRelationship}{$src$, $dest$, $rel$}
   \EndProcedure
 \end{algorithmic}
 
\end{algorithm}
\end{singlespaced}

\subsection{Modular Grime}\label{subsec:modgrime_inject}
This section describes the basic strategy for injecting modular grime into an 
existing software system. This strategy, defined by the pseudocode in Algorithm 
\ref{alg:mod_grime_is}, has three control parameters. These parameters 
correspond to the components defining the modular grime taxonomy 
\cite{schanz_object_2010}). These components are the strength, scope, and 
direction of the grime and exist in the strategy as the Boolean flags 
$persist$., $extern$, and $efferent$, respectively.

\begin{table}[!tb]
\centering
\caption{Value table for the Modular Grime Injection Strategy parameters. T 
indicates $true$, F indicates $false$, and -- indicates
N/A}\label{tab:mod_grime_vals}
\begin{tabular}{c|ccc}
\multicolumn{1}{c}{\multirow{2}{*}{Grime}} & 
\multicolumn{3}{c}{Parameters}\tabularnewline
\cline{2-4} 
 & $persist$ & $extern$ & $efferent$\tabularnewline
\hline 
PIG & T & F & \textendash{}\tabularnewline
\hline 
TIG & F & F & \textendash{}\tabularnewline
\hline 
PEEG & T & T & T\tabularnewline
\hline 
TEEG & F & T & T\tabularnewline
\hline 
PEAG & T & T & F\tabularnewline
\hline 
TEAG & F & T & F\tabularnewline
\hline 
\end{tabular}
\end{table}

Parameter combinations specify the known types of modular grime, as shown in 
Table \ref{tab:mod_grime_vals}. Specifically, this works by controlling the 
algorithm using the following interpretations of each variable's possible 
values. When $persist$ is true, this indicates a form of persistent modular 
grime, and, otherwise, indicates a form of temporary modular grime. When 
$extern$ is true, this indicates a form of external modular grime, and, 
otherwise, indicates a form of internal modular grime. When $efferent$ is true, 
this indicates a form of efferent modular grime, and, otherwise, indicates a 
form of afferent modular grime. With this understanding in mind, the following 
describes the inner workings of this strategy.

The injection strategy, based upon the definition of Modular Grime from Chapter 
\ref{chap:taxonomies}, generates grime inducing relationships using a set of 
three variables. These variables are as follows: (i) $src$, the source side of 
the grime inducing relationship, (ii) $dest$, the destination side of the grime 
inducing relationship, and (iii) $rel$, the type of the grime inducing 
relationship. Initially, the strategy sets the values for $src$, $dest$, and 
$rel$ to be null. The variable value selection corresponds to the grime type 
specified by the input parameters. The following describes the assignment 
process for each of the variables. 

Modular Grime injection variable assignment considers the following cases. If 
both $extern$ and $efferent$ are true, then the value of the $src$ will be the 
selection of some class external to the pattern instance, and $dest$ selects 
from the set of pattern class. If $extern$ is true and $efferent$ is false, the 
opposite selection occurs. If $extern$ is not true, both $src$ and $dest$ are 
assigned pattern classes. 

Once both $src$ and $dest$ are assigned, the algorithm selects the relationship 
type.  The strategy determines relationship type, as follows. If $persist$ is 
true, then the value of $rel$ is set to be persistent (one of generalization, 
realization, or a form of association), and otherwise is set to be temporary (a 
form of dependency). Finally, once selected, the variables $src$, $dest$, and 
$rel$ act as input to the respective relationship constructing transform, which 
is created and passed to the \textit{TransformInvoker}.

\begin{singlespaced}
\begin{algorithm}[!tb]
\caption{Class Grime Injection Strategy}\label{alg:class_grime_is}

\begin{algorithmic}[1]
  \Procedure{Inject}{$direct$, $internal$, $pair$}
    \State $clazz \gets $ \Call{SelectPatternClass}{$ $}
    \State $field \gets $ \Call{SelectField}{$clazz$}
    \State $method1 \gets \varnothing $
    \State $method2 \gets \varnothing $
    
    \If{$internal$}
      \State $method1 \gets $ \Call{SelectPatternMethod}{$ $}
    \Else
      \State $method1 \gets $ \Call{SelectOrCreateMethod}{$ $}
    \EndIf
    \If{$pair$}
      \State $method2 \gets $ \Call{SelectOrCreateMethod}{$ $}
    \EndIf
    \If{$direct$}
      \State \Call{AddFieldUse}{$method1$, $field$}
      \If{$pair$}
        \State \Call{AddFieldUse}{$method2$, $field$}
      \EndIf
    \Else
      \State $mutator \gets $ \Call{SelectOrCreateMutator}{$field$}
      \State \Call{AddMethodCall}{$method1$, $mutator$}
      \If{$pair$}
        \State \Call{AddMethodCall}{$method2$, $mutator$}
      \EndIf
    \EndIf
  \EndProcedure
\end{algorithmic}
\end{algorithm}
\end{singlespaced}

\subsection{Class Grime}\label{subsec:clsgrime_inject}
This section details the basic strategy for injecting class grime into an 
existing software system. This strategy, defined by the pseudocode in Algorithm 
\ref{alg:class_grime_is}, has three parameters. These parameters correspond to 
the components defining the class grime taxonomy. These components are the 
strength, the scope, and the direction components of the taxonomy (c.f. 
\ref{sec:class_grime_tax}) and exist in the strategy as the Boolean flags 
$direct$, $internal$, and $pair$, respectively.

\begin{table}[!tb]
\centering
\caption{Value table for the Class Grime Injection Strategy parameters. T 
indicates $true$ and F indicates $false$.}\label{tab:class_grime_vals}
\begin{tabular}{c|ccc}
\multicolumn{1}{c}{\multirow{2}{*}{Grime}} & 
\multicolumn{3}{c}{Parameters}\tabularnewline
\cline{2-4} 
 & $direct$ & $internal$ & $pair$\tabularnewline
\hline 
DIPG & T & T & T\tabularnewline
\hline 
DISG & T & T & F\tabularnewline
\hline 
DEPG & T & F & T\tabularnewline
\hline 
DESG & T & F & F\tabularnewline
\hline 
IIPG & F & T & T\tabularnewline
\hline 
IISG & F & T & F\tabularnewline
\hline 
IEPG & F & F & T\tabularnewline
\hline 
IESG & F & F & F\tabularnewline
\hline 
\end{tabular}
\end{table}

Parameter combinations specify the known types of class grime, as shown in Table 
\ref{tab:class_grime_vals}. Specifically, this works by controlling the 
algorithm using the following interpretations of each variable's possible 
values. When $direct$ is true, this indicates a form of direct class grime, and, 
otherwise, indicates a form of indirect class grime. When $internal$ is true, 
this indicates a form of internal class grime, and, otherwise, indicates a form 
of external class grime. When $pair$ is true, this indicates a form of pair 
class grime, and, otherwise, indicates a form of singular class grime. With this 
understanding in mind, the following describes the inner workings of this 
strategy.

The injection strategy, based upon the definition of Class Grime from Chapter 
\ref{chap:taxonomies}, generates grime inducing field and method use 
relationships using a set of four variables. These variables are as follows: (i) 
$clazz$, the class injected with grime, (ii) $field$, the field to be connected 
to a method forming the grime relationship, (iii) $method1$, and (iv) $method2$, 
the methods which will form the source side of the relationship. Initially, the 
strategy assigns to $clazz$ the value of a randomly selected pattern instance 
class and assigns to $field$ a randomly selected field from within that class. 
In the case that no available field exists, the strategy creates one. The 
strategy then sets the value of $method1$ and $method2$ to null. The variable 
value selection corresponds to the grime type specified by the input parameters. 
The following describes the assignment process for each of these variables.

Class Grime injection variable assignment considers the following cases. If 
$internal$ is true, then $method1$ is set to a method within the selected class 
matching a pattern feature role. Otherwise, the strategy assigns $method1$ to 
any other method or a newly created method. If $pair$ is true, then the strategy 
assigns $method2$ to any method or a newly created method. If $direct$ is true, 
then the strategy constructs a transform to create a field use relationship 
between the $field$ and $method1$ and adds it to the TransformInvoker. If both 
$direct$ and $pair$ are true, then the strategy constructs a transform to create 
a field use relationship between $field$ and $method2$ and adds it to the 
TransformInvoker. If $direct$ is false, then the strategy constructs an indirect 
relationship through a selected or created mutator of the $field$, rather than 
constructing direct relationships.

\subsection{Organizational Grime}\label{subsec:orggrime_inject}
This section details the basic strategies for injecting organizational grime 
into an existing software system. Unlike both Class and Modular Grime, 
Organizational Grime subdivides into two distinct types: Package and Modular 
Organizational Grime.

\begin{singlespaced}
\begin{algorithm}[!tb]
 \caption{Package Organizational Grime Injection
 Strategy}\label{alg:org_grime_is1}
 
 \begin{algorithmic}[1]
   \Procedure{Inject}{$internal$, $closure$}
     \State $pkg \gets $ \Call{SelectPatternNamespace}{$ $}
     \State $type \gets \varnothing $, $rel \gets \varnothing$, $dest \gets 
\varnothing$, $other \gets \varnothing$
     \If{$internal$}
       \State $type \gets $ \Call{SelectPatternClass}{$pkg$}
     \Else
       \State $type \gets $ \Call{selectOrCreateExternalClass}{$pkg$}
     \EndIf
     
     \State $rel \gets $ \Call{SelectRelationship}{$ $}
     \If{$closure$}
       \State $other \gets $ \Call{SelectUnreachableNamespace}{$pkg$}
       \State $dest \gets $ \Call{SelectExternalClass}{other}
     \Else
       \State $other \gets $ \Call{SelectNamespace}{$ $}
       \State $dest \gets $ \Call{SelectExternalClass}{other}
     \EndIf
     
     \If{$other$ \textbf{and} $dest$}
       \State \Call{CreateRelationship}{$type$, $dest$, $rel$}
     \EndIf
   \EndProcedure
 \end{algorithmic}
 
\end{algorithm}
\end{singlespaced}

\subsubsection*{Package Organizational Grime} This section details the strategy 
for injecting package organizational grime into an existing software system. 
This strategy, defined by the pseudocode in Algorithm \ref{alg:org_grime_is1}, 
has two parameters corresponding the components of the taxonomy (c.f. 
\ref{sec:org_grime_tax}) and are identified as the Boolean flags $internal$ and 
$closure$.

\begin{table}[!tb]

\centering
\caption{Value table for the Package Organizational Grime Injection Strategy
parameters. T indicates $true$ and F indicates 
$false$.}\label{tab:pkg_org_grime_vals}
\begin{tabular}{c|cc}
\multicolumn{1}{c}{\multirow{2}{*}{Grime}} & 
\multicolumn{2}{c}{Parameters}\tabularnewline
\cline{2-3} 
 & $internal$ & $closure$\tabularnewline
\hline 
PICG & T & T\tabularnewline
\hline 
PIRG & T & F\tabularnewline
\hline 
PECG & F & T\tabularnewline
\hline 
PERG & F & F\tabularnewline
\hline 
\end{tabular}

\end{table}

Parameter combinations specify the known types of package organizational grime, 
as shown in Table \ref{tab:pkg_org_grime_vals}. Specifically, this works by 
controlling the algorithm using the following interpretations of each variable's 
possible values. When $intern$ is true, then this indicates a form of internal 
package organizational grime, and when false, this indicates a form of external 
package organizational grime. When $closure$ is true, this indicates a form of 
closure package organizational grime, and, otherwise, indicates a form of reuse 
package organizational grime. The following describes the inner workings of this 
strategy.

The injection strategy uses the definition of Package Organizational Grime from 
Chapter \ref{chap:taxonomies}. This strategy focuses on the creation of grime 
inducing relationships using the following five control variables: (i) $pkg$, 
the namespace containing elements of the pattern instance, (ii) $type$, the type 
selected from the pattern instance within the namespace referenced by $pkg$, 
(iii) $rel$, the relationship type to be injected, (iv) $dest$, the type 
representing the destination end of the relationship injected, and (v) $other$, 
the other namespace containing the type referenced by $dest$. Initially, the 
strategy assigns $pkg$ to a randomly selected namespace from those containing 
elements of the pattern instance and the remaining four variables to null.  The 
control variable values correspond to the values of the three input parameters.

This correspondence is a direct connection between the values specified in Table 
\ref{tab:pkg_org_grime_vals} to the definition of Package Organizational Grime; 
the strategy considers the following cases. If $internal$ is true, then the 
strategy assigns $type$ to a pattern instance class within the namespace 
referenced by $pkg$. Otherwise, the strategy assigns $type$ to a class internal 
to the namespace or one created internal to the namespace but external to the 
pattern instance. The strategy then selects the type of relationship to create 
and assigns it to the variable $rel$. The strategy then selects the destination 
end of the relationship. If $closure$ is true, then the strategy assigns to 
$other$ a namespace currently unreachable from the namespace referenced by $pkg$ 
and assigns to $dest$ a type (external to the current pattern instance) found 
within the namespace referenced by $other$. Otherwise, the strategy assigns to 
$other$ any namespace and assigns to $dest$ a type (external to the current 
pattern instance) found within the namespace referenced by $other$. Finally, if 
both $other$ and $dest$ have a value set, the strategy constructs a transform to 
create a relationship between $type$ and $dest$ with the type or $rel$ and adds 
it to the TransformInvoker.

\begin{singlespaced}
\begin{algorithm}[!tb]
 \caption{Modular Organizational Grime Injection
 Strategy}\label{alg:org_grime_is2}
 
 \begin{algorithmic}[1]
   \Procedure{Inject}{$persistent$, $internal$, $cyclical$}
     \State $pkgs \gets $ \Call{PatternNamespaces}{$ $}
     \State $ns_1 \gets \varnothing, ns_2 \gets \varnothing$
     \If{internal}
       \If{$\vert pkgs \vert > 1$}
         \State $(ns_1, ns_2) \gets $ \Call{SelectNamespaces}{$pkgs$}
       \Else
         \State $ns_1 \gets $ \Call{SelectNamespace}{$pkgs$}
         \State $(ns_1, ns_2) \gets $ \Call{SplitNamespace}{ns1}
       \EndIf
     \Else
       \State $ns_1 \gets $ \Call{SelectPatternNamespace}{$ $}
       \State $ns_2 \gets $ \Call{SelectOrCreateExternNamespace}{$ $}
     \EndIf
     \If{$persistent$}
       \State $rel \gets $ \Call{SelectPersistentRelationship}{$ $}
     \Else
       \State $rel \gets $ \Call{SelectTempRelationship}{$ $}
     \EndIf
     \If{$cyclical$}
       \State \Call{CreateCyclicalDep}{$ns_1$, $ns_2$, $rel$}
     \Else
       \State \Call{AddInstabilitiy}{$ns_1$, $ns_2$, $rel$}
     \EndIf  
   \EndProcedure
 \end{algorithmic}
\end{algorithm}
\end{singlespaced}

\subsubsection*{Modular Organizational Grime} 
This section details the strategy for injecting modular organizational grime 
into an existing software system. This strategy, defined by the pseudocode in 
Algorithm \ref{alg:org_grime_is2}, has in three parameters corresponding to the 
components of the taxonomy (c.f. \ref{sec:org_grime_tax}) and identified by the 
Boolean flags $persistent$, $internal$, and $cyclical$, respectively.

\begin{table}[!tb]

\centering
\caption{Value table for the Modular Organizational Grime Injection Strategy 
parameters. T indicates $true$ and F indicates 
$false$.}\label{tab:mod_org_grime_values}
\begin{tabular}{c|ccc}
\multicolumn{1}{c}{\multirow{2}{*}{Grime}} & 
\multicolumn{3}{c}{Parameters}\tabularnewline
\cline{2-4} 
 & $persistent$ & $internal$ & $cyclical$\tabularnewline
\hline 
MPICG & T & T & T\tabularnewline
\hline 
MPIUG & T & T & F\tabularnewline
\hline 
MPECG & T & F & T\tabularnewline
\hline 
MPEUG & T & F & F\tabularnewline
\hline 
MTICG & F & T & T\tabularnewline
\hline 
MTIUG & F & T & F\tabularnewline
\hline 
MTECG & F & F & T\tabularnewline
\hline 
MTEUG & F & F & F\tabularnewline
\hline 
\end{tabular}
\end{table}

Parameter combinations specify the known types of modular organizational grime, 
as shown in Table \ref{tab:mod_org_grime_values}. Specifically, this works by 
controlling the algorithm using the following interpretations of each variable's 
possible values. When $persist$ is true, this indicates a form of persistent 
modular organizational grime, and, otherwise, indicates a form of temporary 
organizational modular grime. When $internal$ is true, this indicates a form of 
internal modular organizational grime, and, otherwise, indicates a form of 
external modular organizational grime. When $cyclical$ is true, this indicates a 
form of cyclical modular organizational grime, and, otherwise, indicates a form 
of unstable modular organizational grime. With this understanding in mind, the 
following describes the inner workings of this strategy.

The injection strategy, based upon the definition of Modular Organizational 
Grime from Chapter \ref{chap:taxonomies}, generates grime inducing relationships 
using a set of three variables. These variables are as follows: (i) $pkgs$, 
namespaces containing elements of the pattern instance, (ii) $ns_1$, the 
source-side namespace of an injected grime forming dependency, (iii) $ns_2$, 
destination side namespace of an injected grime forming dependency. Initially, 
the strategy assigns to $pkgs$ the set of namespaces containing the pattern 
instance's elements. The variable selection corresponds to the grime type 
specified by the input parameters. The following describes the assignment 
process for each of these variables.

Modular Organizational Grime injection variable assignment considers the 
following cases. If $internal$ is true and the size of
$pkgs$ is greater than 1, then the strategy assigns both $ns_1$ and $ns_2$ to 
randomly selected members of $pkgs$. In the case that the size of $pkgs$ is 1, 
then the strategy assigns both $ns_1$ and $ns_2$ to the namespaces created 
through a split of the namespace currently referenced by $ns_1$. Otherwise, if 
$internal$ is false, then the strategy assigns to $ns_1$ any one of the pattern 
instance containing namespaces, and to $ns_2$ an external namespace if one 
exists ( otherwise it creates one). If $persistent$ is true, then the strategy 
assigns to $rel$ a persistent relationship type (one of generalization, 
realization, or a form of association). Otherwise, the strategy assigns to $rel$ 
a dependency relationship type. Finally, if $cyclical$ is true, then a set of 
transforms are added to the TransformInvoker which will create relationships 
between $ns_1$ and $ns_2$ of type $rel$. These transforms result in the 
formation of a cyclical relationship between the namespaces represented by 
$ns_1$ and $ns_2$. On the other hand, if $cyclical$ is false, then the set of 
transforms are added to the TransformInvoker create relationships between $ns_1$ 
and $ns_2$ of type $rel$, such that the instability of $ns_1$ increases.

% \section{Validation} In order to validate the injection strategies. We intend
% to utilize a bare system initialized with a clean implementation (no known
% grime or other disharmonies) of a selected design pattern. Using a randomized
% complete block experimental design, we will randomly select a grime type
% injection ordering across a series of design pattern implementations. Once the
% design has been set up, we randomize the pairs of pattern, and grime type and
% execute the experiment. Between injections, we recopy the clean system for the
% next injection. We also evaluate each system between injections in order to
% determine if the grime was injected properly or not. The response variable for
% of these experiments is the \textit{accuracy} of the injections given the 
%grime
% type to be injected. This process is depicted in Figure
% \ref{fig:valid-inject}.

\section{Applications}\label{sec:si_app}
This Chapter describes a technique to inject design disharmonies into existing 
source code programmatically. Within this research, this approach facilitates 
the evaluation of the effects of design pattern grime through experimentation. 
Although this technique is effective in accomplishing its objective, it is 
capable of much more. In the following subsections, we describe three potential 
applications of software injection. 

\subsection{Application to Experimentation}
The use of injection allows for the controlled creation of design disharmonies 
through the creation of injection strategies. Furthermore, injection strategies 
allow the injection of any number or type of software entity into software 
artifacts. This capability, when combined with proper experimental design and 
parameterization, provides the ability to evaluate the various effects of the 
injected entities on the system. This combination enhances experimentation 
capability, as injection allows for randomization in assignment and selection of 
treatment groups, thus providing a means to evaluate causal relationships. 
Beyond traditional experimentation, software injection applies to case studies 
and single-case mechanism experiments from Design Science 
\cite{wieringa_design_2014}.

\subsection{Application to Benchmarking}
Injection strategies also allow the development of proper benchmarking datasets 
such as code smell, antipattern, and design rule violation detectors. Beyond 
just a simple true/false identification, injection strategies will allow for the 
fine-tuning and calibration of such tools. Fine-tuning and calibration allow for 
the possibility of identifying a range of detection for each design disharmony a 
tool supports.  Improving tools in this manner allows for the identification and 
evaluation of the systematic error associated with these tools. Additionally, 
injection strategies can provide tools with the capability to detect rare or 
theoretical design disharmonies.
 
\subsection{Application to Design Patterns}
Beyond simply injecting disharmonies, injection strategies can inject more 
complicated and more useful concepts as well. For instance, as a part of the 
experimentation process, rather than requiring the software product studied to 
have existing instances of each type of design pattern, we could inject the 
required patterns into the system as needed. These injected design pattern 
instances provide a base for additional disharmony injection or other 
experiments.

\section{Conclusion}\label{sec:si_conclude}
This Chapter presented current work on the software injection process and 
framework. We presented the architecture, \mm , and integration with the Arc 
framework underlying this approach. Furthermore, we defined the concept of 
\textit{injection strategy}, which provides an algorithmic approach to inserting 
design disharmonies into the software. Finally, we presented several potential 
applications for this technique, which our future work will explore.
