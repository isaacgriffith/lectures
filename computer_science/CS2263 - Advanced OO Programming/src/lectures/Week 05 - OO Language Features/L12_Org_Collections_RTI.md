---
author:
- Dr. Isaac Griffith
title: Organization, Collections, and RTTI
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
* Understand the basics features of most OO Languages
  - Class Organization
  - Collections
  - Run-time Type Identification
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
\begin{minipage}{.515\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Class Organization
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Organizing Classes

* In large systems it is essential that components be located in a manner to facilitate easy access
* Since classes and interfaces comprise systems, we must have a method for organizing them
* In java, this method is based on files and packages

# Creating Files

* There are several general rules and conventions for file organization
  - One class/interface per file
  - Files are named `<class/interface name>.java`
  - For a class with multiple types
    - Only one outer type may be public, and it is the one the file is named after

# Packages

* \small A package is simply a collection of classes
  - \footnotesize In java, they are formed from a physical directory structure
* \small Packages provide a logical namespace by within which type names must be unique
  - \footnotesize Thus, a class' full name is the `packagename.type_name`
* \small Package names are the names of directories where the "/" or "\\" directory separator is replaced with a period
  - \footnotesize E.g., the directory `edu/isu/cs/` would become the package `edu.isu.cs`
  - \footnotesize Package names tend to start with an inversion of the companies url - the prior example would be the package for "http://cs.isu.edu" the page for the CS Department.
* \small Examples of common packages from java include:
  - \footnotesize\ `java.io`
  - \footnotesize\ `java.util`
  - \footnotesize\ `java.lang.reflect`

# Using Packages

* \small All `.java` files must declare the package they belong to as the first executable line of code.
  - \footnotesize This is done with with the `package` declaration:
  - \footnotesize E.g., `package edu.isu.cs;`

\vskip.5em

* \small In order to utilize a type from a different package than the current type you have three choices
  1. \footnotesize You can access the type using its full name
     - \scriptsize E.g., `java.util.Vector myVector = new java.util.Vector();`
  2. \footnotesize You can import the type directly
     - \scriptsize E.g., `import java.util.Vector;`
  3. \footnotesize If you are using several types from the same package you can import all types
     - \scriptsize E.g., `import java.util.*;`

# Encapsulation

* \small One of the most important features of OOP is that it facilitates \textcolor{RoarangeLight}{\textit{encapsulation}} -- a class encapsulates both the data it uses, and the methods to manipulate the data

\vskip0.5em

* \small The external user \textcolor{RoarangeLight}{\textit{only}} sees the public methods of the class, and interacts with the objects of that class purely by calling those methods

\vskip0.5em

* \small This has several benefits
  - \footnotesize Users are insulated from needing to learn details outside their scope of competence
  - \footnotesize Programmers can alter or improve the implementation without affecting any client code

# Access Restrictions

* \small Encapsulation is enforced by the correct use of the access modifiers, \textcolor{Roarange}{\texttt{public}}, \textcolor{Roarange}{\texttt{private}}, and \textcolor{Roarange}{\texttt{protected}}

\vskip0.5em

* \small If you omit the access modifier, then you get the default, sometimes known as "package"

\vskip0.5em

* \small These latter two modifiers are only really relevant for multi-package programs that use inheritance, so we need only consider public and private at the moment

# `public` and `private`

* \small If an \textcolor{Roarange}{\textbf{instance variable}} is \textcolor{Roarange}{\texttt{public}}, then
  - \footnotesize Any object can \textcolor{RoarangeLight}{\textit{access}} it directly
  - \footnotesize Any object can \textcolor{RoarangeLight}{\textit{alter}} it directly

\vskip0.5em

* \small If an \textcolor{Roarange}{\textbf{instance variable}} is \textcolor{Roarange}{\texttt{private}}, then
  - \footnotesize Objects that belong to \textcolor{RoarangeLight}{\textit{the same class}} can access and alter it
  - \footnotesize Notice that privacy is a per-class attribute not per-object

\vskip0.5em

* \small If a \textcolor{Roarange}{\textbf{method}} is \textcolor{Roarange}{\texttt{public}}, then
  - \footnotesize Any object can call that method

\vskip0.5em

* \small If a \textcolor{Roarange}{\textbf{method}} is \textcolor{Roarange}{\texttt{private}}, then
  - \footnotesize Objects that belong to \textcolor{RoarangeLight}{\textit{the same class}} can call it

# Public Methods

* \small The \textcolor{RoarangeLight}{\textit{public interface}} of a class is its list of public methods, which details all of the services that this class provides

\vskip0.5em

* \small Once a class is released (for example, as part of a library), then it is impossible or very difficult to change its public interface, because client code may use any of the public methods

\vskip0.5em

* \small Public methods must be precisely documented and robust to incorrect input and accidental misuse

\vskip0.5em

* \small Classes should make as \textcolor{RoarangeLight}{\textit{few}} methods public as possible -- limit them to just the methods needed for the class to perform its stated function.

# Public Variables

* \small Normally instance variables should \textcolor{Roarange}{\textbf{not}} be public, since if client code can alter the values of instance variables then the benefit of encapsulation is lost

\vskip0.5em

* \small If client access to instance variables is desirable, then it should be provided by \textcolor{RoarangeLight}{\textit{accessor}} and/or \textcolor{RoarangeLight}{\textit{mutator}} methods (getters and setters)

\vskip0.5em

* \small Advantages
  - \footnotesize Maintenance of object integrity
  - \footnotesize Permits change of implementation

# Simple Example

\small

```java
    class MyDate {
        public int day;
        public String month;
        public int year;
    }

    MyDate md = new MyDate();
    md.day = 31;
    md.month = "Feb";
```

Here `md`, is corrupt (since there is no Feb. 31) which could cause problems elsewhere in the system.

# Use Mutators Instead

\small

```java
    public void setDay(int day) {
        // Check that day is valid for this.month
        // before setting the variables
    }

    public int getDay() {
        return this.day;
    }
```

* \small Setter methods act as "gatekeepers" to protect the integrity of objects.

\vskip.25em

* \small Setters reject values that would create a corrupt object.

\vskip.25em

* \small Getters return a value for client code to use, but do not allow the object itself to be changed.

#

\centering
\vfill
\begin{minipage}{.55\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Java Module System
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Java Module Basics

* \small Added in Java 9
* \small Modules may contain one or more Packages
* \small Each module must be given a unique name
  - \footnotesize `edu.isu.cs2263.intro`
  - \footnotesize do not use underscores for any names in Java

# Module Root Directory

* \small In prior versions of java, all packages and classes were packaged under the root dir:
  - \footnotesize a class: `edu.isu.cs2263.intro.App`
  - \footnotesize is in directory: `/edu/isu/cs2263/intro/`

\vskip0.5em

* \small However modules allow us to package all module components under a directory with the same name as the module:
  - \footnotesize For module: `edu.isu.cs2263.intro`
  - \footnotesize a class: `edu.isu.cs2263.intro.App`
  - \footnotesize is in directory: `/edu.isu.cs2263.intro/edu/isu/cs2263/intro/`

\vskip0.5em

* \small Furthermore, you should have separate gradle projects for each module
  - \footnotesize Thus having separate `src/main/java` directories

# Module Descriptor

* \small A module's definition is stored in a module descriptor file

\vskip0.5em

* \small A module descriptor file is a `module-info.java` file
  - \footnotesize must be located in the corresponding module's root directory

::: columns
:::: column

\small

\textcolor{Roarange}{\textbf{Syntax:}}

```
module Identifier {

}
```

* \small Where `Identifier` is the name of the module.

::::
:::: column
\small
\textcolor{Roarange}{\textbf{Example:}}

```java
    module edu.isu.cs2263 {

    }
```

::::
:::

# Module Exports

* \small A module must explicitly export all packages in the module that are to be accessible for other modules using the module.

\vskip0.5em

* \small One must also export subpackages
  - \footnotesize but exporting the parent package is not required

\small

\textcolor{Roarange}{\textbf{Example:}}

```java
    module edu.isu.cs2263 {
        exports edu.isu.cs2263;
        exports edu.isu.cs2263.util;
    }
```

# Module Requires

* \small If a module requires another module to do its work, it must be specified in the descriptor

\vskip0.5em

* \small This is done with the `requires` keyword

\small

\textcolor{Roarange}{\textbf{Example:}}

```java
    module edu.isu.cs2263 {
        requires javafx.graphics;
    }
```

# What's Not Allowed

* \small \textcolor{Roarange}{\textbf{Circular Dependencies}}
  - \footnotesize You cannot have circular dependencies between packages
  - \footnotesize That is Module A cannot depend on Module B, if Module B already depends on Module A
    * \scriptsize These dependencies may be either direct or indirect
  - \footnotesize In other words, the dependency graph must be acyclic.

\vskip0.5em

* \small \textcolor{Roarange}{\textbf{Split Packages}}
  - \footnotesize Only a single module may export a package at any time.
  - \footnotesize Thus, you cannot have two (or more) modules exporting the same package

# Module Benefits

\small The Java Module System provides several benefits.

\vskip0.5em

* \small Smaller application distributables via the Modular Java Platform

\vskip0.5em

* \small Encapsulation of internal packages

\vskip0.5em

* \small Startup detection of missing modules

\vskip0.5em

\small Additionally, Java will automatically modularize unmodularized dependencies that you use.

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Collections
}
\vskip-0.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Collections

* \small In 2235 and 1187, you (should have) learned all about data structures.

\vskip0.5em

* \small However, most language base libraries contain a majority of these structures, or there are libraries that will provide them

\vskip0.5em

* \small The section of java which contains these structures is the Java Collections Library.
  * \footnotesize The primary interface for this library is: `java.util.Collection`, with the following interface
    - \scriptsize\ `boolean add(Object object)`
    - \scriptsize\ `boolean addAll(Collection collection)`
    - \scriptsize\ `void clear()`
    - \scriptsize\ `boolean contains(Object object)`
    - \scriptsize\ `int size()`
    - \scriptsize\ additional methods to remove, check if empty, etc.

# Collections

Java provides implementations of several useful collections:

::: columns
:::: column

- \small `List` via the interface `java.util.List`
  - \footnotesize\ `java.util.ArrayList`
  - \footnotesize\ `java.util.LinkedList`

\vskip0.5em

- \small `Stack` via `java.util.Stack`

\vskip0.5em

- \small `Queue` via the interface `java.util.Queue`
  - \footnotesize\ `java.util.PriorityQueue`
  - \footnotesize\ `java.util.Deque`
  - \footnotesize\ `java.util.ArrayDeque`

::::
:::: column

- \small `Set` via the interface `java.util.Set`
  - \footnotesize\ `java.util.HashSet`
  - \footnotesize\ `java.util.TreeSet`

\vskip0.5em

- \small `Map` via the interface `java.util.Map`
  - \footnotesize\ `java.util.HashMap`
  - \footnotesize\ `java.util.TreeMap`

\vskip0.5em

* \small Additionally, I would look into both of the following libraries
  - \footnotesize \textcolor{Roarange}{\textbf{Google Guava}}
  - \footnotesize \textcolor{Roarange}{\textbf{Apache Commons Collections}}

::::
:::

# Collections Example

\small

```java
    import java.util.*;

    public class ListUseExample {

        public static void main(String[] args) {
            List<String> list = new ArrayList<>();
            for (int i = 1; i <= 10; i++)
                list.add(new String("String " + i));

            for (String s : list)
                System.out.println(s);
        }
    }
```

#

\centering
\vfill
\begin{minipage}{.725\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Run-time Type Identification
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# RTTI

* \small We need some mechanism that provides the following:
  - \footnotesize Allows us to detect if one class is an instance of another
  - \footnotesize This mechanism must take into account inheritance hierarchies

\vskip0.5em

* \small We also need the ability to
  - \footnotesize Apply certain functionality to one subclass
  - \footnotesize But not to a sibling subclass

\vskip0.5em

* \small RTTI solves both of these, and in Java we have
  - \footnotesize RTTI via reflection through the `Class` class in `java.lang`
  - \footnotesize RTTI via the `instanceof` operator

# Reflection

* \small \textcolor{Roarange}{\textbf{Reflection}} - a mechanism to inspect the Java Runtime and objects via their meta-data
  - \footnotesize Key to reflect in Java is the `Class` class and objects thereof

\vskip0.5em

* \small An instance of `Class` can be obtained from any non-null object
  - \footnotesize simply call `getClass()` on that object

\vskip0.5em

* \small\ `Class` provides several methods of particular interest
  - \scriptsize\ `getName()` - returns a `String` representation
  - \scriptsize\ `forName(String)` - static method which returns a Class instance for the named class
  - \scriptsize\ `getConstructors()` - returns a list of `Constructor` objects which can be used to instantiate an object
  - \scriptsize\ `getDeclaredFields()` - returns a list of `Field` objects describing the fields declared in the represented class
  - \scriptsize\ `getDelcaredMethods()` - returns a list of `Method` objects describing the methods declared in the represented class
  - \scriptsize\ and many others describing all aspects of the class

# Reflection Example

\small

```java
    Shape shape;

    // code to create a Shape object
    // and store its reference in shape

    if (shape.getClass().getName().equals("Circle")) {
        // take appropriate action
    }
```

Unfortunately, the one drawback is that the compiler cannot check whether "Circle" is the proper name or not.

# Reflection Example

\small

Thus, we could easily make the following mistake, but it will compile fine

```java
    Shape shape;

    // code to create a Shape object
    // and store its reference in shape

    if (shape.getClass().getName().equals("circle")) {
      // take appropriate action
    }
```

# `instanceof`

* \small To handle this problem we must use the `instanceof` operator

  \small

  ```java
      Shape shape;

      // code to create a Shape object
      // and store its reference in shape

      if (shape instanceof Circle) {
        // take appropriate action
      }
  ```

* \small This operator returns true if shape is an instance of Circle, and false otherwise
  - \footnotesize This also allows the compiler to ensure that such a check can be made

\begin{center}
\textcolor{Roarange}{\textbf{Although useful, code such as this is typically an unwise idea.}}
\end{center}

# Enhancements to `instanceof`

* \small Since Java 16 you can now use pattern matching in `instanceof`

\vskip0.5em

* \small This eliminates the need for explicit casts after a type check

\vskip0.5em

::: columns
:::: column

\small
\textcolor{Roarange}{\textbf{Old Way:}}

```java
if (obj instanceof String) {
    String s = (String) obj;
    if (s.length() > 5) {
        System.out.println("> 5 chars");
    }
}
```

::::
:::: column

\small
\textcolor{Roarange}{\textbf{New Way:}}

```java
    if (obj instanceof String s &&
                      s.length() > 5) {
        System.out.println("> 5 chars");
    }
```

::::
:::

# For Next Time

::: columns
:::: column
* Review Chapter 4.1 - 4.4
* Review this Lecture
* Come to class
* Read Chapter 4.6
* Read the Gson Tutorial
* Read the JavaDoc Tutorial
* Start working on Homework 03
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
