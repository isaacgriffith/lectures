---
author:
- Isaac Griffith
title: Work Distribution and Data Parallelism
institute: |
  CS 2263

  Department of Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* How to apply the state pattern to UIs
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears.jpg}
::::
:::

#

\centering
\vfill
\begin{minipage}{.8\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge Analyzing Parallelism
\vskip-0.75em
\rule{.75\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 2263}
\end{minipage}
\end{minipage}

# Introduction

# Analyzing Parallelism

# Realistic Multiprocessor Scheduling

#

\centering
\vfill
\begin{minipage}{.8\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge Work Distribution
\vskip-0.75em
\rule{.75\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 2263}
\end{minipage}
\end{minipage}

# Work Distribution

# Work Stealing

# Yielding and Multiprogramming

#

\centering
\vfill
\begin{minipage}{.8\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge Work-Stealing Deques
\vskip-0.75em
\rule{.75\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 2263}
\end{minipage}
\end{minipage}

# Bounded work-stealing deque

# Unbounded work-stealing deque

# Work Dealing

#

\centering
\vfill
\begin{minipage}{.8\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge Data Parallelism
\vskip-0.75em
\rule{.75\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 2263}
\end{minipage}
\end{minipage}

# Introduction

#

\centering
\vfill
\begin{minipage}{.8\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge MapReduce
\vskip-0.75em
\rule{.75\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 2263}
\end{minipage}
\end{minipage}

# MapReduce

# The MapReduce Framework

# Word Count Application

# KMeans Application

# MapReduce Implementation

#

\centering
\vfill
\begin{minipage}{.8\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{\textwidth}
\Huge Stream Computing
\vskip-0.75em
\rule{.75\textwidth}{2pt}

\large \color{Roarange}\textbf{CS 2263}
\end{minipage}
\end{minipage}

# Stream Computing

# Word Count Application

# KMeans Application

# Parallelizing Aggregation Operations

# For Next Time

::: columns
:::: column
* Review Chapter 10.8 - 10.10
* Review this lecture
* Read Chapter 11.1 - 11.6 and 11.10
* Watch Lecture 30
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}
