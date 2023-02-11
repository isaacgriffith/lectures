---
author:
- Isaac Griffith
title: Java III
institute: |
  CS 2235

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 12pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

#

\vfill
\centering
\Huge Java III

# Outcomes

At the end of Today's Lecture you will be able to:

* Utilize basic looping constructs in Java
* Understand the concepts of Wrapper Objects

# Introduction

#

\vfill
\begin{center}
{\Huge Loops}
\end{center}

# While Loops

* The simplest kind of loop in Java is a `while` loop.
* Such a loop tests that a certain condition is satisfied and will perform the body of the loop each time this condition is evaluated to be true.
* The syntax for such a conditional test before a loop body is executed is as follows:


```
  while(booleanExpression)
      loopBody
```


# Do..While Loops

* Java has another form of the while loop that allows the Boolean condition to be checked at the end of each pass of the loop rather than before each pass.
* This form is known a a do-while loop, and has syntax shown below:


```
  do
      loopBody
  while(booleanExpression)
```

# For Loops

* The traditional `for`-loop syntax consists of four sections

  * an initialization, a Boolean condition, an increment statement or block, and the body
  * Any of these four sections can be empty

* The structure is as follows:
```{=latex}
{\footnotesize
```

```
  for (initialization; booleanCondition; increment)
      loopBody
```

```{=latex}
}
```

* Meaning:

\footnotesize
```
  {
      initialization;
      while (booleanCondition) {
          loopBody;
          increment;
      }
  }
```


# Example For Loops

* Compute the sum of an array of doubles


```java
  public static double sum(double[] data) {
     double totla = 0;
     for (int j = 0; j < data.length; j++)
         total += data[j];
     return total;
  }
```

* Compute the maximum in an array of doubles

\footnotesize
```java
  public static double max(double[] data) {
     double currentMax = data[0];
     for (int j = 1; j < data.length; j++)
        if (data[j] > currentMax)
           currentMax = data[j];
     return currentMax;
  }
```

# For-Each Loops

* Since looping through elements of a collection is such a common construct, Java provides a shorthand notation for such loops, called the **for-each** loop.
\vskip1em
* The syntax for such a loop is as follows:


```
      for (elementType name : collection)
          loopBody
```

# For-Each Loop Example

* Computing sum of an array of doubles:


```java
  public static double sum(double[] data) {
     double total = 0;
     for (double val : data)
        total += val;
     return total;
  }
```

* When using a for-each loop, there is no explicit use of array indices
* The loop variable represents one particular element of the array

#

\vfill
\begin{center}
{\Huge Casting and Wrappers}
\end{center}

# Casting

* Casting is an operation that allows us to change the type of a value.
\vskip1em
* We can take a value of one type and cast it into an equivalent value of another type.
\vskip1em
* There are two forms of casting in Java:

  * **explicit casting**
  * **implicit casting**

# Explicit Casting

* Syntax: `(type) exp`
\vskip1em
Here "type" is the type that we would like the expression exp to have.
* This syntax may only be used to cast from one primitive type to another primitive type, or from one reference type to another reference type.

\vskip1em
**Example:**

```java
  double ap = 14.696;
  int round = (int) (ap + 0.5);
  double apRound = (double) round;
```

# Implicit Casting

* There are cases where Java will perform an implicit cast based upon the context of an expression.
* You can perform a **widening cast** between primitive types (such as from an int to a double), without explicit use of the casting operator.
* However, if attempting to do an implicit **narrowing cast**, a compiler error results.


**Example**

```java
  int x = 2; double y = 20.0;
  y = (3 * y + 4) / (x + 2); // implicit widening cast. Now y = 16.0
  x = (3 * y + 4) / (x + 2); // is now x == 13? No! Compiler error! Why?
```

# Wrapper Types

* There are many data structures and algorithms in Java's libraries that are specifically designed so that they only work with object type (not primitives).
* To get around this obstacle, Java defines a **wrapper** class for each base type.

  * Java provides additional support for implicitly converting between base types and their wrapper types through a process known as automatic **boxing** and **unboxing**.


# Example Wrapper Types

```{=latex}
\begin{center}
\footnotesize
```

+---------------+----------------+---------------------------------+----------------------+
| **Base Type** | **Class Name** | **Creation Example**            | **Access Example**   |
+:=============:+:==============:+:================================+:=====================+
| **boolean**   | Boolean        | `obj = new Boolean(true)`       | `obj.booleanValue();`|
+---------------+----------------+---------------------------------+----------------------+
| **char**      | Character      | `obj = new Character('Z');`     | `obj.charValue();`   |
+---------------+----------------+---------------------------------+----------------------+
| **byte**      | Byte           | `obj = new Byte((byte) 34);`    | `obj.byteValue();`   |
+---------------+----------------+---------------------------------+----------------------+
| **short**     | Short          | `obj = new Short((short) 1);`   | `obj.shortValue();`  |
+---------------+----------------+---------------------------------+----------------------+
| **int**       | Integer        | `obj = new Integer(1045);`      | `obj.intValue();`    |
+---------------+----------------+---------------------------------+----------------------+
| **long**      | Long           | `obj = new Long(10849L);`       | `obj.longValue();`   |
+---------------+----------------+---------------------------------+----------------------+
| **float**     | Float          | `obj = new Float(3.934F);`      | `obj.floatValue();`  |
+---------------+----------------+---------------------------------+----------------------+
| **double**    | Double         | `obj = new Double(3.934);`      | `obj.doubleValue();` |
+---------------+----------------+---------------------------------+----------------------+

