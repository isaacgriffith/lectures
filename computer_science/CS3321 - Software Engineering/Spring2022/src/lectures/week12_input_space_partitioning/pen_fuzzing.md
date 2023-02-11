---
author:
- Dr. Isaac Griffith
title: Penetration Testing and Fuzzing
course: CS 3321
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

#

\titleslide{.5\textwidth}{PEN Testing}

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

\titleslide{.375\textwidth}{Fuzzing}

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

#

\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
