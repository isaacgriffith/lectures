---
author:
- Dr. Isaac Griffith
title: Relations
course: CS 1187
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Outline

The lecture is structured as follows:

::: columns
:::: {.column width=.7}
* Closures of Relations
* Equivalence Relations
* Partial Orderings
::::
:::: {.column width=.25}
\vfill
\vspace{7.25em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\ts{Closures of Relations}

# Relational Closures

* Three types we will study
  * Reflexive -> Easy
  * Symmetric -> Easy
  * Transitive -> Hard

# Reflexive Closure

* Consider a relation R depicted in the digraph.
  * Note that it is not reflexive

::: columns
:::: column

* We want to add edges to make the relation reflexive

\vskip.5em

* By adding those edges, we have made a non-reflexive relation $R$ into a reflexive relation

\vskip.5em

* This new relation is called the **reflexive closure** on $R$

::::
:::: column

\only<1>{
\vspace{-1em}
\centering
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {};
\node[main] (2) [above of=1] {};
\node[main] (3) [above of=2] {};
\node[main] (4) [below right of=3] {};
\node[main] (5) [below right of=4] {};
\node[main] (6) [above of=5] {};
\node[main] (7) [above of=6] {};

\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to (7);

\end{tikzpicture}
}

\only<2>{
\vspace{-1em}
\centering
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {};
\node[main] (2) [above of=1] {};
\node[main] (3) [above of=2] {};
\node[main] (4) [below right of=3] {};
\node[main] (5) [below right of=4] {};
\node[main] (6) [above of=5] {};
\node[main] (7) [above of=6] {};

\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to (7);

\draw [-Latex, line width=0.25mm, FireOpal] (1) to [out=105, in=195, looseness=8] (1);
\draw [-Latex, line width=0.25mm, FireOpal] (2) to [out=105, in=195, looseness=8] (2);
\draw [-Latex, line width=0.25mm, FireOpal] (3) to [out=105, in=195, looseness=8] (3);
\draw [-Latex, line width=0.25mm, FireOpal] (4) to [out=195, in=285, looseness=8] (4);
\draw [-Latex, line width=0.25mm, FireOpal] (5) to [out=15, in=285, looseness=8] (5);
\draw [-Latex, line width=0.25mm, FireOpal] (6) to [out=15, in=285, looseness=8] (6);
\draw [-Latex, line width=0.25mm, FireOpal] (7) to [out=15, in=285, looseness=8] (7);

\end{tikzpicture}
}

::::
:::

# Reflexive Closure

* In order to find the reflexive closure of a relation $R$, we add a loop at each node that does not have one

\vskip.5em

* The reflexive closure of $R$ is $R \cup \Delta$
  * Where $\Delta = \{(a, a)\, |\, a \in R\}$
    * Called the *"Diagonal Relation"*
  * With matrices, we set the diagonal to all 1's

# Symmetric Closure

* Consider a relation $R$ depicted in the digraph
  * Note that it is not symmetric

::: columns
:::: column

* We want to add edge to make the relation symmetric

\vskip.5em

* By adding those edges, we have made a non-symmetric relation $R$ into a symmetric relation

\vskip.5em

* This new relation is called the **symmetric closure** of $R$

::::
:::: column

\only<1>{
\vspace{-1em}
\centering
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {};
\node[main] (2) [above of=1] {};
\node[main] (3) [above of=2] {};
\node[main] (4) [below right of=3] {};
\node[main] (5) [below right of=4] {};
\node[main] (6) [above of=5] {};
\node[main] (7) [above of=6] {};

\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to (7);

\end{tikzpicture}
}

\only<2>{
\vspace{-1em}
\centering
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {};
\node[main] (2) [above of=1] {};
\node[main] (3) [above of=2] {};
\node[main] (4) [below right of=3] {};
\node[main] (5) [below right of=4] {};
\node[main] (6) [above of=5] {};
\node[main] (7) [above of=6] {};

\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to (7);

\draw [-Latex, line width=0.25mm, FireOpal] (4) to [out=195, in=285, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, FireOpal] (5) to [out=195, in=285, looseness=1.25] (4);
\draw [-Latex, line width=0.25mm, FireOpal] (6) to [out=345, in=15, looseness=1.25] (5);
\draw [-Latex, line width=0.25mm, FireOpal] (7) to [out=345, in=15, looseness=1.25] (6);

\end{tikzpicture}
}
::::
:::


# Symmetric Closure

* In order to find the symmetric closure of a relation $R$, we add an edge from $a$ to $b$, where there is already an edge from $b$ to $a$

\vskip.5em

* The symmetric closure of $R$ is $R \cup R^{-1}$
  * If $R = \{(a,b)\,|\, \ldots\}$
  * Then $R^{-1} = \{(b, a)\,|\,(a,b) \in R\}$

# Paths in Directed Graphs

* A *path* is a sequence of connected edges from vertex $a$ to vertex $b$

::: columns
:::: {.column width=.333}

\begin{itemize}
\item<8-> No path exists from the noted start location
\item<9-> A path that starts and ends at the same vertex is called a \textit{circuit} or \textit{cycle}
\begin{itemize}
  \item<11-> Must have length $\geq 1$
\end{itemize}
\end{itemize}

::::
:::: {.column width=.667}

\only<2,9>{
\vspace{-1em}
\centering
\hspace{-2em}
\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {};
\node[main] (2) [above of=1] {};
\node[main] (3) [above of=2] {};
\node[main] (4) [above of=3] {};
\node[main] (5) [above of=4] {};
\node[main] (6) [above of=5] {};
\node[main] (7) [right of=6] {};
\node[main] (8) [below of=7] {};

\node[main] (9) [right of=7] {};
\node[main] (10) [below of=9] {};
\node[main] (11) [below of=10] {};
\node[main] (12) [below of=11] {};
\node[main] (13) [below of=12] {};
\node[main] (14) [below of=13] {};
\node[main] (15) [right of=9] {};
\node[main] (16) [below of=15] {};
\node[main] (17) [right of=15] {};
\node[main] (18) [below of=17] {};
\node[main] (19) [below of=18] {};
\node[main] (20) [below of=19] {};
\node[main] (21) [below of=20] {};
\node[main] (22) [left of=21] {};
\node[main] (23) [right of=17] {};
\node[main] (24) [above of=23] {};
\node[main] (25) [right of=20] {};
\node[main] (26) [below of=25] {};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (14) to (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (13) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (11) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to (11);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (11) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (12) to (13);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (13) to (14);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (18) to (17);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (19) to (18);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (20) to (19);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (21) to (20);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (21) to (22);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (22) to (13);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (12) to (20);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (19) to (11);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (23) to (24);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (20) to (25);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (25) to (26);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (26) to (21);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=105, in=255, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=285, in=75, looseness=1.25] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=105, in=255, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=285, in=75, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=105, in=255, looseness=1.25] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=285, in=75, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=105, in=255, looseness=1.25] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=285, in=75, looseness=1.25] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=105, in=255, looseness=1.25] (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=285, in=75, looseness=1.25] (5);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=15, in=165, looseness=1.25] (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (7) to [out=195, in=345, looseness=1.25] (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=15, in=165, looseness=1.25] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to [out=195, in=345, looseness=1.25] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (7) to [out=15, in=165, looseness=1.25] (9);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to [out=195, in=345, looseness=1.25] (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to [out=15, in=165, looseness=1.25] (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to [out=195, in=345, looseness=1.25] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to [out=15, in=165, looseness=1.25] (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (15) to [out=195, in=345, looseness=1.25] (9);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to [out=15, in=165, looseness=1.25] (16);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to [out=195, in=345, looseness=1.25] (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (15) to [out=15, in=165, looseness=1.25] (17);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (17) to [out=195, in=345, looseness=1.25] (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to [out=15, in=165, looseness=1.25] (18);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (18) to [out=195, in=345, looseness=1.25] (16);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (17) to [out=15, in=165, looseness=1.25] (23);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (23) to [out=195, in=345, looseness=1.25] (17);

\end{tikzpicture}
}

\only<3,5>{
\vspace{-1em}
\centering
\hspace{-2em}
\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {};
\node[main] (2) [above of=1] {};
\node[main] (3) [above of=2] {};
\node[main] (4) [above of=3] {};
\node[main] (5) [above of=4] {};
\node[main] (6) [above of=5] {};
\node[main] (7) [right of=6] {};
\node[main] (8) [below of=7] {};

\node[main] (9) [right of=7] {};
\node[main] (10) [below of=9] {};
\node[main] (11) [below of=10] {};
\node[main] (12) [below of=11] {};
\node[main] (13) [below of=12] {};
\node[main] (14) [below of=13] {};
\node[main] (15) [right of=9] {};
\node[main] (16) [below of=15] {};
\node[main] (17) [right of=15] {};
\node[main] (18) [below of=17] {};
\node[main] (19) [below of=18] {};
\node[main] (20) [below of=19] {};
\node[main] (21) [below of=20] {};
\node[main] (22) [left of=21] {};
\node[main] (23) [right of=17] {};
\node[main] (24) [above of=23] {};
\node[main] (25) [right of=20] {};
\node[main] (26) [below of=25] {};

\node[FireOpal] (27) at (-2,0) {Start ($a$)};
\node[FireOpal] (28) [below right of=23] {End ($b$)};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (14) to (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (13) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (11) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to (11);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (11) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (12) to (13);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (13) to (14);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (18) to (17);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (19) to (18);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (20) to (19);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (21) to (20);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (21) to (22);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (22) to (13);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (12) to (20);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (19) to (11);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (23) to (24);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (20) to (25);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (25) to (26);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (26) to (21);

\draw [-Latex, line width=0.25mm, FireOpal] (27) to (1);
\draw [-Latex, line width=0.25mm, FireOpal] (18) to (28);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=105, in=255, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=285, in=75, looseness=1.25] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=105, in=255, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=285, in=75, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=105, in=255, looseness=1.25] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=285, in=75, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=105, in=255, looseness=1.25] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=285, in=75, looseness=1.25] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=105, in=255, looseness=1.25] (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=285, in=75, looseness=1.25] (5);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=15, in=165, looseness=1.25] (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (7) to [out=195, in=345, looseness=1.25] (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=15, in=165, looseness=1.25] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to [out=195, in=345, looseness=1.25] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (7) to [out=15, in=165, looseness=1.25] (9);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to [out=195, in=345, looseness=1.25] (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to [out=15, in=165, looseness=1.25] (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to [out=195, in=345, looseness=1.25] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to [out=15, in=165, looseness=1.25] (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (15) to [out=195, in=345, looseness=1.25] (9);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to [out=15, in=165, looseness=1.25] (16);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to [out=195, in=345, looseness=1.25] (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (15) to [out=15, in=165, looseness=1.25] (17);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (17) to [out=195, in=345, looseness=1.25] (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to [out=15, in=165, looseness=1.25] (18);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (18) to [out=195, in=345, looseness=1.25] (16);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (17) to [out=15, in=165, looseness=1.25] (23);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (23) to [out=195, in=345, looseness=1.25] (17);

\end{tikzpicture}
}

\only<4>{
\vspace{-1em}
\centering
\hspace{-2em}
\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {};
\node[main] (2) [above of=1] {};
\node[main] (3) [above of=2] {};
\node[main] (4) [above of=3] {};
\node[main] (5) [above of=4] {};
\node[main] (6) [above of=5] {};
\node[main] (7) [right of=6] {};
\node[main] (8) [below of=7] {};

\node[main] (9) [right of=7] {};
\node[main] (10) [below of=9] {};
\node[main] (11) [below of=10] {};
\node[main] (12) [below of=11] {};
\node[main] (13) [below of=12] {};
\node[main] (14) [below of=13] {};
\node[main] (15) [right of=9] {};
\node[main] (16) [below of=15] {};
\node[main] (17) [right of=15] {};
\node[main] (18) [below of=17] {};
\node[main] (19) [below of=18] {};
\node[main] (20) [below of=19] {};
\node[main] (21) [below of=20] {};
\node[main] (22) [left of=21] {};
\node[main] (23) [right of=17] {};
\node[main] (24) [above of=23] {};
\node[main] (25) [right of=20] {};
\node[main] (26) [below of=25] {};

\node[FireOpal] (27) at (-2,0) {Start ($a$)};
\node[FireOpal] (28) [below right of=23] {End ($b$)};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (14) to (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (13) to (2);
\draw [-Latex, line width=0.25mm, FireOpal] (3) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (11) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to (11);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (11) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (12) to (13);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (13) to (14);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (18) to (17);
\draw [-Latex, line width=0.25mm, FireOpal] (19) to (18);
\draw [-Latex, line width=0.25mm, FireOpal] (20) to (19);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (21) to (20);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (21) to (22);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (22) to (13);
\draw [-Latex, line width=0.25mm, FireOpal] (12) to (20);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (19) to (11);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (23) to (24);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (20) to (25);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (25) to (26);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (26) to (21);

\draw [-Latex, line width=0.25mm, FireOpal] (27) to (1);
\draw [-Latex, line width=0.25mm, FireOpal] (18) to (28);

\draw [-Latex, line width=0.25mm, FireOpal] (1) to [out=105, in=255, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=285, in=75, looseness=1.25] (1);
\draw [-Latex, line width=0.25mm, FireOpal] (2) to [out=105, in=255, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=285, in=75, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=105, in=255, looseness=1.25] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=285, in=75, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=105, in=255, looseness=1.25] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=285, in=75, looseness=1.25] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=105, in=255, looseness=1.25] (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=285, in=75, looseness=1.25] (5);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=15, in=165, looseness=1.25] (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (7) to [out=195, in=345, looseness=1.25] (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=15, in=165, looseness=1.25] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to [out=195, in=345, looseness=1.25] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (7) to [out=15, in=165, looseness=1.25] (9);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to [out=195, in=345, looseness=1.25] (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to [out=15, in=165, looseness=1.25] (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to [out=195, in=345, looseness=1.25] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to [out=15, in=165, looseness=1.25] (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (15) to [out=195, in=345, looseness=1.25] (9);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to [out=15, in=165, looseness=1.25] (16);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to [out=195, in=345, looseness=1.25] (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (15) to [out=15, in=165, looseness=1.25] (17);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (17) to [out=195, in=345, looseness=1.25] (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to [out=15, in=165, looseness=1.25] (18);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (18) to [out=195, in=345, looseness=1.25] (16);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (17) to [out=15, in=165, looseness=1.25] (23);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (23) to [out=195, in=345, looseness=1.25] (17);

\end{tikzpicture}
}

\only<6>{
\vspace{-1em}
\centering
\hspace{-2em}
\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {};
\node[main] (2) [above of=1] {};
\node[main] (3) [above of=2] {};
\node[main] (4) [above of=3] {};
\node[main] (5) [above of=4] {};
\node[main] (6) [above of=5] {};
\node[main] (7) [right of=6] {};
\node[main] (8) [below of=7] {};

\node[main] (9) [right of=7] {};
\node[main] (10) [below of=9] {};
\node[main] (11) [below of=10] {};
\node[main] (12) [below of=11] {};
\node[main] (13) [below of=12] {};
\node[main] (14) [below of=13] {};
\node[main] (15) [right of=9] {};
\node[main] (16) [below of=15] {};
\node[main] (17) [right of=15] {};
\node[main] (18) [below of=17] {};
\node[main] (19) [below of=18] {};
\node[main] (20) [below of=19] {};
\node[main] (21) [below of=20] {};
\node[main] (22) [left of=21] {};
\node[main] (23) [right of=17] {};
\node[main] (24) [above of=23] {};
\node[main] (25) [right of=20] {};
\node[main] (26) [below of=25] {};

\node[FireOpal] (27) at (-2,0) {Start ($a$)};
\node[FireOpal] (28) [below right of=23] {End ($b$)};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (14) to (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (13) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (11) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to (11);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (11) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (12) to (13);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (13) to (14);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (18) to (17);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (19) to (18);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (20) to (19);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (21) to (20);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (21) to (22);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (22) to (13);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (12) to (20);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (19) to (11);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (23) to (24);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (20) to (25);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (25) to (26);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (26) to (21);

\draw [-Latex, line width=0.25mm, FireOpal] (27) to (1);
\draw [-Latex, line width=0.25mm, FireOpal] (18) to (28);

\draw [-Latex, line width=0.25mm, FireOpal] (1) to [out=105, in=255, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=285, in=75, looseness=1.25] (1);
\draw [-Latex, line width=0.25mm, FireOpal] (2) to [out=105, in=255, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=285, in=75, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, FireOpal] (3) to [out=105, in=255, looseness=1.25] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=285, in=75, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, FireOpal] (4) to [out=105, in=255, looseness=1.25] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=285, in=75, looseness=1.25] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=105, in=255, looseness=1.25] (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=285, in=75, looseness=1.25] (5);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=15, in=165, looseness=1.25] (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (7) to [out=195, in=345, looseness=1.25] (6);
\draw [-Latex, line width=0.25mm, FireOpal] (5) to [out=15, in=165, looseness=1.25] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to [out=195, in=345, looseness=1.25] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (7) to [out=15, in=165, looseness=1.25] (9);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to [out=195, in=345, looseness=1.25] (7);
\draw [-Latex, line width=0.25mm, FireOpal] (8) to [out=15, in=165, looseness=1.25] (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to [out=195, in=345, looseness=1.25] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to [out=15, in=165, looseness=1.25] (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (15) to [out=195, in=345, looseness=1.25] (9);
\draw [-Latex, line width=0.25mm, FireOpal] (10) to [out=15, in=165, looseness=1.25] (16);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to [out=195, in=345, looseness=1.25] (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (15) to [out=15, in=165, looseness=1.25] (17);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (17) to [out=195, in=345, looseness=1.25] (15);
\draw [-Latex, line width=0.25mm, FireOpal] (16) to [out=15, in=165, looseness=1.25] (18);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (18) to [out=195, in=345, looseness=1.25] (16);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (17) to [out=15, in=165, looseness=1.25] (23);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (23) to [out=195, in=345, looseness=1.25] (17);

\end{tikzpicture}
}

\only<7,8>{
\vspace{-1em}
\centering
\hspace{-2em}
\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {};
\node[main] (2) [above of=1] {};
\node[main] (3) [above of=2] {};
\node[main] (4) [above of=3] {};
\node[main] (5) [above of=4] {};
\node[main] (6) [above of=5] {};
\node[main] (7) [right of=6] {};
\node[main] (8) [below of=7] {};

\node[main] (9) [right of=7] {};
\node[main] (10) [below of=9] {};
\node[main] (11) [below of=10] {};
\node[main] (12) [below of=11] {};
\node[main] (13) [below of=12] {};
\node[main] (14) [below of=13] {};
\node[main] (15) [right of=9] {};
\node[main] (16) [below of=15] {};
\node[main] (17) [right of=15] {};
\node[main] (18) [below of=17] {};
\node[main] (19) [below of=18] {};
\node[main] (20) [below of=19] {};
\node[main] (21) [below of=20] {};
\node[main] (22) [left of=21] {};
\node[main] (23) [right of=17] {};
\node[main] (24) [above of=23] {};
\node[main] (25) [right of=20] {};
\node[main] (26) [below of=25] {};

\node[FireOpal] (27) [below right of=24] {Start ($a$)};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (14) to (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (13) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (11) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to (11);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (11) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (12) to (13);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (13) to (14);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (18) to (17);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (19) to (18);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (20) to (19);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (21) to (20);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (21) to (22);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (22) to (13);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (12) to (20);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (19) to (11);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (23) to (24);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (20) to (25);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (25) to (26);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (26) to (21);

\draw [-Latex, line width=0.25mm, FireOpal] (27) to (24);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=105, in=255, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=285, in=75, looseness=1.25] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=105, in=255, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=285, in=75, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=105, in=255, looseness=1.25] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=285, in=75, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=105, in=255, looseness=1.25] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=285, in=75, looseness=1.25] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=105, in=255, looseness=1.25] (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=285, in=75, looseness=1.25] (5);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=15, in=165, looseness=1.25] (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (7) to [out=195, in=345, looseness=1.25] (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=15, in=165, looseness=1.25] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to [out=195, in=345, looseness=1.25] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (7) to [out=15, in=165, looseness=1.25] (9);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to [out=195, in=345, looseness=1.25] (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to [out=15, in=165, looseness=1.25] (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to [out=195, in=345, looseness=1.25] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to [out=15, in=165, looseness=1.25] (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (15) to [out=195, in=345, looseness=1.25] (9);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to [out=15, in=165, looseness=1.25] (16);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to [out=195, in=345, looseness=1.25] (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (15) to [out=15, in=165, looseness=1.25] (17);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (17) to [out=195, in=345, looseness=1.25] (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to [out=15, in=165, looseness=1.25] (18);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (18) to [out=195, in=345, looseness=1.25] (16);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (17) to [out=15, in=165, looseness=1.25] (23);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (23) to [out=195, in=345, looseness=1.25] (17);

\end{tikzpicture}
}

\only<10,11>{
\vspace{-1em}
\centering
\hspace{-2em}
\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {};
\node[main] (2) [above of=1] {};
\node[main] (3) [above of=2] {};
\node[main] (4) [above of=3] {};
\node[main] (5) [above of=4] {};
\node[main] (6) [above of=5] {};
\node[main] (7) [right of=6] {};
\node[main] (8) [below of=7] {};

\node[main] (9) [right of=7] {};
\node[main] (10) [below of=9] {};
\node[main] (11) [below of=10] {};
\node[main] (12) [below of=11] {};
\node[main] (13) [below of=12] {};
\node[main] (14) [below of=13] {};
\node[main] (15) [right of=9] {};
\node[main] (16) [below of=15] {};
\node[main] (17) [right of=15] {};
\node[main] (18) [below of=17] {};
\node[main] (19) [below of=18] {};
\node[main] (20) [below of=19] {};
\node[main] (21) [below of=20] {};
\node[main] (22) [left of=21] {};
\node[main] (23) [right of=17] {};
\node[main] (24) [above of=23] {};
\node[main] (25) [right of=20] {};
\node[main] (26) [below of=25] {};

\node[FireOpal] (27) at (5.5,3) {Start ($a$)};
\node[FireOpal] (28) at (5.45,2.6) {End ($b$)};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (14) to (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (13) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (11) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to (11);
\draw [-Latex, line width=0.25mm, FireOpal] (11) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (12) to (13);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (13) to (14);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (18) to (17);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (19) to (18);
\draw [-Latex, line width=0.25mm, FireOpal] (20) to (19);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (21) to (20);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (21) to (22);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (22) to (13);
\draw [-Latex, line width=0.25mm, FireOpal] (12) to (20);
\draw [-Latex, line width=0.25mm, FireOpal] (19) to (11);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (23) to (24);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (20) to (25);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (25) to (26);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (26) to (21);

\draw [-Latex, line width=0.25mm, FireOpal] (27) to (19);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=105, in=255, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=285, in=75, looseness=1.25] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=105, in=255, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=285, in=75, looseness=1.25] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=105, in=255, looseness=1.25] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=285, in=75, looseness=1.25] (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=105, in=255, looseness=1.25] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=285, in=75, looseness=1.25] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=105, in=255, looseness=1.25] (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=285, in=75, looseness=1.25] (5);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=15, in=165, looseness=1.25] (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (7) to [out=195, in=345, looseness=1.25] (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=15, in=165, looseness=1.25] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to [out=195, in=345, looseness=1.25] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (7) to [out=15, in=165, looseness=1.25] (9);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to [out=195, in=345, looseness=1.25] (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to [out=15, in=165, looseness=1.25] (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to [out=195, in=345, looseness=1.25] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to [out=15, in=165, looseness=1.25] (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (15) to [out=195, in=345, looseness=1.25] (9);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (10) to [out=15, in=165, looseness=1.25] (16);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to [out=195, in=345, looseness=1.25] (10);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (15) to [out=15, in=165, looseness=1.25] (17);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (17) to [out=195, in=345, looseness=1.25] (15);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (16) to [out=15, in=165, looseness=1.25] (18);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (18) to [out=195, in=345, looseness=1.25] (16);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (17) to [out=15, in=165, looseness=1.25] (23);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (23) to [out=195, in=345, looseness=1.25] (17);

\end{tikzpicture}
}

::::
:::

# More on Paths...

* The length of a path is the number of **edges** in the path, not the number of nodes

# Shortest Paths

* What is really needed in most applications is finding the shortest path between two vertices

::: columns
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/relations/shortest_path1.eps}

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/relations/shortest_path2.eps}

::::
:::

# Transitive Closure

\centering
\includegraphics[width=.6\textwidth]{images/relations/trans_closure.png}

The Transitive closure would contain edges between all nodes reachable by a path of any length.

# Transitive Closure

\begin{itemize}
\item<1-> Informal definition: If there is a path from $a$ to $b$, then there should be an edge from $a$ to $b$ in the transitive closure
\item<2-> First take of a definition:
\begin{itemize}
  \item<3-> In order to find the transitive closure of a relation $R$, we add an edge from $a$ to $c$, when there are edges from $a$ to $b$ and $b$ to $c$
\end{itemize}
\item<10-> But there is a path from 1 to 4 with no edge!
\end{itemize}

::: columns
:::: column

\centering

\only<4->{
$$R = \{(1,2),(2,3),(3,4)\}$$
}

\only<5->{
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {1};
\node[main] (2) [right of=1] {2};
\node[main] (3) [right of=2] {3};
\node[main] (4) [above of=3] {4};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);
\end{tikzpicture}
}

::::
:::: column

\only<6->{
\begin{equation*}
(1,2)\,\, \&\,\, (2,3) \Rightarrow (1,3)
\end{equation*}
}

\only<8->{
\begin{equation*}
(2,3)\,\, \&\,\, (3,4) \Rightarrow (2,4)
\end{equation*}
}

\centering

\only<5,6>{
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {1};
\node[main] (2) [right of=1] {2};
\node[main] (3) [right of=2] {3};
\node[main] (4) [above of=3] {4};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);
\end{tikzpicture}
}

\only<7,8>{
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {1};
\node[main] (2) [right of=1] {2};
\node[main] (3) [right of=2] {3};
\node[main] (4) [above of=3] {4};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);

\draw [-Latex, line width=0.25mm, FireOpal] (1) to [out=345, in=195, looseness=1.95] (3);
\end{tikzpicture}
}

\only<9,10>{
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {1};
\node[main] (2) [right of=1] {2};
\node[main] (3) [right of=2] {3};
\node[main] (4) [above of=3] {4};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);
\draw [-Latex, line width=0.25mm, FireOpal] (2) to (4);

\draw [-Latex, line width=0.25mm, FireOpal] (1) to [out=345, in=195, looseness=1.95] (3);
\end{tikzpicture}
}

\only<11>{
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {1};
\node[main] (2) [right of=1] {2};
\node[main] (3) [right of=2] {3};
\node[main] (4) [above of=3] {4};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);
\draw [-Latex, line width=0.25mm, FireOpal] (2) to (4);

\draw [-Latex, line width=0.25mm, FireOpal] (1) to [out=345, in=195, looseness=1.95] (3);

\draw[Olivine, line width=0.25mm] (0, 0) circle(4mm);
\draw[Olivine, line width=0.25mm] (3, 1.5) circle(4mm);

\end{tikzpicture}
}

::::
:::

# Transitive Closure

\begin{itemize}
\item<1-> Informal definition: If there is a path from $a$ to $b$, then there should be an edge from $a$ to $b$ in the transitive closure
\vskip.5em
\item<2-> Second take of a definition:
\begin{itemize}
  \item<3-> In order to find the transitive closure of a relation $R$, we add an edge from $a$ to $c$, when there are edges from $a$ to $b$ and $b$ to $c$
  \item<4-> Repeat this step until no new edges are added to the relation
\end{itemize}
\vskip.5em
\item<8-> We will study different algorithms for determining the transitive closure
\end{itemize}

::: columns
:::: column

\begin{itemize}
\item<6-> {\bfseries \textcolor{FireOpal}{FireOpal}} means added on the first repeat
\vskip.5em
\item<7-> {\bfseries \textcolor{Olivine}{Olivine}} means added on the second repeat
\end{itemize}

::::
:::: column

\centering
\only<5>{
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {1};
\node[main] (2) [right of=1] {2};
\node[main] (3) [right of=2] {3};
\node[main] (4) [above of=3] {4};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);
\end{tikzpicture}
}

\only<6>{
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {1};
\node[main] (2) [right of=1] {2};
\node[main] (3) [right of=2] {3};
\node[main] (4) [above of=3] {4};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);
\draw [-Latex, line width=0.25mm, FireOpal] (2) to (4);

\draw [-Latex, line width=0.25mm, FireOpal] (1) to [out=345, in=195, looseness=1.25] (3);
\end{tikzpicture}
}

