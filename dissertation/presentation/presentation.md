---
author:
- Isaac D. Griffith
title: Design Pattern Decay
subtitle: A Study of Design Pattern Grime and Its Impact on Quality and Technical Debt
institute: Gianforte School of Computing
fontsize: 11pt
wideLogo: "images/MSU-vert.eps"
instituteLogo: "images/MSU-horiz-reverse.png"
instituteTagLine: "images/mmtag-reverse.png"
...

# Technical Debt <!-- 1 Minute (1 Minute Total) -->

\vskip-1.5em

* 1992 - Ward Cunningham coined the term **Technical Debt** describing a financial metaphor explaining the need to refactor to stakeholders

\pause

\vskip1.5em

\centering
\Large \textbf{... 20 years later ...}
\centering

\pause

\vskip1.5em

## 2012 - CAST Research Group Findings

\centering
\small
In an analysis of 745 applications comprising 365 MLOC, on average, there is \textbf{\$3.61 of Technical Debt per LOC}

# Technical Debt <!-- 1 Minute (2 Minutes Total) -->

\vskip-1.5em

\begin{definition}

\begin{quote}
   ``In software intensive systems, technical debt--is a design or implementation construct that is expedient in the short term, but sets up a technical
   context that can make a future change more costly or impossible. Technical debt is a contingent liability whose impact is limited to internal system
   qualities, primarily maintainability and evolvability"\footnote{\tiny Paris Avgeriou, Philippe Kruchten, Ipek Ozkaya, and Carolyn Seaman, Managing Technical Debt in
Software Engineering (Dagstuhl Seminar 16162), Dagstuhl Reports 6 (2016), no. 4, 110–138}
\end{quote}

\end{definition}

\pause

**Properties**

- **Principal** - The effort required to refactor the software and remove the debt.

\pause

- **Interest** - The increase in development effort caused by debt affected components which have yet to be refactored.

<!--
# Technical Debt
-->
<!-- 2 Minutes (4 Minutes Total) -->

<!--
::: columns
:::: column


\centering
\includegraphics[width=.65\textwidth]{images/intro/td_graph.eps}
-->

<!-- TODO replace this diagram with TikZ diagram -->

<!--
::::
:::: column

**Properties**

- **Principal** - The effort required to refactor the software and remove the debt.
- **Interest** - The increase in development effort caused by debt affected components which have yet to be refactored.
- **Interest Probability** - The probability that interest associated with a debt will actually affect software development.
-->

<!--
::::
:::
-->

<!--
# Technical Debt Management

::: columns
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/quality/tdm.eps}

::::
:::: column

\textbf{\underline{TD Measurement}}

* **CAST (Curtis and Sappidi) - Principal only**
* **Nugroho et al. - Principal and Interest**
* **SQALE (Letousey et al.) - Principal only**

::::
:::
-->

# Technical Debt <!-- 1.5 Minutes but 1 Minute with tight talking points (5 Minutes Total) -->

\vskip-1.5em

\only<1>{
  \hspace{7.1em}
  \includegraphics[width=.45\textwidth]{images/quality/grime_tree1.eps}
}

\only<2>{
  \hspace{7.1em}
  \includegraphics[width=.45\textwidth]{images/quality/grime_tree2.eps}
}

\only<3>{
  \centering
  \includegraphics[width=.62\textwidth]{images/quality/grime_tree3.eps}
}

# Design Pattern Grime <!-- 1 Minute (6 Minutes Total) -->

\vskip-1.75em

\begin{definition}

The accumulation of unnecessary or unrelated software artifacts within the classes of a design pattern instance.

\end{definition}

<!--
::: columns
:::: column
-->

\begin{itemize}
  \item<2-> {\color<6->{AltGray}\textbf{Structural Grime} - Izurieta and Bieman}
  \begin{itemize}
    \item<3-> \color<4->{AltGray}\textbf{Modular Structural Grime} - build-up of relationships involving one or more pattern classes that are unnecessary to facilitate the operation of a pattern
    \item<4-> \color<5->{AltGray}\textbf{Class Structural Grime} - build-up of fields/methods within pattern classes that are unnecessary to facilitate the operation of a pattern
    \item<5-> \color<6->{AltGray}\textbf{Organizational Structural Grime} - the unnecessary distribution of pattern instance classes across namespaces or packages
  \end{itemize}
  \item<6-> \textbf{Behavioral Grime} - Reimanis and Izurieta
  \begin{itemize}
    \item<7-> Buildup of errant behavioral elements within a pattern instance (i.e. \textit{Excessive Actions} or \textit{Improper Order of Sequences})
  \end{itemize}
\end{itemize}

<!--
::::
:::: column

\centering
\only<2>{
  \includegraphics[width=.85\textwidth]{images/taxonomies/peag_ex.eps}

  \tiny Illustration of the PEEG form of Modular Grime.
}

\only<3>{
  \includegraphics[width=.85\textwidth]{images/taxonomies/depg_ex.eps}

  \tiny Illustration of the DEPG form of Class Grime.
}

\only<4>{
  \includegraphics[width=.80\textwidth]{images/taxonomies/mpicg_ex.eps}

  \tiny Illustration of the MPICG form of Organizational Grime.
}

\only<5>{
  \includegraphics[width=\textwidth]{images/taxonomies/beh_grime-tax.eps}
}

::::
:::
-->

# Problem Statement <!-- 1 Minute (7 Minutes Total) -->

<!-- TODO Update to use picture rather than words here -->

<!--
##

Currently, little is known about the causal nature of Grime on TD measures and Maintainability or how there three issues interrelate.
Understanding these relationships would provide guidance to practitioners regarding implementation and evolution of patterns, while
providing an empirical foundation upon which existing and future research and be grounded. Thus, we ask the following question:

\vskip1em
-->

\centering
\only<1>{
  \vskip2em
  \hspace{.275em}\includegraphics[width=.55\textwidth]{images/quality/problem1.eps}
}
\only<2->{
  \vskip-1.5em
  \includegraphics[width=.55\textwidth]{images/quality/problem2.eps}
}

\only<3->{
  \begin{block}

  \textit{What is the nature of the relationships between structural design pattern grime, software maintainability, and technical debt measurement?}

  \end{block}
}

# Design Science <!-- 1.5 Minutes but 1 Minute with tight talking points (8 Minutes Total) -->

\vskip-1em

\begin{block}

\footnotesize
\centering
An approach whereby stakeholders, serving human purposes, create or improve "things" within technological solutions

\end{block}

\pause

**Design Science Components:**

