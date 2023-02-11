# Week 1

---

## Lecture 01 - Git

- Foundational Knowledge:
  * Why Git and SCM
  * How Git Works
  * .gitignore, readme, and changelog
  * Basic Git Commands
    - config, init, clone, add, commit
    - diff, reset, status, rm, log
    - tag, branch, checkout
    - remote, push, pull, fetch
- Examples (Live Coding):
  * Create a simple git repo
  * Execute commands as follows
    - init -> config -> add -> commit -> remote -> push
    - clone (new directory) -> add -> commit -> push -> branch -> push all
    - (old dir) status -> checkout -> pull -> remote -> add -> commit -> push
    - (new dir) fetch -> merge -> log -> rm -> reset -> tag
- Quick Exploration:
  * Have students do a similar exercise as in the example
- Homework:
  * Have students explore svn, Hg, cvs, as compared to git
    - should focus on team work, working on same feature, and other issues
  * Evaluation of open source project readmes and changelogs
    - what did they do well?
    - what can be improved?
- Quiz Questions:
  * Ask about basic git commands and when to use them
- Projects: All projects require the use of git
- Resources:

## Lecture 02 - GitFlow

- Foundation Knowledge:
  * What gitflow provides
  * Basic concepts of the flow
  * Semantic versioning
  * Commands
    - init
    - feature (start, publish, finish, pull, track)
    - release (start, publish, finish, pull, track)
    - hotfix  (start, publish, finish, pull, track)
- Examples (Live Coding):
  - create repo
  - create dir -> init -> push all
  - feature start, publish, track, pull (other dir), finish
  - release start, publish, track, finish
  - hotfix start, finish
  - show graph
- Quick Exploration:
  - Have students do a similar exercise as in the example
- Homework:
- Quiz Questions:
  * puposes of each number in semantic versioning
- Projects: All projects require the use of gitflow
- Resources:

---

## Lecture 03 - Gradle

---

- Foundation Knowledge:
  - Build and dependency management
  - Gradle
  - build.gradle and
  - Commands:
    * init, clean, build, test
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects: All projects will require the use of gradle

---

# Mini Project 01

---

Goal is to utilize GitHub, Git, GitFlow, and Gradle to:

* Fork a provided project
* Create a new feature in the project
* Add Gradle as a dependency management component to the project
* Add a library to gradle
* Use gradle to build and test the project
* Add a tool (JaCoCo) to the gradle build
* Use gradle to run JaCoCo
* Commit the changes
* Finish the feature
* Create a release
* Update the Changelog and Readme
* Finish the release
* push all changes

---

# Week 2

---

## Lecture 04 - Basic OO Concepts

- Foundation Knowledge:
  * Role of Objects and Classes
  * Abstraction
  * UML
  * Design Patterns
  * Analysis Process
  * Extendability and Adaptability
  * Modular Design and Encapsulation
  * Cohesion and Coupling
  * Modifiability and Testability
  * Benefits and Drawbacks of OO
  * Brief History of OO
- Examples:
- Quick Exploration:
- Homework: Ch 1 exercises 3, 4, 5
- Quiz Questions: Ch 1 exercises 6
- Projects:

## Lecture 05 - Basic OO Programming

- Foundation Knowledge:
  * Basics
    - attributes
    - instantiation
    - references
  * Classes
    - behavior
    - fields
    - accessibility
    - methods
    - constructors
    - printing objects
    - static members
  * Multiple classes
    - this
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 2.1 - 2.4

## Lecture 06 - Basic OO Programming

- Foundation Knowledge:
  * Interfaces
    - ADTs
    - Inner classes
  * Abstract Classes
  * Object Equality
  * Describing OO Systems
    - Class Diagrams
    - Use Cases and Use Case Diagrams
    - Sequence Diagrams
    - Associations
    - Interface Implementation
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 2.5 - 2.8

---

# Week 3

---

## Lecture 07 - Relationships

- Foundation Knowledge:
  * Associations
    - Characteristics
  * Inheritance
    - Hierarchies
    - Inheriting from an Interface
    - Polymorphism and Dynamic Binding
    - Protected Fields and Methods
    - The Object Class
  * Genericity
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 3

## Lecture 08 - OO Language Features

- Foundation Knowledge:
  - Organizing Classes
    - Files
    - Packages
    - Protected and Package Access
  - Collection Classes
  - Exceptions
  - Run-Time Type Identification
    - Reflection
    - instanceof
    - Downcasting
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 4.1 - 4.4

## Lecture 09a - GUI Support

- Foundation Knowledge:
  - The Basics
  - Event Handling
  - Widgets and Layouts
  - Drawing Shapes
  - Displaying Text
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Rsources: Chapter 4.5

---

## Mini-Project 02

---



---

## Lecture 09b - Long-Term Storage of Objects

---

