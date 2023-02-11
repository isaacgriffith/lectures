\chapter{Design Pattern Grime Taxonomy}\label{chap:taxonomies}

\begin{quote}
\centering
\textit{Good judgment comes from experience, and experience comes from bad judgment.}\\--Frederick P. Brooks
\end{quote}

\section{Introduction}
This chapter describes the extensions to grime taxonomy by expanding the Class 
and Organizational leaves of the original grime taxonomy defined by Izurieta 
\cite{izurieta_decay_2009}. We first elaborate on the approach used to define 
the taxonomies. We then define the extended taxonomies for Class and 
Organizational Grime. We note that this taxonomy is only a refinement rather 
than a final taxonomy of all grime.

\begin{enumerate}[leftmargin=1.5cm,label=\bfseries RG\arabic*:]
  \item Analyze design patterns to elaborate on the complete taxonomy of Class 
and Organizational Grime.
  \begin{enumerate}[label=\bfseries RQ1.\arabic*:]
    \item What are the types of Class Grime?\\
    \textbf{Rationale:} This is a fundamental question of this research, 
inquiring as to the nature of Class Grime.
    \item What are the types of Organizational Grime?\\
    \textbf{Rationale:} This is a fundamental question of this research, 
inquiring as to the nature of Organizational Grime.
  \end{enumerate}
\end{enumerate}

\paragraph*{Organization}
This chapter is organized as follows. Section \ref{sec:tax_def} defines our 
process for the definition and refinement of a taxonomy. Subsection 
\ref{sec:formal} provides a formal definition of the concepts underlying the 
taxonomy and provides for the predicates and set definitions necessary to 
describe the concepts defining grime categories. Section \ref{sec:mod_grime_tax} 
describes the basis, conceptual components, and formal definitions of the 
Modular Grime taxonomy developed by Schanz and Izurieta 
\cite{schanz_object_2010}. Section \ref{sec:class_grime_tax} describes the 
basis, conceptual components, and formal definitions of the Class Grime 
taxonomy. Section \ref{sec:org_grime_tax} describes the basis, conceptual 
components, and formal definitions of the Organizational Grime taxonomy. 
Finally, Section \ref{sec:tax_conclude} concludes this chapter.

\section{Taxonomy Definition Process}\label{sec:tax_def}
The goal of the taxonomy definition process is to elaborate possible grime 
subtypes, further refining existing categories as was done by Schanz and 
Izurieta \cite{schanz_object_2010}. To extend this taxonomy, we developed a 
process to elaborate on the Class and Organizational Grime types further. The 
steps of this process are, as follows:
\begin{enumerate}
  \item Develop an underlying formal framework necessary to develop the 
taxonomy.
  \item Identify the software entities of concern, such as classes, packages, or 
relationships.
  \item Identify the design principles or practices that affect these entities, 
which have not already been elaborated upon by existing disharmonies.
  \item Identify the measurable properties of these principles or their 
components to develop the levels of the taxonomy.
  \item Select metrics to measure the identified properties.
  \item Define, formally, each type of grime identified as part of the newly 
extended taxonomy.
\end{enumerate}
\noindent The following sections utilize this process to develop the Class Grime 
and Organizational Grime taxonomies.

\section{Formal Framework}\label{sec:formal}
Design pattern grime categories, as defined by the following taxonomies, require 
an underlying formal framework. Initially, we assume there is a system under 
analysis, $\mathcal{S}$, and that this system is defined using an 
object-oriented language such as UML or Java\texttrademark . Furthermore, a 
system can be described as $\mathcal{S} = \langle \mathcal{T}, \mathcal{Z} 
\rangle$, which is a tuple containing the set of types, $\mathcal{T}$, and 
relationships, $\mathcal{Z}$, of the system. We also define $\mathfrak{R}$ as 
the set of formal specifications of design patterns using a design pattern 
specification language such as RBML. To further define this framework, we 
consider two different perspectives: structural and relational.

\begin{figure}
\centering
\includegraphics[scale=.65]{images/Examples/Formal/package.eps}
\caption{Example Package Graph.}\label{fig:ex_pkg_graph}
\end{figure}

\subsection{Structure}\label{subsec:formal_struct}
This subsection details the formal concepts related to the structural aspects of 
the system and pattern representations. Each type, $t \in 
\mathcal{T}_\mathcal{S}$, can be further defined as $t = \langle \mathcal{A}_t, 
\mathcal{M}_t \rangle$, which is a tuple containing the set of attributes for 
type $t$, $\mathcal{A}_t$, and the set of methods for type $t$, $\mathcal{M}_t$. 
is further composed of a set of attributes $\mathcal{A}(t)$. The set of 
attributes, $\mathcal{A}_t$ represents the data directly defined in the type. 
The set of methods $\mathcal{M}(t)$ which represent the behavior associated with 
the type and its contained data. For example, Figure \ref{fig:ex_pkg_graph} 
represents a system, $\mathcal{S}$, wherein $\mathcal{T}_\mathcal{S} = 
\{A\,B\,C\,D\,E\,F\,G\,H\,I\,J\,K\,L\}$ and $\mathcal{Z}_\mathcal{S}$ is the set 
of relationship between the types (excluding the dashed arrows between 
packages).

Types can be either internal or external to a package as determined by the 
predicates $internal$ and $external$, which are defined as follows: $internal(t 
\in \mathcal{T}, p \in \mathcal{P}) \equiv t \in p$ which evaluates to true if 
$t$ is a type within the package $p$. $external(t \in \mathcal{T}, p \in 
\mathcal{P}) \equiv \lnot internal(t, p)$ which evaluates to true if $t$ is a 
type not in the package $p$. For example, in Figure \ref{fig:ex_pkg_graph} 
$internal(G, D)$ evaluates to true, as type $G$ is in package $D$, and 
$external(G, A)$ evaluates to true as well. On the other hand, $internal(F,B)$ 
evaluates to false and similarly $external(K, G)$ evaluates to false. A system's 
types can also be partitioned into a set of packages (also known as namespaces), 
$\mathcal{P}_\mathcal{S}$. The set of packages can be defined using a set 
partition as follows: $\underset{i\in\mathcal{P_{\mathcal{S}}}}{\bigcup} = 
\mathcal{T}_\mathcal{S} \wedge \mathcal{P}_{\mathcal{S}_i} \cap 
\mathcal{P}_{\mathcal{S}_j} = \varnothing\, \textrm{for}\, i,j \in 
\mathcal{P}_\mathcal{S} \wedge i \neq j$. We assume that a single type, $t$, may 
only be in a single package at one time. Thus, the set of types contained in a 
package $p \in \mathcal{P}_\mathcal{S}$ is a proper subset of the types of the 
system itself: $\mathcal{T}_p \subseteq \mathcal{T}_\mathcal{S}$. For example, 
in Figure \ref{fig:ex_pkg_graph} the set $\mathcal{P}_\mathcal{S} = \{\{A\, 
B\}\, \{C\}\, \{D\,E\}\, \{G\,F\}\, \{H\,I\}\, \{J\}\, \{K\, L\}\}$.

