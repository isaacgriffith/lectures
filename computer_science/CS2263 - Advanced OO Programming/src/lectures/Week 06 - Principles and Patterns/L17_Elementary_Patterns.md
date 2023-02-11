---
author:
- Dr. Isaac Griffith
title: Elementary Design Patterns
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

* \small To describe the structure, implement, and know when to use the following design patterns:
  - \footnotesize Iterator
  - \footnotesize Singleton
  - \footnotesize Adapter

::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Elementary Design Patterns
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Reusing Experience

* \small As our experience grows it is logical to want to reuse that experience in future projects
* \small Unfortunately most applications tend to exhibit relatively little similarity
  - \footnotesize But, upon deeper inspection, we can see a number of similar issues at the design level
* \small As we gain exposure to problems common to multiple scenarios
  - \footnotesize Our ability to identify these problems increases
  - \footnotesize Our ability to provide solutions to these problems quickly increases
  - \footnotesize We begin to recognize commonalities in these solutions
    * \scriptsize Sets of classes with similar functionalities and relationships

# Design Patterns?

* \small In O-O we divide a system into objects and the classes that create them
* \small Thus, the task in designing an OO System is to recognize the
  - \footnotesize classes
  - \footnotesize interfaces
  - \footnotesize and relationships
* \small Necessary to solve a specific design problem

* \small The application of this approach has lead to the identification of \textcolor{Roarange}{\textbf{design patterns}}

* \small \textcolor{Roarange}{\textbf{Design Pattern:}} An O-O solution (set of classes, interfaces, and their relationships) to a commonly occurring design problem
  - \footnotesize It can also be thought of as an encapsulation of design experience or knowledge
  - \footnotesize It also defines a lexicon of OO design concepts

# Elementary Design Patterns

\small In this lecture we will study the following three design patterns:

* \footnotesize \textcolor{Roarange}{\textbf{Iterator Pattern:}} Used to traverse a collection regardless of the means by which the collection is implemented.
* \footnotesize \textcolor{Roarange}{\textbf{Singleton Pattern:}} Used when it is known that we need one and only one instance of a class.
* \footnotesize \textcolor{Roarange}{\textbf{Adapter Pattern:}} Used to adapt existing classes to a new interface.

#