\begin{itemize}
  \item<2-> {\color<5->{AltGray}\footnotesize \textbf{Design Problems:} ``call for a change in the real world and require an analysis of actual or hypothetical stakeholder goals"}
  \begin{itemize}
    \item<3-> {\color<4->{AltGray}\scriptsize Result in the creation of an artifact}
    \item<4-> {\color<5->{AltGray}\scriptsize Addressed by following a \textit{design cycle}}
    % Problem Investigation $\rightarrow$ Design $\rightarrow$ Validation $\rightarrow$ Implementation
  \end{itemize}

  \item<5-> \footnotesize \textbf{Knowledge Questions:} ``do not call for a change but ask for knowledge about the world as it is"
  \begin{itemize}
    \item<6-> {\color<7->{AltGray}\scriptsize Result in a proposition}
    \item<7-> \scriptsize Addressed by following an \textit{empirical cycle}
    % Research Problem Analysis $\rightarrow$ Research & Inference Design $\rightarrow$ Validation $\rightarrow$ Research Execution $\rightarrow$ Data Analysis
  \end{itemize}
\end{itemize}

<!-- TODO insert an image of the two cycles propagating questions between each other -->

<!--
# Method

::: columns
:::: column

\centering
\vskip-1em
\includegraphics[width=.95\textwidth]{images/method/method.eps}

::::
:::: column

\begin{center}
\vskip-2em
\includegraphics[width=.95\textwidth]{images/method/to_study.eps}
\end{center}

* \scriptsize To address the problem statement
  - \tiny we developed an empirical method comprised of several stages designed
  - \tiny to build-up knowledge concerning software engineering phenomena
  - \tiny and combine the results of multiple empirical methods

::::
:::
-->

<!-- 1.5 Minutes but 1 Minute with tight talking points (9 Minutes Total) -->
<!--
# Method
-->

<!--
::: columns
:::: column
-->

<!--
\centering
\vskip-1em
\includegraphics[width=.45\textwidth]{images/method/overview.eps}
-->


<!--
::::
:::: column

* \scriptsize To address the problem statement
  - \tiny we developed an empirical method comprised of several stages designed
  - \tiny to build-up knowledge concerning software engineering phenomena
  - \tiny and combine the results of multiple empirical methods

* \scriptsize Through this work, we conducted the first three phases:
  - \tiny\ **Phase 01** - We conducted a Pilot Study of Class Grime and furthered Grime Taxonomy Development
  - \tiny\ **Phase 02** - Developed grime injections and executed experiments to evaluate the effects of grime
  - \tiny\ **Phase 03** - Verified the results of the experiments and the injection approach

::::
:::
-->

# Phase 01 - Extending Grime Taxonomies <!-- 1 Minute (10 Minutes Total) -->

\vskip-1.5em

\begin{block}

\footnotesize
\textbf{RG1:} Analyze design patterns to elaborate on the complete taxonomy of Class and Organizational Grime

\end{block}

\pause

::: columns
:::: column

<!--
\vskip-1em
\begin{center}
\includegraphics[width=\textwidth]{images/method/phase01b.eps}
\end{center}
-->

**Research Questions**

* \scriptsize \textbf{RQ1.1:} What are the types of Class Grime?

* \scriptsize \textbf{RQ1.2:} What are the types of Organizational Grime?

::::
:::: column

\pause

\centering
\includegraphics[width=\textwidth]{images/taxonomies/mod_grime-tax.eps}

::::
:::

<!--
# Class Grime

\vskip-1.5em

\begin{block}

\centering
\footnotesize
\textbf{RQ1.1:} What are the types of Class Grime?

\end{block}

::: columns
:::: column

\textbf{\underline{Taxonomy}:}

\centering
\includegraphics[width=\textwidth]{images/taxonomies/class_grime-tax.eps}

::::
:::: column

\textbf{\underline{Basis}:}

* \footnotesize Principles:
  - \tiny \textbf{You Ain't Going to Need It (YAGNI)} - do not add new functionality until it is needed
  - \tiny \textbf{Single Responsibility Principle(SRP)} - a class should only have responsibility for a single part of the functionality of the software
  - \tiny \textbf{Interface Segregation Principle(ISP)} - clients should not depend on methods that they do not use
  - \tiny \textbf{High Class Cohesion (HC)} - responsibilities embodied within the methods of a class should be highly related and support the class responsibility

::::
:::
-->

# Class Grime <!-- 1.25 Minutes but 1 Minute with tight talking points (11 Minutes Total) -->

\vskip-1.5em

\begin{block}

\centering
\footnotesize
\textbf{RQ1.1:} What are the types of Class Grime?

\end{block}

::: columns
:::: column

\textbf{\underline{Taxonomy}:}

\centering

\begin{tikzpicture}
  \node[anchor=south west] (image) at (0,0) {
    \includegraphics[width=\textwidth]{images/taxonomies/class_grime-tax.eps}
  };
  \begin{scope}[
  x={($0.1*(image.south east)$)},
  y={($0.1*(image.north west)$)}]

    \draw<3>[very thick,red] (0,5.1) rectangle (9.5,6.6);
    \draw<4>[very thick,red] (0,3.1) rectangle (9.5,5.1);
    \draw<5>[very thick,red] (0,1.65) rectangle (9.5,3.05);
    \draw<6>[very thick,red] (0,0) rectangle (9.5,1.65);
  \end{scope}
\end{tikzpicture}

::::
:::: column

\pause

\textbf{\underline{Basis}:}

\begin{itemize}
  \item<2-> {\color<3->{AltGray}\footnotesize \textbf{Design Principles:} \textit{SRP} and \textit{HC}}
  \item<3-> {\color<4->{AltGray}\footnotesize \textbf{Strength:} Attribute use by Method(s)}
  \item<4-> {\color<5->{AltGray}\footnotesize \textbf{Scope:} Method(s) fulfill a pattern role or not}
  \item<5-> {\footnotesize \textbf{Context:} Defined by the cohesion metric used}
  \begin{itemize}
    \item<6-> \scriptsize Pair: Tight Class Cohesion (TCC)
    \item<6-> \scriptsize Single: Ratio of Cohesive Interactions (RCI)
  \end{itemize}
\end{itemize}

::::
:::

<!--
# Organizational Grime

\vskip-1.5em

\begin{block}

\centering
\footnotesize
\textbf{RQ1.2:} What are the types of Organizational Grime?

\end{block}

::: columns
:::: column

\textbf{\underline{Taxonomy}:}

\centering
\includegraphics[width=\textwidth]{images/taxonomies/org_grime-tax.eps}

::::
:::: column

\textbf{\underline{Basis}:}

* \footnotesize Principles:
  - \tiny \textbf{Acyclic Dependencies Principle (ADP)} - dependencies between packages should not form cycles
  - \tiny \textbf{Stable Dependencies Principle (SDP)} - depend in the direction of stability
  - \tiny \textbf{Stable Abstractions Principle (SAP)} - abstractness should increase with stability
  - \tiny \textbf{Common Closure Principle (CCP)} - classes in a package should be closed to the same types of changes
  - \tiny \textbf{Common Reuse Principle (CRP)} - classes in the same package should be reused together

::::
:::
-->

# Package Organizational Grime <!-- 1.25 Minutes but 1 minute with tight talking points (12 Minutes Total) -->

\vskip-1.5em

\begin{block}

\centering
\footnotesize
\textbf{RQ1.2:} What are the types of Organizational Grime?

\end{block}

::: columns
:::: column

\textbf{\underline{Taxonomy}:}

\centering
\begin{tikzpicture}
  \node[anchor=south west] (image) at (0,0) {
    \includegraphics[width=\textwidth]{images/taxonomies/pkg_org_grime-tax.eps}
  };
  \begin{scope}[
  x={($0.1*(image.south east)$)},
  y={($0.1*(image.north west)$)}]

    \draw<3>[very thick,red] (0,2.7) rectangle (6.5,4.45);
    \draw<4>[very thick,red] (0,1.35) rectangle (6.5,2.7);
    \draw<5>[very thick,red] (0,0) rectangle (6.5,1.35);
  \end{scope}
\end{tikzpicture}

::::
:::: column

\textbf{\underline{Basis}:}

\begin{itemize}
  \item<2-> {\color<3->{AltGray}\footnotesize \textbf{Principles:} \textit{CCP} and \textit{CRP}}
  \item<3-> {\color<4->{AltGray}\footnotesize \textbf{Scope:} Whether a class in a package is a member of the pattern}
  \item<4-> {\footnotesize \textbf{Context:} Considers how well a class fits within the package}
  \begin{itemize}
    \item<5-> \scriptsize Closure - as measured by $CohesionQ$
    \item<5-> \scriptsize Reuse - as measured by $CouplingQ$
  \end{itemize}
\end{itemize}

<!--
\vskip-2em
\scriptsize
\begin{eqnarray*}
CohesionQ(p) & = & \frac{\left|p_{Int.D}\right|}{\left|p_D\right|}\\
CouplingQ(p) & = & 1 - \frac{\left|p_{Pro.P} \cup
p_{Cli.P}\right|}{\left|p_D\right|}
\end{eqnarray*}
-->

::::
:::

# Modular Organizational Grime <!-- 1.25 Minutes but 1 Minute with tight talking points (13 Minutes Total) -->

\vskip-1.5em

\begin{block}

\centering
\footnotesize
\textbf{RQ1.2:} What are the types of Organizational Grime?

\end{block}

::: columns
:::: column

\textbf{\underline{Taxonomy}:}

\centering
\begin{tikzpicture}
  \node[anchor=south west] (image) at (0,0) {
    \includegraphics[width=\textwidth]{images/taxonomies/mod_org_grime-tax.eps}
  };
  \begin{scope}[
  x={($0.1*(image.south east)$)},
  y={($0.1*(image.north west)$)}]

    \draw<3>[very thick,red] (0,4.45) rectangle (10,5.85);
    \draw<4>[very thick,red] (0,2.7) rectangle (10,4.45);
    \draw<5>[very thick,red] (0,1.35) rectangle (10,2.7);
    \draw<6>[very thick,red] (0,0) rectangle (10,1.35);
  \end{scope}
\end{tikzpicture}

<!--
\vskip-1em
\scriptsize
\begin{eqnarray*}
D' & = & \left|A + I - 1\right|\\
A  & = & \frac{N_a}{N_c}\\
I  & = & \frac{C_e}{C_a + C_e}
\end{eqnarray*}
-->

::::
:::: column

\textbf{\underline{Basis}:}

\begin{itemize}
  \item<2-> \footnotesize {\color<3->{AltGray}\textbf{Principles:} \textit{ADP} and \textit{SDP}}
  \item<3-> \footnotesize {\color<4->{AltGray}\textbf{Strength:} Type of coupling underlying package dependencies}
  \item<4-> \footnotesize {\color<5->{AltGray}\textbf{Scope:} Considers class dependency forming class membership within the pattern instance}
  \item<5-> \footnotesize \textbf{Context:} Does the dependency create a cycle or reduce stability
\end{itemize}

::::
:::

# Phase 02 - Simulation Experiments <!-- 1 Minute (14 Minutes Total) -->

\vskip-1.5em

::: columns
:::: column

\begin{block}

\scriptsize \textbf{RG2:} Analyze design pattern instances afflicted with \textbf{design pattern grime} for the purpose of evaluation with respect to the \textbf{ISO/IEC 25010 Maintainability sub-characteristics}, from the perspective of researchers, in the context of generated Java\texttrademark\ design pattern instances.

\end{block}

::::
:::: column

\pause

\begin{block}

\scriptsize \textbf{RG3:} Analyze design pattern instances afflicted with \textbf{design pattern grime} for the purpose of evaluation with respect to the \textbf{Technical Debt Principal and Interest}, from the perspective of researchers, in the context of generated Java\texttrademark\ design pattern instances.

\vspace{1.25em}

\end{block}

::::
:::

\pause

\vspace{-1.30em}
\begin{center}
\includegraphics[width=.85\textwidth]{images/arrows.eps}
\end{center}

\vskip-1.5em
\begin{block}

\scriptsize \textbf{DP1:} How can we conduct a full-factorial experiment to evaluate the relationship between grime and quality and grime and technical debt when we are unsure how often design pattern grime occurs?

\end{block}

<!--
\centering
\includegraphics[width=.75\textwidth]{images/method/phase02.eps}
-->

# The Arc Framework <!-- 1 Minute (15 Minutes Total) -->

\vskip-1.5em

\begin{block}

\centering
\footnotesize \textbf{DP1.1} How do we automate the data collection and experimentation process?

\end{block}

<!--
::: columns
:::: column
-->

\centering
\includegraphics[width=.43\textwidth]{images/arc/arc_arch.eps}

<!--::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/arc/javaai_integration.eps}

\vskip.5em

\includegraphics[width=.85\textwidth]{images/arc/javacomp_integration.eps}

::::
:::-->

<!-- # The Arc Framework

\vskip-1em

::: columns
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/arc/arc_arch.eps}

::::
:::: column
\centering
\vfill -->
<!--\includegraphics[width=.95\textwidth]{images/arc/workflows.eps}-->

<!-- ::::
::: -->

<!--
# The Arc Framework

\vskip-1.5em

\begin{block}

\centering
\textbf{DP1.5} How do we automate the data collection and experimentation process?

\end{block}

::: columns
:::: column

\textbf{\underline{Gradle Build Integration}:}

\centering
\includegraphics[width=.95\textwidth]{images/arc/gradle_integration.eps}

::::
:::: column

\textbf{\underline{SpotBugs Tool Integration}:}

\centering
\vfill
\includegraphics[width=.95\textwidth]{images/arc/findbugs_integration.eps}

::::
:::
-->

<!--# The Arc Framework

\vskip-1em

::: columns
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/arc/javaai_integration.eps}

::::
:::: column
\centering
\vfill
\includegraphics[width=.95\textwidth]{images/arc/javacomp_integration.eps}

::::
:::-->

<!--# The Arc Framework

\vskip-1em

::: columns
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/arc/gradle_integration.eps}

::::
:::: column
\centering
\vfill
\includegraphics[width=.95\textwidth]{images/arc/findbugs_integration.eps}

::::
:::-->

# Pattern Generation and Grime Injection <!-- 2 Minutes (17 Minutes total) -->

\vskip-1.5em

\begin{block}

\centering
\footnotesize

\only<1>{\textbf{DP1.2} How can we generate design pattern instances?}

\only<2>{\textbf{DP1.3} How can we ensure design patterns have the correct type of grime?}

\end{block}


::: columns
:::: column

\textbf{\underline{Pattern Generation Integration}:}

\centering
<!--\includegraphics[width=\textwidth]{images/pattern_gen/pattern_gen_cd.eps}-->
\includegraphics[width=.85\textwidth]{images/pattern_gen/patterngen_integration.eps}

::::
:::: column

\pause

\textbf{\underline{Grime Injection Operation}:}

\centering
<!--\includegraphics[width=\textwidth]{images/pattern_gen/patterngen_integration.eps}-->
\includegraphics[width=.85\textwidth]{images/injection/process.eps}

::::
:::

<!--# Injecting Grime

::: columns
:::: column

\centering
\includegraphics[width=.9\textwidth]{images/injection/injectors.eps}

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/injection/process.eps}

::::
:::-->