The set of methods, $\mathcal{M}_t$, for a given type, $t$, can be further 
partitioned into \textit{operations}, \textit{accessors}, \textit{mutators}. The 
set of accessors is extracted using the function $accessors(t)$, which evaluates 
to the set of accessor methods defined in type $t$. A method, $m \in 
\mathcal{M}_t$, can be determined if it is an accessor for attribute, $a \in 
\mathcal{A}_t$, in type $t$ using the predicate $accessor(m, a)$. The predicate 
$accessor(m, a)$ evaluates to true if method $m$ simply returns the value of 
attribute $a$ and does nothing else. Similarly, the set of mutators is extracted 
using the function $mutators(t)$, which evaluates to the set of mutator methods 
defined in type $t$. A method, $m \in \mathcal{M}_t$, can be determined if it is 
a mutator for attribute, $a \in \mathcal{A}_t$, in type $t$ using predicate 
$mutator(m, a)$. The predicate $mutator(m, a)$ evaluates to true if method $m$ 
simply modifies the value of attribute $a$ and does nothing else. Finally, the 
set of methods calling a method $m$ can be extracted using the $calls(m)$ 
function.

\begin{figure}[tb]
\centering
\includegraphics[scale=.5]{images/Examples/Formal/pattern.eps}
\caption{Example Pattern Graph.}\label{fig:ex_pattern_graph}
\end{figure}

A design pattern realization $\mathcal{L} = \langle r \in \mathfrak{R}, 
\mathcal{B}_r \rangle$ is a tuple consisting of a design pattern specification 
(as defined using RBML \cite{france_uml-based_2004}), $r \in \mathfrak{R}$, and 
a mapping of the roles of $r$ to the components of the system, $\mathcal{B}_r$. 
This binding is defined as, $\mathcal{B}_r \equiv bind : \mathcal{C}_\mathcal{S} 
\rightarrow \mathcal{R}$. The set $\mathcal{C}_\mathcal{S} = 
\mathcal{T}_\mathcal{S} \cup \mathcal{A}_\mathcal{S} \cup 
\mathcal{M}_\mathcal{S} \cup \mathcal{P}_\mathcal{S}$ which is the union of 
types, attributes, methods, and packages defined across the system.

A pair of methods $(m_i, m_j)$ can be either internal or external to a pattern 
realization. This is determined by the $internal$ and $external$ predicates for 
method pairs. The $internal$ predicate is defined as $internal((m_i, m_j, l \in 
\mathcal{L}) \in \mathcal{M}_t) \equiv internal(m_i, l) \wedge internal(m_j, l)$ 
which evaluates to true if both methods $m_i$ and $m_j$ are are both internal to 
the pattern representation $l$. The $external$ predicate is defined as 
$external((m_i, m_j, l \in \mathcal{L}) \in \mathcal{M}_t) \equiv external(m_i, 
l) \vee external(m_j, l)$ which evaluates to true if either method $m_i$ or 
$m_j$ is determined to be external to the pattern realization. Both of the 
method pair predicates are based on the singular method predicates. The singular 
method $internal$ predicate is defined as $internal(m \in \mathcal{M}_t, l \in 
\mathcal{L}) \equiv \mathcal{B}_l(m) \neq \varnothing$ which evaluates to true 
if there is a binding from method $m$ to a role in a pattern specification of 
pattern realization $l$ as defined by $\mathcal{B}_l$. Similarly, the singular 
method $external$ predicate is defined as $external(m \in \mathcal{M}_t, l \in 
\mathcal{L}) \equiv \lnot internal(m, l)$

\subsection{Relationships}\label{subsec:formal_rel}
In the context of design pattern grime and object-oriented systems, we define 
three specific types of relationships: (i) usage relationships between methods 
and attributes of the same Class, (ii) connection relationships between classes, 
and (iii) dependency relationships between packages. The remainder of this 
subsection further defines these relationships.

A relationship simply defines a directed connection from one component of a 
system to another, as in: $r \equiv (c_1, c_2)$. Here, $c_1$ and $c_2$ are two 
components of the system. A relationship can be determined to be either 
persistent or temporary based on the type of relationship it is. This 
determination can be evaluated using the $persistent$ and $temporary$ 
predicates. The $persistent$ predicate is defined as $persistent(r \in 
\mathcal{Z}) \equiv r.type \in \{Generalization,\, Realization,\, Association\}$ 
evaluates true if the relationship is of type Generalization, Realization, or 
Association (including Composition or Aggregation). The $temporary$ predicate is 
defined as $temporary(r \in \mathcal{Z}) \equiv \lnot persistent(r)$ evaluates 
true if not persistent. For example, in Figure \ref{fig:ex_pkg_graph} 
$persistent((A,B))$ and $persistent(C,F)$ both evaluate to true, while 
$persistent(F, J)$ evaluates to false. On the other hand, $temporary(F, J)$ 
evaluates to true, while $temporary(J, G)$ evaluates to false.

\begin{figure}
\centering
\includegraphics[scale=.75]{images/Examples/Formal/composite.eps}
\caption{Example Composite Graph.}\label{fig:ex_comp_graph}
\end{figure}

Usage relationships describe the connection between the methods of a class and 
the attributes within that Class. These connections form when the statements of 
a method's body contain a read or write to a field of the method's containing 
Class. Thus the predicate $usage(m, a)$ evaluates to true if for some type, $t$, 
there is a method $m \in \mathcal{M}_t$ and an attribute $a \in \mathcal{A}_t$ 
where $m$ contains a statement which reads or writes the value of $a$. The set 
of usages of a type, $t$, can be defined as $\mathcal{U}_t \equiv \{\langle m, a 
\rangle\,|\, usage(m, a) \wedge m \in \mathcal{M}_t \wedge a \in 
\mathcal{A}_t\}$.