\centering
\vfill
\begin{minipage}{.41\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Iterator Pattern
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Introducing Iterator

* \small Let us say we have two List implementations:

\centering
\includegraphics[width=.85\textwidth]{images/patterns/edp01i.eps}

# Iterator Motivation

* \small Numerous applications need to maintain collections of objects
* \small Yet, depending on the needs of a particular application, the specific data structure may change
* \small Common Data Structures (as you know from CS 2235) are:
  - \footnotesize Lists
  - \footnotesize Sets
  - \footnotesize Maps
  - \footnotesize Queues
  - \footnotesize Deques
  - \footnotesize Stacks
  - \footnotesize Binary Trees
  - \footnotesize B-Trees
  - \footnotesize Graphs

# Iterator Motivation

* \small The traversal of each of these structures and their various implementations, tend to be specific to those implementations
  - \footnotesize Yet, if we require every collection to provide a means of traversal, we end up violating both the SRP and LC principles
    * \scriptsize \textcolor{Roarange}{\textbf{SRP}} - The collection both stores and traverses
    * \scriptsize \textcolor{Roarange}{\textbf{LC}} - Client of the collection needs to be intimately aware of how to traverse
* \small Thus, we need a new object -- \textcolor{Roarange}{\textbf{Iterator}} which provides standard methods to traverse a collection.

# Iterator Structure

\centering
\includegraphics[width=.75\textwidth]{images/patterns/edp02i.eps}

# Iterator Implementation

\centering
\includegraphics[width=.75\textwidth]{images/patterns/edp03i.eps}

#

\vfill
\centering
\includegraphics[width=.5\textwidth]{images/to_code.eps}

#

\centering
\vfill
\begin{minipage}{.475\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Singleton Pattern
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Introducing Singleton

::: columns
:::: column
* \small In many situations we want to ensure that there is just one object of a certain class

* \small To do this we need a few things
  - \footnotesize A private default constructor
  - \footnotesize An attribute to hold the instance
  - \footnotesize A method to create, if not already created, and return the instance

\small \textcolor{Roarange}{\textbf{Singleton Structure}}

\begin{center}
\includegraphics[width=.4\textwidth]{images/patterns/edp04i.eps}
\end{center}

::::
:::: column

\small \textcolor{Roarange}{\textbf{Basic Singleton Implementation}}

\scriptsize

```java
public class B {
    private static B singleton;
    private B() {}
    public static B instance() {
        if (singleton == null)
            singleton = new B();
        return singleton;
    }
    // rest of class
}
```

::::
:::

# Subclassing Singletons

* \small Often we need to subclass a singleton with other singletons

* \small Example: A machine which runs multiple servers in separate processes where each is a singleton
  - \footnotesize General purpose server - time, directory, file, replication, name services
  - \footnotesize Directory server - sophisticated directory service
  - \footnotesize File Server - reading and updating files
  - \footnotesize File Server - only reading or creating new files

* \small \textcolor{Roarange}{\textbf{General Problem:}} We need to implement two classes `B` and `D`, where `B` is the super class of `D` and both are singletons.

# Steps in Subclassing Singletons

1. \small Make `B`'s constructor \textcolor{Roarange}{\textbf{protected}} rather than private
2. \small Add logic in the constructor to prevent `B` from creating new instances of itself
3. \small Add another private constructor (which takes a parameter) that will be used by `B`'s `instance()` method
4. \small Implement `D` as a standard singleton, but make its constructor call `B`'s protected constructor

# Subclassing Implementation

::: columns
:::: column

\small \textcolor{Roarange}{\textbf{Superclass Implementation}}

\scriptsize
```java
import java.lang.reflect.*;

public class B {
  private B singleton;
  protected B() throws Exception {
    if (getClass().getName().equals("B"))
      throw new Exception();
  }
  private B(int i) {}

  public static B instance() {
    if (singleton == null) {
      singleton = new B(1);
    }
    return singleton
  }
  // rest of class
}
```
::::
:::: column

\small \textcolor{Roarange}{\textbf{Subclass Implementation}}

\scriptsize
```java
public class D extends B {
  private static D singleton;
  protected D() {
    super();
  }
  public static D instance() {
    if (singleton == null)
      singleton = new D();
    return singleton;
  }
  // rest of class
}







```

::::
:::

# Singleton Implementation

::: columns
:::: column

* \small We have already seen the basic approach to implementation
* \small But, there have been several improvements to this approach
  - \footnotesize Enum
  - \footnotesize Double-checked Locking
  - \footnotesize Helper class
  - \footnotesize and many more

::::
:::: column
\textcolor{Roarange}{\textbf{Basic Approach}}

* \small Benefits
  - \footnotesize Simple
  - \footnotesize Can be subclassed (with a little work)
* \small Drawbacks
  - \footnotesize Not thread-safe
  - \footnotesize In languages like Java, does not guarantee a single instance
::::
:::

# Singleton Implementation

::: columns
:::: column

* \small We have already seen the basic approach to implementation
* \small But, there have been several improvements to this approach
  - \footnotesize \textcolor{Roarange}{\textbf{Enum}}
  - \footnotesize Double-checked Locking
  - \footnotesize Helper class
  - \footnotesize and many more

::::
:::: column
\small \textcolor{Roarange}{\textbf{Enum Approach}}

\footnotesize
```java
public enum E {

    INSTANCE;

    // methods
}
```

* \small Benefits
  - \footnotesize Thread safe
  - \footnotesize Simple
* \small Drawbacks
  - \footnotesize Cannot be subclassed
::::
:::

# Singleton Implementation

::: columns
:::: column

* \footnotesize We have already seen the basic approach to implementation
* \footnotesize But, there have been several improvements to this approach
  - \scriptsize Enum
  - \scriptsize \textcolor{Roarange}{\textbf{Double-checked Locking}}
  - \scriptsize Helper class
  - \scriptsize and many more

\vskip.5em

* \footnotesize Benefits
  - \scriptsize Thread safe
  - \scriptsize Can be subclassed
* \footnotesize Drawbacks
  - \scriptsize Convoluted

::::
:::: column
\small \textcolor{Roarange}{\textbf{Double-checked Locking Approach}}

\scriptsize
```java
public class D {

  private static volatile D singleton;

  private D() {}
  public D instance() {
    D local = singleton;
    if (local == null) {
      synchronized (this) {
        local = singleton;
        if (local == null) {
          singleton = local = new D();
        }
      }
    }

    return singleton;
  }
  // methods
}
```
::::
:::

# Singleton Implementation

::: columns
:::: column

* \small We have already seen the basic approach to implementation
* \small But, there have been several improvements to this approach
  - \footnotesize Enum
  - \footnotesize Double-checked Locking
  - \footnotesize \textcolor{Roarange}{\textbf{Helper class}}
  - \footnotesize and many more

::::
:::: column
\footnotesize \textcolor{Roarange}{\textbf{Helper Class Approach}}

\tiny
```java
public class H {

  private H() {}

  private static final class Helper() {
    private static final H INSTANCE = new H();
  }

  public static instance() {
    return Helper.INSTANCE;
  }
  // methods
}
```

\vskip-1em

* \footnotesize Benefits
  - \scriptsize Thread safe
  - \scriptsize Simpler than DCL
  - \scriptsize Allows for subclassing
  - \scriptsize Lazy Loading
::::
:::

#

\vfill
\centering
\includegraphics[width=.5\textwidth]{images/to_code.eps}

#

\centering
\vfill
\begin{minipage}{.425\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Adapter Pattern
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Introducing Adapter

* \small If we have an interface to which we need an implementation, but do not wish to undergo the labor intensive implement
* \small The, perhaps we can instead utilize an existing class to achieve this implementation via delegation
* \small We could then reach our desired functionality

# Adapter Motivation

* \small The General Problem:
  - \footnotesize Given an interface `I`
  - \footnotesize A existing class `C` which contains the set of methods `Mc`
  - \footnotesize We wish to create a class `A` which implements `I`
  - \footnotesize Such that each implemented method in `Mi` is realized via a combination of calls to methods in `Mc`

# Adapter Types

* \small There are two types of adapters both of which will implement our strategy
  - \footnotesize \textcolor{Roarange}{\textbf{Object Adapters:}} Creates an adapter class that implements a given interface using an instance of an existing class (adaptee)
    * \scriptsize This requires that the adapter class has an attribute of type `Adaptee` to which the work is delegated
    * \scriptsize \textcolor{Roarange}{\textbf{Downside}} of this approach is that it will introduce another object to the system
    * \scriptsize \textcolor{Roarange}{\textbf{Upside}} is that the choice of adaptee can be postponed to run-time

  - \footnotesize \textcolor{Roarange}{\textbf{Class Adapters:}} Creates an adapter class that implements a given interface by extending an existing class (adaptee)
    * \scriptsize Less flexible than Object adapters due to the inheritance relationship
    - \scriptsize Choice of adaptee is forced to be made at compile-time
    - \scriptsize All public methods of the extended class will be exposed to the client

# Adapter Structure

\centering
\includegraphics[width=.5\textwidth]{images/patterns/edp05i.eps}

# Adapter Implementation

\centering
\includegraphics[width=.8\textwidth]{images/patterns/edp06i.eps}

#

\vfill
\centering
\includegraphics[width=.5\textwidth]{images/to_code.eps}

# For Next Time

::: columns
:::: column
* Review Chapter 5
* Review this Lecture
* Come to Class
* \textcolor{Roarange}{\textbf{Complete Project Part 1}}
* Read Chapter 6
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
