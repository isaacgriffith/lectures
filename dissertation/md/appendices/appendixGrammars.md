\chapter{Domain Specific Language Grammars}

\section{Injection Strategy DSL Grammar}
This grammar describes the grammar associated with injection strategy textual definitions. The grammar is divided into four separate sections: Literals which defines the literals such as numbers, letters, whitespace and visibility, it also defines strings and identifiers which are derived from these concepts. Operators which are the operators used to combine expressions together. Expressions which are used to define mathematical, range, and conditional epressions used in defining augmentors. Finally, structures which define the structural components such as selectors, augmentors, and other control stuctures of the language.

\subsection{Literals}
\begin{EBNF}
 \begin{singlespace}
 \item[identifier] 
  \ebnfpn{letter} [~(~\ebnfpn{letter} | \ebnfpn{digit}~)~] | \ebnfpn{identifier}
  \ebnfts{.} \ebnfpn{identifier} \ebnfterm
 \item[number] 
  (~\ebnfts{+} | \ebnfts{-}~) [~\ebnfpn{digit}~] | (~\ebnfts{.}
  [~\ebnfpn{digit}~]~) \ebnfterm
 \item[letters] \ebnfgrp{\ebnfrg{A}{Z},\ebnfrg{a}{z}} \ebnfterm
 \item[string] \ebnfts{``} \ebnfrep{\ebnfpn{\ebnfpn{digit}} \ebnfalt \ebnfpn{letter} \ebnfalt \ebnfpn{punc} \ebnfalt \ebnfpn{whitespace}} \ebnfts{"}
 \item[whitespace] \ebnfts{\,\,} \ebnfalt \ebnfts{\textbackslash t} \ebnfalt \ebnfts{\textbackslash n} \ebnfalt \ebnfts{\textbackslash r}
 \item[digit] \ebnfts{0} \ebnfalt \ebnfts{1} \ebnfalt \ebnfts{2} \ebnfalt \ebnfts{3} \ebnfalt \ebnfts{4} \ebnfalt \ebnfts{5} \ebnfalt \ebnfts{6} \ebnfalt \ebnfts{7} \ebnfalt \ebnfts{8} \ebnfalt \ebnfts{9} \ebnfterm
 \item[visibility] \ebnfts{public} \ebnfalt \ebnfts{protected} \ebnfalt \ebnfts{private} \ebnfalt \ebnfts{package}
 \item[boolean] \ebnfts{true} \ebnfalt \ebnfts{false}
 %  \item[punc} \ebnfts{~} \ebnfalt \ebnfTS{`} \ebnfalt \ebnfts{!} \ebnfalt \ebnfts{@} \ebnfts{\#} \ebnfalt \ebnfts{\$} \ebnfalt \ebnfts{\%} \ebnfalt \ebnfts{^} \ebnfalt \ebnfts{&} \ebnfalt \ebnfts{*} \ebnfalt \ebnfts{(} \ebnfalt \ebnfts{)} \ebnfalt \ebnfts{_} \ebnfalt \ebnfts{-} \ebnfalt \ebnfts{+} \ebnfalt \ebnfts{=} \ebnfalt \ebnfts{\{} \ebnfalt \ebnfts{\}} \ebnfalt \ebnfts{\ebnfopt{} \ebnfalt \ebnfts{}} \ebnfalt \ebnfts{\textbar} \ebnfalt \ebnfts{\textbackslash} \ebnfalt \ebnfts{:} \ebnfalt \ebnfts{;} \ebnfalt \ebnfTS{'} \ebnfalt \ebnfts{"} \ebnfalt \ebnfts{,} \ebnfalt \ebnfts{\textgreater} \ebnfalt \ebnfts{\textless} \ebnfalt \ebnfts{.} \ebnfalt \ebnfts{?} \ebnfalt \ebnfts{/}
 \end{singlespace}
\end{EBNF}

\subsection{Operators}
\begin{EBNF}
 \begin{singlespace}
 \item[arrow] \ebnfts{-\textgreater}
 \item[logical-op] \ebnfts{\&\&} \ebnfalt \ebnfts{\textbar\textbar} \ebnfalt \ebnfts{!}
 \item[math-op] \ebnfts{$-$} \ebnfalt \ebnfts{$/$} \ebnfalt \ebnfts{$+$} \ebnfalt \ebnfts{$*$} \ebnfalt \ebnfts{$\%$}
 \item[relational-op] \ebnfts{\textless} \ebnfalt \ebnfts{\textgreater} \ebnfalt \ebnfts{\textless=} \ebnfalt \ebnfts{\textgreater=} \ebnfalt \ebnfts{==} \ebnfalt \ebnfts{!=}
 \end{singlespace}
\end{EBNF}

\subsection{Expressions}
\begin{EBNF}
\begin{singlespace}
 \item[cond-expr] \ebnfpn{cond-expr} \ebnfpn{logical-op} \ebnfpn{cond-expr} \ebnfalt \ebnfts{(} \ebnfpn{cond-expr} \ebnfts{)} \ebnfalt \ebnfpn{identifier} \ebnfalt \ebnfpn{boolean}
 \item[math-expr] \ebnfpn{math-expr} \ebnfpn{math-op} \ebnfpn{math-expr} \ebnfalt \ebnfts{(} \ebnfpn{math-expr} \ebnfts{)} \ebnfalt \ebnfpn{identifier} \ebnfalt \ebnfpn{number}
\end{singlespace}
\end{EBNF}

\subsection{Structures}
\begin{EBNF} 
 \begin{singlespace}
 \item[augmentor] \ebnfpn{typeaugmentor} \ebnfalt \ebnfpn{relationaugmentor}
 \item[typeaugmentor] \ebnfts{TypeAugmentor} \ebnfcc \ebnfts{:} \ebnfcc \ebnfpn{target} \ebnfcc \ebnfpn{operator} \ebnfcc \ebnfts{\{} \ebnfcc \ebnfpn{augmentor-body} \ebnfcc \ebnfts{\}}
 \item[relationaugmentor] \ebnfts{RelationAugmentor} \ebnfcc \ebnfts{:} \ebnfcc \ebnfpn{target} \ebnfcc \ebnfpn{operator} \ebnfcc \ebnfts{\{} \ebnfcc \ebnfpn{augmentor-body} \ebnfcc \ebnfts{\}}
 \item[augmentor-body] \ebnfpn{param-list}
 \item[target] \ebnfts{target} \ebnfcc \ebnfts{:} \ebnfcc \ebnfpn{selector-or-identifier}
 \item[operator] \ebnfts{operator} \ebnfcc \ebnfts{:} \ebnfcc \ebnfpn{identifier} \ebnfopt{\ebnfpn{arrow} \ebnfpn{identifier}}
 \item[value] \ebnfpn{boolean} \ebnfalt \ebnfpn{number} \ebnfalt \ebnfpn{identifier} \ebnfalt \ebnfpn{string} \ebnfalt \ebnfpn{value-list}
 \item[parameter] \ebnfts{parameter} \ebnfcc \ebnfts{:} \ebnfcc \ebnfpn{identifier} \ebnfcc \ebnfpn{arrow} \ebnfcc \ebnfpn{value} \ebnfts{;}
 \item[param-list] \ebnfpn{parameter} \ebnfalt \ebnfpn{param-list} \ebnfalt \ebnfes
 \item[selector] \ebnfts{Selector} \ebnfcc \ebnfts{:} \ebnfcc \ebnfpn{identifier} \ebnfcc \ebnfpn{arrow} \ebnfcc \ebnfpn{identifier} \ebnfts{;}
 \item[select-list] \ebnfpn{selector} \ebnfalt \ebnfpn{select-list} \ebnfalt \ebnfes
 \item[range] \ebnfpn{identifier} \ebnfcc \ebnfts{to} \ebnfcc \ebnfpn{identifier}
 \item[range-assign] \ebnfpn{identifier} \ebnfcc \ebnfts{=} \ebnfcc \ebnfpn{range}
 \item[injection strategy] \ebnfts{InjectionStrategy} \ebnfcc \ebnfts{\{} \ebnfcc \ebnfpn{isbody} \ebnfcc \ebnfts{\}}
 \item[isbody] \ebnfpn{param-list} \ebnfcc \ebnfpn{select-list} \ebnfcc \ebnfpn{augment-list}
 \item[loop] \ebnfts{Loop} \ebnfcc \ebnfts{:} \ebnfcc \ebnfpn{loop-control} \ebnfcc \ebnfts{\{} \ebnfcc \ebnfpn{loop-body} \ebnfcc \ebnfts{\}}
 \item[loop-control] \ebnfpn{range} \ebnfalt \ebnfpn{range-assign}
 \item[loop-body] \ebnfpn{augment-list}
 \item[conditional] \ebnfts{Conditional} \ebnfcc \ebnfts{\{} \ebnfcc \ebnfpn{conditional-body} \ebnfcc \ebnfts{\}}
 \item[condtional-body] \ebnfpn{cond-list}
 \item[cond-list] \ebnfpn{condition} \ebnfalt \ebnfpn{cond-list} \ebnfalt \ebnfes
 \item[condition] \ebnfts{Condition} \ebnfcc \ebnfts{:} \ebnfcc \ebnfpn{cond-expr} \ebnfcc \ebnfts{\{} \ebnfcc \ebnfpn{cond-body} \ebnfcc \ebnfts{\}}
 \item[cond-body] \ebnfpn{augment-list}
 \item[selector-or-identifier] \ebnfpn{selector} \ebnfalt \ebnfpn{identifier}
 \end{singlespace}
\end{EBNF}

\section{Detection Strategy DSL}
This grammar describes the grammar associated with detection strategy textual definitions. The grammar is divided into four separate sections: Literals which defines the literals such as numbers, letters, whitespace and visibility, it also defines strings and identifiers which are derived from these concepts. Operators which are the operators used to combine expressions together in order to make the grammar more useful rather than simply a specification for a file type. Expressions which are used to define mathematical, range, and conditional epressions used in defining augmentors. Filters which are used to define Finally, structures which define the structural components such as selectors, augmentors, and other control stuctures of the grammar.
\subsection{Literals}
\begin{EBNF}
 \item[identifier] \ebnfpn{letter} \ebnfrep{\ebnfopt{\ebnfpn{letter} \ebnfalt \ebnfpn{\ebnfpn{digit}}}} \ebnfalt \ebnfpn{identifier} \ebnfts{.} \ebnfpn{identifier}
 \item[number] \ebnfopt{\ebnfts{+} \ebnfalt \ebnfts{-}} \ebnfrep{\ebnfpn{\ebnfpn{digit}}} \ebnfopt{\ebnfts{.} \ebnfrep{\ebnfpn{\ebnfpn{digit}}}}
 \item[letters] \ebnfgrp{\ebnfrg{A}{Z},\ebnfrg{a}{z}} \ebnfterm
 \item[string] \ebnfts{``} \ebnfrep{\ebnfpn{\ebnfpn{digit}} \ebnfalt \ebnfpn{letter} \ebnfalt \ebnfpn{punc} \ebnfalt \ebnfpn{whitespace}} \ebnfts{"}
 \item[whitespace] \ebnfts{\,\,} \ebnfalt \ebnfts{\textbackslash t} \ebnfalt \ebnfts{\textbackslash n} \ebnfalt \ebnfts{\textbackslash r}
 \item[digit] \ebnfts{0} \ebnfalt \ebnfts{1} \ebnfalt \ebnfts{2} \ebnfalt \ebnfts{3} \ebnfalt \ebnfts{4} \ebnfalt \ebnfts{5} \ebnfalt \ebnfts{6} \ebnfalt \ebnfts{7} \ebnfalt \ebnfts{8} \ebnfalt \ebnfts{9} \ebnfterm
 \item[visibility] \ebnfts{public} \ebnfalt \ebnfts{protected} \ebnfalt \ebnfts{private} \ebnfalt \ebnfts{package}
 \item[boolean] \ebnfts{true} \ebnfalt \ebnfts{false}
\end{EBNF}

\subsection{Operators}
\begin{EBNF}
 \item[arrow] \ebnfts{\textless-}
 \item[logical-op] \ebnfts{\&\&} \ebnfalt \ebnfts{\textbar\textbar} \ebnfalt \ebnfts{!}
 \item[math-op] \ebnfts{$-$} \ebnfalt \ebnfts{$/$} \ebnfalt \ebnfts{$+$} \ebnfalt \ebnfts{$*$} \ebnfalt \ebnfts{$\%$}
 \item[relational-op] \ebnfts{\textless} \ebnfalt \ebnfts{\textgreater} \ebnfalt \ebnfts{\textless=} \ebnfalt \ebnfts{\textgreater=} \ebnfalt \ebnfts{==} \ebnfalt \ebnfts{!=}
 \item[absolute-op] \ebnfts{HigherThan} \ebnfalt \ebnfts{LowerThan}
 \item[relative-op] \ebnfts{TopValues} \ebnfalt \ebnfts{BottomValues}
 \item[composite-op] \ebnfts{\&\&} \ebnfalt \ebnfts{\textbar\textbar} \ebnfalt \ebnfts{\textbackslash}
\end{EBNF}

\subsection{Expressions}
\begin{EBNF}
 \item[cond-expr] \ebnfpn{cond-expr} \ebnfpn{logical-op} \ebnfpn{cond-expr} \ebnfalt \ebnfts{(} \ebnfpn{cond-expr} \ebnfts{)} \ebnfalt \ebnfpn{identifier} \ebnfalt \ebnfpn{boolean}
 \item[math-expr] \ebnfpn{math-expr} \ebnfpn{math-op} \ebnfpn{math-expr} \ebnfalt \ebnfts{(} \ebnfpn{math-expr} \ebnfts{)} \ebnfalt \ebnfpn{identifier} \ebnfalt \ebnfpn{number}
\end{EBNF}

\subsection{Filters}
\begin{EBNF} 
 \item[filter]
 \item[membership-filter]
 \item[relation-filter]
 \item[marginal-filter] \ebnfpn{relative-filter} \ebnfalt \ebnfpn{absolute-filter}
 \item[relative-filter]
 \item[absolute-filter]
 \item[composite-filter]
 \item[interval-filter] \ebnfpn{marginal-filter} \ebnfalt \ebnfpn{marginal-filter}
 \item[cluster-filter]
 \item[historical-filter]
 \item[architectural-filter]
 \item[validation-filter]
\end{EBNF}

\subsection{Structures}
\begin{EBNF} 
 \item[metric] \ebnfts{Metric:} \ebnfpn{identifier} \ebnfpn{arrow} \ebnfpn{value}
\end{EBNF}

\section{Empirical Study DSL Grammar}
This grammar describes the grammar associated with detection strategy textual definitions. The grammar is divided into four separate sections: Literals which defines the literals such as numbers, letters, whitespace and visibility, it also defines strings and identifiers which are derived from these concepts. Operators which are the operators used to combine expressions together in order to make the grammar more useful rather than simply a specification for a file type. Expressions which are used to define mathematical, range, and conditional epressions used in defining augmentors. Filters which are used to define Finally, structures which define the structural components such as selectors, augmentors, and other control stuctures of the grammar.

\subsection{Literals}
\begin{EBNF}
 \item[identifier] \ebnfpn{letter} \ebnfrep{\ebnfopt{\ebnfpn{letter} \ebnfalt \ebnfpn{\ebnfpn{digit}}}} \ebnfalt \ebnfpn{identifier} \ebnfts{.} \ebnfpn{identifier}
 \item[number] \ebnfopt{\ebnfts{+} \ebnfalt \ebnfts{-}} \ebnfrep{\ebnfpn{\ebnfpn{digit}}} \ebnfopt{\ebnfts{.} \ebnfrep{\ebnfpn{\ebnfpn{digit}}}}
 \item[letters] \ebnfgrp{\ebnfrg{A}{Z},\ebnfrg{a}{z}} \ebnfterm
 \item[string] \ebnfts{``} \ebnfrep{\ebnfpn{\ebnfpn{digit}} \ebnfalt \ebnfpn{letter} \ebnfalt \ebnfpn{punc} \ebnfalt \ebnfpn{whitespace}} \ebnfts{"}
 \item[whitespace] \ebnfts{\,\,} \ebnfalt \ebnfts{\textbackslash t} \ebnfalt \ebnfts{\textbackslash n} \ebnfalt \ebnfts{\textbackslash r}
 \item[digit] \ebnfts{0} \ebnfalt \ebnfts{1} \ebnfalt \ebnfts{2} \ebnfalt \ebnfts{3} \ebnfalt \ebnfts{4} \ebnfalt \ebnfts{5} \ebnfalt \ebnfts{6} \ebnfalt \ebnfts{7} \ebnfalt \ebnfts{8} \ebnfalt \ebnfts{9} \ebnfterm
 \item[visibility] \ebnfts{public} \ebnfalt \ebnfts{protected} \ebnfalt \ebnfts{private} \ebnfalt \ebnfts{package}
 \item[boolean] \ebnfts{true} \ebnfalt \ebnfts{false}
\end{EBNF}

\subsection{Operators}
\begin{EBNF}
 \item[arrow] \ebnfts{\textless-}
 \item[logical-op] \ebnfts{\&\&} \ebnfalt \ebnfts{\textbar\textbar} \ebnfalt \ebnfts{!}
 \item[math-op] \ebnfts{$-$} \ebnfalt \ebnfts{$/$} \ebnfalt \ebnfts{$+$} \ebnfalt \ebnfts{$*$} \ebnfalt \ebnfts{$\%$}
 \item[relational-op] \ebnfts{\textless} \ebnfalt \ebnfts{\textgreater} \ebnfalt \ebnfts{\textless=} \ebnfalt \ebnfts{\textgreater=} \ebnfalt \ebnfts{==} \ebnfalt \ebnfts{!=}
\end{EBNF}

\subsection{Expressions}
\begin{EBNF}
 \item[cond-expr] \ebnfpn{cond-expr} \ebnfpn{logical-op} \ebnfpn{cond-expr} \ebnfalt \ebnfts{(} \ebnfpn{cond-expr} \ebnfts{)} \ebnfalt \ebnfpn{identifier} \ebnfalt \ebnfpn{boolean}
 \item[math-expr] \ebnfpn{math-expr} \ebnfpn{math-op} \ebnfpn{math-expr} \ebnfalt \ebnfts{(} \ebnfpn{math-expr} \ebnfts{)} \ebnfalt \ebnfpn{identifier} \ebnfalt \ebnfpn{number}
\end{EBNF}

\subsection{Variables}
\begin{EBNF} 
 \item[variables] \ebnfpn{response} \ebnfalt \ebnfpn{explanatory}
 \item[explanatory] \ebnfpn{factor} \ebnfalt \ebnfpn{block}
 \item[response] \ebnfts{ResponseVariable} \ebnfpn{identifier} \ebnfts{\{} \ebnfts{\}}
 \item[factor] \ebnfts{Factor} \ebnfpn{identifier} \ebnfts{\{} \ebnfts{\}}
 \item[block] \ebnfts{BlockingVariable} \ebnfpn{identifier} \ebnfts{\{} \ebnfts{\}}
 \item[level] \ebnfpn{treatment} \ebnfalt \ebnfts{Level} \ebnfts{:} \ebnfpn{identifier} \ebnfpn{arrow} \ebnfpn{value}
 \item[treatment] \ebnfts{Treatment} \ebnfts{:} \ebnfpn{identifier} \ebnfpn{arrow} \ebnfpn{value}
 \item[vartype] \ebnfts{Continuous} \ebnfalt \ebnfts{Discrete}
\end{EBNF}

\subsection{Structures}
\begin{EBNF} 
 \item[exp-design] \ebnfts{CRD} \ebnfalt \ebnfts{RCBD} \ebnfalt \ebnfts{SRMD} \ebnfalt \ebnfts{LSD} \ebnfalt \ebnfts{Factorial} \ebnfalt \ebnfts{RLSD} \ebnfalt \ebnfts{GLSD} \ebnfalt \ebnfts{BIBD} \ebnfalt \ebnfts{Nested} \ebnfalt \ebnfts{SplitPlot} \ebnfalt \ebnfts{SplitSplitPlot} \ebnfalt \ebnfts{FractionalFactorial} \ebnfalt \ebnfts{YS} \ebnfalt \ebnfts{Lattice} \ebnfalt \ebnfts{PIBD}
 \item[subjects] \ebnfts{subjects} \ebnfts{:} \ebnfpn{subject-list} \ebnfts{;}
 \item[subject-list] \ebnfpn{subject} \ebnfopt{\ebnfrep{\ebnfts{,} \ebnfpn{subject}}}
 \item[subject] \ebnfts{System} \ebnfalt \ebnfts{Files} \ebnfalt \ebnfts{Classes} \ebnfalt \ebnfts{Patterns}
 \item[empirical-study] \ebnfpn{case-study} \ebnfalt \ebnfpn{experiment}
 \item[experiment] \ebnfts{Experiment} \ebnfts{\{} \ebnfpn{subjects} \ebnfpn{variables} \ebnfpn{output-config} \ebnfpn{process} \ebnfts{\}}
 \item[output-config]
 \item[process]
 \item[activity]
 \item[toolchain]
\end{EBNF}

\section{RBML Grammar}

\begin{EBNF}
    \item[pattern] \ebnfts{pattern} \ebnfpn{string} \ebnfts{,} \ebnfts{\{} \ebnfopt{\ebnfpn{sps}} \ebnfrep{ips} \ebnfts{\}} \ebnfterm
    \item[sps] \ebnfts{sps} \ebnfts{,} \ebnfopt{\ebnfpn{roles}} \ebnfopt{\ebnfpn{constraints}} \ebnfopt{\ebnfpn{relations}} \ebnfts{\}} \ebnfterm
    \item[roles] \ebnfts{roles} \ebnfts{\{} \ebnfrep{\ebnfpn{role}} \ebnfts{\}} \ebnfterm
    \item[role] \ebnfpn{gen\_hierarchy} \ebnfalt \ebnfpn{classifier\_role}
    \ebnfalt \ebnfpn{class\_role} \ebnfalt \ebnfpn{interface\_role} \ebnfterm
    \item[genhierarchy] \ebnfts{gen\_hierarchy} \ebnfpn{string}
    \ebnfopt{\ebnfts{,} \ebnfts{\{} \ebnfpn{root\_classifier}
    \ebnfrep{\ebnfgrp{\ebnfpn{class\_role} \ebnfalt \ebnfpn{classifier\_role}}}
    \ebnfts{\}}} \ebnfterm
    \item[root\_classifier] \ebnfts{classifier\_role} \ebnfpn{string}
    \ebnfts{root:} \ebnfpn{boolean} \ebnfnopt{\ebnfts{,} \ebnfts{\{}}
    \ebnfrep{\ebnfpn{behavioral\_feature}}
    \ebnfrep{\ebnfpn{structural\_feature}} \ebnfts{\}} \ebnfterm
    \item[classifier\_role] \ebnfts{classifier\_role} \ebnfpn{string}
    \ebnfopt{\ebnfts{,} \ebnfpn{mult}} \ebnfnopt{\ebnfts{,} \ebnfts{\{} \ebnfrep{\ebnfpn{behavioral\_feature}} \ebnfrep{\ebnfpn{structural\_feature}} \ebnfts{\}}} \ebnfterm
    \item[class\_role] \ebnfts{class\_role} \ebnfpn{string} \ebnfopt{\ebnfts{,} \ebnfpn{mult}} \ebnfnopt{\ebnfts{,} \ebnfts{\{} \ebnfrep{\ebnfpn{behavioral\_feature}} \ebnfrep{\ebnfpn{structural\_feature}} \ebnfts{\}}} \ebnfterm
    \item[interface\_role] \ebnfts{interface\_role} \ebnfpn{string} \ebnfopt{\ebnfts{,} \ebnfpn{mult}} \ebnfnopt{\ebnfts{,} \ebnfts{\{} \ebnfrep{\ebnfpn{behavioral\_feature}} \ebnfrep{\ebnfpn{structural\_feature}} \ebnfts{\}}} \ebnfterm
    \item[behavioral\_feature] \ebnfts{behavioral\_feature} \ebnfpn{string} \ebnfopt{\ebnfts{,} \ebnfpn{mult}} \ebnfterm
    \item[structural\_feature] \ebnfts{structural\_feature} \ebnfpn{string} \ebnfopt{\ebnfts{,} \ebnfpn{mult}} \ebnfterm
    \item[constraints] \ebnfts{constraints} \ebnfts{\{} \ebnfrep{\ebnfpn{context}} \ebnfts{\}} \ebnfterm
    \item[context] \ebnfts{context} \ebnfpn{string} \ebnfopt{\ebnfts{,}
    \ebnfgrp{\ebnfpn{inv} \ebnfalt \ebnfgrp{\ebnfpn{pre} \ebnfts{,} \ebnfpn{post}}}} \ebnfterm
    \item[inv] \ebnfts{inv:} \ebnfpn{string} \ebnfterm
    \item[pre] \ebnfts{pre:} \ebnfpn{string} \ebnfterm
    \item[post] \ebnfts{post:} \ebnfpn{string} \ebnfterm
    \item[relations] \ebnfts{relations} \ebnfts{\{} \ebnfrep{\ebnfpn{relation}} \ebnfts{\}} \ebnfterm
    \item[relation] \ebnfpn{association\_role}
             \ebnfalt \ebnfpn{generalization\_role}
             \ebnfalt \ebnfpn{realization\_role}
             \ebnfalt \ebnfpn{usage\_role} \ebnfterm
    \item[association\_role] \ebnfts{association\_role} \ebnfpn{string} \ebnfts{,} \ebnfts{\{} \ebnfpn{named\_source} \ebnfpn{named\_dest} \ebnfts{\}} \ebnfterm
    \item[named\_source] \ebnfts{source} \ebnfpn{string} \ebnfpn{role} \ebnfopt{\ebnfts{,}, \ebnfpn{mult}} \ebnfterm
    \item[named\_dest] \ebnfts{dest} \ebnfpn{string} \ebnfpn{role} \ebnfopt{\ebnfts{,} \ebnfpn{mult}} \ebnfterm
    \item[generalization\_role] \ebnfts{generalization\_role} \ebnfpn{string}
    \ebnfopt{\ebnfts{,} \ebnfts{mult:} \ebnfpn{mult\_string}} \ebnfopt{\ebnfts{,} \ebnfgrp{\ebnfts{\{} \ebnfpn{source} \ebnfpn{dest} \ebnfts{\}} \ebnfalt \ebnfts{source:} \ebnfpn{string} \ebnfts{,} \ebnfts{dest:} \ebnfpn{string}}} \ebnfterm
    \item[realization\_role] \ebnfts{realization\_role} \ebnfpn{string}
    \ebnfopt{\ebnfts{,} \ebnfts{mult:} \ebnfpn{mult\_string}} \ebnfopt{\ebnfts{,} \ebnfgrp{\ebnfts{\{} \ebnfpn{source} \ebnfpn{dest} \ebnfts{\}} \ebnfalt \ebnfts{source:} \ebnfpn{string} \ebnfts{,} \ebnfts{dest:} \ebnfpn{string}}} \ebnfterm
    \item[usage\_role] \ebnfts{usage\_role} \ebnfpn{string} \ebnfopt{\ebnfts{,}
    \ebnfts{mult:} \ebnfpn{mult\_string}} \ebnfopt{\ebnfts{,} \ebnfgrp{\ebnfts{\{} \ebnfpn{source} \ebnfpn{dest} \ebnfts{\}} \ebnfalt \ebnfts{source:} \ebnfpn{string} \ebnfts{,} \ebnfts{dest:} \ebnfpn{string}}} \ebnfterm
    \item[source] \ebnfts{source} \ebnfpn{role} \ebnfopt{\ebnfts{,} \ebnfpn{mult}} \ebnfterm
    \item[dest] \ebnfts{dest} \ebnfpn{role} \ebnfopt{\ebnfts{,} \ebnfpn{mult}} \ebnfterm
    \item[role] \ebnfts{role:} \ebnfpn{string} \ebnfterm
    \item[ips] \ebnfts{ips} \ebnfpn{string} \ebnfopt{\ebnfts{,} \ebnfpn{mult}} \ebnfts{,} \ebnfts{\{} \ebnfopt{\ebnfpn{lines}} \ebnfopt{\ebnfpn{trace}} \ebnfts{\}} \ebnfterm
    \item[mult] \ebnfts{mult:} \ebnfpn{mult\_string} \ebnfterm
    \item[lines] \ebnfts{lines} \ebnfts{\{}, \ebnfrep{\ebnfpn{lifeline}} \ebnfts{\}} \ebnfterm
    \item[trace] \ebnfts{trace} \ebnfts{\{}, \ebnfrep{\ebnfpn{fragment}} \ebnfts{\}} \ebnfterm
    \item[fragment] \ebnfpn{call\_role}
             \ebnfalt \ebnfpn{create\_role}
             \ebnfalt \ebnfpn{call\_return}
             \ebnfalt \ebnfpn{destroy\_role}
             \ebnfalt \ebnfpn{async\_message}
             \ebnfalt \ebnfpn{alt}
             \ebnfalt \ebnfpn{opt}
             \ebnfalt \ebnfpn{loop}
             \ebnfalt \ebnfpn{brk}
             \ebnfalt \ebnfpn{par}
             \ebnfalt \ebnfpn{strict}
             \ebnfalt \ebnfpn{seq}
             \ebnfalt \ebnfpn{critical} \ebnfterm
    \item[call\_role] "call\_role", \ebnfpn{string}\ebnfopt{\ebnfts{,}, "source:", string}, \ebnfts{,}, "dest:", string;
    
    \item[create\_role] "create\_role", \ebnfpn{string} \ebnfopt{\ebnfts{,}, "source:", string}, \ebnfts{,}, "dest:", \ebnfpn{string};
    
    \item[call\_return] "call\_return", \ebnfpn{string} \ebnfts{,}, "source:", \ebnfpn{string} \ebnfopt{\ebnfts{,}, "dest:", string} ;
    
    \item[destroy\_role] "destroy\_role", \ebnfpn{string}\ebnfopt{\ebnfts{,}, "source:", string}, \ebnfts{,}, "dest:", string;
    
    \item[async\_message] "async\_role", \ebnfpn{string}\ebnfopt{\ebnfts{,}, "source:", string}, \ebnfts{,}, "dest:", string;
    
    \item[alt] "alt", \ebnfts{\{}, guarded\_trace*, \ebnfts{\}} ;
    
    \item[guarded\_trace] "trace", \ebnfpn{string} \ebnfts{,}, \ebnfts{\{}, fragment*, \ebnfts{\}} ;
    
    \item[opt] "opt", \ebnfts{\{}, guarded\_trace*, \ebnfts{\}} ;
    
    \item[loop] \ebnfts{loop} \ebnfcc \ebnfopt{\ebnfts{min:} \ebnfpn{integer} \ebnfts{,}} \ebnfopt{\ebnfts{max:} \ebnfpn{integer} \ebnfts{,}} \ebnfts{\{}, \ebnfopt{\ebnfpn{guarded\_trace}} \ebnfts{\}} \ebnfterm
    \item[brk] \ebnfts{brk} \ebnfts{\{}, \ebnfopt{guarded\_trace}, \ebnfts{\}} \ebnfterm
    \item[par] \ebnfts{par} \ebnfts{\{} \ebnfrep{\ebnfpn{guarded\_trace}} \ebnfts{\}} \ebnfterm
    \item[strict] \ebnfts{strict} \ebnfts{\{} \ebnfrep{\ebnfpn{guarded\_trace}} \ebnfts{\}} \ebnfterm
    \item[seq] \ebnfts{seq} \ebnfts{\{} \ebnfrep{\ebnfpn{guarded\_trace}} \ebnfts{\}} \ebnfterm
    \item[critical] \ebnfts{critical} \ebnfts{\{} \ebnfopt{guarded\_trace} \ebnfts{\}} \ebnfterm
    \item[string] \ebnfts{"} \ebnfpn{string\_contents} \ebnfts{"}
           \ebnfalt \ebnfts{'} \ebnfpn{string\_contents} \ebnfts{"}
           \ebnfalt \ebnfts{"""} \ebnfpn{string\_contents} \ebnfts{"""} 
           \ebnfalt \ebnfts{'''} \ebnfpn{string\_contents} \ebnfts{'''} \ebnfterm
    \item[string\_contents] \ebnfspec{all characters} \ebnfterm
    
    \item[mult\_string] \ebnfts{"} \ebnfcc \ebnfpn{mult\_string\_contents} \ebnfcc \ebnfts{"}
           \ebnfalt \ebnfTS{'} \ebnfcc \ebnfpn{mult\_string\_contents} \ebnfcc \ebnfTS{"}
           \ebnfalt \ebnfts{"""} \ebnfcc \ebnfpn{mult\_string\_contents} \ebnfcc \ebnfts{"""} 
           \ebnfalt \ebnfTS{'''} \ebnfcc \ebnfpn{mult\_string\_contents} \ebnfcc \ebnfTS{'''} \ebnfterm
    \item[mult\_string\_contents] \ebnfgrp{\ebnfrep{\ebnfpn{digit}} \ebnfalt \ebnfpn{star}} \ebnfcc \ebnfopt{\ebnfts{..} \ebnfcc (\ebnfrep{\ebnfpn{digit}} \ebnfalt \ebnfpn{star}} \ebnfterm
    \item[integer] \ebnfopt{\ebnfgrp{\ebnfts{+} \ebnfalt \ebnfts{-}}} \ebnfcc \ebnfrep{\ebnfpn{digit}} \ebnfterm
    \item[star] \ebnfts{*} \ebnfterm
    \item[digit] \ebnfts{0} \ebnfalt \ebnfts{1} \ebnfalt \ebnfts{2} \ebnfalt \ebnfts{3} \ebnfalt \ebnfts{4} \ebnfalt \ebnfts{5} \ebnfalt \ebnfts{6} \ebnfalt \ebnfts{7} \ebnfalt \ebnfts{8} \ebnfalt \ebnfts{9} \ebnfterm
    \item[comment] \ebnfts{/*} \ebnfcc \ebnfpn{string\_contents} \ebnfcc \ebnfts{*/}
            \ebnfalt \ebnfts{//} \ebnfcc \ebnfpn{string\_contents} \ebnfterm
\end{EBNF}