A pair of methods can either directly or indirectly access an attribute. This 
can be evaluated using the $direct$ or $indirect$ predicates for method pairs. 
The $direct$ predicate is defined as $direct((m_i, m_j) \in \mathcal{M}_t, a) 
\in \mathcal{M}_t) \equiv direct(m_i, a) \wedge direct(m_j, a)$ and evaluates to 
true if both the usage from method $m_i$ to attribute $a$ is a direct access 
(rather than through an accessor or mutator) \textit{and} the usage from $m_j$ 
to $a$ is also direct access. On the other hand, the $indirect$ predicate for 
method pairs is defined as $indirect((m_i, m_j) \in \mathcal{M}_t, a) \equiv 
indirect(m_i, a) \vee indirect(m_j, a)$ which evaluates to true if either the 
usages from method $m_i$ or from method $m_j$ to attribute $a$ is via an 
accessor or mutator. Both the method pair $direct$ and $indirect$ predicates are 
derived from the singular method $direct$ and $indirect$ predicates. The 
singluar method $direct$ predicate is defined as $direct(m \in \mathcal{M}_t, a 
\in \mathcal{A}_t) \equiv (m, a) \in \mathcal{U}_t$ which evaluates to true if 
there is a direct usage between method $m$ and attribute $a$ and $m$ and $a$ are 
defined in the same type $t$. Similarly the singluar method $indirect$ predicate 
is defined as $indirect(m \in \mathcal{M}_t, a) \equiv (calls(m, m_i \in 
accessors(t)) \wedge accessor(m_i, a)) \vee (calls(m, m_i \in mutators(t)) 
\wedge mutator(m_i, a))$ which evaluates to true if there is call from $m$ to 
some method $m_i$ which is either an accessor or mutator for attribute $a$ and 
all are defined in the same type $t$. Figure \ref{fig:ex_comp_graph} depicts 
several of the type properties as well as the aspects evaluated by the 
previously defined predicates. For example, in Figure \ref{fig:ex_comp_graph} we 
can see that for the type, $Class$, depicted; the attributes set is defined as 
$\mathcal{A}_{Class} = \{a1\,a2\,a3\}$ and the methods set is defined as 
$\mathcal{M}_{Class} = \{accessor\,m1\,m2\,m3\,m4\}$. Additionally, we can see 
that $direct((m1, m2), a1)$ evaluates to false due to the fact that both 
$direct(m1, a1)$ and $direct(m2, a1)$ evaluate to false. On the other hand, 
$direct((m3, m4), a3)$ evaluates to true as both $direct(m3, a3)$ and 
$direct(m4, a3)$ evaluate to true. Additionally, $indirect(m2, a1)$ evaluates to 
true, but $indirect(m3, a2)$ evaluates to false.

Connections represent relationships between classes. Relationships that form 
connections are Associations (including Aggregations and Compositions), 
Generalizations, Realizations, and Dependencies (such as Usage). Connections are 
between classes and are used to define the relationships between packages (known 
as dependencies). Note, multiple connections could realize a single dependency. 
The set of connections in the system can be defined as $\mathcal{K} \equiv 
\{\langle a, b \rangle\,|\, conn(x, y)\}$. For example, in Figure 
\ref{fig:ex_pkg_graph} $conn(F, K)$ evaluates to true, but $conn(K, L)$ 
evaluates to false.

A connection $(t_1, t_2)$ can be determined as invalid in the context of a 
design pattern realization using the following predicate: $invalid(r = (t_1, 
t_2) \in \mathcal{K}, l \in \mathcal{L}) \equiv (r \notin \mathcal{B}_l \wedge 
internal(r)) \vee (internal(t1, l) \wedge external(t2, l))$ For example, in 
Figure \ref{fig:ex_pattern_graph} $invalid((SearchClient, SearchStrategy))$ 
evaluates false as there is a binding to that relationship, but 
$invalid(AnotherDFS, BreadthFirstSearch)$ evaluates to true as there is no 
binding to that relationship.

A connection can be either internal or external to a pattern realization. This 
can be evaluated using the predicates $internal$ and $external$. The $internal$ 
predicate is defined as $internal((t_i, t_j) \in \mathcal{K}, l \in \mathcal{L}) 
\equiv t_i, t_j \in \mathcal{T}_l$ and evaluates true if the provided connection 
is between two types defined within the pattern realization, $l$. The $external$ 
predicate is defined as $external((t_i, t_j) \in \mathcal{K}, l \in \mathcal{L}) 
\equiv t_i \notin \mathcal{T}_l \vee t_j \notin \mathcal{T}_l$ and evaluates to 
true if the provided connection has at least one type which is external to the 
pattern specification. For example, in Figure \ref{fig:ex_pattern_graph} 
$internal(SearchClient, SearchStrategy)$ evaluates to true, as both SearchClient 
and SearchStrategy are members of the pattern realization and fulfill roles 
according to the pattern specification.

Dependencies represent relationships between packages. These relationships (as 
noted previously) are formed by the connections between classes that cross 
package boundaries. Thus the predicate $depend(x, y) \equiv \exists_{c \in 
\mathcal{T}_x, d \in \mathcal{T}_y} \,\, conn(x, y)$ evaluates to true if there 
exists a class $c$ in package $x$ and a class $d$ in package $y$ such that there 
is a connection between classes $c$ and $d$. The set of dependencies in the 
system can be defined as $\mathcal{D} \equiv \{\langle x, y \rangle\,|\, 
depend(x, y) \wedge x, y \in \mathcal{P} \wedge x \neq y\}$. For example, in 
Figure \ref{fig:ex_pkg_graph} $depend(A,G)$ evaluates to true, but $depend(A,B)$ 
evaluates to false. For example, in Figure \ref{fig:ex_pkg_graph} the set 
$\mathcal{D} = \{(A,D)\, (B,D)\, (C,D)\, (D,E)\, (D,F)\, (F,D)\, (D,G)\}$, while 
the set of connections between classes $\mathcal{K} = \{(A,G)\, (B,G)\, (C,F)\, 
(E,G)\, (F,G)\, (F,K)\, (G,I)\, (J,G)\}$.

A sequence of dependencies where the target of a preceeding dependency is the 
source of a succeeding depedency is called a path. Determining if such a 
sequence exists from one package $p_i$ to another $p_j$ is determined by the 
predicate $path(p_i, p_j)$. For example, in Figure \ref{fig:ex_pkg_graph} 
$path(A, E)$ evaluates to true for packages $A$ and $E$. Paths can then be used 
to form the set of packages reachable from a given package $p$, which is defined 
as $reachable(p) \equiv \{ x | path(p, x) \wedge p, x \in \mathcal{P}\}$ 
represents the set of packages to which a path (excluding cycles). For example, 
in Figure \ref{fig:ex_pkg_graph} $reachable(A) = {D\,E\,F\,G}$. Additionally, a 
path can form a cycle if the source of the first dependency in the sequence is 
the target of the last dependency in the sequence. Formally, we can define a 
predicate $cycle$ as $cycle(p, q) \equiv path(p, q) \wedge depends(q, p)$ which 
evaluates to true when there is a path from package $p$ to package $q$ and a 
dependency from $q$ to $p$. Often there packages define simple cycles where a 
package $p$ depends on package $q$ and $q$ also depends on $p$. This is 
formalized by the predicate $directCycle(p, q) \equiv depends(p, q) \wedge 
depends(q, p)$. For example, in Figure \ref{fig:ex_pkg_graph} $cycle(D,F)$ and 
$directCycle(F,D)$ both evaluate to true.

Each type of relationship defined above allows for the representation of the 
entities as a graph structure. Usage relationships between the methods and 
attributes of a Type construct a bipartite directed graph. On the other hand, 
Connections represent the structural relationships between types forming a 
directed graph similar to a UML class diagram. Dependencies represent the 
structural relationships between packages, which form a directed graph similar 
to a UML Package Diagram.

\section{Modular Grime}\label{sec:mod_grime_tax}
Modular Grime is the build-up of unnecessary and invalid relationships between 
classes of a pattern realization and between classes of a pattern and classes 
external to the pattern. Schanz and Izurieta \cite{schanz_object_2010} defined 
the Modular Grime taxonomy, c.f. Figure \ref{fig:mod-tax}, included here for 
completeness. We have re-envisioned the definitions of Modular Grime to be 
consistent with the above formal framework while being equivalent to the 
original definitions.

