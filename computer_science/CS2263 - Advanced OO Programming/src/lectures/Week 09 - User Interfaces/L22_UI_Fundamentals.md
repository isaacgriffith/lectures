---
author:
- Dr. Isaac Griffith
title: UI Fundamentals
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# An Aside

* I want us to consider the creation of a UI
* Think about your project.
* Ask yourself this question: What are the concerns in our system, and did we follow the "Separation of Concerns" principle in our design?

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Application Layers
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand and describe the general concepts of UI, UX, and User Centric Design
* Understand the ideas and basic methods of UI design
* Understand the general principles of UI Design
* Understand the fundamentals underlying UI Design
::::
:::: {.column width=.25}
\vfill
\vspace{5.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

# What is User Experience? (UX)

* \small Puts the end user at the center of the universe and defines the system from that perspective
* \small Usability is finding the best match between a user's needs and a product's use
* \small While this is a specialty by itself, a computer scientist/developer can grow an appreciation for UX, which affects
  1. \footnotesize Functionality
  2. \footnotesize System Organization and Structure
  3. \footnotesize Interactions and Look and Feel
  4. \footnotesize Access

# What is User Interface? (UI)

* \small \textcolor{Roarange}{\textbf{Human-Computer Interaction (HCI)}} research is focused on the interfaces between people (users) and computers

* \small The point of interaction or communication between a computer and another entity, such as a printer or human operator. Information flows in one direction or two.

* \small The layout of an application's graphic, spoken, touch, or textural controls in conjunction with the way the application responds to user activity.

::: columns
:::: column
* \small UI fulfills two key UX needs:
  3. \footnotesize Interactions and Look and Feel
  4. \footnotesize Access
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/ui/what_is_ui.png}
::::
:::

# Why Do We Care About UX/UI?

\centering
\vfill
\Huge Because it matters

# Poor UX

\begin{center}Poor UX means people won't use your product\end{center}

::: columns
:::: column

\textcolor{Roarange}{\textbf{People will call tech support}}

\centering
\includegraphics[width=\textwidth]{images/ui/support_costs.png}

::::
:::: column

\textcolor{Roarange}{\textbf{People won't use it even when it works and will return it}}

* \small E.g., an ISP had 30% of routers returned as non-working \textcolor{Roarange}{\textbf{but they tested fine}}

\textcolor{Roarange}{\textbf{People won't buy your product and worse, will tell their friends not to use it}}

* \small Measured by negative impact on Net Promoter Score (NPS)
  - \footnotesize Gauges the loyalty of a firm's customer relationships
  - \footnotesize Is thought to be correlated with revenue growth

::::
:::

# What is Design?

::: columns
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/ui/jobs.png}

::::
:::: column

\small "Most people make the mistake of thinking design is what it looks like. People think it's this veneer -- that the designers are handed this box and told, 'Make it look good!' That's not what we think design is. It's not just what it looks like and feels like. \textcolor{Roarange}{\textbf{Design is how it works}}"

\begin{flushright}Steve Jobs\end{flushright}

* \small Design is hard
* \small Design is easy to overdo

::::
:::

# What is a Good Design?

\begin{center}
\Large
A solution that \textbf{serves the users}\\
and \textcolor{Roarange}{\textbf{satisfies the client}}
\end{center}

\vskip1em

1. \small Does what the users need and want

\vskip1.5em

2. \small Natural to use

\vskip1.5em

3. \small Helps them avoid trouble

\vskip1.5em

\centering
\Large \textbf{Easy to say, very hard to do well}

# User Centered Design

\centering
\Large

Puts the end user at the center of the

universe and defines the system from that

perspective

# User Centered Design

1. \small Identify who the users are

2. \small Identify what they want to accomplish

3. \small Constantly assess (1) and (2)

#

\centering
\vfill
\begin{minipage}{.4\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Fundamentals
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}


# Grids / Layouts / Structure

* \small A well-designed UI must be grounded in strong layouts with a grid.
* \small \textcolor{Roarange}{Grids provide order, regularity, rhythm, and control}
* \small Knowing how to work with grids is a vital interface design skill, which takes years to master

\centering
\includegraphics[width=\textwidth]{images/ui/grids.png}

# Grids / Layouts / Structure

* \small Navigational Structure
  - \footnotesize Easy, meaningful path \textcolor{Roarange}{(taskflow)}

\vskip1.5em

* \small Informational Structure
  - \footnotesize Sensible grouping of content and actions \textcolor{Roarange}{(menus and tabs)}

\vskip1.5em

* \small Visual Structure
  - \footnotesize Attractive, clear organization of a screen's content \textcolor{Roarange}{(layout)}

#

\vspace{-1em}
\centering
\includegraphics[width=.65\textwidth]{images/ui/structure.png}

# Typography

::: columns
:::: column

* \small Type is about tone of \textcolor{Roarange}{voice, readability, legibility.}
* \small Diligently crafted type is paramount for effective \textcolor{Roarange}{communication}

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/ui/typography01.png}

::::
:::

# Typography

::: columns
:::: column

* \small Most design problems are simply type issues.
  - \footnotesize As a good rule, start your design with \textcolor{Roarange}{\textbf{three fonts}}
  - \footnotesize A font is any variation of:
    - \scriptsize typeface
    - \scriptsize size
    - \scriptsize weight
    - \scriptsize style
    - \scriptsize color
    - \scriptsize etc.

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/ui/typography01.png}

::::
:::

#

\vspace{-.5em}
\centering
\includegraphics[width=.6\textwidth]{images/ui/typography02.png}

#

\vspace{-.5em}
\centering
\includegraphics[width=.7\textwidth]{images/ui/typography03.png}

# Color

* \small Color follows the same constraints as type, with the exception that color gets to the core \textcolor{Roarange}{\textbf{emotional}} impact of the product in a more direct, visceral way that type does not.

* \textcolor{Buttons}{While type speaks, color punctuates}

\centering
\includegraphics[width=.55\textwidth]{images/ui/color.png}

#

\vspace{-.5em}
\centering
\includegraphics[width=.8\textwidth]{images/ui/color02.png}

#

\vspace{-.5em}
\centering
\includegraphics[width=.8\textwidth]{images/ui/color03.png}

# Color: where to start

::: columns
:::: column

* \small Pick a color palette of just a few core colors:
  - \footnotesize 1 base
  - \footnotesize 3 complements
  - \footnotesize 1 highlight
  - \footnotesize black/white
* \small Use the color system to solve functional issues first, then add expressive, emotive, brand qualities

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/ui/color04.png}

