---
author:
- Dr. Isaac Griffith
title: Metamorphic Testing, PEN Testing and Fuzzing
course: CS 3321
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

* Understand the basic idea of metamorphic testing and the types of issues it addresses.
* Understand the basic idea of penetration testing and the tools that are used.
* Understand the basic idea of fuzzing and the approach used.

::::
:::: {.column width=.25}
\vfill
\vspace{7.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

# Inspiration

#

\ts{Metamorphic Testing}

# Introduction

\begin{block}{Test Oracle}
Mechanism to decide whether a test output is correct or not
\end{block}

\centering
\includegraphics[width=.75\textwidth]{images/Testing/Metamorphic/mt01.eps}

# Introduction

\begin{block}{Oracle Problem}
Sometimes it is not feasible to check the correctness of a test output
\end{block}

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt02.png}

#

\centering
\vfill
\Huge Let's see some examples

# Examples

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt03.png}

# Examples

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt04.eps}

# Examples

\centering
\includegraphics[width=.75\textwidth]{images/Testing/Metamorphic/mt05.eps}

# Examples

\centering
\includegraphics[width=.7\textwidth]{images/Testing/Metamorphic/mt06.eps}

# Metamorphic Testing Process

1. Identification of metamorphic relations.
2. Generation/Selection of source test cases.
3. Generation of follow-up test cases.
4. Checking of metamorphic relations

#

\centering
\vfill
\Huge Oh, I get it. This is about alleviating the oracle problem. Is that it?
\vfill
\Huge Yes! but MT can also support test data generation!

# Test Data Generation

\centering
\includegraphics[width=.75\textwidth]{images/Testing/Metamorphic/mt07.png}

# Test Data Generation

\centering
\includegraphics[width=.45\textwidth]{images/Testing/Metamorphic/mt08.png}

#

\ts{State of the art}

# Domains

From a survey of 84 Case Studies

::: columns
:::: column
* Numerical programs ~5%
* Variability and decision support ~5%
* Compilers ~4%
* Components ~3%
* Autonomous Vehicles ~2%
* Bioinformatics ~8%
::::
:::: column
* Machine Learning ~8%
* Simulation and Modeling ~8%
* Embedded Systems ~8%
* Computer Graphics ~11%
* Web Services/Apps ~14%
* Other (Adobe, NASA, CyberSec) ~24%
::::
:::

# Lessons Learned

\begin{block}{Lesson Learned}
Metamorphic testing requires good knowledge of the problem domain
\end{block}

# Lessons Learned

\begin{block}{Lesson Learned}
Different metamorphic relations can have different fault-detection capability
\end{block}

\centering
\includegraphics[width=.65\textwidth]{images/Testing/Metamorphic/mt09.eps}

# Lessons Learned

\begin{block}{Lesson Learned}
Metamorphic relations should be diverse so they exercise different parts of the program.
\end{block}

\centering
\includegraphics[width=.35\textwidth]{images/Testing/Metamorphic/mt10.eps}

# Lessons Learned

\begin{block}{Lesson Learned}
Two common approaches for the construction of metamorphic relations: \textbf{\underline{input-driven}} vs. output-driven
\end{block}

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt11.eps}

# Lessons Learned

\begin{block}{Lesson Learned}
Two common approaches for the construction of metamorphic relations: input-driven vs. \textbf{\underline{output-driven}}
\end{block}

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt12.eps}

# Lessons Learned

\begin{block}{Lesson Learned}
Metamorphic relations can be combined
\end{block}

\centering
\includegraphics[width=.7\textwidth]{images/Testing/Metamorphic/mt13.eps}

# Lessons Learned

\begin{block}{Lesson Learned}
Metamorphic relations can be combined
\end{block}

\centering
\includegraphics[width=.5\textwidth]{images/Testing/Metamorphic/mt14.eps}

# Lessons Learned

\begin{block}{Lesson Learned}
The automated discovery of metamorphic relations seems feasible in certain domains
\end{block}

\centering
\includegraphics[width=.85\textwidth]{images/Testing/Metamorphic/mt15.eps}

# Challenges

* Systematic guidelines for the construction of good metamorphic relations
* Generation of likely metamorphic relations
* Non-functional metamorphic testing
* Provide tools to foster the use of the technique

#

\ts{PEN Testing}

# Penetration Testing

**Definition from DOI:**

> Penetration testing is a controlled attack simulation that helps identify susceptibility to application, network, and operating system breaches.

* Also known as **PEN testing** or **ethical hacking**

# Penetration Testing

* PEN testing is about finding vulnerabilities in software systems
* Thinking in the perspective of an attacker or hacker

\vskip1em

* Software systems are more connected (and vulnerable) than ever in the age of the internet.
  * Web Apps
  * E-commerce
  * Public APIs
  * Internal Enterprise Applications
  * Etc.

# PEN Testing Strategies

Consider different PEN testing strategies when planning a PEN test

\vskip 1em

* **External PEN testing:**
  * Performing the attack outside the organization's boundary using the internet

\vskip .5em

* **Internal PEN testing:**
  * Performing the attack from inside the organization's network.
  * This would simulate a disgruntled employee

# PEN Testing Strategies

* **Blind PEN testing:**
  * The testing team performing the attack is given no or little information about the organization.
  * This simulates a real-lief hacking attempt

\vskip.5em

* **Double Blind PEN testing:**
  * An extended version of a blind PEN test where the organization's IT staff and security team are not aware of the test

# Types of PEN Testing

* **Black Box**
  * PEN testers have no knowledge of the target system

* **White Box**
  * PEN testers are provided all information about a target system; source code, operating system details, IP addresses, etc.

* **Grey Box**
  * PEN testers are given some knowledge about a system (e.g., OS details and IP addresses but no source code)

# General Approach to PEN Testing

1. Define the Scope
2. Reconnaissance (passive)
3. Scanning
4. Exploit Vulnerability
5. Report \& Cleanup

\vskip1em

In the literature, the full approach is often called Vulnerability Assessment and Penetration Testing (VAPT)

# Common Vulnerabilities

* Injection
* Broken Authentication
* Sensitive Data Exposure
* XML External Entities (XXE)
* Security Mis-configuration
* Cross-Site Scripting (XSS)
* Using components with identified vulnerabilities
* Insufficient Logging \& Monitoring

\vskip.5em

Use Open Web Application Security Project (OWASP) for up-to-date top 10 list

# Common Tools

Most of these tools aid in scanning/reconnaissance

\vskip.5em

* Nmap
* Nessus
* Wireshark
* Metasploit
* The harvester
* Zed Attack Proxy (ZAP)
* Browser Exploitation Framework (Beef)
* SQLMAP

#

\ts{Fuzzing}

# Fuzzing (or Fuzz Testing)

**Definition:**

> Fuzzing or fuzz testing is an automated software testing technique that involves providing invalid, unexpected, or random data as inputs to a computer program

* Developed by Barton Miller at the University of Wisconsin in 1989

# Fuzzing Process (automated)

* Enter random and/or unexpected inputs

\vskip .5em

* If the program hangs or crashes, the test failed

# Fuzzing

* Good for finding unknown vulnerabilities

\vskip.5em

* Black box technique

\vskip.5em

* Simple
  * The criteria for passing the test is if the program didn't crash or hang

\vskip.5em

* Easily automated

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