\begin{figure}[tb]
\centering
\includegraphics[scale=.20]{taxonomies/mod_grime-tax.eps}
\caption{The extended Modular Grime taxonomy.}\label{fig:mod-tax}
\end{figure}

\subsection{Class Coupling}
Coupling describes the interconnectedness of a set of classes. Based on this and 
the principle of Low Coupling, Schanz and Izurieta decomposed coupling into 
three categories: (i) Strength, (ii) Scope, and (iii) Direction, which form the 
levels of the Modular Grime taxonomy.

\paragraph*{Strength} Strength indicates the strength of the coupling between 
classes. The strength may be either persistent (couplings based on associations, 
generalizations, or realizations between classes) or temporary (couplings based 
on local variable types, method return types, or method parameter types (aka Use 
Dependencies)). Persistent couplings are more challenging to remediate via 
techniques such as refactoring, whereas temporary relationships tend to be more 
amenable to remediation via techniques such as refactoring.

\paragraph*{Scope} Scope indicates that a relationship contained within the 
context of the pattern or not. Thus, the scope may be either internal (a 
relationship defined between two types fulfilling roles within the pattern 
realization) or external (a relationship defined between a type fulfilling a 
role in the pattern realization and one outside the definition of the pattern 
realization).

\paragraph*{Direction} Direction indicates the direction of the coupling between 
types, in the context of the pattern realization. The direction is only 
pertinent to those relationships that are determined to be external. 
Relationships that are outgoing from the pattern realization are called efferent 
couplings, and those that are incoming to the pattern realization are called 
afferent couplings. These are measured using the $Ce$ and $Ca$ metrics 
\cite{martin_agile_2003}, respectively. Where $Ce$ is the count of outgoing 
dependencies from a package to other packages, or in the context of a pattern 
realization, it is the count of the outgoing couplings from pattern internal 
classes to pattern, external classes. Similarly, $Ca$ is the count of incoming 
dependencies from other packages into a package, or in the context of a pattern 
realization, it is the count of the incoming couplings from pattern external 
classes to pattern internal classes.

\subsection{Modular Grime Examples}
Figure \ref{fig:pig_ex} depicts an example of Persistent Internal Grime (PIG). 
The figure depicts a Strategy Pattern realization in which all depicted classes 
are internal to the pattern. Except for the green relationship from 
``AnotherDFS'' to ``BreadthFirstSearch,'' all relationships are valid based on 
the Strategy Pattern RBML definition. The green relationship indicates an 
example of PIG.

\begin{figure}
\centering
\includegraphics[scale=.750]{examples/pig_ex.eps}
\caption{An example of the PIG type of Modular Grime.}\label{fig:pig_ex}
\end{figure}

Figure \ref{fig:peeg_ex} depicts an example of Persistent External Efferent 
Grime. The dashed red line partitions pattern realization connected classes into 
either internal classes (above and to the right) or external classes (below and 
to the left). Furthermore, we see that there are two incoming (efferent) 
associations (persistent) relationships crossing this border, which are invalid 
to the pattern definition. These two lines (marked green) are two examples of 
PEEG.

\begin{figure}
\centering
\includegraphics[scale=.750]{examples/peeg_ex.eps}
\caption{An example of the PEEG type of Modular Grime.}\label{fig:peeg_ex}
\end{figure}

In Figure \ref{fig:disg_ch3_ex} we can see an example of Direct Internal Single 
Grime (DISG). The figure is the representation of a pattern class. The dashed 
red line indicates those methods internal (specified by the pattern) or external 
(not specified by the pattern) to the pattern. The figure depicts a case of DISG 
as there is a method, $m1$, allowed by the pattern specification that directly 
uses an attribute, $a1$, but no other method uses that attribute. This instance 
of grime indicates that there could be an unintentional secondary responsibility 
associated with this Class or a misunderstanding on the part of the developer in 
the pattern's implementation.

\subsection{Modular Grime Categories}
Using the notions of Strength, Scope, and Direction, Schanz and Izurieta defined 
six specific categories of Modular Grime. In the following, we describe these 
categories and provide a formal set definition for each based on the framework 
from Section \ref{sec:formal}.

\paragraph*{Persistent Internal Grime (PIG)} The set of relationships which are 
persistent, internal to the pattern realization $l$, are invalid according to 
the pattern specification of $l$ and where the number of connections between 
classes of $l$ increases. Formally, this defines the set $\{r\,|\,l \in 
\mathcal{L}_\mathcal{S} \wedge persistent(r) \wedge internal(r, l) \wedge 
invalid(r, l.r) \wedge \left|\mathcal{K}_l\right|\uparrow\}$.

\paragraph*{Temporary Internal Grime (TIG)} The set of relationships which are 
temporary, internal to the pattern realization $l$, are invalid according to the 
pattern specification of $l$ and where the number of connections between classes 
of $l$ increases. Formally, this defines the set $\{r\,|\,l \in 
\mathcal{L}_\mathcal{S} \wedge temporary(r) \wedge internal(r, l) \wedge 
invalid(r, l.r) \wedge \left|\mathcal{K}_l\right|\uparrow\}$.

\paragraph*{Persistent External Efferent Grime (PEEG)} The set of relationships 
which are persistent, external to the pattern realization $l$, are invalid 
according to the pattern specification of $l$, and which increase the efferent 
coupling of pattern instance $l$. Formally, this defines the set $\{r\,|\,l \in 
\mathcal{L}_\mathcal{S} \wedge persistent(r) \wedge external(r, l) \wedge 
invalid(r, l.r) \wedge Ce(l)\uparrow\}$.

\paragraph*{Temporary External Efferent Grime (TEEG)} The set of relationships 
which are temporary, external to the pattern realization $l$, are invalid 
according to the pattern specification of $l$, and which increase the efferent 
coupling of pattern instance $l$. Formally, this defines the set $\{r\,|\,l \in 
\mathcal{L}_\mathcal{S} \wedge temporary(r) \wedge external(r, l) \wedge 
invalid(r, l.r) \wedge Ce(l)\uparrow\}$.

\paragraph*{Persistent External Afferent Grime (PEAG)} The set of relationships 
which are persistent, external to the pattern realization $l$, are invalid 
according to the pattern specification of $l$, and which increase the afferent 
coupling of pattern instance $l$. Formally, this defines the set $\{r\,|\,l \in 
\mathcal{L}_\mathcal{S} \wedge persistent(r) \wedge external(r, l) \wedge 
invalid(r, l.r) \wedge Ca(l)\uparrow\}$.

\paragraph*{Temporary External Afferent Grime (TEAG)} The set of relationships 
which are temporary, external to the pattern realization $l$, are invalid 
according to the pattern specification of $l$, and which increase the afferent 
coupling of pattern instance $l$. Formally, this defines the set $\{r\,|\,l \in 
\mathcal{L}_\mathcal{S} \wedge temporary(r) \wedge external(r, l) \wedge 
invalid(r, l.r) \wedge Ca(l)\uparrow\}$.