<!--
# Software Quality

\vskip-1.5em

\begin{block}

\centering
\footnotesize
\textbf{DP1.4} How do we measure the quality of a pattern instance?

\end{block}

::: columns
:::: column

\underline{\textbf{ISO/IEC 25010}}

\centering
\includegraphics[width=\textwidth]{images/quality/iso_concern.eps}

::::
:::: column

\underline{\textbf{Quality Modeling Approaches}}

\vskip1em

\small
Of the many available, we investigated

* **Quamoco**
* QATCH
* SQALE
* Squale

* **SIG Maintainability Model**
* **QMOOD**

::::
:::
-->

# Measuring Software Quality <!--1.25 Minutes (18.25 Minutes Total) -->

\vskip-1.5em

\begin{block}

\centering
\footnotesize
\textbf{DP1.4} How do we measure the quality of a pattern instance?

\end{block}

\pause

\centering

\begin{tikzpicture}
  \node[anchor=south west] (image) at (0,0) {
    \only<1-5>\includegraphics[width=.75\textwidth]{images/quality/sig_mm.eps}
  };
  \begin{scope}[
  x={($0.1*(image.south east)$)},
  y={($0.1*(image.north west)$)}]

    \fill<1-2>[white] (3,0) rectangle (6.3,10);
    \fill<1-3>[white] (6.3,0) rectangle (8.2,10);
    \fill<1-4>[white] (8.2,0) rectangle (10,10);
  \end{scope}
\end{tikzpicture}

<!--
\pause

\underline{\textbf{Integrating into Arc}}

\centering
\includegraphics[width=.95\textwidth]{images/quality/sig_arch.eps}
-->

\tiny Calibrated using SIG's prescribed method across 106 Open Source Projects from the *Qualitas.Class Corpus*

# Measuring Technical Debt <!-- 1.5 Minutes but 1 Minute with tight talking points and no integration (20.75 Minutes Total) -->
<!-- TODO Drop the Integration -- 2 Minutes (23 Total) -->

\vskip-1.5em

\begin{block}

\centering
\footnotesize
\textbf{DP1.5} How do we measure the technical debt of a pattern instance?

\end{block}

\pause

\begin{center}\underline{\textbf{Nugroho et al.'s Calculations}}\end{center}

::: columns
:::: column

\scriptsize

\begin{itemize}
  \item \textbf{TD Principal} (\textit{Repair Effort (RE)}):

  $RE = RF * RV * RA$

  \begin{itemize}
    \tiny
    \item Rebuild Value, $RV = SS * TF$
    \item RF - Rework Fraction
    \item SS - System Size in KLOC
    \item TF - Technology Factor % (0.00136 for Java)
    \item RA - Refactoring Adjustment % (0.10)
  \end{itemize}
\end{itemize}

::::
:::: column

\pause

\scriptsize

\begin{itemize}

  \item \textbf{TD Interest (TDI)}:

  $TDI = ME_I - ME_C$

  \begin{itemize}
    \tiny
    \item $ME_I$ = Maintenance Effort at Ideal Quality Level
    \item $ME_C$ = Maintenance Effort at Current Quality Level
  \end{itemize}

  $ME = \frac{MF * RV}{QF}$

  \begin{itemize}
    \tiny
    \item $MF$ = yearly maintenance effort of the system (0.15)
    \item $RV$ = Rebuild Value
    \item $QF$ = Quality Factor
  \end{itemize}

  $QF = 2^{((QualityLevel - 3) / 2)}$
\end{itemize}

<!--
::::
:::: column

\pause

\underline{\textbf{Integrating into Arc}}

\centering
\includegraphics[width=.95\textwidth]{images/quality/td_integration.eps}
-->

::::
:::

# Research Questions <!-- 1 Minute -->

\vskip-1em

<!-- TODO Show the headings first, then each sub question one at a time -->

\begin{itemize}
  \item \footnotesize \textbf{RQ2(3):} How does each type of grime affect software product maintainability (technical debt estimate)?
  \begin{itemize}
    \scriptsize
    \item<2-> {\color<3->{AltGray}\scriptsize \textbf{RQ2(3).1:} How does each type of Grime affect design pattern quality for each of the selected maintainability sub-characteristics (technical debt principal and interest)?}
    \item<3-> {\color<4->{AltGray}\scriptsize \textbf{RQ2(3).2:} What level of injection severity affects a change in design pattern quality for each of the maintainability sub-characteristics (technical debt principal and interest)?}
    \item<4-> \scriptsize \textbf{RQ2(3).3:} What is the difference between the effects of the grime types and their subtypes on maintainability sub-characteristics (technical debt principal and interest)?
  \end{itemize}
\end{itemize}

# Experimental Design <!-- 1 Minute (2 Minutes Total) -->

\vskip-1em

::: columns
:::: column

\begin{itemize}
  \item<1-> {\color<2->{AltGray} Design Type: Factorial}
  \item<2-> {\color<6->{AltGray} Replication Size: 2496 Units}
  \begin{itemize}
    \item<3-> {\color<4->{AltGray} 26 Grime Types for Injection}
    \item<4-> {\color<5->{AltGray} 16 Design Pattern Types}
    \item<5-> {\color<6->{AltGray} 6 Levels of Injection Severity}
  \end{itemize}
\end{itemize}

\scriptsize

\only<4->{
  \begin{table}[]
  \centering
  \begin{tabular}{cc}
  \hline
  \multicolumn{2}{c}{\textbf{Pattern Types}} \\ \hline
  Adapter                 & Observer         \\
  Bridge                  & Prototype        \\
  Chain of Responsibility & Proxy            \\
  Command                 & Singleton        \\
  Composite               & State            \\
  Decorator               & Strategy         \\
  Flyweight               & Template Method  \\
  Factory Method          & Visitor          \\ \hline
  \end{tabular}
  \end{table}
}

::::
:::: column

\scriptsize

\only<5->{
  \begin{table}[]
  \centering
  \begin{tabular}{cc}
  \hline
  \textbf{Level} & \textbf{Max \% Grime Injected} \\ \hline
   \color<6>{AltOrange} 0             & \color<6>{AltOrange} 0\% (Control)                  \\
   1             & $\leq$ 15\%                    \\
   2             & $\leq$ 30\%                    \\
   3             & $\leq$ 45\%                    \\
   4             & $\leq$ 60\%                    \\
   5             & $\leq$ 75\%                    \\ \hline
  \end{tabular}
  \end{table}
}

\only<7->{
  \textbf{\underline{Analysis}:}

  \begin{itemize}
    \item Each experiment was analyzed using a Permutation F-Test
    \item Followed by an analysis of interactions between Pattern Type, Injection Type and Injection Severity
    \item Here we present 3 of the 7 Experiments
  \end{itemize}
}

<!--
\vskip1em
\centering
\includegraphics[width=\textwidth]{images/experiments/analysis.eps}
-->

::::
:::

# Data Collection <!-- 1 Minute  (3 Minutes Total)-->

\vskip-1em

<!--
::: columns
:::: column

\textbf{\underline{Workflow}:}
-->

\centering
\includegraphics[width=\textwidth]{images/experiments/grime_ex_dc.eps}

<!--
::::
:::: column

\textbf{\underline{Execution}:}

\centering
\includegraphics[width=\textwidth]{images/experiments/exp_execution.eps}

\textbf{\underline{Size Analysis}:}

\begin{table}[]
\scriptsize
\centering
\begin{tabular}{lc}
\hline
\textbf{Attribute} & \textbf{Replications} \\ \hline
Analyzability      & 3                     \\
\rowcolor[HTML]{EFEFEF}
Testability        & 12                    \\
Modularity         & 4                     \\
\rowcolor[HTML]{EFEFEF}
Modifiability      & 4                     \\
Reusability        & --                    \\
\rowcolor[HTML]{EFEFEF}
TD Principal       & 2                     \\
TD Interest        & 3                     \\ \hline
\end{tabular}
\end{table}

\vskip1em

\begin{block}

\centering

\textbf{Total of 69,888 Experimental Units}

\end{block}

::::
:::
-->

<!--
# Analyzability

\vskip-2.25em

::: columns
:::: column

\centering
\includegraphics[width=.825\textwidth]{images/experiments/analyzability/panels_plot.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/analyzability/table_plot.pdf}

::::
:::: column

\centering
\includegraphics[width=.825\textwidth]{images/experiments/analyzability/aov_plot.pdf}

\begin{table}[]
\centering
\tiny
\begin{tabular}{ccccc}
\hline
\textbf{Min} & \textbf{Median} & \textbf{Mean} & \textbf{Max} & \textbf{SD} \\ \hline
-10382265    & -0.0038076      & -0.1226307    & 0.0          & 0.2772369   \\ \hline
\end{tabular}
\end{table}

\begin{table}[]
\centering
\tiny
\begin{tabular}{llll}
\hline
\textbf{Test}      & \textbf{Value} & \textbf{p-value}  & \textbf{Decision} \\ \hline
Anderson-Darling   & 1812.5         & \textless 2.2e-16 & Reject $H_0$         \\
Levene's Test      & 1.6523e26      & \textless 2.2e-16 & Reject $H_0$         \\ \hline\hline
Permutation F-Test &                & \textless 2.2e-16 & Reject $H_{1,0}$       \\
Interactions       &                & \textless 2.2e-16 & Reject $H_{2,0}$       \\ \hline
\end{tabular}
\end{table}

::::
:::

# Analyzability

\vskip-2em

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/analyzability/class_grime_interactions.pdf}

::::
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/analyzability/class_grime_interactions2.pdf}

::::
:::

\centering
\includegraphics[width=.375\textwidth]{images/experiments/analyzability/mod_grime_interactions.pdf}

# Analyzability

\vskip-2em

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/analyzability/mod_org_grime_interactions.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/analyzability/pkg_org_grime_interactions.pdf}

::::
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/analyzability/mod_org_grime_interactions2.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/analyzability/pkg_org_grime_interactions2.pdf}

::::
:::

# Analyzability

::: columns
:::: column

\centering
\includegraphics[width=1.1\textwidth]{images/experiments/analyzability/pkg_org_grime_interactions3.pdf}

::::
:::: column

\scriptsize

\only<3->{
  \begin{itemize}
    \item \textbf{RQ2.1}
    \begin{itemize}
      \item \tiny Most significantly impacted by Org Grime
      \item \tiny Class and Mod Grime effects are dependent on pattern type (specifically Bridge, Decorator, Observers, Singleton, and Visitor)
    \end{itemize}

    \item \textbf{RQ2.2}
    \begin{itemize}
      \item \tiny All Injection Severity Levels induce a negative change
      \item \tiny The exception of PECG and the Prototype Pattern Type
    \end{itemize}

    \item \textbf{RQ2.3}
    \begin{itemize}
      \item \tiny The most significant effects are from Organizational Grime subtypes
    \end{itemize}
  \end{itemize}
}

::::
:::
-->

#