\only<7->{
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {1};
\node[main] (2) [right of=1] {2};
\node[main] (3) [right of=2] {3};
\node[main] (4) [above of=3] {4};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);
\draw [-Latex, line width=0.25mm, FireOpal] (2) to (4);
\draw [-Latex, line width=0.25mm, Olivine] (1) to (4);

\draw [-Latex, line width=0.25mm, FireOpal] (1) to [out=345, in=195, looseness=1.25] (3);
\end{tikzpicture}
}

::::
:::

# 6 Degrees of Separation

* The idea that everybody in the world is connected by six degrees of separation
  * Where 1 degree of separation means you know (or have met) somebody else

\vskip.5em

* Let $R$ be a relation on the set of all people in the world
  * $\left(a,b\right) \in R$ if person $a$ has met person $b$

\vskip.5em

* So six degrees of separation for *any* two people $a$ and $g$ means
  * $\left(a,b\right),\, (b,c),\, (c,d),\, (d,e),\, (e,f),\, (f,g)$ are all in $R$

\vskip.5em

* Or, $\left(a,g\right) \in R^6$

# Connectivity Relation

* $R$ contains edges between all the nodes reachable via 1 edge

\vskip.5em

* $R \circ R = R^2$ contains edges between nodes that are reachable via 2 edges in $R$

