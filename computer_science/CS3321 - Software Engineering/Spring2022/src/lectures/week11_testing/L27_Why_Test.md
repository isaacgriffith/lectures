---
author:
- Dr. Isaac Griffith
title: Why Do We Test Software?
course: CS 3321
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Inspiration

\vfill

> "A true professional does not waste the time and money of other people by handing over software that is not reasonably free of obvious bugs; that has not undergone minimal unit testing; that does not meet the specifications and requirements; that is gold-plated with unnecessary features; or that looks like junk." -- *Daniel Read*


# Outcomes

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}
* Understand the current nature of software.
* Understand the difference between a fault, an error, and a failure.
* Understand the cost of software failures
* Understand the testing in the 21st century
* Understand test process maturity.
* Understand the goals of software testing.
::::
:::: {.column width=.25}
\vfill
\vspace{7.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\titleslide{.85\textwidth}{The 21st Century}

# Testing in the 21st Century

::: columns
:::: column

* Software defines **behavior**
  - network routers, finance, switching networks, other infrastructure
* Today's software **market**:
  - is much **bigger**
  - is more **competitive**
  - has more **users**

::::
:::: column

* **Embedded Control** Applications
  - airplanes, air traffic control
  - spaceships
  - smartphones
  - memory seats
* **Agile** processes put increased pressure on testers
  - **Programmers** must **unit** test - with no training or education!
  - Tests are key to **functional requirements** - but who builds those tests?

::::
:::

# Software is a Skin of Civilization

\begin{center}
\includegraphics[width=.75\textwidth]{images/Testing/WhyTest/skin.eps}
\end{center}

# Software Faults, Errors \& Failures

* **Software Fault**: A static defect in the software

\vskip.5em

* **Software Failure**: External, incorrect behavior with respect to the requirements or other description of the expected behavior

\vskip.5em

* **Software Error**: An incorrect internal state that is the manifestation of some fault

\vskip1.5em

\begin{center}
\large\textbf{Faults in software are equivalent to design\\mistakes in hardware.\\Software does not degrade.}
\end{center}

# Fault and Failure Example

* A patient gives a doctor a list of **symptoms**
  - **Failures**

\vskip.5em

* The doctor tries to diagnose the root cause, the **ailment**
  - **Fault**

\vskip.5em

* The doctor may look for **anomalous internal conditions** (high blood pressure, irregular heartbeat, bacteria in the blood stream)
  - **Errors**

\vskip1em

\begin{center}
\large\textbf{Most medical problems result from external attacks (bacteria, viruses) or physical degradation as we age. Software faults were there at the beginning and do not "appear" when a part wears out.}
\end{center}

# A Concrete Example

::: columns
:::: column

\vskip-3em

\footnotesize

```java
public static int numZero(int[] arr)
{
  // Effects: if arr is null throw
  // NullPointerException
  // else return the number of
  // occurrences of 0 in arr
  int count = 0;
  for (int i = 1; i < arr.length; i++)
  {
    if (arr[i] == 0) {
      count++;
    }
  }
  return count;
}
```
::::
:::: column

\pause

* **Fault**: Should start search at 0, not 1

\pause

* Test 1:
  - Input: [2, 7, 0]
  - Expected: 1
  - **Error**: i is 1, not 0, on the first iteration
  - **Failure**: none
::::
:::

# A Concrete Example

::: columns
:::: column

\vskip-3em

\footnotesize

```java
public static int numZero(int[] arr)
{
  // Effects: if arr is null throw
  // NullPointerException
  // else return the number of
  // occurrences of 0 in arr
  int count = 0;
  for (int i = 1; i < arr.length; i++)
  {
    if (arr[i] == 0) {
      count++;
    }
  }
  return count;
}
```
::::
:::: column
* **Fault**: Should start search at 0, not 1

\pause

* Test 2:
  - Input: [0, 2, 7]
  - Expected: 1
  - **Error**: i is 1, not 0, Error propagates to the variable count
  - **Failure**: count is 0 at the return statement
::::
:::

# The Term Bug

* **Bug** is used informally
* Sometimes **speakers mean fault**, sometimes **error**, sometimes **failure** ... often the speaker doesn't know what it means!
* This class will try to use words that have **precise**, **defined**, and **unambiguous** meanings.

::: columns
:::: {.column width=.25}
\vspace{-1em}
\begin{center}
\includegraphics[width=.75\textwidth]{images/Testing/Intro/edison.png}
\end{center}
::::
:::: {.column width=.75}
"It has been just so in all of my inventions. The first step is an intuition, and comes with a burst, then difficulties arise--this thing gives out and [it is] then that '**Bugs**'--as such little faults and difficulties are called--show themselves and months of intense watching, study and labor are requite..." -- Thomas Edison
::::
:::

# The Term Bug

* **Bug** is used informally
* Sometimes **speakers mean fault**, sometimes **error**, sometimes **failure** ... often the speaker doesn't know what it means!
* This class will try to use words that have **precise**, **defined**, and **unambiguous** meanings.

::: columns
:::: {.column width=.25}
\vspace{-1em}
\begin{center}
\includegraphics[width=.85\textwidth]{images/Testing/Intro/lovelace.png}
\end{center}
::::
:::: {.column width=.75}
"an analyzing process must equally have been performed in order to furnish the Analytical Engine with the necessary operative data; and that herein may also lie a possible source of **error**. Granted that the actual mechanism is unerring in its processes, the cards may give it wrong orders." -- Ada, Countess Lovelace (notes on Babbage's Analytical Engine)
::::
:::

# Spectacular Software Failures

* **NASA's Mars Lander**: September 1999, crashed due to a units integration fault.

\vskip.5em

* **THERAC-25 radiation machine**: Poor testing of safety-critical software can cost *lives*: 3 patients were killed

\vskip.5em

* **Ariane 5 explosion**: Exception-handling bug: forced self-destruct on maiden flight (64-bit to 16-bit conversion) ~$370 million

\vskip.5em

* **Intel's Pentium FDIV fault**: public relations nightmare (not to mention invalidation of scientific results)

\vskip1em

\pause

\begin{center}
\large\textbf{We need our software to be dependable\\Test is \textit{one} way to assess dependability}
\end{center}

# Northeast Blackout of 2003

::: columns
:::: column
* 508 generating units and 256 power plants shut down

\vskip.5em

* Affected 10 million people in Ontario, Canada

\vskip.5em

* Affected 40 million people in 8 US states

\vskip.5em

* Financial losses of \$6 Billion USD

::::
:::: column
\begin{center}
\includegraphics[width=.85\textwidth]{images/Testing/Intro/blackout.png}
\end{center}
::::
:::

* The alarm system in the energy management system failed due to a software error and operators were not informed of the power overload in the system.

# Costly Software Failures

* NIST report, "The **Economic Impacts** of Inadequate Infrastructure for Software Testing" (2002)
  - Inadequate software testing costs the US alone between $22 and $59 billion annually

\vskip.5em

* **Huge losses** due to web application failures
  - **Financial** services: \$6.5 million per hour (just in USA)
  - **Credit card sales** applications: \$2.4 million per hour

\vskip.5em

* In Dec 2006, amazon.com's **BOGO** offer turned into a **double discount**

\vskip1em

\pause

\begin{center}
\large\textbf{World-wide monetary loss due to poor software is staggering}
\end{center}

# Testing in the 21st Century

::: columns
:::: column

* More **safety** critical, **real-time** software

\vskip.5em

* **Embedded** software is ubiquitous ... check your pockets

\vskip.5em

* **Enterprise** applications means bigger programs, more users

\vskip.5em

* Paradoxically, free software **increases** our expectations!

::::
:::: column

* **Security** is now all about software faults
  - **Secure** software is **reliable** software

\vskip.5em

* The **web** offers a new deployment platform
  - Very **competitive** and very **available** to more users
  - Web apps are distributed
  - **Web apps** must be highly reliable

::::
:::

\vskip1em

\begin{center}
\large\textbf{\textit{Industry desperately needs our inventions!}}
\end{center}

# What Does this Mean?

\pause

\vspace{2em}

\begin{center}
{\Large\textbf{Software testing is extremely important}}
\end{center}

\pause
\vspace{2em}

\begin{center}
{\Large\textbf{What are we trying to do when we test?\\What are our goals?}}
\end{center}

#

\titleslide{.85\textwidth}{Test Process Maturity}

# Verification \& Validation (IEEE)

* **Validation**: The process of evaluating software at the end of software development to ensure compliance with intended usage

\vskip.5em

* **Verification**: The process of determining whether the products of a given phase of the software development process fulfill the requirements established during the previous phase

\vspace{1em}

\pause

\begin{center}
\large\textbf{IV\&V stands for "independent verification and validation"}
\end{center}

# Test Process Maturity

* **Level 0**: There's no difference between **testing and debugging**

\vskip.5em

* **Level 1**: The purpose of testing is to show **correctness**

\vskip.5em

* **Level 2**: The purpose of testing is to show that the software **doesn't work**

\vskip.5em

* **Level 3**: The purpose of testing is not to prove anything specific, but to **reduce the risk** of using the software

\vskip.5em

* **Level 4**: Testing is a **mental discipline** that helps all IT professionals develop higher quality software

# Level 0 Thinking

* Testing is the **same** as debugging

\vskip.5em

* Does *\underline{NOT}* distinguish between incorrect **behavior** and mistakes in the program

\vskip.5em

* Does *\underline{NOT}* help develop software that is **reliable** or **safe**

\vspace{1em}

\pause

\begin{center}
\large\textbf{This is what we teach undergraduate CS majors}
\end{center}

# Level 1 Thinking

::: columns
:::: column

* Purpose is to show **correctness**

\vskip.5em

* Correctness is **impossible** to achieve

\vskip.5em

* What do we know if **no failures**?
  - Good software or bad tests?

::::
:::: column

* **Test engineers** have no:
  - Strict goal
  - Real stopping rule
  - Formal test technique

\vskip.5em

* Test managers are **powerless**

::::
:::

\pause

\vskip1em

\begin{center}
\large\textbf{This is what hardware engineers often expect}
\end{center}

# Level 2 Thinking

* Purpose is to show **failures**

\vskip.5em

* Looking for failures is a **negative** activity

\vskip.5em

* Puts testers and developers into an **adversarial** relationship

\vskip.5em

* What if there are **no failures**?

\pause

\vspace{1em}

\begin{center}
\large\textbf{This describes most companies.\vskip1em How can we move to a \underline{team approach}??}
\end{center}

# Level 3 Thinking

* Testing can only show the **presence of failures**

\vskip.5em

* Whenever we use software, we incur some **risk**

\vskip.5em

* Risk may be **small** and consequences unimportant

\vskip.5em

* Risk may be **great** and consequences catastrophic

\pause

\vspace{1em}

\begin{center}
\textbf{This describes a few "enlightened" software companies}
\end{center}

# Level 4 Thinking

\begin{center}
\large\textbf{A mental discipline that increase quality}
\end{center}

\pause
\vspace{1em}

* Testing is only **one way** to increase quality

\vskip.5em

* Test engineers can become **technical leaders** of the project

\vskip.5em

* Primary responsibility to **measure and improve** software quality

\vskip.5em

* Their expertise should **help the developers**

\pause

\vspace{1em}

\begin{center}
\large\textbf{This is the way "traditional" engineering works}
\end{center}

# Where are You?

\vspace{1.5em}

\begin{center}
\large\textbf{Are you at level 0, 1, or 2?}
\end{center}

\vspace{1.5em}

\begin{center}
\large\textbf{Is your organization at work at level 0, 1, or 2? Or 3?}
\end{center}

\vspace{1.5em}

\begin{center}
\large\textbf{We hope to teach you to become "change agents" in your workplace...\\Advocates for level 4 thinking}
\end{center}

#

\titleslide{.85\textwidth}{Goals and Costs}

# Tactical Goals: Why Each Test?

\begin{center}
\large\textbf{If you don't know \underline{why} you're conducting each test, it won't be very helpful}
\end{center}

\vspace{1em}

\pause

* **Written test objectives** and requirements must be documented

\vskip.5em

* What are your planned **coverage** levels?

\vskip.5em

* How much testing is **enough**?

\vskip.5em

* Common objective - **spend the budget** ... **test until the ship-date** ...
  - Sometimes called the "**date criterion**"

# Why Each Test?

\begin{center}
\large\textbf{If you don't start planning for each test when the functional requirements are formed, you'll never know why you're conducting the test}
\end{center}

\pause

\vspace{1em}

* 1980: "The software shall be easily **maintainable**"

\vskip.5em

* Threshold **reliability** requirements?

\vskip.5em

* What fact does each test try to **verify**?

\vskip.5em

* **Requirements** definition teams need testers!

# Cost of Not Testing

\begin{center}
\large\textbf{Poor Program Managers might say: "Testing is too expensive."}
\end{center}

\pause

\vspace{1em}

* Testing is the **most time consuming** and expensive part of software development

\vskip.5em

* *\underline{Not}* testing is even **more expensive**

\vskip.5em

* If we have too little testing effort early, the cost of testing **increases**

\vskip.5em

* Planning for testing after development is **prohibitively** expensive

# Cost of Late Testing

\vskip-1em
\begin{center}
\includegraphics[width=.85\textwidth]{images/Testing/WhyTest/chart01.eps}
\end{center}

# Summary

\begin{center}
\Large{\textbf{A tester's goal is to eliminate faults as early as possible}}
\end{center}

\vskip1em

\Large
* Improve quality
* Reduce cost
* Preserve Customer Satisfaction

# Things to Learn

::: columns
:::: {.column width=.333}

* Input Space Partitioning
* Boundary Value Analysis
* Decision Table Testing
* Black-, White-, and Gray-Box Testing

::::
:::: {.column width=.333}

* Graph Coverage
  * Statement Coverage
  * Branch Coverage
  * All Paths Coverage
* OO Testing

::::
:::: {.column width=.333}

* Application Level Testing
* Mutation Testing
* Metamorphic Testing
* Test Planning and Automation

::::
:::

\vspace{2em}

::: columns
:::: {.column width=.25}

\centering
\includegraphics[width=.5\textwidth]{images/Testing/Intro/concise_guide.jpg}

::::
:::: {.column width=.25}

\centering
\includegraphics[width=.5\textwidth]{images/Testing/Intro/binder.jpg}

::::
:::: {.column width=.25}

\centering
\includegraphics[width=.5\textwidth]{images/Testing/Intro/offutt.jpg}

::::
:::: {.column width=.25}

\centering
\includegraphics[width=.5\textwidth]{images/Testing/Intro/essentials.jpg}

::::
:::

# For Next Time

::: columns
:::: column

* Review the Reading
* Review this Lecture
* Come to Class

::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
