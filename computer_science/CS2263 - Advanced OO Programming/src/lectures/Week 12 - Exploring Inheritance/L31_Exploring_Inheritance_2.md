---
author:
- Dr. Isaac Griffith
title: Exploring Inheritance part 2
course: CS 2263
institute: Idaho State University
fontsize: 11pt
headerlogo: "images/header-logo.png"
footerlogo: "images/footer-logo.png"
titlelogo: "images/title-logo.png"
outline: false
...

# Outcomes

After today's lecture you will:

::: columns
:::: {.column width=.7}

* Have a deeper understanding of inheritance
* Understand the OCP
* Understand the SDP
* Understand the Factory and Visitor patterns
* Learn about the issues with multiple inheritance

::::
:::: {.column width=.25}
\vfill
\vskip7.75em
\centering
\includegraphics[width=\textwidth]{images/brain-gears-invert2.png}
::::
:::

#

\ts{Exploring Inheritance}

# Drawbacks of the Approach

* In general, we have two goals:
  - The system should be easy to build and test
  - The system should be adaptable

# Easy to Build and Test

* As we store more and more complexity in `Book` we decrease the ease of build and test

\vskip.5em

* With two categories of objects we have
  - 10 outcomes to test

\vskip.5em

* Furthermore, as we increase the amount of combinations in a class we increase the likelihood of human error

# Adaptability

Change is inevitable, and in our system changes takes two forms;

1. Procedures for performing library operations may change

\vskip.5em

2. We may add new categories of items to the library

\vskip.5em

* Our current structure hurts us for both of these situations
  - each time we add a new item type, we must modify each method
  - This means we must add new tests for each method

\vskip.5em

* This approach violates the **OCP**
  - A module must be open for extension but closed for modification
    * **Extension** -> adding new features
    * **Modification** -> converting design to code

# OCP

* We want to be able to update the system
  - This will require modifying existing classes
  - But, we want to ensure that classes not directly involved in the change are unaffected

\vskip.5em

* Often, we can encapsulate changes into a separate class, which must be related to existing classes
  - Inheritance allows this without requiring much modification of other classes

# Improving Design

* What classes must change to accomodate the new kinds of items?
  - `Library` -> it is a `Facade` after all
  - `UserInterface`

\vskip.5em

* Is there a set of guiding principles that can be employed when we introduce inheritance to incorporate the new items?

\vskip.5em

* Is there a systematic procedure that we can employ when introducing inheritance?

# Designing the Hierarchy

* We have two classes: `Book` and `Periodical`
  - Now we need to determine how they are related

\vskip.5em

::: columns
:::: column

**Option 1:** Common Ancestor

\centering
\includegraphics[width=.85\textwidth]{images/inherit/inheritance04.eps}

::::
:::: column

**Option 2:** One Inherits from the Other

\centering
\includegraphics[width=.5\textwidth]{images/inherit/inheritance05.eps}

::::
:::

# Designing the Hierarchy

**Option 1:** Common Ancestor

\vskip.5em

::: columns
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/inherit/inheritance04.eps}

::::
:::: column

* Create abstract class `LoanableItem`
* Update `Catalog` to be collection of `LoanableItem`s
* Update other classes to use `LoanableItem` rather than `Book`

\vskip.5em

**Advantages**

* Treats all items uniformly

\vskip.5em

**Disadvantages**

* Updates are tedious

::::
:::

# Designing the Hierarchy

**Option 2:** One Inherits from the Other

::: columns
:::: column

\centering
\includegraphics[width=.5\textwidth]{images/inherit/inheritance05.eps}

::::
:::: column

* `Book` already exists so we don't need to change other classes

\vskip.5em

**Advantages**

* Quick to implement

\vskip.5em

**Disadvantages**

* In the long run this approach will be detrimental to the system

::::
:::

# Stability

**Stable Dependencies Principle (SDP)**

> Depend in the direction of stability

\vskip.5em

* **Stability:** the amount of work required to be put in to disturb the existing equilibrium

\vskip.5em