\centering
\vfill
\begin{minipage}{.45\textwidth}
\Huge \textcolor{MSUDkBlue}{Testability}
\vskip-0.75em
\textcolor{MSUAthleticGold}{\rule{\textwidth}{2pt}}

\large \color{MSUDkBlue}\textbf{\hfill Experiment}
\end{minipage}

# Testability

\vskip-1.5em

\centering
\only<1>{\includegraphics[width=.75\textwidth]{images/experiments/testability/scatterplot.png}}
\only<2>{\includegraphics[width=.75\textwidth]{images/experiments/testability/key_interactions.pdf}}

<!--
# Testability

\vskip-2.2em

\centering

\begin{tikzpicture}
  \node[anchor=south west] (image) at (0,0) {
    \includegraphics[width=.8\textwidth]{images/experiments/testability/panels_plot.png}
  };
  \begin{scope}[
  x={($0.1*(image.south east)$)},
  y={($0.1*(image.north west)$)}]

  % Grid
  %  \draw[lightgray,step=1] (image.south west) grid (image.north east);

  % Axes' labels
  %  \foreach \x in {0,1,...,10} { \node [below] at (\x,0) {\x}; }
  %  \foreach \y in {0,1,...,10} { \node [left] at (0,\y) {\y};}

    \draw<2>[very thick,orange] (0.65,7) rectangle (2.85,8.85);
    \draw<2>[very thick,blue] (2.85,5) rectangle (5,7);
    \draw<2>[very thick,blue] (5,3.1) rectangle (7.2,5);
    \draw<2>[very thick,blue] (7.2,1.2) rectangle (9.3,3.1);
    \draw<3>[very thick,green] (7.2,7) rectangle (9.3,8.85); % correlation of sigTest by IS Factor
    \draw<4>[very thick,green] (0.4,5) rectangle (2.85,7); % scatterplot of sigTest by PT Factor
    \draw<5>[very thick,green] (0.65,3.1) rectangle (2.85,5); % scatterplot of sigTest by IT Factor
  \end{scope}
\end{tikzpicture}
-->

<!-- # Testability -->
<!-- 2 Minutes (5 Minutes Total) -->

<!-- \vskip-1.5em -->

<!--
::: columns
:::: column

\textbf{\underline{The Data}:}

\centering
\includegraphics[width=\textwidth]{images/experiments/testability/panels_plot.pdf}
-->

<!--
\begin{table}[]
\centering
\tiny
\begin{tabular}{ccccc}
\hline
\textbf{Min} & \textbf{Median} & \textbf{Mean} & \textbf{Max} & \textbf{SD} \\ \hline
-1.459066    & -0.005952       & -0.248710     & 0.0          & 0.5072027   \\ \hline
\end{tabular}
\end{table}
-->

<!--
::::
:::: column
-->

<!--
\centering
\textbf{\underline{Assumptions}:}

\begin{table}[]
\centering
\tiny
\begin{tabular}{lccc}
\hline
\textbf{Test}      & \textbf{Value} & \textbf{p-value}  & \textbf{Decision} \\ \hline
Anderson-Darling   & 5069.2         & \textless 2.2e-16 & Reject $H_0$         \\
Levene's Test      & 8.7427         & \textless 2.2e-16 & Reject $H_0$         \\ \hline
\end{tabular}
\end{table}

\textbf{\underline{Hypothesis Testing}:}

\begin{table}[]
\centering
\tiny
\begin{tabular}{lccc}
\hline
\textbf{Test}      & \textbf{Value} & \textbf{p-value}  & \textbf{Decision} \\ \hline
Permutation F-Test & 627.8          & \textless 2.2e-16 & Reject $H_{1,0}$       \\
Interactions       &                & \textless 2.2e-16 & Reject $H_{2,0}$       \\ \hline
\end{tabular}
\end{table}
-->

<!--
::::
:::
-->

<!--
# Testability

\vskip-2em

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/testability/class_grime_interactions.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/testability/pkg_org_grime_interactions.pdf}

::::
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/testability/mod_grime_interactions.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/testability/pkg_org_grime_interactions2.pdf}

::::
:::
-->

 <!-- 1.5 Minutes (6.5 Minutes Total) -->
<!--
# Testability

\vskip-1.5em

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/testability/key_interactions.pdf}

::::
:::: column

\scriptsize

* **RQ2.1**
  - \tiny Most significantly impacted by Org Grime
  - \tiny Class and Mod Grime effects are smaller and dependent on pattern type (specifically Bridge, Decorator, Observers, Singleton, and Visitor)

* **RQ2.2**
  - \tiny All Injection Severity Levels induce a negative change in Testability.

* **RQ2.3**
  - \tiny The most significant effects are from Organizational Grime subtypes.

::::
:::
-->

#

\centering
\vfill
\begin{minipage}{.45\textwidth}
\Huge \textcolor{MSUDkBlue}{Modifiability}
\vskip-0.75em
\textcolor{MSUAthleticGold}{\rule{\textwidth}{2pt}}

\large \color{MSUDkBlue}\textbf{\hfill Experiment}
\end{minipage}

# Modifiability

\vskip-1.5em

\centering
\only<1>{\includegraphics[width=.75\textwidth]{images/experiments/modifiability/scatterplot.png}}
\only<2>{\includegraphics[width=.75\textwidth]{images/experiments/modifiability/key_interactions.pdf}}

<!--
# Modifiability

\vskip-2.2em

\centering

\begin{tikzpicture}
  \node[anchor=south west] (image) at (0,0) {
    \includegraphics[width=.8\textwidth]{images/experiments/modifiability/panels_plot.png}
  };
  \begin{scope}[
  x={($0.1*(image.south east)$)},
  y={($0.1*(image.north west)$)}]

  % Grid
  %  \draw[lightgray,step=1] (image.south west) grid (image.north east);

  % Axes' labels
  %  \foreach \x in {0,1,...,10} { \node [below] at (\x,0) {\x}; }
  %  \foreach \y in {0,1,...,10} { \node [left] at (0,\y) {\y};}

    \draw<2>[very thick,orange] (0.65,7) rectangle (2.85,8.85);
    \draw<2>[very thick,blue] (2.85,5) rectangle (5,7);
    \draw<2>[very thick,blue] (5,3.1) rectangle (7.2,5);
    \draw<2>[very thick,blue] (7.2,1.2) rectangle (9.3,3.1);
    %\draw<3>[very thick,green] (7.2,7) rectangle (9.3,8.85); % correlation of sigModif by IS Factor
    \draw<3>[very thick,green] (0.4,5) rectangle (2.85,7); % scatterplot of sigModif by PT Factor
    \draw<4>[very thick,green] (0.65,3.1) rectangle (2.85,5); % scatterplot of sigModif by IT Factor
  \end{scope}
\end{tikzpicture}
-->

<!-- # Modifiability  -->
<!-- 1.5 Minutes (8 Minutes Total) -->

<!-- \vskip-1.5em -->

<!--
::: columns
:::: column

\textbf{\underline{The Data}:}

\centering
\includegraphics[width=\textwidth]{images/experiments/modifiability/panels_plot.pdf}
-->

<!--
\begin{table}[]
\centering
\tiny
\begin{tabular}{ccccc}
\hline
\textbf{Min} & \textbf{Median} & \textbf{Mean} & \textbf{Max} & \textbf{SD} \\ \hline
-1.36        & 0.0             & -0.01526      & 0.49121      & 0.1230359   \\ \hline
\end{tabular}
\end{table}
-->

<!--
::::
:::: column
-->

<!--
\centering

\textbf{\underline{Assumptions}:}

\begin{table}[]
\centering
\tiny
\begin{tabular}{lccc}
\hline
\textbf{Test}      & \textbf{Value} & \textbf{p-value}  & \textbf{Decision} \\ \hline
Anderson-Darling   & 3211           & \textless 2.2e-16 & Reject $H_0$         \\
Levene's Test      & 2.5321         & \textless 2.2e-16 & Reject $H_0$         \\ \hline
\end{tabular}
\end{table}

\textbf{\underline{Hypothesis Testing}:}

\begin{table}[]
\centering
\tiny
\begin{tabular}{lccc}
\hline
\textbf{Test}      & \textbf{Value} & \textbf{p-value}  & \textbf{Decision} \\ \hline
Permutation F-Test & 4.6363         & \textless 2.2e-16 & Reject $H_{1,0}$       \\
Interactions       &                & \textless 2.2e-16 & Reject $H_{2,0}$       \\ \hline
\end{tabular}
\end{table}
-->

<!--
::::
:::
-->

<!--
# Modifiability

\vskip-2em

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/modifiability/class_grime_interactions.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/modifiability/mod_grime_interactions.pdf}

::::
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/modifiability/class_grime_interactions2.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/modifiability/mod_grime_interactions2.pdf}

::::
:::

# Modifiability

\vskip-2em

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/modifiability/mod_org_grime_interactions.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/modifiability/pkg_org_grime_interactions.pdf}

::::
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/modifiability/mod_org_grime_interactions2.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/modifiability/pkg_org_grime_interactions2.pdf}

::::
:::
-->

<!-- 1.5 Minutes (9.5 Minutes Total) -->
<!--
# Modifiability

\vskip-1.5em

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/modifiability/key_interactions.pdf}

::::
:::: column

\scriptsize

* **RQ2.1**
  - \tiny Decorator, Prototype, and Visitor instances are positively impacted for all Grime types but PEAG, TEAG, MPICG, MTICG, and PIRG
  - \tiny PEAG, TEAG, and PIRG negatively affect Modifiability for all pattern types.

* **RQ2.2**
  - \tiny Affected either positively or negatively based on pattern type and when IS is level 3 or greater.

* **RQ2.3**
  - \tiny The most significant effects are negative and stem from PEAG, TEAG, MPICG, and MTICG
  - \tiny PEAG and TEAG only affect a few patterns
  - \tiny MPICG and MTICG affect all patterns

::::
:::
-->

<!--
# Modularity

\vskip-2.25em

::: columns
:::: column

\centering
\includegraphics[width=.825\textwidth]{images/experiments/modularity/panels_plot.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/modularity/table_plot.pdf}

::::
:::: column

\centering
\includegraphics[width=.825\textwidth]{images/experiments/modularity/aov_plot.pdf}

\begin{table}[]
\centering
\tiny
\begin{tabular}{ccccc}
\hline
\textbf{Min} & \textbf{Median} & \textbf{Mean} & \textbf{Max} & \textbf{SD} \\ \hline
-2.64236     & 0.0             & -0.6583       & 1.23418      & 0.5395721   \\ \hline
\end{tabular}
\end{table}

