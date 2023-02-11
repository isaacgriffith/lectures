---
author:
- Isaac Griffith
title: UI Design Principles and Tools
institute: |
  SE 5520 - Software Construction and Configuration Management

  Department of Software Engineering

  Idaho State University
fontsize: 12pt
cornerLogo: "../../../images/spirit.png"
wideLogo: "../../../images/wide.png"
lowerCornerLogo: "../../../images/roar.eps"
...

# Outcomes

At the end of Today's Lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand and describe the general concepts of UI, UX, and User Centric Design
* Understand the ideas and basic methods of UI design
* Understand the general principles of UI Design
* Understand the fundamentals underlying UI Design
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{../../../images/brain-gears.jpg}
::::
:::

# Inspiration


#

\centering
\vfill
\begin{minipage}{.75\textwidth}
\begin{minipage}{3.5em}
\vskip-3em
\includegraphics[width=\textwidth]{../../../images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge UI Design
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# What is User Experience? (UX)

* Puts the end user at the center of the universe and defines the system from that perspective
* Usability is finding the best match between a user's needs and a product's use
* While this is a specialty by itself, a computer scientist/developer can grow an appreciation for UX, which affects
  1. Functionality
  2. System Organization and Structure
  3. Interactions and Look and Feel
  4. Access

# What is User Interface? (UI)

* **Human-Computer Interaction (HCI)** research is focused on the interfaces between people (users) and computers

* The point of interaction or communication between a computer and another entity, such as a printer or human operator. Information flows in one direction or two.

* The layout of an application's graphic, spoken, touch, or textural controls in conjunction with the way the application responds to user activity.

::: columns
:::: column
* UI fulfills two key UX needs:
  3. Interactions and Look and Feel
  4. Access
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

**People will call tech support**

\centering
\includegraphics[width=\textwidth]{images/ui/support_costs.png}

::::
:::: column

**People won't use it even when it works and will return it**

* E.g., an ISP had 30% of routers returned as non-working **but they tested fine**

**People won't buy your product and worse, will tell their friends not to use it**

* Measured by negative impact on Net Promoter Score (NPS)
  - Gauges the loyalty of a firm's customer relationships
  - Is thought to be correlated with revenue growth

::::
:::

# What is Design?

::: columns
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/ui/jobs.png}

::::
:::: column

"Most people make the mistake of thinking design is what it looks like. People think it's this veneer -- that the designers are handed this box and told, 'Make it look good!' That's not what we think design is. It's not just what it looks like and feels like. **Design is how it works**"

\begin{flushright}Steve Jobs\end{flushright}

* Design is hard
* Design is easy to overdo

::::
:::

# What is a Good Design?

\begin{block}

\begin{center}
\Large
A solution that \textbf{serves the users}\\
and \color{Roarange}\textbf{satisfies the client}\color{Black}
\end{center}

\end{block}

1. Does what the users need and want

\vskip1.5em

2. Natural to use

\vskip1.5em

3. Helps them avoid trouble

\vskip1.5em

\begin{block}

\centering
\Large \textbf{Easy to say, very hard to do well}

\end{block}

# User Centered Design

\centering
\Large

Puts the end user at the center of the

universe and defines the system from that

perspective

# User Centered Design

1. Identify who the users are

2. Identify what they want to accomplish

3. Constantly assess (1) and (2)

#

\centering
\vfill
\begin{minipage}{.75\textwidth}
\begin{minipage}{3.5em}
\vskip-3em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.75\textwidth}
\Huge How do we express designs?
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# Start with Paper Prototypes

::: columns
:::: column

* Karis and Virzi have shown you can often get the same design information from easier and cheaper to make low fidelity prototypes as from higher fidelity prototypes

::::
:::: column

\includegraphics[width=.95\textwidth]{images/ui/paper01.png}

::::
:::

\includegraphics[width=.75\textwidth]{images/ui/paper02.png}


# Paper Prototypes

\centering
\includegraphics[width=.75\textwidth]{images/ui/paper03.png}

# Fancier Example

\centering
\includegraphics[width=.75\textwidth]{images/ui/paper04.png}

# Wireframes

::: columns
:::: column

* You can also compose parts of these on a computer, of course (at various levels of detail, up to a full-fledged mockup).

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/ui/wireframe01.png}

::::
:::

# Wireframes

::: columns
:::: column
**Advantages**

1. Fast way to mock up an interface -- no coding required.
2. Finds a variety of problems with the interface
3. Allows an interface to be refined.
4. A multidisciplinary team can participate.