\vskip.5em

* $R^2 \circ R = R^3$ contains edges between nodes that are reachable via 3 edges in $R$

\vskip.5em

* $R^n =$ contains edges between nodes that are reachable via $n$ edges in $R$

\vskip.5em

* $R^*$ contains edges between nodes that are reachable via any number of edges (i.e., via any path) in $R$
  * Rephrased: $R^*$ contains all the edges between nodes $a$ and $b$ when there is a path of length at least 1 between $a$ and $b$ in $R$

\vskip.5em

* $R^*$ is the transitive closure of $R$
  * The definition of a transitive closure is that there are edges between any nodes $\left(a,b\right)$ that contain a path between them.

# Star Closure

* $R^*$ is the star closure of relation $R$, and it is defined as

  $$R^* = \underset{k = 1}{\overset{\infty}{\bigcup}}R^k$$

\vskip.5em

* **Definition:** The transitive closure of a relation $R$, $t(R)$, is the smallest transitive relation containing $R$.

\vskip.5em

* **Theorem:** $t(R) = R^*$

# Finding the Transitive Closure

* Let $\mathbf{M}_R$ be the zero-one matrix of the relation $R$ on a set with $n$ elements. Then the zero-one matrix of the transitive closure $R^*$ is:

  $$\mathbf{M}_{R^*} = \mathbf{M}_R \lor \mathbf{M}_R^{[2]} \lor \mathbf{M}_{R}^{[3]} \lor \ldots \lor \mathbf{M}_{R}^{[n]}$$

  Where:

  - $\mathbf{M}_{R}$ - Nodes reachable with one application of the relation
  - $\mathbf{M}_{R}^{[2]}$ - Nodes reachable with two applications of the relation
  - $\mathbf{M}_{R}^{[n]}$ - Nodes reachable with $n$ applications of the relation