::::
:::

# Icons / Imagery

::: columns
:::: column

* \small Icons are visual indicators of
  - \footnotesize status
  - \footnotesize functionality
  - \footnotesize branding

::::
:::: column

* \small They should complement the main content, and not contribute to UI clutter or noise
* \small Just like type and color, should be used \textcolor{Roarange}{judiciously}

::::
:::

\centering
\includegraphics[width=.65\textwidth]{images/ui/icons01.png}

# Metaphors / Models

* \small \textcolor{Roarange}{A proper mental model drives good design}

\vskip.5em

* \small Expressed as a metaphor, it \textcolor{Roarange}{\textbf{frames}} the product properly in your mind

\vskip.5em

* \small Intentional & contextual, it shapes understanding of the product's purpose and how to use it

# Language

::: columns
:::: column

* \small Many design problems are simply issues of \textcolor{Roarange}{\textbf{poor terminology}}:
  - \footnotesize button labels
  - \footnotesize menu items
  - \footnotesize feature names
  - \footnotesize etc.

\vskip.5em

* \small Generally speaking, product language should be no more complicated than everyday conversation
  - \footnotesize \textcolor{Roarange}{Ask your target audience}

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/ui/language.png}

::::
:::

# Behavior

* \small A digital product is used to do something

\vskip.5em

* \small Interactive behavior, and specifically, the ability to \textcolor{Roarange}{\textbf{directly manipulate data}} with an input device as an intuitive, seamless extension of the user's hand/mind, are \textcolor{Roarange}{\textbf{critical}} in that regard

\vskip.5em

* \small \textcolor{Roarange}{Affordances, motion, feedback are key}

# Patterns

::: columns
:::: column

* \small \textcolor{Roarange}{A pattern describes an optimal solution to a common problem within a specific context}

\vskip.5em

* \small As common problems are tossed around a community and are resolved, common solutions often spontaneously emerge

\vskip.5em

* \small Eventually, the best of these rise above & reach the status of a Design Pattern

::::
:::: column

\begin{center}
\includegraphics[width=\textwidth]{images/ui/patterns01.eps}
\end{center}

::::
:::

# UI-Patterns.com

\centering
\includegraphics[width=.575\textwidth]{images/ui/patterns02.png}

# UI-Patterns.com

\centering
\includegraphics[width=.6\textwidth]{images/ui/patterns03.png}

# Principles

::: columns
:::: column

* \small Make it direct
* \small Keep it lightweight
* \small Stay on the page
* \small Provide an invitation
* \small Use transitions
* \small React immediately

::::
:::: column

* \small Focus on human goals
* \small Make it simple
* \small Inspire delight
* \small Exhibit craftsmanship
* \small Deliver unique value

::::
:::

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