::::
:::: column

**Disadvantages**

1. Doesn't produce any code
2. Does not find all classes of problems with an interface
3. Can affect the way users interact with the interface
4. Has stronger benefits in some situations than in others

::::
:::

#

\centering
\vfill
\begin{minipage}{.85\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.725\textwidth}
\Huge Wireframing Example
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

#

\centering
\vfill
\begin{minipage}{.85\textwidth}
\begin{minipage}{3.5em}
\vskip-3em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.725\textwidth}
\Huge Nielsen's 10 Principles\\ of UI Design
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# 1. Match the real world

::: columns
:::: column

**Examples**

* Desktop
* Trashcan

**Dangers of metaphors**

1. Often hard for designers to find
2. Deceptive
3. Constraining
4. Breaking the metaphor

::::
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/ui/real.png}

::::
:::

* Using a metaphor doesn't excuse other bad design decisions

# Directly Manipulate Objects

* User interacts with visual representation of data objects
  - Continuous visual representation
  - Physical actions or labeled button presses
  - Rapid, incremental, reversible, immediately visible effects

* Examples
  - Files and folders on a desktop
  - Scrollbar
  - Dragging to resize a rectangle
  - Selecting text

* Visual representation and physical interaction are important

# Objects suggest actions for use

Perceived and actual properties of a thing that determine how the thing could be used

1. Chair is for sitting
2. Knob is for turning
3. Button is for pushing
4. Listbox is for selection
5. Scollbar is for continuous scrolling or panning

# Natural Mapping

::: columns
:::: column

* Physical arrangement of controls should match arrangement of function

* Best mapping is direct, but natural mappings don't have to be direct
  - Light switches
  - Stove burners
  - Turn signals
  - Audio mixer

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

* Examples
  - Push buttons
  - Scrollbars
  - Drag and drop

* Kinds of feedback
  - Visual
  - Audio
  - Haptic (conveyed by sense of touch)

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

* Users should not have to wonder whether different words, situations, or actions mean the same thing.

* Follow **platform conventions....**

::::
:::

# 3. Help and Documentation

::: columns
:::: {.column width=.3}

**Help should be**

1. Searchable
2. Context-sensitive
3. Task sensitive
4. Concrete
5. Short
6. \color{Roarange}\textbf{NOT NEEDED}\color{Black}

::::
:::: {.column width=.7}

\centering
\includegraphics[width=.95\textwidth]{images/ui/help.png}

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

1. Provide Undo
2. Long operations should be allowed to be paused/suspended
3. All dialogs should have a cancel button

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

1. Change cursor to indicate action
2. Use highlights to show selected objects
3. Use status bar to show progress

::::
:::

# 6. Flexibility and Efficiency

* Accelerators -- unseen by the novice user -- may often speed up the interaction for the expert user such that the system can cater to both inexperienced and experienced users. Allow users to tailor frequent actions.

::: columns
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/ui/flexibility01.png}

::::
:::: column

\centering
\includegraphics[width=.65\textwidth]{images/ui/flexibility02.png}

::::
:::

# 7. Recognition, Not Recall

::: columns
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/ui/recall.png}

::::
:::: column

Minimize the user's memory load by making objects, actions, and options visible

\vskip1em

The user should not have to remember information from one part of the dialog to another. Instructions for use of the system should be visible or easily retrievable whenever appropriate.

1. Use menus, not command languages
2. Use combo boxes, not textboxes
3. Use generic commands
4. All needed information must be visible

::::
:::

# 8. Error Prevention

::: columns
:::: column

* Even better than good error messages is a careful design which prevents a problem from occurring in the first place

* Either eliminate error-prone conditions or check for them and present users with a confirmation option before they commit to the action

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

* Error messages should be expressed in plain language (no codes), precisely indicate the problem, and constructively suggest a solution.

* And they should be polite...

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

* Dialogs should not contain information which is irrelevant or rarely needed.
* Every extra unit of information in a dialog competes with the relevant units of information and diminishes their relative visibility.

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{minipage}{3.5em}
\vskip-1em
\includegraphics[width=\textwidth]{images/bengal-black.png}
\end{minipage}
\begin{minipage}{.80\textwidth}
\Huge Fundamentals
\vskip-0.75em
\rule{.975\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}


# Grids / Layouts / Structure

* A well-designed UI must be grounded in strong layouts with a grid.
* \color{Roarange}Grids provide order, regularity, rhythm, and control\color{Black}
* Knowing how to work with grids is a vital interface design skill, which takes years to master