# Example

* Find the zero-one matrix of the transitive closure of the relation $R$ given by:

::: columns
:::: {.column width=.333}

$$\mathbf{M}_R = \begin{bmatrix}
1 & 0 & 1 \\
0 & 1 & 0 \\
1 & 1 & 0
\end{bmatrix}$$

$$\mathbf{M}_{R^*} = \mathbf{M}_R \lor \mathbf{M}_R^{[2]} \mathbf{M}_R^{[3]}$$

::::
:::: {.column width=.333}

\vspace{-2em}
\begin{center}
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (3) {\footnotesize 3};
\node[main] (1) [above left of=3] {\footnotesize 1};
\node[main] (2) [above right of=3] {\footnotesize 2};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (3);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=165, in=285, looseness=1.25] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=135, in=225, looseness=5] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=45, in=315, looseness=5] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=225, in=315, looseness=5] (3);
\end{tikzpicture}
\end{center}

::::
:::: {.column width=.333}

\vspace{-2em}
\begin{center}
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (3) {\footnotesize 3};
\node[main] (1) [above left of=3] {\footnotesize 1};
\node[main] (2) [above right of=3] {\footnotesize 2};

\node[white] at (-2,.5) {$\mathbf{M}_R^{[2]}=$};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (3);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=165, in=285, looseness=1.25] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=135, in=225, looseness=5] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=45, in=315, looseness=5] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=225, in=315, looseness=5] (3);
\end{tikzpicture}
\end{center}

::::
:::

$$\mathbf{M}_R^{[2]} = \mathbf{M}_R \odot \mathbf{M}_R = \begin{bmatrix}
1 & 0 & 1 \\
0 & 1 & 0 \\
1 & 1 & 0
\end{bmatrix} \odot \begin{bmatrix}
1 & 0 & 1 \\
0 & 1 & 0 \\
1 & 1 & 0
\end{bmatrix} = \begin{bmatrix}
1 & 1 & 1 \\
0 & 1 & 0 \\
1 & 1 & 1
\end{bmatrix}$$

# Example

$$\mathbf{M}_R^{[3]} = \mathbf{M}_R^{[2]} \odot \mathbf{M}_R = \begin{bmatrix}
1 & 1 & 1 \\
0 & 1 & 0 \\
1 & 1 & 1
\end{bmatrix} \odot \begin{bmatrix}
1 & 0 & 1 \\
0 & 1 & 0 \\
1 & 1 & 0
\end{bmatrix} = \begin{bmatrix}
1 & 1 & 1 \\
0 & 1 & 0 \\
1 & 1 & 1
\end{bmatrix}$$

\vspace{-1em}

\begin{center}
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (3) {\footnotesize 3};
\node[main] (1) [above left of=3] {\footnotesize 1};
\node[main] (2) [above right of=3] {\footnotesize 2};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (3);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=165, in=285, looseness=1.25] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=135, in=225, looseness=5] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=45, in=315, looseness=5] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=225, in=315, looseness=5] (3);
\end{tikzpicture}
\end{center}

\vspace{-1em}

$$\mathbf{M}_R^{[3]} = \mathbf{M}_R^{[2]} \odot \mathbf{M}_R = \begin{bmatrix}
1 & 0 & 1 \\
0 & 1 & 0 \\
1 & 1 & 1
\end{bmatrix} \lor \begin{bmatrix}
1 & 1 & 1 \\
0 & 1 & 0 \\
1 & 1 & 1
\end{bmatrix} \lor \begin{bmatrix}
1 & 1 & 1 \\
0 & 1 & 0 \\
1 & 1 & 1
\end{bmatrix} = \begin{bmatrix}
1 & 1 & 1 \\
0 & 1 & 0 \\
1 & 1 & 1
\end{bmatrix}$$

# Transitive Closure Algorithm

* What we did (or rather, could have done):
  * Compute the next matrix $\mathbf{M}_R^{[i]}$, where $1 \leq i \leq n$
  * Do a Boolean join with the previously computed matrix

\vskip.5em

* For the example:
  * Compute $\mathbf{M}_R^{[2]} = \mathbf{M}_R \circ \mathbf{M}_R$
  * Join that with $\mathbf{M}_R$ to yield $\mathbf{M}_R \lor \mathbf{M}_R^{[2]}$
  * Compute $\mathbf{M}_R^{[3]} = \mathbf{M}_R^{[2]} \circ \mathbf{M}_R$
  * Join that with $\mathbf{M}_R \lor \mathbf{M}_R^{[2]}$ from above

# Transitive Closure Algorithm

\begin{algorithmic}
\Procedure{transitive\_closure}{$\mathbf{M}_R$: zero-one $n\times n$ matrix}
  \State $A \coloneqq \mathbf{M}_R$
  \State $B \coloneqq A$
  \For{$i \coloneqq 2$ \textbf{to} $n$}
    \State $A \coloneqq A \odot \mathbf{M}_R$
    \State $B \coloneqq B \lor A$
  \EndFor
  \State \Return $B$
\EndProcedure
\end{algorithmic}

* What is the time complexity? $O(n^4)$ bit operations due to the product and join operations within the loop

# Roy-Warshall Algorithm

* Uses only $O(n^3)$ bit operations

\begin{algorithmic}
\Procedure{Warshall}{$\mathbf{M}_R$: rank-$n$ 0-1 matrix}
  \State $W \coloneqq \mathbf{M}_R$
  \For{$k \coloneqq 1$ \textbf{to} $n$}
    \For{$i \coloneqq 1$ \textbf{to} $n$}
      \For{$j \coloneqq 1$ \textbf{to} $n$}
        \State $w_{ij} \coloneqq w_{ij} \lor (w_{ik} \lor w_{kj})$
      \EndFor
    \EndFor
  \EndFor

  \State \Return $W$ \Comment{represents $R^*$}
\EndProcedure
\end{algorithmic}

* $w_{ij} = 1$ means there is a path from $i$ to $j$ going only through nodes $\leq k$.

\vskip.5em

* Indices $i$ and $j$ may have index higher than $k$

#

\ts{Equivalence Relations}

# Introduction