* An unstable system, if left undisturbed, may remain stable for a very long time, but it only takes minimal effort to make it unstable

# Stability

* In our system, we want to ensure that `LoanableItem` is very stable, as the hierarchy depends upon it.

\vskip.5em

* The top-down design of procedural approaches tend to lead to unstable systems, but the bottom-up approach of OO design will tend to lead to stable systems

\vskip.5em

::: columns
:::: column

* In OO we turn the dependency around such that we specify only the abstraction for which concretions satisfy

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/inherit/inheritance06.eps}

::::
:::

# Designing the Hierarchy

**Rule of Thumb:** Depend upon abstractions; avoid depending upon concrete implementations

* Thus, we choose Option 2:

  \tiny

  ```java
  public abstract class LoanableItem implements Matchable<String> {
    // code common to all types of items that the library lends
  }

  public class Book extends LoanableItem {
    // code specific to books
  }

  public class Periodical extends LoanableItem {
    // code specific to periodicals
  }
  ```

  \normalsize

* Which implies that we need to update several classes, including:
  - `Library`
  - `Catalog`
  - `Member`

# Invoking the Constructors

* We move our calls to constructors into `Library` under method `addLoanableItem()`
  - here we need to add switching for each type
  - as we add new types, we would need to update this method
  - this does shift us to refer to the abstract type and lets **dynamic binding** take care of the rest
  - **Note:** the conditionals for calling the constructors cannot be eliminated

\vskip.5em

* We now want to protect `Library` from being affected by changes to the hierarchy

# Invoking Constructors

\tiny
```java
private static final int BOOK = 1;
private static final int PERIODICAL = 2;
public void addLoanableItem() {
  LoanableItem result;
  do {
    String typeString = getToken("Enter type: " +
                                BOOK + " for books\n" +
                                PERIODICAL + " for periodicals\n");
    int type = Integer.parseInt(typeString);
    String title = getToken("Enter title");
    String author = null;
    if (type == BOOK) {
      author = getToken("Enter author");
    }
    String id = getToken("Enter id");
    result = library.addLoanableItem(type, title, author, id);
    if (result != null) {
      System.out.println(result);
    } esle {
      System.out.println("Item could not be added");
    }
    if (!yesOrNo("Add more items?")) {
      break;
    }
  } while (true):
}
```

# Calling Constructors

* We have three options to construct out items in the `Library` class
  1. We could extend `Library` to have subclasses specific to each type we want to create
  2. We could move the creation logic to `LoanableItem` (the abstract superclass)
  3. We could create a class to take care of creating items

# Calling Constructors

* We have three options to construct out items in the `Library` class
  1. We could extend `Library` to have subclasses specific to each type we want to create
     - This doesn't make sense as all classes which depend on `Library` would need to change. Since this is a facade that is a lot of classes.
  2. We could move the creation logic to `LoanableItem` (the abstract superclass)
  3. We could create a class to take care of creating items

# Calling Constructors

* We have three options to construct out items in the `Library` class
  1. We could extend `Library` to have subclasses specific to each type we want to create
  2. We could move the creation logic to `LoanableItem` (the abstract superclass)
     - Seems logical, but it defeats the purpose of having an inheritance hierarchy in the first place as the superclass depends on its children.
  3. We could create a class to take care of creating items

# Calling Constructors

* We have three options to construct out items in the `Library` class
  1. We could extend `Library` to have subclasses specific to each type we want to create
  2. We could move the creation logic to `LoanableItem` (the abstract superclass)
  3. We could create a class to take care of creating items
     - This is the best choice as we will create a separate class to encapsulate the changes that occur for calling constructors

# Creating Inheritance Hierarchies

Some things to remember when creating inheritance hierarchies:

* Do not rush in too soon
  - have a clear data abstraction in mind before creating the hierarchy

\vskip.5em

* Allow for future expansion
  - define methods to be as general as possible at each level of the hierarchy
  - be generous in defining data types and storage to avoid difficult changes later on

\vskip.5em