\section{Class Grime}\label{sec:class_grime_tax} Class Grime is the build-up of 
unnecessary (given the specification of a pattern) methods and fields within the 
classes of a pattern instance. Such a build-up implies a violation of one or 
more of the following design principles:
\begin{itemize}
  \item The YAGNI (You Ain't Gonna Need It) principle -- you should not add 
functionality until you are going to need it \cite{fowler_refactoring:_1999}.
  \item The Single Responsibility Principle (SRP) -- a class should only have 
responsibility for a single part of the functionality of the software, and the 
Class should fully encapsulate this responsibility \cite{martin_agile_2003}.
  \item The Interface Segregation Principle (ISP) -- no client should depend on 
those methods it does not use \cite{martin_agile_2003}. 
  \item High class cohesion -- the responsibilities of the methods within a 
class should be highly related and support the responsibility of that Class 
\cite{yourdon_structured_1979}.
\end{itemize}

Each of these principles speaks to the cohesion of a class. High cohesion is a 
fundamental object-oriented principle, in which a highly cohesive class is a 
class in which its member fields and methods work together to address a single 
primary responsibility of the Class. Using cohesion as the fundamental property, 
we have divided Class Grime into eight specific subtypes, as depicted in Figure 
\ref{fig:class-tax}. The following sections further explain this division.

\begin{figure}
\centering
\includegraphics[scale=.20]{taxonomies/class_grime-tax.eps}
\caption{The extended Class Grime taxonomy.}\label{fig:class-tax}
\end{figure}

\subsection{Class Cohesion}
Cohesion describes how well constructed a class is \cite{briand_unified_1998}. 
The higher the cohesion of a class, the closer aligned its internal components 
are towards a common goal. In design pattern realizations, the classes should 
represent individual responsibilities of the pattern, and each Class should have 
high cohesion. Thus cohesion provides a basis to determine whether a design 
pattern realization's classes contain Class Grime.

\begin{figure}
\centering
\includegraphics[scale=.750]{examples/iesg_ex.eps}
\caption{An example of the IESG type of Class Grime.}\label{fig:classgrime-ex}
\end{figure}

\paragraph*{Strength} Strength indicates how a class' methods access its local 
attributes. The method of access can be either direct (methods directly access 
attributes) or indirect (attribute accessed through the use of accessor/mutator 
methods). Figure \ref{fig:classgrime-ex} depicts each method of access. In this 
figure, the unbroken lines between attributes (rectangles) and methods (rounded 
rectangles) are direct relationships, and the lines broken by a smaller rounded 
rectangle are indirect relationships. Direct attribute use provides a stronger 
but more brittle relationship between the method and attribute, causing issues 
when attempting to refactor by moving the attribute. Whereas indirect attribute 
use implies a flexible and weaker relationship between the method and attribute, 
but one which is more amenable to refactoring.

\paragraph*{Scope} In the context of pattern classes, the scope can either be 
internal or external. Internal refers to attributes access by a local method (or 
local method pair, depending on context) defined by the pattern specification. 
External refers to attributes accessed by at least one local method (or local 
method pair) not defined by the pattern specification. In Figure 
\ref{fig:classgrime-ex}, the internal/external division is shown by the dashed 
red line dividing the Class into methods/attributes associated with the pattern 
specification of that Class and those methods/attributes not specified by the 
pattern specification. Thus providing a means to distinguish between 
identification of attributes or methods that obscure the pattern implementation 
by reducing overall class cohesion.

\paragraph*{Context} The context refers to the types of relationships taken into 
account by surrogate metrics used to measure cohesion. The majority of cohesion 
metrics take one of two perspectives: single-method use or method pair use of 
attributes \cite{briand_unified_1998}. In order to satisfy the strength, scope, 
and context aspects of the taxonomy, we have selected two metrics. The first is 
Tight Class Cohesion (TCC) \cite{bieman_cohesion_1995}, which measures the 
cohesion of a class by looking at pairs of methods with attributes in common, 
and it can handle both indirect and direct attribute use. The second is the 
Ratio of Cohesive Interactions (RCI) \cite{briand_measuring_1993} metric, which 
measures the cohesion of a class by looking at how particular methods use 
attributes, and it can handle both indirect and direct attribute use.

\begin{figure}[tbh]
\centering
\includegraphics[scale=.75]{examples/disg_ex.eps}
\caption{Example of DISG.}\label{fig:disg_ch3_ex}
\end{figure}

\subsection{Class Grime Example}
In Figure \ref{fig:disg_ch3_ex} we can see an example of Direct Internal Single 
Grime (DISG). The figure is the representation of a pattern class. Where the 
dashed red line indicates those methods that are internal (specified by the 
pattern) and those external (not specified by the pattern). The figure depicts a 
case of DISG, as there exists a method, $m1$, allowed by the pattern 
specification that directly uses an attribute, $a1$, but no other method uses 
that attribute. This instance of DISG indicates that there could be an 
unintentional secondary responsibility associated with this Class or a 
misunderstanding on the part of the developer in the pattern's implementation.

\subsection{Class Grime Categories}
Using the notions of Strength, Scope, and Context, we define eight specific 
categories of Class Grime. In the following, we describe these categories and 
provide a formal set definition for each based on the framework from Section 
\ref{sec:formal}.

\paragraph*{Direct Internal Pair Grime (DIPG)} 
The set of method pairs from the type $t$ which are internal to pattern 
realization $l$, form a direct relationship to the same attribute $a$, the set 
of methods calling $m_1$ is empty, and for which the relationships decrease the 
TCC of $t$. Formally, this defines the set $\{(m_1, m_2)\,|\,t \in 
\mathcal{T}_\mathcal{S} \wedge m_1, m_2 \in \mathcal{M}_t \wedge r_1 = (m_1, a) 
\wedge r_2 = (m_2, a) \wedge a \in \mathcal{A}_t \wedge direct(r_1, r_2) \wedge 
internal(m_1, m_2) \wedge calls(m_1) = \varnothing \wedge TCC(t) \downarrow\}$.

% The set of invalid direct internal class relationships between pairs of 
methods and attributes within the classes of a pattern. DIPG can be observed 
when $(m_{i},\, m_{j}) \in Internal$, $(r_{i},\, r_{j}) \in Direct$, 
$r_{i}.attribute = r_{j}.attribute$, and $TCC$ decreases.

% \begin{figure}[tbh] \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Class/dipg_ex.eps}
% \caption{Example of DIPG.}\label{fig:dipg_ex} \end{figure}

\paragraph*{Direct Internal Single Grime (DISG)} 
The set of methods from the type $t$ which are internal to pattern realization 
$l$, forms a direct relationship to attribute $a$, the set of methods calling 
$m$ is empty, and for which the relationships decrease the RCI of $t$. Formally, 
this defines the set $\{m\,|\,t \in \mathcal{T}_\mathcal{S} \wedge m \in 
\mathcal{M}_t \wedge r = (m, a) \wedge a \in \mathcal{A}_t \wedge direct(r) 
\wedge internal(m) \wedge RCI(t) \downarrow\}$.