* Certain combinations of relation properties are very useful

\vskip.5em

* In this section we will study equivalence relations:
  * A relation that is *reflexive*, *symmetric*, and *transitive*

\vskip.5em

* In the next section we will study partial ordering:
  * A relation that is *reflexive*, *antisymmetric*, and *transitive*

\vskip.5em

* The difference is whether the relation is symmetric or antisymmetric

# Equivalence Relations

We can group properties of relations together to define new types of important relations

\vskip.5em

* **Definition:** A relation $R$ on a set $A$ is an **equivalence relation** iff $R$ is
  * reflexive
  * symmetric
  * transitive

\vskip.5em

* Two elements related by an equivalence relation are called **equivalent**

\vskip.5em

* \ex Consider relation $R = \{(a,b)\,|\,len(a) = len(b)\}$, where $len(a)$ means the length of string $a$
  * It is reflexive: $len(a) = len(a)$
  * It is symmetric: if $len(a) = len(b)$, then $len(b) = len(a)$
  * It is transitive: if $len(a) = len(b)$ and $len(b) = len(c)$, then $len(a) = len(c)$
  * Thus, $R$ is an equivalence relation

# Equivalence Relation Example

* Consider the relation $R = \{(a,b)\,|\, a \equiv b (\mod m)\}$
  * Remember that this means that $m\, |\, a - b$
  * Called "congruence modulo $m$"

\vskip.5em

* Is it reflexive: $\left(a, a\right) \in R$ means that $m\, |\, a - a$
  * $a - a = 0$, which is divisible by $m$

\vskip.5em

* Is it symmetric: if $\left(a,b\right) \in R$ then $\left(b, a\right) \in R$
  * $\left(a, b\right)$ means that $m\, |\, a-b$
  * Or that $km = a - b$. Negating that, we get $b - a = -km$
  * Thus, $m\,|\,b - a$, so $\left(b, a\right) \in R$

# Equivalence Relation Example

* Consider the relation $R = \{(a,b)\,|\, a \equiv b (\mod m)\}$
  * Remember that this means that $m\, |\, a - b$
  * Called "congruence modulo $m$"

\vskip.5em

* Is it transitive: if $\left(a, b\right) \in R$ and $\left(b, c\right) \in R$ then $\left(a, c\right) \in R$
  * $\left(a, b\right)$ means $m\,|\,a - b$, or that $km = a-b$
  * $\left(b, c\right)$ means $m\,|\,b-c$, or that $lm = b-c$
  * $\left(a,c\right)$ means that $m\,|\, a-c$, or that $nm = a - c$
  * Adding these two, we get $km + lm = (a - b) + (b - c)$
  * Or $\left(k + l\right)m = a - c$
  * Thus, $m$ divides $a - c$, where $n = k + l$

\vskip.5em

* Thus, congruence modulo $m$ is an equivalence relation


# Equivalence Classes

* An **equivalence class** of an element $x$:

  * $[x] = \{y\,|\,(x, y) \in R\}$
  * $[x]$ is the subset of all elements related to $[x]$ by $R$
  * The element in the bracket is called a **representative** of the equivalence class.
    * We could have chosen any one.

* **Theorem:** Let $R$ be an equivalence relation on $A$. Then either

  $$[a] = [b]\, \text{or } [a] \cap [b] = \varnothing$$

* The number of equivalence classes is called the *rank* of the equivalence relation

::: columns
:::: column

\ex Let $A = \{a,b,c\}$ and $R$ be given by the shown digraph, then

$$[a] = \{a, c\},\,\, [b] = \{b\},\,\, [c] = \{a, c\}$$

\centering

rank = 2

::::
:::: column

\vspace{-2em}
\begin{center}
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (3) {\footnotesize c};
\node[main] (1) [above left of=3] {\footnotesize a};
\node[main] (2) [above right of=3] {\footnotesize b};

\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (1) to (3);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=165, in=285, looseness=1.25] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=135, in=225, looseness=5] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=45, in=315, looseness=5] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=225, in=315, looseness=5] (3);
\end{tikzpicture}
\end{center}

::::
:::

# Equivalence Classes

* Consider the relation $R = \{(a,b)\,|\,a \mod 2 = b \mod 2\}$ on the set of integers
  * Thus, all the even numbers are related to each other
  * As are the odd numbers

\vskip.5em

* The even numbers form an equivalence class
  * As do the odd numbers

\vskip.5em

* The equivalence class for the even numbers is denoted by $[2]$ (or $[4]$, or $[784]$, etc.)
  * $[2] = \{\ldots,-4,-2,0,2,-4,\ldots\}$
  * 2 is *representative* of its equivalence class

\vskip.5em

* There are only 2 equivalence classes formed by this equivalence relation

# Equivalence Classes

* Consider the relation: $R = \{(a,b)\,|\,a = b \lor a = -b\}$
  * Thus, every number is related to additive inverse

\vskip.5em

* The equivalence class for an integer $a$:
  * $[7] = \{7, -7\}$
  * $[0] = \{0\}$
  * $[a] = \{a, -a\}$

\vskip.5em

* There are an infinite number of equivalence classes formed by this equivalence relation

# Equivalence Class and Partitions

* **Theorem:** Let $R$ be an equivalence relation on a set $A$. The equivalence classes of $R$ **partition** the set $A$ into disjoint nonempty subsets whose union is the entire set. This partition is denoted $A/R$ and called
  * The *quotient set*, or
  * the *partition of $A$ induced by $R$*, or
  * *$A$ modulo $R$*

# Equivalence Class and Partitions

* **Definition:** Let $S_1,S_2,\ldots,S_n$ be a collection of subsets of a set $A$. Then the collection forms a **partition** of $A$ if the subsets are nonempty, disjoint and exhaust A

::: columns
:::: column

* $S_1 \ne \varnothing$
* $S_i \cap S_j = \varnothing$ if $i \ne j$
* $\bigcup S_i = A$

::::
:::: column

\centering
\includegraphics[width=.35\textwidth]{images/relations/partition.eps}

::::
:::

* Note that $\{\{\}, \{1,3\}, \{2\}\}$ is not a partition of $\{1,2,3\}$ (it contains the empty set)

\vskip.5em

* Note that $\{\{1\},\{2\}\}$ is not a partition of $\{1,2,3\}$ as none of blocks contain 3

# Equivalence Relations and Digraphs

* \small It is easy to recognize equivalence relations using digraphs:
  * \footnotesize The equivalence class of a particular element forms a universal relation (contains all possible edges) between the elements in the equivalence class
  * \footnotesize The (sub)digraph representing the subset is called a **complete** (sub)digraph, since all edges are present

\vskip.5em

* \small \ex All possible equivalence relations on a set $A$ with 3 elements

\small
::: columns
:::: {.column width=.333}
\vspace{-2em}
\begin{center}
\begin{tikzpicture}
[node distance={13mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (3) {};
\node[main] (1) [above left of=3] {};
\node[main] (2) [above right of=3] {};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=135, in=225, looseness=8] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=45, in=315, looseness=8] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=225, in=315, looseness=8] (3);
\end{tikzpicture}

\textbf{rank = 3}
\end{center}

\vspace{-2em}
\begin{center}
\begin{tikzpicture}
[node distance={13mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (3) {};
\node[main] (1) [above left of=3] {};
\node[main] (2) [above right of=3] {};

\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=135, in=225, looseness=8] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=45, in=315, looseness=8] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=225, in=315, looseness=8] (3);
\end{tikzpicture}

\textbf{rank = 2}
\end{center}

::::
:::: {.column width=.333}
\vspace{-2em}
\begin{center}
\begin{tikzpicture}
[node distance={13mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (3) {};
\node[main] (1) [above left of=3] {};
\node[main] (2) [above right of=3] {};

\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=135, in=225, looseness=8] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=45, in=315, looseness=8] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=225, in=315, looseness=8] (3);
\end{tikzpicture}

\textbf{rank = 2}
\end{center}

\vspace{-2em}
\begin{center}
\begin{tikzpicture}
[node distance={13mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (3) {};
\node[main] (1) [above left of=3] {};
\node[main] (2) [above right of=3] {};

\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (1) to (3);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=135, in=225, looseness=8] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=45, in=315, looseness=8] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=225, in=315, looseness=8] (3);
\end{tikzpicture}

\textbf{rank = 2}
\end{center}

::::
:::: {.column width=.333}
\vspace{-2em}
\begin{center}
\begin{tikzpicture}
[node distance={13mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (3) {};
\node[main] (1) [above left of=3] {};
\node[main] (2) [above right of=3] {};

\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (1) to (3);
\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (2) to (3);
\draw [Latex-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=135, in=225, looseness=8] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=45, in=315, looseness=8] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=225, in=315, looseness=8] (3);
\end{tikzpicture}

\textbf{rank = 1}
\end{center}
::::
:::

# Induced Equivalence Relations

* **Theorem:** If $R_1$ and $R_2$ are equivalence relations on $A$, then $R_1 \cap R_2$ is an equivalence relation on $A$

\vskip.5em

* **Definition:** Lt $R$ be a relation on $A$. Then the reflexive, symmetric, transitive closure of $R$, $tsr(R)$, is an equivalence relation on $A$, called the **equivalence relation induced** by $R$

* \ex

::: columns
:::: column

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {\footnotesize a};
\node[main] (2) [right of=1] {\footnotesize b};
\node[main] (3) [below of=2] {\footnotesize c};
\node[main] (4) [below of=1] {\footnotesize d};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (3);
\end{tikzpicture}

$R$
\end{center}

\vskip.5em

