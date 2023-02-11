---
author:
- Dr. Isaac Griffith
title: Refactoring
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Outcome

After today's lecture you will be able to:

::: columns
:::: {.column width=.7}

* Define the process of refactoring
* Understand the describe the basic refactoring process
* Use refactoring in your daily practice
* Understand the uses of refactoring in practice
* Understand why we refactor and what code smells are
* Understand how refactorings are applied
* Apply these refactorings in your daily practice

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
\begin{minipage}{.4\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Refactoring
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# What is Refactoring

* Refactoring is the process of changing a software system such that
  - The external behavior of the system does not change
    - e.g., functional requirements are maintained
  - but the internal structure of the system is improved

\vskip.5em

* This is sometimes called
  - "improving the design after it has been written"

# (Very) Simple Example

* Consolidate duplicate conditional fragments

::: columns
:::: column
**This**

```java
if (isSpecialDeal()) {
     total = price * 0.95;
     send();
} else {
     total = price * 0.98;
     send();
}
```
::::
:::: column
**Becomes This**

```java
if (isSpecialDeal()) {
     total = price * 0.95;
} else {
     total = price * 0.98;
}
send();
```
::::
:::

# (Another) Simple Example

* Replace magic number with symbolic constant:

\vskip.5em

**This**

```java
double potentialEnergy(double mass, double height){
    return mass * 9.81 * height;
}
```

\vskip.5em

**Becomes This**

```java
static final double GRAVITATIONAL_CONSTANT = 9.81;
double potentialEnergy(double mass, double height) {
  return mass * GRAVITATIONAL_CONSTANT * height;
}
```

\centering
\Large In This way, refactoring formalizes good programming practices

# But, Refactoring is Dangerous!

* Although refactoring helps to reduce bugs, it can also introduce new bugs into the code

\vskip.5em

* Manager's point of view
  - If my programmers spend time "cleaning up the code" then that's less time implementing required functionality (and my schedule is slipping as it is!)

\vskip.5em

* To address these concerns
  - Refactoring needs to be **systematic**, **incremental**, and **safe**

# Refactoring is Useful Too

* The idea behind refactoring is to acknowledge that it will be difficult to get a design right the first time and, as a program's requirements change, the design may need to change
  - refactoring provides techniques for evolving the design in small incremental steps

\vskip.5em

* Benefits
  - Often code size is reduced after refactoring
  - Confusing structures are transformed into simpler structures
    - which are easier to maintain and understand

# A "Cookbook" can be Useful

* Refactoring: Improving the Design of Existing Code
  - by Martin Fowler (and Kent Beck, John Brant, William Opdyke, and Don Roberts)

\vskip.5em

* Similar to the Gang of Four's Design Patterns
  - Provides "refactoring patterns"

\vskip.5em

* Also
  - http://www.refactoring.com/catalog
  - http://sourcemaking.com/refactoring
  - http://refactoring.guru/

# Principles in Refactoring

* Fowler's definition
  - Refactoring (noun)
    * a **change made to the internal structure of software** to make it **easier to understand and cheaper to modify** \color{Roarange}without changing its observable behavior\color{Black}
  - Refactoring (verb)
    * to **restructure software** by applying a series of refactorings \color{Roarange}without changing its observable behavior\color{Black}

# Principles, continued

* The purpose of refactoring is
  - to make software **easier to understand and modify**
  - **no functionality is added,** but the code is **cleaned up**, make easier to understand and modify, and sometimes is reduced in size

\vskip.5em

* Contrast this with performance optimization
  - functionality is not changed, only internal structure;
  - however, performance optimizations often involve making code harder to understand (but faster!)

# Principles, continued

How do you make refactorings safe?

\vskip.5em

1. Use refactoring "patterns"
   - Fowler's book (and Website) assigns "names" to refactorings in the same way that the GoF's book assigned names to patterns

 \vskip.5em

2. Test constantly!
   * you write tests **before** you write the code
   * after you refactor, you run the tests and check that they all pass
   * if a test fails, the refactoring broke something **but you know about it right away** and can fix the problem before you move on

# Why Should you Refactor?

* **Refactoring improves the design of software**
  - without refactoring, a design will "decay" as people make changes to a software system

\vskip.5em

* **Refactoring makes software easier to understand**
  - because structure is improved, duplicated code is eliminated, etc.

\vskip.5em

* **Refactoring helps you find bugs**
  - Refactoring promotes a deep understanding of the code at hand, and this understanding aids the programmer in finding bugs and anticipating potential bugs

\vskip.5em

* **Refactoring helps you program faster**
  - because a good design enables progress

# When Should you Refactor?

* The Rule of Three
  - Three "strikes" and you refactor
    - refers to duplication of code

\vskip.5em

* Refactor when you add functionality
  - do it before you add the new function to make it easier to add the function
  - or do it after to clean up the code after the function is added

\vskip.5em

* Refactor when you need to fix a bug

\vskip.5em

* Refactor as you do a code review

# Problems with Refactoring

* Databases
  - Business applications are often tightly coupled to underlying databases
    - code is easy to change; databases are not

\vskip.5em

* Changing interfaces (!!)
  - Some refactorings **require that interfaces be changed**
    * if you own all the calling code, no problem
    * if not, the interface is "published" and can't change

# Refactoring: Where to Start?

* How do you identify code that needs to be refactored?
  - Fowler uses an olfactory analogy (attributed to Kent Beck)
  - Look for "Bad Smells" in code
    * A chapter in Fowler's book
    * Several online sources (e.g., http://sourcemaking.com/refactoring/bad-smells-in-code)
    * They present examples of "bad smells" and then suggest refactoring techniques to apply

#

\centering
\vfill
\begin{minipage}{.4\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Code Smells
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Bad Smells in Code

* **Duplicated Code**
  - Bad because if you modify one instance of duplicated code but not the others, you (may) have introduced a bug!

\vskip.5em

* **Long method**
  - Long methods are more difficult to understand
    - performance concerns with respect to short methods are largely obsolete

# Bad Smells in Code

* **Large Class**
  - Large classes try to do too much, which reduces cohesion

\vskip.5em

* **Long Parameter List**
  - Hard to understand, can become inconsistent if the same parameter chain is being passed from method to method

\vskip.5em

* **Divergent Change**
  - symptom: one type of change requires changing one subset of methods; another type of change requires changing another subset
  - e.g., "I have to change these three methods every time I get a new database."
  - Related to cohesion

# Bad Smells in Code

* **Shotgun Surgery**
  - A change requires lots of little changes in a lot of different classes

\vskip.5em

* **Feature Envy**
  - A method requires lots of information form some other class
    - Move it closer!

\vskip.5em

* **Data Clumps**
  - Attributes that clump together (are used together) but are not part of the same class

# Bad Smells in Code

* **Primitive Obsession**
  - Characterized by a reluctance to use classes instead of primitive data types

\vskip.5em

* **Switch Statements**
  - Switch statements are often duplicated in code; they can typically be replaced by use of polymorphism (let OO do your selection for you!)

\vskip.5em

* **Parallel Inheritance Hierarchies**
  - Similar to shotgun surgery; each time I add a subclass to one hierarchy, I need to do it for all related hierarchies
    * Note: some design patterns encourage the use of parallel inheritance hierarchies (so they are not always bad!)

# Bad Smells in Code

* **Lazy Class**
  - A class that no longer "pays its way"
    * e.g., may be a class that was downsized by a previous refactoring, or represented planned functionality that did not pan out

\vskip.5em

* **Speculative Generality**
  - "Oh, I think we need the ability to do this kind of thing someday"
    * thus have all sorts of hooks and special cases to handle things that aren't required

\vskip.5em

* **Temporary Field**
  - An attribute of an object is only set/used in certain circumstances;
    * but an object should need all of its attributes

# Bad Smells in Code

* **Message Chains**
  - a client asks an object for another object and then asks that object for another object etc.
    * client depends on the structure of the navigation
    * any change to the intermediate relationships requires a change to the client

\vskip.5em

* **Middle Man**
  - If a class is delegating more than half its responsibilities to another class, do you really need it? Involves trade-offs, some design patterns encourage this (e.g., Decorator)

\vskip.5em

* **Inappropriate Intimacy**
  - Pairs of classes that know too much about each other's implementation details (loss of encapsulation)

# Bad Smells in Code

* **Data Class (information holder)**
  - These are classes that have fields, getting and setting methods for the fields, and nothing else; they are data holders, but objects should be about data AND behavior

\vskip.5em

* **Refused Bequest**
  - A subclass ignores most of the functionality provided by its superclass
  - Subclass may not pass the "IS-A" test

\vskip.5em

* **Comments** (!)
  - Comments are sometimes used to hide bad code
    - "...comments are often used as a deodorant"(!)

#

\centering
\vfill
\begin{minipage}{.35\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Application
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# The Catalog of Refactorings

* Fowler's book and Website (http://www.refactoring.com/catalog/) has 72+ refactoring patterns
  - I'm only going to cover a few of the more common ones, including
    * Extract Method
    * Replace Temp with Query
    * Move Method
    * Replace Conditional with Polymorphism
    * Introduce Null Object
    * Separate Query for Modifier
    * Introduce Parameter Object
    * Encapsulate Collection
    * Replace Nested Conditional with Guard Clauses

# Extract Method

* You have a code fragment that can be grouped together

\vskip.5em

* Turn the fragment into a method whose name explains the purpose of the fragment

\vskip.5em

* Example, next slide

# Extract Method

::: columns
:::: column
**This**

\footnotesize
```java
void printOwing(double amount) {
  printBanner();
  //print details
  System.out.println("name: " + name);
  System.out.println("amount: " + amount);
}
```
::::
:::: column
**Becomes This**

\footnotesize
```java
void printOwing(double amount) {
  printBanner();
  printDetails(amount);
}

void printDetails(double amount) {
  System.out.println("name: " + name);
  System.out.println("amount: " + amount);
}
```
::::
:::

# Replace Temp with Query

* You are using a temporary variable to hold the result of an expression
  - Extract the expression into a method;
  - Replace all references to the temp with an expression
  - The new method can then be used in other methods

\vskip.5em

* Example, next slide

# Replace Temp with Query

::: columns
:::: column
**This**

\footnotesize
```java
double basePrice = quantity * itemPrice;

if (basePrice > 1000)
  return basePrice * 0.95;
else
  return basePrice * 0.98;
```
::::
:::: column
**Becomes This**

\footnotesize
```java
if (basePrice() > 1000)
  return basePrice() * 0.95;
else
  return basePrice() * 0.98;
...
double basePrice() {
  return quantity * itemPrice;
}
```
::::
:::

<!--

# Move Method (I)

* A method is using more features (attributes and operations) of another class than the class on which it is defined
  - Create a new method with a similar body in the class it uses most. Either turn the old method into a simple delegation, or remove it altogether

# Move Method (II)

::: columns
:::: column
\scriptsize
```java
class Account {
  ...
  double overdraftCharge() {
    if (type.isPremium()) {
      double result = 10;
      if (daysOverdrawn > 7) {
        result += (daysOverdrawn - 7) * 0.85;
      }
      return result;
    } else {
      return daysOverdrawn * 1.75;
    }
  }
  double bankCharge() {
    double result = 4.5;
    if (daysOverdrawn > 0) {
      result += overdraftCharge();
    }
    return result;
  }
  private AccountType type;
  private int daysOverdrawn;
}
```
::::
:::: column
A class to manage a bank account. There are currently two types of accounts: standard and premium
\vskip1em
It is anticipated that we will be adding new account types and that each type will have a different rule for calculating an overdraft charge.
\vskip1em
As such, we'd like to **move the method** `overdraftCharge()` to the `AccountType` class.
::::
:::

# Move Method (III)

* When moving a method to a new class, we examine its code to see if it makes use of internal attributes of its original class
  - In this case, `overdraftCharge()` makes use of `daysOverdrawn`

* All such attributes become parameters to the method in its new home. (If the method already had parameters, the new parameters get tacked on to the end of its existing parameter list.)
  - In this case, `daysOverdrawn` will stay in the `Account` class and be passed as a parameter to `AccountType.overdraftCharge()`.

* Note, also, that since we are moving this method to the `AccountType` class, all calls to its methods that previously required a variable reference can now be made directly
  - Thus, `type.isPremium()` becomes simply `isPremium()` in the method's new home

# Move Method (IV)

\footnotesize
```java
class AccountType {
  ...
  double overdraftCharge(int daysOverdrawn) {
    if (isPremium()) {
      double result = 10;
      if (daysOverdrawn > 7) {
        result += (daysOverdrawn - 7) * 0.85;
      }
      return result;
    } else {
      return daysOverdrawn * 1.75;
    }
  }
  ...
}
```

\small
Here is the method in is new home. It has a `daysOverdrawn` parameter, which is used instead of `daysOverdrawn`, throughout the method. `type.isPremium()` is now just `isPremium()`, as advertised.

# Move Method (V)

\footnotesize
```java
class Account {
  ...
  double overdraftCharge() {
    return type.overdraftCharge(daysOverdrawn);
  }

  double bankCharge() {
    double result = 4.5;
    if (daysOverdrawn > 0) {
      result += overdraftCharge();
    }
    return result;
  }

  private AccountType type;
  private int daysOverdrawn;
}
```

\small
Back in the `Account` class, we update `overdraftCharge()` to delegate to the `overdraftCharge()` method in the `AccountType` class. Or, we could...

# Move Method (VI)

\footnotesize
```java
class Account {
  ...
  double bankCharge() {
    double result = 4.5;
    if (daysOverdrawn > 0) {
      result += type.overdraftCharge(daysOverdrawn);
    }
    return result;
  }

  private AccountType type;
  private int daysOverdrawn;
}
```

\small
...get rid of the `overdraftCharge()` method in `Account` entirely. In that case, we move the call to `AccountType.overdraftCharge()` to `bankCharge()`

-->

# Replace Conditional with Polymorphism

* You have a conditional that chooses different behavior depending on the type of an object
  - Move each "leg" of the conditional to an overriding method in a subclass. Make the original method abstract.

# Replace Conditional with Polymorphism

```java
double getSpeed() {
  switch (type) {
    case EUROPEAN:
      return getBaseSpeed();
    case AFRICAN:
      return getBseSpeed() - getLoadFactor() * numCoconuts;
    case NORWEGIAN_BLUE:
      reutrn (isNailed) ? 0 : getBaseSpeed(voltage);
  }
  throw new RuntimeException("Unknown Type of Bird");
}
```

# Replace Conditional with Polymorphism

\begin{center}
\includegraphics[width=.5\textwidth]{images/refactoring/birds.eps}
\end{center}

\vspace{-1em}

With this configuration, you can now write code that looks like this:

```java
void printSpeed(Bird[] birds) {
  for (int i = 0; i < birds.length; i++) {
    System.out.println("" + birds[i].getSpeed());
  }
}
```

and everything will work correctly via polymorphism and will be easy to extend: just add a new subclass to support a new type of bird.

<!--

# Introduce Null Object (I)

* Repeated checks for a null value (see below)

* Rather than returning a null value from `findCustomer()` return an instance of a "null customer" object

::: columns
:::: {.column width=.67}
```java
...
Customer c = findCustomer(...);
...
if (customer == null) {
  name = "occupant"
} else {
  name = customer.getName();
}
if (customer == null) {
  ...
}
```
::::
:::: {.column width=.33}
\begin{center}
\includegraphics[width=.75\textwidth]{images/refactoring/customer.eps}
\end{center}
::::
:::

# Introduce Null Object (II)

```java
public class NullCustomer {
  public String getName() { return "occupant"; }
}

=========================

Customer c = findCustomer(...);
name = c.getName();
```

* The conditional goes away entirely!

# Separate Query for Modifier

* Sometimes you will encounter code that does something like this
  - `getTotalOutstandingAndSetReadyForSummaries()`

* It is a query method but it is also changing the state of the object being called
  - This change is known as a "side effect" because it's not the primary purpose of the method

* It is generally accepted practice that queries should not have side effects so this refactoring says to split methods like this into:
  - `getTotalOutstanding()`
  - `setReadyForSummaries()`

* Try as best as possible to avoid any side effects in query methods

# Introduce Parameter Object

* You have a group of parameters that go naturally together
  - Stick them in an object and pass the object

* Imagine methods like
  - `amountInvoicedIn(Data start, Date end)`
  - `amountOverdueIn(Date start, Date end)`

* This refactoring says replace them with something like
  - `amountInvoicedIn(DateRange dateRange)`

* The new class starts out as a data holder but will likely attract methods to it

# Encapsulate Collection

* A method returns a collection
  - Make it return a read-only version of the collection and provide add/remove methods

* Student class with
  - `Map getCourses()`
  - `void setCourses(Map courses)`

* Chage to
  - `ReadOnlyList getCourses()`
  - `addCourse(Course c)`
  - `removeCourse(Course c)`

# Replace Nested Conditional

* This refactoring relates to the purpose of conditional code
  - Only type of conditional checks for a variation in "normal" behavior
    * The system will do either A or B; both are considered "normal" behavior
  - The other type of conditional checks for unusual circumstances that require special behavior; if all of these checks fail then the system proceeds with "normal behavior"

* We want to apply this refactoring when we encounter the latter type of conditional

* This refactoring is described in Fowler's book as:
  - "A method has conditional behavior that does not make clear the normal path of execution; Use guard clauses for all special cases"

# Example (I)

::: columns
:::: column
\footnotesize
```java
double getAmount() {
  double result;
  if (isDead) {
    result = deadAmount();
  } else {
    if (isSeparated) {
      result = separatedAmount();
    } else {
      if (isRetired) {
        result = retiredAmount();
      } else {
        result = normalAmount();
      }
    }
  }
  return result;
}
```
::::
:::: column
**Note: This type of code may be the result of a novice programmer or due to a programming constraint imposed by some companies that a method can only have a single return.**
\vskip1em
**Often this constraint causes more confusion than its worth**
::::
:::

# Example (II)

```java
double getAmount() {
  if (isDead) return deadAmount();
  if (isSeparated) return separatedAmount();
  if (isRetired) return retiredAmount();
  return normalAmount();
}
```

**With this refactoring, all of the code trying to identify special conditions are turned into one-line statements that determine whether the condition applies and if so handles it.**
\vskip1em
**That's why these statements are called "guard clauses"**
\vskip1em
**Even though this method has four returns, it is easier to understand than the method before the refactoring**

-->

# Wrapping Up

* Refactoring is a useful technique for making non-functional changes to a software system that result in
  - better code structures
  - less code
    * Many refactorings are triggered via the discovery of duplicated code
    * The refactorings then show you how to eliminate duplication

\vskip.5em

* Bad Smells
  - Useful analogy for discovering places in a system "ripe" for refactoring

# For Next Time

::: columns
:::: {.column width=.6}
* Review Chapter 8
* Watch Lecture 19
::::
:::: {.column width=.4}
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert2.png}
::::
:::

#

\vfill
\centering
\includegraphics[scale=.40]{images/questions-invert2.png}

\Huge \textbf{Are there any questions?}
