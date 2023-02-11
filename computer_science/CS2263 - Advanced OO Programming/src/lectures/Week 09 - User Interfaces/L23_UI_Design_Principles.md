---
author:
- Isaac Griffith
title: UI Design
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand the general principles of UI Design
::::
:::: {.column width=.25}
\vfill
\vspace{5.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\centering
\vfill
\begin{minipage}{.6\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Principles of UI Design
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# 1. Match the real world

::: columns
:::: column

\textcolor{Roarange}{\textbf{Examples}}

* \small Desktop
* \small Trashcan

\textcolor{Roarange}{\textbf{Dangers of metaphors}}

1. \small Often hard for designers to find
2. \small Deceptive
3. \small Constraining
4. \small Breaking the metaphor

::::
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/ui/real.png}

::::
:::

* \small Using a metaphor doesn't excuse other bad design decisions

# Directly Manipulate Objects

* \small User interacts with visual representation of data objects
  - \footnotesize Continuous visual representation
  - \footnotesize Physical actions or labeled button presses
  - \footnotesize Rapid, incremental, reversible, immediately visible effects

\vskip.5em

* \small Examples
  - \footnotesize Files and folders on a desktop
  - \footnotesize Scrollbar
  - \footnotesize Dragging to resize a rectangle
  - \footnotesize Selecting text

\vskip.5em

* \small Visual representation and physical interaction are important

# Objects suggest actions for use

Perceived and actual properties of a thing that determine how the thing could be used

\vskip.5em

1. \small Chair is for sitting
2. \small Knob is for turning
3. \small Button is for pushing
4. \small Listbox is for selection
5. \small Scollbar is for continuous scrolling or panning

# Natural Mapping

::: columns
:::: column

* \small Physical arrangement of controls should match arrangement of function

\vskip.5em

* \small Best mapping is direct, but natural mappings don't have to be direct
  - \footnotesize Light switches
  - \footnotesize Stove burners
  - \footnotesize Turn signals
  - \footnotesize Audio mixer

::::
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/ui/mapping.eps}

::::
:::

# Actions

Actions should have immediate, visible effects

::: columns
:::: column

* \small Examples
  - \footnotesize Push buttons
  - \footnotesize Scrollbars
  - \footnotesize Drag and drop

\vskip.5em

* \small Kinds of feedback
  - \footnotesize Visual
  - \footnotesize Audio
  - \footnotesize Haptic (conveyed by sense of touch)

::::
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/ui/actions.png}

::::
:::

# 2. Consistency and Standards

::: columns
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/ui/consistency.png}

::::
:::: column

* \small Users should not have to wonder whether different words, situations, or actions mean the same thing.

\vskip.5em

* \small Follow \textcolor{Roarange}{\textbf{platform conventions....}}

::::
:::

# 3. Help and Documentation

::: columns
:::: {.column width=.3}

\textcolor{Roarange}{\textbf{Help should be}}

\vskip.5em

1. \small Searchable
2. \small Context-sensitive
3. \small Task sensitive
4. \small Concrete
5. \small Short
6. \small \textcolor{Roarange}{\textbf{NOT NEEDED}}

::::
:::: {.column width=.7}

\centering
\includegraphics[width=.8\textwidth]{images/ui/help.png}

::::
:::

# 4. User Control and Freedom

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/ui/freedom.png}

::::
:::: column

Users may run into trouble by using a system function by mistake and need a clearly marked "emergency exit" to leave the unwanted state without having to go through an extended dialogue.

\vskip.5em

1. \small Provide Undo
2. \small Long operations should be allowed to be paused/suspended
3. \small All dialogs should have a cancel button

::::
:::

# 5. Visibility of System Status

::: columns
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/ui/status.png}

::::
:::: column

The system should always keep users informed about what is going on, through appropriate feedback within reasonable time.

\vskip.5em

1. \small Change cursor to indicate action
2. \small Use highlights to show selected objects
3. \small Use status bar to show progress

::::
:::

# 6. Flexibility and Efficiency

* \small Accelerators -- unseen by the novice user -- may often speed up the interaction for the expert user such that the system can cater to both inexperienced and experienced users. Allow users to tailor frequent actions.

::: columns
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/ui/flexibility01.png}

::::
:::: column

\centering
\includegraphics[width=.5\textwidth]{images/ui/flexibility02.png}

::::
:::

# 7. Recognition, Not Recall

::: columns
:::: column

\centering
\includegraphics[width=.6\textwidth]{images/ui/recall.png}

::::
:::: column

\small Minimize the user's memory load by making objects, actions, and options visible

\vskip1em

\small The user should not have to remember information from one part of the dialog to another. Instructions for use of the system should be visible or easily retrievable whenever appropriate.

\vskip.5em

1. \footnotesize Use menus, not command languages
2. \footnotesize Use combo boxes, not textboxes
3. \footnotesize Use generic commands
4. \footnotesize All needed information must be visible

::::
:::

# 8. Error Prevention

::: columns
:::: column

* \small Even better than good error messages is a careful design which prevents a problem from occurring in the first place

\vskip.5em

* \small Either eliminate error-prone conditions or check for them and present users with a confirmation option before they commit to the action

::::
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/ui/error.png}

::::
:::

# 9. Recovery

\begin{center}
\Large \textbf{Help Users Recognize, Diagnose, and Recover from Errors}
\end{center}

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/ui/errors01.png}

\vskip1.5em

\centering
\includegraphics[width=.75\textwidth]{images/ui/errors02.png}

::::
:::: column

* \small Error messages should be expressed in plain language (no codes), precisely indicate the problem, and constructively suggest a solution.

\vskip.5em

* \small And they should be polite...

::::
:::

# 10. Aesthetic and Minimalist Design

::: columns
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/ui/minimal01.png}

::::
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/ui/minimal02.png}

::::
:::

* \footnotesize Dialogs should not contain information which is irrelevant or rarely needed.

* \footnotesize Every extra unit of information in a dialog competes with the relevant units of information and diminishes their relative visibility.

# For Next Time

::: columns
:::: {.column width=.6}
* Review this lecture
::::
:::: {.column width=.4}
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\centering
\vfill
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