* **Theorem:** $tsr(R)$ is an equivalence relation

::::
:::: column
\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {\footnotesize a};
\node[main] (2) [right of=1] {\footnotesize b};
\node[main] (3) [below of=2] {\footnotesize c};
\node[main] (4) [below of=1] {\footnotesize d};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (3);
\end{tikzpicture}

$tsr(R)$

\textbf{rank = 2}

\vspace{-2em}

$$A = [a] \cup [b] = \{a\} \cup \{b, c, d\}$$

\vspace{-3em}

$$A/R = \{\{a\}, \{b, c, d\}\}$$

\end{center}
::::
:::

#

\ts{Partial Orderings}

# Introduction

* An equivalence relation is a relation that is reflexive, symmetric, and transitive

\vskip.5em

* A **partial ordering** (or **partial order**) is a relation that is reflexive, *antisymmetric*, and transitive
  * Recall that antisymmetric means that is $\left(a, b\right) \in R$, then $\left(b,a\right) \notin R$ unless $b = a$
  * Thus, $\left(a,a\right)$ is allowed to be in $R$
  * But, since it's reflexive, all possible $\left(a,a\right)$ must be in $R$

# Partially Ordered Set (POSET)

* **Definition:** A relation $R$ on a set $S$ is called a **partial ordering** or **partial order** if it is *reflexive*, *antisymmetric*, and *transitive*. A set $S$ together with a partial ordering $R$ is called a **partially ordered set**, or **poset**, and is denoted by $\left(S, R\right)$

\vskip.5em

* \ex Let $S = \{1,2,3\}$ and $R = \{(1,1),(2,2),(3,3),(1,2),(3,1),(3,2)\}$

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {\footnotesize 1};
\node[main] (2) [below of=1] {\footnotesize 2};
\node[main] (3) [right of=2] {\footnotesize 3};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (1);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=90, in=180, looseness=8] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=180, in=270, looseness=8] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=270, in=0, looseness=8] (3);
\end{tikzpicture}

\end{center}

# Partially Ordered Set (POSET)

* In a poset the notation $a \preccurlyeq b$ denotes that $\left(a, b\right) \in R$

  \vskip.5em

  This notation is used because the "less than or equal to" relation is a paradigm for a partial ordering. (Note that the symbol $\preccurlyeq$ is used to denote the relation in *any* poset, not just the "less than or equals" relation.)

  \vskip.5em

  The notation $a \prec b$ denotes that $a \preccurlyeq b$, but $a \neq b$

\vskip.5em

* \ex Let $S = \{1,2,3\}$ and $R = \{(1,1), (2,2), (3,3), (1,2), (3,1), (3,2)\}$

  ::: columns
  :::: column

  \vspace{-2em}
  \begin{center}
  \begin{tikzpicture}
  [node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

  \node[main] (1) {\footnotesize 1};
  \node[main] (2) [below of=1] {\footnotesize 2};
  \node[main] (3) [right of=2] {\footnotesize 3};

  \draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
  \draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (2);
  \draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (1);

  \draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=90, in=180, looseness=8] (1);
  \draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=180, in=270, looseness=8] (2);
  \draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=270, in=0, looseness=8] (3);
  \end{tikzpicture}

  \end{center}

  ::::
  :::: column

  \normalsize

  $$\begin{array}{rcl}
  2 & \preccurlyeq & 2 \\
  3 & \prec & 2
  \end{array}$$

  ::::
  :::

# Comparable / Incomparable

* **Definition:** The elements $a$ and $b$ of a poset $\left(S, \preccurlyeq\right)$ are called **comparable** if either $a \preccurlyeq b$ or $b \preccurlyeq a$. When $a$ and $b$ are elements of $S$ such that neither $a \preccurlyeq b$ nor $b \preccurlyeq a$, $a$ and $b$ are called **incomparable**

\vskip.5em

* \ex Consider the power set of $\{a, b, c\}$ and the subset relation. $\left(P(\{a,b,c\}\right), \subseteq)$

  $$\{a, c\} \not\subseteq \{a, b\}\,\text{and } \{a, b\} \not\subseteq \{a,c\}$$

  So, $\{a,c\}$ and $\{a,\b\}$ are **incomparable**

# Totally Ordered

* **Definition:** If $\left(S, \preccurlyeq\right)$ is a poset and every two elements of $S$ are comparable, $S$ is called a **totally ordered** or **linearly ordered** set, and $\preccurlyeq$ is called a **total order** or a **linear order**.
  * A totally ordered set is also called a **chain**

# Greatest/Least Elements

* **Definition:** Let *R* be a total order on $A$ and suppose $S \subseteq A$. An element $s \in S$ is a **least element** of $S$ iff $sRb$ for every $b \in S$.
  * Note: this implies that $\left(a,s\right)$ is not in $R$ for any $a$ unless $a = s$. (There is nothing smaller than $s$ under the order $R$)

\vskip.5em

* **Definition:** Let *R* be a total order on $A$ and suppose $S \subseteq A$. An element $s \in S$ is a **greatest element** of $S$ iff $bRs$ for every $b \in S$
  * Note: this implies that $\left(s,a\right)$ is not in $R$ for any $a$ unless $a = s$. (There is nothing larger than $s$ under the order $R$)

# Well-Ordered Set

* **Definition:** $\left(S, \preccurlyeq\right)$ is a **well-ordered set** if it is a poset such that $\preccurlyeq$ is a total ordering and such that every nonempty subset of $S$ has a *least element*

\vskip.5em

* \ex Consider the ordered pairs of positive integers, $\mathbb{Z}^+ \times \mathbb{Z}^+$ where

  $\left(a_1,a_2\right) \preccurlyeq (b_1, b_2)$ if $a_1 < b_1$, or if $a_1 = b_1$ and $a_2 \leq b_2$

# Examples

* \ex $\left(\mathbb{Z}, \leq\right)$
  * Is a total ordered poset (every element is comparable to every other element)
  * It has no least element
  * Thus, it is not a well-ordered set

\vskip.5em

* \ex $\left(S, \leq\right)$ where $S = \{1,2,3,4,5\}$
  * Is a total ordered poset (every element is comparable to every other element)
  * Has a least element (1)
  * Thus, it is a well-ordered set

# Lexicographic Order

* **Definition:** This ordering is called *lexicographic* because it is the way that words are ordered in the dictionary

\vskip.5em

* Given two posets $\left(A_1, R_1\right)$ and $\left(A_2, R_2\right)$ we construct an *induced* partial order $R$ on $A_1 \times A_2$:

  $\left(x_1, y_1\right) R (x_2, y_2)$ iff

  - $x_1 R_1 x_2$, or
  - $x_1 = x_2$ and $y_1 R_2 y_2$

\vskip.5em

* \ex Let $A_1 = A_2 = \mathbb{Z}^+$ and $R_1 = R_2 =$ 'divides', then
  * $\left(2,4\right) R (2,8)$ since $x_1 = x_2$ and $y_1 R_2 y_2$
  * $\left(2,4\right)$ is not related under $R$ to $\left(2,6\right)$ since $x_1 = x_2$ but 4 does not divide 6
  * $\left(2,4\right) R (4,5)$ since $x_1 R x_2$. (Note that 4 is not related to 5)

# Example

\ex Let $\sum$ be a finite set and suppose $R$ is a partial order relation defined on $\sum$. Define a relation $\preccurlyeq$ on $\sum^*$, the set of all strings over $\sum$, as follows:

\vskip.5em

* For any positive integers $m$ and $n$ and $a_1a_2\ldots a_m$ and $b_1b_2\ldots b_n$ in $\sum^*$
  1. If $m \leq n$ and $a_i = b_i$ for all $i = 1, 2, \ldots, m$, then

     $$a_1a_2\ldots a_m \preccurlyeq b_1b_2\ldots b_n$$

  2. If for some integer $k$ with $k \leq m$, $k \leq n$, and $k \geq 1$, $a_i = b_i$ for all $i = 1, 2, \ldots, k - 1$, and $a_kRb_k$ but $a_k \neq b_k$, then

     $$a_1a_2\ldots a_m \preccurlyeq b_1b_2\ldots b_n$$

  3. If $\epsilon$ is the null string and $s$ is any string in $\sum^*$ then $\epsilon \preccurlyeq s$.

# Well-Ordered Induction

**Principle of Well-Ordered Induction:**

\vskip.5em

* Suppose that $S$ is a well-ordered set. Then $P(x)$ is true for all $x \in S$, if:

  \vskip.5em

  *BASIS STEP:* $P(x_0)$ is true for the least element of $S$, and

  \vskip.5em

  *INDUCTIVE STEP:* For every $y \in S$ if $P(x)$ is true for all $x \prec y$, then $P(y)$ is true

# Hasse Diagrams

* Given any partial order relation defined on a finite set, it is possible to draw the directed graph so that all of these properties are satisfied.

\vskip.5em

* This makes it possible to associate a somewhat simpler graph, called a **Hasse diagram**, with a partial order relation defined on a finite set.

\vskip.5em

* Start with a directed graph of the relation in which all arrows point upward. Then eliminate:
  1. The loops at all the vertices
  2. All arrows whose existence is implied by the transitive property
  3. The direction indicators on the arrows

# Example

\ex Let $A = \{1,2,3,9,19\}$ and consider the "divides" relation on $A$

  $\forall a,b \in A$, $a\, |\, b \leftrightarrow b = ka$ for some integer $k$