\centering
\includegraphics[width=\textwidth]{images/ui/grids.png}

# Grids / Layouts / Structure

* Navigational Structure
  - Easy, meaningful path \color{Roarange}(taskflow)\color{Black}

\vskip1.5em

* Informational Structure
  - Sensible grouping of content and actions \color{Roarange}(menus and tabs)\color{Black}

\vskip1.5em

* Visual Structure
  - Attractive, clear organization of a screen's content \color{Roarange}(layout)\color{Black}

#

\centering
\includegraphics[width=.75\textwidth]{images/ui/structure.png}

# Typography

* Type is about tone of \color{Roarange}voice, readability, legibility.\color{Black}
* Diligently crafted type is paramount for effective \color{Roarange}communication\color{Black}

\centering
\includegraphics[width=.45\textwidth]{images/ui/typography01.png}

# Typography

* Most design problems are simply type issues.
  - As a good rule, start your design with **three fonts**
  - A font is any variation of:
    - typeface
    - size
    - weight
    - style
    - color
    - et.

#

\centering
\includegraphics[width=.85\textwidth]{images/ui/typography02.png}

#

\centering
\includegraphics[width=.75\textwidth]{images/ui/typography03.png}

# Color

* Color follows the same constraints as type, with the exception that color gets to the core **emotional** impact of the product in a more direct, visceral way that type does not.

* \color{Roarange}While type speaks, color punctuates\color{Black}

\centering
\includegraphics[width=.75\textwidth]{images/ui/color.png}

#

\centering
\vfill
\includegraphics[width=\textwidth]{images/ui/color02.png}

#

\centering
\vfill
\includegraphics[width=\textwidth]{images/ui/color03.png}

# Color: where to start

::: columns
:::: column

* Pick a color palette of just a few core colors:
  - 1 base
  - 3 complements
  - 1 highligh
  - black/white
* Use the color system to solve functional issues first, then add expressive, emotive, brand qualities

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/ui/color04.png}

::::
:::

# Icons / Imagery

* Icons are visual indicators of
  - status
  - functionality
  - branding
* They should complement the main content, and not contribute to UI clutter or noise
* Just like type and color, should be used \color{Roarange}judiciously\color{Black}

\centering
\includegraphics[width=.75\textwidth]{images/ui/icons01.png}

# Metaphors / Models

* \color{Roarange}A proper mental model drives good design\color{Black}
* Expressed as a metaphor, it **frames** the product properly in your mind
* Intentional & contextual, it shapes understanding of the product's purpose and how to use it

# Language

* Many design problems are simply issues of **poor terminology**:
  - button labels
  - menu items
  - feature names
  - etc.
* Generally speaking, product language should be no more complicated than everyday conversation
  - \color{Roarange}Ask your target audience\color{Black}

\centering
\includegraphics[width=.45\textwidth]{images/ui/language.png}

# Behavior

* A digital product is used to do something
* Interactive behavior, and specifically, the ability to **directly manipulate data** with an input device as an intuitive, seamless extension of the user's hand/mind, are **critical** in that regard
* \color{Roarange}Affordances, motion, feedback are key\color{Black}

# Patterns

\footnotesize
* \color{Roarange}A pattern describes an optimal solution to a common problem within a specific context\color{Black}
* As common problems are tossed around a community and are resolved, common solutions often spontaneously emerge
* Eventually, the best of these rise above & reach the status of a Design Pattern

\begin{block}

\begin{center}
\includegraphics[width=.65\textwidth]{images/ui/patterns01.eps}
\end{center}

\end{block}

# UI-Patterns.com

\centering
\includegraphics[width=.75\textwidth]{images/ui/patterns02.png}

# UI-Patterns.com

\centering
\includegraphics[width=.75\textwidth]{images/ui/patterns03.png}

# Principles

::: columns
:::: column

* Make it direct
* Keep it lightweight
* Stay on the page
* Provide an invitation
* Use transitions
* React immediately

::::
:::: column

* Focus on human goals
* Make it simple
* Inspire delight
* Exhibit craftsmanship
* Deliver unique value

::::
:::

# Summary


# For Next Time

::: columns
:::: {.column width=.6}

::::
:::: {.column width=.4}
\centering
\includegraphics[width=.85\textwidth]{../../../images/next_time.png}
::::
:::

#

\centering
\vfill
\includegraphics[scale=.40]{../../../images/questions.png}

\Huge \textbf{Are there any questions?}