- Foundation Knowledge:
  - Storing and Retrieving Objects
  - Issues in Storing and Retrieving Objects
  - Java Serialization
  - JSON and Gson Serialization
  - XML and XStream Serialization
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 4.6 and Gson/XStream tutorials

---

# Week 4

---

## Lecture 10 - Coding Style

- Foundation Knowledge:
  - Why care about style?
  - Google Code Style for Java as a baseline
  - Checking the style of your code
    - Using IntelliJ
    - Using Gradle and CheckStyle
  - Documenting your Code
    - Java Doc guidelines
  - Generating Code Documentation
    - Manually
    - Using Gradle
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources:

## Lecture 11 - Principles and Idioms

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 12 - Elementary Design Patterns

- Foundation Knowledge:
  - Iterator pattern
  - Singleton pattern
  - Adapter pattern
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 5

---

# Week 5

---

## Lecture 13 - Gathering Requirements

- Foundation Knowledge:
  * The Analysis Phase
  * Gathering the requirements
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 14 - Requirements Specifications

- Foundation Knowledge:
  * Functional Requirements Specifications
  * Use Case Analysis
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 15 - Domain Analysis

- Foundation Knowledge:
  * Defining Conceptual Classes and Relationships
  * Using Knowledge of the Domain
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

---

# Week 6

---

## Lecture 16 - Design

- Foundation Knowledge:
  * Major Subsystem Design
  * Creating Software Classes
  * Assigning Responsibilities to Classes
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 7.1.1 - 7.1.4

## Lecture 17 - UI and Data Storage Design

- Foundation Knowledge:
  * Class Diagrams
  * User Interface Design
  * Data Storage Design
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 7.1.5 - 7.1.6

## Lecture 18 - Implementation

- Foundation Knowledge:
  * Design Implementation
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 7.2

---

# Week 7

---

## Lecture 19 - Commercial Development

- Foundation Knowledge:
  * Conceptual, Software and Implementation Classes
  * Building a Commercially Acceptable System
  * The Facade Pattern
  * Implementing Singletons
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 7.3

## Lecture 20 - Refactoring

- Foundation Knowledge:
  - Refactoring
  - Using Generics to refactor duplicated code
  - Code Smells
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 21 - Release Engineering

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

---

# Week 8

---

## Lecture 22 - Exploring Inheritance

- Foundation Knowledge:
  * Applications of Inheritance
    - Restricting Behaviors and Properties
    - Abstract Superclass
    - Adding Features
    - Hiding Features
    - Combining Structural and Type Inheritance
  * Limitations and Caveats of Inheritance
    - Deep Hierarchies
    - Lack of Multiple Inheritance
    - Changes in the Superclass
    - Liskov Substitution Principle
    - Addressing Limitations
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 9.1 - 9.3

## Lecture 23 - Exploring Inheritance

- Foundation Knowledge:
  * Type Inheritance
    - Clonable Interface
    - Runnable Interface
  * Making Enhancements to the Library Class
  * Improving Design
    - Designing a Hierarchy
    - Invoking Constructors
    - Distributing Responsibilities
    - Factoring Responsibilities across a hierarchy
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 9.4 - 9.6

## Lecture 24 - Exploring Inheritance

- Foundation Knowledge:
  * Consequences of Inheritance
    - Exception Handling
    - Adding New Functionality to a Hierarchy
  * Multiple Inheritance
    - Resolving Conflicts
    - Repeated Inheritance
    - Multiple Inheritance in Java
  * Discussion
    - Design Patterns facilitating Inheritance
    - Performance of OO Systems
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 9.7 - 9.9

---

# Week 9

---

## Lecture 25 - FSMs

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 26 - FSMs

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 27 - FSMs

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

---

# Week 10

---

## Lecture 28 - Interactive Systems

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 29 - Interactive Systems

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 30 - Interactive Systems

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

---

# Week 11

---

## Lecture 31 - Unit Testing

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 32 - Integration Testing

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 33 - Selecting Tests

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

---

# Week 12

---

## Lecture 34 - Defensive Programming

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 35 - Defensive Programming

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 36 - Defensive Programming

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

---

# Week 13

---

## Lecture 37 - Secure Programming

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 38 - Secure Programming

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 39 - Secure Programming

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

---

# Week 14

---

## Lecture 40 - Distributed Programming

- Foundation Knowledge:
  * Client/Server Systems
  * Java RMI
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources: Chapter 12.1 - 12.2

## Lecture 41 - Distributed Programming

- Foundation Knowledge:
  * OO Systems on the Web
  * Service Oriented Architecture
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources 12.3

## Lecture 42 - Distributed Programming

- Foundation Knowledge:
  - RESTful Services
  - Microservice Architectures
  - Using Javalin to implement
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:
- Resources:

---

# Week 15

---

## Lecture 43 - Static Analysis

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 44 - Quality

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

## Lecture 45 - PSP

- Topics:
- Foundation Knowledge:
- Examples:
- Quick Exploration:
- Homework:
- Quiz Questions:
- Projects:

---
