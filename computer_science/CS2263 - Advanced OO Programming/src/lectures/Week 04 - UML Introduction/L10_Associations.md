---
author:
- Dr. Isaac Griffith
title: Associations and Inheritance
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
...

# Outcomes

After today's lecture you will:

::: columns
:::: {.column width=.7}
* \footnotesize Have and understanding of the different types of UML Diagrams
* \footnotesize Understand the types of relationships between classes/objects
* \footnotesize Be capable of using these relationships in Class Diagrams
* \footnotesize Be capable of translating basic Class Diagrams to working code.
* \footnotesize Understand the basic patterns of class collaborations
::::
:::: {.column width=.25}
\vskip-2em
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert.jpg}
::::
:::

#

\centering
\vfill
\begin{minipage}{.425\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Associations
}
\vskip-0.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Association

* **Association** - a relation among two or more classes describing a group of links with common structure and semantics
  - Implies an object of one class is making use of an object of another class
  - Indicated by a solid line connecting two classes
  - Does not imply there is always a link
  - Does imply a persistent, identifiable connection

* Can represent physical or conceptual relationships

# Implementing Associations

::: columns
:::: column
* \footnotesize Implementation can take several forms:
  - \scriptsize Class A stores a key (or several keys) that uniquely identifies an object of class B
  - \scriptsize Class A stores a reference(s) to object(s) of class B
  - \scriptsize Class A has a reference to an object of class C, which, in turn is associated with an unique instance of class B

* \footnotesize The first and second are direct associations
* \footnotesize The third is indirect association

**Example Class Diagram**

\begin{center}
\includegraphics[width=\textwidth]{images/uml/arity.eps}
\end{center}

::::
:::: column

**Example Implementation**

\scriptsize

```java
import java.util.*;

public class Student {
  private List<Section> enrolledIn;
  // remaining fields and methods ...
}

public class Section {
  private List<Student> students;
  private Course belongsTo;
  // remaining fields and methods ...
}

public class Course {
  private List<Section> sections;
  // remaining fields and methods ...
}
```

::::
:::

# Directionality

* Associations are assumed to be **bi-directional**
* We change this by placing an open arrow on an end
* Additionally, we can name an association by placing a descriptive name centered along and above the line
  - This name also typically implies direction
* Examples:
  - A student **enrolls** in a section, which **belongs to** a course
  - We can invert this to be: a course **has** sections that **enroll** students

\centering
\includegraphics[width=.85\textwidth]{images/uml/directionality.eps}

# Roles

* Typically the ends of associations will have named **roles**
* For example:
  - Section has zero or more `students` of type `Student`
  - Course has zero or more `sections` of type `Section`
* During implementation role names become field names with the type of the role end type

\centering
\includegraphics[width=.85\textwidth]{images/uml/roles.eps}

# Arity of Relationships

* \scriptsize Arity, also called **multiplicity**, of a relationship between Class A and Class B denotes how many objects of Class A exist for each object of Class B
* \scriptsize Arity can be **one-one**, **one-many**, or **many-many**
* \scriptsize It is normally depicted as two numbers separated by ".." where the left denotes the minimum and the right the maximum
  - \tiny 1  only one (min = 1, max = 1)
  - \tiny 0..1  zero or one
  - \tiny 0..*  zero to many
  - \tiny \*  zero to many
  - \tiny 1..*  one to many
  - \tiny 2..10  two to ten

\centering
\includegraphics[width=.85\textwidth]{images/uml/arity.eps}

# Containment Relationships

* \footnotesize Objects are often composed of other objects
* \footnotesize In UML this relationship is denoted by a special form of association, **containment**
* \footnotesize There are two forms of containment:
  - \scriptsize \textbf{Aggregation} - An association where the object of class A is "made up of" objects of class B. Indicates a whole-part relationship.
    - \tiny Denoted by an open diamond on the class A side
  - \scriptsize \textbf{Composition} - An aggregation in which each instance of the part belongs to only one instance of the whole, and that the part cannot exist except as part of the whole.
    - \tiny Denoted by a filled in (black) diamond on the class A side

\centering
\includegraphics[width=.85\textwidth]{images/uml/containment.eps}

# Association Classes

::: columns
:::: column
* \footnotesize Associations with additional information
  * \scriptsize qualifying its nature
  * \scriptsize describing its properties
* \footnotesize When the information is not useful outside the context of the relationship
  - \scriptsize We treat the association itself as a class
* \footnotesize For example when students enroll in a section, a registration record is created
  - \scriptsize This record stores the registration date and grade
  - \scriptsize Yet, the record does not make sense if a particular student doesn't enroll in a given section
::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/uml/assoc_class.eps}

::::
:::

#