::: columns
:::: column

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (4) {\footnotesize 1};
\node[main] (2) [above left of=4] {\footnotesize 2};
\node[main] (5) [right of=4] {\footnotesize 3};
\node[main] (3) [above right of=5] {\footnotesize 9};
\node[main] (1) at (1,3) {\footnotesize 18};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to (1);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to [out=45, in=135, looseness=8] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=135, in=225, looseness=8] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=45, in=315, looseness=8] (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=225, in=315, looseness=8] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (5) to [out=225, in=315, looseness=8] (5);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=30, in=135, looseness=1.5] (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=45, in=180, looseness=1.5] (3);
\end{tikzpicture}

\end{center}

::::
:::: column

* Eliminate the loops at all the vertices

\vskip.5em

* Elminiate all arrows whose existence is implied by the transitive property

\vskip.5em

* Eliminate the direction indicators on the arrows

::::
:::

# Hasse Diagram

* For the poset $\left(\{1,2,3,4,6,8,12\}, |\right)$

::: columns
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {\footnotesize 1};
\node[main] (2) [above left of=1] {\footnotesize 2};
\node[main] (3) [above right of=1] {\footnotesize 3};
\node[main] (4) [above of=2] {\footnotesize 4};
\node[main] (6) [above of=3] {\footnotesize 6};
\node[main] (8) [above of=4] {\footnotesize 8};
\node[main] (12) [above of=6] {\footnotesize 12};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to (12);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (12);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=135, in=225, looseness=1.15] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=45, in=315, looseness=1.15] (12);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=210, in=150, looseness=5] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=330, in=30, looseness=5] (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to [out=210, in=150, looseness=5] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=330, in=30, looseness=5] (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to [out=210, in=150, looseness=5] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (12) to [out=330, in=30, looseness=5] (12);

\end{tikzpicture}
\end{center}

::::
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {\footnotesize 1};
\node[main] (2) [above left of=1] {\footnotesize 2};
\node[main] (3) [above right of=1] {\footnotesize 3};
\node[main] (4) [above of=2] {\footnotesize 4};
\node[main] (6) [above of=3] {\footnotesize 6};
\node[main] (8) [above of=4] {\footnotesize 8};
\node[main] (12) [above of=6] {\footnotesize 12};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (3);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to (12);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (12);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to (6);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (12);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (2) to [out=135, in=225, looseness=1.15] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=45, in=315, looseness=1.15] (12);

\end{tikzpicture}
\end{center}

