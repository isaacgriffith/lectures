---
author:
- Isaac Griffith
title: Introduction and Java I
institute: |
  CS 2235

  Department of Informatics and Computer Science

  Idaho State University
fontsize: 11pt
cornerLogo: "images/spirit.png"
wideLogo: "images/wide.png"
lowerCornerLogo: "images/roar.eps"
...

# Introduction

What we will do today

* Course Introductions
* Syllabus Review
* Introduction to Java

# Who Am I?

::: columns

:::: {.column width=33%}
\vspace{-1em}
\begin{center}
\includegraphics[width=.9\textwidth]{images/Module1/Intro/isaac.jpg}
\end{center}
::::
:::: {.column width=67%}  

Isaac Griffith

Assistant Professor of Computer Science

\vskip.75em

Education at Montana State University:

* PhD, MS, BS in Computer Science
* Graduate Certificate in Applied Statistics
* BA in Philosophy at Montana State University

\vskip.75em
Research Interests:

* Empirical Software Engineering
* Augmented and Mixed Reality
* Software Quality
* Software Architecture

::::
:::

# Prerequisite Review

**Course Prereqs**

* CS/INFO 1181

**What you should be familiar with:**

* Basic use of variables
* Construction and Use of Objects
* Implementation of Methods
* Basic concepts of Object Orientation
* Selection and Flow Control
* Basic concepts of Logic
* Basic understanding of what an Algorithm is

# Student Participation Expectations

::: columns
:::: column
* Class participation is a key to success
* **Do the assigned readings**
* Bring a laptop to class each day.
* Participate in class activities
* **Come to each course meeting**
  - If you missing > 9 meetings you will fail with an X grade
::::
:::: column
## The Book

\begin{center}
\includegraphics[scale=0.25]{images/Module1/Intro/book.jpg}
\end{center}

::::
:::

# Academic Integrity

\vspace{-1em}