\begin{table}[]
\centering
\tiny
\begin{tabular}{lccc}
\hline
\textbf{Test}      & \textbf{Value} & \textbf{p-value}  & \textbf{Decision} \\ \hline
Anderson-Darling   & 1122.3         & \textless 2.2e-16 & Reject $H_0$         \\
Levene's Test      & 3.1551         & \textless 2.2e-16 & Reject $H_0$         \\ \hline\hline
Permutation F-Test & 57.63          & \textless 2.2e-16 & Reject $H_{1,0}$       \\
Interactions       &                & \textless 2.2e-16 & Reject $H_{2,0}$       \\ \hline
\end{tabular}
\end{table}

::::
:::

# Modularity

\vskip-2em

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/modularity/mod_grime_interactions.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/modularity/class_grime_interactions.pdf}

::::
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/modularity/mod_grime_interactions2.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/modularity/pkg_org_grime_interactions.pdf}
::::
:::

# Modularity

\vskip-2em

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/modularity/mod_org_grime_interactions.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/modularity/mod_org_grime_interactions2.pdf}

::::
:::: column

\scriptsize

* **RQ2.1**
  - \tiny Positively affected by Class Grime for Decorator, Prototype and Visitor Patterns
  - \tiny Negatively affected by Modular Grime across all pattern types.
  - \tiny Positively affected by Package Org Grime, MPEUG, and MTEUG for all pattern types.
  - \tiny Negatively affected by all remaining forms of Modular Org Grime.

* **RQ2.2**
  - \tiny Positive effects of class grime depend upon Injection Severity level
  - \tiny The negative effects occur across all patterns and all levels of severity.

* **RQ2.3**
  - \tiny PEAG, TEAG, and Modular Org Grime subtypes have significant negative effects
  - \tiny MTEUG and Package Org grime have significant positive effects.

::::
:::

# Reusability

\vskip-2.25em

::: columns
:::: column

\centering
\includegraphics[width=.825\textwidth]{images/experiments/reusability/panels_plot.pdf}

- \scriptsize Across all of the experiments each of the following showed no change during injection
  * \tiny Sig Duplication
  * \tiny Sig Unit Complexity
  * \tiny \textbf{Sig Unit Interfacing}
  * \tiny \textbf{Sig Unit Size}

- \scriptsize Reusability is the aggregation of the ratings for Unit Interfacing and Unit Size

::::
:::: column

\begin{center}
\includegraphics[width=.75\textwidth]{images/experiments/reusability/table_plot.pdf}
\end{center}

\begin{table}[]
\centering
\tiny
\begin{tabular}{ccccc}
\hline
\textbf{Min} & \textbf{Median} & \textbf{Mean} & \textbf{Max} & \textbf{SD} \\ \hline
0.0          & 0.0             & 0.0           & 0.0          & 0.0         \\ \hline
\end{tabular}
\end{table}

\begin{block}

\centering
\scriptsize Therefore, there is no change in Reusability

\end{block}

::::
:::
-->

#

\centering
\vfill
\begin{minipage}{.45\textwidth}
\Huge \textcolor{MSUDkBlue}{TD Principal}
\vskip-0.75em
\textcolor{MSUAthleticGold}{\rule{\textwidth}{2pt}}

\large \color{MSUDkBlue}\textbf{\hfill Experiment}
\end{minipage}

# TD Principal

\vskip-1.5em

\centering
\only<1>{\includegraphics[width=.75\textwidth]{images/experiments/td_principal/scatterplot.png}}
\only<2>{\includegraphics[width=.75\textwidth]{images/experiments/td_principal/key_interactions.pdf}}

<!--
# TD Principal

\vskip-2.2em

\centering

\begin{tikzpicture}
  \node[anchor=south west] (image) at (0,0) {
    \includegraphics[width=.8\textwidth]{images/experiments/td_principal/panels_plot.png}
  };
  \begin{scope}[
  x={($0.1*(image.south east)$)},
  y={($0.1*(image.north west)$)}]

  % Grid
  %  \draw[lightgray,step=1] (image.south west) grid (image.north east);

  % Axes' labels
  %  \foreach \x in {0,1,...,10} { \node [below] at (\x,0) {\x}; }
  %  \foreach \y in {0,1,...,10} { \node [left] at (0,\y) {\y};}

    \draw<2>[very thick,orange] (0.65,7) rectangle (2.85,8.85);
    \draw<2>[very thick,blue] (2.85,5) rectangle (5,7);
    \draw<2>[very thick,blue] (5,3.1) rectangle (7.2,5);
    \draw<2>[very thick,blue] (7.2,1.2) rectangle (9.3,3.1);
    \draw<3>[very thick,green] (7.2,7) rectangle (9.3,8.85); % correlation of TDP by IS Factor
    \draw<4>[very thick,green] (0.4,5) rectangle (2.85,7); % scatterplot of TDP by PT Factor
    \draw<5>[very thick,green] (0.65,3.1) rectangle (2.85,5); % scatterplot of TDP by IT Factor
  \end{scope}
\end{tikzpicture}
-->

<!-- # TD Principal -->
<!-- 1 Minute (10.5 Minutes Total) -->

<!-- \vskip-1.5em -->

<!--
::: columns
:::: column

\textbf{\underline{The Data}:}

\centering
\includegraphics[width=\textwidth]{images/experiments/td_principal/panels_plot.pdf}
-->

<!--
\begin{table}[]
\centering
\tiny
\begin{tabular}{ccccc}
\hline
\textbf{Min} & \textbf{Median} & \textbf{Mean} & \textbf{Max} & \textbf{SD} \\ \hline
-0.9351      & 0.1002          & 0.3206        & 12.7850      & 0.6634359   \\ \hline
\end{tabular}
\end{table}
-->

<!--
::::
:::: column
-->

<!--
\centering

\textbf{\underline{Assumptions}:}

\begin{table}[]
\centering
\tiny
\begin{tabular}{lccc}
\hline
\textbf{Test}      & \textbf{Value} & \textbf{p-value}  & \textbf{Decision} \\ \hline
Anderson-Darling   & 534.18         & \textless 2.2e-16 & Reject $H_0$         \\
Levene's Test      & 4.254e26       & \textless 2.2e-16 & Reject $H_0$         \\ \hline
\end{tabular}
\end{table}

\textbf{\underline{Hypothesis Testing}:}

\begin{table}[]
\centering
\tiny
\begin{tabular}{lccc}
\hline
\textbf{Test}      & \textbf{Value} & \textbf{p-value}  & \textbf{Decision} \\ \hline
Permutation F-Test & 6.226          & \textless 2.2e-16 & Reject $H_{1,0}$       \\
Interactions       &                & \textless 2.2e-16 & Reject $H_{2,0}$       \\ \hline
\end{tabular}
\end{table}
-->

<!--
::::
:::
-->

<!--
# TD Principal

\vskip-2em

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/td_principal/cls_grime_interactions.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/td_principal/mod_org_grime_interactions.pdf}

::::
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/td_principal/mod_grime_interactions.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/td_principal/mod_org_grime_interactions2.pdf}

::::
:::
-->

<!-- 2.5 Minutes (13 Minutes Total) -->
<!--
# TD Principal

\vskip-1.5em

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/td_principal/key_interactions.pdf}

::::
:::: column

\scriptsize

* **RQ3.1**
  - \tiny All grime types affect positive change as severity increases
  - \tiny The exceptions are MTEUG, PECG, and PICG, which have negative impact

* **RQ3.2**
  - \tiny All severity levels affect positive change except for MTEUG
  - \tiny As severity increases there is an increase in the magnitude of the change

* **RQ3.3**
  - \tiny Modular and Class grime have positive effects
  - \tiny Modular Org Grime (excluding MPEUG and MTEUG) have positive effects
  - \tiny MPEUG and MTEUG have significant negative effects
  - \tiny PECG and PICG have positive effects
  - \tiny PERG and PIRG have both negative and positive effects dependent upon severity level.

::::
:::
-->

<!--
# TD Interest

\vskip-1.5em

::: columns
:::: column

\textbf{\underline{The Data}:}

\centering
\includegraphics[width=\textwidth]{images/experiments/td_interest/panels_plot.pdf}
-->

<!--
\begin{table}[]
\centering
\tiny
\begin{tabular}{ccccc}
\hline
\textbf{Min} & \textbf{Median} & \textbf{Mean} & \textbf{Max} & \textbf{SD} \\ \hline
-0.0072254   & 0.0006794       & 0.0025232     & 0.0962732    & 0.005841174 \\ \hline
\end{tabular}
\end{table}
-->

<!--
::::
:::: column

\textbf{\underline{Assumptions}:}

\begin{table}[]
\centering
\tiny
\begin{tabular}{llll}
\hline
\textbf{Test}      & \textbf{Value} & \textbf{p-value}  & \textbf{Decision} \\ \hline
Anderson-Darling   & 964.57         & \textless 2.2e-16 & Reject $H_0$      \\
Levene's Test      & 1.369          & \textless 2.2e-16 & Reject $H_0$      \\ \hline
\end{tabular}
\end{table}

\textbf{\underline{Hypothesis Testing}:}

\begin{table}[]
\centering
\tiny
\begin{tabular}{llll}
\hline
\textbf{Test}      & \textbf{Value} & \textbf{p-value}  & \textbf{Decision} \\ \hline
Permutation F-Test & 11.01          & \textless 2.2e-16 & Reject $H_{1,0}$  \\
Interactions       &                & \textless 2.2e-16 & Reject $H_{2,0}$  \\ \hline
\end{tabular}
\end{table}

::::
:::
-->

<!--
# TD Interest

\vskip-2em

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/td_interest/cls_grime_interactions.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/td_interest/mod_org_grime_interactions.pdf}
::::
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/experiments/td_interest/mod_grime_interactions.pdf}

\includegraphics[width=.75\textwidth]{images/experiments/td_interest/mod_org_grime_interactions2.pdf}

::::
:::
-->

<!--
# TD Interest

\vskip-1.5em

::: columns
:::: column

\centering
\includegraphics[width=\textwidth]{images/experiments/td_interest/key_interactions.pdf}

::::
:::: column

\scriptsize

* **RQ3.1**
  - \tiny All grime types affect positive change as severity increases
  - \tiny The exceptions are MTEUG, PECG, and PICG, which have negative impact

* **RQ3.2**
  - \tiny All severity levels affect positive change except for MTEUG
  - \tiny As severity increases there is an increase in the magnitude of the change

* **RQ3.3**
  - \tiny Modular and Class grime have positive effects
  - \tiny Modular Org Grime (excluding MPEUG and MTEUG) have positive effects
  - \tiny MPEUG and MTEUG have significant negative effects
  - \tiny PECG and PICG have positive effects
  - \tiny PERG and PIRG have both negative and positive effects dependent upon severity level.

::::
:::
-->

# Phase 03 - Verification Study <!-- 0.5 Minutes (13.5 Minutes Total) -->

\vskip-1.5em

\begin{block}

\scriptsize
\textbf{RG4:} Analyze design pattern instances for the purpose of comparing injected and observed instances of grime with respect to their ISO/IEC 25010 Maintainability subcharacteristics attributes and Technical Debt Principal and Interest from the perspective of researchers in the context of open source Java\texttrademark\ software projects.

