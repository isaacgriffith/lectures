---
author:
- Dr. Isaac Griffith
title: Introduction to Software Quality
institute: |
  CS 3321

  Department of Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

#

\centering
\vfill
\begin{minipage}{.5\textwidth}
\begin{center}
\includegraphics[width=22pt]{images/bengal-black.png}
\Huge Software Quality
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 3321}
\end{minipage}

# Software quality management

* Concerned with ensuring that the required level of quality is achieved in a software product.

**Three principal concerns:**

- **Organizational Level**
  1. establishing a framework of processes and standards that will lead to high-quality software.
- **Project Level**
  2. application of specific quality processes
  3. establishing a quality plan for a project
     - Includes project quality goals
     - Defines processes and standards to be used.

# Scope of quality management

* Quality management is particularly important for large, complex systems. The quality documentation is a record of progress and supports continuity of development as the development team changes.
* For smaller systems, quality management needs less documentation and should focus on establishing a quality culture.
* Techniques have to evolve when agile development is used.

# Software quality

* Quality, simplistically, means that a product should meet its specification.
* This is problematical for software systems
  - There is a tension between customer quality requirements (efficiency, reliability, etc.) and developer quality requirements (maintainability, reusability, etc.);
  - Some quality requirements are difficult to specify in an unambiguous way;
  - Software specifications are usually incomplete and often inconsistent.
* The focus may be ‘fitness for purpose’ rather than specification conformance.

# Software fitness for purpose

* Has the software been properly tested?
* Is the software sufficiently dependable to be put into use?
* Is the performance of the software acceptable for normal use?
* Is the software usable?
* Is the software well-structured and understandable?
* Have programming and documentation standards been followed in the development process?

# Non-functional characteristics

* The subjective quality of a software system is largely based on its non-functional characteristics.
* This reflects practical user experience – if the software’s functionality is not what is expected, then users will often just work around this and find other ways to do what they want to do.
* However, if the software is unreliable or too slow, then it is practically impossible for them to achieve their goals.

# Software Quality and ISO/IEC 25010

::: columns
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/quality/iso25k_product.eps}

::::
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/quality/iso25k_use.eps}

::::
:::

# Quality conflicts

* It is not possible for any system to be optimized for all of these attributes – for example, improving robustness may lead to loss of performance.
* The quality plan should therefore define the most important quality attributes for the software that is being developed.
* The plan should also include a definition of the quality assessment process, an agreed way of assessing whether some quality, such as maintainability or robustness, is present in the product.

# Process and product quality

* The quality of a developed product is influenced by the quality of the production process.
* This is important in software development as some product quality attributes are hard to assess.
* However, there is a very complex and poorly understood relationship between software processes and product quality.
  - The application of individual skills and experience is particularly important in software development;
  - External factors such as the novelty of an application or the need for an accelerated development schedule may impair product quality.

# Process-based quality

\begin{center}
\includegraphics[width=.85\textwidth]{images/quality/quality02.eps}
\end{center}

# Quality culture

* Quality managers should aim to develop a ‘quality culture’ where everyone responsible for software development is committed to achieving a high level of product quality.
* They should encourage teams to take responsibility for the quality of their work and to develop new approaches to quality improvement.
* They should support people who are interested in the intangible aspects of quality and encourage professional behavior in all team members.
