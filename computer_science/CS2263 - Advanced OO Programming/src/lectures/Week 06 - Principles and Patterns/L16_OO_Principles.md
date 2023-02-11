---
author:
- Dr. Isaac Griffith
title: OO Design Principles
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
* \small Understand the basic principles of Object Oriented Design
* \small Be capable of applying these principles in you daily development
* \small Be capable of identifying violations of the SOLID principles
* \small Understand approaches to handle such violations
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
\begin{minipage}{.475\textwidth}
\begin{center}
\includegraphics[width=13pt]{images/mark.png}
\Huge Design Principles
\end{center}
\vskip-1em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}

# The Open-Closed Principle (OCP)

\textcolor{Buttons}{\textbf{\textit{Make code which is open for extension, but closed for modification}}}

* \small i.e., keep your codebase easily extensible by isolating & limiting the spots that need to change

\vskip.5em

* \small (Note its related to Encapsulate what Varies)

\vskip.5em

* \small Inheritance with significant overriding can violate OCP since overriding is modifying -- either
  - \footnotesize "Favor Composition over Inheritance" (another [principle](https://en.wikipedia.org/wiki/Composition_over_inheritance), btw) -- use composition to "plug in" the part that incorporates the extension
  - \footnotesize Allow subclassing but declare nearly all methods **final** to greatly limit or eliminate overriding

\vskip.5em

* \small OCP makes code more reliable since complex inter-dependencies don't have random changes injected into them by outsiders.

# OCP Example

\scriptsize
```csharp
    public class Rectangle
    {
        public double Width { get; set; }
        public double Height { get; set; }
    }

    public class AreaCalculator
    {
        public double Area(Rectangle[] shapes)
        {
            double area = 0;
            foreach (var shape in shapes)
            {
                area += shape.Width*shape.Height;
            }

            return area;
        }
    }
```

# OCP Example

\scriptsize
```java
    public double Area(object[] shapes)
    {
        double area = 0;
        foreach (var shape in shapes)
        {
            if (shape is Rectangle)
            {
                Rectangle rectangle = (Rectangle) shape;
                area += rectangle.Width*rectangle.Height;
            }
            else
            {
                Circle circle = (Circle)shape;
                area += circle.Radius * circle.Radius * Math.PI;
            }
        }

        return area;
    }
```

# OCP Example -- Fixed

```csharp
    public abstract class Shape
    {
        public abstract double Area();
    }
```

# OCP Example -- Fixed

\scriptsize
```csharp
    public class Rectangle : Shape
    {
        public double Width { get; set; }
        public double Height { get; set; }
        public override double Area()
        {
            return Width*Height;
        }
    }

    public class Circle : Shape
    {
        public double Radius { get; set; }
        public override double Area()
        {
            return Radius*Radius*Math.PI;
        }
    }
```

# OCP Example -- Fixed

\scriptsize
```csharp
    public double Area(Shape[] shapes)
    {
        double area = 0;
        foreach (var shape in shapes)
        {
            area += shape.Area();
        }

        return area;
    }
```

# OCP Violations

\textcolor{Roarange}{\textbf{Finding}}

* \small Do you work directly with a concrete implementation rather than an abstraction?

\vskip.5em

* \small Does your code show issues when you extend classes to accommodate new functionality

\vskip.5em

* \small Other signs:
  - \footnotesize you have private methods that do nearly the same thing but with only slight variations
  - \footnotesize you use a lot of ifs/switches to control behavior
  - \footnotesize you use abstract classes but check for concrete implementations (`instanceof`) to control flow

\textcolor{Roarange}{\textbf{Handling}}

* \small Apply the Strategy, Template Method, Decorator, or State Patterns

# Liskov Substitution Principle (LSP)

\small \textcolor{Buttons}{\textbf{\textit{Objects of a superclass shall be replaceable with objects of its subclasses without breaking the application.}}}

* \small That requires the objects of your subclasses to behave in the same way as the objects of your superclass

\vskip0.5em

* \small This can be achieved by following a couple of simple rules
  - \footnotesize An overridden method of a subclass needs to accept the same input parameter values as the method of the superclass
    * \scriptsize You can have less restrictive validation rules, but not more restrictive ones
    * \scriptsize Otherwise, any call on this method via a superclass typed variable might lead to an exception

  \vskip0.25em

  - \footnotesize The return value of a method of the subclass needs to comply with the same rules as the return value of the method of the superclass
    * \scriptsize You may apply a stricter type (more specific subtype) than than the super class, but not a more general type than the superclass provides

# LSP Example

::: columns
:::: column

\scriptsize

```java
public class Rectangle
{
    int height, width;

    Rectangle(int w, int h) {
      height = h; width = w;
    }

    public int getHeight() { return height; }
    public int getWidth() { return height; }
    public int setHeight(int h) { height = h; }
    public int setWidth(int w) { width = w; }
    public int findArea() {
      return getHeight() * getWidth();
    }
}
```

::::
:::: column

\scriptsize

```java
public class Square extends Rectangle
{
    Square(int s) { new Rectangle(s,s); }

    // set both to preserve square-ness
    public int setSide(int h) {
      width = h;
      height = h;
    }

    public int setHeight(int h) { setSide(h); }
    public int setWidth(int w) { setSide(w); }
}




```

::::
:::

# LSP Example


\scriptsize

```java
    s = new Square(10);
    Rectangle r = s; // imagine this was a function call
                     // passing a Square to function asking
                     // for a Rectangle
    //  equivalence r.getWidth() == (r.setHeight(4).getWidth())
    //  should hold but would fail for the above
    //     - bad attempt at Square is-a Rectangle.
```

# LSP Example

* \small Does `Square` is-a `Rectangle` hold??

\vskip.5em

* \small First, we had to override width/height to try to keep square from becoming a non-square with `aSquare.setHeight(4);`

\vskip.5em

* \small But, the above code attempt violates rectangle invariant that setting a rectangle's width should not alter height: really bad code!

\vskip.5em

* \small If there is no mutation (the width/height fields are `final`) the is-a relationship is reasonable - that interface supports is-a fully

# LSP Violations

\textcolor{Roarange}{\textbf{Finding}}

* \small Look for subtypes that don't behave the same way as their base classes

\vskip.5em

* \small Check inheritance hierarchies that are deeply nested

\textcolor{Roarange}{\textbf{Handling}}

* \small Reduce inheritance using composition

# Interface Segregation Principle (ISP)

\textcolor{Buttons}{\textbf{\textit{Clients should not be forced to depend on methods (inherit from or implement) they don't use}}}

* \small To be more precise, the bad methods are ones that not only don't they use now, they will never conceivably want to use them because they intuitively "don't belong": the interface is \textcolor{Roarange}{\textbf{too fat}}

\vskip.5em

* \small These extra methods are "junk" and clutter the design space; more fundamentally, they are a sign that the class/method structuring is not correct.

\vskip.5em

* \small If you have this pattern it means you need to refactor, often by turning one interface into many.

# ISP Example

* \small The Java Swing GUI library has different `Listener` interfaces for different events

\vskip.5em

* \small Mouse events have many types of events: clicking but also just cursor movement or wheel motion

\vskip.5em

* \small Most of the time programmers only care about clicks, not how the mouse is moving.

\vskip.5em

* \small If there was one single Mouse Listener interface users would need to write empty methods for the wheel/motion/etc events they don't care about

\vskip.5em

* \small Example Solution: Java Swing uses three separate interfaces for mouse events, `MouseListener`, `MouseWheelListener`, `MouseMotionListener` to "segregate" the types of mouse events; only `implement` the interfaces you need.

# ISP Violations

\textcolor{Roarange}{\textbf{Finding}}

* \small Look for interfaces with more than a few methods
  - \footnotesize Do the methods form a cohesive group and are all used by clients?

\vskip.5em

* \small Look for deep layers of inheritance

\textcolor{Roarange}{\textbf{Handling}}

* \small Split the interfaces into multiple, smaller interfaces that define a specific need or role (also called RoleInterfaces)

# Dependency Inversion Principle (DIP)

\textcolor{Buttons}{\textbf{\textit{Don't depend on concrete classes, depend on abstractions}}}

\vskip.5em

\small Don't have high-level (user) code directly call/inherit from low-level (library) code; instead,

1. \small Library or component publishes an interface (or, if that is not possible, an abstract class)
2. \small Users write a class conforming to that interface (or extending abstract class), which then interacts with the other library classes.

\vskip.5em

This is an \textcolor{Buttons}{\textbf{\textit{inversion:}}} in traditional software the higher-level components directly invoke the lower-level ones: this principle inverts that since the user code now depends on a high-level interface: \textcolor{Buttons}{\textbf{\textit{dependency inversion}}} has taken place.

# Why does DIP help?

* \small First, it allows different low-level implementations to be swapped out; as long as they implement the common interface all is well.

\vskip.5em

* \small More generally, it increases \textcolor{Buttons}{\textbf{\textit{encapsulation}}}

\vskip.5em

* \small This principle is widespread in well-written libraries; for example when you run the debugger on your Swing app you will see all these strange implementation class names you have never heard of which subclass or implement the class/interface you were interacting with.

# DIP Violations

\textcolor{Roarange}{\textbf{Finding}}

* \small Check dependencies between modules
  - \footnotesize If a high-level abstract module depends on a low-level module, that is a violation

\vskip.5em

* \small Look at areas where it is difficult to add or remove a low-level part of the application

\vskip.5em

* \small Look at areas that are difficult to test

\textcolor{Roarange}{\textbf{Handling}}

* \small Replace the use of concrete types for variables with interfaces

\vskip.5em

* \small Add in new interfaces as abstractions to concrete classes

\vskip.5em

* \small Utilize the Dependency Injection approach or Factory Patterns

#

\centering
\vfill
\begin{minipage}{.45\textwidth}
{
\includegraphics[width=13pt]{images/mark.png}
\Huge Other Principles
}
\vskip-.5em
\textcolor{GrowlingGray}{\rule{\textwidth}{2pt}}
\large \color{Roarange}\textbf{\hfill CS 2263}
\end{minipage}


# Basic A&D Principles

Here are some basic design principles you probably have already heard about:

* \small Well-designed software is easier to debug, change and extend.

\vskip.5em

* \small Code to interfaces, not implementations

\vskip.5em

* \small Share common behavior via inheritance

\vskip.5em

* \small If design is proving to be inflexible, refactor it to restore it to be a good design (Refactoring is a lecture topic on its own later)

\vskip.5em

* \small Make classes cohesive: class should have a single, clearly stated purpose which fits its name and all of its fields and methods.
  - \footnotesize Similarly at the lower level of methods: the name should be (all that) it does.
  - \footnotesize We will cover a similar principle below, the Single Responsibility Principle (SRP).

# Don't Repeat Yourself (DRY)

\textcolor{Buttons}{\textbf{\textit{Avoid duplicate code -- abstract out things in common to a single location}}}

* \small Finding this smell is easy, nearly-identical code blocks will Repeat

\vskip.5em

* \small The problem is if you don't abstract it out, you have two parallel codebases to try to keep consistent and you often fail

\vskip.5em

* \small And maybe two copies turns into three turns into four before you realize what is happening.

\vskip.5em

* \small You can solve it by moving code to a common method, making a common superclass, etc.

# Loose Coupling

\textcolor{Buttons}{\textbf{\textit{Strive for loosely coupled designs of autonomous, interacting objects}}}

\textcolor{Roarange}{\textbf{Examples}}

* \small Swing \textcolor{Roarange}{\textbf{Listener}}'s: the Swing event system and the user's action code need to know almost nothing about each other besides the methods on the listener.

\vskip.5em

* \small MVC in general illustrates the advantages of loose coupling.

# LC Deeper Philosophy

There is a deeper principle here:

* \small The more complex the system the more loosely coupled, autonomous, and multi-layered it needs to be.

\vskip.5em

* \small Think of the human body for example: there are components, sub-components, sub-sub-components, etc.

\vskip.5em

* \small It wasn't consciously \textcolor{Buttons}{\textbf{\textit{designed}}} that way, it emerged that way.

# Encapsulate What Varies

AKA encapsulate code that changes a lot. This basic O-O principle you may not know as well, here is a brief overview.

* \small One way that ugly code arises is new code has to be patched in as new features are added

\vskip.5em

* \small If you push code deeper into classes and behind encapsulation boundaries the change is isolated, code is more maintainable.

# Encapsulate What Varies

Original smelly code, any changes to policy on when customer can check out a book or when a book is available requires change to \textcolor{Roarange}{\textbf{checkoutBook}} method:

\footnotesize
```js
var library = {
  checkoutBook: function (customer, book) {
    if (customer && customer.fine <= 0.0 && customer.card &&
        customer.card.expiration === null && book && !book.isCheckedOut &&
      (!book.reserveDate || book.reserveDate.getTime() > (new Date()).getTime())) {
      customer.books.push(book);
      book.isCheckedOut = true;
    }
    return customer;
  }
};
```

# Encapsulate What Varies

\small
\textbf{\underline{Improved code}:} pull out the concepts of a customer that \textcolor{Roarange}{\textbf{canCheckoutBook}} into its own method, and similarly for a book that \textcolor{Roarange}{\textbf{isAvailable}} (plus, in turn pull out even more methods \textcolor{Roarange}{\textbf{hasFine}} and \textcolor{Roarange}{\textbf{hasActiveLibraryCard}} etc from those actions):

```js
var library = {
  checkoutBook: function (customer, book) {
    if (customer.canCheckoutBook() && book.isAvailable()) {
      customer.checkout(book);
    }
    return customer;
  }
};
```

# Encapsulate What Varies

\small

```js
  var customer = {
    canCheckoutBook: function () {
      return !this.hasFine() && this.hasActiveLibraryCard();
    },
    hasFine: function () {
      return this.fine > 0.0;
    },
    hasActiveLibraryCard: function () {
      return this.card !== null && this.card.expiration === null;
    },
    checkout: function (book) {
      //implementation
    }
  };
```

# Encapsulate What Varies

\footnotesize

```js
var book = {
  isAvailable: function () {
    return !this.isCheckedOut && !this.isReserved();
  },
  isReserved: function () {
    return this.reserveDate !== null &&!this.isFutureReserve();
  },
  isFutureReserve: function () {
    return this.reserveDate.getTime() > (new Date()).getTime();
  }
};
```

\small

The \textcolor{Roarange}{\textbf{library}} code is now not needing to change at all if there is a change in the policy on when customers can check out books or what defines a book being available -- we \textcolor{Buttons}{\textbf{\textit{Encapsulated what Varied}}}!

# Separation of Concerns

* \small Separation of Concerns (SoC)
  - \footnotesize don't have many different concerns in one class; instead, different tasks/aspects should be in different classes/functions.
  - \footnotesize also related to SRP, SRP is "one concern per class"

# The Principle of Least Knowledge

\textcolor{Buttons}{\textbf{\textit{Talk only to your immediate friends}}}

* \small Don't dig deep inside your friends for friends of friends of friends and get in deep conversations with them -- don't do
  `aWindow.getPane().getRasterizer().setUpdateFrequency(60)`

\vskip.5em

* \small Code is more convoluted if too many objects are directly interacting with one another, and bugs are more likely to be introduced as the code evolves over time.

\vskip.5em

* \small Solution: let the shared friend be an intermediary instead of introducing lots of long-range dependencies.

  `aWindow.useHighUpdateFrequency()`

\vskip.5em

* \small This is related to the principle of loose coupling, things close are coupled tightly and things far are coupled loosely.

# For Next Time

::: columns
:::: column
* Review this Lecture
* Read Chapter 5 from the book
* \textcolor{Roarange}{\textbf{Continue working on Project Part 1}}
* Come to Class
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