\end{block}

\pause

\vspace{-1.5em}

\begin{center}
\includegraphics[width=.25\textwidth]{images/arrow.eps}
\end{center}

\vskip-1.5em

\begin{block}

\scriptsize
\textbf{DP2:} How do we verify the results of the experiments with real software?

\end{block}

<!--
\centering
\includegraphics[width=.75\textwidth]{images/method/phase03.eps}
-->


# Design Pattern Detection <!-- 1.25 Minutes but 1 Minute with tight talking points (15 Minutes Total) -->

\vskip-1.5em

\begin{block}

\centering
\footnotesize
\only<1-2>{\textbf{DP2.1:} How do we incorporate design pattern detection into the Arc Framework?}
\only<3>{\textbf{DP2.2:} How do we track instances of design patterns across versions of a software system?}

\end{block}

\centering
\only<2-3>{\includegraphics[width=.45\textwidth]{images/dpd/pattern4_integration_nopc.eps}}

# Design Pattern Detection

\vskip-1.5em

\begin{block}

\centering
\footnotesize
\textbf{DP2.2:} How do we track instances of design patterns across versions of a software system?

\end{block}

::: columns
:::: column

\includegraphics[width=.95\textwidth]{images/dpd/pattern4_integration.eps}

::::
:::: column

\only<2>{
\includegraphics[width=.95\textwidth]{images/dpd/chaining1.eps}
}
\only<3>{
\includegraphics[width=.95\textwidth]{images/dpd/chaining2.eps}
}
\only<4>{
\includegraphics[width=.95\textwidth]{images/dpd/chaining3.eps}
}

::::
:::

# Controlled Injection <!-- 1 Minute (16 Minutes Total) -->

\vskip-1.5em

\begin{block}

\centering
\footnotesize
\textbf{DP2.3:} How do we modify the Software Injector to allow for controlled injection to mimic the change in grime that occurred between versions?

\end{block}

\centering
\includegraphics[width=.45\textwidth]{images/injection/process_mod.eps}

# Research Questions <!-- 0.5 Minutes (16.5 Minutes Total) -->

##

\scriptsize
**RQ4:** Do observed and injected grime have a similar effect on the Maintainability sub-characteristics and Technical Debt Principal and Interest?

<!--
\tiny
- **RQ4.1:** Does grime injection have a similar effect on **Analyzability** as the observed effect of grime on **Analyzability**?
- **RQ4.2:** Does grime injection have a similar effect on **Testability** as the observed effect of grime on **Testability**?
- **RQ4.3:** Does grime injection have a similar effect on **Modifiability** as the observed effect of grime on **Modifiability**?
- **RQ4.4:** Does grime injection have a similar effect on **Modularity** as the observed effect of grime on **Modularity**?
- **RQ4.5:** Does grime injection have a similar effect on **Reusability** as the observed effect of grime on **Reusability**?
- **RQ4.6:** Does grime injection have a similar effect on **Technical Debt Principal** as the observed effect of grime on **Technical Debt Principal**?
- **RQ4.7:** Does grime injection have a similar effect on **Technical Debt Interest** as the observed effect of grime on **Technical Debt Interest**?
-->

<!--
# System Selection

\vskip-1em

\begin{table}[]
\centering

\underline{Open Source Systems selected from the \textit{Qualitas Corpus}}

\footnotesize
\begin{tabular}{l|ccc|l|ccc}
\cline{2-4} \cline{6-8}
                                 & \multicolumn{3}{c|}{\textbf{Versions}}                                                              &                                     & \multicolumn{3}{c}{\textbf{Versions}}                                                                 \\ \hline
\textbf{System}                & \textbf{Min}                    & \textbf{Max}                   & \textbf{Evaluated}        & \textbf{System}                     & \textbf{Min}                     & \textbf{Max}                   & \textbf{Evaluated}                  \\ \hline
\textbf{jgrapht}                          & 0.4.0                         & 0.8.3                          & 3                         & \cellcolor[HTML]{EFEFEF}\textbf{trove}       & \cellcolor[HTML]{EFEFEF}0.0.1 & \cellcolor[HTML]{EFEFEF}3.0.0   & \cellcolor[HTML]{EFEFEF}5  \\
\cellcolor[HTML]{EFEFEF}\textbf{jmoney}   & \cellcolor[HTML]{EFEFEF}0.2.0 & \cellcolor[HTML]{EFEFEF}0.4.4  & \cellcolor[HTML]{EFEFEF}3 & \textbf{jag}                                 & 2.2.0                         & 6.1.0                           & 3                          \\
\textbf{fitjava}                          & 1.0                           & 1.1                            & 3                         & \cellcolor[HTML]{EFEFEF}\textbf{quickserver} & \cellcolor[HTML]{EFEFEF}1.0   & \cellcolor[HTML]{EFEFEF}1.4.7   & \cellcolor[HTML]{EFEFEF}12 \\
\cellcolor[HTML]{EFEFEF}\textbf{drawswf}  & \cellcolor[HTML]{EFEFEF}1.0.1 & \cellcolor[HTML]{EFEFEF}1.1.1  & \cellcolor[HTML]{EFEFEF}3 & \textbf{sunflow}                             & 0.05.1                        & 0.07.2                          & 2                          \\
\textbf{webmail}                          & 0.6.1                         & 0.7.6                          & 3                         & \cellcolor[HTML]{EFEFEF}\textbf{informa}     & \cellcolor[HTML]{EFEFEF}0.2.0 & \cellcolor[HTML]{EFEFEF}0.7.0a1 & \cellcolor[HTML]{EFEFEF}6  \\
\cellcolor[HTML]{EFEFEF}\textbf{nekohtml} & \cellcolor[HTML]{EFEFEF}0.9.5 & \cellcolor[HTML]{EFEFEF}1.9.18 & \cellcolor[HTML]{EFEFEF}4 & \textbf{marauroa}                            & 2.6.3                         & 3.8.1                           & 2                          \\
\textbf{jsXe}                             & 0.1.1                         & 0.4b                           & 11                        & \cellcolor[HTML]{EFEFEF}\textbf{sablecc}     & \cellcolor[HTML]{EFEFEF}3.1   & \cellcolor[HTML]{EFEFEF}4\_b.4  & \cellcolor[HTML]{EFEFEF}2  \\ \hline
\end{tabular}
\end{table}
-->

# Data Collection (1) <!-- 1.25 Minutes but 1 Minute with tight talking points (17.75 Minutes Total) -->

\vskip-1.5em

\centering
\includegraphics[width=\textwidth]{images/flows/verification_phase_1.eps}

<!--
::: columns
:::: column

\footnotesize
* Total versions evaluated: 62
* Total instances evaluated: 705
* Total chains identified: 230

::::
:::: column

-->

\pause

##

\centering

**Total units found: 8**

<!--
::::
:::
-->

<!--
# Results (1)

\vskip-1.5em

\begin{table}[]
\centering
\scriptsize
\begin{tabular}{lcccc|lcccc}
\hline
\textbf{Project}                & \textbf{Versions}          & \textbf{Instances}          & \textbf{Chains}            & \textbf{Units}                     & \textbf{Project}                    & \textbf{Versions}          & \textbf{Instances}         & \textbf{Chains}            & \textbf{Units}                     \\ \hline
jgrapht                         & 3                          & 27                          & 9                          & 0                                  & \cellcolor[HTML]{EFEFEF}jmoney      & \cellcolor[HTML]{EFEFEF}3  & \cellcolor[HTML]{EFEFEF}6  & \cellcolor[HTML]{EFEFEF}2  & \cellcolor[HTML]{EFEFEF}0          \\
\cellcolor[HTML]{EFEFEF}fitjava & \cellcolor[HTML]{EFEFEF}3  & \cellcolor[HTML]{EFEFEF}12  & \cellcolor[HTML]{EFEFEF}4  & \cellcolor[HTML]{EFEFEF}\textbf{5} & drawswf                             & 3                          & 6                          & 2                          & \textbf{1}                         \\
webmail                         & 3                          & 84                          & 28                         & 0                                  & \cellcolor[HTML]{EFEFEF}nekohtml    & \cellcolor[HTML]{EFEFEF}4  & \cellcolor[HTML]{EFEFEF}12 & \cellcolor[HTML]{EFEFEF}3  & \cellcolor[HTML]{EFEFEF}0          \\
\cellcolor[HTML]{EFEFEF}jsXe    & \cellcolor[HTML]{EFEFEF}11 & \cellcolor[HTML]{EFEFEF}66  & \cellcolor[HTML]{EFEFEF}6  & \cellcolor[HTML]{EFEFEF}0          & trove                               & 5                          & 140                        & 28                         & 0                                  \\
jag                             & 3                          & 24                          & 8                          & 0                                  & \cellcolor[HTML]{EFEFEF}quickserver & \cellcolor[HTML]{EFEFEF}12 & \cellcolor[HTML]{EFEFEF}24 & \cellcolor[HTML]{EFEFEF}2  & \cellcolor[HTML]{EFEFEF}\textbf{2} \\
\cellcolor[HTML]{EFEFEF}sunflow & \cellcolor[HTML]{EFEFEF}2  & \cellcolor[HTML]{EFEFEF}118 & \cellcolor[HTML]{EFEFEF}59 & \cellcolor[HTML]{EFEFEF}0          & informa                             & 6                          & 42                         & 7                          & 0                                  \\
marauroa                        & 2                          & 106                         & 53                         & 0                                  & \cellcolor[HTML]{EFEFEF}sablecc     & \cellcolor[HTML]{EFEFEF}2  & \cellcolor[HTML]{EFEFEF}38 & \cellcolor[HTML]{EFEFEF}19 & \cellcolor[HTML]{EFEFEF}0          \\ \hline
\end{tabular}
\end{table}

\footnotesize
* Total versions evaluated: 62
* Total instances evaluated: 705
* Total chains identified: 230
* **Total units found: 8**
-->

# Data Collection (2) <!-- 2.25 Minutes (19.75 minutes) -->

::: columns
:::: column

\centering
\includegraphics[width=\textwidth]{images/flows/verification_phase_2.eps}

::::
:::: column

\only<2>{
  \begin{itemize}
    \item \scriptsize Next we map the change in each characteristic, $\Delta c$ to a nominal scale for comparison:

      \scriptsize
      $$
      map(\Delta c)=\begin{cases}
      L & \mbox{if }\Delta c < 0\\
      E & \mbox{if }\Delta c = 0\\
      G & \mbox{if }\Delta c > 0
      \end{cases}
      $$

      Where $\Delta c$ is the difference between:
      \begin{itemize}
        \tiny
        \item \tiny Natural Evolution and Base Version
        \item \tiny Injected Evolution and Base Version
      \end{itemize}
  \end{itemize}
}