* Make sure the construction is secure
  - choose the right access modifiers for your attributes
  - only expose items that are needed by derived classes
  - the functionality provided by the methods of the base class should not depend on features that can be overridden

# A Simple Factory

* A **Factory** is employed when we wish to make a system independent of how its products are created, composed, and represented

\vskip.5em

* Here, we want `Library` to be independent of the construction of items.

\vskip.5em

* Thus, we create the `LoanableItemFactory`


# A Simple Factory

::: columns
:::: column

\tiny
```java
public class LoanableItemFactory {
  private static final int BOOK = 1;
  private static final int PERIODICAL = 2;
  private static LoanableItemFactory lFactory;
  private LoanableItemFactory() { }

  public static LoanableItemFactory instance() {
    if (lFactory == null)
      return lFactory = new LoanableItemFactory();
    else
      return lFactory
  }

  public LoanableItem createLoanableItem(int type, String title,
                                        String author, String id) {
    switch (type) {
      case BOOK:
        return new Book(title, author, id);
      case PERIODICAL:
        return new Periodical(title, id);
      default:
        return null;
    }
  }
}
```

::::
:::: column

\tiny

```java
public LoanableItem addLoanableItem(int type, String title,
                                   String author, String id) {
  LoanableItemFactory factory = LoanableItemFactory.instance();
  LoanableItem item = factory.createLoanableItem(type, title, author, id);

  if (item != null) {
    if (catalog.insertLoanableItem(item))
      return item;
  }
  return null;
}















```

::::
:::

# Distributing Responsibilities

* \footnotesize This perhaps is the most difficult part of hierarchy changes

\vskip.5em

* \footnotesize \textbf{Goal:} to keep client classes unaware of the structure of the hierarchy
  - \scriptsize Thus, any method called by the client must exist in the abstract superclass (`LoanableItem`)
  - \scriptsize We also need to store fields and assign access modifiers based on these considerations

  \vskip.5em

  \tiny
  ```java
  public abstract class LoanableItem implements Serializable, Matchable<String> {
    private String title;
    private String id;
    private Member borrowedBy;
    protected Calendar dueDate;

    public boolean matches(String other) { return this.id.equals(id);  }

    public String getTitle() { return title; }

    public String getId() { return id; }

    public Member getBorrower() { return borrowedBy; }

    public String getDueDate() { return (dueDate.getTime().toString()); }
    // other fields and methods
  }
  ```

# Distributing Responsibilities

* \scriptsize Fields `title` and `id` are immutable -> `private`
* \scriptsize Other fields are `protected` so they can be accessed by subclasses
* \scriptsize Methods like `getAuthor()` are a specialization of `Book` -> left out
* \scriptsize Methods for processing holds are similar for all items -> implemented in superclass

\tiny
\vspace{-1.5em}

::: columns
:::: column

  ```java
  protected List holds = new LinkedList();
  protected String author;

  public String getAuthor() { return ""; }
  public Iterator getHolds() { return holds.iterator(); }
  public void placeHold(Hold hold) { holds.add(hold); }
  public void removeHold(String memberId) {
    for (ListIterator iterator = holds.listIterator();
                    iterator.hasNext(); ) {
      Hold hold = (Hold) iterator.next();
      String id = hold.getMember().getId();
      if (id.equals(memberId)) {
        iterator.remove();
      }
    }
  }
  ```

::::
:::: column

  ```java
  public Hold getNextHold() {
    for (ListIterator iterator = holds.listIterator();
                    iterator.hasNext(); ) {
      Hold hold = (Hold) iterator.next();
      iterator.remove();
      if (hold.isValid()) {
        return hold;
      }
    }
    return null;
  }
  public boolean hasHold() {
    ListIterator iterator = holds.listIterator();
    if (iterator.hasNext()) {
      return true;
    }
    return false;
  }
  ```
::::
:::

# Consequences of Introducing Inheritance

* **Exception Handling in Inheritance Hierarchies**
  - **Rule:** A subclass that overrides a method of a superclass may not throw an exception that is not thrown by the superclass method

  - This is a consequence of the **LSP**

  - We can get around this limitation by using an **Exception Hierarchy**