\centering
\vfill
\begin{minipage}{.6\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Collaboration Patterns
\end{center}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Object Selection

* \footnotesize When it comes to defining objects within a domain model, there are four categories:

  * \scriptsize \textbf{People:} Generally perform actions within a given context (such as a role)
    - \tiny Each context should be modeled with a more specific type of person
    - \tiny Additionally, we can personify non-human entities such as companies (they becom "Actors")

  \vskip0.5em

  * \scriptsize \textbf{Places:} Actions that take place in a location should be modeled with a place

  \vskip0.5em

  * \scriptsize \textbf{Things:} Things are the typical target of an action.
    - \tiny Often represented by a general type definition and a more specific form of the thing.

  \vskip0.5em

  * \scriptsize \textbf{Events:} These tie people, places, and things together in a moment of time (or range of time)

# Object Collaboration Patterns

* Objects tend to work together in order to model and fulfill requirements
* These relationships, or collaborations, follow 12 general patterns
* Within each pattern, each object is a "pattern player" and has specific responsibilities
  - \footnotesize responsibilities in regard to defining behavior
  - \footnotesize responsibilities in regard to enforcing constraints

# People and Places Patterns

::: columns
:::: column

\scriptsize

**Actor -- Role**

\includegraphics[width=.85\textwidth]{images/collab_patterns/roles.eps}

* \tiny Role represents an Actor in a specific context
* \tiny `Actor` may know zero or more `Roles`
  - \tiny Though the set of `Roles` is typically unique
* \tiny `Role` may only know one `Actor`

\vskip0.5em
\scriptsize

**Examples**

* \tiny Customer -- Buyer
* \tiny Customer -- Seller
* \tiny Person -- LibStaff
* \tiny Person -- LibUser

::::
:::: column

\scriptsize

**OuterPlace -- Place**

\includegraphics[width=.85\textwidth]{images/collab_patterns/outer_place.eps}

* \tiny `Place` is a location where things happen
* \tiny `OuterPlace` may know one or more `Places`
* \tiny `Place` may know at most one `OuterPlace`
* \tiny Relationship may be hierarchical

\vskip0.5em
\scriptsize

**Examples**

* \tiny Region -- Office
* \tiny Country -- Branch
* \tiny Branch -- Room

::::
:::

# Things Patterns

::: columns
:::: column

\scriptsize

**Item -- SpecificItem**

\includegraphics[width=.85\textwidth]{images/collab_patterns/item_specificitem.eps}

* \tiny `SpecificItem` is a specific representation of a generic `Item`
* \tiny `Item` may know zero or more `SpecificItems`
* \tiny `SpecificItem` must know exacly one `Item` and cannot exist without it.

\vskip0.5em
\scriptsize

**Examples**

* \tiny Book -- BookCopy
* \tiny PhoneModel -- Phone
* \tiny Video -- VideoTape

::::
:::: column

\scriptsize

**Assembly -- Part**

\includegraphics[width=.85\textwidth]{images/collab_patterns/assembly.eps}

* \tiny `Assembly` is an aggregation of `Parts`
* \tiny `Assembly` must know at least one `Part`
* \tiny `Part` may know only one `Assembly` and cannot exist outside of an `Assembly`

\vskip0.5em
\scriptsize

**Examples**

* \tiny Parcel -- Content
* \tiny Book -- Chapter

::::
:::

# Things Patterns

::: columns
:::: column

\scriptsize

**Container -- Content**

\includegraphics[width=.85\textwidth]{images/collab_patterns/container.eps}

* \tiny `Container` is a collection of `Content`
* \tiny `Container` may know zero or more `Contents` (can be empty)
* \tiny `Content` may know at most one `Container`
  - \tiny Can exist outside `Container` or move to another `Container`
* \tiny Relationship may be hierarchical

\vskip0.5em
\scriptsize

**Examples**

* \tiny BookShelf -- Book
* \tiny FileCabinet -- File

::::
:::: column

\scriptsize

**Group -- Member**

\includegraphics[width=.85\textwidth]{images/collab_patterns/group_membership.eps}

* \tiny `Group` is a collection of `Members`
* \tiny `Group` knows zero or more `Members` (can be empty)
* \tiny `Member` knows zero or more `Groups`
* \tiny Relationship may be hierarchical

\vskip0.5em
\scriptsize

**Examples**

* \tiny Team -- Student
* \tiny Club -- Member

::::
:::

# Events Patterns

::: columns
:::: column

\scriptsize

**Role -- Transaction**

\includegraphics[width=.85\textwidth]{images/collab_patterns/role_transaction.eps}

* \tiny `Role` handles `Transactions`
* \tiny `Role` knows of zero or more `Transactions`
* \tiny `Transaction` knows of only one `Role`

\vskip0.5em
\scriptsize

**Examples**

* \tiny Customer -- Order
* \tiny Student -- Register
* \tiny Buyer -- Payment

::::
:::: column

\scriptsize

**Place -- Transaction**

\includegraphics[width=.85\textwidth]{images/collab_patterns/place_transaction.eps}

* \tiny `Place` conducts `Transactions`
* \tiny `Place` knows of zero or more `Transactions`
* \tiny `Transaction` knows of only one `Place`

\vskip0.5em
\scriptsize

**Examples**

* \tiny Branch -- Withdrawal
* \tiny Counter -- Purchase

::::
:::

# Events Patterns

::: columns
:::: column

\scriptsize

**SpecificItem -- Transaction**

\includegraphics[width=.85\textwidth]{images/collab_patterns/specificitem_transaction.eps}

* \tiny `SpecificItem` is involved in `Transactions`
* \tiny `SpecificItem` knows of zero or more `Transactions`
* \tiny `Transaction` knows of only one `SpecificItem`

\vskip0.5em
\scriptsize

**Examples**

* \tiny VideoCD -- Rent
* \tiny BookCopy -- Loan

::::
:::: column

\scriptsize

**CompositeTransaction -- LineItem**

\includegraphics[width=.85\textwidth]{images/collab_patterns/composite_transaction.eps}

* \tiny `CompositeTransaction` is a collection of `LineItems`
* \tiny `CompositeTransaction` contains one or more `LineItems` (cannot be empty)
* \tiny `LineItem` knows of one `CompositeTransaction` and cannot exist outside of the `CompositeTransaction`

\vskip0.5em
\scriptsize

**Examples**

* \tiny Order -- OrderDetail
* \tiny Performance -- Event

::::
:::

# Events Patterns

::: columns
:::: column

\scriptsize

**SpecificItem -- LineItem**

\includegraphics[width=.85\textwidth]{images/collab_patterns/specificitem_lineitem.eps}

* \tiny `SpecificItem` appears within `LineItems`
* \tiny `SpecificItem` knows of zero or more `LineItems`
* \tiny `LineItem` knows of a single `SpecificItem`

\vskip0.5em
\scriptsize

**Examples**

* \tiny VideoCD -- RentDetail
* \tiny Product -- OrderDetail

::::
:::: column

\scriptsize

**Transaction -- FollowupTransaction**

\includegraphics[width=.85\textwidth]{images/collab_patterns/followup_transaction.eps}

* \tiny `Transaction` is related to `FollowupTransaction`
* \tiny `Transaction` knows of zero or more `FollowupTransactions`
* \tiny `FollowupTransaction` knows of a single `Transaction`

\vskip0.5em
\scriptsize

**Examples**

* \tiny Order -- Payment
* \tiny Reserve -- Purchase

::::
:::

#

\centering
\vfill
\begin{minipage}{.375\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Inheritance
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# Inheritance

::: columns
:::: column

\footnotesize
* When two classes have both
  - \scriptsize A great deal of similarity
  - \scriptsize Significant differences
* Association is not applicable
  - \scriptsize Too similar to be captured by association
  - \scriptsize Differ too much that genericity cannot be employed
* If we have two such classes `C1` and `C2`
  - \scriptsize We extract the common aspects into class `B`
  - \scriptsize Reducing the size of `C1` and `C2`
  - \scriptsize Capturing only the unique properties and methods for each

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/uml/inherit.eps}

::::
:::

# Inheritance

::: columns
:::: column

\footnotesize
* This is **inheritance**, where `C1` and `C2` **inherit** from `B`
* `B` is the `baseclass` or `superclass` and `C1` and `C2` are the **derived classes** or **subclasses**
* Superclasses are generalizations or **abstractions**
  - \scriptsize we move toward a more general type (upward movement)
  - \scriptsize we denote **specialization** toward more specific classes (downward movement)
  - \scriptsize this forms a **hierarchy**

::::
:::: column

\centering
\includegraphics[width=\textwidth]{images/uml/inherit.eps}

::::
:::

# Example Hierarchy

::: columns
:::: {.column width=.4}

**Hierarchy**

\centering
\includegraphics[width=\textwidth]{images/uml/ex_hierarchy.eps}

::::
:::: {.column width=.6}

**Implementation**

\footnotesize

```java
public class Product {
  // functionality of product
}

public class Television extends Product {
  // functionality that is unique to televisions
  // modifications
}

public class Book extends Product {
  // functionality that is unique for books
  // modifications
}

```

::::
:::

# Class Structure

* We can consider two entities in isolation without worrying about similarities

\centering
\only<1>{\includegraphics[width=.85\textwidth]{images/uml/class_struct.eps}}
\only<2>{\includegraphics[width=.85\textwidth]{images/uml/class_struct_high.eps}}

* Now notice the similarities

# Class Structure

* OO provides the power to utilize these similarities by reducing the `Television` and `Book` classes by having them extend a common `Product` class

\includegraphics[width=.8\textwidth]{images/uml/class_struct_ref.eps}

# Implementation

**Product**

::: columns
:::: column
\scriptsize
```java
public class Product {
  private String company;
  private double price;
  private int quantitySold;

  public Product(String company, double price) {
    this.company = company;
    this.price = price;
  }

  public void sell() {
    quantitySold++;
  }
```

::::
:::: column
\scriptsize
```java
  public void setPrice(double newPrice) {
    price = newPrice
  }

  public String toString() {
    return "Company: " + company + " price: " +
      price + " quantity sold " + quantitySold;
  }
}





```
::::
:::

# Implementation

::: columns
:::: column
\footnotesize
**Television**

\scriptsize
```java
public class Television extends Product {

  private String model;

  public Television(String manufacturer,
      String model, double price) {
    super(manufacturer, price);
    this.model = model;
  }

  public String toString() {
    return super.toString() +
      " model: " + model;
  }
}



```

::::
:::: column

\footnotesize
**Book**

\scriptsize
```java
public class Book extends Product {

  private String title;
  private String author;

  public Book(String title, String author,
      String publisher, double price) {
    super(publisher, price);
    this.title = title;
    this.author = author;
  }

  public String toString() {
    return super.toString() + " title: "
      + title + " author: " + author;
  }
}
```

::::
:::

# Interface Realization

::: columns
:::: column

\centering
\includegraphics[width=.65\textwidth]{images/uml/interfaces.eps}

::::
:::: column

* The relationship between an interface and the implementing class is called **realization**
* Depicted in UML as a dotted line with a large open arrowhead pointing to the interface.

::::
:::

# Polymorphism

::: columns
:::: column

* \footnotesize In general the following polymorphic rules apply to any type hierarchy
  \scriptsize

  1. \scriptsize Any object of type `SubClass1` or `SubClass2` can be store in a reference of type `SuperClass`
  2. \scriptsize No object of type `SubClass1` (`SubClass2`) can be stored in a reference of type `SubClass2` (`SubClass1`)
  3. \scriptsize A reference of type `SuperClass` can be cast as a reference of type `SubClass1` or `SubClass2`

::::
:::: column

\centering
\includegraphics[width=.75\textwidth]{images/uml/poly_01.eps}

::::
:::

* \footnotesize Thus, a reference is able to point to objects of different types as long as the actual types of these objects conform to the type of reference.
* \footnotesize The above rules are the rules of **conformance**

# Polymorphism

* \scriptsize Polymorphism will result in a loss of information at run time
* \scriptsize But, it will allow us to invoke methods without knowing the specific object we are dealing with
* \scriptsize This is provided via **Dynamic Binding**

::: columns
:::: column

* \scriptsize If we have the hierarchy depicted, dynamic binding allows
  * \tiny Us to have a variable of type `GraduateStudent`
  * \tiny on which we can call `getGPACutoff()`

* \scriptsize Similarly, if we override `isInGoodStanding()` in `UndergraduateStudent`
  - \tiny If we have a variable of type `Student` but it is an instance of `UndergraduateStudent`
  - \tiny If we call `isInGoodStanding()` it will know to call the one in `UndergraduateStudent`
  - \tiny But a call to `getGPACutoff()` will be called in `Student`

::::
:::: column

\centering
\includegraphics[width=.95\textwidth]{images/uml/poly_02.eps}

::::
:::

# The `Object` Class

* In Java, the superclass of all classes is `java.lang.Object`
* Thus from polymorphism we know that a variable of type `Object` can hold a reference to any type
* The following is legal:

  ```java
  Object any;
  any = new Student();
  any = new Integer(4);
  any = "Some String";
  ```

# Genericity

* Mechanism for creating entities that vary only in the types of their parameters.
* Can be associated with any entity (class or method) that requires type parameterization.
* A generic entity replaces types with placeholders (**generic parameters**)
* Because of this generic entities are **not fully specified** and thus cannot be directly instantiated
* Generics relieve us of the need to classes that require the use of `Object` and require and overuse of casting and exception handling

# Genericity Example

```java
public class Stack<E> {
  public void push(E item) {
    // code to push item onto stack
  }

  public E pop() {
    // code to pop item from stack
  }
}

Stack<Integer> stack = new Stack<>();
```

# For Next Time

::: columns
:::: column
* Review Chapters 2 and 3 from the book
* Review this Lecture
* Come to Class
* Continue working on Homework 02
::::
:::: column
\centering
\includegraphics[width=.85\textwidth]{images/next_time-invert.png}
::::
:::

#

\centering
\includegraphics[scale=.40]{images/questions-invert.png}

\Huge \textbf{Are there any questions?}