<!--
\only<3>{
  \begin{itemize}
    \item \scriptsize Finally, we compare these values for the Normal and Injected Evolutions
    \begin{enumerate}
      \item \tiny Across Each Characteristic (Side-by-Side): Evaluates injection process mirrors the natural process, using Cohen's $\kappa$ measure of agreement
      \item \tiny To Experimental results: to verify those results hold in real systems.
    \end{enumerate}
  \end{itemize}
}
-->

<!-- TODO add in analysis techniques (including cohen's kappa) -->

::::
:::

# Results

\vskip.85em

\scriptsize

\begin{table}[]
\centering
\begin{tabular}{l|cc|cc|cc|cc|cc|cc|cc|cc|}
\cline{2-17}
               & \multicolumn{16}{c|}{\textbf{Study Units}} \\ \cline{2-17}
               & \multicolumn{2}{c|}{\textit{\textbf{1 - State}}}      & \multicolumn{2}{c|}{\textit{\textbf{2 - State}}}      & \multicolumn{2}{c|}{\textit{\textbf{3 - Sngltn}}}     & \multicolumn{2}{c|}{\textit{\textbf{4 - Adapt}}}      & \multicolumn{2}{c|}{\textit{\textbf{5 - TM}}}         & \multicolumn{2}{c|}{\textit{\textbf{6 - TM}}}         & \multicolumn{2}{c|}{\textit{\textbf{7 - State}}}      & \multicolumn{2}{c|}{\textit{\textbf{8 - Sngltn}}}      \\
               & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              \\ \hline
\textbf{Ana}   & E & G & L & L & G & L & E & E & L & G & L & L & L & L & G & L \\
\textbf{Test}  & E & L & L & L & L & L & E & L & G & L & G & L & G & L & G & L \\
\textbf{Modul} & E & G & L & L & E & L & E & L & G & L & L & L & L & L & E & L \\
\textbf{Modif} & E & E & E & E & E & E & E & G & G & G & G & G & E & E & G & G \\
\textbf{Reuse} & E & G & G & G & G & L & E & L & G & L & G & L & L & L & L & L \\
\textbf{TDP}   & E & G & G & G & G & L & E & L & G & L & G & L & G & L & G & L \\
\textbf{TDI}   & E & G & G & G & G & L & E & L & G & L & G & L & G & L & G & L \\ \hline
\end{tabular}
\end{table}

# Results <!-- 2.5 Minutes (22.25 Minutes Total) -->

\vskip-1.5em

\begin{block}

\begin{center}
What is the agreement between natural and injection evolution?
\end{center}

\end{block}

\scriptsize

\begin{table}[]
\centering
\begin{tabular}{l|cc|cc|cc|cc|cc|cc|cc|cc|}
\cline{2-17}
               & \multicolumn{16}{c|}{\textbf{Study Units}} \\ \cline{2-17}
               & \multicolumn{2}{c|}{\textit{\textbf{1 - State}}}      & \multicolumn{2}{c|}{\textit{\textbf{2 - State}}}      & \multicolumn{2}{c|}{\textit{\textbf{3 - Sngltn}}}     & \multicolumn{2}{c|}{\textit{\textbf{4 - Adapt}}}      & \multicolumn{2}{c|}{\textit{\textbf{5 - TM}}}         & \multicolumn{2}{c|}{\textit{\textbf{6 - TM}}}         & \multicolumn{2}{c|}{\textit{\textbf{7 - State}}}      & \multicolumn{2}{c|}{\textit{\textbf{8 - Sngltn}}}      \\
               & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              \\ \hline
\textbf{Ana}   & E & G & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L & G & L & \cellcolor[HTML]{FFCCC9}E & \cellcolor[HTML]{FFCCC9}E & L & G & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L & G & L \\
\textbf{Test}  & E & L & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L & E                         & L & G                         & L & G                         & L & G                         & L & G                         & L \\
\textbf{Modul} & E                         & G & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L & E                         & L & E                         & L                         & G                         & L & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L & E                         & L \\
\textbf{Modif} & \cellcolor[HTML]{FFCCC9}E & \cellcolor[HTML]{FFCCC9}E & \cellcolor[HTML]{FFCCC9}E & \cellcolor[HTML]{FFCCC9}E & \cellcolor[HTML]{FFCCC9}E & \cellcolor[HTML]{FFCCC9}E & E & G                         & \cellcolor[HTML]{FFCCC9}G & \cellcolor[HTML]{FFCCC9}G & \cellcolor[HTML]{FFCCC9}G & \cellcolor[HTML]{FFCCC9}G & \cellcolor[HTML]{FFCCC9}E & \cellcolor[HTML]{FFCCC9}E & \cellcolor[HTML]{FFCCC9}G & \cellcolor[HTML]{FFCCC9}G \\
\textbf{Reuse} & E                         & G                         & \cellcolor[HTML]{FFCCC9}G & \cellcolor[HTML]{FFCCC9}G & G                         & L                         & E                         & L                         & G                         & L                         & G                         & L                         & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L & \cellcolor[HTML]{FFCCC9}L \\
\textbf{TDP}   & E                         & G & \cellcolor[HTML]{FFCCC9}G & \cellcolor[HTML]{FFCCC9}G & G & L                         & E                         & L                         & G & L                         & G & L                         & G                         & L & G & L                         \\
\textbf{TDI}   & E                         & G & \cellcolor[HTML]{FFCCC9}G & \cellcolor[HTML]{FFCCC9}G & G & L                         & E                         & L                         & G & L                         & G & L                         & G                         & L & G & L                         \\ \hline
\end{tabular}
\end{table}

\pause

\begin{table}[]
\centering
\begin{tabular}{r|ccccccc}
\cline{2-8}
          & \multicolumn{7}{c}{\textbf{Attribute}}                                                  \\ \cline{2-8}
          & Ana    & Test & Modul  & Modif                               & Reuse   & TDP    & TDI   \\ \hline
$\kappa$  & 0.16   & 0.0  & 0.048  & \cellcolor[HTML]{FFCCC9}0.75        & 0.091  & -0.077 & -0.077 \\
Agreement & Slight & None & Slight & \cellcolor[HTML]{FFCCC9}Substantial & Slight & None   & None   \\ \hline
\end{tabular}
\end{table}

# Results <!-- 2.5 Minutes (22.25 Minutes Total) -->

\vskip-1.5em

\begin{block}

\begin{center}
How does natural and injected evolution compare to experimental results?
\end{center}

\end{block}

\vskip-.5em

\scriptsize

\begin{table}[]
\centering
\begin{tabular}{l|cc|cc|cc|cc|cc|cc|cc|cc|}
\cline{2-17}
               & \multicolumn{16}{c|}{\textbf{Study Units}} \\ \cline{2-17}
               & \multicolumn{2}{c|}{\textit{\textbf{1 - State}}}      & \multicolumn{2}{c|}{\textit{\textbf{2 - State}}}      & \multicolumn{2}{c|}{\textit{\textbf{3 - Sngltn}}}     & \multicolumn{2}{c|}{\textit{\textbf{4 - Adapt}}}      & \multicolumn{2}{c|}{\textit{\textbf{5 - TM}}}         & \multicolumn{2}{c|}{\textit{\textbf{6 - TM}}}         & \multicolumn{2}{c|}{\textit{\textbf{7 - State}}}      & \multicolumn{2}{c|}{\textit{\textbf{8 - Sngltn}}}      \\
               & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              & \textit{Nat}              & \textit{Inj}              \\ \hline
\textbf{Ana}   & E                         & G                         & \cellcolor[HTML]{CAE8FC}L & \cellcolor[HTML]{CAE8FC}L & G                         & \cellcolor[HTML]{CAE8FC}L & E & E & \cellcolor[HTML]{CAE8FC}L & G                         & \cellcolor[HTML]{CAE8FC}L & \cellcolor[HTML]{CAE8FC}L & \cellcolor[HTML]{CAE8FC}L & \cellcolor[HTML]{CAE8FC}L & G                         & \cellcolor[HTML]{CAE8FC}L \\
\textbf{Test}  & E                         & \cellcolor[HTML]{CAE8FC}L & \cellcolor[HTML]{CAE8FC}L & \cellcolor[HTML]{CAE8FC}L & \cellcolor[HTML]{CAE8FC}L & \cellcolor[HTML]{CAE8FC}L & E                         & \cellcolor[HTML]{CAE8FC}L & G                         & \cellcolor[HTML]{CAE8FC}L & G                         & \cellcolor[HTML]{CAE8FC}L & G                         & \cellcolor[HTML]{CAE8FC}L & G                         & \cellcolor[HTML]{CAE8FC}L \\
\textbf{Modul} & E                         & \cellcolor[HTML]{CAE8FC}G & L & L & E                         & \cellcolor[HTML]{CAE8FC}L & E                         & L                         & G                         & \cellcolor[HTML]{CAE8FC}L & L & L & L & L & E                         & \cellcolor[HTML]{CAE8FC}L \\
\textbf{Modif} & \cellcolor[HTML]{CAE8FC}E & \cellcolor[HTML]{CAE8FC}E & \cellcolor[HTML]{CAE8FC}E & \cellcolor[HTML]{CAE8FC}E & \cellcolor[HTML]{CAE8FC}E & \cellcolor[HTML]{CAE8FC}E & \cellcolor[HTML]{CAE8FC}E & G                         & G & G & G & G & \cellcolor[HTML]{CAE8FC}E & \cellcolor[HTML]{CAE8FC}E & G & G \\
\textbf{Reuse} & E                         & G                         & G & G & G                         & L                         & E                         & L                         & G                         & L                         & G                         & L                         & L & L & L & L \\
\textbf{TDP}   & E                         & \cellcolor[HTML]{CAE8FC}G & G & G & \cellcolor[HTML]{CAE8FC}G & L                         & E                         & L                         & \cellcolor[HTML]{CAE8FC}G & L                         & \cellcolor[HTML]{CAE8FC}G & L                         & G                         & \cellcolor[HTML]{CAE8FC}L & \cellcolor[HTML]{CAE8FC}G & L                         \\
\textbf{TDI}   & E                         & \cellcolor[HTML]{CAE8FC}G & G & G & \cellcolor[HTML]{CAE8FC}G & L                         & E                         & L                         & \cellcolor[HTML]{CAE8FC}G & L                         & \cellcolor[HTML]{CAE8FC}G & L                         & G                         & \cellcolor[HTML]{CAE8FC}L & \cellcolor[HTML]{CAE8FC}G & L                         \\ \hline
\end{tabular}
\end{table}

\pause

* 39.583\% of the natural evolution results reflect the experimental results
* 52.083\% of the injected evolution results reflect the experimental results

<!-- TODO show results showing percentages of matching, also make sure the table is 100% correct -->

<!--
# Key Findings

\vskip-1.5em

* Modifiability:
  - Strong evidence to confirm the injection process matches natural evolution
  - Good evidence that the experimental results hold for Modifiability
* For all other attributes
  - There is a disconnect between the experimental and observed effects
  - There is a disconnect between natural and injected evolution
* Implications of these results
  - The use of the validation study has identified that there are underlying issues to be resolved
  - Provides validation for the overall method, but indicates that additional iterations are needed
-->

<!--
#

\centering
\vfill
\begin{minipage}{.45\textwidth}
\Huge \textcolor{MSUDkBlue}{Conclusions}
\vskip-0.75em
\textcolor{MSUAthleticGold}{\rule{\textwidth}{2pt}}

\large \color{MSUDkBlue}\textbf{\hfill Design Pattern Decay}
\end{minipage}
-->

# Impacts <!-- 1 Minute (23.25 Minutes Total) -->

\vskip-1.5em

::: columns
:::: column

\centering
\only<1>{
  \vskip3em
  \includegraphics[width=.95\textwidth]{images/quality/problem2.eps}
}
\only<2>{
  \vskip3em
  \includegraphics[width=.95\textwidth]{images/quality/problem3.eps}
}
\only<3->{\includegraphics[width=.95\textwidth]{images/method/overview.eps}}

::::
:::: column

\only<1>{
  \includegraphics[width=.95\textwidth]{images/quality/grime_tree2.eps}
}
\only<2>{
  \includegraphics[width=.95\textwidth]{images/quality/grime_tree4.eps}
}

\only<3->{
{\color<7->{AltGray}\textbf{\underline{Researchers}:}}

\begin{itemize}
  \tiny
  \item<3-> {\color<4->{AltGray}\tiny Presents a promising approach to explore and understand SE phenomena}
  %\begin{itemize}
  %  \scriptsize
  %  \item<2-> {\color<3->{AltGray}\scriptsize Other forms of TD}
  %  \item<2-> {\color<3->{AltGray}\scriptsize Security vulnerabilities}
  %  \item<2-> {\color<3->{AltGray}\scriptsize Build automation issues (among many others)}
  %\end{itemize}
  \item<4-> {\color<5->{AltGray}\tiny Bridge the gap between empirical methods allows a combination of results}
  \item<5-> {\color<6->{AltGray}\tiny Confirmed prior results concerning the effects of Modular Grime on Testability and TD Principal}
  \item<6-> {\color<7->{AltGray}\tiny Approach to inject and detect design pattern grime for experimental purposes}
\end{itemize}

\only<7->{\textbf{\underline{Practitioners}:}}

\begin{itemize}
  \tiny
  \item<7-> {\color<8->{AltGray}\tiny Open implementation of the SIG Maintainability Model}
  \item<9-> {\color<9->{AltGray}\tiny First known implementation of Nugroho et al.'s TD Measurements}
  \item<10-> \tiny \textbf{Modifyiability}: Specific grime types should be of concern for instances of the Decorator, Observer, Singleton, and Visitor patterns.
\end{itemize}
}

::::
:::

# Threats to Validity <!-- 1.5 Minutes (24.75 Minutes Total) -->

\vskip-1em

::: columns
:::: column

\footnotesize
<!--
\underline{\textbf{Internal Validity}}

* \scriptsize Experiments: No threats
* \scriptsize Validation Study: No threats
-->

\underline{\textbf{Construct Validity}}

\begin{itemize}
  \scriptsize
  \item \scriptsize Experiments and Validation Study:
  \begin{itemize}
    \tiny
    \item \tiny Use of modified SIG Maintainability model with linear projection during rating phase.
  \end{itemize}
  \item \scriptsize Validation Study:
  \begin{itemize}
    \tiny
    \item \tiny Assumption of accumulative changes in grime between versions
  \end{itemize}
\end{itemize}

\pause

\underline{\textbf{Content Validity}}

\begin{itemize}
  \scriptsize
  \item \scriptsize Experiments:
  \begin{itemize}
    \tiny
    \item \tiny Only covered 16 of the 23 GoF patterns
  \end{itemize}
\end{itemize}

::::
:::: column

\pause

\footnotesize
\underline{\textbf{External Validity}}

\begin{itemize}
  \scriptsize
  \item \scriptsize Experiments:
  \begin{itemize}
    \tiny
    \item \tiny Injection used generated rather than real systems
    \item \tiny Does not account for Behavioral or Unknown types of grime
    \item \tiny Only analyzed the Java language
  \end{itemize}
  \item \scriptsize Validation Study:
  \begin{itemize}
    \tiny
    \item \tiny Only Open-Source Java Software Systems
    \item \tiny Small sample size
    \item \tiny Limited coverage of grime types
    \item \tiny Limited coverage of pattern types
  \end{itemize}
\end{itemize}

::::
:::

<!-- 0.5 Minutes (25.25 Minutes) -->
<!--
# Accomplishments

\vskip-1em

* Developed Empirical Method to study SE Phenomena, and validated (partially) through:
  - Implementation of the Arc Framework
  - Taxonomy Development for both Class and Organizational Grime
  - Grime Injection Experiments to evaluate the impact of Grime on Maintainability and TD
  - Validation Study Approach to validate experimental results
* Developed the following:
  - Software Injection Approach for Design Disharmonies
  - Automated Detection for Design Pattern Grime
  - First known implementation of Nugroho et al.'s approach to estimating TD Principal and Interest
  - Approach to combining multiple empirical methods in a consistent and repeatable manner
-->

# Related Publications <!-- 1.25 Minutes but 1 Minute with tight talking points (26.5 Minutes Total) -->

\vskip-1em

\scriptsize
\begin{itemize}
  \item<1-> {\color<2->{AltGray} Manuscript in progress.}
  \item<2-> {\color<3->{AltGray} Taxonomies}
  \begin{itemize}
    \tiny
    \item<2-> {\color<3->{AltGray} \tiny Izurieta C., Reimanis D., \textbf{Griffith I.}, Schanz T., "Structural and Behavioral Taxonomies of Design Pattern Grime Evolution". In Proceedings of the 12th Seminar on Advanced Techniques \& Tools for Software Evolution, SATToSE 2019. Bolzano, Italy, July 8-10, 2019.}
  \end{itemize}

  \item<3-> {\color<4->{AltGray} Quality Modeling}
  \begin{itemize}
    \tiny
    \item<3-> {\color<4->{AltGray} \tiny \textbf{Griffith I.}, Izurieta C., Huvaere C., "An Industry Perspective to Comparing the SQALE and Quamoco Software Quality Models," 11th ACM-IEEE International Symposium on Empirical Software Engineering and Measurement, ESEM 2017, Toronto, Canada, November 9-10, 2017.​}
  \end{itemize}

  \item<4-> Technical Debt Measurement Implementation
  \begin{itemize}
    \tiny
    \item<4-> \tiny \textbf{Griffith I.}, Reimanis D., Izurieta C., Codabux Z., Deo A., and Williams B., "The Correspondence between Software Quality Models and Technical Debt Estimation Approaches". In Proceedings of the 6th International Workshop on Managing Technical Debt. Victoria, British Columbia, Canada, September 30, 2014.
  \end{itemize}
\end{itemize}

# Related Publications

\vskip-1em

\scriptsize

\begin{itemize}
  \item<1-> {\color<2->{AltGray} Software Injection and Initial Class Grime Taxonomy}
  \begin{itemize}
    \tiny
    \item<1-> {\color<2->{AltGray} \tiny \textbf{Griffith I.} and Izurieta C., "Design Pattern Decay: The Case for Class Grime". In Proceedings of the 8th International Symposium on Empirical Software Engineering and Measurement. Torino, Italy, September 18–19, 2014.}
  \end{itemize}

  \item<2-> {\color<3->{AltGray} The Overall Method}
  \begin{itemize}
    \tiny
    \item<2-> {\color<3->{AltGray} \tiny \textbf{Griffith I.} and Izurieta C., "Design Pattern Decay: An Extended Taxonomy and Empirical Study of Grime and its Impact on Design Pattern Evolution". The 11th International Doctoral Symposium on Empirical Software Engineering. Baltimore, Maryland, October 9, 2013.}
  \end{itemize}

  \item<3-> Arc Data Model and Metrics
  \begin{itemize}
    \tiny
    \item<3-> \tiny \textbf{Griffith I.}, Wahl S., and Izurieta C., "Evolution of Legacy System Comprehensibility through Automated Refactoring". In Proceedings of IEEE ACM MALETS 2011 International Workshop on Machine Learning Technologies in Software Engineering. In association with the 26th International Conference on Automated Software Engineering, ASE 2011. Lawrence, Kansas, November 7–12, 2011.
    \item<3-> \tiny \textbf{Griffith I.}, Wahl S., and Izurieta C., "TrueRefactor: An Automated Refactoring Tool to Improve Legacy System and Application Comprehensibility". In Proceedings of ISCA 24th International Conference on Computer Applications in Industry and Engineering, CAINE ’11. Honolulu, Hawaii, November 2011.
  \end{itemize}
\end{itemize}
<!--
#

\centering
\vfill
\begin{minipage}{.45\textwidth}
\Huge \textcolor{MSUDkBlue}{Future Work}
\vskip-0.75em
\textcolor{MSUAthleticGold}{\rule{\textwidth}{2pt}}

\large \color{MSUDkBlue}\textbf{\hfill Design Pattern Decay}
\end{minipage}
-->

# Future Work <!-- 1.25 Minutes but 1 Minute with tight talking points (27.75 minutes) -->

\vskip-1em

::: columns
:::: column

\color<4->{AltGray}\textbf{\underline{Short-term}:}

\begin{itemize}
  \scriptsize
  \item<1-> {\color<3->{AltGray}\scriptsize Identification and correction of the underlying issues leading to the results of the verification study}
  \begin{itemize}
    \tiny
    \item<2-> {\color<3->{AltGray}\tiny Improve Taxonomy Definitions (if needed)}
    \item<2-> {\color<3->{AltGray}\tiny Improve Injection Strategies and Process}
    \item<2-> {\color<3->{AltGray}\tiny Re-execute Phase 02 and 03 Studies}
  \end{itemize}
  % \item<3-> {\color<5->{AltGray}\scriptsize Execution of Phase 04 (multiple-case) and Phase 05 (longitudinal) case studies}
  % \begin{itemize}
    % \tiny
    % \item<4-> {\color<5->{AltGray}\tiny Exploring grime evolution}
    % \item<4-> {\color<5->{AltGray}\tiny Exploring grime propagation}
    % \item<4-> {\color<5->{AltGray}\tiny Exploring grime type relationships}
  % \end{itemize}
\end{itemize}

<!--
\scriptsize
* Use predictive modeling and machine Learning to improve Taxonomies, Injection Strategies and Detection Strategies
-->

::::
:::: column

\only<4->{
  \textbf{\underline{Long-term}:}

  \centering
  \includegraphics[width=.75\textwidth]{images/conclude/future_work.eps}
}

::::
:::

# Thank You! <!-- 0.25 Minutes (28 Minutes Total) -->

\centering
\includegraphics[scale=.39]{images/questions.png}

\Huge \textbf{Are there any questions?}