```{=latex}
\end{center}
\vspace{-3em}
```
::: columns
:::: column
```java
  int j = 9;
  Integer a = new Integer(12);
  int k = a;
  int m = j + a;
  ```
::::
:::: column
```java
  a = 3 * m;
  Integer b = new Integer("-135");
  int n = Integer.parseInt("2013");
```
::::
:::

# Quiz

```java
  // Broken comparator - can you spot the flaw?
  public int compare(Integer first, Integer second) {
      return first < second ? -1 : (first == second ? 0 : 1);
  }
```

\vskip1em

**What would this return: -1, 0, or 1?**

#

\vfill
\begin{center}
{\Huge Coding}
\end{center}

# Packages & Imports

* name of package that contains the class definition goes on the first line
* `verb packageName;`
* `import java.util.Scanner;`
* `import java.util.*;`
* `static import packageName.PhysicalConstants.*;`
* `static import java.lang.Math.*;`

# Coding

* Algorithm pseudo-code facilitates

  * feasibility, efficiency & verification analysis
  * prior to time consuming & costly code development

* Packages & imports

  * enhanced modularity & encapsulation
  * avoids naming conflicts

* IDEs
* Documentation & Style -- JavaDoc

# Errors

* Compile-time: `int x = 1.5;`
* Run-time: `x/0;`
* Logical errors: bugs are the bane of a programmer's existence!
* **Example:** An "expensive" bug

  * Ariane 5 European satellite
  * Cost: \$7B, 10 years to build
  * Rocket crashed within 1 min of takeoff with expensive uninsured scientific cargo
  * Bug: unintended cast from 64-bit to 16-bit

# Testing & Debugging

* Top-down modular testing with stubs
* Bottom-up unit-testing
* Regression testing on evolving software
* Basic debugging by print statements or assertions:
  `assert(x > 5) : "x = " + x;`
* Enabling  disabling assertions:
```
  java -ea // enable assertions. Slow - used during testing
  java -da // disable assertions. Fast - for production
```

* Java debugger jdb (using breakpoints)
* Advanced IDE debuggers with GUI display

#

\vfill
\begin{center}
{\Huge Examples}
\end{center}

# Example Program

\scriptsize
```java
  public class Newton {
     public static double sqrt(double a) {
        final double EPSILON = 1e-15;
        if (a < 0.0) return Double.NaN;

        double x = a;
        while (Math.abs(x - a / x) > EPSILON * x)
           x = (x + a / x) / 2;
        return x;
     }

     public static void main(String[] args) {
        System.out.println("Input numbers & their square roots: ");
        double root;
        for (int i = 0; i < args.length; i++) {
           root = sqrt(Double.parseDouble(args[i]));
           System.out.println(args[i] + "\t" + root);
        }
     }
  }
```

# Another Program

\footnotesize
```java
  public class CreditCard {
     // Instance variables
     private String customer;
     private String bank;
     private String account;
     private int limit;
     protected double balance;
     // Constructors:
     public CreditCard(String cust, String bk, String acnt, int lim, double initialBal) {
        customer = cust;
        bank = bk;
        account = acnt;
        limit = lim;
        balance = initialBal;
     }
     public CreditCard(String cust, String bk, String acnt, int lim) {
        this(cust, bk, acnt, lim, 0.0);
     }
```

# Program Continued

\vspace{-1em}
\scriptsize
```java
     public String getCustomer() { return customer; }
     public String getBank() { return bank; }
     public String getAccount() { return account; }
     public int getLimit() { return limit; }
     public double getBalance() { return balance; }

     public boolean charge(double price) {
        if (price + balance > limit)
           return false;
        balance += price;
        return true;
     }
     public void makePayment(double amount) {
        balance -= amount;
     }

     public static void printSummary(CreditCard card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Balance = " + card.balance);
        System.out.println("Limit = " + card.limit);
     }
  }
```

# Program Continued

\scriptsize
```java
  public static void main(String[] args} {
     CreditCard[] wallet = new CreditCard[3];
     wallet[0] = new CreditCard("John Bowman", "California Savings",
                                "5391 0375 9387 5309", 5000);
     wallet[1] = new CreditCard("John Bowman", "California Federal",
                                "3485 0399 3395 1954", 3500);
     wallet[2] = new CreditCard("John Bowman", "California Finance",
                                "5391 0375 9387 5309", 2500, 300);

     for (int val = 1; val <= 16; val++) {
        wallet[0].charge(3 * val);
        wallet[1].charge(2 * val);
        wallet[2].charge(val);
     }

     for (CreditCard card : wallet) {
        CreditCard.printSummary(card);
        while (card.getBalance() > 200.0) {
           card.makePayment(200);
           System.out.println("New balance = " + card.getBalance());
        }
     }
  }
```

#

\centering
\includegraphics[scale=.40]{images/questions.png}

\Huge \textbf{Are there any questions?}

# For Next Time

* Programming Assignment 1 will be posted this evening take a look and get started
* Programming Project 1 will be posted this evening take a look and get started
* Review Chapter 1
* Finish Reading Chapter 2