* ISU Academic Integrity and Dishonesty Policy can be found at:

  \url{http://coursecat.isu.edu/undergraduate/academic_integrity_and_dishonesty_policy/}

* Academic Dishonesty is broken down into two groups:

  * Cheating
  * Plagiarism

::: columns
:::: column

* Instructor-Level Penalties:

  * Written Warning
  * Re-submission of work
  * Grade reduction
  * Fail the course

::::
:::: column

* University-Level Penalties:

  * Suspension
  * Expulsion

::::
:::  

* My Policy

  * First-time: Grade Reduction (i.e., fail the associated graded item)
  * Second-time: Fail the Course and I will recommend either Suspension or Expulsion

# Course Objectives

* Expand your understanding of OO Programming
* Familiarize you with the concepts of Algorithms Analysis
* Familiarize you with the concepts and construction of basic data structures (Lists, Stacks, Queues, Maps, Sets, and Graphs)
* Teach you about the uses of and basic operations for the basic data structures
* Familiarize you with basic algorithm design approaches (recursion, divide-and-conquer, dynamic programming, and greedy methods)
* Introduce you to the basics of modeling and simulation

# How We Will Spend Class Time

**Each Session will contain:**

* Lecture covering 2 or 3 major topics from the book
* Live Coding demonstrations of a major concept
* Individual/Group Active Learning exercises related to a major concept.


# How to Study and Prepare for Class

::: columns
:::: column

* Before each Lecture

  * Complete the Readings
  * Complete the Quiz
  * Review Lecture Notes
  * Write down any questions you have

* Come to lecture
* During lecture

  * Listen
  * Participate by asking questions
  * Participate in in-class activities
  * Take notes

::::
:::: column

* After Lecture

  * Review notes
  * Stop by my Office Hours or make an Appointment
  * Complete the assignments

* My Office Hours:

  * Office: BA 315
  * Tuesday: 1430 - 1530
  * Thursday: 1430 - 1530
  * By Appointment: [https://isaac-griffith.youcanbook.me](https://isaac-griffith.youcanbook.me)
  * Last Resort: grifisaa@isu.edu

::::
:::

# Grade Distribution

+-------------------------+------------------------+
| Grade Event Type        | Percent of Final Grade |
+:========================+:======================:+
| Programming Assignments | 20%                    |
+-------------------------+------------------------+
| Programming Projects    | 40%                    |
+-------------------------+------------------------+
| Midterm Exam            | 15%                    |
+-------------------------+------------------------+
| Final Exam              | 25%                    |
+-------------------------+------------------------+

#

\vfill
\begin{center}
\begin{minipage}{100pt}
\includegraphics[height=100pt]{images/brain-gears.jpg}
\end{minipage}
\begin{minipage}[adjusting]{4in}
{\Huge Your idea of this course}\\
A Mindmapping Exercise
\end{minipage}
\end{center}

# Think Pair Share

\begin{minipage}{50pt}
\includegraphics[width=50pt]{images/5-minutes.png}
\end{minipage}
\begin{minipage}[adjusting]{4in}
Take 2 minutes and think about the following question:
\end{minipage}
\vskip1em
\begin{minipage}{50pt}
\includegraphics[width=50pt]{images/brainstorming.png}
\end{minipage}
\begin{minipage}[adjusting]{4in}
What is an algorithm? For any given problem multiple algorithms and data structures exist to help solve the problem. What do you think we should use to guide us in selecting the best approaches?
\end{minipage}
\vskip1em
\begin{minipage}{50pt}
\includegraphics[width=50pt]{images/idea.png}
\end{minipage}
\begin{minipage}[adjusting]{4in}
Pair up with your neighbor and take the next few minutes to discuss your thoughts.
\end{minipage}

#

\vfill
\begin{center}
{\Huge Intro to Java}
\end{center}

# Gradle

* A JVM based tool used to:

  * Manage the build
  * Manage dependencies

* Based upon conventions and build tasks
* Is extensible
* Has significant IDE support
\vskip1em
* For more info visit: [https://docs.gradle.org/current/userguide/what_is_gradle.html](https://docs.gradle.org/current/userguide/what_is_gradle.html)

# Welcome to Java

* Java is widely available with large online support
* Embraces a full set of modern abstractions.
* Java's motto: write-once-run-anywhere
* Has a variety of automatic checks for mistakes in programs, especially when used in an IDE
* CS 2235 uses Java but is **not** a Java course. It is an introductory course on data structures.

# An Example Program

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module1/Java/example_prog}
\end{center}

# Components of a Java Program

* In Java, executable statements are placed in **methods**, that belong to class definition.
* The static method named **main** is the first method to be executed when running a Java program
* Any set of statements between the braces "**{**" and "**}**" define a program block.

# Identifiers

* An **identifier** is the name of a class, method, or variable
* An identifier cannot be any reserved word
* It can be any string of Java letters, beginning with a letter (or `$` or `_`), followed by letters, including digits

**Examples:**

* package: org.omg.CORBA, java.lang, cs.isu.assignments
* Classes: Name, Math, enum, MyClass, YourClass
* Interfaces: Comparable, Clonable, Iterable
* Methods: verb, getValue, isEmpty, equals, clone, toString
* variables: name, counter3, `$tstVariable`, `_testVar`
* CONSTANTS: PI, `MAX_INT`, MASS

# Primitive Types

* Java has several primitive types, which are basic ways of storing data
* An identifier variable can be declared to hold any primitive type and it can later be reassigned to hold another value of the same type.
\vskip1em
* `boolean` a Boolean value: `true` or `false`
* `char` 16-bit Unicode character
* `byte` 8-bit signed two's complement integer
* `short` 16-bit signed two's complement integer
* `int` 32-bit signed two's complement integer
* `long` 64-bit signed two's complement integer
* `float` 32-bit floating-point number (IEEE 754-1985)
* `double` 64-bit floating-point number (IEEE 754-1985)


# Classes and Objects

\begin{center}
\includegraphics[width=.85\textwidth]{images/Module1/Java/classes_objects}
\end{center}

# Classes and Objects

\vspace{-1em}

* Every **object** is an instance of a **class**, which serves as the type of the object and as a blueprint, defining the data which the object stores and the methods for accessing and modifying that data.

\vskip.5em

The critical members of a class in Java are the following:

* **Instance variables** (or **fields**)
  - Represent the data associated with an object of a class.
  - Have a type (primitive or reference).
* **Methods**
  - Blocks of code that can be called to perform actions.
  - Can accept parameters as arguments
  - Can return 0 or 1 values
* Special forms of methods are **accessor** and **mutator** Methods
  - **accessors** simply return the value of a field
  - **mutators** simply update the value of a field

# Another Example

```java
  public class Counter {
      private int count;
      public Counter() {}
      public Counter(int initial) { count = initial; }
      public int getCount() { return count; }
      public void increment() { count++; }
      public void increment(int delta) { count += delta; }
      public void reset() { count = 0; }
  }
```


* This class includes one instance variable, named **count**, with default value of zero, unless otherwise initialized.
* The class includes 2 special methods known as **constructors**, 1 accessor method, and 3 mutator methods.


# Reference Objects

* Classes are known as **reference objects** in Java, and a variable of that type is known as a **reference variable**.
* A reference variable $v$ can be viewed as a "pointer" to some object of its class type.
* A reference variable is capable of storing the location (i.e., memory address) of an object from the declared class.

  * So we might assign it to reference an existing instance or a newly constructed instance.
  * A reference variable can also store a special value **null** that represents the lack of an object.

# Creating and Using Objects

* In Java, a new object is created by using the **new** operator followed by a call to a constructor for the desired class.
* A **constructor** is a method that always shares the same name as its class. The new operator returns a reference to the newly created instance; the returned reference is typically assigned to an **object** of that **class** for further use.


**Example:** `Counter c = new Counter(167);`

# Continued Example

```java
public class CounterDemo {
    public static void main(String[] args) {
        Counter c;
        c = new Counter();
        c.increment();
        c.increment(3);
        int temp = c.getCount();
        c.reset();
        Counter d = new Counter(5);
        d.increment();
        Counter e = d;
        temp = e.getCount();
        e.increment(2);
    }
}
```

# The Dot Operator

* A reference variable name of an object can be used to access the members of the object's class.
* This access is performed with the dot (".") operator.
* Such access is done by using the object reference variable name, followed by the dot operator, followed by the member field or member method name and its parameters;


**Examples:**

```java
     myObject.field;
     myObject.myMethod(parameters)
     e.increment(3);
     System.out.println(e.getCount());
     System.out.println(e.count);
```

# Defining Classes

* A **class definition** is a block of code, delimited by braces "**{**" and "**}**", within which is included:

  * declarations of instance variables
  * member methods & constructors
  * nested classes

\vskip1em

* Immediately before the definition of a class, instance variable, or method, keywords known as **modifiers** can be placed to convey additional stipulations about that definition.

# Defining Methods

* A Method has a very simple definition:

```
<access> <modifiers> <type> methodName(<parameter_list>) {
  <body>
}
```

* Where:
  - Method Name is any valid identifier
  - We will discuss access and modifiers later
  - Type is the return type
    - `void` returns nothing
    - primitive or reference types

# Method Parameter List

* A comma-separated list of parameters
  * A parameter consists of two parts, the parameter type and the parameter name.

* All parameters in Java are **passed by value**
  * So if we pass an **int** variable to a method, then that variable's integer value is copied.
  * The method can change the copy but not the original
  * If we pass an object reference as a parameter to a method, then that reference is copied (but not the object it points to).

# Signatures

* If there are several methods with the same name defined for a class, then the Java runtime system uses the one that matches the actual number of parameters sent as arguments, as well as their respective types.
\vskip1em
* A method's name combined with the number and types of its parameters is called a method's **signature**, for it takes all of these parts to determine the actual method to perform for a certain method call.

#

 \vfill
 \begin{center}
 \begin{minipage}{100pt}
  \includegraphics[width=100pt]{images/connections.png}
 \end{minipage}
 \begin{minipage}[adjusting]{3in}
  {\huge Making Connections}

  A Mindmapping Exercise
 \end{minipage}
 \end{center}


#

\begin{center}
\includegraphics[width=.45\textwidth]{images/questions.png}

{\Huge Any Questions?}
\end{center}

# For Next Time

* Review the Syllabus and Schedule posted on Moodle
* Work through the Java and Gradle tutorials posted on Moodle
* Read Chapter 1 and Chapter 2 of the book
* Review Lecture 1 and Lecture 2