% \begin{figure}[tbh]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Class/disg_ex.eps}
% \caption{Example of DISG.}\label{fig:disg_ex}
% \end{figure}

\paragraph*{Direct External Pair Grime (DEPG)} 
The set of method pairs from the type $t$ which are external to pattern 
realization $l$, form a direct relationship to the same attribute $a$, the set 
of methods calling $m_1$ is empty, and for which the relationships decrease the 
TCC of $t$. Formally, this defines the set $\{(m_1, m_2)\,|\,t \in 
\mathcal{T}_\mathcal{S} \wedge m_1, m_2 \in \mathcal{M}_t \wedge r_1 = (m_1, a) 
\wedge r_2 = (m_2, a) \wedge a \in \mathcal{A}_t \wedge direct(r_1, r_2) \wedge 
external(m_1, m_2) \wedge calls(m_1) = \varnothing \wedge TCC(t) \downarrow\}$.

% \begin{figure}[tbh] \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Class/depg_ex.eps}
% \caption{Example of DEPG.}\label{fig:depg_ex} \end{figure}

\paragraph*{Direct External Single Grime (DESG)} 
The set of methods from the type $t$ which are external to pattern realization 
$l$, forms a direct relationship to attribute $a$, the set of methods calling 
$m$ is empty, and for which the relationships decrease the RCI of $t$. Formally, 
this defines the set $\{m\,|\,t \in \mathcal{T}_\mathcal{S} \wedge m \in 
\mathcal{M}_t \wedge r = (m, a) \wedge a \in \mathcal{A}_t \wedge direct(r) 
\wedge external(m) \wedge RCI(t) \downarrow\}$.

% \begin{figure}[tbh] \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Class/desg_ex.eps}
% \caption{Example of DESG.}\label{fig:desg_ex} \end{figure}

\paragraph*{Indirect Internal Pair Grime (IIPG)} 
The set of method pairs from the type $t$ which are internal to pattern 
realization $l$, form an indirect relationship to the same attribute $a$, the 
set of methods calling $m_1$ is empty, and for which the relationships decrease 
the TCC of $t$. Formally, this defines the set $\{(m_1, m_2)\,|\,t \in 
\mathcal{T}_\mathcal{S} \wedge m_1, m_2 \in \mathcal{M}_t \wedge r_1 = (m_1, a) 
\wedge r_2 = (m_2, a) \wedge a \in \mathcal{A}_t \wedge indirect(r_1, r_2) 
\wedge internal(m_1, m_2) \wedge calls(m_1) = \varnothing \wedge TCC(t) 
\downarrow\}$.

% \begin{figure}[tbh] \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Class/iipg_ex.eps}
% \caption{Example of IIPG.}\label{fig:iipg_ex} \end{figure}

\paragraph*{Indirect Internal Single Grime (IISG)}
The set of methods from the type $t$ which are internal to pattern realization 
$l$, forms an indirect relationship to attribute $a$, the set of methods calling 
$m$ is empty, and for which the relationships decrease the RCI of $t$. Formally, 
this defines the set $\{m\,|\,t \in \mathcal{T}_\mathcal{S} \wedge m \in 
\mathcal{M}_t \wedge r = (m, a) \wedge a \in \mathcal{A}_t \wedge indirect(r) 
\wedge internal(m) \wedge RCI(t) \downarrow\}$.

% \begin{figure}[tbh]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Class/iisg_ex.eps}
% \caption{Example of IISG.}\label{fig:iisg_ex}
% \end{figure}

\paragraph*{Indirect External Pair Grime (IEPG)}
The set of method pairs from the type $t$ which are external to pattern 
realization $l$, form a indirect relationship to the same attribute $a$, the set 
of methods calling $m_1$ is empty, and for which the relationships decrease the 
TCC of $t$. Formally, this defines the set $\{(m_1, m_2)\,|\,t \in 
\mathcal{T}_\mathcal{S} \wedge m_1, m_2 \in \mathcal{M}_t \wedge r_1 = (m_1, a) 
\wedge r_2 = (m_2, a) \wedge a \in \mathcal{A}_t \wedge indirect(r_1, r_2) 
\wedge external(m_1, m_2) \wedge TCC(t) \downarrow\}$.

% \begin{figure}[tbh]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Class/iepg_ex.eps}
% \caption{Example of IEPG.}\label{fig:iepg_ex}
% \end{figure}

\paragraph*{Indirect External Single Grime (IESG)} 
The set of methods from the type $t$ which are external to pattern realization 
$l$, forms an indirect relationship to attribute $a$, the set of methods calling 
$m$ is empty, and for which the relationships decrease the RCI of $t$. Formally, 
this defines the set $\{m\,|\,t \in \mathcal{T}_\mathcal{S} \wedge m \in 
\mathcal{M}_t \wedge r = (m, a) \wedge a \in \mathcal{A}_t \wedge indirect(r) 
\wedge external(m) \wedge RCI(t) \downarrow\}$.

% \begin{figure}[tbh]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Class/iesg_ex.eps}
% \caption{Example of IESG.}\label{fig:iesg_ex}
% \end{figure}

\section{Organizational Grime}\label{sec:org_grime_tax}
Organizational Grime is the accumulation of design pattern grime due to the 
allocation of pattern classes to packages, namespaces, or modules within a 
software system. The development of the Organizational Grime hierarchy comes 
from the following design principles:

\begin{itemize}
  \item The Acyclic Dependencies Principle (ADP) -- Dependencies between 
packages should not form cycles \cite{martin_agile_2003}.
  \item The Stable Dependencies Principle (SDP) -- Depend in the direction of 
stability \cite{martin_agile_2003}.
  \item The Stable Abstractions Principle (SAP) -- Abstractness should increase 
with stability \cite{martin_agile_2003}.
  \item The Common Closure Principle (CCP) -- Classes in a package should be 
closed to the same kinds of changes \cite{martin_agile_2003}.
  \item The Common Reuse Principle (CRP) -- Classes in the same package should 
be reused together \cite{martin_agile_2003}.
\end{itemize}

\noindent These principles speak to both the coupling between packages and the 
cohesion within a package. Using the properties of package coupling and 
cohesion, we have divided package grime into twelve specific subtypes, as 
depicted in Figure \ref{fig:org-tax}. The following sections further explain 
this division.

\begin{figure*}[tb]
\begin{centering}
\includegraphics[width=\textwidth, scale=0.15]{taxonomies/org_grime-tax}
\par\end{centering}
\begin{centering}
\caption{Organizational Grime taxonomy.} \label{fig:org-tax}
\par\end{centering}
\end{figure*}

\subsection{Package Cohesion}
Package cohesion is used to develop the \textit{Package} subtype of 
Organizational Grime, as seen in Figure \ref{fig:org-tax}. Here we consider only 
the scope and context properties. Together these concepts are used to form the 
Package branch of Organizational Grime.