# Introducing Inheritance by Refactoring

* In the first attempt at changing the library system we introduced the code smell **Switch Statements** where we were selecting the behavior of the `Book` class based on the value of a field.

\vskip.5em

* Whenever we see code like this we should immediately be thinking that we can replace this with polymorphism. Luckily, there is such a refactoring that can guides us in this process.

# Replace Conditional with Polymorphism

\footnotesize

> If you have a conditional that chooses different behavior depending on some feature of the object, move each leg of the conditional to an overriding method in a (possibly newly defined) subclass and make the original method abstract.

**Steps in this Refactoring**

1. \scriptsize Identify a conditional statement in a method that changes its behavior based on the value stored in a particular field.
   - \tiny \textbf{Note:} in a large class there will be several methods that switch on a field
2. \scriptsize If the conditional statement is part of a larger method, the conditional may have to be extracted using the **Extract Method** refactoring.
   - \tiny \textbf{Note:} if the extract cannot be easily done, you may need to re-evaluate the class more closely
3. \scriptsize Define an inheritance hierarchy where the subclasses reflect the variations in the field on which we are switching
4. \scriptsize Create a subclass method that overrides the conditional statement method
   - \tiny Copy one leg of the conditional into each of the subclass methods
   - \tiny Adjust the code so it fits
5. \scriptsize Remove the conditional from the superclass method and make the method abstract.
   - \tiny If appropriate remove the field on which the switching was done

# Adding New Functionality

* Replacing a class with a hierarchy poses additional problems when new functionality needs to be added

\vskip.5em

* Problems that can occur are as follows:
  - The design may be tailored too specifically to one kind of operation
    * Making it difficult to add new ones
  - The design is tailored for one class and cannot accommodate a hierarchy
    * Does not allow for subclass specific operations

# Visitor Pattern

* The standard solution for dealing with these issues is the **Visitor Design Pattern**

\vskip.5em

* **Pattern Intent:** to represent an operation to be performed on the elements of an object structure, and is employed to define a new operation without changing the classes of elements on which it operates

\vskip.5em

* The base principle is to **Encapsulate What Varies** by creating a separate structure that accommodates the changes and shields the classes that must be kept stable

# Visitor Pattern

**Description**

* **Visitor Interface:** encapsulates the variability in the object structure

\vskip.5em

* **`accept` method**: required in each visitee

  `public void accept(Visitor v)`

\vskip.5em

* Concrete class for the required functionality that implements the visitor interface

# Visitor Behavior

\centering
\includegraphics[width=.75\textwidth]{images/inherit/inheritance07.eps}

# Multiple Inheritance

* **Multiple Inheritance:** ability of a class to subclass multiple classes

# Multiple Inheritance

\centering
\includegraphics[width=.6\textwidth]{images/inherit/inheritance08.eps}

\centering
\includegraphics[width=.6\textwidth]{images/inherit/inheritance09.eps}

# Resolving Conflicts

\begin{center}
\includegraphics[width=.85\textwidth]{images/inherit/inheritance11.eps}
\end{center}

Since we have redundant concepts we need a way to resolve this

1. "un-inherit" specific components to resolve the ambiguity

2. declare unwanted components abstract


# Repeated Inheritance

* Also called the diamond problem

\vskip.5em

::: columns
:::: column

* This could allow for multiple invocations of ancestor method

\vskip.5em

* Requires deep knowledge of the hierarchy
  - This may not be available (as in the case of an API or library)

\vskip.5em

* No real good way of handling issues this creates

::::
:::: column

\centering
\includegraphics[width=.85\textwidth]{images/inherit/inheritance12.eps}

::::
:::

# Multiple Inheritance in Java

* Java does not allow multiple inheritance in the traditional sense

* Allows only inheriting an implementation from a single class

* We can implement an interface, and as these are types, we have a form of multiple inheritance

# For Next Time

::: columns
:::: {.column width=.6}
* Review this Lecture
* Review Chapter 9.5 - 9.9
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
