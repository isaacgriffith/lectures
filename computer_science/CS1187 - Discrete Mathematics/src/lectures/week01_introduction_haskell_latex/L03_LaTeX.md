---
author:
- Dr. Isaac Griffith
title: Introduction to \LaTeX
shortTitle: LaTeX Intro
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Outcomes

After today's lecture you will:

::: columns
:::: {.column width=.7}
* Be introduced to the \LaTeX\ document processing system
* Understand how to create \LaTeX\ documents, including
  - \LaTeX\ Preamble (i.e., document class, authorship info, and the inclusion of packages)
  - Structuring \LaTeX\ documents
  - Creation of tables, figures, etc.
  - Basic components of formatting \LaTeX\ documents
  - Mathematical equations
  - Citations and Bibliographies
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
\begin{minipage}{.525\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Introduction to \LaTeX
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# The Philosophy Behind \LaTeX

* \small Problems with WYSIWYG editors such as MS Office and LibreOffice
  - \footnotesize Author is distracted from the proper business of composing text, in favor of making typographical choices in relation to which they may have no expertise
    * \scriptsize i.e., fiddling with fonts and margins when they should be concentrating on content
  - \footnotesize Making changes to the whole document i.e., section headings, numbering of figures, references and tables is tedious
  - \footnotesize Does not encourage concern with document structure

# Many Reasons to use \LaTeX

* \small The typesetting of mathematical formulae is supported in a convenient and powerful always

\vskip.5em

* \small Users only need to learn a few easy-to-understand commands that specify the logical structure of a document.
  - \footnotesize They almost never need to tinker with the actual layout of the document

\vskip.5em

* \small Even complex structures such as footnotes, references, table of contents, and bibliographies can be generated easily

\vskip.5em

* \small \LaTeX\ encourages authors to write well-structured texts, because this is how \LaTeX\ works: by specifying structure

\vskip.5em

* \small \TeX, the formatting engine of \LaTeX2e, is highly portable and free
  - \footnotesize Therefore the system runs on almost any hardware platform available

# \TeX, \LaTeX\ and \LaTeX2e

* \small Rather than attempting to be all things in a single program, \TeX\ is designed with modularity in mind.
  - \footnotesize Thus \TeX\ itself provides only fundamental typesetting capabilities and does not incorporate editing, printing, or previewing capabilities

\vskip.5em

* \small \LaTeX\ (pronounced "Lay-tech" or "Lah-tech"), is a \TeX\ macro package written by Leslie Lamport (1980's), that allows authors to use \TeX\ easily and uses \TeX\ as its formatting engine

\vskip.5em

* \small \LaTeX2e is the name used when distinguishing the current version of \LaTeX\ from its predecessor, \LaTeX\ 2.09

# \TeX, \LaTeX\ and \LaTeX2e

The typesetting operations of \TeX\ are applied on a very low level. They address the tasks of

* \small Stringing characters together in words and paragraphs

\vskip.5em

* \small Positioning symbols properly in mathematical formulas

\vskip.5em

* \small Automatically finding good page breaks

\vskip.5em

* \small Dealing with footnotes and other floating objects (such as figures and tables)

# \TeX, \LaTeX\ and \LaTeX2e

* \small By design \TeX\ is almost always used in conjunction with an auxiliary piece of software called a \TeX\ format
  - \footnotesize The purpose of this tool is to bridge the gap between the low-level typesetting functions of \TeX\ and
  - \footnotesize A higher-level interface more suitable for authors

\vskip.5em

* \small A \TeX\ format is made by assembling all of the \TeX\ macros that define the higher-level interface and precompiling them as a unit in order to reduce start-up time
  - \footnotesize \textbf{\LaTeX\ and \LaTeX2e are \TeX\ formats}

# How it Works

* \small 1st step is to type the file that \TeX\ reads, usually called the \TeX\ file or the input file, using a simple text editor and saved in ASCII mode without any special control characters

\vskip.5em

* \small The \TeX\ program then reads your input file and produces a DVI file (Device Independent)
  - \footnotesize This file is not readable

\vskip.5em

* \small The DVI file is then read by another program (called a device driver)
  - \footnotesize Produces the output htat is readable by humans

\vskip.5em

* \small Why the extra file?
  - \footnotesize The same DVI file can be read by different device drivers to produce output on a printer, screen, or phototypesetter

\vskip.5em

* \small Once you have produced a DVI file that gives the right output, you can be assured that you will get the same output on all other devices

# \LaTeX\ Editors

* \small \TeX\ Studio -- Windows
* \small Atom -- All OS
* \small Kile -- Linux
* \small Overleaf -- Online

\vfill
\centering
\large \textcolor{Roarange}{For this course we will be using Overleaf}

#

\centering
\vfill
\begin{minipage}{.475\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Document Layout
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Input File Structure

* \small When \LaTeX2e processes an input file, it expects it to follow a certain structure.
  - \footnotesize Thus every input file just start with the command:

    \vskip.5em

    `\documentclass{...}`

    \vskip.5em

  - \footnotesize This specifies what sort of document you intend to write.

\vskip.5em

* \small After that, add commands to influence the style of the whole document, or load packages that add new features to the \LaTeX\ system
  - \footnotesize To load such a package you use the command

    \vskip.5em

    `\usepackage{...}`

# Input File Structure

* \small When all the setup work is done, you start the body of the text with the command

  \vskip.5em

  `\begin{document}`

\vskip.5em

* \small Now you enter the text miexed with some useful \LaTeX\ commands. You end the document with the following command

  \vskip.5em

  `\end{document}`

\vskip.5em

* \small Anything following that command will be ignored

# Document Classes

* \small The first thing \LaTeX\ needs to know when processing an input file is the type of document the author wants to create.
  - \footnotesize This is specified with the `\documentclass` command

    \vskip.5em

    `\documentclass[options]{class}`

    \vskip.5em

  - \footnotesize Here `class` specifies the type of document to be created
  - \footnotesize The `options` parameter customizes the behavior of the document class
    * \scriptsize options need to be separated by commas

* \small \textcolor{Roarange}{\textbf{Example:}}

  \vskip.5em

  `\documentclass[11pt,twoside,a4paper]{article}`

# Document Classes

\scriptsize
+-----------+---------------------------------------------------------------------+
| `class`   | `description`                                                       |
+:==========+:====================================================================+
| `article` | for articles in scientific journals, presentations                  |
|           | short reports, program documentation, invitations \vskip0.5em       |
+-----------+---------------------------------------------------------------------+
| `proc`    | a class for proceedings based on the article class \vskip.5em       |
+-----------+---------------------------------------------------------------------+
| `minimal` | is as small as it can get. It only sets a page size                 |
|           | and a base font. It is manly used for debugging purposes \vskip.5em |
+-----------+---------------------------------------------------------------------+
| `report`  | for longer reports containing several chapters,                     |
|           | small books, Master's and PhD theses \vskip.5em                     |
+-----------+---------------------------------------------------------------------+
| `book`    | for real books \vskip.5em                                           |
+-----------+---------------------------------------------------------------------+
| `beamer`  | the \LaTeX\ version of Powerpoint                                    |
+-----------+---------------------------------------------------------------------+

# Document Class Options

\scriptsize
+---------------------+---------------------------------------+
| `option`            | `description`                         |
+:====================+:======================================+
| 10pt/11pt/12pt      | Font size \vskip0.5em                 |
+---------------------+---------------------------------------+
| letterpaper/a4paper | Paper size \vskip0.5em                |
+---------------------+---------------------------------------+
| twocolumn           | Use two columns \vskip0.5em           |
+---------------------+---------------------------------------+
| twoside             | Set margins for two-sided \vskip0.5em |
+---------------------+---------------------------------------+
| draft               | Double-space lines                    |
+---------------------+---------------------------------------+

# Packages

* \small There are some functionalities that you won't be able to do with basic \LaTeX

\vskip.5em

* \small Including graphics, color, etc. requires enhancing capabilities by including packages using the `\usepackage[options]{package}` command in the preamble of your document

\vskip.5em

* \small Comprehensive \TeX\ Archive Network (CTAN) is the central source for all packages

\vskip.5em

* \small [http://www.ctan.org](http://www.ctan.org)

# Packages

* \small Common Packages to include:
  - \footnotesize `graphicx` - for graphics
  - \footnotesize `algorithm` and `algpseudocode` - for algorithms
  - \footnotesize `listings` - for code listings
  - \footnotesize `multirow` and `multicol` - for multiple row or multiple column cells in tables
  - \footnotesize `amssymb` and `amsmath` - for mathematical symbols
  - \footnotesize `xcolor` with option `svgnames` - for defining colors
  - \footnotesize `url` - to insert a url with the `\url{...}` command

# Document Title Information

Before the `\begin{document}`

* \small Author Information is added with the `\author{...}` directive
* \small Title of document is added with the `\title{...}` directive
* \small Date of a document is set with the `\date{...}` directive

After `\begin{document}`

* \small Making the title
  - \footnotesize Typically right after we start the body of the document with `\begin{document}`, we issue the `\maketitle` declaration
  - \footnotesize `\maketitle` is a macro which will take all of the information necessary and format the title components

# Fundamentals

* \small \LaTeX\ commands or directives are case sensitive

\vskip.5em

* \small They start with a backslash \\ and then have a name consisting of letters only

\vskip.5em

* \small Command names are terminated by a space

\vskip.5em

* \small Some commands require a parameter, which has to be given between curly braces `{}` after the command name

  \vskip.5em

* \small Some commands take optional parameters, which are inserted after the command name in square brackets `[]`

\vskip.5em

* \small The `%` character is used to comment out a line

# Environments

* \small Environments define special sections of text to be formatted in a particular way.

::: columns
:::: column
* \small All environments use the following structure:

  \footnotesize
  ```latex
    \begin{environment}
    text
    \end{environment}
  ```

  - \footnotesize Where `environment` is the name of the environment

::::
:::: column

* \small Additionally, environments can be nested within each other as long as the correct nesting order is maintained

  \footnotesize
  ```latex
    \begin{aaa}
      text
      \begin{bbb}
        text
      \end{bbb}
      text
    \end{aaa}
  ```

::::
:::

#

\centering
\vfill
\begin{minipage}{.57\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Document Body
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 1187}
\end{minipage}

# Document Structure

* \small A document can be decomposed into several components:
  - \footnotesize `\part{title}` - sections of a book, the highest subdivision
  - \footnotesize `\chapter{title}` - chapters of a book
  - \footnotesize `\section{title}` - section of a document
  - \footnotesize `\subsection{title}` - subsection of a section
  - \footnotesize `\subsubsection{title}` - a sub-subsection of a subsection
  - \footnotesize `\paragraph{title}` - a titled paragraph in a section/subsection/subsubsection
  - \footnotesize `\subparagraph{title}` - a titled subparagraph

\vskip.5em

* \small Note that each of these components will be numbered. You can opt to have unnumbered items
  if you follow the name with a star
  - \footnotesize Example: `\section*{title}` will create an unnumbered titled section.

# Spaces

::: columns
:::: column

\underline{Input}:

\small
```
It does not matter whether
you enter one or      several
spaces after a word.

An empty line starts a new
paragraph.
```

\vskip.5em

\underline{Output}:

\small
\vskip.5em

It does not matter whether you enter one or several spaces after a word.

An empty line starts a new paragraph.

::::
:::: column

* \small Whitespace characters, such as blank or tab, are treated uniformly as a space by \LaTeX

\vskip.25em

* \small Several consecutive whitespace characters are treated as one space

\vskip.25em

* \small Whitespace at the start of a line is generally ignored, and a single line break is treated as whitespace

\vskip.25em

* \small An empty line between two lines of text defines the end of a paragraph

\vskip.25em

* \small Several empty lines are treated the same as one empty line

::::
:::

# Special Characters

* \small The following symbols are reserved characters that either have a special meaning in \LaTeX\ or are not available in all the fonts.
  - \footnotesize If you enter them directly in your text, they will normally not print, but rather coerce \LaTeX\ to do things you did not intend.

    \vskip.5em
    \footnotesize
    `   # $ % ^ & _ { } ~ \ |`

    \vskip.5em

  - \footnotesize Insert a backslash before these characters to get the desired result

    \vskip.5em
    \footnotesize
    `   \# \$ \% \^ \{ \} \& \_ \~ \textbackslash \textbar`

# List Environments

\footnotesize

::: columns
:::: column

```latex
\flushleft
\begin{enumerate}
\item You can nest the list environments to
 your taste:
\begin{itemize}
\item But it might start to look silly.
\item[-] With a dash.
\end{itemize}
\item Therefore remember:
\begin{description}
\item[Stupid] things will not become
smart because they are in a list.
\item[Smart] things, though, can be
presented beautifully in a list.
\end{description}
\end{enumerate}
```

::::
:::: column

\flushleft
\begin{enumerate}
\item \small You can nest the list environments to your taste:
\begin{itemize}
\footnotesize
\item But it might start to look silly.
\item[-] With a dash.
\end{itemize}
\item \small Therefore remember:
\begin{description}
\footnotesize
\item[\footnotesize \textcolor{Roarange}{Stupid}] things will not become
smart because they are in a list.
\item[\footnotesize \textcolor{Roarange}{Smart}] things, though, can be
presented beautifully in a list.
\end{description}
\end{enumerate}

::::
:::

# Floating Bodies

* \small Often in LaTeX we need to add objects, which float within the document as the text changes, these include
  * \footnotesize Tables
  * \footnotesize Figures
  * \footnotesize Equations

\footnotesize

::: columns
:::: {.column width=.333}
\textcolor{Roarange}{\textbf{Tables}}

```
    \begin{table}[t]
    \centering
    \caption{Caption}
    \label{tab:label}
    \begin{tabular}
    ...
    \end{tabular}
    \end{table}
```
::::
:::: {.column width=.333}
\textcolor{Roarange}{\textbf{Figures}}

```
\begin{figure}[b]
\centering
\includegraphics[options]{file}
\caption{caption}
\label{fig:label}
\end{figure}
```
::::
:::: {.column width=.333}
\textcolor{Roarange}{\textbf{Equations}}

```
    \begin{equation}[H]
    \centering
    ...
    \caption{Caption}
    \label{eqn:label}
    \end{equation}
```
::::
:::


# Text Properties

::: columns
:::: column

* \small Font Families
  - \footnotesize Roman: `\textrm{text}` or `\rmfamily text`
  - \footnotesize Sans serif: `\textsf{text}` or `\sffamily text`
  - \footnotesize Typewriter: `\texttt{text}` or `\ttfamily text`

::::
:::: column

* \small Font Styles
  - \footnotesize Medium: `\textmd{text}` or `\mdseries text`
  - \footnotesize Bold: `\textbf{text}` or `\bfseries text`
  - \footnotesize Italics: `\textit{text}` or `\itseries text`
  - \footnotesize Small Caps: `\textsc{text}` or `\scshape text`
  - \footnotesize Emphasized: `\emph{text}` or `\em text`
  - \footnotesize Slanted: `\textsl{text}` or `\slshape text`
  - \footnotesize Upright: `\textup{text}` or `\upshape text`
  - \footnotesize Underline: `\underline{text}`

::::
:::

* \small Note that the command forms handle spacing better than the declaration forms

# Font size

* \small Although we can directly set the font size, it is typically best to utilize the built-in declarations

::: columns
:::: {.column width=.1}
::::
:::: {.column width=.45}

- \footnotesize `\tiny`
- \footnotesize `\scriptsize`
- \footnotesize `\footnotesize`
- \footnotesize `\small`
- \footnotesize `\normalsize`

::::
:::: {.column width=.45}

- \footnotesize `\large`
- \footnotesize `\Large`
- \footnotesize `\LARGE`
- \footnotesize `\huge`
- \footnotesize `\Huge`

::::
:::

* \small As these are declarations, they will apply to everything following them, to reduce this we can use braces surrounding the section we want to change the font of.
  `{\small ...}`

# Justification

* \small Default justification is fully-justified
* \small Center - Text can be center justified as follows
  - \footnotesize Environment: `\begin{center} ... \end{center}`
  - \footnotesize Declaration: `\centering`
* \small Left - Text can be left justified as follows
  - \footnotesize Environment: `\begin{flushleft} ... \end{flushleft}`
  - \footnotesize Declaration: `\raggedleft`
* \small Right - Text can be right justified as follows:
  - \footnotesize Environment: `\begin{flushright} ... \end{flushright}`
  - \footnotesize Declaration: `\raggedright`
* \small I suggest that you use the package `ragged2e` which provides some useful refinements to the above

# Delimiters

* \small Quotes: ``` ``text'' ``` this produces "text",
  - \footnotesize Starts with two backticks, ends with two single quote marks

\vskip.5em

* \small Braces: curly braces denote a block in \TeX, thus you need to escape them as follows: `\{ \}`
  - \footnotesize Parentheses and square brackets can be use as is
  - \footnotesize angle brackets (less than or greater than) need a special command:
    * \scriptsize `\textless`
    * \scriptsize `\textgreater`

# Line Breaking and Page Breaking

* \small Books are often typeset with each line having the same length.
  - \footnotesize \LaTeX\ inserts the necessary line breaks and spaces between words by optimizing the contents of a whole paragraph

\vskip.5em

* \small If necessary, it also hyphenates words that would not fit comfortably on a line.
  - \footnotesize How the paragraphs are typeset depends on the document class.
  - \footnotesize Normally the first line of a paragraph is indented, and there is no additional space between two paragraphs
    * \scriptsize To prevent indent use `\noindent`

\vskip.5em

* \small In special cases it might be necessary to order \LaTeX\ to break a line
  - \footnotesize `\\` or `\newline` starts a new line without starting a new paragraph
  - \footnotesize `\\*` additionally prohibits a page break after a forced line break
  - \footnotesize `\newpage` starts a new page

# Tables

* \small To create a table use the `\begin{tabular}{cols} content \end{tabular}` environment

\vskip.5em

* \small The `cols` option has the following basic specification
  - \footnotesize for each column we want, we add a "l", "c", or "r", for left-, center-, or right-aligned column
  - \footnotesize if we want vertical lines before or after a column, we add a "|" before or after the columns letter in the options

\vskip.5em

* \small Rows are then a line of data where each cell of the row is separated by an "\&" and the line is ended with a "\\"
  - \footnotesize if we wish to have a line between (or above/below a row) we need to use the `\hline` command

# Table Example

::: columns
:::: column

```latex
\begin{table}[!th]
 \begin{tabular}{|l|c|r|}
  \hline
  first & row & data \\ \hline
  second & row & data \\
  \hline
 \end{tabular}
 \caption{This is the caption}
 \label{tab:table}
\end{table}
```

::::
:::: column

\begin{table}[!th]
 \begin{tabular}{|l|c|r|}
  \hline
  first & row & data \\ \hline
  second & row & data \\
  \hline
 \end{tabular}
 \caption{This is the caption}
 \label{tab:table}
\end{table}

::::
:::

* \small Note that we reference something that has a `\label{something}` using the `\ref{something}` command.

# Math Mode

* \small Equations
  - \footnotesize For inline math: `\{ ... \}` or `$ ... $`
  - \footnotesize For numbered eqns: `\[ ... \]` or `\begin{equation}...\end{equation}`

* \small You can write any basic equation:

::: columns
:::: {.column width=.05}
::::
:::: {.column width=.4}
  - \footnotesize `$4x + 5 = 17$`
  - \footnotesize Superscript: `$x^{y}$` yields $x^{y}$
  - \footnotesize Subscript: `$x_{y}$` yields $x_{y}$
  - \footnotesize Fractions: `$\frac{x}{y}$` yields $\frac{x}{y}$
  - \footnotesize Roots: `$\sqrt[n]{x}$` yields $\sqrt[n]{x}$
::::
:::: {.column width=.55}
  - \footnotesize Sums:
    * \scriptsize `$\sum_{k=1}^n x$` yields $\sum_{k=1}^n x$
    * \scriptsize `$\overset{n}{\underset{k=1}{\sum}}x$` yields $\overset{n}{\underset{k=1}{\sum}}x$
  - \footnotesize Products:
    * \scriptsize `$\prod_{k=1}^n x$` yields $\prod_{k=1}^n x$
    * \scriptsize `$\overset{n}{\underset{k=1}{\prod}}x$` yields $\overset{n}{\underset{k=1}{\prod}}x$
::::
:::

# Biliographies

* \small We construct bibliographies using the BibTeX format.
* \small Bibliographies are stored in files ending in "*.bib" extension
* \small We can then include these in our documents (before the `\end{doucment}`) as follows:
  - \footnotesize We first set the bibliography style using: `\biliographstyle{style}`
  - \footnotesize We then set the bibliography file (using the filename without the `.bib` extension): `\bibliograph{filename}`

\vskip.5em

* \small The basic bibliography styles include:
  - \footnotesize Standard: `abbrv`, `alpha`, `plain`
  - \footnotesize APA: `apa`
  - \footnotesize Unsorted: `unsrt`
  - \footnotesize Alpha + Abstract: `abstract`

# BibTeX

* \small BibTeX is a tool for processing citations with \LaTeX
  - \footnotesize Overleaf handles processing this for you.
* \small The particular format of BibTeX files is a collection of BibTeX entries
  - \footnotesize Each entry has one of the following types:

\scriptsize
+--------------------------------------------+---------------------------------------------+--------------------------------------------+----------------------------------------------------+
| \textcolor{Roarange}{\textbf{Entry Type}}  | \textcolor{Roarange}{\textbf{Description}}  | \textcolor{Roarange}{\textbf{Entry Type}}  | \textcolor{Roarange}{\textbf{Description}}         |
+:===========================================+:============================================+:===========================================+:===================================================+
| `@article`                                 | Journal or magazine article                 | `@book`                                    | Book with publisher \vskip.5em                     |
+--------------------------------------------+---------------------------------------------+--------------------------------------------+----------------------------------------------------+
| `@booklet`                                 | Book without publisher                      | `@conference`                              | Article in conference proceedings \vskip.5em       |
+--------------------------------------------+---------------------------------------------+--------------------------------------------+----------------------------------------------------+
| `@inbook`                                  | A part of a book and/or range of pages      | `@incollection`                            | A part of book with its own title \vskip.5em       |
+--------------------------------------------+---------------------------------------------+--------------------------------------------+----------------------------------------------------+

# BibTeX

\scriptsize
+--------------------------------------------+---------------------------------------------+--------------------------------------------+----------------------------------------------------+
| \textcolor{Roarange}{\textbf{Entry Type}}  | \textcolor{Roarange}{\textbf{Description}}  | \textcolor{Roarange}{\textbf{Entry Type}}  | \textcolor{Roarange}{\textbf{Description}}         |
+:===========================================+:============================================+:===========================================+:===================================================+
| `@misc`                                    | If nothing else fits                        | `@phdthesis`                               | PhD Thesis \vskip.5em                              |
+--------------------------------------------+---------------------------------------------+--------------------------------------------+----------------------------------------------------+
| `@proceedings`                             | Proceedings of a conference                 | `@techreport`                              | Tech report, usually numbered in series \vskip.5em |
+--------------------------------------------+---------------------------------------------+--------------------------------------------+----------------------------------------------------+
| `@unpublished`                             | Unpublished manuscript                      |                                            |                                                    |
+--------------------------------------------+---------------------------------------------+--------------------------------------------+----------------------------------------------------+

* \small The general syntax is as follows: `@type{key, ...}`
  - \footnotesize Where type is an entry type from the table, and `key` is a unique alphanumeric key within the file

# BibTeX

* \small Each BibTeX entry is then composed of several fields, not all of which must be filled in.

\scriptsize
+---------------------------------------+---------------------------------------------+---------------------------------------+--------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Field}}  | \textcolor{Roarange}{\textbf{Description}}  | \textcolor{Roarange}{\textbf{Field}}  | \textcolor{Roarange}{\textbf{Description}}             |
+:======================================+:============================================+:======================================+:=======================================================+
| `address`                             | Address of publisher                        | `author`                              | Names of authors \vskip.5em                            |
+---------------------------------------+---------------------------------------------+---------------------------------------+--------------------------------------------------------+
| `booktitle`                           | Title of book when part of it is cited      | `chapter`                             | Chapter or section number \vskip.5em                   |
+---------------------------------------+---------------------------------------------+---------------------------------------+--------------------------------------------------------+
| `edition`                             | Edition of a book                           | `editor`                              | Name of editors \vskip.5em                             |
+---------------------------------------+---------------------------------------------+---------------------------------------+--------------------------------------------------------+
| `institution`                         | Sponsoring institution of tech. report.     | `journal`                             | Journal name \vskip.5em                                |
+---------------------------------------+---------------------------------------------+---------------------------------------+--------------------------------------------------------+
| `month`                               | Month published (3-letter abbrev.)          | `note`                                | Any additional information \vskip.5em                  |
+---------------------------------------+---------------------------------------------+---------------------------------------+--------------------------------------------------------+

# BibTeX

* \small Each BibTeX entry is then composed of several fields, not all of which must be filled in.

\scriptsize
+---------------------------------------+---------------------------------------------+---------------------------------------+--------------------------------------------------------+
| \textcolor{Roarange}{\textbf{Field}}  | \textcolor{Roarange}{\textbf{Description}}  | \textcolor{Roarange}{\textbf{Field}}  | \textcolor{Roarange}{\textbf{Description}}             |
+:======================================+:============================================+:======================================+:=======================================================+
| `number`                              | Number of journal or magazine               | `organization`                        | Organization that sponsors a conference \vskip.5em     |
+---------------------------------------+---------------------------------------------+---------------------------------------+--------------------------------------------------------+
| `pages`                               | Page range (`2,6,9--12`)                    | `publisher`                           | Publisher's name \vskip.5em                            |
+---------------------------------------+---------------------------------------------+---------------------------------------+--------------------------------------------------------+
| `school`                              | Name of school (for thesis)                 | `series`                              | Name of series of books \vskip.5em                     |
+---------------------------------------+---------------------------------------------+---------------------------------------+--------------------------------------------------------+
| `title`                               | Title of work                               | `type`                                | Type of tech. report., e.g. "Research Note" \vskip.5em |
+---------------------------------------+---------------------------------------------+---------------------------------------+--------------------------------------------------------+
| `volume`                              | Volume of a journal or book                 | `year`                                | Year of publication \vskip.5em                         |
+---------------------------------------+---------------------------------------------+---------------------------------------+--------------------------------------------------------+

# BibTeX Example

```bibtex
  @Article{WC:1953,
    author  = {James Watson and Frances Crick},
    title   = {A structure for Dexoxyribose Nucleic Acid},
    journal = N,
    volume  = {171}
    pages   = {737},
    year    = 1953
  }
```

# Managing References

* \small Typically, I would suggest using a tool to manage your references, and then use it to generate the BibTeX file for you

\vskip.5em

* \small Such tools include
  - \footnotesize Zotero
  - \footnotesize Mendely
  - \footnotesize EndNote
  - \footnotesize RefWorks

\vskip.5em

* \small Each has its benefits and drawbacks and each of these integrates with Overleaf, to automate BibTeX generation

# Citations

* \small When you need to cite a reference item in your document, you need two things:
  - \footnotesize A key, as defined in the BibTeX file
  - \footnotesize The right command

\vskip.5em

* \small The commands that can be used for citing items are:
  - \footnotesize `\cite{key}` - cites the full author list and year i.e., "(Watson and Crick 1953)".
  - \footnotesize `\citeA{key}` - Full author list i.e., "(Watson and Crick)"
  - \footnotesize `\citeN{key}` - Full author list and year i.e., "Watson and Crick (1953)"
  - \footnotesize `\citeyear{key}` - cites the year only i.e., "(1953)"

\vskip.5em

* \small Note that different reference styles will cite differently, additionally they may user different commands.
  - \footnotesize Be sure to read the documentation on how to use the particular class or template you have selected

# Miscellaneous Commands

* \small `\today` - Generates the current date

\vskip.5em

* \small `$\sim$` - Generates a $\sim$ in math mode

\vskip.5em

* \small `\hspace{l}` - Generates a Horizontal space of length $l$ (e.g., $l = 1.5em$)

\vskip.5em

* \small `\vspace{l}` - Generates a Vertical space of length $l$

\vskip.5em

* \small `\rule{w}{h}` - Creates a line of width $w$ and height $h$

# Typical CS Document Classes

* \small In Computer Science we tend to use several specific formats:
  - \footnotesize IEEE Transactions
    * \scriptsize Document Class: `IEEEtran` with options (`journal`, `compsoc`, `conference`)
    * \scriptsize Bibliography Style: `IEEEtran`
  - \footnotesize ACM
    * \scriptsize Document Classes: `acmart` has multiple options
    * \scriptsize Bibliography Style: `ACM-Reference-Format`

\vskip.5em

* \small These are available on Overleaf.com to be used as templates

\vskip.5em

* \small For this course, our homework will be using the document class `homework` from the template `Gij's Homework Template` found on Overleaf.com

# For Next Time

::: columns
:::: column
* Review LaTeX Tutorial
* Review this Lecture
* Come To Lecture
* Read DMA Chapter 3
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