\paragraph*{Scope}
The scope can be either internal or external, both referring to the addition of 
a new class or type to a package. If the new class or type is also a member of 
the pattern under consideration, then its scope is internal; otherwise, it is 
external.

\paragraph*{Context/Direction}
The context property takes the form of either closure or reuse. Closure here 
indicates that the new class or type fits within the package by being closed to 
similar changes as the other classes. Reuse indicates that we are concerned with 
how well a class integrates into its containing package based on how tightly it 
couples with the remaining classes.

The closure quality of a package is measured using the \textit{CohesionQ} metric 
defined by Abdeen et al. \cite{abdeen_2009}. The reuse quality of a package is 
measured using the \textit{CouplingQ} metric defined by Abdeen et al. 
\cite{abdeen_2009}. These metrics are calculated using the following formulas:

\begin{IEEEeqnarray}{rCl}
CohesionQ(p) & = & \frac{\left|p_{Int.D}\right|}{\left|p_D\right|}\\
CouplingQ(p) & = & 1 - \frac{\left|p_{Pro.P} \cup
p_{Cli.P}\right|}{\left|p_D\right|}
\end{IEEEeqnarray}

\noindent Common to both $CohesionQ$ and $CouplingQ$, the set $p_D$ is the set 
of all dependencies in and out of package $p$. Formally we define $p_D$ as $p_D 
\equiv \forall_{p_i \in \mathcal{P}_\mathcal{S}} ((p, p_i) \in \mathcal{D} \vee 
(p_i, p) \in \mathcal{D}) \wedge p \neq p_i$. The set $p_{Int.D}$ is the set of 
internal dependencies (connections) between classes within package $p$. Formally 
we define $p_{Int.D}$ as $p_{Int.D} \equiv \forall_{\{t_i,t_j\}\in p} (t_i, t_j) 
\in \mathcal{K}$.

\subsection{Package Coupling}
Package coupling is the basis of the \textit{Modular} subtype of Organizational 
Grime, c.f. Figure \ref{fig:org-tax}. Together these concepts are used to form 
the Modular branch of Organizational Grime.

\paragraph*{Strength}
Here we consider three properties of coupling between packages. The first is the 
\emph{strength}, which can be either \emph{persistent} or \emph{temporary}. 
Persistent couplings are those created by inheritance, realization, associations 
(including aggregation and composition), temporary are the remaining 
dependencies such as use dependencies.

\paragraph*{Scope}
The next property is \emph{scope}, which can be either \emph{internal} or 
\emph{external}. Internal couplings are those that are caused by classes within 
the same pattern but spread across packages. External couplings are 
relationships between packages that are caused by external classes interacting 
with pattern classes across packages.

\paragraph*{Context/Direction}
The final property is \emph{direction/context}. Here we are looking at how the 
coupling affects cyclic dependencies between packages, \emph{cyclical} value, 
and the flow of stability between packages, \emph{unstable} value. When we are 
considering whether the new dependency will cause cycles between packages we are 
in the cyclical context, and when we are considering the flow of dependencies 
towards stability, then we are in the unstable context. Cycles in the package 
dependency graph can be evaluated using the algorithm for enumerating cycles in 
a directed graph developed by Liu and Wang \cite{liu_wang_2006}. Instability of 
packages is measured using Martin's \textit{Normalized Distance (D')} metric 
\cite{martin_agile_2003}, which is calculated as follows:

\begin{IEEEeqnarray}{rCl}
D' & = & \left|A + I - 1\right|\\
A  & = & \frac{N_a}{N_c}\\
I  & = & \frac{C_e}{C_a + C_e}
\end{IEEEeqnarray}

\noindent Equation 9.1 represents the distance from the main sequence and has 
values in the range [0,1] with 0, indicating that the package is on the main 
sequence. Packages with values away from zero tend to be less maintainable and 
more sensitive to change. To complete the computation of $D'$, we need to 
calculate several other values. The first is the \textit{Abstractness (A)} 
metric, which is a measure of the level of abstraction in a given package. The 
$A$ metric is calculated as the ratio of the \textit{number of abstract classes 
($N_a$)} to the \textit{number of classes ($N_c$)} in a package. The second 
value necessary for calculating $D'$ is the \textit{Instability (I)} metric, 
which measures the level of instability of a given package. The $I$ metric is 
the ratio of the number of efferent couplings ($C_e$) of a package to the sum of 
the number of efferent ($C_e$) and afferent couplings ($C_a$) of a package.

\begin{figure}[tbH]
\centering
\includegraphics[scale=.5]{examples/pecg_ex.eps}
\caption{Example of PECG.}\label{fig:pecg_ch3_ex}
\end{figure}

\subsection{Organizational Grime Example}
In Figure \ref{fig:pecg_ch3_ex} we can see an example of Package External 
Closure Grime (PECG). In this diagram, those classes which are a part of the 
pattern as grey rectangles, and classes not part of the pattern as white 
rectangles. The figure depicts dependencies between packages using a dashed line 
with an open arrowhead pointing in the direction of the dependency, while other 
relationships follow the usual UML syntax. The red items mark the causes of 
grime. Here there is an XOR relation between either an existing class or new 
class (both external to the pattern) interacting with a non-pattern class but 
increasing the number of packages reachable from pattern packages.

\subsection{Organizational Grime Categories}
Using the notions of Strength, Scope, and Context, we define twelve specific 
categories of Organizational Grime. In the following, we describe these 
categories and provide a formal set definition for each based on the framework 
from Section \ref{sec:formal}.


\paragraph*{Package External Closure Grime (PECG)} The set of classes which are 
internal to a pattern bearing package, external to a pattern realization, and 
whose connections decrease the cohesion quality (and thus the common closure) of 
the package. Formally, this defines the set $\{c\,|\,l \in \mathcal{L} \wedge p 
\in \mathcal{P}_l \wedge external(c, l) \wedge internal(c, p) \wedge 
CohesionQ(q)\downarrow\}$.

% \begin{figure}[tbH]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Organizational/pecg_ex.eps}
% \caption{Example of PECG.}\label{fig:pecg_ex}
% \end{figure}

\paragraph*{Package External Reuse Grime (PERG)} The set of classes which are 
internal to a pattern bearing package, external to a pattern realization, and 
whose connections decrease the coupling quality (and thus the common reuse) of 
the package. Formally, this defines the set $\{c\,|\,l \in \mathcal{L} \wedge p 
\in \mathcal{P}_l \wedge external(c, l) \wedge internal(c, p) \wedge 
CouplingQ(q)\downarrow\})$. 

% \begin{figure}[tbH]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Organizational/perg_ex.eps}
% \caption{Example of PERG.}\label{fig:perg_ex}
% \end{figure}

\paragraph*{Package Internal Closure Grime (PICG)} The set of classes which are 
internal to a pattern bearing package, internal to a pattern realization, and 
whose connections decrease the cohesion quality (and thus the common closure) of 
the package. Formally, this defines the set $\{c\,|\,l \in \mathcal{L} \wedge p 
\in \mathcal{P}_l \wedge internal(c, l) \wedge internal(c, p) \wedge 
CohesionQ(q)\downarrow\}$. 