::::
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={20mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {\footnotesize 1};
\node[main] (2) [above left of=1] {\footnotesize 2};
\node[main] (3) [above right of=1] {\footnotesize 3};
\node[main] (4) [above of=2] {\footnotesize 4};
\node[main] (6) [above of=3] {\footnotesize 6};
\node[main] (8) [above of=4] {\footnotesize 8};
\node[main] (12) [above of=6] {\footnotesize 12};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (12);

\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (12);

\end{tikzpicture}
\end{center}

::::
:::

# Hasse Diagram

* \ex Construct the Hasse diagram of $\left(P(\{a, b, c\}\right), \subseteq)$

::: columns
:::: column

The elements of $P(\{a,b,c\})$ are:

* $\varnothing$
* $\{a\}$, $\{b\}$, $\{c\}$
* $\{a,b\}$, $\{a, c\}$, $\{b, c\}$
* $\{a,b,c\}$

::::
:::: column

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {\footnotesize $\varnothing$};
\node[main] (3) [above of=1] {\footnotesize $\{b\}$};
\node[main] (2) [left of=3] {\footnotesize $\{a\}$};
\node[main] (4) [right of=3] {\footnotesize $\{c\}$};
\node[main] (5) [above of=2] {\footnotesize $\{a, b\}$};
\node[main] (6) [above of=3] {\footnotesize $\{a, c\}$};
\node[main] (7) [above of=4] {\footnotesize $\{b, c\}$};
\node[main] (8) [above of=6] {\footnotesize $\{a, b, c\}$};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (7) -- (8);

\end{tikzpicture}
\end{center}

::::
:::

# Maximal and Minimal Elements

* **Definition:** $a$ is a **maximal** in the poset $\left(S, \preccurlyeq\right)$ if there is no $b \in S$ such that $a \prec b$.

\vskip.5em

* **Definition:** $a$ is a **minimal** in the poset $\left(S, \preccurlyeq\right)$ if there is no element $b \in S$ such that $b \prec a$

::: columns
:::: column

* Note: it is possible to have multiple minimals and maximals

::::
:::: column

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {\footnotesize 1};
\node[main] (2) [above left of=1] {\footnotesize 2};
\node[main] (3) [above right of=1] {\footnotesize 3};
\node[main] (4) [above of=2] {\footnotesize 4};
\node[main] (6) [above of=3] {\footnotesize 6};
\node[main] (8) [above of=4] {\footnotesize 8};
\node[main] (12) [above of=6] {\footnotesize 12};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (12);

\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (12);

\end{tikzpicture}
\end{center}

::::
:::

# GLEs and ULBs

* **Definition:** $a$ is the **greatest element** in the poset $\left(S, \preccurlyeq\right)$ if $b \preccurlyeq a$ for all $b \in S$.

\vskip.5em

* **Definition:** $a$ is the **least element** in the poset $\left(S, \preccurlyeq\right)$ if $a \preccurlyeq b$ for all $b \in S$.

\vskip.5em

* Sometimes it is possible to find an element that is greater than all the elements in a subset $A$ of a poset $\left(S, \preccurlyeq\right)$.

\vskip.5em

* **Definition:** If $u$ is an element of $S$ such that $a \preccurlyeq u$ for all elements $a \in A$, then $u$ is called an **upper bound** of $A$

\vskip.5em

* There may also be an element less than all the elements in $A$

\vskip.5em

* **Definition:** If $l$ is an element of $S$ such that $l \preccurlyeq a$ for all elements $a \in A$, then $l$ is called a **lower bound** of $A$

# LUB/GLB

* **Definition:** The element $x$ is called the **least upper bound** ($\lub$) of the subset $A$ if $x$ is an upper bound that is less than every other upper bound of $A$

\vskip.5em

* **Definition:** The element $y$ is called the **greatest lower bound** ($\glb$) of the subset $A$ if $y$ is a lower bound of $A$ and $z \preccurlyeq y$ whenever $z$ is a lower bound of $A$.

# Lattices

* **Definition:** A partially ordered set in which *every pair* of elements has both a least upper bound and a greatest lower bound is called a **lattice**

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (1) {\footnotesize $\varnothing$};
\node[main] (3) [above of=1] {\footnotesize $\{b\}$};
\node[main] (2) [left of=3] {\footnotesize $\{a\}$};
\node[main] (4) [right of=3] {\footnotesize $\{c\}$};
\node[main] (5) [above of=2] {\footnotesize $\{a, b\}$};
\node[main] (6) [above of=3] {\footnotesize $\{a, c\}$};
\node[main] (7) [above of=4] {\footnotesize $\{b, c\}$};
\node[main] (8) [above of=6] {\footnotesize $\{a, b, c\}$};

\draw [line width=0.25mm, BlueDeFrance] (1) -- (2);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (3);
\draw [line width=0.25mm, BlueDeFrance] (1) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (5);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (7);
\draw [line width=0.25mm, BlueDeFrance] (5) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (8);
\draw [line width=0.25mm, BlueDeFrance] (7) -- (8);

\end{tikzpicture}
\end{center}

# Lattice Example

\ex Determine whether the posets represented by each of the following Hasse diagrams are lattices.

::: columns
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={12mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (a) {\footnotesize $a$};
\node[main] (b) [above of=a] {\footnotesize $b$};
\node[main] (c) [above left of=b] {\footnotesize $c$};
\node[main] (d) [above right of=b] {\footnotesize $d$};
\node[main] (e) [above right of=c] {\footnotesize $e$};
\node[main] (f) [above of=e] {\footnotesize $f$};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (e) -- (f);

\end{tikzpicture}
\end{center}

::::
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={12mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (a) {\footnotesize $a$};
\node[main] (b) [above left of=a] {\footnotesize $b$};
\node[main] (c) [above right of=a] {\footnotesize $c$};
\node[main] (d) [above of=b] {\footnotesize $d$};
\node[main] (e) [above of=c] {\footnotesize $e$};
\node[main] (f) [above left of=e] {\footnotesize $f$};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (c);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (c) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (e) -- (f);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (f);

\end{tikzpicture}
\end{center}

::::
:::: {.column width=.333}

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={12mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (a) {\footnotesize $a$};
\node[main] (d) [above of=a] {\footnotesize $d$};
\node[main] (b) [left of=d] {\footnotesize $b$};
\node[main] (dd) [right of=d] {\footnotesize $d$};
\node[main] (e) [above of=b] {\footnotesize $e$};
\node[main] (g) [above of=d] {\footnotesize $g$};
\node[main] (gg) [above of=dd] {\footnotesize $g$};
\node[main] (h) [above of=g] {\footnotesize $h$};

\draw [line width=0.25mm, BlueDeFrance] (a) -- (b);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (d);
\draw [line width=0.25mm, BlueDeFrance] (a) -- (dd);
\draw [line width=0.25mm, BlueDeFrance] (b) -- (e);
\draw [line width=0.25mm, BlueDeFrance] (d) -- (g);
\draw [line width=0.25mm, BlueDeFrance] (dd) -- (gg);
\draw [line width=0.25mm, BlueDeFrance] (e) -- (h);
\draw [line width=0.25mm, BlueDeFrance] (g) -- (h);
\draw [line width=0.25mm, BlueDeFrance] (gg) -- (h);

\end{tikzpicture}
\end{center}

::::
:::

\sol both the first and third Hasse diagrams are latices, however the second is not since both $b$ and $c$ do not have least upper bounds.

# Topological Sorting

* A total ordering $\preccurlyeq$ is said to be compatible with the partial ordering $R$ if $a \preccurlyeq b$ whenever $aRb$. Constructing a total ordering from a partial ordering is called **topological sorting**

\vskip.5em

* If there is an edge from $v$ to $w$, then $v$ precedes $w$ in the sequential listing

\only<1>{
\begin{center}
\begin{tikzpicture}
[node distance={25mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (0) {\footnotesize 0};
\node[main] (1) [right of=0] {\footnotesize 1};
\node[main] (2) [right of=1] {\footnotesize 2};
\node[main] (3) [right of=2] {\footnotesize 3};
\node[main] (4) [right of=3] {\footnotesize 4};
\node[main] (5) [below of=0] {\footnotesize 5};
\node[main] (6) [right of=5] {\footnotesize 6};
\node[main] (7) [right of=6] {\footnotesize 7};
\node[main] (8) [right of=7] {\footnotesize 8};
\node[main] (9) [right of=8] {\footnotesize 9};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (0) to (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (0) to (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to (0);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to (4);
\end{tikzpicture}
\end{center}
}

\only<2>{
\begin{center}
\begin{tikzpicture}
[node distance={10mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (9) {\footnotesize 9};
\node[main] (6) [right of=9] {\footnotesize 6};
\node[main] (3) [right of=6] {\footnotesize 3};
\node[main] (4) [right of=3] {\footnotesize 4};
\node[main] (8) [right of=4] {\footnotesize 8};
\node[main] (2) [right of=8] {\footnotesize 2};
\node[main] (0) [right of=2] {\footnotesize 0};
\node[main] (5) [right of=0] {\footnotesize 5};
\node[main] (1) [right of=5] {\footnotesize 1};
\node[main] (7) [right of=1] {\footnotesize 7};

\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (4) to (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (0) to (5);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (1) to (7);

\draw [-Latex, line width=0.25mm, BlueDeFrance] (9) to [out=45, in=135, looseness=1.025] (4);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=45, in=135, looseness=1.025] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=45, in=135, looseness=1.025] (0);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (6) to [out=45, in=135, looseness=1.025] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=45, in=135, looseness=1.025] (8);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (8) to [out=45, in=135, looseness=1.025] (7);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (0) to [out=45, in=150, looseness=1.025] (1);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=315, in=225, looseness=1.025] (2);
\draw [-Latex, line width=0.25mm, BlueDeFrance] (3) to [out=315, in=225, looseness=1.025] (7);
\end{tikzpicture}
\end{center}
}

# Example

\ex Consider the set $A = \{2,3,4,6,18,24\}$ ordered by the "divides" relation. The Hasse diagram follows:

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (2) {\footnotesize 2};
\node[main] (3) at (3,0) {\footnotesize 3};
\node[main] (4) [above of=2] {\footnotesize 4};
\node[main] (6) [above of=3] {\footnotesize 6};
\node[main] (24) [above of=4] {\footnotesize 24};
\node[main] (18) [above of=6] {\footnotesize 18};

\draw [line width=0.25mm, BlueDeFrance] (2) -- (4);
\draw [line width=0.25mm, BlueDeFrance] (2) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (3) -- (6);
\draw [line width=0.25mm, BlueDeFrance] (4) -- (24);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (18);
\draw [line width=0.25mm, BlueDeFrance] (6) -- (24);

\end{tikzpicture}
\end{center}

The ordinary "less than or equal to" relation $\leq$ on this set is a topological sorting for it since for positive integers $a$ and $b$, if $a\,|\,b$, then $a \leq b$

# Toplogical Sorting

\begin{algorithmic}
\Procedure{topologicalSort}{$\left(S, \preccurlyeq\right)$: finite poset}
\State $k \coloneqq 1$
\While{$S \neq \varnothing$}
  \State $a_k \coloneqq a$ minimal element of $S$
  \State $S \coloneqq S - \{a_k\}$
  \State $k \coloneqq k + 1$
\EndWhile
\State \Return $a_1,a_2,\ldots,a_n$
\EndProcedure
\end{algorithmic}

# Example

* \ex A development project at a computer company requires the completion of seven tasks. Some of these tasks can be started only after other tasks are finished. A partial ordering on tasks is set up by considering task $X \prec$ task $Y$ if task $Y$ cannot be started until task $X$ has been completed.

  * The Hasse diagram for the seven tasks, with respect to this partial ordering is shown below.

  * Find an order in which these tasks can be carried out to complete the project.

\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (A) {\footnotesize A};
\node[main] (B) [above right of=A] {\footnotesize B};
\node[main] (C) at (2.25,0) {\footnotesize C};
\node[main] (D) [above of=B] {\footnotesize D};
\node[main] (E) at (4,0) {\footnotesize E};
\node[main] (F) at (4,2.75) {\footnotesize F};
\node[main] (G) at (2.5,3.5) {\footnotesize G};

\draw [line width=0.25mm, BlueDeFrance] (A) -- (B);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (B);
\draw [line width=0.25mm, BlueDeFrance] (D) -- (G);
\draw [line width=0.25mm, BlueDeFrance] (E) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (F) -- (G);

\end{tikzpicture}
\end{center}

# Example

* \ex A development project at a computer company requires the completion of seven tasks. Some of these tasks can be started only after other tasks are finished. A partial ordering on tasks is set up by considering task $X \prec$ task $Y$ if task $Y$ cannot be started until task $X$ has been completed.

  * The Hasse diagram for the seven tasks, with respect to this partial ordering is shown below.

  * Find an order in which these tasks can be carried out to complete the project.

::: columns
:::: column

\only<1>{
\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (A) {\footnotesize A};
\node[main] (B) [above right of=A] {\footnotesize B};
\node[main] (C) at (2.25,0) {\footnotesize C};
\node[main] (D) [above of=B] {\footnotesize D};
\node[main] (E) at (4,0) {\footnotesize E};
\node[main] (F) at (4,2.75) {\footnotesize F};
\node[main] (G) at (2.5,3.5) {\footnotesize G};

\draw [line width=0.25mm, BlueDeFrance] (A) -- (B);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (B);
\draw [line width=0.25mm, BlueDeFrance] (D) -- (G);
\draw [line width=0.25mm, BlueDeFrance] (E) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (F) -- (G);

\end{tikzpicture}
\end{center}
}

\only<2>{
\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (B) [above right of=A] {\footnotesize B};
\node[main] (C) at (2.25,0) {\footnotesize C};
\node[main] (D) [above of=B] {\footnotesize D};
\node[main] (E) at (4,0) {\footnotesize E};
\node[main] (F) at (4,2.75) {\footnotesize F};
\node[main] (G) at (2.5,3.5) {\footnotesize G};

\draw [line width=0.25mm, BlueDeFrance] (B) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (C) -- (B);
\draw [line width=0.25mm, BlueDeFrance] (D) -- (G);
\draw [line width=0.25mm, BlueDeFrance] (E) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (F) -- (G);

\end{tikzpicture}
\end{center}
}

\only<3>{
\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (B) [above right of=A] {\footnotesize B};
\node[main] (D) [above of=B] {\footnotesize D};
\node[main] (E) at (4,0) {\footnotesize E};
\node[main] (F) at (4,2.75) {\footnotesize F};
\node[main] (G) at (2.5,3.5) {\footnotesize G};

\draw [line width=0.25mm, BlueDeFrance] (B) -- (D);
\draw [line width=0.25mm, BlueDeFrance] (B) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (D) -- (G);
\draw [line width=0.25mm, BlueDeFrance] (E) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (F) -- (G);

\end{tikzpicture}
\end{center}
}

\only<4>{
\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (D) [above of=B] {\footnotesize D};
\node[main] (E) at (4,0) {\footnotesize E};
\node[main] (F) at (4,2.75) {\footnotesize F};
\node[main] (G) at (2.5,3.5) {\footnotesize G};

\draw [line width=0.25mm, BlueDeFrance] (D) -- (G);
\draw [line width=0.25mm, BlueDeFrance] (E) -- (F);
\draw [line width=0.25mm, BlueDeFrance] (F) -- (G);

\end{tikzpicture}
\end{center}
}

\only<5>{
\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (D) [above of=B] {\footnotesize D};
\node[main] (F) at (4,2.75) {\footnotesize F};
\node[main] (G) at (2.5,3.5) {\footnotesize G};

\draw [line width=0.25mm, BlueDeFrance] (D) -- (G);
\draw [line width=0.25mm, BlueDeFrance] (F) -- (G);

\end{tikzpicture}
\end{center}
}

\only<6>{
\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (D) [above of=B] {\footnotesize D};
\node[main] (G) at (2.5,3.5) {\footnotesize G};

\draw [line width=0.25mm, BlueDeFrance] (D) -- (G);

\end{tikzpicture}
\end{center}
}

\only<7->{
\vspace{-1em}
\begin{center}
\begin{tikzpicture}
[node distance={15mm},main/.style = {draw, circle, minimum size=1mm, line width=0.25mm, white}]

\node[main] (G) at (2.5,3.5) {\footnotesize G};

\end{tikzpicture}
\end{center}
}

::::
:::: column

\sol

\small

\begin{itemize}
\item<2-> A
\item<3-> C
\item<4-> B
\item<5-> E
\item<6-> F
\item<7-> D
\item<8-8> G
\end{itemize}

\only<8>{
\vspace{-3em}
\begin{equation*}
A \prec C \prec B \prec E \prec F \prec D \prec G
\end{equation*}
}

::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