% \begin{figure}[tbH]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Organizational/picg_ex.eps}
% \caption{Example of PICG.}\label{fig:picg_ex}
% \end{figure}

\paragraph*{Package Internal Reuse Grime (PIRG)} The set of classes which are 
internal to a pattern bearing package, internal to a pattern realization, and 
whose connections decrease the coupling quality (and thus the common reuse) of 
the package. Formally, this defines the set $\{c\,|\,l \in \mathcal{L} \wedge p 
\in \mathcal{P}_l \wedge internal(c, l) \wedge internal(c, p) \wedge 
CouplingQ(q)\downarrow\})$.

% \begin{figure}[tbH]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Organizational/pirg_ex.eps}
% \caption{Example of PIRG.}\label{fig:pirg_ex}
% \end{figure}

\paragraph*{Modular Persistent External Cyclical Grime (MPECG)} The set of 
dependencies between a pattern-bearing package and a non-pattern-bearing 
package, created due to a persistent connection between classes, and cause a 
cyclic dependency between the connected packages. Formally, this defines the set 
$\{(d, e)\,|\, persistent((d, e)) \wedge (external(d, \mathcal{P}_r) \vee 
external(e, \mathcal{P}_r)) \wedge r \in \mathcal{R} \wedge cycle(d, e)\}$. 

% \begin{figure}[tbH]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Organizational/mpecg_ex.eps}
% \caption{Example of MPECG.}\label{fig:mpecg_ex}
% \end{figure}

\paragraph*{Modular Temporary External Cyclical Grime (MTECG)} The set of 
dependencies between a pattern-bearing package and a non-pattern-bearing 
package, created due to a temporary connection between classes, and cause a 
cyclic dependency between the connected packages. Formally, this defines the set 
$\{(d, e)\,|\, temporary((d, e)) \wedge (external(d, \mathcal{P}_r) \vee 
external(e, \mathcal{P}_r)) \wedge r \in \mathcal{R} \wedge cycle(d, e)\}$.

% \begin{figure}[tbH]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Organizational/mtecg_ex.eps}
% \caption{Example of MTECG.}\label{fig:mtecg_ex}
% \end{figure}

\paragraph*{Modular Persistent Internal Cyclical Grime (MPICG)}The set of 
dependencies between packages which contain types that are internal to a pattern 
instance, created due to a persistent connection between classes, and cause a 
cyclic dependency between the connected packages. Formally, this defines the set 
$\{(d, e)\,|\, persistent((d, e)) \wedge internal(d, e, \mathcal{P}_r) \wedge r 
\in \mathcal{R} \wedge cycle(d, e)\}$.

% \begin{figure}[tbH]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Organizational/mpicg_ex.eps}
% \caption{Example of MPICG.}\label{fig:mpicg_ex}
% \end{figure}

\paragraph*{Modular Temporary Internal Cyclical Grime (MTICG)} The set of 
dependencies between packages which contain types that are internal to a pattern 
instance, created due to a temporary connection between classes, and cause a 
cyclic dependency between the connected packages. Formally, this defines the set 
$\{(d, e)\,|\, temporary((d, e)) \wedge internal(d, e, \mathcal{P}_r) \wedge r 
\in \mathcal{R} \wedge cycle(d, e)\}$.

% \begin{figure}[tbH]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Organizational/mticg_ex.eps}
% \caption{Example of MTICG.}\label{fig:mticg_ex}
% \end{figure}

\paragraph*{Modular Persistent External Unstable Grime (MPEUG)} The set of 
dependencies between pattern-bearing package and a non-pattern-bearing package, 
created due to a persistent connection between classes, and the source side of 
the dependency is more stable than the target side of the dependency. Formally, 
this defines the set $\{(d, e)\,|\, persistent((d, e)) \wedge ((external(d, 
\mathcal{P}_r) \wedge internal(e, \mathcal{P}_r) \wedge I(e) \leq I(d)) \vee 
(internal(d, \mathcal{P}_r) \wedge external(e, \mathcal{P}_r) \wedge I(d) \leq 
I(e)))\}$.

% \begin{figure}[tbH]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Organizational/mpeug_ex.eps}
% \caption{Example of MPEUG.}\label{fig:mpeug_ex}
% \end{figure}

\paragraph*{Modular Temporary External Unstable Grime (MTEUG)} The set of 
dependencies between pattern-bearing package and a non-pattern-bearing package, 
created due to a temporary connection between classes, and the source side of 
the dependency is more stable than the target side of the dependency. Formally, 
this defines the set $\{(d, e)\,|\, temporary((d, e)) \wedge ((external(d, 
\mathcal{P}_r) \wedge internal(e, \mathcal{P}_r) \wedge I(e) \leq I(d)) \vee 
(internal(d, \mathcal{P}_r) \wedge external(e, \mathcal{P}_r) \wedge I(d) \leq 
I(e)))\}$. 

% \begin{figure}[tbH]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Organizational/mteug_ex.eps}
% \caption{Example of MTEUG.}\label{fig:mteug_ex}
% \end{figure}

\paragraph*{Modular Persistent Internal Unstable Grime (MPIUG)} The set of 
dependencies between packages which contain types that are internal to a pattern 
instance, created due to a persistent connection between classes, and the source 
side of the dependency is more stable than the target side of the dependency. 
Formally, this defines the set $\{(d, e)\,|\, persistent((d, e)) \wedge 
internal(d, e, \mathcal{P}_r) \wedge I(d) \leq I(e)\}$. 

% \begin{figure}[tbH]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Organizational/mpiug_ex.eps}
% \caption{Example of MPIUG.}\label{fig:mpiug_ex}
% \end{figure}

\paragraph*{Modular Temporary Internal Unstable Grime (MTIUG)} The set of 
dependencies between packages which contain types that are internal to a pattern 
instance, created due to a temporary connection between classes, and the source 
side of the dependency is more stable than the target side of the dependency. 
Formally, this defines the set $\{(d, e)\,|\, temporary((d, e)) \wedge 
internal(d, e, \mathcal{P}_r) \wedge I(d) \leq I(e)\}$.

% \begin{figure}[tbH]
% \centering
% \includegraphics[scale=.5]{images/Examples/Grime/Organizational/mtiug_ex.eps}
% \caption{Example of MTIUG.}\label{fig:mtiug_ex}
% \end{figure}

\section{Conclusion}\label{sec:tax_conclude}
This chapter presented the enhanced design pattern grime taxonomy. We detailed 
the exact methodology used to develop enhanced Class and Organizational Grime 
taxonomies. Furthermore, we connected these taxonomies to the underlying 
software engineering principles they are codifying as well as the metrics that 
lead to the definition of their detection strategies. The development of these 
taxonomies, along with the existing modular grime taxonomy, leads directly into 
the design of both injection and detection strategies for different grime types.
